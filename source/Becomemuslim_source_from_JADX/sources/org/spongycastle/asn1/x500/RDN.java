package org.spongycastle.asn1.x500;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERSet;

public class RDN extends ASN1Object {
    /* renamed from: a */
    private ASN1Set f31118a;

    private RDN(ASN1Set aSN1Set) {
        this.f31118a = aSN1Set;
    }

    /* renamed from: a */
    public static RDN m40207a(Object obj) {
        if (obj instanceof RDN) {
            return (RDN) obj;
        }
        return obj != null ? new RDN(ASN1Set.m43012a(obj)) : null;
    }

    public RDN(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a((ASN1Encodable) aSN1ObjectIdentifier);
        aSN1EncodableVector.m27141a(aSN1Encodable);
        this.f31118a = new DERSet(new DERSequence(aSN1EncodableVector));
    }

    public RDN(AttributeTypeAndValue[] attributeTypeAndValueArr) {
        this.f31118a = new DERSet((ASN1Encodable[]) attributeTypeAndValueArr);
    }

    /* renamed from: a */
    public boolean m40208a() {
        return this.f31118a.m43021c() > 1;
    }

    /* renamed from: b */
    public AttributeTypeAndValue m40209b() {
        if (this.f31118a.m43021c() == 0) {
            return null;
        }
        return AttributeTypeAndValue.m40201a(this.f31118a.m43016a(0));
    }

    /* renamed from: c */
    public AttributeTypeAndValue[] m40210c() {
        AttributeTypeAndValue[] attributeTypeAndValueArr = new AttributeTypeAndValue[this.f31118a.m43021c()];
        for (int i = 0; i != attributeTypeAndValueArr.length; i++) {
            attributeTypeAndValueArr[i] = AttributeTypeAndValue.m40201a(this.f31118a.m43016a(i));
        }
        return attributeTypeAndValueArr;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        return this.f31118a;
    }
}
