package expolib_v1.p321a.p322a.p331i;

import expolib_v1.p321a.C6216e;
import expolib_v1.p321a.C6217f;
import expolib_v1.p321a.C6244x;
import expolib_v1.p321a.C6246z;
import expolib_v1.p321a.C7490w;
import expolib_v1.p321a.ab;
import expolib_v1.p321a.af;
import expolib_v1.p321a.ag;
import expolib_v1.p321a.p322a.C6148a;
import expolib_v1.p321a.p322a.C6165c;
import expolib_v1.p321a.p322a.p324b.C6154g;
import expolib_v1.p321a.p322a.p331i.C6205c.C6204a;
import expolib_v1.p332b.C6251f;
import expolib_v1.p332b.C7496d;
import expolib_v1.p332b.C7497e;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: RealWebSocket */
/* renamed from: expolib_v1.a.a.i.a */
public final class C7475a implements C6204a, af {
    /* renamed from: d */
    static final /* synthetic */ boolean f25930d = (C7475a.class.desiredAssertionStatus() ^ 1);
    /* renamed from: e */
    private static final List<C6244x> f25931e = Collections.singletonList(C6244x.HTTP_1_1);
    /* renamed from: a */
    final ag f25932a;
    /* renamed from: b */
    int f25933b;
    /* renamed from: c */
    int f25934c;
    /* renamed from: f */
    private final C6246z f25935f;
    /* renamed from: g */
    private final Random f25936g;
    /* renamed from: h */
    private final String f25937h;
    /* renamed from: i */
    private C6216e f25938i;
    /* renamed from: j */
    private final Runnable f25939j;
    /* renamed from: k */
    private C6205c f25940k;
    /* renamed from: l */
    private C6206d f25941l;
    /* renamed from: m */
    private ScheduledExecutorService f25942m;
    /* renamed from: n */
    private C6202e f25943n;
    /* renamed from: o */
    private final ArrayDeque<C6251f> f25944o = new ArrayDeque();
    /* renamed from: p */
    private final ArrayDeque<Object> f25945p = new ArrayDeque();
    /* renamed from: q */
    private long f25946q;
    /* renamed from: r */
    private boolean f25947r;
    /* renamed from: s */
    private ScheduledFuture<?> f25948s;
    /* renamed from: t */
    private int f25949t = -1;
    /* renamed from: u */
    private String f25950u;
    /* renamed from: v */
    private boolean f25951v;

    /* compiled from: RealWebSocket */
    /* renamed from: expolib_v1.a.a.i.a$1 */
    class C61971 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C7475a f20053a;

        C61971(C7475a c7475a) {
            this.f20053a = c7475a;
        }

