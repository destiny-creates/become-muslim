package org.spongycastle.pqc.asn1;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class ParSet extends ASN1Object {
    /* renamed from: a */
    private static final BigInteger f32150a = BigInteger.valueOf(0);
    /* renamed from: b */
    private int f32151b;
    /* renamed from: c */
    private int[] f32152c;
    /* renamed from: d */
    private int[] f32153d;
    /* renamed from: e */
    private int[] f32154e;

    public ParSet(int i, int[] iArr, int[] iArr2, int[] iArr3) {
        this.f32151b = i;
        this.f32152c = iArr;
        this.f32153d = iArr2;
        this.f32154e = iArr3;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
        for (int i = 0; i < this.f32152c.length; i++) {
            aSN1EncodableVector.m27141a(new ASN1Integer((long) this.f32152c[i]));
            aSN1EncodableVector2.m27141a(new ASN1Integer((long) this.f32153d[i]));
            aSN1EncodableVector3.m27141a(new ASN1Integer((long) this.f32154e[i]));
        }
        ASN1EncodableVector aSN1EncodableVector4 = new ASN1EncodableVector();
        aSN1EncodableVector4.m27141a(new ASN1Integer((long) this.f32151b));
        aSN1EncodableVector4.m27141a(new DERSequence(aSN1EncodableVector));
        aSN1EncodableVector4.m27141a(new DERSequence(aSN1EncodableVector2));
        aSN1EncodableVector4.m27141a(new DERSequence(aSN1EncodableVector3));
        return new DERSequence(aSN1EncodableVector4);
    }
}
