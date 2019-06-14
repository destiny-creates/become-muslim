package com.facebook.ads.internal.p090e;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.os.Looper;
import android.text.TextUtils;
import com.facebook.ads.internal.p090e.C1375f.C1374a;
import com.facebook.ads.internal.p105q.p106a.C1496d;
import com.facebook.ads.internal.p105q.p109d.C1540a;
import com.facebook.ads.internal.p105q.p109d.C1541b;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* renamed from: com.facebook.ads.internal.e.d */
public class C1372d {
    /* renamed from: a */
    private static final String f3979a;
    /* renamed from: b */
    private static final int f3980b = Runtime.getRuntime().availableProcessors();
    /* renamed from: c */
    private static final int f3981c = Math.max(2, Math.min(f3980b - 1, 4));
    /* renamed from: d */
    private static final int f3982d = ((f3980b * 2) + 1);
    /* renamed from: e */
    private static final ThreadFactory f3983e = new C13701();
    /* renamed from: f */
    private static final BlockingQueue<Runnable> f3984f = new LinkedBlockingQueue(128);
    /* renamed from: g */
    private static final Executor f3985g;
    /* renamed from: h */
    private static final ReentrantReadWriteLock f3986h = new ReentrantReadWriteLock();
    /* renamed from: i */
    private static final Lock f3987i = f3986h.readLock();
    /* renamed from: j */
    private static final Lock f3988j = f3986h.writeLock();
    /* renamed from: k */
    private final Context f3989k;
    /* renamed from: l */
    private final C3576h f3990l = new C3576h(this);
    /* renamed from: m */
    private final C3575c f3991m = new C3575c(this);
    /* renamed from: n */
    private SQLiteOpenHelper f3992n;

    /* renamed from: com.facebook.ads.internal.e.d$1 */
    static class C13701 implements ThreadFactory {
        /* renamed from: a */
        private final AtomicInteger f3974a = new AtomicInteger(1);

        C13701() {
        }

