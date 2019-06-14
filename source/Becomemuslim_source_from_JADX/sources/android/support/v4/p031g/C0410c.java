package android.support.v4.p031g;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.Callable;

/* compiled from: SelfDestructiveThread */
/* renamed from: android.support.v4.g.c */
public class C0410c {
    /* renamed from: a */
    private final Object f1058a = new Object();
    /* renamed from: b */
    private HandlerThread f1059b;
    /* renamed from: c */
    private Handler f1060c;
    /* renamed from: d */
    private int f1061d;
    /* renamed from: e */
    private Callback f1062e = new C04051(this);
    /* renamed from: f */
    private final int f1063f;
    /* renamed from: g */
    private final int f1064g;
    /* renamed from: h */
    private final String f1065h;

    /* compiled from: SelfDestructiveThread */
    /* renamed from: android.support.v4.g.c$1 */
    class C04051 implements Callback {
        /* renamed from: a */
        final /* synthetic */ C0410c f1045a;

        C04051(C0410c c0410c) {
            this.f1045a = c0410c;
        }

        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    this.f1045a.m1207a();
                    return true;
                case 1:
                    this.f1045a.m1211b((Runnable) message.obj);
                    return true;
                default:
                    return true;
            }
        }
    }

    /* compiled from: SelfDestructiveThread */
    /* renamed from: android.support.v4.g.c$a */
    public interface C0409a<T> {
        /* renamed from: a */
        void mo227a(T t);
    }

    public C0410c(String str, int i, int i2) {
        this.f1065h = str;
        this.f1064g = i;
        this.f1063f = i2;
        this.f1061d = null;
    }

    /* renamed from: a */
    private void m1210a(Runnable runnable) {
        synchronized (this.f1058a) {
            if (this.f1059b == null) {
                this.f1059b = new HandlerThread(this.f1065h, this.f1064g);
                this.f1059b.start();
                this.f1060c = new Handler(this.f1059b.getLooper(), this.f1062e);
                this.f1061d++;
            }
            this.f1060c.removeMessages(0);
            this.f1060c.sendMessage(this.f1060c.obtainMessage(1, runnable));
        }
    }

    /* renamed from: a */
    public <T> void m1213a(final Callable<T> callable, final C0409a<T> c0409a) {
        final Handler handler = new Handler();
        m1210a(new Runnable(this) {
            /* renamed from: d */
            final /* synthetic */ C0410c f1051d;

            public void run() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
                /*
                r3 = this;
                r0 = r3;	 Catch:{ Exception -> 0x0007 }
                r0 = r0.call();	 Catch:{ Exception -> 0x0007 }
                goto L_0x0008;
            L_0x0007:
                r0 = 0;
            L_0x0008:
                r1 = r0;
                r2 = new android.support.v4.g.c$2$1;
                r2.<init>(r3, r0);
                r1.post(r2);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: android.support.v4.g.c.2.run():void");
            }
        });
    }

    /* renamed from: a */
    public <T> T m1212a(java.util.concurrent.Callable<T> r13, int r14) {
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
        r12 = this;
        r7 = new java.util.concurrent.locks.ReentrantLock;
        r7.<init>();
        r8 = r7.newCondition();
        r9 = new java.util.concurrent.atomic.AtomicReference;
        r9.<init>();
        r10 = new java.util.concurrent.atomic.AtomicBoolean;
        r0 = 1;
        r10.<init>(r0);
        r11 = new android.support.v4.g.c$3;
        r0 = r11;
        r1 = r12;
        r2 = r9;
        r3 = r13;
        r4 = r7;
        r5 = r10;
        r6 = r8;
        r0.<init>(r1, r2, r3, r4, r5, r6);
        r12.m1210a(r11);
        r7.lock();
        r13 = r10.get();	 Catch:{ all -> 0x005d }
        if (r13 != 0) goto L_0x0034;	 Catch:{ all -> 0x005d }
    L_0x002c:
        r13 = r9.get();	 Catch:{ all -> 0x005d }
        r7.unlock();
        return r13;
    L_0x0034:
        r13 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ all -> 0x005d }
        r0 = (long) r14;	 Catch:{ all -> 0x005d }
        r13 = r13.toNanos(r0);	 Catch:{ all -> 0x005d }
    L_0x003b:
        r0 = r8.awaitNanos(r13);	 Catch:{ InterruptedException -> 0x0040 }
        r13 = r0;
    L_0x0040:
        r0 = r10.get();	 Catch:{ all -> 0x005d }
        if (r0 != 0) goto L_0x004e;	 Catch:{ all -> 0x005d }
    L_0x0046:
        r13 = r9.get();	 Catch:{ all -> 0x005d }
        r7.unlock();
        return r13;
    L_0x004e:
        r0 = 0;
        r0 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x0055;
    L_0x0054:
        goto L_0x003b;
    L_0x0055:
        r13 = new java.lang.InterruptedException;	 Catch:{ all -> 0x005d }
        r14 = "timeout";	 Catch:{ all -> 0x005d }
        r13.<init>(r14);	 Catch:{ all -> 0x005d }
        throw r13;	 Catch:{ all -> 0x005d }
    L_0x005d:
        r13 = move-exception;
        r7.unlock();
        throw r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.g.c.a(java.util.concurrent.Callable, int):T");
    }

    /* renamed from: b */
    private void m1211b(Runnable runnable) {
        runnable.run();
        synchronized (this.f1058a) {
            this.f1060c.removeMessages(0);
            this.f1060c.sendMessageDelayed(this.f1060c.obtainMessage(0), (long) this.f1063f);
        }
    }

    /* renamed from: a */
    private void m1207a() {
        synchronized (this.f1058a) {
            if (this.f1060c.hasMessages(1)) {
                return;
            }
            this.f1059b.quit();
            this.f1059b = null;
            this.f1060c = null;
        }
    }
}
