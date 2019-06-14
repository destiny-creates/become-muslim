package org.spongycastle.jce;

import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.x509.KeyUsage;

public class X509KeyUsage extends ASN1Object {
    /* renamed from: a */
    private int f31991a;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        return new KeyUsage(this.f31991a).mo5709e();
    }
}
