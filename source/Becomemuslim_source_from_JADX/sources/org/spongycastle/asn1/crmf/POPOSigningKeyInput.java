package org.spongycastle.asn1.crmf;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;

public class POPOSigningKeyInput extends ASN1Object {
    /* renamed from: a */
    private GeneralName f30695a;
    /* renamed from: b */
    private PKMACValue f30696b;
    /* renamed from: c */
    private SubjectPublicKeyInfo f30697c;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.f30695a != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 0, this.f30695a));
        } else {
            aSN1EncodableVector.m27141a(this.f30696b);
        }
        aSN1EncodableVector.m27141a(this.f30697c);
        return new DERSequence(aSN1EncodableVector);
    }
}
