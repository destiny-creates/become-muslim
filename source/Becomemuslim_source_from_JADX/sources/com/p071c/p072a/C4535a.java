package com.p071c.p072a;

import com.p071c.p072a.C4537e.C3457a;
import p289e.C5974e.C7335a;
import p289e.p291b.C5914b;

/* compiled from: BehaviorRelay */
/* renamed from: com.c.a.a */
public class C4535a<T> extends C3455d<T, T> {
    /* renamed from: c */
    private static final Object[] f12265c = new Object[0];
    /* renamed from: b */
    private final C4537e<T> f12266b;

    /* renamed from: a */
    public static <T> C4535a<T> m15426a(T t) {
        return C4535a.m15427a(t, true);
    }

    /* renamed from: a */
    private static <T> C4535a<T> m15427a(T t, boolean z) {
        final Object c4537e = new C4537e();
        if (z) {
            c4537e.m15439a(C1110b.m3936a(t));
        }
        c4537e.f12271d = new C5914b<C3457a<T>>() {
            /* renamed from: b */
            public /* synthetic */ void m11100b(Object obj) {
                m11099a((C3457a) obj);
            }

            /* renamed from: a */
            public void m11099a(C3457a<T> c3457a) {
                c3457a.m11109c(c4537e.m15436a());
            }
        };
        return new C4535a(c4537e, c4537e);
    }

    protected C4535a(C7335a<T> c7335a, C4537e<T> c4537e) {
        super(c7335a);
        this.f12266b = c4537e;
    }

    /* renamed from: b */
    public void m15430b(T t) {
        if (this.f12266b.m15436a() == null || this.f12266b.f12269b) {
            t = C1110b.m3936a(t);
            for (C3457a b : this.f12266b.m15442c(t)) {
                b.m11108b(t);
            }
        }
    }

    /* renamed from: a */
    public boolean mo2803a() {
        return this.f12266b.m15441b().length > 0;
    }

    /* renamed from: b */
    public T m15429b() {
        Object a = this.f12266b.m15436a();
        return a != null ? C1110b.m3938b(a) : null;
    }
}
