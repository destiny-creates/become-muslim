package org.spongycastle.x509;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.x509.Attribute;

public class X509Attribute extends ASN1Object {
    /* renamed from: a */
    Attribute f32190a;

    X509Attribute(ASN1Encodable aSN1Encodable) {
        this.f32190a = Attribute.m40240a(aSN1Encodable);
    }

    /* renamed from: a */
    public String m42151a() {
        return this.f32190a.m40241a().m42986b();
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        return this.f32190a.mo5709e();
    }
}
