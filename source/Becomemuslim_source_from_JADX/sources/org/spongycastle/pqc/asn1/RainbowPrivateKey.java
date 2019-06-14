package org.spongycastle.pqc.asn1;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.pqc.crypto.rainbow.Layer;
import org.spongycastle.pqc.crypto.rainbow.util.RainbowUtil;

public class RainbowPrivateKey extends ASN1Object {
    /* renamed from: a */
    private ASN1Integer f32155a;
    /* renamed from: b */
    private ASN1ObjectIdentifier f32156b;
    /* renamed from: c */
    private byte[][] f32157c;
    /* renamed from: d */
    private byte[] f32158d;
    /* renamed from: e */
    private byte[][] f32159e;
    /* renamed from: f */
    private byte[] f32160f;
    /* renamed from: g */
    private byte[] f32161g;
    /* renamed from: h */
    private Layer[] f32162h;

    private RainbowPrivateKey(ASN1Sequence aSN1Sequence) {
        int i;
        RainbowPrivateKey rainbowPrivateKey = this;
        ASN1Sequence aSN1Sequence2 = aSN1Sequence;
        int i2 = 0;
        if (aSN1Sequence2.mo6860a(0) instanceof ASN1Integer) {
            rainbowPrivateKey.f32155a = ASN1Integer.m42963a(aSN1Sequence2.mo6860a(0));
        } else {
            rainbowPrivateKey.f32156b = ASN1ObjectIdentifier.m42973a(aSN1Sequence2.mo6860a(0));
        }
        ASN1Sequence aSN1Sequence3 = (ASN1Sequence) aSN1Sequence2.mo6860a(1);
        rainbowPrivateKey.f32157c = new byte[aSN1Sequence3.mo6862g()][];
        for (i = 0; i < aSN1Sequence3.mo6862g(); i++) {
            rainbowPrivateKey.f32157c[i] = ((ASN1OctetString) aSN1Sequence3.mo6860a(i)).mo6859c();
        }
        rainbowPrivateKey.f32158d = ((ASN1OctetString) ((ASN1Sequence) aSN1Sequence2.mo6860a(2)).mo6860a(0)).mo6859c();
        ASN1Sequence aSN1Sequence4 = (ASN1Sequence) aSN1Sequence2.mo6860a(3);
        rainbowPrivateKey.f32159e = new byte[aSN1Sequence4.mo6862g()][];
        for (int i3 = 0; i3 < aSN1Sequence4.mo6862g(); i3++) {
            rainbowPrivateKey.f32159e[i3] = ((ASN1OctetString) aSN1Sequence4.mo6860a(i3)).mo6859c();
        }
        rainbowPrivateKey.f32160f = ((ASN1OctetString) ((ASN1Sequence) aSN1Sequence2.mo6860a(4)).mo6860a(0)).mo6859c();
        rainbowPrivateKey.f32161g = ((ASN1OctetString) ((ASN1Sequence) aSN1Sequence2.mo6860a(5)).mo6860a(0)).mo6859c();
        aSN1Sequence2 = (ASN1Sequence) aSN1Sequence2.mo6860a(6);
        byte[][][][] bArr = new byte[aSN1Sequence2.mo6862g()][][][];
        byte[][][][] bArr2 = new byte[aSN1Sequence2.mo6862g()][][][];
        byte[][][] bArr3 = new byte[aSN1Sequence2.mo6862g()][][];
        byte[][] bArr4 = new byte[aSN1Sequence2.mo6862g()][];
        int i4 = 0;
        while (i4 < aSN1Sequence2.mo6862g()) {
            int i5;
            ASN1Sequence aSN1Sequence5 = (ASN1Sequence) aSN1Sequence2.mo6860a(i4);
            ASN1Sequence aSN1Sequence6 = (ASN1Sequence) aSN1Sequence5.mo6860a(i2);
            bArr[i4] = new byte[aSN1Sequence6.mo6862g()][][];
            for (int i6 = 0; i6 < aSN1Sequence6.mo6862g(); i6++) {
                ASN1Sequence aSN1Sequence7 = (ASN1Sequence) aSN1Sequence6.mo6860a(i6);
                bArr[i4][i6] = new byte[aSN1Sequence7.mo6862g()][];
                for (i2 = 0; i2 < aSN1Sequence7.mo6862g(); i2++) {
                    bArr[i4][i6][i2] = ((ASN1OctetString) aSN1Sequence7.mo6860a(i2)).mo6859c();
                }
            }
            ASN1Sequence aSN1Sequence8 = (ASN1Sequence) aSN1Sequence5.mo6860a(1);
            bArr2[i4] = new byte[aSN1Sequence8.mo6862g()][][];
            for (i5 = 0; i5 < aSN1Sequence8.mo6862g(); i5++) {
                ASN1Sequence aSN1Sequence9 = (ASN1Sequence) aSN1Sequence8.mo6860a(i5);
                bArr2[i4][i5] = new byte[aSN1Sequence9.mo6862g()][];
                for (int i7 = 0; i7 < aSN1Sequence9.mo6862g(); i7++) {
                    bArr2[i4][i5][i7] = ((ASN1OctetString) aSN1Sequence9.mo6860a(i7)).mo6859c();
                }
            }
            aSN1Sequence8 = (ASN1Sequence) aSN1Sequence5.mo6860a(2);
            bArr3[i4] = new byte[aSN1Sequence8.mo6862g()][];
            for (i5 = 0; i5 < aSN1Sequence8.mo6862g(); i5++) {
                bArr3[i4][i5] = ((ASN1OctetString) aSN1Sequence8.mo6860a(i5)).mo6859c();
            }
            bArr4[i4] = ((ASN1OctetString) aSN1Sequence5.mo6860a(3)).mo6859c();
            i4++;
            i2 = 0;
        }
        int length = rainbowPrivateKey.f32161g.length - 1;
        rainbowPrivateKey.f32162h = new Layer[length];
        i2 = 0;
        while (i2 < length) {
            i = i2 + 1;
            rainbowPrivateKey.f32162h[i2] = new Layer(rainbowPrivateKey.f32161g[i2], rainbowPrivateKey.f32161g[i], RainbowUtil.m29137a(bArr[i2]), RainbowUtil.m29137a(bArr2[i2]), RainbowUtil.m29135a(bArr3[i2]), RainbowUtil.m29138b(bArr4[i2]));
            i2 = i;
        }
    }

