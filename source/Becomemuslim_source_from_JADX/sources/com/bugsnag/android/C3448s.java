package com.bugsnag.android;

import com.bugsnag.android.ab.C1071a;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Error */
/* renamed from: com.bugsnag.android.s */
public class C3448s implements C1071a {
    /* renamed from: a */
    final C1091l f9201a;
    /* renamed from: b */
    private Map<String, Object> f9202b = new HashMap();
    /* renamed from: c */
    private Map<String, Object> f9203c = new HashMap();
    /* renamed from: d */
    private aq f9204d = new aq();
    /* renamed from: e */
    private Severity f9205e;
    /* renamed from: f */
    private af f9206f = new af();
    /* renamed from: g */
    private String f9207g;
    /* renamed from: h */
    private String f9208h;
    /* renamed from: i */
    private final String[] f9209i;
    /* renamed from: j */
    private final C3450x f9210j;
    /* renamed from: k */
    private Breadcrumbs f9211k;
    /* renamed from: l */
    private final Throwable f9212l;
    /* renamed from: m */
    private final C3451z f9213m;
    /* renamed from: n */
    private final aj f9214n;
    /* renamed from: o */
    private final ap f9215o;

    /* compiled from: Error */
    /* renamed from: com.bugsnag.android.s$a */
    static class C1100a {
        /* renamed from: a */
        private final C1091l f3102a;
        /* renamed from: b */
        private final Throwable f3103b;
        /* renamed from: c */
        private final al f3104c;
        /* renamed from: d */
        private final ap f3105d;
        /* renamed from: e */
        private Severity f3106e;
        /* renamed from: f */
        private af f3107f;
        /* renamed from: g */
        private String f3108g;
        /* renamed from: h */
        private String f3109h;

        C1100a(C1091l c1091l, Throwable th, al alVar, Thread thread, boolean z) {
            this.f3106e = Severity.WARNING;
            this.f3105d = new ap(c1091l, thread, Thread.getAllStackTraces(), z ? th : false);
            this.f3102a = c1091l;
            this.f3103b = th;
            this.f3109h = "userSpecifiedSeverity";
            this.f3104c = alVar;
        }

        C1100a(C1091l c1091l, String str, String str2, StackTraceElement[] stackTraceElementArr, al alVar, Thread thread) {
            this(c1091l, new C1081g(str, str2, stackTraceElementArr), alVar, thread, false);
        }

        /* renamed from: a */
        C1100a m3904a(String str) {
            this.f3109h = str;
            return this;
        }

        /* renamed from: b */
        C1100a m3906b(String str) {
            this.f3108g = str;
            return this;
        }

        /* renamed from: a */
        C1100a m3902a(Severity severity) {
            this.f3106e = severity;
            return this;
        }

        /* renamed from: a */
        C1100a m3903a(af afVar) {
            this.f3107f = afVar;
            return this;
        }

        /* renamed from: a */
        C3448s m3905a() {
            C3451z a = C3451z.m11092a(this.f3109h, this.f3106e, this.f3108g);
            C3448s c3448s = new C3448s(this.f3102a, this.f3103b, a, this.f3106e, m3901a(a), this.f3105d);
            if (this.f3107f != null) {
                c3448s.m11065a(this.f3107f);
            }
            return c3448s;
        }

        /* renamed from: a */
        private aj m3901a(C3451z c3451z) {
            aj d = this.f3104c.m3754d();
            aj ajVar = null;
            if (d == null) {
                return null;
            }
            if (this.f3102a.m3859l() || !d.m11049h()) {
                if (c3451z.m11095b() != null) {
                    ajVar = this.f3104c.m3755e();
                } else {
                    ajVar = this.f3104c.m3756f();
                }
            }
            return ajVar;
        }
    }

    C3448s(C1091l c1091l, Throwable th, C3451z c3451z, Severity severity, aj ajVar, ap apVar) {
        this.f9215o = apVar;
        this.f9201a = c1091l;
        this.f9212l = th;
        this.f9213m = c3451z;
        this.f9205e = severity;
        this.f9214n = ajVar;
        this.f9209i = c1091l.m3854h();
        this.f9210j = new C3450x(c1091l, th);
    }

