package p289e.p302h;

import java.util.ArrayList;
import java.util.List;
import p289e.C5974e.C7335a;
import p289e.p290a.C5903b;
import p289e.p291b.C5914b;
import p289e.p292c.p293a.C5937h;
import p289e.p302h.C8154e.C7358b;

/* compiled from: BehaviorSubject */
/* renamed from: e.h.a */
public final class C8149a<T> extends C7356d<T, T> {
    /* renamed from: b */
    private static final Object[] f30311b = new Object[0];
    /* renamed from: c */
    private final C8154e<T> f30312c;

    /* renamed from: b */
    public static <T> C8149a<T> m39535b() {
        return C8149a.m39534a(null, false);
    }

    /* renamed from: a */
    private static <T> C8149a<T> m39534a(T t, boolean z) {
        final Object c8154e = new C8154e();
        if (z) {
            c8154e.m39554a(C5937h.m24848a((Object) t));
        }
        c8154e.f30323d = new C5914b<C7358b<T>>() {
            /* renamed from: b */
            public /* synthetic */ void mo4974b(Object obj) {
                m33746a((C7358b) obj);
            }

            /* renamed from: a */
            public void m33746a(C7358b<T> c7358b) {
                c7358b.m33758c(c8154e.m39551a());
            }
        };
        c8154e.f30324e = c8154e.f30323d;
        return new C8149a(c8154e, c8154e);
    }

    protected C8149a(C7335a<T> c7335a, C8154e<T> c8154e) {
        super(c7335a);
        this.f30312c = c8154e;
    }

    public void L_() {
        if (this.f30312c.m39551a() == null || this.f30312c.f30321b) {
            Object a = C5937h.m24847a();
            for (C7358b b : this.f30312c.m39559d(a)) {
                b.m33757b(a);
            }
        }
    }

    /* renamed from: a */
    public void mo5001a(Throwable th) {
        if (this.f30312c.m39551a() == null || this.f30312c.f30321b) {
            th = C5937h.m24849a(th);
            List list = null;
            for (C7358b b : this.f30312c.m39559d(th)) {
                try {
                    b.m33757b(th);
                } catch (Throwable th2) {
                    if (list == null) {
                        list = new ArrayList();
                    }
                    list.add(th2);
                }
            }
            C5903b.m24793a(list);
        }
    }

    /* renamed from: a */
    public void mo5000a(T t) {
        if (this.f30312c.m39551a() == null || this.f30312c.f30321b) {
            t = C5937h.m24848a((Object) t);
            for (C7358b b : this.f30312c.m39558c(t)) {
                b.m33757b(t);
            }
        }
    }
}
