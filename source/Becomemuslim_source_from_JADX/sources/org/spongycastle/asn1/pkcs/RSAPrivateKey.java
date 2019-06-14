package org.spongycastle.asn1.pkcs;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class RSAPrivateKey extends ASN1Object {
    /* renamed from: a */
    private BigInteger f31012a;
    /* renamed from: b */
    private BigInteger f31013b;
    /* renamed from: c */
    private BigInteger f31014c;
    /* renamed from: d */
    private BigInteger f31015d;
    /* renamed from: e */
    private BigInteger f31016e;
    /* renamed from: f */
    private BigInteger f31017f;
    /* renamed from: g */
    private BigInteger f31018g;
    /* renamed from: h */
    private BigInteger f31019h;
    /* renamed from: i */
    private BigInteger f31020i;
    /* renamed from: j */
    private ASN1Sequence f31021j;

    /* renamed from: a */
    public static RSAPrivateKey m40125a(Object obj) {
        if (obj instanceof RSAPrivateKey) {
            return (RSAPrivateKey) obj;
        }
        return obj != null ? new RSAPrivateKey(ASN1Sequence.m43000a(obj)) : null;
    }

    public RSAPrivateKey(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, BigInteger bigInteger6, BigInteger bigInteger7, BigInteger bigInteger8) {
        this.f31021j = null;
        this.f31012a = BigInteger.valueOf(0);
        this.f31013b = bigInteger;
        this.f31014c = bigInteger2;
        this.f31015d = bigInteger3;
        this.f31016e = bigInteger4;
        this.f31017f = bigInteger5;
        this.f31018g = bigInteger6;
        this.f31019h = bigInteger7;
        this.f31020i = bigInteger8;
    }

    private RSAPrivateKey(ASN1Sequence aSN1Sequence) {
        this.f31021j = null;
        aSN1Sequence = aSN1Sequence.mo6861c();
        BigInteger b = ((ASN1Integer) aSN1Sequence.nextElement()).m42968b();
        if (b.intValue() != 0) {
            if (b.intValue() != 1) {
                throw new IllegalArgumentException("wrong version for RSA private key");
            }
        }
        this.f31012a = b;
        this.f31013b = ((ASN1Integer) aSN1Sequence.nextElement()).m42968b();
        this.f31014c = ((ASN1Integer) aSN1Sequence.nextElement()).m42968b();
        this.f31015d = ((ASN1Integer) aSN1Sequence.nextElement()).m42968b();
        this.f31016e = ((ASN1Integer) aSN1Sequence.nextElement()).m42968b();
        this.f31017f = ((ASN1Integer) aSN1Sequence.nextElement()).m42968b();
        this.f31018g = ((ASN1Integer) aSN1Sequence.nextElement()).m42968b();
        this.f31019h = ((ASN1Integer) aSN1Sequence.nextElement()).m42968b();
        this.f31020i = ((ASN1Integer) aSN1Sequence.nextElement()).m42968b();
        if (aSN1Sequence.hasMoreElements()) {
            this.f31021j = (ASN1Sequence) aSN1Sequence.nextElement();
        }
    }

    /* renamed from: a */
    public BigInteger m40126a() {
        return this.f31013b;
    }

    /* renamed from: b */
    public BigInteger m40127b() {
        return this.f31014c;
    }

    /* renamed from: c */
    public BigInteger m40128c() {
        return this.f31015d;
    }

    /* renamed from: d */
    public BigInteger m40129d() {
        return this.f31016e;
    }

    /* renamed from: g */
    public BigInteger m40131g() {
        return this.f31017f;
    }

    /* renamed from: h */
    public BigInteger m40132h() {
        return this.f31018g;
    }

    /* renamed from: i */
    public BigInteger m40133i() {
        return this.f31019h;
    }

    /* renamed from: j */
    public BigInteger m40134j() {
        return this.f31020i;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(new ASN1Integer(this.f31012a));
        aSN1EncodableVector.m27141a(new ASN1Integer(m40126a()));
        aSN1EncodableVector.m27141a(new ASN1Integer(m40127b()));
        aSN1EncodableVector.m27141a(new ASN1Integer(m40128c()));
        aSN1EncodableVector.m27141a(new ASN1Integer(m40129d()));
        aSN1EncodableVector.m27141a(new ASN1Integer(m40131g()));
        aSN1EncodableVector.m27141a(new ASN1Integer(m40132h()));
        aSN1EncodableVector.m27141a(new ASN1Integer(m40133i()));
        aSN1EncodableVector.m27141a(new ASN1Integer(m40134j()));
        if (this.f31021j != null) {
            aSN1EncodableVector.m27141a(this.f31021j);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
