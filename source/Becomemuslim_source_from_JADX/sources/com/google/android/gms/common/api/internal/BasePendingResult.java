package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.C2789g;
import com.google.android.gms.common.api.C2789g.C2788a;
import com.google.android.gms.common.api.C2791i;
import com.google.android.gms.common.api.C2814k;
import com.google.android.gms.common.api.C2815l;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C2863p;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.internal.p205d.C4956e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@KeepName
public abstract class BasePendingResult<R extends C2814k> extends C2789g<R> {
    /* renamed from: c */
    static final ThreadLocal<Boolean> f11381c = new cn();
    /* renamed from: a */
    private final Object f11382a;
    /* renamed from: b */
    private final C4346a<R> f11383b;
    /* renamed from: d */
    private final WeakReference<GoogleApiClient> f11384d;
    /* renamed from: e */
    private final CountDownLatch f11385e;
    /* renamed from: f */
    private final ArrayList<C2788a> f11386f;
    /* renamed from: g */
    private C2815l<? super R> f11387g;
    /* renamed from: h */
    private final AtomicReference<cb> f11388h;
    /* renamed from: i */
    private R f11389i;
    /* renamed from: j */
    private Status f11390j;
    /* renamed from: k */
    private volatile boolean f11391k;
    /* renamed from: l */
    private boolean f11392l;
    /* renamed from: m */
    private boolean f11393m;
    @KeepName
    private C2792b mResultGuardian;
    /* renamed from: n */
    private C2863p f11394n;
    /* renamed from: o */
    private volatile bv<R> f11395o;
    /* renamed from: p */
    private boolean f11396p;

    /* renamed from: com.google.android.gms.common.api.internal.BasePendingResult$b */
    private final class C2792b {
        /* renamed from: a */
        private final /* synthetic */ BasePendingResult f7119a;

        private C2792b(BasePendingResult basePendingResult) {
            this.f7119a = basePendingResult;
        }

        protected final void finalize() {
            BasePendingResult.m14060c(this.f7119a.f11389i);
            super.finalize();
        }
    }

    /* renamed from: com.google.android.gms.common.api.internal.BasePendingResult$a */
    public static class C4346a<R extends C2814k> extends C4956e {
        public C4346a() {
            this(Looper.getMainLooper());
        }

        public C4346a(Looper looper) {
            super(looper);
        }

