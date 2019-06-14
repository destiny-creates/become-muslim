package p289e;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import p289e.C7332c.C5922a;
import p289e.p290a.C5903b;
import p289e.p290a.C5906e;
import p289e.p291b.C5913a;
import p289e.p291b.C5914b;
import p289e.p291b.C5915c;
import p289e.p291b.C5916d;
import p289e.p291b.C5918f;
import p289e.p291b.C5919g;
import p289e.p291b.C5920h;
import p289e.p292c.p293a.C7262b;
import p289e.p292c.p293a.C8096f;
import p289e.p292c.p293a.C8097g;
import p289e.p292c.p293a.C8099i;
import p289e.p292c.p293a.C8101k;
import p289e.p292c.p293a.C8104l;
import p289e.p292c.p293a.C8106m;
import p289e.p292c.p293a.C8107n;
import p289e.p292c.p293a.C8109o;
import p289e.p292c.p293a.C8111p;
import p289e.p292c.p293a.C8113q;
import p289e.p292c.p293a.C8114r;
import p289e.p292c.p293a.C8115s;
import p289e.p292c.p293a.C8116t;
import p289e.p292c.p293a.C8117u;
import p289e.p292c.p293a.C8119v;
import p289e.p292c.p293a.C8126x;
import p289e.p292c.p293a.C8127y;
import p289e.p292c.p293a.aa;
import p289e.p292c.p293a.ab;
import p289e.p292c.p293a.ac;
import p289e.p292c.p293a.ad;
import p289e.p292c.p293a.ae;
import p289e.p292c.p293a.af;
import p289e.p292c.p293a.ag;
import p289e.p292c.p293a.ai;
import p289e.p292c.p293a.aj;
import p289e.p292c.p293a.ak;
import p289e.p292c.p293a.al;
import p289e.p292c.p293a.am;
import p289e.p292c.p293a.an;
import p289e.p292c.p293a.ao;
import p289e.p292c.p293a.ap;
import p289e.p292c.p293a.aq;
import p289e.p292c.p293a.ar;
import p289e.p292c.p293a.as;
import p289e.p292c.p293a.at;
import p289e.p292c.p293a.au;
import p289e.p292c.p293a.av;
import p289e.p292c.p293a.aw;
import p289e.p292c.p293a.ax;
import p289e.p292c.p293a.ay;
import p289e.p292c.p293a.az;
import p289e.p292c.p293a.ba;
import p289e.p292c.p293a.bb;
import p289e.p292c.p293a.bc;
import p289e.p292c.p293a.bd;
import p289e.p292c.p293a.be;
import p289e.p292c.p295e.C5961e;
import p289e.p292c.p295e.C5967n;
import p289e.p292c.p295e.C7311a;
import p289e.p292c.p295e.C7322j;
import p289e.p292c.p295e.C7328l;
import p289e.p292c.p295e.C8139b;
import p289e.p292c.p295e.C8140g;
import p289e.p298d.C5969a;
import p289e.p298d.C7333b;
import p289e.p298d.C7334c;
import p289e.p299e.C8145b;
import p289e.p300f.C5977c;
import p289e.p301g.C5983a;

/* compiled from: Observable */
/* renamed from: e.e */
public class C5974e<T> {
    /* renamed from: a */
    final C7335a<T> f19749a;

    /* compiled from: Observable */
    /* renamed from: e.e$a */
    public interface C7335a<T> extends C5914b<C7367k<? super T>> {
    }

    /* compiled from: Observable */
    /* renamed from: e.e$b */
    public interface C7336b<R, T> extends C5919g<C7367k<? super R>, C7367k<? super T>> {
    }

    /* compiled from: Observable */
    /* renamed from: e.e$c */
    public interface C7337c<T, R> extends C5919g<C5974e<T>, C5974e<R>> {
    }

    protected C5974e(C7335a<T> c7335a) {
        this.f19749a = c7335a;
    }

    /* renamed from: a */
    public static <T> C5974e<T> m24970a(C5914b<C7332c<T>> c5914b, C5922a c5922a) {
        return C5974e.m24972a(new C8106m(c5914b, c5922a));
    }

    /* renamed from: a */
    public static <T> C5974e<T> m24972a(C7335a<T> c7335a) {
        return new C5974e(C5977c.m25060a((C7335a) c7335a));
    }

