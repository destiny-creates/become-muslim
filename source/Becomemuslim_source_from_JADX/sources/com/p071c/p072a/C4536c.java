package com.p071c.p072a;

import com.p071c.p072a.C4537e.C3457a;
import p289e.C5974e.C7335a;

/* compiled from: PublishRelay */
/* renamed from: com.c.a.c */
public class C4536c<T> extends C3455d<T, T> {
    /* renamed from: b */
    private final C4537e<T> f12267b;

    /* renamed from: b */
    public static <T> C4536c<T> m15431b() {
        Object c4537e = new C4537e();
        return new C4536c(c4537e, c4537e);
    }

    protected C4536c(C7335a<T> c7335a, C4537e<T> c4537e) {
        super(c7335a);
        this.f12267b = c4537e;
    }

    /* renamed from: b */
    public void m15433b(T t) {
        for (C3457a a : this.f12267b.m15441b()) {
            a.m11106a((Object) t);
        }
    }

    /* renamed from: a */
    public boolean mo2803a() {
        return this.f12267b.m15441b().length > 0;
    }
}
