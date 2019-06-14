package org.spongycastle.asn1;

import java.util.Vector;

public class ASN1EncodableVector {
    /* renamed from: a */
    private final Vector f21434a = new Vector();

    /* renamed from: a */
    public void m27141a(ASN1Encodable aSN1Encodable) {
        this.f21434a.addElement(aSN1Encodable);
    }

    /* renamed from: a */
    public ASN1Encodable m27140a(int i) {
        return (ASN1Encodable) this.f21434a.elementAt(i);
    }

    /* renamed from: a */
    public int m27139a() {
        return this.f21434a.size();
    }
}
