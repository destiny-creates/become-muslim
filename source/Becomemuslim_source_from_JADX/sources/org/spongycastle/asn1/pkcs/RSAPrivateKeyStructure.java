package org.spongycastle.asn1.pkcs;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class RSAPrivateKeyStructure extends ASN1Object {
    /* renamed from: a */
    private int f31022a;
    /* renamed from: b */
    private BigInteger f31023b;
    /* renamed from: c */
    private BigInteger f31024c;
    /* renamed from: d */
    private BigInteger f31025d;
    /* renamed from: e */
    private BigInteger f31026e;
    /* renamed from: f */
    private BigInteger f31027f;
    /* renamed from: g */
    private BigInteger f31028g;
    /* renamed from: h */
    private BigInteger f31029h;
    /* renamed from: i */
    private BigInteger f31030i;
    /* renamed from: j */
    private ASN1Sequence f31031j;

    /* renamed from: a */
    public BigInteger m40135a() {
        return this.f31023b;
    }

    /* renamed from: b */
    public BigInteger m40136b() {
        return this.f31024c;
    }

    /* renamed from: c */
    public BigInteger m40137c() {
        return this.f31025d;
    }

    /* renamed from: d */
    public BigInteger m40138d() {
        return this.f31026e;
    }

    /* renamed from: g */
    public BigInteger m40140g() {
        return this.f31027f;
    }

    /* renamed from: h */
    public BigInteger m40141h() {
        return this.f31028g;
    }

    /* renamed from: i */
    public BigInteger m40142i() {
        return this.f31029h;
    }

    /* renamed from: j */
    public BigInteger m40143j() {
        return this.f31030i;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(new ASN1Integer((long) this.f31022a));
        aSN1EncodableVector.m27141a(new ASN1Integer(m40135a()));
        aSN1EncodableVector.m27141a(new ASN1Integer(m40136b()));
        aSN1EncodableVector.m27141a(new ASN1Integer(m40137c()));
        aSN1EncodableVector.m27141a(new ASN1Integer(m40138d()));
        aSN1EncodableVector.m27141a(new ASN1Integer(m40140g()));
        aSN1EncodableVector.m27141a(new ASN1Integer(m40141h()));
        aSN1EncodableVector.m27141a(new ASN1Integer(m40142i()));
        aSN1EncodableVector.m27141a(new ASN1Integer(m40143j()));
        if (this.f31031j != null) {
            aSN1EncodableVector.m27141a(this.f31031j);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
