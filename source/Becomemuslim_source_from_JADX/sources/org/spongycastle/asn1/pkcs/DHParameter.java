package org.spongycastle.asn1.pkcs;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class DHParameter extends ASN1Object {
    /* renamed from: a */
    ASN1Integer f30978a;
    /* renamed from: b */
    ASN1Integer f30979b;
    /* renamed from: c */
    ASN1Integer f30980c;

    public DHParameter(BigInteger bigInteger, BigInteger bigInteger2, int i) {
        this.f30978a = new ASN1Integer(bigInteger);
        this.f30979b = new ASN1Integer(bigInteger2);
        if (i != 0) {
            this.f30980c = new ASN1Integer((long) i);
        } else {
            this.f30980c = null;
        }
    }

    /* renamed from: a */
    public static DHParameter m40065a(Object obj) {
        if (obj instanceof DHParameter) {
            return (DHParameter) obj;
        }
        return obj != null ? new DHParameter(ASN1Sequence.m43000a(obj)) : null;
    }

    private DHParameter(ASN1Sequence aSN1Sequence) {
        aSN1Sequence = aSN1Sequence.mo6861c();
        this.f30978a = ASN1Integer.m42963a(aSN1Sequence.nextElement());
        this.f30979b = ASN1Integer.m42963a(aSN1Sequence.nextElement());
        if (aSN1Sequence.hasMoreElements()) {
            this.f30980c = (ASN1Integer) aSN1Sequence.nextElement();
        } else {
            this.f30980c = null;
        }
    }

    /* renamed from: a */
    public BigInteger m40066a() {
        return this.f30978a.m42969c();
    }

    /* renamed from: b */
    public BigInteger m40067b() {
        return this.f30979b.m42969c();
    }

    /* renamed from: c */
    public BigInteger m40068c() {
        if (this.f30980c == null) {
            return null;
        }
        return this.f30980c.m42969c();
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30978a);
        aSN1EncodableVector.m27141a(this.f30979b);
        if (m40068c() != null) {
            aSN1EncodableVector.m27141a(this.f30980c);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
