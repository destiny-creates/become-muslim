package p289e.p302h;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p289e.C5974e.C7335a;
import p289e.C5982f;
import p289e.C5984g;
import p289e.C5989l;
import p289e.C7367k;
import p289e.p290a.C5903b;
import p289e.p291b.C5913a;
import p289e.p292c.p293a.C5923a;
import p289e.p292c.p293a.C5937h;
import p289e.p292c.p295e.p296a.C5955h;
import p289e.p292c.p295e.p296a.C7310g;
import p289e.p292c.p295e.p297b.C8353x;
import p289e.p292c.p295e.p297b.C8354y;
import p289e.p292c.p295e.p297b.ae;

/* compiled from: UnicastSubject */
/* renamed from: e.h.f */
public final class C8156f<T> extends C7356d<T, T> {
    /* renamed from: b */
    final C8155a<T> f30334b;

    /* compiled from: UnicastSubject */
    /* renamed from: e.h.f$a */
    static final class C8155a<T> extends AtomicLong implements C7335a<T>, C5982f<T>, C5984g, C5989l {
        private static final long serialVersionUID = -9044104859202255786L;
        /* renamed from: a */
        final AtomicReference<C7367k<? super T>> f30325a = new AtomicReference();
        /* renamed from: b */
        final Queue<Object> f30326b;
        /* renamed from: c */
        final boolean f30327c;
        /* renamed from: d */
        final AtomicReference<C5913a> f30328d;
        /* renamed from: e */
        Throwable f30329e;
        /* renamed from: f */
        volatile boolean f30330f;
        /* renamed from: g */
        boolean f30331g;
        /* renamed from: h */
        boolean f30332h;
        /* renamed from: i */
        volatile boolean f30333i;

        /* renamed from: b */
        public /* synthetic */ void mo4974b(Object obj) {
            m39561a((C7367k) obj);
        }

        public C8155a(int i, boolean z, C5913a c5913a) {
            this.f30328d = c5913a != null ? new AtomicReference(c5913a) : null;
            this.f30327c = z;
            if (i > true) {
                z = ae.m24923a() ? new C8354y(i) : new C5955h(i);
            } else {
                z = ae.m24923a() != 0 ? new C8353x() : new C7310g();
            }
            this.f30326b = z;
        }

        /* renamed from: a */
        public void mo5000a(T t) {
            if (!this.f30330f) {
                if (!this.f30333i) {
                    Object obj = null;
                    synchronized (this) {
                        if (!this.f30333i) {
                            this.f30326b.offer(C5937h.m24848a((Object) t));
                            obj = 1;
                        }
                    }
                    if (obj != null) {
                        m39567c();
                        return;
                    }
                }
                C7367k c7367k = (C7367k) this.f30325a.get();
                try {
                    c7367k.mo5000a((Object) t);
                } catch (Throwable th) {
                    C5903b.m24790a(th, c7367k, t);
                }
            }
        }

        /* renamed from: a */
        public void mo5001a(Throwable th) {
            if (!this.f30330f) {
                m39568d();
                this.f30329e = th;
                this.f30330f = true;
                if (!this.f30333i) {
                    int i;
                    synchronized (this) {
                        i = 1 ^ this.f30333i;
                    }
                    if (i != 0) {
                        m39567c();
                        return;
                    }
                }
                ((C7367k) this.f30325a.get()).mo5001a(th);
            }
        }

        public void L_() {
            if (!this.f30330f) {
                m39568d();
                this.f30330f = true;
                if (!this.f30333i) {
                    int i;
                    synchronized (this) {
                        i = 1 ^ this.f30333i;
                    }
                    if (i != 0) {
                        m39567c();
                        return;
                    }
                }
                ((C7367k) this.f30325a.get()).L_();
            }
        }

        /* renamed from: a */
        public void mo5119a(long j) {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i < 0) {
                throw new IllegalArgumentException("n >= 0 required");
            } else if (i > 0) {
                C5923a.m24836a((AtomicLong) this, j);
                m39567c();
            } else if (this.f30330f != null) {
                m39567c();
            }
        }

