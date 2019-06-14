package org.spongycastle.pqc.crypto.rainbow.util;

import java.lang.reflect.Array;

public class ComputeInField {
    /* renamed from: a */
    short[] f23323a;
    /* renamed from: b */
    private short[][] f23324b;

    /* renamed from: a */
    public short[] m29119a(short[][] r7, short[] r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = r7.length;	 Catch:{ RuntimeException -> 0x0062 }
        r1 = r8.length;	 Catch:{ RuntimeException -> 0x0062 }
        if (r0 != r1) goto L_0x005a;	 Catch:{ RuntimeException -> 0x0062 }
    L_0x0004:
        r0 = r7.length;	 Catch:{ RuntimeException -> 0x0062 }
        r1 = r7.length;	 Catch:{ RuntimeException -> 0x0062 }
        r1 = r1 + 1;	 Catch:{ RuntimeException -> 0x0062 }
        r0 = new int[]{r0, r1};	 Catch:{ RuntimeException -> 0x0062 }
        r1 = short.class;	 Catch:{ RuntimeException -> 0x0062 }
        r0 = java.lang.reflect.Array.newInstance(r1, r0);	 Catch:{ RuntimeException -> 0x0062 }
        r0 = (short[][]) r0;	 Catch:{ RuntimeException -> 0x0062 }
        r6.f23324b = r0;	 Catch:{ RuntimeException -> 0x0062 }
        r0 = r7.length;	 Catch:{ RuntimeException -> 0x0062 }
        r0 = new short[r0];	 Catch:{ RuntimeException -> 0x0062 }
        r6.f23323a = r0;	 Catch:{ RuntimeException -> 0x0062 }
        r0 = 0;	 Catch:{ RuntimeException -> 0x0062 }
        r1 = 0;	 Catch:{ RuntimeException -> 0x0062 }
    L_0x001d:
        r2 = r7.length;	 Catch:{ RuntimeException -> 0x0062 }
        if (r1 >= r2) goto L_0x0036;	 Catch:{ RuntimeException -> 0x0062 }
    L_0x0020:
        r2 = 0;	 Catch:{ RuntimeException -> 0x0062 }
    L_0x0021:
        r3 = r7[r0];	 Catch:{ RuntimeException -> 0x0062 }
        r3 = r3.length;	 Catch:{ RuntimeException -> 0x0062 }
        if (r2 >= r3) goto L_0x0033;	 Catch:{ RuntimeException -> 0x0062 }
    L_0x0026:
        r3 = r6.f23324b;	 Catch:{ RuntimeException -> 0x0062 }
        r3 = r3[r1];	 Catch:{ RuntimeException -> 0x0062 }
        r4 = r7[r1];	 Catch:{ RuntimeException -> 0x0062 }
        r4 = r4[r2];	 Catch:{ RuntimeException -> 0x0062 }
        r3[r2] = r4;	 Catch:{ RuntimeException -> 0x0062 }
        r2 = r2 + 1;	 Catch:{ RuntimeException -> 0x0062 }
        goto L_0x0021;	 Catch:{ RuntimeException -> 0x0062 }
    L_0x0033:
        r1 = r1 + 1;	 Catch:{ RuntimeException -> 0x0062 }
        goto L_0x001d;	 Catch:{ RuntimeException -> 0x0062 }
    L_0x0036:
        r7 = 0;	 Catch:{ RuntimeException -> 0x0062 }
    L_0x0037:
        r1 = r8.length;	 Catch:{ RuntimeException -> 0x0062 }
        if (r7 >= r1) goto L_0x0051;	 Catch:{ RuntimeException -> 0x0062 }
    L_0x003a:
        r1 = r6.f23324b;	 Catch:{ RuntimeException -> 0x0062 }
        r1 = r1[r7];	 Catch:{ RuntimeException -> 0x0062 }
        r2 = r8.length;	 Catch:{ RuntimeException -> 0x0062 }
        r3 = r8[r7];	 Catch:{ RuntimeException -> 0x0062 }
        r4 = r6.f23324b;	 Catch:{ RuntimeException -> 0x0062 }
        r4 = r4[r7];	 Catch:{ RuntimeException -> 0x0062 }
        r5 = r8.length;	 Catch:{ RuntimeException -> 0x0062 }
        r4 = r4[r5];	 Catch:{ RuntimeException -> 0x0062 }
        r3 = org.spongycastle.pqc.crypto.rainbow.util.GF2Field.m29126a(r3, r4);	 Catch:{ RuntimeException -> 0x0062 }
        r1[r2] = r3;	 Catch:{ RuntimeException -> 0x0062 }
        r7 = r7 + 1;	 Catch:{ RuntimeException -> 0x0062 }
        goto L_0x0037;	 Catch:{ RuntimeException -> 0x0062 }
    L_0x0051:
        r6.m29115a(r0);	 Catch:{ RuntimeException -> 0x0062 }
        r6.m29116b();	 Catch:{ RuntimeException -> 0x0062 }
        r7 = r6.f23323a;	 Catch:{ RuntimeException -> 0x0062 }
        return r7;	 Catch:{ RuntimeException -> 0x0062 }
    L_0x005a:
        r7 = new java.lang.RuntimeException;	 Catch:{ RuntimeException -> 0x0062 }
        r8 = "The equation system is not solvable";	 Catch:{ RuntimeException -> 0x0062 }
        r7.<init>(r8);	 Catch:{ RuntimeException -> 0x0062 }
        throw r7;	 Catch:{ RuntimeException -> 0x0062 }
    L_0x0062:
        r7 = 0;
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.pqc.crypto.rainbow.util.ComputeInField.a(short[][], short[]):short[]");
    }