        /* renamed from: a */
        public final void m14057a(C2815l<? super R> c2815l, R r) {
            sendMessage(obtainMessage(1, new Pair(c2815l, r)));
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Pair pair = (Pair) message.obj;
                    C2815l c2815l = (C2815l) pair.first;
                    C2814k c2814k = (C2814k) pair.second;
                    try {
                        c2815l.onResult(c2814k);
                        return;
                    } catch (RuntimeException e) {
                        BasePendingResult.m14060c(c2814k);
                        throw e;
                    }
                case 2:
                    ((BasePendingResult) message.obj).m14072c(Status.f13154d);
                    return;
                default:
                    message = message.what;
                    StringBuilder stringBuilder = new StringBuilder(45);
                    stringBuilder.append("Don't know how to handle message: ");
                    stringBuilder.append(message);
                    Log.wtf("BasePendingResult", stringBuilder.toString(), new Exception());
                    return;
            }
        }
    }

    @Deprecated
    BasePendingResult() {
        this.f11382a = new Object();
        this.f11385e = new CountDownLatch(1);
        this.f11386f = new ArrayList();
        this.f11388h = new AtomicReference();
        this.f11396p = false;
        this.f11383b = new C4346a(Looper.getMainLooper());
        this.f11384d = new WeakReference(null);
    }

    /* renamed from: a */
    protected abstract R mo3278a(Status status);

    /* renamed from: c */
    public final Integer mo2382c() {
        return null;
    }

    protected BasePendingResult(GoogleApiClient googleApiClient) {
        this.f11382a = new Object();
        this.f11385e = new CountDownLatch(1);
        this.f11386f = new ArrayList();
        this.f11388h = new AtomicReference();
        this.f11396p = false;
        this.f11383b = new C4346a(googleApiClient != null ? googleApiClient.mo2412c() : Looper.getMainLooper());
        this.f11384d = new WeakReference(googleApiClient);
    }

    @Deprecated
    protected BasePendingResult(Looper looper) {
        this.f11382a = new Object();
        this.f11385e = new CountDownLatch(1);
        this.f11386f = new ArrayList();
        this.f11388h = new AtomicReference();
        this.f11396p = false;
        this.f11383b = new C4346a(looper);
        this.f11384d = new WeakReference(null);
    }

    /* renamed from: f */
    public final boolean m14073f() {
        return this.f11385e.getCount() == 0;
    }

    /* renamed from: a */
    public final R mo2376a(long r4, java.util.concurrent.TimeUnit r6) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r3 = this;
        r0 = 0;
        r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x000b;
    L_0x0006:
        r0 = "await must not be called on the UI thread when time is greater than zero.";
        com.google.android.gms.common.internal.C2872v.m8393c(r0);
    L_0x000b:
        r0 = r3.f11391k;
        r1 = 1;
        r0 = r0 ^ r1;
        r2 = "Result has already been consumed.";
        com.google.android.gms.common.internal.C2872v.m8387a(r0, r2);
        r0 = r3.f11395o;
        if (r0 != 0) goto L_0x0019;
    L_0x0018:
        goto L_0x001a;
    L_0x0019:
        r1 = 0;
    L_0x001a:
        r0 = "Cannot await if then() has been called.";
        com.google.android.gms.common.internal.C2872v.m8387a(r1, r0);
        r0 = r3.f11385e;	 Catch:{ InterruptedException -> 0x002d }
        r4 = r0.await(r4, r6);	 Catch:{ InterruptedException -> 0x002d }
        if (r4 != 0) goto L_0x0032;	 Catch:{ InterruptedException -> 0x002d }
    L_0x0027:
        r4 = com.google.android.gms.common.api.Status.f13154d;	 Catch:{ InterruptedException -> 0x002d }
        r3.m14072c(r4);	 Catch:{ InterruptedException -> 0x002d }
        goto L_0x0032;
    L_0x002d:
        r4 = com.google.android.gms.common.api.Status.f13152b;
        r3.m14072c(r4);
    L_0x0032:
        r4 = r3.m14073f();
        r5 = "Result is not ready.";
        com.google.android.gms.common.internal.C2872v.m8387a(r4, r5);
        r4 = r3.mo3282d();
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.a(long, java.util.concurrent.TimeUnit):R");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo2379a(com.google.android.gms.common.api.C2815l<? super R> r5) {
        /*
        r4 = this;
        r0 = r4.f11382a;
        monitor-enter(r0);
        if (r5 != 0) goto L_0x000c;
    L_0x0005:
        r5 = 0;
        r4.f11387g = r5;	 Catch:{ all -> 0x000a }
        monitor-exit(r0);	 Catch:{ all -> 0x000a }
        return;
    L_0x000a:
        r5 = move-exception;
        goto L_0x003c;
    L_0x000c:
        r1 = r4.f11391k;	 Catch:{ all -> 0x000a }
        r2 = 1;
        r1 = r1 ^ r2;
        r3 = "Result has already been consumed.";
        com.google.android.gms.common.internal.C2872v.m8387a(r1, r3);	 Catch:{ all -> 0x000a }
        r1 = r4.f11395o;	 Catch:{ all -> 0x000a }
        if (r1 != 0) goto L_0x001a;
    L_0x0019:
        goto L_0x001b;
    L_0x001a:
        r2 = 0;
    L_0x001b:
        r1 = "Cannot set callbacks if then() has been called.";
        com.google.android.gms.common.internal.C2872v.m8387a(r2, r1);	 Catch:{ all -> 0x000a }
        r1 = r4.mo2381b();	 Catch:{ all -> 0x000a }
        if (r1 == 0) goto L_0x0028;
    L_0x0026:
        monitor-exit(r0);	 Catch:{ all -> 0x000a }
        return;
    L_0x0028:
        r1 = r4.m14073f();	 Catch:{ all -> 0x000a }
        if (r1 == 0) goto L_0x0038;
    L_0x002e:
        r1 = r4.f11383b;	 Catch:{ all -> 0x000a }
        r2 = r4.mo3282d();	 Catch:{ all -> 0x000a }
        r1.m14057a(r5, r2);	 Catch:{ all -> 0x000a }
        goto L_0x003a;
    L_0x0038:
        r4.f11387g = r5;	 Catch:{ all -> 0x000a }
    L_0x003a:
        monitor-exit(r0);	 Catch:{ all -> 0x000a }
        return;
    L_0x003c:
        monitor-exit(r0);	 Catch:{ all -> 0x000a }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.a(com.google.android.gms.common.api.l):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo2380a(com.google.android.gms.common.api.C2815l<? super R> r5, long r6, java.util.concurrent.TimeUnit r8) {
        /*
        r4 = this;
        r0 = r4.f11382a;
        monitor-enter(r0);
        if (r5 != 0) goto L_0x000c;
    L_0x0005:
        r5 = 0;
        r4.f11387g = r5;	 Catch:{ all -> 0x000a }
        monitor-exit(r0);	 Catch:{ all -> 0x000a }
        return;
    L_0x000a:
        r5 = move-exception;
        goto L_0x004a;
    L_0x000c:
        r1 = r4.f11391k;	 Catch:{ all -> 0x000a }
        r2 = 1;
        r1 = r1 ^ r2;
        r3 = "Result has already been consumed.";
        com.google.android.gms.common.internal.C2872v.m8387a(r1, r3);	 Catch:{ all -> 0x000a }
        r1 = r4.f11395o;	 Catch:{ all -> 0x000a }
        if (r1 != 0) goto L_0x001a;
    L_0x0019:
        goto L_0x001b;
    L_0x001a:
        r2 = 0;
    L_0x001b:
        r1 = "Cannot set callbacks if then() has been called.";
        com.google.android.gms.common.internal.C2872v.m8387a(r2, r1);	 Catch:{ all -> 0x000a }
        r1 = r4.mo2381b();	 Catch:{ all -> 0x000a }
        if (r1 == 0) goto L_0x0028;
    L_0x0026:
        monitor-exit(r0);	 Catch:{ all -> 0x000a }
        return;
    L_0x0028:
        r1 = r4.m14073f();	 Catch:{ all -> 0x000a }
        if (r1 == 0) goto L_0x0038;
    L_0x002e:
        r6 = r4.f11383b;	 Catch:{ all -> 0x000a }
        r7 = r4.mo3282d();	 Catch:{ all -> 0x000a }
        r6.m14057a(r5, r7);	 Catch:{ all -> 0x000a }
        goto L_0x0048;
    L_0x0038:
        r4.f11387g = r5;	 Catch:{ all -> 0x000a }
        r5 = r4.f11383b;	 Catch:{ all -> 0x000a }
        r6 = r8.toMillis(r6);	 Catch:{ all -> 0x000a }
        r8 = 2;
        r8 = r5.obtainMessage(r8, r4);	 Catch:{ all -> 0x000a }
        r5.sendMessageDelayed(r8, r6);	 Catch:{ all -> 0x000a }
    L_0x0048:
        monitor-exit(r0);	 Catch:{ all -> 0x000a }
        return;
    L_0x004a:
        monitor-exit(r0);	 Catch:{ all -> 0x000a }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.a(com.google.android.gms.common.api.l, long, java.util.concurrent.TimeUnit):void");
    }

    /* renamed from: a */
    public final void mo2378a(C2788a c2788a) {
        C2872v.m8391b(c2788a != null, "Callback cannot be null.");
        synchronized (this.f11382a) {
            if (m14073f()) {
                c2788a.mo2453a(this.f11390j);
            } else {
                this.f11386f.add(c2788a);
            }
        }
    }

    /* renamed from: a */
    public void mo2377a() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r2 = this;
        r0 = r2.f11382a;
        monitor-enter(r0);
        r1 = r2.f11392l;	 Catch:{ all -> 0x002a }
        if (r1 != 0) goto L_0x0028;	 Catch:{ all -> 0x002a }
    L_0x0007:
        r1 = r2.f11391k;	 Catch:{ all -> 0x002a }
        if (r1 == 0) goto L_0x000c;	 Catch:{ all -> 0x002a }
    L_0x000b:
        goto L_0x0028;	 Catch:{ all -> 0x002a }
    L_0x000c:
        r1 = r2.f11394n;	 Catch:{ all -> 0x002a }
        if (r1 == 0) goto L_0x0015;
    L_0x0010:
        r1 = r2.f11394n;	 Catch:{ RemoteException -> 0x0015 }
        r1.m8365a();	 Catch:{ RemoteException -> 0x0015 }
    L_0x0015:
        r1 = r2.f11389i;	 Catch:{ all -> 0x002a }
        m14060c(r1);	 Catch:{ all -> 0x002a }
        r1 = 1;	 Catch:{ all -> 0x002a }
        r2.f11392l = r1;	 Catch:{ all -> 0x002a }
        r1 = com.google.android.gms.common.api.Status.f13155e;	 Catch:{ all -> 0x002a }
        r1 = r2.mo3278a(r1);	 Catch:{ all -> 0x002a }
        r2.mo3280a(r1);	 Catch:{ all -> 0x002a }
        monitor-exit(r0);	 Catch:{ all -> 0x002a }
        return;	 Catch:{ all -> 0x002a }
    L_0x0028:
        monitor-exit(r0);	 Catch:{ all -> 0x002a }
        return;	 Catch:{ all -> 0x002a }
    L_0x002a:
        r1 = move-exception;	 Catch:{ all -> 0x002a }
        monitor-exit(r0);	 Catch:{ all -> 0x002a }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.a():void");
    }

    /* renamed from: g */
    public final boolean m14074g() {
        boolean b;
        synchronized (this.f11382a) {
            if (((GoogleApiClient) this.f11384d.get()) == null || !this.f11396p) {
                mo2377a();
            }
            b = mo2381b();
        }
        return b;
    }

    /* renamed from: b */
    public boolean mo2381b() {
        boolean z;
        synchronized (this.f11382a) {
            z = this.f11392l;
        }
        return z;
    }

    /* renamed from: b */
    public final void m14069b(R r) {
        synchronized (this.f11382a) {
            if (this.f11393m || this.f11392l) {
                m14060c((C2814k) r);
                return;
            }
            m14073f();
            C2872v.m8387a(m14073f() ^ 1, (Object) "Results have already been set");
            C2872v.m8387a(this.f11391k ^ 1, (Object) "Result has already been consumed");
            mo3280a((C2814k) r);
        }
    }

    /* renamed from: c */
    public final void m14072c(Status status) {
        synchronized (this.f11382a) {
            if (!m14073f()) {
                m14069b(mo3278a(status));
                this.f11393m = true;
            }
        }
    }

    /* renamed from: a */
    public final void m14066a(cb cbVar) {
        this.f11388h.set(cbVar);
    }

    /* renamed from: h */
    public final void m14075h() {
        boolean z;
        if (!this.f11396p) {
            if (!((Boolean) f11381c.get()).booleanValue()) {
                z = false;
                this.f11396p = z;
            }
        }
        z = true;
        this.f11396p = z;
    }

    /* renamed from: d */
    private final R mo3282d() {
        R r;
        synchronized (this.f11382a) {
            C2872v.m8387a(this.f11391k ^ true, (Object) "Result has already been consumed.");
            C2872v.m8387a(m14073f(), (Object) "Result is not ready.");
            r = this.f11389i;
            this.f11389i = null;
            this.f11387g = null;
            this.f11391k = true;
        }
        cb cbVar = (cb) this.f11388h.getAndSet(null);
        if (cbVar != null) {
            cbVar.mo2426a(this);
        }
        return r;
    }

    /* renamed from: a */
    private final void mo3280a(R r) {
        this.f11389i = r;
        this.f11394n = null;
        this.f11385e.countDown();
        this.f11390j = this.f11389i.mo2360b();
        if (this.f11392l) {
            this.f11387g = null;
        } else if (this.f11387g != null) {
            this.f11383b.removeMessages(2);
            this.f11383b.m14057a(this.f11387g, mo3282d());
        } else if (this.f11389i instanceof C2791i) {
            this.mResultGuardian = new C2792b();
        }
        ArrayList arrayList = (ArrayList) this.f11386f;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((C2788a) obj).mo2453a(this.f11390j);
        }
        this.f11386f.clear();
    }

    /* renamed from: c */
    public static void m14060c(C2814k c2814k) {
        if (c2814k instanceof C2791i) {
            try {
                ((C2791i) c2814k).mo3299a();
            } catch (Throwable e) {
                c2814k = String.valueOf(c2814k);
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(c2814k).length() + 18);
                stringBuilder.append("Unable to release ");
                stringBuilder.append(c2814k);
                Log.w("BasePendingResult", stringBuilder.toString(), e);
            }
        }
    }
}
