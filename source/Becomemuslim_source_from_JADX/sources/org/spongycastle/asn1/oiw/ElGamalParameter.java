package org.spongycastle.asn1.oiw;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class ElGamalParameter extends ASN1Object {
    /* renamed from: a */
    ASN1Integer f30961a;
    /* renamed from: b */
    ASN1Integer f30962b;

    public ElGamalParameter(BigInteger bigInteger, BigInteger bigInteger2) {
        this.f30961a = new ASN1Integer(bigInteger);
        this.f30962b = new ASN1Integer(bigInteger2);
    }

    private ElGamalParameter(ASN1Sequence aSN1Sequence) {
        aSN1Sequence = aSN1Sequence.mo6861c();
        this.f30961a = (ASN1Integer) aSN1Sequence.nextElement();
        this.f30962b = (ASN1Integer) aSN1Sequence.nextElement();
    }

    /* renamed from: a */
    public static ElGamalParameter m40046a(Object obj) {
        if (obj instanceof ElGamalParameter) {
            return (ElGamalParameter) obj;
        }
        return obj != null ? new ElGamalParameter(ASN1Sequence.m43000a(obj)) : null;
    }

    /* renamed from: a */
    public BigInteger m40047a() {
        return this.f30961a.m42969c();
    }

    /* renamed from: b */
    public BigInteger m40048b() {
        return this.f30962b.m42969c();
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30961a);
        aSN1EncodableVector.m27141a(this.f30962b);
        return new DERSequence(aSN1EncodableVector);
    }
}
