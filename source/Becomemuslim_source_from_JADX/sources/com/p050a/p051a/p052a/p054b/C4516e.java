package com.p050a.p051a.p052a.p054b;

import com.p050a.p051a.p061e.C0947e;
import com.p050a.p051a.p062f.C0950a;
import java.util.List;

/* compiled from: IntegerKeyframeAnimation */
/* renamed from: com.a.a.a.b.e */
public class C4516e extends C3362f<Integer> {
    /* renamed from: a */
    /* synthetic */ Object mo731a(C0950a c0950a, float f) {
        return m15344b(c0950a, f);
    }

    public C4516e(List<C0950a<Integer>> list) {
        super(list);
    }

    /* renamed from: b */
    Integer m15344b(C0950a<Integer> c0950a, float f) {
        if (c0950a.f2644a == null || c0950a.f2645b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        } else if (this.b == null) {
            return Integer.valueOf(C0947e.m3305a(((Integer) c0950a.f2644a).intValue(), ((Integer) c0950a.f2645b).intValue(), f));
        } else {
            return (Integer) this.b.m3330a(c0950a.f2647d, c0950a.f2648e.floatValue(), c0950a.f2644a, c0950a.f2645b, f, m3136c(), m3139f());
        }
    }
}
