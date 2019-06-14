package okhttp3.internal.connection;

import com.facebook.common.time.Clock;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.stetho.server.http.HttpStatus;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.Connection;
import okhttp3.ConnectionPool;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Interceptor.Chain;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http1.Http1Codec;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Codec;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2Connection.Builder;
import okhttp3.internal.http2.Http2Connection.Listener;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket.Streams;
import p286d.C5870l;
import p286d.C5876t;
import p286d.C7203d;
import p286d.C7204e;

public final class RealConnection extends Listener implements Connection {
    private static final int MAX_TUNNEL_ATTEMPTS = 21;
    private static final String NPE_THROW_WITH_NULL = "throw with null exception";
    public int allocationLimit = 1;
    public final List<Reference<StreamAllocation>> allocations = new ArrayList();
    private final ConnectionPool connectionPool;
    private Handshake handshake;
    private Http2Connection http2Connection;
    public long idleAtNanos = Clock.MAX_TIME;
    public boolean noNewStreams;
    private Protocol protocol;
    private Socket rawSocket;
    private final Route route;
    private C7203d sink;
    private Socket socket;
    private C7204e source;
    public int successCount;

    public RealConnection(ConnectionPool connectionPool, Route route) {
        this.connectionPool = connectionPool;
        this.route = route;
    }

