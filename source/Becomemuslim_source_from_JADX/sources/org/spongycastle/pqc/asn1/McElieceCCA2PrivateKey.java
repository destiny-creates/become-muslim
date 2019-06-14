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

public class McElieceCCA2PrivateKey extends ASN1Object {
    /* renamed from: a */
    private ASN1ObjectIdentifier f32124a;
    /* renamed from: b */
    private int f32125b;
    /* renamed from: c */
    private int f32126c;
    /* renamed from: d */
    private byte[] f32127d;
    /* renamed from: e */
    private byte[] f32128e;
    /* renamed from: f */
    private byte[] f32129f;
    /* renamed from: g */
    private byte[] f32130g;
    /* renamed from: h */
    private byte[][] f32131h;

    public McElieceCCA2PrivateKey(ASN1ObjectIdentifier aSN1ObjectIdentifier, int i, int i2, GF2mField gF2mField, PolynomialGF2mSmallM polynomialGF2mSmallM, Permutation permutation, GF2Matrix gF2Matrix, PolynomialGF2mSmallM[] polynomialGF2mSmallMArr) {
        this.f32124a = aSN1ObjectIdentifier;
        this.f32125b = i;
        this.f32126c = i2;
        this.f32127d = gF2mField.m29219b();
        this.f32128e = polynomialGF2mSmallM.m29275c();
        this.f32129f = permutation.m29247a();
        this.f32130g = gF2Matrix.m36510a();
        this.f32131h = new byte[polynomialGF2mSmallMArr.length][];
        for (aSN1ObjectIdentifier = null; aSN1ObjectIdentifier != polynomialGF2mSmallMArr.length; aSN1ObjectIdentifier++) {
            this.f32131h[aSN1ObjectIdentifier] = polynomialGF2mSmallMArr[aSN1ObjectIdentifier].m29275c();
        }
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f32124a);
        aSN1EncodableVector.m27141a(new ASN1Integer((long) this.f32125b));
        aSN1EncodableVector.m27141a(new ASN1Integer((long) this.f32126c));
        aSN1EncodableVector.m27141a(new DEROctetString(this.f32127d));
        aSN1EncodableVector.m27141a(new DEROctetString(this.f32128e));
        aSN1EncodableVector.m27141a(new DEROctetString(this.f32129f));
        aSN1EncodableVector.m27141a(new DEROctetString(this.f32130g));
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        for (byte[] dEROctetString : this.f32131h) {
            aSN1EncodableVector2.m27141a(new DEROctetString(dEROctetString));
        }
        aSN1EncodableVector.m27141a(new DERSequence(aSN1EncodableVector2));
        return new DERSequence(aSN1EncodableVector);
    }
}
