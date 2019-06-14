package org.spongycastle.pqc.asn1;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;
import org.spongycastle.pqc.math.linearalgebra.GF2mField;
import org.spongycastle.pqc.math.linearalgebra.Permutation;
import org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;

public class McEliecePrivateKey extends ASN1Object {
    /* renamed from: a */
    private ASN1ObjectIdentifier f32136a;
    /* renamed from: b */
    private int f32137b;
    /* renamed from: c */
    private int f32138c;
    /* renamed from: d */
    private byte[] f32139d;
    /* renamed from: e */
    private byte[] f32140e;
    /* renamed from: f */
    private byte[] f32141f;
    /* renamed from: g */
    private byte[] f32142g;
    /* renamed from: h */
    private byte[] f32143h;
    /* renamed from: i */
    private byte[] f32144i;
    /* renamed from: j */
    private byte[][] f32145j;

    public McEliecePrivateKey(ASN1ObjectIdentifier aSN1ObjectIdentifier, int i, int i2, GF2mField gF2mField, PolynomialGF2mSmallM polynomialGF2mSmallM, GF2Matrix gF2Matrix, Permutation permutation, Permutation permutation2, GF2Matrix gF2Matrix2, PolynomialGF2mSmallM[] polynomialGF2mSmallMArr) {
        this.f32136a = aSN1ObjectIdentifier;
        this.f32137b = i;
        this.f32138c = i2;
        this.f32139d = gF2mField.m29219b();
        this.f32140e = polynomialGF2mSmallM.m29275c();
        this.f32141f = gF2Matrix.m36510a();
        this.f32142g = permutation.m29247a();
        this.f32143h = permutation2.m29247a();
        this.f32144i = gF2Matrix2.m36510a();
        this.f32145j = new byte[polynomialGF2mSmallMArr.length][];
        for (aSN1ObjectIdentifier = null; aSN1ObjectIdentifier != polynomialGF2mSmallMArr.length; aSN1ObjectIdentifier++) {
            this.f32145j[aSN1ObjectIdentifier] = polynomialGF2mSmallMArr[aSN1ObjectIdentifier].m29275c();
        }
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f32136a);
        aSN1EncodableVector.m27141a(new ASN1Integer((long) this.f32137b));
        aSN1EncodableVector.m27141a(new ASN1Integer((long) this.f32138c));
        aSN1EncodableVector.m27141a(new DEROctetString(this.f32139d));
        aSN1EncodableVector.m27141a(new DEROctetString(this.f32140e));
        aSN1EncodableVector.m27141a(new DEROctetString(this.f32141f));
        aSN1EncodableVector.m27141a(new DEROctetString(this.f32142g));
        aSN1EncodableVector.m27141a(new DEROctetString(this.f32143h));
        aSN1EncodableVector.m27141a(new DEROctetString(this.f32144i));
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        for (byte[] dEROctetString : this.f32145j) {
            aSN1EncodableVector2.m27141a(new DEROctetString(dEROctetString));
        }
        aSN1EncodableVector.m27141a(new DERSequence(aSN1EncodableVector2));
        return new DERSequence(aSN1EncodableVector);
    }
}
