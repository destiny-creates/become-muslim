package p289e.p292c.p293a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;
import p289e.C5974e;
import p289e.C5974e.C7336b;
import p289e.C5984g;
import p289e.C5989l;
import p289e.C7367k;
import p289e.p290a.C5902a;
import p289e.p291b.C5913a;
import p289e.p292c.p295e.C7322j;
import p289e.p292c.p295e.p296a.C5954f;
import p289e.p300f.C5977c;
import p289e.p303i.C5987e;
import p289e.p303i.C7364d;

/* compiled from: OperatorSwitch */
/* renamed from: e.c.a.aw */
public final class aw<T> implements C7336b<T, C5974e<? extends T>> {
    /* renamed from: a */
    final boolean f30104a;

    /* compiled from: OperatorSwitch */
    /* renamed from: e.c.a.aw$a */
    static final class C5931a {
        /* renamed from: a */
        static final aw<Object> f19652a = new aw(false);
    }

    /* compiled from: OperatorSwitch */
    /* renamed from: e.c.a.aw$b */
    static final class C5932b {
        /* renamed from: a */
        static final aw<Object> f19653a = new aw(true);
    }

    /* compiled from: OperatorSwitch */
    /* renamed from: e.c.a.aw$c */
    static final class C8077c<T> extends C7367k<T> {
        /* renamed from: a */
        private final long f30089a;
        /* renamed from: b */
        private final C8078d<T> f30090b;

        C8077c(long j, C8078d<T> c8078d) {
            this.f30089a = j;
            this.f30090b = c8078d;
        }

        /* renamed from: a */
        public void mo6324a(C5984g c5984g) {
            this.f30090b.m39275a(c5984g, this.f30089a);
        }

        /* renamed from: a */
        public void mo5000a(T t) {
            this.f30090b.m39277a((Object) t, this);
        }

        /* renamed from: a */
        public void mo5001a(Throwable th) {
            this.f30090b.m39279a(th, this.f30089a);
        }

        public void L_() {
            this.f30090b.mo6325b(this.f30089a);
        }
    }

    /* compiled from: OperatorSwitch */
    /* renamed from: e.c.a.aw$d */
    static final class C8078d<T> extends C7367k<C5974e<? extends T>> {
        /* renamed from: m */
        static final Throwable f30091m = new Throwable("Terminal error");
        /* renamed from: a */
        final C7367k<? super T> f30092a;
        /* renamed from: b */
        final C7364d f30093b = new C7364d();
        /* renamed from: c */
        final boolean f30094c;
        /* renamed from: d */
        final AtomicLong f30095d;
        /* renamed from: e */
        final C5954f<Object> f30096e;
        /* renamed from: f */
        boolean f30097f;
        /* renamed from: g */
        boolean f30098g;
        /* renamed from: h */
        long f30099h;
        /* renamed from: i */
        C5984g f30100i;
        /* renamed from: j */
        volatile boolean f30101j;
        /* renamed from: k */
        Throwable f30102k;
        /* renamed from: l */
        boolean f30103l;

        /* compiled from: OperatorSwitch */
        /* renamed from: e.c.a.aw$d$1 */
        class C72571 implements C5913a {
            /* renamed from: a */
            final /* synthetic */ C8078d f25557a;

            C72571(C8078d c8078d) {
                this.f25557a = c8078d;
            }

            /* renamed from: a */
            public void mo4985a() {
                this.f25557a.m39286e();
            }
        }

        /* compiled from: OperatorSwitch */
        /* renamed from: e.c.a.aw$d$2 */
        class C72582 implements C5984g {
            /* renamed from: a */
            final /* synthetic */ C8078d f25558a;

            C72582(C8078d c8078d) {
                this.f25558a = c8078d;
            }

