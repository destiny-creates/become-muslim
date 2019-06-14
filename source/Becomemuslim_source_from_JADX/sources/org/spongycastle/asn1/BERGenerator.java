package org.spongycastle.asn1;

public class BERGenerator extends ASN1Generator {
    /* renamed from: b */
    private boolean f26450b;
    /* renamed from: c */
    private boolean f26451c;

    /* renamed from: a */
    protected void m34601a() {
        this.a.write(0);
        this.a.write(0);
        if (this.f26450b && this.f26451c) {
            this.a.write(0);
            this.a.write(0);
        }
    }
}
