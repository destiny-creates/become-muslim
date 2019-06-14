package com.amplitude.api;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Pair;
import com.amplitude.p063a.C0968a;
import com.facebook.GraphResponse;
import com.facebook.appevents.UserDataStore;
import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.ServerProtocol;
import com.facebook.places.model.PlaceFields;
import com.facebook.stetho.common.Utf8Charset;
import com.raizlabs.android.dbflow.config.C5679e;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AmplitudeClient {
    public static final String DEVICE_ID_KEY = "device_id";
    public static final String END_SESSION_EVENT = "session_end";
    public static final String LAST_EVENT_ID_KEY = "last_event_id";
    public static final String LAST_EVENT_TIME_KEY = "last_event_time";
    public static final String LAST_IDENTIFY_ID_KEY = "last_identify_id";
    public static final String OPT_OUT_KEY = "opt_out";
    public static final String PREVIOUS_SESSION_ID_KEY = "previous_session_id";
    public static final String SEQUENCE_NUMBER_KEY = "sequence_number";
    public static final String START_SESSION_EVENT = "session_start";
    public static final String TAG = "com.amplitude.api.AmplitudeClient";
    public static final String USER_ID_KEY = "user_id";
    private static final AmplitudeLog logger = AmplitudeLog.getLogger();
    protected String apiKey;
    private boolean backoffUpload;
    private int backoffUploadBatchSize;
    protected Context context;
    protected DatabaseHelper dbHelper;
    protected String deviceId;
    private DeviceInfo deviceInfo;
    private int eventMaxCount;
    private int eventUploadMaxBatchSize;
    private long eventUploadPeriodMillis;
    private int eventUploadThreshold;
    private boolean flushEventsOnClose;
    protected OkHttpClient httpClient;
    WorkerThread httpThread;
    private boolean inForeground;
    protected boolean initialized;
    protected String instanceName;
    Throwable lastError;
    long lastEventId;
    long lastEventTime;
    long lastIdentifyId;
    WorkerThread logThread;
    private long minTimeBetweenSessionsMillis;
    private boolean newDeviceIdPerInstall;
    private boolean offline;
    private boolean optOut;
    long previousSessionId;
    long sequenceNumber;
    long sessionId;
    private long sessionTimeoutMillis;
    private boolean trackingSessionEvents;
    private AtomicBoolean updateScheduled;
    AtomicBoolean uploadingCurrently;
    String url;
    private boolean useAdvertisingIdForDeviceId;
    protected String userId;
    private boolean usingForegroundTracking;

    /* renamed from: com.amplitude.api.AmplitudeClient$2 */
    class C09712 implements Runnable {
        C09712() {
        }

        public void run() {
            if (AmplitudeClient.this.deviceInfo != null) {
                AmplitudeClient.this.deviceInfo.setLocationListening(true);
                return;
            }
            throw new IllegalStateException("Must initialize before acting on location listening.");
        }
    }

    /* renamed from: com.amplitude.api.AmplitudeClient$3 */
    class C09723 implements Runnable {
        C09723() {
        }

        public void run() {
            if (AmplitudeClient.this.deviceInfo != null) {
                AmplitudeClient.this.deviceInfo.setLocationListening(false);
                return;
            }
            throw new IllegalStateException("Must initialize before acting on location listening.");
        }
    }

    public AmplitudeClient() {
        this(null);
    }

    public AmplitudeClient(String str) {
        this.newDeviceIdPerInstall = false;
        this.useAdvertisingIdForDeviceId = false;
        this.initialized = false;
        this.optOut = false;
        this.offline = false;
        this.sessionId = -1;
        this.sequenceNumber = 0;
        this.lastEventId = -1;
        this.lastIdentifyId = -1;
        this.lastEventTime = -1;
        this.previousSessionId = -1;
        this.eventUploadThreshold = 30;
        this.eventUploadMaxBatchSize = 100;
        this.eventMaxCount = 1000;
        this.eventUploadPeriodMillis = Constants.EVENT_UPLOAD_PERIOD_MILLIS;
        this.minTimeBetweenSessionsMillis = Constants.MIN_TIME_BETWEEN_SESSIONS_MILLIS;
        this.sessionTimeoutMillis = Constants.SESSION_TIMEOUT_MILLIS;
        this.backoffUpload = false;
        this.backoffUploadBatchSize = this.eventUploadMaxBatchSize;
        this.usingForegroundTracking = false;
        this.trackingSessionEvents = false;
        this.inForeground = false;
        this.flushEventsOnClose = true;
        this.updateScheduled = new AtomicBoolean(false);
        this.uploadingCurrently = new AtomicBoolean(false);
        this.url = Constants.EVENT_LOG_URL;
        this.logThread = new WorkerThread("logThread");
        this.httpThread = new WorkerThread("httpThread");
        this.instanceName = Utils.normalizeInstanceName(str);
        this.logThread.start();
        this.httpThread.start();
    }

    public AmplitudeClient initialize(Context context, String str) {
        return initialize(context, str, null);
    }

    public synchronized AmplitudeClient initialize(final Context context, String str, final String str2) {
        if (context == null) {
            logger.m3415e(TAG, "Argument context cannot be null in initialize()");
            return this;
        } else if (TextUtils.isEmpty(str)) {
            logger.m3415e(TAG, "Argument apiKey cannot be null or blank in initialize()");
            return this;
        } else {
            this.context = context.getApplicationContext();
            this.apiKey = str;
            this.dbHelper = DatabaseHelper.getDatabaseHelper(this.context, this.instanceName);
            runOnLogThread(new Runnable() {
                public void run() {
                    if (!AmplitudeClient.this.initialized) {
                        try {
                            if (AmplitudeClient.this.instanceName.equals(Constants.DEFAULT_INSTANCE)) {
                                AmplitudeClient.upgradePrefs(context);
                                AmplitudeClient.upgradeSharedPrefsToDB(context);
                            }
                            AmplitudeClient.this.httpClient = new OkHttpClient();
                            AmplitudeClient.this.initializeDeviceInfo();
                            if (str2 != null) {
                                this.userId = str2;
                                AmplitudeClient.this.dbHelper.insertOrReplaceKeyValue("user_id", str2);
                            } else {
                                this.userId = AmplitudeClient.this.dbHelper.getValue("user_id");
                            }
                            Long longValue = AmplitudeClient.this.dbHelper.getLongValue(AmplitudeClient.OPT_OUT_KEY);
                            AmplitudeClient amplitudeClient = AmplitudeClient.this;
                            boolean z = longValue != null && longValue.longValue() == 1;
                            amplitudeClient.optOut = z;
                            AmplitudeClient.this.previousSessionId = AmplitudeClient.this.getLongvalue(AmplitudeClient.PREVIOUS_SESSION_ID_KEY, -1);
                            if (AmplitudeClient.this.previousSessionId >= 0) {
                                AmplitudeClient.this.sessionId = AmplitudeClient.this.previousSessionId;
                            }
                            AmplitudeClient.this.sequenceNumber = AmplitudeClient.this.getLongvalue(AmplitudeClient.SEQUENCE_NUMBER_KEY, 0);
                            AmplitudeClient.this.lastEventId = AmplitudeClient.this.getLongvalue(AmplitudeClient.LAST_EVENT_ID_KEY, -1);
                            AmplitudeClient.this.lastIdentifyId = AmplitudeClient.this.getLongvalue(AmplitudeClient.LAST_IDENTIFY_ID_KEY, -1);
                            AmplitudeClient.this.lastEventTime = AmplitudeClient.this.getLongvalue(AmplitudeClient.LAST_EVENT_TIME_KEY, -1);
                            AmplitudeClient.this.initialized = true;
                        } catch (CursorWindowAllocationException e) {
                            AmplitudeClient.logger.m3415e(AmplitudeClient.TAG, String.format("Failed to initialize Amplitude SDK due to: %s", new Object[]{e.getMessage()}));
                            this.apiKey = null;
                        }
                    }
                }
            });
            return this;
        }
    }

    public AmplitudeClient enableForegroundTracking(Application application) {
        if (!this.usingForegroundTracking) {
            if (contextAndApiKeySet("enableForegroundTracking()")) {
                if (VERSION.SDK_INT >= 14) {
                    application.registerActivityLifecycleCallbacks(new AmplitudeCallbacks(this));
                }
                return this;
            }
        }
        return this;
    }

    private void initializeDeviceInfo() {
        this.deviceInfo = new DeviceInfo(this.context);
        this.deviceId = initializeDeviceId();
        this.deviceInfo.prefetch();
    }

    public AmplitudeClient enableNewDeviceIdPerInstall(boolean z) {
        this.newDeviceIdPerInstall = z;
        return this;
    }

    public AmplitudeClient useAdvertisingIdForDeviceId() {
        this.useAdvertisingIdForDeviceId = true;
        return this;
    }

    public AmplitudeClient enableLocationListening() {
        runOnLogThread(new C09712());
        return this;
    }

    public AmplitudeClient disableLocationListening() {
        runOnLogThread(new C09723());
        return this;
    }

    public AmplitudeClient setEventUploadThreshold(int i) {
        this.eventUploadThreshold = i;
        return this;
    }

    public AmplitudeClient setEventUploadMaxBatchSize(int i) {
        this.eventUploadMaxBatchSize = i;
        this.backoffUploadBatchSize = i;
        return this;
    }

    public AmplitudeClient setEventMaxCount(int i) {
        this.eventMaxCount = i;
        return this;
    }

    public AmplitudeClient setEventUploadPeriodMillis(int i) {
        this.eventUploadPeriodMillis = (long) i;
        return this;
    }

    public AmplitudeClient setMinTimeBetweenSessionsMillis(long j) {
        this.minTimeBetweenSessionsMillis = j;
        return this;
    }

    public AmplitudeClient setSessionTimeoutMillis(long j) {
        this.sessionTimeoutMillis = j;
        return this;
    }

    public AmplitudeClient setOptOut(final boolean z) {
        if (!contextAndApiKeySet("setOptOut()")) {
            return this;
        }
        runOnLogThread(new Runnable() {
            public void run() {
                if (!TextUtils.isEmpty(AmplitudeClient.this.apiKey)) {
                    this.optOut = z;
                    AmplitudeClient.this.dbHelper.insertOrReplaceKeyLongValue(AmplitudeClient.OPT_OUT_KEY, Long.valueOf(z ? 1 : 0));
                }
            }
        });
        return this;
    }

    public boolean isOptedOut() {
        return this.optOut;
    }

    public AmplitudeClient enableLogging(boolean z) {
        logger.setEnableLogging(z);
        return this;
    }

    public AmplitudeClient setLogLevel(int i) {
        logger.setLogLevel(i);
        return this;
    }

    public AmplitudeClient setOffline(boolean z) {
        this.offline = z;
        if (!z) {
            uploadEvents();
        }
        return this;
    }

    public AmplitudeClient setFlushEventsOnClose(boolean z) {
        this.flushEventsOnClose = z;
        return this;
    }

    public AmplitudeClient trackSessionEvents(boolean z) {
        this.trackingSessionEvents = z;
        return this;
    }

    void useForegroundTracking() {
        this.usingForegroundTracking = true;
    }

    boolean isUsingForegroundTracking() {
        return this.usingForegroundTracking;
    }

    boolean isInForeground() {
        return this.inForeground;
    }

    public void logEvent(String str) {
        logEvent(str, null);
    }

    public void logEvent(String str, JSONObject jSONObject) {
        logEvent(str, jSONObject, false);
    }

    public void logEvent(String str, JSONObject jSONObject, boolean z) {
        logEvent(str, jSONObject, null, z);
    }

    public void logEvent(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        logEvent(str, jSONObject, jSONObject2, false);
    }

    public void logEvent(String str, JSONObject jSONObject, JSONObject jSONObject2, boolean z) {
        logEvent(str, jSONObject, jSONObject2, getCurrentTimeMillis(), z);
    }

    public void logEvent(String str, JSONObject jSONObject, JSONObject jSONObject2, long j, boolean z) {
        if (validateLogEvent(str)) {
            logEventAsync(str, jSONObject, null, null, jSONObject2, j, z);
        }
    }

    public void logEventSync(String str) {
        logEventSync(str, null);
    }

    public void logEventSync(String str, JSONObject jSONObject) {
        logEventSync(str, jSONObject, false);
    }

    public void logEventSync(String str, JSONObject jSONObject, boolean z) {
        logEventSync(str, jSONObject, null, z);
    }

    public void logEventSync(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        logEventSync(str, jSONObject, jSONObject2, false);
    }

    public void logEventSync(String str, JSONObject jSONObject, JSONObject jSONObject2, boolean z) {
        logEventSync(str, jSONObject, jSONObject2, getCurrentTimeMillis(), z);
    }

    public void logEventSync(String str, JSONObject jSONObject, JSONObject jSONObject2, long j, boolean z) {
        if (validateLogEvent(str)) {
            logEvent(str, jSONObject, null, null, jSONObject2, j, z);
        }
    }

    protected boolean validateLogEvent(String str) {
        if (TextUtils.isEmpty(str) == null) {
            return contextAndApiKeySet("logEvent()");
        }
        logger.m3415e(TAG, "Argument eventType cannot be null or blank in logEvent()");
        return null;
    }

    protected void logEventAsync(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, long j, boolean z) {
        final JSONObject cloneJSONObject = jSONObject != null ? Utils.cloneJSONObject(jSONObject) : jSONObject;
        final JSONObject cloneJSONObject2 = jSONObject3 != null ? Utils.cloneJSONObject(jSONObject3) : jSONObject3;
        final JSONObject cloneJSONObject3 = jSONObject4 != null ? Utils.cloneJSONObject(jSONObject4) : jSONObject4;
        final String str2 = str;
        final JSONObject jSONObject5 = jSONObject2;
        final long j2 = j;
        final boolean z2 = z;
        Runnable c09745 = new Runnable() {
            public void run() {
                if (!TextUtils.isEmpty(AmplitudeClient.this.apiKey)) {
                    AmplitudeClient.this.logEvent(str2, cloneJSONObject, jSONObject5, cloneJSONObject2, cloneJSONObject3, j2, z2);
                }
            }
        };
        AmplitudeClient amplitudeClient = this;
        runOnLogThread(c09745);
    }

    protected long logEvent(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, long j, boolean z) {
        AmplitudeLog amplitudeLog = logger;
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Logged event to Amplitude: ");
        stringBuilder.append(str);
        amplitudeLog.m3413d(str2, stringBuilder.toString());
        if (this.optOut) {
            return -1;
        }
        Object obj = (this.trackingSessionEvents && (str.equals(START_SESSION_EVENT) || str.equals(END_SESSION_EVENT))) ? 1 : null;
        if (obj == null && !z) {
            if (this.inForeground) {
                refreshSessionTime(j);
            } else {
                startNewSessionIfNeeded(j);
            }
        }
        JSONObject jSONObject5 = new JSONObject();
        try {
            long j2;
            jSONObject5.put("event_type", replaceWithJSONNull(str));
            jSONObject5.put("timestamp", j);
            jSONObject5.put("user_id", replaceWithJSONNull(this.userId));
            jSONObject5.put(DEVICE_ID_KEY, replaceWithJSONNull(this.deviceId));
            j = "session_id";
            if (z) {
                j2 = -1;
            } else {
                j2 = this.sessionId;
            }
            jSONObject5.put(j, j2);
            jSONObject5.put("version_name", replaceWithJSONNull(this.deviceInfo.getVersionName()));
            jSONObject5.put("os_name", replaceWithJSONNull(this.deviceInfo.getOsName()));
            jSONObject5.put("os_version", replaceWithJSONNull(this.deviceInfo.getOsVersion()));
            jSONObject5.put("device_brand", replaceWithJSONNull(this.deviceInfo.getBrand()));
            jSONObject5.put("device_manufacturer", replaceWithJSONNull(this.deviceInfo.getManufacturer()));
            jSONObject5.put("device_model", replaceWithJSONNull(this.deviceInfo.getModel()));
            jSONObject5.put("carrier", replaceWithJSONNull(this.deviceInfo.getCarrier()));
            jSONObject5.put(UserDataStore.COUNTRY, replaceWithJSONNull(this.deviceInfo.getCountry()));
            jSONObject5.put("language", replaceWithJSONNull(this.deviceInfo.getLanguage()));
            jSONObject5.put("platform", Constants.PLATFORM);
            jSONObject5.put("uuid", UUID.randomUUID().toString());
            jSONObject5.put(SEQUENCE_NUMBER_KEY, getNextSequenceNumber());
            j = new JSONObject();
            j.put("name", Constants.LIBRARY);
            j.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, Constants.VERSION);
            jSONObject5.put("library", j);
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            j = this.deviceInfo.getMostRecentLocation();
            if (j != null) {
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("lat", j.getLatitude());
                jSONObject6.put("lng", j.getLongitude());
                jSONObject2.put(PlaceFields.LOCATION, jSONObject6);
            }
            if (this.deviceInfo.getAdvertisingId() != null) {
                jSONObject2.put("androidADID", this.deviceInfo.getAdvertisingId());
            }
            jSONObject2.put("limit_ad_tracking", this.deviceInfo.isLimitAdTrackingEnabled());
            jSONObject2.put("gps_enabled", this.deviceInfo.isGooglePlayServicesEnabled());
            jSONObject5.put("api_properties", jSONObject2);
            jSONObject2 = "event_properties";
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = truncate(jSONObject);
            }
            jSONObject5.put(jSONObject2, jSONObject);
            jSONObject = "user_properties";
            if (jSONObject3 == null) {
                jSONObject2 = new JSONObject();
            } else {
                jSONObject2 = truncate(jSONObject3);
            }
            jSONObject5.put(jSONObject, jSONObject2);
            jSONObject5.put("groups", jSONObject4 == null ? new JSONObject() : truncate(jSONObject4));
            jSONObject = saveEvent(str, jSONObject5);
        } catch (JSONObject jSONObject7) {
            logger.m3415e(TAG, String.format("JSON Serialization of event type %s failed, skipping: %s", new Object[]{str, jSONObject7.toString()}));
            jSONObject7 = -1;
        }
        return jSONObject7;
    }

    protected long saveEvent(String str, JSONObject jSONObject) {
        jSONObject = jSONObject.toString();
        if (TextUtils.isEmpty(jSONObject)) {
            logger.m3415e(TAG, String.format("Detected empty event string for event type %s, skipping", new Object[]{str}));
            return -1;
        }
        if (str.equals(Constants.IDENTIFY_EVENT)) {
            this.lastIdentifyId = this.dbHelper.addIdentify(jSONObject);
            setLastIdentifyId(this.lastIdentifyId);
        } else {
            this.lastEventId = this.dbHelper.addEvent(jSONObject);
            setLastEventId(this.lastEventId);
        }
        jSONObject = Math.min(Math.max(1, this.eventMaxCount / 10), 20);
        if (this.dbHelper.getEventCount() > ((long) this.eventMaxCount)) {
            this.dbHelper.removeEvents(this.dbHelper.getNthEventId((long) jSONObject));
        }
        if (this.dbHelper.getIdentifyCount() > ((long) this.eventMaxCount)) {
            this.dbHelper.removeIdentifys(this.dbHelper.getNthIdentifyId((long) jSONObject));
        }
        long totalEventCount = this.dbHelper.getTotalEventCount();
        if (totalEventCount % ((long) this.eventUploadThreshold) != 0 || totalEventCount < ((long) this.eventUploadThreshold)) {
            updateServerLater(this.eventUploadPeriodMillis);
        } else {
            updateServer();
        }
        return str.equals(Constants.IDENTIFY_EVENT) != null ? this.lastIdentifyId : this.lastEventId;
    }

    private long getLongvalue(String str, long j) {
        str = this.dbHelper.getLongValue(str);
        return str == null ? j : str.longValue();
    }

    long getNextSequenceNumber() {
        this.sequenceNumber++;
        this.dbHelper.insertOrReplaceKeyLongValue(SEQUENCE_NUMBER_KEY, Long.valueOf(this.sequenceNumber));
        return this.sequenceNumber;
    }

    void setLastEventTime(long j) {
        this.lastEventTime = j;
        this.dbHelper.insertOrReplaceKeyLongValue(LAST_EVENT_TIME_KEY, Long.valueOf(j));
    }

    void setLastEventId(long j) {
        this.lastEventId = j;
        this.dbHelper.insertOrReplaceKeyLongValue(LAST_EVENT_ID_KEY, Long.valueOf(j));
    }

    void setLastIdentifyId(long j) {
        this.lastIdentifyId = j;
        this.dbHelper.insertOrReplaceKeyLongValue(LAST_IDENTIFY_ID_KEY, Long.valueOf(j));
    }

    public long getSessionId() {
        return this.sessionId;
    }

    void setPreviousSessionId(long j) {
        this.previousSessionId = j;
        this.dbHelper.insertOrReplaceKeyLongValue(PREVIOUS_SESSION_ID_KEY, Long.valueOf(j));
    }

    boolean startNewSessionIfNeeded(long j) {
        if (inSession()) {
            if (isWithinMinTimeBetweenSessions(j)) {
                refreshSessionTime(j);
                return false;
            }
            startNewSession(j);
            return true;
        } else if (!isWithinMinTimeBetweenSessions(j)) {
            startNewSession(j);
            return true;
        } else if (this.previousSessionId == -1) {
            startNewSession(j);
            return true;
        } else {
            setSessionId(this.previousSessionId);
            refreshSessionTime(j);
            return false;
        }
    }

    private void startNewSession(long j) {
        if (this.trackingSessionEvents) {
            sendSessionEvent(END_SESSION_EVENT);
        }
        setSessionId(j);
        refreshSessionTime(j);
        if (this.trackingSessionEvents != null) {
            sendSessionEvent(START_SESSION_EVENT);
        }
    }

    private boolean inSession() {
        return this.sessionId >= 0;
    }

    private boolean isWithinMinTimeBetweenSessions(long j) {
        return j - this.lastEventTime < (this.usingForegroundTracking ? this.minTimeBetweenSessionsMillis : this.sessionTimeoutMillis) ? 1 : 0;
    }

    private void setSessionId(long j) {
        this.sessionId = j;
        setPreviousSessionId(j);
    }

    void refreshSessionTime(long j) {
        if (inSession()) {
            setLastEventTime(j);
        }
    }

    private void sendSessionEvent(java.lang.String r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r10 = this;
        r0 = "sendSessionEvent('%s')";
        r1 = 1;
        r1 = new java.lang.Object[r1];
        r2 = 0;
        r1[r2] = r11;
        r0 = java.lang.String.format(r0, r1);
        r0 = r10.contextAndApiKeySet(r0);
        if (r0 != 0) goto L_0x0013;
    L_0x0012:
        return;
    L_0x0013:
        r0 = r10.inSession();
        if (r0 != 0) goto L_0x001a;
    L_0x0019:
        return;
    L_0x001a:
        r4 = new org.json.JSONObject;
        r4.<init>();
        r0 = "special";	 Catch:{ JSONException -> 0x0030 }
        r4.put(r0, r11);	 Catch:{ JSONException -> 0x0030 }
        r3 = 0;
        r5 = 0;
        r6 = 0;
        r7 = r10.lastEventTime;
        r9 = 0;
        r1 = r10;
        r2 = r11;
        r1.logEvent(r2, r3, r4, r5, r6, r7, r9);
        return;
    L_0x0030:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplitude.api.AmplitudeClient.sendSessionEvent(java.lang.String):void");
    }

    void onExitForeground(final long j) {
        runOnLogThread(new Runnable() {
            public void run() {
                if (!TextUtils.isEmpty(AmplitudeClient.this.apiKey)) {
                    AmplitudeClient.this.refreshSessionTime(j);
                    AmplitudeClient.this.inForeground = false;
                    if (AmplitudeClient.this.flushEventsOnClose) {
                        AmplitudeClient.this.updateServer();
                    }
                }
            }
        });
    }

    void onEnterForeground(final long j) {
        runOnLogThread(new Runnable() {
            public void run() {
                if (!TextUtils.isEmpty(AmplitudeClient.this.apiKey)) {
                    AmplitudeClient.this.startNewSessionIfNeeded(j);
                    AmplitudeClient.this.inForeground = true;
                }
            }
        });
    }

    public void logRevenue(double d) {
        logRevenue(null, 1, d);
    }

    public void logRevenue(String str, int i, double d) {
        logRevenue(str, i, d, null, null);
    }

    public void logRevenue(java.lang.String r12, int r13, double r14, java.lang.String r16, java.lang.String r17) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r11 = this;
        r0 = "logRevenue()";
        r10 = r11;
        r0 = r11.contextAndApiKeySet(r0);
        if (r0 != 0) goto L_0x000a;
    L_0x0009:
        return;
    L_0x000a:
        r4 = new org.json.JSONObject;
        r4.<init>();
        r0 = "special";	 Catch:{ JSONException -> 0x0036 }
        r1 = "revenue_amount";	 Catch:{ JSONException -> 0x0036 }
        r4.put(r0, r1);	 Catch:{ JSONException -> 0x0036 }
        r0 = "productId";	 Catch:{ JSONException -> 0x0036 }
        r1 = r12;	 Catch:{ JSONException -> 0x0036 }
        r4.put(r0, r12);	 Catch:{ JSONException -> 0x0036 }
        r0 = "quantity";	 Catch:{ JSONException -> 0x0036 }
        r1 = r13;	 Catch:{ JSONException -> 0x0036 }
        r4.put(r0, r13);	 Catch:{ JSONException -> 0x0036 }
        r0 = "price";	 Catch:{ JSONException -> 0x0036 }
        r1 = r14;	 Catch:{ JSONException -> 0x0036 }
        r4.put(r0, r14);	 Catch:{ JSONException -> 0x0036 }
        r0 = "receipt";	 Catch:{ JSONException -> 0x0036 }
        r1 = r16;	 Catch:{ JSONException -> 0x0036 }
        r4.put(r0, r1);	 Catch:{ JSONException -> 0x0036 }
        r0 = "receiptSig";	 Catch:{ JSONException -> 0x0036 }
        r1 = r17;	 Catch:{ JSONException -> 0x0036 }
        r4.put(r0, r1);	 Catch:{ JSONException -> 0x0036 }
    L_0x0036:
        r2 = "revenue_amount";
        r3 = 0;
        r5 = 0;
        r6 = 0;
        r7 = r11.getCurrentTimeMillis();
        r9 = 0;
        r1 = r11;
        r1.logEventAsync(r2, r3, r4, r5, r6, r7, r9);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplitude.api.AmplitudeClient.logRevenue(java.lang.String, int, double, java.lang.String, java.lang.String):void");
    }

    public void logRevenueV2(Revenue revenue) {
        if (contextAndApiKeySet("logRevenueV2()") && revenue != null) {
            if (revenue.isValidRevenue()) {
                logEvent(Constants.AMP_REVENUE_EVENT, revenue.toJSONObject());
            }
        }
    }

    public void setUserProperties(JSONObject jSONObject, boolean z) {
        setUserProperties(jSONObject);
    }

    public void setUserProperties(JSONObject jSONObject) {
        if (!(jSONObject == null || jSONObject.length() == 0)) {
            if (contextAndApiKeySet("setUserProperties")) {
                jSONObject = truncate(jSONObject);
                if (jSONObject.length() != 0) {
                    Identify identify = new Identify();
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String str = (String) keys.next();
                        try {
                            identify.setUserProperty(str, jSONObject.get(str));
                        } catch (JSONException e) {
                            logger.m3415e(TAG, e.toString());
                        }
                    }
                    identify(identify);
                }
            }
        }
    }

    public void clearUserProperties() {
        identify(new Identify().clearAll());
    }

    public void identify(Identify identify) {
        identify(identify, false);
    }

    public void identify(Identify identify, boolean z) {
        if (!(identify == null || identify.userPropertiesOperations.length() == 0)) {
            if (contextAndApiKeySet("identify()")) {
                logEventAsync(Constants.IDENTIFY_EVENT, null, null, identify.userPropertiesOperations, null, getCurrentTimeMillis(), z);
            }
        }
    }

    public void setGroup(String str, Object obj) {
        if (contextAndApiKeySet("setGroup()")) {
            if (!TextUtils.isEmpty(str)) {
                JSONObject put;
                try {
                    put = new JSONObject().put(str, obj);
                } catch (JSONException e) {
                    logger.m3415e(TAG, e.toString());
                    put = null;
                }
                logEventAsync(Constants.IDENTIFY_EVENT, null, null, new Identify().setUserProperty(str, obj).userPropertiesOperations, put, getCurrentTimeMillis(), false);
            }
        }
    }

    public JSONObject truncate(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        if (jSONObject.length() > 1000) {
            logger.m3421w(TAG, "Warning: too many properties (more than 1000), ignoring");
            return new JSONObject();
        }
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            try {
                Object obj = jSONObject.get(str);
                if (!str.equals(Constants.AMP_REVENUE_RECEIPT)) {
                    if (!str.equals(Constants.AMP_REVENUE_RECEIPT_SIG)) {
                        if (obj.getClass().equals(String.class)) {
                            jSONObject.put(str, truncate((String) obj));
                        } else if (obj.getClass().equals(JSONObject.class)) {
                            jSONObject.put(str, truncate((JSONObject) obj));
                        } else if (obj.getClass().equals(JSONArray.class)) {
                            jSONObject.put(str, truncate((JSONArray) obj));
                        }
                    }
                }
                jSONObject.put(str, obj);
            } catch (JSONException e) {
                logger.m3415e(TAG, e.toString());
            }
        }
        return jSONObject;
    }

    public JSONArray truncate(JSONArray jSONArray) {
        if (jSONArray == null) {
            return new JSONArray();
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if (obj.getClass().equals(String.class)) {
                jSONArray.put(i, truncate((String) obj));
            } else if (obj.getClass().equals(JSONObject.class)) {
                jSONArray.put(i, truncate((JSONObject) obj));
            } else if (obj.getClass().equals(JSONArray.class)) {
                jSONArray.put(i, truncate((JSONArray) obj));
            }
        }
        return jSONArray;
    }

    public String truncate(String str) {
        return str.length() <= 1024 ? str : str.substring(0, 1024);
    }

    public String getUserId() {
        return this.userId;
    }

    public AmplitudeClient setUserId(final String str) {
        if (!contextAndApiKeySet("setUserId()")) {
            return this;
        }
        runOnLogThread(new Runnable() {
            public void run() {
                if (!TextUtils.isEmpty(this.apiKey)) {
                    this.userId = str;
                    AmplitudeClient.this.dbHelper.insertOrReplaceKeyValue("user_id", str);
                }
            }
        });
        return this;
    }

    public AmplitudeClient setDeviceId(final String str) {
        Set invalidDeviceIds = getInvalidDeviceIds();
        if (contextAndApiKeySet("setDeviceId()") && !TextUtils.isEmpty(str)) {
            if (!invalidDeviceIds.contains(str)) {
                runOnLogThread(new Runnable() {
                    public void run() {
                        if (!TextUtils.isEmpty(this.apiKey)) {
                            this.deviceId = str;
                            AmplitudeClient.this.dbHelper.insertOrReplaceKeyValue(AmplitudeClient.DEVICE_ID_KEY, str);
                        }
                    }
                });
                return this;
            }
        }
        return this;
    }

    public AmplitudeClient regenerateDeviceId() {
        if (!contextAndApiKeySet("regenerateDeviceId()")) {
            return this;
        }
        runOnLogThread(new Runnable() {
            public void run() {
                if (!TextUtils.isEmpty(this.apiKey)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(DeviceInfo.generateUUID());
                    stringBuilder.append("R");
                    AmplitudeClient.this.setDeviceId(stringBuilder.toString());
                }
            }
        });
        return this;
    }

    public void uploadEvents() {
        if (contextAndApiKeySet("uploadEvents()")) {
            this.logThread.post(new Runnable() {
                public void run() {
                    if (!TextUtils.isEmpty(AmplitudeClient.this.apiKey)) {
                        AmplitudeClient.this.updateServer();
                    }
                }
            });
        }
    }

    private void updateServerLater(long j) {
        if (!this.updateScheduled.getAndSet(true)) {
            this.logThread.postDelayed(new Runnable() {
                public void run() {
                    AmplitudeClient.this.updateScheduled.set(false);
                    AmplitudeClient.this.updateServer();
                }
            }, j);
        }
    }

    protected void updateServer() {
        updateServer(false);
    }

    protected void updateServer(boolean z) {
        if (!this.optOut) {
            if (!this.offline) {
                if (!this.uploadingCurrently.getAndSet(true)) {
                    long min = Math.min((long) (z ? this.backoffUploadBatchSize : this.eventUploadMaxBatchSize), this.dbHelper.getTotalEventCount());
                    if (min <= 0) {
                        this.uploadingCurrently.set(false);
                        return;
                    }
                    try {
                        Pair mergeEventsAndIdentifys = mergeEventsAndIdentifys(this.dbHelper.getEvents(this.lastEventId, min), this.dbHelper.getIdentifys(this.lastIdentifyId, min), min);
                        if (((JSONArray) mergeEventsAndIdentifys.second).length() == 0) {
                            this.uploadingCurrently.set(false);
                            return;
                        }
                        final long longValue = ((Long) ((Pair) mergeEventsAndIdentifys.first).first).longValue();
                        final long longValue2 = ((Long) ((Pair) mergeEventsAndIdentifys.first).second).longValue();
                        final String jSONArray = ((JSONArray) mergeEventsAndIdentifys.second).toString();
                        this.httpThread.post(new Runnable() {
                            public void run() {
                                AmplitudeClient.this.makeEventUploadPostRequest(AmplitudeClient.this.httpClient, jSONArray, longValue, longValue2);
                            }
                        });
                    } catch (JSONException e) {
                        this.uploadingCurrently.set(false);
                        logger.m3415e(TAG, e.toString());
                    } catch (CursorWindowAllocationException e2) {
                        this.uploadingCurrently.set(false);
                        logger.m3415e(TAG, String.format("Caught Cursor window exception during event upload, deferring upload: %s", new Object[]{e2.getMessage()}));
                    }
                }
            }
        }
    }

    protected Pair<Pair<Long, Long>, JSONArray> mergeEventsAndIdentifys(List<JSONObject> list, List<JSONObject> list2, long j) {
        JSONArray jSONArray = new JSONArray();
        long j2 = -1;
        long j3 = -1;
        while (((long) jSONArray.length()) < j) {
            boolean isEmpty = list.isEmpty();
            boolean isEmpty2 = list2.isEmpty();
            if (isEmpty && isEmpty2) {
                logger.m3421w(TAG, String.format("mergeEventsAndIdentifys: number of events and identifys less than expected by %d", new Object[]{Long.valueOf(j - ((long) jSONArray.length()))}));
                break;
            }
            long j4;
            JSONObject jSONObject;
            if (isEmpty2) {
                jSONObject = (JSONObject) list.remove(0);
                j4 = jSONObject.getLong("event_id");
                jSONArray.put(jSONObject);
            } else {
                long j5;
                JSONObject jSONObject2;
                if (isEmpty) {
                    jSONObject2 = (JSONObject) list2.remove(0);
                    j5 = jSONObject2.getLong("event_id");
                    jSONArray.put(jSONObject2);
                } else {
                    if (((JSONObject) list.get(0)).has(SEQUENCE_NUMBER_KEY)) {
                        if (((JSONObject) list.get(0)).getLong(SEQUENCE_NUMBER_KEY) >= ((JSONObject) list2.get(0)).getLong(SEQUENCE_NUMBER_KEY)) {
                            jSONObject2 = (JSONObject) list2.remove(0);
                            j5 = jSONObject2.getLong("event_id");
                            jSONArray.put(jSONObject2);
                        }
                    }
                    jSONObject = (JSONObject) list.remove(0);
                    j4 = jSONObject.getLong("event_id");
                    jSONArray.put(jSONObject);
                }
                j3 = j5;
            }
            j2 = j4;
        }
        return new Pair(new Pair(Long.valueOf(j2), Long.valueOf(j3)), jSONArray);
    }

    protected void makeEventUploadPostRequest(OkHttpClient okHttpClient, String str, long j, long j2) {
        String str2 = "2";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(getCurrentTimeMillis());
        String stringBuilder2 = stringBuilder.toString();
        String str3 = "";
        try {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(str2);
            stringBuilder3.append(this.apiKey);
            stringBuilder3.append(str);
            stringBuilder3.append(stringBuilder2);
            str3 = bytesToHexString(new C0968a().digest(stringBuilder3.toString().getBytes(Utf8Charset.NAME)));
        } catch (UnsupportedEncodingException e) {
            logger.m3415e(TAG, e.toString());
        }
        try {
            str = new Builder().url(this.url).post(new FormBody.Builder().add("v", str2).add("client", this.apiKey).add(C5679e.f18978a, str).add("upload_time", stringBuilder2).add("checksum", str3).build()).build();
            boolean z = true;
            try {
                okHttpClient = okHttpClient.newCall(str).execute();
                str = okHttpClient.body().string();
                if (str.equals(GraphResponse.SUCCESS_KEY)) {
                    try {
                        final long j3 = j;
                        final long j4 = j2;
                        this.logThread.post(new Runnable() {

                            /* renamed from: com.amplitude.api.AmplitudeClient$14$1 */
                            class C09691 implements Runnable {
                                C09691() {
                                }

                                public void run() {
                                    AmplitudeClient.this.updateServer(AmplitudeClient.this.backoffUpload);
                                }
                            }

                            public void run() {
                                if (j3 >= 0) {
                                    AmplitudeClient.this.dbHelper.removeEvents(j3);
                                }
                                if (j4 >= 0) {
                                    AmplitudeClient.this.dbHelper.removeIdentifys(j4);
                                }
                                AmplitudeClient.this.uploadingCurrently.set(false);
                                if (AmplitudeClient.this.dbHelper.getTotalEventCount() > ((long) AmplitudeClient.this.eventUploadThreshold)) {
                                    AmplitudeClient.this.logThread.post(new C09691());
                                    return;
                                }
                                AmplitudeClient.this.backoffUpload = false;
                                AmplitudeClient.this.backoffUploadBatchSize = AmplitudeClient.this.eventUploadMaxBatchSize;
                            }
                        });
                    } catch (ConnectException e2) {
                        okHttpClient = e2;
                        this.lastError = okHttpClient;
                        if (!z) {
                            this.uploadingCurrently.set(false);
                        }
                    } catch (UnknownHostException e3) {
                        okHttpClient = e3;
                        this.lastError = okHttpClient;
                        if (z) {
                            this.uploadingCurrently.set(false);
                        }
                    } catch (IOException e4) {
                        okHttpClient = e4;
                        logger.m3415e(TAG, okHttpClient.toString());
                        this.lastError = okHttpClient;
                        if (z) {
                            this.uploadingCurrently.set(false);
                        }
                    } catch (AssertionError e5) {
                        okHttpClient = e5;
                        logger.m3416e(TAG, "Exception:", okHttpClient);
                        this.lastError = okHttpClient;
                        if (z) {
                            this.uploadingCurrently.set(false);
                        }
                    } catch (Exception e6) {
                        okHttpClient = e6;
                        logger.m3416e(TAG, "Exception:", okHttpClient);
                        this.lastError = okHttpClient;
                        if (z) {
                            this.uploadingCurrently.set(false);
                        }
                    }
                }
                if (str.equals("invalid_api_key")) {
                    logger.m3415e(TAG, "Invalid API key, make sure your API key is correct in initialize()");
                } else if (str.equals("bad_checksum")) {
                    logger.m3421w(TAG, "Bad checksum, post request was mangled in transit, will attempt to reupload later");
                } else if (str.equals("request_db_write_failed")) {
                    logger.m3421w(TAG, "Couldn't write to request database on server, will attempt to reupload later");
                } else if (okHttpClient.code() == 413) {
                    if (this.backoffUpload != null && this.backoffUploadBatchSize == 1) {
                        if (j >= 0) {
                            this.dbHelper.removeEvent(j);
                        }
                        if (j2 >= 0) {
                            this.dbHelper.removeIdentify(j2);
                        }
                    }
                    this.backoffUpload = true;
                    this.backoffUploadBatchSize = (int) Math.ceil(((double) Math.min((int) this.dbHelper.getEventCount(), this.backoffUploadBatchSize)) / 4611686018427387904L);
                    logger.m3421w(TAG, "Request too large, will decrease size and attempt to reupload");
                    this.logThread.post(new Runnable() {
                        public void run() {
                            AmplitudeClient.this.uploadingCurrently.set(false);
                            AmplitudeClient.this.updateServer(true);
                        }
                    });
                } else {
                    okHttpClient = logger;
                    String str4 = TAG;
                    StringBuilder stringBuilder4 = new StringBuilder();
                    stringBuilder4.append("Upload failed, ");
                    stringBuilder4.append(str);
                    stringBuilder4.append(", will attempt to reupload later");
                    okHttpClient.m3421w(str4, stringBuilder4.toString());
                }
                z = false;
            } catch (ConnectException e7) {
                okHttpClient = e7;
                z = false;
                this.lastError = okHttpClient;
                if (z) {
                    this.uploadingCurrently.set(false);
                }
            } catch (UnknownHostException e8) {
                okHttpClient = e8;
                z = false;
                this.lastError = okHttpClient;
                if (z) {
                    this.uploadingCurrently.set(false);
                }
            } catch (IOException e9) {
                okHttpClient = e9;
                z = false;
                logger.m3415e(TAG, okHttpClient.toString());
                this.lastError = okHttpClient;
                if (z) {
                    this.uploadingCurrently.set(false);
                }
            } catch (AssertionError e10) {
                okHttpClient = e10;
                z = false;
                logger.m3416e(TAG, "Exception:", okHttpClient);
                this.lastError = okHttpClient;
                if (z) {
                    this.uploadingCurrently.set(false);
                }
            } catch (Exception e11) {
                okHttpClient = e11;
                z = false;
                logger.m3416e(TAG, "Exception:", okHttpClient);
                this.lastError = okHttpClient;
                if (z) {
                    this.uploadingCurrently.set(false);
                }
            }
            if (z) {
                this.uploadingCurrently.set(false);
            }
        } catch (OkHttpClient okHttpClient2) {
            logger.m3415e(TAG, okHttpClient2.toString());
            this.uploadingCurrently.set(false);
        }
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    private Set<String> getInvalidDeviceIds() {
        Set<String> hashSet = new HashSet();
        hashSet.add("");
        hashSet.add("9774d56d682e549c");
        hashSet.add("unknown");
        hashSet.add("000000000000000");
        hashSet.add(Constants.PLATFORM);
        hashSet.add("DEFACE");
        hashSet.add("00000000-0000-0000-0000-000000000000");
        return hashSet;
    }

    private String initializeDeviceId() {
        Set invalidDeviceIds = getInvalidDeviceIds();
        Object value = this.dbHelper.getValue(DEVICE_ID_KEY);
        if (!TextUtils.isEmpty(value) && !invalidDeviceIds.contains(value)) {
            return value;
        }
        if (!this.newDeviceIdPerInstall && this.useAdvertisingIdForDeviceId) {
            String advertisingId = this.deviceInfo.getAdvertisingId();
            if (!(TextUtils.isEmpty(advertisingId) || invalidDeviceIds.contains(advertisingId))) {
                this.dbHelper.insertOrReplaceKeyValue(DEVICE_ID_KEY, advertisingId);
                return advertisingId;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        DeviceInfo deviceInfo = this.deviceInfo;
        stringBuilder.append(DeviceInfo.generateUUID());
        stringBuilder.append("R");
        String stringBuilder2 = stringBuilder.toString();
        this.dbHelper.insertOrReplaceKeyValue(DEVICE_ID_KEY, stringBuilder2);
        return stringBuilder2;
    }

    protected void runOnLogThread(Runnable runnable) {
        if (Thread.currentThread() != this.logThread) {
            this.logThread.post(runnable);
        } else {
            runnable.run();
        }
    }

    protected Object replaceWithJSONNull(Object obj) {
        return obj == null ? JSONObject.NULL : obj;
    }

    protected synchronized boolean contextAndApiKeySet(String str) {
        AmplitudeLog amplitudeLog;
        String str2;
        StringBuilder stringBuilder;
        if (this.context == null) {
            amplitudeLog = logger;
            str2 = TAG;
            stringBuilder = new StringBuilder();
            stringBuilder.append("context cannot be null, set context with initialize() before calling ");
            stringBuilder.append(str);
            amplitudeLog.m3415e(str2, stringBuilder.toString());
            return false;
        } else if (!TextUtils.isEmpty(this.apiKey)) {
            return true;
        } else {
            amplitudeLog = logger;
            str2 = TAG;
            stringBuilder = new StringBuilder();
            stringBuilder.append("apiKey cannot be null or empty, set apiKey with initialize() before calling ");
            stringBuilder.append(str);
            amplitudeLog.m3415e(str2, stringBuilder.toString());
            return false;
        }
    }

    protected String bytesToHexString(byte[] bArr) {
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & JfifUtil.MARKER_FIRST_BYTE;
            int i3 = i * 2;
            cArr2[i3] = cArr[i2 >>> 4];
            cArr2[i3 + 1] = cArr[i2 & 15];
        }
        return new String(cArr2);
    }

    static boolean upgradePrefs(Context context) {
        return upgradePrefs(context, null, null);
    }

    static boolean upgradePrefs(android.content.Context r7, java.lang.String r8, java.lang.String r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = 0;
        if (r8 != 0) goto L_0x0016;
    L_0x0003:
        r8 = "com.amplitude.api";	 Catch:{ Exception -> 0x0013 }
        r1 = com.amplitude.api.Constants.class;	 Catch:{ Exception -> 0x0011 }
        r1 = r1.getPackage();	 Catch:{ Exception -> 0x0011 }
        r1 = r1.getName();	 Catch:{ Exception -> 0x0011 }
        r8 = r1;
        goto L_0x0016;
        goto L_0x0016;
    L_0x0013:
        r7 = move-exception;
        goto L_0x015f;
    L_0x0016:
        if (r9 != 0) goto L_0x001a;
    L_0x0018:
        r9 = "com.amplitude.api";	 Catch:{ Exception -> 0x0013 }
    L_0x001a:
        r1 = r9.equals(r8);	 Catch:{ Exception -> 0x0013 }
        if (r1 == 0) goto L_0x0021;	 Catch:{ Exception -> 0x0013 }
    L_0x0020:
        return r0;	 Catch:{ Exception -> 0x0013 }
    L_0x0021:
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0013 }
        r1.<init>();	 Catch:{ Exception -> 0x0013 }
        r1.append(r8);	 Catch:{ Exception -> 0x0013 }
        r2 = ".";	 Catch:{ Exception -> 0x0013 }
        r1.append(r2);	 Catch:{ Exception -> 0x0013 }
        r2 = r7.getPackageName();	 Catch:{ Exception -> 0x0013 }
        r1.append(r2);	 Catch:{ Exception -> 0x0013 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0013 }
        r2 = r7.getSharedPreferences(r1, r0);	 Catch:{ Exception -> 0x0013 }
        r3 = r2.getAll();	 Catch:{ Exception -> 0x0013 }
        r3 = r3.size();	 Catch:{ Exception -> 0x0013 }
        if (r3 != 0) goto L_0x0048;	 Catch:{ Exception -> 0x0013 }
    L_0x0047:
        return r0;	 Catch:{ Exception -> 0x0013 }
    L_0x0048:
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0013 }
        r3.<init>();	 Catch:{ Exception -> 0x0013 }
        r3.append(r9);	 Catch:{ Exception -> 0x0013 }
        r9 = ".";	 Catch:{ Exception -> 0x0013 }
        r3.append(r9);	 Catch:{ Exception -> 0x0013 }
        r9 = r7.getPackageName();	 Catch:{ Exception -> 0x0013 }
        r3.append(r9);	 Catch:{ Exception -> 0x0013 }
        r9 = r3.toString();	 Catch:{ Exception -> 0x0013 }
        r7 = r7.getSharedPreferences(r9, r0);	 Catch:{ Exception -> 0x0013 }
        r7 = r7.edit();	 Catch:{ Exception -> 0x0013 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0013 }
        r3.<init>();	 Catch:{ Exception -> 0x0013 }
        r3.append(r8);	 Catch:{ Exception -> 0x0013 }
        r4 = ".previousSessionId";	 Catch:{ Exception -> 0x0013 }
        r3.append(r4);	 Catch:{ Exception -> 0x0013 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0013 }
        r3 = r2.contains(r3);	 Catch:{ Exception -> 0x0013 }
        if (r3 == 0) goto L_0x009b;	 Catch:{ Exception -> 0x0013 }
    L_0x007f:
        r3 = "com.amplitude.api.previousSessionId";	 Catch:{ Exception -> 0x0013 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0013 }
        r4.<init>();	 Catch:{ Exception -> 0x0013 }
        r4.append(r8);	 Catch:{ Exception -> 0x0013 }
        r5 = ".previousSessionId";	 Catch:{ Exception -> 0x0013 }
        r4.append(r5);	 Catch:{ Exception -> 0x0013 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0013 }
        r5 = -1;	 Catch:{ Exception -> 0x0013 }
        r4 = r2.getLong(r4, r5);	 Catch:{ Exception -> 0x0013 }
        r7.putLong(r3, r4);	 Catch:{ Exception -> 0x0013 }
    L_0x009b:
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0013 }
        r3.<init>();	 Catch:{ Exception -> 0x0013 }
        r3.append(r8);	 Catch:{ Exception -> 0x0013 }
        r4 = ".deviceId";	 Catch:{ Exception -> 0x0013 }
        r3.append(r4);	 Catch:{ Exception -> 0x0013 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0013 }
        r3 = r2.contains(r3);	 Catch:{ Exception -> 0x0013 }
        r4 = 0;	 Catch:{ Exception -> 0x0013 }
        if (r3 == 0) goto L_0x00cd;	 Catch:{ Exception -> 0x0013 }
    L_0x00b3:
        r3 = "com.amplitude.api.deviceId";	 Catch:{ Exception -> 0x0013 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0013 }
        r5.<init>();	 Catch:{ Exception -> 0x0013 }
        r5.append(r8);	 Catch:{ Exception -> 0x0013 }
        r6 = ".deviceId";	 Catch:{ Exception -> 0x0013 }
        r5.append(r6);	 Catch:{ Exception -> 0x0013 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x0013 }
        r5 = r2.getString(r5, r4);	 Catch:{ Exception -> 0x0013 }
        r7.putString(r3, r5);	 Catch:{ Exception -> 0x0013 }
    L_0x00cd:
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0013 }
        r3.<init>();	 Catch:{ Exception -> 0x0013 }
        r3.append(r8);	 Catch:{ Exception -> 0x0013 }
        r5 = ".userId";	 Catch:{ Exception -> 0x0013 }
        r3.append(r5);	 Catch:{ Exception -> 0x0013 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0013 }
        r3 = r2.contains(r3);	 Catch:{ Exception -> 0x0013 }
        if (r3 == 0) goto L_0x00fe;	 Catch:{ Exception -> 0x0013 }
    L_0x00e4:
        r3 = "com.amplitude.api.userId";	 Catch:{ Exception -> 0x0013 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0013 }
        r5.<init>();	 Catch:{ Exception -> 0x0013 }
        r5.append(r8);	 Catch:{ Exception -> 0x0013 }
        r6 = ".userId";	 Catch:{ Exception -> 0x0013 }
        r5.append(r6);	 Catch:{ Exception -> 0x0013 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x0013 }
        r4 = r2.getString(r5, r4);	 Catch:{ Exception -> 0x0013 }
        r7.putString(r3, r4);	 Catch:{ Exception -> 0x0013 }
    L_0x00fe:
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0013 }
        r3.<init>();	 Catch:{ Exception -> 0x0013 }
        r3.append(r8);	 Catch:{ Exception -> 0x0013 }
        r4 = ".optOut";	 Catch:{ Exception -> 0x0013 }
        r3.append(r4);	 Catch:{ Exception -> 0x0013 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0013 }
        r3 = r2.contains(r3);	 Catch:{ Exception -> 0x0013 }
        if (r3 == 0) goto L_0x012f;	 Catch:{ Exception -> 0x0013 }
    L_0x0115:
        r3 = "com.amplitude.api.optOut";	 Catch:{ Exception -> 0x0013 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0013 }
        r4.<init>();	 Catch:{ Exception -> 0x0013 }
        r4.append(r8);	 Catch:{ Exception -> 0x0013 }
        r8 = ".optOut";	 Catch:{ Exception -> 0x0013 }
        r4.append(r8);	 Catch:{ Exception -> 0x0013 }
        r8 = r4.toString();	 Catch:{ Exception -> 0x0013 }
        r8 = r2.getBoolean(r8, r0);	 Catch:{ Exception -> 0x0013 }
        r7.putBoolean(r3, r8);	 Catch:{ Exception -> 0x0013 }
    L_0x012f:
        r7.apply();	 Catch:{ Exception -> 0x0013 }
        r7 = r2.edit();	 Catch:{ Exception -> 0x0013 }
        r7 = r7.clear();	 Catch:{ Exception -> 0x0013 }
        r7.apply();	 Catch:{ Exception -> 0x0013 }
        r7 = logger;	 Catch:{ Exception -> 0x0013 }
        r8 = "com.amplitude.api.AmplitudeClient";	 Catch:{ Exception -> 0x0013 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0013 }
        r2.<init>();	 Catch:{ Exception -> 0x0013 }
        r3 = "Upgraded shared preferences from ";	 Catch:{ Exception -> 0x0013 }
        r2.append(r3);	 Catch:{ Exception -> 0x0013 }
        r2.append(r1);	 Catch:{ Exception -> 0x0013 }
        r1 = " to ";	 Catch:{ Exception -> 0x0013 }
        r2.append(r1);	 Catch:{ Exception -> 0x0013 }
        r2.append(r9);	 Catch:{ Exception -> 0x0013 }
        r9 = r2.toString();	 Catch:{ Exception -> 0x0013 }
        r7.m3417i(r8, r9);	 Catch:{ Exception -> 0x0013 }
        r7 = 1;
        return r7;
    L_0x015f:
        r8 = logger;
        r9 = "com.amplitude.api.AmplitudeClient";
        r1 = "Error upgrading shared preferences";
        r8.m3416e(r9, r1, r7);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplitude.api.AmplitudeClient.upgradePrefs(android.content.Context, java.lang.String, java.lang.String):boolean");
    }

    static boolean upgradeSharedPrefsToDB(Context context) {
        return upgradeSharedPrefsToDB(context, null);
    }

    static boolean upgradeSharedPrefsToDB(Context context, String str) {
        if (str == null) {
            str = "com.amplitude.api";
        }
        DatabaseHelper databaseHelper = DatabaseHelper.getDatabaseHelper(context);
        CharSequence value = databaseHelper.getValue(DEVICE_ID_KEY);
        Long longValue = databaseHelper.getLongValue(PREVIOUS_SESSION_ID_KEY);
        Long longValue2 = databaseHelper.getLongValue(LAST_EVENT_TIME_KEY);
        if (!TextUtils.isEmpty(value) && longValue != null && longValue2 != null) {
            return true;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(".");
        stringBuilder.append(context.getPackageName());
        context = context.getSharedPreferences(stringBuilder.toString(), 0);
        migrateStringValue(context, Constants.PREFKEY_DEVICE_ID, null, databaseHelper, DEVICE_ID_KEY);
        Context context2 = context;
        DatabaseHelper databaseHelper2 = databaseHelper;
        migrateLongValue(context2, Constants.PREFKEY_LAST_EVENT_TIME, -1, databaseHelper2, LAST_EVENT_TIME_KEY);
        migrateLongValue(context2, Constants.PREFKEY_LAST_EVENT_ID, -1, databaseHelper2, LAST_EVENT_ID_KEY);
        migrateLongValue(context2, Constants.PREFKEY_LAST_IDENTIFY_ID, -1, databaseHelper2, LAST_IDENTIFY_ID_KEY);
        migrateLongValue(context2, Constants.PREFKEY_PREVIOUS_SESSION_ID, -1, databaseHelper2, PREVIOUS_SESSION_ID_KEY);
        migrateStringValue(context, Constants.PREFKEY_USER_ID, null, databaseHelper, "user_id");
        migrateBooleanValue(context, Constants.PREFKEY_OPT_OUT, false, databaseHelper, OPT_OUT_KEY);
        return true;
    }

    private static void migrateLongValue(SharedPreferences sharedPreferences, String str, long j, DatabaseHelper databaseHelper, String str2) {
        if (databaseHelper.getLongValue(str2) == null) {
            databaseHelper.insertOrReplaceKeyLongValue(str2, Long.valueOf(sharedPreferences.getLong(str, j)));
            sharedPreferences.edit().remove(str).apply();
        }
    }

    private static void migrateStringValue(SharedPreferences sharedPreferences, String str, String str2, DatabaseHelper databaseHelper, String str3) {
        if (TextUtils.isEmpty(databaseHelper.getValue(str3))) {
            str2 = sharedPreferences.getString(str, str2);
            if (!TextUtils.isEmpty(str2)) {
                databaseHelper.insertOrReplaceKeyValue(str3, str2);
                sharedPreferences.edit().remove(str).apply();
            }
        }
    }

    private static void migrateBooleanValue(SharedPreferences sharedPreferences, String str, boolean z, DatabaseHelper databaseHelper, String str2) {
        if (databaseHelper.getLongValue(str2) == null) {
            databaseHelper.insertOrReplaceKeyLongValue(str2, Long.valueOf(sharedPreferences.getBoolean(str, z) ? 1 : 0));
            sharedPreferences.edit().remove(str).apply();
        }
    }

    protected long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }
}
