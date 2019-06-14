package com.google.android.exoplayer2.p135b;

import android.annotation.TargetApi;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCodec.CryptoInfo.Pattern;
import com.google.android.exoplayer2.p164l.C2541v;

/* compiled from: CryptoInfo */
/* renamed from: com.google.android.exoplayer2.b.b */
public final class C2247b {
    /* renamed from: a */
    public byte[] f5355a;
    /* renamed from: b */
    public byte[] f5356b;
    /* renamed from: c */
    public int f5357c;
    /* renamed from: d */
    public int[] f5358d;
    /* renamed from: e */
    public int[] f5359e;
    /* renamed from: f */
    public int f5360f;
    /* renamed from: g */
    public int f5361g;
    /* renamed from: h */
    public int f5362h;
    /* renamed from: i */
    private final CryptoInfo f5363i;
    /* renamed from: j */
    private final C2246a f5364j;

    @TargetApi(24)
    /* compiled from: CryptoInfo */
    /* renamed from: com.google.android.exoplayer2.b.b$a */
    private static final class C2246a {
        /* renamed from: a */
        private final CryptoInfo f5353a;
        /* renamed from: b */
        private final Pattern f5354b;

        private C2246a(CryptoInfo cryptoInfo) {
            this.f5353a = cryptoInfo;
            this.f5354b = new Pattern(0, 0);
        }

        /* renamed from: a */
        private void m6209a(int i, int i2) {
            this.f5354b.set(i, i2);
            this.f5353a.setPattern(this.f5354b);
        }
    }

    public C2247b() {
        this.f5363i = C2541v.f6467a >= 16 ? m6211b() : null;
        this.f5364j = C2541v.f6467a >= 24 ? new C2246a(this.f5363i) : null;
    }

    /* renamed from: a */
    public void m6214a(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        this.f5360f = i;
        this.f5358d = iArr;
        this.f5359e = iArr2;
        this.f5356b = bArr;
        this.f5355a = bArr2;
        this.f5357c = i2;
        this.f5361g = i3;
        this.f5362h = i4;
        if (C2541v.f6467a >= 16) {
            m6212c();
        }
    }

    @TargetApi(16)
    /* renamed from: a */
    public CryptoInfo m6213a() {
        return this.f5363i;
    }

    @TargetApi(16)
    /* renamed from: b */
    private CryptoInfo m6211b() {
        return new CryptoInfo();
    }

    @TargetApi(16)
    /* renamed from: c */
    private void m6212c() {
        this.f5363i.numSubSamples = this.f5360f;
        this.f5363i.numBytesOfClearData = this.f5358d;
        this.f5363i.numBytesOfEncryptedData = this.f5359e;
        this.f5363i.key = this.f5356b;
        this.f5363i.iv = this.f5355a;
        this.f5363i.mode = this.f5357c;
        if (C2541v.f6467a >= 24) {
            this.f5364j.m6209a(this.f5361g, this.f5362h);
        }
    }
}
