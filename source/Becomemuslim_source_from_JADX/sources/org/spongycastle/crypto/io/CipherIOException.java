package org.spongycastle.crypto.io;

import java.io.IOException;

public class CipherIOException extends IOException {
    private static final long serialVersionUID = 1;
    /* renamed from: a */
    private final Throwable f22381a;

    public CipherIOException(String str, Throwable th) {
        super(str);
        this.f22381a = th;
    }

    public Throwable getCause() {
        return this.f22381a;
    }
}