    /* renamed from: a */
    public short[][] m29121a(short[][] r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = r7.length;	 Catch:{ RuntimeException -> 0x00be }
        r1 = r7.length;	 Catch:{ RuntimeException -> 0x00be }
        r1 = r1 * 2;	 Catch:{ RuntimeException -> 0x00be }
        r0 = new int[]{r0, r1};	 Catch:{ RuntimeException -> 0x00be }
        r1 = short.class;	 Catch:{ RuntimeException -> 0x00be }
        r0 = java.lang.reflect.Array.newInstance(r1, r0);	 Catch:{ RuntimeException -> 0x00be }
        r0 = (short[][]) r0;	 Catch:{ RuntimeException -> 0x00be }
        r6.f23324b = r0;	 Catch:{ RuntimeException -> 0x00be }
        r0 = r7.length;	 Catch:{ RuntimeException -> 0x00be }
        r1 = 0;	 Catch:{ RuntimeException -> 0x00be }
        r2 = r7[r1];	 Catch:{ RuntimeException -> 0x00be }
        r2 = r2.length;	 Catch:{ RuntimeException -> 0x00be }
        if (r0 != r2) goto L_0x00b6;	 Catch:{ RuntimeException -> 0x00be }
    L_0x0019:
        r0 = 0;	 Catch:{ RuntimeException -> 0x00be }
    L_0x001a:
        r2 = r7.length;	 Catch:{ RuntimeException -> 0x00be }
        r3 = 1;	 Catch:{ RuntimeException -> 0x00be }
        if (r0 >= r2) goto L_0x004b;	 Catch:{ RuntimeException -> 0x00be }
    L_0x001e:
        r2 = 0;	 Catch:{ RuntimeException -> 0x00be }
    L_0x001f:
        r4 = r7.length;	 Catch:{ RuntimeException -> 0x00be }
        if (r2 >= r4) goto L_0x002f;	 Catch:{ RuntimeException -> 0x00be }
    L_0x0022:
        r4 = r6.f23324b;	 Catch:{ RuntimeException -> 0x00be }
        r4 = r4[r0];	 Catch:{ RuntimeException -> 0x00be }
        r5 = r7[r0];	 Catch:{ RuntimeException -> 0x00be }
        r5 = r5[r2];	 Catch:{ RuntimeException -> 0x00be }
        r4[r2] = r5;	 Catch:{ RuntimeException -> 0x00be }
        r2 = r2 + 1;	 Catch:{ RuntimeException -> 0x00be }
        goto L_0x001f;	 Catch:{ RuntimeException -> 0x00be }
    L_0x002f:
        r2 = r7.length;	 Catch:{ RuntimeException -> 0x00be }
    L_0x0030:
        r4 = r7.length;	 Catch:{ RuntimeException -> 0x00be }
        r4 = r4 * 2;	 Catch:{ RuntimeException -> 0x00be }
        if (r2 >= r4) goto L_0x003e;	 Catch:{ RuntimeException -> 0x00be }
    L_0x0035:
        r4 = r6.f23324b;	 Catch:{ RuntimeException -> 0x00be }
        r4 = r4[r0];	 Catch:{ RuntimeException -> 0x00be }
        r4[r2] = r1;	 Catch:{ RuntimeException -> 0x00be }
        r2 = r2 + 1;	 Catch:{ RuntimeException -> 0x00be }
        goto L_0x0030;	 Catch:{ RuntimeException -> 0x00be }
    L_0x003e:
        r2 = r6.f23324b;	 Catch:{ RuntimeException -> 0x00be }
        r2 = r2[r0];	 Catch:{ RuntimeException -> 0x00be }
        r4 = r6.f23324b;	 Catch:{ RuntimeException -> 0x00be }
        r4 = r4.length;	 Catch:{ RuntimeException -> 0x00be }
        r4 = r4 + r0;	 Catch:{ RuntimeException -> 0x00be }
        r2[r4] = r3;	 Catch:{ RuntimeException -> 0x00be }
        r0 = r0 + 1;	 Catch:{ RuntimeException -> 0x00be }
        goto L_0x001a;	 Catch:{ RuntimeException -> 0x00be }
    L_0x004b:
        r6.m29115a(r3);	 Catch:{ RuntimeException -> 0x00be }
        r7 = 0;	 Catch:{ RuntimeException -> 0x00be }
    L_0x004f:
        r0 = r6.f23324b;	 Catch:{ RuntimeException -> 0x00be }
        r0 = r0.length;	 Catch:{ RuntimeException -> 0x00be }
        if (r7 >= r0) goto L_0x007c;	 Catch:{ RuntimeException -> 0x00be }
    L_0x0054:
        r0 = r6.f23324b;	 Catch:{ RuntimeException -> 0x00be }
        r0 = r0[r7];	 Catch:{ RuntimeException -> 0x00be }
        r0 = r0[r7];	 Catch:{ RuntimeException -> 0x00be }
        r0 = org.spongycastle.pqc.crypto.rainbow.util.GF2Field.m29125a(r0);	 Catch:{ RuntimeException -> 0x00be }
        r2 = r7;	 Catch:{ RuntimeException -> 0x00be }
    L_0x005f:
        r3 = r6.f23324b;	 Catch:{ RuntimeException -> 0x00be }
        r3 = r3.length;	 Catch:{ RuntimeException -> 0x00be }
        r3 = r3 * 2;	 Catch:{ RuntimeException -> 0x00be }
        if (r2 >= r3) goto L_0x0079;	 Catch:{ RuntimeException -> 0x00be }
    L_0x0066:
        r3 = r6.f23324b;	 Catch:{ RuntimeException -> 0x00be }
        r3 = r3[r7];	 Catch:{ RuntimeException -> 0x00be }
        r4 = r6.f23324b;	 Catch:{ RuntimeException -> 0x00be }
        r4 = r4[r7];	 Catch:{ RuntimeException -> 0x00be }
        r4 = r4[r2];	 Catch:{ RuntimeException -> 0x00be }
        r4 = org.spongycastle.pqc.crypto.rainbow.util.GF2Field.m29127b(r4, r0);	 Catch:{ RuntimeException -> 0x00be }
        r3[r2] = r4;	 Catch:{ RuntimeException -> 0x00be }
        r2 = r2 + 1;	 Catch:{ RuntimeException -> 0x00be }
        goto L_0x005f;	 Catch:{ RuntimeException -> 0x00be }
    L_0x0079:
        r7 = r7 + 1;	 Catch:{ RuntimeException -> 0x00be }
        goto L_0x004f;	 Catch:{ RuntimeException -> 0x00be }
    L_0x007c:
        r6.m29114a();	 Catch:{ RuntimeException -> 0x00be }
        r7 = r6.f23324b;	 Catch:{ RuntimeException -> 0x00be }
        r7 = r7.length;	 Catch:{ RuntimeException -> 0x00be }
        r0 = r6.f23324b;	 Catch:{ RuntimeException -> 0x00be }
        r0 = r0.length;	 Catch:{ RuntimeException -> 0x00be }
        r7 = new int[]{r7, r0};	 Catch:{ RuntimeException -> 0x00be }
        r0 = short.class;	 Catch:{ RuntimeException -> 0x00be }
        r7 = java.lang.reflect.Array.newInstance(r0, r7);	 Catch:{ RuntimeException -> 0x00be }
        r7 = (short[][]) r7;	 Catch:{ RuntimeException -> 0x00be }
    L_0x0091:
        r0 = r6.f23324b;	 Catch:{ RuntimeException -> 0x00be }
        r0 = r0.length;	 Catch:{ RuntimeException -> 0x00be }
        if (r1 >= r0) goto L_0x00b5;	 Catch:{ RuntimeException -> 0x00be }
    L_0x0096:
        r0 = r6.f23324b;	 Catch:{ RuntimeException -> 0x00be }
        r0 = r0.length;	 Catch:{ RuntimeException -> 0x00be }
    L_0x0099:
        r2 = r6.f23324b;	 Catch:{ RuntimeException -> 0x00be }
        r2 = r2.length;	 Catch:{ RuntimeException -> 0x00be }
        r2 = r2 * 2;	 Catch:{ RuntimeException -> 0x00be }
        if (r0 >= r2) goto L_0x00b2;	 Catch:{ RuntimeException -> 0x00be }
    L_0x00a0:
        r2 = r7[r1];	 Catch:{ RuntimeException -> 0x00be }
        r3 = r6.f23324b;	 Catch:{ RuntimeException -> 0x00be }
        r3 = r3.length;	 Catch:{ RuntimeException -> 0x00be }
        r3 = r0 - r3;	 Catch:{ RuntimeException -> 0x00be }
        r4 = r6.f23324b;	 Catch:{ RuntimeException -> 0x00be }
        r4 = r4[r1];	 Catch:{ RuntimeException -> 0x00be }
        r4 = r4[r0];	 Catch:{ RuntimeException -> 0x00be }
        r2[r3] = r4;	 Catch:{ RuntimeException -> 0x00be }
        r0 = r0 + 1;	 Catch:{ RuntimeException -> 0x00be }
        goto L_0x0099;	 Catch:{ RuntimeException -> 0x00be }
    L_0x00b2:
        r1 = r1 + 1;	 Catch:{ RuntimeException -> 0x00be }
        goto L_0x0091;	 Catch:{ RuntimeException -> 0x00be }
    L_0x00b5:
        return r7;	 Catch:{ RuntimeException -> 0x00be }
    L_0x00b6:
        r7 = new java.lang.RuntimeException;	 Catch:{ RuntimeException -> 0x00be }
        r0 = "The matrix is not invertible. Please choose another one!";	 Catch:{ RuntimeException -> 0x00be }
        r7.<init>(r0);	 Catch:{ RuntimeException -> 0x00be }
        throw r7;	 Catch:{ RuntimeException -> 0x00be }
    L_0x00be:
        r7 = 0;
        r7 = (short[][]) r7;
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.pqc.crypto.rainbow.util.ComputeInField.a(short[][]):short[][]");
    }

