package org.spongycastle.asn1.ocsp;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.Extensions;

public class SingleResponse extends ASN1Object {
    /* renamed from: a */
    private CertID f30950a;
    /* renamed from: b */
    private CertStatus f30951b;
    /* renamed from: c */
    private ASN1GeneralizedTime f30952c;
    /* renamed from: d */
    private ASN1GeneralizedTime f30953d;
    /* renamed from: e */
    private Extensions f30954e;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30950a);
        aSN1EncodableVector.m27141a(this.f30951b);
        aSN1EncodableVector.m27141a(this.f30952c);
        if (this.f30953d != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 0, this.f30953d));
        }
        if (this.f30954e != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 1, this.f30954e));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
