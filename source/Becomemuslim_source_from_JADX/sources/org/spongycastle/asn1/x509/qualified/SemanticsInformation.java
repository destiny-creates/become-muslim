package org.spongycastle.asn1.x509.qualified;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.GeneralName;

public class SemanticsInformation extends ASN1Object {
    /* renamed from: a */
    private ASN1ObjectIdentifier f31505a;
    /* renamed from: b */
    private GeneralName[] f31506b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.f31505a != null) {
            aSN1EncodableVector.m27141a(this.f31505a);
        }
        if (this.f31506b != null) {
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
            for (ASN1Encodable a : this.f31506b) {
                aSN1EncodableVector2.m27141a(a);
            }
            aSN1EncodableVector.m27141a(new DERSequence(aSN1EncodableVector2));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
