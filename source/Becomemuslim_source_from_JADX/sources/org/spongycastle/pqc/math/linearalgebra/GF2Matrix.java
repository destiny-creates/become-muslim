package org.spongycastle.pqc.math.linearalgebra;

import com.facebook.imageutils.JfifUtil;
import java.lang.reflect.Array;
import java.security.SecureRandom;

public class GF2Matrix extends Matrix {
    /* renamed from: a */
    private int[][] f27861a;
    /* renamed from: b */
    private int f27862b;

    public GF2Matrix(int i, int[][] iArr) {
        int i2 = 0;
        if (iArr[0].length == ((i + 31) >> 5)) {
            this.d = i;
            this.c = iArr.length;
            this.f27862b = iArr[0].length;
            i &= 31;
            i = i == 0 ? -1 : (1 << i) - 1;
            while (i2 < this.c) {
                int[] iArr2 = iArr[i2];
                int i3 = this.f27862b - 1;
                iArr2[i3] = iArr2[i3] & i;
                i2++;
            }
            this.f27861a = iArr;
            return;
        }
        throw new ArithmeticException("Int array does not match given number of columns.");
    }

    public GF2Matrix(int i, char c) {
        this(i, c, new SecureRandom());
    }

    public GF2Matrix(int i, char c, SecureRandom secureRandom) {
        if (i <= 0) {
            throw new ArithmeticException("Size of matrix is non-positive.");
        } else if (c == 'I') {
            m36499a(i);
        } else if (c == 'L') {
            m36504b(i, secureRandom);
        } else if (c == 'R') {
            m36506d(i, secureRandom);
        } else if (c == 'U') {
            m36505c(i, secureRandom);
        } else if (c == 'Z') {
            m36500a(i, i);
        } else {
            throw new ArithmeticException("Unknown matrix type.");
        }
    }

    public GF2Matrix(GF2Matrix gF2Matrix) {
        this.d = gF2Matrix.m29245h();
        this.c = gF2Matrix.m29244g();
        this.f27862b = gF2Matrix.f27862b;
        this.f27861a = new int[gF2Matrix.f27861a.length][];
        for (int i = 0; i < this.f27861a.length; i++) {
            this.f27861a[i] = IntUtils.m29234a(gF2Matrix.f27861a[i]);
        }
    }

    private GF2Matrix(int i, int i2) {
        if (i2 <= 0 || i <= 0) {
            throw new ArithmeticException("size of matrix is non-positive");
        }
        m36500a(i, i2);
    }

    /* renamed from: a */
    private void m36500a(int i, int i2) {
        this.c = i;
        this.d = i2;
        this.f27862b = (i2 + 31) >>> 5;
        this.f27861a = (int[][]) Array.newInstance(int.class, new int[]{this.c, this.f27862b});
        for (i2 = 0; i2 < this.c; i2++) {
            for (int i3 = 0; i3 < this.f27862b; i3++) {
                this.f27861a[i2][i3] = 0;
            }
        }
    }

    /* renamed from: a */
    private void m36499a(int i) {
        this.c = i;
        this.d = i;
        this.f27862b = (i + 31) >>> 5;
        this.f27861a = (int[][]) Array.newInstance(int.class, new int[]{this.c, this.f27862b});
        i = 0;
        for (int i2 = 0; i2 < this.c; i2++) {
            for (int i3 = 0; i3 < this.f27862b; i3++) {
                this.f27861a[i2][i3] = 0;
            }
        }
        while (i < this.c) {
            this.f27861a[i][i >>> 5] = 1 << (i & 31);
            i++;
        }
    }

