package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.crmf.EncryptedValue;
import org.spongycastle.asn1.crmf.PKIPublicationInfo;

public class CertifiedKeyPair extends ASN1Object {
    /* renamed from: a */
    private CertOrEncCert f30451a;
    /* renamed from: b */
    private EncryptedValue f30452b;
    /* renamed from: c */
    private PKIPublicationInfo f30453c;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30451a);
        if (this.f30452b != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 0, this.f30452b));
        }
        if (this.f30453c != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 1, this.f30453c));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
