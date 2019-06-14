package org.spongycastle.asn1;

import java.util.Enumeration;

class LazyEncodedSequence extends ASN1Sequence {
    /* renamed from: b */
    private byte[] f32858b;

    LazyEncodedSequence(byte[] bArr) {
        this.f32858b = bArr;
    }

    /* renamed from: j */
    private void m44402j() {
        Enumeration lazyConstructionEnumeration = new LazyConstructionEnumeration(this.f32858b);
        while (lazyConstructionEnumeration.hasMoreElements()) {
            this.a.addElement(lazyConstructionEnumeration.nextElement());
        }
        this.f32858b = null;
    }

    /* renamed from: a */
    public synchronized ASN1Encodable mo6860a(int i) {
        if (this.f32858b != null) {
            m44402j();
        }
        return super.mo6860a(i);
    }

    /* renamed from: c */
    public synchronized Enumeration mo6861c() {
        if (this.f32858b == null) {
            return super.mo6861c();
        }
        return new LazyConstructionEnumeration(this.f32858b);
    }

    /* renamed from: g */
    public synchronized int mo6862g() {
        if (this.f32858b != null) {
            m44402j();
        }
        return super.mo6862g();
    }

    /* renamed from: h */
    ASN1Primitive mo6791h() {
        if (this.f32858b != null) {
            m44402j();
        }
        return super.mo6791h();
    }

    /* renamed from: i */
    ASN1Primitive mo6792i() {
        if (this.f32858b != null) {
            m44402j();
        }
        return super.mo6792i();
    }

    /* renamed from: d */
    int mo6790d() {
        if (this.f32858b != null) {
            return (StreamUtil.m27168a(this.f32858b.length) + 1) + this.f32858b.length;
        }
        return super.mo6792i().mo6790d();
    }

    /* renamed from: a */
    void mo6787a(ASN1OutputStream aSN1OutputStream) {
        if (this.f32858b != null) {
            aSN1OutputStream.m27146a(48, this.f32858b);
        } else {
            super.mo6792i().mo6787a(aSN1OutputStream);
        }
    }
}
