package p289e.p292c.p293a;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import p289e.C5974e.C7335a;
import p289e.C5989l;
import p289e.C7367k;
import p289e.p291b.C5913a;
import p289e.p291b.C5914b;
import p289e.p298d.C7333b;
import p289e.p303i.C5987e;
import p289e.p303i.C7362b;

/* compiled from: OnSubscribeRefCount */
/* renamed from: e.c.a.z */
public final class C8129z<T> implements C7335a<T> {
    /* renamed from: a */
    volatile C7362b f30260a = new C7362b();
    /* renamed from: b */
    final AtomicInteger f30261b = new AtomicInteger(0);
    /* renamed from: c */
    final ReentrantLock f30262c = new ReentrantLock();
    /* renamed from: d */
    private final C7333b<? extends T> f30263d;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void m39482a(p289e.C7367k<? super T> r3) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x003f in list [B:7:0x0022]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:43)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
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
        r0 = r2.f30262c;
        r0.lock();
        r0 = r2.f30261b;
        r0 = r0.incrementAndGet();
        r1 = 1;
        if (r0 != r1) goto L_0x0035;
    L_0x000e:
        r0 = new java.util.concurrent.atomic.AtomicBoolean;
        r0.<init>(r1);
        r1 = r2.f30263d;	 Catch:{ all -> 0x0028 }
        r3 = r2.m39479a(r3, r0);	 Catch:{ all -> 0x0028 }
        r1.mo6326d(r3);	 Catch:{ all -> 0x0028 }
        r3 = r0.get();
        if (r3 == 0) goto L_0x003f;
    L_0x0022:
        r3 = r2.f30262c;
        r3.unlock();
        goto L_0x003f;
    L_0x0028:
        r3 = move-exception;
        r0 = r0.get();
        if (r0 == 0) goto L_0x0034;
    L_0x002f:
        r0 = r2.f30262c;
        r0.unlock();
    L_0x0034:
        throw r3;
    L_0x0035:
        r0 = r2.f30260a;	 Catch:{ all -> 0x0040 }
        r2.m39483a(r3, r0);	 Catch:{ all -> 0x0040 }
        r3 = r2.f30262c;
        r3.unlock();
    L_0x003f:
        return;
    L_0x0040:
        r3 = move-exception;
        r0 = r2.f30262c;
        r0.unlock();
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a.z.a(e.k):void");
    }

    /* renamed from: b */
    public /* synthetic */ void mo4974b(Object obj) {
        m39482a((C7367k) obj);
    }

    public C8129z(C7333b<? extends T> c7333b) {
        this.f30263d = c7333b;
    }

    /* renamed from: a */
    private C5914b<C5989l> m39479a(final C7367k<? super T> c7367k, final AtomicBoolean atomicBoolean) {
        return new C5914b<C5989l>(this) {
            /* renamed from: c */
            final /* synthetic */ C8129z f25627c;

            /* renamed from: b */
            public /* synthetic */ void mo4974b(Object obj) {
                m33593a((C5989l) obj);
            }

            /* renamed from: a */
            public void m33593a(C5989l c5989l) {
                try {
                    this.f25627c.f30260a.m33765a(c5989l);
                    this.f25627c.m39483a(c7367k, this.f25627c.f30260a);
                } finally {
                    this.f25627c.f30262c.unlock();
                    atomicBoolean.set(false);
                }
            }
        };
    }

    /* renamed from: a */
    void m39483a(final C7367k<? super T> c7367k, final C7362b c7362b) {
        c7367k.m33781a(m39481a(c7362b));
        this.f30263d.m25007a(new C7367k<T>(this, c7367k) {
            /* renamed from: c */
            final /* synthetic */ C8129z f30259c;

            /* renamed from: a */
            public void mo5001a(Throwable th) {
                m39478d();
                c7367k.mo5001a(th);
            }

            /* renamed from: a */
            public void mo5000a(T t) {
                c7367k.mo5000a((Object) t);
            }

            public void L_() {
                m39478d();
                c7367k.L_();
            }

            /* renamed from: d */
            void m39478d() {
                this.f30259c.f30262c.lock();
                try {
                    if (this.f30259c.f30260a == c7362b) {
                        if (this.f30259c.f30263d instanceof C5989l) {
                            ((C5989l) this.f30259c.f30263d).U_();
                        }
                        this.f30259c.f30260a.U_();
                        this.f30259c.f30260a = new C7362b();
                        this.f30259c.f30261b.set(0);
                    }
                    this.f30259c.f30262c.unlock();
                } catch (Throwable th) {
                    this.f30259c.f30262c.unlock();
                }
            }
        });
    }

    /* renamed from: a */
    private C5989l m39481a(final C7362b c7362b) {
        return C5987e.m25118a(new C5913a(this) {
            /* renamed from: b */
            final /* synthetic */ C8129z f25629b;

            /* renamed from: a */
            public void mo4985a() {
                this.f25629b.f30262c.lock();
                try {
                    if (this.f25629b.f30260a == c7362b && this.f25629b.f30261b.decrementAndGet() == 0) {
                        if (this.f25629b.f30263d instanceof C5989l) {
                            ((C5989l) this.f25629b.f30263d).U_();
                        }
                        this.f25629b.f30260a.U_();
                        this.f25629b.f30260a = new C7362b();
                    }
                    this.f25629b.f30262c.unlock();
                } catch (Throwable th) {
                    this.f25629b.f30262c.unlock();
                }
            }
        });
    }
}
