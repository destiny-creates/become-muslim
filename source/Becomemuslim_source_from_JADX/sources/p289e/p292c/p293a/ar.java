package p289e.p292c.p293a;

import com.facebook.common.time.Clock;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p289e.C5974e;
import p289e.C5974e.C7335a;
import p289e.C5984g;
import p289e.C5989l;
import p289e.C7367k;
import p289e.p290a.C5904c;
import p289e.p291b.C5913a;
import p289e.p291b.C5919g;
import p289e.p292c.p295e.C7322j;
import p289e.p292c.p295e.p296a.C7309d;
import p289e.p292c.p295e.p297b.C8364q;
import p289e.p292c.p295e.p297b.ae;
import p289e.p298d.C7333b;
import p289e.p303i.C5987e;

/* compiled from: OperatorPublish */
/* renamed from: e.c.a.ar */
public final class ar<T> extends C7333b<T> {
    /* renamed from: b */
    final C5974e<? extends T> f30043b;
    /* renamed from: c */
    final AtomicReference<C8070b<T>> f30044c;

    /* compiled from: OperatorPublish */
    /* renamed from: e.c.a.ar$a */
    static final class C7247a<T> extends AtomicLong implements C5984g, C5989l {
        private static final long serialVersionUID = -4453897557930727610L;
        /* renamed from: a */
        final C8070b<T> f25538a;
        /* renamed from: b */
        final C7367k<? super T> f25539b;

        public C7247a(C8070b<T> c8070b, C7367k<? super T> c7367k) {
            this.f25538a = c8070b;
            this.f25539b = c7367k;
            lazySet(0);
        }

        /* renamed from: a */
        public void mo5119a(long j) {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i >= 0) {
                long j2;
                long j3;
                do {
                    j2 = get();
                    if (j2 != Long.MIN_VALUE) {
                        if (j2 >= 0 && i == 0) {
                            return;
                        }
                        if (j2 == -4611686018427387904L) {
                            j3 = j;
                        } else {
                            j3 = j2 + j;
                            if (j3 < 0) {
                                j3 = Clock.MAX_TIME;
                            }
                        }
                    } else {
                        return;
                    }
                } while (!compareAndSet(j2, j3));
                this.f25538a.m39231e();
            }
        }

