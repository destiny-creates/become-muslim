package org.spongycastle.crypto.digests;

import org.spongycastle.crypto.ExtendedDigest;

public class ShortenedDigest implements ExtendedDigest {
    /* renamed from: a */
    private ExtendedDigest f31621a;
    /* renamed from: b */
    private int f31622b;

    /* renamed from: a */
    public String mo5729a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f31621a.mo5729a());
        stringBuilder.append("(");
        stringBuilder.append(this.f31622b * 8);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    /* renamed from: b */
    public int mo5732b() {
        return this.f31622b;
    }

    /* renamed from: a */
    public void mo5730a(byte b) {
        this.f31621a.mo5730a(b);
    }

    /* renamed from: a */
    public void mo5731a(byte[] bArr, int i, int i2) {
        this.f31621a.mo5731a(bArr, i, i2);
    }

    /* renamed from: a */
    public int mo5728a(byte[] bArr, int i) {
        Object obj = new byte[this.f31621a.mo5732b()];
        this.f31621a.mo5728a(obj, 0);
        System.arraycopy(obj, 0, bArr, i, this.f31622b);
        return this.f31622b;
    }

    /* renamed from: c */
    public void mo5733c() {
        this.f31621a.mo5733c();
    }

    /* renamed from: d */
    public int mo6445d() {
        return this.f31621a.mo6445d();
    }
}
