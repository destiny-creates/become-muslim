package org.spongycastle.asn1.x509.sigi;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERPrintableString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x500.DirectoryString;

public class PersonalData extends ASN1Object {
    /* renamed from: a */
    private NameOrPseudonym f31511a;
    /* renamed from: b */
    private BigInteger f31512b;
    /* renamed from: c */
    private ASN1GeneralizedTime f31513c;
    /* renamed from: d */
    private DirectoryString f31514d;
    /* renamed from: e */
    private String f31515e;
    /* renamed from: f */
    private DirectoryString f31516f;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f31511a);
        if (this.f31512b != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 0, new ASN1Integer(this.f31512b)));
        }
        if (this.f31513c != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 1, this.f31513c));
        }
        if (this.f31514d != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 2, this.f31514d));
        }
        if (this.f31515e != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 3, new DERPrintableString(this.f31515e, true)));
        }
        if (this.f31516f != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 4, this.f31516f));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
