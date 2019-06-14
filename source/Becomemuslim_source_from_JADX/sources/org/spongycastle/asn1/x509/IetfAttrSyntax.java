package org.spongycastle.asn1.x509;

import java.util.Enumeration;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class IetfAttrSyntax extends ASN1Object {
    /* renamed from: a */
    GeneralNames f31319a;
    /* renamed from: b */
    Vector f31320b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.f31319a != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(0, this.f31319a));
        }
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        Enumeration elements = this.f31320b.elements();
        while (elements.hasMoreElements()) {
            aSN1EncodableVector2.m27141a((ASN1Encodable) elements.nextElement());
        }
        aSN1EncodableVector.m27141a(new DERSequence(aSN1EncodableVector2));
        return new DERSequence(aSN1EncodableVector);
    }
}