    public static RealConnection testConnection(ConnectionPool connectionPool, Route route, Socket socket, long j) {
        RealConnection realConnection = new RealConnection(connectionPool, route);
        realConnection.socket = socket;
        realConnection.idleAtNanos = j;
        return realConnection;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connect(int r17, int r18, int r19, int r20, boolean r21, okhttp3.Call r22, okhttp3.EventListener r23) {
        /*
        r16 = this;
        r7 = r16;
        r8 = r22;
        r9 = r23;
        r0 = r7.protocol;
        if (r0 != 0) goto L_0x0132;
    L_0x000a:
        r0 = r7.route;
        r0 = r0.address();
        r0 = r0.connectionSpecs();
        r10 = new okhttp3.internal.connection.ConnectionSpecSelector;
        r10.<init>(r0);
        r1 = r7.route;
        r1 = r1.address();
        r1 = r1.sslSocketFactory();
        if (r1 != 0) goto L_0x0074;
    L_0x0025:
        r1 = okhttp3.ConnectionSpec.CLEARTEXT;
        r0 = r0.contains(r1);
        if (r0 == 0) goto L_0x0067;
    L_0x002d:
        r0 = r7.route;
        r0 = r0.address();
        r0 = r0.url();
        r0 = r0.host();
        r1 = okhttp3.internal.platform.Platform.get();
        r1 = r1.isCleartextTrafficPermitted(r0);
        if (r1 == 0) goto L_0x0046;
    L_0x0045:
        goto L_0x0074;
    L_0x0046:
        r1 = new okhttp3.internal.connection.RouteException;
        r2 = new java.net.UnknownServiceException;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "CLEARTEXT communication to ";
        r3.append(r4);
        r3.append(r0);
        r0 = " not permitted by network security policy";
        r3.append(r0);
        r0 = r3.toString();
        r2.<init>(r0);
        r1.<init>(r2);
        throw r1;
    L_0x0067:
        r0 = new okhttp3.internal.connection.RouteException;
        r1 = new java.net.UnknownServiceException;
        r2 = "CLEARTEXT communication not enabled for client";
        r1.<init>(r2);
        r0.<init>(r1);
        throw r0;
    L_0x0074:
        r11 = 0;
        r12 = r11;
    L_0x0076:
        r0 = r7.route;	 Catch:{ IOException -> 0x00e7 }
        r0 = r0.requiresTunnel();	 Catch:{ IOException -> 0x00e7 }
        if (r0 == 0) goto L_0x0097;
    L_0x007e:
        r1 = r16;
        r2 = r17;
        r3 = r18;
        r4 = r19;
        r5 = r22;
        r6 = r23;
        r1.connectTunnel(r2, r3, r4, r5, r6);	 Catch:{ IOException -> 0x00e7 }
        r0 = r7.rawSocket;	 Catch:{ IOException -> 0x00e7 }
        if (r0 != 0) goto L_0x0092;
    L_0x0091:
        goto L_0x00b4;
    L_0x0092:
        r13 = r17;
        r14 = r18;
        goto L_0x009e;
    L_0x0097:
        r13 = r17;
        r14 = r18;
        r7.connectSocket(r13, r14, r8, r9);	 Catch:{ IOException -> 0x00e5 }
    L_0x009e:
        r15 = r20;
        r7.establishProtocol(r10, r15, r8, r9);	 Catch:{ IOException -> 0x00e3 }
        r0 = r7.route;	 Catch:{ IOException -> 0x00e3 }
        r0 = r0.socketAddress();	 Catch:{ IOException -> 0x00e3 }
        r1 = r7.route;	 Catch:{ IOException -> 0x00e3 }
        r1 = r1.proxy();	 Catch:{ IOException -> 0x00e3 }
        r2 = r7.protocol;	 Catch:{ IOException -> 0x00e3 }
        r9.connectEnd(r8, r0, r1, r2);	 Catch:{ IOException -> 0x00e3 }
    L_0x00b4:
        r0 = r7.route;
        r0 = r0.requiresTunnel();
        if (r0 == 0) goto L_0x00ce;
    L_0x00bc:
        r0 = r7.rawSocket;
        if (r0 == 0) goto L_0x00c1;
    L_0x00c0:
        goto L_0x00ce;
    L_0x00c1:
        r0 = new java.net.ProtocolException;
        r1 = "Too many tunnel connections attempted: 21";
        r0.<init>(r1);
        r1 = new okhttp3.internal.connection.RouteException;
        r1.<init>(r0);
        throw r1;
    L_0x00ce:
        r0 = r7.http2Connection;
        if (r0 == 0) goto L_0x00e2;
    L_0x00d2:
        r1 = r7.connectionPool;
        monitor-enter(r1);
        r0 = r7.http2Connection;	 Catch:{ all -> 0x00df }
        r0 = r0.maxConcurrentStreams();	 Catch:{ all -> 0x00df }
        r7.allocationLimit = r0;	 Catch:{ all -> 0x00df }
        monitor-exit(r1);	 Catch:{ all -> 0x00df }
        goto L_0x00e2;
    L_0x00df:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x00df }
        throw r0;
    L_0x00e2:
        return;
    L_0x00e3:
        r0 = move-exception;
        goto L_0x00ee;
    L_0x00e5:
        r0 = move-exception;
        goto L_0x00ec;
    L_0x00e7:
        r0 = move-exception;
        r13 = r17;
        r14 = r18;
    L_0x00ec:
        r15 = r20;
    L_0x00ee:
        r1 = r7.socket;
        okhttp3.internal.Util.closeQuietly(r1);
        r1 = r7.rawSocket;
        okhttp3.internal.Util.closeQuietly(r1);
        r7.socket = r11;
        r7.rawSocket = r11;
        r7.source = r11;
        r7.sink = r11;
        r7.handshake = r11;
        r7.protocol = r11;
        r7.http2Connection = r11;
        r1 = r7.route;
        r3 = r1.socketAddress();
        r1 = r7.route;
        r4 = r1.proxy();
        r5 = 0;
        r1 = r23;
        r2 = r22;
        r6 = r0;
        r1.connectFailed(r2, r3, r4, r5, r6);
        if (r12 != 0) goto L_0x0124;
    L_0x011d:
        r1 = new okhttp3.internal.connection.RouteException;
        r1.<init>(r0);
        r12 = r1;
        goto L_0x0127;
    L_0x0124:
        r12.addConnectException(r0);
    L_0x0127:
        if (r21 == 0) goto L_0x0131;
    L_0x0129:
        r0 = r10.connectionFailed(r0);
        if (r0 == 0) goto L_0x0131;
    L_0x012f:
        goto L_0x0076;
    L_0x0131:
        throw r12;
    L_0x0132:
        r0 = new java.lang.IllegalStateException;
        r1 = "already connected";
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnection.connect(int, int, int, int, boolean, okhttp3.Call, okhttp3.EventListener):void");
    }

    private void connectTunnel(int i, int i2, int i3, Call call, EventListener eventListener) {
        Request createTunnelRequest = createTunnelRequest();
        HttpUrl url = createTunnelRequest.url();
        int i4 = 0;
        while (i4 < 21) {
            connectSocket(i, i2, call, eventListener);
            createTunnelRequest = createTunnel(i2, i3, createTunnelRequest, url);
            if (createTunnelRequest != null) {
                Util.closeQuietly(this.rawSocket);
                this.rawSocket = null;
                this.sink = null;
                this.source = null;
                eventListener.connectEnd(call, this.route.socketAddress(), this.route.proxy(), null);
                i4++;
            } else {
                return;
            }
        }
    }

    private void connectSocket(int i, int i2, Call call, EventListener eventListener) {
        Socket socket;
        Proxy proxy = this.route.proxy();
        Address address = this.route.address();
        if (proxy.type() != Type.DIRECT) {
            if (proxy.type() != Type.HTTP) {
                socket = new Socket(proxy);
                this.rawSocket = socket;
                eventListener.connectStart(call, this.route.socketAddress(), proxy);
                this.rawSocket.setSoTimeout(i2);
                Platform.get().connectSocket(this.rawSocket, this.route.socketAddress(), i);
                this.source = C5870l.m24720a(C5870l.m24730b(this.rawSocket));
                this.sink = C5870l.m24719a(C5870l.m24724a(this.rawSocket));
            }
        }
        socket = address.socketFactory().createSocket();
        this.rawSocket = socket;
        eventListener.connectStart(call, this.route.socketAddress(), proxy);
        this.rawSocket.setSoTimeout(i2);
        try {
            Platform.get().connectSocket(this.rawSocket, this.route.socketAddress(), i);
            try {
                this.source = C5870l.m24720a(C5870l.m24730b(this.rawSocket));
                this.sink = C5870l.m24719a(C5870l.m24724a(this.rawSocket));
            } catch (int i3) {
                if (NPE_THROW_WITH_NULL.equals(i3.getMessage()) != 0) {
                    throw new IOException(i3);
                }
            }
        } catch (int i32) {
            call = new StringBuilder();
            call.append("Failed to connect to ");
            call.append(this.route.socketAddress());
            i2 = new ConnectException(call.toString());
            i2.initCause(i32);
            throw i2;
        }
    }

    private void establishProtocol(ConnectionSpecSelector connectionSpecSelector, int i, Call call, EventListener eventListener) {
        if (this.route.address().sslSocketFactory() == null) {
            this.protocol = Protocol.HTTP_1_1;
            this.socket = this.rawSocket;
            return;
        }
        eventListener.secureConnectStart(call);
        connectTls(connectionSpecSelector);
        eventListener.secureConnectEnd(call, this.handshake);
        if (this.protocol == Protocol.HTTP_2) {
            this.socket.setSoTimeout(null);
            this.http2Connection = new Builder(true).socket(this.socket, this.route.address().url().host(), this.source, this.sink).listener(this).pingIntervalMillis(i).build();
            this.http2Connection.start();
        }
    }

    private void connectTls(ConnectionSpecSelector connectionSpecSelector) {
        Address address = this.route.address();
        String str = null;
        try {
            Socket socket = (SSLSocket) address.sslSocketFactory().createSocket(this.rawSocket, address.url().host(), address.url().port(), true);
            try {
                connectionSpecSelector = connectionSpecSelector.configureSecureSocket(socket);
                if (connectionSpecSelector.supportsTlsExtensions()) {
                    Platform.get().configureTlsExtensions(socket, address.url().host(), address.protocols());
                }
                socket.startHandshake();
                SSLSession session = socket.getSession();
                if (isValid(session)) {
                    Handshake handshake = Handshake.get(session);
                    if (address.hostnameVerifier().verify(address.url().host(), session)) {
                        address.certificatePinner().check(address.url().host(), handshake.peerCertificates());
                        if (connectionSpecSelector.supportsTlsExtensions() != null) {
                            str = Platform.get().getSelectedProtocol(socket);
                        }
                        this.socket = socket;
                        this.source = C5870l.m24720a(C5870l.m24730b(this.socket));
                        this.sink = C5870l.m24719a(C5870l.m24724a(this.socket));
                        this.handshake = handshake;
                        if (str != null) {
                            connectionSpecSelector = Protocol.get(str);
                        } else {
                            connectionSpecSelector = Protocol.HTTP_1_1;
                        }
                        this.protocol = connectionSpecSelector;
                        if (socket != null) {
                            Platform.get().afterHandshake(socket);
                            return;
                        }
                        return;
                    }
                    X509Certificate x509Certificate = (X509Certificate) handshake.peerCertificates().get(0);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Hostname ");
                    stringBuilder.append(address.url().host());
                    stringBuilder.append(" not verified:\n    certificate: ");
                    stringBuilder.append(CertificatePinner.pin(x509Certificate));
                    stringBuilder.append("\n    DN: ");
                    stringBuilder.append(x509Certificate.getSubjectDN().getName());
                    stringBuilder.append("\n    subjectAltNames: ");
                    stringBuilder.append(OkHostnameVerifier.allSubjectAltNames(x509Certificate));
                    throw new SSLPeerUnverifiedException(stringBuilder.toString());
                }
                throw new IOException("a valid ssl session was not established");
            } catch (AssertionError e) {
                connectionSpecSelector = e;
                str = socket;
                try {
                    if (Util.isAndroidGetsocknameError(connectionSpecSelector)) {
                        throw connectionSpecSelector;
                    }
                    throw new IOException(connectionSpecSelector);
                } catch (Throwable th) {
                    connectionSpecSelector = th;
                    socket = str;
                    if (socket != null) {
                        Platform.get().afterHandshake(socket);
                    }
                    Util.closeQuietly(socket);
                    throw connectionSpecSelector;
                }
            } catch (Throwable th2) {
                connectionSpecSelector = th2;
                if (socket != null) {
                    Platform.get().afterHandshake(socket);
                }
                Util.closeQuietly(socket);
                throw connectionSpecSelector;
            }
        } catch (AssertionError e2) {
            connectionSpecSelector = e2;
            if (Util.isAndroidGetsocknameError(connectionSpecSelector)) {
                throw connectionSpecSelector;
            }
            throw new IOException(connectionSpecSelector);
        }
    }

    private boolean isValid(SSLSession sSLSession) {
        return ("NONE".equals(sSLSession.getProtocol()) || "SSL_NULL_WITH_NULL_NULL".equals(sSLSession.getCipherSuite()) != null) ? null : true;
    }

    private Request createTunnel(int i, int i2, Request request, HttpUrl httpUrl) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CONNECT ");
        stringBuilder.append(Util.hostHeader(httpUrl, true));
        stringBuilder.append(" HTTP/1.1");
        httpUrl = stringBuilder.toString();
        while (true) {
            Http1Codec http1Codec = new Http1Codec(null, null, this.source, this.sink);
            this.source.timeout().timeout((long) i, TimeUnit.MILLISECONDS);
            this.sink.timeout().timeout((long) i2, TimeUnit.MILLISECONDS);
            http1Codec.writeRequest(request.headers(), httpUrl);
            http1Codec.finishRequest();
            Response build = http1Codec.readResponseHeaders(false).request(request).build();
            long contentLength = HttpHeaders.contentLength(build);
            if (contentLength == -1) {
                contentLength = 0;
            }
            C5876t newFixedLengthSource = http1Codec.newFixedLengthSource(contentLength);
            Util.skipAll(newFixedLengthSource, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            newFixedLengthSource.close();
            int code = build.code();
            if (code == HttpStatus.HTTP_OK) {
                break;
            } else if (code == 407) {
                Request authenticate = this.route.address().proxyAuthenticator().authenticate(this.route, build);
                if (authenticate == null) {
                    throw new IOException("Failed to authenticate with proxy");
                } else if ("close".equalsIgnoreCase(build.header("Connection")) != null) {
                    return authenticate;
                } else {
                    request = authenticate;
                }
            } else {
                i2 = new StringBuilder();
                i2.append("Unexpected response code for CONNECT: ");
                i2.append(build.code());
                throw new IOException(i2.toString());
            }
        }
        if (this.source.mo6292b().mo6300e() != 0 && this.sink.mo6292b().mo6300e() != 0) {
            return null;
        }
        throw new IOException("TLS tunnel buffered too many bytes!");
    }

    private Request createTunnelRequest() {
        return new Request.Builder().url(this.route.address().url()).header("Host", Util.hostHeader(this.route.address().url(), true)).header("Proxy-Connection", "Keep-Alive").header("User-Agent", Version.userAgent()).build();
    }

    public boolean isEligible(okhttp3.Address r5, okhttp3.Route r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.allocations;
        r0 = r0.size();
        r1 = r4.allocationLimit;
        r2 = 0;
        if (r0 >= r1) goto L_0x00a6;
    L_0x000b:
        r0 = r4.noNewStreams;
        if (r0 == 0) goto L_0x0011;
    L_0x000f:
        goto L_0x00a6;
    L_0x0011:
        r0 = okhttp3.internal.Internal.instance;
        r1 = r4.route;
        r1 = r1.address();
        r0 = r0.equalsNonHost(r1, r5);
        if (r0 != 0) goto L_0x0020;
    L_0x001f:
        return r2;
    L_0x0020:
        r0 = r5.url();
        r0 = r0.host();
        r1 = r4.route();
        r1 = r1.address();
        r1 = r1.url();
        r1 = r1.host();
        r0 = r0.equals(r1);
        r1 = 1;
        if (r0 == 0) goto L_0x0040;
    L_0x003f:
        return r1;
    L_0x0040:
        r0 = r4.http2Connection;
        if (r0 != 0) goto L_0x0045;
    L_0x0044:
        return r2;
    L_0x0045:
        if (r6 != 0) goto L_0x0048;
    L_0x0047:
        return r2;
    L_0x0048:
        r0 = r6.proxy();
        r0 = r0.type();
        r3 = java.net.Proxy.Type.DIRECT;
        if (r0 == r3) goto L_0x0055;
    L_0x0054:
        return r2;
    L_0x0055:
        r0 = r4.route;
        r0 = r0.proxy();
        r0 = r0.type();
        r3 = java.net.Proxy.Type.DIRECT;
        if (r0 == r3) goto L_0x0064;
    L_0x0063:
        return r2;
    L_0x0064:
        r0 = r4.route;
        r0 = r0.socketAddress();
        r3 = r6.socketAddress();
        r0 = r0.equals(r3);
        if (r0 != 0) goto L_0x0075;
    L_0x0074:
        return r2;
    L_0x0075:
        r6 = r6.address();
        r6 = r6.hostnameVerifier();
        r0 = okhttp3.internal.tls.OkHostnameVerifier.INSTANCE;
        if (r6 == r0) goto L_0x0082;
    L_0x0081:
        return r2;
    L_0x0082:
        r6 = r5.url();
        r6 = r4.supportsUrl(r6);
        if (r6 != 0) goto L_0x008d;
    L_0x008c:
        return r2;
    L_0x008d:
        r6 = r5.certificatePinner();	 Catch:{ SSLPeerUnverifiedException -> 0x00a5 }
        r5 = r5.url();	 Catch:{ SSLPeerUnverifiedException -> 0x00a5 }
        r5 = r5.host();	 Catch:{ SSLPeerUnverifiedException -> 0x00a5 }
        r0 = r4.handshake();	 Catch:{ SSLPeerUnverifiedException -> 0x00a5 }
        r0 = r0.peerCertificates();	 Catch:{ SSLPeerUnverifiedException -> 0x00a5 }
        r6.check(r5, r0);	 Catch:{ SSLPeerUnverifiedException -> 0x00a5 }
        return r1;
    L_0x00a5:
        return r2;
    L_0x00a6:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnection.isEligible(okhttp3.Address, okhttp3.Route):boolean");
    }

    public boolean supportsUrl(HttpUrl httpUrl) {
        if (httpUrl.port() != this.route.address().url().port()) {
            return false;
        }
        boolean z = true;
        if (httpUrl.host().equals(this.route.address().url().host())) {
            return true;
        }
        if (this.handshake == null || OkHostnameVerifier.INSTANCE.verify(httpUrl.host(), (X509Certificate) this.handshake.peerCertificates().get(0)) == null) {
            z = false;
        }
        return z;
    }

    public HttpCodec newCodec(OkHttpClient okHttpClient, Chain chain, StreamAllocation streamAllocation) {
        if (this.http2Connection != null) {
            return new Http2Codec(okHttpClient, chain, streamAllocation, this.http2Connection);
        }
        this.socket.setSoTimeout(chain.readTimeoutMillis());
        this.source.timeout().timeout((long) chain.readTimeoutMillis(), TimeUnit.MILLISECONDS);
        this.sink.timeout().timeout((long) chain.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
        return new Http1Codec(okHttpClient, streamAllocation, this.source, this.sink);
    }

    public Streams newWebSocketStreams(StreamAllocation streamAllocation) {
        final StreamAllocation streamAllocation2 = streamAllocation;
        return new Streams(true, this.source, this.sink) {
            public void close() {
                streamAllocation2.streamFinished(true, streamAllocation2.codec(), -1, null);
            }
        };
    }

    public Route route() {
        return this.route;
    }

    public void cancel() {
        Util.closeQuietly(this.rawSocket);
    }

    public Socket socket() {
        return this.socket;
    }

    public boolean isHealthy(boolean r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.socket;
        r0 = r0.isClosed();
        r1 = 0;
        if (r0 != 0) goto L_0x0051;
    L_0x0009:
        r0 = r4.socket;
        r0 = r0.isInputShutdown();
        if (r0 != 0) goto L_0x0051;
    L_0x0011:
        r0 = r4.socket;
        r0 = r0.isOutputShutdown();
        if (r0 == 0) goto L_0x001a;
    L_0x0019:
        goto L_0x0051;
    L_0x001a:
        r0 = r4.http2Connection;
        r2 = 1;
        if (r0 == 0) goto L_0x0027;
    L_0x001f:
        r5 = r4.http2Connection;
        r5 = r5.isShutdown();
        r5 = r5 ^ r2;
        return r5;
    L_0x0027:
        if (r5 == 0) goto L_0x0050;
    L_0x0029:
        r5 = r4.socket;	 Catch:{ SocketTimeoutException -> 0x0050, IOException -> 0x004f }
        r5 = r5.getSoTimeout();	 Catch:{ SocketTimeoutException -> 0x0050, IOException -> 0x004f }
        r0 = r4.socket;	 Catch:{ all -> 0x0048 }
        r0.setSoTimeout(r2);	 Catch:{ all -> 0x0048 }
        r0 = r4.source;	 Catch:{ all -> 0x0048 }
        r0 = r0.mo6300e();	 Catch:{ all -> 0x0048 }
        if (r0 == 0) goto L_0x0042;
    L_0x003c:
        r0 = r4.socket;	 Catch:{ SocketTimeoutException -> 0x0050, IOException -> 0x004f }
        r0.setSoTimeout(r5);	 Catch:{ SocketTimeoutException -> 0x0050, IOException -> 0x004f }
        return r1;	 Catch:{ SocketTimeoutException -> 0x0050, IOException -> 0x004f }
    L_0x0042:
        r0 = r4.socket;	 Catch:{ SocketTimeoutException -> 0x0050, IOException -> 0x004f }
        r0.setSoTimeout(r5);	 Catch:{ SocketTimeoutException -> 0x0050, IOException -> 0x004f }
        return r2;	 Catch:{ SocketTimeoutException -> 0x0050, IOException -> 0x004f }
    L_0x0048:
        r0 = move-exception;	 Catch:{ SocketTimeoutException -> 0x0050, IOException -> 0x004f }
        r3 = r4.socket;	 Catch:{ SocketTimeoutException -> 0x0050, IOException -> 0x004f }
        r3.setSoTimeout(r5);	 Catch:{ SocketTimeoutException -> 0x0050, IOException -> 0x004f }
        throw r0;	 Catch:{ SocketTimeoutException -> 0x0050, IOException -> 0x004f }
    L_0x004f:
        return r1;
    L_0x0050:
        return r2;
    L_0x0051:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnection.isHealthy(boolean):boolean");
    }

    public void onStream(Http2Stream http2Stream) {
        http2Stream.close(ErrorCode.REFUSED_STREAM);
    }

    public void onSettings(Http2Connection http2Connection) {
        synchronized (this.connectionPool) {
            this.allocationLimit = http2Connection.maxConcurrentStreams();
        }
    }

    public Handshake handshake() {
        return this.handshake;
    }

    public boolean isMultiplexed() {
        return this.http2Connection != null;
    }

    public Protocol protocol() {
        return this.protocol;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Connection{");
        stringBuilder.append(this.route.address().url().host());
        stringBuilder.append(":");
        stringBuilder.append(this.route.address().url().port());
        stringBuilder.append(", proxy=");
        stringBuilder.append(this.route.proxy());
        stringBuilder.append(" hostAddress=");
        stringBuilder.append(this.route.socketAddress());
        stringBuilder.append(" cipherSuite=");
        stringBuilder.append(this.handshake != null ? this.handshake.cipherSuite() : ViewProps.NONE);
        stringBuilder.append(" protocol=");
        stringBuilder.append(this.protocol);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
