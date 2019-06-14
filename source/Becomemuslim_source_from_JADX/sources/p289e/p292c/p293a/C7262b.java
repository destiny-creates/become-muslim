package p289e.p292c.p293a;

import com.facebook.common.time.Clock;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import p289e.C5974e;
import p289e.C5974e.C7335a;
import p289e.C5982f;
import p289e.C5984g;
import p289e.C5989l;
import p289e.C7367k;
import p289e.p292c.p295e.C5962f;
import p289e.p303i.C7364d;

/* compiled from: CachedObservable */
/* renamed from: e.c.a.b */
public final class C7262b<T> extends C5974e<T> {
    /* renamed from: b */
    private final C7260a<T> f25575b;

    /* compiled from: CachedObservable */
    /* renamed from: e.c.a.b$a */
    static final class C7260a<T> extends C5962f implements C5982f<T> {
        /* renamed from: d */
        static final C7261c<?>[] f25562d = new C7261c[0];
        /* renamed from: a */
        final C5974e<? extends T> f25563a;
        /* renamed from: b */
        final C7364d f25564b = new C7364d();
        /* renamed from: c */
        volatile C7261c<?>[] f25565c = f25562d;
        /* renamed from: e */
        volatile boolean f25566e;
        /* renamed from: f */
        boolean f25567f;

        /* compiled from: CachedObservable */
        /* renamed from: e.c.a.b$a$1 */
        class C80831 extends C7367k<T> {
            /* renamed from: a */
            final /* synthetic */ C7260a f30119a;

            C80831(C7260a c7260a) {
                this.f30119a = c7260a;
            }

            /* renamed from: a */
            public void mo5000a(T t) {
                this.f30119a.mo5000a((Object) t);
            }

            /* renamed from: a */
            public void mo5001a(Throwable th) {
                this.f30119a.mo5001a(th);
            }

            public void L_() {
                this.f30119a.L_();
            }
        }

        public C7260a(C5974e<? extends T> c5974e, int i) {
            super(i);
            this.f25563a = c5974e;
        }

        /* renamed from: a */
        public void m33552a(C7261c<T> c7261c) {
            synchronized (this.f25564b) {
                Object obj = this.f25565c;
                int length = obj.length;
                Object obj2 = new C7261c[(length + 1)];
                System.arraycopy(obj, 0, obj2, 0, length);
                obj2[length] = c7261c;
                this.f25565c = obj2;
            }
        }

        /* renamed from: b */
        public void m33556b(C7261c<T> c7261c) {
            synchronized (this.f25564b) {
                Object obj = this.f25565c;
                int length = obj.length;
                int i = -1;
                for (int i2 = 0; i2 < length; i2++) {
                    if (obj[i2].equals(c7261c)) {
                        i = i2;
                        break;
                    }
                }
                if (i < 0) {
                } else if (length == 1) {
                    this.f25565c = f25562d;
                } else {
                    Object obj2 = new C7261c[(length - 1)];
                    System.arraycopy(obj, 0, obj2, 0, i);
                    System.arraycopy(obj, i + 1, obj2, i, (length - i) - 1);
                    this.f25565c = obj2;
                }
            }
        }

        /* renamed from: b */
        public void m33555b() {
            C7367k c80831 = new C80831(this);
            this.f25564b.m33770a(c80831);
            this.f25563a.m25007a(c80831);
            this.f25566e = true;
        }

        /* renamed from: a */
        public void mo5000a(T t) {
            if (!this.f25567f) {
                m24931b(C5937h.m24848a((Object) t));
                m33557c();
            }
        }

        /* renamed from: a */
        public void mo5001a(Throwable th) {
            if (!this.f25567f) {
                this.f25567f = true;
                m24931b(C5937h.m24849a(th));
                this.f25564b.U_();
                m33557c();
            }
        }

