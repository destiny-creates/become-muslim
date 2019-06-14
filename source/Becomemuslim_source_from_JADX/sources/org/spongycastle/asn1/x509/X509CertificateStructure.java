package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;

public class X509CertificateStructure extends ASN1Object implements PKCSObjectIdentifiers, X509ObjectIdentifiers {
    ASN1Sequence bF;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        return this.bF;
    }
}
