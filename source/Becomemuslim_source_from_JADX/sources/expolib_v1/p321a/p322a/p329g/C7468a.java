package expolib_v1.p321a.p322a.p329g;

import android.util.Log;
import expolib_v1.p321a.C6244x;
import expolib_v1.p321a.p322a.C6165c;
import expolib_v1.p321a.p322a.p330h.C6193b;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;

/* compiled from: AndroidPlatform */
/* renamed from: expolib_v1.a.a.g.a */
class C7468a extends C6192e {
    /* renamed from: a */
    private final Class<?> f25910a;
    /* renamed from: b */
    private final C6191d<Socket> f25911b;
    /* renamed from: c */
    private final C6191d<Socket> f25912c;
    /* renamed from: d */
    private final C6191d<Socket> f25913d;
    /* renamed from: e */
    private final C6191d<Socket> f25914e;
    /* renamed from: f */
    private final C6189b f25915f = C6189b.m25482a();

    /* compiled from: AndroidPlatform */
    /* renamed from: expolib_v1.a.a.g.a$b */
    static final class C6189b {
        /* renamed from: a */
        private final Method f20034a;
        /* renamed from: b */
        private final Method f20035b;
        /* renamed from: c */
        private final Method f20036c;

        C6189b(Method method, Method method2, Method method3) {
            this.f20034a = method;
            this.f20035b = method2;
            this.f20036c = method3;
        }

