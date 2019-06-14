package com.google.android.exoplayer2.p163k;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import com.google.android.exoplayer2.p164l.C2516a;
import com.google.android.exoplayer2.p164l.C2541v;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* compiled from: Loader */
/* renamed from: com.google.android.exoplayer2.k.s */
public final class C4251s implements C2512t {
    /* renamed from: a */
    private final ExecutorService f11215a;
    /* renamed from: b */
    private C2507b<? extends C2508c> f11216b;
    /* renamed from: c */
    private IOException f11217c;

    /* compiled from: Loader */
    /* renamed from: com.google.android.exoplayer2.k.s$a */
    public interface C2506a<T extends C2508c> {
        /* renamed from: a */
        int mo2238a(T t, long j, long j2, IOException iOException);

        /* renamed from: a */
        void mo2239a(T t, long j, long j2);

        /* renamed from: a */
        void mo2240a(T t, long j, long j2, boolean z);
    }

    @SuppressLint({"HandlerLeak"})
    /* compiled from: Loader */
    /* renamed from: com.google.android.exoplayer2.k.s$b */
    private final class C2507b<T extends C2508c> extends Handler implements Runnable {
        /* renamed from: a */
        public final int f6364a;
        /* renamed from: b */
        final /* synthetic */ C4251s f6365b;
        /* renamed from: c */
        private final T f6366c;
        /* renamed from: d */
        private final C2506a<T> f6367d;
        /* renamed from: e */
        private final long f6368e;
        /* renamed from: f */
        private IOException f6369f;
        /* renamed from: g */
        private int f6370g;
        /* renamed from: h */
        private volatile Thread f6371h;
        /* renamed from: i */
        private volatile boolean f6372i;

        public C2507b(C4251s c4251s, Looper looper, T t, C2506a<T> c2506a, int i, long j) {
            this.f6365b = c4251s;
            super(looper);
            this.f6366c = t;
            this.f6367d = c2506a;
            this.f6364a = i;
            this.f6368e = j;
        }

        /* renamed from: a */
        public void m6969a(int i) {
            if (this.f6369f == null) {
                return;
            }
            if (this.f6370g > i) {
                throw this.f6369f;
            }
        }

        /* renamed from: a */
        public void m6970a(long j) {
            C2516a.m7019b(this.f6365b.f11216b == null);
            this.f6365b.f11216b = this;
            if (j > 0) {
                sendEmptyMessageDelayed(0, j);
            } else {
                m6966a();
            }
        }

