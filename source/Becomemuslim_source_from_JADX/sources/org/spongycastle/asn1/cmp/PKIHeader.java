package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.GeneralName;

public class PKIHeader extends ASN1Object {
    /* renamed from: a */
    public static final GeneralName f30479a = new GeneralName(X500Name.m40212a(new DERSequence()));
    /* renamed from: b */
    private ASN1Integer f30480b;
    /* renamed from: c */
    private GeneralName f30481c;
    /* renamed from: d */
    private GeneralName f30482d;
    /* renamed from: e */
    private ASN1GeneralizedTime f30483e;
    /* renamed from: f */
    private AlgorithmIdentifier f30484f;
    /* renamed from: g */
    private ASN1OctetString f30485g;
    /* renamed from: h */
    private ASN1OctetString f30486h;
    /* renamed from: i */
    private ASN1OctetString f30487i;
    /* renamed from: j */
    private ASN1OctetString f30488j;
    /* renamed from: k */
    private ASN1OctetString f30489k;
    /* renamed from: l */
    private PKIFreeText f30490l;
    /* renamed from: m */
    private ASN1Sequence f30491m;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30480b);
        aSN1EncodableVector.m27141a(this.f30481c);
        aSN1EncodableVector.m27141a(this.f30482d);
        m39852a(aSN1EncodableVector, 0, this.f30483e);
        m39852a(aSN1EncodableVector, 1, this.f30484f);
        m39852a(aSN1EncodableVector, 2, this.f30485g);
        m39852a(aSN1EncodableVector, 3, this.f30486h);
        m39852a(aSN1EncodableVector, 4, this.f30487i);
        m39852a(aSN1EncodableVector, 5, this.f30488j);
        m39852a(aSN1EncodableVector, 6, this.f30489k);
        m39852a(aSN1EncodableVector, 7, this.f30490l);
        m39852a(aSN1EncodableVector, 8, this.f30491m);
        return new DERSequence(aSN1EncodableVector);
    }

    /* renamed from: a */
    private void m39852a(ASN1EncodableVector aSN1EncodableVector, int i, ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, i, aSN1Encodable));
        }
    }
}
