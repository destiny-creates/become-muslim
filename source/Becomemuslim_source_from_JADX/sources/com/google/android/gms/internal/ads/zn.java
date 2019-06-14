package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;

abstract class zn implements ts {
    /* renamed from: a */
    private final byte[] f24421a;
    /* renamed from: b */
    private final zm f24422b;
    /* renamed from: c */
    private final zm f24423c;

    zn(byte[] bArr) {
        this.f24421a = (byte[]) bArr.clone();
        this.f24422b = mo6141a(bArr, 1);
        this.f24423c = mo6141a(bArr, 0);
    }

    /* renamed from: a */
    abstract zm mo6141a(byte[] bArr, int i);

    /* renamed from: a */
    public byte[] mo4385a(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        this.f24422b.mo6139a();
        if (length <= 2147483619) {
            ByteBuffer allocate = ByteBuffer.allocate((bArr.length + this.f24422b.mo6139a()) + 16);
            if (allocate.remaining() >= (bArr.length + this.f24422b.mo6139a()) + 16) {
                int position = allocate.position();
                this.f24422b.m31256a(allocate, bArr);
                allocate.position(position);
                bArr = new byte[this.f24422b.mo6139a()];
                allocate.get(bArr);
                allocate.limit(allocate.limit() - 16);
                if (bArr2 == null) {
                    bArr2 = new byte[0];
                }
                byte[] bArr3 = new byte[32];
                this.f24423c.mo6140a(bArr, 0).get(bArr3);
                int length2 = bArr2.length % 16 == 0 ? bArr2.length : (bArr2.length + 16) - (bArr2.length % 16);
                int remaining = allocate.remaining();
                int i = remaining % 16;
                i = (i == 0 ? remaining : (remaining + 16) - i) + length2;
                ByteBuffer order = ByteBuffer.allocate(i + 16).order(ByteOrder.LITTLE_ENDIAN);
                order.put(bArr2);
                order.position(length2);
                order.put(allocate);
                order.position(i);
                order.putLong((long) bArr2.length);
                order.putLong((long) remaining);
                bArr = zj.m20195a(bArr3, order.array());
                allocate.limit(allocate.limit() + 16);
                allocate.put(bArr);
                return allocate.array();
            }
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        throw new GeneralSecurityException("plaintext too long");
    }
}
