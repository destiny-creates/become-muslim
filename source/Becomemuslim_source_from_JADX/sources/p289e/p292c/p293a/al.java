package p289e.p292c.p293a;

import p289e.C5974e.C7336b;
import p289e.C7367k;
import p289e.p290a.C5903b;
import p289e.p291b.C5919g;
import p289e.p291b.C5920h;
import p289e.p292c.p295e.C5967n;

/* compiled from: OperatorDistinctUntilChanged */
/* renamed from: e.c.a.al */
public final class al<T, U> implements C5920h<U, U, Boolean>, C7336b<T, T> {
    /* renamed from: a */
    final C5919g<? super T, ? extends U> f29951a;
    /* renamed from: b */
    final C5920h<? super U, ? super U, Boolean> f29952b = this;

    /* compiled from: OperatorDistinctUntilChanged */
    /* renamed from: e.c.a.al$a */
    static final class C5925a {
        /* renamed from: a */
        static final al<?, ?> f19646a = new al(C5967n.m24947b());
    }

    /* renamed from: a */
    public /* synthetic */ Object mo5126a(Object obj, Object obj2) {
        return m39153b(obj, obj2);
    }

    /* renamed from: a */
    public static <T> al<T, T> m39149a() {
        return C5925a.f19646a;
    }

    public al(C5919g<? super T, ? extends U> c5919g) {
        this.f29951a = c5919g;
    }

    /* renamed from: b */
    public Boolean m39153b(U u, U u2) {
        if (u != u2) {
            if (u == null || u.equals(u2) == null) {
                u = null;
                return Boolean.valueOf(u);
            }
        }
        u = true;
        return Boolean.valueOf(u);
    }

    /* renamed from: a */
    public C7367k<? super T> m39150a(final C7367k<? super T> c7367k) {
        return new C7367k<T>(this, c7367k) {
            /* renamed from: a */
            U f29947a;
            /* renamed from: b */
            boolean f29948b;
            /* renamed from: d */
            final /* synthetic */ al f29950d;

            /* renamed from: a */
            public void mo5000a(T t) {
                try {
                    Object a = this.f29950d.f29951a.mo4976a(t);
                    Object obj = this.f29947a;
                    this.f29947a = a;
                    if (this.f29948b) {
                        try {
                            if (((Boolean) this.f29950d.f29952b.mo5126a(obj, a)).booleanValue()) {
                                m33779a(1);
                            } else {
                                c7367k.mo5000a((Object) t);
                            }
                        } catch (T t2) {
                            C5903b.m24790a(t2, c7367k, a);
                            return;
                        }
                    }
                    this.f29948b = true;
                    c7367k.mo5000a((Object) t2);
                } catch (Throwable th) {
                    C5903b.m24790a(th, c7367k, t2);
                }
            }

            /* renamed from: a */
            public void mo5001a(Throwable th) {
                c7367k.mo5001a(th);
            }

            public void L_() {
                c7367k.L_();
            }
        };
    }
}
