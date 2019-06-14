package org.spongycastle.x509;

import java.security.cert.CertificateEncodingException;

class ExtCertificateEncodingException extends CertificateEncodingException {
    /* renamed from: a */
    Throwable f23476a;

    public Throwable getCause() {
        return this.f23476a;
    }
}
