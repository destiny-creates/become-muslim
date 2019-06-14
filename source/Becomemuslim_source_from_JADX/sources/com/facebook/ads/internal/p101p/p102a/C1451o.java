package com.facebook.ads.internal.p101p.p102a;

import android.os.Build.VERSION;
import android.util.Base64;
import java.security.MessageDigest;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;

/* renamed from: com.facebook.ads.internal.p.a.o */
public class C1451o {
    /* renamed from: a */
    private static String m5138a(byte[] bArr, String str) {
        MessageDigest instance = MessageDigest.getInstance(str);
        instance.reset();
        return Base64.encodeToString(instance.digest(bArr), 0);
    }

    /* renamed from: a */
    public static void m5139a(HttpsURLConnection httpsURLConnection, Set<String> set, Set<String> set2) {
        if (VERSION.SDK_INT != 15 || !"4.0.3".equals(VERSION.RELEASE)) {
            try {
                Certificate[] serverCertificates = httpsURLConnection.getServerCertificates();
                int length = serverCertificates.length;
                int i = 0;
                while (i < length) {
                    X509Certificate x509Certificate = (X509Certificate) serverCertificates[i];
                    String a = C1451o.m5138a(x509Certificate.getEncoded(), "SHA-1");
                    if (set == null || !set.contains(a)) {
                        String a2 = C1451o.m5138a(x509Certificate.getPublicKey().getEncoded(), "SHA-1");
                        if (set2 == null || !set2.contains(a2)) {
                            i++;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                throw new CertificateException("Unable to find valid certificate or public key.");
            } catch (Exception e) {
                throw e;
            }
        }
    }
}
