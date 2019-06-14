package org.spongycastle.asn1.ocsp;

import org.spongycastle.asn1.ASN1Enumerated;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;

public class OCSPResponseStatus extends ASN1Object {
    /* renamed from: a */
    private ASN1Enumerated f30930a;

    private OCSPResponseStatus(ASN1Enumerated aSN1Enumerated) {
        this.f30930a = aSN1Enumerated;
    }

    /* renamed from: a */
    public static OCSPResponseStatus m40033a(Object obj) {
        if (obj instanceof OCSPResponseStatus) {
            return (OCSPResponseStatus) obj;
        }
        return obj != null ? new OCSPResponseStatus(ASN1Enumerated.m42946a(obj)) : null;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        return this.f30930a;
    }
}
