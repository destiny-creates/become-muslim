package org.spongycastle.pqc.crypto.mceliece;

import java.math.BigInteger;
import org.spongycastle.pqc.math.linearalgebra.BigIntUtils;
import org.spongycastle.pqc.math.linearalgebra.GF2Vector;
import org.spongycastle.pqc.math.linearalgebra.IntegerFunctions;

final class Conversions {
    /* renamed from: a */
    private static final BigInteger f23254a = BigInteger.valueOf(0);
    /* renamed from: b */
    private static final BigInteger f23255b = BigInteger.valueOf(1);

    private Conversions() {
    }

    /* renamed from: a */
    public static GF2Vector m29088a(int i, int i2, byte[] bArr) {
        if (i >= i2) {
            BigInteger a = IntegerFunctions.m29236a(i, i2);
            BigInteger bigInteger = new BigInteger(1, bArr);
            if (bigInteger.compareTo(a) < null) {
                bArr = new GF2Vector(i);
                BigInteger bigInteger2 = bigInteger;
                int i3 = i2;
                i2 = i;
                for (int i4 = 0; i4 < i; i4++) {
                    a = a.multiply(BigInteger.valueOf((long) (i2 - i3))).divide(BigInteger.valueOf((long) i2));
                    i2--;
                    if (a.compareTo(bigInteger2) <= 0) {
                        bArr.m36522a(i4);
                        bigInteger2 = bigInteger2.subtract(a);
                        i3--;
                        if (i2 == i3) {
                            a = f23255b;
                        } else {
                            a = a.multiply(BigInteger.valueOf((long) (i3 + 1))).divide(BigInteger.valueOf((long) (i2 - i3)));
                        }
                    }
                }
                return bArr;
            }
            throw new IllegalArgumentException("Encoded number too large.");
        }
        throw new IllegalArgumentException("n < t");
    }

    /* renamed from: a */
    public static byte[] m29089a(int i, int i2, GF2Vector gF2Vector) {
        if (gF2Vector.m29294e() == i && gF2Vector.m36526c() == i2) {
            gF2Vector = gF2Vector.m36525b();
            BigInteger a = IntegerFunctions.m29236a(i, i2);
            BigInteger bigInteger = f23254a;
            int i3 = i2;
            i2 = i;
            for (int i4 = 0; i4 < i; i4++) {
                a = a.multiply(BigInteger.valueOf((long) (i2 - i3))).divide(BigInteger.valueOf((long) i2));
                i2--;
                if ((gF2Vector[i4 >> 5] & (1 << (i4 & 31))) != 0) {
                    bigInteger = bigInteger.add(a);
                    i3--;
                    if (i2 == i3) {
                        a = f23255b;
                    } else {
                        a = a.multiply(BigInteger.valueOf((long) (i3 + 1))).divide(BigInteger.valueOf((long) (i2 - i3)));
                    }
                }
            }
            return BigIntUtils.m29181a(bigInteger);
        }
        throw new IllegalArgumentException("vector has wrong length or hamming weight");
    }
}
