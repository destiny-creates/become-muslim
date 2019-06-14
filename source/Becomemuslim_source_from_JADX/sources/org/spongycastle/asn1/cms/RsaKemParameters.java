package org.spongycastle.asn1.cms;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class RsaKemParameters extends ASN1Object {
    /* renamed from: a */
    private final AlgorithmIdentifier f30622a;
    /* renamed from: b */
    private final BigInteger f30623b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30622a);
        aSN1EncodableVector.m27141a(new ASN1Integer(this.f30623b));
        return new DERSequence(aSN1EncodableVector);
    }
}
