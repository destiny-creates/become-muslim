package p289e.p292c.p293a;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p289e.C5974e.C7335a;
import p289e.C5984g;
import p289e.C5989l;
import p289e.C7332c;
import p289e.C7332c.C5922a;
import p289e.C7367k;
import p289e.p290a.C5904c;
import p289e.p291b.C5914b;
import p289e.p291b.C5917e;
import p289e.p292c.p295e.C7322j;
import p289e.p292c.p295e.p296a.C5955h;
import p289e.p292c.p295e.p297b.C8354y;
import p289e.p292c.p295e.p297b.ae;
import p289e.p292c.p387d.C7306a;
import p289e.p300f.C5977c;
import p289e.p303i.C7364d;

/* compiled from: OnSubscribeCreate */
/* renamed from: e.c.a.m */
public final class C8106m<T> implements C7335a<T> {
    /* renamed from: a */
    final C5914b<C7332c<T>> f30202a;
    /* renamed from: b */
    final C5922a f30203b;

    /* compiled from: OnSubscribeCreate */
    /* renamed from: e.c.a.m$a */
    static abstract class C8105a<T> extends AtomicLong implements C7332c<T>, C5984g, C5989l {
        private static final long serialVersionUID = 7326289992464377023L;
        /* renamed from: a */
        final C7367k<? super T> f30200a;
        /* renamed from: b */
        final C7364d f30201b = new C7364d();

        /* renamed from: c */
        void mo6761c() {
        }

        /* renamed from: d */
        void mo6762d() {
        }

        public C8105a(C7367k<? super T> c7367k) {
            this.f30200a = c7367k;
        }

        public void L_() {
            if (!this.f30200a.mo5121b()) {
                try {
                    this.f30200a.L_();
                } finally {
                    this.f30201b.U_();
                }
            }
        }

        /* renamed from: a */
        public void mo5001a(Throwable th) {
            if (!this.f30200a.mo5121b()) {
                try {
                    this.f30200a.mo5001a(th);
                } finally {
                    this.f30201b.U_();
                }
            }
        }

        public final void U_() {
            this.f30201b.U_();
            mo6761c();
        }

        /* renamed from: b */
        public final boolean mo5121b() {
            return this.f30201b.mo5121b();
        }

        /* renamed from: a */
        public final void mo5119a(long j) {
            if (C5923a.m24837a(j)) {
                C5923a.m24836a((AtomicLong) this, j);
                mo6762d();
            }
        }

        /* renamed from: a */
        public final void mo6331a(C5989l c5989l) {
            this.f30201b.m33770a(c5989l);
        }

        /* renamed from: a */
        public final void mo6330a(C5917e c5917e) {
            mo6331a(new C7306a(c5917e));
        }
    }

    /* compiled from: OnSubscribeCreate */
    /* renamed from: e.c.a.m$b */
    static final class C8250b<T> extends C8105a<T> {
        private static final long serialVersionUID = 2427151001689639875L;
        /* renamed from: c */
        final Queue<Object> f32437c;
        /* renamed from: d */
        Throwable f32438d;
        /* renamed from: e */
        volatile boolean f32439e;
        /* renamed from: f */
        final AtomicInteger f32440f;

        public C8250b(C7367k<? super T> c7367k, int i) {
            super(c7367k);
            this.f32437c = ae.m24923a() != null ? new C8354y(i) : new C5955h(i);
            this.f32440f = new AtomicInteger();
        }

        /* renamed from: a */
        public void mo5000a(T t) {
            this.f32437c.offer(C5937h.m24848a((Object) t));
            m42853e();
        }

        /* renamed from: a */
        public void mo5001a(Throwable th) {
            this.f32438d = th;
            this.f32439e = true;
            m42853e();
        }

        public void L_() {
            this.f32439e = true;
            m42853e();
        }

        /* renamed from: d */
        void mo6762d() {
            m42853e();
        }

