package org.spongycastle.asn1.x500;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1String;

public class DirectoryString extends ASN1Object implements ASN1Choice, ASN1String {
    /* renamed from: a */
    private ASN1String f31117a;

    /* renamed from: b */
    public String mo6440b() {
        return this.f31117a.mo6440b();
    }

    public String toString() {
        return this.f31117a.mo6440b();
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        return ((ASN1Encodable) this.f31117a).mo5709e();
    }
}
