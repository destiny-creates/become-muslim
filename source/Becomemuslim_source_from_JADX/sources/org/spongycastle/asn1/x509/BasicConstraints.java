package org.spongycastle.asn1.x509;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1Boolean;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class BasicConstraints extends ASN1Object {
    /* renamed from: a */
    ASN1Boolean f31240a = ASN1Boolean.m42939a(false);
    /* renamed from: b */
    ASN1Integer f31241b = null;

    /* renamed from: a */
    public static BasicConstraints m40258a(Object obj) {
        if (obj instanceof BasicConstraints) {
            return (BasicConstraints) obj;
        }
        if (obj instanceof X509Extension) {
            return m40258a(X509Extension.m27255a((X509Extension) obj));
        }
        return obj != null ? new BasicConstraints(ASN1Sequence.m43000a(obj)) : null;
    }

    private BasicConstraints(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo6862g() == 0) {
            this.f31240a = null;
            this.f31241b = null;
            return;
        }
        if (aSN1Sequence.mo6860a(0) instanceof ASN1Boolean) {
            this.f31240a = ASN1Boolean.m42937a(aSN1Sequence.mo6860a(0));
        } else {
            this.f31240a = null;
            this.f31241b = ASN1Integer.m42963a(aSN1Sequence.mo6860a(0));
        }
        if (aSN1Sequence.mo6862g() <= 1) {
            return;
        }
        if (this.f31240a != null) {
            this.f31241b = ASN1Integer.m42963a(aSN1Sequence.mo6860a(1));
            return;
        }
        throw new IllegalArgumentException("wrong sequence in constructor");
    }

    /* renamed from: a */
    public boolean m40259a() {
        return this.f31240a != null && this.f31240a.m42944b();
    }

    /* renamed from: b */
    public BigInteger m40260b() {
        return this.f31241b != null ? this.f31241b.m42968b() : null;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.f31240a != null) {
            aSN1EncodableVector.m27141a(this.f31240a);
        }
        if (this.f31241b != null) {
            aSN1EncodableVector.m27141a(this.f31241b);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public String toString() {
        StringBuilder stringBuilder;
        if (this.f31241b != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("BasicConstraints: isCa(");
            stringBuilder.append(m40259a());
            stringBuilder.append("), pathLenConstraint = ");
            stringBuilder.append(this.f31241b.m42968b());
            return stringBuilder.toString();
        } else if (this.f31240a == null) {
            return "BasicConstraints: isCa(false)";
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("BasicConstraints: isCa(");
            stringBuilder.append(m40259a());
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }
}
