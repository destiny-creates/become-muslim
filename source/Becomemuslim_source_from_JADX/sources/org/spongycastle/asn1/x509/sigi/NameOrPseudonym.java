package org.spongycastle.asn1.x509.sigi;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x500.DirectoryString;

public class NameOrPseudonym extends ASN1Object implements ASN1Choice {
    /* renamed from: a */
    private DirectoryString f31508a;
    /* renamed from: b */
    private DirectoryString f31509b;
    /* renamed from: c */
    private ASN1Sequence f31510c;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        if (this.f31508a != null) {
            return this.f31508a.mo5709e();
        }
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f31509b);
        aSN1EncodableVector.m27141a(this.f31510c);
        return new DERSequence(aSN1EncodableVector);
    }
}
