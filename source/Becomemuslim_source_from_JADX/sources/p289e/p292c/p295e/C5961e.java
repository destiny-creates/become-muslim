package p289e.p292c.p295e;

import java.util.List;
import p289e.C5970d;
import p289e.C5974e;
import p289e.C5974e.C7336b;
import p289e.p290a.C5907f;
import p289e.p291b.C5914b;
import p289e.p291b.C5919g;
import p289e.p291b.C5920h;
import p289e.p292c.p293a.ah;

/* compiled from: InternalObservableUtils */
/* renamed from: e.c.e.e */
public enum C5961e {
    ;
    
    /* renamed from: a */
    public static final C7318e f19711a = null;
    /* renamed from: b */
    public static final C7316c f19712b = null;
    /* renamed from: c */
    public static final C7321h f19713c = null;
    /* renamed from: d */
    static final C7320g f19714d = null;
    /* renamed from: e */
    public static final C7317d f19715e = null;
    /* renamed from: f */
    static final C7315b f19716f = null;
    /* renamed from: g */
    public static final C5914b<Throwable> f19717g = null;
    /* renamed from: h */
    public static final C7336b<Boolean, Object> f19718h = null;

    /* compiled from: InternalObservableUtils */
    /* renamed from: e.c.e.e$a */
    static final class C7314a implements C5914b<Throwable> {
        C7314a() {
        }

        /* renamed from: b */
        public /* synthetic */ void mo4974b(Object obj) {
            m33657a((Throwable) obj);
        }

        /* renamed from: a */
        public void m33657a(Throwable th) {
            throw new C5907f(th);
        }
    }

    /* compiled from: InternalObservableUtils */
    /* renamed from: e.c.e.e$b */
    static final class C7315b implements C5919g<C5970d<?>, Throwable> {
        C7315b() {
        }

        /* renamed from: a */
        public Throwable m33660a(C5970d<?> c5970d) {
            return c5970d.m24954b();
        }
    }

    /* compiled from: InternalObservableUtils */
    /* renamed from: e.c.e.e$c */
    static final class C7316c implements C5920h<Object, Object, Boolean> {
        C7316c() {
        }

        /* renamed from: a */
        public /* synthetic */ Object mo5126a(Object obj, Object obj2) {
            return m33662b(obj, obj2);
        }

        /* renamed from: b */
        public Boolean m33662b(Object obj, Object obj2) {
            if (obj != obj2) {
                if (obj == null || obj.equals(obj2) == null) {
                    obj = null;
                    return Boolean.valueOf(obj);
                }
            }
            obj = true;
            return Boolean.valueOf(obj);
        }
    }

    /* compiled from: InternalObservableUtils */
    /* renamed from: e.c.e.e$d */
    static final class C7317d implements C5920h<Integer, Object, Integer> {
        C7317d() {
        }

        /* renamed from: a */
        public Integer m33663a(Integer num, Object obj) {
            return Integer.valueOf(num.intValue() + 1);
        }
    }

    /* compiled from: InternalObservableUtils */
    /* renamed from: e.c.e.e$e */
    static final class C7318e implements C5920h<Long, Object, Long> {
        C7318e() {
        }

        /* renamed from: a */
        public Long m33665a(Long l, Object obj) {
            return Long.valueOf(l.longValue() + 1);
        }
    }

    /* compiled from: InternalObservableUtils */
    /* renamed from: e.c.e.e$f */
    static final class C7319f implements C5919g<C5974e<? extends C5970d<?>>, C5974e<?>> {
        /* renamed from: a */
        final C5919g<? super C5974e<? extends Void>, ? extends C5974e<?>> f25716a;

        public C7319f(C5919g<? super C5974e<? extends Void>, ? extends C5974e<?>> c5919g) {
            this.f25716a = c5919g;
        }

        /* renamed from: a */
        public C5974e<?> m33667a(C5974e<? extends C5970d<?>> c5974e) {
            return (C5974e) this.f25716a.mo4976a(c5974e.m25030e(C5961e.f19714d));
        }
    }

    /* compiled from: InternalObservableUtils */
    /* renamed from: e.c.e.e$g */
    static final class C7320g implements C5919g<Object, Void> {
        /* renamed from: b */
        public Void m33670b(Object obj) {
            return null;
        }

        C7320g() {
        }

        /* renamed from: a */
        public /* synthetic */ Object mo4976a(Object obj) {
            return m33670b(obj);
        }
    }

    /* compiled from: InternalObservableUtils */
    /* renamed from: e.c.e.e$h */
    static final class C7321h implements C5919g<List<? extends C5974e<?>>, C5974e<?>[]> {
        C7321h() {
        }

        /* renamed from: a */
        public C5974e<?>[] m33672a(List<? extends C5974e<?>> list) {
            return (C5974e[]) list.toArray(new C5974e[list.size()]);
        }
    }

    static {
        f19711a = new C7318e();
        f19712b = new C7316c();
        f19713c = new C7321h();
        f19714d = new C7320g();
        f19715e = new C7317d();
        f19716f = new C7315b();
        f19717g = new C7314a();
        f19718h = new ah(C5967n.m24946a(), true);
    }

    /* renamed from: a */
    public static C5919g<C5974e<? extends C5970d<?>>, C5974e<?>> m24930a(C5919g<? super C5974e<? extends Void>, ? extends C5974e<?>> c5919g) {
        return new C7319f(c5919g);
    }
}
