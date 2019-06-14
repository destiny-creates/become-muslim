package org.spongycastle.pqc.crypto.gmss;

import org.spongycastle.util.Arrays;

public class GMSSParameters {
    /* renamed from: a */
    private int f23191a;
    /* renamed from: b */
    private int[] f23192b;
    /* renamed from: c */
    private int[] f23193c;
    /* renamed from: d */
    private int[] f23194d;

    public GMSSParameters(int i, int[] iArr, int[] iArr2, int[] iArr3) {
        m29048a(i, iArr, iArr2, iArr3);
    }

    /* renamed from: a */
    private void m29048a(int i, int[] iArr, int[] iArr2, int[] iArr3) {
        String str;
        int i2;
        String str2 = "";
        this.f23191a = i;
        if (this.f23191a == iArr2.length && this.f23191a == iArr.length) {
            if (this.f23191a == iArr3.length) {
                i = 1;
                str = str2;
                i2 = i;
                i = 0;
                while (i < this.f23191a) {
                    if (iArr3[i] < 2 || (iArr[i] - iArr3[i]) % 2 != 0) {
                        str = "Wrong parameter K (K >= 2 and H-K even required)!";
                        i2 = 0;
                    }
                    if (iArr[i] >= 4 || iArr2[i] < 2) {
                        str = "Wrong parameter H or w (H > 3 and w > 1 required)!";
                        i2 = 0;
                    }
                    i++;
                }
                if (i2 == 0) {
                    this.f23192b = Arrays.m29375b(iArr);
                    this.f23193c = Arrays.m29375b(iArr2);
                    this.f23194d = Arrays.m29375b(iArr3);
                }
                throw new IllegalArgumentException(str);
            }
        }
        str2 = "Unexpected parameterset format";
        i = 0;
        str = str2;
        i2 = i;
        i = 0;
        while (i < this.f23191a) {
            str = "Wrong parameter K (K >= 2 and H-K even required)!";
            i2 = 0;
            if (iArr[i] >= 4) {
            }
            str = "Wrong parameter H or w (H > 3 and w > 1 required)!";
            i2 = 0;
            i++;
        }
        if (i2 == 0) {
            throw new IllegalArgumentException(str);
        }
        this.f23192b = Arrays.m29375b(iArr);
        this.f23193c = Arrays.m29375b(iArr2);
        this.f23194d = Arrays.m29375b(iArr3);
    }

    /* renamed from: a */
    public int m29049a() {
        return this.f23191a;
    }

    /* renamed from: b */
    public int[] m29050b() {
        return Arrays.m29375b(this.f23192b);
    }

    /* renamed from: c */
    public int[] m29051c() {
        return Arrays.m29375b(this.f23193c);
    }

    /* renamed from: d */
    public int[] m29052d() {
        return Arrays.m29375b(this.f23194d);
    }
}
