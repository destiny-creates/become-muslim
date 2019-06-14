package org.spongycastle.crypto.digests;

import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.crypto.params.SkeinParameters;
import org.spongycastle.util.Memoable;

public class SkeinDigest implements ExtendedDigest, Memoable {
    /* renamed from: a */
    private SkeinEngine f31623a;

    public SkeinDigest(int i, int i2) {
        this.f31623a = new SkeinEngine(i, i2);
        m40648a((SkeinParameters) 0);
    }

    public SkeinDigest(SkeinDigest skeinDigest) {
        this.f31623a = new SkeinEngine(skeinDigest.f31623a);
    }

    /* renamed from: a */
    public void mo5734a(Memoable memoable) {
        this.f31623a.mo5734a(((SkeinDigest) memoable).f31623a);
    }

    /* renamed from: e */
    public Memoable mo5735e() {
        return new SkeinDigest(this);
    }

    /* renamed from: a */
    public String mo5729a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Skein-");
        stringBuilder.append(this.f31623a.m34748b() * 8);
        stringBuilder.append("-");
        stringBuilder.append(this.f31623a.m34742a() * 8);
        return stringBuilder.toString();
    }

    /* renamed from: b */
    public int mo5732b() {
        return this.f31623a.m34742a();
    }

    /* renamed from: d */
    public int mo6445d() {
        return this.f31623a.m34748b();
    }

    /* renamed from: a */
    public void m40648a(SkeinParameters skeinParameters) {
        this.f31623a.m34745a(skeinParameters);
    }

    /* renamed from: c */
    public void mo5733c() {
        this.f31623a.m34749c();
    }

    /* renamed from: a */
    public void mo5730a(byte b) {
        this.f31623a.m34744a(b);
    }

    /* renamed from: a */
    public void mo5731a(byte[] bArr, int i, int i2) {
        this.f31623a.m34747a(bArr, i, i2);
    }

    /* renamed from: a */
    public int mo5728a(byte[] bArr, int i) {
        return this.f31623a.m34743a(bArr, i);
    }
}
