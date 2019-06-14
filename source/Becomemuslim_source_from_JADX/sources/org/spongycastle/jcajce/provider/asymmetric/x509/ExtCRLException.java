package org.spongycastle.jcajce.provider.asymmetric.x509;

import java.security.cert.CRLException;

class ExtCRLException extends CRLException {
    /* renamed from: a */
    Throwable f22834a;

    ExtCRLException(String str, Throwable th) {
        super(str);
        this.f22834a = th;
    }

    public Throwable getCause() {
        return this.f22834a;
    }
}
