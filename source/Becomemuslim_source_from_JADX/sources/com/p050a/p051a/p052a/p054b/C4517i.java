package com.p050a.p051a.p052a.p054b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.p050a.p051a.p062f.C0950a;
import java.util.List;

/* compiled from: PathKeyframeAnimation */
/* renamed from: com.a.a.a.b.i */
public class C4517i extends C3362f<PointF> {
    /* renamed from: c */
    private final PointF f12206c = new PointF();
    /* renamed from: d */
    private final float[] f12207d = new float[2];
    /* renamed from: e */
    private C3363h f12208e;
    /* renamed from: f */
    private PathMeasure f12209f;

    /* renamed from: a */
    public /* synthetic */ Object mo731a(C0950a c0950a, float f) {
        return m15346b(c0950a, f);
    }

    public C4517i(List<? extends C0950a<PointF>> list) {
        super(list);
    }

    /* renamed from: b */
    public PointF m15346b(C0950a<PointF> c0950a, float f) {
        C0950a c0950a2 = (C3363h) c0950a;
        Path a = c0950a2.m10673a();
        if (a == null) {
            return (PointF) c0950a.f2644a;
        }
        if (this.b != null) {
            return (PointF) this.b.m3330a(c0950a2.d, c0950a2.e.floatValue(), c0950a2.a, c0950a2.b, m3136c(), f, m3139f());
        }
        if (this.f12208e != c0950a2) {
            this.f12209f = new PathMeasure(a, false);
            this.f12208e = c0950a2;
        }
        this.f12209f.getPosTan(f * this.f12209f.getLength(), this.f12207d, null);
        this.f12206c.set(this.f12207d[0], this.f12207d[1]);
        return this.f12206c;
    }
}
