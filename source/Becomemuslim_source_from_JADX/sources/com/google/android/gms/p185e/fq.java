package com.google.android.gms.p185e;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.C2814k;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.util.C2895e;
import com.google.android.gms.common.util.C4376h;
import com.google.android.gms.internal.p210i.cq;
import com.google.android.gms.internal.p210i.cs;
import com.google.android.gms.internal.p210i.cv;
import com.google.android.gms.internal.p210i.cw;
import com.google.android.gms.internal.p210i.db;
import com.google.android.gms.p185e.cr.C2935a;

/* renamed from: com.google.android.gms.e.fq */
public final class fq extends BasePendingResult<C4391b> {
    /* renamed from: a */
    private final C2895e f13306a;
    /* renamed from: b */
    private final C4396j f13307b;
    /* renamed from: d */
    private final Looper f13308d;
    /* renamed from: e */
    private final ct f13309e;
    /* renamed from: f */
    private final int f13310f;
    /* renamed from: g */
    private final Context f13311g;
    /* renamed from: h */
    private final C2937d f13312h;
    /* renamed from: i */
    private final String f13313i;
    /* renamed from: j */
    private final C2941m f13314j;
    /* renamed from: k */
    private C4398l f13315k;
    /* renamed from: l */
    private cw f13316l;
    /* renamed from: m */
    private volatile fn f13317m;
    /* renamed from: n */
    private volatile boolean f13318n;
    /* renamed from: o */
    private cs f13319o;
    /* renamed from: p */
    private long f13320p;
    /* renamed from: q */
    private String f13321q;
    /* renamed from: r */
    private C4397k f13322r;
    /* renamed from: s */
    private C2940g f13323s;

    public fq(Context context, C2937d c2937d, Looper looper, String str, int i, C2942p c2942p) {
        Context context2 = context;
        String str2 = str;
        this(context2, c2937d, looper, str2, i, new dh(context2, str2), new dc(context2, str2, c2942p), new cw(context2), C4376h.m14397d(), new bq(1, 5, 900000, 5000, "refreshing", C4376h.m14397d()), new C2941m(context2, str2));
        this.f13316l.a(c2942p.m8759a());
    }

    private fq(Context context, C2937d c2937d, Looper looper, String str, int i, C4398l c4398l, C4397k c4397k, cw cwVar, C2895e c2895e, ct ctVar, C2941m c2941m) {
        super(looper == null ? Looper.getMainLooper() : looper);
        this.f13311g = context;
        this.f13312h = c2937d;
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        this.f13308d = looper;
        this.f13313i = str;
        this.f13310f = i;
        this.f13315k = c4398l;
        this.f13322r = c4397k;
        this.f13316l = cwVar;
        this.f13307b = new C4396j();
        this.f13319o = new cs();
        this.f13306a = c2895e;
        this.f13309e = ctVar;
        this.f13314j = c2941m;
        if (m16926e() != null) {
            m16930a(cr.m8622a().m8624c());
        }
    }

    /* renamed from: d */
    public final void mo3282d() {
        m16921a(true);
    }

