package org.spongycastle.jcajce.provider.asymmetric.util;

import java.security.spec.InvalidKeySpecException;

public class ExtendedInvalidKeySpecException extends InvalidKeySpecException {
    /* renamed from: a */
    private Throwable f22822a;

    public ExtendedInvalidKeySpecException(String str, Throwable th) {
        super(str);
        this.f22822a = th;
    }

    public Throwable getCause() {
        return this.f22822a;
    }
}
