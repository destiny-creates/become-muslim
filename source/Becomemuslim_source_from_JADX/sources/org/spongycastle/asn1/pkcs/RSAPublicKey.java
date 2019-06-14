package org.spongycastle.asn1.pkcs;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class RSAPublicKey extends ASN1Object {
    /* renamed from: a */
    private BigInteger f31032a;
    /* renamed from: b */
    private BigInteger f31033b;

    /* renamed from: a */
    public static RSAPublicKey m40144a(Object obj) {
        if (obj instanceof RSAPublicKey) {
            return (RSAPublicKey) obj;
        }
        return obj != null ? new RSAPublicKey(ASN1Sequence.m43000a(obj)) : null;
    }

    public RSAPublicKey(BigInteger bigInteger, BigInteger bigInteger2) {
        this.f31032a = bigInteger;
        this.f31033b = bigInteger2;
    }

    private RSAPublicKey(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo6862g() == 2) {
            aSN1Sequence = aSN1Sequence.mo6861c();
            this.f31032a = ASN1Integer.m42963a(aSN1Sequence.nextElement()).m42969c();
            this.f31033b = ASN1Integer.m42963a(aSN1Sequence.nextElement()).m42969c();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bad sequence size: ");
        stringBuilder.append(aSN1Sequence.mo6862g());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public BigInteger m40145a() {
        return this.f31032a;
    }

    /* renamed from: b */
    public BigInteger m40146b() {
        return this.f31033b;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(new ASN1Integer(m40145a()));
        aSN1EncodableVector.m27141a(new ASN1Integer(m40146b()));
        return new DERSequence(aSN1EncodableVector);
    }
}
