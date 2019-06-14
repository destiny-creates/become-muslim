package com.facebook.ads.internal.p101p.p103b;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import com.facebook.ads.internal.p101p.p103b.p104a.C1455a;
import com.facebook.ads.internal.p101p.p103b.p104a.C1456c;
import com.facebook.ads.internal.p101p.p103b.p104a.C3603f;
import com.facebook.ads.internal.p101p.p103b.p104a.C4569g;
import com.facebook.internal.Utility;
import java.io.File;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* renamed from: com.facebook.ads.internal.p.b.f */
public class C1471f {
    /* renamed from: a */
    private final Object f4331a;
    /* renamed from: b */
    private final ExecutorService f4332b;
    /* renamed from: c */
    private final Map<String, C1472g> f4333c;
    /* renamed from: d */
    private final ServerSocket f4334d;
    /* renamed from: e */
    private final int f4335e;
    /* renamed from: f */
    private final Thread f4336f;
    /* renamed from: g */
    private final C1463c f4337g;
    /* renamed from: h */
    private boolean f4338h;

    /* renamed from: com.facebook.ads.internal.p.b.f$a */
    public static final class C1466a {
        /* renamed from: a */
        private File f4321a;
        /* renamed from: b */
        private C1456c f4322b = new C3603f();
        /* renamed from: c */
        private C1455a f4323c = new C4569g(67108864);

        public C1466a(Context context) {
            this.f4321a = C1480o.m5238a(context);
        }

        /* renamed from: a */
        private C1463c m5178a() {
            return new C1463c(this.f4321a, this.f4322b, this.f4323c);
        }
    }

    /* renamed from: com.facebook.ads.internal.p.b.f$b */
    private class C1467b implements Callable<Boolean> {
        /* renamed from: a */
        final /* synthetic */ C1471f f4324a;

        private C1467b(C1471f c1471f) {
            this.f4324a = c1471f;
        }

        /* renamed from: a */
        public Boolean m5180a() {
            return Boolean.valueOf(this.f4324a.m5191c());
        }

        public /* synthetic */ Object call() {
            return m5180a();
        }
    }

    /* renamed from: com.facebook.ads.internal.p.b.f$c */
    private class C1468c implements Callable<Boolean> {
        /* renamed from: a */
        final /* synthetic */ C1471f f4325a;
        /* renamed from: b */
        private final String f4326b;

        public C1468c(C1471f c1471f, String str) {
            this.f4325a = c1471f;
            this.f4326b = str;
        }

        /* renamed from: a */
        public Boolean m5181a() {
            return Boolean.valueOf(this.f4325a.m5192c(this.f4326b));
        }

        public /* synthetic */ Object call() {
            return m5181a();
        }
    }

    /* renamed from: com.facebook.ads.internal.p.b.f$d */
    private final class C1469d implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C1471f f4327a;
        /* renamed from: b */
        private final Socket f4328b;

        public C1469d(C1471f c1471f, Socket socket) {
            this.f4327a = c1471f;
            this.f4328b = socket;
        }

