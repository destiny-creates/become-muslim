package com.p050a.p051a.p052a.p054b;

import android.graphics.Path;
import android.graphics.PointF;
import com.p050a.p051a.C0954f;
import com.p050a.p051a.p061e.C0948f;
import com.p050a.p051a.p062f.C0950a;

/* compiled from: PathKeyframe */
/* renamed from: com.a.a.a.b.h */
public class C3363h extends C0950a<PointF> {
    /* renamed from: h */
    private Path f8928h;

    public C3363h(C0954f c0954f, C0950a<PointF> c0950a) {
        super(c0954f, c0950a.f2644a, c0950a.f2645b, c0950a.f2646c, c0950a.f2647d, c0950a.f2648e);
        c0954f = (this.b == null || this.a == null || ((PointF) this.a).equals(((PointF) this.b).x, ((PointF) this.b).y) == null) ? null : true;
        if (this.b != null && c0954f == null) {
            this.f8928h = C0948f.m3316a((PointF) this.a, (PointF) this.b, c0950a.f2649f, c0950a.f2650g);
        }
    }

    /* renamed from: a */
    Path m10673a() {
        return this.f8928h;
    }
}
