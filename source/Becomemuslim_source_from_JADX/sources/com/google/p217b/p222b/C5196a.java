package com.google.p217b.p222b;

import java.util.Arrays;

/* compiled from: BitArray */
/* renamed from: com.google.b.b.a */
public final class C5196a implements Cloneable {
    /* renamed from: a */
    private int[] f17514a;
    /* renamed from: b */
    private int f17515b;

    public /* synthetic */ Object clone() {
        return m21970f();
    }

    public C5196a() {
        this.f17515b = 0;
        this.f17514a = new int[1];
    }

    public C5196a(int i) {
        this.f17515b = i;
        this.f17514a = C5196a.m21953f(i);
    }

    C5196a(int[] iArr, int i) {
        this.f17514a = iArr;
        this.f17515b = i;
    }

    /* renamed from: a */
    public int m21954a() {
        return this.f17515b;
    }

    /* renamed from: b */
    public int m21961b() {
        return (this.f17515b + 7) / 8;
    }

    /* renamed from: e */
    private void m21952e(int i) {
        if (i > (this.f17514a.length << 5)) {
            i = C5196a.m21953f(i);
            System.arraycopy(this.f17514a, 0, i, 0, this.f17514a.length);
            this.f17514a = i;
        }
    }

    /* renamed from: a */
    public boolean m21959a(int i) {
        return ((1 << (i & 31)) & this.f17514a[i / 32]) != 0;
    }

    /* renamed from: b */
    public void m21962b(int i) {
        int[] iArr = this.f17514a;
        int i2 = i / 32;
        iArr[i2] = (1 << (i & 31)) | iArr[i2];
    }

    /* renamed from: c */
    public int m21965c(int i) {
        if (i >= this.f17515b) {
            return this.f17515b;
        }
        int i2 = i / 32;
        i = (~((1 << (i & 31)) - 1)) & this.f17514a[i2];
        while (i == 0) {
            i2++;
            if (i2 == this.f17514a.length) {
                return this.f17515b;
            }
            i = this.f17514a[i2];
        }
        i2 = (i2 << 5) + Integer.numberOfTrailingZeros(i);
        return i2 > this.f17515b ? this.f17515b : i2;
    }

    /* renamed from: d */
    public int m21967d(int i) {
        if (i >= this.f17515b) {
            return this.f17515b;
        }
        int i2 = i / 32;
        i = (~((1 << (i & 31)) - 1)) & (~this.f17514a[i2]);
        while (i == 0) {
            i2++;
            if (i2 == this.f17514a.length) {
                return this.f17515b;
            }
            i = ~this.f17514a[i2];
        }
        i2 = (i2 << 5) + Integer.numberOfTrailingZeros(i);
        return i2 > this.f17515b ? this.f17515b : i2;
    }

    /* renamed from: a */
    public void m21955a(int i, int i2) {
        this.f17514a[i / 32] = i2;
    }

    /* renamed from: c */
    public void m21966c() {
        int length = this.f17514a.length;
        for (int i = 0; i < length; i++) {
            this.f17514a[i] = 0;
        }
    }

    /* renamed from: a */
    public boolean m21960a(int i, int i2, boolean z) {
        if (i2 < i || i < 0 || i2 > this.f17515b) {
            throw new IllegalArgumentException();
        } else if (i2 == i) {
            return true;
        } else {
            i2--;
            int i3 = i / 32;
            int i4 = i2 / 32;
            int i5 = i3;
            while (i5 <= i4) {
                int i6 = 31;
                int i7 = i5 > i3 ? 0 : i & 31;
                if (i5 >= i4) {
                    i6 = 31 & i2;
                }
                i6 = (2 << i6) - (1 << i7);
                i7 = this.f17514a[i5] & i6;
                if (!z) {
                    i6 = 0;
                }
                if (i7 != i6) {
                    return false;
                }
                i5++;
            }
            return true;
        }
    }

