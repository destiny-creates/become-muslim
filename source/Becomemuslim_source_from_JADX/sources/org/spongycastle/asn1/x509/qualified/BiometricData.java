package org.spongycastle.asn1.x509.qualified;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class BiometricData extends ASN1Object {
    /* renamed from: a */
    private TypeOfBiometricData f31495a;
    /* renamed from: b */
    private AlgorithmIdentifier f31496b;
    /* renamed from: c */
    private ASN1OctetString f31497c;
    /* renamed from: d */
    private DERIA5String f31498d;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f31495a);
        aSN1EncodableVector.m27141a(this.f31496b);
        aSN1EncodableVector.m27141a(this.f31497c);
        if (this.f31498d != null) {
            aSN1EncodableVector.m27141a(this.f31498d);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
