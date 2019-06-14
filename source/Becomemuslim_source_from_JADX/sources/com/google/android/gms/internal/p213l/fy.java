package com.google.android.gms.internal.p213l;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

/* renamed from: com.google.android.gms.internal.l.fy */
final class fy extends SSLSocket {
    /* renamed from: a */
    private final SSLSocket f17243a;

    fy(fx fxVar, SSLSocket sSLSocket) {
        this.f17243a = sSLSocket;
    }

    public final void addHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        this.f17243a.addHandshakeCompletedListener(handshakeCompletedListener);
    }

    public final void bind(SocketAddress socketAddress) {
        this.f17243a.bind(socketAddress);
    }

    public final synchronized void close() {
        this.f17243a.close();
    }

    public final void connect(SocketAddress socketAddress) {
        this.f17243a.connect(socketAddress);
    }

    public final void connect(SocketAddress socketAddress, int i) {
        this.f17243a.connect(socketAddress, i);
    }

    public final boolean equals(Object obj) {
        return this.f17243a.equals(obj);
    }

    public final SocketChannel getChannel() {
        return this.f17243a.getChannel();
    }

    public final boolean getEnableSessionCreation() {
        return this.f17243a.getEnableSessionCreation();
    }

    public final String[] getEnabledCipherSuites() {
        return this.f17243a.getEnabledCipherSuites();
    }

    public final String[] getEnabledProtocols() {
        return this.f17243a.getEnabledProtocols();
    }

    public final InetAddress getInetAddress() {
        return this.f17243a.getInetAddress();
    }

    public final InputStream getInputStream() {
        return this.f17243a.getInputStream();
    }

    public final boolean getKeepAlive() {
        return this.f17243a.getKeepAlive();
    }

    public final InetAddress getLocalAddress() {
        return this.f17243a.getLocalAddress();
    }

    public final int getLocalPort() {
        return this.f17243a.getLocalPort();
    }

    public final SocketAddress getLocalSocketAddress() {
        return this.f17243a.getLocalSocketAddress();
    }

    public final boolean getNeedClientAuth() {
        return this.f17243a.getNeedClientAuth();
    }

    public final boolean getOOBInline() {
        return this.f17243a.getOOBInline();
    }

    public final OutputStream getOutputStream() {
        return this.f17243a.getOutputStream();
    }

    public final int getPort() {
        return this.f17243a.getPort();
    }

    public final synchronized int getReceiveBufferSize() {
        return this.f17243a.getReceiveBufferSize();
    }

    public final SocketAddress getRemoteSocketAddress() {
        return this.f17243a.getRemoteSocketAddress();
    }

    public final boolean getReuseAddress() {
        return this.f17243a.getReuseAddress();
    }

    public final synchronized int getSendBufferSize() {
        return this.f17243a.getSendBufferSize();
    }

    public final SSLSession getSession() {
        return this.f17243a.getSession();
    }

    public final int getSoLinger() {
        return this.f17243a.getSoLinger();
    }

    public final synchronized int getSoTimeout() {
        return this.f17243a.getSoTimeout();
    }

    public final String[] getSupportedCipherSuites() {
        return this.f17243a.getSupportedCipherSuites();
    }

    public final String[] getSupportedProtocols() {
        return this.f17243a.getSupportedProtocols();
    }

    public final boolean getTcpNoDelay() {
        return this.f17243a.getTcpNoDelay();
    }

    public final int getTrafficClass() {
        return this.f17243a.getTrafficClass();
    }

    public final boolean getUseClientMode() {
        return this.f17243a.getUseClientMode();
    }

    public final boolean getWantClientAuth() {
        return this.f17243a.getWantClientAuth();
    }

    public final boolean isBound() {
        return this.f17243a.isBound();
    }

    public final boolean isClosed() {
        return this.f17243a.isClosed();
    }

    public final boolean isConnected() {
        return this.f17243a.isConnected();
    }

    public final boolean isInputShutdown() {
        return this.f17243a.isInputShutdown();
    }

    public final boolean isOutputShutdown() {
        return this.f17243a.isOutputShutdown();
    }

    public final void removeHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        this.f17243a.removeHandshakeCompletedListener(handshakeCompletedListener);
    }

    public final void sendUrgentData(int i) {
        this.f17243a.sendUrgentData(i);
    }

    public final void setEnableSessionCreation(boolean z) {
        this.f17243a.setEnableSessionCreation(z);
    }

    public final void setEnabledCipherSuites(String[] strArr) {
        this.f17243a.setEnabledCipherSuites(strArr);
    }

    public final void setEnabledProtocols(String[] strArr) {
        if (strArr != null && Arrays.asList(strArr).contains("SSLv3")) {
            List arrayList = new ArrayList(Arrays.asList(this.f17243a.getEnabledProtocols()));
            if (arrayList.size() > 1) {
                arrayList.remove("SSLv3");
            }
            strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        this.f17243a.setEnabledProtocols(strArr);
    }

    public final void setKeepAlive(boolean z) {
        this.f17243a.setKeepAlive(z);
    }

    public final void setNeedClientAuth(boolean z) {
        this.f17243a.setNeedClientAuth(z);
    }

    public final void setOOBInline(boolean z) {
        this.f17243a.setOOBInline(z);
    }

    public final void setPerformancePreferences(int i, int i2, int i3) {
        this.f17243a.setPerformancePreferences(i, i2, i3);
    }

    public final synchronized void setReceiveBufferSize(int i) {
        this.f17243a.setReceiveBufferSize(i);
    }

    public final void setReuseAddress(boolean z) {
        this.f17243a.setReuseAddress(z);
    }

    public final synchronized void setSendBufferSize(int i) {
        this.f17243a.setSendBufferSize(i);
    }

    public final void setSoLinger(boolean z, int i) {
        this.f17243a.setSoLinger(z, i);
    }

    public final synchronized void setSoTimeout(int i) {
        this.f17243a.setSoTimeout(i);
    }

    public final void setTcpNoDelay(boolean z) {
        this.f17243a.setTcpNoDelay(z);
    }

    public final void setTrafficClass(int i) {
        this.f17243a.setTrafficClass(i);
    }

    public final void setUseClientMode(boolean z) {
        this.f17243a.setUseClientMode(z);
    }

    public final void setWantClientAuth(boolean z) {
        this.f17243a.setWantClientAuth(z);
    }

    public final void shutdownInput() {
        this.f17243a.shutdownInput();
    }

    public final void shutdownOutput() {
        this.f17243a.shutdownOutput();
    }

    public final void startHandshake() {
        this.f17243a.startHandshake();
    }

    public final String toString() {
        return this.f17243a.toString();
    }
}
