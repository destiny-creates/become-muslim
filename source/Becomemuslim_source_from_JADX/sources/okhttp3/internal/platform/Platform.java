package okhttp3.internal.platform;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.internal.tls.BasicCertificateChainCleaner;
import okhttp3.internal.tls.BasicTrustRootIndex;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;
import p286d.C8037c;

public class Platform {
    public static final int INFO = 4;
    private static final Platform PLATFORM = findPlatform();
    public static final int WARN = 5;
    private static final Logger logger = Logger.getLogger(OkHttpClient.class.getName());

    public void afterHandshake(SSLSocket sSLSocket) {
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
    }

    public String getPrefix() {
        return "OkHttp";
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        return null;
    }

    public boolean isCleartextTrafficPermitted(String str) {
        return true;
    }

    public static Platform get() {
        return PLATFORM;
    }

    protected javax.net.ssl.X509TrustManager trustManager(javax.net.ssl.SSLSocketFactory r4) {
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
        r4 = readFieldOrNull(r4, r1, r2);	 Catch:{ ClassNotFoundException -> 0x001b }
        if (r4 != 0) goto L_0x0010;	 Catch:{ ClassNotFoundException -> 0x001b }
    L_0x000f:
        return r0;	 Catch:{ ClassNotFoundException -> 0x001b }
    L_0x0010:
        r1 = javax.net.ssl.X509TrustManager.class;	 Catch:{ ClassNotFoundException -> 0x001b }
        r2 = "trustManager";	 Catch:{ ClassNotFoundException -> 0x001b }
        r4 = readFieldOrNull(r4, r1, r2);	 Catch:{ ClassNotFoundException -> 0x001b }
        r4 = (javax.net.ssl.X509TrustManager) r4;	 Catch:{ ClassNotFoundException -> 0x001b }
        return r4;
    L_0x001b:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.platform.Platform.trustManager(javax.net.ssl.SSLSocketFactory):javax.net.ssl.X509TrustManager");
    }

    public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i) {
        socket.connect(inetSocketAddress, i);
    }

    public void log(int i, String str, Throwable th) {
        logger.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public Object getStackTraceForCloseable(String str) {
        return logger.isLoggable(Level.FINE) ? new Throwable(str) : null;
    }

    public void logCloseableLeak(String str, Object obj) {
        if (obj == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
            str = stringBuilder.toString();
        }
        log(5, str, (Throwable) obj);
    }

    public static List<String> alpnProtocolNames(List<Protocol> list) {
        List<String> arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = (Protocol) list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                arrayList.add(protocol.toString());
            }
        }
        return arrayList;
    }

    public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager x509TrustManager) {
        return new BasicCertificateChainCleaner(buildTrustRootIndex(x509TrustManager));
    }

    public CertificateChainCleaner buildCertificateChainCleaner(SSLSocketFactory sSLSocketFactory) {
        X509TrustManager trustManager = trustManager(sSLSocketFactory);
        if (trustManager != null) {
            return buildCertificateChainCleaner(trustManager);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to extract the trust manager on ");
        stringBuilder.append(get());
        stringBuilder.append(", sslSocketFactory is ");
        stringBuilder.append(sSLSocketFactory.getClass());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public static boolean isConscryptPreferred() {
        if ("conscrypt".equals(System.getProperty("okhttp.platform"))) {
            return true;
        }
        return "Conscrypt".equals(Security.getProviders()[0].getName());
    }

    private static Platform findPlatform() {
        Platform buildIfSupported = AndroidPlatform.buildIfSupported();
        if (buildIfSupported != null) {
            return buildIfSupported;
        }
        if (isConscryptPreferred()) {
            buildIfSupported = ConscryptPlatform.buildIfSupported();
            if (buildIfSupported != null) {
                return buildIfSupported;
            }
        }
        buildIfSupported = Jdk9Platform.buildIfSupported();
        if (buildIfSupported != null) {
            return buildIfSupported;
        }
        buildIfSupported = JdkWithJettyBootPlatform.buildIfSupported();
        if (buildIfSupported != null) {
            return buildIfSupported;
        }
        return new Platform();
    }

    static byte[] concatLengthPrefixed(List<Protocol> list) {
        C8037c c8037c = new C8037c();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = (Protocol) list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                c8037c.m38981b(protocol.toString().length());
                c8037c.m38969a(protocol.toString());
            }
        }
        return c8037c.mo6319s();
    }

    static <T> T readFieldOrNull(java.lang.Object r4, java.lang.Class<T> r5, java.lang.String r6) {
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
        r4 = readFieldOrNull(r4, r0, r1);
        if (r4 == 0) goto L_0x0046;
    L_0x0041:
        r4 = readFieldOrNull(r4, r5, r6);
        return r4;
    L_0x0046:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.platform.Platform.readFieldOrNull(java.lang.Object, java.lang.Class, java.lang.String):T");
    }

    public SSLContext getSSLContext() {
        try {
            return SSLContext.getInstance("TLS");
        } catch (Throwable e) {
            throw new IllegalStateException("No TLS provider", e);
        }
    }

    public TrustRootIndex buildTrustRootIndex(X509TrustManager x509TrustManager) {
        return new BasicTrustRootIndex(x509TrustManager.getAcceptedIssuers());
    }
}