    /* renamed from: b */
    private void m36504b(int i, SecureRandom secureRandom) {
        this.c = i;
        this.d = i;
        this.f27862b = (i + 31) >>> 5;
        this.f27861a = (int[][]) Array.newInstance(int.class, new int[]{this.c, this.f27862b});
        for (int i2 = 0; i2 < this.c; i2++) {
            int i3 = i2 >>> 5;
            int i4 = i2 & 31;
            int i5 = 31 - i4;
            i4 = 1 << i4;
            for (int i6 = 0; i6 < i3; i6++) {
                this.f27861a[i2][i6] = secureRandom.nextInt();
            }
            this.f27861a[i2][i3] = i4 | (secureRandom.nextInt() >>> i5);
            while (true) {
                i3++;
                if (i3 >= this.f27862b) {
                    break;
                }
                this.f27861a[i2][i3] = 0;
            }
        }
    }

    /* renamed from: c */
    private void m36505c(int i, SecureRandom secureRandom) {
        this.c = i;
        this.d = i;
        this.f27862b = (i + 31) >>> 5;
        this.f27861a = (int[][]) Array.newInstance(int.class, new int[]{this.c, this.f27862b});
        i &= 31;
        i = i == 0 ? -1 : (1 << i) - 1;
        for (int i2 = 0; i2 < this.c; i2++) {
            int i3 = i2 >>> 5;
            int i4 = i2 & 31;
            int i5 = 1 << i4;
            for (int i6 = 0; i6 < i3; i6++) {
                this.f27861a[i2][i6] = 0;
            }
            this.f27861a[i2][i3] = (secureRandom.nextInt() << i4) | i5;
            while (true) {
                i3++;
                if (i3 >= this.f27862b) {
                    break;
                }
                this.f27861a[i2][i3] = secureRandom.nextInt();
            }
            int[] iArr = this.f27861a[i2];
            i4 = this.f27862b - 1;
            iArr[i4] = iArr[i4] & i;
        }
    }

    /* renamed from: d */
    private void m36506d(int i, SecureRandom secureRandom) {
        this.c = i;
        this.d = i;
        this.f27862b = (i + 31) >>> 5;
        this.f27861a = (int[][]) Array.newInstance(int.class, new int[]{this.c, this.f27862b});
        GF2Matrix gF2Matrix = (GF2Matrix) new GF2Matrix(i, 'L', secureRandom).m36507a(new GF2Matrix(i, 'U', secureRandom));
        secureRandom = new Permutation(i, secureRandom).m29248b();
        for (int i2 = 0; i2 < i; i2++) {
            System.arraycopy(gF2Matrix.f27861a[i2], 0, this.f27861a[secureRandom[i2]], 0, this.f27862b);
        }
    }

    /* renamed from: a */
    public static GF2Matrix[] m36503a(int i, SecureRandom secureRandom) {
        int i2;
        int i3 = i;
        SecureRandom secureRandom2 = secureRandom;
        GF2Matrix[] gF2MatrixArr = new GF2Matrix[2];
        int i4 = (i3 + 31) >> 5;
        GF2Matrix gF2Matrix = new GF2Matrix(i3, 'L', secureRandom2);
        Matrix gF2Matrix2 = new GF2Matrix(i3, 'U', secureRandom2);
        GF2Matrix gF2Matrix3 = (GF2Matrix) gF2Matrix.m36507a(gF2Matrix2);
        Permutation permutation = new Permutation(i3, secureRandom2);
        int[] b = permutation.m29248b();
        int[][] iArr = (int[][]) Array.newInstance(int.class, new int[]{i3, i4});
        for (i2 = 0; i2 < i3; i2++) {
            System.arraycopy(gF2Matrix3.f27861a[b[i2]], 0, iArr[i2], 0, i4);
        }
        gF2MatrixArr[0] = new GF2Matrix(i3, iArr);
        GF2Matrix gF2Matrix4 = new GF2Matrix(i3, 'I');
        int i5 = 0;
        while (i5 < i3) {
            int i6 = i5 >>> 5;
            i2 = 1 << (i5 & 31);
            int i7 = i5 + 1;
            for (int i8 = i7; i8 < i3; i8++) {
                if ((gF2Matrix.f27861a[i8][i6] & i2) != 0) {
                    for (int i9 = 0; i9 <= i6; i9++) {
                        int[] iArr2 = gF2Matrix4.f27861a[i8];
                        iArr2[i9] = iArr2[i9] ^ gF2Matrix4.f27861a[i5][i9];
                    }
                }
            }
            i5 = i7;
        }
        gF2Matrix = new GF2Matrix(i3, 'I');
        for (i3--; i3 >= 0; i3--) {
            i5 = i3 >>> 5;
            int i10 = 1 << (i3 & 31);
            for (int i11 = i3 - 1; i11 >= 0; i11--) {
                if ((gF2Matrix2.f27861a[i11][i5] & i10) != 0) {
                    for (i7 = i5; i7 < i4; i7++) {
                        int[] iArr3 = gF2Matrix.f27861a[i11];
                        iArr3[i7] = iArr3[i7] ^ gF2Matrix.f27861a[i3][i7];
                    }
                }
            }
        }
        gF2MatrixArr[1] = (GF2Matrix) gF2Matrix.m36507a(gF2Matrix4.m36508a(permutation));
        return gF2MatrixArr;
    }

