package io.p347a.p348a.p349a.p350a.p356e;

import io.p347a.p348a.p349a.C6514c;
import java.security.MessageDigest;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: PinningTrustManager */
/* renamed from: io.a.a.a.a.e.h */
class C6487h implements X509TrustManager {
    /* renamed from: a */
    private final TrustManager[] f20898a;
    /* renamed from: b */
    private final C6488i f20899b;
    /* renamed from: c */
    private final long f20900c;
    /* renamed from: d */
    private final List<byte[]> f20901d = new LinkedList();
    /* renamed from: e */
    private final Set<X509Certificate> f20902e = Collections.synchronizedSet(new HashSet());

    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }

    public C6487h(C6488i c6488i, C6486g c6486g) {
        this.f20898a = m26594a(c6488i);
        this.f20899b = c6488i;
        this.f20900c = c6486g.m26589d();
        for (String a : c6486g.m26588c()) {
            this.f20901d.add(m26593a(a));
        }
    }

    /* renamed from: a */
    private TrustManager[] m26594a(C6488i c6488i) {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance("X509");
            instance.init(c6488i.f20903a);
            return instance.getTrustManagers();
        } catch (C6488i c6488i2) {
            throw new AssertionError(c6488i2);
        } catch (C6488i c6488i22) {
            throw new AssertionError(c6488i22);
        }
    }

    /* renamed from: a */
    private boolean m26592a(X509Certificate x509Certificate) {
        try {
            x509Certificate = MessageDigest.getInstance("SHA1").digest(x509Certificate.getPublicKey().getEncoded());
            for (byte[] equals : this.f20901d) {
                if (Arrays.equals(equals, x509Certificate)) {
                    return true;
                }
            }
            return null;
        } catch (X509Certificate x509Certificate2) {
            throw new CertificateException(x509Certificate2);
        }
    }

    /* renamed from: a */
    private void m26591a(X509Certificate[] x509CertificateArr, String str) {
        for (TrustManager trustManager : this.f20898a) {
            ((X509TrustManager) trustManager).checkServerTrusted(x509CertificateArr, str);
        }
    }

    /* renamed from: a */
    private void m26590a(X509Certificate[] x509CertificateArr) {
        if (this.f20900c == -1 || System.currentTimeMillis() - this.f20900c <= 15552000000L) {
            x509CertificateArr = C6476a.m26522a(x509CertificateArr, this.f20899b);
            int length = x509CertificateArr.length;
            int i = 0;
            while (i < length) {
                if (!m26592a(x509CertificateArr[i])) {
                    i++;
                } else {
                    return;
                }
            }
            throw new CertificateException("No valid pins found in chain!");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Certificate pins are stale, (");
        stringBuilder.append(System.currentTimeMillis() - this.f20900c);
        stringBuilder.append(" millis vs ");
        stringBuilder.append(15552000000L);
        stringBuilder.append(" millis) ");
        stringBuilder.append("falling back to system trust.");
        C6514c.m26634h().mo5477d("Fabric", stringBuilder.toString());
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        throw new CertificateException("Client certificates not supported!");
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        if (!this.f20902e.contains(x509CertificateArr[0])) {
            m26591a(x509CertificateArr, str);
            m26590a(x509CertificateArr);
            this.f20902e.add(x509CertificateArr[0]);
        }
    }

    /* renamed from: a */
    private byte[] m26593a(String str) {
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }
}
