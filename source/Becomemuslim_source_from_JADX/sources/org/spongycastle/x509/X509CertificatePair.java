package org.spongycastle.x509;

import java.security.cert.X509Certificate;
import org.spongycastle.asn1.x509.CertificatePair;
import org.spongycastle.jce.provider.X509CertificateObject;

public class X509CertificatePair {
    /* renamed from: a */
    private X509Certificate f23487a;
    /* renamed from: b */
    private X509Certificate f23488b;

    public X509CertificatePair(CertificatePair certificatePair) {
        if (certificatePair.m40296a() != null) {
            this.f23487a = new X509CertificateObject(certificatePair.m40296a());
        }
        if (certificatePair.m40297b() != null) {
            this.f23488b = new X509CertificateObject(certificatePair.m40297b());
        }
    }

    /* renamed from: a */
    public X509Certificate m29471a() {
        return this.f23487a;
    }

    /* renamed from: b */
    public X509Certificate m29472b() {
        return this.f23488b;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null || !(obj instanceof X509CertificatePair)) {
            return false;
        }
        X509CertificatePair x509CertificatePair = (X509CertificatePair) obj;
        boolean equals = this.f23487a != null ? this.f23487a.equals(x509CertificatePair.f23487a) : x509CertificatePair.f23487a == null;
        obj = this.f23488b != null ? this.f23488b.equals(x509CertificatePair.f23488b) : x509CertificatePair.f23488b != null ? null : true;
        if (equals && r5 != null) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        int i = -1;
        if (this.f23487a != null) {
            i = -1 ^ this.f23487a.hashCode();
        }
        return this.f23488b != null ? (i * 17) ^ this.f23488b.hashCode() : i;
    }
}