    /* renamed from: a */
    public byte[] m36510a() {
        byte[] bArr = new byte[((((this.d + 7) >>> 3) * this.c) + 8)];
        LittleEndianConversions.m29239a(this.c, bArr, 0);
        LittleEndianConversions.m29239a(this.d, bArr, 4);
        int i = this.d >>> 5;
        int i2 = this.d & 31;
        int i3 = 0;
        int i4 = 8;
        while (i3 < this.c) {
            int i5 = i4;
            i4 = 0;
            while (i4 < i) {
                LittleEndianConversions.m29239a(this.f27861a[i3][i4], bArr, i5);
                i4++;
                i5 += 4;
            }
            i4 = 0;
            while (i4 < i2) {
                int i6 = i5 + 1;
                bArr[i5] = (byte) ((this.f27861a[i3][i] >>> i4) & JfifUtil.MARKER_FIRST_BYTE);
                i4 += 8;
                i5 = i6;
            }
            i3++;
            i4 = i5;
        }
        return bArr;
    }

    /* renamed from: b */
    public GF2Matrix m36511b() {
        if (this.d > this.c) {
            int i = (this.c + 31) >> 5;
            int[][] iArr = (int[][]) Array.newInstance(int.class, new int[]{this.c, i});
            int i2 = (1 << (this.c & 31)) - 1;
            if (i2 == 0) {
                i2 = -1;
            }
            for (int i3 = this.c - 1; i3 >= 0; i3--) {
                System.arraycopy(this.f27861a[i3], 0, iArr[i3], 0, i);
                int[] iArr2 = iArr[i3];
                int i4 = i - 1;
                iArr2[i4] = iArr2[i4] & i2;
            }
            return new GF2Matrix(this.c, iArr);
        }
        throw new ArithmeticException("empty submatrix");
    }

    /* renamed from: c */
    public GF2Matrix m36513c() {
        GF2Matrix gF2Matrix = new GF2Matrix(this.c, this.d + this.c);
        int i = (this.c - 1) + this.d;
        int i2 = this.c - 1;
        while (i2 >= 0) {
            System.arraycopy(this.f27861a[i2], 0, gF2Matrix.f27861a[i2], 0, this.f27862b);
            int[] iArr = gF2Matrix.f27861a[i2];
            int i3 = i >> 5;
            iArr[i3] = iArr[i3] | (1 << (i & 31));
            i2--;
            i--;
        }
        return gF2Matrix;
    }

