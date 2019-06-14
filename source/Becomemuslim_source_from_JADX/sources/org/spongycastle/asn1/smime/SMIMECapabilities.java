package org.spongycastle.asn1.smime;

import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;

public class SMIMECapabilities extends ASN1Object {
    /* renamed from: a */
    public static final ASN1ObjectIdentifier f31054a = PKCSObjectIdentifiers.ar;
    /* renamed from: b */
    public static final ASN1ObjectIdentifier f31055b = PKCSObjectIdentifiers.as;
    /* renamed from: c */
    public static final ASN1ObjectIdentifier f31056c = PKCSObjectIdentifiers.at;
    /* renamed from: d */
    public static final ASN1ObjectIdentifier f31057d = NISTObjectIdentifiers.f21769E;
    /* renamed from: e */
    public static final ASN1ObjectIdentifier f31058e = NISTObjectIdentifiers.f21803x;
    /* renamed from: f */
    public static final ASN1ObjectIdentifier f31059f = NISTObjectIdentifiers.f21796q;
    /* renamed from: g */
    public static final ASN1ObjectIdentifier f31060g = new ASN1ObjectIdentifier("1.3.6.1.4.1.188.7.1.1.2");
    /* renamed from: h */
    public static final ASN1ObjectIdentifier f31061h = new ASN1ObjectIdentifier("1.2.840.113533.7.66.10");
    /* renamed from: i */
    public static final ASN1ObjectIdentifier f31062i = new ASN1ObjectIdentifier("1.3.14.3.2.7");
    /* renamed from: j */
    public static final ASN1ObjectIdentifier f31063j = PKCSObjectIdentifiers.f21835B;
    /* renamed from: k */
    public static final ASN1ObjectIdentifier f31064k = PKCSObjectIdentifiers.f21836C;
    /* renamed from: l */
    private ASN1Sequence f31065l;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        return this.f31065l;
    }
}
