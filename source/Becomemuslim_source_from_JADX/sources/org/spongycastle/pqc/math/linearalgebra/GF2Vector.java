package org.spongycastle.pqc.math.linearalgebra;

import java.security.SecureRandom;

public class GF2Vector extends Vector {
    /* renamed from: b */
    private int[] f27863b;

    public GF2Vector(int i) {
        if (i >= 0) {
            this.a = i;
            this.f27863b = new int[((i + 31) >> 5)];
            return;
        }
        throw new ArithmeticException("Negative length.");
    }

    public GF2Vector(int i, SecureRandom secureRandom) {
        this.a = i;
        int i2 = (i + 31) >> 5;
        this.f27863b = new int[i2];
        i2--;
        for (int i3 = i2; i3 >= 0; i3--) {
            this.f27863b[i3] = secureRandom.nextInt();
        }
        i &= 31;
        if (i != 0) {
            secureRandom = this.f27863b;
            secureRandom[i2] = ((1 << i) - 1) & secureRandom[i2];
        }
    }

    public GF2Vector(int i, int i2, SecureRandom secureRandom) {
        if (i2 <= i) {
            int i3;
            this.a = i;
            this.f27863b = new int[((i + 31) >> 5)];
            int[] iArr = new int[i];
            for (i3 = 0; i3 < i; i3++) {
                iArr[i3] = i3;
            }
            for (int i4 = 0; i4 < i2; i4++) {
                i3 = RandUtils.m29292a(secureRandom, i);
                m36522a(iArr[i3]);
                i--;
                iArr[i3] = iArr[i];
            }
            return;
        }
        throw new ArithmeticException("The hamming weight is greater than the length of vector.");
    }

    public GF2Vector(int i, int[] iArr) {
        if (i >= 0) {
            this.a = i;
            int i2 = (i + 31) >> 5;
            if (iArr.length == i2) {
                this.f27863b = IntUtils.m29234a(iArr);
                i &= 31;
                if (i != 0) {
                    iArr = this.f27863b;
                    i2--;
                    iArr[i2] = ((1 << i) - 1) & iArr[i2];
                    return;
                }
                return;
            }
            throw new ArithmeticException("length mismatch");
        }
        throw new ArithmeticException("negative length");
    }

    public GF2Vector(GF2Vector gF2Vector) {
        this.a = gF2Vector.a;
        this.f27863b = IntUtils.m29234a(gF2Vector.f27863b);
    }

    protected GF2Vector(int[] iArr, int i) {
        this.f27863b = iArr;
        this.a = i;
    }

    /* renamed from: a */
    public static GF2Vector m36518a(int i, byte[] bArr) {
        if (i >= 0) {
            if (bArr.length <= ((i + 7) >> 3)) {
                return new GF2Vector(i, LittleEndianConversions.m29243a(bArr));
            }
            throw new ArithmeticException("length mismatch");
        }
        throw new ArithmeticException("negative length");
    }

    /* renamed from: a */
    public byte[] m36523a() {
        return LittleEndianConversions.m29242a(this.f27863b, (this.a + 7) >> 3);
    }

    /* renamed from: b */
    public int[] m36525b() {
        return this.f27863b;
    }

    /* renamed from: c */
    public int m36526c() {
        int i = 0;
        int i2 = 0;
        while (i < this.f27863b.length) {
            int i3 = this.f27863b[i];
            int i4 = i2;
            for (i2 = 0; i2 < 32; i2++) {
                if ((i3 & 1) != 0) {
                    i4++;
                }
                i3 >>>= 1;
            }
            i++;
            i2 = i4;
        }
        return i2;
    }

