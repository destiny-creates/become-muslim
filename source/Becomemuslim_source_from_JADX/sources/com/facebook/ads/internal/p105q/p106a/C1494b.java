package com.facebook.ads.internal.p105q.p106a;

import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;

/* renamed from: com.facebook.ads.internal.q.a.b */
public class C1494b {
    /* renamed from: a */
    private static boolean f4410a = false;
    /* renamed from: b */
    private static boolean f4411b = false;

    /* renamed from: a */
    public static synchronized String m5264a(String str) {
        synchronized (C1494b.class) {
            if (C1494b.m5265a()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("fb.e2e.");
                stringBuilder.append(str);
                str = System.getProperty(stringBuilder.toString());
                return str;
            }
            return null;
        }
    }

    /* renamed from: a */
    public static synchronized boolean m5265a() {
        boolean z;
        synchronized (C1494b.class) {
            if (!f4411b) {
                f4410a = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(System.getProperty("fb.running_e2e"));
                f4411b = true;
            }
            z = f4410a;
        }
        return z;
    }

    /* renamed from: b */
    public static synchronized boolean m5266b(String str) {
        boolean isEmpty;
        synchronized (C1494b.class) {
            isEmpty = TextUtils.isEmpty(C1494b.m5264a(str)) ^ 1;
        }
        return isEmpty;
    }
}
