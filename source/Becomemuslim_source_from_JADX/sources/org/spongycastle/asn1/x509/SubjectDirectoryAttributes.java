package org.spongycastle.asn1.x509;

import java.util.Enumeration;
import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class SubjectDirectoryAttributes extends ASN1Object {
    /* renamed from: a */
    private Vector f31376a;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        Enumeration elements = this.f31376a.elements();
        while (elements.hasMoreElements()) {
            aSN1EncodableVector.m27141a((Attribute) elements.nextElement());
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
