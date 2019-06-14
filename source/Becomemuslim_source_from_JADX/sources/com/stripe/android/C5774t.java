package com.stripe.android;

import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: StripeSSLSocketFactory */
/* renamed from: com.stripe.android.t */
class C5774t extends SSLSocketFactory {
    /* renamed from: a */
    private final SSLSocketFactory f19155a = HttpsURLConnection.getDefaultSSLSocketFactory();
    /* renamed from: b */
    private final boolean f19156b;
    /* renamed from: c */
    private final boolean f19157c;

    C5774t() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r8.<init>();
        r0 = javax.net.ssl.HttpsURLConnection.getDefaultSSLSocketFactory();
        r8.f19155a = r0;
        r0 = 0;
        r1 = javax.net.ssl.SSLContext.getDefault();	 Catch:{ NoSuchAlgorithmException -> 0x0017 }
        r1 = r1.getSupportedSSLParameters();	 Catch:{ NoSuchAlgorithmException -> 0x0017 }
        r1 = r1.getProtocols();	 Catch:{ NoSuchAlgorithmException -> 0x0017 }
        goto L_0x0019;
    L_0x0017:
        r1 = new java.lang.String[r0];
    L_0x0019:
        r2 = r1.length;
        r3 = 0;
        r4 = 0;
    L_0x001c:
        if (r0 >= r2) goto L_0x0037;
    L_0x001e:
        r5 = r1[r0];
        r6 = "TLSv1.1";
        r6 = r5.equals(r6);
        r7 = 1;
        if (r6 == 0) goto L_0x002b;
    L_0x0029:
        r3 = 1;
        goto L_0x0034;
    L_0x002b:
        r6 = "TLSv1.2";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x0034;
    L_0x0033:
        r4 = 1;
    L_0x0034:
        r0 = r0 + 1;
        goto L_0x001c;
    L_0x0037:
        r8.f19156b = r3;
        r8.f19157c = r4;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.t.<init>():void");
    }

    public String[] getDefaultCipherSuites() {
        return this.f19155a.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.f19155a.getSupportedCipherSuites();
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        return m24415a(this.f19155a.createSocket(socket, str, i, z));
    }

    public Socket createSocket(String str, int i) {
        return m24415a(this.f19155a.createSocket(str, i));
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        return m24415a(this.f19155a.createSocket(str, i, inetAddress, i2));
    }

    public Socket createSocket(InetAddress inetAddress, int i) {
        return m24415a(this.f19155a.createSocket(inetAddress, i));
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return m24415a(this.f19155a.createSocket(inetAddress, i, inetAddress2, i2));
    }

    /* renamed from: a */
    private Socket m24415a(Socket socket) {
        if (!(socket instanceof SSLSocket)) {
            return socket;
        }
        SSLSocket sSLSocket = (SSLSocket) socket;
        Set hashSet = new HashSet(Arrays.asList(sSLSocket.getEnabledProtocols()));
        if (this.f19156b) {
            hashSet.add("TLSv1.1");
        }
        if (this.f19157c) {
            hashSet.add("TLSv1.2");
        }
        sSLSocket.setEnabledProtocols((String[]) hashSet.toArray(new String[0]));
        return sSLSocket;
    }
}