        public void run() {
            while (this.f20053a.m33940c()) {
                try {
                } catch (Exception e) {
                    this.f20053a.m33929a(e, null);
                    return;
                }
            }
        }
    }

    /* compiled from: RealWebSocket */
    /* renamed from: expolib_v1.a.a.i.a$a */
    final class C6198a implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C7475a f20054a;

        C6198a(C7475a c7475a) {
            this.f20054a = c7475a;
        }

        public void run() {
            this.f20054a.m33926a();
        }
    }

    /* compiled from: RealWebSocket */
    /* renamed from: expolib_v1.a.a.i.a$b */
    static final class C6199b {
        /* renamed from: a */
        final int f20055a;
        /* renamed from: b */
        final C6251f f20056b;
        /* renamed from: c */
        final long f20057c;

        C6199b(int i, C6251f c6251f, long j) {
            this.f20055a = i;
            this.f20056b = c6251f;
            this.f20057c = j;
        }
    }

    /* compiled from: RealWebSocket */
    /* renamed from: expolib_v1.a.a.i.a$c */
    static final class C6200c {
        /* renamed from: a */
        final int f20058a;
        /* renamed from: b */
        final C6251f f20059b;

        C6200c(int i, C6251f c6251f) {
            this.f20058a = i;
            this.f20059b = c6251f;
        }
    }

    /* compiled from: RealWebSocket */
    /* renamed from: expolib_v1.a.a.i.a$d */
    private final class C6201d implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C7475a f20060a;

        C6201d(C7475a c7475a) {
            this.f20060a = c7475a;
        }

        public void run() {
            this.f20060a.m33941d();
        }
    }

    /* compiled from: RealWebSocket */
    /* renamed from: expolib_v1.a.a.i.a$e */
    public static abstract class C6202e implements Closeable {
        /* renamed from: c */
        public final boolean f20061c;
        /* renamed from: d */
        public final C7497e f20062d;
        /* renamed from: e */
        public final C7496d f20063e;

        public C6202e(boolean z, C7497e c7497e, C7496d c7496d) {
            this.f20061c = z;
            this.f20062d = c7497e;
            this.f20063e = c7496d;
        }
    }

    public C7475a(C6246z c6246z, ag agVar, Random random) {
        if ("GET".equals(c6246z.m25823b())) {
            this.f25935f = c6246z;
            this.f25932a = agVar;
            this.f25936g = random;
            byte[] bArr = new byte[16];
            random.nextBytes(bArr);
            this.f25937h = C6251f.m25838a(bArr).mo5359b();
            this.f25939j = new C61971(this);
            return;
        }
        random = new StringBuilder();
        random.append("Request must be GET: ");
        random.append(c6246z.m25823b());
        throw new IllegalArgumentException(random.toString());
    }

    /* renamed from: a */
    public void m33926a() {
        this.f25938i.mo5343c();
    }

    /* renamed from: a */
    public void m33928a(C7490w c7490w) {
        c7490w = c7490w.m33995y().m25796a(f25931e).m25800a();
        final int d = c7490w.m33974d();
        final C6246z b = this.f25935f.m25828f().m25816a("Upgrade", "websocket").m25816a("Connection", "Upgrade").m25816a("Sec-WebSocket-Key", this.f25937h).m25816a("Sec-WebSocket-Version", "13").m25820b();
        this.f25938i = C6148a.f19868a.mo5332a(c7490w, b);
        this.f25938i.mo5341a(new C6217f(this) {
            /* renamed from: c */
            final /* synthetic */ C7475a f25929c;

            public void onResponse(C6216e c6216e, ab abVar) {
                try {
                    this.f25929c.m33927a(abVar);
                    C6154g a = C6148a.f19868a.mo5331a(c6216e);
                    a.m25264d();
                    C6202e a2 = a.m25261b().m33805a(a);
                    try {
                        this.f25929c.f25932a.onOpen(this.f25929c, abVar);
                        abVar = new StringBuilder();
                        abVar.append("OkHttp WebSocket ");
                        abVar.append(b.m25821a().m25777n());
                        this.f25929c.m33930a(abVar.toString(), (long) d, a2);
                        a.m25261b().m33813c().setSoTimeout(null);
                        this.f25929c.m33935b();
                    } catch (Exception e) {
                        this.f25929c.m33929a(e, null);
                    }
                } catch (Exception e2) {
                    this.f25929c.m33929a(e2, abVar);
                    C6165c.m25315a((Closeable) abVar);
                }
            }

            public void onFailure(C6216e c6216e, IOException iOException) {
                this.f25929c.m33929a((Exception) iOException, null);
            }
        });
    }

    /* renamed from: a */
    void m33927a(ab abVar) {
        StringBuilder stringBuilder;
        if (abVar.m25580c() == 101) {
            String a = abVar.m25577a("Connection");
            if ("Upgrade".equalsIgnoreCase(a)) {
                a = abVar.m25577a("Upgrade");
                if ("websocket".equalsIgnoreCase(a)) {
                    abVar = abVar.m25577a("Sec-WebSocket-Accept");
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(this.f25937h);
                    stringBuilder2.append("258EAFA5-E914-47DA-95CA-C5AB0DC85B11");
                    a = C6251f.m25837a(stringBuilder2.toString()).mo5361d().mo5359b();
                    if (!a.equals(abVar)) {
                        StringBuilder stringBuilder3 = new StringBuilder();
                        stringBuilder3.append("Expected 'Sec-WebSocket-Accept' header value '");
                        stringBuilder3.append(a);
                        stringBuilder3.append("' but was '");
                        stringBuilder3.append(abVar);
                        stringBuilder3.append("'");
                        throw new ProtocolException(stringBuilder3.toString());
                    }
                    return;
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("Expected 'Upgrade' header value 'websocket' but was '");
                stringBuilder.append(a);
                stringBuilder.append("'");
                throw new ProtocolException(stringBuilder.toString());
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("Expected 'Connection' header value 'Upgrade' but was '");
            stringBuilder.append(a);
            stringBuilder.append("'");
            throw new ProtocolException(stringBuilder.toString());
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Expected HTTP 101 response but was '");
        stringBuilder.append(abVar.m25580c());
        stringBuilder.append(" ");
        stringBuilder.append(abVar.m25582e());
        stringBuilder.append("'");
        throw new ProtocolException(stringBuilder.toString());
    }

    /* renamed from: a */
    public void m33930a(String str, long j, C6202e c6202e) {
        synchronized (this) {
            this.f25943n = c6202e;
            this.f25941l = new C6206d(c6202e.f20061c, c6202e.f20063e, this.f25936g);
            this.f25942m = new ScheduledThreadPoolExecutor(1, C6165c.m25313a(str, false));
            if (j != 0) {
                this.f25942m.scheduleAtFixedRate(new C6201d(this), j, j, TimeUnit.MILLISECONDS);
            }
            if (this.f25945p.isEmpty() == null) {
                m33925e();
            }
        }
        this.f25940k = new C6205c(c6202e.f20061c, c6202e.f20062d, this);
    }

    /* renamed from: b */
    public void m33935b() {
        while (this.f25949t == -1) {
            this.f25940k.m25539a();
        }
    }

    /* renamed from: b */
    public void mo5310b(String str) {
        this.f25932a.onMessage((af) this, str);
    }

    /* renamed from: b */
    public void mo5309b(C6251f c6251f) {
        this.f25932a.onMessage((af) this, c6251f);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    public synchronized void mo5311c(expolib_v1.p332b.C6251f r2) {
        /*
        r1 = this;
        monitor-enter(r1);
        r0 = r1.f25951v;	 Catch:{ all -> 0x0024 }
        if (r0 != 0) goto L_0x0022;
    L_0x0005:
        r0 = r1.f25947r;	 Catch:{ all -> 0x0024 }
        if (r0 == 0) goto L_0x0012;
    L_0x0009:
        r0 = r1.f25945p;	 Catch:{ all -> 0x0024 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0024 }
        if (r0 == 0) goto L_0x0012;
    L_0x0011:
        goto L_0x0022;
    L_0x0012:
        r0 = r1.f25944o;	 Catch:{ all -> 0x0024 }
        r0.add(r2);	 Catch:{ all -> 0x0024 }
        r1.m33925e();	 Catch:{ all -> 0x0024 }
        r2 = r1.f25933b;	 Catch:{ all -> 0x0024 }
        r2 = r2 + 1;
        r1.f25933b = r2;	 Catch:{ all -> 0x0024 }
        monitor-exit(r1);
        return;
    L_0x0022:
        monitor-exit(r1);
        return;
    L_0x0024:
        r2 = move-exception;
        monitor-exit(r1);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.i.a.c(expolib_v1.b.f):void");
    }

    /* renamed from: d */
    public synchronized void mo5312d(C6251f c6251f) {
        this.f25934c++;
    }

    /* renamed from: b */
    public void mo5308b(int i, String str) {
        if (i != -1) {
            Closeable closeable;
            synchronized (this) {
                if (this.f25949t == -1) {
                    this.f25949t = i;
                    this.f25950u = str;
                    if (this.f25947r && this.f25945p.isEmpty()) {
                        closeable = this.f25943n;
                        this.f25943n = null;
                        if (this.f25948s != null) {
                            this.f25948s.cancel(false);
                        }
                        this.f25942m.shutdown();
                    } else {
                        closeable = null;
                    }
                } else {
                    throw new IllegalStateException("already closed");
                }
            }
            try {
                this.f25932a.onClosing(this, i, str);
                if (closeable != null) {
                    this.f25932a.onClosed(this, i, str);
                }
                C6165c.m25315a(closeable);
            } catch (Throwable th) {
                C6165c.m25315a(closeable);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: a */
    public boolean mo5307a(String str) {
        if (str != null) {
            return m33924a(C6251f.m25837a(str), 1);
        }
        throw new NullPointerException("text == null");
    }

    /* renamed from: a */
    public boolean mo5306a(C6251f c6251f) {
        if (c6251f != null) {
            return m33924a(c6251f, 2);
        }
        throw new NullPointerException("bytes == null");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private synchronized boolean m33924a(expolib_v1.p332b.C6251f r7, int r8) {
        /*
        r6 = this;
        monitor-enter(r6);
        r0 = r6.f25951v;	 Catch:{ all -> 0x003e }
        r1 = 0;
        if (r0 != 0) goto L_0x003c;
    L_0x0006:
        r0 = r6.f25947r;	 Catch:{ all -> 0x003e }
        if (r0 == 0) goto L_0x000b;
    L_0x000a:
        goto L_0x003c;
    L_0x000b:
        r2 = r6.f25946q;	 Catch:{ all -> 0x003e }
        r0 = r7.mo5366h();	 Catch:{ all -> 0x003e }
        r4 = (long) r0;	 Catch:{ all -> 0x003e }
        r2 = r2 + r4;
        r4 = 16777216; // 0x1000000 float:2.3509887E-38 double:8.289046E-317;
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 <= 0) goto L_0x0022;
    L_0x001a:
        r7 = 1001; // 0x3e9 float:1.403E-42 double:4.946E-321;
        r8 = 0;
        r6.mo5305a(r7, r8);	 Catch:{ all -> 0x003e }
        monitor-exit(r6);
        return r1;
    L_0x0022:
        r0 = r6.f25946q;	 Catch:{ all -> 0x003e }
        r2 = r7.mo5366h();	 Catch:{ all -> 0x003e }
        r2 = (long) r2;	 Catch:{ all -> 0x003e }
        r0 = r0 + r2;
        r6.f25946q = r0;	 Catch:{ all -> 0x003e }
        r0 = r6.f25945p;	 Catch:{ all -> 0x003e }
        r1 = new expolib_v1.a.a.i.a$c;	 Catch:{ all -> 0x003e }
        r1.<init>(r8, r7);	 Catch:{ all -> 0x003e }
        r0.add(r1);	 Catch:{ all -> 0x003e }
        r6.m33925e();	 Catch:{ all -> 0x003e }
        r7 = 1;
        monitor-exit(r6);
        return r7;
    L_0x003c:
        monitor-exit(r6);
        return r1;
    L_0x003e:
        r7 = move-exception;
        monitor-exit(r6);
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.i.a.a(expolib_v1.b.f, int):boolean");
    }

    /* renamed from: a */
    public boolean mo5305a(int i, String str) {
        return m33932a(i, str, 60000);
    }

    /* renamed from: a */
    synchronized boolean m33932a(int i, String str, long j) {
        C6203b.m25529b(i);
        C6251f c6251f = null;
        if (str != null) {
            c6251f = C6251f.m25837a(str);
            if (((long) c6251f.mo5366h()) > 123) {
                j = new StringBuilder();
                j.append("reason.size() > 123: ");
                j.append(str);
                throw new IllegalArgumentException(j.toString());
            }
        }
        if (this.f25951v == null) {
            if (this.f25947r == null) {
                this.f25947r = true;
                this.f25945p.add(new C6199b(i, c6251f, j));
                m33925e();
                return true;
            }
        }
        return false;
    }

    /* renamed from: e */
    private void m33925e() {
        if (!f25930d) {
            if (!Thread.holdsLock(this)) {
                throw new AssertionError();
            }
        }
        if (this.f25942m != null) {
            this.f25942m.execute(this.f25939j);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    boolean m33940c() {
        /*
        r11 = this;
        monitor-enter(r11);
        r0 = r11.f25951v;	 Catch:{ all -> 0x00ab }
        r1 = 0;
        if (r0 == 0) goto L_0x0008;
    L_0x0006:
        monitor-exit(r11);	 Catch:{ all -> 0x00ab }
        return r1;
    L_0x0008:
        r0 = r11.f25941l;	 Catch:{ all -> 0x00ab }
        r2 = r11.f25944o;	 Catch:{ all -> 0x00ab }
        r2 = r2.poll();	 Catch:{ all -> 0x00ab }
        r2 = (expolib_v1.p332b.C6251f) r2;	 Catch:{ all -> 0x00ab }
        r3 = -1;
        r4 = 0;
        if (r2 != 0) goto L_0x004c;
    L_0x0016:
        r5 = r11.f25945p;	 Catch:{ all -> 0x00ab }
        r5 = r5.poll();	 Catch:{ all -> 0x00ab }
        r6 = r5 instanceof expolib_v1.p321a.p322a.p331i.C7475a.C6199b;	 Catch:{ all -> 0x00ab }
        if (r6 == 0) goto L_0x0046;
    L_0x0020:
        r1 = r11.f25949t;	 Catch:{ all -> 0x00ab }
        r6 = r11.f25950u;	 Catch:{ all -> 0x00ab }
        if (r1 == r3) goto L_0x0031;
    L_0x0026:
        r3 = r11.f25943n;	 Catch:{ all -> 0x00ab }
        r11.f25943n = r4;	 Catch:{ all -> 0x00ab }
        r4 = r11.f25942m;	 Catch:{ all -> 0x00ab }
        r4.shutdown();	 Catch:{ all -> 0x00ab }
        r4 = r3;
        goto L_0x004f;
    L_0x0031:
        r3 = r11.f25942m;	 Catch:{ all -> 0x00ab }
        r7 = new expolib_v1.a.a.i.a$a;	 Catch:{ all -> 0x00ab }
        r7.<init>(r11);	 Catch:{ all -> 0x00ab }
        r8 = r5;
        r8 = (expolib_v1.p321a.p322a.p331i.C7475a.C6199b) r8;	 Catch:{ all -> 0x00ab }
        r8 = r8.f20057c;	 Catch:{ all -> 0x00ab }
        r10 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ all -> 0x00ab }
        r3 = r3.schedule(r7, r8, r10);	 Catch:{ all -> 0x00ab }
        r11.f25948s = r3;	 Catch:{ all -> 0x00ab }
        goto L_0x004f;
    L_0x0046:
        if (r5 != 0) goto L_0x004a;
    L_0x0048:
        monitor-exit(r11);	 Catch:{ all -> 0x00ab }
        return r1;
    L_0x004a:
        r6 = r4;
        goto L_0x004e;
    L_0x004c:
        r5 = r4;
        r6 = r5;
    L_0x004e:
        r1 = -1;
    L_0x004f:
        monitor-exit(r11);	 Catch:{ all -> 0x00ab }
        if (r2 == 0) goto L_0x0058;
    L_0x0052:
        r0.m25546b(r2);	 Catch:{ all -> 0x0056 }
        goto L_0x009c;
    L_0x0056:
        r0 = move-exception;
        goto L_0x00a7;
    L_0x0058:
        r2 = r5 instanceof expolib_v1.p321a.p322a.p331i.C7475a.C6200c;	 Catch:{ all -> 0x0056 }
        if (r2 == 0) goto L_0x0088;
    L_0x005c:
        r1 = r5;
        r1 = (expolib_v1.p321a.p322a.p331i.C7475a.C6200c) r1;	 Catch:{ all -> 0x0056 }
        r1 = r1.f20059b;	 Catch:{ all -> 0x0056 }
        r5 = (expolib_v1.p321a.p322a.p331i.C7475a.C6200c) r5;	 Catch:{ all -> 0x0056 }
        r2 = r5.f20058a;	 Catch:{ all -> 0x0056 }
        r3 = r1.mo5366h();	 Catch:{ all -> 0x0056 }
        r5 = (long) r3;	 Catch:{ all -> 0x0056 }
        r0 = r0.m25542a(r2, r5);	 Catch:{ all -> 0x0056 }
        r0 = expolib_v1.p332b.C6252l.m25858a(r0);	 Catch:{ all -> 0x0056 }
        r0.mo6376c(r1);	 Catch:{ all -> 0x0056 }
        r0.close();	 Catch:{ all -> 0x0056 }
        monitor-enter(r11);	 Catch:{ all -> 0x0056 }
        r2 = r11.f25946q;	 Catch:{ all -> 0x0085 }
        r0 = r1.mo5366h();	 Catch:{ all -> 0x0085 }
        r0 = (long) r0;	 Catch:{ all -> 0x0085 }
        r2 = r2 - r0;
        r11.f25946q = r2;	 Catch:{ all -> 0x0085 }
        monitor-exit(r11);	 Catch:{ all -> 0x0085 }
        goto L_0x009c;
    L_0x0085:
        r0 = move-exception;
        monitor-exit(r11);	 Catch:{ all -> 0x0085 }
        throw r0;	 Catch:{ all -> 0x0056 }
    L_0x0088:
        r2 = r5 instanceof expolib_v1.p321a.p322a.p331i.C7475a.C6199b;	 Catch:{ all -> 0x0056 }
        if (r2 == 0) goto L_0x00a1;
    L_0x008c:
        r5 = (expolib_v1.p321a.p322a.p331i.C7475a.C6199b) r5;	 Catch:{ all -> 0x0056 }
        r2 = r5.f20055a;	 Catch:{ all -> 0x0056 }
        r3 = r5.f20056b;	 Catch:{ all -> 0x0056 }
        r0.m25544a(r2, r3);	 Catch:{ all -> 0x0056 }
        if (r4 == 0) goto L_0x009c;
    L_0x0097:
        r0 = r11.f25932a;	 Catch:{ all -> 0x0056 }
        r0.onClosed(r11, r1, r6);	 Catch:{ all -> 0x0056 }
    L_0x009c:
        r0 = 1;
        expolib_v1.p321a.p322a.C6165c.m25315a(r4);
        return r0;
    L_0x00a1:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x0056 }
        r0.<init>();	 Catch:{ all -> 0x0056 }
        throw r0;	 Catch:{ all -> 0x0056 }
    L_0x00a7:
        expolib_v1.p321a.p322a.C6165c.m25315a(r4);
        throw r0;
    L_0x00ab:
        r0 = move-exception;
        monitor-exit(r11);	 Catch:{ all -> 0x00ab }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.i.a.c():boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: d */
    void m33941d() {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.f25951v;	 Catch:{ all -> 0x0016 }
        if (r0 == 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r2);	 Catch:{ all -> 0x0016 }
        return;
    L_0x0007:
        r0 = r2.f25941l;	 Catch:{ all -> 0x0016 }
        monitor-exit(r2);	 Catch:{ all -> 0x0016 }
        r1 = expolib_v1.p332b.C6251f.f20378b;	 Catch:{ IOException -> 0x0010 }
        r0.m25545a(r1);	 Catch:{ IOException -> 0x0010 }
        goto L_0x0015;
    L_0x0010:
        r0 = move-exception;
        r1 = 0;
        r2.m33929a(r0, r1);
    L_0x0015:
        return;
    L_0x0016:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0016 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.i.a.d():void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void m33929a(java.lang.Exception r4, expolib_v1.p321a.ab r5) {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r3.f25951v;	 Catch:{ all -> 0x0031 }
        if (r0 == 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r3);	 Catch:{ all -> 0x0031 }
        return;
    L_0x0007:
        r0 = 1;
        r3.f25951v = r0;	 Catch:{ all -> 0x0031 }
        r0 = r3.f25943n;	 Catch:{ all -> 0x0031 }
        r1 = 0;
        r3.f25943n = r1;	 Catch:{ all -> 0x0031 }
        r1 = r3.f25948s;	 Catch:{ all -> 0x0031 }
        if (r1 == 0) goto L_0x0019;
    L_0x0013:
        r1 = r3.f25948s;	 Catch:{ all -> 0x0031 }
        r2 = 0;
        r1.cancel(r2);	 Catch:{ all -> 0x0031 }
    L_0x0019:
        r1 = r3.f25942m;	 Catch:{ all -> 0x0031 }
        if (r1 == 0) goto L_0x0022;
    L_0x001d:
        r1 = r3.f25942m;	 Catch:{ all -> 0x0031 }
        r1.shutdown();	 Catch:{ all -> 0x0031 }
    L_0x0022:
        monitor-exit(r3);	 Catch:{ all -> 0x0031 }
        r1 = r3.f25932a;	 Catch:{ all -> 0x002c }
        r1.onFailure(r3, r4, r5);	 Catch:{ all -> 0x002c }
        expolib_v1.p321a.p322a.C6165c.m25315a(r0);
        return;
    L_0x002c:
        r4 = move-exception;
        expolib_v1.p321a.p322a.C6165c.m25315a(r0);
        throw r4;
    L_0x0031:
        r4 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0031 }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.i.a.a(java.lang.Exception, expolib_v1.a.ab):void");
    }
}