        /* renamed from: b */
        public long m33521b(long j) {
            if (j > 0) {
                long j2;
                long j3;
                do {
                    j3 = get();
                    if (j3 == -4611686018427387904L) {
                        throw new IllegalStateException("Produced without request");
                    } else if (j3 == Long.MIN_VALUE) {
                        return Long.MIN_VALUE;
                    } else {
                        j2 = j3 - j;
                        if (j2 < 0) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("More produced (");
                            stringBuilder.append(j);
                            stringBuilder.append(") than requested (");
                            stringBuilder.append(j3);
                            stringBuilder.append(")");
                            throw new IllegalStateException(stringBuilder.toString());
                        }
                    }
                } while (!compareAndSet(j3, j2));
                return j2;
            }
            throw new IllegalArgumentException("Cant produce zero or less");
        }

        /* renamed from: b */
        public boolean mo5121b() {
            return get() == Long.MIN_VALUE;
        }

        public void U_() {
            if (get() != Long.MIN_VALUE && getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.f25538a.m39228b(this);
                this.f25538a.m39231e();
            }
        }
    }

    /* compiled from: OperatorPublish */
    /* renamed from: e.c.a.ar$b */
    static final class C8070b<T> extends C7367k<T> implements C5989l {
        /* renamed from: d */
        static final C7247a[] f30034d = new C7247a[0];
        /* renamed from: e */
        static final C7247a[] f30035e = new C7247a[0];
        /* renamed from: a */
        final Queue<Object> f30036a;
        /* renamed from: b */
        final AtomicReference<C8070b<T>> f30037b;
        /* renamed from: c */
        volatile Object f30038c;
        /* renamed from: f */
        final AtomicReference<C7247a[]> f30039f;
        /* renamed from: g */
        final AtomicBoolean f30040g;
        /* renamed from: h */
        boolean f30041h;
        /* renamed from: i */
        boolean f30042i;

        /* compiled from: OperatorPublish */
        /* renamed from: e.c.a.ar$b$1 */
        class C72481 implements C5913a {
            /* renamed from: a */
            final /* synthetic */ C8070b f25540a;

            C72481(C8070b c8070b) {
                this.f25540a = c8070b;
            }

            /* renamed from: a */
            public void mo4985a() {
                this.f25540a.f30039f.getAndSet(C8070b.f30035e);
                this.f25540a.f30037b.compareAndSet(this.f25540a, null);
            }
        }

        public C8070b(AtomicReference<C8070b<T>> atomicReference) {
            this.f30036a = ae.m24923a() ? new C8364q(C7322j.f25717b) : new C7309d(C7322j.f25717b);
            this.f30039f = new AtomicReference(f30034d);
            this.f30037b = atomicReference;
            this.f30040g = new AtomicBoolean();
        }

        /* renamed from: d */
        void m39230d() {
            m33781a(C5987e.m25118a(new C72481(this)));
        }

        /* renamed from: c */
        public void mo6323c() {
            m33779a((long) C7322j.f25717b);
        }

        /* renamed from: a */
        public void mo5000a(T t) {
            if (this.f30036a.offer(C5937h.m24848a((Object) t)) == null) {
                mo5001a(new C5904c());
            } else {
                m39231e();
            }
        }

        /* renamed from: a */
        public void mo5001a(Throwable th) {
            if (this.f30038c == null) {
                this.f30038c = C5937h.m24849a(th);
                m39231e();
            }
        }

        public void L_() {
            if (this.f30038c == null) {
                this.f30038c = C5937h.m24847a();
                m39231e();
            }
        }

        /* renamed from: a */
        boolean m39226a(C7247a<T> c7247a) {
            if (c7247a != null) {
                C7247a[] c7247aArr;
                Object obj;
                do {
                    c7247aArr = (C7247a[]) this.f30039f.get();
                    if (c7247aArr == f30035e) {
                        return false;
                    }
                    int length = c7247aArr.length;
                    obj = new C7247a[(length + 1)];
                    System.arraycopy(c7247aArr, 0, obj, 0, length);
                    obj[length] = c7247a;
                } while (!this.f30039f.compareAndSet(c7247aArr, obj));
                return true;
            }
            throw new NullPointerException();
        }

        /* renamed from: b */
        void m39228b(C7247a<T> c7247a) {
            C7247a[] c7247aArr;
            Object obj;
            do {
                c7247aArr = (C7247a[]) this.f30039f.get();
                if (c7247aArr != f30034d) {
                    if (c7247aArr != f30035e) {
                        int i = -1;
                        int length = c7247aArr.length;
                        for (int i2 = 0; i2 < length; i2++) {
                            if (c7247aArr[i2].equals(c7247a)) {
                                i = i2;
                                break;
                            }
                        }
                        if (i >= 0) {
                            if (length == 1) {
                                obj = f30034d;
                            } else {
                                Object obj2 = new C7247a[(length - 1)];
                                System.arraycopy(c7247aArr, 0, obj2, 0, i);
                                System.arraycopy(c7247aArr, i + 1, obj2, i, (length - i) - 1);
                                obj = obj2;
                            }
                        } else {
                            return;
                        }
                    }
                }
                return;
            } while (!this.f30039f.compareAndSet(c7247aArr, obj));
        }

        /* renamed from: a */
        boolean m39227a(Object obj, boolean z) {
            int i = 0;
            if (obj != null) {
                if (!C5937h.m24851b(obj)) {
                    obj = C5937h.m24854e(obj);
                    this.f30037b.compareAndSet(this, null);
                    try {
                        C7247a[] c7247aArr = (C7247a[]) this.f30039f.getAndSet(f30035e);
                        int length = c7247aArr.length;
                        while (i < length) {
                            c7247aArr[i].f25539b.mo5001a((Throwable) obj);
                            i++;
                        }
                        return true;
                    } finally {
                        U_();
                    }
                } else if (z) {
                    this.f30037b.compareAndSet(this, null);
                    try {
                        C7247a[] c7247aArr2 = (C7247a[]) this.f30039f.getAndSet(f30035e);
                        z = c7247aArr2.length;
                        boolean z2;
                        while (z2 < z) {
                            c7247aArr2[z2].f25539b.L_();
                            z2++;
                        }
                        return true;
                    } finally {
                        U_();
                    }
                }
            }
            return false;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: e */
        void m39231e() {
            /*
            r18 = this;
            r1 = r18;
            monitor-enter(r18);
            r0 = r1.f30041h;	 Catch:{ all -> 0x00ef }
            r2 = 1;
            if (r0 == 0) goto L_0x000c;
        L_0x0008:
            r1.f30042i = r2;	 Catch:{ all -> 0x00ef }
            monitor-exit(r18);	 Catch:{ all -> 0x00ef }
            return;
        L_0x000c:
            r1.f30041h = r2;	 Catch:{ all -> 0x00ef }
            r3 = 0;
            r1.f30042i = r3;	 Catch:{ all -> 0x00ef }
            monitor-exit(r18);	 Catch:{ all -> 0x00ef }
        L_0x0012:
            r0 = r1.f30038c;	 Catch:{ all -> 0x00e2 }
            r4 = r1.f30036a;	 Catch:{ all -> 0x00e2 }
            r4 = r4.isEmpty();	 Catch:{ all -> 0x00e2 }
            r0 = r1.m39227a(r0, r4);	 Catch:{ all -> 0x00e2 }
            if (r0 == 0) goto L_0x0021;
        L_0x0020:
            return;
        L_0x0021:
            if (r4 != 0) goto L_0x00c8;
        L_0x0023:
            r0 = r1.f30039f;	 Catch:{ all -> 0x00e2 }
            r0 = r0.get();	 Catch:{ all -> 0x00e2 }
            r5 = r0;
            r5 = (p289e.p292c.p293a.ar.C7247a[]) r5;	 Catch:{ all -> 0x00e2 }
            r0 = r5.length;	 Catch:{ all -> 0x00e2 }
            r6 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
            r8 = r5.length;	 Catch:{ all -> 0x00e2 }
            r9 = r6;
            r6 = 0;
            r7 = 0;
        L_0x0036:
            r11 = 0;
            if (r6 >= r8) goto L_0x0054;
        L_0x003a:
            r13 = r5[r6];	 Catch:{ all -> 0x00e2 }
            r13 = r13.get();	 Catch:{ all -> 0x00e2 }
            r11 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1));
            if (r11 < 0) goto L_0x0049;
        L_0x0044:
            r9 = java.lang.Math.min(r9, r13);	 Catch:{ all -> 0x00e2 }
            goto L_0x0051;
        L_0x0049:
            r11 = -9223372036854775808;
            r11 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1));
            if (r11 != 0) goto L_0x0051;
        L_0x004f:
            r7 = r7 + 1;
        L_0x0051:
            r6 = r6 + 1;
            goto L_0x0036;
        L_0x0054:
            r13 = 1;
            if (r0 != r7) goto L_0x0070;
        L_0x0058:
            r0 = r1.f30038c;	 Catch:{ all -> 0x00e2 }
            r4 = r1.f30036a;	 Catch:{ all -> 0x00e2 }
            r4 = r4.poll();	 Catch:{ all -> 0x00e2 }
            if (r4 != 0) goto L_0x0064;
        L_0x0062:
            r4 = 1;
            goto L_0x0065;
        L_0x0064:
            r4 = 0;
        L_0x0065:
            r0 = r1.m39227a(r0, r4);	 Catch:{ all -> 0x00e2 }
            if (r0 == 0) goto L_0x006c;
        L_0x006b:
            return;
        L_0x006c:
            r1.m33779a(r13);	 Catch:{ all -> 0x00e2 }
            goto L_0x0012;
        L_0x0070:
            r0 = r4;
            r4 = 0;
        L_0x0072:
            r6 = (long) r4;	 Catch:{ all -> 0x00e2 }
            r8 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1));
            if (r8 >= 0) goto L_0x00bb;
        L_0x0077:
            r0 = r1.f30038c;	 Catch:{ all -> 0x00e2 }
            r8 = r1.f30036a;	 Catch:{ all -> 0x00e2 }
            r8 = r8.poll();	 Catch:{ all -> 0x00e2 }
            if (r8 != 0) goto L_0x0083;
        L_0x0081:
            r15 = 1;
            goto L_0x0084;
        L_0x0083:
            r15 = 0;
        L_0x0084:
            r0 = r1.m39227a(r0, r15);	 Catch:{ all -> 0x00e2 }
            if (r0 == 0) goto L_0x008b;
        L_0x008a:
            return;
        L_0x008b:
            if (r15 == 0) goto L_0x008e;
        L_0x008d:
            goto L_0x00bc;
        L_0x008e:
            r6 = p289e.p292c.p293a.C5937h.m24853d(r8);	 Catch:{ all -> 0x00e2 }
            r7 = r5.length;	 Catch:{ all -> 0x00e2 }
            r8 = 0;
        L_0x0094:
            if (r8 >= r7) goto L_0x00b6;
        L_0x0096:
            r2 = r5[r8];	 Catch:{ all -> 0x00e2 }
            r16 = r2.get();	 Catch:{ all -> 0x00e2 }
            r0 = (r16 > r11 ? 1 : (r16 == r11 ? 0 : -1));
            if (r0 <= 0) goto L_0x00b2;
        L_0x00a0:
            r0 = r2.f25539b;	 Catch:{ Throwable -> 0x00a9 }
            r0.mo5000a(r6);	 Catch:{ Throwable -> 0x00a9 }
            r2.m33521b(r13);	 Catch:{ all -> 0x00e2 }
            goto L_0x00b2;
        L_0x00a9:
            r0 = move-exception;
            r2.U_();	 Catch:{ all -> 0x00e2 }
            r2 = r2.f25539b;	 Catch:{ all -> 0x00e2 }
            p289e.p290a.C5903b.m24790a(r0, r2, r6);	 Catch:{ all -> 0x00e2 }
        L_0x00b2:
            r8 = r8 + 1;
            r2 = 1;
            goto L_0x0094;
        L_0x00b6:
            r4 = r4 + 1;
            r0 = r15;
            r2 = 1;
            goto L_0x0072;
        L_0x00bb:
            r15 = r0;
        L_0x00bc:
            if (r4 <= 0) goto L_0x00c1;
        L_0x00be:
            r1.m33779a(r6);	 Catch:{ all -> 0x00e2 }
        L_0x00c1:
            r0 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1));
            if (r0 == 0) goto L_0x00c8;
        L_0x00c5:
            if (r15 != 0) goto L_0x00c8;
        L_0x00c7:
            goto L_0x00d7;
        L_0x00c8:
            monitor-enter(r18);	 Catch:{ all -> 0x00e2 }
            r0 = r1.f30042i;	 Catch:{ all -> 0x00da }
            if (r0 != 0) goto L_0x00d4;
        L_0x00cd:
            r1.f30041h = r3;	 Catch:{ all -> 0x00da }
            monitor-exit(r18);	 Catch:{ all -> 0x00d1 }
            return;
        L_0x00d1:
            r0 = move-exception;
            r2 = 1;
            goto L_0x00dc;
        L_0x00d4:
            r1.f30042i = r3;	 Catch:{ all -> 0x00da }
            monitor-exit(r18);	 Catch:{ all -> 0x00da }
        L_0x00d7:
            r2 = 1;
            goto L_0x0012;
        L_0x00da:
            r0 = move-exception;
            r2 = 0;
        L_0x00dc:
            monitor-exit(r18);	 Catch:{ all -> 0x00e0 }
            throw r0;	 Catch:{ all -> 0x00de }
        L_0x00de:
            r0 = move-exception;
            goto L_0x00e4;
        L_0x00e0:
            r0 = move-exception;
            goto L_0x00dc;
        L_0x00e2:
            r0 = move-exception;
            r2 = 0;
        L_0x00e4:
            if (r2 != 0) goto L_0x00ee;
        L_0x00e6:
            monitor-enter(r18);
            r1.f30041h = r3;	 Catch:{ all -> 0x00eb }
            monitor-exit(r18);	 Catch:{ all -> 0x00eb }
            goto L_0x00ee;
        L_0x00eb:
            r0 = move-exception;
            monitor-exit(r18);	 Catch:{ all -> 0x00eb }
            throw r0;
        L_0x00ee:
            throw r0;
        L_0x00ef:
            r0 = move-exception;
            monitor-exit(r18);	 Catch:{ all -> 0x00ef }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: e.c.a.ar.b.e():void");
        }
    }

    /* renamed from: h */
    public static <T> C7333b<T> m39234h(C5974e<? extends T> c5974e) {
        final AtomicReference atomicReference = new AtomicReference();
        return new ar(new C7335a<T>() {
            /* renamed from: b */
            public /* synthetic */ void mo4974b(Object obj) {
                m39217a((C7367k) obj);
            }

            /* renamed from: a */
            public void m39217a(C7367k<? super T> c7367k) {
                while (true) {
                    C8070b c8070b = (C8070b) atomicReference.get();
                    if (c8070b == null || c8070b.mo5121b()) {
                        C8070b c8070b2 = new C8070b(atomicReference);
                        c8070b2.m39230d();
                        if (atomicReference.compareAndSet(c8070b, c8070b2)) {
                            c8070b = c8070b2;
                        }
                    }
                    C5984g c7247a = new C7247a(c8070b, c7367k);
                    if (c8070b.m39226a((C7247a) c7247a)) {
                        c7367k.m33781a((C5989l) c7247a);
                        c7367k.mo6324a(c7247a);
                        return;
                    }
                }
            }
        }, c5974e, atomicReference);
    }

    /* renamed from: a */
    public static <T, R> C5974e<R> m39232a(C5974e<? extends T> c5974e, C5919g<? super C5974e<T>, ? extends C5974e<R>> c5919g) {
        return ar.m39233a(c5974e, c5919g, false);
    }

    /* renamed from: a */
    public static <T, R> C5974e<R> m39233a(final C5974e<? extends T> c5974e, final C5919g<? super C5974e<T>, ? extends C5974e<R>> c5919g, final boolean z) {
        return C5974e.m24972a(new C7335a<R>() {
            /* renamed from: b */
            public /* synthetic */ void mo4974b(Object obj) {
                m39222a((C7367k) obj);
            }

            /* renamed from: a */
            public void m39222a(final C7367k<? super R> c7367k) {
                final C7335a c8121w = new C8121w(C7322j.f25717b, z);
                C7367k c80681 = new C7367k<R>(this) {
                    /* renamed from: c */
                    final /* synthetic */ C80692 f30030c;

                    /* renamed from: a */
                    public void mo5000a(R r) {
                        c7367k.mo5000a((Object) r);
                    }

                    /* renamed from: a */
                    public void mo5001a(Throwable th) {
                        c8121w.U_();
                        c7367k.mo5001a(th);
                    }

                    public void L_() {
                        c8121w.U_();
                        c7367k.L_();
                    }

                    /* renamed from: a */
                    public void mo6324a(C5984g c5984g) {
                        c7367k.mo6324a(c5984g);
                    }
                };
                c7367k.m33781a((C5989l) c8121w);
                c7367k.m33781a((C5989l) c80681);
                ((C5974e) c5919g.mo4976a(C5974e.m24972a(c8121w))).m25007a(c80681);
                c5974e.m25007a(c8121w.m39455e());
            }
        });
    }

    private ar(C7335a<T> c7335a, C5974e<? extends T> c5974e, AtomicReference<C8070b<T>> atomicReference) {
        super(c7335a);
        this.f30043b = c5974e;
        this.f30044c = atomicReference;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: d */
    public void mo6326d(p289e.p291b.C5914b<? super p289e.C5989l> r5) {
        /*
        r4 = this;
    L_0x0000:
        r0 = r4.f30044c;
        r0 = r0.get();
        r0 = (p289e.p292c.p293a.ar.C8070b) r0;
        if (r0 == 0) goto L_0x0010;
    L_0x000a:
        r1 = r0.mo5121b();
        if (r1 == 0) goto L_0x0024;
    L_0x0010:
        r1 = new e.c.a.ar$b;
        r2 = r4.f30044c;
        r1.<init>(r2);
        r1.m39230d();
        r2 = r4.f30044c;
        r0 = r2.compareAndSet(r0, r1);
        if (r0 != 0) goto L_0x0023;
    L_0x0022:
        goto L_0x0000;
    L_0x0023:
        r0 = r1;
    L_0x0024:
        r1 = r0.f30040g;
        r1 = r1.get();
        r2 = 1;
        r3 = 0;
        if (r1 != 0) goto L_0x0037;
    L_0x002e:
        r1 = r0.f30040g;
        r1 = r1.compareAndSet(r3, r2);
        if (r1 == 0) goto L_0x0037;
    L_0x0036:
        goto L_0x0038;
    L_0x0037:
        r2 = 0;
    L_0x0038:
        r5.mo4974b(r0);
        if (r2 == 0) goto L_0x0042;
    L_0x003d:
        r5 = r4.f30043b;
        r5.m25007a(r0);
    L_0x0042:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a.ar.d(e.b.b):void");
    }
}
