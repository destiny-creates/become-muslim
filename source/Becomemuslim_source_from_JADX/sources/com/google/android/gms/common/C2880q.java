package com.google.android.gms.common;

import android.content.Context;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.util.Log;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.internal.bb;
import com.google.android.gms.common.internal.bc;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.p174b.C4757d;

/* renamed from: com.google.android.gms.common.q */
final class C2880q {
    /* renamed from: a */
    private static volatile bb f7343a;
    /* renamed from: b */
    private static final Object f7344b = new Object();
    /* renamed from: c */
    private static Context f7345c;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    static synchronized void m8405a(android.content.Context r2) {
        /*
        r0 = com.google.android.gms.common.C2880q.class;
        monitor-enter(r0);
        r1 = f7345c;	 Catch:{ all -> 0x001a }
        if (r1 != 0) goto L_0x0011;
    L_0x0007:
        if (r2 == 0) goto L_0x0018;
    L_0x0009:
        r2 = r2.getApplicationContext();	 Catch:{ all -> 0x001a }
        f7345c = r2;	 Catch:{ all -> 0x001a }
        monitor-exit(r0);
        return;
    L_0x0011:
        r2 = "GoogleCertificates";
        r1 = "GoogleCertificates has been initialized already";
        android.util.Log.w(r2, r1);	 Catch:{ all -> 0x001a }
    L_0x0018:
        monitor-exit(r0);
        return;
    L_0x001a:
        r2 = move-exception;
        monitor-exit(r0);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.q.a(android.content.Context):void");
    }

    /* renamed from: a */
    static aa m8403a(String str, C4789s c4789s, boolean z) {
        ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            str = C2880q.m8406b(str, c4789s, z);
            return str;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    /* renamed from: b */
    private static aa m8406b(String str, C4789s c4789s, boolean z) {
        try {
            if (f7343a == null) {
                C2872v.m8380a(f7345c);
                synchronized (f7344b) {
                    if (f7343a == null) {
                        f7343a = bc.m14379a(DynamiteModule.m8508a(f7345c, DynamiteModule.f7431c, "com.google.android.gms.googlecertificates").m8520a("com.google.android.gms.common.GoogleCertificatesImpl"));
                    }
                }
            }
            C2872v.m8380a(f7345c);
            try {
                if (f7343a.mo2476a(new C4790y(str, c4789s, z), C4757d.m16684a(f7345c.getPackageManager()))) {
                    return aa.m7892a();
                }
                return aa.m7895a(new C2881r(z, str, c4789s));
            } catch (String str2) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", str2);
                return aa.m7894a("module call", str2);
            }
        } catch (String str22) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", str22);
            c4789s = "module init: ";
            z = String.valueOf(str22.getMessage());
            return aa.m7894a(z.length() != 0 ? c4789s.concat(z) : new String(c4789s), str22);
        }
    }

    /* renamed from: a */
    static final /* synthetic */ String m8404a(boolean z, String str, C4789s c4789s) {
        boolean z2 = true;
        if (z || !C2880q.m8406b(str, c4789s, true).f7074a) {
            z2 = false;
        }
        return aa.m7896a(str, c4789s, z, z2);
    }
}
