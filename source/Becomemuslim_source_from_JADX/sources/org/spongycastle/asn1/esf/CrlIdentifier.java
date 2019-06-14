package org.spongycastle.asn1.esf;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1UTCTime;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x500.X500Name;

public class CrlIdentifier extends ASN1Object {
    /* renamed from: a */
    private X500Name f30794a;
    /* renamed from: b */
    private ASN1UTCTime f30795b;
    /* renamed from: c */
    private ASN1Integer f30796c;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30794a.mo5709e());
        aSN1EncodableVector.m27141a(this.f30795b);
        if (this.f30796c != null) {
            aSN1EncodableVector.m27141a(this.f30796c);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
