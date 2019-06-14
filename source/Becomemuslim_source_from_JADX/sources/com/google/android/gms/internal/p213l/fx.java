package com.google.android.gms.internal.p213l;

import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: com.google.android.gms.internal.l.fx */
final class fx extends SSLSocketFactory {
    /* renamed from: a */
    private final SSLSocketFactory f17242a;

    fx() {
        this(HttpsURLConnection.getDefaultSSLSocketFactory());
    }

    private fx(SSLSocketFactory sSLSocketFactory) {
        this.f17242a = sSLSocketFactory;
    }

    /* renamed from: a */
    private final SSLSocket m21370a(SSLSocket sSLSocket) {
        return new fy(this, sSLSocket);
    }

    public final Socket createSocket() {
        return m21370a((SSLSocket) this.f17242a.createSocket());
    }

    public final Socket createSocket(String str, int i) {
        return m21370a((SSLSocket) this.f17242a.createSocket(str, i));
    }

    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        return m21370a((SSLSocket) this.f17242a.createSocket(str, i, inetAddress, i2));
    }

    public final Socket createSocket(InetAddress inetAddress, int i) {
        return m21370a((SSLSocket) this.f17242a.createSocket(inetAddress, i));
    }

    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return m21370a((SSLSocket) this.f17242a.createSocket(inetAddress, i, inetAddress2, i2));
    }

    public final Socket createSocket(Socket socket, String str, int i, boolean z) {
        return m21370a((SSLSocket) this.f17242a.createSocket(socket, str, i, z));
    }

    public final String[] getDefaultCipherSuites() {
        return this.f17242a.getDefaultCipherSuites();
    }

    public final String[] getSupportedCipherSuites() {
        return this.f17242a.getSupportedCipherSuites();
    }
}
