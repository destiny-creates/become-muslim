package io.p347a.p348a.p349a.p350a.p353c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import java.util.LinkedList;
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

/* compiled from: AsyncTask */
/* renamed from: io.a.a.a.a.c.a */
public abstract class C6456a<Params, Progress, Result> {
    /* renamed from: a */
    private static final int f20839a = Runtime.getRuntime().availableProcessors();
    /* renamed from: b */
    public static final Executor f20840b = new ThreadPoolExecutor(f20842d, f20843e, 1, TimeUnit.SECONDS, f20845g, f20844f);
    /* renamed from: c */
    public static final Executor f20841c = new C6450c();
    /* renamed from: d */
    private static final int f20842d = (f20839a + 1);
    /* renamed from: e */
    private static final int f20843e = ((f20839a * 2) + 1);
    /* renamed from: f */
    private static final ThreadFactory f20844f = new C64441();
    /* renamed from: g */
    private static final BlockingQueue<Runnable> f20845g = new LinkedBlockingQueue(128);
    /* renamed from: h */
    private static final C6448b f20846h = new C6448b();
    /* renamed from: i */
    private static volatile Executor f20847i = f20841c;
    /* renamed from: j */
    private final C6452e<Params, Result> f20848j = new C76082(this);
    /* renamed from: k */
    private final FutureTask<Result> f20849k = new FutureTask<Result>(this, this.f20848j) {
        /* renamed from: a */
        final /* synthetic */ C6456a f20823a;

        protected void done() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r3 = this;
            r0 = r3.f20823a;	 Catch:{ InterruptedException -> 0x001e, ExecutionException -> 0x0011, CancellationException -> 0x000a }
            r1 = r3.get();	 Catch:{ InterruptedException -> 0x001e, ExecutionException -> 0x0011, CancellationException -> 0x000a }
            r0.m26459d(r1);	 Catch:{ InterruptedException -> 0x001e, ExecutionException -> 0x0011, CancellationException -> 0x000a }
            goto L_0x0024;
        L_0x000a:
            r0 = r3.f20823a;
            r1 = 0;
            r0.m26459d(r1);
            goto L_0x0024;
        L_0x0011:
            r0 = move-exception;
            r1 = new java.lang.RuntimeException;
            r0 = r0.getCause();
            r2 = "An error occured while executing doInBackground()";
            r1.<init>(r2, r0);
            throw r1;
        L_0x001e:
            r0 = move-exception;
            r1 = "AsyncTask";
            android.util.Log.w(r1, r0);
        L_0x0024:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.a.a.a.a.c.a.3.done():void");
        }
    };
    /* renamed from: l */
    private volatile C6451d f20850l = C6451d.PENDING;
    /* renamed from: m */
    private final AtomicBoolean f20851m = new AtomicBoolean();
    /* renamed from: n */
    private final AtomicBoolean f20852n = new AtomicBoolean();

    /* compiled from: AsyncTask */
    /* renamed from: io.a.a.a.a.c.a$1 */
    static class C64441 implements ThreadFactory {
        /* renamed from: a */
        private final AtomicInteger f20822a = new AtomicInteger(1);

        C64441() {
        }

        public Thread newThread(Runnable runnable) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("AsyncTask #");
            stringBuilder.append(this.f20822a.getAndIncrement());
            return new Thread(runnable, stringBuilder.toString());
        }
    }

    /* compiled from: AsyncTask */
    /* renamed from: io.a.a.a.a.c.a$a */
    private static class C6447a<Data> {
        /* renamed from: a */
        final C6456a f20825a;
        /* renamed from: b */
        final Data[] f20826b;

        C6447a(C6456a c6456a, Data... dataArr) {
            this.f20825a = c6456a;
            this.f20826b = dataArr;
        }
    }

    /* compiled from: AsyncTask */
    /* renamed from: io.a.a.a.a.c.a$b */
    private static class C6448b extends Handler {
        public C6448b() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            C6447a c6447a = (C6447a) message.obj;
            switch (message.what) {
                case 1:
                    c6447a.f20825a.m26461f(c6447a.f20826b[0]);
                    return;
                case 2:
                    c6447a.f20825a.m26468b(c6447a.f20826b);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: AsyncTask */
    /* renamed from: io.a.a.a.a.c.a$c */
    private static class C6450c implements Executor {
        /* renamed from: a */
        final LinkedList<Runnable> f20829a;
        /* renamed from: b */
        Runnable f20830b;

        private C6450c() {
            this.f20829a = new LinkedList();
        }

        public synchronized void execute(final Runnable runnable) {
            this.f20829a.offer(new Runnable(this) {
                /* renamed from: b */
                final /* synthetic */ C6450c f20828b;

                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        this.f20828b.m26450a();
                    }
                }
            });
            if (this.f20830b == null) {
                m26450a();
            }
        }

        /* renamed from: a */
        protected synchronized void m26450a() {
            Runnable runnable = (Runnable) this.f20829a.poll();
            this.f20830b = runnable;
            if (runnable != null) {
                C6456a.f20840b.execute(this.f20830b);
            }
        }
    }

    /* compiled from: AsyncTask */
    /* renamed from: io.a.a.a.a.c.a$d */
    public enum C6451d {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* compiled from: AsyncTask */
    /* renamed from: io.a.a.a.a.c.a$e */
    private static abstract class C6452e<Params, Result> implements Callable<Result> {
        /* renamed from: b */
        Params[] f20835b;

        private C6452e() {
        }
    }

    /* compiled from: AsyncTask */
    /* renamed from: io.a.a.a.a.c.a$2 */
    class C76082 extends C6452e<Params, Result> {
        /* renamed from: a */
        final /* synthetic */ C6456a f26308a;

        C76082(C6456a c6456a) {
            this.f26308a = c6456a;
            super();
        }

        public Result call() {
            this.f26308a.f20852n.set(true);
            Process.setThreadPriority(10);
            return this.f26308a.m26460e(this.f26308a.mo6417a(this.b));
        }
    }

    protected void R_() {
    }

    /* renamed from: a */
    protected abstract Result mo6417a(Params... paramsArr);

    /* renamed from: a */
    protected void mo6418a() {
    }

    /* renamed from: a */
    protected void mo6419a(Result result) {
    }

    /* renamed from: b */
    protected void m26468b(Progress... progressArr) {
    }

    /* renamed from: d */
    private void m26459d(Result result) {
        if (!this.f20852n.get()) {
            m26460e(result);
        }
    }

    /* renamed from: e */
    private Result m26460e(Result result) {
        f20846h.obtainMessage(1, new C6447a(this, result)).sendToTarget();
        return result;
    }

    public final C6451d Q_() {
        return this.f20850l;
    }

    /* renamed from: b */
    protected void mo6420b(Result result) {
        R_();
    }

    /* renamed from: e */
    public final boolean m26469e() {
        return this.f20851m.get();
    }

    /* renamed from: a */
    public final boolean m26466a(boolean z) {
        this.f20851m.set(true);
        return this.f20849k.cancel(z);
    }

    /* renamed from: a */
    public final C6456a<Params, Progress, Result> m26462a(Executor executor, Params... paramsArr) {
        if (this.f20850l != C6451d.PENDING) {
            switch (this.f20850l) {
                case RUNNING:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case FINISHED:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
                default:
                    break;
            }
        }
        this.f20850l = C6451d.RUNNING;
        mo6418a();
        this.f20848j.f20835b = paramsArr;
        executor.execute(this.f20849k);
        return this;
    }

    /* renamed from: f */
    private void m26461f(Result result) {
        if (m26469e()) {
            mo6420b((Object) result);
        } else {
            mo6419a((Object) result);
        }
        this.f20850l = C6451d.FINISHED;
    }
}
