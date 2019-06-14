package com.facebook.ads.internal.p105q.p110e;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.util.Log;
import android.view.Window;
import com.facebook.ads.internal.p105q.p106a.C1525y;
import com.facebook.ads.internal.p105q.p109d.C1540a;
import com.facebook.ads.internal.p105q.p109d.C1541b;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.imagepipeline.memory.DefaultFlexByteArrayPoolParams;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.q.e.b */
public class C1543b {
    /* renamed from: a */
    private static final String f4578a = "b";

    /* renamed from: a */
    public static Map<String, String> m5401a(Context context) {
        Map<String, String> hashMap = new HashMap();
        if (context == null) {
            Log.v(f4578a, "Null context in window interactive check.");
            return hashMap;
        }
        try {
            String str;
            String str2;
            hashMap.put("kgr", String.valueOf(C1543b.m5403c(context)));
            if (context instanceof Activity) {
                Window window = ((Activity) context).getWindow();
                if (window != null) {
                    int i = window.getAttributes().flags;
                    hashMap.put("wt", Integer.toString(window.getAttributes().type));
                    hashMap.put("wfdkg", (DefaultFlexByteArrayPoolParams.DEFAULT_MAX_BYTE_ARRAY_SIZE & i) > 0 ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    hashMap.put("wfswl", (524288 & i) > 0 ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    return hashMap;
                }
                str = f4578a;
                str2 = "Invalid window in window interactive check, assuming interactive.";
            } else {
                str = f4578a;
                str2 = "Invalid Activity context in window interactive check, assuming interactive.";
            }
            Log.v(str, str2);
        } catch (Exception e) {
            Log.e(f4578a, "Exception in window info check", e);
            C1540a.m5396a(context, "risky", C1541b.f4573r, e);
        }
        return hashMap;
    }

    /* renamed from: b */
    public static boolean m5402b(Context context) {
        return C1525y.m5350b(C1543b.m5401a(context)) ^ 1;
    }

    /* renamed from: c */
    public static boolean m5403c(Context context) {
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
        return keyguardManager != null && keyguardManager.inKeyguardRestrictedInputMode();
    }
}