        public Thread newThread(Runnable runnable) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("DatabaseTask #");
            stringBuilder.append(this.f3974a.getAndIncrement());
            return new Thread(runnable, stringBuilder.toString());
        }
    }

    /* renamed from: com.facebook.ads.internal.e.d$a */
    private static class C1371a<T> extends AsyncTask<Void, Void, T> {
        /* renamed from: a */
        private final C1375f<T> f3975a;
        /* renamed from: b */
        private final C1368a<T> f3976b;
        /* renamed from: c */
        private final Context f3977c;
        /* renamed from: d */
        private C1374a f3978d;

        C1371a(Context context, C1375f<T> c1375f, C1368a<T> c1368a) {
            this.f3975a = c1375f;
            this.f3976b = c1368a;
            this.f3977c = context;
        }

        /* renamed from: a */
        protected T m4679a(Void... voidArr) {
            T b;
            Exception e;
            try {
                b = this.f3975a.mo2869b();
                try {
                    this.f3978d = this.f3975a.m4701c();
                } catch (Exception e2) {
                    e = e2;
                    C1540a.m5396a(this.f3977c, "database", C1541b.f4567l, e);
                    this.f3978d = C1374a.UNKNOWN;
                    return b;
                }
            } catch (Exception e3) {
                Exception exception = e3;
                b = null;
                e = exception;
                C1540a.m5396a(this.f3977c, "database", C1541b.f4567l, e);
                this.f3978d = C1374a.UNKNOWN;
                return b;
            }
            return b;
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m4679a((Void[]) objArr);
        }

        protected void onPostExecute(T t) {
            if (this.f3978d == null) {
                this.f3976b.mo943a(t);
            } else {
                this.f3976b.mo942a(this.f3978d.m4697a(), this.f3978d.m4698b());
            }
            this.f3976b.m4675a();
        }
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT tokens.");
        stringBuilder.append(C3576h.f9567a.f3972b);
        stringBuilder.append(", ");
        stringBuilder.append("tokens");
        stringBuilder.append(".");
        stringBuilder.append(C3576h.f9568b.f3972b);
        stringBuilder.append(", ");
        stringBuilder.append("events");
        stringBuilder.append(".");
        stringBuilder.append(C3575c.f9556a.f3972b);
        stringBuilder.append(", ");
        stringBuilder.append("events");
        stringBuilder.append(".");
        stringBuilder.append(C3575c.f9558c.f3972b);
        stringBuilder.append(", ");
        stringBuilder.append("events");
        stringBuilder.append(".");
        stringBuilder.append(C3575c.f9559d.f3972b);
        stringBuilder.append(", ");
        stringBuilder.append("events");
        stringBuilder.append(".");
        stringBuilder.append(C3575c.f9560e.f3972b);
        stringBuilder.append(", ");
        stringBuilder.append("events");
        stringBuilder.append(".");
        stringBuilder.append(C3575c.f9561f.f3972b);
        stringBuilder.append(", ");
        stringBuilder.append("events");
        stringBuilder.append(".");
        stringBuilder.append(C3575c.f9562g.f3972b);
        stringBuilder.append(", ");
        stringBuilder.append("events");
        stringBuilder.append(".");
        stringBuilder.append(C3575c.f9563h.f3972b);
        stringBuilder.append(", ");
        stringBuilder.append("events");
        stringBuilder.append(".");
        stringBuilder.append(C3575c.f9564i.f3972b);
        stringBuilder.append(" FROM ");
        stringBuilder.append("events");
        stringBuilder.append(" JOIN ");
        stringBuilder.append("tokens");
        stringBuilder.append(" ON ");
        stringBuilder.append("events");
        stringBuilder.append(".");
        stringBuilder.append(C3575c.f9557b.f3972b);
        stringBuilder.append(" = ");
        stringBuilder.append("tokens");
        stringBuilder.append(".");
        stringBuilder.append(C3576h.f9567a.f3972b);
        stringBuilder.append(" ORDER BY ");
        stringBuilder.append("events");
        stringBuilder.append(".");
        stringBuilder.append(C3575c.f9560e.f3972b);
        stringBuilder.append(" ASC");
        f3979a = stringBuilder.toString();
        Executor threadPoolExecutor = new ThreadPoolExecutor(f3981c, f3982d, 30, TimeUnit.SECONDS, f3984f, f3983e);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f3985g = threadPoolExecutor;
    }

    public C1372d(Context context) {
        this.f3989k = context;
    }

    /* renamed from: i */
    private synchronized SQLiteDatabase m4684i() {
        if (this.f3992n == null) {
            this.f3992n = new C1373e(this.f3989k, this);
        }
        return this.f3992n.getWritableDatabase();
    }

    /* renamed from: a */
    public Cursor m4685a(int i) {
        f3987i.lock();
        try {
            SQLiteDatabase a = m4686a();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f3979a);
            stringBuilder.append(" LIMIT ");
            stringBuilder.append(String.valueOf(i));
            Cursor rawQuery = a.rawQuery(stringBuilder.toString(), null);
            return rawQuery;
        } finally {
            f3987i.unlock();
        }
    }

    /* renamed from: a */
    public SQLiteDatabase m4686a() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return m4684i();
        }
        throw new IllegalStateException("Cannot call getDatabase from the UI thread!");
    }

    /* renamed from: a */
    public <T> AsyncTask m4687a(C1375f<T> c1375f, C1368a<T> c1368a) {
        return C1496d.m5269a(f3985g, new C1371a(this.f3989k.getApplicationContext(), c1375f, c1368a), new Void[0]);
    }

    /* renamed from: a */
    public AsyncTask m4688a(String str, int i, String str2, double d, double d2, String str3, Map<String, String> map, C1368a<String> c1368a) {
        final String str4 = str;
        final int i2 = i;
        final String str5 = str2;
        final double d3 = d;
        final double d4 = d2;
        final String str6 = str3;
        final Map<String, String> map2 = map;
        C1375f c45672 = new C3577i<String>(this) {
            /* renamed from: h */
            final /* synthetic */ C1372d f12434h;

            /* renamed from: a */
            public String m15753a() {
                Exception e;
                Throwable th;
                if (TextUtils.isEmpty(str4)) {
                    return null;
                }
                C1372d.f3988j.lock();
                SQLiteDatabase a;
                try {
                    a = this.f12434h.m4686a();
                    try {
                        a.beginTransaction();
                        String a2 = this.f12434h.f3991m.m11646a(this.f12434h.f3990l.m11652a(str4), i2, str5, d3, d4, str6, map2);
                        a.setTransactionSuccessful();
                        if (a != null && a.isOpen()) {
                            try {
                                if (a.inTransaction()) {
                                    a.endTransaction();
                                }
                            } catch (Exception e2) {
                                C1540a.m5396a(this.f12434h.f3989k, "database", C1541b.f4566k, e2);
                            }
                        }
                        C1372d.f3988j.unlock();
                        return a2;
                    } catch (Exception e3) {
                        e = e3;
                        try {
                            m4699a(C1374a.DATABASE_INSERT);
                            C1540a.m5396a(this.f12434h.f3989k, "database", C1541b.f4564i, e);
                            try {
                                if (a.inTransaction()) {
                                    a.endTransaction();
                                }
                            } catch (Exception e22) {
                                C1540a.m5396a(this.f12434h.f3989k, "database", C1541b.f4566k, e22);
                            }
                            C1372d.f3988j.unlock();
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                if (a.inTransaction()) {
                                    a.endTransaction();
                                }
                            } catch (Exception e222) {
                                C1540a.m5396a(this.f12434h.f3989k, "database", C1541b.f4566k, e222);
                            }
                            C1372d.f3988j.unlock();
                            throw th;
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    a = null;
                    m4699a(C1374a.DATABASE_INSERT);
                    C1540a.m5396a(this.f12434h.f3989k, "database", C1541b.f4564i, e);
                    if (a != null && a.isOpen()) {
                        if (a.inTransaction()) {
                            a.endTransaction();
                        }
                    }
                    C1372d.f3988j.unlock();
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    a = null;
                    if (a != null && a.isOpen()) {
                        if (a.inTransaction()) {
                            a.endTransaction();
                        }
                    }
                    C1372d.f3988j.unlock();
                    throw th;
                }
            }

            /* renamed from: b */
            public /* synthetic */ Object mo2869b() {
                return m15753a();
            }
        };
        C1372d c1372d = this;
        return m4687a(c45672, c1368a);
    }

    /* renamed from: a */
    public boolean m4689a(java.lang.String r6) {
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
        r5 = this;
        r0 = f3988j;
        r0.lock();
        r0 = 1;
        r1 = 0;
        r2 = new java.lang.StringBuilder;	 Catch:{ SQLiteException -> 0x0054 }
        r2.<init>();	 Catch:{ SQLiteException -> 0x0054 }
        r3 = "UPDATE ";	 Catch:{ SQLiteException -> 0x0054 }
        r2.append(r3);	 Catch:{ SQLiteException -> 0x0054 }
        r3 = "events";	 Catch:{ SQLiteException -> 0x0054 }
        r2.append(r3);	 Catch:{ SQLiteException -> 0x0054 }
        r3 = " SET ";	 Catch:{ SQLiteException -> 0x0054 }
        r2.append(r3);	 Catch:{ SQLiteException -> 0x0054 }
        r3 = com.facebook.ads.internal.p090e.C3575c.f9564i;	 Catch:{ SQLiteException -> 0x0054 }
        r3 = r3.f3972b;	 Catch:{ SQLiteException -> 0x0054 }
        r2.append(r3);	 Catch:{ SQLiteException -> 0x0054 }
        r3 = "=";	 Catch:{ SQLiteException -> 0x0054 }
        r2.append(r3);	 Catch:{ SQLiteException -> 0x0054 }
        r3 = com.facebook.ads.internal.p090e.C3575c.f9564i;	 Catch:{ SQLiteException -> 0x0054 }
        r3 = r3.f3972b;	 Catch:{ SQLiteException -> 0x0054 }
        r2.append(r3);	 Catch:{ SQLiteException -> 0x0054 }
        r3 = "+1";	 Catch:{ SQLiteException -> 0x0054 }
        r2.append(r3);	 Catch:{ SQLiteException -> 0x0054 }
        r3 = " WHERE ";	 Catch:{ SQLiteException -> 0x0054 }
        r2.append(r3);	 Catch:{ SQLiteException -> 0x0054 }
        r3 = com.facebook.ads.internal.p090e.C3575c.f9556a;	 Catch:{ SQLiteException -> 0x0054 }
        r3 = r3.f3972b;	 Catch:{ SQLiteException -> 0x0054 }
        r2.append(r3);	 Catch:{ SQLiteException -> 0x0054 }
        r3 = "=?";	 Catch:{ SQLiteException -> 0x0054 }
        r2.append(r3);	 Catch:{ SQLiteException -> 0x0054 }
        r3 = r5.m4686a();	 Catch:{ SQLiteException -> 0x0054 }
        r2 = r2.toString();	 Catch:{ SQLiteException -> 0x0054 }
        r4 = new java.lang.String[r0];	 Catch:{ SQLiteException -> 0x0054 }
        r4[r1] = r6;	 Catch:{ SQLiteException -> 0x0054 }
        r3.execSQL(r2, r4);	 Catch:{ SQLiteException -> 0x0054 }
        goto L_0x0055;
    L_0x0054:
        r0 = 0;
    L_0x0055:
        r6 = f3988j;
        r6.unlock();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.e.d.a(java.lang.String):boolean");
    }

    /* renamed from: b */
    public synchronized void m4690b() {
        for (C1376g e : m4692c()) {
            e.m4709e();
        }
        if (this.f3992n != null) {
            this.f3992n.close();
            this.f3992n = null;
        }
    }

    /* renamed from: b */
    public boolean m4691b(String str) {
        f3988j.lock();
        try {
            boolean a = this.f3991m.m11647a(str);
            return a;
        } finally {
            f3988j.unlock();
        }
    }

    /* renamed from: c */
    public C1376g[] m4692c() {
        return new C1376g[]{this.f3990l, this.f3991m};
    }

    /* renamed from: d */
    public Cursor m4693d() {
        f3987i.lock();
        try {
            Cursor c = this.f3991m.mo940c();
            return c;
        } finally {
            f3987i.unlock();
        }
    }

    /* renamed from: e */
    public Cursor m4694e() {
        f3987i.lock();
        try {
            Cursor d = this.f3991m.m11650d();
            return d;
        } finally {
            f3987i.unlock();
        }
    }

    /* renamed from: f */
    public Cursor m4695f() {
        f3987i.lock();
        try {
            Cursor c = this.f3990l.mo940c();
            return c;
        } finally {
            f3987i.unlock();
        }
    }

    /* renamed from: g */
    public void m4696g() {
        f3988j.lock();
        try {
            this.f3990l.m11655d();
        } finally {
            f3988j.unlock();
        }
    }
}
