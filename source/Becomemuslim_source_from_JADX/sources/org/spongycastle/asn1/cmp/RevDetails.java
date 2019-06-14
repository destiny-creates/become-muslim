package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.crmf.CertTemplate;
import org.spongycastle.asn1.x509.Extensions;

public class RevDetails extends ASN1Object {
    /* renamed from: a */
    private CertTemplate f30521a;
    /* renamed from: b */
    private Extensions f30522b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30521a);
        if (this.f30522b != null) {
            aSN1EncodableVector.m27141a(this.f30522b);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