        /* renamed from: a */
        public void m6971a(boolean z) {
            this.f6372i = z;
            this.f6369f = null;
            if (hasMessages(0)) {
                removeMessages(0);
                if (!z) {
                    sendEmptyMessage(1);
                }
            } else {
                this.f6366c.mo2282a();
                if (this.f6371h != null) {
                    this.f6371h.interrupt();
                }
            }
            if (z) {
                m6967b();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.f6367d.mo2240a(this.f6366c, elapsedRealtime, elapsedRealtime - this.f6368e, true);
            }
        }

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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r4 = this;
            r0 = 2;
            r1 = 3;
            r2 = java.lang.Thread.currentThread();	 Catch:{ IOException -> 0x009d, InterruptedException -> 0x008b, Exception -> 0x0072, OutOfMemoryError -> 0x0059, Error -> 0x0044 }
            r4.f6371h = r2;	 Catch:{ IOException -> 0x009d, InterruptedException -> 0x008b, Exception -> 0x0072, OutOfMemoryError -> 0x0059, Error -> 0x0044 }
            r2 = r4.f6366c;	 Catch:{ IOException -> 0x009d, InterruptedException -> 0x008b, Exception -> 0x0072, OutOfMemoryError -> 0x0059, Error -> 0x0044 }
            r2 = r2.mo2283b();	 Catch:{ IOException -> 0x009d, InterruptedException -> 0x008b, Exception -> 0x0072, OutOfMemoryError -> 0x0059, Error -> 0x0044 }
            if (r2 != 0) goto L_0x003c;	 Catch:{ IOException -> 0x009d, InterruptedException -> 0x008b, Exception -> 0x0072, OutOfMemoryError -> 0x0059, Error -> 0x0044 }
        L_0x0010:
            r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x009d, InterruptedException -> 0x008b, Exception -> 0x0072, OutOfMemoryError -> 0x0059, Error -> 0x0044 }
            r2.<init>();	 Catch:{ IOException -> 0x009d, InterruptedException -> 0x008b, Exception -> 0x0072, OutOfMemoryError -> 0x0059, Error -> 0x0044 }
            r3 = "load:";	 Catch:{ IOException -> 0x009d, InterruptedException -> 0x008b, Exception -> 0x0072, OutOfMemoryError -> 0x0059, Error -> 0x0044 }
            r2.append(r3);	 Catch:{ IOException -> 0x009d, InterruptedException -> 0x008b, Exception -> 0x0072, OutOfMemoryError -> 0x0059, Error -> 0x0044 }
            r3 = r4.f6366c;	 Catch:{ IOException -> 0x009d, InterruptedException -> 0x008b, Exception -> 0x0072, OutOfMemoryError -> 0x0059, Error -> 0x0044 }
            r3 = r3.getClass();	 Catch:{ IOException -> 0x009d, InterruptedException -> 0x008b, Exception -> 0x0072, OutOfMemoryError -> 0x0059, Error -> 0x0044 }
            r3 = r3.getSimpleName();	 Catch:{ IOException -> 0x009d, InterruptedException -> 0x008b, Exception -> 0x0072, OutOfMemoryError -> 0x0059, Error -> 0x0044 }
            r2.append(r3);	 Catch:{ IOException -> 0x009d, InterruptedException -> 0x008b, Exception -> 0x0072, OutOfMemoryError -> 0x0059, Error -> 0x0044 }
            r2 = r2.toString();	 Catch:{ IOException -> 0x009d, InterruptedException -> 0x008b, Exception -> 0x0072, OutOfMemoryError -> 0x0059, Error -> 0x0044 }
            com.google.android.exoplayer2.p164l.C2538t.m7155a(r2);	 Catch:{ IOException -> 0x009d, InterruptedException -> 0x008b, Exception -> 0x0072, OutOfMemoryError -> 0x0059, Error -> 0x0044 }
            r2 = r4.f6366c;	 Catch:{ all -> 0x0037 }
            r2.mo2284c();	 Catch:{ all -> 0x0037 }
            com.google.android.exoplayer2.p164l.C2538t.m7154a();	 Catch:{ IOException -> 0x009d, InterruptedException -> 0x008b, Exception -> 0x0072, OutOfMemoryError -> 0x0059, Error -> 0x0044 }
            goto L_0x003c;	 Catch:{ IOException -> 0x009d, InterruptedException -> 0x008b, Exception -> 0x0072, OutOfMemoryError -> 0x0059, Error -> 0x0044 }
        L_0x0037:
            r2 = move-exception;	 Catch:{ IOException -> 0x009d, InterruptedException -> 0x008b, Exception -> 0x0072, OutOfMemoryError -> 0x0059, Error -> 0x0044 }
            com.google.android.exoplayer2.p164l.C2538t.m7154a();	 Catch:{ IOException -> 0x009d, InterruptedException -> 0x008b, Exception -> 0x0072, OutOfMemoryError -> 0x0059, Error -> 0x0044 }
            throw r2;	 Catch:{ IOException -> 0x009d, InterruptedException -> 0x008b, Exception -> 0x0072, OutOfMemoryError -> 0x0059, Error -> 0x0044 }
        L_0x003c:
            r2 = r4.f6372i;	 Catch:{ IOException -> 0x009d, InterruptedException -> 0x008b, Exception -> 0x0072, OutOfMemoryError -> 0x0059, Error -> 0x0044 }
            if (r2 != 0) goto L_0x00a9;	 Catch:{ IOException -> 0x009d, InterruptedException -> 0x008b, Exception -> 0x0072, OutOfMemoryError -> 0x0059, Error -> 0x0044 }
        L_0x0040:
            r4.sendEmptyMessage(r0);	 Catch:{ IOException -> 0x009d, InterruptedException -> 0x008b, Exception -> 0x0072, OutOfMemoryError -> 0x0059, Error -> 0x0044 }
            goto L_0x00a9;
        L_0x0044:
            r0 = move-exception;
            r1 = "LoadTask";
            r2 = "Unexpected error loading stream";
            android.util.Log.e(r1, r2, r0);
            r1 = r4.f6372i;
            if (r1 != 0) goto L_0x0058;
        L_0x0050:
            r1 = 4;
            r1 = r4.obtainMessage(r1, r0);
            r1.sendToTarget();
        L_0x0058:
            throw r0;
        L_0x0059:
            r0 = move-exception;
            r2 = "LoadTask";
            r3 = "OutOfMemory error loading stream";
            android.util.Log.e(r2, r3, r0);
            r2 = r4.f6372i;
            if (r2 != 0) goto L_0x00a9;
        L_0x0065:
            r2 = new com.google.android.exoplayer2.k.s$f;
            r2.<init>(r0);
            r0 = r4.obtainMessage(r1, r2);
            r0.sendToTarget();
            goto L_0x00a9;
        L_0x0072:
            r0 = move-exception;
            r2 = "LoadTask";
            r3 = "Unexpected exception loading stream";
            android.util.Log.e(r2, r3, r0);
            r2 = r4.f6372i;
            if (r2 != 0) goto L_0x00a9;
        L_0x007e:
            r2 = new com.google.android.exoplayer2.k.s$f;
            r2.<init>(r0);
            r0 = r4.obtainMessage(r1, r2);
            r0.sendToTarget();
            goto L_0x00a9;
            r1 = r4.f6366c;
            r1 = r1.mo2283b();
            com.google.android.exoplayer2.p164l.C2516a.m7019b(r1);
            r1 = r4.f6372i;
            if (r1 != 0) goto L_0x00a9;
        L_0x0099:
            r4.sendEmptyMessage(r0);
            goto L_0x00a9;
        L_0x009d:
            r0 = move-exception;
            r2 = r4.f6372i;
            if (r2 != 0) goto L_0x00a9;
        L_0x00a2:
            r0 = r4.obtainMessage(r1, r0);
            r0.sendToTarget();
        L_0x00a9:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.k.s.b.run():void");
        }

        public void handleMessage(Message message) {
            if (!this.f6372i) {
                if (message.what == 0) {
                    m6966a();
                } else if (message.what != 4) {
                    m6967b();
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    long j = elapsedRealtime - this.f6368e;
                    if (this.f6366c.mo2283b()) {
                        this.f6367d.mo2240a(this.f6366c, elapsedRealtime, j, false);
                        return;
                    }
                    switch (message.what) {
                        case 1:
                            this.f6367d.mo2240a(this.f6366c, elapsedRealtime, j, false);
                            break;
                        case 2:
                            try {
                                this.f6367d.mo2239a(this.f6366c, elapsedRealtime, j);
                                break;
                            } catch (Message message2) {
                                Log.e("LoadTask", "Unexpected exception handling load completed", message2);
                                this.f6365b.f11217c = new C2511f(message2);
                                break;
                            }
                        case 3:
                            this.f6369f = (IOException) message2.obj;
                            message2 = this.f6367d.mo2238a(this.f6366c, elapsedRealtime, j, this.f6369f);
                            if (message2 != 3) {
                                if (message2 != 2) {
                                    int i = 1;
                                    if (message2 != 1) {
                                        i = 1 + this.f6370g;
                                    }
                                    this.f6370g = i;
                                    m6970a(m6968c());
                                    break;
                                }
                            }
                            this.f6365b.f11217c = this.f6369f;
                            break;
                            break;
                        default:
                            break;
                    }
                } else {
                    throw ((Error) message2.obj);
                }
            }
        }

        /* renamed from: a */
        private void m6966a() {
            this.f6369f = null;
            this.f6365b.f11215a.execute(this.f6365b.f11216b);
        }

        /* renamed from: b */
        private void m6967b() {
            this.f6365b.f11216b = null;
        }

        /* renamed from: c */
        private long m6968c() {
            return (long) Math.min((this.f6370g - 1) * 1000, 5000);
        }
    }

    /* compiled from: Loader */
    /* renamed from: com.google.android.exoplayer2.k.s$c */
    public interface C2508c {
        /* renamed from: a */
        void mo2282a();

        /* renamed from: b */
        boolean mo2283b();

        /* renamed from: c */
        void mo2284c();
    }

    /* compiled from: Loader */
    /* renamed from: com.google.android.exoplayer2.k.s$d */
    public interface C2509d {
        /* renamed from: g */
        void mo2244g();
    }

    /* compiled from: Loader */
    /* renamed from: com.google.android.exoplayer2.k.s$e */
    private static final class C2510e extends Handler implements Runnable {
        /* renamed from: a */
        private final C2509d f6373a;

        public C2510e(C2509d c2509d) {
            this.f6373a = c2509d;
        }

        public void run() {
            if (getLooper().getThread().isAlive()) {
                sendEmptyMessage(0);
            }
        }

        public void handleMessage(Message message) {
            this.f6373a.mo2244g();
        }
    }

    /* compiled from: Loader */
    /* renamed from: com.google.android.exoplayer2.k.s$f */
    public static final class C2511f extends IOException {
        public C2511f(Throwable th) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected ");
            stringBuilder.append(th.getClass().getSimpleName());
            stringBuilder.append(": ");
            stringBuilder.append(th.getMessage());
            super(stringBuilder.toString(), th);
        }
    }

    public C4251s(String str) {
        this.f11215a = C2541v.m7173a(str);
    }

    /* renamed from: a */
    public <T extends C2508c> long m13797a(T t, C2506a<T> c2506a, int i) {
        Looper myLooper = Looper.myLooper();
        C2516a.m7019b(myLooper != null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new C2507b(this, myLooper, t, c2506a, i, elapsedRealtime).m6970a((long) null);
        return elapsedRealtime;
    }

    /* renamed from: a */
    public boolean m13799a() {
        return this.f11216b != null;
    }

    /* renamed from: b */
    public void m13801b() {
        this.f11216b.m6971a(false);
    }

    /* renamed from: c */
    public void m13802c() {
        m13800a(null);
    }

    /* renamed from: a */
    public boolean m13800a(C2509d c2509d) {
        boolean z = true;
        if (this.f11216b != null) {
            this.f11216b.m6971a(true);
            if (c2509d != null) {
                this.f11215a.execute(new C2510e(c2509d));
            }
        } else if (c2509d != null) {
            c2509d.mo2244g();
            this.f11215a.shutdown();
            return z;
        }
        z = false;
        this.f11215a.shutdown();
        return z;
    }

    /* renamed from: d */
    public void mo2322d() {
        m13798a((int) LinearLayoutManager.INVALID_OFFSET);
    }

    /* renamed from: a */
    public void m13798a(int i) {
        if (this.f11217c != null) {
            throw this.f11217c;
        } else if (this.f11216b != null) {
            C2507b c2507b = this.f11216b;
            if (i == LinearLayoutManager.INVALID_OFFSET) {
                i = this.f11216b.f6364a;
            }
            c2507b.m6969a(i);
        }
    }
}
