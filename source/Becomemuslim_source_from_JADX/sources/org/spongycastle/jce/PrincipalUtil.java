package org.spongycastle.jce;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.x509.TBSCertificateStructure;
import org.spongycastle.asn1.x509.X509Name;

public class PrincipalUtil {
    /* renamed from: a */
    public static X509Principal m28123a(X509Certificate x509Certificate) {
        try {
            return new X509Principal(X509Name.m40471a(TBSCertificateStructure.m40443a(ASN1Primitive.m39798b(x509Certificate.getTBSCertificate())).m40444a()));
        } catch (X509Certificate x509Certificate2) {
            throw new CertificateEncodingException(x509Certificate2.toString());
        }
    }

    /* renamed from: b */
    public static X509Principal m28124b(X509Certificate x509Certificate) {
        try {
            return new X509Principal(X509Name.m40471a(TBSCertificateStructure.m40443a(ASN1Primitive.m39798b(x509Certificate.getTBSCertificate())).m40445b()));
        } catch (X509Certificate x509Certificate2) {
            throw new CertificateEncodingException(x509Certificate2.toString());
        }
    }
}
