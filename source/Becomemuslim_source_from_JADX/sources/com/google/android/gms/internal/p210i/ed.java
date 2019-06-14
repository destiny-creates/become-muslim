package com.google.android.gms.internal.p210i;

/* renamed from: com.google.android.gms.internal.i.ed */
final class ed extends ej {
    /* renamed from: c */
    private final int f32297c;
    /* renamed from: d */
    private final int f32298d;

    ed(byte[] bArr, int i, int i2) {
        super(bArr);
        dy.m20455b(i, i + i2, bArr.length);
        this.f32297c = i;
        this.f32298d = i2;
    }

    /* renamed from: a */
    public final byte mo6159a(int i) {
        int a = mo6160a();
        if (((a - (i + 1)) | i) >= 0) {
            return this.b[this.f32297c + i];
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

    /* renamed from: b */
    final byte mo6166b(int i) {
        return this.b[this.f32297c + i];
    }

    /* renamed from: a */
    public final int mo6160a() {
        return this.f32298d;
    }

    /* renamed from: e */
    protected final int mo6725e() {
        return this.f32297c;
    }
}