    /* renamed from: a */
    public final <R> C5974e<R> m24997a(C7336b<? extends R, ? super T> c7336b) {
        return C5974e.m24972a(new C8117u(this.f19749a, c7336b));
    }

    /* renamed from: a */
    public <R> C5974e<R> m24998a(C7337c<? super T, ? extends R> c7337c) {
        return (C5974e) c7337c.mo4976a(this);
    }

    /* renamed from: d */
    public C5988i<T> m25027d() {
        return new C5988i(aa.m39091a(this));
    }

    /* renamed from: e */
    public C5912a m25028e() {
        return C5912a.m24803a(this);
    }

    /* renamed from: a */
    public static <T> C5974e<T> m24974a(C5974e<? extends T> c5974e, C5974e<? extends T> c5974e2) {
        return C5974e.m24972a(C8099i.m39381a(c5974e, c5974e2));
    }

    /* renamed from: a */
    public static <T> C5974e<T> m24973a(C5974e<? extends C5974e<? extends T>> c5974e) {
        return c5974e.m24996a(C5967n.m24947b());
    }

    /* renamed from: b */
    public static <T> C5974e<T> m24983b(C5974e<? extends T> c5974e, C5974e<? extends T> c5974e2) {
        return C5974e.m24973a(C5974e.m24977a((Object) c5974e, (Object) c5974e2));
    }

    /* renamed from: a */
    public static <T> C5974e<T> m24971a(C5918f<C5974e<T>> c5918f) {
        return C5974e.m24972a(new C8107n(c5918f));
    }

    /* renamed from: f */
    public static <T> C5974e<T> m24988f() {
        return C8096f.m39370a();
    }

    /* renamed from: b */
    public static <T> C5974e<T> m24984b(Throwable th) {
        return C5974e.m24972a(new ac(th));
    }

    /* renamed from: a */
    public static <T> C5974e<T> m24976a(Iterable<? extends T> iterable) {
        return C5974e.m24972a(new C8116t(iterable));
    }

    /* renamed from: a */
    public static <T> C5974e<T> m24980a(T[] tArr) {
        int length = tArr.length;
        if (length == 0) {
            return C5974e.m24988f();
        }
        if (length == 1) {
            return C5974e.m24987c(tArr[0]);
        }
        return C5974e.m24972a(new C8114r(tArr));
    }

    /* renamed from: a */
    public static <T> C5974e<T> m24978a(Callable<? extends T> callable) {
        return C5974e.m24972a(new C8115s(callable));
    }

    /* renamed from: a */
    public static C5974e<Long> m24967a(long j, long j2, TimeUnit timeUnit, C5986h c5986h) {
        return C5974e.m24972a(new ag(j, j2, timeUnit, c5986h));
    }

    /* renamed from: c */
    public static <T> C5974e<T> m24987c(T t) {
        return C7328l.m33687a(t);
    }

    /* renamed from: a */
    public static <T> C5974e<T> m24977a(T t, T t2) {
        return C5974e.m24980a(new Object[]{t, t2});
    }

    /* renamed from: b */
    public static <T> C5974e<T> m24982b(C5974e<? extends C5974e<? extends T>> c5974e) {
        if (c5974e.getClass() == C7328l.class) {
            return ((C7328l) c5974e).m33691l(C5967n.m24947b());
        }
        return c5974e.m24997a(ap.m39206a(false));
    }

    /* renamed from: c */
    public static <T> C5974e<T> m24986c(C5974e<? extends T> c5974e, C5974e<? extends T> c5974e2) {
        return C5974e.m24979a(new C5974e[]{c5974e, c5974e2});
    }

    /* renamed from: a */
    public static <T> C5974e<T> m24975a(C5974e<? extends T> c5974e, C5974e<? extends T> c5974e2, C5974e<? extends T> c5974e3) {
        return C5974e.m24979a(new C5974e[]{c5974e, c5974e2, c5974e3});
    }

    /* renamed from: a */
    public static <T> C5974e<T> m24979a(C5974e<? extends T>[] c5974eArr) {
        return C5974e.m24982b(C5974e.m24980a((Object[]) c5974eArr));
    }

    /* renamed from: g */
    public static <T> C5974e<T> m24989g() {
        return C8097g.m39373a();
    }

    /* renamed from: c */
    public static <T> C5974e<T> m24985c(C5974e<? extends C5974e<? extends T>> c5974e) {
        return c5974e.m24997a(aw.m39288a(false));
    }

