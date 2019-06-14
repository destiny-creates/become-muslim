package com.facebook.ads.internal.p105q.p106a;

import android.app.KeyguardManager;
import android.content.Context;
import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.q.a.y */
public class C1525y {
    /* renamed from: a */
    private static final String f4506a = "y";

    /* renamed from: a */
    public static boolean m5348a(Context context) {
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
        return keyguardManager != null && keyguardManager.inKeyguardRestrictedInputMode();
    }

    /* renamed from: a */
    public static boolean m5349a(Map<String, String> map) {
        if (map != null) {
            if (!map.isEmpty()) {
                String str = (String) map.get("wfdkg");
                String str2 = (String) map.get("wfswl");
                String str3 = (String) map.get("kgr");
                return str != null && str.equals(AppEventsConstants.EVENT_PARAM_VALUE_YES) && str2 != null && str2.equals(AppEventsConstants.EVENT_PARAM_VALUE_YES) && str3 != null && str3.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            }
        }
        Log.v(f4506a, "Invalid Window info in window interactive check, assuming is not a Lockscreen.");
        return false;
    }

    /* renamed from: b */
    public static boolean m5350b(Map<String, String> map) {
        boolean z = false;
        if (map != null) {
            if (!map.isEmpty()) {
                String str = (String) map.get("wfdkg");
                String str2 = (String) map.get("wfswl");
                if ((str != null && str.equals(AppEventsConstants.EVENT_PARAM_VALUE_YES)) || (str2 != null && str2.equals(AppEventsConstants.EVENT_PARAM_VALUE_YES))) {
                    return false;
                }
                String str3 = (String) map.get("kgr");
                if (str3 != null && str3.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                    z = true;
                }
                return z;
            }
        }
        Log.v(f4506a, "Invalid Window info in window interactive check, assuming not obstructed by Keyguard.");
        return false;
    }
}
