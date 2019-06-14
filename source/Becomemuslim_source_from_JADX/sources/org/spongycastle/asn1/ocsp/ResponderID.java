package org.spongycastle.asn1.ocsp;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERTaggedObject;

public class ResponderID extends ASN1Object implements ASN1Choice {
    /* renamed from: a */
    private ASN1Encodable f30933a;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        if (this.f30933a instanceof ASN1OctetString) {
            return new DERTaggedObject(true, 2, this.f30933a);
        }
        return new DERTaggedObject(true, 1, this.f30933a);
    }
}
