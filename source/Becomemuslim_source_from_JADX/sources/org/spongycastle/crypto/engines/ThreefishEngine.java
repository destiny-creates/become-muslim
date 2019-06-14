package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.TweakableBlockCipherParameters;

public class ThreefishEngine implements BlockCipher {
    /* renamed from: a */
    private static int[] f26800a = new int[80];
    /* renamed from: b */
    private static int[] f26801b = new int[f26800a.length];
    /* renamed from: c */
    private static int[] f26802c = new int[f26800a.length];
    /* renamed from: d */
    private static int[] f26803d = new int[f26800a.length];
    /* renamed from: e */
    private int f26804e;
    /* renamed from: f */
    private int f26805f;
    /* renamed from: g */
    private long[] f26806g;
    /* renamed from: h */
    private long[] f26807h = new long[5];
    /* renamed from: i */
    private long[] f26808i;
    /* renamed from: j */
    private ThreefishCipher f26809j;
    /* renamed from: k */
    private boolean f26810k;

    private static abstract class ThreefishCipher {
        /* renamed from: a */
        protected final long[] f22333a;
        /* renamed from: b */
        protected final long[] f22334b;

        /* renamed from: a */
        abstract void mo5753a(long[] jArr, long[] jArr2);

        /* renamed from: b */
        abstract void mo5754b(long[] jArr, long[] jArr2);

        protected ThreefishCipher(long[] jArr, long[] jArr2) {
            this.f22334b = jArr;
            this.f22333a = jArr2;
        }
    }

    private static final class Threefish1024Cipher extends ThreefishCipher {
        public Threefish1024Cipher(long[] jArr, long[] jArr2) {
            super(jArr, jArr2);
        }

