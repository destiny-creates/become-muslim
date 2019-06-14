package com.p050a.p051a.p052a.p054b;

import android.graphics.PointF;
import com.p050a.p051a.p052a.p054b.C0885a.C0884a;
import com.p050a.p051a.p062f.C0950a;
import java.util.Collections;

/* compiled from: SplitDimensionPathKeyframeAnimation */
/* renamed from: com.a.a.a.b.m */
public class C3365m extends C0885a<PointF, PointF> {
    /* renamed from: c */
    private final PointF f8931c = new PointF();
    /* renamed from: d */
    private final C0885a<Float, Float> f8932d;
    /* renamed from: e */
    private final C0885a<Float, Float> f8933e;

    /* renamed from: a */
    /* synthetic */ Object mo731a(C0950a c0950a, float f) {
        return m10678b(c0950a, f);
    }

    /* renamed from: e */
    public /* synthetic */ Object mo733e() {
        return mo734g();
    }

    public C3365m(C0885a<Float, Float> c0885a, C0885a<Float, Float> c0885a2) {
        super(Collections.emptyList());
        this.f8932d = c0885a;
        this.f8933e = c0885a2;
        mo732a(m3139f());
    }

    /* renamed from: a */
    public void mo732a(float f) {
        this.f8932d.mo732a(f);
        this.f8933e.mo732a(f);
        this.f8931c.set(((Float) this.f8932d.mo733e()).floatValue(), ((Float) this.f8933e.mo733e()).floatValue());
        for (int i = 0; i < this.a.size(); i++) {
            ((C0884a) this.a.get(i)).mo728a();
        }
    }

    /* renamed from: g */
    public PointF mo734g() {
        return m10678b(null, 0.0f);
    }

    /* renamed from: b */
    PointF m10678b(C0950a<PointF> c0950a, float f) {
        return this.f8931c;
    }
}
