package com.facebook.react.modules.network;

import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class TLSSocketFactory extends SSLSocketFactory {
    private SSLSocketFactory delegate;

    public TLSSocketFactory() {
        SSLContext instance = SSLContext.getInstance("TLS");
        instance.init(null, null, null);
        this.delegate = instance.getSocketFactory();
    }

    public String[] getDefaultCipherSuites() {
        return this.delegate.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.delegate.getSupportedCipherSuites();
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        return enableTLSOnSocket(this.delegate.createSocket(socket, str, i, z));
    }

    public Socket createSocket(String str, int i) {
        return enableTLSOnSocket(this.delegate.createSocket(str, i));
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        return enableTLSOnSocket(this.delegate.createSocket(str, i, inetAddress, i2));
    }

    public Socket createSocket(InetAddress inetAddress, int i) {
        return enableTLSOnSocket(this.delegate.createSocket(inetAddress, i));
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return enableTLSOnSocket(this.delegate.createSocket(inetAddress, i, inetAddress2, i2));
    }

    private Socket enableTLSOnSocket(Socket socket) {
        if (socket != null && (socket instanceof SSLSocket)) {
            ((SSLSocket) socket).setEnabledProtocols(new String[]{"TLSv1", "TLSv1.1", "TLSv1.2"});
        }
        return socket;
    }
}
