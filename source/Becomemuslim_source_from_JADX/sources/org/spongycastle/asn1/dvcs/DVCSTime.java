package org.spongycastle.asn1.dvcs;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.cms.ContentInfo;

public class DVCSTime extends ASN1Object implements ASN1Choice {
    /* renamed from: a */
    private ASN1GeneralizedTime f30747a;
    /* renamed from: b */
    private ContentInfo f30748b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        if (this.f30747a != null) {
            return this.f30747a;
        }
        return this.f30748b != null ? this.f30748b.mo5709e() : null;
    }

    public String toString() {
        if (this.f30747a != null) {
            return this.f30747a.toString();
        }
        return this.f30748b != null ? this.f30748b.toString() : null;
    }
}
