package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;

public class SubjectKeyIdentifier extends ASN1Object {
    /* renamed from: a */
    private byte[] f31377a;

    public SubjectKeyIdentifier(byte[] bArr) {
        this.f31377a = bArr;
    }

    /* renamed from: a */
    public byte[] m40407a() {
        return this.f31377a;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        return new DEROctetString(this.f31377a);
    }
}
