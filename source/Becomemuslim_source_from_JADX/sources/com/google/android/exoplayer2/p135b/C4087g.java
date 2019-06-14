package com.google.android.exoplayer2.p135b;

import com.google.android.exoplayer2.p164l.C2516a;
import java.util.LinkedList;

/* compiled from: SimpleDecoder */
/* renamed from: com.google.android.exoplayer2.b.g */
public abstract class C4087g<I extends C4085e, O extends C4086f, E extends Exception> implements C2248c<I, O, E> {
    /* renamed from: a */
    private final Thread f10323a;
    /* renamed from: b */
    private final Object f10324b = new Object();
    /* renamed from: c */
    private final LinkedList<I> f10325c = new LinkedList();
    /* renamed from: d */
    private final LinkedList<O> f10326d = new LinkedList();
    /* renamed from: e */
    private final I[] f10327e;
    /* renamed from: f */
    private final O[] f10328f;
    /* renamed from: g */
    private int f10329g;
    /* renamed from: h */
    private int f10330h;
    /* renamed from: i */
    private I f10331i;
    /* renamed from: j */
    private E f10332j;
    /* renamed from: k */
    private boolean f10333k;
    /* renamed from: l */
    private boolean f10334l;
    /* renamed from: m */
    private int f10335m;

    /* compiled from: SimpleDecoder */
    /* renamed from: com.google.android.exoplayer2.b.g$1 */
    class C22501 extends Thread {
        /* renamed from: a */
        final /* synthetic */ C4087g f5374a;

        C22501(C4087g c4087g) {
            this.f5374a = c4087g;
        }

        public void run() {
            this.f5374a.m12762k();
        }
    }

    /* renamed from: a */
    protected abstract E mo3243a(I i, O o, boolean z);

    /* renamed from: g */
    protected abstract I mo3245g();

    /* renamed from: h */
    protected abstract O mo3246h();

    /* renamed from: a */
    public /* synthetic */ Object mo2146a() {
        return m12774e();
    }

    /* renamed from: b */
    public /* synthetic */ Object mo2148b() {
        return m12775f();
    }

    protected C4087g(I[] iArr, O[] oArr) {
        this.f10327e = iArr;
        this.f10329g = iArr.length;
        for (int i = 0; i < this.f10329g; i++) {
            this.f10327e[i] = mo3245g();
        }
        this.f10328f = oArr;
        this.f10330h = oArr.length;
        for (iArr = null; iArr < this.f10330h; iArr++) {
            this.f10328f[iArr] = mo3246h();
        }
        this.f10323a = new C22501(this);
        this.f10323a.start();
    }

    /* renamed from: a */
    protected final void m12767a(int i) {
        C2516a.m7019b(this.f10329g == this.f10327e.length);
        for (C4085e e : this.f10327e) {
            e.m12753e(i);
        }
    }

    /* renamed from: e */
    public final I m12774e() {
        I i;
        synchronized (this.f10324b) {
            C4085e c4085e;
            mo3247i();
            C2516a.m7019b(this.f10331i == null);
            if (this.f10329g == 0) {
                c4085e = null;
            } else {
                C4085e[] c4085eArr = this.f10327e;
                int i2 = this.f10329g - 1;
                this.f10329g = i2;
                c4085e = c4085eArr[i2];
            }
            this.f10331i = c4085e;
            i = this.f10331i;
        }
        return i;
    }

    /* renamed from: a */
    public final void m12768a(I i) {
        synchronized (this.f10324b) {
            mo3247i();
            C2516a.m7017a(i == this.f10331i);
            this.f10325c.addLast(i);
            mo3248j();
            this.f10331i = null;
        }
    }

    /* renamed from: f */
    public final O m12775f() {
        synchronized (this.f10324b) {
            mo3247i();
            if (this.f10326d.isEmpty()) {
                return null;
            }
            C4086f c4086f = (C4086f) this.f10326d.removeFirst();
            return c4086f;
        }
    }

    /* renamed from: a */
    protected void mo3244a(O o) {
        synchronized (this.f10324b) {
            m12759b((C4086f) o);
            mo3248j();
        }
    }

    /* renamed from: c */
    public final void mo2149c() {
        synchronized (this.f10324b) {
            this.f10333k = true;
            this.f10335m = 0;
            if (this.f10331i != null) {
                m12758b(this.f10331i);
                this.f10331i = null;
            }
            while (!this.f10325c.isEmpty()) {
                m12758b((C4085e) this.f10325c.removeFirst());
            }
            while (!this.f10326d.isEmpty()) {
                m12759b((C4086f) this.f10326d.removeFirst());
            }
        }
    }

