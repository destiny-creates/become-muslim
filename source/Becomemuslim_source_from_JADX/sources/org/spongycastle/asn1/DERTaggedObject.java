package org.spongycastle.asn1;

public class DERTaggedObject extends ASN1TaggedObject {
    /* renamed from: e */
    private static final byte[] f32854e = new byte[0];

    public DERTaggedObject(boolean z, int i, ASN1Encodable aSN1Encodable) {
        super(z, i, aSN1Encodable);
    }

    public DERTaggedObject(int i, ASN1Encodable aSN1Encodable) {
        super(true, i, aSN1Encodable);
    }

    /* renamed from: a */
    boolean mo6788a() {
        if (this.b || this.c) {
            return true;
        }
        return this.d.mo5709e().mo6791h().mo6788a();
    }

    /* renamed from: d */
    int mo6790d() {
        if (this.b) {
            return StreamUtil.m27170b(this.a) + 1;
        }
        int d = this.d.mo5709e().mo6791h().mo6790d();
        if (this.c) {
            return (StreamUtil.m27170b(this.a) + StreamUtil.m27168a(d)) + d;
        }
        return StreamUtil.m27170b(this.a) + (d - 1);
    }

    /* renamed from: a */
    void mo6787a(ASN1OutputStream aSN1OutputStream) {
        int i = 160;
        if (this.b) {
            aSN1OutputStream.m27145a(160, this.a, f32854e);
            return;
        }
        ASN1Primitive h = this.d.mo5709e().mo6791h();
        if (this.c) {
            aSN1OutputStream.m27144a(160, this.a);
            aSN1OutputStream.m27143a(h.mo6790d());
            aSN1OutputStream.mo5713a((ASN1Encodable) h);
            return;
        }
        if (!h.mo6788a()) {
            i = 128;
        }
        aSN1OutputStream.m27144a(i, this.a);
        aSN1OutputStream.m27148a(h);
    }
}
