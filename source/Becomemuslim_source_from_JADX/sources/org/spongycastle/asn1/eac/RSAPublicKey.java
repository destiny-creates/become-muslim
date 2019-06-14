package org.spongycastle.asn1.eac;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class RSAPublicKey extends PublicKeyDataObject {
    /* renamed from: d */
    private static int f32524d = 1;
    /* renamed from: e */
    private static int f32525e = 2;
    /* renamed from: a */
    private ASN1ObjectIdentifier f32526a;
    /* renamed from: b */
    private BigInteger f32527b;
    /* renamed from: c */
    private BigInteger f32528c;

    /* renamed from: a */
    public BigInteger m43133a() {
        return this.f32527b;
    }

    /* renamed from: b */
    public BigInteger m43134b() {
        return this.f32528c;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f32526a);
        aSN1EncodableVector.m27141a(new UnsignedInteger(1, m43133a()));
        aSN1EncodableVector.m27141a(new UnsignedInteger(2, m43134b()));
        return new DERSequence(aSN1EncodableVector);
    }
}
