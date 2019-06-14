package org.spongycastle.asn1.x509;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class RSAPublicKeyStructure extends ASN1Object {
    /* renamed from: a */
    private BigInteger f31372a;
    /* renamed from: b */
    private BigInteger f31373b;

    /* renamed from: a */
    public BigInteger m40400a() {
        return this.f31372a;
    }

    /* renamed from: b */
    public BigInteger m40401b() {
        return this.f31373b;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(new ASN1Integer(m40400a()));
        aSN1EncodableVector.m27141a(new ASN1Integer(m40401b()));
        return new DERSequence(aSN1EncodableVector);
    }
}