        public void run() {
            this.f4327a.m5185a(this.f4328b);
        }
    }

    /* renamed from: com.facebook.ads.internal.p.b.f$e */
    private final class C1470e implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C1471f f4329a;
        /* renamed from: b */
        private final CountDownLatch f4330b;

        public C1470e(C1471f c1471f, CountDownLatch countDownLatch) {
            this.f4329a = c1471f;
            this.f4330b = countDownLatch;
        }

        public void run() {
            this.f4330b.countDown();
            this.f4329a.m5197e();
        }
    }

    public C1471f(Context context) {
        this(new C1466a(context).m5178a());
    }

    private C1471f(C1463c c1463c) {
        this.f4331a = new Object();
        this.f4332b = Executors.newFixedThreadPool(8);
        this.f4333c = new ConcurrentHashMap();
        this.f4337g = (C1463c) C1473j.m5210a(c1463c);
        try {
            this.f4334d = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            this.f4335e = this.f4334d.getLocalPort();
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.f4336f = new Thread(new C1470e(this, countDownLatch));
            this.f4336f.start();
            countDownLatch.await();
            Log.i("ProxyCache", "Proxy cache server started. Ping it...");
            m5187b();
        } catch (Throwable e) {
            this.f4332b.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e);
        }
    }

    /* renamed from: a */
    private void m5184a(Throwable th) {
        Log.e("ProxyCache", "HttpProxyCacheServer error", th);
    }

    /* renamed from: a */
    private void m5185a(java.net.Socket r5) {
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
        r4 = this;
        r0 = r5.getInputStream();	 Catch:{ SocketException -> 0x005a, l -> 0x0044, l -> 0x0044 }
        r0 = com.facebook.ads.internal.p101p.p103b.C1464d.m5176a(r0);	 Catch:{ SocketException -> 0x005a, l -> 0x0044, l -> 0x0044 }
        r1 = "ProxyCache";	 Catch:{ SocketException -> 0x005a, l -> 0x0044, l -> 0x0044 }
        r2 = new java.lang.StringBuilder;	 Catch:{ SocketException -> 0x005a, l -> 0x0044, l -> 0x0044 }
        r2.<init>();	 Catch:{ SocketException -> 0x005a, l -> 0x0044, l -> 0x0044 }
        r3 = "Request to cache proxy:";	 Catch:{ SocketException -> 0x005a, l -> 0x0044, l -> 0x0044 }
        r2.append(r3);	 Catch:{ SocketException -> 0x005a, l -> 0x0044, l -> 0x0044 }
        r2.append(r0);	 Catch:{ SocketException -> 0x005a, l -> 0x0044, l -> 0x0044 }
        r2 = r2.toString();	 Catch:{ SocketException -> 0x005a, l -> 0x0044, l -> 0x0044 }
        android.util.Log.i(r1, r2);	 Catch:{ SocketException -> 0x005a, l -> 0x0044, l -> 0x0044 }
        r1 = r0.f4318a;	 Catch:{ SocketException -> 0x005a, l -> 0x0044, l -> 0x0044 }
        r1 = com.facebook.ads.internal.p101p.p103b.C1478m.m5232c(r1);	 Catch:{ SocketException -> 0x005a, l -> 0x0044, l -> 0x0044 }
        r2 = "ping";	 Catch:{ SocketException -> 0x005a, l -> 0x0044, l -> 0x0044 }
        r2 = r2.equals(r1);	 Catch:{ SocketException -> 0x005a, l -> 0x0044, l -> 0x0044 }
        if (r2 == 0) goto L_0x0030;	 Catch:{ SocketException -> 0x005a, l -> 0x0044, l -> 0x0044 }
    L_0x002c:
        r4.m5188b(r5);	 Catch:{ SocketException -> 0x005a, l -> 0x0044, l -> 0x0044 }
        goto L_0x0037;	 Catch:{ SocketException -> 0x005a, l -> 0x0044, l -> 0x0044 }
    L_0x0030:
        r1 = r4.m5196e(r1);	 Catch:{ SocketException -> 0x005a, l -> 0x0044, l -> 0x0044 }
        r1.m5208a(r0, r5);	 Catch:{ SocketException -> 0x005a, l -> 0x0044, l -> 0x0044 }
    L_0x0037:
        r4.m5190c(r5);
        r5 = "ProxyCache";
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        goto L_0x006b;
    L_0x0042:
        r0 = move-exception;
        goto L_0x007f;
    L_0x0044:
        r0 = move-exception;
        r1 = new com.facebook.ads.internal.p.b.l;	 Catch:{ all -> 0x0042 }
        r2 = "Error processing request";	 Catch:{ all -> 0x0042 }
        r1.<init>(r2, r0);	 Catch:{ all -> 0x0042 }
        r4.m5184a(r1);	 Catch:{ all -> 0x0042 }
        r4.m5190c(r5);
        r5 = "ProxyCache";
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        goto L_0x006b;
    L_0x005a:
        r0 = "ProxyCache";	 Catch:{ all -> 0x0042 }
        r1 = "Closing socket... Socket is closed by client.";	 Catch:{ all -> 0x0042 }
        android.util.Log.d(r0, r1);	 Catch:{ all -> 0x0042 }
        r4.m5190c(r5);
        r5 = "ProxyCache";
        r0 = new java.lang.StringBuilder;
        r0.<init>();
    L_0x006b:
        r1 = "Opened connections: ";
        r0.append(r1);
        r1 = r4.m5199f();
        r0.append(r1);
        r0 = r0.toString();
        android.util.Log.d(r5, r0);
        return;
    L_0x007f:
        r4.m5190c(r5);
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r1 = "Opened connections: ";
        r5.append(r1);
        r1 = r4.m5199f();
        r5.append(r1);
        r5 = r5.toString();
        r1 = "ProxyCache";
        android.util.Log.d(r1, r5);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.p.b.f.a(java.net.Socket):void");
    }

    /* renamed from: b */
    private void m5187b() {
        int i = 300;
        int i2 = 0;
        while (i2 < 3) {
            try {
                Future submit = this.f4332b.submit(new C1467b());
                long j = (long) i;
                this.f4338h = ((Boolean) submit.get(j, TimeUnit.MILLISECONDS)).booleanValue();
                if (!this.f4338h) {
                    SystemClock.sleep(j);
                    i2++;
                    i *= 2;
                } else {
                    return;
                }
            } catch (Throwable e) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Error pinging server [attempt: ");
                stringBuilder.append(i2);
                stringBuilder.append(", timeout: ");
                stringBuilder.append(i);
                stringBuilder.append("]. ");
                Log.e("ProxyCache", stringBuilder.toString(), e);
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Shutdown server... Error pinging server [attempts: ");
        stringBuilder2.append(i2);
        stringBuilder2.append(", max timeout: ");
        stringBuilder2.append(i / 2);
        stringBuilder2.append("].");
        Log.e("ProxyCache", stringBuilder2.toString());
        m5201a();
    }

    /* renamed from: b */
    private void m5188b(Socket socket) {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("HTTP/1.1 200 OK\n\n".getBytes());
        outputStream.write("ping ok".getBytes());
    }

    /* renamed from: c */
    private void m5190c(Socket socket) {
        m5195d(socket);
        m5198e(socket);
        m5200f(socket);
    }

    /* renamed from: c */
    private boolean m5191c() {
        C3606h c3606h = new C3606h(m5193d("ping"));
        boolean equals;
        try {
            byte[] bytes = "ping ok".getBytes();
            c3606h.mo994a(0);
            byte[] bArr = new byte[bytes.length];
            c3606h.mo993a(bArr);
            equals = Arrays.equals(bytes, bArr);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Ping response: `");
            stringBuilder.append(new String(bArr));
            stringBuilder.append("`, pinged? ");
            stringBuilder.append(equals);
            Log.d("ProxyCache", stringBuilder.toString());
            return equals;
        } catch (C1477l e) {
            equals = e;
            Log.e("ProxyCache", "Error reading ping response", equals);
            return false;
        } finally {
            c3606h.mo995b();
        }
    }

    /* renamed from: c */
    private boolean m5192c(String str) {
        C3606h c3606h = new C3606h(m5193d(str));
        try {
            c3606h.mo994a(0);
            while (c3606h.mo993a(new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE]) != -1) {
            }
            return true;
        } catch (Throwable e) {
            Log.e("ProxyCache", "Error reading url", e);
            return false;
        } finally {
            c3606h.mo995b();
        }
    }

    /* renamed from: d */
    private String m5193d(String str) {
        return String.format("http://%s:%d/%s", new Object[]{"127.0.0.1", Integer.valueOf(this.f4335e), C1478m.m5231b(str)});
    }

    /* renamed from: d */
    private void m5194d() {
        synchronized (this.f4331a) {
            for (C1472g a : this.f4333c.values()) {
                a.m5207a();
            }
            this.f4333c.clear();
        }
    }

    /* renamed from: d */
    private void m5195d(java.net.Socket r3) {
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
        r0 = r3.isInputShutdown();	 Catch:{ SocketException -> 0x0016, IOException -> 0x000a }
        if (r0 != 0) goto L_0x001d;	 Catch:{ SocketException -> 0x0016, IOException -> 0x000a }
    L_0x0006:
        r3.shutdownInput();	 Catch:{ SocketException -> 0x0016, IOException -> 0x000a }
        goto L_0x001d;
    L_0x000a:
        r3 = move-exception;
        r0 = new com.facebook.ads.internal.p.b.l;
        r1 = "Error closing socket input stream";
        r0.<init>(r1, r3);
        r2.m5184a(r0);
        goto L_0x001d;
    L_0x0016:
        r3 = "ProxyCache";
        r0 = "Releasing input stream... Socket is closed by client.";
        android.util.Log.d(r3, r0);
    L_0x001d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.p.b.f.d(java.net.Socket):void");
    }

    /* renamed from: e */
    private C1472g m5196e(String str) {
        C1472g c1472g;
        synchronized (this.f4331a) {
            c1472g = (C1472g) this.f4333c.get(str);
            if (c1472g == null) {
                c1472g = new C1472g(str, this.f4337g);
                this.f4333c.put(str, c1472g);
            }
        }
        return c1472g;
    }

    /* renamed from: e */
    private void m5197e() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket accept = this.f4334d.accept();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Accept new socket ");
                stringBuilder.append(accept);
                Log.d("ProxyCache", stringBuilder.toString());
                this.f4332b.submit(new C1469d(this, accept));
            } catch (Throwable e) {
                m5184a(new C1477l("Error during waiting connection", e));
                return;
            }
        }
    }

    /* renamed from: e */
    private void m5198e(Socket socket) {
        try {
            if (socket.isOutputShutdown()) {
                socket.shutdownOutput();
            }
        } catch (Throwable e) {
            m5184a(new C1477l("Error closing socket output stream", e));
        }
    }

    /* renamed from: f */
    private int m5199f() {
        int i;
        synchronized (this.f4331a) {
            i = 0;
            for (C1472g b : this.f4333c.values()) {
                i += b.m5209b();
            }
        }
        return i;
    }

    /* renamed from: f */
    private void m5200f(Socket socket) {
        try {
            if (!socket.isClosed()) {
                socket.close();
            }
        } catch (Throwable e) {
            m5184a(new C1477l("Error closing socket", e));
        }
    }

    /* renamed from: a */
    public void m5201a() {
        Log.i("ProxyCache", "Shutdown proxy server");
        m5194d();
        this.f4336f.interrupt();
        try {
            if (!this.f4334d.isClosed()) {
                this.f4334d.close();
            }
        } catch (Throwable e) {
            m5184a(new C1477l("Error shutting down proxy server", e));
        }
    }

    /* renamed from: a */
    public boolean m5202a(String str) {
        int i = 0;
        int i2 = 300;
        while (i < 3) {
            try {
                if (((Boolean) this.f4332b.submit(new C1468c(this, str)).get()).booleanValue()) {
                    return true;
                }
                SystemClock.sleep((long) i2);
                i++;
                i2 *= 2;
            } catch (Throwable e) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Error precaching url [attempt: ");
                stringBuilder.append(i);
                stringBuilder.append(", url: ");
                stringBuilder.append(str);
                stringBuilder.append("]. ");
                Log.e("ProxyCache", stringBuilder.toString(), e);
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Shutdown server... Error precaching url [attempts: ");
        stringBuilder2.append(i);
        stringBuilder2.append(", url: ");
        stringBuilder2.append(str);
        stringBuilder2.append("].");
        Log.e("ProxyCache", stringBuilder2.toString());
        m5201a();
        return false;
    }

    /* renamed from: b */
    public String m5203b(String str) {
        if (!this.f4338h) {
            Log.e("ProxyCache", "Proxy server isn't pinged. Caching doesn't work.");
        }
        return this.f4338h ? m5193d(str) : str;
    }
}
