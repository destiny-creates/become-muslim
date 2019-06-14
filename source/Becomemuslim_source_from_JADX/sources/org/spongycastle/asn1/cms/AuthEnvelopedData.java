package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.BERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class AuthEnvelopedData extends ASN1Object {
    /* renamed from: a */
    private ASN1Integer f30530a;
    /* renamed from: b */
    private OriginatorInfo f30531b;
    /* renamed from: c */
    private ASN1Set f30532c;
    /* renamed from: d */
    private EncryptedContentInfo f30533d;
    /* renamed from: e */
    private ASN1Set f30534e;
    /* renamed from: f */
    private ASN1OctetString f30535f;
    /* renamed from: g */
    private ASN1Set f30536g;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30530a);
        if (this.f30531b != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 0, this.f30531b));
        }
        aSN1EncodableVector.m27141a(this.f30532c);
        aSN1EncodableVector.m27141a(this.f30533d);
        if (this.f30534e != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 1, this.f30534e));
        }
        aSN1EncodableVector.m27141a(this.f30535f);
        if (this.f30536g != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 2, this.f30536g));
        }
        return new BERSequence(aSN1EncodableVector);
    }
}
