package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.Arrays;

public final class yv implements ts {
    /* renamed from: a */
    private final zh f24411a;
    /* renamed from: b */
    private final ue f24412b;
    /* renamed from: c */
    private final int f24413c;

    public yv(zh zhVar, ue ueVar, int i) {
        this.f24411a = zhVar;
        this.f24412b = ueVar;
        this.f24413c = i;
    }

    /* renamed from: a */
    public final byte[] mo4385a(byte[] bArr, byte[] bArr2) {
        bArr = this.f24411a.mo4391a(bArr);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] copyOf = Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8);
        copyOf = this.f24412b.mo4393a(yi.m20169a(bArr2, bArr, copyOf));
        return yi.m20169a(bArr, copyOf);
    }
}
