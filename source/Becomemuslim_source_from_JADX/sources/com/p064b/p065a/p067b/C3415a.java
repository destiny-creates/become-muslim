package com.p064b.p065a.p067b;

import android.annotation.SuppressLint;
import android.content.Context;
import io.p347a.p348a.p349a.C6514c;
import io.p347a.p348a.p349a.p350a.p352b.C6424g;
import io.p347a.p348a.p349a.p350a.p352b.C6430k;
import io.p347a.p348a.p349a.p350a.p352b.C6436o;
import io.p347a.p348a.p349a.p350a.p352b.C6436o.C6435a;
import io.p347a.p348a.p349a.p350a.p356e.C6484e;
import io.p347a.p348a.p349a.p350a.p357f.C6490c;
import io.p347a.p348a.p349a.p350a.p358g.C6495f;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: AbstractCheckForUpdatesController */
/* renamed from: com.b.a.b.a */
abstract class C3415a implements C1006j {
    /* renamed from: a */
    private final AtomicBoolean f9081a;
    /* renamed from: b */
    private final AtomicBoolean f9082b;
    /* renamed from: c */
    private Context f9083c;
    /* renamed from: d */
    private C3417c f9084d;
    /* renamed from: e */
    private C6436o f9085e;
    /* renamed from: f */
    private C6495f f9086f;
    /* renamed from: g */
    private C1003d f9087g;
    /* renamed from: h */
    private C6490c f9088h;
    /* renamed from: i */
    private C6430k f9089i;
    /* renamed from: j */
    private C6484e f9090j;
    /* renamed from: k */
    private long f9091k;

    public C3415a() {
        this(false);
    }

    public C3415a(boolean z) {
        this.f9081a = new AtomicBoolean();
        this.f9091k = 0;
        this.f9082b = new AtomicBoolean(z);
    }

    /* renamed from: a */
    public void mo746a(Context context, C3417c c3417c, C6436o c6436o, C6495f c6495f, C1003d c1003d, C6490c c6490c, C6430k c6430k, C6484e c6484e) {
        this.f9083c = context;
        this.f9084d = c3417c;
        this.f9085e = c6436o;
        this.f9086f = c6495f;
        this.f9087g = c1003d;
        this.f9088h = c6490c;
        this.f9089i = c6430k;
        this.f9090j = c6484e;
        if (m10895b() != null) {
            m10896c();
        }
    }

    /* renamed from: a */
    protected boolean m10894a() {
        this.f9082b.set(true);
        return this.f9081a.get();
    }

    /* renamed from: b */
    boolean m10895b() {
        this.f9081a.set(true);
        return this.f9082b.get();
    }

    @SuppressLint({"CommitPrefEdits"})
    /* renamed from: c */
    protected void m10896c() {
        synchronized (this.f9088h) {
            if (this.f9088h.a().contains("last_update_check")) {
                this.f9088h.a(this.f9088h.b().remove("last_update_check"));
            }
        }
        long a = this.f9089i.a();
        long j = ((long) this.f9086f.f20935b) * 1000;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Check for updates delay: ");
        stringBuilder.append(j);
        C6514c.h().a("Beta", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("Check for updates last check time: ");
        stringBuilder.append(m10897d());
        C6514c.h().a("Beta", stringBuilder.toString());
        long d = m10897d() + j;
        stringBuilder = new StringBuilder();
        stringBuilder.append("Check for updates current time: ");
        stringBuilder.append(a);
        stringBuilder.append(", next check time: ");
        stringBuilder.append(d);
        C6514c.h().a("Beta", stringBuilder.toString());
        if (a >= d) {
            try {
                m10891e();
            } finally {
                m10892a(a);
            }
        } else {
            C6514c.h().a("Beta", "Check for updates next check time was not passed");
        }
    }

    /* renamed from: e */
    private void m10891e() {
        C6514c.h().a("Beta", "Performing update check");
        new C3418e(this.f9084d, this.f9084d.m10910g(), this.f9086f.f20934a, this.f9090j, new C1005g()).m10914a(new C6424g().a(this.f9083c), (String) this.f9085e.i().get(C6435a.f20782c), this.f9087g);
    }

    /* renamed from: a */
    void m10892a(long j) {
        this.f9091k = j;
    }

    /* renamed from: d */
    long m10897d() {
        return this.f9091k;
    }
}
