package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.BERSequence;
import org.spongycastle.asn1.BERTaggedObject;
import org.spongycastle.asn1.DERTaggedObject;

public class SignedData extends ASN1Object {
    /* renamed from: a */
    private static final ASN1Integer f30626a = new ASN1Integer(1);
    /* renamed from: b */
    private static final ASN1Integer f30627b = new ASN1Integer(3);
    /* renamed from: c */
    private static final ASN1Integer f30628c = new ASN1Integer(4);
    /* renamed from: d */
    private static final ASN1Integer f30629d = new ASN1Integer(5);
    /* renamed from: e */
    private ASN1Integer f30630e;
    /* renamed from: f */
    private ASN1Set f30631f;
    /* renamed from: g */
    private ContentInfo f30632g;
    /* renamed from: h */
    private ASN1Set f30633h;
    /* renamed from: i */
    private ASN1Set f30634i;
    /* renamed from: j */
    private ASN1Set f30635j;
    /* renamed from: k */
    private boolean f30636k;
    /* renamed from: l */
    private boolean f30637l;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30630e);
        aSN1EncodableVector.m27141a(this.f30631f);
        aSN1EncodableVector.m27141a(this.f30632g);
        if (this.f30633h != null) {
            if (this.f30636k) {
                aSN1EncodableVector.m27141a(new BERTaggedObject(false, 0, this.f30633h));
            } else {
                aSN1EncodableVector.m27141a(new DERTaggedObject(false, 0, this.f30633h));
            }
        }
        if (this.f30634i != null) {
            if (this.f30637l) {
                aSN1EncodableVector.m27141a(new BERTaggedObject(false, 1, this.f30634i));
            } else {
                aSN1EncodableVector.m27141a(new DERTaggedObject(false, 1, this.f30634i));
            }
        }
        aSN1EncodableVector.m27141a(this.f30635j);
        return new BERSequence(aSN1EncodableVector);
    }
}
