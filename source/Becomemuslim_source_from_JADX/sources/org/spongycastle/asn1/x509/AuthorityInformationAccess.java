package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class AuthorityInformationAccess extends ASN1Object {
    /* renamed from: a */
    private AccessDescription[] f31236a;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        for (int i = 0; i != this.f31236a.length; i++) {
            aSN1EncodableVector.m27141a(this.f31236a[i]);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AuthorityInformationAccess: Oid(");
        stringBuilder.append(this.f31236a[0].m40226a().m42986b());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
