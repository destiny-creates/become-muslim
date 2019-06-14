package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.crmf.CertId;
import org.spongycastle.asn1.x509.Extensions;

public class RevAnnContent extends ASN1Object {
    /* renamed from: a */
    private PKIStatus f30516a;
    /* renamed from: b */
    private CertId f30517b;
    /* renamed from: c */
    private ASN1GeneralizedTime f30518c;
    /* renamed from: d */
    private ASN1GeneralizedTime f30519d;
    /* renamed from: e */
    private Extensions f30520e;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30516a);
        aSN1EncodableVector.m27141a(this.f30517b);
        aSN1EncodableVector.m27141a(this.f30518c);
        aSN1EncodableVector.m27141a(this.f30519d);
        if (this.f30520e != null) {
            aSN1EncodableVector.m27141a(this.f30520e);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
