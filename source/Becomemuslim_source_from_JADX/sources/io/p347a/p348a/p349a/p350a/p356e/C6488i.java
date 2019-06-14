package io.p347a.p348a.p349a.p350a.p356e;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.Principal;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.HashMap;

/* compiled from: SystemKeyStore */
/* renamed from: io.a.a.a.a.e.i */
class C6488i {
    /* renamed from: a */
    final KeyStore f20903a;
    /* renamed from: b */
    private final HashMap<Principal, X509Certificate> f20904b;

    public C6488i(InputStream inputStream, String str) {
        KeyStore a = m26595a(inputStream, str);
        this.f20904b = m26596a(a);
        this.f20903a = a;
    }

    /* renamed from: a */
    public boolean m26597a(X509Certificate x509Certificate) {
        X509Certificate x509Certificate2 = (X509Certificate) this.f20904b.get(x509Certificate.getSubjectX500Principal());
        return (x509Certificate2 == null || x509Certificate2.getPublicKey().equals(x509Certificate.getPublicKey()) == null) ? null : true;
    }

    /* renamed from: b */
    public java.security.cert.X509Certificate m26598b(java.security.cert.X509Certificate r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.f20904b;
        r1 = r5.getIssuerX500Principal();
        r0 = r0.get(r1);
        r0 = (java.security.cert.X509Certificate) r0;
        r1 = 0;
        if (r0 != 0) goto L_0x0010;
    L_0x000f:
        return r1;
    L_0x0010:
        r2 = r0.getSubjectX500Principal();
        r3 = r5.getSubjectX500Principal();
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x001f;
    L_0x001e:
        return r1;
    L_0x001f:
        r2 = r0.getPublicKey();	 Catch:{ GeneralSecurityException -> 0x0027 }
        r5.verify(r2);	 Catch:{ GeneralSecurityException -> 0x0027 }
        return r0;
    L_0x0027:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.a.a.a.a.e.i.b(java.security.cert.X509Certificate):java.security.cert.X509Certificate");
    }

    /* renamed from: a */
    private HashMap<Principal, X509Certificate> m26596a(KeyStore keyStore) {
        try {
            HashMap<Principal, X509Certificate> hashMap = new HashMap();
            Enumeration aliases = keyStore.aliases();
            while (aliases.hasMoreElements()) {
                X509Certificate x509Certificate = (X509Certificate) keyStore.getCertificate((String) aliases.nextElement());
                if (x509Certificate != null) {
                    hashMap.put(x509Certificate.getSubjectX500Principal(), x509Certificate);
                }
            }
            return hashMap;
        } catch (KeyStore keyStore2) {
            throw new AssertionError(keyStore2);
        }
    }

    /* renamed from: a */
    private KeyStore m26595a(InputStream inputStream, String str) {
        InputStream bufferedInputStream;
        try {
            KeyStore instance = KeyStore.getInstance("BKS");
            bufferedInputStream = new BufferedInputStream(inputStream);
            instance.load(bufferedInputStream, str.toCharArray());
            bufferedInputStream.close();
            return instance;
        } catch (InputStream inputStream2) {
            throw new AssertionError(inputStream2);
        } catch (InputStream inputStream22) {
            throw new AssertionError(inputStream22);
        } catch (InputStream inputStream222) {
            throw new AssertionError(inputStream222);
        } catch (InputStream inputStream2222) {
            throw new AssertionError(inputStream2222);
        } catch (Throwable th) {
            bufferedInputStream.close();
        }
    }
}
