package org.spongycastle.pqc.asn1;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;

public class GMSSPublicKey extends ASN1Object {
    /* renamed from: a */
    private ASN1Integer f32122a = new ASN1Integer(0);
    /* renamed from: b */
    private byte[] f32123b;

    public GMSSPublicKey(byte[] bArr) {
        this.f32123b = bArr;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f32122a);
        aSN1EncodableVector.m27141a(new DEROctetString(this.f32123b));
        return new DERSequence(aSN1EncodableVector);
    }
}
