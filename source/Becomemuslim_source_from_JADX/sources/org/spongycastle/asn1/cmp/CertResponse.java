package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class CertResponse extends ASN1Object {
    /* renamed from: a */
    private ASN1Integer f30444a;
    /* renamed from: b */
    private PKIStatusInfo f30445b;
    /* renamed from: c */
    private CertifiedKeyPair f30446c;
    /* renamed from: d */
    private ASN1OctetString f30447d;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30444a);
        aSN1EncodableVector.m27141a(this.f30445b);
        if (this.f30446c != null) {
            aSN1EncodableVector.m27141a(this.f30446c);
        }
        if (this.f30447d != null) {
            aSN1EncodableVector.m27141a(this.f30447d);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
