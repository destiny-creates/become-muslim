package org.spongycastle.asn1.esf;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.Attribute;
import org.spongycastle.asn1.x509.AttributeCertificate;

public class SignerAttribute extends ASN1Object {
    /* renamed from: a */
    private Object[] f30829a;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        for (int i = 0; i != this.f30829a.length; i++) {
            if (this.f30829a[i] instanceof Attribute[]) {
                aSN1EncodableVector.m27141a(new DERTaggedObject(0, new DERSequence((Attribute[]) this.f30829a[i])));
            } else {
                aSN1EncodableVector.m27141a(new DERTaggedObject(1, (AttributeCertificate) this.f30829a[i]));
            }
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
