package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.params.DHParameters;

public class DHParametersGenerator {
    /* renamed from: d */
    private static final BigInteger f22353d = BigInteger.valueOf(2);
    /* renamed from: a */
    private int f22354a;
    /* renamed from: b */
    private int f22355b;
    /* renamed from: c */
    private SecureRandom f22356c;

    /* renamed from: a */
    public void m27436a(int i, int i2, SecureRandom secureRandom) {
        this.f22354a = i;
        this.f22355b = i2;
        this.f22356c = secureRandom;
    }

    /* renamed from: a */
    public DHParameters m27435a() {
        BigInteger[] a = DHParametersHelper.m27438a(this.f22354a, this.f22355b, this.f22356c);
        BigInteger bigInteger = a[0];
        BigInteger bigInteger2 = a[1];
        return new DHParameters(bigInteger, DHParametersHelper.m27437a(bigInteger, bigInteger2, this.f22356c), bigInteger2, f22353d, null);
    }
}
