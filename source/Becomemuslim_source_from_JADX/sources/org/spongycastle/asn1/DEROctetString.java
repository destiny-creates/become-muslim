package org.spongycastle.asn1;

public class DEROctetString extends ASN1OctetString {
    /* renamed from: a */
    boolean mo6788a() {
        return false;
    }

    public DEROctetString(byte[] bArr) {
        super(bArr);
    }

    /* renamed from: d */
    int mo6790d() {
        return (StreamUtil.m27168a(this.a.length) + 1) + this.a.length;
    }

    /* renamed from: a */
    void mo6787a(ASN1OutputStream aSN1OutputStream) {
        aSN1OutputStream.m27146a(4, this.a);
    }

    /* renamed from: a */
    static void m44380a(DEROutputStream dEROutputStream, byte[] bArr) {
        dEROutputStream.m27146a(4, bArr);
    }
}
