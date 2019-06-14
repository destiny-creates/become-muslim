package com.p050a.p051a.p056c.p059c;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.p050a.p051a.C0957g;
import com.p050a.p051a.p052a.p053a.C4504c;
import com.p050a.p051a.p056c.C0917e;
import com.p050a.p051a.p056c.p058b.C3379n;
import java.util.Collections;
import java.util.List;

/* compiled from: ShapeLayer */
/* renamed from: com.a.a.c.c.f */
public class C4840f extends C4529a {
    /* renamed from: e */
    private final C4504c f13725e;

    C4840f(C0957g c0957g, C0912d c0912d) {
        super(c0957g, c0912d);
        this.f13725e = new C4504c(c0957g, this, new C3379n("__container", c0912d.m3203n()));
        this.f13725e.mo729a(Collections.emptyList(), Collections.emptyList());
    }

    /* renamed from: b */
    void mo3346b(Canvas canvas, Matrix matrix, int i) {
        this.f13725e.mo2789a(canvas, matrix, i);
    }

    /* renamed from: a */
    public void mo2790a(RectF rectF, Matrix matrix) {
        super.mo2790a(rectF, matrix);
        this.f13725e.mo2790a(rectF, this.a);
    }

    /* renamed from: b */
    protected void mo3347b(C0917e c0917e, int i, List<C0917e> list, C0917e c0917e2) {
        this.f13725e.mo2791a(c0917e, i, list, c0917e2);
    }
}
