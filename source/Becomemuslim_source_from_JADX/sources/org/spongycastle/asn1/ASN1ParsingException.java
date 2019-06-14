package org.spongycastle.asn1;

public class ASN1ParsingException extends IllegalStateException {
    /* renamed from: a */
    private Throwable f21440a;

    public ASN1ParsingException(String str) {
        super(str);
    }

    public ASN1ParsingException(String str, Throwable th) {
        super(str);
        this.f21440a = th;
    }

    public Throwable getCause() {
        return this.f21440a;
    }
}
