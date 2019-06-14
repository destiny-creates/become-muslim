package com.google.android.gms.internal.ads;

public final class zg {
    /* renamed from: a */
    private final byte[] f16123a;

    private zg(byte[] bArr, int i, int i2) {
        this.f16123a = new byte[i2];
        System.arraycopy(bArr, 0, this.f16123a, 0, i2);
    }

    /* renamed from: a */
    public static zg m20189a(byte[] bArr) {
        return bArr == null ? null : new zg(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public final byte[] m20190a() {
        Object obj = new byte[this.f16123a.length];
        System.arraycopy(this.f16123a, 0, obj, 0, this.f16123a.length);
        return obj;
    }
}
