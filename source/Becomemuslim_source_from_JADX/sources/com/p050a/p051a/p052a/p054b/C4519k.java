package com.p050a.p051a.p052a.p054b;

import com.p050a.p051a.p061e.C0947e;
import com.p050a.p051a.p062f.C0950a;
import com.p050a.p051a.p062f.C0953d;
import java.util.List;

/* compiled from: ScaleKeyframeAnimation */
/* renamed from: com.a.a.a.b.k */
public class C4519k extends C3362f<C0953d> {
    /* renamed from: a */
    public /* synthetic */ Object mo731a(C0950a c0950a, float f) {
        return m15350b(c0950a, f);
    }

    public C4519k(List<C0950a<C0953d>> list) {
        super(list);
    }

    /* renamed from: b */
    public C0953d m15350b(C0950a<C0953d> c0950a, float f) {
        if (c0950a.f2644a == null || c0950a.f2645b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        C0953d c0953d = (C0953d) c0950a.f2644a;
        C0953d c0953d2 = (C0953d) c0950a.f2645b;
        if (this.b == null) {
            return new C0953d(C0947e.m3302a(c0953d.m3333a(), c0953d2.m3333a(), f), C0947e.m3302a(c0953d.m3334b(), c0953d2.m3334b(), f));
        }
        return (C0953d) this.b.m3330a(c0950a.f2647d, c0950a.f2648e.floatValue(), c0953d, c0953d2, f, m3136c(), m3139f());
    }
}