        public void L_() {
            if (!this.f25567f) {
                this.f25567f = true;
                m24931b(C5937h.m24847a());
                this.f25564b.U_();
                m33557c();
            }
        }

        /* renamed from: c */
        void m33557c() {
            for (C7261c c : this.f25565c) {
                c.m33561c();
            }
        }
    }

    /* compiled from: CachedObservable */
    /* renamed from: e.c.a.b$c */
    static final class C7261c<T> extends AtomicLong implements C5984g, C5989l {
        private static final long serialVersionUID = -2557562030197141021L;
        /* renamed from: a */
        final C7367k<? super T> f25568a;
        /* renamed from: b */
        final C7260a<T> f25569b;
        /* renamed from: c */
        Object[] f25570c;
        /* renamed from: d */
        int f25571d;
        /* renamed from: e */
        int f25572e;
        /* renamed from: f */
        boolean f25573f;
        /* renamed from: g */
        boolean f25574g;

        public C7261c(C7367k<? super T> c7367k, C7260a<T> c7260a) {
            this.f25568a = c7367k;
            this.f25569b = c7260a;
        }

        /* renamed from: a */
        public void mo5119a(long j) {
            long j2;
            long j3;
            do {
                j2 = get();
                if (j2 >= 0) {
                    j3 = j2 + j;
                    if (j3 < 0) {
                        j3 = Clock.MAX_TIME;
                    }
                } else {
                    return;
                }
            } while (!compareAndSet(j2, j3));
            m33561c();
        }

        /* renamed from: b */
        public long m33559b(long j) {
            return addAndGet(-j);
        }

        /* renamed from: b */
        public boolean mo5121b() {
            return get() < 0;
        }

