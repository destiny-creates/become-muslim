package org.spongycastle.asn1.crmf;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;

public class EncKeyWithID extends ASN1Object {
    /* renamed from: a */
    private final PrivateKeyInfo f30673a;
    /* renamed from: b */
    private final ASN1Encodable f30674b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30673a);
        if (this.f30674b != null) {
            aSN1EncodableVector.m27141a(this.f30674b);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
