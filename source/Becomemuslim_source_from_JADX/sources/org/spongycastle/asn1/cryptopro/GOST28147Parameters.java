package org.spongycastle.asn1.cryptopro;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class GOST28147Parameters extends ASN1Object {
    /* renamed from: a */
    private ASN1OctetString f30708a;
    /* renamed from: b */
    private ASN1ObjectIdentifier f30709b;

    /* renamed from: a */
    public static GOST28147Parameters m39940a(Object obj) {
        if (obj instanceof GOST28147Parameters) {
            return (GOST28147Parameters) obj;
        }
        return obj != null ? new GOST28147Parameters(ASN1Sequence.m43000a(obj)) : null;
    }

    public GOST28147Parameters(ASN1Sequence aSN1Sequence) {
        aSN1Sequence = aSN1Sequence.mo6861c();
        this.f30708a = (ASN1OctetString) aSN1Sequence.nextElement();
        this.f30709b = (ASN1ObjectIdentifier) aSN1Sequence.nextElement();
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30708a);
        aSN1EncodableVector.m27141a(this.f30709b);
        return new DERSequence(aSN1EncodableVector);
    }

    /* renamed from: a */
    public ASN1ObjectIdentifier m39941a() {
        return this.f30709b;
    }

    /* renamed from: b */
    public byte[] m39942b() {
        return this.f30708a.mo6859c();
    }
}
