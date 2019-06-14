package com.facebook.appevents.internal;

import android.content.Context;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class AppEventsLoggerUtility {
    private static final Map<GraphAPIActivityType, String> API_ACTIVITY_TYPE_TO_STRING = new C17171();

    /* renamed from: com.facebook.appevents.internal.AppEventsLoggerUtility$1 */
    static class C17171 extends HashMap<GraphAPIActivityType, String> {
        C17171() {
            put(GraphAPIActivityType.MOBILE_INSTALL_EVENT, "MOBILE_APP_INSTALL");
            put(GraphAPIActivityType.CUSTOM_APP_EVENTS, "CUSTOM_APP_EVENTS");
        }
    }

    public enum GraphAPIActivityType {
        MOBILE_INSTALL_EVENT,
        CUSTOM_APP_EVENTS
    }

    public static JSONObject getJSONObjectForGraphAPICall(GraphAPIActivityType graphAPIActivityType, AttributionIdentifiers attributionIdentifiers, String str, boolean z, Context context) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("event", API_ACTIVITY_TYPE_TO_STRING.get(graphAPIActivityType));
        graphAPIActivityType = AppEventsLogger.getUserID();
        if (graphAPIActivityType != null) {
            jSONObject.put("app_user_id", graphAPIActivityType);
        }
        graphAPIActivityType = AppEventsLogger.getUserData();
        if (graphAPIActivityType != null) {
            jSONObject.put("ud", graphAPIActivityType);
        }
        Utility.setAppEventAttributionParameters(jSONObject, attributionIdentifiers, str, z);
        try {
            Utility.setAppEventExtendedDeviceInfoParameters(jSONObject, context);
        } catch (GraphAPIActivityType graphAPIActivityType2) {
            Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Fetching extended device info parameters failed: '%s'", graphAPIActivityType2.toString());
        }
        jSONObject.put("application_package_name", context.getPackageName());
        return jSONObject;
    }
}
