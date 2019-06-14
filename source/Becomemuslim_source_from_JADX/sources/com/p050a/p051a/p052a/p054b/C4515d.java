package com.p050a.p051a.p052a.p054b;

import com.p050a.p051a.p056c.p058b.C0896c;
import com.p050a.p051a.p062f.C0950a;
import java.util.List;

/* compiled from: GradientColorKeyframeAnimation */
/* renamed from: com.a.a.a.b.d */
public class C4515d extends C3362f<C0896c> {
    /* renamed from: c */
    private final C0896c f12205c;

    /* renamed from: a */
    /* synthetic */ Object mo731a(C0950a c0950a, float f) {
        return m15342b(c0950a, f);
    }

    public C4515d(List<C0950a<C0896c>> list) {
        super(list);
        int i = 0;
        C0896c c0896c = (C0896c) ((C0950a) list.get(0)).f2644a;
        if (c0896c != null) {
            i = c0896c.m3175c();
        }
        this.f12205c = new C0896c(new float[i], new int[i]);
    }

    /* renamed from: b */
    C0896c m15342b(C0950a<C0896c> c0950a, float f) {
        this.f12205c.m3172a((C0896c) c0950a.f2644a, (C0896c) c0950a.f2645b, f);
        return this.f12205c;
    }
}
