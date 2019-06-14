package com.p050a.p051a.p052a.p054b;

import com.p050a.p051a.p061e.C0945b;
import com.p050a.p051a.p062f.C0950a;
import java.util.List;

/* compiled from: ColorKeyframeAnimation */
/* renamed from: com.a.a.a.b.b */
public class C4513b extends C3362f<Integer> {
    /* renamed from: a */
    public /* synthetic */ Object mo731a(C0950a c0950a, float f) {
        return m15338b(c0950a, f);
    }

    public C4513b(List<C0950a<Integer>> list) {
        super(list);
    }

    /* renamed from: b */
    public Integer m15338b(C0950a<Integer> c0950a, float f) {
        if (c0950a.f2644a == null || c0950a.f2645b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int intValue = ((Integer) c0950a.f2644a).intValue();
        int intValue2 = ((Integer) c0950a.f2645b).intValue();
        if (this.b == null) {
            return Integer.valueOf(C0945b.m3298a(f, intValue, intValue2));
        }
        return (Integer) this.b.m3330a(c0950a.f2647d, c0950a.f2648e.floatValue(), Integer.valueOf(intValue), Integer.valueOf(intValue2), f, m3136c(), m3139f());
    }
}
