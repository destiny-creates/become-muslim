package okhttp3.internal.platform;

import java.security.Provider;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import org.conscrypt.Conscrypt;
import org.conscrypt.OpenSSLProvider;

public class ConscryptPlatform extends Platform {
    private ConscryptPlatform() {
    }

    private Provider getProvider() {
        return new OpenSSLProvider();
    }

    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        if (!Conscrypt.isConscrypt(sSLSocketFactory)) {
            return super.trustManager(sSLSocketFactory);
        }
        try {
            sSLSocketFactory = Platform.readFieldOrNull(sSLSocketFactory, Object.class, "sslParameters");
            return sSLSocketFactory != null ? (X509TrustManager) Platform.readFieldOrNull(sSLSocketFactory, X509TrustManager.class, "x509TrustManager") : null;
        } catch (SSLSocketFactory sSLSocketFactory2) {
            throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on Conscrypt", sSLSocketFactory2);
        }
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
        if (Conscrypt.isConscrypt(sSLSocket)) {
            if (str != null) {
                Conscrypt.setUseSessionTickets(sSLSocket, true);
                Conscrypt.setHostname(sSLSocket, str);
            }
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) Platform.alpnProtocolNames(list).toArray(new String[null]));
            return;
        }
        super.configureTlsExtensions(sSLSocket, str, list);
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        if (Conscrypt.isConscrypt(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return super.getSelectedProtocol(sSLSocket);
    }

    public SSLContext getSSLContext() {
        try {
            return SSLContext.getInstance("TLS", getProvider());
        } catch (Throwable e) {
            throw new IllegalStateException("No TLS provider", e);
        }
    }

    public static okhttp3.internal.platform.Platform buildIfSupported() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = "org.conscrypt.ConscryptEngineSocket";	 Catch:{ ClassNotFoundException -> 0x0017 }
        java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x0017 }
        r1 = org.conscrypt.Conscrypt.isAvailable();	 Catch:{ ClassNotFoundException -> 0x0017 }
        if (r1 != 0) goto L_0x000d;	 Catch:{ ClassNotFoundException -> 0x0017 }
    L_0x000c:
        return r0;	 Catch:{ ClassNotFoundException -> 0x0017 }
    L_0x000d:
        r1 = 1;	 Catch:{ ClassNotFoundException -> 0x0017 }
        org.conscrypt.Conscrypt.setUseEngineSocketByDefault(r1);	 Catch:{ ClassNotFoundException -> 0x0017 }
        r1 = new okhttp3.internal.platform.ConscryptPlatform;	 Catch:{ ClassNotFoundException -> 0x0017 }
        r1.<init>();	 Catch:{ ClassNotFoundException -> 0x0017 }
        return r1;
    L_0x0017:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.platform.ConscryptPlatform.buildIfSupported():okhttp3.internal.platform.Platform");
    }
}
