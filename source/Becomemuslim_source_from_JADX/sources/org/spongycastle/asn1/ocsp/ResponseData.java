package org.spongycastle.asn1.ocsp;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.Extensions;

public class ResponseData extends ASN1Object {
    /* renamed from: a */
    private static final ASN1Integer f30936a = new ASN1Integer(0);
    /* renamed from: b */
    private boolean f30937b;
    /* renamed from: c */
    private ASN1Integer f30938c;
    /* renamed from: d */
    private ResponderID f30939d;
    /* renamed from: e */
    private ASN1GeneralizedTime f30940e;
    /* renamed from: f */
    private ASN1Sequence f30941f;
    /* renamed from: g */
    private Extensions f30942g;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.f30937b || !this.f30938c.equals(f30936a)) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 0, this.f30938c));
        }
        aSN1EncodableVector.m27141a(this.f30939d);
        aSN1EncodableVector.m27141a(this.f30940e);
        aSN1EncodableVector.m27141a(this.f30941f);
        if (this.f30942g != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 1, this.f30942g));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