        /* renamed from: a */
        void mo5753a(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.b;
            long[] jArr4 = this.a;
            int[] g = ThreefishEngine.f26801b;
            int[] e = ThreefishEngine.f26803d;
            if (jArr3.length != 33) {
                throw new IllegalArgumentException();
            } else if (jArr4.length == 5) {
                long j;
                long j2;
                long j3;
                long j4 = jArr[0];
                long j5 = jArr[1];
                long j6 = jArr[2];
                long j7 = jArr[3];
                long j8 = jArr[4];
                long j9 = jArr[5];
                long j10 = jArr[6];
                long j11 = jArr[7];
                long j12 = jArr[8];
                long j13 = jArr[9];
                long j14 = jArr[10];
                long j15 = jArr[11];
                long j16 = jArr[12];
                int i = 13;
                long j17 = jArr[13];
                long j18 = jArr[14];
                j4 += jArr3[0];
                j5 += jArr3[1];
                j8 += jArr3[4];
                j10 += jArr3[6];
                j12 += jArr3[8];
                j14 += jArr3[10];
                j16 += jArr3[12];
                j18 += jArr3[14] + jArr4[1];
                long j19 = j9 + jArr3[5];
                long j20 = j11 + jArr3[7];
                long j21 = j13 + jArr3[9];
                long j22 = j15 + jArr3[11];
                long j23 = j17 + (jArr3[13] + jArr4[0]);
                long j24 = jArr[15] + jArr3[15];
                int i2 = 1;
                long j25 = j7 + jArr3[3];
                j7 = j6 + jArr3[2];
                while (i2 < 20) {
                    int i3 = g[i2];
                    int i4 = e[i2];
                    j4 += j5;
                    j5 = ThreefishEngine.m35261a(j5, 24, j4);
                    int[] iArr = g;
                    int[] iArr2 = e;
                    j = j7 + j25;
                    j25 = ThreefishEngine.m35261a(j25, i, j);
                    int i5 = i2;
                    long j26 = j4;
                    long j27 = j19;
                    long j28 = j8 + j27;
                    long[] jArr5 = jArr3;
                    long a = ThreefishEngine.m35261a(j27, 8, j28);
                    j2 = j20;
                    long j29 = j10 + j2;
                    j2 = ThreefishEngine.m35261a(j2, 47, j29);
                    int i6 = i3;
                    long j30 = j5;
                    j4 = j21;
                    j3 = j12 + j4;
                    j4 = ThreefishEngine.m35261a(j4, 8, j3);
                    long j31 = j3;
                    long j32 = j25;
                    j3 = j22;
                    j25 = j14 + j3;
                    j3 = ThreefishEngine.m35261a(j3, 17, j25);
                    long j33 = j2;
                    long j34 = j25;
                    j2 = j23;
                    j25 = j16 + j2;
                    j2 = ThreefishEngine.m35261a(j2, 22, j25);
                    long j35 = j28;
                    long j36 = j25;
                    j25 = j24;
                    j28 = j18 + j25;
                    long a2 = ThreefishEngine.m35261a(j25, 37, j28);
                    long j37 = j28;
                    j28 = j26 + j4;
                    j4 = ThreefishEngine.m35261a(j4, 38, j28);
                    j += j2;
                    j2 = ThreefishEngine.m35261a(j2, 19, j);
                    j29 += j3;
                    j3 = ThreefishEngine.m35261a(j3, 10, j29);
                    long j38 = j4;
                    j4 = j35 + a2;
                    a2 = ThreefishEngine.m35261a(a2, 55, j4);
                    long j39 = j3;
                    j3 = j34 + j33;
                    long j40 = j2;
                    j2 = ThreefishEngine.m35261a(j33, 49, j3);
                    long j41 = j3;
                    j3 = j36 + j32;
                    long j42 = a2;
                    a2 = ThreefishEngine.m35261a(j32, 18, j3);
                    long j43 = j3;
                    j3 = j37 + a;
                    long j44 = j29;
                    j29 = ThreefishEngine.m35261a(a, 23, j3);
                    long j45 = j3;
                    j3 = j31 + j30;
                    long j46 = j4;
                    j4 = ThreefishEngine.m35261a(j30, 52, j3);
                    j28 += j2;
                    j2 = ThreefishEngine.m35261a(j2, 33, j28);
                    j += j29;
                    j29 = ThreefishEngine.m35261a(j29, 4, j);
                    long j47 = j2;
                    j2 = j46 + a2;
                    long a3 = ThreefishEngine.m35261a(a2, 51, j2);
                    a2 = j44 + j4;
                    long j48 = j29;
                    j29 = j43 + j42;
                    long a4 = ThreefishEngine.m35261a(j4, 13, a2);
                    j4 = ThreefishEngine.m35261a(j42, 34, j29);
                    long j49 = j29;
                    j29 = j45 + j40;
                    long j50 = j2;
                    j2 = ThreefishEngine.m35261a(j40, 41, j29);
                    j3 += j39;
                    long j51 = j29;
                    j29 = ThreefishEngine.m35261a(j39, 59, j3);
                    long j52 = j3;
                    j3 = j41 + j38;
                    long j53 = j2;
                    j2 = ThreefishEngine.m35261a(j38, 17, j3);
                    j28 += j4;
                    j4 = ThreefishEngine.m35261a(j4, 5, j28);
                    j += j29;
                    j29 = ThreefishEngine.m35261a(j29, 20, j);
                    a2 += j53;
                    long j54 = j4;
                    long a5 = ThreefishEngine.m35261a(j53, 48, a2);
                    j4 = j50 + j2;
                    long j55 = j29;
                    j29 = j51 + a4;
                    long a6 = ThreefishEngine.m35261a(j2, 41, j4);
                    j2 = ThreefishEngine.m35261a(a4, 47, j29);
                    long j56 = j29;
                    j29 = j52 + j48;
                    long j57 = a2;
                    a2 = ThreefishEngine.m35261a(j48, 28, j29);
                    j3 += a3;
                    long j58 = j29;
                    j29 = ThreefishEngine.m35261a(a3, 16, j3);
                    long j59 = j3;
                    j3 = j49 + j47;
                    long j60 = a2;
                    int i7 = i6 + 1;
                    j2 += jArr5[i7];
                    int i8 = i6 + 2;
                    j += jArr5[i8];
                    int i9 = i6 + 3;
                    j29 += jArr5[i9];
                    int i10 = i6 + 4;
                    int i11 = i6 + 5;
                    long j61 = j4 + jArr5[i10];
                    j4 = j60 + jArr5[i11];
                    int i12 = i6 + 6;
                    j10 = j57 + jArr5[i12];
                    int i13 = i6 + 7;
                    int i14 = i6 + 8;
                    j12 = j58 + jArr5[i14];
                    int i15 = i6 + 9;
                    long a7 = ThreefishEngine.m35261a(j47, 25, j3) + jArr5[i13];
                    int i16 = i6 + 10;
                    j14 = j59 + jArr5[i16];
                    int i17 = i6 + 11;
                    long j62 = a6 + jArr5[i15];
                    a2 = j55 + jArr5[i17];
                    int i18 = i6 + 12;
                    int i19 = i6 + 13;
                    long j63 = j3 + jArr5[i18];
                    int i20 = i6 + 14;
                    int i21 = i4 + 1;
                    j17 = j56 + (jArr5[i20] + jArr4[i21]);
                    int i22 = i6 + 15;
                    long[] jArr6 = jArr4;
                    long j64 = a5 + (jArr5[i19] + jArr4[i4]);
                    int i23 = i5;
                    j3 = (long) i23;
                    long j65 = j3;
                    j3 = j54 + (jArr5[i22] + j3);
                    int i24 = i23;
                    j28 = (j28 + jArr5[i6]) + j2;
                    j2 = ThreefishEngine.m35261a(j2, 41, j28);
                    j += j29;
                    j29 = ThreefishEngine.m35261a(j29, 9, j);
                    long j66 = j2;
                    j2 = j61 + j4;
                    long a8 = ThreefishEngine.m35261a(j4, 37, j2);
                    j4 = j10 + a7;
                    long j67 = j29;
                    long a9 = ThreefishEngine.m35261a(a7, 31, j4);
                    j29 = j12 + j62;
                    long j68 = j2;
                    j2 = ThreefishEngine.m35261a(j62, 12, j29);
                    long j69 = j29;
                    j29 = j14 + a2;
                    a2 = ThreefishEngine.m35261a(a2, 47, j29);
                    long j70 = j29;
                    j29 = j63 + j64;
                    long j71 = j4;
                    j4 = ThreefishEngine.m35261a(j64, 44, j29);
                    long j72 = j29;
                    j29 = j17 + j3;
                    j3 = ThreefishEngine.m35261a(j3, 30, j29);
                    j28 += j2;
                    j2 = ThreefishEngine.m35261a(j2, 16, j28);
                    j += j4;
                    j4 = ThreefishEngine.m35261a(j4, 34, j);
                    long j73 = j2;
                    j2 = j71 + a2;
                    long a10 = ThreefishEngine.m35261a(a2, 56, j2);
                    a2 = j68 + j3;
                    long j74 = j4;
                    j4 = j70 + a9;
                    long a11 = ThreefishEngine.m35261a(j3, 51, a2);
                    j3 = ThreefishEngine.m35261a(a9, 4, j4);
                    long j75 = j4;
                    j4 = j72 + j67;
                    long j76 = j2;
                    j2 = ThreefishEngine.m35261a(j67, 53, j4);
                    j29 += a8;
                    long j77 = j4;
                    j4 = ThreefishEngine.m35261a(a8, 42, j29);
                    long j78 = j29;
                    j29 = j69 + j66;
                    long j79 = j2;
                    j2 = ThreefishEngine.m35261a(j66, 41, j29);
                    j28 += j3;
                    j3 = ThreefishEngine.m35261a(j3, 31, j28);
                    j += j4;
                    j4 = ThreefishEngine.m35261a(j4, 44, j);
                    a2 += j79;
                    long j80 = j3;
                    long a12 = ThreefishEngine.m35261a(j79, 47, a2);
                    j3 = j76 + j2;
                    long j81 = j4;
                    j4 = j77 + a11;
                    long a13 = ThreefishEngine.m35261a(j2, 46, j3);
                    j2 = ThreefishEngine.m35261a(a11, 19, j4);
                    long j82 = j4;
                    j4 = j78 + j74;
                    long j83 = a2;
                    a2 = ThreefishEngine.m35261a(j74, 42, j4);
                    j29 += a10;
                    long j84 = j4;
                    j4 = ThreefishEngine.m35261a(a10, 44, j29);
                    long j85 = j29;
                    j29 = j75 + j73;
                    long j86 = j3;
                    j3 = ThreefishEngine.m35261a(j73, 25, j29);
                    j28 += j2;
                    j2 = ThreefishEngine.m35261a(j2, 9, j28);
                    j += j4;
                    j4 = ThreefishEngine.m35261a(j4, 48, j);
                    long j87 = j2;
                    j2 = j86 + a2;
                    long a14 = ThreefishEngine.m35261a(a2, 35, j2);
                    a2 = j83 + j3;
                    long j88 = j4;
                    j4 = j84 + a13;
                    long a15 = ThreefishEngine.m35261a(j3, 52, a2);
                    j3 = ThreefishEngine.m35261a(a13, 23, j4);
                    long j89 = j4;
                    j4 = j85 + j81;
                    long j90 = j2;
                    j2 = ThreefishEngine.m35261a(j81, 31, j4);
                    j29 += a12;
                    long j91 = j4;
                    j4 = ThreefishEngine.m35261a(a12, 37, j29);
                    long j92 = j29;
                    j29 = j82 + j80;
                    long j93 = j2;
                    j3 += jArr5[i8];
                    j7 = j + jArr5[i9];
                    long j94 = jArr5[i10] + j4;
                    j8 = a2 + jArr5[i11];
                    j19 = j93 + jArr5[i12];
                    j10 = j90 + jArr5[i13];
                    j20 = ThreefishEngine.m35261a(j80, 20, j29) + jArr5[i14];
                    j12 = j91 + jArr5[i15];
                    j21 = a15 + jArr5[i16];
                    j14 = j92 + jArr5[i17];
                    j22 = j88 + jArr5[i18];
                    j23 = a14 + (jArr5[i20] + jArr6[i21]);
                    j18 = j89 + (jArr5[i22] + jArr6[i4 + 2]);
                    j24 = j87 + ((jArr5[i6 + 16] + j65) + 1);
                    j4 = j28 + jArr5[i7];
                    j16 = j29 + jArr5[i19];
                    j25 = j94;
                    i2 = i24 + 2;
                    j5 = j3;
                    g = iArr;
                    e = iArr2;
                    jArr3 = jArr5;
                    jArr4 = jArr6;
                    Threefish1024Cipher threefish1024Cipher = this;
                    i = 13;
                }
                long j95 = j4;
                long j96 = j5;
                j = j25;
                j9 = j19;
                j11 = j20;
                j4 = j21;
                j3 = j22;
                j2 = j23;
                j25 = j24;
                jArr2[0] = j95;
                jArr2[1] = j96;
                jArr2[2] = j7;
                jArr2[3] = j;
                jArr2[4] = j8;
                jArr2[5] = j9;
                jArr2[6] = j10;
                jArr2[7] = j11;
                jArr2[8] = j12;
                jArr2[9] = j4;
                jArr2[10] = j14;
                jArr2[11] = j3;
                jArr2[12] = j16;
                jArr2[13] = j2;
                jArr2[14] = j18;
                jArr2[15] = j25;
            } else {
                throw new IllegalArgumentException();
            }
        }

