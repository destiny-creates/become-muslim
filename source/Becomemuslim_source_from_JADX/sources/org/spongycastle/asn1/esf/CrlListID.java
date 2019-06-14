package org.spongycastle.asn1.esf;

import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class CrlListID extends ASN1Object {
    /* renamed from: a */
    private ASN1Sequence f30797a;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        return new DERSequence(this.f30797a);
    }
}
