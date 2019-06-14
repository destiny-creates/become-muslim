package org.spongycastle.util.encoders;

public class EncoderException extends IllegalStateException {
    /* renamed from: a */
    private Throwable f23439a;

    EncoderException(String str, Throwable th) {
        super(str);
        this.f23439a = th;
    }

    public Throwable getCause() {
        return this.f23439a;
    }
}
