package org.spongycastle.x509.util;

public class StreamParsingException extends Exception {
    /* renamed from: a */
    Throwable f23504a;

    public StreamParsingException(String str, Throwable th) {
        super(str);
        this.f23504a = th;
    }

    public Throwable getCause() {
        return this.f23504a;
    }
}
