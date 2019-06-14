package org.spongycastle.crypto.digests;

import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.facebook.stetho.dumpapp.Framer;
import org.spongycastle.util.Memoable;
import org.spongycastle.util.MemoableResetException;

public class SHA512tDigest extends LongDigest {
    /* renamed from: j */
    private int f32606j;
    /* renamed from: k */
    private long f32607k;
    /* renamed from: l */
    private long f32608l;
    /* renamed from: m */
    private long f32609m;
    /* renamed from: n */
    private long f32610n;
    /* renamed from: o */
    private long f32611o;
    /* renamed from: p */
    private long f32612p;
    /* renamed from: q */
    private long f32613q;
    /* renamed from: r */
    private long f32614r;

    public SHA512tDigest(int i) {
        if (i >= 512) {
            throw new IllegalArgumentException("bitLength cannot be >= 512");
        } else if (i % 8 != 0) {
            throw new IllegalArgumentException("bitLength needs to be a multiple of 8");
        } else if (i != BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT) {
            this.f32606j = i / 8;
            m43310a(this.f32606j * 8);
            mo5733c();
        } else {
            throw new IllegalArgumentException("bitLength cannot be 384 use SHA384 instead");
        }
    }

    public SHA512tDigest(SHA512tDigest sHA512tDigest) {
        super(sHA512tDigest);
        this.f32606j = sHA512tDigest.f32606j;
        mo5734a((Memoable) sHA512tDigest);
    }

    /* renamed from: a */
    public String mo5729a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SHA-512/");
        stringBuilder.append(Integer.toString(this.f32606j * 8));
        return stringBuilder.toString();
    }

    /* renamed from: b */
    public int mo5732b() {
        return this.f32606j;
    }

    /* renamed from: a */
    public int mo5728a(byte[] bArr, int i) {
        m40617f();
        m43312a(this.a, bArr, i, this.f32606j);
        m43312a(this.b, bArr, i + 8, this.f32606j - 8);
        m43312a(this.c, bArr, i + 16, this.f32606j - 16);
        m43312a(this.d, bArr, i + 24, this.f32606j - 24);
        m43312a(this.e, bArr, i + 32, this.f32606j - 32);
        m43312a(this.f, bArr, i + 40, this.f32606j - 40);
        m43312a(this.g, bArr, i + 48, this.f32606j - 48);
        m43312a(this.h, bArr, i + 56, this.f32606j - 56);
        mo5733c();
        return this.f32606j;
    }

    /* renamed from: c */
    public void mo5733c() {
        super.mo5733c();
        this.a = this.f32607k;
        this.b = this.f32608l;
        this.c = this.f32609m;
        this.d = this.f32610n;
        this.e = this.f32611o;
        this.f = this.f32612p;
        this.g = this.f32613q;
        this.h = this.f32614r;
    }

    /* renamed from: a */
    private void m43310a(int i) {
        this.a = -3482333909917012819L;
        this.b = 2216346199247487646L;
        this.c = -7364697282686394994L;
        this.d = 65953792586715988L;
        this.e = -816286391624063116L;
        this.f = 4512832404995164602L;
        this.g = -5033199132376557362L;
        this.h = -124578254951840548L;
        mo5730a((byte) 83);
        mo5730a((byte) 72);
        mo5730a((byte) 65);
        mo5730a((byte) Framer.STDIN_FRAME_PREFIX);
        mo5730a((byte) 53);
        mo5730a((byte) Framer.STDOUT_FRAME_PREFIX);
        mo5730a((byte) Framer.STDERR_FRAME_PREFIX);
        mo5730a((byte) 47);
        if (i > 100) {
            mo5730a((byte) ((i / 100) + 48));
            i %= 100;
            mo5730a((byte) ((i / 10) + 48));
            mo5730a((byte) (byte) ((i % 10) + 48));
        } else if (i > 10) {
            mo5730a((byte) ((i / 10) + 48));
            mo5730a((byte) (byte) ((i % 10) + 48));
        } else {
            mo5730a((byte) (byte) (i + 48));
        }
        m40617f();
        this.f32607k = this.a;
        this.f32608l = this.b;
        this.f32609m = this.c;
        this.f32610n = this.d;
        this.f32611o = this.e;
        this.f32612p = this.f;
        this.f32613q = this.g;
        this.f32614r = this.h;
    }

    /* renamed from: a */
    private static void m43312a(long j, byte[] bArr, int i, int i2) {
        if (i2 > 0) {
            m43311a((int) (j >>> 32), bArr, i, i2);
            if (i2 > 4) {
                m43311a((int) (j & 4294967295L), bArr, i + 4, i2 - 4);
            }
        }
    }

    /* renamed from: a */
    private static void m43311a(int i, byte[] bArr, int i2, int i3) {
        i3 = Math.min(4, i3);
        while (true) {
            i3--;
            if (i3 >= 0) {
                bArr[i2 + i3] = (byte) (i >>> ((3 - i3) * 8));
            } else {
                return;
            }
        }
    }

    /* renamed from: e */
    public Memoable mo5735e() {
        return new SHA512tDigest(this);
    }

    /* renamed from: a */
    public void mo5734a(Memoable memoable) {
        LongDigest longDigest = (SHA512tDigest) memoable;
        if (this.f32606j == longDigest.f32606j) {
            super.m40612a(longDigest);
            this.f32607k = longDigest.f32607k;
            this.f32608l = longDigest.f32608l;
            this.f32609m = longDigest.f32609m;
            this.f32610n = longDigest.f32610n;
            this.f32611o = longDigest.f32611o;
            this.f32612p = longDigest.f32612p;
            this.f32613q = longDigest.f32613q;
            this.f32614r = longDigest.f32614r;
            return;
        }
        throw new MemoableResetException("digestLength inappropriate in other");
    }
}
