package org.spongycastle.x509;

import java.security.cert.Certificate;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import org.spongycastle.util.Selector;

public class X509CertStoreSelector extends X509CertSelector implements Selector {
    /* renamed from: a */
    public boolean mo5847a(Object obj) {
        if (obj instanceof X509Certificate) {
            return super.match((X509Certificate) obj);
        }
        return null;
    }

    public boolean match(Certificate certificate) {
        return mo5847a((Object) certificate);
    }

    public Object clone() {
        return (X509CertStoreSelector) super.clone();
    }

    /* renamed from: a */
    public static X509CertStoreSelector m36639a(X509CertSelector x509CertSelector) {
        if (x509CertSelector != null) {
            X509CertStoreSelector x509CertStoreSelector = new X509CertStoreSelector();
            x509CertStoreSelector.setAuthorityKeyIdentifier(x509CertSelector.getAuthorityKeyIdentifier());
            x509CertStoreSelector.setBasicConstraints(x509CertSelector.getBasicConstraints());
            x509CertStoreSelector.setCertificate(x509CertSelector.getCertificate());
            x509CertStoreSelector.setCertificateValid(x509CertSelector.getCertificateValid());
            x509CertStoreSelector.setMatchAllSubjectAltNames(x509CertSelector.getMatchAllSubjectAltNames());
            try {
                x509CertStoreSelector.setPathToNames(x509CertSelector.getPathToNames());
                x509CertStoreSelector.setExtendedKeyUsage(x509CertSelector.getExtendedKeyUsage());
                x509CertStoreSelector.setNameConstraints(x509CertSelector.getNameConstraints());
                x509CertStoreSelector.setPolicy(x509CertSelector.getPolicy());
                x509CertStoreSelector.setSubjectPublicKeyAlgID(x509CertSelector.getSubjectPublicKeyAlgID());
                x509CertStoreSelector.setSubjectAlternativeNames(x509CertSelector.getSubjectAlternativeNames());
                x509CertStoreSelector.setIssuer(x509CertSelector.getIssuer());
                x509CertStoreSelector.setKeyUsage(x509CertSelector.getKeyUsage());
                x509CertStoreSelector.setPrivateKeyValid(x509CertSelector.getPrivateKeyValid());
                x509CertStoreSelector.setSerialNumber(x509CertSelector.getSerialNumber());
                x509CertStoreSelector.setSubject(x509CertSelector.getSubject());
                x509CertStoreSelector.setSubjectKeyIdentifier(x509CertSelector.getSubjectKeyIdentifier());
                x509CertStoreSelector.setSubjectPublicKey(x509CertSelector.getSubjectPublicKey());
                return x509CertStoreSelector;
            } catch (X509CertSelector x509CertSelector2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("error in passed in selector: ");
                stringBuilder.append(x509CertSelector2);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        throw new IllegalArgumentException("cannot create from null selector");
    }
}
