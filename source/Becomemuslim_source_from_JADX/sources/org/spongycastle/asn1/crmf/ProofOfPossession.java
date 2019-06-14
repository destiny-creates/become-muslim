package org.spongycastle.asn1.crmf;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DERTaggedObject;

public class ProofOfPossession extends ASN1Object implements ASN1Choice {
    /* renamed from: a */
    private int f30698a = 0;
    /* renamed from: b */
    private ASN1Encodable f30699b = DERNull.f32850a;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        return new DERTaggedObject(false, this.f30698a, this.f30699b);
    }
}
