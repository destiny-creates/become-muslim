package expo.modules.appauth;

import android.annotation.SuppressLint;
import android.net.Uri;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import net.openid.appauth.C6605p;
import net.openid.appauth.p369b.C6575a;

public final class UnsafeConnectionBuilder implements C6575a {
    @SuppressLint({"TrustAllX509TrustManager"})
    private static final TrustManager[] ANY_CERT_MANAGER;
    @SuppressLint({"BadHostnameVerifier"})
    private static final HostnameVerifier ANY_HOSTNAME_VERIFIER = new C60622();
    private static final int CONNECTION_TIMEOUT_MS = ((int) TimeUnit.SECONDS.toMillis(15));
    private static final String HTTP = "http";
    private static final String HTTPS = "https";
    public static final UnsafeConnectionBuilder INSTANCE = new UnsafeConnectionBuilder();
    private static final int READ_TIMEOUT_MS = ((int) TimeUnit.SECONDS.toMillis(10));
    private static final String TAG = "ConnBuilder";
    private static final SSLContext TRUSTING_CONTEXT;

    /* renamed from: expo.modules.appauth.UnsafeConnectionBuilder$1 */
    static class C60611 implements X509TrustManager {
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        C60611() {
        }
    }

    /* renamed from: expo.modules.appauth.UnsafeConnectionBuilder$2 */
    static class C60622 implements HostnameVerifier {
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }

        C60622() {
        }
    }

    static {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new expo.modules.appauth.UnsafeConnectionBuilder;
        r0.<init>();
        INSTANCE = r0;
        r0 = java.util.concurrent.TimeUnit.SECONDS;
        r1 = 15;
        r0 = r0.toMillis(r1);
        r0 = (int) r0;
        CONNECTION_TIMEOUT_MS = r0;
        r0 = java.util.concurrent.TimeUnit.SECONDS;
        r1 = 10;
        r0 = r0.toMillis(r1);
        r0 = (int) r0;
        READ_TIMEOUT_MS = r0;
        r0 = 1;
        r0 = new javax.net.ssl.TrustManager[r0];
        r1 = new expo.modules.appauth.UnsafeConnectionBuilder$1;
        r1.<init>();
        r2 = 0;
        r0[r2] = r1;
        ANY_CERT_MANAGER = r0;
        r0 = new expo.modules.appauth.UnsafeConnectionBuilder$2;
        r0.<init>();
        ANY_HOSTNAME_VERIFIER = r0;
        r0 = 0;
        r1 = "SSL";	 Catch:{ NoSuchAlgorithmException -> 0x0039 }
        r1 = javax.net.ssl.SSLContext.getInstance(r1);	 Catch:{ NoSuchAlgorithmException -> 0x0039 }
        goto L_0x0041;
    L_0x0039:
        r1 = "ConnBuilder";
        r2 = "Unable to acquire SSL context";
        android.util.Log.e(r1, r2);
        r1 = r0;
    L_0x0041:
        if (r1 == 0) goto L_0x0056;
    L_0x0043:
        r2 = ANY_CERT_MANAGER;	 Catch:{ KeyManagementException -> 0x004f }
        r3 = new java.security.SecureRandom;	 Catch:{ KeyManagementException -> 0x004f }
        r3.<init>();	 Catch:{ KeyManagementException -> 0x004f }
        r1.init(r0, r2, r3);	 Catch:{ KeyManagementException -> 0x004f }
        r0 = r1;
        goto L_0x0056;
    L_0x004f:
        r1 = "ConnBuilder";
        r2 = "Failed to initialize trusting SSL context";
        android.util.Log.e(r1, r2);
    L_0x0056:
        TRUSTING_CONTEXT = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.appauth.UnsafeConnectionBuilder.<clinit>():void");
    }

    private UnsafeConnectionBuilder() {
    }

    public HttpURLConnection openConnection(Uri uri) {
        boolean z;
        HttpURLConnection httpURLConnection;
        HttpsURLConnection httpsURLConnection;
        C6605p.m26933a((Object) uri, (Object) "url must not be null");
        if (!"http".equals(uri.getScheme())) {
            if (!"https".equals(uri.getScheme())) {
                z = false;
                C6605p.m26935a(z, (Object) "scheme or uri must be http or https");
                httpURLConnection = (HttpURLConnection) new URL(uri.toString()).openConnection();
                httpURLConnection.setConnectTimeout(CONNECTION_TIMEOUT_MS);
                httpURLConnection.setReadTimeout(READ_TIMEOUT_MS);
                httpURLConnection.setInstanceFollowRedirects(false);
                if ((httpURLConnection instanceof HttpsURLConnection) && TRUSTING_CONTEXT != null) {
                    httpsURLConnection = (HttpsURLConnection) httpURLConnection;
                    httpsURLConnection.setSSLSocketFactory(TRUSTING_CONTEXT.getSocketFactory());
                    httpsURLConnection.setHostnameVerifier(ANY_HOSTNAME_VERIFIER);
                }
                return httpURLConnection;
            }
        }
        z = true;
        C6605p.m26935a(z, (Object) "scheme or uri must be http or https");
        httpURLConnection = (HttpURLConnection) new URL(uri.toString()).openConnection();
        httpURLConnection.setConnectTimeout(CONNECTION_TIMEOUT_MS);
        httpURLConnection.setReadTimeout(READ_TIMEOUT_MS);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpsURLConnection = (HttpsURLConnection) httpURLConnection;
        httpsURLConnection.setSSLSocketFactory(TRUSTING_CONTEXT.getSocketFactory());
        httpsURLConnection.setHostnameVerifier(ANY_HOSTNAME_VERIFIER);
        return httpURLConnection;
    }
}
