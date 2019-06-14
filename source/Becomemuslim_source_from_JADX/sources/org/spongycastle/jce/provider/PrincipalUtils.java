package org.spongycastle.jce.provider;

import java.security.cert.TrustAnchor;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.x509.X509AttributeCertificate;

class PrincipalUtils {
    PrincipalUtils() {
    }

    /* renamed from: a */
    static X500Name m28242a(X509Certificate x509Certificate) {
        return X500Name.m40212a(x509Certificate.getSubjectX500Principal().getEncoded());
    }

    /* renamed from: a */
    static X500Name m28241a(X509CRL x509crl) {
        return X500Name.m40212a(x509crl.getIssuerX500Principal().getEncoded());
    }

    /* renamed from: b */
    static X500Name m28243b(X509Certificate x509Certificate) {
        return X500Name.m40212a(x509Certificate.getIssuerX500Principal().getEncoded());
    }

    /* renamed from: a */
    static X500Name m28240a(TrustAnchor trustAnchor) {
        return X500Name.m40212a(trustAnchor.getCA().getEncoded());
    }

    /* renamed from: a */
    static X500Name m28239a(Object obj) {
        if (obj instanceof X509Certificate) {
            return m28243b((X509Certificate) obj);
        }
        return X500Name.m40212a(((X500Principal) ((X509AttributeCertificate) obj).mo5947d().m36618a()[0]).getEncoded());
    }
}