    /* renamed from: a */
    public static C5974e<Long> m24968a(long j, TimeUnit timeUnit) {
        return C5974e.m24969a(j, timeUnit, C5983a.m25109b());
    }

    /* renamed from: a */
    public static C5974e<Long> m24969a(long j, TimeUnit timeUnit, C5986h c5986h) {
        return C5974e.m24972a(new af(j, timeUnit, c5986h));
    }

    /* renamed from: h */
    public final C5974e<T> m25036h() {
        return C7262b.m33563h(this);
    }

    /* renamed from: b */
    public final C5974e<T> m25008b(int i) {
        return C7262b.m33562a(this, i);
    }

    /* renamed from: a */
    public final <R> C5974e<R> m25003a(Class<R> cls) {
        return m24997a(new ai(cls));
    }

    /* renamed from: a */
    public final <R> C5974e<R> m24993a(C5918f<R> c5918f, C5915c<R, ? super T> c5915c) {
        return C5974e.m24972a(new C8101k(this, c5918f, c5915c));
    }

    /* renamed from: a */
    public final <R> C5974e<R> m24996a(C5919g<? super T, ? extends C5974e<? extends R>> c5919g) {
        if (this instanceof C7328l) {
            return ((C7328l) this).m33691l(c5919g);
        }
        return C5974e.m24972a(new C8104l(this, c5919g, 2, 0));
    }

    /* renamed from: i */
    public final C5974e<Integer> m25038i() {
        return m25004a(Integer.valueOf(0), C5961e.f19715e);
    }

    /* renamed from: b */
    public final C5974e<T> m25009b(long j, TimeUnit timeUnit, C5986h c5986h) {
        return m24997a(new aj(j, timeUnit, c5986h));
    }

    /* renamed from: d */
    public final C5974e<T> m25025d(C5974e<? extends T> c5974e) {
        if (c5974e != null) {
            return C5974e.m24972a(new ab(this, c5974e));
        }
        throw new NullPointerException("alternate is null");
    }

    /* renamed from: c */
    public final C5974e<T> m25017c(long j, TimeUnit timeUnit, C5986h c5986h) {
        return m24997a(new ak(j, timeUnit, c5986h));
    }

    /* renamed from: e */
    public final <U> C5974e<T> m25031e(C5974e<U> c5974e) {
        if (c5974e != null) {
            return C5974e.m24972a(new C8109o(this, c5974e));
        }
        throw new NullPointerException();
    }

    /* renamed from: j */
    public final C5974e<T> m25040j() {
        return m24997a(al.m39149a());
    }

    /* renamed from: a */
    public final C5974e<T> m24992a(C5914b<? super Throwable> c5914b) {
        return C5974e.m24972a(new C8111p(this, new C7311a(C5916d.m24828a(), c5914b, C5916d.m24828a())));
    }

    /* renamed from: b */
    public final C5974e<T> m25011b(C5914b<? super T> c5914b) {
        return C5974e.m24972a(new C8111p(this, new C7311a(c5914b, C5916d.m24828a(), C5916d.m24828a())));
    }

    /* renamed from: a */
    public final C5974e<T> m24991a(C5913a c5913a) {
        return m24997a(new am(c5913a));
    }

    /* renamed from: b */
    public final C5974e<T> m25010b(C5913a c5913a) {
        return C5974e.m24972a(new C8111p(this, new C7311a(C5916d.m24828a(), C5916d.m24827a(c5913a), c5913a)));
    }

    /* renamed from: c */
    public final C5974e<T> m25018c(C5913a c5913a) {
        return m24997a(new an(c5913a));
    }

    /* renamed from: b */
    public final C5974e<T> m25013b(C5919g<? super T, Boolean> c5919g) {
        return C5974e.m24972a(new C8113q(this, c5919g));
    }

    /* renamed from: k */
    public final C5974e<T> m25042k() {
        return m25029e(1).m25046n();
    }

    /* renamed from: c */
    public final <R> C5974e<R> m25019c(C5919g<? super T, ? extends C5974e<? extends R>> c5919g) {
        if (getClass() == C7328l.class) {
            return ((C7328l) this).m33691l(c5919g);
        }
        return C5974e.m24982b(m25030e((C5919g) c5919g));
    }

    /* renamed from: d */
    public final <K> C5974e<C7334c<K, T>> m25024d(C5919g<? super T, ? extends K> c5919g) {
        return m24997a(new ao(c5919g));
    }

