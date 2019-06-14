package org.spongycastle.jce.provider;

import org.spongycastle.jce.exception.ExtException;

public class AnnotatedException extends Exception implements ExtException {
    /* renamed from: a */
    private Throwable f27550a;

    public AnnotatedException(String str, Throwable th) {
        super(str);
        this.f27550a = th;
    }

    public AnnotatedException(String str) {
        this(str, null);
    }

    public Throwable getCause() {
        return this.f27550a;
    }
}
