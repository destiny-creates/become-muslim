package org.spongycastle.asn1.smime;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;

public class SMIMECapability extends ASN1Object {
    /* renamed from: a */
    public static final ASN1ObjectIdentifier f31066a = PKCSObjectIdentifiers.ar;
    /* renamed from: b */
    public static final ASN1ObjectIdentifier f31067b = PKCSObjectIdentifiers.as;
    /* renamed from: c */
    public static final ASN1ObjectIdentifier f31068c = PKCSObjectIdentifiers.at;
    /* renamed from: d */
    public static final ASN1ObjectIdentifier f31069d = new ASN1ObjectIdentifier("1.3.14.3.2.7");
    /* renamed from: e */
    public static final ASN1ObjectIdentifier f31070e = PKCSObjectIdentifiers.f21835B;
    /* renamed from: f */
    public static final ASN1ObjectIdentifier f31071f = PKCSObjectIdentifiers.f21836C;
    /* renamed from: g */
    public static final ASN1ObjectIdentifier f31072g = NISTObjectIdentifiers.f21796q;
    /* renamed from: h */
    public static final ASN1ObjectIdentifier f31073h = NISTObjectIdentifiers.f21803x;
    /* renamed from: i */
    public static final ASN1ObjectIdentifier f31074i = NISTObjectIdentifiers.f21769E;
    /* renamed from: j */
    private ASN1ObjectIdentifier f31075j;
    /* renamed from: k */
    private ASN1Encodable f31076k;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f31075j);
        if (this.f31076k != null) {
            aSN1EncodableVector.m27141a(this.f31076k);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