    /* renamed from: e */
    public final <R> C5974e<R> m25030e(C5919g<? super T, ? extends R> c5919g) {
        return C5974e.m24972a(new C8119v(this, c5919g));
    }

    /* renamed from: f */
    public final C5974e<T> m25033f(C5974e<? extends T> c5974e) {
        return C5974e.m24986c(this, c5974e);
    }

    /* renamed from: a */
    public final C5974e<T> m24999a(C5986h c5986h) {
        return m25000a(c5986h, C7322j.f25717b);
    }

    /* renamed from: a */
    public final C5974e<T> m25000a(C5986h c5986h, int i) {
        return m25002a(c5986h, false, i);
    }

    /* renamed from: a */
    public final C5974e<T> m25002a(C5986h c5986h, boolean z, int i) {
        if (this instanceof C7328l) {
            return ((C7328l) this).m33690d(c5986h);
        }
        return m24997a(new aq(c5986h, z, i));
    }

    /* renamed from: l */
    public final C7333b<T> m25044l() {
        return ar.m39234h(this);
    }

    /* renamed from: f */
    public final <R> C5974e<R> m25032f(C5919g<? super C5974e<T>, ? extends C5974e<R>> c5919g) {
        return ar.m39232a(this, c5919g);
    }

    /* renamed from: a */
    public final <R> C5974e<R> m25004a(R r, C5920h<R, ? super T, R> c5920h) {
        return C5974e.m24972a(new C8127y(this, r, c5920h));
    }

    /* renamed from: g */
    public final C5974e<T> m25034g(C5919g<? super C5974e<? extends Void>, ? extends C5974e<?>> c5919g) {
        return C8126x.m39471b(this, C5961e.m24930a(c5919g));
    }

    /* renamed from: c */
    public final C7333b<T> m25016c(int i) {
        return as.m39249a(this, i);
    }

    /* renamed from: m */
    public final C5974e<T> m25045m() {
        return C8126x.m39469a(this);
    }

    /* renamed from: n */
    public final C5974e<T> m25046n() {
        return m24997a(at.m39256a());
    }

    /* renamed from: d */
    public final C5974e<T> m25022d(int i) {
        return m24997a(new au(i));
    }

    /* renamed from: d */
    public final C5974e<T> m25026d(T t) {
        return C5974e.m24983b(C5974e.m24987c((Object) t), this);
    }

    /* renamed from: o */
    public final C5989l m25047o() {
        return m25015b(new C8139b(C5916d.m24828a(), C5961e.f19717g, C5916d.m24828a()));
    }