    /* renamed from: a */
    private void m29115a(boolean z) {
        if (z) {
            z = this.f23324b.length * 2;
        } else {
            z = this.f23324b.length + 1;
        }
        boolean z2 = false;
        while (z2 < this.f23324b.length - 1) {
            boolean z3 = z2 + 1;
            int i = z3;
            while (i < this.f23324b.length) {
                short s = this.f23324b[i][z2];
                short a = GF2Field.m29125a(this.f23324b[z2][z2]);
                if (a != (short) 0) {
                    for (boolean z4 = z2; z4 < z; z4++) {
                        this.f23324b[i][z4] = GF2Field.m29126a(this.f23324b[i][z4], GF2Field.m29127b(s, GF2Field.m29127b(this.f23324b[z2][z4], a)));
                    }
                    i++;
                } else {
                    throw new RuntimeException("Matrix not invertible! We have to choose another one!");
                }
            }
            z2 = z3;
        }
    }

    /* renamed from: a */
    private void m29114a() {
        for (int length = this.f23324b.length - 1; length > 0; length--) {
            int i = length - 1;
            while (i >= 0) {
                short s = this.f23324b[i][length];
                short a = GF2Field.m29125a(this.f23324b[length][length]);
                if (a != (short) 0) {
                    for (int i2 = length; i2 < this.f23324b.length * 2; i2++) {
                        this.f23324b[i][i2] = GF2Field.m29126a(this.f23324b[i][i2], GF2Field.m29127b(s, GF2Field.m29127b(this.f23324b[length][i2], a)));
                    }
                    i--;
                } else {
                    throw new RuntimeException("The matrix is not invertible");
                }
            }
        }
    }

