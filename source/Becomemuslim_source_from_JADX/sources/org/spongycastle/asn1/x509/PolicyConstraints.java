package org.spongycastle.asn1.x509;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class PolicyConstraints extends ASN1Object {
    /* renamed from: a */
    private BigInteger f31363a;
    /* renamed from: b */
    private BigInteger f31364b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.f31363a != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(0, new ASN1Integer(this.f31363a)));
        }
        if (this.f31364b != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(1, new ASN1Integer(this.f31364b)));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
