package org.spongycastle.util.encoders;

public class DecoderException extends IllegalStateException {
    /* renamed from: a */
    private Throwable f23438a;

    DecoderException(String str, Throwable th) {
        super(str);
        this.f23438a = th;
    }

    public Throwable getCause() {
        return this.f23438a;
    }
}