        /* renamed from: b */
        void mo5754b(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.b;
            long[] jArr4 = this.a;
            int[] g = ThreefishEngine.f26801b;
            int[] e = ThreefishEngine.f26803d;
            if (jArr3.length != 33) {
                throw new IllegalArgumentException();
            } else if (jArr4.length == 5) {
                long[] jArr5;
                long[] jArr6;
                long j = jArr[0];
                int i = 1;
                long j2 = jArr[1];
                long j3 = jArr[2];
                long j4 = jArr[3];
                long j5 = jArr[4];
                long j6 = jArr[5];
                long j7 = jArr[6];
                long j8 = jArr[7];
                long j9 = jArr[8];
                long j10 = jArr[9];
                long j11 = jArr[10];
                long j12 = jArr[11];
                long j13 = jArr[12];
                long j14 = jArr[13];
                long j15 = jArr[14];
                long j16 = jArr[15];
                int i2 = 19;
                while (i2 >= i) {
                    int i3 = g[i2];
                    int i4 = e[i2];
                    int i5 = i3 + 1;
                    j -= jArr3[i5];
                    int i6 = i3 + 2;
                    int i7 = i3 + 3;
                    long j17 = j3 - jArr3[i7];
                    int i8 = i3 + 4;
                    long j18 = j2 - jArr3[i6];
                    long j19 = j4 - jArr3[i8];
                    int i9 = i3 + 5;
                    long j20 = j5 - jArr3[i9];
                    int i10 = i3 + 6;
                    int[] iArr = g;
                    int[] iArr2 = e;
                    int i11 = i3 + 7;
                    long j21 = j19;
                    j19 = j7 - jArr3[i11];
                    int i12 = i3 + 8;
                    long j22 = j6 - jArr3[i10];
                    int i13 = i3 + 9;
                    long j23 = j8 - jArr3[i12];
                    int i14 = i3 + 10;
                    long j24 = j9 - jArr3[i13];
                    int i15 = i3 + 11;
                    long j25 = j10 - jArr3[i14];
                    int i16 = i3 + 12;
                    long j26 = j11 - jArr3[i15];
                    long j27 = j12 - jArr3[i16];
                    int i17 = i3 + 13;
                    long j28 = j20;
                    int i18 = i3 + 14;
                    int i19 = i4 + 1;
                    long j29 = j13 - jArr3[i17];
                    int i20 = i3 + 15;
                    long j30 = j14 - (jArr3[i18] + jArr4[i19]);
                    j20 = j15 - (jArr3[i20] + jArr4[i4 + 2]);
                    jArr5 = jArr3;
                    long j31 = (long) i2;
                    int i21 = i2;
                    long j32 = j31;
                    long b = ThreefishEngine.m35265b(j16 - ((jArr3[i3 + 16] + j31) + 1), 9, j);
                    j -= b;
                    j31 = ThreefishEngine.m35265b(j27, 48, j17);
                    j17 -= j31;
                    long j33 = j31;
                    j31 = ThreefishEngine.m35265b(j30, 35, j19);
                    j19 -= j31;
                    long j34 = b;
                    long j35 = j31;
                    j31 = j28;
                    b = ThreefishEngine.m35265b(j25, 52, j31);
                    j31 -= b;
                    long j36 = b;
                    b = ThreefishEngine.m35265b(j18, 23, j20);
                    long j37 = b;
                    long j38 = j20 - b;
                    b = j24;
                    j27 = ThreefishEngine.m35265b(j22, 31, b);
                    long j39 = b - j27;
                    long j40 = j19;
                    j19 = j26;
                    b = ThreefishEngine.m35265b(j21, 37, j19);
                    long j41 = j19 - b;
                    int i22 = i9;
                    j20 = j29;
                    j19 = ThreefishEngine.m35265b(j23, 20, j20);
                    j20 -= j19;
                    j19 = ThreefishEngine.m35265b(j19, 31, j);
                    j -= j19;
                    j27 = ThreefishEngine.m35265b(j27, 44, j17);
                    j17 -= j27;
                    b = ThreefishEngine.m35265b(b, 47, j31);
                    j31 -= b;
                    long j42 = b;
                    jArr6 = jArr4;
                    long j43 = j27;
                    long j44 = j40;
                    b = ThreefishEngine.m35265b(j37, 46, j44);
                    j44 -= b;
                    long j45 = b;
                    b = ThreefishEngine.m35265b(j34, 19, j20);
                    long j46 = j20 - b;
                    long j47 = j19;
                    j19 = j38;
                    long b2 = ThreefishEngine.m35265b(j35, 42, j19);
                    long j48 = b;
                    long j49 = j19 - b2;
                    b = j39;
                    j19 = ThreefishEngine.m35265b(j33, 44, b);
                    long j50 = b - j19;
                    long j51 = j31;
                    j31 = j41;
                    b = ThreefishEngine.m35265b(j36, 25, j31);
                    j31 -= b;
                    b = ThreefishEngine.m35265b(b, 16, j);
                    j -= b;
                    b2 = ThreefishEngine.m35265b(b2, 34, j17);
                    j17 -= b2;
                    j19 = ThreefishEngine.m35265b(j19, 56, j44);
                    j44 -= j19;
                    long j52 = b2;
                    long j53 = j19;
                    b2 = j51;
                    j19 = ThreefishEngine.m35265b(j48, 51, b2);
                    b2 -= j19;
                    long j54 = j19;
                    j19 = ThreefishEngine.m35265b(j47, 4, j31);
                    long j55 = b;
                    long j56 = j31 - j19;
                    b = j46;
                    j31 = ThreefishEngine.m35265b(j42, 53, b);
                    long j57 = b - j31;
                    long j58 = j44;
                    j44 = j49;
                    b = ThreefishEngine.m35265b(j43, 42, j44);
                    long j59 = j44 - b;
                    long j60 = j19;
                    j19 = j50;
                    j44 = ThreefishEngine.m35265b(j45, 41, j19);
                    j19 -= j44;
                    j44 = ThreefishEngine.m35265b(j44, 41, j);
                    j -= j44;
                    j31 = ThreefishEngine.m35265b(j31, 9, j17);
                    j17 -= j31;
                    b = ThreefishEngine.m35265b(b, 37, b2);
                    long j61 = b;
                    long j62 = b2 - b;
                    b = j58;
                    b2 = ThreefishEngine.m35265b(j60, 31, b);
                    b -= b2;
                    long j63 = b2;
                    b2 = ThreefishEngine.m35265b(j55, 12, j19);
                    long j64 = b2;
                    long j65 = j19 - b2;
                    j19 = j56;
                    b2 = ThreefishEngine.m35265b(j53, 47, j19);
                    long j66 = b2;
                    long j67 = j19 - b2;
                    j19 = j57;
                    b2 = ThreefishEngine.m35265b(j52, 44, j19);
                    long j68 = b2;
                    long j69 = j19 - b2;
                    j19 = j59;
                    b2 = ThreefishEngine.m35265b(j54, 30, j19);
                    j -= jArr5[i3];
                    j17 -= jArr5[i6];
                    long j70 = j31 - jArr5[i7];
                    long j71 = j44 - jArr5[i5];
                    b -= jArr5[i10];
                    long j72 = j61 - jArr5[i22];
                    long j73 = j63 - jArr5[i11];
                    long j74 = j65 - jArr5[i12];
                    long j75 = j62 - jArr5[i8];
                    long j76 = j67 - jArr5[i14];
                    j31 = j66 - jArr5[i15];
                    long j77 = j64 - jArr5[i13];
                    long j78 = j69 - jArr5[i16];
                    j44 = j68 - (jArr5[i17] + jArr6[i4]);
                    j19 = (j19 - b2) - (jArr5[i18] + jArr6[i19]);
                    b2 = ThreefishEngine.m35265b(b2 - (jArr5[i20] + j32), 5, j);
                    j -= b2;
                    j31 = ThreefishEngine.m35265b(j31, 20, j17);
                    j17 -= j31;
                    j44 = ThreefishEngine.m35265b(j44, 48, b);
                    b -= j44;
                    long j79 = j31;
                    long j80 = j44;
                    j31 = j75;
                    j44 = ThreefishEngine.m35265b(j77, 41, j31);
                    j31 -= j44;
                    long j81 = j44;
                    j44 = ThreefishEngine.m35265b(j71, 47, j19);
                    long j82 = b2;
                    long j83 = j19 - j44;
                    b2 = j74;
                    j19 = ThreefishEngine.m35265b(j72, 28, b2);
                    long j84 = b;
                    long j85 = b2 - j19;
                    b = j76;
                    b2 = ThreefishEngine.m35265b(j70, 16, b);
                    long j86 = b - b2;
                    long j87 = j44;
                    j44 = j78;
                    b = ThreefishEngine.m35265b(j73, 25, j44);
                    j44 -= b;
                    b = ThreefishEngine.m35265b(b, 33, j);
                    j -= b;
                    j19 = ThreefishEngine.m35265b(j19, 4, j17);
                    j17 -= j19;
                    b2 = ThreefishEngine.m35265b(b2, 51, j31);
                    j31 -= b2;
                    long j88 = b2;
                    long j89 = j19;
                    j19 = j84;
                    b2 = ThreefishEngine.m35265b(j87, 13, j19);
                    j19 -= b2;
                    long j90 = b2;
                    b2 = ThreefishEngine.m35265b(j82, 34, j44);
                    long j91 = b;
                    long j92 = j44 - b2;
                    b = j83;
                    j44 = ThreefishEngine.m35265b(j80, 41, b);
                    long j93 = b - j44;
                    long j94 = j31;
                    j31 = j85;
                    b = ThreefishEngine.m35265b(j79, 59, j31);
                    long j95 = j31 - b;
                    long j96 = b2;
                    b2 = j86;
                    j31 = ThreefishEngine.m35265b(j81, 17, b2);
                    b2 -= j31;
                    j31 = ThreefishEngine.m35265b(j31, 38, j);
                    j -= j31;
                    j44 = ThreefishEngine.m35265b(j44, 19, j17);
                    j17 -= j44;
                    b = ThreefishEngine.m35265b(b, 10, j19);
                    j19 -= b;
                    long j97 = b;
                    long j98 = j44;
                    j44 = j94;
                    b = ThreefishEngine.m35265b(j96, 55, j44);
                    j44 -= b;
                    long j99 = b;
                    b = ThreefishEngine.m35265b(j91, 49, b2);
                    long j100 = j31;
                    long j101 = b2 - b;
                    j31 = j92;
                    b2 = ThreefishEngine.m35265b(j88, 18, j31);
                    long j102 = b;
                    long j103 = j31 - b2;
                    b = j93;
                    j31 = ThreefishEngine.m35265b(j89, 23, b);
                    long j104 = b - j31;
                    long j105 = j19;
                    j19 = j95;
                    b = ThreefishEngine.m35265b(j90, 52, j19);
                    j19 -= b;
                    b = ThreefishEngine.m35265b(b, 24, j);
                    j -= b;
                    j4 = ThreefishEngine.m35265b(b2, 13, j17);
                    j3 = j17 - j4;
                    j6 = ThreefishEngine.m35265b(j31, 8, j44);
                    j5 = j44 - j6;
                    long j106 = j105;
                    j8 = ThreefishEngine.m35265b(j102, 47, j106);
                    j7 = j106 - j8;
                    j10 = ThreefishEngine.m35265b(j100, 8, j19);
                    j9 = j19 - j10;
                    b2 = j101;
                    j12 = ThreefishEngine.m35265b(j97, 17, b2);
                    j11 = b2 - j12;
                    j27 = j103;
                    j14 = ThreefishEngine.m35265b(j98, 22, j27);
                    j13 = j27 - j14;
                    j27 = j104;
                    j16 = ThreefishEngine.m35265b(j99, 37, j27);
                    j15 = j27 - j16;
                    j2 = b;
                    i2 = i21 - 2;
                    g = iArr;
                    e = iArr2;
                    jArr3 = jArr5;
                    jArr4 = jArr6;
                    Threefish1024Cipher threefish1024Cipher = this;
                    i = 1;
                }
                jArr5 = jArr3;
                jArr6 = jArr4;
                j2 -= jArr5[1];
                j3 -= jArr5[2];
                j4 -= jArr5[3];
                j5 -= jArr5[4];
                j6 -= jArr5[5];
                j7 -= jArr5[6];
                j8 -= jArr5[7];
                j9 -= jArr5[8];
                j10 -= jArr5[9];
                j11 -= jArr5[10];
                j12 -= jArr5[11];
                j13 -= jArr5[12];
                j14 -= jArr5[13] + jArr6[0];
                j15 -= jArr5[14] + jArr6[1];
                j16 -= jArr5[15];
                jArr2[0] = j - jArr5[0];
                jArr2[1] = j2;
                jArr2[2] = j3;
                jArr2[3] = j4;
                jArr2[4] = j5;
                jArr2[5] = j6;
                jArr2[6] = j7;
                jArr2[7] = j8;
                jArr2[8] = j9;
                jArr2[9] = j10;
                jArr2[10] = j11;
                jArr2[11] = j12;
                jArr2[12] = j13;
                jArr2[13] = j14;
                jArr2[14] = j15;
                jArr2[15] = j16;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    private static final class Threefish256Cipher extends ThreefishCipher {
        public Threefish256Cipher(long[] jArr, long[] jArr2) {
            super(jArr, jArr2);
        }

        /* renamed from: a */
        void mo5753a(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.b;
            long[] jArr4 = this.a;
            int[] d = ThreefishEngine.f26802c;
            int[] e = ThreefishEngine.f26803d;
            if (jArr3.length != 9) {
                throw new IllegalArgumentException();
            } else if (jArr4.length == 5) {
                long j = jArr[0];
                long j2 = jArr[1];
                long j3 = jArr[2];
                j += jArr3[0];
                j2 += jArr3[1] + jArr4[0];
                int i = 1;
                long j4 = jArr[3] + jArr3[3];
                long j5 = j3 + (jArr3[2] + jArr4[1]);
                while (i < 18) {
                    int i2 = d[i];
                    int i3 = e[i];
                    j += j2;
                    j2 = ThreefishEngine.m35261a(j2, 14, j);
                    long j6 = j;
                    long j7 = j5 + j4;
                    j4 = ThreefishEngine.m35261a(j4, 16, j7);
                    int[] iArr = d;
                    int[] iArr2 = e;
                    long j8 = j6 + j4;
                    j4 = ThreefishEngine.m35261a(j4, 52, j8);
                    j7 += j2;
                    j2 = ThreefishEngine.m35261a(j2, 57, j7);
                    j8 += j2;
                    j2 = ThreefishEngine.m35261a(j2, 23, j8);
                    j7 += j4;
                    j4 = ThreefishEngine.m35261a(j4, 40, j7);
                    j8 += j4;
                    j4 = ThreefishEngine.m35261a(j4, 5, j8);
                    j7 += j2;
                    int i4 = i2 + 1;
                    j2 = ThreefishEngine.m35261a(j2, 37, j7) + (jArr3[i4] + jArr4[i3]);
                    int i5 = i2 + 2;
                    int i6 = i3 + 1;
                    int i7 = i2 + 3;
                    long j9 = j7 + (jArr3[i5] + jArr4[i6]);
                    long j10 = (long) i;
                    j4 += jArr3[i7] + j10;
                    j8 = (j8 + jArr3[i2]) + j2;
                    j2 = ThreefishEngine.m35261a(j2, 25, j8);
                    int i8 = i;
                    long j11 = j9 + j4;
                    j4 = ThreefishEngine.m35261a(j4, 33, j11);
                    j8 += j4;
                    j4 = ThreefishEngine.m35261a(j4, 46, j8);
                    j11 += j2;
                    j2 = ThreefishEngine.m35261a(j2, 12, j11);
                    j8 += j2;
                    j2 = ThreefishEngine.m35261a(j2, 58, j8);
                    j11 += j4;
                    j4 = ThreefishEngine.m35261a(j4, 22, j11);
                    j8 += j4;
                    j4 = ThreefishEngine.m35261a(j4, 32, j8);
                    j11 += j2;
                    j = jArr3[i4] + j8;
                    j2 = ThreefishEngine.m35261a(j2, 32, j11) + (jArr3[i5] + jArr4[i6]);
                    j5 = j11 + (jArr3[i7] + jArr4[i3 + 2]);
                    j4 += (jArr3[i2 + 4] + j10) + 1;
                    i = i8 + 2;
                    d = iArr;
                    e = iArr2;
                    Threefish256Cipher threefish256Cipher = this;
                }
                jArr2[0] = j;
                jArr2[1] = j2;
                jArr2[2] = j5;
                jArr2[3] = j4;
            } else {
                throw new IllegalArgumentException();
            }
        }

        /* renamed from: b */
        void mo5754b(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.b;
            long[] jArr4 = this.a;
            int[] d = ThreefishEngine.f26802c;
            int[] e = ThreefishEngine.f26803d;
            if (jArr3.length != 9) {
                throw new IllegalArgumentException();
            } else if (jArr4.length == 5) {
                long j = jArr[0];
                int i = 1;
                long j2 = jArr[1];
                long j3 = jArr[2];
                long j4 = jArr[3];
                int i2 = 17;
                while (i2 >= i) {
                    int i3 = d[i2];
                    int i4 = e[i2];
                    int i5 = i3 + 1;
                    j -= jArr3[i5];
                    int i6 = i3 + 2;
                    int i7 = i4 + 1;
                    int i8 = i3 + 3;
                    long j5 = j3 - (jArr3[i8] + jArr4[i4 + 2]);
                    long j6 = (long) i2;
                    long j7 = j2 - (jArr3[i6] + jArr4[i7]);
                    long b = ThreefishEngine.m35265b(j4 - ((jArr3[i3 + 4] + j6) + 1), 32, j);
                    j -= b;
                    int[] iArr = d;
                    int[] iArr2 = e;
                    long b2 = ThreefishEngine.m35265b(j7, 32, j5);
                    j5 -= b2;
                    b2 = ThreefishEngine.m35265b(b2, 58, j);
                    j -= b2;
                    b = ThreefishEngine.m35265b(b, 22, j5);
                    j5 -= b;
                    b = ThreefishEngine.m35265b(b, 46, j);
                    j -= b;
                    b2 = ThreefishEngine.m35265b(b2, 12, j5);
                    j5 -= b2;
                    b2 = ThreefishEngine.m35265b(b2, 25, j);
                    j -= b2;
                    b = ThreefishEngine.m35265b(b, 33, j5);
                    j -= jArr3[i3];
                    b2 -= jArr3[i5] + jArr4[i4];
                    j5 = (j5 - b) - (jArr3[i6] + jArr4[i7]);
                    b = ThreefishEngine.m35265b(b - (jArr3[i8] + j6), 5, j);
                    j -= b;
                    b2 = ThreefishEngine.m35265b(b2, 37, j5);
                    j5 -= b2;
                    b2 = ThreefishEngine.m35265b(b2, 23, j);
                    j -= b2;
                    b = ThreefishEngine.m35265b(b, 40, j5);
                    j5 -= b;
                    b = ThreefishEngine.m35265b(b, 52, j);
                    j -= b;
                    b2 = ThreefishEngine.m35265b(b2, 57, j5);
                    j5 -= b2;
                    b2 = ThreefishEngine.m35265b(b2, 14, j);
                    j -= b2;
                    j4 = ThreefishEngine.m35265b(b, 16, j5);
                    j3 = j5 - j4;
                    i2 -= 2;
                    j2 = b2;
                    d = iArr;
                    e = iArr2;
                    i = 1;
                }
                j2 -= jArr3[1] + jArr4[0];
                j3 -= jArr3[2] + jArr4[1];
                j4 -= jArr3[3];
                jArr2[0] = j - jArr3[0];
                jArr2[1] = j2;
                jArr2[2] = j3;
                jArr2[3] = j4;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    private static final class Threefish512Cipher extends ThreefishCipher {
        protected Threefish512Cipher(long[] jArr, long[] jArr2) {
            super(jArr, jArr2);
        }

        /* renamed from: a */
        public void mo5753a(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.b;
            long[] jArr4 = this.a;
            int[] f = ThreefishEngine.f26800a;
            int[] e = ThreefishEngine.f26803d;
            if (jArr3.length != 17) {
                throw new IllegalArgumentException();
            } else if (jArr4.length == 5) {
                long j;
                long j2 = jArr[0];
                long j3 = jArr[1];
                long j4 = jArr[2];
                long j5 = jArr[3];
                long j6 = jArr[4];
                long j7 = jArr[5];
                long j8 = jArr[6];
                j2 += jArr3[0];
                j3 += jArr3[1];
                j4 += jArr3[2];
                j6 += jArr3[4];
                j8 += jArr3[6] + jArr4[1];
                long j9 = j5 + jArr3[3];
                long j10 = j7 + (jArr3[5] + jArr4[0]);
                long j11 = jArr[7] + jArr3[7];
                int i = 1;
                while (i < 18) {
                    int i2 = f[i];
                    int i3 = e[i];
                    j2 += j3;
                    long a = ThreefishEngine.m35261a(j3, 46, j2);
                    int[] iArr = f;
                    int[] iArr2 = e;
                    long j12 = j4 + j9;
                    j9 = ThreefishEngine.m35261a(j9, 36, j12);
                    int i4 = i;
                    long[] jArr5 = jArr3;
                    j = j10;
                    long j13 = j6 + j;
                    j = ThreefishEngine.m35261a(j, 19, j13);
                    long j14 = j9;
                    int i5 = i2;
                    long j15 = j2;
                    j9 = j11;
                    long j16 = j8 + j9;
                    j9 = ThreefishEngine.m35261a(j9, 37, j16);
                    j12 += a;
                    long a2 = ThreefishEngine.m35261a(a, 33, j12);
                    j13 += j9;
                    j9 = ThreefishEngine.m35261a(j9, 27, j13);
                    j16 += j;
                    j = ThreefishEngine.m35261a(j, 14, j16);
                    long j17 = j15 + j14;
                    long[] jArr6 = jArr4;
                    long j18 = j12;
                    long a3 = ThreefishEngine.m35261a(j14, 42, j17);
                    j13 += a2;
                    a2 = ThreefishEngine.m35261a(a2, 17, j13);
                    j16 += a3;
                    a3 = ThreefishEngine.m35261a(a3, 49, j16);
                    j17 += j;
                    j = ThreefishEngine.m35261a(j, 36, j17);
                    long j19 = j13;
                    j13 = j18 + j9;
                    j9 = ThreefishEngine.m35261a(j9, 39, j13);
                    j16 += a2;
                    a2 = ThreefishEngine.m35261a(a2, 44, j16);
                    j17 += j9;
                    j9 = ThreefishEngine.m35261a(j9, 9, j17);
                    j13 += j;
                    j = ThreefishEngine.m35261a(j, 54, j13);
                    long j20 = j9;
                    long j21 = j19 + a3;
                    int i6 = i5 + 1;
                    a2 += jArr5[i6];
                    int i7 = i5 + 2;
                    j13 += jArr5[i7];
                    int i8 = i5 + 3;
                    a3 = ThreefishEngine.m35261a(a3, 56, j21) + jArr5[i8];
                    int i9 = i5 + 4;
                    j21 += jArr5[i9];
                    int i10 = i5 + 5;
                    j += jArr5[i10] + jArr6[i3];
                    int i11 = i5 + 6;
                    int i12 = i3 + 1;
                    int i13 = i5 + 7;
                    long j22 = j16 + (jArr5[i11] + jArr6[i12]);
                    int i14 = i4;
                    j16 = (long) i14;
                    int i15 = i14;
                    long j23 = j16;
                    long j24 = j20 + (jArr5[i13] + j16);
                    j17 = (j17 + jArr5[i5]) + a2;
                    a2 = ThreefishEngine.m35261a(a2, 39, j17);
                    j13 += a3;
                    a3 = ThreefishEngine.m35261a(a3, 30, j13);
                    j21 += j;
                    j = ThreefishEngine.m35261a(j, 34, j21);
                    long j25 = a3;
                    a3 = j22 + j24;
                    j24 = ThreefishEngine.m35261a(j24, 24, a3);
                    j13 += a2;
                    j2 = ThreefishEngine.m35261a(a2, 13, j13);
                    j21 += j24;
                    j24 = ThreefishEngine.m35261a(j24, 50, j21);
                    a3 += j;
                    j = ThreefishEngine.m35261a(j, 10, a3);
                    j17 += j25;
                    long j26 = j13;
                    int i16 = i6;
                    a = ThreefishEngine.m35261a(j25, 17, j17);
                    j21 += j2;
                    j2 = ThreefishEngine.m35261a(j2, 25, j21);
                    a3 += a;
                    a = ThreefishEngine.m35261a(a, 29, a3);
                    j17 += j;
                    j = ThreefishEngine.m35261a(j, 39, j17);
                    long j27 = j21;
                    j21 = j26 + j24;
                    j24 = ThreefishEngine.m35261a(j24, 43, j21);
                    a3 += j2;
                    j2 = ThreefishEngine.m35261a(j2, 8, a3);
                    j17 += j24;
                    j24 = ThreefishEngine.m35261a(j24, 35, j17);
                    j21 += j;
                    j = ThreefishEngine.m35261a(j, 56, j21);
                    long j28 = a3;
                    long j29 = j27 + a;
                    j2 += jArr5[i7];
                    j4 = j21 + jArr5[i8];
                    j10 = j + (jArr5[i11] + jArr6[i12]);
                    j8 = j28 + (jArr5[i13] + jArr6[i3 + 2]);
                    j11 = j24 + ((jArr5[i5 + 8] + j23) + 1);
                    i = i15 + 2;
                    j6 = j29 + jArr5[i10];
                    j9 = jArr5[i9] + ThreefishEngine.m35261a(a, 22, j29);
                    f = iArr;
                    e = iArr2;
                    jArr3 = jArr5;
                    jArr4 = jArr6;
                    Threefish512Cipher threefish512Cipher = this;
                    j3 = j2;
                    j2 = j17 + jArr5[i16];
                }
                j5 = j9;
                j = j10;
                j9 = j11;
                jArr2[0] = j2;
                jArr2[1] = j3;
                jArr2[2] = j4;
                jArr2[3] = j5;
                jArr2[4] = j6;
                jArr2[5] = j;
                jArr2[6] = j8;
                jArr2[7] = j9;
            } else {
                throw new IllegalArgumentException();
            }
        }

        /* renamed from: b */
        public void mo5754b(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.b;
            long[] jArr4 = this.a;
            int[] f = ThreefishEngine.f26800a;
            int[] e = ThreefishEngine.f26803d;
            if (jArr3.length != 17) {
                throw new IllegalArgumentException();
            } else if (jArr4.length == 5) {
                long[] jArr5;
                long[] jArr6;
                long j = jArr[0];
                int i = 1;
                long j2 = jArr[1];
                long j3 = jArr[2];
                long j4 = jArr[3];
                long j5 = jArr[4];
                long j6 = jArr[5];
                long j7 = jArr[6];
                long j8 = jArr[7];
                int i2 = 17;
                while (i2 >= i) {
                    int i3 = f[i2];
                    int i4 = e[i2];
                    int i5 = i3 + 1;
                    int i6 = i3 + 2;
                    int i7 = i3 + 3;
                    long j9 = j3 - jArr3[i7];
                    int i8 = i3 + 4;
                    long j10 = j - jArr3[i5];
                    long j11 = j4 - jArr3[i8];
                    int i9 = i3 + 5;
                    long j12 = j5 - jArr3[i9];
                    int i10 = i3 + 6;
                    int i11 = i4 + 1;
                    int[] iArr = f;
                    int[] iArr2 = e;
                    long j13 = j6 - (jArr3[i10] + jArr4[i11]);
                    int i12 = i3 + 7;
                    int i13 = i10;
                    long j14 = j7 - (jArr3[i12] + jArr4[i4 + 2]);
                    jArr5 = jArr3;
                    long j15 = (long) i2;
                    int i14 = i2;
                    long j16 = j8 - ((jArr3[i3 + 8] + j15) + 1);
                    long j17 = j15;
                    jArr6 = jArr4;
                    j15 = ThreefishEngine.m35265b(j2 - jArr3[i6], 8, j14);
                    long j18 = j14 - j15;
                    j14 = j10;
                    j16 = ThreefishEngine.m35265b(j16, 35, j14);
                    j14 -= j16;
                    j13 = ThreefishEngine.m35265b(j13, 56, j9);
                    j9 -= j13;
                    j11 = ThreefishEngine.m35265b(j11, 22, j12);
                    j12 -= j11;
                    j15 = ThreefishEngine.m35265b(j15, 25, j12);
                    int i15 = i9;
                    long j19 = j12 - j15;
                    long j20 = j18;
                    j11 = ThreefishEngine.m35265b(j11, 29, j20);
                    j20 -= j11;
                    j13 = ThreefishEngine.m35265b(j13, 39, j14);
                    j14 -= j13;
                    j16 = ThreefishEngine.m35265b(j16, 43, j9);
                    j9 -= j16;
                    j15 = ThreefishEngine.m35265b(j15, 13, j9);
                    j9 -= j15;
                    long j21 = j13;
                    long j22 = j19;
                    j16 = ThreefishEngine.m35265b(j16, 50, j22);
                    j22 -= j16;
                    long j23 = j16;
                    j16 = ThreefishEngine.m35265b(j21, 10, j20);
                    j20 -= j16;
                    j11 = ThreefishEngine.m35265b(j11, 17, j14);
                    j14 -= j11;
                    j15 = ThreefishEngine.m35265b(j15, 39, j14);
                    j14 -= j15;
                    j11 = ThreefishEngine.m35265b(j11, 30, j9);
                    j9 -= j11;
                    j16 = ThreefishEngine.m35265b(j16, 34, j22);
                    j22 -= j16;
                    long j24 = j16;
                    j16 = ThreefishEngine.m35265b(j23, 24, j20);
                    j14 -= jArr5[i3];
                    j9 -= jArr5[i6];
                    j11 -= jArr5[i7];
                    long j25 = j22 - jArr5[i8];
                    j22 = j24 - (jArr5[i15] + jArr6[i4]);
                    j20 = (j20 - j16) - (jArr5[i13] + jArr6[i11]);
                    j16 -= jArr5[i12] + j17;
                    j15 = ThreefishEngine.m35265b(j15 - jArr5[i5], 44, j20);
                    j20 -= j15;
                    j16 = ThreefishEngine.m35265b(j16, 9, j14);
                    j14 -= j16;
                    j22 = ThreefishEngine.m35265b(j22, 54, j9);
                    j9 -= j22;
                    long j26 = j16;
                    j16 = j25;
                    j11 = ThreefishEngine.m35265b(j11, 56, j16);
                    j16 -= j11;
                    j15 = ThreefishEngine.m35265b(j15, 17, j16);
                    j16 -= j15;
                    j11 = ThreefishEngine.m35265b(j11, 49, j20);
                    j20 -= j11;
                    j22 = ThreefishEngine.m35265b(j22, 36, j14);
                    long j27 = j14 - j22;
                    j2 = ThreefishEngine.m35265b(j26, 39, j9);
                    j9 -= j2;
                    j15 = ThreefishEngine.m35265b(j15, 33, j9);
                    j9 -= j15;
                    j2 = ThreefishEngine.m35265b(j2, 27, j16);
                    j16 -= j2;
                    j22 = ThreefishEngine.m35265b(j22, 14, j20);
                    j20 -= j22;
                    long j28 = j9;
                    long j29 = j27;
                    long b = ThreefishEngine.m35265b(j11, 42, j29);
                    j29 -= b;
                    j15 = ThreefishEngine.m35265b(j15, 46, j29);
                    j29 -= j15;
                    long j30 = j15;
                    j15 = j28;
                    j4 = ThreefishEngine.m35265b(b, 36, j15);
                    j3 = j15 - j4;
                    j6 = ThreefishEngine.m35265b(j22, 19, j16);
                    j5 = j16 - j6;
                    j8 = ThreefishEngine.m35265b(j2, 37, j20);
                    j7 = j20 - j8;
                    i2 = i14 - 2;
                    j = j29;
                    f = iArr;
                    e = iArr2;
                    jArr3 = jArr5;
                    jArr4 = jArr6;
                    j2 = j30;
                    Threefish512Cipher threefish512Cipher = this;
                    i = 1;
                }
                jArr5 = jArr3;
                jArr6 = jArr4;
                j2 -= jArr5[1];
                j3 -= jArr5[2];
                j4 -= jArr5[3];
                j5 -= jArr5[4];
                j6 -= jArr5[5] + jArr6[0];
                j7 -= jArr5[6] + jArr6[1];
                j8 -= jArr5[7];
                jArr2[0] = j - jArr5[0];
                jArr2[1] = j2;
                jArr2[2] = j3;
                jArr2[3] = j4;
                jArr2[4] = j5;
                jArr2[5] = j6;
                jArr2[6] = j7;
                jArr2[7] = j8;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    /* renamed from: a */
    static long m35261a(long j, int i, long j2) {
        return ((j >>> (-i)) | (j << i)) ^ j2;
    }

    /* renamed from: b */
    static long m35265b(long j, int i, long j2) {
        j ^= j2;
        return (j << (-i)) | (j >>> i);
    }

    /* renamed from: c */
    public void mo5744c() {
    }

    static {
        for (int i = 0; i < f26800a.length; i++) {
            f26801b[i] = i % 17;
            f26800a[i] = i % 9;
            f26802c[i] = i % 5;
            f26803d[i] = i % 3;
        }
    }

    public ThreefishEngine(int i) {
        this.f26804e = i / 8;
        this.f26805f = this.f26804e / 8;
        this.f26806g = new long[this.f26805f];
        this.f26808i = new long[((this.f26805f * 2) + 1)];
        if (i == 256) {
            this.f26809j = new Threefish256Cipher(this.f26808i, this.f26807h);
        } else if (i == 512) {
            this.f26809j = new Threefish512Cipher(this.f26808i, this.f26807h);
        } else if (i == 1024) {
            this.f26809j = new Threefish1024Cipher(this.f26808i, this.f26807h);
        } else {
            throw new IllegalArgumentException("Invalid blocksize - Threefish is defined with block size of 256, 512, or 1024 bits");
        }
    }

    /* renamed from: a */
    public void mo5742a(boolean z, CipherParameters cipherParameters) {
        byte[] a;
        byte[] b;
        long[] jArr;
        long[] jArr2 = null;
        if (cipherParameters instanceof TweakableBlockCipherParameters) {
            TweakableBlockCipherParameters tweakableBlockCipherParameters = (TweakableBlockCipherParameters) cipherParameters;
            a = tweakableBlockCipherParameters.m35711a().m35685a();
            b = tweakableBlockCipherParameters.m35712b();
        } else if (cipherParameters instanceof KeyParameter) {
            a = ((KeyParameter) cipherParameters).m35685a();
            b = null;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid parameter passed to Threefish init - ");
            stringBuilder.append(cipherParameters.getClass().getName());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (a == null) {
            jArr = null;
        } else if (a.length == this.f26804e) {
            jArr = new long[this.f26805f];
            for (int i = 0; i < jArr.length; i++) {
                jArr[i] = m35262a(a, i * 8);
            }
        } else {
            cipherParameters = new StringBuilder();
            cipherParameters.append("Threefish key must be same size as block (");
            cipherParameters.append(this.f26804e);
            cipherParameters.append(" bytes)");
            throw new IllegalArgumentException(cipherParameters.toString());
        }
        if (b != null) {
            if (b.length == 16) {
                jArr2 = new long[]{m35262a(b, 0), m35262a(b, 8)};
            } else {
                throw new IllegalArgumentException("Threefish tweak must be 16 bytes");
            }
        }
        m35275a(z, jArr, jArr2);
    }

    /* renamed from: a */
    public void m35275a(boolean z, long[] jArr, long[] jArr2) {
        this.f26810k = z;
        if (jArr != null) {
            m35264a(jArr);
        }
        if (jArr2 != null) {
            m35266b(jArr2);
        }
    }

    /* renamed from: a */
    private void m35264a(long[] jArr) {
        if (jArr.length == this.f26805f) {
            long j = 2004413935125273122L;
            for (int i = 0; i < this.f26805f; i++) {
                this.f26808i[i] = jArr[i];
                j ^= this.f26808i[i];
            }
            this.f26808i[this.f26805f] = j;
            System.arraycopy(this.f26808i, 0, this.f26808i, this.f26805f + 1, this.f26805f);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Threefish key must be same size as block (");
        stringBuilder.append(this.f26805f);
        stringBuilder.append(" words)");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: b */
    private void m35266b(long[] jArr) {
        if (jArr.length == 2) {
            this.f26807h[0] = jArr[0];
            this.f26807h[1] = jArr[1];
            this.f26807h[2] = this.f26807h[0] ^ this.f26807h[1];
            this.f26807h[3] = this.f26807h[0];
            this.f26807h[4] = this.f26807h[1];
            return;
        }
        throw new IllegalArgumentException("Tweak must be 2 words.");
    }

    /* renamed from: a */
    public String mo5741a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Threefish-");
        stringBuilder.append(this.f26804e * 8);
        return stringBuilder.toString();
    }

    /* renamed from: b */
    public int mo5743b() {
        return this.f26804e;
    }

    /* renamed from: a */
    public int mo5740a(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.f26804e + i2 > bArr2.length) {
            throw new DataLengthException("Output buffer too short");
        } else if (this.f26804e + i <= bArr.length) {
            for (int i3 = 0; i3 < this.f26804e; i3 += 8) {
                this.f26806g[i3 >> 3] = m35262a(bArr, i + i3);
            }
            m35272a(this.f26806g, this.f26806g);
            for (int i4 = 0; i4 < this.f26804e; i4 += 8) {
                m35263a(this.f26806g[i4 >> 3], bArr2, i2 + i4);
            }
            return this.f26804e;
        } else {
            throw new DataLengthException("Input buffer too short");
        }
    }

    /* renamed from: a */
    public int m35272a(long[] jArr, long[] jArr2) {
        if (this.f26808i[this.f26805f] == 0) {
            throw new IllegalStateException("Threefish engine not initialised");
        } else if (jArr.length != this.f26805f) {
            throw new DataLengthException("Input buffer too short");
        } else if (jArr2.length == this.f26805f) {
            if (this.f26810k) {
                this.f26809j.mo5753a(jArr, jArr2);
            } else {
                this.f26809j.mo5754b(jArr, jArr2);
            }
            return this.f26805f;
        } else {
            throw new DataLengthException("Output buffer too short");
        }
    }

    /* renamed from: a */
    public static long m35262a(byte[] bArr, int i) {
        if (i + 8 <= bArr.length) {
            int i2 = i + 1;
            i = i2 + 1;
            int i3 = i + 1;
            i = i3 + 1;
            i3 = i + 1;
            i = i3 + 1;
            return ((((long) bArr[i + 1]) & 255) << 56) | (((((((((long) bArr[i]) & 255) | ((((long) bArr[i2]) & 255) << 8)) | ((((long) bArr[i]) & 255) << 16)) | ((((long) bArr[i3]) & 255) << 24)) | ((((long) bArr[i]) & 255) << 32)) | ((((long) bArr[i3]) & 255) << 40)) | ((((long) bArr[i]) & 255) << 48));
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: a */
    public static void m35263a(long j, byte[] bArr, int i) {
        if (i + 8 <= bArr.length) {
            int i2 = i + 1;
            bArr[i] = (byte) ((int) j);
            i = i2 + 1;
            bArr[i2] = (byte) ((int) (j >> 8));
            i2 = i + 1;
            bArr[i] = (byte) ((int) (j >> 16));
            i = i2 + 1;
            bArr[i2] = (byte) ((int) (j >> 24));
            i2 = i + 1;
            bArr[i] = (byte) ((int) (j >> 32));
            i = i2 + 1;
            bArr[i2] = (byte) ((int) (j >> 40));
            i2 = i + 1;
            bArr[i] = (byte) ((int) (j >> 48));
            bArr[i2] = (byte) ((int) (j >> 56));
            return;
        }
        throw new IllegalArgumentException();
    }
}
