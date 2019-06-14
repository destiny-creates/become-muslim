package com.google.android.gms.internal.p210i;

import android.annotation.SuppressLint;
import android.content.Context;
import com.google.android.gms.analytics.C2721s;
import com.google.android.gms.analytics.C4746d;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.util.C2895e;
import com.google.android.gms.common.util.C4376h;

@SuppressLint({"StaticFieldLeak"})
/* renamed from: com.google.android.gms.internal.i.q */
public class C5008q {
    /* renamed from: a */
    private static volatile C5008q f16815a;
    /* renamed from: b */
    private final Context f16816b;
    /* renamed from: c */
    private final Context f16817c;
    /* renamed from: d */
    private final C2895e f16818d = C4376h.d();
    /* renamed from: e */
    private final as f16819e = new as(this);
    /* renamed from: f */
    private final bl f16820f;
    /* renamed from: g */
    private final C2721s f16821g;
    /* renamed from: h */
    private final C7816f f16822h;
    /* renamed from: i */
    private final ax f16823i;
    /* renamed from: j */
    private final cb f16824j;
    /* renamed from: k */
    private final bp f16825k;
    /* renamed from: l */
    private final C4746d f16826l;
    /* renamed from: m */
    private final aj f16827m;
    /* renamed from: n */
    private final C7812e f16828n;
    /* renamed from: o */
    private final ac f16829o;
    /* renamed from: p */
    private final aw f16830p;

    private C5008q(C5010s c5010s) {
        Context a = c5010s.m21076a();
        C2872v.a(a, "Application context can't be null");
        Context b = c5010s.m21077b();
        C2872v.a(b);
        this.f16816b = a;
        this.f16817c = b;
        C6797o blVar = new bl(this);
        blVar.m31797A();
        this.f16820f = blVar;
        C5006n e = m21063e();
        String str = C5007p.f16813a;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 134);
        stringBuilder.append("Google Analytics ");
        stringBuilder.append(str);
        stringBuilder.append(" is starting up. To enable debug logging on a device run:\n  adb shell setprop log.tag.GAv4 DEBUG\n  adb logcat -s GAv4");
        e.m21039g(stringBuilder.toString());
        blVar = new bp(this);
        blVar.m31797A();
        this.f16825k = blVar;
        blVar = new cb(this);
        blVar.m31797A();
        this.f16824j = blVar;
        blVar = new C7816f(this, c5010s);
        c5010s = new aj(this);
        C6797o c7812e = new C7812e(this);
        C6797o acVar = new ac(this);
        C6797o awVar = new aw(this);
        C2721s a2 = C2721s.a(a);
        a2.a(new C5009r(this));
        this.f16821g = a2;
        C4746d c4746d = new C4746d(this);
        c5010s.m31797A();
        this.f16827m = c5010s;
        c7812e.m31797A();
        this.f16828n = c7812e;
        acVar.m31797A();
        this.f16829o = acVar;
        awVar.m31797A();
        this.f16830p = awVar;
        c5010s = new ax(this);
        c5010s.m31797A();
        this.f16823i = c5010s;
        blVar.m31797A();
        this.f16822h = blVar;
        c4746d.a();
        this.f16826l = c4746d;
        blVar.m37940b();
    }

    /* renamed from: a */
    public static C5008q m21057a(Context context) {
        C2872v.a(context);
        if (f16815a == null) {
            synchronized (C5008q.class) {
                if (f16815a == null) {
                    C2895e d = C4376h.d();
                    long b = d.b();
                    context = new C5008q(new C5010s(context));
                    f16815a = context;
                    C4746d.c();
                    long b2 = d.b() - b;
                    long longValue = ((Long) ba.f16368E.m20315a()).longValue();
                    if (b2 > longValue) {
                        context.m21063e().m21033c("Slow initialization (ms)", Long.valueOf(b2), Long.valueOf(longValue));
                    }
                }
            }
        }
        return f16815a;
    }

    /* renamed from: a */
    public final Context m21059a() {
        return this.f16816b;
    }

    /* renamed from: b */
    public final Context m21060b() {
        return this.f16817c;
    }

    /* renamed from: c */
    public final C2895e m21061c() {
        return this.f16818d;
    }

    /* renamed from: d */
    public final as m21062d() {
        return this.f16819e;
    }

    /* renamed from: e */
    public final bl m21063e() {
        C5008q.m21058a(this.f16820f);
        return this.f16820f;
    }

    /* renamed from: f */
    public final bl m21064f() {
        return this.f16820f;
    }

    /* renamed from: g */
    public final C2721s m21065g() {
        C2872v.a(this.f16821g);
        return this.f16821g;
    }

    /* renamed from: h */
    public final C7816f m21066h() {
        C5008q.m21058a(this.f16822h);
        return this.f16822h;
    }

    /* renamed from: i */
    public final ax m21067i() {
        C5008q.m21058a(this.f16823i);
        return this.f16823i;
    }

    /* renamed from: j */
    public final C4746d m21068j() {
        C2872v.a(this.f16826l);
        C2872v.b(this.f16826l.b(), "Analytics instance not initialized");
        return this.f16826l;
    }

    /* renamed from: k */
    public final cb m21069k() {
        C5008q.m21058a(this.f16824j);
        return this.f16824j;
    }

    /* renamed from: l */
    public final bp m21070l() {
        C5008q.m21058a(this.f16825k);
        return this.f16825k;
    }

    /* renamed from: m */
    public final bp m21071m() {
        if (this.f16825k != null) {
            if (this.f16825k.m31799y()) {
                return this.f16825k;
            }
        }
        return null;
    }

    /* renamed from: n */
    public final C7812e m21072n() {
        C5008q.m21058a(this.f16828n);
        return this.f16828n;
    }

    /* renamed from: o */
    public final aj m21073o() {
        C5008q.m21058a(this.f16827m);
        return this.f16827m;
    }

    /* renamed from: p */
    public final ac m21074p() {
        C5008q.m21058a(this.f16829o);
        return this.f16829o;
    }

    /* renamed from: q */
    public final aw m21075q() {
        return this.f16830p;
    }

    /* renamed from: a */
    private static void m21058a(C6797o c6797o) {
        C2872v.a(c6797o, "Analytics service not created/initialized");
        C2872v.b(c6797o.m31799y(), "Analytics service not initialized");
    }
}