    /* renamed from: c */
    public final C5989l m25021c(C5914b<? super T> c5914b) {
        if (c5914b != null) {
            return m25015b(new C8139b(c5914b, C5961e.f19717g, C5916d.m24828a()));
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    /* renamed from: a */
    public final C5989l m25005a(C5914b<? super T> c5914b, C5914b<Throwable> c5914b2) {
        if (c5914b == null) {
            throw new IllegalArgumentException("onNext can not be null");
        } else if (c5914b2 != null) {
            return m25015b(new C8139b(c5914b, c5914b2, C5916d.m24828a()));
        } else {
            throw new IllegalArgumentException("onError can not be null");
        }
    }

    /* renamed from: a */
    public final C5989l m25006a(C5982f<? super T> c5982f) {
        if (c5982f instanceof C7367k) {
            return m25015b((C7367k) c5982f);
        }
        if (c5982f != null) {
            return m25015b(new C8140g(c5982f));
        }
        throw new NullPointerException("observer is null");
    }

    /* renamed from: a */
    public final C5989l m25007a(C7367k<? super T> c7367k) {
        try {
            c7367k.mo6323c();
            C5977c.m25061a(this, this.f19749a).mo4974b(c7367k);
            return C5977c.m25066a((C5989l) c7367k);
        } catch (C7367k<? super T> c7367k2) {
            C5903b.m24794b(c7367k2);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error occurred attempting to subscribe [");
            stringBuilder.append(th.getMessage());
            stringBuilder.append("] and then again while trying to pass to onError.");
            C5977c.m25074c(new C5906e(stringBuilder.toString(), c7367k2));
        }
    }

    /* renamed from: b */
    public final C5989l m25015b(C7367k<? super T> c7367k) {
        return C5974e.m24981a((C7367k) c7367k, this);
    }

    /* renamed from: a */
    static <T> C5989l m24981a(C7367k<? super T> c7367k, C5974e<T> c5974e) {
        C5989l c8145b;
        if (c7367k == null) {
            throw new IllegalArgumentException("subscriber can not be null");
        } else if (c5974e.f19749a != null) {
            c7367k.mo6323c();
            if (!(c7367k instanceof C8145b)) {
                c8145b = new C8145b(c7367k);
            }
            try {
                C5977c.m25061a((C5974e) c5974e, c5974e.f19749a).mo4974b(c8145b);
                return C5977c.m25066a(c8145b);
            } catch (C7367k<? super T> c7367k2) {
                C5903b.m24794b(c7367k2);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Error occurred attempting to subscribe [");
                stringBuilder.append(c5974e.getMessage());
                stringBuilder.append("] and then again while trying to pass to onError.");
                C5977c.m25074c(new C5906e(stringBuilder.toString(), c7367k2));
            }
        } else {
            throw new IllegalStateException("onSubscribe function can not be null.");
        }
    }

    /* renamed from: b */
    public final C5974e<T> m25014b(C5986h c5986h) {
        return m25001a(c5986h, !(this.f19749a instanceof C8106m));
    }

    /* renamed from: a */
    public final C5974e<T> m25001a(C5986h c5986h, boolean z) {
        if (this instanceof C7328l) {
            return ((C7328l) this).m33690d(c5986h);
        }
        return C5974e.m24972a(new av(this, c5986h, z));
    }

    /* renamed from: h */
    public final <R> C5974e<R> m25037h(C5919g<? super T, ? extends C5974e<? extends R>> c5919g) {
        return C5974e.m24985c(m25030e((C5919g) c5919g));
    }

    /* renamed from: e */
    public final C5974e<T> m25029e(int i) {
        return m24997a(new ax(i));
    }

    /* renamed from: d */
    public final C5974e<T> m25023d(long j, TimeUnit timeUnit, C5986h c5986h) {
        return m24997a(new ay(j, timeUnit, c5986h));
    }

    /* renamed from: i */
    public final C5974e<T> m25039i(C5919g<? super T, Boolean> c5919g) {
        return m25013b((C5919g) c5919g).m25029e(1);
    }

    /* renamed from: g */
    public final <E> C5974e<T> m25035g(C5974e<? extends E> c5974e) {
        return m24997a(new az(c5974e));
    }

    /* renamed from: j */
    public final C5974e<T> m25041j(C5919g<? super T, Boolean> c5919g) {
        return m24997a(new bb((C5919g) c5919g));
    }

    /* renamed from: k */
    public final C5974e<T> m25043k(C5919g<? super T, Boolean> c5919g) {
        return m24997a(new ba(c5919g));
    }

    /* renamed from: a */
    public final <U, V> C5974e<T> m24994a(C5918f<? extends C5974e<U>> c5918f, C5919g<? super T, ? extends C5974e<V>> c5919g) {
        return m24995a((C5918f) c5918f, (C5919g) c5919g, null);
    }

    /* renamed from: a */
    public final <U, V> C5974e<T> m24995a(C5918f<? extends C5974e<U>> c5918f, C5919g<? super T, ? extends C5974e<V>> c5919g, C5974e<? extends T> c5974e) {
        if (c5919g != null) {
            return C5974e.m24972a(new ad(this, c5918f != null ? C5974e.m24971a((C5918f) c5918f) : null, c5919g, c5974e));
        }
        throw new NullPointerException("timeoutSelector is null");
    }

    /* renamed from: a */
    public final C5974e<T> m24990a(long j, TimeUnit timeUnit, C5974e<? extends T> c5974e, C5986h c5986h) {
        return C5974e.m24972a(new ae(this, j, timeUnit, c5986h, c5974e));
    }

    /* renamed from: p */
    public final C5969a<T> m25048p() {
        return C5969a.m24948a(this);
    }

    /* renamed from: q */
    public final C5974e<List<T>> m25049q() {
        return m24997a(bc.m39324a());
    }

    /* renamed from: c */
    public final C5974e<T> m25020c(C5986h c5986h) {
        return m24997a(new bd(c5986h));
    }

    /* renamed from: b */
    public final <TClosing> C5974e<C5974e<T>> m25012b(C5918f<? extends C5974e<? extends TClosing>> c5918f) {
        return m24997a(new be(c5918f));
    }
}
