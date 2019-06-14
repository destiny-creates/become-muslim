package expolib_v1.p321a.p322a.p327e;

import com.facebook.soloader.MinElf;
import expolib_v1.p321a.p322a.C6155b;
import expolib_v1.p321a.p322a.C6165c;
import expolib_v1.p321a.p322a.p327e.C6179h.C6178b;
import expolib_v1.p332b.C6251f;
import expolib_v1.p332b.C7496d;
import expolib_v1.p332b.C7497e;
import expolib_v1.p332b.C8170c;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Http2Connection */
/* renamed from: expolib_v1.a.a.e.g */
public final class C6177g implements Closeable {
    /* renamed from: a */
    static final ExecutorService f19972a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), C6165c.m25313a("OkHttp Http2Connection", true));
    /* renamed from: s */
    static final /* synthetic */ boolean f19973s = (C6177g.class.desiredAssertionStatus() ^ true);
    /* renamed from: b */
    final boolean f19974b;
    /* renamed from: c */
    final C6176b f19975c;
    /* renamed from: d */
    final Map<Integer, C6180i> f19976d = new LinkedHashMap();
    /* renamed from: e */
    final String f19977e;
    /* renamed from: f */
    int f19978f;
    /* renamed from: g */
    int f19979g;
    /* renamed from: h */
    boolean f19980h;
    /* renamed from: i */
    final C6185m f19981i;
    /* renamed from: j */
    long f19982j = 0;
    /* renamed from: k */
    long f19983k;
    /* renamed from: l */
    C6186n f19984l = new C6186n();
    /* renamed from: m */
    final C6186n f19985m = new C6186n();
    /* renamed from: n */
    boolean f19986n = false;
    /* renamed from: o */
    final Socket f19987o;
    /* renamed from: p */
    final C6181j f19988p;
    /* renamed from: q */
    final C7461c f19989q;
    /* renamed from: r */
    final Set<Integer> f19990r = new LinkedHashSet();
    /* renamed from: t */
    private final ExecutorService f19991t;
    /* renamed from: u */
    private Map<Integer, C6184l> f19992u;
    /* renamed from: v */
    private int f19993v;

    /* compiled from: Http2Connection */
    /* renamed from: expolib_v1.a.a.e.g$a */
    public static class C6175a {
        /* renamed from: a */
        Socket f19964a;
        /* renamed from: b */
        String f19965b;
        /* renamed from: c */
        C7497e f19966c;
        /* renamed from: d */
        C7496d f19967d;
        /* renamed from: e */
        C6176b f19968e = C6176b.f19971f;
        /* renamed from: f */
        C6185m f19969f = C6185m.f20029a;
        /* renamed from: g */
        boolean f19970g;

        public C6175a(boolean z) {
            this.f19970g = z;
        }

        /* renamed from: a */
        public C6175a m25362a(Socket socket, String str, C7497e c7497e, C7496d c7496d) {
            this.f19964a = socket;
            this.f19965b = str;
            this.f19966c = c7497e;
            this.f19967d = c7496d;
            return this;
        }

        /* renamed from: a */
        public C6175a m25361a(C6176b c6176b) {
            this.f19968e = c6176b;
            return this;
        }

        /* renamed from: a */
        public C6177g m25363a() {
            return new C6177g(this);
        }
    }

    /* compiled from: Http2Connection */
    /* renamed from: expolib_v1.a.a.e.g$b */
    public static abstract class C6176b {
        /* renamed from: f */
        public static final C6176b f19971f = new C74571();

        /* compiled from: Http2Connection */
        /* renamed from: expolib_v1.a.a.e.g$b$1 */
        static class C74571 extends C6176b {
            C74571() {
            }

            /* renamed from: a */
            public void mo5251a(C6180i c6180i) {
                c6180i.m25418a(C6169b.REFUSED_STREAM);
            }
        }

        /* renamed from: a */
        public void mo5250a(C6177g c6177g) {
        }

        /* renamed from: a */
        public abstract void mo5251a(C6180i c6180i);
    }

    /* compiled from: Http2Connection */
    /* renamed from: expolib_v1.a.a.e.g$c */
    class C7461c extends C6155b implements C6178b {
        /* renamed from: a */
        final C6179h f25888a;
        /* renamed from: c */
        final /* synthetic */ C6177g f25889c;

        /* renamed from: a */
        public void mo5269a() {
        }

        /* renamed from: a */
        public void mo5270a(int i, int i2, int i3, boolean z) {
        }

        C7461c(C6177g c6177g, C6179h c6179h) {
            this.f25889c = c6177g;
            super("OkHttp %s", c6177g.f19977e);
            this.f25888a = c6179h;
        }

        /* renamed from: c */
        protected void mo5268c() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r5 = this;
            r0 = expolib_v1.p321a.p322a.p327e.C6169b.INTERNAL_ERROR;
            r1 = expolib_v1.p321a.p322a.p327e.C6169b.INTERNAL_ERROR;
            r2 = r5.f25888a;	 Catch:{ IOException -> 0x001e }
            r2.m25413a(r5);	 Catch:{ IOException -> 0x001e }
        L_0x0009:
            r2 = r5.f25888a;	 Catch:{ IOException -> 0x001e }
            r3 = 0;	 Catch:{ IOException -> 0x001e }
            r2 = r2.m25414a(r3, r5);	 Catch:{ IOException -> 0x001e }
            if (r2 == 0) goto L_0x0013;	 Catch:{ IOException -> 0x001e }
        L_0x0012:
            goto L_0x0009;	 Catch:{ IOException -> 0x001e }
        L_0x0013:
            r2 = expolib_v1.p321a.p322a.p327e.C6169b.NO_ERROR;	 Catch:{ IOException -> 0x001e }
            r0 = expolib_v1.p321a.p322a.p327e.C6169b.CANCEL;	 Catch:{ IOException -> 0x001a }
            r1 = r5.f25889c;	 Catch:{ IOException -> 0x0027 }
            goto L_0x0024;
        L_0x001a:
            r0 = r2;
            goto L_0x001e;
        L_0x001c:
            r2 = move-exception;
            goto L_0x0031;
        L_0x001e:
            r2 = expolib_v1.p321a.p322a.p327e.C6169b.PROTOCOL_ERROR;	 Catch:{ all -> 0x001c }
            r0 = expolib_v1.p321a.p322a.p327e.C6169b.PROTOCOL_ERROR;	 Catch:{ all -> 0x002d }
            r1 = r5.f25889c;	 Catch:{ IOException -> 0x0027 }
        L_0x0024:
            r1.m25378a(r2, r0);	 Catch:{ IOException -> 0x0027 }
        L_0x0027:
            r0 = r5.f25888a;
            expolib_v1.p321a.p322a.C6165c.m25315a(r0);
            return;
        L_0x002d:
            r0 = move-exception;
            r4 = r2;
            r2 = r0;
            r0 = r4;
        L_0x0031:
            r3 = r5.f25889c;	 Catch:{ IOException -> 0x0036 }
            r3.m25378a(r0, r1);	 Catch:{ IOException -> 0x0036 }
        L_0x0036:
            r0 = r5.f25888a;
            expolib_v1.p321a.p322a.C6165c.m25315a(r0);
            throw r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.e.g.c.c():void");
        }

        /* renamed from: a */
        public void mo5277a(boolean z, int i, C7497e c7497e, int i2) {
            if (this.f25889c.m25389d(i)) {
                this.f25889c.m25372a(i, c7497e, i2, z);
                return;
            }
            C6180i a = this.f25889c.m25368a(i);
            if (a == null) {
                this.f25889c.m25371a(i, C6169b.PROTOCOL_ERROR);
                c7497e.mo6387h((long) i2);
                return;
            }
            a.m25419a(c7497e, i2);
            if (z) {
                a.m25430i();
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public void mo5276a(boolean r10, int r11, int r12, java.util.List<expolib_v1.p321a.p322a.p327e.C6170c> r13) {
            /*
            r9 = this;
            r12 = r9.f25889c;
            r12 = r12.m25389d(r11);
            if (r12 == 0) goto L_0x000e;
        L_0x0008:
            r12 = r9.f25889c;
            r12.m25374a(r11, r13, r10);
            return;
        L_0x000e:
            r12 = r9.f25889c;
            monitor-enter(r12);
            r0 = r9.f25889c;	 Catch:{ all -> 0x0078 }
            r0 = r0.f19980h;	 Catch:{ all -> 0x0078 }
            if (r0 == 0) goto L_0x0019;
        L_0x0017:
            monitor-exit(r12);	 Catch:{ all -> 0x0078 }
            return;
        L_0x0019:
            r0 = r9.f25889c;	 Catch:{ all -> 0x0078 }
            r0 = r0.m25368a(r11);	 Catch:{ all -> 0x0078 }
            if (r0 != 0) goto L_0x006e;
        L_0x0021:
            r0 = r9.f25889c;	 Catch:{ all -> 0x0078 }
            r0 = r0.f19978f;	 Catch:{ all -> 0x0078 }
            if (r11 > r0) goto L_0x0029;
        L_0x0027:
            monitor-exit(r12);	 Catch:{ all -> 0x0078 }
            return;
        L_0x0029:
            r0 = r11 % 2;
            r1 = r9.f25889c;	 Catch:{ all -> 0x0078 }
            r1 = r1.f19979g;	 Catch:{ all -> 0x0078 }
            r2 = 2;
            r1 = r1 % r2;
            if (r0 != r1) goto L_0x0035;
        L_0x0033:
            monitor-exit(r12);	 Catch:{ all -> 0x0078 }
            return;
        L_0x0035:
            r0 = new expolib_v1.a.a.e.i;	 Catch:{ all -> 0x0078 }
            r5 = r9.f25889c;	 Catch:{ all -> 0x0078 }
            r6 = 0;
            r3 = r0;
            r4 = r11;
            r7 = r10;
            r8 = r13;
            r3.<init>(r4, r5, r6, r7, r8);	 Catch:{ all -> 0x0078 }
            r10 = r9.f25889c;	 Catch:{ all -> 0x0078 }
            r10.f19978f = r11;	 Catch:{ all -> 0x0078 }
            r10 = r9.f25889c;	 Catch:{ all -> 0x0078 }
            r10 = r10.f19976d;	 Catch:{ all -> 0x0078 }
            r13 = java.lang.Integer.valueOf(r11);	 Catch:{ all -> 0x0078 }
            r10.put(r13, r0);	 Catch:{ all -> 0x0078 }
            r10 = expolib_v1.p321a.p322a.p327e.C6177g.f19972a;	 Catch:{ all -> 0x0078 }
            r13 = new expolib_v1.a.a.e.g$c$1;	 Catch:{ all -> 0x0078 }
            r1 = "OkHttp %s stream %d";
            r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x0078 }
            r3 = 0;
            r4 = r9.f25889c;	 Catch:{ all -> 0x0078 }
            r4 = r4.f19977e;	 Catch:{ all -> 0x0078 }
            r2[r3] = r4;	 Catch:{ all -> 0x0078 }
            r3 = 1;
            r11 = java.lang.Integer.valueOf(r11);	 Catch:{ all -> 0x0078 }
            r2[r3] = r11;	 Catch:{ all -> 0x0078 }
            r13.<init>(r9, r1, r2, r0);	 Catch:{ all -> 0x0078 }
            r10.execute(r13);	 Catch:{ all -> 0x0078 }
            monitor-exit(r12);	 Catch:{ all -> 0x0078 }
            return;
        L_0x006e:
            monitor-exit(r12);	 Catch:{ all -> 0x0078 }
            r0.m25420a(r13);
            if (r10 == 0) goto L_0x0077;
        L_0x0074:
            r0.m25430i();
        L_0x0077:
            return;
        L_0x0078:
            r10 = move-exception;
            monitor-exit(r12);	 Catch:{ all -> 0x0078 }
            throw r10;
            */
            throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.e.g.c.a(boolean, int, int, java.util.List):void");
        }

        /* renamed from: a */
        public void mo5273a(int i, C6169b c6169b) {
            if (this.f25889c.m25389d(i)) {
                this.f25889c.m25387c(i, c6169b);
                return;
            }
            i = this.f25889c.m25381b(i);
            if (i != 0) {
                i.m25423c(c6169b);
            }
        }

        /* renamed from: a */
        public void mo5278a(boolean z, C6186n c6186n) {
            long j;
            synchronized (this.f25889c) {
                boolean d = this.f25889c.f19985m.m25472d();
                if (z) {
                    this.f25889c.f19985m.m25465a();
                }
                this.f25889c.f19985m.m25466a(c6186n);
                m33871a(c6186n);
                z = this.f25889c.f19985m.m25472d();
                C6180i[] c6180iArr = null;
                if (z || z == d) {
                    j = false;
                } else {
                    j = (long) (z - d);
                    if (!this.f25889c.f19986n) {
                        this.f25889c.m25376a(j);
                        this.f25889c.f19986n = true;
                    }
                    if (!this.f25889c.f19976d.isEmpty()) {
                        c6180iArr = (C6180i[]) this.f25889c.f19976d.values().toArray(new C6180i[this.f25889c.f19976d.size()]);
                    }
                }
                ExecutorService executorService = C6177g.f19972a;
                Object[] objArr = new Object[1];
                int i = 0;
                objArr[0] = this.f25889c.f19977e;
                executorService.execute(new C6155b(this, "OkHttp %s settings", objArr) {
                    /* renamed from: a */
                    final /* synthetic */ C7461c f25885a;

                    /* renamed from: c */
                    public void mo5268c() {
                        this.f25885a.f25889c.f19975c.mo5250a(this.f25885a.f25889c);
                    }
                });
            }
            if (c6180iArr != null && j != false) {
                int length = c6180iArr.length;
                while (i < length) {
                    C6180i c6180i = c6180iArr[i];
                    synchronized (c6180i) {
                        c6180i.m25417a(j);
                    }
                    i++;
                }
            }
        }

        /* renamed from: a */
        private void m33871a(final C6186n c6186n) {
            C6177g.f19972a.execute(new C6155b(this, "OkHttp %s ACK Settings", new Object[]{this.f25889c.f19977e}) {
                /* renamed from: c */
                final /* synthetic */ C7461c f25887c;

                /* renamed from: c */
                public void mo5268c() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r2 = this;
                    r0 = r2.f25887c;	 Catch:{ IOException -> 0x000b }
                    r0 = r0.f25889c;	 Catch:{ IOException -> 0x000b }
                    r0 = r0.f19988p;	 Catch:{ IOException -> 0x000b }
                    r1 = r7;	 Catch:{ IOException -> 0x000b }
                    r0.m25443a(r1);	 Catch:{ IOException -> 0x000b }
                L_0x000b:
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.e.g.c.3.c():void");
                }
            });
        }

        /* renamed from: a */
        public void mo5275a(boolean z, int i, int i2) {
            if (z) {
                z = this.f25889c.m25385c(i);
                if (z) {
                    z.m25458b();
                    return;
                }
                return;
            }
            this.f25889c.m25380a(true, i, i2, null);
        }

        /* renamed from: a */
        public void mo5274a(int i, C6169b c6169b, C6251f c6251f) {
            c6251f.mo5366h();
            synchronized (this.f25889c) {
                C6180i[] c6180iArr = (C6180i[]) this.f25889c.f19976d.values().toArray(new C6180i[this.f25889c.f19976d.size()]);
                this.f25889c.f19980h = true;
            }
            for (C6180i c6180i : c6180iArr) {
                if (c6180i.m25416a() > i && c6180i.m25424c()) {
                    c6180i.m25423c(C6169b.REFUSED_STREAM);
                    this.f25889c.m25381b(c6180i.m25416a());
                }
            }
        }

        /* renamed from: a */
        public void mo5272a(int i, long j) {
            if (i == 0) {
                synchronized (this.f25889c) {
                    i = this.f25889c;
                    i.f19983k += j;
                    this.f25889c.notifyAll();
                }
                return;
            }
            i = this.f25889c.m25368a(i);
            if (i != 0) {
                synchronized (i) {
                    i.m25417a(j);
                }
            }
        }

        /* renamed from: a */
        public void mo5271a(int i, int i2, List<C6170c> list) {
            this.f25889c.m25373a(i2, (List) list);
        }
    }

    /* renamed from: d */
    boolean m25389d(int i) {
        return i != 0 && (i & 1) == 0;
    }

    C6177g(C6175a c6175a) {
        this.f19981i = c6175a.f19969f;
        this.f19974b = c6175a.f19970g;
        this.f19975c = c6175a.f19968e;
        int i = 2;
        this.f19979g = c6175a.f19970g ? 1 : 2;
        if (c6175a.f19970g) {
            this.f19979g += 2;
        }
        if (c6175a.f19970g) {
            i = 1;
        }
        this.f19993v = i;
        if (c6175a.f19970g) {
            this.f19984l.m25464a(7, 16777216);
        }
        this.f19977e = c6175a.f19965b;
        this.f19991t = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), C6165c.m25313a(C6165c.m25308a("OkHttp %s Push Observer", this.f19977e), true));
        this.f19985m.m25464a(7, MinElf.PN_XNUM);
        this.f19985m.m25464a(5, 16384);
        this.f19983k = (long) this.f19985m.m25472d();
        this.f19987o = c6175a.f19964a;
        this.f19988p = new C6181j(c6175a.f19967d, this.f19974b);
        this.f19989q = new C7461c(this, new C6179h(c6175a.f19966c, this.f19974b));
    }

    /* renamed from: a */
    synchronized C6180i m25368a(int i) {
        return (C6180i) this.f19976d.get(Integer.valueOf(i));
    }

    /* renamed from: b */
    synchronized C6180i m25381b(int i) {
        C6180i c6180i;
        c6180i = (C6180i) this.f19976d.remove(Integer.valueOf(i));
        notifyAll();
        return c6180i;
    }

    /* renamed from: a */
    public synchronized int m25367a() {
        return this.f19985m.m25471c(Integer.MAX_VALUE);
    }

    /* renamed from: a */
    public C6180i m25369a(List<C6170c> list, boolean z) {
        return m25366b(0, list, z);
    }

    /* renamed from: b */
    private C6180i m25366b(int i, List<C6170c> list, boolean z) {
        C6180i c6180i;
        boolean z2 = z ^ 1;
        synchronized (this.f19988p) {
            synchronized (this) {
                if (this.f19980h) {
                    throw new C6168a();
                }
                int i2 = this.f19979g;
                this.f19979g += 2;
                c6180i = new C6180i(i2, this, z2, false, list);
                if (z && this.f19983k != 0) {
                    if (c6180i.f20001b != 0) {
                        z = false;
                        if (c6180i.m25422b()) {
                            this.f19976d.put(Integer.valueOf(i2), c6180i);
                        }
                    }
                }
                z = true;
                if (c6180i.m25422b()) {
                    this.f19976d.put(Integer.valueOf(i2), c6180i);
                }
            }
            if (i == 0) {
                this.f19988p.m25445a(z2, i2, i, (List) list);
            } else if (this.f19974b) {
                throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
            } else {
                this.f19988p.m25439a(i, i2, (List) list);
            }
        }
        if (z) {
            this.f19988p.m25448b();
        }
        return c6180i;
    }

    /* renamed from: a */
    public void m25375a(int r9, boolean r10, expolib_v1.p332b.C8170c r11, long r12) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r0 = 0;
        r1 = 0;
        r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1));
        if (r3 != 0) goto L_0x000d;
    L_0x0007:
        r12 = r8.f19988p;
        r12.m25446a(r10, r9, r11, r0);
        return;
    L_0x000d:
        r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1));
        if (r3 <= 0) goto L_0x0063;
    L_0x0011:
        monitor-enter(r8);
    L_0x0012:
        r3 = r8.f19983k;	 Catch:{ InterruptedException -> 0x005b }
        r3 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1));	 Catch:{ InterruptedException -> 0x005b }
        if (r3 > 0) goto L_0x0030;	 Catch:{ InterruptedException -> 0x005b }
    L_0x0018:
        r3 = r8.f19976d;	 Catch:{ InterruptedException -> 0x005b }
        r4 = java.lang.Integer.valueOf(r9);	 Catch:{ InterruptedException -> 0x005b }
        r3 = r3.containsKey(r4);	 Catch:{ InterruptedException -> 0x005b }
        if (r3 == 0) goto L_0x0028;	 Catch:{ InterruptedException -> 0x005b }
    L_0x0024:
        r8.wait();	 Catch:{ InterruptedException -> 0x005b }
        goto L_0x0012;	 Catch:{ InterruptedException -> 0x005b }
    L_0x0028:
        r9 = new java.io.IOException;	 Catch:{ InterruptedException -> 0x005b }
        r10 = "stream closed";	 Catch:{ InterruptedException -> 0x005b }
        r9.<init>(r10);	 Catch:{ InterruptedException -> 0x005b }
        throw r9;	 Catch:{ InterruptedException -> 0x005b }
    L_0x0030:
        r3 = r8.f19983k;	 Catch:{ all -> 0x0059 }
        r3 = java.lang.Math.min(r12, r3);	 Catch:{ all -> 0x0059 }
        r3 = (int) r3;	 Catch:{ all -> 0x0059 }
        r4 = r8.f19988p;	 Catch:{ all -> 0x0059 }
        r4 = r4.m25450c();	 Catch:{ all -> 0x0059 }
        r3 = java.lang.Math.min(r3, r4);	 Catch:{ all -> 0x0059 }
        r4 = r8.f19983k;	 Catch:{ all -> 0x0059 }
        r6 = (long) r3;	 Catch:{ all -> 0x0059 }
        r4 = r4 - r6;	 Catch:{ all -> 0x0059 }
        r8.f19983k = r4;	 Catch:{ all -> 0x0059 }
        monitor-exit(r8);	 Catch:{ all -> 0x0059 }
        r4 = 0;
        r12 = r12 - r6;
        r4 = r8.f19988p;
        if (r10 == 0) goto L_0x0054;
    L_0x004e:
        r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1));
        if (r5 != 0) goto L_0x0054;
    L_0x0052:
        r5 = 1;
        goto L_0x0055;
    L_0x0054:
        r5 = 0;
    L_0x0055:
        r4.m25446a(r5, r9, r11, r3);
        goto L_0x000d;
    L_0x0059:
        r9 = move-exception;
        goto L_0x0061;
    L_0x005b:
        r9 = new java.io.InterruptedIOException;	 Catch:{ all -> 0x0059 }
        r9.<init>();	 Catch:{ all -> 0x0059 }
        throw r9;	 Catch:{ all -> 0x0059 }
    L_0x0061:
        monitor-exit(r8);	 Catch:{ all -> 0x0059 }
        throw r9;
    L_0x0063:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.e.g.a(int, boolean, expolib_v1.b.c, long):void");
    }

    /* renamed from: a */
    void m25376a(long j) {
        this.f19983k += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* renamed from: a */
    void m25371a(int i, C6169b c6169b) {
        final int i2 = i;
        final C6169b c6169b2 = c6169b;
        f19972a.execute(new C6155b(this, "OkHttp %s stream %d", new Object[]{this.f19977e, Integer.valueOf(i)}) {
            /* renamed from: d */
            final /* synthetic */ C6177g f25859d;

            /* renamed from: c */
            public void mo5268c() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r3 = this;
                r0 = r3.f25859d;	 Catch:{ IOException -> 0x0009 }
                r1 = r5;	 Catch:{ IOException -> 0x0009 }
                r2 = r6;	 Catch:{ IOException -> 0x0009 }
                r0.m25383b(r1, r2);	 Catch:{ IOException -> 0x0009 }
            L_0x0009:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.e.g.1.c():void");
            }
        });
    }

    /* renamed from: b */
    void m25383b(int i, C6169b c6169b) {
        this.f19988p.m25441a(i, c6169b);
    }

    /* renamed from: a */
    void m25370a(int i, long j) {
        final int i2 = i;
        final long j2 = j;
        f19972a.execute(new C6155b(this, "OkHttp Window Update %s stream %d", new Object[]{this.f19977e, Integer.valueOf(i)}) {
            /* renamed from: d */
            final /* synthetic */ C6177g f25862d;

            /* renamed from: c */
            public void mo5268c() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r4 = this;
                r0 = r4.f25862d;	 Catch:{ IOException -> 0x000b }
                r0 = r0.f19988p;	 Catch:{ IOException -> 0x000b }
                r1 = r5;	 Catch:{ IOException -> 0x000b }
                r2 = r6;	 Catch:{ IOException -> 0x000b }
                r0.m25440a(r1, r2);	 Catch:{ IOException -> 0x000b }
            L_0x000b:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.e.g.2.c():void");
            }
        });
    }

    /* renamed from: a */
    void m25380a(boolean z, int i, int i2, C6184l c6184l) {
        final boolean z2 = z;
        final int i3 = i;
        final int i4 = i2;
        final C6184l c6184l2 = c6184l;
        f19972a.execute(new C6155b(this, "OkHttp %s ping %08x%08x", new Object[]{this.f19977e, Integer.valueOf(i), Integer.valueOf(i2)}) {
            /* renamed from: f */
            final /* synthetic */ C6177g f25867f;

            /* renamed from: c */
            public void mo5268c() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r5 = this;
                r0 = r5.f25867f;	 Catch:{ IOException -> 0x000d }
                r1 = r5;	 Catch:{ IOException -> 0x000d }
                r2 = r6;	 Catch:{ IOException -> 0x000d }
                r3 = r7;	 Catch:{ IOException -> 0x000d }
                r4 = r8;	 Catch:{ IOException -> 0x000d }
                r0.m25384b(r1, r2, r3, r4);	 Catch:{ IOException -> 0x000d }
            L_0x000d:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.e.g.3.c():void");
            }
        });
    }

    /* renamed from: b */
    void m25384b(boolean z, int i, int i2, C6184l c6184l) {
        synchronized (this.f19988p) {
            if (c6184l != null) {
                c6184l.m25457a();
            }
            this.f19988p.m25444a(z, i, i2);
        }
    }

    /* renamed from: c */
    synchronized C6184l m25385c(int i) {
        return this.f19992u != null ? (C6184l) this.f19992u.remove(Integer.valueOf(i)) : 0;
    }

    /* renamed from: b */
    public void m25382b() {
        this.f19988p.m25448b();
    }

    /* renamed from: a */
    public void m25377a(C6169b c6169b) {
        synchronized (this.f19988p) {
            synchronized (this) {
                if (this.f19980h) {
                    return;
                }
                this.f19980h = true;
                int i = this.f19978f;
                this.f19988p.m25442a(i, c6169b, C6165c.f19907a);
            }
        }
    }

    public void close() {
        m25378a(C6169b.NO_ERROR, C6169b.CANCEL);
    }

    /* renamed from: a */
    void m25378a(C6169b c6169b, C6169b c6169b2) {
        C6180i[] c6180iArr;
        if (!f19973s) {
            if (Thread.holdsLock(this)) {
                throw new AssertionError();
            }
        }
        Map map = null;
        try {
            m25377a(c6169b);
            c6169b = null;
        } catch (IOException e) {
            c6169b = e;
        }
        synchronized (this) {
            if (this.f19976d.isEmpty()) {
                c6180iArr = null;
            } else {
                c6180iArr = (C6180i[]) this.f19976d.values().toArray(new C6180i[this.f19976d.size()]);
                this.f19976d.clear();
            }
            if (this.f19992u != null) {
                C6184l[] c6184lArr = (C6184l[]) this.f19992u.values().toArray(new C6184l[this.f19992u.size()]);
                this.f19992u = null;
                map = c6184lArr;
            }
        }
        if (c6180iArr != null) {
            C6169b c6169b3 = c6169b;
            for (C6180i a : c6180iArr) {
                try {
                    a.m25418a(c6169b2);
                } catch (IOException e2) {
                    if (c6169b3 != null) {
                        c6169b3 = e2;
                    }
                }
            }
            c6169b = c6169b3;
        }
        if (map != null) {
            for (C6184l c : map) {
                c.m25459c();
            }
        }
        try {
            this.f19988p.close();
        } catch (C6169b c6169b22) {
            if (c6169b == null) {
                c6169b = c6169b22;
            }
        }
        try {
            this.f19987o.close();
        } catch (IOException e3) {
            c6169b = e3;
        }
        if (c6169b != null) {
            throw c6169b;
        }
    }

    /* renamed from: c */
    public void m25386c() {
        m25379a(true);
    }

    /* renamed from: a */
    void m25379a(boolean z) {
        if (z) {
            this.f19988p.m25436a();
            this.f19988p.m25449b(this.f19984l);
            z = this.f19984l.m25472d();
            if (!z) {
                this.f19988p.m25440a(0, (long) (z - true));
            }
        }
        new Thread(this.f19989q).start();
    }

    /* renamed from: d */
    public synchronized boolean m25388d() {
        return this.f19980h;
    }

    /* renamed from: a */
    void m25373a(int i, List<C6170c> list) {
        synchronized (this) {
            if (this.f19990r.contains(Integer.valueOf(i))) {
                m25371a(i, C6169b.PROTOCOL_ERROR);
                return;
            }
            this.f19990r.add(Integer.valueOf(i));
            final int i2 = i;
            final List<C6170c> list2 = list;
            this.f19991t.execute(new C6155b(this, "OkHttp %s Push Request[%s]", new Object[]{this.f19977e, Integer.valueOf(i)}) {
                /* renamed from: d */
                final /* synthetic */ C6177g f25870d;

                /* renamed from: c */
                public void mo5268c() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r3 = this;
                    r0 = r3.f25870d;
                    r0 = r0.f19981i;
                    r1 = r5;
                    r2 = r6;
                    r0 = r0.mo5281a(r1, r2);
                    if (r0 == 0) goto L_0x002e;
                L_0x000e:
                    r0 = r3.f25870d;	 Catch:{ IOException -> 0x002e }
                    r0 = r0.f19988p;	 Catch:{ IOException -> 0x002e }
                    r1 = r5;	 Catch:{ IOException -> 0x002e }
                    r2 = expolib_v1.p321a.p322a.p327e.C6169b.CANCEL;	 Catch:{ IOException -> 0x002e }
                    r0.m25441a(r1, r2);	 Catch:{ IOException -> 0x002e }
                    r0 = r3.f25870d;	 Catch:{ IOException -> 0x002e }
                    monitor-enter(r0);	 Catch:{ IOException -> 0x002e }
                    r1 = r3.f25870d;	 Catch:{ all -> 0x002b }
                    r1 = r1.f19990r;	 Catch:{ all -> 0x002b }
                    r2 = r5;	 Catch:{ all -> 0x002b }
                    r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x002b }
                    r1.remove(r2);	 Catch:{ all -> 0x002b }
                    monitor-exit(r0);	 Catch:{ all -> 0x002b }
                    goto L_0x002e;	 Catch:{ all -> 0x002b }
                L_0x002b:
                    r1 = move-exception;	 Catch:{ all -> 0x002b }
                    monitor-exit(r0);	 Catch:{ all -> 0x002b }
                    throw r1;	 Catch:{ IOException -> 0x002e }
                L_0x002e:
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.e.g.4.c():void");
                }
            });
        }
    }

    /* renamed from: a */
    void m25374a(int i, List<C6170c> list, boolean z) {
        final int i2 = i;
        final List<C6170c> list2 = list;
        final boolean z2 = z;
        this.f19991t.execute(new C6155b(this, "OkHttp %s Push Headers[%s]", new Object[]{this.f19977e, Integer.valueOf(i)}) {
            /* renamed from: e */
            final /* synthetic */ C6177g f25874e;

            /* renamed from: c */
            public void mo5268c() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r4 = this;
                r0 = r4.f25874e;
                r0 = r0.f19981i;
                r1 = r5;
                r2 = r6;
                r3 = r7;
                r0 = r0.mo5282a(r1, r2, r3);
                if (r0 == 0) goto L_0x001b;
            L_0x0010:
                r1 = r4.f25874e;	 Catch:{ IOException -> 0x0036 }
                r1 = r1.f19988p;	 Catch:{ IOException -> 0x0036 }
                r2 = r5;	 Catch:{ IOException -> 0x0036 }
                r3 = expolib_v1.p321a.p322a.p327e.C6169b.CANCEL;	 Catch:{ IOException -> 0x0036 }
                r1.m25441a(r2, r3);	 Catch:{ IOException -> 0x0036 }
            L_0x001b:
                if (r0 != 0) goto L_0x0021;	 Catch:{ IOException -> 0x0036 }
            L_0x001d:
                r0 = r7;	 Catch:{ IOException -> 0x0036 }
                if (r0 == 0) goto L_0x0036;	 Catch:{ IOException -> 0x0036 }
            L_0x0021:
                r0 = r4.f25874e;	 Catch:{ IOException -> 0x0036 }
                monitor-enter(r0);	 Catch:{ IOException -> 0x0036 }
                r1 = r4.f25874e;	 Catch:{ all -> 0x0033 }
                r1 = r1.f19990r;	 Catch:{ all -> 0x0033 }
                r2 = r5;	 Catch:{ all -> 0x0033 }
                r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x0033 }
                r1.remove(r2);	 Catch:{ all -> 0x0033 }
                monitor-exit(r0);	 Catch:{ all -> 0x0033 }
                goto L_0x0036;	 Catch:{ all -> 0x0033 }
            L_0x0033:
                r1 = move-exception;	 Catch:{ all -> 0x0033 }
                monitor-exit(r0);	 Catch:{ all -> 0x0033 }
                throw r1;	 Catch:{ IOException -> 0x0036 }
            L_0x0036:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.e.g.5.c():void");
            }
        });
    }

    /* renamed from: a */
    void m25372a(int i, C7497e c7497e, int i2, boolean z) {
        final C8170c c8170c = new C8170c();
        long j = (long) i2;
        c7497e.mo6370a(j);
        c7497e.read(c8170c, j);
        if (c8170c.m39582a() == j) {
            final int i3 = i;
            final int i4 = i2;
            final boolean z2 = z;
            this.f19991t.execute(new C6155b(this, "OkHttp %s Push Data[%s]", new Object[]{this.f19977e, Integer.valueOf(i)}) {
                /* renamed from: f */
                final /* synthetic */ C6177g f25879f;

                /* renamed from: c */
                public void mo5268c() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r5 = this;
                    r0 = r5.f25879f;	 Catch:{ IOException -> 0x0038 }
                    r0 = r0.f19981i;	 Catch:{ IOException -> 0x0038 }
                    r1 = r4;	 Catch:{ IOException -> 0x0038 }
                    r2 = r5;	 Catch:{ IOException -> 0x0038 }
                    r3 = r6;	 Catch:{ IOException -> 0x0038 }
                    r4 = r7;	 Catch:{ IOException -> 0x0038 }
                    r0 = r0.mo5280a(r1, r2, r3, r4);	 Catch:{ IOException -> 0x0038 }
                    if (r0 == 0) goto L_0x001d;	 Catch:{ IOException -> 0x0038 }
                L_0x0012:
                    r1 = r5.f25879f;	 Catch:{ IOException -> 0x0038 }
                    r1 = r1.f19988p;	 Catch:{ IOException -> 0x0038 }
                    r2 = r4;	 Catch:{ IOException -> 0x0038 }
                    r3 = expolib_v1.p321a.p322a.p327e.C6169b.CANCEL;	 Catch:{ IOException -> 0x0038 }
                    r1.m25441a(r2, r3);	 Catch:{ IOException -> 0x0038 }
                L_0x001d:
                    if (r0 != 0) goto L_0x0023;	 Catch:{ IOException -> 0x0038 }
                L_0x001f:
                    r0 = r7;	 Catch:{ IOException -> 0x0038 }
                    if (r0 == 0) goto L_0x0038;	 Catch:{ IOException -> 0x0038 }
                L_0x0023:
                    r0 = r5.f25879f;	 Catch:{ IOException -> 0x0038 }
                    monitor-enter(r0);	 Catch:{ IOException -> 0x0038 }
                    r1 = r5.f25879f;	 Catch:{ all -> 0x0035 }
                    r1 = r1.f19990r;	 Catch:{ all -> 0x0035 }
                    r2 = r4;	 Catch:{ all -> 0x0035 }
                    r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x0035 }
                    r1.remove(r2);	 Catch:{ all -> 0x0035 }
                    monitor-exit(r0);	 Catch:{ all -> 0x0035 }
                    goto L_0x0038;	 Catch:{ all -> 0x0035 }
                L_0x0035:
                    r1 = move-exception;	 Catch:{ all -> 0x0035 }
                    monitor-exit(r0);	 Catch:{ all -> 0x0035 }
                    throw r1;	 Catch:{ IOException -> 0x0038 }
                L_0x0038:
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.e.g.6.c():void");
                }
            });
            return;
        }
        c7497e = new StringBuilder();
        c7497e.append(c8170c.m39582a());
        c7497e.append(" != ");
        c7497e.append(i2);
        throw new IOException(c7497e.toString());
    }

    /* renamed from: c */
    void m25387c(int i, C6169b c6169b) {
        final int i2 = i;
        final C6169b c6169b2 = c6169b;
        this.f19991t.execute(new C6155b(this, "OkHttp %s Push Reset[%s]", new Object[]{this.f19977e, Integer.valueOf(i)}) {
            /* renamed from: d */
            final /* synthetic */ C6177g f25882d;

            /* renamed from: c */
            public void mo5268c() {
                this.f25882d.f19981i.mo5279a(i2, c6169b2);
                synchronized (this.f25882d) {
                    this.f25882d.f19990r.remove(Integer.valueOf(i2));
                }
            }
        });
    }
}
