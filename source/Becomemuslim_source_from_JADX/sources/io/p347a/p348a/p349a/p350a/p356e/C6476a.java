package io.p347a.p348a.p349a.p350a.p356e;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.LinkedList;

/* compiled from: CertificateChainCleaner */
/* renamed from: io.a.a.a.a.e.a */
final class C6476a {
    /* renamed from: a */
    public static X509Certificate[] m26522a(X509Certificate[] x509CertificateArr, C6488i c6488i) {
        LinkedList linkedList = new LinkedList();
        boolean a = c6488i.m26597a(x509CertificateArr[0]);
        linkedList.add(x509CertificateArr[0]);
        int i = 1;
        boolean z = a;
        int i2 = 1;
        while (i2 < x509CertificateArr.length) {
            if (c6488i.m26597a(x509CertificateArr[i2])) {
                z = true;
            }
            if (!C6476a.m26521a(x509CertificateArr[i2], x509CertificateArr[i2 - 1])) {
                break;
            }
            linkedList.add(x509CertificateArr[i2]);
            i2++;
        }
        x509CertificateArr = c6488i.m26598b(x509CertificateArr[i2 - 1]);
        if (x509CertificateArr != null) {
            linkedList.add(x509CertificateArr);
        } else {
            i = z;
        }
        if (i != 0) {
            return (X509Certificate[]) linkedList.toArray(new X509Certificate[linkedList.size()]);
        }
        throw new CertificateException("Didn't find a trust anchor in chain cleanup!");
    }

    /* renamed from: a */
    private static boolean m26521a(java.security.cert.X509Certificate r2, java.security.cert.X509Certificate r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r2.getSubjectX500Principal();
        r1 = r3.getIssuerX500Principal();
        r0 = r0.equals(r1);
        r1 = 0;
        if (r0 != 0) goto L_0x0010;
    L_0x000f:
        return r1;
    L_0x0010:
        r2 = r2.getPublicKey();	 Catch:{ GeneralSecurityException -> 0x0019 }
        r3.verify(r2);	 Catch:{ GeneralSecurityException -> 0x0019 }
        r2 = 1;
        return r2;
    L_0x0019:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.a.a.a.a.e.a.a(java.security.cert.X509Certificate, java.security.cert.X509Certificate):boolean");
    }
}
