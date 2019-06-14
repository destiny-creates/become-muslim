package org.spongycastle.asn1.isismtt.x509;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.GeneralName;

public class AdmissionSyntax extends ASN1Object {
    /* renamed from: a */
    private GeneralName f30866a;
    /* renamed from: b */
    private ASN1Sequence f30867b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.f30866a != null) {
            aSN1EncodableVector.m27141a(this.f30866a);
        }
        aSN1EncodableVector.m27141a(this.f30867b);
        return new DERSequence(aSN1EncodableVector);
    }
}
