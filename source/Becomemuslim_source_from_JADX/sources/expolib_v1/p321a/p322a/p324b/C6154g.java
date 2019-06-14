package expolib_v1.p321a.p322a.p324b;

import expolib_v1.p321a.C6207a;
import expolib_v1.p321a.C6224j;
import expolib_v1.p321a.C7490w;
import expolib_v1.p321a.ad;
import expolib_v1.p321a.p322a.C6148a;
import expolib_v1.p321a.p322a.C6165c;
import expolib_v1.p321a.p322a.p325c.C6157c;
import expolib_v1.p321a.p322a.p327e.C6168a;
import expolib_v1.p321a.p322a.p327e.C6169b;
import expolib_v1.p321a.p322a.p327e.C6187o;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;

/* compiled from: StreamAllocation */
/* renamed from: expolib_v1.a.a.b.g */
public final class C6154g {
    /* renamed from: b */
    static final /* synthetic */ boolean f19886b = (C6154g.class.desiredAssertionStatus() ^ 1);
    /* renamed from: a */
    public final C6207a f19887a;
    /* renamed from: c */
    private ad f19888c;
    /* renamed from: d */
    private final C6224j f19889d;
    /* renamed from: e */
    private final Object f19890e;
    /* renamed from: f */
    private final C6152f f19891f;
    /* renamed from: g */
    private int f19892g;
    /* renamed from: h */
    private C7439c f19893h;
    /* renamed from: i */
    private boolean f19894i;
    /* renamed from: j */
    private boolean f19895j;
    /* renamed from: k */
    private C6157c f19896k;

    /* compiled from: StreamAllocation */
    /* renamed from: expolib_v1.a.a.b.g$a */
    public static final class C6153a extends WeakReference<C6154g> {
        /* renamed from: a */
        public final Object f19885a;

        C6153a(C6154g c6154g, Object obj) {
            super(c6154g);
            this.f19885a = obj;
        }
    }

    public C6154g(C6224j c6224j, C6207a c6207a, Object obj) {
        this.f19889d = c6224j;
        this.f19887a = c6207a;
        this.f19891f = new C6152f(c6207a, m25255g());
        this.f19890e = obj;
    }

