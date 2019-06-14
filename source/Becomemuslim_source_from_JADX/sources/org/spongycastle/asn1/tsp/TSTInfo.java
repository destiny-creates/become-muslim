package org.spongycastle.asn1.tsp;

import org.spongycastle.asn1.ASN1Boolean;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.Extensions;
import org.spongycastle.asn1.x509.GeneralName;

public class TSTInfo extends ASN1Object {
    /* renamed from: a */
    private ASN1Integer f31082a;
    /* renamed from: b */
    private ASN1ObjectIdentifier f31083b;
    /* renamed from: c */
    private MessageImprint f31084c;
    /* renamed from: d */
    private ASN1Integer f31085d;
    /* renamed from: e */
    private ASN1GeneralizedTime f31086e;
    /* renamed from: f */
    private Accuracy f31087f;
    /* renamed from: g */
    private ASN1Boolean f31088g;
    /* renamed from: h */
    private ASN1Integer f31089h;
    /* renamed from: i */
    private GeneralName f31090i;
    /* renamed from: j */
    private Extensions f31091j;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f31082a);
        aSN1EncodableVector.m27141a(this.f31083b);
        aSN1EncodableVector.m27141a(this.f31084c);
        aSN1EncodableVector.m27141a(this.f31085d);
        aSN1EncodableVector.m27141a(this.f31086e);
        if (this.f31087f != null) {
            aSN1EncodableVector.m27141a(this.f31087f);
        }
        if (this.f31088g != null && this.f31088g.m42944b()) {
            aSN1EncodableVector.m27141a(this.f31088g);
        }
        if (this.f31089h != null) {
            aSN1EncodableVector.m27141a(this.f31089h);
        }
        if (this.f31090i != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 0, this.f31090i));
        }
        if (this.f31091j != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 1, this.f31091j));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
