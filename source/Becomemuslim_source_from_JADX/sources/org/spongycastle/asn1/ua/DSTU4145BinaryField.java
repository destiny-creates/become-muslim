package org.spongycastle.asn1.ua;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class DSTU4145BinaryField extends ASN1Object {
    /* renamed from: a */
    private int f31100a;
    /* renamed from: b */
    private int f31101b;
    /* renamed from: c */
    private int f31102c;
    /* renamed from: d */
    private int f31103d;

    private DSTU4145BinaryField(ASN1Sequence aSN1Sequence) {
        this.f31100a = ASN1Integer.m42963a(aSN1Sequence.mo6860a(0)).m42969c().intValue();
        if (aSN1Sequence.mo6860a(1) instanceof ASN1Integer) {
            this.f31101b = ((ASN1Integer) aSN1Sequence.mo6860a(1)).m42969c().intValue();
        } else if (aSN1Sequence.mo6860a(1) instanceof ASN1Sequence) {
            aSN1Sequence = ASN1Sequence.m43000a(aSN1Sequence.mo6860a(1));
            this.f31101b = ASN1Integer.m42963a(aSN1Sequence.mo6860a(0)).m42969c().intValue();
            this.f31102c = ASN1Integer.m42963a(aSN1Sequence.mo6860a(1)).m42969c().intValue();
            this.f31103d = ASN1Integer.m42963a(aSN1Sequence.mo6860a(2)).m42969c().intValue();
        } else {
            throw new IllegalArgumentException("object parse error");
        }
    }

    /* renamed from: a */
    public static DSTU4145BinaryField m40180a(Object obj) {
        if (obj instanceof DSTU4145BinaryField) {
            return (DSTU4145BinaryField) obj;
        }
        return obj != null ? new DSTU4145BinaryField(ASN1Sequence.m43000a(obj)) : null;
    }

    /* renamed from: a */
    public int m40181a() {
        return this.f31100a;
    }

    /* renamed from: b */
    public int m40182b() {
        return this.f31101b;
    }

    /* renamed from: c */
    public int m40183c() {
        return this.f31102c;
    }

    /* renamed from: d */
    public int m40184d() {
        return this.f31103d;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(new ASN1Integer((long) this.f31100a));
        if (this.f31102c == 0) {
            aSN1EncodableVector.m27141a(new ASN1Integer((long) this.f31101b));
        } else {
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
            aSN1EncodableVector2.m27141a(new ASN1Integer((long) this.f31101b));
            aSN1EncodableVector2.m27141a(new ASN1Integer((long) this.f31102c));
            aSN1EncodableVector2.m27141a(new ASN1Integer((long) this.f31103d));
            aSN1EncodableVector.m27141a(new DERSequence(aSN1EncodableVector2));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
