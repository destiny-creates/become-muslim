package com.google.android.gms.p185e;

import android.text.TextUtils;

/* renamed from: com.google.android.gms.e.aw */
final class aw {
    /* renamed from: a */
    private final long f7458a;
    /* renamed from: b */
    private final long f7459b;
    /* renamed from: c */
    private final long f7460c;
    /* renamed from: d */
    private String f7461d;

    /* renamed from: a */
    final long m8560a() {
        return this.f7458a;
    }

    /* renamed from: b */
    final long m8562b() {
        return this.f7460c;
    }

    aw(long j, long j2, long j3) {
        this.f7458a = j;
        this.f7459b = j2;
        this.f7460c = j3;
    }

    /* renamed from: c */
    final String m8563c() {
        return this.f7461d;
    }

    /* renamed from: a */
    final void m8561a(String str) {
        if (str != null) {
            if (!TextUtils.isEmpty(str.trim())) {
                this.f7461d = str;
            }
        }
    }
}
