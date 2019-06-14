package com.p050a.p051a.p056c.p057a;

import android.graphics.PointF;
import com.p050a.p051a.p052a.p054b.C0885a;
import com.p050a.p051a.p052a.p054b.C4517i;
import com.p050a.p051a.p052a.p054b.C4518j;
import com.p050a.p051a.p062f.C0950a;
import java.util.Collections;
import java.util.List;

/* compiled from: AnimatablePathValue */
/* renamed from: com.a.a.c.a.e */
public class C3367e implements C0893m<PointF, PointF> {
    /* renamed from: a */
    private final List<C0950a<PointF>> f8935a;

    public C3367e() {
        this.f8935a = Collections.singletonList(new C0950a(new PointF(0.0f, 0.0f)));
    }

    public C3367e(List<C0950a<PointF>> list) {
        this.f8935a = list;
    }

    /* renamed from: a */
    public C0885a<PointF, PointF> mo737a() {
        if (((C0950a) this.f8935a.get(0)).m3328d()) {
            return new C4518j(this.f8935a);
        }
        return new C4517i(this.f8935a);
    }
}
