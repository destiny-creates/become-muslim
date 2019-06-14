package org.spongycastle.crypto.agreement.jpake;

import java.math.BigInteger;

public class JPAKEPrimeOrderGroup {
    /* renamed from: a */
    private final BigInteger f22222a;
    /* renamed from: b */
    private final BigInteger f22223b;
    /* renamed from: c */
    private final BigInteger f22224c;

    JPAKEPrimeOrderGroup(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, boolean z) {
        JPAKEUtil.m27361a(bigInteger, "p");
        JPAKEUtil.m27361a(bigInteger2, "q");
        JPAKEUtil.m27361a(bigInteger3, "g");
        if (!z) {
            if (!bigInteger.subtract(JPAKEUtil.f22229b).mod(bigInteger2).equals(JPAKEUtil.f22228a)) {
                throw new IllegalArgumentException("p-1 must be evenly divisible by q");
            } else if (bigInteger3.compareTo(BigInteger.valueOf(2)) || bigInteger3.compareTo(bigInteger.subtract(JPAKEUtil.f22229b))) {
                throw new IllegalArgumentException("g must be in [2, p-1]");
            } else if (!bigInteger3.modPow(bigInteger2, bigInteger).equals(JPAKEUtil.f22229b)) {
                throw new IllegalArgumentException("g^q mod p must equal 1");
            } else if (!bigInteger.isProbablePrime(20)) {
                throw new IllegalArgumentException("p must be prime");
            } else if (!bigInteger2.isProbablePrime(20)) {
                throw new IllegalArgumentException("q must be prime");
            }
        }
        this.f22222a = bigInteger;
        this.f22223b = bigInteger2;
        this.f22224c = bigInteger3;
    }
}
