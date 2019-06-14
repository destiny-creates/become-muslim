package org.spongycastle.asn1.isismtt.x509;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERPrintableString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x500.DirectoryString;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.IssuerSerial;

public class ProcurationSyntax extends ASN1Object {
    /* renamed from: a */
    private String f30879a;
    /* renamed from: b */
    private DirectoryString f30880b;
    /* renamed from: c */
    private GeneralName f30881c;
    /* renamed from: d */
    private IssuerSerial f30882d;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.f30879a != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 1, new DERPrintableString(this.f30879a, true)));
        }
        if (this.f30880b != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 2, this.f30880b));
        }
        if (this.f30881c != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 3, this.f30881c));
        } else {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 3, this.f30882d));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