    /* renamed from: d */
    public GF2Matrix m36515d() {
        if (this.d > this.c) {
            int i = this.c >> 5;
            int i2 = this.c & 31;
            GF2Matrix gF2Matrix = new GF2Matrix(this.c, this.d - this.c);
            for (int i3 = this.c - 1; i3 >= 0; i3--) {
                int i4 = 0;
                if (i2 != 0) {
                    int i5;
                    int i6 = i;
                    while (i4 < gF2Matrix.f27862b - 1) {
                        i5 = i6 + 1;
                        gF2Matrix.f27861a[i3][i4] = (this.f27861a[i3][i6] >>> i2) | (this.f27861a[i3][i5] << (32 - i2));
                        i4++;
                        i6 = i5;
                    }
                    i5 = i6 + 1;
                    gF2Matrix.f27861a[i3][gF2Matrix.f27862b - 1] = this.f27861a[i3][i6] >>> i2;
                    if (i5 < this.f27862b) {
                        int[] iArr = gF2Matrix.f27861a[i3];
                        i6 = gF2Matrix.f27862b - 1;
                        iArr[i6] = iArr[i6] | (this.f27861a[i3][i5] << (32 - i2));
                    }
                } else {
                    System.arraycopy(this.f27861a[i3], i, gF2Matrix.f27861a[i3], 0, gF2Matrix.f27862b);
                }
            }
            return gF2Matrix;
        }
        throw new ArithmeticException("empty submatrix");
    }

    /* renamed from: e */
    public Matrix m36516e() {
        int[][] iArr = (int[][]) Array.newInstance(int.class, new int[]{this.d, (this.c + 31) >>> 5});
        for (int i = 0; i < this.c; i++) {
            for (int i2 = 0; i2 < this.d; i2++) {
                int i3 = i >>> 5;
                int i4 = i & 31;
                if (((this.f27861a[i][i2 >>> 5] >>> (i2 & 31)) & 1) == 1) {
                    int[] iArr2 = iArr[i2];
                    iArr2[i3] = (1 << i4) | iArr2[i3];
                }
            }
        }
        return new GF2Matrix(this.c, iArr);
    }

    /* renamed from: f */
    public Matrix m36517f() {
        if (this.c == this.d) {
            int[][] iArr = (int[][]) Array.newInstance(int.class, new int[]{this.c, this.f27862b});
            for (int i = this.c - 1; i >= 0; i--) {
                iArr[i] = IntUtils.m29234a(this.f27861a[i]);
            }
            int[][] iArr2 = (int[][]) Array.newInstance(int.class, new int[]{this.c, this.f27862b});
            for (int i2 = this.c - 1; i2 >= 0; i2--) {
                iArr2[i2][i2 >> 5] = 1 << (i2 & 31);
            }
            for (int i3 = 0; i3 < this.c; i3++) {
                int i4;
                int i5 = i3 >> 5;
                int i6 = 1 << (i3 & 31);
                if ((iArr[i3][i5] & i6) == 0) {
                    i4 = i3 + 1;
                    Object obj = null;
                    while (i4 < this.c) {
                        if ((iArr[i4][i5] & i6) != 0) {
                            m36502a(iArr, i3, i4);
                            m36502a(iArr2, i3, i4);
                            i4 = this.c;
                            obj = 1;
                        }
                        i4++;
                    }
                    if (obj == null) {
                        throw new ArithmeticException("Matrix is not invertible.");
                    }
                }
                i4 = this.c - 1;
                while (i4 >= 0) {
                    if (!(i4 == i3 || (iArr[i4][i5] & i6) == 0)) {
                        m36501a(iArr[i3], iArr[i4], i5);
                        m36501a(iArr2[i3], iArr2[i4], 0);
                    }
                    i4--;
                }
            }
            return new GF2Matrix(this.d, iArr2);
        }
        throw new ArithmeticException("Matrix is not invertible.");
    }

    /* renamed from: a */
    public Vector m36509a(Vector vector) {
        if (!(vector instanceof GF2Vector)) {
            throw new ArithmeticException("vector is not defined over GF(2)");
        } else if (vector.f23398a == this.c) {
            vector = ((GF2Vector) vector).m36525b();
            int[] iArr = new int[this.f27862b];
            int i = this.c >> 5;
            int i2 = 1;
            int i3 = 1 << (this.c & 31);
            int i4 = 0;
            int i5 = 0;
            while (i4 < i) {
                int i6 = i5;
                i5 = 1;
                do {
                    if ((vector[i4] & i5) != 0) {
                        for (int i7 = 0; i7 < this.f27862b; i7++) {
                            iArr[i7] = iArr[i7] ^ this.f27861a[i6][i7];
                        }
                    }
                    i6++;
                    i5 <<= 1;
                } while (i5 != 0);
                i4++;
                i5 = i6;
            }
            while (i2 != i3) {
                if ((vector[i] & i2) != 0) {
                    for (i4 = 0; i4 < this.f27862b; i4++) {
                        iArr[i4] = iArr[i4] ^ this.f27861a[i5][i4];
                    }
                }
                i5++;
                i2 <<= 1;
            }
            return new GF2Vector(iArr, this.d);
        } else {
            throw new ArithmeticException("length mismatch");
        }
    }

