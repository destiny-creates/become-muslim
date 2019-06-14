package org.spongycastle.asn1.x9;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class X9FieldID extends ASN1Object implements X9ObjectIdentifiers {
    private ASN1ObjectIdentifier ap;
    private ASN1Primitive aq;

    public X9FieldID(BigInteger bigInteger) {
        this.ap = c;
        this.aq = new ASN1Integer(bigInteger);
    }

    public X9FieldID(int i, int i2) {
        this(i, i2, 0, 0);
    }

    public X9FieldID(int i, int i2, int i3, int i4) {
        this.ap = d;
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(new ASN1Integer((long) i));
        if (i3 == 0) {
            if (i4 == 0) {
                aSN1EncodableVector.m27141a(f);
                aSN1EncodableVector.m27141a(new ASN1Integer((long) i2));
            } else {
                throw new IllegalArgumentException("inconsistent k values");
            }
        } else if (i3 <= i2 || i4 <= i3) {
            throw new IllegalArgumentException("inconsistent k values");
        } else {
            aSN1EncodableVector.m27141a(g);
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
            aSN1EncodableVector2.m27141a(new ASN1Integer((long) i2));
            aSN1EncodableVector2.m27141a(new ASN1Integer((long) i3));
            aSN1EncodableVector2.m27141a(new ASN1Integer((long) i4));
            aSN1EncodableVector.m27141a(new DERSequence(aSN1EncodableVector2));
        }
        this.aq = new DERSequence(aSN1EncodableVector);
    }

    private X9FieldID(ASN1Sequence aSN1Sequence) {
        this.ap = ASN1ObjectIdentifier.m42973a(aSN1Sequence.mo6860a(0));
        this.aq = aSN1Sequence.mo6860a(1).mo5709e();
    }

    /* renamed from: a */
    public static X9FieldID m40526a(Object obj) {
        if (obj instanceof X9FieldID) {
            return (X9FieldID) obj;
        }
        return obj != null ? new X9FieldID(ASN1Sequence.m43000a(obj)) : null;
    }

    /* renamed from: a */
    public ASN1ObjectIdentifier m40527a() {
        return this.ap;
    }

    /* renamed from: b */
    public ASN1Primitive m40528b() {
        return this.aq;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.ap);
        aSN1EncodableVector.m27141a(this.aq);
        return new DERSequence(aSN1EncodableVector);
    }
}
