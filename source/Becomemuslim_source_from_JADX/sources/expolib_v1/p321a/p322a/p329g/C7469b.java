package expolib_v1.p321a.p322a.p329g;

import java.lang.reflect.Method;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: Jdk9Platform */
/* renamed from: expolib_v1.a.a.g.b */
final class C7469b extends C6192e {
    /* renamed from: a */
    final Method f25916a;
    /* renamed from: b */
    final Method f25917b;

    public C7469b(Method method, Method method2) {
        this.f25916a = method;
        this.f25917b = method2;
    }

    /* renamed from: a */
    public void mo5299a(javax.net.ssl.SSLSocket r5, java.lang.String r6, java.util.List<expolib_v1.p321a.C6244x> r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r6 = r5.getSSLParameters();	 Catch:{ IllegalAccessException -> 0x0021, IllegalAccessException -> 0x0021 }
        r7 = expolib_v1.p321a.p322a.p329g.C6192e.m25494a(r7);	 Catch:{ IllegalAccessException -> 0x0021, IllegalAccessException -> 0x0021 }
        r0 = r4.f25916a;	 Catch:{ IllegalAccessException -> 0x0021, IllegalAccessException -> 0x0021 }
        r1 = 1;	 Catch:{ IllegalAccessException -> 0x0021, IllegalAccessException -> 0x0021 }
        r1 = new java.lang.Object[r1];	 Catch:{ IllegalAccessException -> 0x0021, IllegalAccessException -> 0x0021 }
        r2 = 0;	 Catch:{ IllegalAccessException -> 0x0021, IllegalAccessException -> 0x0021 }
        r3 = r7.size();	 Catch:{ IllegalAccessException -> 0x0021, IllegalAccessException -> 0x0021 }
        r3 = new java.lang.String[r3];	 Catch:{ IllegalAccessException -> 0x0021, IllegalAccessException -> 0x0021 }
        r7 = r7.toArray(r3);	 Catch:{ IllegalAccessException -> 0x0021, IllegalAccessException -> 0x0021 }
        r1[r2] = r7;	 Catch:{ IllegalAccessException -> 0x0021, IllegalAccessException -> 0x0021 }
        r0.invoke(r6, r1);	 Catch:{ IllegalAccessException -> 0x0021, IllegalAccessException -> 0x0021 }
        r5.setSSLParameters(r6);	 Catch:{ IllegalAccessException -> 0x0021, IllegalAccessException -> 0x0021 }
        return;
    L_0x0021:
        r5 = new java.lang.AssertionError;
        r5.<init>();
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.g.b.a(javax.net.ssl.SSLSocket, java.lang.String, java.util.List):void");
    }

    /* renamed from: a */
    public java.lang.String mo5294a(javax.net.ssl.SSLSocket r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.f25917b;	 Catch:{ IllegalAccessException -> 0x0019, IllegalAccessException -> 0x0019 }
        r1 = 0;	 Catch:{ IllegalAccessException -> 0x0019, IllegalAccessException -> 0x0019 }
        r1 = new java.lang.Object[r1];	 Catch:{ IllegalAccessException -> 0x0019, IllegalAccessException -> 0x0019 }
        r3 = r0.invoke(r3, r1);	 Catch:{ IllegalAccessException -> 0x0019, IllegalAccessException -> 0x0019 }
        r3 = (java.lang.String) r3;	 Catch:{ IllegalAccessException -> 0x0019, IllegalAccessException -> 0x0019 }
        if (r3 == 0) goto L_0x0017;	 Catch:{ IllegalAccessException -> 0x0019, IllegalAccessException -> 0x0019 }
    L_0x000d:
        r0 = "";	 Catch:{ IllegalAccessException -> 0x0019, IllegalAccessException -> 0x0019 }
        r0 = r3.equals(r0);	 Catch:{ IllegalAccessException -> 0x0019, IllegalAccessException -> 0x0019 }
        if (r0 == 0) goto L_0x0016;
    L_0x0015:
        goto L_0x0017;
    L_0x0016:
        return r3;
    L_0x0017:
        r3 = 0;
        return r3;
    L_0x0019:
        r3 = new java.lang.AssertionError;
        r3.<init>();
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.g.b.a(javax.net.ssl.SSLSocket):java.lang.String");
    }

    /* renamed from: a */
    public X509TrustManager mo5295a(SSLSocketFactory sSLSocketFactory) {
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+");
    }

    /* renamed from: a */
    public static expolib_v1.p321a.p322a.p329g.C7469b m33912a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = javax.net.ssl.SSLParameters.class;	 Catch:{ NoSuchMethodException -> 0x0020 }
        r1 = "setApplicationProtocols";	 Catch:{ NoSuchMethodException -> 0x0020 }
        r2 = 1;	 Catch:{ NoSuchMethodException -> 0x0020 }
        r2 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x0020 }
        r3 = java.lang.String[].class;	 Catch:{ NoSuchMethodException -> 0x0020 }
        r4 = 0;	 Catch:{ NoSuchMethodException -> 0x0020 }
        r2[r4] = r3;	 Catch:{ NoSuchMethodException -> 0x0020 }
        r0 = r0.getMethod(r1, r2);	 Catch:{ NoSuchMethodException -> 0x0020 }
        r1 = javax.net.ssl.SSLSocket.class;	 Catch:{ NoSuchMethodException -> 0x0020 }
        r2 = "getApplicationProtocol";	 Catch:{ NoSuchMethodException -> 0x0020 }
        r3 = new java.lang.Class[r4];	 Catch:{ NoSuchMethodException -> 0x0020 }
        r1 = r1.getMethod(r2, r3);	 Catch:{ NoSuchMethodException -> 0x0020 }
        r2 = new expolib_v1.a.a.g.b;	 Catch:{ NoSuchMethodException -> 0x0020 }
        r2.<init>(r0, r1);	 Catch:{ NoSuchMethodException -> 0x0020 }
        return r2;
    L_0x0020:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.g.b.a():expolib_v1.a.a.g.b");
    }
}
