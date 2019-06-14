package org.spongycastle.asn1.crmf;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.GeneralName;

public class CertId extends ASN1Object {
    /* renamed from: a */
    private GeneralName f30662a;
    /* renamed from: b */
    private ASN1Integer f30663b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30662a);
        aSN1EncodableVector.m27141a(this.f30663b);
        return new DERSequence(aSN1EncodableVector);
    }
}
