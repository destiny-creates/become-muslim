package org.spongycastle.util;

public class StoreException extends RuntimeException {
    /* renamed from: a */
    private Throwable f23434a;

    public StoreException(String str, Throwable th) {
        super(str);
        this.f23434a = th;
    }

    public Throwable getCause() {
        return this.f23434a;
    }
}
