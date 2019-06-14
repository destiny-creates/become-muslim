package org.spongycastle.asn1.eac;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class ECDSAPublicKey extends PublicKeyDataObject {
    /* renamed from: a */
    private ASN1ObjectIdentifier f32515a;
    /* renamed from: b */
    private BigInteger f32516b;
    /* renamed from: c */
    private BigInteger f32517c;
    /* renamed from: d */
    private BigInteger f32518d;
    /* renamed from: e */
    private byte[] f32519e;
    /* renamed from: f */
    private BigInteger f32520f;
    /* renamed from: g */
    private byte[] f32521g;
    /* renamed from: h */
    private BigInteger f32522h;
    /* renamed from: i */
    private int f32523i;

    /* renamed from: a */
    public byte[] m43125a() {
        return (this.f32523i & 8) != 0 ? this.f32519e : null;
    }

    /* renamed from: b */
    public BigInteger m43126b() {
        return (this.f32523i & 64) != 0 ? this.f32522h : null;
    }

    /* renamed from: c */
    public BigInteger m43127c() {
        return (this.f32523i & 2) != 0 ? this.f32517c : null;
    }

    /* renamed from: d */
    public BigInteger m43128d() {
        return (this.f32523i & 16) != 0 ? this.f32520f : null;
    }

    /* renamed from: g */
    public BigInteger m43130g() {
        return (this.f32523i & 1) != 0 ? this.f32516b : null;
    }

    /* renamed from: h */
    public byte[] m43131h() {
        return (this.f32523i & 32) != 0 ? this.f32521g : null;
    }

    /* renamed from: i */
    public BigInteger m43132i() {
        return (this.f32523i & 4) != 0 ? this.f32518d : null;
    }

    /* renamed from: a */
    public ASN1EncodableVector m43124a(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a((ASN1Encodable) aSN1ObjectIdentifier);
        if (!z) {
            aSN1EncodableVector.m27141a(new UnsignedInteger(1, m43130g()));
            aSN1EncodableVector.m27141a(new UnsignedInteger(2, m43127c()));
            aSN1EncodableVector.m27141a(new UnsignedInteger(3, m43132i()));
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 4, new DEROctetString(m43125a())));
            aSN1EncodableVector.m27141a(new UnsignedInteger(5, m43128d()));
        }
        aSN1EncodableVector.m27141a(new DERTaggedObject(false, 6, new DEROctetString(m43131h())));
        if (!z) {
            aSN1EncodableVector.m27141a(new UnsignedInteger(true, m43126b()));
        }
        return aSN1EncodableVector;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        return new DERSequence(m43124a(this.f32515a, false));
    }
}