    /* renamed from: b */
    public Vector m36512b(Vector vector) {
        if (!(vector instanceof GF2Vector)) {
            throw new ArithmeticException("vector is not defined over GF(2)");
        } else if (vector.f23398a == this.c) {
            int i;
            int i2;
            vector = ((GF2Vector) vector).m36525b();
            int[] iArr = new int[(((this.c + this.d) + 31) >>> 5)];
            int i3 = this.c >>> 5;
            int i4 = 0;
            int i5 = 0;
            while (i4 < i3) {
                i = i5;
                i5 = 1;
                do {
                    if ((vector[i4] & i5) != 0) {
                        for (i2 = 0; i2 < this.f27862b; i2++) {
                            iArr[i2] = iArr[i2] ^ this.f27861a[i][i2];
                        }
                        i2 = (this.d + i) >>> 5;
                        iArr[i2] = (1 << ((this.d + i) & 31)) | iArr[i2];
                    }
                    i++;
                    i5 <<= 1;
                } while (i5 != 0);
                i4++;
                i5 = i;
            }
            i4 = 1 << (this.c & 31);
            i = i5;
            for (i5 = 1; i5 != i4; i5 <<= 1) {
                if ((vector[i3] & i5) != 0) {
                    for (i2 = 0; i2 < this.f27862b; i2++) {
                        iArr[i2] = iArr[i2] ^ this.f27861a[i][i2];
                    }
                    i2 = (this.d + i) >>> 5;
                    iArr[i2] = (1 << ((this.d + i) & 31)) | iArr[i2];
                }
                i++;
            }
            return new GF2Vector(iArr, this.c + this.d);
        } else {
            throw new ArithmeticException("length mismatch");
        }
    }

    /* renamed from: a */
    public Matrix m36507a(Matrix matrix) {
        if (!(matrix instanceof GF2Matrix)) {
            throw new ArithmeticException("matrix is not defined over GF(2)");
        } else if (matrix.f23388c == this.d) {
            int i;
            GF2Matrix gF2Matrix = (GF2Matrix) matrix;
            Matrix gF2Matrix2 = new GF2Matrix(this.c, matrix.f23389d);
            matrix = this.d & 31;
            if (matrix == null) {
                i = this.f27862b;
            } else {
                i = this.f27862b - 1;
            }
            for (int i2 = 0; i2 < this.c; i2++) {
                int i3;
                int i4;
                int i5 = 0;
                int i6 = 0;
                while (i5 < i) {
                    i3 = this.f27861a[i2][i5];
                    i4 = i6;
                    for (i6 = 0; i6 < 32; i6++) {
                        if (((1 << i6) & i3) != 0) {
                            for (int i7 = 0; i7 < gF2Matrix.f27862b; i7++) {
                                int[] iArr = gF2Matrix2.f27861a[i2];
                                iArr[i7] = iArr[i7] ^ gF2Matrix.f27861a[i4][i7];
                            }
                        }
                        i4++;
                    }
                    i5++;
                    i6 = i4;
                }
                i5 = this.f27861a[i2][this.f27862b - 1];
                i3 = i6;
                for (i6 = 0; i6 < matrix; i6++) {
                    if (((1 << i6) & i5) != 0) {
                        for (i4 = 0; i4 < gF2Matrix.f27862b; i4++) {
                            int[] iArr2 = gF2Matrix2.f27861a[i2];
                            iArr2[i4] = iArr2[i4] ^ gF2Matrix.f27861a[i3][i4];
                        }
                    }
                    i3++;
                }
            }
            return gF2Matrix2;
        } else {
            throw new ArithmeticException("length mismatch");
        }
    }

