package org.spongycastle.jce.exception;

import java.security.cert.CertPath;
import java.security.cert.CertPathValidatorException;

public class ExtCertPathValidatorException extends CertPathValidatorException implements ExtException {
    /* renamed from: a */
    private Throwable f27547a;

    public ExtCertPathValidatorException(String str, Throwable th) {
        super(str);
        this.f27547a = th;
    }

    public ExtCertPathValidatorException(String str, Throwable th, CertPath certPath, int i) {
        super(str, th, certPath, i);
        this.f27547a = th;
    }

    public Throwable getCause() {
        return this.f27547a;
    }
}
