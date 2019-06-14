package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class AccessDescription extends ASN1Object {
    /* renamed from: a */
    public static final ASN1ObjectIdentifier f31212a = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.48.2");
    /* renamed from: b */
    public static final ASN1ObjectIdentifier f31213b = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.48.1");
    /* renamed from: c */
    ASN1ObjectIdentifier f31214c;
    /* renamed from: d */
    GeneralName f31215d;

    /* renamed from: a */
    public ASN1ObjectIdentifier m40226a() {
        return this.f31214c;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f31214c);
        aSN1EncodableVector.m27141a(this.f31215d);
        return new DERSequence(aSN1EncodableVector);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AccessDescription: Oid(");
        stringBuilder.append(this.f31214c.m42986b());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
