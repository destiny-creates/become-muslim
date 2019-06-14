package org.spongycastle.jce.exception;

import java.security.cert.CertificateEncodingException;

public class ExtCertificateEncodingException extends CertificateEncodingException implements ExtException {
    /* renamed from: a */
    private Throwable f27548a;

    public Throwable getCause() {
        return this.f27548a;
    }
}
