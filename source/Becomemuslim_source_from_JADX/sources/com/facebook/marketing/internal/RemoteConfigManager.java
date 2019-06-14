package com.facebook.marketing.internal;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.amplitude.api.AmplitudeClient;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.internal.AttributionIdentifiers;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class RemoteConfigManager {
    private static final String SAMPLING_ENDPOINT_PATH = "%s/button_auto_detection_device_selection";
    private static final String SAMPLING_RESULT_FIELD = "is_selected";
    private static final String TAG = RemoteConfigManager.class.getCanonicalName();
    private static final Map<String, RemoteConfig> remoteConfigs = new ConcurrentHashMap();

    /* renamed from: com.facebook.marketing.internal.RemoteConfigManager$1 */
    static class C18481 implements Runnable {
        C18481() {
        }

        public void run() {
            Context applicationContext = FacebookSdk.getApplicationContext();
            String applicationId = FacebookSdk.getApplicationId();
            AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(applicationContext);
            if (attributionIdentifiers != null && attributionIdentifiers.getAndroidAdvertiserId() != null) {
                JSONObject access$000 = RemoteConfigManager.getRemoteConfigQueryResponse(applicationId, attributionIdentifiers.getAndroidAdvertiserId());
                if (access$000 != null) {
                    RemoteConfigManager.parseRemoteConfigFromJSON(applicationId, access$000);
                }
            }
        }
    }

    public static void loadRemoteConfig() {
        FacebookSdk.getExecutor().execute(new C18481());
    }

    public static RemoteConfig getRemoteConfigWithoutQuery(String str) {
        return str != null ? (RemoteConfig) remoteConfigs.get(str) : null;
    }

    private static JSONObject getRemoteConfigQueryResponse(String str, String str2) {
        try {
            String format = String.format(Locale.US, SAMPLING_ENDPOINT_PATH, new Object[]{str});
            Bundle bundle = new Bundle();
            bundle.putString(AmplitudeClient.DEVICE_ID_KEY, str2);
            bundle.putString(GraphRequest.FIELDS_PARAM, SAMPLING_RESULT_FIELD);
            String graphRequest = new GraphRequest(null, format, bundle, HttpMethod.GET, null);
            graphRequest.setSkipClientToken(true);
            return graphRequest.executeAndWait().getJSONObject();
        } catch (String str3) {
            Log.e(TAG, "fail to request button sampling api", str3);
            return new JSONObject();
        }
    }

    private static void parseRemoteConfigFromJSON(String str, JSONObject jSONObject) {
        jSONObject = jSONObject.optJSONArray("data");
        if (jSONObject != null && jSONObject.length() > 0) {
            jSONObject = jSONObject.optJSONObject(0);
            if (jSONObject != null) {
                remoteConfigs.put(str, new RemoteConfig(jSONObject.optBoolean(SAMPLING_RESULT_FIELD, false)));
            }
        }
    }
}
