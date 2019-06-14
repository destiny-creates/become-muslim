package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.BERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class AuthenticatedData extends ASN1Object {
    /* renamed from: a */
    private ASN1Integer f30537a;
    /* renamed from: b */
    private OriginatorInfo f30538b;
    /* renamed from: c */
    private ASN1Set f30539c;
    /* renamed from: d */
    private AlgorithmIdentifier f30540d;
    /* renamed from: e */
    private AlgorithmIdentifier f30541e;
    /* renamed from: f */
    private ContentInfo f30542f;
    /* renamed from: g */
    private ASN1Set f30543g;
    /* renamed from: h */
    private ASN1OctetString f30544h;
    /* renamed from: i */
    private ASN1Set f30545i;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30537a);
        if (this.f30538b != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 0, this.f30538b));
        }
        aSN1EncodableVector.m27141a(this.f30539c);
        aSN1EncodableVector.m27141a(this.f30540d);
        if (this.f30541e != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 1, this.f30541e));
        }
        aSN1EncodableVector.m27141a(this.f30542f);
        if (this.f30543g != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 2, this.f30543g));
        }
        aSN1EncodableVector.m27141a(this.f30544h);
        if (this.f30545i != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 3, this.f30545i));
        }
        return new BERSequence(aSN1EncodableVector);
    }
}
