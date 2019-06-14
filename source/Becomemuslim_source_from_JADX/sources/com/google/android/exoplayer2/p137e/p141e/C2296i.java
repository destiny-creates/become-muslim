package com.google.android.exoplayer2.p137e.p141e;

import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.p164l.C2516a;

/* compiled from: VorbisBitArray */
/* renamed from: com.google.android.exoplayer2.e.e.i */
final class C2296i {
    /* renamed from: a */
    private final byte[] f5646a;
    /* renamed from: b */
    private final int f5647b;
    /* renamed from: c */
    private int f5648c;
    /* renamed from: d */
    private int f5649d;

    public C2296i(byte[] bArr) {
        this.f5646a = bArr;
        this.f5647b = bArr.length;
    }

    /* renamed from: a */
    public boolean m6357a() {
        boolean z = (((this.f5646a[this.f5648c] & JfifUtil.MARKER_FIRST_BYTE) >> this.f5649d) & 1) == 1;
        m6359b(1);
        return z;
    }

    /* renamed from: a */
    public int m6356a(int i) {
        int i2 = this.f5648c;
        int min = Math.min(i, 8 - this.f5649d);
        int i3 = i2 + 1;
        i2 = ((this.f5646a[i2] & JfifUtil.MARKER_FIRST_BYTE) >> this.f5649d) & (JfifUtil.MARKER_FIRST_BYTE >> (8 - min));
        while (min < i) {
            i2 |= (this.f5646a[i3] & JfifUtil.MARKER_FIRST_BYTE) << min;
            min += 8;
            i3++;
        }
        i2 &= -1 >>> (32 - i);
        m6359b(i);
        return i2;
    }

    /* renamed from: b */
    public void m6359b(int i) {
        int i2 = i / 8;
        this.f5648c += i2;
        this.f5649d += i - (i2 * 8);
        if (this.f5649d > 7) {
            this.f5648c++;
            this.f5649d -= 8;
        }
        m6355c();
    }

    /* renamed from: b */
    public int m6358b() {
        return (this.f5648c * 8) + this.f5649d;
    }

    /* renamed from: c */
    private void m6355c() {
        boolean z = this.f5648c >= 0 && (this.f5648c < this.f5647b || (this.f5648c == this.f5647b && this.f5649d == 0));
        C2516a.m7019b(z);
    }
}
