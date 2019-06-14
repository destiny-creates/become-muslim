package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.BERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class EnvelopedData extends ASN1Object {
    /* renamed from: a */
    private ASN1Integer f30566a;
    /* renamed from: b */
    private OriginatorInfo f30567b;
    /* renamed from: c */
    private ASN1Set f30568c;
    /* renamed from: d */
    private EncryptedContentInfo f30569d;
    /* renamed from: e */
    private ASN1Set f30570e;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30566a);
        if (this.f30567b != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 0, this.f30567b));
        }
        aSN1EncodableVector.m27141a(this.f30568c);
        aSN1EncodableVector.m27141a(this.f30569d);
        if (this.f30570e != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 1, this.f30570e));
        }
        return new BERSequence(aSN1EncodableVector);
    }
}
