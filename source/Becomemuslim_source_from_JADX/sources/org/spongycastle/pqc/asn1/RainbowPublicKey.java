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
import org.spongycastle.pqc.crypto.rainbow.util.RainbowUtil;

public class RainbowPublicKey extends ASN1Object {
    /* renamed from: a */
    private ASN1Integer f32163a;
    /* renamed from: b */
    private ASN1ObjectIdentifier f32164b;
    /* renamed from: c */
    private ASN1Integer f32165c;
    /* renamed from: d */
    private byte[][] f32166d;
    /* renamed from: e */
    private byte[][] f32167e;
    /* renamed from: f */
    private byte[] f32168f;

    private RainbowPublicKey(ASN1Sequence aSN1Sequence) {
        int i;
        if (aSN1Sequence.mo6860a(0) instanceof ASN1Integer) {
            this.f32163a = ASN1Integer.m42963a(aSN1Sequence.mo6860a(0));
        } else {
            this.f32164b = ASN1ObjectIdentifier.m42973a(aSN1Sequence.mo6860a(0));
        }
        this.f32165c = ASN1Integer.m42963a(aSN1Sequence.mo6860a(1));
        ASN1Sequence a = ASN1Sequence.m43000a(aSN1Sequence.mo6860a(2));
        this.f32166d = new byte[a.mo6862g()][];
        for (i = 0; i < a.mo6862g(); i++) {
            this.f32166d[i] = ASN1OctetString.m42990a(a.mo6860a(i)).mo6859c();
        }
        a = (ASN1Sequence) aSN1Sequence.mo6860a(3);
        this.f32167e = new byte[a.mo6862g()][];
        for (i = 0; i < a.mo6862g(); i++) {
            this.f32167e[i] = ASN1OctetString.m42990a(a.mo6860a(i)).mo6859c();
        }
        this.f32168f = ASN1OctetString.m42990a(((ASN1Sequence) aSN1Sequence.mo6860a(4)).mo6860a(0)).mo6859c();
    }

    public RainbowPublicKey(int i, short[][] sArr, short[][] sArr2, short[] sArr3) {
        this.f32163a = new ASN1Integer(0);
        this.f32165c = new ASN1Integer((long) i);
        this.f32166d = RainbowUtil.m29134a(sArr);
        this.f32167e = RainbowUtil.m29134a(sArr2);
        this.f32168f = RainbowUtil.m29132a(sArr3);
    }

    /* renamed from: a */
    public static RainbowPublicKey m42087a(Object obj) {
        if (obj instanceof RainbowPublicKey) {
            return (RainbowPublicKey) obj;
        }
        return obj != null ? new RainbowPublicKey(ASN1Sequence.m43000a(obj)) : null;
    }

    /* renamed from: a */
    public int m42088a() {
        return this.f32165c.m42968b().intValue();
    }

    /* renamed from: b */
    public short[][] m42089b() {
        return RainbowUtil.m29135a(this.f32166d);
    }

    /* renamed from: c */
    public short[][] m42090c() {
        return RainbowUtil.m29135a(this.f32167e);
    }

    /* renamed from: d */
    public short[] m42091d() {
        return RainbowUtil.m29138b(this.f32168f);
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.f32163a != null) {
            aSN1EncodableVector.m27141a(this.f32163a);
        } else {
            aSN1EncodableVector.m27141a(this.f32164b);
        }
        aSN1EncodableVector.m27141a(this.f32165c);
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        for (byte[] dEROctetString : this.f32166d) {
            aSN1EncodableVector2.m27141a(new DEROctetString(dEROctetString));
        }
        aSN1EncodableVector.m27141a(new DERSequence(aSN1EncodableVector2));
        aSN1EncodableVector2 = new ASN1EncodableVector();
        for (byte[] dEROctetString2 : this.f32167e) {
            aSN1EncodableVector2.m27141a(new DEROctetString(dEROctetString2));
        }
        aSN1EncodableVector.m27141a(new DERSequence(aSN1EncodableVector2));
        aSN1EncodableVector2 = new ASN1EncodableVector();
        aSN1EncodableVector2.m27141a(new DEROctetString(this.f32168f));
        aSN1EncodableVector.m27141a(new DERSequence(aSN1EncodableVector2));
        return new DERSequence(aSN1EncodableVector);
    }
}