    /* renamed from: a */
    private final void m16921a(boolean z) {
        this.f13315k.mo3304a(new C4394h());
        this.f13322r.mo3301a(new C4395i());
        db a = this.f13315k.mo3303a(this.f13310f);
        if (a != null) {
            this.f13317m = new fn(this.f13312h, this.f13308d, new C2929a(this.f13311g, this.f13312h.m8636a(), this.f13313i, 0, a), this.f13307b);
        }
        this.f13323s = new C4393f(this, z);
        if (m16926e()) {
            this.f13322r.mo3300a(0, "");
        } else {
            this.f13315k.mo3306b();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private final synchronized void m16920a(com.google.android.gms.internal.p210i.cs r10, long r11, boolean r13) {
        /*
        r9 = this;
        monitor-enter(r9);
        if (r13 == 0) goto L_0x0008;
    L_0x0003:
        r13 = r9.f13318n;	 Catch:{ all -> 0x0006 }
        goto L_0x0008;
    L_0x0006:
        r10 = move-exception;
        goto L_0x0075;
    L_0x0008:
        r13 = r9.m14073f();	 Catch:{ all -> 0x0006 }
        if (r13 == 0) goto L_0x0014;
    L_0x000e:
        r13 = r9.f13317m;	 Catch:{ all -> 0x0006 }
        if (r13 != 0) goto L_0x0014;
    L_0x0012:
        monitor-exit(r9);
        return;
    L_0x0014:
        r9.f13319o = r10;	 Catch:{ all -> 0x0006 }
        r9.f13320p = r11;	 Catch:{ all -> 0x0006 }
        r13 = r9.f13314j;	 Catch:{ all -> 0x0006 }
        r0 = r13.m8755a();	 Catch:{ all -> 0x0006 }
        r2 = 0;
        r4 = r9.f13320p;	 Catch:{ all -> 0x0006 }
        r13 = 0;
        r4 = r4 + r0;
        r13 = r9.f13306a;	 Catch:{ all -> 0x0006 }
        r6 = r13.mo2482a();	 Catch:{ all -> 0x0006 }
        r13 = 0;
        r4 = r4 - r6;
        r0 = java.lang.Math.min(r0, r4);	 Catch:{ all -> 0x0006 }
        r0 = java.lang.Math.max(r2, r0);	 Catch:{ all -> 0x0006 }
        r9.m16915a(r0);	 Catch:{ all -> 0x0006 }
        r13 = new com.google.android.gms.e.a;	 Catch:{ all -> 0x0006 }
        r3 = r9.f13311g;	 Catch:{ all -> 0x0006 }
        r0 = r9.f13312h;	 Catch:{ all -> 0x0006 }
        r4 = r0.m8636a();	 Catch:{ all -> 0x0006 }
        r5 = r9.f13313i;	 Catch:{ all -> 0x0006 }
        r2 = r13;
        r6 = r11;
        r8 = r10;
        r2.<init>(r3, r4, r5, r6, r8);	 Catch:{ all -> 0x0006 }
        r10 = r9.f13317m;	 Catch:{ all -> 0x0006 }
        if (r10 != 0) goto L_0x005b;
    L_0x004d:
        r10 = new com.google.android.gms.e.fn;	 Catch:{ all -> 0x0006 }
        r11 = r9.f13312h;	 Catch:{ all -> 0x0006 }
        r12 = r9.f13308d;	 Catch:{ all -> 0x0006 }
        r0 = r9.f13307b;	 Catch:{ all -> 0x0006 }
        r10.<init>(r11, r12, r13, r0);	 Catch:{ all -> 0x0006 }
        r9.f13317m = r10;	 Catch:{ all -> 0x0006 }
        goto L_0x0060;
    L_0x005b:
        r10 = r9.f13317m;	 Catch:{ all -> 0x0006 }
        r10.m16909a(r13);	 Catch:{ all -> 0x0006 }
    L_0x0060:
        r10 = r9.m14073f();	 Catch:{ all -> 0x0006 }
        if (r10 != 0) goto L_0x0073;
    L_0x0066:
        r10 = r9.f13323s;	 Catch:{ all -> 0x0006 }
        r10 = r10.mo2565a(r13);	 Catch:{ all -> 0x0006 }
        if (r10 == 0) goto L_0x0073;
    L_0x006e:
        r10 = r9.f13317m;	 Catch:{ all -> 0x0006 }
        r9.m14069b(r10);	 Catch:{ all -> 0x0006 }
    L_0x0073:
        monitor-exit(r9);
        return;
    L_0x0075:
        monitor-exit(r9);
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.e.fq.a(com.google.android.gms.internal.i.cs, long, boolean):void");
    }

    /* renamed from: a */
    final synchronized void m16930a(String str) {
        this.f13321q = str;
        if (this.f13322r != null) {
            this.f13322r.mo3302a(str);
        }
    }

    /* renamed from: a */
    private final synchronized void m16915a(long j) {
        if (this.f13322r == null) {
            bs.m8584b("Refresh requested, but no network load scheduler.");
        } else {
            this.f13322r.mo3300a(j, this.f13319o.f28855c);
        }
    }

    /* renamed from: b */
    protected final C4391b m16931b(Status status) {
        if (this.f13317m != null) {
            return this.f13317m;
        }
        if (status == Status.f13154d) {
            bs.m8582a("timer expired: setting result to failure");
        }
        return new fn(status);
    }

    /* renamed from: e */
    private final boolean m16926e() {
        cr a = cr.m8622a();
        return (a.m8623b() == C2935a.CONTAINER || a.m8623b() == C2935a.CONTAINER_DEBUG) && this.f13313i.equals(a.m8625d());
    }

    /* renamed from: a */
    private final synchronized void m16919a(cs csVar) {
        if (this.f13315k != null) {
            cv cvVar = new cv();
            cvVar.f28869a = this.f13320p;
            cvVar.f28870b = new cq();
            cvVar.f28871c = csVar;
            this.f13315k.mo3305a(cvVar);
        }
    }

    /* renamed from: a */
    protected final /* synthetic */ C2814k mo3278a(Status status) {
        return m16931b(status);
    }
}
