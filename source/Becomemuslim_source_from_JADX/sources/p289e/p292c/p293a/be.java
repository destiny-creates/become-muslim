package p289e.p292c.p293a;

import com.facebook.common.time.Clock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p289e.C5974e;
import p289e.C5974e.C7336b;
import p289e.C5982f;
import p289e.C5989l;
import p289e.C7367k;
import p289e.p291b.C5918f;
import p289e.p299e.C8146d;
import p289e.p302h.C8156f;
import p289e.p303i.C7364d;

/* compiled from: OperatorWindowWithObservableFactory */
/* renamed from: e.c.a.be */
public final class be<T, U> implements C7336b<C5974e<T>, T> {
    /* renamed from: b */
    static final Object f30148b = new Object();
    /* renamed from: a */
    final C5918f<? extends C5974e<? extends U>> f30149a;

    /* compiled from: OperatorWindowWithObservableFactory */
    /* renamed from: e.c.a.be$a */
    static final class C8089a<T, U> extends C7367k<U> {
        /* renamed from: a */
        final C8090b<T, U> f30138a;
        /* renamed from: b */
        boolean f30139b;

        public C8089a(C8090b<T, U> c8090b) {
            this.f30138a = c8090b;
        }

        /* renamed from: c */
        public void mo6323c() {
            m33779a((long) Clock.MAX_TIME);
        }

        /* renamed from: a */
        public void mo5000a(U u) {
            if (this.f30139b == null) {
                this.f30139b = true;
                this.f30138a.m39342f();
            }
        }

        /* renamed from: a */
        public void mo5001a(Throwable th) {
            this.f30138a.mo5001a(th);
        }

        public void L_() {
            if (!this.f30139b) {
                this.f30139b = true;
                this.f30138a.L_();
            }
        }
    }

    /* compiled from: OperatorWindowWithObservableFactory */
    /* renamed from: e.c.a.be$b */
    static final class C8090b<T, U> extends C7367k<T> {
        /* renamed from: a */
        final C7367k<? super C5974e<T>> f30140a;
        /* renamed from: b */
        final Object f30141b = new Object();
        /* renamed from: c */
        C5982f<T> f30142c;
        /* renamed from: d */
        C5974e<T> f30143d;
        /* renamed from: e */
        boolean f30144e;
        /* renamed from: f */
        List<Object> f30145f;
        /* renamed from: g */
        final C7364d f30146g = new C7364d();
        /* renamed from: h */
        final C5918f<? extends C5974e<? extends U>> f30147h;

        public C8090b(C7367k<? super C5974e<T>> c7367k, C5918f<? extends C5974e<? extends U>> c5918f) {
            this.f30140a = new C8146d(c7367k);
            this.f30147h = c5918f;
            m33781a((C5989l) this.f30146g);
        }