        /* renamed from: a */
        public void m39561a(C7367k<? super T> c7367k) {
            if (this.f30325a.compareAndSet(null, c7367k)) {
                c7367k.m33781a((C5989l) this);
                c7367k.mo6324a((C5984g) this);
                return;
            }
            c7367k.mo5001a(new IllegalStateException("Only a single subscriber is allowed"));
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: c */
        void m39567c() {
            /*
            r15 = this;
            monitor-enter(r15);
            r0 = r15.f30331g;	 Catch:{ all -> 0x0097 }
            r1 = 1;
            if (r0 == 0) goto L_0x000a;
        L_0x0006:
            r15.f30332h = r1;	 Catch:{ all -> 0x0097 }
            monitor-exit(r15);	 Catch:{ all -> 0x0097 }
            return;
        L_0x000a:
            r15.f30331g = r1;	 Catch:{ all -> 0x0097 }
            monitor-exit(r15);	 Catch:{ all -> 0x0097 }
            r0 = r15.f30326b;
            r2 = r15.f30327c;
        L_0x0011:
            r3 = r15.f30325a;
            r3 = r3.get();
            r3 = (p289e.C7367k) r3;
            r4 = 0;
            if (r3 == 0) goto L_0x007b;
        L_0x001c:
            r5 = r15.f30330f;
            r6 = r0.isEmpty();
            r5 = r15.m39564a(r5, r6, r2, r3);
            if (r5 == 0) goto L_0x0029;
        L_0x0028:
            return;
        L_0x0029:
            r5 = r15.get();
            r7 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
            r7 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
            if (r7 != 0) goto L_0x0038;
        L_0x0036:
            r7 = 1;
            goto L_0x0039;
        L_0x0038:
            r7 = 0;
        L_0x0039:
            r8 = 0;
            r10 = r8;
        L_0x003c:
            r12 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1));
            if (r12 == 0) goto L_0x0070;
        L_0x0040:
            r12 = r15.f30330f;
            r13 = r0.poll();
            if (r13 != 0) goto L_0x004a;
        L_0x0048:
            r14 = 1;
            goto L_0x004b;
        L_0x004a:
            r14 = 0;
        L_0x004b:
            r12 = r15.m39564a(r12, r14, r2, r3);
            if (r12 == 0) goto L_0x0052;
        L_0x0051:
            return;
        L_0x0052:
            if (r14 == 0) goto L_0x0055;
        L_0x0054:
            goto L_0x0070;
        L_0x0055:
            r12 = p289e.p292c.p293a.C5937h.m24853d(r13);
            r3.mo5000a(r12);	 Catch:{ Throwable -> 0x0061 }
            r12 = 1;
            r5 = r5 - r12;
            r10 = r10 + r12;
            goto L_0x003c;
        L_0x0061:
            r1 = move-exception;
            r0.clear();
            p289e.p290a.C5903b.m24794b(r1);
            r0 = p289e.p290a.C5910g.m24799a(r1, r12);
            r3.mo5001a(r0);
            return;
        L_0x0070:
            if (r7 != 0) goto L_0x007c;
        L_0x0072:
            r3 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1));
            if (r3 == 0) goto L_0x007c;
        L_0x0076:
            r5 = -r10;
            r15.addAndGet(r5);
            goto L_0x007c;
        L_0x007b:
            r7 = 0;
        L_0x007c:
            monitor-enter(r15);
            r3 = r15.f30332h;	 Catch:{ all -> 0x0094 }
            if (r3 != 0) goto L_0x008f;
        L_0x0081:
            if (r7 == 0) goto L_0x008b;
        L_0x0083:
            r0 = r0.isEmpty();	 Catch:{ all -> 0x0094 }
            if (r0 == 0) goto L_0x008b;
        L_0x0089:
            r15.f30333i = r1;	 Catch:{ all -> 0x0094 }
        L_0x008b:
            r15.f30331g = r4;	 Catch:{ all -> 0x0094 }
            monitor-exit(r15);	 Catch:{ all -> 0x0094 }
            return;
        L_0x008f:
            r15.f30332h = r4;	 Catch:{ all -> 0x0094 }
            monitor-exit(r15);	 Catch:{ all -> 0x0094 }
            goto L_0x0011;
        L_0x0094:
            r0 = move-exception;
            monitor-exit(r15);	 Catch:{ all -> 0x0094 }
            throw r0;
        L_0x0097:
            r0 = move-exception;
            monitor-exit(r15);	 Catch:{ all -> 0x0097 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: e.h.f.a.c():void");
        }

        public void U_() {
            m39568d();
            this.f30330f = true;
            synchronized (this) {
                if (this.f30331g) {
                    return;
                }
                this.f30331g = true;
                this.f30326b.clear();
            }
        }

        /* renamed from: b */
        public boolean mo5121b() {
            return this.f30330f;
        }

        /* renamed from: a */
        boolean m39564a(boolean z, boolean z2, boolean z3, C7367k<? super T> c7367k) {
            if (c7367k.mo5121b()) {
                this.f30326b.clear();
                return true;
            }
            if (z) {
                z = this.f30329e;
                if (z && !z3) {
                    this.f30326b.clear();
                    c7367k.mo5001a((Throwable) z);
                    return true;
                } else if (z2) {
                    if (z) {
                        c7367k.mo5001a((Throwable) z);
                    } else {
                        c7367k.L_();
                    }
                    return true;
                }
            }
            return false;
        }

        /* renamed from: d */
        void m39568d() {
            AtomicReference atomicReference = this.f30328d;
            if (atomicReference != null) {
                C5913a c5913a = (C5913a) atomicReference.get();
                if (c5913a != null && atomicReference.compareAndSet(c5913a, null)) {
                    c5913a.mo4985a();
                }
            }
        }
    }

    /* renamed from: b */
    public static <T> C8156f<T> m39570b() {
        return C8156f.m39569a(16);
    }

    /* renamed from: a */
    public static <T> C8156f<T> m39569a(int i) {
        return new C8156f(new C8155a(i, false, null));
    }

    private C8156f(C8155a<T> c8155a) {
        super(c8155a);
        this.f30334b = c8155a;
    }

    /* renamed from: a */
    public void mo5000a(T t) {
        this.f30334b.mo5000a((Object) t);
    }

    /* renamed from: a */
    public void mo5001a(Throwable th) {
        this.f30334b.mo5001a(th);
    }

    public void L_() {
        this.f30334b.L_();
    }
}