    /* renamed from: d */
    public void mo2150d() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r2 = this;
        r0 = r2.f10324b;
        monitor-enter(r0);
        r1 = 1;
        r2.f10334l = r1;	 Catch:{ all -> 0x001a }
        r1 = r2.f10324b;	 Catch:{ all -> 0x001a }
        r1.notify();	 Catch:{ all -> 0x001a }
        monitor-exit(r0);	 Catch:{ all -> 0x001a }
        r0 = r2.f10323a;	 Catch:{ InterruptedException -> 0x0012 }
        r0.join();	 Catch:{ InterruptedException -> 0x0012 }
        goto L_0x0019;
    L_0x0012:
        r0 = java.lang.Thread.currentThread();
        r0.interrupt();
    L_0x0019:
        return;
    L_0x001a:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x001a }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.b.g.d():void");
    }

    /* renamed from: i */
    private void mo3247i() {
        if (this.f10332j != null) {
            throw this.f10332j;
        }
    }

    /* renamed from: j */
    private void mo3248j() {
        if (m12764m()) {
            this.f10324b.notify();
        }
    }

    /* renamed from: k */
    private void m12762k() {
        while (m12763l()) {
            try {
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: l */
    private boolean m12763l() {
        /*
        r6 = this;
        r0 = r6.f10324b;
        monitor-enter(r0);
    L_0x0003:
        r1 = r6.f10334l;	 Catch:{ all -> 0x0086 }
        if (r1 != 0) goto L_0x0013;
    L_0x0007:
        r1 = r6.m12764m();	 Catch:{ all -> 0x0086 }
        if (r1 != 0) goto L_0x0013;
    L_0x000d:
        r1 = r6.f10324b;	 Catch:{ all -> 0x0086 }
        r1.wait();	 Catch:{ all -> 0x0086 }
        goto L_0x0003;
    L_0x0013:
        r1 = r6.f10334l;	 Catch:{ all -> 0x0086 }
        r2 = 0;
        if (r1 == 0) goto L_0x001a;
    L_0x0018:
        monitor-exit(r0);	 Catch:{ all -> 0x0086 }
        return r2;
    L_0x001a:
        r1 = r6.f10325c;	 Catch:{ all -> 0x0086 }
        r1 = r1.removeFirst();	 Catch:{ all -> 0x0086 }
        r1 = (com.google.android.exoplayer2.p135b.C4085e) r1;	 Catch:{ all -> 0x0086 }
        r3 = r6.f10328f;	 Catch:{ all -> 0x0086 }
        r4 = r6.f10330h;	 Catch:{ all -> 0x0086 }
        r5 = 1;
        r4 = r4 - r5;
        r6.f10330h = r4;	 Catch:{ all -> 0x0086 }
        r3 = r3[r4];	 Catch:{ all -> 0x0086 }
        r4 = r6.f10333k;	 Catch:{ all -> 0x0086 }
        r6.f10333k = r2;	 Catch:{ all -> 0x0086 }
        monitor-exit(r0);	 Catch:{ all -> 0x0086 }
        r0 = r1.m6206c();
        if (r0 == 0) goto L_0x003c;
    L_0x0037:
        r0 = 4;
        r3.m6204b(r0);
        goto L_0x0059;
    L_0x003c:
        r0 = r1.g_();
        if (r0 == 0) goto L_0x0047;
    L_0x0042:
        r0 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r3.m6204b(r0);
    L_0x0047:
        r0 = r6.mo3243a(r1, r3, r4);
        r6.f10332j = r0;
        r0 = r6.f10332j;
        if (r0 == 0) goto L_0x0059;
    L_0x0051:
        r0 = r6.f10324b;
        monitor-enter(r0);
        monitor-exit(r0);	 Catch:{ all -> 0x0056 }
        return r2;
    L_0x0056:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0056 }
        throw r1;
    L_0x0059:
        r4 = r6.f10324b;
        monitor-enter(r4);
        r0 = r6.f10333k;	 Catch:{ all -> 0x0083 }
        if (r0 == 0) goto L_0x0064;
    L_0x0060:
        r6.m12759b(r3);	 Catch:{ all -> 0x0083 }
        goto L_0x007e;
    L_0x0064:
        r0 = r3.g_();	 Catch:{ all -> 0x0083 }
        if (r0 == 0) goto L_0x0073;
    L_0x006a:
        r0 = r6.f10335m;	 Catch:{ all -> 0x0083 }
        r0 = r0 + r5;
        r6.f10335m = r0;	 Catch:{ all -> 0x0083 }
        r6.m12759b(r3);	 Catch:{ all -> 0x0083 }
        goto L_0x007e;
    L_0x0073:
        r0 = r6.f10335m;	 Catch:{ all -> 0x0083 }
        r3.f10322b = r0;	 Catch:{ all -> 0x0083 }
        r6.f10335m = r2;	 Catch:{ all -> 0x0083 }
        r0 = r6.f10326d;	 Catch:{ all -> 0x0083 }
        r0.addLast(r3);	 Catch:{ all -> 0x0083 }
    L_0x007e:
        r6.m12758b(r1);	 Catch:{ all -> 0x0083 }
        monitor-exit(r4);	 Catch:{ all -> 0x0083 }
        return r5;
    L_0x0083:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0083 }
        throw r0;
    L_0x0086:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0086 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.b.g.l():boolean");
    }

    /* renamed from: m */
    private boolean m12764m() {
        return !this.f10325c.isEmpty() && this.f10330h > 0;
    }

    /* renamed from: b */
    private void m12758b(I i) {
        i.mo2145a();
        C4085e[] c4085eArr = this.f10327e;
        int i2 = this.f10329g;
        this.f10329g = i2 + 1;
        c4085eArr[i2] = i;
    }

    /* renamed from: b */
    private void m12759b(O o) {
        o.mo2145a();
        C4086f[] c4086fArr = this.f10328f;
        int i = this.f10330h;
        this.f10330h = i + 1;
        c4086fArr[i] = o;
    }
}