        /* renamed from: a */
        java.lang.Object m25483a(java.lang.String r6) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r5 = this;
            r0 = r5.f20034a;
            r1 = 0;
            if (r0 == 0) goto L_0x0019;
        L_0x0005:
            r0 = r5.f20034a;	 Catch:{ Exception -> 0x0019 }
            r2 = 0;	 Catch:{ Exception -> 0x0019 }
            r3 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0019 }
            r0 = r0.invoke(r1, r3);	 Catch:{ Exception -> 0x0019 }
            r3 = r5.f20035b;	 Catch:{ Exception -> 0x0019 }
            r4 = 1;	 Catch:{ Exception -> 0x0019 }
            r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0019 }
            r4[r2] = r6;	 Catch:{ Exception -> 0x0019 }
            r3.invoke(r0, r4);	 Catch:{ Exception -> 0x0019 }
            return r0;
        L_0x0019:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.g.a.b.a(java.lang.String):java.lang.Object");
        }

        /* renamed from: a */
        boolean m25484a(java.lang.Object r4) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r3 = this;
            r0 = 0;
            if (r4 == 0) goto L_0x000b;
        L_0x0003:
            r1 = r3.f20036c;	 Catch:{ Exception -> 0x000b }
            r2 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x000b }
            r1.invoke(r4, r2);	 Catch:{ Exception -> 0x000b }
            r0 = 1;
        L_0x000b:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.g.a.b.a(java.lang.Object):boolean");
        }

        /* renamed from: a */
        static expolib_v1.p321a.p322a.p329g.C7468a.C6189b m25482a() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = 0;
            r1 = "dalvik.system.CloseGuard";	 Catch:{ Exception -> 0x0027 }
            r1 = java.lang.Class.forName(r1);	 Catch:{ Exception -> 0x0027 }
            r2 = "get";	 Catch:{ Exception -> 0x0027 }
            r3 = 0;	 Catch:{ Exception -> 0x0027 }
            r4 = new java.lang.Class[r3];	 Catch:{ Exception -> 0x0027 }
            r2 = r1.getMethod(r2, r4);	 Catch:{ Exception -> 0x0027 }
            r4 = "open";	 Catch:{ Exception -> 0x0027 }
            r5 = 1;	 Catch:{ Exception -> 0x0027 }
            r5 = new java.lang.Class[r5];	 Catch:{ Exception -> 0x0027 }
            r6 = java.lang.String.class;	 Catch:{ Exception -> 0x0027 }
            r5[r3] = r6;	 Catch:{ Exception -> 0x0027 }
            r4 = r1.getMethod(r4, r5);	 Catch:{ Exception -> 0x0027 }
            r5 = "warnIfOpen";	 Catch:{ Exception -> 0x0027 }
            r3 = new java.lang.Class[r3];	 Catch:{ Exception -> 0x0027 }
            r1 = r1.getMethod(r5, r3);	 Catch:{ Exception -> 0x0027 }
            r0 = r2;
            goto L_0x0029;
        L_0x0027:
            r1 = r0;
            r4 = r1;
        L_0x0029:
            r2 = new expolib_v1.a.a.g.a$b;
            r2.<init>(r0, r4, r1);
            return r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.g.a.b.a():expolib_v1.a.a.g.a$b");
        }
    }

    /* compiled from: AndroidPlatform */
    /* renamed from: expolib_v1.a.a.g.a$a */
    static final class C7467a extends C6193b {
        /* renamed from: a */
        private final Object f25908a;
        /* renamed from: b */
        private final Method f25909b;

        public int hashCode() {
            return 0;
        }

        C7467a(Object obj, Method method) {
            this.f25908a = obj;
            this.f25909b = method;
        }

        /* renamed from: a */
        public List<Certificate> mo5291a(List<Certificate> list, String str) {
            try {
                X509Certificate[] x509CertificateArr = (X509Certificate[]) list.toArray(new X509Certificate[list.size()]);
                return (List) this.f25909b.invoke(this.f25908a, new Object[]{x509CertificateArr, "RSA", str});
            } catch (List<Certificate> list2) {
                str = new SSLPeerUnverifiedException(list2.getMessage());
                str.initCause(list2);
                throw str;
            } catch (List<Certificate> list22) {
                throw new AssertionError(list22);
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof C7467a;
        }
    }

    public C7468a(Class<?> cls, C6191d<Socket> c6191d, C6191d<Socket> c6191d2, C6191d<Socket> c6191d3, C6191d<Socket> c6191d4) {
        this.f25910a = cls;
        this.f25911b = c6191d;
        this.f25912c = c6191d2;
        this.f25913d = c6191d3;
        this.f25914e = c6191d4;
    }

    /* renamed from: a */
    public void mo5298a(Socket socket, InetSocketAddress inetSocketAddress, int i) {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e) {
            if (C6165c.m25318a(e) != null) {
                throw new IOException(e);
            }
            throw e;
        } catch (Socket socket2) {
            inetSocketAddress = new IOException("Exception in connect");
            inetSocketAddress.initCause(socket2);
            throw inetSocketAddress;
        }
    }

    /* renamed from: a */
    public javax.net.ssl.X509TrustManager mo5295a(javax.net.ssl.SSLSocketFactory r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.f25910a;
        r1 = "sslParameters";
        r0 = expolib_v1.p321a.p322a.p329g.C6192e.m25493a(r4, r0, r1);
        if (r0 != 0) goto L_0x0025;
    L_0x000a:
        r0 = "com.google.android.gms.org.conscrypt.SSLParametersImpl";	 Catch:{ ClassNotFoundException -> 0x0020 }
        r1 = 0;	 Catch:{ ClassNotFoundException -> 0x0020 }
        r2 = r4.getClass();	 Catch:{ ClassNotFoundException -> 0x0020 }
        r2 = r2.getClassLoader();	 Catch:{ ClassNotFoundException -> 0x0020 }
        r0 = java.lang.Class.forName(r0, r1, r2);	 Catch:{ ClassNotFoundException -> 0x0020 }
        r1 = "sslParameters";	 Catch:{ ClassNotFoundException -> 0x0020 }
        r0 = expolib_v1.p321a.p322a.p329g.C6192e.m25493a(r4, r0, r1);	 Catch:{ ClassNotFoundException -> 0x0020 }
        goto L_0x0025;
    L_0x0020:
        r4 = super.mo5295a(r4);
        return r4;
    L_0x0025:
        r4 = javax.net.ssl.X509TrustManager.class;
        r1 = "x509TrustManager";
        r4 = expolib_v1.p321a.p322a.p329g.C6192e.m25493a(r0, r4, r1);
        r4 = (javax.net.ssl.X509TrustManager) r4;
        if (r4 == 0) goto L_0x0032;
    L_0x0031:
        return r4;
    L_0x0032:
        r4 = javax.net.ssl.X509TrustManager.class;
        r1 = "trustManager";
        r4 = expolib_v1.p321a.p322a.p329g.C6192e.m25493a(r0, r4, r1);
        r4 = (javax.net.ssl.X509TrustManager) r4;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.g.a.a(javax.net.ssl.SSLSocketFactory):javax.net.ssl.X509TrustManager");
    }

    /* renamed from: a */
    public void mo5299a(SSLSocket sSLSocket, String str, List<C6244x> list) {
        if (str != null) {
            this.f25911b.m25489b(sSLSocket, Boolean.valueOf(true));
            this.f25912c.m25489b(sSLSocket, str);
        }
        if (this.f25914e != null && this.f25914e.m25488a((Object) sSLSocket) != null) {
            this.f25914e.m25491d(sSLSocket, new Object[]{C6192e.m25496b((List) list)});
        }
    }

    /* renamed from: a */
    public String mo5294a(SSLSocket sSLSocket) {
        String str = null;
        if (this.f25913d == null || !this.f25913d.m25488a((Object) sSLSocket)) {
            return null;
        }
        byte[] bArr = (byte[]) this.f25913d.m25491d(sSLSocket, new Object[0]);
        if (bArr != null) {
            str = new String(bArr, C6165c.f19911e);
        }
        return str;
    }

    /* renamed from: a */
    public void mo5296a(int i, String str, Throwable th) {
        int i2 = 5;
        if (i != 5) {
            i2 = 3;
        }
        if (th != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append('\n');
            stringBuilder.append(Log.getStackTraceString(th));
            str = stringBuilder.toString();
        }
        th = null;
        int length = str.length();
        while (th < length) {
            int min;
            int indexOf = str.indexOf(10, th);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, th + 4000);
                Log.println(i2, "OkHttp", str.substring(th, min));
                if (min >= indexOf) {
                    break;
                }
                th = min;
            }
            th = min + 1;
        }
    }

    /* renamed from: a */
    public Object mo5293a(String str) {
        return this.f25915f.m25483a(str);
    }

    /* renamed from: a */
    public void mo5297a(String str, Object obj) {
        if (this.f25915f.m25484a(obj) == null) {
            mo5296a(5, str, null);
        }
    }

    /* renamed from: b */
    public boolean mo5300b(java.lang.String r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = "android.security.NetworkSecurityPolicy";	 Catch:{ ClassNotFoundException -> 0x0038, ClassNotFoundException -> 0x0038, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0038, ClassNotFoundException -> 0x0038, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032 }
        r1 = "getInstance";	 Catch:{ ClassNotFoundException -> 0x0038, ClassNotFoundException -> 0x0038, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032 }
        r2 = 0;	 Catch:{ ClassNotFoundException -> 0x0038, ClassNotFoundException -> 0x0038, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032 }
        r3 = new java.lang.Class[r2];	 Catch:{ ClassNotFoundException -> 0x0038, ClassNotFoundException -> 0x0038, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032 }
        r1 = r0.getMethod(r1, r3);	 Catch:{ ClassNotFoundException -> 0x0038, ClassNotFoundException -> 0x0038, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032 }
        r3 = 0;	 Catch:{ ClassNotFoundException -> 0x0038, ClassNotFoundException -> 0x0038, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032 }
        r4 = new java.lang.Object[r2];	 Catch:{ ClassNotFoundException -> 0x0038, ClassNotFoundException -> 0x0038, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032 }
        r1 = r1.invoke(r3, r4);	 Catch:{ ClassNotFoundException -> 0x0038, ClassNotFoundException -> 0x0038, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032 }
        r3 = "isCleartextTrafficPermitted";	 Catch:{ ClassNotFoundException -> 0x0038, ClassNotFoundException -> 0x0038, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032 }
        r4 = 1;	 Catch:{ ClassNotFoundException -> 0x0038, ClassNotFoundException -> 0x0038, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032 }
        r5 = new java.lang.Class[r4];	 Catch:{ ClassNotFoundException -> 0x0038, ClassNotFoundException -> 0x0038, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032 }
        r6 = java.lang.String.class;	 Catch:{ ClassNotFoundException -> 0x0038, ClassNotFoundException -> 0x0038, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032 }
        r5[r2] = r6;	 Catch:{ ClassNotFoundException -> 0x0038, ClassNotFoundException -> 0x0038, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032 }
        r0 = r0.getMethod(r3, r5);	 Catch:{ ClassNotFoundException -> 0x0038, ClassNotFoundException -> 0x0038, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032 }
        r3 = new java.lang.Object[r4];	 Catch:{ ClassNotFoundException -> 0x0038, ClassNotFoundException -> 0x0038, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032 }
        r3[r2] = r8;	 Catch:{ ClassNotFoundException -> 0x0038, ClassNotFoundException -> 0x0038, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032 }
        r0 = r0.invoke(r1, r3);	 Catch:{ ClassNotFoundException -> 0x0038, ClassNotFoundException -> 0x0038, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032 }
        r0 = (java.lang.Boolean) r0;	 Catch:{ ClassNotFoundException -> 0x0038, ClassNotFoundException -> 0x0038, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032 }
        r0 = r0.booleanValue();	 Catch:{ ClassNotFoundException -> 0x0038, ClassNotFoundException -> 0x0038, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032 }
        return r0;
    L_0x0032:
        r8 = new java.lang.AssertionError;
        r8.<init>();
        throw r8;
    L_0x0038:
        r8 = super.mo5300b(r8);
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.g.a.b(java.lang.String):boolean");
    }

    /* renamed from: a */
    public expolib_v1.p321a.p322a.p330h.C6193b mo5292a(javax.net.ssl.X509TrustManager r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = "android.net.http.X509TrustManagerExtensions";	 Catch:{ Exception -> 0x0036 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Exception -> 0x0036 }
        r1 = 1;	 Catch:{ Exception -> 0x0036 }
        r2 = new java.lang.Class[r1];	 Catch:{ Exception -> 0x0036 }
        r3 = javax.net.ssl.X509TrustManager.class;	 Catch:{ Exception -> 0x0036 }
        r4 = 0;	 Catch:{ Exception -> 0x0036 }
        r2[r4] = r3;	 Catch:{ Exception -> 0x0036 }
        r2 = r0.getConstructor(r2);	 Catch:{ Exception -> 0x0036 }
        r3 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x0036 }
        r3[r4] = r8;	 Catch:{ Exception -> 0x0036 }
        r2 = r2.newInstance(r3);	 Catch:{ Exception -> 0x0036 }
        r3 = "checkServerTrusted";	 Catch:{ Exception -> 0x0036 }
        r5 = 3;	 Catch:{ Exception -> 0x0036 }
        r5 = new java.lang.Class[r5];	 Catch:{ Exception -> 0x0036 }
        r6 = java.security.cert.X509Certificate[].class;	 Catch:{ Exception -> 0x0036 }
        r5[r4] = r6;	 Catch:{ Exception -> 0x0036 }
        r4 = java.lang.String.class;	 Catch:{ Exception -> 0x0036 }
        r5[r1] = r4;	 Catch:{ Exception -> 0x0036 }
        r1 = 2;	 Catch:{ Exception -> 0x0036 }
        r4 = java.lang.String.class;	 Catch:{ Exception -> 0x0036 }
        r5[r1] = r4;	 Catch:{ Exception -> 0x0036 }
        r0 = r0.getMethod(r3, r5);	 Catch:{ Exception -> 0x0036 }
        r1 = new expolib_v1.a.a.g.a$a;	 Catch:{ Exception -> 0x0036 }
        r1.<init>(r2, r0);	 Catch:{ Exception -> 0x0036 }
        return r1;
    L_0x0036:
        r8 = super.mo5292a(r8);
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.g.a.a(javax.net.ssl.X509TrustManager):expolib_v1.a.a.h.b");
    }

    /* renamed from: a */
    public static expolib_v1.p321a.p322a.p329g.C6192e m33902a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = "com.android.org.conscrypt.SSLParametersImpl";	 Catch:{ ClassNotFoundException -> 0x0009 }
        r1 = java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x0009 }
    L_0x0007:
        r3 = r1;
        goto L_0x0010;
    L_0x0009:
        r1 = "org.apache.harmony.xnet.provider.jsse.SSLParametersImpl";	 Catch:{ ClassNotFoundException -> 0x0055 }
        r1 = java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x0055 }
        goto L_0x0007;	 Catch:{ ClassNotFoundException -> 0x0055 }
    L_0x0010:
        r4 = new expolib_v1.a.a.g.d;	 Catch:{ ClassNotFoundException -> 0x0055 }
        r1 = "setUseSessionTickets";	 Catch:{ ClassNotFoundException -> 0x0055 }
        r2 = 1;	 Catch:{ ClassNotFoundException -> 0x0055 }
        r5 = new java.lang.Class[r2];	 Catch:{ ClassNotFoundException -> 0x0055 }
        r6 = java.lang.Boolean.TYPE;	 Catch:{ ClassNotFoundException -> 0x0055 }
        r7 = 0;	 Catch:{ ClassNotFoundException -> 0x0055 }
        r5[r7] = r6;	 Catch:{ ClassNotFoundException -> 0x0055 }
        r4.<init>(r0, r1, r5);	 Catch:{ ClassNotFoundException -> 0x0055 }
        r5 = new expolib_v1.a.a.g.d;	 Catch:{ ClassNotFoundException -> 0x0055 }
        r1 = "setHostname";	 Catch:{ ClassNotFoundException -> 0x0055 }
        r6 = new java.lang.Class[r2];	 Catch:{ ClassNotFoundException -> 0x0055 }
        r8 = java.lang.String.class;	 Catch:{ ClassNotFoundException -> 0x0055 }
        r6[r7] = r8;	 Catch:{ ClassNotFoundException -> 0x0055 }
        r5.<init>(r0, r1, r6);	 Catch:{ ClassNotFoundException -> 0x0055 }
        r1 = "android.net.Network";	 Catch:{ ClassNotFoundException -> 0x004b }
        java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x004b }
        r1 = new expolib_v1.a.a.g.d;	 Catch:{ ClassNotFoundException -> 0x004b }
        r6 = byte[].class;	 Catch:{ ClassNotFoundException -> 0x004b }
        r8 = "getAlpnSelectedProtocol";	 Catch:{ ClassNotFoundException -> 0x004b }
        r9 = new java.lang.Class[r7];	 Catch:{ ClassNotFoundException -> 0x004b }
        r1.<init>(r6, r8, r9);	 Catch:{ ClassNotFoundException -> 0x004b }
        r6 = new expolib_v1.a.a.g.d;	 Catch:{ ClassNotFoundException -> 0x004c }
        r8 = "setAlpnProtocols";	 Catch:{ ClassNotFoundException -> 0x004c }
        r2 = new java.lang.Class[r2];	 Catch:{ ClassNotFoundException -> 0x004c }
        r9 = byte[].class;	 Catch:{ ClassNotFoundException -> 0x004c }
        r2[r7] = r9;	 Catch:{ ClassNotFoundException -> 0x004c }
        r6.<init>(r0, r8, r2);	 Catch:{ ClassNotFoundException -> 0x004c }
        r7 = r6;
        goto L_0x004d;
    L_0x004b:
        r1 = r0;
    L_0x004c:
        r7 = r0;
    L_0x004d:
        r6 = r1;
        r1 = new expolib_v1.a.a.g.a;	 Catch:{ ClassNotFoundException -> 0x0055 }
        r2 = r1;	 Catch:{ ClassNotFoundException -> 0x0055 }
        r2.<init>(r3, r4, r5, r6, r7);	 Catch:{ ClassNotFoundException -> 0x0055 }
        return r1;
    L_0x0055:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.g.a.a():expolib_v1.a.a.g.e");
    }
}