        public void U_() {
            if (get() >= 0 && getAndSet(-1) >= 0) {
                this.f25569b.m33556b(this);
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: c */
        public void m33561c() {
            /*
            r15 = this;
            monitor-enter(r15);
            r0 = r15.f25573f;	 Catch:{ all -> 0x00e6 }
            r1 = 1;
            if (r0 == 0) goto L_0x000a;
        L_0x0006:
            r15.f25574g = r1;	 Catch:{ all -> 0x00e6 }
            monitor-exit(r15);	 Catch:{ all -> 0x00e6 }
            return;
        L_0x000a:
            r15.f25573f = r1;	 Catch:{ all -> 0x00e6 }
            monitor-exit(r15);	 Catch:{ all -> 0x00e6 }
            r0 = 0;
            r2 = r15.f25568a;	 Catch:{ all -> 0x00d9 }
        L_0x0010:
            r3 = r15.get();	 Catch:{ all -> 0x00d9 }
            r5 = 0;
            r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
            if (r7 >= 0) goto L_0x001b;
        L_0x001a:
            return;
        L_0x001b:
            r8 = r15.f25569b;	 Catch:{ all -> 0x00d9 }
            r8 = r8.m24933e();	 Catch:{ all -> 0x00d9 }
            if (r8 == 0) goto L_0x00c1;
        L_0x0023:
            r9 = r15.f25570c;	 Catch:{ all -> 0x00d9 }
            if (r9 != 0) goto L_0x002f;
        L_0x0027:
            r9 = r15.f25569b;	 Catch:{ all -> 0x00d9 }
            r9 = r9.m24932d();	 Catch:{ all -> 0x00d9 }
            r15.f25570c = r9;	 Catch:{ all -> 0x00d9 }
        L_0x002f:
            r10 = r9.length;	 Catch:{ all -> 0x00d9 }
            r10 = r10 - r1;
            r11 = r15.f25572e;	 Catch:{ all -> 0x00d9 }
            r12 = r15.f25571d;	 Catch:{ all -> 0x00d9 }
            if (r7 != 0) goto L_0x005c;
        L_0x0037:
            r3 = r9[r12];	 Catch:{ all -> 0x00d9 }
            r4 = p289e.p292c.p293a.C5937h.m24851b(r3);	 Catch:{ all -> 0x00d9 }
            if (r4 == 0) goto L_0x004b;
        L_0x003f:
            r2.L_();	 Catch:{ all -> 0x00d9 }
            r15.U_();	 Catch:{ all -> 0x0046 }
            return;
        L_0x0046:
            r2 = move-exception;
            r1 = r2;
            r4 = 1;
            goto L_0x00db;
        L_0x004b:
            r4 = p289e.p292c.p293a.C5937h.m24852c(r3);	 Catch:{ all -> 0x00d9 }
            if (r4 == 0) goto L_0x00c1;
        L_0x0051:
            r3 = p289e.p292c.p293a.C5937h.m24854e(r3);	 Catch:{ all -> 0x00d9 }
            r2.mo5001a(r3);	 Catch:{ all -> 0x00d9 }
            r15.U_();	 Catch:{ all -> 0x0046 }
            return;
        L_0x005c:
            if (r7 <= 0) goto L_0x00c1;
        L_0x005e:
            r7 = 0;
        L_0x005f:
            if (r11 >= r8) goto L_0x00b0;
        L_0x0061:
            r13 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
            if (r13 <= 0) goto L_0x00b0;
        L_0x0065:
            r13 = r2.mo5121b();	 Catch:{ all -> 0x00d9 }
            if (r13 == 0) goto L_0x006c;
        L_0x006b:
            return;
        L_0x006c:
            if (r12 != r10) goto L_0x0075;
        L_0x006e:
            r9 = r9[r10];	 Catch:{ all -> 0x00d9 }
            r9 = (java.lang.Object[]) r9;	 Catch:{ all -> 0x00d9 }
            r9 = (java.lang.Object[]) r9;	 Catch:{ all -> 0x00d9 }
            r12 = 0;
        L_0x0075:
            r13 = r9[r12];	 Catch:{ all -> 0x00d9 }
            r14 = p289e.p292c.p293a.C5937h.m24850a(r2, r13);	 Catch:{ Throwable -> 0x008e }
            if (r14 == 0) goto L_0x0084;
        L_0x007d:
            r15.U_();	 Catch:{ Throwable -> 0x0081 }
            return;
        L_0x0081:
            r3 = move-exception;
            r4 = 1;
            goto L_0x0090;
        L_0x0084:
            r12 = r12 + 1;
            r11 = r11 + 1;
            r13 = 1;
            r3 = r3 - r13;
            r7 = r7 + 1;
            goto L_0x005f;
        L_0x008e:
            r3 = move-exception;
            r4 = 0;
        L_0x0090:
            p289e.p290a.C5903b.m24794b(r3);	 Catch:{ all -> 0x00ae }
            r15.U_();	 Catch:{ all -> 0x0046 }
            r4 = p289e.p292c.p293a.C5937h.m24852c(r13);	 Catch:{ all -> 0x0046 }
            if (r4 != 0) goto L_0x00ad;
        L_0x009c:
            r4 = p289e.p292c.p293a.C5937h.m24851b(r13);	 Catch:{ all -> 0x0046 }
            if (r4 != 0) goto L_0x00ad;
        L_0x00a2:
            r4 = p289e.p292c.p293a.C5937h.m24853d(r13);	 Catch:{ all -> 0x0046 }
            r3 = p289e.p290a.C5910g.m24799a(r3, r4);	 Catch:{ all -> 0x0046 }
            r2.mo5001a(r3);	 Catch:{ all -> 0x0046 }
        L_0x00ad:
            return;
        L_0x00ae:
            r1 = move-exception;
            goto L_0x00db;
        L_0x00b0:
            r3 = r2.mo5121b();	 Catch:{ all -> 0x00d9 }
            if (r3 == 0) goto L_0x00b7;
        L_0x00b6:
            return;
        L_0x00b7:
            r15.f25572e = r11;	 Catch:{ all -> 0x00d9 }
            r15.f25571d = r12;	 Catch:{ all -> 0x00d9 }
            r15.f25570c = r9;	 Catch:{ all -> 0x00d9 }
            r3 = (long) r7;	 Catch:{ all -> 0x00d9 }
            r15.m33559b(r3);	 Catch:{ all -> 0x00d9 }
        L_0x00c1:
            monitor-enter(r15);	 Catch:{ all -> 0x00d9 }
            r3 = r15.f25574g;	 Catch:{ all -> 0x00cf }
            if (r3 != 0) goto L_0x00ca;
        L_0x00c6:
            r15.f25573f = r0;	 Catch:{ all -> 0x00cf }
            monitor-exit(r15);	 Catch:{ all -> 0x00d7 }
            return;
        L_0x00ca:
            r15.f25574g = r0;	 Catch:{ all -> 0x00cf }
            monitor-exit(r15);	 Catch:{ all -> 0x00cf }
            goto L_0x0010;
        L_0x00cf:
            r2 = move-exception;
            r1 = 0;
        L_0x00d1:
            monitor-exit(r15);	 Catch:{ all -> 0x00d7 }
            throw r2;	 Catch:{ all -> 0x00d3 }
        L_0x00d3:
            r2 = move-exception;
            r4 = r1;
            r1 = r2;
            goto L_0x00db;
        L_0x00d7:
            r2 = move-exception;
            goto L_0x00d1;
        L_0x00d9:
            r1 = move-exception;
            r4 = 0;
        L_0x00db:
            if (r4 != 0) goto L_0x00e5;
        L_0x00dd:
            monitor-enter(r15);
            r15.f25573f = r0;	 Catch:{ all -> 0x00e2 }
            monitor-exit(r15);	 Catch:{ all -> 0x00e2 }
            goto L_0x00e5;
        L_0x00e2:
            r0 = move-exception;
            monitor-exit(r15);	 Catch:{ all -> 0x00e2 }
            throw r0;
        L_0x00e5:
            throw r1;
        L_0x00e6:
            r0 = move-exception;
            monitor-exit(r15);	 Catch:{ all -> 0x00e6 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: e.c.a.b.c.c():void");
        }
    }

    /* compiled from: CachedObservable */
    /* renamed from: e.c.a.b$b */
    static final class C8084b<T> extends AtomicBoolean implements C7335a<T> {
        private static final long serialVersionUID = -2817751667698696782L;
        /* renamed from: a */
        final C7260a<T> f30120a;

        /* renamed from: b */
        public /* synthetic */ void mo4974b(Object obj) {
            m39310a((C7367k) obj);
        }

        public C8084b(C7260a<T> c7260a) {
            this.f30120a = c7260a;
        }

        /* renamed from: a */
        public void m39310a(C7367k<? super T> c7367k) {
            C5984g c7261c = new C7261c(c7367k, this.f30120a);
            this.f30120a.m33552a((C7261c) c7261c);
            c7367k.m33781a((C5989l) c7261c);
            c7367k.mo6324a(c7261c);
            if (get() == null && compareAndSet(null, true) != null) {
                this.f30120a.m33555b();
            }
        }
    }

    /* renamed from: h */
    public static <T> C7262b<T> m33563h(C5974e<? extends T> c5974e) {
        return C7262b.m33562a(c5974e, 16);
    }

    /* renamed from: a */
    public static <T> C7262b<T> m33562a(C5974e<? extends T> c5974e, int i) {
        if (i >= 1) {
            C7260a c7260a = new C7260a(c5974e, i);
            return new C7262b(new C8084b(c7260a), c7260a);
        }
        throw new IllegalArgumentException("capacityHint > 0 required");
    }

    private C7262b(C7335a<T> c7335a, C7260a<T> c7260a) {
        super(c7335a);
        this.f25575b = c7260a;
    }
}
