package com.facebook.ads.internal.p105q.p110e;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.util.Log;
import com.facebook.ads.internal.p105q.p109d.C1540a;
import com.facebook.ads.internal.p105q.p109d.C1541b;

/* renamed from: com.facebook.ads.internal.q.e.a */
public class C1542a {
    /* renamed from: a */
    private static final String f4577a = "a";

    /* renamed from: a */
    public static boolean m5399a(Context context) {
        return C1542a.m5400b(context) && C1543b.m5402b(context);
    }

    /* renamed from: b */
    public static boolean m5400b(Context context) {
        if (context == null) {
            Log.v(f4577a, "Invalid context in screen interactive check, assuming interactive.");
            return true;
        }
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            return VERSION.SDK_INT >= 20 ? powerManager.isInteractive() : powerManager.isScreenOn();
        } catch (Exception e) {
            Log.e(f4577a, "Exception in screen interactive check, assuming interactive.", e);
            C1540a.m5396a(context, "risky", C1541b.f4572q, e);
            return true;
        }
    }
}
