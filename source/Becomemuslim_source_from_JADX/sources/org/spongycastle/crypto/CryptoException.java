package org.spongycastle.crypto;

public class CryptoException extends Exception {
    /* renamed from: a */
    private Throwable f22199a;

    public CryptoException(String str) {
        super(str);
    }

    public CryptoException(String str, Throwable th) {
        super(str);
        this.f22199a = th;
    }

    public Throwable getCause() {
        return this.f22199a;
    }
}