    public RainbowPrivateKey(short[][] sArr, short[] sArr2, short[][] sArr3, short[] sArr4, int[] iArr, Layer[] layerArr) {
        this.f32155a = new ASN1Integer(1);
        this.f32157c = RainbowUtil.m29134a(sArr);
        this.f32158d = RainbowUtil.m29132a(sArr2);
        this.f32159e = RainbowUtil.m29134a(sArr3);
        this.f32160f = RainbowUtil.m29132a(sArr4);
        this.f32161g = RainbowUtil.m29131a(iArr);
        this.f32162h = layerArr;
    }

    /* renamed from: a */
    public static RainbowPrivateKey m42079a(Object obj) {
        if (obj instanceof RainbowPrivateKey) {
            return (RainbowPrivateKey) obj;
        }
        return obj != null ? new RainbowPrivateKey(ASN1Sequence.m43000a(obj)) : null;
    }

    /* renamed from: a */
    public short[][] m42080a() {
        return RainbowUtil.m29135a(this.f32157c);
    }

    /* renamed from: b */
    public short[] m42081b() {
        return RainbowUtil.m29138b(this.f32158d);
    }

    /* renamed from: c */
    public short[] m42082c() {
        return RainbowUtil.m29138b(this.f32160f);
    }

    /* renamed from: d */
    public short[][] m42083d() {
        return RainbowUtil.m29135a(this.f32159e);
    }

