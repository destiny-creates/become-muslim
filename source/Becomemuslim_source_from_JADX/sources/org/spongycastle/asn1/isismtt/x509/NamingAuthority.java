package org.spongycastle.asn1.isismtt.x509;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.isismtt.ISISMTTObjectIdentifiers;
import org.spongycastle.asn1.x500.DirectoryString;

public class NamingAuthority extends ASN1Object {
    /* renamed from: a */
    public static final ASN1ObjectIdentifier f30875a;
    /* renamed from: b */
    private ASN1ObjectIdentifier f30876b;
    /* renamed from: c */
    private String f30877c;
    /* renamed from: d */
    private DirectoryString f30878d;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ISISMTTObjectIdentifiers.f21709o);
        stringBuilder.append(".1");
        f30875a = new ASN1ObjectIdentifier(stringBuilder.toString());
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.f30876b != null) {
            aSN1EncodableVector.m27141a(this.f30876b);
        }
        if (this.f30877c != null) {
            aSN1EncodableVector.m27141a(new DERIA5String(this.f30877c, true));
        }
        if (this.f30878d != null) {
            aSN1EncodableVector.m27141a(this.f30878d);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
