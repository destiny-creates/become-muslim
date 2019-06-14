package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.BERSequence;
import org.spongycastle.asn1.BERTaggedObject;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class EncryptedContentInfo extends ASN1Object {
    /* renamed from: a */
    private ASN1ObjectIdentifier f30560a;
    /* renamed from: b */
    private AlgorithmIdentifier f30561b;
    /* renamed from: c */
    private ASN1OctetString f30562c;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30560a);
        aSN1EncodableVector.m27141a(this.f30561b);
        if (this.f30562c != null) {
            aSN1EncodableVector.m27141a(new BERTaggedObject(false, 0, this.f30562c));
        }
        return new BERSequence(aSN1EncodableVector);
    }
}