    /* renamed from: b */
    private void m29116b() {
        short a = GF2Field.m29125a(this.f23324b[this.f23324b.length - 1][this.f23324b.length - 1]);
        if (a != (short) 0) {
            this.f23323a[this.f23324b.length - 1] = GF2Field.m29127b(this.f23324b[this.f23324b.length - 1][this.f23324b.length], a);
            int length = this.f23324b.length - 2;
            while (length >= 0) {
                short s = this.f23324b[length][this.f23324b.length];
                for (int length2 = this.f23324b.length - 1; length2 > length; length2--) {
                    s = GF2Field.m29126a(s, GF2Field.m29127b(this.f23324b[length][length2], this.f23323a[length2]));
                }
                short a2 = GF2Field.m29125a(this.f23324b[length][length]);
                if (a2 != (short) 0) {
                    this.f23323a[length] = GF2Field.m29127b(s, a2);
                    length--;
                } else {
                    throw new RuntimeException("Not solvable equation system");
                }
            }
            return;
        }
        throw new RuntimeException("The equation system is not solvable");
    }

    /* renamed from: b */
    public short[] m29123b(short[][] sArr, short[] sArr2) {
        if (sArr[0].length == sArr2.length) {
            short[] sArr3 = new short[sArr.length];
            for (int i = 0; i < sArr.length; i++) {
                for (int i2 = 0; i2 < sArr2.length; i2++) {
                    sArr3[i] = GF2Field.m29126a(sArr3[i], GF2Field.m29127b(sArr[i][i2], sArr2[i2]));
                }
            }
            return sArr3;
        }
        throw new RuntimeException("Multiplication is not possible!");
    }

