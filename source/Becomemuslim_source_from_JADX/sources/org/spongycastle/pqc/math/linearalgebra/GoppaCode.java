package org.spongycastle.pqc.math.linearalgebra;

import java.lang.reflect.Array;

public final class GoppaCode {

    public static class MaMaPe {
        /* renamed from: a */
        private GF2Matrix f23378a;
        /* renamed from: b */
        private GF2Matrix f23379b;
        /* renamed from: c */
        private Permutation f23380c;

        public MaMaPe(GF2Matrix gF2Matrix, GF2Matrix gF2Matrix2, Permutation permutation) {
            this.f23378a = gF2Matrix;
            this.f23379b = gF2Matrix2;
            this.f23380c = permutation;
        }

        /* renamed from: a */
        public GF2Matrix m29228a() {
            return this.f23379b;
        }

        /* renamed from: b */
        public Permutation m29229b() {
            return this.f23380c;
        }
    }

    public static class MatrixSet {
    }

    private GoppaCode() {
    }

    /* renamed from: a */
    public static GF2Matrix m29230a(GF2mField gF2mField, PolynomialGF2mSmallM polynomialGF2mSmallM) {
        int i;
        int i2;
        int a = gF2mField.m29212a();
        int i3 = 1 << a;
        int a2 = polynomialGF2mSmallM.m29266a();
        int[][] iArr = (int[][]) Array.newInstance(int.class, new int[]{a2, i3});
        int[][] iArr2 = (int[][]) Array.newInstance(int.class, new int[]{a2, i3});
        for (i = 0; i < i3; i++) {
            iArr2[0][i] = gF2mField.m29213a(polynomialGF2mSmallM.m29271b(i));
        }
        for (i = 1; i < a2; i++) {
            for (i2 = 0; i2 < i3; i2++) {
                iArr2[i][i2] = gF2mField.m29217b(iArr2[i - 1][i2], i2);
            }
        }
        for (i = 0; i < a2; i++) {
            for (i2 = 0; i2 < i3; i2++) {
                int i4;
                for (i4 = 0; i4 <= i; i4++) {
                    iArr[i][i2] = gF2mField.m29214a(iArr[i][i2], gF2mField.m29217b(iArr2[i4][i2], polynomialGF2mSmallM.m29267a((a2 + i4) - i)));
                }
            }
        }
        int[][] iArr3 = (int[][]) Array.newInstance(int.class, new int[]{a2 * a, (i3 + 31) >>> 5});
        for (polynomialGF2mSmallM = null; polynomialGF2mSmallM < i3; polynomialGF2mSmallM++) {
            int i5 = polynomialGF2mSmallM >>> 5;
            i = 1 << (polynomialGF2mSmallM & 31);
            for (i2 = 0; i2 < a2; i2++) {
                i4 = iArr[i2][polynomialGF2mSmallM];
                for (int i6 = 0; i6 < a; i6++) {
                    if (((i4 >>> i6) & 1) != 0) {
                        int[] iArr4 = iArr3[(((i2 + 1) * a) - i6) - 1];
                        iArr4[i5] = iArr4[i5] ^ i;
                    }
                }
            }
        }
        return new GF2Matrix(i3, iArr3);
    }

    /* renamed from: a */
    public static org.spongycastle.pqc.math.linearalgebra.GoppaCode.MaMaPe m29232a(org.spongycastle.pqc.math.linearalgebra.GF2Matrix r7, java.security.SecureRandom r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r7.m29245h();
        r1 = 0;
    L_0x0005:
        r2 = new org.spongycastle.pqc.math.linearalgebra.Permutation;
        r2.<init>(r0, r8);
        r3 = r7.m36508a(r2);
        r3 = (org.spongycastle.pqc.math.linearalgebra.GF2Matrix) r3;
        r4 = r3.m36511b();
        r5 = 1;
        r6 = r4.m36517f();	 Catch:{ ArithmeticException -> 0x001d }
        r6 = (org.spongycastle.pqc.math.linearalgebra.GF2Matrix) r6;	 Catch:{ ArithmeticException -> 0x001d }
        r1 = r6;
        goto L_0x001e;
    L_0x001d:
        r5 = 0;
    L_0x001e:
        if (r5 == 0) goto L_0x0005;
    L_0x0020:
        r7 = r1.m36507a(r3);
        r7 = (org.spongycastle.pqc.math.linearalgebra.GF2Matrix) r7;
        r7 = r7.m36515d();
        r8 = new org.spongycastle.pqc.math.linearalgebra.GoppaCode$MaMaPe;
        r8.<init>(r4, r7, r2);
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.pqc.math.linearalgebra.GoppaCode.a(org.spongycastle.pqc.math.linearalgebra.GF2Matrix, java.security.SecureRandom):org.spongycastle.pqc.math.linearalgebra.GoppaCode$MaMaPe");
    }

    /* renamed from: a */
    public static GF2Vector m29231a(GF2Vector gF2Vector, GF2mField gF2mField, PolynomialGF2mSmallM polynomialGF2mSmallM, PolynomialGF2mSmallM[] polynomialGF2mSmallMArr) {
        int a = 1 << gF2mField.m29212a();
        GF2Vector gF2Vector2 = new GF2Vector(a);
        if (!gF2Vector.m36527d()) {
            gF2Vector = new PolynomialGF2mSmallM(gF2Vector.m36519a(gF2mField)).m29278e(polynomialGF2mSmallM).m29273c(1).m29269a(polynomialGF2mSmallMArr).m29281f(polynomialGF2mSmallM);
            int i = null;
            gF2Vector = gF2Vector[0].m29274c(gF2Vector[0]).m29268a(gF2Vector[1].m29274c(gF2Vector[1]).m29280f(1));
            gF2Vector = gF2Vector.m29276d(gF2mField.m29213a(gF2Vector.m29270b()));
            while (i < a) {
                if (gF2Vector.m29271b(i) == null) {
                    gF2Vector2.m36522a(i);
                }
                i++;
            }
        }
        return gF2Vector2;
    }
}
