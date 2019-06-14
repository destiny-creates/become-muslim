package com.p050a.p051a.p052a.p054b;

import com.p050a.p051a.p061e.C0947e;
import com.p050a.p051a.p062f.C0950a;
import java.util.List;

/* compiled from: FloatKeyframeAnimation */
/* renamed from: com.a.a.a.b.c */
public class C4514c extends C3362f<Float> {
    /* renamed from: a */
    /* synthetic */ Object mo731a(C0950a c0950a, float f) {
        return m15340b(c0950a, f);
    }

    public C4514c(List<C0950a<Float>> list) {
        super(list);
    }

    /* renamed from: b */
    Float m15340b(C0950a<Float> c0950a, float f) {
        if (c0950a.f2644a == null || c0950a.f2645b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        } else if (this.b == null) {
            return Float.valueOf(C0947e.m3302a(((Float) c0950a.f2644a).floatValue(), ((Float) c0950a.f2645b).floatValue(), f));
        } else {
            return (Float) this.b.m3330a(c0950a.f2647d, c0950a.f2648e.floatValue(), c0950a.f2644a, c0950a.f2645b, f, m3136c(), m3139f());
        }
    }
}