        /* renamed from: c */
        void mo6761c() {
            if (this.f32440f.getAndIncrement() == 0) {
                this.f32437c.clear();
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: e */
        void m42853e() {
            /*
            r14 = this;
            r0 = r14.f32440f;
            r0 = r0.getAndIncrement();
            if (r0 == 0) goto L_0x0009;
        L_0x0008:
            return;
        L_0x0009:
            r0 = r14.a;
            r1 = r14.f32437c;
            r2 = 1;
            r3 = 1;
        L_0x000f:
            r4 = r14.get();
            r6 = 0;
            r8 = r6;
        L_0x0016:
            r10 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1));
            if (r10 == 0) goto L_0x004d;
        L_0x001a:
            r11 = r0.mo5121b();
            if (r11 == 0) goto L_0x0024;
        L_0x0020:
            r1.clear();
            return;
        L_0x0024:
            r11 = r14.f32439e;
            r12 = r1.poll();
            if (r12 != 0) goto L_0x002e;
        L_0x002c:
            r13 = 1;
            goto L_0x002f;
        L_0x002e:
            r13 = 0;
        L_0x002f:
            if (r11 == 0) goto L_0x003f;
        L_0x0031:
            if (r13 == 0) goto L_0x003f;
        L_0x0033:
            r0 = r14.f32438d;
            if (r0 == 0) goto L_0x003b;
        L_0x0037:
            super.mo5001a(r0);
            goto L_0x003e;
        L_0x003b:
            super.L_();
        L_0x003e:
            return;
        L_0x003f:
            if (r13 == 0) goto L_0x0042;
        L_0x0041:
            goto L_0x004d;
        L_0x0042:
            r10 = p289e.p292c.p293a.C5937h.m24853d(r12);
            r0.mo5000a(r10);
            r10 = 1;
            r8 = r8 + r10;
            goto L_0x0016;
        L_0x004d:
            if (r10 != 0) goto L_0x006f;
        L_0x004f:
            r4 = r0.mo5121b();
            if (r4 == 0) goto L_0x0059;
        L_0x0055:
            r1.clear();
            return;
        L_0x0059:
            r4 = r14.f32439e;
            r5 = r1.isEmpty();
            if (r4 == 0) goto L_0x006f;
        L_0x0061:
            if (r5 == 0) goto L_0x006f;
        L_0x0063:
            r0 = r14.f32438d;
            if (r0 == 0) goto L_0x006b;
        L_0x0067:
            super.mo5001a(r0);
            goto L_0x006e;
        L_0x006b:
            super.L_();
        L_0x006e:
            return;
        L_0x006f:
            r4 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));
            if (r4 == 0) goto L_0x0076;
        L_0x0073:
            p289e.p292c.p293a.C5923a.m24838b(r14, r8);
        L_0x0076:
            r4 = r14.f32440f;
            r3 = -r3;
            r3 = r4.addAndGet(r3);
            if (r3 != 0) goto L_0x000f;
        L_0x007f:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: e.c.a.m.b.e():void");
        }
    }

    /* compiled from: OnSubscribeCreate */
    /* renamed from: e.c.a.m$e */
    static final class C8251e<T> extends C8105a<T> {
        private static final long serialVersionUID = 4023437720691792495L;
        /* renamed from: c */
        final AtomicReference<Object> f32441c = new AtomicReference();
        /* renamed from: d */
        Throwable f32442d;
        /* renamed from: e */
        volatile boolean f32443e;
        /* renamed from: f */
        final AtomicInteger f32444f = new AtomicInteger();

        public C8251e(C7367k<? super T> c7367k) {
            super(c7367k);
        }

        /* renamed from: a */
        public void mo5000a(T t) {
            this.f32441c.set(C5937h.m24848a((Object) t));
            m42858e();
        }

        /* renamed from: a */
        public void mo5001a(Throwable th) {
            this.f32442d = th;
            this.f32443e = true;
            m42858e();
        }

        public void L_() {
            this.f32443e = true;
            m42858e();
        }

        /* renamed from: d */
        void mo6762d() {
            m42858e();
        }

        /* renamed from: c */
        void mo6761c() {
            if (this.f32444f.getAndIncrement() == 0) {
                this.f32441c.lazySet(null);
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: e */
        void m42858e() {
            /*
            r17 = this;
            r0 = r17;
            r1 = r0.f32444f;
            r1 = r1.getAndIncrement();
            if (r1 == 0) goto L_0x000b;
        L_0x000a:
            return;
        L_0x000b:
            r1 = r0.a;
            r2 = r0.f32441c;
            r3 = 1;
            r4 = 1;
        L_0x0011:
            r5 = r17.get();
            r7 = 0;
            r9 = r7;
        L_0x0018:
            r11 = 0;
            r12 = 0;
            r13 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
            if (r13 == 0) goto L_0x0053;
        L_0x001e:
            r14 = r1.mo5121b();
            if (r14 == 0) goto L_0x0028;
        L_0x0024:
            r2.lazySet(r12);
            return;
        L_0x0028:
            r14 = r0.f32443e;
            r15 = r2.getAndSet(r12);
            if (r15 != 0) goto L_0x0033;
        L_0x0030:
            r16 = 1;
            goto L_0x0035;
        L_0x0033:
            r16 = 0;
        L_0x0035:
            if (r14 == 0) goto L_0x0045;
        L_0x0037:
            if (r16 == 0) goto L_0x0045;
        L_0x0039:
            r1 = r0.f32442d;
            if (r1 == 0) goto L_0x0041;
        L_0x003d:
            super.mo5001a(r1);
            goto L_0x0044;
        L_0x0041:
            super.L_();
        L_0x0044:
            return;
        L_0x0045:
            if (r16 == 0) goto L_0x0048;
        L_0x0047:
            goto L_0x0053;
        L_0x0048:
            r11 = p289e.p292c.p293a.C5937h.m24853d(r15);
            r1.mo5000a(r11);
            r11 = 1;
            r9 = r9 + r11;
            goto L_0x0018;
        L_0x0053:
            if (r13 != 0) goto L_0x0078;
        L_0x0055:
            r5 = r1.mo5121b();
            if (r5 == 0) goto L_0x005f;
        L_0x005b:
            r2.lazySet(r12);
            return;
        L_0x005f:
            r5 = r0.f32443e;
            r6 = r2.get();
            if (r6 != 0) goto L_0x0068;
        L_0x0067:
            r11 = 1;
        L_0x0068:
            if (r5 == 0) goto L_0x0078;
        L_0x006a:
            if (r11 == 0) goto L_0x0078;
        L_0x006c:
            r1 = r0.f32442d;
            if (r1 == 0) goto L_0x0074;
        L_0x0070:
            super.mo5001a(r1);
            goto L_0x0077;
        L_0x0074:
            super.L_();
        L_0x0077:
            return;
        L_0x0078:
            r5 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1));
            if (r5 == 0) goto L_0x007f;
        L_0x007c:
            p289e.p292c.p293a.C5923a.m24838b(r0, r9);
        L_0x007f:
            r5 = r0.f32444f;
            r4 = -r4;
            r4 = r5.addAndGet(r4);
            if (r4 != 0) goto L_0x0011;
        L_0x0088:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: e.c.a.m.e.e():void");
        }
    }

    /* compiled from: OnSubscribeCreate */
    /* renamed from: e.c.a.m$f */
    static abstract class C8252f<T> extends C8105a<T> {
        private static final long serialVersionUID = 4127754106204442833L;

        /* renamed from: e */
        abstract void mo6857e();

        public C8252f(C7367k<? super T> c7367k) {
            super(c7367k);
        }

        /* renamed from: a */
        public void mo5000a(T t) {
            if (!this.a.mo5121b()) {
                if (get() != 0) {
                    this.a.mo5000a((Object) t);
                    C5923a.m24838b(this, 1);
                } else {
                    mo6857e();
                }
            }
        }
    }

    /* compiled from: OnSubscribeCreate */
    /* renamed from: e.c.a.m$g */
    static final class C8253g<T> extends C8105a<T> {
        private static final long serialVersionUID = 3776720187248809713L;

        public C8253g(C7367k<? super T> c7367k) {
            super(c7367k);
        }

        /* renamed from: a */
        public void mo5000a(T t) {
            if (!this.a.mo5121b()) {
                this.a.mo5000a((Object) t);
                long j;
                do {
                    j = get();
                    if (j == 0) {
                        break;
                    }
                } while (compareAndSet(j, j - 1) == null);
            }
        }
    }

    /* compiled from: OnSubscribeCreate */
    /* renamed from: e.c.a.m$c */
    static final class C8343c<T> extends C8252f<T> {
        private static final long serialVersionUID = 8360058422307496563L;

        /* renamed from: e */
        void mo6857e() {
        }

        public C8343c(C7367k<? super T> c7367k) {
            super(c7367k);
        }
    }

    /* compiled from: OnSubscribeCreate */
    /* renamed from: e.c.a.m$d */
    static final class C8344d<T> extends C8252f<T> {
        private static final long serialVersionUID = 338953216916120960L;
        /* renamed from: c */
        private boolean f32847c;

        public C8344d(C7367k<? super T> c7367k) {
            super(c7367k);
        }

        /* renamed from: a */
        public void mo5000a(T t) {
            if (!this.f32847c) {
                super.mo5000a(t);
            }
        }

        public void L_() {
            if (!this.f32847c) {
                this.f32847c = true;
                super.L_();
            }
        }

        /* renamed from: a */
        public void mo5001a(Throwable th) {
            if (this.f32847c) {
                C5977c.m25068a(th);
                return;
            }
            this.f32847c = true;
            super.mo5001a(th);
        }

        /* renamed from: e */
        void mo6857e() {
            mo5001a(new C5904c("create: could not emit value due to lack of requests"));
        }
    }

    /* renamed from: b */
    public /* synthetic */ void mo4974b(Object obj) {
        m39411a((C7367k) obj);
    }

    public C8106m(C5914b<C7332c<T>> c5914b, C5922a c5922a) {
        this.f30202a = c5914b;
        this.f30203b = c5922a;
    }

    /* renamed from: a */
    public void m39411a(C7367k<? super T> c7367k) {
        C5984g c8253g;
        switch (this.f30203b) {
            case NONE:
                c8253g = new C8253g(c7367k);
                break;
            case ERROR:
                c8253g = new C8344d(c7367k);
                break;
            case DROP:
                c8253g = new C8343c(c7367k);
                break;
            case LATEST:
                c8253g = new C8251e(c7367k);
                break;
            default:
                c8253g = new C8250b(c7367k, C7322j.f25717b);
                break;
        }
        c7367k.m33781a((C5989l) c8253g);
        c7367k.mo6324a(c8253g);
        this.f30202a.mo4974b(c8253g);
    }
}
