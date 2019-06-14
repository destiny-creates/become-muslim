package org.spongycastle.asn1;

import java.io.IOException;

public class ASN1Exception extends IOException {
    /* renamed from: a */
    private Throwable f21435a;

    ASN1Exception(String str) {
        super(str);
    }

    ASN1Exception(String str, Throwable th) {
        super(str);
        this.f21435a = th;
    }

    public Throwable getCause() {
        return this.f21435a;
    }
}
