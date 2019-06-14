package org.spongycastle.pqc.asn1;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;

public class McElieceCCA2PublicKey extends ASN1Object {
    /* renamed from: a */
    private ASN1ObjectIdentifier f32132a;
    /* renamed from: b */
    private int f32133b;
    /* renamed from: c */
    private int f32134c;
    /* renamed from: d */
    private byte[] f32135d;

    public McElieceCCA2PublicKey(ASN1ObjectIdentifier aSN1ObjectIdentifier, int i, int i2, GF2Matrix gF2Matrix) {
        this.f32132a = aSN1ObjectIdentifier;
        this.f32133b = i;
        this.f32134c = i2;
        this.f32135d = gF2Matrix.m36510a();
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f32132a);
        aSN1EncodableVector.m27141a(new ASN1Integer((long) this.f32133b));
        aSN1EncodableVector.m27141a(new ASN1Integer((long) this.f32134c));
        aSN1EncodableVector.m27141a(new DEROctetString(this.f32135d));
        return new DERSequence(aSN1EncodableVector);
    }
}
