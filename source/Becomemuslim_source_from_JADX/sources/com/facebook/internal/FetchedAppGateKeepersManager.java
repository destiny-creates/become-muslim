package com.facebook.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class FetchedAppGateKeepersManager {
    private static final String APPLICATION_DEVICE_ID = "device_id";
    private static final String APPLICATION_FIELDS = "fields";
    private static final long APPLICATION_GATEKEEPER_CACHE_TIMEOUT = 3600000;
    private static final String APPLICATION_GATEKEEPER_EDGE = "mobile_sdk_gk";
    private static final String APPLICATION_GATEKEEPER_FIELD = "gatekeepers";
    private static final String APPLICATION_GRAPH_DATA = "data";
    private static final String APPLICATION_PLATFORM = "platform";
    private static final String APPLICATION_SDK_VERSION = "sdk_version";
    public static final String APP_EVENTS_IF_AUTO_LOG_SUBS = "app_events_if_auto_log_subs";
    private static final String APP_GATEKEEPERS_PREFS_KEY_FORMAT = "com.facebook.internal.APP_GATEKEEPERS.%s";
    private static final String APP_GATEKEEPERS_PREFS_STORE = "com.facebook.internal.preferences.APP_GATEKEEPERS";
    private static final String APP_PLATFORM = "android";
    private static final String TAG = FetchedAppGateKeepersManager.class.getCanonicalName();
    private static final Map<String, JSONObject> fetchedAppGateKeepers = new ConcurrentHashMap();
    private static Long timestamp = null;

    public static synchronized void loadAppGateKeepersAsync() {
        synchronized (FetchedAppGateKeepersManager.class) {
            if (isTimestampValid(timestamp)) {
                return;
            }
            final Context applicationContext = FacebookSdk.getApplicationContext();
            final String applicationId = FacebookSdk.getApplicationId();
            final String format = String.format(APP_GATEKEEPERS_PREFS_KEY_FORMAT, new Object[]{applicationId});
            FacebookSdk.getExecutor().execute(new Runnable() {
                public void run() {
                    SharedPreferences sharedPreferences = applicationContext.getSharedPreferences(FetchedAppGateKeepersManager.APP_GATEKEEPERS_PREFS_STORE, 0);
                    JSONObject jSONObject = null;
                    String string = sharedPreferences.getString(format, null);
                    if (!Utility.isNullOrEmpty(string)) {
                        try {
                            jSONObject = new JSONObject(string);
                        } catch (Exception e) {
                            Utility.logd("FacebookSDK", e);
                        }
                        if (jSONObject != null) {
                            FetchedAppGateKeepersManager.parseAppGateKeepersFromJSON(applicationId, jSONObject);
                        }
                    }
                    JSONObject access$100 = FetchedAppGateKeepersManager.getAppGateKeepersQueryResponse(applicationId);
                    if (access$100 != null) {
                        FetchedAppGateKeepersManager.timestamp = Long.valueOf(System.currentTimeMillis());
                        FetchedAppGateKeepersManager.parseAppGateKeepersFromJSON(applicationId, access$100);
                        sharedPreferences.edit().putString(format, access$100.toString()).apply();
                    }
                }
            });
        }
    }

    public static JSONObject queryAppGateKeepers(String str, boolean z) {
        if (!z && fetchedAppGateKeepers.containsKey(str)) {
            return (JSONObject) fetchedAppGateKeepers.get(str);
        }
        z = getAppGateKeepersQueryResponse(str);
        if (!z) {
            return null;
        }
        Context applicationContext = FacebookSdk.getApplicationContext();
        applicationContext.getSharedPreferences(APP_GATEKEEPERS_PREFS_STORE, 0).edit().putString(String.format(APP_GATEKEEPERS_PREFS_KEY_FORMAT, new Object[]{str}), z.toString()).apply();
        return parseAppGateKeepersFromJSON(str, z);
    }

    public static boolean getGateKeeperForKey(String str, String str2, boolean z) {
        loadAppGateKeepersAsync();
        if (str2 != null) {
            if (fetchedAppGateKeepers.containsKey(str2)) {
                return ((JSONObject) fetchedAppGateKeepers.get(str2)).optBoolean(str, z);
            }
        }
        return z;
    }

    private static JSONObject getAppGateKeepersQueryResponse(String str) {
        Bundle bundle = new Bundle();
        AttributionIdentifiers cachedIdentifiers = AttributionIdentifiers.getCachedIdentifiers();
        String str2 = "";
        if (!(cachedIdentifiers == null || cachedIdentifiers.getAndroidAdvertiserId() == null)) {
            str2 = cachedIdentifiers.getAndroidAdvertiserId();
        }
        String sdkVersion = FacebookSdk.getSdkVersion();
        bundle.putString(APPLICATION_PLATFORM, "android");
        bundle.putString("device_id", str2);
        bundle.putString(APPLICATION_SDK_VERSION, sdkVersion);
        bundle.putString("fields", APPLICATION_GATEKEEPER_FIELD);
        str = GraphRequest.newGraphPathRequest(null, String.format("%s/%s", new Object[]{str, APPLICATION_GATEKEEPER_EDGE}), null);
        str.setSkipClientToken(true);
        str.setParameters(bundle);
        return str.executeAndWait().getJSONObject();
    }

    private static synchronized JSONObject parseAppGateKeepersFromJSON(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        synchronized (FetchedAppGateKeepersManager.class) {
            if (fetchedAppGateKeepers.containsKey(str)) {
                jSONObject2 = (JSONObject) fetchedAppGateKeepers.get(str);
            } else {
                jSONObject2 = new JSONObject();
            }
            jSONObject = jSONObject.optJSONArray("data");
            JSONObject jSONObject3 = null;
            int i = 0;
            if (jSONObject != null) {
                jSONObject3 = jSONObject.optJSONObject(0);
            }
            if (!(jSONObject3 == null || jSONObject3.optJSONArray(APPLICATION_GATEKEEPER_FIELD) == null)) {
                jSONObject = jSONObject3.optJSONArray(APPLICATION_GATEKEEPER_FIELD);
                while (i < jSONObject.length()) {
                    try {
                        jSONObject3 = jSONObject.getJSONObject(i);
                        jSONObject2.put(jSONObject3.getString("key"), jSONObject3.getBoolean("value"));
                    } catch (Exception e) {
                        Utility.logd("FacebookSDK", e);
                    }
                    i++;
                }
            }
            fetchedAppGateKeepers.put(str, jSONObject2);
        }
        return jSONObject2;
    }

    private static boolean isTimestampValid(Long l) {
        boolean z = false;
        if (l == null) {
            return false;
        }
        if (System.currentTimeMillis() - l.longValue() < APPLICATION_GATEKEEPER_CACHE_TIMEOUT) {
            z = true;
        }
        return z;
    }
}
