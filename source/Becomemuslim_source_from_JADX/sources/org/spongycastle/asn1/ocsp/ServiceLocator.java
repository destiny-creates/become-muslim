package org.spongycastle.asn1.ocsp;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x509.AuthorityInformationAccess;

public class ServiceLocator extends ASN1Object {
    /* renamed from: a */
    private final X500Name f30945a;
    /* renamed from: b */
    private final AuthorityInformationAccess f30946b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30945a);
        if (this.f30946b != null) {
            aSN1EncodableVector.m27141a(this.f30946b);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
