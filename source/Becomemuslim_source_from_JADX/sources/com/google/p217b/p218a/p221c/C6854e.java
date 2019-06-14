package com.google.p217b.p218a.p221c;

import com.google.p217b.p222b.C5196a;

/* compiled from: SimpleToken */
/* renamed from: com.google.b.a.c.e */
final class C6854e extends C5192g {
    /* renamed from: b */
    private final short f24675b;
    /* renamed from: c */
    private final short f24676c;

    C6854e(C5192g c5192g, int i, int i2) {
        super(c5192g);
        this.f24675b = (short) i;
        this.f24676c = (short) i2;
    }

    /* renamed from: a */
    void mo4859a(C5196a c5196a, byte[] bArr) {
        c5196a.m21963b(this.f24675b, this.f24676c);
    }

    public String toString() {
        int i = (this.f24675b & ((1 << this.f24676c) - 1)) | (1 << this.f24676c);
        StringBuilder stringBuilder = new StringBuilder("<");
        stringBuilder.append(Integer.toBinaryString(i | (1 << this.f24676c)).substring(1));
        stringBuilder.append('>');
        return stringBuilder.toString();
    }
}
