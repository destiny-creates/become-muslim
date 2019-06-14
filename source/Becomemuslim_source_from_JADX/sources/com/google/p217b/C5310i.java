package com.google.p217b;

import com.facebook.imageutils.JfifUtil;

/* compiled from: LuminanceSource */
/* renamed from: com.google.b.i */
public abstract class C5310i {
    /* renamed from: a */
    private final int f17936a;
    /* renamed from: b */
    private final int f17937b;

    /* renamed from: a */
    public abstract byte[] mo4872a();

    /* renamed from: a */
    public abstract byte[] mo4873a(int i, byte[] bArr);

    /* renamed from: d */
    public boolean m22568d() {
        return false;
    }

    protected C5310i(int i, int i2) {
        this.f17936a = i;
        this.f17937b = i2;
    }

    /* renamed from: b */
    public final int m22566b() {
        return this.f17936a;
    }

    /* renamed from: c */
    public final int m22567c() {
        return this.f17937b;
    }

    /* renamed from: e */
    public C5310i m22569e() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public final String toString() {
        byte[] bArr = new byte[this.f17936a];
        StringBuilder stringBuilder = new StringBuilder(this.f17937b * (this.f17936a + 1));
        byte[] bArr2 = bArr;
        for (int i = 0; i < this.f17937b; i++) {
            bArr2 = mo4873a(i, bArr2);
            for (int i2 = 0; i2 < this.f17936a; i2++) {
                int i3 = bArr2[i2] & JfifUtil.MARKER_FIRST_BYTE;
                char c = i3 < 64 ? '#' : i3 < 128 ? '+' : i3 < JfifUtil.MARKER_SOFn ? '.' : ' ';
                stringBuilder.append(c);
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
