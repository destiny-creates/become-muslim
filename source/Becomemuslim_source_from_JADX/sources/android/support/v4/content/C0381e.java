package android.support.v4.content;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ModernAsyncTask */
/* renamed from: android.support.v4.content.e */
abstract class C0381e<Params, Progress, Result> {
    /* renamed from: a */
    private static final ThreadFactory f998a = new C03741();
    /* renamed from: b */
    private static final BlockingQueue<Runnable> f999b = new LinkedBlockingQueue(10);
    /* renamed from: c */
    public static final Executor f1000c = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, f999b, f998a);
    /* renamed from: d */
    private static C0378b f1001d;
    /* renamed from: e */
    private static volatile Executor f1002e = f1000c;
    /* renamed from: f */
    private final C0380d<Params, Result> f1003f = new C31952(this);
    /* renamed from: g */
    private final FutureTask<Result> f1004g = new FutureTask<Result>(this, this.f1003f) {
        /* renamed from: a */
        final /* synthetic */ C0381e f989a;

        protected void done() {
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
            r0 = r3.get();	 Catch:{ InterruptedException -> 0x0027, ExecutionException -> 0x001a, CancellationException -> 0x0013, Throwable -> 0x000a }
            r1 = r3.f989a;	 Catch:{ InterruptedException -> 0x0027, ExecutionException -> 0x001a, CancellationException -> 0x0013, Throwable -> 0x000a }
            r1.m1155c(r0);	 Catch:{ InterruptedException -> 0x0027, ExecutionException -> 0x001a, CancellationException -> 0x0013, Throwable -> 0x000a }
            goto L_0x002d;
        L_0x000a:
            r0 = move-exception;
            r1 = new java.lang.RuntimeException;
            r2 = "An error occurred while executing doInBackground()";
            r1.<init>(r2, r0);
            throw r1;
        L_0x0013:
            r0 = r3.f989a;
            r1 = 0;
            r0.m1155c(r1);
            goto L_0x002d;
        L_0x001a:
            r0 = move-exception;
            r1 = new java.lang.RuntimeException;
            r0 = r0.getCause();
            r2 = "An error occurred while executing doInBackground()";
            r1.<init>(r2, r0);
            throw r1;
        L_0x0027:
            r0 = move-exception;
            r1 = "AsyncTask";
            android.util.Log.w(r1, r0);
        L_0x002d:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.content.e.3.done():void");
        }
    };
    /* renamed from: h */
    private volatile C0379c f1005h = C0379c.PENDING;
    /* renamed from: i */
    private final AtomicBoolean f1006i = new AtomicBoolean();
    /* renamed from: j */
    private final AtomicBoolean f1007j = new AtomicBoolean();

    /* compiled from: ModernAsyncTask */
    /* renamed from: android.support.v4.content.e$1 */
    static class C03741 implements ThreadFactory {
        /* renamed from: a */
        private final AtomicInteger f988a = new AtomicInteger(1);

        C03741() {
        }

        public Thread newThread(Runnable runnable) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ModernAsyncTask #");
            stringBuilder.append(this.f988a.getAndIncrement());
            return new Thread(runnable, stringBuilder.toString());
        }
    }

    /* compiled from: ModernAsyncTask */
    /* renamed from: android.support.v4.content.e$a */
    private static class C0377a<Data> {
        /* renamed from: a */
        final C0381e f991a;
        /* renamed from: b */
        final Data[] f992b;

        C0377a(C0381e c0381e, Data... dataArr) {
            this.f991a = c0381e;
            this.f992b = dataArr;
        }
    }

    /* compiled from: ModernAsyncTask */
    /* renamed from: android.support.v4.content.e$b */
    private static class C0378b extends Handler {
        C0378b() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            C0377a c0377a = (C0377a) message.obj;
            switch (message.what) {
                case 1:
                    c0377a.f991a.m1158e(c0377a.f992b[0]);
                    return;
                case 2:
                    c0377a.f991a.m1154b(c0377a.f992b);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: ModernAsyncTask */
    /* renamed from: android.support.v4.content.e$c */
    public enum C0379c {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* compiled from: ModernAsyncTask */
    /* renamed from: android.support.v4.content.e$d */
    private static abstract class C0380d<Params, Result> implements Callable<Result> {
        /* renamed from: b */
        Params[] f997b;

        C0380d() {
        }
    }

    /* compiled from: ModernAsyncTask */
    /* renamed from: android.support.v4.content.e$2 */
    class C31952 extends C0380d<Params, Result> {
        /* renamed from: a */
        final /* synthetic */ C0381e f8242a;

        C31952(C0381e c0381e) {
            this.f8242a = c0381e;
        }

        public Result call() {
            Throwable th;
            Throwable th2;
            this.f8242a.f1007j.set(true);
            Object obj = null;
            try {
                Process.setThreadPriority(10);
                Result a = this.f8242a.mo220a(this.b);
                try {
                    Binder.flushPendingCommands();
                    this.f8242a.m1157d(a);
                    return a;
                } catch (Throwable th3) {
                    th2 = th3;
                    obj = a;
                    this.f8242a.m1157d(obj);
                    throw th2;
                }
            } catch (Throwable th4) {
                th = th4;
                this.f8242a.f1006i.set(true);
                throw th;
            }
        }
    }

    /* renamed from: a */
    protected abstract Result mo220a(Params... paramsArr);

    /* renamed from: a */
    protected void m1149a() {
    }

    /* renamed from: a */
    protected void mo221a(Result result) {
    }

    /* renamed from: b */
    protected void m1152b() {
    }

    /* renamed from: b */
    protected void m1154b(Progress... progressArr) {
    }

    /* renamed from: d */
    private static Handler m1146d() {
        Handler handler;
        synchronized (C0381e.class) {
            if (f1001d == null) {
                f1001d = new C0378b();
            }
            handler = f1001d;
        }
        return handler;
    }

    C0381e() {
    }

    /* renamed from: c */
    void m1155c(Result result) {
        if (!this.f1007j.get()) {
            m1157d(result);
        }
    }

    /* renamed from: d */
    Result m1157d(Result result) {
        C0381e.m1146d().obtainMessage(1, new C0377a(this, result)).sendToTarget();
        return result;
    }

    /* renamed from: b */
    protected void mo222b(Result result) {
        m1152b();
    }

    /* renamed from: c */
    public final boolean m1156c() {
        return this.f1006i.get();
    }

    /* renamed from: a */
    public final boolean m1151a(boolean z) {
        this.f1006i.set(true);
        return this.f1004g.cancel(z);
    }

    /* renamed from: a */
    public final C0381e<Params, Progress, Result> m1147a(Executor executor, Params... paramsArr) {
        if (this.f1005h != C0379c.PENDING) {
            switch (this.f1005h) {
                case RUNNING:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case FINISHED:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
                default:
                    throw new IllegalStateException("We should never reach this state");
            }
        }
        this.f1005h = C0379c.RUNNING;
        m1149a();
        this.f1003f.f997b = paramsArr;
        executor.execute(this.f1004g);
        return this;
    }

    /* renamed from: e */
    void m1158e(Result result) {
        if (m1156c()) {
            mo222b((Object) result);
        } else {
            mo221a((Object) result);
        }
        this.f1005h = C0379c.FINISHED;
    }
}
