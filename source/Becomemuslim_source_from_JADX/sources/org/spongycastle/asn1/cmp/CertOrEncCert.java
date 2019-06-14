package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.crmf.EncryptedValue;

public class CertOrEncCert extends ASN1Object implements ASN1Choice {
    /* renamed from: a */
    private CMPCertificate f30440a;
    /* renamed from: b */
    private EncryptedValue f30441b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        if (this.f30440a != null) {
            return new DERTaggedObject(true, 0, this.f30440a);
        }
        return new DERTaggedObject(true, 1, this.f30441b);
    }
}
