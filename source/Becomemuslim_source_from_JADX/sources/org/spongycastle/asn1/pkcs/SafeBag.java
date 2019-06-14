package org.spongycastle.asn1.pkcs;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DLSequence;
import org.spongycastle.asn1.DLTaggedObject;

public class SafeBag extends ASN1Object {
    /* renamed from: a */
    private ASN1ObjectIdentifier f31042a;
    /* renamed from: b */
    private ASN1Encodable f31043b;
    /* renamed from: c */
    private ASN1Set f31044c;

    public SafeBag(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable, ASN1Set aSN1Set) {
        this.f31042a = aSN1ObjectIdentifier;
        this.f31043b = aSN1Encodable;
        this.f31044c = aSN1Set;
    }

    /* renamed from: a */
    public static SafeBag m40154a(Object obj) {
        if (obj instanceof SafeBag) {
            return (SafeBag) obj;
        }
        return obj != null ? new SafeBag(ASN1Sequence.m43000a(obj)) : null;
    }

    private SafeBag(ASN1Sequence aSN1Sequence) {
        this.f31042a = (ASN1ObjectIdentifier) aSN1Sequence.mo6860a(0);
        this.f31043b = ((ASN1TaggedObject) aSN1Sequence.mo6860a(1)).m43036k();
        if (aSN1Sequence.mo6862g() == 3) {
            this.f31044c = (ASN1Set) aSN1Sequence.mo6860a(2);
        }
    }

    /* renamed from: a */
    public ASN1ObjectIdentifier m40155a() {
        return this.f31042a;
    }

    /* renamed from: b */
    public ASN1Encodable m40156b() {
        return this.f31043b;
    }

    /* renamed from: c */
    public ASN1Set m40157c() {
        return this.f31044c;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f31042a);
        aSN1EncodableVector.m27141a(new DLTaggedObject(true, 0, this.f31043b));
        if (this.f31044c != null) {
            aSN1EncodableVector.m27141a(this.f31044c);
        }
        return new DLSequence(aSN1EncodableVector);
    }
}
