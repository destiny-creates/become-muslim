package com.p050a.p051a.p052a.p054b;

import android.graphics.PointF;
import com.p050a.p051a.p062f.C0950a;
import java.util.List;

/* compiled from: PointKeyframeAnimation */
/* renamed from: com.a.a.a.b.j */
public class C4518j extends C3362f<PointF> {
    /* renamed from: c */
    private final PointF f12210c = new PointF();

    /* renamed from: a */
    public /* synthetic */ Object mo731a(C0950a c0950a, float f) {
        return m15348b(c0950a, f);
    }

    public C4518j(List<C0950a<PointF>> list) {
        super(list);
    }

    /* renamed from: b */
    public PointF m15348b(C0950a<PointF> c0950a, float f) {
        if (c0950a.f2644a == null || c0950a.f2645b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF = (PointF) c0950a.f2644a;
        PointF pointF2 = (PointF) c0950a.f2645b;
        if (this.b != null) {
            return (PointF) this.b.m3330a(c0950a.f2647d, c0950a.f2648e.floatValue(), pointF, pointF2, f, m3136c(), m3139f());
        }
        this.f12210c.set(pointF.x + ((pointF2.x - pointF.x) * f), pointF.y + (f * (pointF2.y - pointF.y)));
        return this.f12210c;
    }
}
