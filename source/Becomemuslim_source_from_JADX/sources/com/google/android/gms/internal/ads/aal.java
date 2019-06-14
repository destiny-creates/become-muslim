package com.google.android.gms.internal.ads;

final class aal extends aap {
    /* renamed from: c */
    private final int f32191c;
    /* renamed from: d */
    private final int f32192d;

    aal(byte[] bArr, int i, int i2) {
        super(bArr);
        aai.m17833b(i, i + i2, bArr.length);
        this.f32191c = i;
        this.f32192d = i2;
    }

    /* renamed from: a */
    public final byte mo6035a(int i) {
        int a = mo6036a();
        if (((a - (i + 1)) | i) >= 0) {
            return this.b[this.f32191c + i];
        }
        if (i < 0) {
            StringBuilder stringBuilder = new StringBuilder(22);
            stringBuilder.append("Index < 0: ");
            stringBuilder.append(i);
            throw new ArrayIndexOutOfBoundsException(stringBuilder.toString());
        }
        StringBuilder stringBuilder2 = new StringBuilder(40);
        stringBuilder2.append("Index > length: ");
        stringBuilder2.append(i);
        stringBuilder2.append(", ");
        stringBuilder2.append(a);
        throw new ArrayIndexOutOfBoundsException(stringBuilder2.toString());
    }

    /* renamed from: a */
    public final int mo6036a() {
        return this.f32192d;
    }

    /* renamed from: a */
    protected final void mo6041a(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.b, mo6626g(), bArr, 0, i3);
    }

    /* renamed from: g */
    protected final int mo6626g() {
        return this.f32191c;
    }
}
