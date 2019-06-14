package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.params.ElGamalParameters;

public class ElGamalParametersGenerator {
    /* renamed from: a */
    private int f22370a;
    /* renamed from: b */
    private int f22371b;
    /* renamed from: c */
    private SecureRandom f22372c;

    /* renamed from: a */
    public void m27453a(int i, int i2, SecureRandom secureRandom) {
        this.f22370a = i;
        this.f22371b = i2;
        this.f22372c = secureRandom;
    }

    /* renamed from: a */
    public ElGamalParameters m27452a() {
        BigInteger[] a = DHParametersHelper.m27438a(this.f22370a, this.f22371b, this.f22372c);
        BigInteger bigInteger = a[0];
        return new ElGamalParameters(bigInteger, DHParametersHelper.m27437a(bigInteger, a[1], this.f22372c));
    }
}
