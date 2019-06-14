package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1Boolean;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERUTF8String;

public class MetaData extends ASN1Object {
    /* renamed from: a */
    private ASN1Boolean f30596a;
    /* renamed from: b */
    private DERUTF8String f30597b;
    /* renamed from: c */
    private DERIA5String f30598c;
    /* renamed from: d */
    private Attributes f30599d;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30596a);
        if (this.f30597b != null) {
            aSN1EncodableVector.m27141a(this.f30597b);
        }
        if (this.f30598c != null) {
            aSN1EncodableVector.m27141a(this.f30598c);
        }
        if (this.f30599d != null) {
            aSN1EncodableVector.m27141a(this.f30599d);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
