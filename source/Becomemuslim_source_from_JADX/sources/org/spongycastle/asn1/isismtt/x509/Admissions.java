package org.spongycastle.asn1.isismtt.x509;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.GeneralName;

public class Admissions extends ASN1Object {
    /* renamed from: a */
    private GeneralName f30868a;
    /* renamed from: b */
    private NamingAuthority f30869b;
    /* renamed from: c */
    private ASN1Sequence f30870c;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.f30868a != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 0, this.f30868a));
        }
        if (this.f30869b != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 1, this.f30869b));
        }
        aSN1EncodableVector.m27141a(this.f30870c);
        return new DERSequence(aSN1EncodableVector);
    }
}
