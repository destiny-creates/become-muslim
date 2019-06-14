package org.spongycastle.asn1.crmf;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERTaggedObject;

public class POPOPrivKey extends ASN1Object implements ASN1Choice {
    /* renamed from: a */
    private int f30690a;
    /* renamed from: b */
    private ASN1Encodable f30691b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        return new DERTaggedObject(false, this.f30690a, this.f30691b);
    }
}