    /* renamed from: g */
    public Layer[] m42085g() {
        return this.f32162h;
    }

    /* renamed from: h */
    public int[] m42086h() {
        return RainbowUtil.m29133a(this.f32161g);
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        int i;
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.f32155a != null) {
            aSN1EncodableVector.m27141a(this.f32155a);
        } else {
            aSN1EncodableVector.m27141a(this.f32156b);
        }
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        for (byte[] dEROctetString : this.f32157c) {
            aSN1EncodableVector2.m27141a(new DEROctetString(dEROctetString));
        }
        aSN1EncodableVector.m27141a(new DERSequence(aSN1EncodableVector2));
        aSN1EncodableVector2 = new ASN1EncodableVector();
        aSN1EncodableVector2.m27141a(new DEROctetString(this.f32158d));
        aSN1EncodableVector.m27141a(new DERSequence(aSN1EncodableVector2));
        aSN1EncodableVector2 = new ASN1EncodableVector();
        for (byte[] dEROctetString2 : this.f32159e) {
            aSN1EncodableVector2.m27141a(new DEROctetString(dEROctetString2));
        }
        aSN1EncodableVector.m27141a(new DERSequence(aSN1EncodableVector2));
        aSN1EncodableVector2 = new ASN1EncodableVector();
        aSN1EncodableVector2.m27141a(new DEROctetString(this.f32160f));
        aSN1EncodableVector.m27141a(new DERSequence(aSN1EncodableVector2));
        aSN1EncodableVector2 = new ASN1EncodableVector();
        aSN1EncodableVector2.m27141a(new DEROctetString(this.f32161g));
        aSN1EncodableVector.m27141a(new DERSequence(aSN1EncodableVector2));
        aSN1EncodableVector2 = new ASN1EncodableVector();
        for (i = 0; i < this.f32162h.length; i++) {
            int i2;
            ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
            byte[][][] a = RainbowUtil.m29136a(this.f32162h[i].m29110d());
            ASN1EncodableVector aSN1EncodableVector4 = new ASN1EncodableVector();
            for (i2 = 0; i2 < a.length; i2++) {
                ASN1EncodableVector aSN1EncodableVector5 = new ASN1EncodableVector();
                for (byte[] dEROctetString3 : a[i2]) {
                    aSN1EncodableVector5.m27141a(new DEROctetString(dEROctetString3));
                }
                aSN1EncodableVector4.m27141a(new DERSequence(aSN1EncodableVector5));
            }
            aSN1EncodableVector3.m27141a(new DERSequence(aSN1EncodableVector4));
            a = RainbowUtil.m29136a(this.f32162h[i].m29111e());
            aSN1EncodableVector4 = new ASN1EncodableVector();
            for (i2 = 0; i2 < a.length; i2++) {
                aSN1EncodableVector5 = new ASN1EncodableVector();
                for (byte[] dEROctetString32 : a[i2]) {
                    aSN1EncodableVector5.m27141a(new DEROctetString(dEROctetString32));
                }
                aSN1EncodableVector4.m27141a(new DERSequence(aSN1EncodableVector5));
            }
            aSN1EncodableVector3.m27141a(new DERSequence(aSN1EncodableVector4));
            byte[][] a2 = RainbowUtil.m29134a(this.f32162h[i].m29112f());
            aSN1EncodableVector4 = new ASN1EncodableVector();
            for (byte[] dEROctetString4 : a2) {
                aSN1EncodableVector4.m27141a(new DEROctetString(dEROctetString4));
            }
            aSN1EncodableVector3.m27141a(new DERSequence(aSN1EncodableVector4));
            aSN1EncodableVector3.m27141a(new DEROctetString(RainbowUtil.m29132a(this.f32162h[i].m29113g())));
            aSN1EncodableVector2.m27141a(new DERSequence(aSN1EncodableVector3));
        }
        aSN1EncodableVector.m27141a(new DERSequence(aSN1EncodableVector2));
        return new DERSequence(aSN1EncodableVector);
    }
}
