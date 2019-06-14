package org.spongycastle.asn1.misc;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;

public class IDEACBCPar extends ASN1Object {
    /* renamed from: a */
    ASN1OctetString f30910a;

    public IDEACBCPar(byte[] bArr) {
        this.f30910a = new DEROctetString(bArr);
    }

    public IDEACBCPar(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo6862g() == 1) {
            this.f30910a = (ASN1OctetString) aSN1Sequence.mo6860a(0);
        } else {
            this.f30910a = null;
        }
    }

    /* renamed from: a */
    public byte[] m40022a() {
        return this.f30910a != null ? this.f30910a.mo6859c() : null;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.f30910a != null) {
            aSN1EncodableVector.m27141a(this.f30910a);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
