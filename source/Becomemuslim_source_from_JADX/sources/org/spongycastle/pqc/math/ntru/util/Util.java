package org.spongycastle.pqc.math.ntru.util;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.spongycastle.pqc.math.ntru.euclid.IntEuclidean;
import org.spongycastle.pqc.math.ntru.polynomial.DenseTernaryPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.SparseTernaryPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.TernaryPolynomial;
import org.spongycastle.util.Integers;

public class Util {
    /* renamed from: a */
    private static volatile boolean f23428a;
    /* renamed from: b */
    private static volatile boolean f23429b;

    /* renamed from: a */
    public static int m29336a(int i, int i2) {
        i %= i2;
        if (i < 0) {
            i += i2;
        }
        return IntEuclidean.m29296a(i, i2).f23402a;
    }

    /* renamed from: a */
    public static int m29337a(int i, int i2, int i3) {
        int i4 = 1;
        for (int i5 = 0; i5 < i2; i5++) {
            i4 = (i4 * i) % i3;
        }
        return i4;
    }

    /* renamed from: a */
    public static TernaryPolynomial m29338a(int i, int i2, int i3, boolean z, SecureRandom secureRandom) {
        if (z) {
            return SparseTernaryPolynomial.m42140a(i, i2, i3, secureRandom);
        }
        return DenseTernaryPolynomial.m42134a(i, i2, i3, secureRandom);
    }

    /* renamed from: a */
    public static int[] m29340a(int i, int i2, int i3, SecureRandom secureRandom) {
        Integer a = Integers.m29396a(1);
        Integer a2 = Integers.m29396a(-1);
        int i4 = 0;
        Integer a3 = Integers.m29396a(0);
        List arrayList = new ArrayList();
        for (int i5 = 0; i5 < i2; i5++) {
            arrayList.add(a);
        }
        for (i2 = 0; i2 < i3; i2++) {
            arrayList.add(a2);
        }
        while (arrayList.size() < i) {
            arrayList.add(a3);
        }
        Collections.shuffle(arrayList, secureRandom);
        i2 = new int[i];
        while (i4 < i) {
            i2[i4] = ((Integer) arrayList.get(i4)).intValue();
            i4++;
        }
        return i2;
    }

    /* renamed from: a */
    public static boolean m29339a() {
        if (!f23428a) {
            boolean z;
            String property = System.getProperty("os.arch");
            String property2 = System.getProperty("sun.arch.data.model");
            if (!("amd64".equals(property) || "x86_64".equals(property) || "ppc64".equals(property))) {
                if (!"64".equals(property2)) {
                    z = false;
                    f23429b = z;
                    f23428a = true;
                }
            }
            z = true;
            f23429b = z;
            f23428a = true;
        }
        return f23429b;
    }
}
