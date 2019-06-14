package org.spongycastle.asn1.ess;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.IssuerSerial;

public class ESSCertIDv2 extends ASN1Object {
    /* renamed from: d */
    private static final AlgorithmIdentifier f30838d = new AlgorithmIdentifier(NISTObjectIdentifiers.f21782c);
    /* renamed from: a */
    private AlgorithmIdentifier f30839a;
    /* renamed from: b */
    private byte[] f30840b;
    /* renamed from: c */
    private IssuerSerial f30841c;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (!this.f30839a.equals(f30838d)) {
            aSN1EncodableVector.m27141a(this.f30839a);
        }
        aSN1EncodableVector.m27141a(new DEROctetString(this.f30840b).mo5709e());
        if (this.f30841c != null) {
            aSN1EncodableVector.m27141a(this.f30841c);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
