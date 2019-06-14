package com.google.android.gms.internal.ads;

import com.facebook.imageutils.JfifUtil;

public final class zw {
    /* renamed from: a */
    private final byte[] f16133a = new byte[256];
    /* renamed from: b */
    private int f16134b;
    /* renamed from: c */
    private int f16135c;

    public zw(byte[] bArr) {
        int i;
        for (i = 0; i < 256; i++) {
            this.f16133a[i] = (byte) i;
        }
        int i2 = 0;
        for (i = 0; i < 256; i++) {
            i2 = ((i2 + this.f16133a[i]) + bArr[i % bArr.length]) & JfifUtil.MARKER_FIRST_BYTE;
            byte b = this.f16133a[i];
            this.f16133a[i] = this.f16133a[i2];
            this.f16133a[i2] = b;
        }
        this.f16134b = 0;
        this.f16135c = 0;
    }

    /* renamed from: a */
    public final void m20206a(byte[] bArr) {
        int i = this.f16134b;
        int i2 = this.f16135c;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & JfifUtil.MARKER_FIRST_BYTE;
            i2 = (i2 + this.f16133a[i]) & JfifUtil.MARKER_FIRST_BYTE;
            byte b = this.f16133a[i];
            this.f16133a[i] = this.f16133a[i2];
            this.f16133a[i2] = b;
            bArr[i3] = (byte) (bArr[i3] ^ this.f16133a[(this.f16133a[i] + this.f16133a[i2]) & JfifUtil.MARKER_FIRST_BYTE]);
        }
        this.f16134b = i;
        this.f16135c = i2;
    }
}
