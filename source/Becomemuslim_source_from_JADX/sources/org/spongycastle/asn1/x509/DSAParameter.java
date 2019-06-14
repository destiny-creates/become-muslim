package org.spongycastle.asn1.x509;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class DSAParameter extends ASN1Object {
    /* renamed from: a */
    ASN1Integer f31260a;
    /* renamed from: b */
    ASN1Integer f31261b;
    /* renamed from: c */
    ASN1Integer f31262c;

    /* renamed from: a */
    public static DSAParameter m40300a(Object obj) {
        if (obj instanceof DSAParameter) {
            return (DSAParameter) obj;
        }
        return obj != null ? new DSAParameter(ASN1Sequence.m43000a(obj)) : null;
    }

    public DSAParameter(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f31260a = new ASN1Integer(bigInteger);
        this.f31261b = new ASN1Integer(bigInteger2);
        this.f31262c = new ASN1Integer(bigInteger3);
    }

    private DSAParameter(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo6862g() == 3) {
            aSN1Sequence = aSN1Sequence.mo6861c();
            this.f31260a = ASN1Integer.m42963a(aSN1Sequence.nextElement());
            this.f31261b = ASN1Integer.m42963a(aSN1Sequence.nextElement());
            this.f31262c = ASN1Integer.m42963a(aSN1Sequence.nextElement());
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bad sequence size: ");
        stringBuilder.append(aSN1Sequence.mo6862g());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public BigInteger m40301a() {
        return this.f31260a.m42969c();
    }

    /* renamed from: b */
    public BigInteger m40302b() {
        return this.f31261b.m42969c();
    }

    /* renamed from: c */
    public BigInteger m40303c() {
        return this.f31262c.m42969c();
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f31260a);
        aSN1EncodableVector.m27141a(this.f31261b);
        aSN1EncodableVector.m27141a(this.f31262c);
        return new DERSequence(aSN1EncodableVector);
    }
}
