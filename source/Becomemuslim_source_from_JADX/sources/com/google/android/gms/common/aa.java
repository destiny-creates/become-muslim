package com.google.android.gms.common;

import android.util.Log;
import com.google.android.gms.common.util.C2891a;
import com.google.android.gms.common.util.C2899j;
import java.util.concurrent.Callable;

class aa {
    /* renamed from: b */
    private static final aa f7073b = new aa(true, null, null);
    /* renamed from: a */
    final boolean f7074a;
    /* renamed from: c */
    private final String f7075c;
    /* renamed from: d */
    private final Throwable f7076d;

    aa(boolean z, String str, Throwable th) {
        this.f7074a = z;
        this.f7075c = str;
        this.f7076d = th;
    }

    /* renamed from: a */
    static aa m7892a() {
        return f7073b;
    }

    /* renamed from: a */
    static aa m7895a(Callable<String> callable) {
        return new ac(callable, null);
    }

    /* renamed from: a */
    static aa m7893a(String str) {
        return new aa(false, str, null);
    }

    /* renamed from: a */
    static aa m7894a(String str, Throwable th) {
        return new aa(false, str, th);
    }

    /* renamed from: b */
    String mo2375b() {
        return this.f7075c;
    }

    /* renamed from: c */
    final void m7898c() {
        if (!this.f7074a && Log.isLoggable("GoogleCertificatesRslt", 3)) {
            if (this.f7076d != null) {
                Log.d("GoogleCertificatesRslt", mo2375b(), this.f7076d);
                return;
            }
            Log.d("GoogleCertificatesRslt", mo2375b());
        }
    }

    /* renamed from: a */
    static String m7896a(String str, C4789s c4789s, boolean z, boolean z2) {
        z2 = z2 ? "debug cert rejected" : "not whitelisted";
        return String.format("%s: pkg=%s, sha1=%s, atk=%s, ver=%s", new Object[]{z2, str, C2899j.m8446a(C2891a.m8415a("SHA-1").digest(c4789s.mo3467c())), Boolean.valueOf(z), "12451009.false"});
    }
}
