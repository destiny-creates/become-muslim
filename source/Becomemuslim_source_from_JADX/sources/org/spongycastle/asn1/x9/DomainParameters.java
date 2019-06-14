package org.spongycastle.asn1.x9;

import java.math.BigInteger;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class DomainParameters extends ASN1Object {
    /* renamed from: a */
    private final ASN1Integer f31525a;
    /* renamed from: b */
    private final ASN1Integer f31526b;
    /* renamed from: c */
    private final ASN1Integer f31527c;
    /* renamed from: d */
    private final ASN1Integer f31528d;
    /* renamed from: e */
    private final ValidationParams f31529e;

    /* renamed from: a */
    public static DomainParameters m40493a(Object obj) {
        if (obj instanceof DomainParameters) {
            return (DomainParameters) obj;
        }
        return obj != null ? new DomainParameters(ASN1Sequence.m43000a(obj)) : null;
    }

    private DomainParameters(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo6862g() < 3 || aSN1Sequence.mo6862g() > 5) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Bad sequence size: ");
            stringBuilder.append(aSN1Sequence.mo6862g());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        Enumeration c = aSN1Sequence.mo6861c();
        this.f31525a = ASN1Integer.m42963a(c.nextElement());
        this.f31526b = ASN1Integer.m42963a(c.nextElement());
        this.f31527c = ASN1Integer.m42963a(c.nextElement());
        ASN1Encodable a = m40492a(c);
        if (a == null || !(a instanceof ASN1Integer)) {
            this.f31528d = null;
        } else {
            this.f31528d = ASN1Integer.m42963a((Object) a);
            a = m40492a(c);
        }
        if (a != null) {
            this.f31529e = ValidationParams.m40502a(a.mo5709e());
        } else {
            this.f31529e = null;
        }
    }

    /* renamed from: a */
    private static ASN1Encodable m40492a(Enumeration enumeration) {
        return enumeration.hasMoreElements() ? (ASN1Encodable) enumeration.nextElement() : null;
    }

    /* renamed from: a */
    public BigInteger m40494a() {
        return this.f31525a.m42969c();
    }

    /* renamed from: b */
    public BigInteger m40495b() {
        return this.f31526b.m42969c();
    }

    /* renamed from: c */
    public BigInteger m40496c() {
        return this.f31527c.m42969c();
    }

    /* renamed from: d */
    public BigInteger m40497d() {
        if (this.f31528d == null) {
            return null;
        }
        return this.f31528d.m42969c();
    }

    /* renamed from: g */
    public ValidationParams m40499g() {
        return this.f31529e;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f31525a);
        aSN1EncodableVector.m27141a(this.f31526b);
        aSN1EncodableVector.m27141a(this.f31527c);
        if (this.f31528d != null) {
            aSN1EncodableVector.m27141a(this.f31528d);
        }
        if (this.f31529e != null) {
            aSN1EncodableVector.m27141a(this.f31529e);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
