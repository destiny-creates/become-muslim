package com.google.android.gms.internal.p213l;

/* renamed from: com.google.android.gms.internal.l.bc */
final class bc implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ int f16961a;
    /* renamed from: b */
    private final /* synthetic */ String f16962b;
    /* renamed from: c */
    private final /* synthetic */ Object f16963c;
    /* renamed from: d */
    private final /* synthetic */ Object f16964d;
    /* renamed from: e */
    private final /* synthetic */ Object f16965e;
    /* renamed from: f */
    private final /* synthetic */ bb f16966f;

    bc(bb bbVar, int i, String str, Object obj, Object obj2, Object obj3) {
        this.f16966f = bbVar;
        this.f16961a = i;
        this.f16962b = str;
        this.f16963c = obj;
        this.f16964d = obj2;
        this.f16965e = obj3;
    }

    public final void run() {
        dc c = this.f16966f.q.m31961c();
        if (c.m38103y()) {
            char c2;
            if (this.f16966f.f32312a == '\u0000') {
                bb bbVar;
                if (this.f16966f.mo6215t().m38051g()) {
                    bbVar = this.f16966f;
                    this.f16966f.mo4755u();
                    c2 = 'C';
                } else {
                    bbVar = this.f16966f;
                    this.f16966f.mo4755u();
                    c2 = 'c';
                }
                bbVar.f32312a = c2;
            }
            if (this.f16966f.f32313b < 0) {
                this.f16966f.f32313b = this.f16966f.mo6215t().m38049f();
            }
            char charAt = "01VDIWEA?".charAt(this.f16961a);
            c2 = this.f16966f.f32312a;
            long b = this.f16966f.f32313b;
            String a = bb.m42552a(true, this.f16962b, this.f16963c, this.f16964d, this.f16965e);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(a).length() + 24);
            stringBuilder.append("2");
            stringBuilder.append(charAt);
            stringBuilder.append(c2);
            stringBuilder.append(b);
            stringBuilder.append(":");
            stringBuilder.append(a);
            String stringBuilder2 = stringBuilder.toString();
            if (stringBuilder2.length() > 1024) {
                stringBuilder2 = this.f16962b.substring(0, 1024);
            }
            c.f32325b.m21323a(stringBuilder2, 1);
            return;
        }
        this.f16966f.m42556a(6, "Persisted config not initialized. Not logging error/warn");
    }
}
