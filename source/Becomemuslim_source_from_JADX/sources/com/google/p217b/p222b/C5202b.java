package com.google.p217b.p222b;

import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import java.util.Arrays;

/* compiled from: BitMatrix */
/* renamed from: com.google.b.b.b */
public final class C5202b implements Cloneable {
    /* renamed from: a */
    private final int f17536a;
    /* renamed from: b */
    private final int f17537b;
    /* renamed from: c */
    private final int f17538c;
    /* renamed from: d */
    private final int[] f17539d;

    public /* synthetic */ Object clone() {
        return m22012h();
    }

    public C5202b(int i) {
        this(i, i);
    }

    public C5202b(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f17536a = i;
        this.f17537b = i2;
        this.f17538c = (i + 31) / 32;
        this.f17539d = new int[(this.f17538c * i2)];
    }

    private C5202b(int i, int i2, int i3, int[] iArr) {
        this.f17536a = i;
        this.f17537b = i2;
        this.f17538c = i3;
        this.f17539d = iArr;
    }

    /* renamed from: a */
    public boolean m22002a(int i, int i2) {
        return ((this.f17539d[(i2 * this.f17538c) + (i / 32)] >>> (i & 31)) & 1) != 0;
    }

    /* renamed from: b */
    public void m22004b(int i, int i2) {
        i2 = (i2 * this.f17538c) + (i / 32);
        int[] iArr = this.f17539d;
        iArr[i2] = (1 << (i & 31)) | iArr[i2];
    }

    /* renamed from: c */
    public void m22006c(int i, int i2) {
        i2 = (i2 * this.f17538c) + (i / 32);
        int[] iArr = this.f17539d;
        iArr[i2] = (1 << (i & 31)) ^ iArr[i2];
    }

    /* renamed from: a */
    public void m22000a() {
        int length = this.f17539d.length;
        for (int i = 0; i < length; i++) {
            this.f17539d[i] = 0;
        }
    }

