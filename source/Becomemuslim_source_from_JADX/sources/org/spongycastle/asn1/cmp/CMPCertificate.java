package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.Certificate;

public class CMPCertificate extends ASN1Object implements ASN1Choice {
    /* renamed from: a */
    private Certificate f30435a;
    /* renamed from: b */
    private int f30436b;
    /* renamed from: c */
    private ASN1Object f30437c;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        if (this.f30437c != null) {
            return new DERTaggedObject(true, this.f30436b, this.f30437c);
        }
        return this.f30435a.mo5709e();
    }
}
