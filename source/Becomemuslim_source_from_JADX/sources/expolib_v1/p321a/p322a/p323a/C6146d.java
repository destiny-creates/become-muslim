package expolib_v1.p321a.p322a.p323a;

import com.facebook.ads.AdError;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.cache.disk.DefaultDiskStorage.FileType;
import expolib_v1.p321a.p322a.C6165c;
import expolib_v1.p321a.p322a.p328f.C6188a;
import expolib_v1.p321a.p322a.p329g.C6192e;
import expolib_v1.p332b.C6252l;
import expolib_v1.p332b.C6258s;
import expolib_v1.p332b.C7496d;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* compiled from: DiskLruCache */
/* renamed from: expolib_v1.a.a.a.d */
public final class C6146d implements Closeable, Flushable {
    /* renamed from: a */
    static final Pattern f19846a = Pattern.compile("[a-z0-9_-]{1,120}");
    /* renamed from: m */
    static final /* synthetic */ boolean f19847m = (C6146d.class.desiredAssertionStatus() ^ 1);
    /* renamed from: b */
    final C6188a f19848b;
    /* renamed from: c */
    final File f19849c;
    /* renamed from: d */
    final int f19850d;
    /* renamed from: e */
    C7496d f19851e;
    /* renamed from: f */
    final LinkedHashMap<String, C6144b> f19852f = new LinkedHashMap(0, 0.75f, true);
    /* renamed from: g */
    int f19853g;
    /* renamed from: h */
    boolean f19854h;
    /* renamed from: i */
    boolean f19855i;
    /* renamed from: j */
    boolean f19856j;
    /* renamed from: k */
    boolean f19857k;
    /* renamed from: l */
    boolean f19858l;
    /* renamed from: n */
    private final File f19859n;
    /* renamed from: o */
    private final File f19860o;
    /* renamed from: p */
    private final File f19861p;
    /* renamed from: q */
    private final int f19862q;
    /* renamed from: r */
    private long f19863r;
    /* renamed from: s */
    private long f19864s = 0;
    /* renamed from: t */
    private long f19865t = 0;
    /* renamed from: u */
    private final Executor f19866u;
    /* renamed from: v */
    private final Runnable f19867v = new C61421(this);

    /* compiled from: DiskLruCache */
    /* renamed from: expolib_v1.a.a.a.d$1 */
    class C61421 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C6146d f19828a;

        C61421(C6146d c6146d) {
            this.f19828a = c6146d;
        }

