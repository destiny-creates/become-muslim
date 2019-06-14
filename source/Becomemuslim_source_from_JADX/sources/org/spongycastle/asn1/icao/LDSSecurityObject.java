package org.spongycastle.asn1.icao;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class LDSSecurityObject extends ASN1Object implements ICAOObjectIdentifiers {
    /* renamed from: k */
    private ASN1Integer f30854k;
    /* renamed from: l */
    private AlgorithmIdentifier f30855l;
    /* renamed from: m */
    private DataGroupHash[] f30856m;
    /* renamed from: n */
    private LDSVersionInfo f30857n;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30854k);
        aSN1EncodableVector.m27141a(this.f30855l);
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        for (ASN1Encodable a : this.f30856m) {
            aSN1EncodableVector2.m27141a(a);
        }
        aSN1EncodableVector.m27141a(new DERSequence(aSN1EncodableVector2));
        if (this.f30857n != null) {
            aSN1EncodableVector.m27141a(this.f30857n);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