    /* renamed from: a */
    public short[] m29118a(short[] sArr, short[] sArr2) {
        if (sArr.length == sArr2.length) {
            short[] sArr3 = new short[sArr.length];
            for (int i = 0; i < sArr3.length; i++) {
                sArr3[i] = GF2Field.m29126a(sArr[i], sArr2[i]);
            }
            return sArr3;
        }
        throw new RuntimeException("Multiplication is not possible!");
    }

    /* renamed from: b */
    public short[][] m29124b(short[] sArr, short[] sArr2) {
        if (sArr.length == sArr2.length) {
            short[][] sArr3 = (short[][]) Array.newInstance(short.class, new int[]{sArr.length, sArr2.length});
            for (int i = 0; i < sArr.length; i++) {
                for (int i2 = 0; i2 < sArr2.length; i2++) {
                    sArr3[i][i2] = GF2Field.m29127b(sArr[i], sArr2[i2]);
                }
            }
            return sArr3;
        }
        throw new RuntimeException("Multiplication is not possible!");
    }

    /* renamed from: a */
    public short[] m29117a(short s, short[] sArr) {
        short[] sArr2 = new short[sArr.length];
        for (int i = 0; i < sArr2.length; i++) {
            sArr2[i] = GF2Field.m29127b(s, sArr[i]);
        }
        return sArr2;
    }

    /* renamed from: a */
    public short[][] m29120a(short s, short[][] sArr) {
        short[][] sArr2 = (short[][]) Array.newInstance(short.class, new int[]{sArr.length, sArr[0].length});
        for (int i = 0; i < sArr.length; i++) {
            for (int i2 = 0; i2 < sArr[0].length; i2++) {
                sArr2[i][i2] = GF2Field.m29127b(s, sArr[i][i2]);
            }
        }
        return sArr2;
    }

    /* renamed from: a */
    public short[][] m29122a(short[][] sArr, short[][] sArr2) {
        if (sArr.length == sArr2.length && sArr[0].length == sArr2[0].length) {
            short[][] sArr3 = (short[][]) Array.newInstance(short.class, new int[]{sArr.length, sArr.length});
            for (int i = 0; i < sArr.length; i++) {
                for (int i2 = 0; i2 < sArr2.length; i2++) {
                    sArr3[i][i2] = GF2Field.m29126a(sArr[i][i2], sArr2[i][i2]);
                }
            }
            return sArr3;
        }
        throw new RuntimeException("Addition is not possible!");
    }
}
