package org.spongycastle.asn1.x9;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;

public class ValidationParams extends ASN1Object {
    /* renamed from: a */
    private DERBitString f31535a;
    /* renamed from: b */
    private ASN1Integer f31536b;

    /* renamed from: a */
    public static ValidationParams m40502a(Object obj) {
        if (obj instanceof ValidationParams) {
            return (ValidationParams) obj;
        }
        return obj != null ? new ValidationParams(ASN1Sequence.m43000a(obj)) : null;
    }

    private ValidationParams(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo6862g() == 2) {
            this.f31535a = DERBitString.m43051a(aSN1Sequence.mo6860a(0));
            this.f31536b = ASN1Integer.m42963a(aSN1Sequence.mo6860a(1));
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bad sequence size: ");
        stringBuilder.append(aSN1Sequence.mo6862g());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public byte[] m40503a() {
        return this.f31535a.m43059c();
    }

    /* renamed from: b */
    public BigInteger m40504b() {
        return this.f31536b.m42969c();
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f31535a);
        aSN1EncodableVector.m27141a(this.f31536b);
        return new DERSequence(aSN1EncodableVector);
    }
}
