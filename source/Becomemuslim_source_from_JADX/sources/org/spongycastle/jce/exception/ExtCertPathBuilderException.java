package org.spongycastle.jce.exception;

import java.security.cert.CertPathBuilderException;

public class ExtCertPathBuilderException extends CertPathBuilderException implements ExtException {
    /* renamed from: a */
    private Throwable f27546a;

    public ExtCertPathBuilderException(String str, Throwable th) {
        super(str);
        this.f27546a = th;
    }

    public Throwable getCause() {
        return this.f27546a;
    }
}
