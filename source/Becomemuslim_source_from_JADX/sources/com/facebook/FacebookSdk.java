package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.internal.AppEventsLoggerUtility;
import com.facebook.appevents.internal.AppEventsLoggerUtility.GraphAPIActivityType;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.LockOnGetVariable;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class FacebookSdk {
    public static final String ADVERTISER_ID_COLLECTION_ENABLED_PROPERTY = "com.facebook.sdk.AdvertiserIDCollectionEnabled";
    public static final String APPLICATION_ID_PROPERTY = "com.facebook.sdk.ApplicationId";
    public static final String APPLICATION_NAME_PROPERTY = "com.facebook.sdk.ApplicationName";
    private static final String ATTRIBUTION_PREFERENCES = "com.facebook.sdk.attributionTracking";
    public static final String AUTO_LOG_APP_EVENTS_ENABLED_PROPERTY = "com.facebook.sdk.AutoLogAppEventsEnabled";
    static final String CALLBACK_OFFSET_CHANGED_AFTER_INIT = "The callback request code offset can't be updated once the SDK is initialized. Call FacebookSdk.setCallbackRequestCodeOffset inside your Application.onCreate method";
    static final String CALLBACK_OFFSET_NEGATIVE = "The callback request code offset can't be negative.";
    public static final String CALLBACK_OFFSET_PROPERTY = "com.facebook.sdk.CallbackOffset";
    public static final String CLIENT_TOKEN_PROPERTY = "com.facebook.sdk.ClientToken";
    public static final String CODELESS_DEBUG_LOG_ENABLED_PROPERTY = "com.facebook.sdk.CodelessDebugLogEnabled";
    private static final int DEFAULT_CALLBACK_REQUEST_CODE_OFFSET = 64206;
    private static final int DEFAULT_CORE_POOL_SIZE = 5;
    private static final int DEFAULT_KEEP_ALIVE = 1;
    private static final int DEFAULT_MAXIMUM_POOL_SIZE = 128;
    private static final ThreadFactory DEFAULT_THREAD_FACTORY = new C12631();
    private static final BlockingQueue<Runnable> DEFAULT_WORK_QUEUE = new LinkedBlockingQueue(10);
    private static final String FACEBOOK_COM = "facebook.com";
    private static final Object LOCK = new Object();
    private static final int MAX_REQUEST_CODE_RANGE = 100;
    private static final String PUBLISH_ACTIVITY_PATH = "%s/activities";
    private static final String TAG = FacebookSdk.class.getCanonicalName();
    public static final String WEB_DIALOG_THEME = "com.facebook.sdk.WebDialogTheme";
    private static volatile Boolean advertiserIDCollectionEnabled;
    private static volatile String appClientToken;
    private static Context applicationContext;
    private static volatile String applicationId;
    private static volatile String applicationName;
    private static volatile Boolean autoLogAppEventsEnabled;
    private static LockOnGetVariable<File> cacheDir;
    private static int callbackRequestCodeOffset = DEFAULT_CALLBACK_REQUEST_CODE_OFFSET;
    private static volatile Boolean codelessDebugLogEnabled;
    private static Executor executor;
    private static volatile String facebookDomain = FACEBOOK_COM;
    private static String graphApiVersion = ServerProtocol.getDefaultAPIVersion();
    private static volatile boolean isDebugEnabled = false;
    private static boolean isLegacyTokenUpgradeSupported = false;
    private static final HashSet<LoggingBehavior> loggingBehaviors = new HashSet(Arrays.asList(new LoggingBehavior[]{LoggingBehavior.DEVELOPER_ERRORS}));
    private static AtomicLong onProgressThreshold = new AtomicLong(65536);
    private static Boolean sdkInitialized = Boolean.valueOf(false);

    /* renamed from: com.facebook.FacebookSdk$1 */
    static class C12631 implements ThreadFactory {
        private final AtomicInteger counter = new AtomicInteger(0);

        C12631() {
        }

        public Thread newThread(Runnable runnable) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("FacebookSdk #");
            stringBuilder.append(this.counter.incrementAndGet());
            return new Thread(runnable, stringBuilder.toString());
        }
    }

    /* renamed from: com.facebook.FacebookSdk$2 */
    static class C12642 implements Callable<File> {
        C12642() {
        }

        public File call() {
            return FacebookSdk.applicationContext.getCacheDir();
        }
    }

    public interface InitializeCallback {
        void onInitialized();
    }

    public static String getSdkVersion() {
        return FacebookSdkVersion.BUILD;
    }

    @Deprecated
    public static synchronized void sdkInitialize(Context context, int i) {
        synchronized (FacebookSdk.class) {
            sdkInitialize(context, i, null);
        }
    }

    @Deprecated
    public static synchronized void sdkInitialize(Context context, int i, InitializeCallback initializeCallback) {
        synchronized (FacebookSdk.class) {
            if (sdkInitialized.booleanValue()) {
                if (i != callbackRequestCodeOffset) {
                    throw new FacebookException(CALLBACK_OFFSET_CHANGED_AFTER_INIT);
                }
            }
            if (i >= 0) {
                callbackRequestCodeOffset = i;
                sdkInitialize(context, initializeCallback);
            } else {
                throw new FacebookException(CALLBACK_OFFSET_NEGATIVE);
            }
        }
    }

    @Deprecated
    public static synchronized void sdkInitialize(Context context) {
        synchronized (FacebookSdk.class) {
            sdkInitialize(context, null);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @java.lang.Deprecated
    public static synchronized void sdkInitialize(final android.content.Context r3, final com.facebook.FacebookSdk.InitializeCallback r4) {
        /*
        r0 = com.facebook.FacebookSdk.class;
        monitor-enter(r0);
        r1 = sdkInitialized;	 Catch:{ all -> 0x0081 }
        r1 = r1.booleanValue();	 Catch:{ all -> 0x0081 }
        if (r1 == 0) goto L_0x0012;
    L_0x000b:
        if (r4 == 0) goto L_0x0010;
    L_0x000d:
        r4.onInitialized();	 Catch:{ all -> 0x0081 }
    L_0x0010:
        monitor-exit(r0);
        return;
    L_0x0012:
        r1 = "applicationContext";
        com.facebook.internal.Validate.notNull(r3, r1);	 Catch:{ all -> 0x0081 }
        r1 = 0;
        com.facebook.internal.Validate.hasFacebookActivity(r3, r1);	 Catch:{ all -> 0x0081 }
        com.facebook.internal.Validate.hasInternetPermissions(r3, r1);	 Catch:{ all -> 0x0081 }
        r1 = r3.getApplicationContext();	 Catch:{ all -> 0x0081 }
        applicationContext = r1;	 Catch:{ all -> 0x0081 }
        r1 = applicationContext;	 Catch:{ all -> 0x0081 }
        loadDefaultsFromMetadata(r1);	 Catch:{ all -> 0x0081 }
        r1 = applicationId;	 Catch:{ all -> 0x0081 }
        r1 = com.facebook.internal.Utility.isNullOrEmpty(r1);	 Catch:{ all -> 0x0081 }
        if (r1 != 0) goto L_0x0079;
    L_0x0031:
        r1 = applicationContext;	 Catch:{ all -> 0x0081 }
        r1 = r1 instanceof android.app.Application;	 Catch:{ all -> 0x0081 }
        if (r1 == 0) goto L_0x0048;
    L_0x0037:
        r1 = autoLogAppEventsEnabled;	 Catch:{ all -> 0x0081 }
        r1 = r1.booleanValue();	 Catch:{ all -> 0x0081 }
        if (r1 == 0) goto L_0x0048;
    L_0x003f:
        r1 = applicationContext;	 Catch:{ all -> 0x0081 }
        r1 = (android.app.Application) r1;	 Catch:{ all -> 0x0081 }
        r2 = applicationId;	 Catch:{ all -> 0x0081 }
        com.facebook.appevents.internal.ActivityLifecycleTracker.startTracking(r1, r2);	 Catch:{ all -> 0x0081 }
    L_0x0048:
        r1 = 1;
        r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ all -> 0x0081 }
        sdkInitialized = r1;	 Catch:{ all -> 0x0081 }
        com.facebook.internal.FetchedAppSettingsManager.loadAppSettingsAsync();	 Catch:{ all -> 0x0081 }
        com.facebook.internal.NativeProtocol.updateAllAvailableProtocolVersionsAsync();	 Catch:{ all -> 0x0081 }
        r1 = applicationContext;	 Catch:{ all -> 0x0081 }
        com.facebook.internal.BoltsMeasurementEventListener.getInstance(r1);	 Catch:{ all -> 0x0081 }
        r1 = new com.facebook.internal.LockOnGetVariable;	 Catch:{ all -> 0x0081 }
        r2 = new com.facebook.FacebookSdk$2;	 Catch:{ all -> 0x0081 }
        r2.<init>();	 Catch:{ all -> 0x0081 }
        r1.<init>(r2);	 Catch:{ all -> 0x0081 }
        cacheDir = r1;	 Catch:{ all -> 0x0081 }
        r1 = new java.util.concurrent.FutureTask;	 Catch:{ all -> 0x0081 }
        r2 = new com.facebook.FacebookSdk$3;	 Catch:{ all -> 0x0081 }
        r2.<init>(r4, r3);	 Catch:{ all -> 0x0081 }
        r1.<init>(r2);	 Catch:{ all -> 0x0081 }
        r3 = getExecutor();	 Catch:{ all -> 0x0081 }
        r3.execute(r1);	 Catch:{ all -> 0x0081 }
        monitor-exit(r0);
        return;
    L_0x0079:
        r3 = new com.facebook.FacebookException;	 Catch:{ all -> 0x0081 }
        r4 = "A valid Facebook app id must be set in the AndroidManifest.xml or set by calling FacebookSdk.setApplicationId before initializing the sdk.";
        r3.<init>(r4);	 Catch:{ all -> 0x0081 }
        throw r3;	 Catch:{ all -> 0x0081 }
    L_0x0081:
        r3 = move-exception;
        monitor-exit(r0);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.FacebookSdk.sdkInitialize(android.content.Context, com.facebook.FacebookSdk$InitializeCallback):void");
    }

    public static synchronized boolean isInitialized() {
        boolean booleanValue;
        synchronized (FacebookSdk.class) {
            booleanValue = sdkInitialized.booleanValue();
        }
        return booleanValue;
    }

    public static Set<LoggingBehavior> getLoggingBehaviors() {
        Set<LoggingBehavior> unmodifiableSet;
        synchronized (loggingBehaviors) {
            unmodifiableSet = Collections.unmodifiableSet(new HashSet(loggingBehaviors));
        }
        return unmodifiableSet;
    }

    public static void addLoggingBehavior(LoggingBehavior loggingBehavior) {
        synchronized (loggingBehaviors) {
            loggingBehaviors.add(loggingBehavior);
            updateGraphDebugBehavior();
        }
    }

    public static void removeLoggingBehavior(LoggingBehavior loggingBehavior) {
        synchronized (loggingBehaviors) {
            loggingBehaviors.remove(loggingBehavior);
        }
    }

    public static void clearLoggingBehaviors() {
        synchronized (loggingBehaviors) {
            loggingBehaviors.clear();
        }
    }

    public static boolean isLoggingBehaviorEnabled(LoggingBehavior loggingBehavior) {
        synchronized (loggingBehaviors) {
            loggingBehavior = (!isDebugEnabled() || loggingBehaviors.contains(loggingBehavior) == null) ? null : true;
        }
        return loggingBehavior;
    }

    public static boolean isDebugEnabled() {
        return isDebugEnabled;
    }

    public static void setIsDebugEnabled(boolean z) {
        isDebugEnabled = z;
    }

    public static boolean isLegacyTokenUpgradeSupported() {
        return isLegacyTokenUpgradeSupported;
    }

    private static void updateGraphDebugBehavior() {
        if (loggingBehaviors.contains(LoggingBehavior.GRAPH_API_DEBUG_INFO) && !loggingBehaviors.contains(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
            loggingBehaviors.add(LoggingBehavior.GRAPH_API_DEBUG_WARNING);
        }
    }

    public static void setLegacyTokenUpgradeSupported(boolean z) {
        isLegacyTokenUpgradeSupported = z;
    }

    public static Executor getExecutor() {
        synchronized (LOCK) {
            if (executor == null) {
                executor = AsyncTask.THREAD_POOL_EXECUTOR;
            }
        }
        return executor;
    }

    public static void setExecutor(Executor executor) {
        Validate.notNull(executor, "executor");
        synchronized (LOCK) {
            executor = executor;
        }
    }

    public static String getFacebookDomain() {
        return facebookDomain;
    }

    public static void setFacebookDomain(String str) {
        Log.w(TAG, "WARNING: Calling setFacebookDomain from non-DEBUG code.");
        facebookDomain = str;
    }

    public static Context getApplicationContext() {
        Validate.sdkInitialized();
        return applicationContext;
    }

    public static void setGraphApiVersion(String str) {
        Log.w(TAG, "WARNING: Calling setGraphApiVersion from non-DEBUG code.");
        if (!Utility.isNullOrEmpty(str) && !graphApiVersion.equals(str)) {
            graphApiVersion = str;
        }
    }

    public static String getGraphApiVersion() {
        Utility.logd(TAG, String.format("getGraphApiVersion: %s", new Object[]{graphApiVersion}));
        return graphApiVersion;
    }

    public static void publishInstallAsync(Context context, final String str) {
        context = context.getApplicationContext();
        getExecutor().execute(new Runnable() {
            public void run() {
                FacebookSdk.publishInstallAndWaitForResponse(context, str);
            }
        });
    }

    static void publishInstallAndWaitForResponse(Context context, String str) {
        if (context == null || str == null) {
            throw new IllegalArgumentException("Both context and applicationId must be non-null");
        }
        try {
            AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(context);
            SharedPreferences sharedPreferences = context.getSharedPreferences(ATTRIBUTION_PREFERENCES, 0);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("ping");
            String stringBuilder2 = stringBuilder.toString();
            long j = sharedPreferences.getLong(stringBuilder2, 0);
            context = AppEventsLoggerUtility.getJSONObjectForGraphAPICall(GraphAPIActivityType.MOBILE_INSTALL_EVENT, attributionIdentifiers, AppEventsLogger.getAnonymousAppDeviceGUID(context), getLimitEventAndDataUsage(context), context);
            context = GraphRequest.newPostRequest(null, String.format(PUBLISH_ACTIVITY_PATH, new Object[]{str}), context, null);
            if (j == 0) {
                context.executeAndWait();
                context = sharedPreferences.edit();
                context.putLong(stringBuilder2, System.currentTimeMillis());
                context.apply();
            }
        } catch (Throwable e) {
            throw new FacebookException("An error occurred while publishing install.", e);
        } catch (Exception e2) {
            Utility.logd("Facebook-publish", e2);
        }
    }

    public static boolean getLimitEventAndDataUsage(Context context) {
        Validate.sdkInitialized();
        return context.getSharedPreferences(AppEventsLogger.APP_EVENT_PREFERENCES, 0).getBoolean("limitEventUsage", false);
    }

    public static void setLimitEventAndDataUsage(Context context, boolean z) {
        context.getSharedPreferences(AppEventsLogger.APP_EVENT_PREFERENCES, 0).edit().putBoolean("limitEventUsage", z).apply();
    }

    public static long getOnProgressThreshold() {
        Validate.sdkInitialized();
        return onProgressThreshold.get();
    }

    public static void setOnProgressThreshold(long j) {
        onProgressThreshold.set(j);
    }

    static void loadDefaultsFromMetadata(android.content.Context r4) {
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
        if (r4 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0 = r4.getPackageManager();	 Catch:{ NameNotFoundException -> 0x00b8 }
        r4 = r4.getPackageName();	 Catch:{ NameNotFoundException -> 0x00b8 }
        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ NameNotFoundException -> 0x00b8 }
        r4 = r0.getApplicationInfo(r4, r1);	 Catch:{ NameNotFoundException -> 0x00b8 }
        if (r4 == 0) goto L_0x00b7;
    L_0x0013:
        r0 = r4.metaData;
        if (r0 != 0) goto L_0x0019;
    L_0x0017:
        goto L_0x00b7;
    L_0x0019:
        r0 = applicationId;
        if (r0 != 0) goto L_0x0051;
    L_0x001d:
        r0 = r4.metaData;
        r1 = "com.facebook.sdk.ApplicationId";
        r0 = r0.get(r1);
        r1 = r0 instanceof java.lang.String;
        if (r1 == 0) goto L_0x0044;
    L_0x0029:
        r0 = (java.lang.String) r0;
        r1 = java.util.Locale.ROOT;
        r1 = r0.toLowerCase(r1);
        r2 = "fb";
        r1 = r1.startsWith(r2);
        if (r1 == 0) goto L_0x0041;
    L_0x0039:
        r1 = 2;
        r0 = r0.substring(r1);
        applicationId = r0;
        goto L_0x0051;
    L_0x0041:
        applicationId = r0;
        goto L_0x0051;
    L_0x0044:
        r0 = r0 instanceof java.lang.Integer;
        if (r0 != 0) goto L_0x0049;
    L_0x0048:
        goto L_0x0051;
    L_0x0049:
        r4 = new com.facebook.FacebookException;
        r0 = "App Ids cannot be directly placed in the manifest.They must be prefixed by 'fb' or be placed in the string resource file.";
        r4.<init>(r0);
        throw r4;
    L_0x0051:
        r0 = applicationName;
        if (r0 != 0) goto L_0x005f;
    L_0x0055:
        r0 = r4.metaData;
        r1 = "com.facebook.sdk.ApplicationName";
        r0 = r0.getString(r1);
        applicationName = r0;
    L_0x005f:
        r0 = appClientToken;
        if (r0 != 0) goto L_0x006d;
    L_0x0063:
        r0 = r4.metaData;
        r1 = "com.facebook.sdk.ClientToken";
        r0 = r0.getString(r1);
        appClientToken = r0;
    L_0x006d:
        r0 = callbackRequestCodeOffset;
        r1 = 64206; // 0xface float:8.9972E-41 double:3.1722E-319;
        if (r0 != r1) goto L_0x007e;
    L_0x0074:
        r0 = r4.metaData;
        r2 = "com.facebook.sdk.CallbackOffset";
        r0 = r0.getInt(r2, r1);
        callbackRequestCodeOffset = r0;
    L_0x007e:
        r0 = autoLogAppEventsEnabled;
        r1 = 1;
        if (r0 != 0) goto L_0x0091;
    L_0x0083:
        r0 = r4.metaData;
        r2 = "com.facebook.sdk.AutoLogAppEventsEnabled";
        r0 = r0.getBoolean(r2, r1);
        r0 = java.lang.Boolean.valueOf(r0);
        autoLogAppEventsEnabled = r0;
    L_0x0091:
        r0 = codelessDebugLogEnabled;
        if (r0 != 0) goto L_0x00a4;
    L_0x0095:
        r0 = r4.metaData;
        r2 = "com.facebook.sdk.CodelessDebugLogEnabled";
        r3 = 0;
        r0 = r0.getBoolean(r2, r3);
        r0 = java.lang.Boolean.valueOf(r0);
        codelessDebugLogEnabled = r0;
    L_0x00a4:
        r0 = advertiserIDCollectionEnabled;
        if (r0 != 0) goto L_0x00b6;
    L_0x00a8:
        r4 = r4.metaData;
        r0 = "com.facebook.sdk.AdvertiserIDCollectionEnabled";
        r4 = r4.getBoolean(r0, r1);
        r4 = java.lang.Boolean.valueOf(r4);
        advertiserIDCollectionEnabled = r4;
    L_0x00b6:
        return;
    L_0x00b7:
        return;
    L_0x00b8:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.FacebookSdk.loadDefaultsFromMetadata(android.content.Context):void");
    }

    public static java.lang.String getApplicationSignature(android.content.Context r3) {
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
        com.facebook.internal.Validate.sdkInitialized();
        r0 = 0;
        if (r3 != 0) goto L_0x0007;
    L_0x0006:
        return r0;
    L_0x0007:
        r1 = r3.getPackageManager();
        if (r1 != 0) goto L_0x000e;
    L_0x000d:
        return r0;
    L_0x000e:
        r3 = r3.getPackageName();
        r2 = 64;
        r3 = r1.getPackageInfo(r3, r2);	 Catch:{ NameNotFoundException -> 0x003f }
        r1 = r3.signatures;
        if (r1 == 0) goto L_0x003e;
    L_0x001c:
        r1 = r1.length;
        if (r1 != 0) goto L_0x0020;
    L_0x001f:
        goto L_0x003e;
    L_0x0020:
        r1 = "SHA-1";	 Catch:{ NoSuchAlgorithmException -> 0x003d }
        r1 = java.security.MessageDigest.getInstance(r1);	 Catch:{ NoSuchAlgorithmException -> 0x003d }
        r3 = r3.signatures;
        r0 = 0;
        r3 = r3[r0];
        r3 = r3.toByteArray();
        r1.update(r3);
        r3 = r1.digest();
        r0 = 9;
        r3 = android.util.Base64.encodeToString(r3, r0);
        return r3;
    L_0x003d:
        return r0;
    L_0x003e:
        return r0;
    L_0x003f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.FacebookSdk.getApplicationSignature(android.content.Context):java.lang.String");
    }

    public static String getApplicationId() {
        Validate.sdkInitialized();
        return applicationId;
    }

    public static void setApplicationId(String str) {
        applicationId = str;
    }

    public static String getApplicationName() {
        Validate.sdkInitialized();
        return applicationName;
    }

    public static void setApplicationName(String str) {
        applicationName = str;
    }

    public static String getClientToken() {
        Validate.sdkInitialized();
        return appClientToken;
    }

    public static void setClientToken(String str) {
        appClientToken = str;
    }

    public static boolean getAutoLogAppEventsEnabled() {
        Validate.sdkInitialized();
        return autoLogAppEventsEnabled.booleanValue();
    }

    public static void setAutoLogAppEventsEnabled(boolean z) {
        autoLogAppEventsEnabled = Boolean.valueOf(z);
    }

    public static boolean getCodelessDebugLogEnabled() {
        Validate.sdkInitialized();
        return codelessDebugLogEnabled.booleanValue();
    }

    public static void setAdvertiserIDCollectionEnabled(boolean z) {
        advertiserIDCollectionEnabled = Boolean.valueOf(z);
    }

    public static boolean getAdvertiserIDCollectionEnabled() {
        Validate.sdkInitialized();
        return advertiserIDCollectionEnabled.booleanValue();
    }

    public static void setCodelessDebugLogEnabled(boolean z) {
        codelessDebugLogEnabled = Boolean.valueOf(z);
    }

    public static File getCacheDir() {
        Validate.sdkInitialized();
        return (File) cacheDir.getValue();
    }

    public static void setCacheDir(File file) {
        cacheDir = new LockOnGetVariable((Object) file);
    }

    public static int getCallbackRequestCodeOffset() {
        Validate.sdkInitialized();
        return callbackRequestCodeOffset;
    }

    public static boolean isFacebookRequestCode(int i) {
        return i >= callbackRequestCodeOffset && i < callbackRequestCodeOffset + 100;
    }
}