    /* renamed from: d */
    public boolean m36527d() {
        for (int length = this.f27863b.length - 1; length >= 0; length--) {
            if (this.f27863b[length] != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public void m36522a(int i) {
        if (i < this.a) {
            int[] iArr = this.f27863b;
            int i2 = i >> 5;
            iArr[i2] = (1 << (i & 31)) | iArr[i2];
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    /* renamed from: a */
    public Vector mo5929a(Vector vector) {
        if (vector instanceof GF2Vector) {
            GF2Vector gF2Vector = (GF2Vector) vector;
            if (this.a == gF2Vector.a) {
                int[] a = IntUtils.m29234a(gF2Vector.f27863b);
                for (int length = a.length - 1; length >= 0; length--) {
                    a[length] = a[length] ^ this.f27863b[length];
                }
                return new GF2Vector(this.a, a);
            }
            throw new ArithmeticException("length mismatch");
        }
        throw new ArithmeticException("vector is not defined over GF(2)");
    }

    /* renamed from: a */
    public Vector m36520a(Permutation permutation) {
        permutation = permutation.m29248b();
        if (this.a == permutation.length) {
            Vector gF2Vector = new GF2Vector(this.a);
            for (int i = 0; i < permutation.length; i++) {
                if ((this.f27863b[permutation[i] >> 5] & (1 << (permutation[i] & 31))) != 0) {
                    int[] iArr = gF2Vector.f27863b;
                    int i2 = i >> 5;
                    iArr[i2] = (1 << (i & 31)) | iArr[i2];
                }
            }
            return gF2Vector;
        }
        throw new ArithmeticException("length mismatch");
    }

    /* renamed from: b */
    public GF2Vector m36524b(int i) {
        if (i > this.a) {
            throw new ArithmeticException("invalid length");
        } else if (i == this.a) {
            return new GF2Vector(this);
        } else {
            GF2Vector gF2Vector = new GF2Vector(i);
            int i2 = (this.a - i) >> 5;
            int i3 = (this.a - i) & 31;
            i = (i + 31) >> 5;
            int i4 = 0;
            if (i3 != 0) {
                int i5;
                while (true) {
                    i5 = i - 1;
                    if (i4 >= i5) {
                        break;
                    }
                    int i6 = i2 + 1;
                    gF2Vector.f27863b[i4] = (this.f27863b[i2] >>> i3) | (this.f27863b[i6] << (32 - i3));
                    i4++;
                    i2 = i6;
                }
                int i7 = i2 + 1;
                gF2Vector.f27863b[i5] = this.f27863b[i2] >>> i3;
                if (i7 < this.f27863b.length) {
                    i = gF2Vector.f27863b;
                    i[i5] = i[i5] | (this.f27863b[i7] << (32 - i3));
                }
            } else {
                System.arraycopy(this.f27863b, i2, gF2Vector.f27863b, 0, i);
            }
            return gF2Vector;
        }
    }

    /* renamed from: a */
    public GF2mVector m36519a(GF2mField gF2mField) {
        int a = gF2mField.m29212a();
        if (this.a % a == 0) {
            int i = this.a / a;
            int[] iArr = new int[i];
            int i2 = 0;
            for (i--; i >= 0; i--) {
                for (int a2 = gF2mField.m29212a() - 1; a2 >= 0; a2--) {
                    if (((this.f27863b[i2 >>> 5] >>> (i2 & 31)) & 1) == 1) {
                        iArr[i] = iArr[i] ^ (1 << a2);
                    }
                    i2++;
                }
            }
            return new GF2mVector(gF2mField, iArr);
        }
        throw new ArithmeticException("conversion is impossible");
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof GF2Vector)) {
            return false;
        }
        GF2Vector gF2Vector = (GF2Vector) obj;
        if (this.a == gF2Vector.a && IntUtils.m29233a(this.f27863b, gF2Vector.f27863b) != null) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return (this.a * 31) + this.f27863b.hashCode();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (i < this.a) {
            if (i != 0 && (i & 31) == 0) {
                stringBuffer.append(' ');
            }
            if ((this.f27863b[i >> 5] & (1 << (i & 31))) == 0) {
                stringBuffer.append('0');
            } else {
                stringBuffer.append('1');
            }
            i++;
        }
        return stringBuffer.toString();
    }
}
