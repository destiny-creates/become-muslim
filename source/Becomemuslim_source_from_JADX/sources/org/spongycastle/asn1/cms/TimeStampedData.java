package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.BERSequence;
import org.spongycastle.asn1.DERIA5String;

public class TimeStampedData extends ASN1Object {
    /* renamed from: a */
    private ASN1Integer f30650a;
    /* renamed from: b */
    private DERIA5String f30651b;
    /* renamed from: c */
    private MetaData f30652c;
    /* renamed from: d */
    private ASN1OctetString f30653d;
    /* renamed from: e */
    private Evidence f30654e;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30650a);
        if (this.f30651b != null) {
            aSN1EncodableVector.m27141a(this.f30651b);
        }
        if (this.f30652c != null) {
            aSN1EncodableVector.m27141a(this.f30652c);
        }
        if (this.f30653d != null) {
            aSN1EncodableVector.m27141a(this.f30653d);
        }
        aSN1EncodableVector.m27141a(this.f30654e);
        return new BERSequence(aSN1EncodableVector);
    }
}
