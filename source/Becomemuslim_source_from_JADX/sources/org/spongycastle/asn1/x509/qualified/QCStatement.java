package org.spongycastle.asn1.x509.qualified;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class QCStatement extends ASN1Object implements ETSIQCObjectIdentifiers, RFC3739QCObjectIdentifiers {
    /* renamed from: e */
    ASN1ObjectIdentifier f31503e;
    /* renamed from: f */
    ASN1Encodable f31504f;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f31503e);
        if (this.f31504f != null) {
            aSN1EncodableVector.m27141a(this.f31504f);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
