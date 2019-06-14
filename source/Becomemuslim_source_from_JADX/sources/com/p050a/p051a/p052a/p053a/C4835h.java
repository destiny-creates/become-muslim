package com.p050a.p051a.p052a.p053a;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.support.v4.util.C0452f;
import com.p050a.p051a.C0957g;
import com.p050a.p051a.p052a.p054b.C0885a;
import com.p050a.p051a.p052a.p054b.C0885a.C0884a;
import com.p050a.p051a.p056c.p058b.C0896c;
import com.p050a.p051a.p056c.p058b.C0897f;
import com.p050a.p051a.p056c.p058b.C3373e;
import com.p050a.p051a.p056c.p059c.C4529a;

/* compiled from: GradientStrokeContent */
/* renamed from: com.a.a.a.a.h */
public class C4835h extends C4503a {
    /* renamed from: b */
    private final String f13704b;
    /* renamed from: c */
    private final C0452f<LinearGradient> f13705c = new C0452f();
    /* renamed from: d */
    private final C0452f<RadialGradient> f13706d = new C0452f();
    /* renamed from: e */
    private final RectF f13707e = new RectF();
    /* renamed from: f */
    private final C0897f f13708f;
    /* renamed from: g */
    private final int f13709g;
    /* renamed from: h */
    private final C0885a<C0896c, C0896c> f13710h;
    /* renamed from: i */
    private final C0885a<PointF, PointF> f13711i;
    /* renamed from: j */
    private final C0885a<PointF, PointF> f13712j;

    public C4835h(C0957g c0957g, C4529a c4529a, C3373e c3373e) {
        super(c0957g, c4529a, c3373e.m10717h().m3186a(), c3373e.m10718i().m3187a(), c3373e.m10713d(), c3373e.m10716g(), c3373e.m10719j(), c3373e.m10720k());
        this.f13704b = c3373e.m10710a();
        this.f13708f = c3373e.m10711b();
        this.f13709g = (int) (c0957g.m3399r().m3342c() / 32.0f);
        this.f13710h = c3373e.m10712c().mo737a();
        this.f13710h.m3133a((C0884a) this);
        c4529a.m15378a(this.f13710h);
        this.f13711i = c3373e.m10714e().mo737a();
        this.f13711i.m3133a((C0884a) this);
        c4529a.m15378a(this.f13711i);
        this.f13712j = c3373e.m10715f().mo737a();
        this.f13712j.m3133a((C0884a) this);
        c4529a.m15378a(this.f13712j);
    }

    /* renamed from: a */
    public void mo2789a(Canvas canvas, Matrix matrix, int i) {
        mo2790a(this.f13707e, matrix);
        if (this.f13708f == C0897f.Linear) {
            this.a.setShader(m17177c());
        } else {
            this.a.setShader(m17178d());
        }
        super.mo2789a(canvas, matrix, i);
    }

    /* renamed from: b */
    public String mo730b() {
        return this.f13704b;
    }

    /* renamed from: c */
    private LinearGradient m17177c() {
        long e = (long) m17179e();
        LinearGradient linearGradient = (LinearGradient) this.f13705c.m1412a(e);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointF = (PointF) this.f13711i.mo733e();
        PointF pointF2 = (PointF) this.f13712j.mo733e();
        C0896c c0896c = (C0896c) this.f13710h.mo733e();
        LinearGradient linearGradient2 = new LinearGradient((float) ((int) ((this.f13707e.left + (this.f13707e.width() / 2.0f)) + pointF.x)), (float) ((int) ((this.f13707e.top + (this.f13707e.height() / 2.0f)) + pointF.y)), (float) ((int) ((this.f13707e.left + (this.f13707e.width() / 2.0f)) + pointF2.x)), (float) ((int) ((this.f13707e.top + (this.f13707e.height() / 2.0f)) + pointF2.y)), c0896c.m3174b(), c0896c.m3173a(), TileMode.CLAMP);
        this.f13705c.m1418b(e, linearGradient2);
        return linearGradient2;
    }

    /* renamed from: d */
    private RadialGradient m17178d() {
        long e = (long) m17179e();
        RadialGradient radialGradient = (RadialGradient) this.f13706d.m1412a(e);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointF = (PointF) this.f13711i.mo733e();
        PointF pointF2 = (PointF) this.f13712j.mo733e();
        C0896c c0896c = (C0896c) this.f13710h.mo733e();
        int[] b = c0896c.m3174b();
        float[] a = c0896c.m3173a();
        int width = (int) ((this.f13707e.left + (this.f13707e.width() / 2.0f)) + pointF.x);
        int height = (int) ((this.f13707e.top + (this.f13707e.height() / 2.0f)) + pointF.y);
        float f = (float) width;
        float f2 = (float) height;
        RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot((double) (((int) ((this.f13707e.left + (this.f13707e.width() / 2.0f)) + pointF2.x)) - width), (double) (((int) ((this.f13707e.top + (this.f13707e.height() / 2.0f)) + pointF2.y)) - height)), b, a, TileMode.CLAMP);
        this.f13706d.m1418b(e, radialGradient2);
        return radialGradient2;
    }

    /* renamed from: e */
    private int m17179e() {
        int round = Math.round(this.f13711i.m3139f() * ((float) this.f13709g));
        int round2 = Math.round(this.f13712j.m3139f() * ((float) this.f13709g));
        int round3 = Math.round(this.f13710h.m3139f() * ((float) this.f13709g));
        int i = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i = (i * 31) * round2;
        }
        return round3 != 0 ? (i * 31) * round3 : i;
    }
}