        public void run() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r4 = this;
            r0 = r4.f19828a;
            monitor-enter(r0);
            r1 = r4.f19828a;	 Catch:{ all -> 0x0041 }
            r1 = r1.f19855i;	 Catch:{ all -> 0x0041 }
            r2 = 1;	 Catch:{ all -> 0x0041 }
            r1 = r1 ^ r2;	 Catch:{ all -> 0x0041 }
            r3 = r4.f19828a;	 Catch:{ all -> 0x0041 }
            r3 = r3.f19856j;	 Catch:{ all -> 0x0041 }
            r1 = r1 | r3;	 Catch:{ all -> 0x0041 }
            if (r1 == 0) goto L_0x0012;	 Catch:{ all -> 0x0041 }
        L_0x0010:
            monitor-exit(r0);	 Catch:{ all -> 0x0041 }
            return;
        L_0x0012:
            r1 = r4.f19828a;	 Catch:{ IOException -> 0x0018 }
            r1.m25211e();	 Catch:{ IOException -> 0x0018 }
            goto L_0x001c;
        L_0x0018:
            r1 = r4.f19828a;	 Catch:{ all -> 0x0041 }
            r1.f19857k = r2;	 Catch:{ all -> 0x0041 }
        L_0x001c:
            r1 = r4.f19828a;	 Catch:{ IOException -> 0x002f }
            r1 = r1.m25208c();	 Catch:{ IOException -> 0x002f }
            if (r1 == 0) goto L_0x003f;	 Catch:{ IOException -> 0x002f }
        L_0x0024:
            r1 = r4.f19828a;	 Catch:{ IOException -> 0x002f }
            r1.m25207b();	 Catch:{ IOException -> 0x002f }
            r1 = r4.f19828a;	 Catch:{ IOException -> 0x002f }
            r3 = 0;	 Catch:{ IOException -> 0x002f }
            r1.f19853g = r3;	 Catch:{ IOException -> 0x002f }
            goto L_0x003f;
        L_0x002f:
            r1 = r4.f19828a;	 Catch:{ all -> 0x0041 }
            r1.f19858l = r2;	 Catch:{ all -> 0x0041 }
            r1 = r4.f19828a;	 Catch:{ all -> 0x0041 }
            r2 = expolib_v1.p332b.C6252l.m25860a();	 Catch:{ all -> 0x0041 }
            r2 = expolib_v1.p332b.C6252l.m25858a(r2);	 Catch:{ all -> 0x0041 }
            r1.f19851e = r2;	 Catch:{ all -> 0x0041 }
        L_0x003f:
            monitor-exit(r0);	 Catch:{ all -> 0x0041 }
            return;	 Catch:{ all -> 0x0041 }
        L_0x0041:
            r1 = move-exception;	 Catch:{ all -> 0x0041 }
            monitor-exit(r0);	 Catch:{ all -> 0x0041 }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.a.d.1.run():void");
        }
    }

    /* compiled from: DiskLruCache */
    /* renamed from: expolib_v1.a.a.a.d$a */
    public final class C6143a {
        /* renamed from: a */
        final C6144b f19829a;
        /* renamed from: b */
        final boolean[] f19830b;
        /* renamed from: c */
        final /* synthetic */ C6146d f19831c;
        /* renamed from: d */
        private boolean f19832d;

        C6143a(C6146d c6146d, C6144b c6144b) {
            this.f19831c = c6146d;
            this.f19829a = c6144b;
            this.f19830b = c6144b.f19837e != null ? null : new boolean[c6146d.f19850d];
        }

        /* renamed from: a */
        void m25185a() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r3 = this;
            r0 = r3.f19829a;
            r0 = r0.f19838f;
            if (r0 != r3) goto L_0x0022;
        L_0x0006:
            r0 = 0;
        L_0x0007:
            r1 = r3.f19831c;
            r1 = r1.f19850d;
            if (r0 >= r1) goto L_0x001d;
        L_0x000d:
            r1 = r3.f19831c;	 Catch:{ IOException -> 0x001a }
            r1 = r1.f19848b;	 Catch:{ IOException -> 0x001a }
            r2 = r3.f19829a;	 Catch:{ IOException -> 0x001a }
            r2 = r2.f19836d;	 Catch:{ IOException -> 0x001a }
            r2 = r2[r0];	 Catch:{ IOException -> 0x001a }
            r1.mo5287d(r2);	 Catch:{ IOException -> 0x001a }
        L_0x001a:
            r0 = r0 + 1;
            goto L_0x0007;
        L_0x001d:
            r0 = r3.f19829a;
            r1 = 0;
            r0.f19838f = r1;
        L_0x0022:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.a.d.a.a():void");
        }

        /* renamed from: a */
        public expolib_v1.p332b.C6257r m25184a(int r4) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r3 = this;
            r0 = r3.f19831c;
            monitor-enter(r0);
            r1 = r3.f19832d;	 Catch:{ all -> 0x003f }
            if (r1 != 0) goto L_0x0039;	 Catch:{ all -> 0x003f }
        L_0x0007:
            r1 = r3.f19829a;	 Catch:{ all -> 0x003f }
            r1 = r1.f19838f;	 Catch:{ all -> 0x003f }
            if (r1 == r3) goto L_0x0013;	 Catch:{ all -> 0x003f }
        L_0x000d:
            r4 = expolib_v1.p332b.C6252l.m25860a();	 Catch:{ all -> 0x003f }
            monitor-exit(r0);	 Catch:{ all -> 0x003f }
            return r4;	 Catch:{ all -> 0x003f }
        L_0x0013:
            r1 = r3.f19829a;	 Catch:{ all -> 0x003f }
            r1 = r1.f19837e;	 Catch:{ all -> 0x003f }
            if (r1 != 0) goto L_0x001e;	 Catch:{ all -> 0x003f }
        L_0x0019:
            r1 = r3.f19830b;	 Catch:{ all -> 0x003f }
            r2 = 1;	 Catch:{ all -> 0x003f }
            r1[r4] = r2;	 Catch:{ all -> 0x003f }
        L_0x001e:
            r1 = r3.f19829a;	 Catch:{ all -> 0x003f }
            r1 = r1.f19836d;	 Catch:{ all -> 0x003f }
            r4 = r1[r4];	 Catch:{ all -> 0x003f }
            r1 = r3.f19831c;	 Catch:{ FileNotFoundException -> 0x0033 }
            r1 = r1.f19848b;	 Catch:{ FileNotFoundException -> 0x0033 }
            r4 = r1.mo5285b(r4);	 Catch:{ FileNotFoundException -> 0x0033 }
            r1 = new expolib_v1.a.a.a.d$a$1;	 Catch:{ all -> 0x003f }
            r1.<init>(r3, r4);	 Catch:{ all -> 0x003f }
            monitor-exit(r0);	 Catch:{ all -> 0x003f }
            return r1;	 Catch:{ all -> 0x003f }
        L_0x0033:
            r4 = expolib_v1.p332b.C6252l.m25860a();	 Catch:{ all -> 0x003f }
            monitor-exit(r0);	 Catch:{ all -> 0x003f }
            return r4;	 Catch:{ all -> 0x003f }
        L_0x0039:
            r4 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x003f }
            r4.<init>();	 Catch:{ all -> 0x003f }
            throw r4;	 Catch:{ all -> 0x003f }
        L_0x003f:
            r4 = move-exception;	 Catch:{ all -> 0x003f }
            monitor-exit(r0);	 Catch:{ all -> 0x003f }
            throw r4;
            */
            throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.a.d.a.a(int):expolib_v1.b.r");
        }

        /* renamed from: b */
        public void m25186b() {
            synchronized (this.f19831c) {
                if (this.f19832d) {
                    throw new IllegalStateException();
                }
                if (this.f19829a.f19838f == this) {
                    this.f19831c.m25204a(this, true);
                }
                this.f19832d = true;
            }
        }

        /* renamed from: c */
        public void m25187c() {
            synchronized (this.f19831c) {
                if (this.f19832d) {
                    throw new IllegalStateException();
                }
                if (this.f19829a.f19838f == this) {
                    this.f19831c.m25204a(this, false);
                }
                this.f19832d = true;
            }
        }
    }

    /* compiled from: DiskLruCache */
    /* renamed from: expolib_v1.a.a.a.d$b */
    private final class C6144b {
        /* renamed from: a */
        final String f19833a;
        /* renamed from: b */
        final long[] f19834b;
        /* renamed from: c */
        final File[] f19835c;
        /* renamed from: d */
        final File[] f19836d;
        /* renamed from: e */
        boolean f19837e;
        /* renamed from: f */
        C6143a f19838f;
        /* renamed from: g */
        long f19839g;
        /* renamed from: h */
        final /* synthetic */ C6146d f19840h;

        C6144b(C6146d c6146d, String str) {
            this.f19840h = c6146d;
            this.f19833a = str;
            this.f19834b = new long[c6146d.f19850d];
            this.f19835c = new File[c6146d.f19850d];
            this.f19836d = new File[c6146d.f19850d];
            StringBuilder stringBuilder = new StringBuilder(str);
            stringBuilder.append('.');
            str = stringBuilder.length();
            for (int i = 0; i < c6146d.f19850d; i++) {
                stringBuilder.append(i);
                this.f19835c[i] = new File(c6146d.f19849c, stringBuilder.toString());
                stringBuilder.append(FileType.TEMP);
                this.f19836d[i] = new File(c6146d.f19849c, stringBuilder.toString());
                stringBuilder.setLength(str);
            }
        }

        /* renamed from: a */
        void m25191a(java.lang.String[] r5) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r4 = this;
            r0 = r5.length;
            r1 = r4.f19840h;
            r1 = r1.f19850d;
            if (r0 != r1) goto L_0x001e;
        L_0x0007:
            r0 = 0;
        L_0x0008:
            r1 = r5.length;	 Catch:{ NumberFormatException -> 0x0019 }
            if (r0 >= r1) goto L_0x0018;	 Catch:{ NumberFormatException -> 0x0019 }
        L_0x000b:
            r1 = r4.f19834b;	 Catch:{ NumberFormatException -> 0x0019 }
            r2 = r5[r0];	 Catch:{ NumberFormatException -> 0x0019 }
            r2 = java.lang.Long.parseLong(r2);	 Catch:{ NumberFormatException -> 0x0019 }
            r1[r0] = r2;	 Catch:{ NumberFormatException -> 0x0019 }
            r0 = r0 + 1;
            goto L_0x0008;
        L_0x0018:
            return;
        L_0x0019:
            r5 = r4.m25188b(r5);
            throw r5;
        L_0x001e:
            r5 = r4.m25188b(r5);
            throw r5;
            */
            throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.a.d.b.a(java.lang.String[]):void");
        }

        /* renamed from: a */
        void m25190a(C7496d c7496d) {
            for (long m : this.f19834b) {
                c7496d.mo6389i(32).mo6394m(m);
            }
        }

        /* renamed from: b */
        private IOException m25188b(String[] strArr) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("unexpected journal line: ");
            stringBuilder.append(Arrays.toString(strArr));
            throw new IOException(stringBuilder.toString());
        }

        /* renamed from: a */
        expolib_v1.p321a.p322a.p323a.C6146d.C6145c m25189a() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r10 = this;
            r0 = r10.f19840h;
            r0 = java.lang.Thread.holdsLock(r0);
            if (r0 == 0) goto L_0x0057;
        L_0x0008:
            r0 = r10.f19840h;
            r0 = r0.f19850d;
            r0 = new expolib_v1.p332b.C6258s[r0];
            r1 = r10.f19834b;
            r1 = r1.clone();
            r7 = r1;
            r7 = (long[]) r7;
            r8 = 0;
            r1 = 0;
        L_0x0019:
            r2 = r10.f19840h;	 Catch:{ FileNotFoundException -> 0x003e }
            r2 = r2.f19850d;	 Catch:{ FileNotFoundException -> 0x003e }
            if (r1 >= r2) goto L_0x0030;	 Catch:{ FileNotFoundException -> 0x003e }
        L_0x001f:
            r2 = r10.f19840h;	 Catch:{ FileNotFoundException -> 0x003e }
            r2 = r2.f19848b;	 Catch:{ FileNotFoundException -> 0x003e }
            r3 = r10.f19835c;	 Catch:{ FileNotFoundException -> 0x003e }
            r3 = r3[r1];	 Catch:{ FileNotFoundException -> 0x003e }
            r2 = r2.mo5283a(r3);	 Catch:{ FileNotFoundException -> 0x003e }
            r0[r1] = r2;	 Catch:{ FileNotFoundException -> 0x003e }
            r1 = r1 + 1;	 Catch:{ FileNotFoundException -> 0x003e }
            goto L_0x0019;	 Catch:{ FileNotFoundException -> 0x003e }
        L_0x0030:
            r9 = new expolib_v1.a.a.a.d$c;	 Catch:{ FileNotFoundException -> 0x003e }
            r2 = r10.f19840h;	 Catch:{ FileNotFoundException -> 0x003e }
            r3 = r10.f19833a;	 Catch:{ FileNotFoundException -> 0x003e }
            r4 = r10.f19839g;	 Catch:{ FileNotFoundException -> 0x003e }
            r1 = r9;	 Catch:{ FileNotFoundException -> 0x003e }
            r6 = r0;	 Catch:{ FileNotFoundException -> 0x003e }
            r1.<init>(r2, r3, r4, r6, r7);	 Catch:{ FileNotFoundException -> 0x003e }
            return r9;
        L_0x003e:
            r1 = r10.f19840h;
            r1 = r1.f19850d;
            if (r8 >= r1) goto L_0x0050;
        L_0x0044:
            r1 = r0[r8];
            if (r1 == 0) goto L_0x0050;
        L_0x0048:
            r1 = r0[r8];
            expolib_v1.p321a.p322a.C6165c.m25315a(r1);
            r8 = r8 + 1;
            goto L_0x003e;
        L_0x0050:
            r0 = r10.f19840h;	 Catch:{ IOException -> 0x0055 }
            r0.m25205a(r10);	 Catch:{ IOException -> 0x0055 }
        L_0x0055:
            r0 = 0;
            return r0;
        L_0x0057:
            r0 = new java.lang.AssertionError;
            r0.<init>();
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.a.d.b.a():expolib_v1.a.a.a.d$c");
        }
    }

    /* compiled from: DiskLruCache */
    /* renamed from: expolib_v1.a.a.a.d$c */
    public final class C6145c implements Closeable {
        /* renamed from: a */
        final /* synthetic */ C6146d f19841a;
        /* renamed from: b */
        private final String f19842b;
        /* renamed from: c */
        private final long f19843c;
        /* renamed from: d */
        private final C6258s[] f19844d;
        /* renamed from: e */
        private final long[] f19845e;

        C6145c(C6146d c6146d, String str, long j, C6258s[] c6258sArr, long[] jArr) {
            this.f19841a = c6146d;
            this.f19842b = str;
            this.f19843c = j;
            this.f19844d = c6258sArr;
            this.f19845e = jArr;
        }

        /* renamed from: a */
        public C6143a m25192a() {
            return this.f19841a.m25201a(this.f19842b, this.f19843c);
        }

        /* renamed from: a */
        public C6258s m25193a(int i) {
            return this.f19844d[i];
        }

        public void close() {
            for (Closeable a : this.f19844d) {
                C6165c.m25315a(a);
            }
        }
    }

    C6146d(C6188a c6188a, File file, int i, int i2, long j, Executor executor) {
        this.f19848b = c6188a;
        this.f19849c = file;
        this.f19862q = i;
        this.f19859n = new File(file, "journal");
        this.f19860o = new File(file, "journal.tmp");
        this.f19861p = new File(file, "journal.bkp");
        this.f19850d = i2;
        this.f19863r = j;
        this.f19866u = executor;
    }

    /* renamed from: a */
    public synchronized void m25203a() {
        if (!f19847m) {
            if (!Thread.holdsLock(this)) {
                throw new AssertionError();
            }
        }
        if (!this.f19855i) {
            if (this.f19848b.mo5288e(this.f19861p)) {
                if (this.f19848b.mo5288e(this.f19859n)) {
                    this.f19848b.mo5287d(this.f19861p);
                } else {
                    this.f19848b.mo5284a(this.f19861p, this.f19859n);
                }
            }
            if (this.f19848b.mo5288e(this.f19859n)) {
                try {
                    m25197g();
                    m25199i();
                    this.f19855i = true;
                    return;
                } catch (Throwable e) {
                    C6192e b = C6192e.m25495b();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("DiskLruCache ");
                    stringBuilder.append(this.f19849c);
                    stringBuilder.append(" is corrupt: ");
                    stringBuilder.append(e.getMessage());
                    stringBuilder.append(", removing");
                    b.mo5296a(5, stringBuilder.toString(), e);
                    m25212f();
                } finally {
                    this.f19856j = false;
                }
            }
            m25207b();
            this.f19855i = true;
        }
    }

    /* renamed from: a */
    public static C6146d m25194a(C6188a c6188a, File file, int i, int i2, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i2 > 0) {
            return new C6146d(c6188a, file, i, i2, j, new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), C6165c.m25313a("OkHttp DiskLruCache", true)));
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    /* renamed from: g */
    private void m25197g() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r0 = r8.f19848b;
        r1 = r8.f19859n;
        r0 = r0.mo5283a(r1);
        r0 = expolib_v1.p332b.C6252l.m25859a(r0);
        r1 = r0.mo6401s();	 Catch:{ all -> 0x00ac }
        r2 = r0.mo6401s();	 Catch:{ all -> 0x00ac }
        r3 = r0.mo6401s();	 Catch:{ all -> 0x00ac }
        r4 = r0.mo6401s();	 Catch:{ all -> 0x00ac }
        r5 = r0.mo6401s();	 Catch:{ all -> 0x00ac }
        r6 = "libcore.io.DiskLruCache";	 Catch:{ all -> 0x00ac }
        r6 = r6.equals(r1);	 Catch:{ all -> 0x00ac }
        if (r6 == 0) goto L_0x0078;	 Catch:{ all -> 0x00ac }
    L_0x0028:
        r6 = "1";	 Catch:{ all -> 0x00ac }
        r6 = r6.equals(r2);	 Catch:{ all -> 0x00ac }
        if (r6 == 0) goto L_0x0078;	 Catch:{ all -> 0x00ac }
    L_0x0030:
        r6 = r8.f19862q;	 Catch:{ all -> 0x00ac }
        r6 = java.lang.Integer.toString(r6);	 Catch:{ all -> 0x00ac }
        r3 = r6.equals(r3);	 Catch:{ all -> 0x00ac }
        if (r3 == 0) goto L_0x0078;	 Catch:{ all -> 0x00ac }
    L_0x003c:
        r3 = r8.f19850d;	 Catch:{ all -> 0x00ac }
        r3 = java.lang.Integer.toString(r3);	 Catch:{ all -> 0x00ac }
        r3 = r3.equals(r4);	 Catch:{ all -> 0x00ac }
        if (r3 == 0) goto L_0x0078;	 Catch:{ all -> 0x00ac }
    L_0x0048:
        r3 = "";	 Catch:{ all -> 0x00ac }
        r3 = r3.equals(r5);	 Catch:{ all -> 0x00ac }
        if (r3 == 0) goto L_0x0078;
    L_0x0050:
        r1 = 0;
    L_0x0051:
        r2 = r0.mo6401s();	 Catch:{ EOFException -> 0x005b }
        r8.m25195d(r2);	 Catch:{ EOFException -> 0x005b }
        r1 = r1 + 1;
        goto L_0x0051;
    L_0x005b:
        r2 = r8.f19852f;	 Catch:{ all -> 0x00ac }
        r2 = r2.size();	 Catch:{ all -> 0x00ac }
        r1 = r1 - r2;	 Catch:{ all -> 0x00ac }
        r8.f19853g = r1;	 Catch:{ all -> 0x00ac }
        r1 = r0.mo6382f();	 Catch:{ all -> 0x00ac }
        if (r1 != 0) goto L_0x006e;	 Catch:{ all -> 0x00ac }
    L_0x006a:
        r8.m25207b();	 Catch:{ all -> 0x00ac }
        goto L_0x0074;	 Catch:{ all -> 0x00ac }
    L_0x006e:
        r1 = r8.m25198h();	 Catch:{ all -> 0x00ac }
        r8.f19851e = r1;	 Catch:{ all -> 0x00ac }
    L_0x0074:
        expolib_v1.p321a.p322a.C6165c.m25315a(r0);
        return;
    L_0x0078:
        r3 = new java.io.IOException;	 Catch:{ all -> 0x00ac }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ac }
        r6.<init>();	 Catch:{ all -> 0x00ac }
        r7 = "unexpected journal header: [";	 Catch:{ all -> 0x00ac }
        r6.append(r7);	 Catch:{ all -> 0x00ac }
        r6.append(r1);	 Catch:{ all -> 0x00ac }
        r1 = ", ";	 Catch:{ all -> 0x00ac }
        r6.append(r1);	 Catch:{ all -> 0x00ac }
        r6.append(r2);	 Catch:{ all -> 0x00ac }
        r1 = ", ";	 Catch:{ all -> 0x00ac }
        r6.append(r1);	 Catch:{ all -> 0x00ac }
        r6.append(r4);	 Catch:{ all -> 0x00ac }
        r1 = ", ";	 Catch:{ all -> 0x00ac }
        r6.append(r1);	 Catch:{ all -> 0x00ac }
        r6.append(r5);	 Catch:{ all -> 0x00ac }
        r1 = "]";	 Catch:{ all -> 0x00ac }
        r6.append(r1);	 Catch:{ all -> 0x00ac }
        r1 = r6.toString();	 Catch:{ all -> 0x00ac }
        r3.<init>(r1);	 Catch:{ all -> 0x00ac }
        throw r3;	 Catch:{ all -> 0x00ac }
    L_0x00ac:
        r1 = move-exception;
        expolib_v1.p321a.p322a.C6165c.m25315a(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.a.d.g():void");
    }

    /* renamed from: h */
    private C7496d m25198h() {
        return C6252l.m25858a(new C8162e(this, this.f19848b.mo5286c(this.f19859n)) {
            /* renamed from: a */
            static final /* synthetic */ boolean f32453a = (C6146d.class.desiredAssertionStatus() ^ 1);
            /* renamed from: b */
            final /* synthetic */ C6146d f32454b;

            /* renamed from: a */
            protected void mo6766a(IOException iOException) {
                if (f32453a == null) {
                    if (Thread.holdsLock(this.f32454b) == null) {
                        throw new AssertionError();
                    }
                }
                this.f32454b.f19854h = true;
            }
        });
    }

    /* renamed from: d */
    private void m25195d(String str) {
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            String substring;
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(32, i);
            if (indexOf2 == -1) {
                substring = str.substring(i);
                if (indexOf == "REMOVE".length() && str.startsWith("REMOVE")) {
                    this.f19852f.remove(substring);
                    return;
                }
            }
            substring = str.substring(i, indexOf2);
            C6144b c6144b = (C6144b) this.f19852f.get(substring);
            if (c6144b == null) {
                c6144b = new C6144b(this, substring);
                this.f19852f.put(substring, c6144b);
            }
            if (indexOf2 != -1 && indexOf == "CLEAN".length() && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                c6144b.f19837e = true;
                c6144b.f19838f = null;
                c6144b.m25191a(split);
            } else if (indexOf2 == -1 && indexOf == "DIRTY".length() && str.startsWith("DIRTY")) {
                c6144b.f19838f = new C6143a(this, c6144b);
            } else if (!(indexOf2 == -1 && indexOf == "READ".length() && str.startsWith("READ"))) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("unexpected journal line: ");
                stringBuilder.append(str);
                throw new IOException(stringBuilder.toString());
            }
            return;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("unexpected journal line: ");
        stringBuilder.append(str);
        throw new IOException(stringBuilder.toString());
    }

    /* renamed from: i */
    private void m25199i() {
        this.f19848b.mo5287d(this.f19860o);
        Iterator it = this.f19852f.values().iterator();
        while (it.hasNext()) {
            C6144b c6144b = (C6144b) it.next();
            int i = 0;
            if (c6144b.f19838f == null) {
                while (i < this.f19850d) {
                    this.f19864s += c6144b.f19834b[i];
                    i++;
                }
            } else {
                c6144b.f19838f = null;
                while (i < this.f19850d) {
                    this.f19848b.mo5287d(c6144b.f19835c[i]);
                    this.f19848b.mo5287d(c6144b.f19836d[i]);
                    i++;
                }
                it.remove();
            }
        }
    }

    /* renamed from: b */
    synchronized void m25207b() {
        if (this.f19851e != null) {
            this.f19851e.close();
        }
        C7496d a = C6252l.m25858a(this.f19848b.mo5285b(this.f19860o));
        try {
            a.mo6373b("libcore.io.DiskLruCache").mo6389i(10);
            a.mo6373b(AppEventsConstants.EVENT_PARAM_VALUE_YES).mo6389i(10);
            a.mo6394m((long) this.f19862q).mo6389i(10);
            a.mo6394m((long) this.f19850d).mo6389i(10);
            a.mo6389i(10);
            for (C6144b c6144b : this.f19852f.values()) {
                if (c6144b.f19838f != null) {
                    a.mo6373b("DIRTY").mo6389i(32);
                    a.mo6373b(c6144b.f19833a);
                    a.mo6389i(10);
                } else {
                    a.mo6373b("CLEAN").mo6389i(32);
                    a.mo6373b(c6144b.f19833a);
                    c6144b.m25190a(a);
                    a.mo6389i(10);
                }
            }
            if (this.f19848b.mo5288e(this.f19859n)) {
                this.f19848b.mo5284a(this.f19859n, this.f19861p);
            }
            this.f19848b.mo5284a(this.f19860o, this.f19859n);
            this.f19848b.mo5287d(this.f19861p);
            this.f19851e = m25198h();
            this.f19854h = false;
            this.f19858l = false;
        } finally {
            a.close();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public synchronized expolib_v1.p321a.p322a.p323a.C6146d.C6145c m25202a(java.lang.String r4) {
        /*
        r3 = this;
        monitor-enter(r3);
        r3.m25203a();	 Catch:{ all -> 0x0050 }
        r3.m25200j();	 Catch:{ all -> 0x0050 }
        r3.m25196e(r4);	 Catch:{ all -> 0x0050 }
        r0 = r3.f19852f;	 Catch:{ all -> 0x0050 }
        r0 = r0.get(r4);	 Catch:{ all -> 0x0050 }
        r0 = (expolib_v1.p321a.p322a.p323a.C6146d.C6144b) r0;	 Catch:{ all -> 0x0050 }
        r1 = 0;
        if (r0 == 0) goto L_0x004e;
    L_0x0015:
        r2 = r0.f19837e;	 Catch:{ all -> 0x0050 }
        if (r2 != 0) goto L_0x001a;
    L_0x0019:
        goto L_0x004e;
    L_0x001a:
        r0 = r0.m25189a();	 Catch:{ all -> 0x0050 }
        if (r0 != 0) goto L_0x0022;
    L_0x0020:
        monitor-exit(r3);
        return r1;
    L_0x0022:
        r1 = r3.f19853g;	 Catch:{ all -> 0x0050 }
        r1 = r1 + 1;
        r3.f19853g = r1;	 Catch:{ all -> 0x0050 }
        r1 = r3.f19851e;	 Catch:{ all -> 0x0050 }
        r2 = "READ";
        r1 = r1.mo6373b(r2);	 Catch:{ all -> 0x0050 }
        r2 = 32;
        r1 = r1.mo6389i(r2);	 Catch:{ all -> 0x0050 }
        r4 = r1.mo6373b(r4);	 Catch:{ all -> 0x0050 }
        r1 = 10;
        r4.mo6389i(r1);	 Catch:{ all -> 0x0050 }
        r4 = r3.m25208c();	 Catch:{ all -> 0x0050 }
        if (r4 == 0) goto L_0x004c;
    L_0x0045:
        r4 = r3.f19866u;	 Catch:{ all -> 0x0050 }
        r1 = r3.f19867v;	 Catch:{ all -> 0x0050 }
        r4.execute(r1);	 Catch:{ all -> 0x0050 }
    L_0x004c:
        monitor-exit(r3);
        return r0;
    L_0x004e:
        monitor-exit(r3);
        return r1;
    L_0x0050:
        r4 = move-exception;
        monitor-exit(r3);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.a.d.a(java.lang.String):expolib_v1.a.a.a.d$c");
    }

    /* renamed from: b */
    public C6143a m25206b(String str) {
        return m25201a(str, -1);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    synchronized expolib_v1.p321a.p322a.p323a.C6146d.C6143a m25201a(java.lang.String r5, long r6) {
        /*
        r4 = this;
        monitor-enter(r4);
        r4.m25203a();	 Catch:{ all -> 0x0074 }
        r4.m25200j();	 Catch:{ all -> 0x0074 }
        r4.m25196e(r5);	 Catch:{ all -> 0x0074 }
        r0 = r4.f19852f;	 Catch:{ all -> 0x0074 }
        r0 = r0.get(r5);	 Catch:{ all -> 0x0074 }
        r0 = (expolib_v1.p321a.p322a.p323a.C6146d.C6144b) r0;	 Catch:{ all -> 0x0074 }
        r1 = -1;
        r3 = 0;
        r1 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1));
        if (r1 == 0) goto L_0x0023;
    L_0x0019:
        if (r0 == 0) goto L_0x0021;
    L_0x001b:
        r1 = r0.f19839g;	 Catch:{ all -> 0x0074 }
        r6 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1));
        if (r6 == 0) goto L_0x0023;
    L_0x0021:
        monitor-exit(r4);
        return r3;
    L_0x0023:
        if (r0 == 0) goto L_0x002b;
    L_0x0025:
        r6 = r0.f19838f;	 Catch:{ all -> 0x0074 }
        if (r6 == 0) goto L_0x002b;
    L_0x0029:
        monitor-exit(r4);
        return r3;
    L_0x002b:
        r6 = r4.f19857k;	 Catch:{ all -> 0x0074 }
        if (r6 != 0) goto L_0x006b;
    L_0x002f:
        r6 = r4.f19858l;	 Catch:{ all -> 0x0074 }
        if (r6 == 0) goto L_0x0034;
    L_0x0033:
        goto L_0x006b;
    L_0x0034:
        r6 = r4.f19851e;	 Catch:{ all -> 0x0074 }
        r7 = "DIRTY";
        r6 = r6.mo6373b(r7);	 Catch:{ all -> 0x0074 }
        r7 = 32;
        r6 = r6.mo6389i(r7);	 Catch:{ all -> 0x0074 }
        r6 = r6.mo6373b(r5);	 Catch:{ all -> 0x0074 }
        r7 = 10;
        r6.mo6389i(r7);	 Catch:{ all -> 0x0074 }
        r6 = r4.f19851e;	 Catch:{ all -> 0x0074 }
        r6.flush();	 Catch:{ all -> 0x0074 }
        r6 = r4.f19854h;	 Catch:{ all -> 0x0074 }
        if (r6 == 0) goto L_0x0056;
    L_0x0054:
        monitor-exit(r4);
        return r3;
    L_0x0056:
        if (r0 != 0) goto L_0x0062;
    L_0x0058:
        r0 = new expolib_v1.a.a.a.d$b;	 Catch:{ all -> 0x0074 }
        r0.<init>(r4, r5);	 Catch:{ all -> 0x0074 }
        r6 = r4.f19852f;	 Catch:{ all -> 0x0074 }
        r6.put(r5, r0);	 Catch:{ all -> 0x0074 }
    L_0x0062:
        r5 = new expolib_v1.a.a.a.d$a;	 Catch:{ all -> 0x0074 }
        r5.<init>(r4, r0);	 Catch:{ all -> 0x0074 }
        r0.f19838f = r5;	 Catch:{ all -> 0x0074 }
        monitor-exit(r4);
        return r5;
    L_0x006b:
        r5 = r4.f19866u;	 Catch:{ all -> 0x0074 }
        r6 = r4.f19867v;	 Catch:{ all -> 0x0074 }
        r5.execute(r6);	 Catch:{ all -> 0x0074 }
        monitor-exit(r4);
        return r3;
    L_0x0074:
        r5 = move-exception;
        monitor-exit(r4);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.a.d.a(java.lang.String, long):expolib_v1.a.a.a.d$a");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    synchronized void m25204a(expolib_v1.p321a.p322a.p323a.C6146d.C6143a r10, boolean r11) {
        /*
        r9 = this;
        monitor-enter(r9);
        r0 = r10.f19829a;	 Catch:{ all -> 0x00fc }
        r1 = r0.f19838f;	 Catch:{ all -> 0x00fc }
        if (r1 != r10) goto L_0x00f6;
    L_0x0007:
        r1 = 0;
        if (r11 == 0) goto L_0x0047;
    L_0x000a:
        r2 = r0.f19837e;	 Catch:{ all -> 0x00fc }
        if (r2 != 0) goto L_0x0047;
    L_0x000e:
        r2 = 0;
    L_0x000f:
        r3 = r9.f19850d;	 Catch:{ all -> 0x00fc }
        if (r2 >= r3) goto L_0x0047;
    L_0x0013:
        r3 = r10.f19830b;	 Catch:{ all -> 0x00fc }
        r3 = r3[r2];	 Catch:{ all -> 0x00fc }
        if (r3 == 0) goto L_0x002d;
    L_0x0019:
        r3 = r9.f19848b;	 Catch:{ all -> 0x00fc }
        r4 = r0.f19836d;	 Catch:{ all -> 0x00fc }
        r4 = r4[r2];	 Catch:{ all -> 0x00fc }
        r3 = r3.mo5288e(r4);	 Catch:{ all -> 0x00fc }
        if (r3 != 0) goto L_0x002a;
    L_0x0025:
        r10.m25187c();	 Catch:{ all -> 0x00fc }
        monitor-exit(r9);
        return;
    L_0x002a:
        r2 = r2 + 1;
        goto L_0x000f;
    L_0x002d:
        r10.m25187c();	 Catch:{ all -> 0x00fc }
        r10 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x00fc }
        r11 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00fc }
        r11.<init>();	 Catch:{ all -> 0x00fc }
        r0 = "Newly created entry didn't create value for index ";
        r11.append(r0);	 Catch:{ all -> 0x00fc }
        r11.append(r2);	 Catch:{ all -> 0x00fc }
        r11 = r11.toString();	 Catch:{ all -> 0x00fc }
        r10.<init>(r11);	 Catch:{ all -> 0x00fc }
        throw r10;	 Catch:{ all -> 0x00fc }
    L_0x0047:
        r10 = r9.f19850d;	 Catch:{ all -> 0x00fc }
        if (r1 >= r10) goto L_0x0080;
    L_0x004b:
        r10 = r0.f19836d;	 Catch:{ all -> 0x00fc }
        r10 = r10[r1];	 Catch:{ all -> 0x00fc }
        if (r11 == 0) goto L_0x0078;
    L_0x0051:
        r2 = r9.f19848b;	 Catch:{ all -> 0x00fc }
        r2 = r2.mo5288e(r10);	 Catch:{ all -> 0x00fc }
        if (r2 == 0) goto L_0x007d;
    L_0x0059:
        r2 = r0.f19835c;	 Catch:{ all -> 0x00fc }
        r2 = r2[r1];	 Catch:{ all -> 0x00fc }
        r3 = r9.f19848b;	 Catch:{ all -> 0x00fc }
        r3.mo5284a(r10, r2);	 Catch:{ all -> 0x00fc }
        r10 = r0.f19834b;	 Catch:{ all -> 0x00fc }
        r3 = r10[r1];	 Catch:{ all -> 0x00fc }
        r10 = r9.f19848b;	 Catch:{ all -> 0x00fc }
        r5 = r10.mo5289f(r2);	 Catch:{ all -> 0x00fc }
        r10 = r0.f19834b;	 Catch:{ all -> 0x00fc }
        r10[r1] = r5;	 Catch:{ all -> 0x00fc }
        r7 = r9.f19864s;	 Catch:{ all -> 0x00fc }
        r10 = 0;
        r7 = r7 - r3;
        r7 = r7 + r5;
        r9.f19864s = r7;	 Catch:{ all -> 0x00fc }
        goto L_0x007d;
    L_0x0078:
        r2 = r9.f19848b;	 Catch:{ all -> 0x00fc }
        r2.mo5287d(r10);	 Catch:{ all -> 0x00fc }
    L_0x007d:
        r1 = r1 + 1;
        goto L_0x0047;
    L_0x0080:
        r10 = r9.f19853g;	 Catch:{ all -> 0x00fc }
        r1 = 1;
        r10 = r10 + r1;
        r9.f19853g = r10;	 Catch:{ all -> 0x00fc }
        r10 = 0;
        r0.f19838f = r10;	 Catch:{ all -> 0x00fc }
        r10 = r0.f19837e;	 Catch:{ all -> 0x00fc }
        r10 = r10 | r11;
        r2 = 10;
        r3 = 32;
        if (r10 == 0) goto L_0x00bc;
    L_0x0092:
        r0.f19837e = r1;	 Catch:{ all -> 0x00fc }
        r10 = r9.f19851e;	 Catch:{ all -> 0x00fc }
        r1 = "CLEAN";
        r10 = r10.mo6373b(r1);	 Catch:{ all -> 0x00fc }
        r10.mo6389i(r3);	 Catch:{ all -> 0x00fc }
        r10 = r9.f19851e;	 Catch:{ all -> 0x00fc }
        r1 = r0.f19833a;	 Catch:{ all -> 0x00fc }
        r10.mo6373b(r1);	 Catch:{ all -> 0x00fc }
        r10 = r9.f19851e;	 Catch:{ all -> 0x00fc }
        r0.m25190a(r10);	 Catch:{ all -> 0x00fc }
        r10 = r9.f19851e;	 Catch:{ all -> 0x00fc }
        r10.mo6389i(r2);	 Catch:{ all -> 0x00fc }
        if (r11 == 0) goto L_0x00da;
    L_0x00b2:
        r10 = r9.f19865t;	 Catch:{ all -> 0x00fc }
        r1 = 1;
        r1 = r1 + r10;
        r9.f19865t = r1;	 Catch:{ all -> 0x00fc }
        r0.f19839g = r10;	 Catch:{ all -> 0x00fc }
        goto L_0x00da;
    L_0x00bc:
        r10 = r9.f19852f;	 Catch:{ all -> 0x00fc }
        r11 = r0.f19833a;	 Catch:{ all -> 0x00fc }
        r10.remove(r11);	 Catch:{ all -> 0x00fc }
        r10 = r9.f19851e;	 Catch:{ all -> 0x00fc }
        r11 = "REMOVE";
        r10 = r10.mo6373b(r11);	 Catch:{ all -> 0x00fc }
        r10.mo6389i(r3);	 Catch:{ all -> 0x00fc }
        r10 = r9.f19851e;	 Catch:{ all -> 0x00fc }
        r11 = r0.f19833a;	 Catch:{ all -> 0x00fc }
        r10.mo6373b(r11);	 Catch:{ all -> 0x00fc }
        r10 = r9.f19851e;	 Catch:{ all -> 0x00fc }
        r10.mo6389i(r2);	 Catch:{ all -> 0x00fc }
    L_0x00da:
        r10 = r9.f19851e;	 Catch:{ all -> 0x00fc }
        r10.flush();	 Catch:{ all -> 0x00fc }
        r10 = r9.f19864s;	 Catch:{ all -> 0x00fc }
        r0 = r9.f19863r;	 Catch:{ all -> 0x00fc }
        r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1));
        if (r10 > 0) goto L_0x00ed;
    L_0x00e7:
        r10 = r9.m25208c();	 Catch:{ all -> 0x00fc }
        if (r10 == 0) goto L_0x00f4;
    L_0x00ed:
        r10 = r9.f19866u;	 Catch:{ all -> 0x00fc }
        r11 = r9.f19867v;	 Catch:{ all -> 0x00fc }
        r10.execute(r11);	 Catch:{ all -> 0x00fc }
    L_0x00f4:
        monitor-exit(r9);
        return;
    L_0x00f6:
        r10 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x00fc }
        r10.<init>();	 Catch:{ all -> 0x00fc }
        throw r10;	 Catch:{ all -> 0x00fc }
    L_0x00fc:
        r10 = move-exception;
        monitor-exit(r9);
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.a.d.a(expolib_v1.a.a.a.d$a, boolean):void");
    }

    /* renamed from: c */
    boolean m25208c() {
        return this.f19853g >= AdError.SERVER_ERROR_CODE && this.f19853g >= this.f19852f.size();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    public synchronized boolean m25209c(java.lang.String r6) {
        /*
        r5 = this;
        monitor-enter(r5);
        r5.m25203a();	 Catch:{ all -> 0x0029 }
        r5.m25200j();	 Catch:{ all -> 0x0029 }
        r5.m25196e(r6);	 Catch:{ all -> 0x0029 }
        r0 = r5.f19852f;	 Catch:{ all -> 0x0029 }
        r6 = r0.get(r6);	 Catch:{ all -> 0x0029 }
        r6 = (expolib_v1.p321a.p322a.p323a.C6146d.C6144b) r6;	 Catch:{ all -> 0x0029 }
        r0 = 0;
        if (r6 != 0) goto L_0x0017;
    L_0x0015:
        monitor-exit(r5);
        return r0;
    L_0x0017:
        r6 = r5.m25205a(r6);	 Catch:{ all -> 0x0029 }
        if (r6 == 0) goto L_0x0027;
    L_0x001d:
        r1 = r5.f19864s;	 Catch:{ all -> 0x0029 }
        r3 = r5.f19863r;	 Catch:{ all -> 0x0029 }
        r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r1 > 0) goto L_0x0027;
    L_0x0025:
        r5.f19857k = r0;	 Catch:{ all -> 0x0029 }
    L_0x0027:
        monitor-exit(r5);
        return r6;
    L_0x0029:
        r6 = move-exception;
        monitor-exit(r5);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.a.d.c(java.lang.String):boolean");
    }

    /* renamed from: a */
    boolean m25205a(C6144b c6144b) {
        if (c6144b.f19838f != null) {
            c6144b.f19838f.m25185a();
        }
        for (int i = 0; i < this.f19850d; i++) {
            this.f19848b.mo5287d(c6144b.f19835c[i]);
            this.f19864s -= c6144b.f19834b[i];
            c6144b.f19834b[i] = 0;
        }
        this.f19853g++;
        this.f19851e.mo6373b("REMOVE").mo6389i(32).mo6373b(c6144b.f19833a).mo6389i(10);
        this.f19852f.remove(c6144b.f19833a);
        if (m25208c() != null) {
            this.f19866u.execute(this.f19867v);
        }
        return true;
    }

    /* renamed from: d */
    public synchronized boolean m25210d() {
        return this.f19856j;
    }

    /* renamed from: j */
    private synchronized void m25200j() {
        if (m25210d()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void flush() {
        if (this.f19855i) {
            m25200j();
            m25211e();
            this.f19851e.flush();
        }
    }

    public synchronized void close() {
        if (this.f19855i) {
            if (!this.f19856j) {
                for (C6144b c6144b : (C6144b[]) this.f19852f.values().toArray(new C6144b[this.f19852f.size()])) {
                    if (c6144b.f19838f != null) {
                        c6144b.f19838f.m25187c();
                    }
                }
                m25211e();
                this.f19851e.close();
                this.f19851e = null;
                this.f19856j = true;
                return;
            }
        }
        this.f19856j = true;
    }

    /* renamed from: e */
    void m25211e() {
        while (this.f19864s > this.f19863r) {
            m25205a((C6144b) this.f19852f.values().iterator().next());
        }
        this.f19857k = false;
    }

    /* renamed from: f */
    public void m25212f() {
        close();
        this.f19848b.mo5290g(this.f19849c);
    }

    /* renamed from: e */
    private void m25196e(String str) {
        if (!f19846a.matcher(str).matches()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("keys must match regex [a-z0-9_-]{1,120}: \"");
            stringBuilder.append(str);
            stringBuilder.append("\"");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }
}
