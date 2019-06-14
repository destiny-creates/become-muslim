package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.BERSequence;
import org.spongycastle.asn1.BERTaggedObject;

public class EncryptedData extends ASN1Object {
    /* renamed from: a */
    private ASN1Integer f30563a;
    /* renamed from: b */
    private EncryptedContentInfo f30564b;
    /* renamed from: c */
    private ASN1Set f30565c;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30563a);
        aSN1EncodableVector.m27141a(this.f30564b);
        if (this.f30565c != null) {
            aSN1EncodableVector.m27141a(new BERTaggedObject(false, 1, this.f30565c));
        }
        return new BERSequence(aSN1EncodableVector);
    }
}
