package org.spongycastle.jce.exception;

import java.io.IOException;

public class ExtIOException extends IOException implements ExtException {
    /* renamed from: a */
    private Throwable f27549a;

    public Throwable getCause() {
        return this.f27549a;
    }
}
