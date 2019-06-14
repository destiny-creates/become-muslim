package p000a.p001a.p002a;

import p000a.p001a.C0002a;
import p000a.p003b.p004a.C0003a;

/* compiled from: DoubleCheck */
/* renamed from: a.a.a.b */
public final class C3085b<T> implements C0002a<T>, C0003a<T> {
    /* renamed from: a */
    static final /* synthetic */ boolean f7872a = (C3085b.class.desiredAssertionStatus() ^ 1);
    /* renamed from: b */
    private static final Object f7873b = new Object();
    /* renamed from: c */
    private volatile C0003a<T> f7874c;
    /* renamed from: d */
    private volatile Object f7875d = f7873b;

    private C3085b(C0003a<T> c0003a) {
        if (!f7872a) {
            if (c0003a == null) {
                throw new AssertionError();
            }
        }
        this.f7874c = c0003a;
    }

    /* renamed from: a */
    public T mo1a() {
        T t = this.f7875d;
        if (t == f7873b) {
            synchronized (this) {
                t = this.f7875d;
                if (t == f7873b) {
                    t = this.f7874c.mo1a();
                    T t2 = this.f7875d;
                    if (t2 != f7873b) {
                        if (t2 != t) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Scoped provider was invoked recursively returning different results: ");
                            stringBuilder.append(t2);
                            stringBuilder.append(" & ");
                            stringBuilder.append(t);
                            stringBuilder.append(". This is likely due to a circular dependency.");
                            throw new IllegalStateException(stringBuilder.toString());
                        }
                    }
                    this.f7875d = t;
                    this.f7874c = null;
                }
            }
        }
        return t;
    }

    /* renamed from: a */
    public static <P extends C0003a<T>, T> C0003a<T> m9025a(P p) {
        C0000d.m0a(p);
        if (p instanceof C3085b) {
            return p;
        }
        return new C3085b(p);
    }

    /* renamed from: b */
    public static <P extends C0003a<T>, T> C0002a<T> m9026b(P p) {
        if (p instanceof C0002a) {
            return (C0002a) p;
        }
        return new C3085b((C0003a) C0000d.m0a(p));
    }
}
