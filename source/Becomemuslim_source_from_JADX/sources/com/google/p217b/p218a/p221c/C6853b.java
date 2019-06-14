package com.google.p217b.p218a.p221c;

import com.google.p217b.p222b.C5196a;

/* compiled from: BinaryShiftToken */
/* renamed from: com.google.b.a.c.b */
final class C6853b extends C5192g {
    /* renamed from: b */
    private final short f24673b;
    /* renamed from: c */
    private final short f24674c;

    C6853b(C5192g c5192g, int i, int i2) {
        super(c5192g);
        this.f24673b = (short) i;
        this.f24674c = (short) i2;
    }

    /* renamed from: a */
    public void mo4859a(C5196a c5196a, byte[] bArr) {
        short s = (short) 0;
        while (s < this.f24674c) {
            if (s == (short) 0 || (s == (short) 31 && this.f24674c <= (short) 62)) {
                c5196a.m21963b(31, 5);
                if (this.f24674c > (short) 62) {
                    c5196a.m21963b(this.f24674c - 31, 16);
                } else if (s == (short) 0) {
                    c5196a.m21963b(Math.min(this.f24674c, 31), 5);
                } else {
                    c5196a.m21963b(this.f24674c - 31, 5);
                }
            }
            c5196a.m21963b(bArr[this.f24673b + s], 8);
            s++;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        stringBuilder.append(this.f24673b);
        stringBuilder.append("::");
        stringBuilder.append((this.f24673b + this.f24674c) - 1);
        stringBuilder.append('>');
        return stringBuilder.toString();
    }
}