    public void toStream(ab abVar) {
        r0 = new af[2];
        int i = 0;
        r0[0] = this.f9201a.m3860m();
        r0[1] = this.f9206f;
        C1071a a = af.m11030a(r0);
        abVar.mo772c();
        abVar.mo764a("context").mo771b(this.f9208h);
        abVar.mo764a("metaData").m11021a(a);
        abVar.mo764a("severity").m11021a(this.f9205e);
        abVar.mo764a("severityReason").m11021a(this.f9213m);
        abVar.mo764a("unhandled").mo769a(this.f9213m.m11095b());
        if (this.f9209i != null) {
            abVar.mo764a("projectPackages").mo776e();
            String[] strArr = this.f9209i;
            int length = strArr.length;
            while (i < length) {
                abVar.mo771b(strArr[i]);
                i++;
            }
            abVar.mo775d();
        }
        abVar.mo764a("exceptions").m11021a(this.f9210j);
        abVar.mo764a("user").m11021a(this.f9204d);
        abVar.mo764a("app").m11023a(this.f9202b);
        abVar.mo764a("device").m11023a(this.f9203c);
        abVar.mo764a("breadcrumbs").m11021a(this.f9211k);
        abVar.mo764a("groupingHash").mo771b(this.f9207g);
        if (this.f9201a.m3857j()) {
            abVar.mo764a("threads").m11021a(this.f9215o);
        }
        if (this.f9214n != null) {
            abVar.mo764a("session").mo772c();
            abVar.mo764a("id").mo771b(this.f9214n.m11042a());
            abVar.mo764a("startedAt").mo771b(C1093m.m3874a(this.f9214n.m11043b()));
            abVar.mo764a("events").mo772c();
            abVar.mo764a("handled").mo766a((long) this.f9214n.m11045d());
            abVar.mo764a("unhandled").mo766a((long) this.f9214n.m11044c());
            abVar.mo770b();
            abVar.mo770b();
        }
        abVar.mo770b();
    }

    /* renamed from: a */
    public void m11067a(String str) {
        this.f9208h = str;
    }

    /* renamed from: a */
    public String m11062a() {
        return this.f9208h;
    }

    /* renamed from: b */
    public void m11070b(String str) {
        this.f9207g = str;
    }

    /* renamed from: a */
    public void m11064a(Severity severity) {
        if (severity != null) {
            this.f9205e = severity;
            this.f9213m.m11094a(severity);
        }
    }

    /* renamed from: a */
    void m11066a(aq aqVar) {
        this.f9204d = aqVar;
    }

    /* renamed from: b */
    public af m11069b() {
        return this.f9206f;
    }

    /* renamed from: a */
    public void m11065a(af afVar) {
        if (afVar == null) {
            this.f9206f = new af();
        } else {
            this.f9206f = afVar;
        }
    }

    /* renamed from: c */
    public String m11072c() {
        if (this.f9212l instanceof C1081g) {
            return ((C1081g) this.f9212l).m3781a();
        }
        return this.f9212l.getClass().getName();
    }

    /* renamed from: d */
    public String m11073d() {
        String localizedMessage = this.f9212l.getLocalizedMessage();
        return localizedMessage != null ? localizedMessage : "";
    }

    /* renamed from: e */
    Map<String, Object> m11074e() {
        return this.f9202b;
    }

    /* renamed from: a */
    void m11068a(Map<String, Object> map) {
        this.f9202b = map;
    }

    /* renamed from: b */
    void m11071b(Map<String, Object> map) {
        this.f9203c = map;
    }

    /* renamed from: a */
    void m11063a(Breadcrumbs breadcrumbs) {
        this.f9211k = breadcrumbs;
    }

    /* renamed from: f */
    boolean m11075f() {
        return this.f9201a.m3853h(m11072c());
    }

    /* renamed from: g */
    C3451z m11076g() {
        return this.f9213m;
    }

    /* renamed from: h */
    C3450x m11077h() {
        return this.f9210j;
    }

    /* renamed from: i */
    aj m11078i() {
        return this.f9214n;
    }
}
