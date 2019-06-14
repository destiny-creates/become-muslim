package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class yj extends zm {
    /* renamed from: c */
    private static final byte[] f28778c = new byte[16];

    yj(byte[] bArr, int i) {
        super(bArr, i);
    }

    /* renamed from: a */
    private static void m37672a(int[] iArr, int i, int i2, int i3, int i4) {
        iArr[i] = iArr[i] + iArr[i2];
        iArr[i4] = zm.m31252a(iArr[i4] ^ iArr[i], 16);
        iArr[i3] = iArr[i3] + iArr[i4];
        iArr[i2] = zm.m31252a(iArr[i2] ^ iArr[i3], 12);
        iArr[i] = iArr[i] + iArr[i2];
        iArr[i4] = zm.m31252a(iArr[i] ^ iArr[i4], 8);
        iArr[i3] = iArr[i3] + iArr[i4];
        iArr[i2] = zm.m31252a(iArr[i2] ^ iArr[i3], 7);
    }

    /* renamed from: a */
    final int mo6139a() {
        return 12;
    }

    /* renamed from: a */
    final ByteBuffer mo6140a(byte[] bArr, int i) {
        Object obj = new int[16];
        System.arraycopy(zm.f24418a, 0, obj, 0, a.length);
        Object a = zm.m31253a(ByteBuffer.wrap(this.b.m20190a()));
        int i2 = 4;
        System.arraycopy(a, 0, obj, 4, a.length);
        obj[12] = i;
        System.arraycopy(zm.m31253a(ByteBuffer.wrap(bArr)), 0, obj, 13, 3);
        int[] iArr = (int[]) obj.clone();
        int i3 = 0;
        while (i3 < 10) {
            m37672a(iArr, 0, i2, 8, 12);
            m37672a(iArr, 1, 5, 9, 13);
            m37672a(iArr, 2, 6, 10, 14);
            m37672a(iArr, 3, 7, 11, 15);
            m37672a(iArr, 0, 5, 10, 15);
            m37672a(iArr, 1, 6, 11, 12);
            m37672a(iArr, 2, 7, 8, 13);
            m37672a(iArr, 3, 4, 9, 14);
            i3++;
            i2 = 4;
        }
        for (int i4 = 0; i4 < 16; i4++) {
            obj[i4] = obj[i4] + iArr[i4];
        }
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(obj, 0, 16);
        return order;
    }
}
