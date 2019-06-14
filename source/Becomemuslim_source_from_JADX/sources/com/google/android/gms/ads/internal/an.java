package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.aoq;
import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.jn;
import com.google.android.gms.internal.ads.jw;
import java.lang.ref.WeakReference;

@cm
public final class an {
    /* renamed from: a */
    private final ap f6720a;
    /* renamed from: b */
    private final Runnable f6721b;
    /* renamed from: c */
    private aoq f6722c;
    /* renamed from: d */
    private boolean f6723d;
    /* renamed from: e */
    private boolean f6724e;
    /* renamed from: f */
    private long f6725f;

    public an(C4736a c4736a) {
        this(c4736a, new ap(jw.f15691a));
    }

    private an(C4736a c4736a, ap apVar) {
        this.f6723d = false;
        this.f6724e = false;
        this.f6725f = 0;
        this.f6720a = apVar;
        this.f6721b = new ao(this, new WeakReference(c4736a));
    }

    /* renamed from: a */
    public final void m7438a() {
        this.f6723d = false;
        this.f6720a.m7446a(this.f6721b);
    }

    /* renamed from: a */
    public final void m7439a(aoq aoq) {
        this.f6722c = aoq;
    }

    /* renamed from: a */
    public final void m7440a(aoq aoq, long j) {
        if (this.f6723d) {
            jn.e("An ad refresh is already scheduled.");
            return;
        }
        this.f6722c = aoq;
        this.f6723d = true;
        this.f6725f = j;
        if (!this.f6724e) {
            StringBuilder stringBuilder = new StringBuilder(65);
            stringBuilder.append("Scheduling ad refresh ");
            stringBuilder.append(j);
            stringBuilder.append(" milliseconds from now.");
            jn.d(stringBuilder.toString());
            this.f6720a.m7447a(this.f6721b, j);
        }
    }

    /* renamed from: b */
    public final void m7441b() {
        this.f6724e = true;
        if (this.f6723d) {
            this.f6720a.m7446a(this.f6721b);
        }
    }

    /* renamed from: b */
    public final void m7442b(aoq aoq) {
        m7440a(aoq, 60000);
    }

    /* renamed from: c */
    public final void m7443c() {
        this.f6724e = false;
        if (this.f6723d) {
            this.f6723d = false;
            m7440a(this.f6722c, this.f6725f);
        }
    }

    /* renamed from: d */
    public final void m7444d() {
        this.f6724e = false;
        this.f6723d = false;
        if (!(this.f6722c == null || this.f6722c.f28263c == null)) {
            this.f6722c.f28263c.remove("_ad");
        }
        m7440a(this.f6722c, 0);
    }

    /* renamed from: e */
    public final boolean m7445e() {
        return this.f6723d;
    }
}