    /* renamed from: a */
    public C6157c m25257a(C7490w c7490w, boolean z) {
        try {
            c7490w = m25252a(c7490w.m33969a(), c7490w.m33972b(), c7490w.m33973c(), c7490w.m33989s(), z).m33804a(c7490w, this);
            synchronized (this.f19889d) {
                this.f19896k = c7490w;
            }
            return c7490w;
        } catch (C7490w c7490w2) {
            throw new C6151e(c7490w2);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private expolib_v1.p321a.p322a.p324b.C7439c m25252a(int r4, int r5, int r6, boolean r7, boolean r8) {
        /*
        r3 = this;
    L_0x0000:
        r0 = r3.m25251a(r4, r5, r6, r7);
        r1 = r3.f19889d;
        monitor-enter(r1);
        r2 = r0.f25799b;	 Catch:{ all -> 0x0019 }
        if (r2 != 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        return r0;
    L_0x000d:
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        r1 = r0.m33811a(r8);
        if (r1 != 0) goto L_0x0018;
    L_0x0014:
        r3.m25264d();
        goto L_0x0000;
    L_0x0018:
        return r0;
    L_0x0019:
        r4 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.b.g.a(int, int, int, boolean, boolean):expolib_v1.a.a.b.c");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private expolib_v1.p321a.p322a.p324b.C7439c m25251a(int r5, int r6, int r7, boolean r8) {
        /*
        r4 = this;
        r0 = r4.f19889d;
        monitor-enter(r0);
        r1 = r4.f19894i;	 Catch:{ all -> 0x00a2 }
        if (r1 != 0) goto L_0x009a;
    L_0x0007:
        r1 = r4.f19896k;	 Catch:{ all -> 0x00a2 }
        if (r1 != 0) goto L_0x0092;
    L_0x000b:
        r1 = r4.f19895j;	 Catch:{ all -> 0x00a2 }
        if (r1 != 0) goto L_0x008a;
    L_0x000f:
        r1 = r4.f19893h;	 Catch:{ all -> 0x00a2 }
        if (r1 == 0) goto L_0x0019;
    L_0x0013:
        r2 = r1.f25798a;	 Catch:{ all -> 0x00a2 }
        if (r2 != 0) goto L_0x0019;
    L_0x0017:
        monitor-exit(r0);	 Catch:{ all -> 0x00a2 }
        return r1;
    L_0x0019:
        r1 = expolib_v1.p321a.p322a.C6148a.f19868a;	 Catch:{ all -> 0x00a2 }
        r2 = r4.f19889d;	 Catch:{ all -> 0x00a2 }
        r3 = r4.f19887a;	 Catch:{ all -> 0x00a2 }
        r1.mo5329a(r2, r3, r4);	 Catch:{ all -> 0x00a2 }
        r1 = r4.f19893h;	 Catch:{ all -> 0x00a2 }
        if (r1 == 0) goto L_0x002a;
    L_0x0026:
        r5 = r4.f19893h;	 Catch:{ all -> 0x00a2 }
        monitor-exit(r0);	 Catch:{ all -> 0x00a2 }
        return r5;
    L_0x002a:
        r1 = r4.f19888c;	 Catch:{ all -> 0x00a2 }
        monitor-exit(r0);	 Catch:{ all -> 0x00a2 }
        if (r1 != 0) goto L_0x0035;
    L_0x002f:
        r0 = r4.f19891f;
        r1 = r0.m25250b();
    L_0x0035:
        r2 = r4.f19889d;
        monitor-enter(r2);
        r4.f19888c = r1;	 Catch:{ all -> 0x0087 }
        r0 = 0;
        r4.f19892g = r0;	 Catch:{ all -> 0x0087 }
        r0 = new expolib_v1.a.a.b.c;	 Catch:{ all -> 0x0087 }
        r3 = r4.f19889d;	 Catch:{ all -> 0x0087 }
        r0.<init>(r3, r1);	 Catch:{ all -> 0x0087 }
        r4.m25258a(r0);	 Catch:{ all -> 0x0087 }
        r1 = r4.f19895j;	 Catch:{ all -> 0x0087 }
        if (r1 != 0) goto L_0x007f;
    L_0x004b:
        monitor-exit(r2);	 Catch:{ all -> 0x0087 }
        r0.m33807a(r5, r6, r7, r8);
        r5 = r4.m25255g();
        r6 = r0.mo5249a();
        r5.m25234b(r6);
        r5 = 0;
        r6 = r4.f19889d;
        monitor-enter(r6);
        r7 = expolib_v1.p321a.p322a.C6148a.f19868a;	 Catch:{ all -> 0x007c }
        r8 = r4.f19889d;	 Catch:{ all -> 0x007c }
        r7.mo5338b(r8, r0);	 Catch:{ all -> 0x007c }
        r7 = r0.m33815e();	 Catch:{ all -> 0x007c }
        if (r7 == 0) goto L_0x0077;
    L_0x006b:
        r5 = expolib_v1.p321a.p322a.C6148a.f19868a;	 Catch:{ all -> 0x007c }
        r7 = r4.f19889d;	 Catch:{ all -> 0x007c }
        r8 = r4.f19887a;	 Catch:{ all -> 0x007c }
        r5 = r5.mo5337b(r7, r8, r4);	 Catch:{ all -> 0x007c }
        r0 = r4.f19893h;	 Catch:{ all -> 0x007c }
    L_0x0077:
        monitor-exit(r6);	 Catch:{ all -> 0x007c }
        expolib_v1.p321a.p322a.C6165c.m25316a(r5);
        return r0;
    L_0x007c:
        r5 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x007c }
        throw r5;
    L_0x007f:
        r5 = new java.io.IOException;	 Catch:{ all -> 0x0087 }
        r6 = "Canceled";
        r5.<init>(r6);	 Catch:{ all -> 0x0087 }
        throw r5;	 Catch:{ all -> 0x0087 }
    L_0x0087:
        r5 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0087 }
        throw r5;
    L_0x008a:
        r5 = new java.io.IOException;	 Catch:{ all -> 0x00a2 }
        r6 = "Canceled";
        r5.<init>(r6);	 Catch:{ all -> 0x00a2 }
        throw r5;	 Catch:{ all -> 0x00a2 }
    L_0x0092:
        r5 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x00a2 }
        r6 = "codec != null";
        r5.<init>(r6);	 Catch:{ all -> 0x00a2 }
        throw r5;	 Catch:{ all -> 0x00a2 }
    L_0x009a:
        r5 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x00a2 }
        r6 = "released";
        r5.<init>(r6);	 Catch:{ all -> 0x00a2 }
        throw r5;	 Catch:{ all -> 0x00a2 }
    L_0x00a2:
        r5 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x00a2 }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.b.g.a(int, int, int, boolean):expolib_v1.a.a.b.c");
    }

    /* renamed from: a */
    public void m25260a(boolean z, C6157c c6157c) {
        Socket a;
        synchronized (this.f19889d) {
            if (c6157c != null) {
                if (c6157c == this.f19896k) {
                    if (!z) {
                        C7439c c7439c = this.f19893h;
                        c7439c.f25799b++;
                    }
                    a = m25253a(z, false, true);
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("expected ");
            stringBuilder.append(this.f19896k);
            stringBuilder.append(" but was ");
            stringBuilder.append(c6157c);
            throw new IllegalStateException(stringBuilder.toString());
        }
        C6165c.m25316a(a);
    }

    /* renamed from: a */
    public C6157c m25256a() {
        C6157c c6157c;
        synchronized (this.f19889d) {
            c6157c = this.f19896k;
        }
        return c6157c;
    }

    /* renamed from: g */
    private C6150d m25255g() {
        return C6148a.f19868a.mo5330a(this.f19889d);
    }

    /* renamed from: b */
    public synchronized C7439c m25261b() {
        return this.f19893h;
    }

    /* renamed from: c */
    public void m25263c() {
        Socket a;
        synchronized (this.f19889d) {
            a = m25253a(false, true, false);
        }
        C6165c.m25316a(a);
    }

    /* renamed from: d */
    public void m25264d() {
        Socket a;
        synchronized (this.f19889d) {
            a = m25253a(true, false, false);
        }
        C6165c.m25316a(a);
    }

    /* renamed from: a */
    private Socket m25253a(boolean z, boolean z2, boolean z3) {
        if (!f19886b) {
            if (!Thread.holdsLock(this.f19889d)) {
                throw new AssertionError();
            }
        }
        if (z3) {
            this.f19896k = null;
        }
        if (z2) {
            this.f19894i = true;
        }
        if (this.f19893h) {
            if (z) {
                this.f19893h.f25798a = true;
            }
            if (!this.f19896k && (this.f19894i || this.f19893h.f25798a)) {
                m25254c(this.f19893h);
                if (this.f19893h.f25801d.isEmpty()) {
                    this.f19893h.f25802e = System.nanoTime();
                    if (C6148a.f19868a.mo5336a(this.f19889d, this.f19893h)) {
                        z = this.f19893h.m33813c();
                        this.f19893h = null;
                        return z;
                    }
                }
                z = false;
                this.f19893h = null;
                return z;
            }
        }
        return false;
    }

    /* renamed from: e */
    public void m25265e() {
        synchronized (this.f19889d) {
            this.f19895j = true;
            C6157c c6157c = this.f19896k;
            C7439c c7439c = this.f19893h;
        }
        if (c6157c != null) {
            c6157c.mo5267c();
        } else if (c7439c != null) {
            c7439c.m33812b();
        }
    }

    /* renamed from: a */
    public void m25259a(IOException iOException) {
        Socket a;
        synchronized (this.f19889d) {
            if (iOException instanceof C6187o) {
                C6187o c6187o = (C6187o) iOException;
                if (c6187o.f20032a == C6169b.REFUSED_STREAM) {
                    this.f19892g++;
                }
                if (c6187o.f20032a != C6169b.REFUSED_STREAM || this.f19892g > 1) {
                    this.f19888c = null;
                }
                iOException = null;
                a = m25253a(iOException, false, true);
            } else {
                if (this.f19893h != null && (!this.f19893h.m33815e() || (iOException instanceof C6168a))) {
                    if (this.f19893h.f25799b == 0) {
                        if (!(this.f19888c == null || iOException == null)) {
                            this.f19891f.m25248a(this.f19888c, iOException);
                        }
                        this.f19888c = null;
                    }
                }
                iOException = null;
                a = m25253a(iOException, false, true);
            }
            iOException = true;
            a = m25253a(iOException, false, true);
        }
        C6165c.m25316a(a);
    }

    /* renamed from: a */
    public void m25258a(C7439c c7439c) {
        if (!f19886b) {
            if (!Thread.holdsLock(this.f19889d)) {
                throw new AssertionError();
            }
        }
        if (this.f19893h == null) {
            this.f19893h = c7439c;
            c7439c.f25801d.add(new C6153a(this, this.f19890e));
            return;
        }
        throw new IllegalStateException();
    }

    /* renamed from: c */
    private void m25254c(C7439c c7439c) {
        int size = c7439c.f25801d.size();
        for (int i = 0; i < size; i++) {
            if (((Reference) c7439c.f25801d.get(i)).get() == this) {
                c7439c.f25801d.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    /* renamed from: b */
    public Socket m25262b(C7439c c7439c) {
        if (!f19886b) {
            if (!Thread.holdsLock(this.f19889d)) {
                throw new AssertionError();
            }
        }
        if (this.f19896k == null && this.f19893h.f25801d.size() == 1) {
            Reference reference = (Reference) this.f19893h.f25801d.get(0);
            Socket a = m25253a(true, false, false);
            this.f19893h = c7439c;
            c7439c.f25801d.add(reference);
            return a;
        }
        throw new IllegalStateException();
    }

    /* renamed from: f */
    public boolean m25266f() {
        if (this.f19888c == null) {
            if (!this.f19891f.m25249a()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        C7439c b = m25261b();
        return b != null ? b.toString() : this.f19887a.toString();
    }
}