    /* renamed from: a */
    public void m22001a(int i, int i2, int i3, int i4) {
        if (i2 < 0 || i < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        } else if (i4 <= 0 || i3 <= 0) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        } else {
            i3 += i;
            i4 += i2;
            if (i4 > this.f17537b || i3 > this.f17536a) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            while (i2 < i4) {
                int i5 = this.f17538c * i2;
                for (int i6 = i; i6 < i3; i6++) {
                    int[] iArr = this.f17539d;
                    int i7 = (i6 / 32) + i5;
                    iArr[i7] = iArr[i7] | (1 << (i6 & 31));
                }
                i2++;
            }
        }
    }

    /* renamed from: a */
    public C5196a m21998a(int i, C5196a c5196a) {
        int i2;
        if (c5196a != null) {
            if (c5196a.m21954a() >= this.f17536a) {
                c5196a.m21966c();
                i *= this.f17538c;
                for (i2 = 0; i2 < this.f17538c; i2++) {
                    c5196a.m21955a(i2 << 5, this.f17539d[i + i2]);
                }
                return c5196a;
            }
        }
        c5196a = new C5196a(this.f17536a);
        i *= this.f17538c;
        for (i2 = 0; i2 < this.f17538c; i2++) {
            c5196a.m21955a(i2 << 5, this.f17539d[i + i2]);
        }
        return c5196a;
    }

    /* renamed from: b */
    public void m22005b(int i, C5196a c5196a) {
        System.arraycopy(c5196a.m21968d(), 0, this.f17539d, i * this.f17538c, this.f17538c);
    }

    /* renamed from: b */
    public void m22003b() {
        int f = m22010f();
        int g = m22011g();
        C5196a c5196a = new C5196a(f);
        C5196a c5196a2 = new C5196a(f);
        for (f = 0; f < (g + 1) / 2; f++) {
            c5196a = m21998a(f, c5196a);
            int i = (g - 1) - f;
            c5196a2 = m21998a(i, c5196a2);
            c5196a.m21969e();
            c5196a2.m21969e();
            m22005b(f, c5196a2);
            m22005b(i, c5196a);
        }
    }

    /* renamed from: c */
    public int[] m22007c() {
        int i = this.f17536a;
        int i2 = -1;
        int i3 = this.f17537b;
        int i4 = -1;
        int i5 = i;
        i = 0;
        while (i < this.f17537b) {
            int i6 = i4;
            i4 = i2;
            i2 = i5;
            for (i5 = 0; i5 < this.f17538c; i5++) {
                int i7 = this.f17539d[(this.f17538c * i) + i5];
                if (i7 != 0) {
                    if (i < i3) {
                        i3 = i;
                    }
                    if (i > i6) {
                        i6 = i;
                    }
                    int i8 = i5 << 5;
                    int i9 = 31;
                    if (i8 < i2) {
                        int i10 = 0;
                        while ((i7 << (31 - i10)) == 0) {
                            i10++;
                        }
                        i10 += i8;
                        if (i10 < i2) {
                            i2 = i10;
                        }
                    }
                    if (i8 + 31 > i4) {
                        while ((i7 >>> i9) == 0) {
                            i9--;
                        }
                        i7 = i8 + i9;
                        if (i7 > i4) {
                            i4 = i7;
                        }
                    }
                }
            }
            i++;
            i5 = i2;
            i2 = i4;
            i4 = i6;
        }
        if (i2 >= i5) {
            if (i4 >= i3) {
                return new int[]{i5, i3, (i2 - i5) + 1, (i4 - i3) + 1};
            }
        }
        return null;
    }

    /* renamed from: d */
    public int[] m22008d() {
        int i = 0;
        while (i < this.f17539d.length && this.f17539d[i] == 0) {
            i++;
        }
        if (i == this.f17539d.length) {
            return null;
        }
        int i2;
        int i3 = i / this.f17538c;
        int i4 = (i % this.f17538c) << 5;
        for (i2 = 0; (this.f17539d[i] << (31 - i2)) == 0; i2++) {
        }
        return new int[]{i4 + i2, i3};
    }

    /* renamed from: e */
    public int[] m22009e() {
        int length = this.f17539d.length - 1;
        while (length >= 0 && this.f17539d[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i;
        int i2 = length / this.f17538c;
        int i3 = (length % this.f17538c) << 5;
        for (i = 31; (this.f17539d[length] >>> i) == 0; i--) {
        }
        return new int[]{i3 + i, i2};
    }

    /* renamed from: f */
    public int m22010f() {
        return this.f17536a;
    }

    /* renamed from: g */
    public int m22011g() {
        return this.f17537b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C5202b)) {
            return false;
        }
        C5202b c5202b = (C5202b) obj;
        if (this.f17536a == c5202b.f17536a && this.f17537b == c5202b.f17537b && this.f17538c == c5202b.f17538c && Arrays.equals(this.f17539d, c5202b.f17539d) != null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.f17536a * 31) + this.f17536a) * 31) + this.f17537b) * 31) + this.f17538c) * 31) + Arrays.hashCode(this.f17539d);
    }

    public String toString() {
        return m21999a("X ", "  ");
    }

    /* renamed from: a */
    public String m21999a(String str, String str2) {
        return m21997a(str, str2, ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
    }

    /* renamed from: a */
    private String m21997a(String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder(this.f17537b * (this.f17536a + 1));
        for (int i = 0; i < this.f17537b; i++) {
            for (int i2 = 0; i2 < this.f17536a; i2++) {
                stringBuilder.append(m22002a(i2, i) ? str : str2);
            }
            stringBuilder.append(str3);
        }
        return stringBuilder.toString();
    }

    /* renamed from: h */
    public C5202b m22012h() {
        return new C5202b(this.f17536a, this.f17537b, this.f17538c, (int[]) this.f17539d.clone());
    }
}
