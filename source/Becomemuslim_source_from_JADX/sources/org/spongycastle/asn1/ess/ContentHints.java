package org.spongycastle.asn1.ess;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERUTF8String;

public class ContentHints extends ASN1Object {
    /* renamed from: a */
    private DERUTF8String f30833a;
    /* renamed from: b */
    private ASN1ObjectIdentifier f30834b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.f30833a != null) {
            aSN1EncodableVector.m27141a(this.f30833a);
        }
        aSN1EncodableVector.m27141a(this.f30834b);
        return new DERSequence(aSN1EncodableVector);
    }
}
