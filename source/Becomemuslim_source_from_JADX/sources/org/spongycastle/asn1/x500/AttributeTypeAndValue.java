package org.spongycastle.asn1.x500;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class AttributeTypeAndValue extends ASN1Object {
    /* renamed from: a */
    private ASN1ObjectIdentifier f31115a;
    /* renamed from: b */
    private ASN1Encodable f31116b;

    private AttributeTypeAndValue(ASN1Sequence aSN1Sequence) {
        this.f31115a = (ASN1ObjectIdentifier) aSN1Sequence.mo6860a(0);
        this.f31116b = aSN1Sequence.mo6860a(1);
    }

    /* renamed from: a */
    public static AttributeTypeAndValue m40201a(Object obj) {
        if (obj instanceof AttributeTypeAndValue) {
            return (AttributeTypeAndValue) obj;
        }
        if (obj != null) {
            return new AttributeTypeAndValue(ASN1Sequence.m43000a(obj));
        }
        throw new IllegalArgumentException("null value in getInstance()");
    }

    public AttributeTypeAndValue(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.f31115a = aSN1ObjectIdentifier;
        this.f31116b = aSN1Encodable;
    }

    /* renamed from: a */
    public ASN1ObjectIdentifier m40202a() {
        return this.f31115a;
    }

    /* renamed from: b */
    public ASN1Encodable m40203b() {
        return this.f31116b;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f31115a);
        aSN1EncodableVector.m27141a(this.f31116b);
        return new DERSequence(aSN1EncodableVector);
    }
}
