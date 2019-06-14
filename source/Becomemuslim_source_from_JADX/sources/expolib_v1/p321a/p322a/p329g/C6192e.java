package expolib_v1.p321a.p322a.p329g;

import expolib_v1.p321a.C6244x;
import expolib_v1.p321a.C7490w;
import expolib_v1.p321a.p322a.p330h.C6193b;
import expolib_v1.p321a.p322a.p330h.C6196e;
import expolib_v1.p321a.p322a.p330h.C7471a;
import expolib_v1.p332b.C8170c;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* compiled from: Platform */
/* renamed from: expolib_v1.a.a.g.e */
public class C6192e {
    /* renamed from: a */
    private static final C6192e f20043a = C6192e.m25492a();
    /* renamed from: b */
    private static final Logger f20044b = Logger.getLogger(C7490w.class.getName());

    /* renamed from: a */
    public String mo5294a(SSLSocket sSLSocket) {
        return null;
    }

    /* renamed from: a */
    public void mo5299a(SSLSocket sSLSocket, String str, List<C6244x> list) {
    }

    /* renamed from: b */
    public void mo5301b(SSLSocket sSLSocket) {
    }

    /* renamed from: b */
    public boolean mo5300b(String str) {
        return true;
    }

    /* renamed from: c */
    public String m25507c() {
        return "OkHttp";
    }

    /* renamed from: b */
    public static C6192e m25495b() {
        return f20043a;
    }

    /* renamed from: a */
    public javax.net.ssl.X509TrustManager mo5295a(javax.net.ssl.SSLSocketFactory r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = 0;
        r1 = "sun.security.ssl.SSLContextImpl";	 Catch:{ ClassNotFoundException -> 0x001b }
        r1 = java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x001b }
        r2 = "context";	 Catch:{ ClassNotFoundException -> 0x001b }
        r4 = expolib_v1.p321a.p322a.p329g.C6192e.m25493a(r4, r1, r2);	 Catch:{ ClassNotFoundException -> 0x001b }
        if (r4 != 0) goto L_0x0010;	 Catch:{ ClassNotFoundException -> 0x001b }
    L_0x000f:
        return r0;	 Catch:{ ClassNotFoundException -> 0x001b }
    L_0x0010:
        r1 = javax.net.ssl.X509TrustManager.class;	 Catch:{ ClassNotFoundException -> 0x001b }
        r2 = "trustManager";	 Catch:{ ClassNotFoundException -> 0x001b }
        r4 = expolib_v1.p321a.p322a.p329g.C6192e.m25493a(r4, r1, r2);	 Catch:{ ClassNotFoundException -> 0x001b }
        r4 = (javax.net.ssl.X509TrustManager) r4;	 Catch:{ ClassNotFoundException -> 0x001b }
        return r4;
    L_0x001b:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.g.e.a(javax.net.ssl.SSLSocketFactory):javax.net.ssl.X509TrustManager");
    }

    /* renamed from: a */
    public void mo5298a(Socket socket, InetSocketAddress inetSocketAddress, int i) {
        socket.connect(inetSocketAddress, i);
    }

    /* renamed from: a */
    public void mo5296a(int i, String str, Throwable th) {
        f20044b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    /* renamed from: a */
    public Object mo5293a(String str) {
        return f20044b.isLoggable(Level.FINE) ? new Throwable(str) : null;
    }

    /* renamed from: a */
    public void mo5297a(String str, Object obj) {
        if (obj == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
            str = stringBuilder.toString();
        }
        mo5296a(5, str, (Throwable) obj);
    }

    /* renamed from: a */
    public static List<String> m25494a(List<C6244x> list) {
        List<String> arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            C6244x c6244x = (C6244x) list.get(i);
            if (c6244x != C6244x.HTTP_1_0) {
                arrayList.add(c6244x.toString());
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public C6193b mo5292a(X509TrustManager x509TrustManager) {
        return new C7471a(C6196e.m25524a(x509TrustManager));
    }

    /* renamed from: a */
    private static C6192e m25492a() {
        C6192e a = C7468a.m33902a();
        if (a != null) {
            return a;
        }
        a = C7469b.m33912a();
        if (a != null) {
            return a;
        }
        a = C7470c.m33916a();
        if (a != null) {
            return a;
        }
        return new C6192e();
    }

    /* renamed from: b */
    static byte[] m25496b(List<C6244x> list) {
        C8170c c8170c = new C8170c();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            C6244x c6244x = (C6244x) list.get(i);
            if (c6244x != C6244x.HTTP_1_0) {
                c8170c.m39604b(c6244x.toString().length());
                c8170c.m39591a(c6244x.toString());
            }
        }
        return c8170c.mo6402t();
    }

    /* renamed from: a */
    static <T> T m25493a(java.lang.Object r4, java.lang.Class<T> r5, java.lang.String r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r4.getClass();
    L_0x0004:
        r1 = java.lang.Object.class;
        r2 = 0;
        if (r0 == r1) goto L_0x002f;
    L_0x0009:
        r1 = r0.getDeclaredField(r6);	 Catch:{ NoSuchFieldException -> 0x002a, IllegalAccessException -> 0x0024 }
        r3 = 1;	 Catch:{ NoSuchFieldException -> 0x002a, IllegalAccessException -> 0x0024 }
        r1.setAccessible(r3);	 Catch:{ NoSuchFieldException -> 0x002a, IllegalAccessException -> 0x0024 }
        r1 = r1.get(r4);	 Catch:{ NoSuchFieldException -> 0x002a, IllegalAccessException -> 0x0024 }
        if (r1 == 0) goto L_0x0023;	 Catch:{ NoSuchFieldException -> 0x002a, IllegalAccessException -> 0x0024 }
    L_0x0017:
        r3 = r5.isInstance(r1);	 Catch:{ NoSuchFieldException -> 0x002a, IllegalAccessException -> 0x0024 }
        if (r3 != 0) goto L_0x001e;	 Catch:{ NoSuchFieldException -> 0x002a, IllegalAccessException -> 0x0024 }
    L_0x001d:
        goto L_0x0023;	 Catch:{ NoSuchFieldException -> 0x002a, IllegalAccessException -> 0x0024 }
    L_0x001e:
        r1 = r5.cast(r1);	 Catch:{ NoSuchFieldException -> 0x002a, IllegalAccessException -> 0x0024 }
        return r1;
    L_0x0023:
        return r2;
    L_0x0024:
        r4 = new java.lang.AssertionError;
        r4.<init>();
        throw r4;
    L_0x002a:
        r0 = r0.getSuperclass();
        goto L_0x0004;
    L_0x002f:
        r0 = "delegate";
        r0 = r6.equals(r0);
        if (r0 != 0) goto L_0x0046;
    L_0x0037:
        r0 = java.lang.Object.class;
        r1 = "delegate";
        r4 = expolib_v1.p321a.p322a.p329g.C6192e.m25493a(r4, r0, r1);
        if (r4 == 0) goto L_0x0046;
    L_0x0041:
        r4 = expolib_v1.p321a.p322a.p329g.C6192e.m25493a(r4, r5, r6);
        return r4;
    L_0x0046:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.g.e.a(java.lang.Object, java.lang.Class, java.lang.String):T");
    }
}
