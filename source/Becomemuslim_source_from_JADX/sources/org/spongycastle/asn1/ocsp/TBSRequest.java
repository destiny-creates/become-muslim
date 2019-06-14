package org.spongycastle.asn1.ocsp;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.Extensions;
import org.spongycastle.asn1.x509.GeneralName;

public class TBSRequest extends ASN1Object {
    /* renamed from: f */
    private static final ASN1Integer f30955f = new ASN1Integer(0);
    /* renamed from: a */
    ASN1Integer f30956a;
    /* renamed from: b */
    GeneralName f30957b;
    /* renamed from: c */
    ASN1Sequence f30958c;
    /* renamed from: d */
    Extensions f30959d;
    /* renamed from: e */
    boolean f30960e;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (!this.f30956a.equals(f30955f) || this.f30960e) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 0, this.f30956a));
        }
        if (this.f30957b != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 1, this.f30957b));
        }
        aSN1EncodableVector.m27141a(this.f30958c);
        if (this.f30959d != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 2, this.f30959d));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