    /* renamed from: a */
    public void m21958a(boolean z) {
        m21952e(this.f17515b + 1);
        if (z) {
            z = this.f17514a;
            int i = this.f17515b / 32;
            z[i] = z[i] | (1 << (this.f17515b & 31));
        }
        this.f17515b += true;
    }

    /* renamed from: b */
    public void m21963b(int i, int i2) {
        if (i2 < 0 || i2 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        m21952e(this.f17515b + i2);
        while (i2 > 0) {
            boolean z = true;
            if (((i >> (i2 - 1)) & 1) != 1) {
                z = false;
            }
            m21958a(z);
            i2--;
        }
    }

    /* renamed from: a */
    public void m21957a(C5196a c5196a) {
        int i = c5196a.f17515b;
        m21952e(this.f17515b + i);
        for (int i2 = 0; i2 < i; i2++) {
            m21958a(c5196a.m21959a(i2));
        }
    }

    /* renamed from: b */
    public void m21964b(C5196a c5196a) {
        if (this.f17515b == c5196a.f17515b) {
            for (int i = 0; i < this.f17514a.length; i++) {
                int[] iArr = this.f17514a;
                iArr[i] = iArr[i] ^ c5196a.f17514a[i];
            }
            return;
        }
        throw new IllegalArgumentException("Sizes don't match");
    }

    /* renamed from: a */
    public void m21956a(int i, byte[] bArr, int i2, int i3) {
        int i4 = i;
        i = 0;
        while (i < i3) {
            int i5 = i4;
            int i6 = 0;
            for (i4 = 0; i4 < 8; i4++) {
                if (m21959a(i5)) {
                    i6 |= 1 << (7 - i4);
                }
                i5++;
            }
            bArr[i2 + i] = (byte) i6;
            i++;
            i4 = i5;
        }
    }

    /* renamed from: d */
    public int[] m21968d() {
        return this.f17514a;
    }

    /* renamed from: e */
    public void m21969e() {
        int i;
        int[] iArr = new int[this.f17514a.length];
        int i2 = (this.f17515b - 1) / 32;
        int i3 = i2 + 1;
        for (i = 0; i < i3; i++) {
            long j = (long) this.f17514a[i];
            j = ((j & 1431655765) << 1) | ((j >> 1) & 1431655765);
            j = ((j & 858993459) << 2) | ((j >> 2) & 858993459);
            j = ((j & 252645135) << 4) | ((j >> 4) & 252645135);
            j = ((j & 16711935) << 8) | ((j >> 8) & 16711935);
            iArr[i2 - i] = (int) (((j & 65535) << 16) | ((j >> 16) & 65535));
        }
        i = i3 << 5;
        if (this.f17515b != i) {
            i -= this.f17515b;
            int i4 = iArr[0] >>> i;
            for (i2 = 1; i2 < i3; i2++) {
                int i5 = iArr[i2];
                iArr[i2 - 1] = i4 | (i5 << (32 - i));
                i4 = i5 >>> i;
            }
            iArr[i3 - 1] = i4;
        }
        this.f17514a = iArr;
    }

    /* renamed from: f */
    private static int[] m21953f(int i) {
        return new int[((i + 31) / 32)];
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C5196a)) {
            return false;
        }
        C5196a c5196a = (C5196a) obj;
        if (this.f17515b != c5196a.f17515b || Arrays.equals(this.f17514a, c5196a.f17514a) == null) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f17515b * 31) + Arrays.hashCode(this.f17514a);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder((this.f17515b + (this.f17515b / 8)) + 1);
        for (int i = 0; i < this.f17515b; i++) {
            if ((i & 7) == 0) {
                stringBuilder.append(' ');
            }
            stringBuilder.append(m21959a(i) ? 'X' : '.');
        }
        return stringBuilder.toString();
    }

    /* renamed from: f */
    public C5196a m21970f() {
        return new C5196a((int[]) this.f17514a.clone(), this.f17515b);
    }
}
