package com.p050a.p051a.p052a.p054b;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.p050a.p051a.C0959i;
import com.p050a.p051a.p052a.p054b.C0885a.C0884a;
import com.p050a.p051a.p056c.p057a.C3369l;
import com.p050a.p051a.p056c.p059c.C4529a;
import com.p050a.p051a.p062f.C0952c;
import com.p050a.p051a.p062f.C0953d;

/* compiled from: TransformKeyframeAnimation */
/* renamed from: com.a.a.a.b.o */
public class C0887o {
    /* renamed from: a */
    private final Matrix f2486a = new Matrix();
    /* renamed from: b */
    private final C0885a<PointF, PointF> f2487b;
    /* renamed from: c */
    private final C0885a<?, PointF> f2488c;
    /* renamed from: d */
    private final C0885a<C0953d, C0953d> f2489d;
    /* renamed from: e */
    private final C0885a<Float, Float> f2490e;
    /* renamed from: f */
    private final C0885a<Integer, Integer> f2491f;
    /* renamed from: g */
    private final C0885a<?, Float> f2492g;
    /* renamed from: h */
    private final C0885a<?, Float> f2493h;

    public C0887o(C3369l c3369l) {
        this.f2487b = c3369l.m10688a().mo737a();
        this.f2488c = c3369l.m10689b().mo737a();
        this.f2489d = c3369l.m10690c().mo737a();
        this.f2490e = c3369l.m10691d().mo737a();
        this.f2491f = c3369l.m10692e().mo737a();
        if (c3369l.m10693f() != null) {
            this.f2492g = c3369l.m10693f().mo737a();
        } else {
            this.f2492g = null;
        }
        if (c3369l.m10694g() != null) {
            this.f2493h = c3369l.m10694g().mo737a();
        } else {
            this.f2493h = null;
        }
    }

    /* renamed from: a */
    public void m3146a(C4529a c4529a) {
        c4529a.m15378a(this.f2487b);
        c4529a.m15378a(this.f2488c);
        c4529a.m15378a(this.f2489d);
        c4529a.m15378a(this.f2490e);
        c4529a.m15378a(this.f2491f);
        if (this.f2492g != null) {
            c4529a.m15378a(this.f2492g);
        }
        if (this.f2493h != null) {
            c4529a.m15378a(this.f2493h);
        }
    }

    /* renamed from: a */
    public void m3145a(C0884a c0884a) {
        this.f2487b.m3133a(c0884a);
        this.f2488c.m3133a(c0884a);
        this.f2489d.m3133a(c0884a);
        this.f2490e.m3133a(c0884a);
        this.f2491f.m3133a(c0884a);
        if (this.f2492g != null) {
            this.f2492g.m3133a(c0884a);
        }
        if (this.f2493h != null) {
            this.f2493h.m3133a(c0884a);
        }
    }

    /* renamed from: a */
    public void m3144a(float f) {
        this.f2487b.mo732a(f);
        this.f2488c.mo732a(f);
        this.f2489d.mo732a(f);
        this.f2490e.mo732a(f);
        this.f2491f.mo732a(f);
        if (this.f2492g != null) {
            this.f2492g.mo732a(f);
        }
        if (this.f2493h != null) {
            this.f2493h.mo732a(f);
        }
    }

    /* renamed from: a */
    public C0885a<?, Integer> m3143a() {
        return this.f2491f;
    }

    /* renamed from: b */
    public C0885a<?, Float> m3149b() {
        return this.f2492g;
    }

    /* renamed from: c */
    public C0885a<?, Float> m3150c() {
        return this.f2493h;
    }

    /* renamed from: d */
    public Matrix m3151d() {
        this.f2486a.reset();
        PointF pointF = (PointF) this.f2488c.mo733e();
        if (!(pointF.x == 0.0f && pointF.y == 0.0f)) {
            this.f2486a.preTranslate(pointF.x, pointF.y);
        }
        float floatValue = ((Float) this.f2490e.mo733e()).floatValue();
        if (floatValue != 0.0f) {
            this.f2486a.preRotate(floatValue);
        }
        C0953d c0953d = (C0953d) this.f2489d.mo733e();
        if (!(c0953d.m3333a() == 1.0f && c0953d.m3334b() == 1.0f)) {
            this.f2486a.preScale(c0953d.m3333a(), c0953d.m3334b());
        }
        pointF = (PointF) this.f2487b.mo733e();
        if (!(pointF.x == 0.0f && pointF.y == 0.0f)) {
            this.f2486a.preTranslate(-pointF.x, -pointF.y);
        }
        return this.f2486a;
    }

    /* renamed from: b */
    public Matrix m3148b(float f) {
        PointF pointF = (PointF) this.f2488c.mo733e();
        PointF pointF2 = (PointF) this.f2487b.mo733e();
        C0953d c0953d = (C0953d) this.f2489d.mo733e();
        float floatValue = ((Float) this.f2490e.mo733e()).floatValue();
        this.f2486a.reset();
        this.f2486a.preTranslate(pointF.x * f, pointF.y * f);
        double d = (double) f;
        this.f2486a.preScale((float) Math.pow((double) c0953d.m3333a(), d), (float) Math.pow((double) c0953d.m3334b(), d));
        this.f2486a.preRotate(floatValue * f, pointF2.x, pointF2.y);
        return this.f2486a;
    }

    /* renamed from: a */
    public <T> boolean m3147a(T t, C0952c<T> c0952c) {
        if (t == C0959i.f2705e) {
            this.f2487b.m3134a((C0952c) c0952c);
        } else if (t == C0959i.f2706f) {
            this.f2488c.m3134a((C0952c) c0952c);
        } else if (t == C0959i.f2709i) {
            this.f2489d.m3134a((C0952c) c0952c);
        } else if (t == C0959i.f2710j) {
            this.f2490e.m3134a((C0952c) c0952c);
        } else if (t == C0959i.f2703c) {
            this.f2491f.m3134a((C0952c) c0952c);
        } else if (t == C0959i.f2721u && this.f2492g != null) {
            this.f2492g.m3134a((C0952c) c0952c);
        } else if (t != C0959i.f2722v || this.f2493h == null) {
            return null;
        } else {
            this.f2493h.m3134a((C0952c) c0952c);
        }
        return true;
    }
}
