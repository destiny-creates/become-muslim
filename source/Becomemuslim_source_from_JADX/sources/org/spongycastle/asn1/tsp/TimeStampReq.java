package org.spongycastle.asn1.tsp;

import org.spongycastle.asn1.ASN1Boolean;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.Extensions;

public class TimeStampReq extends ASN1Object {
    /* renamed from: a */
    ASN1Integer f31092a;
    /* renamed from: b */
    MessageImprint f31093b;
    /* renamed from: c */
    ASN1ObjectIdentifier f31094c;
    /* renamed from: d */
    ASN1Integer f31095d;
    /* renamed from: e */
    ASN1Boolean f31096e;
    /* renamed from: f */
    Extensions f31097f;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f31092a);
        aSN1EncodableVector.m27141a(this.f31093b);
        if (this.f31094c != null) {
            aSN1EncodableVector.m27141a(this.f31094c);
        }
        if (this.f31095d != null) {
            aSN1EncodableVector.m27141a(this.f31095d);
        }
        if (this.f31096e != null && this.f31096e.m42944b()) {
            aSN1EncodableVector.m27141a(this.f31096e);
        }
        if (this.f31097f != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 0, this.f31097f));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