    /* renamed from: a */
    public Matrix m36508a(Permutation permutation) {
        permutation = permutation.m29248b();
        if (permutation.length == this.d) {
            Matrix gF2Matrix = new GF2Matrix(this.c, this.d);
            for (int i = this.d - 1; i >= 0; i--) {
                int i2 = i >>> 5;
                int i3 = i & 31;
                int i4 = permutation[i] >>> 5;
                int i5 = permutation[i] & 31;
                for (int i6 = this.c - 1; i6 >= 0; i6--) {
                    int[] iArr = gF2Matrix.f27861a[i6];
                    iArr[i2] = iArr[i2] | (((this.f27861a[i6][i4] >>> i5) & 1) << i3);
                }
            }
            return gF2Matrix;
        }
        throw new ArithmeticException("length mismatch");
    }

    /* renamed from: c */
    public Vector m36514c(Vector vector) {
        if (!(vector instanceof GF2Vector)) {
            throw new ArithmeticException("vector is not defined over GF(2)");
        } else if (vector.f23398a == this.d) {
            vector = ((GF2Vector) vector).m36525b();
            int[] iArr = new int[((this.c + 31) >>> 5)];
            for (int i = 0; i < this.c; i++) {
                int i2;
                int i3 = 0;
                for (i2 = 0; i2 < this.f27862b; i2++) {
                    i3 ^= this.f27861a[i][i2] & vector[i2];
                }
                int i4 = 0;
                for (i2 = 0; i2 < 32; i2++) {
                    i4 ^= (i3 >>> i2) & 1;
                }
                if (i4 == 1) {
                    i2 = i >>> 5;
                    iArr[i2] = iArr[i2] | (1 << (i & 31));
                }
            }
            return new GF2Vector(iArr, this.c);
        } else {
            throw new ArithmeticException("length mismatch");
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GF2Matrix)) {
            return false;
        }
        GF2Matrix gF2Matrix = (GF2Matrix) obj;
        if (this.c == gF2Matrix.c && this.d == gF2Matrix.d) {
            if (this.f27862b == gF2Matrix.f27862b) {
                for (int i = 0; i < this.c; i++) {
                    if (!IntUtils.m29233a(this.f27861a[i], gF2Matrix.f27861a[i])) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = (((this.c * 31) + this.d) * 31) + this.f27862b;
        for (int i2 = 0; i2 < this.c; i2++) {
            i = (i * 31) + this.f27861a[i2].hashCode();
        }
        return i;
    }

    public String toString() {
        int i;
        int i2 = this.d & 31;
        if (i2 == 0) {
            i = this.f27862b;
        } else {
            i = this.f27862b - 1;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < this.c; i3++) {
            int i4;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i3);
            stringBuilder.append(": ");
            stringBuffer.append(stringBuilder.toString());
            for (i4 = 0; i4 < i; i4++) {
                int i5 = this.f27861a[i3][i4];
                for (int i6 = 0; i6 < 32; i6++) {
                    if (((i5 >>> i6) & 1) == 0) {
                        stringBuffer.append('0');
                    } else {
                        stringBuffer.append('1');
                    }
                }
                stringBuffer.append(' ');
            }
            i4 = this.f27861a[i3][this.f27862b - 1];
            for (i5 = 0; i5 < i2; i5++) {
                if (((i4 >>> i5) & 1) == 0) {
                    stringBuffer.append('0');
                } else {
                    stringBuffer.append('1');
                }
            }
            stringBuffer.append('\n');
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private static void m36502a(int[][] iArr, int i, int i2) {
        int[] iArr2 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = iArr2;
    }

    /* renamed from: a */
    private static void m36501a(int[] iArr, int[] iArr2, int i) {
        for (int length = iArr2.length - 1; length >= i; length--) {
            iArr2[length] = iArr[length] ^ iArr2[length];
        }
    }
}
