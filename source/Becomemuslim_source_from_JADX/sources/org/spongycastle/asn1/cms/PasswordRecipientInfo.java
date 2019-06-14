package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class PasswordRecipientInfo extends ASN1Object {
    /* renamed from: a */
    private ASN1Integer f30611a;
    /* renamed from: b */
    private AlgorithmIdentifier f30612b;
    /* renamed from: c */
    private AlgorithmIdentifier f30613c;
    /* renamed from: d */
    private ASN1OctetString f30614d;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30611a);
        if (this.f30612b != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 0, this.f30612b));
        }
        aSN1EncodableVector.m27141a(this.f30613c);
        aSN1EncodableVector.m27141a(this.f30614d);
        return new DERSequence(aSN1EncodableVector);
    }
}
