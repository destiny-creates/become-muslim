package com.google.android.gms.p185e;

import android.content.Context;
import com.google.android.gms.analytics.C4746d;
import com.google.android.gms.analytics.C4748h;

/* renamed from: com.google.android.gms.e.eq */
public final class eq {
    /* renamed from: a */
    private C4746d f7564a;
    /* renamed from: b */
    private Context f7565b;
    /* renamed from: c */
    private C4748h f7566c;

    public eq(Context context) {
        this.f7565b = context;
    }

    /* renamed from: a */
    public final C4748h m8709a(String str) {
        m8708b(str);
        return this.f7566c;
    }

    /* renamed from: b */
    private final synchronized void m8708b(String str) {
        if (this.f7564a == null) {
            this.f7564a = C4746d.m16610a(this.f7565b);
            this.f7564a.m16615a(new er());
            this.f7566c = this.f7564a.m16612a(str);
        }
    }
}
