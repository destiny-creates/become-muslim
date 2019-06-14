package org.spongycastle.jce.provider;

import java.security.cert.CRLException;

class ExtCRLException extends CRLException {
    /* renamed from: a */
    Throwable f22971a;

    ExtCRLException(String str, Throwable th) {
        super(str);
        this.f22971a = th;
    }

    public Throwable getCause() {
        return this.f22971a;
    }
}