            /* renamed from: a */
            public void mo5119a(long j) {
                int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                if (i > 0) {
                    this.f25558a.m39283c(j);
                } else if (i < 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("n >= 0 expected but it was ");
                    stringBuilder.append(j);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
        }

        C8078d(C7367k<? super T> c7367k, boolean z) {
            this.f30092a = c7367k;
            this.f30094c = z;
            this.f30095d = new AtomicLong();
            this.f30096e = new C5954f(C7322j.f25717b);
        }

        /* renamed from: d */
        void m39285d() {
            this.f30092a.m33781a(this.f30093b);
            this.f30092a.m33781a(C5987e.m25118a(new C72571(this)));
            this.f30092a.mo6324a(new C72582(this));
        }

        /* renamed from: e */
        void m39286e() {
            synchronized (this) {
                this.f30100i = null;
            }
        }

        /* renamed from: a */
        public void m39274a(C5974e<? extends T> c5974e) {
            C7367k c8077c;
            long incrementAndGet = this.f30095d.incrementAndGet();
            C5989l c = this.f30093b.m33772c();
            if (c != null) {
                c.U_();
            }
            synchronized (this) {
                c8077c = new C8077c(incrementAndGet, this);
                this.f30103l = true;
                this.f30100i = null;
            }
            this.f30093b.m33770a(c8077c);
            c5974e.m25007a(c8077c);
        }

        /* renamed from: a */
        public void mo5001a(Throwable th) {
            synchronized (this) {
                boolean b = m39282b(th);
            }
            if (b) {
                this.f30101j = true;
                m39287f();
                return;
            }
            m39284c(th);
        }

        /* renamed from: b */
        boolean m39282b(Throwable th) {
            Throwable th2 = this.f30102k;
            if (th2 == f30091m) {
                return false;
            }
            if (th2 == null) {
                this.f30102k = th;
            } else if (th2 instanceof C5902a) {
                Collection arrayList = new ArrayList(((C5902a) th2).m24787a());
                arrayList.add(th);
                this.f30102k = new C5902a(arrayList);
            } else {
                this.f30102k = new C5902a(th2, th);
            }
            return true;
        }

        public void L_() {
            this.f30101j = true;
            m39287f();
        }

        /* renamed from: a */
        void m39277a(T t, C8077c<T> c8077c) {
            synchronized (this) {
                if (this.f30095d.get() != c8077c.f30089a) {
                    return;
                }
                this.f30096e.m24904a((Object) c8077c, C5937h.m24848a((Object) t));
                m39287f();
            }
        }

        /* renamed from: a */
        void m39279a(Throwable th, long j) {
            synchronized (this) {
                if (this.f30095d.get() == j) {
                    j = m39282b(th);
                    this.f30103l = false;
                    this.f30100i = null;
                } else {
                    j = 1;
                }
            }
            if (j != null) {
                m39287f();
            } else {
                m39284c(th);
            }
        }

        /* renamed from: b */
        void mo6325b(long j) {
            synchronized (this) {
                if (this.f30095d.get() != j) {
                    return;
                }
                this.f30103l = 0;
                this.f30100i = 0;
                m39287f();
            }
        }

        /* renamed from: c */
        void m39284c(Throwable th) {
            C5977c.m25068a(th);
        }

        /* renamed from: a */
        void m39275a(C5984g c5984g, long j) {
            synchronized (this) {
                if (this.f30095d.get() != j) {
                    return;
                }
                j = this.f30099h;
                this.f30100i = c5984g;
                c5984g.mo5119a(j);
            }
        }

        /* renamed from: c */
        void m39283c(long j) {
            synchronized (this) {
                C5984g c5984g = this.f30100i;
                this.f30099h = C5923a.m24835a(this.f30099h, j);
            }
            if (c5984g != null) {
                c5984g.mo5119a(j);
            }
            m39287f();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: f */
        void m39287f() {
            /*
            r20 = this;
            r8 = r20;
            monitor-enter(r20);
            r0 = r8.f30097f;	 Catch:{ all -> 0x00c8 }
            r1 = 1;
            if (r0 == 0) goto L_0x000c;
        L_0x0008:
            r8.f30098g = r1;	 Catch:{ all -> 0x00c8 }
            monitor-exit(r20);	 Catch:{ all -> 0x00c8 }
            return;
        L_0x000c:
            r8.f30097f = r1;	 Catch:{ all -> 0x00c8 }
            r0 = r8.f30103l;	 Catch:{ all -> 0x00c8 }
            r1 = r8.f30099h;	 Catch:{ all -> 0x00c8 }
            r3 = r8.f30102k;	 Catch:{ all -> 0x00c8 }
            if (r3 == 0) goto L_0x0022;
        L_0x0016:
            r4 = f30091m;	 Catch:{ all -> 0x00c8 }
            if (r3 == r4) goto L_0x0022;
        L_0x001a:
            r4 = r8.f30094c;	 Catch:{ all -> 0x00c8 }
            if (r4 != 0) goto L_0x0022;
        L_0x001e:
            r4 = f30091m;	 Catch:{ all -> 0x00c8 }
            r8.f30102k = r4;	 Catch:{ all -> 0x00c8 }
        L_0x0022:
            monitor-exit(r20);	 Catch:{ all -> 0x00c8 }
            r9 = r8.f30096e;
            r10 = r8.f30095d;
            r11 = r8.f30092a;
            r4 = r8.f30101j;
            r12 = r1;
            r14 = r3;
            r15 = r4;
        L_0x002e:
            r1 = 0;
            r16 = r1;
        L_0x0032:
            r18 = (r16 > r12 ? 1 : (r16 == r12 ? 0 : -1));
            if (r18 == 0) goto L_0x0076;
        L_0x0036:
            r1 = r11.mo5121b();
            if (r1 == 0) goto L_0x003d;
        L_0x003c:
            return;
        L_0x003d:
            r19 = r9.isEmpty();
            r1 = r20;
            r2 = r15;
            r3 = r0;
            r4 = r14;
            r5 = r9;
            r6 = r11;
            r7 = r19;
            r1 = r1.m39280a(r2, r3, r4, r5, r6, r7);
            if (r1 == 0) goto L_0x0051;
        L_0x0050:
            return;
        L_0x0051:
            if (r19 == 0) goto L_0x0054;
        L_0x0053:
            goto L_0x0076;
        L_0x0054:
            r1 = r9.poll();
            r1 = (p289e.p292c.p293a.aw.C8077c) r1;
            r2 = r9.poll();
            r2 = p289e.p292c.p293a.C5937h.m24853d(r2);
            r3 = r10.get();
            r5 = r1.f30089a;
            r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
            if (r1 != 0) goto L_0x0032;
        L_0x006e:
            r11.mo5000a(r2);
            r1 = 1;
            r16 = r16 + r1;
            goto L_0x0032;
        L_0x0076:
            if (r18 != 0) goto L_0x0092;
        L_0x0078:
            r1 = r11.mo5121b();
            if (r1 == 0) goto L_0x007f;
        L_0x007e:
            return;
        L_0x007f:
            r2 = r8.f30101j;
            r7 = r9.isEmpty();
            r1 = r20;
            r3 = r0;
            r4 = r14;
            r5 = r9;
            r6 = r11;
            r0 = r1.m39280a(r2, r3, r4, r5, r6, r7);
            if (r0 == 0) goto L_0x0092;
        L_0x0091:
            return;
        L_0x0092:
            monitor-enter(r20);
            r0 = r8.f30099h;	 Catch:{ all -> 0x00c5 }
            r2 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
            r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
            if (r2 == 0) goto L_0x00a2;
        L_0x009e:
            r0 = r0 - r16;
            r8.f30099h = r0;	 Catch:{ all -> 0x00c5 }
        L_0x00a2:
            r12 = r0;
            r0 = r8.f30098g;	 Catch:{ all -> 0x00c5 }
            r1 = 0;
            if (r0 != 0) goto L_0x00ac;
        L_0x00a8:
            r8.f30097f = r1;	 Catch:{ all -> 0x00c5 }
            monitor-exit(r20);	 Catch:{ all -> 0x00c5 }
            return;
        L_0x00ac:
            r8.f30098g = r1;	 Catch:{ all -> 0x00c5 }
            r15 = r8.f30101j;	 Catch:{ all -> 0x00c5 }
            r0 = r8.f30103l;	 Catch:{ all -> 0x00c5 }
            r14 = r8.f30102k;	 Catch:{ all -> 0x00c5 }
            if (r14 == 0) goto L_0x00c2;
        L_0x00b6:
            r1 = f30091m;	 Catch:{ all -> 0x00c5 }
            if (r14 == r1) goto L_0x00c2;
        L_0x00ba:
            r1 = r8.f30094c;	 Catch:{ all -> 0x00c5 }
            if (r1 != 0) goto L_0x00c2;
        L_0x00be:
            r1 = f30091m;	 Catch:{ all -> 0x00c5 }
            r8.f30102k = r1;	 Catch:{ all -> 0x00c5 }
        L_0x00c2:
            monitor-exit(r20);	 Catch:{ all -> 0x00c5 }
            goto L_0x002e;
        L_0x00c5:
            r0 = move-exception;
            monitor-exit(r20);	 Catch:{ all -> 0x00c5 }
            throw r0;
        L_0x00c8:
            r0 = move-exception;
            monitor-exit(r20);	 Catch:{ all -> 0x00c8 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: e.c.a.aw.d.f():void");
        }

        /* renamed from: a */
        protected boolean m39280a(boolean z, boolean z2, Throwable th, C5954f<Object> c5954f, C7367k<? super T> c7367k, boolean z3) {
            if (this.f30094c) {
                if (z && !z2 && z3) {
                    if (th != null) {
                        c7367k.mo5001a(th);
                    } else {
                        c7367k.L_();
                    }
                    return true;
                }
            } else if (th != null) {
                c5954f.clear();
                c7367k.mo5001a(th);
                return true;
            } else if (z && !z2 && z3) {
                c7367k.L_();
                return true;
            }
            return false;
        }
    }

    /* renamed from: a */
    public static <T> aw<T> m39288a(boolean z) {
        if (z) {
            return C5932b.f19653a;
        }
        return C5931a.f19652a;
    }

    aw(boolean z) {
        this.f30104a = z;
    }

    /* renamed from: a */
    public C7367k<? super C5974e<? extends T>> m39289a(C7367k<? super T> c7367k) {
        C5989l c8078d = new C8078d(c7367k, this.f30104a);
        c7367k.m33781a(c8078d);
        c8078d.m39285d();
        return c8078d;
    }
}
