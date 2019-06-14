package org.spongycastle.crypto.digests;

import org.spongycastle.util.Memoable;
import org.spongycastle.util.Pack;

public class SHA384Digest extends LongDigest {
    /* renamed from: a */
    public String mo5729a() {
        return "SHA-384";
    }

    /* renamed from: b */
    public int mo5732b() {
        return 48;
    }

    public SHA384Digest(SHA384Digest sHA384Digest) {
        super(sHA384Digest);
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
        mo5733c();
        return 48;
    }

    /* renamed from: c */
    public void mo5733c() {
        super.mo5733c();
        this.a = -3766243637369397544L;
        this.b = 7105036623409894663L;
        this.c = -7973340178411365097L;
        this.d = 1526699215303891257L;
        this.e = 7436329637833083697L;
        this.f = -8163818279084223215L;
        this.g = -2662702644619276377L;
        this.h = 5167115440072839076L;
    }

    /* renamed from: e */
    public Memoable mo5735e() {
        return new SHA384Digest(this);
    }

    /* renamed from: a */
    public void mo5734a(Memoable memoable) {
        super.m40612a((SHA384Digest) memoable);
    }
}