        /* renamed from: c */
        public void mo6323c() {
            m33779a((long) Clock.MAX_TIME);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public void mo5000a(T r7) {
            /*
            r6 = this;
            r0 = r6.f30141b;
            monitor-enter(r0);
            r1 = r6.f30144e;	 Catch:{ all -> 0x0066 }
            if (r1 == 0) goto L_0x0019;
        L_0x0007:
            r1 = r6.f30145f;	 Catch:{ all -> 0x0066 }
            if (r1 != 0) goto L_0x0012;
        L_0x000b:
            r1 = new java.util.ArrayList;	 Catch:{ all -> 0x0066 }
            r1.<init>();	 Catch:{ all -> 0x0066 }
            r6.f30145f = r1;	 Catch:{ all -> 0x0066 }
        L_0x0012:
            r1 = r6.f30145f;	 Catch:{ all -> 0x0066 }
            r1.add(r7);	 Catch:{ all -> 0x0066 }
            monitor-exit(r0);	 Catch:{ all -> 0x0066 }
            return;
        L_0x0019:
            r1 = r6.f30145f;	 Catch:{ all -> 0x0066 }
            r2 = 0;
            r6.f30145f = r2;	 Catch:{ all -> 0x0066 }
            r3 = 1;
            r6.f30144e = r3;	 Catch:{ all -> 0x0066 }
            monitor-exit(r0);	 Catch:{ all -> 0x0066 }
            r0 = 1;
        L_0x0023:
            r4 = 0;
            r6.m39336a(r1);	 Catch:{ all -> 0x0057 }
            if (r0 == 0) goto L_0x002d;
        L_0x0029:
            r6.m39337b(r7);	 Catch:{ all -> 0x0057 }
            r0 = 0;
        L_0x002d:
            r1 = r6.f30141b;	 Catch:{ all -> 0x0057 }
            monitor-enter(r1);	 Catch:{ all -> 0x0057 }
            r5 = r6.f30145f;	 Catch:{ all -> 0x004f }
            r6.f30145f = r2;	 Catch:{ all -> 0x004f }
            if (r5 != 0) goto L_0x003a;
        L_0x0036:
            r6.f30144e = r4;	 Catch:{ all -> 0x004f }
            monitor-exit(r1);	 Catch:{ all -> 0x0055 }
            return;
        L_0x003a:
            monitor-exit(r1);	 Catch:{ all -> 0x004f }
            r1 = r6.f30140a;	 Catch:{ all -> 0x0057 }
            r1 = r1.mo5121b();	 Catch:{ all -> 0x0057 }
            if (r1 == 0) goto L_0x004d;
        L_0x0043:
            r1 = r6.f30141b;
            monitor-enter(r1);
            r6.f30144e = r4;	 Catch:{ all -> 0x004a }
            monitor-exit(r1);	 Catch:{ all -> 0x004a }
            return;
        L_0x004a:
            r7 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x004a }
            throw r7;
        L_0x004d:
            r1 = r5;
            goto L_0x0023;
        L_0x004f:
            r7 = move-exception;
            r3 = 0;
        L_0x0051:
            monitor-exit(r1);	 Catch:{ all -> 0x0055 }
            throw r7;	 Catch:{ all -> 0x0053 }
        L_0x0053:
            r7 = move-exception;
            goto L_0x0059;
        L_0x0055:
            r7 = move-exception;
            goto L_0x0051;
        L_0x0057:
            r7 = move-exception;
            r3 = 0;
        L_0x0059:
            if (r3 != 0) goto L_0x0065;
        L_0x005b:
            r0 = r6.f30141b;
            monitor-enter(r0);
            r6.f30144e = r4;	 Catch:{ all -> 0x0062 }
            monitor-exit(r0);	 Catch:{ all -> 0x0062 }
            goto L_0x0065;
        L_0x0062:
            r7 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0062 }
            throw r7;
        L_0x0065:
            throw r7;
        L_0x0066:
            r7 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0066 }
            throw r7;
            */
            throw new UnsupportedOperationException("Method not decompiled: e.c.a.be.b.a(java.lang.Object):void");
        }

        /* renamed from: a */
        void m39336a(List<Object> list) {
            if (list != null) {
                for (Object next : list) {
                    if (next == be.f30148b) {
                        m39340d();
                    } else if (C5937h.m24852c(next)) {
                        m39338b(C5937h.m24854e(next));
                        break;
                    } else if (C5937h.m24851b(next)) {
                        m39343g();
                        break;
                    } else {
                        m39337b(next);
                    }
                }
            }
        }

        /* renamed from: d */
        void m39340d() {
            C5982f c5982f = this.f30142c;
            if (c5982f != null) {
                c5982f.L_();
            }
            m39341e();
            this.f30140a.mo5000a((Object) this.f30143d);
        }

        /* renamed from: e */
        void m39341e() {
            Object b = C8156f.m39570b();
            this.f30142c = b;
            this.f30143d = b;
            try {
                C5974e c5974e = (C5974e) this.f30147h.call();
                C7367k c8089a = new C8089a(this);
                this.f30146g.m33770a(c8089a);
                c5974e.m25007a(c8089a);
            } catch (Throwable th) {
                this.f30140a.mo5001a(th);
                U_();
            }
        }

        /* renamed from: b */
        void m39337b(T t) {
            C5982f c5982f = this.f30142c;
            if (c5982f != null) {
                c5982f.mo5000a((Object) t);
            }
        }

        /* renamed from: a */
        public void mo5001a(Throwable th) {
            synchronized (this.f30141b) {
                if (this.f30144e) {
                    this.f30145f = Collections.singletonList(C5937h.m24849a(th));
                    return;
                }
                this.f30145f = null;
                this.f30144e = true;
                m39338b(th);
            }
        }

        public void L_() {
            synchronized (this.f30141b) {
                if (this.f30144e) {
                    if (this.f30145f == null) {
                        this.f30145f = new ArrayList();
                    }
                    this.f30145f.add(C5937h.m24847a());
                    return;
                }
                List list = this.f30145f;
                this.f30145f = null;
                this.f30144e = true;
                try {
                    m39336a(list);
                    m39343g();
                } catch (Throwable th) {
                    m39338b(th);
                }
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: f */
        void m39342f() {
            /*
            r6 = this;
            r0 = r6.f30141b;
            monitor-enter(r0);
            r1 = r6.f30144e;	 Catch:{ all -> 0x0068 }
            if (r1 == 0) goto L_0x001b;
        L_0x0007:
            r1 = r6.f30145f;	 Catch:{ all -> 0x0068 }
            if (r1 != 0) goto L_0x0012;
        L_0x000b:
            r1 = new java.util.ArrayList;	 Catch:{ all -> 0x0068 }
            r1.<init>();	 Catch:{ all -> 0x0068 }
            r6.f30145f = r1;	 Catch:{ all -> 0x0068 }
        L_0x0012:
            r1 = r6.f30145f;	 Catch:{ all -> 0x0068 }
            r2 = p289e.p292c.p293a.be.f30148b;	 Catch:{ all -> 0x0068 }
            r1.add(r2);	 Catch:{ all -> 0x0068 }
            monitor-exit(r0);	 Catch:{ all -> 0x0068 }
            return;
        L_0x001b:
            r1 = r6.f30145f;	 Catch:{ all -> 0x0068 }
            r2 = 0;
            r6.f30145f = r2;	 Catch:{ all -> 0x0068 }
            r3 = 1;
            r6.f30144e = r3;	 Catch:{ all -> 0x0068 }
            monitor-exit(r0);	 Catch:{ all -> 0x0068 }
            r0 = 1;
        L_0x0025:
            r4 = 0;
            r6.m39336a(r1);	 Catch:{ all -> 0x0059 }
            if (r0 == 0) goto L_0x002f;
        L_0x002b:
            r6.m39340d();	 Catch:{ all -> 0x0059 }
            r0 = 0;
        L_0x002f:
            r1 = r6.f30141b;	 Catch:{ all -> 0x0059 }
            monitor-enter(r1);	 Catch:{ all -> 0x0059 }
            r5 = r6.f30145f;	 Catch:{ all -> 0x0051 }
            r6.f30145f = r2;	 Catch:{ all -> 0x0051 }
            if (r5 != 0) goto L_0x003c;
        L_0x0038:
            r6.f30144e = r4;	 Catch:{ all -> 0x0051 }
            monitor-exit(r1);	 Catch:{ all -> 0x0057 }
            return;
        L_0x003c:
            monitor-exit(r1);	 Catch:{ all -> 0x0051 }
            r1 = r6.f30140a;	 Catch:{ all -> 0x0059 }
            r1 = r1.mo5121b();	 Catch:{ all -> 0x0059 }
            if (r1 == 0) goto L_0x004f;
        L_0x0045:
            r1 = r6.f30141b;
            monitor-enter(r1);
            r6.f30144e = r4;	 Catch:{ all -> 0x004c }
            monitor-exit(r1);	 Catch:{ all -> 0x004c }
            return;
        L_0x004c:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x004c }
            throw r0;
        L_0x004f:
            r1 = r5;
            goto L_0x0025;
        L_0x0051:
            r0 = move-exception;
            r3 = 0;
        L_0x0053:
            monitor-exit(r1);	 Catch:{ all -> 0x0057 }
            throw r0;	 Catch:{ all -> 0x0055 }
        L_0x0055:
            r0 = move-exception;
            goto L_0x005b;
        L_0x0057:
            r0 = move-exception;
            goto L_0x0053;
        L_0x0059:
            r0 = move-exception;
            r3 = 0;
        L_0x005b:
            if (r3 != 0) goto L_0x0067;
        L_0x005d:
            r1 = r6.f30141b;
            monitor-enter(r1);
            r6.f30144e = r4;	 Catch:{ all -> 0x0064 }
            monitor-exit(r1);	 Catch:{ all -> 0x0064 }
            goto L_0x0067;
        L_0x0064:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0064 }
            throw r0;
        L_0x0067:
            throw r0;
        L_0x0068:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0068 }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: e.c.a.be.b.f():void");
        }

        /* renamed from: g */
        void m39343g() {
            C5982f c5982f = this.f30142c;
            this.f30142c = null;
            this.f30143d = null;
            if (c5982f != null) {
                c5982f.L_();
            }
            this.f30140a.L_();
            U_();
        }

        /* renamed from: b */
        void m39338b(Throwable th) {
            C5982f c5982f = this.f30142c;
            this.f30142c = null;
            this.f30143d = null;
            if (c5982f != null) {
                c5982f.mo5001a(th);
            }
            this.f30140a.mo5001a(th);
            U_();
        }
    }

    public be(C5918f<? extends C5974e<? extends U>> c5918f) {
        this.f30149a = c5918f;
    }

    /* renamed from: a */
    public C7367k<? super T> m39344a(C7367k<? super C5974e<T>> c7367k) {
        C5989l c8090b = new C8090b(c7367k, this.f30149a);
        c7367k.m33781a(c8090b);
        c8090b.m39342f();
        return c8090b;
    }
}
