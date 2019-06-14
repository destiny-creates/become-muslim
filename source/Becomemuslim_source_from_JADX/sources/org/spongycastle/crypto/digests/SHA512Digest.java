package org.spongycastle.crypto.digests;

import org.spongycastle.util.Memoable;
import org.spongycastle.util.Pack;

public class SHA512Digest extends LongDigest {
    /* renamed from: a */
    public String mo5729a() {
        return "SHA-512";
    }

    /* renamed from: b */
    public int mo5732b() {
        return 64;
    }

    public SHA512Digest(SHA512Digest sHA512Digest) {
        super(sHA512Digest);
    }

    /* renamed from: a */
    public int mo5728a(byte[] bArr, int i) {
        m40617f();
        Pack.m29401a(this.a, bArr, i);
        Pack.m29401a(this.b, bArr, i + 8);
        Pack.m29401a(this.c, bArr, i + 16);
        Pack.m29401a(this.d, bArr, i + 24);
        Pack.m29401a(this.e, bArr, i + 32);
        Pack.m29401a(this.f, bArr, i + 40);
        Pack.m29401a(this.g, bArr, i + 48);
        Pack.m29401a(this.h, bArr, i + 56);
        mo5733c();
        return 64;
    }

    /* renamed from: c */
    public void mo5733c() {
        super.mo5733c();
        this.a = 7640891576956012808L;
        this.b = -4942790177534073029L;
        this.c = 4354685564936845355L;
        this.d = -6534734903238641935L;
        this.e = 5840696475078001361L;
        this.f = -7276294671716946913L;
        this.g = 2270897969802886507L;
        this.h = 6620516959819538809L;
    }

    /* renamed from: e */
    public Memoable mo5735e() {
        return new SHA512Digest(this);
    }

    /* renamed from: a */
    public void mo5734a(Memoable memoable) {
        m40612a((LongDigest) (SHA512Digest) memoable);
    }
}
