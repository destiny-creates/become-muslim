package org.spongycastle.pqc.jcajce.spec;

import java.security.InvalidParameterException;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.pqc.math.linearalgebra.PolynomialRingGF2;

public class ECCKeyGenParameterSpec implements AlgorithmParameterSpec {
    /* renamed from: a */
    private int f23346a;
    /* renamed from: b */
    private int f23347b;
    /* renamed from: c */
    private int f23348c;
    /* renamed from: d */
    private int f23349d;

    public ECCKeyGenParameterSpec() {
        this(11, 50);
    }

    public ECCKeyGenParameterSpec(int i, int i2) {
        if (i < 1) {
            throw new InvalidParameterException("m must be positive");
        } else if (i <= 32) {
            this.f23346a = i;
            this.f23348c = 1 << i;
            if (i2 < 0) {
                throw new InvalidParameterException("t must be positive");
            } else if (i2 <= this.f23348c) {
                this.f23347b = i2;
                this.f23349d = PolynomialRingGF2.m29287c(i);
            } else {
                throw new InvalidParameterException("t must be less than n = 2^m");
            }
        } else {
            throw new InvalidParameterException("m is too large");
        }
    }

    /* renamed from: a */
    public int m29168a() {
        return this.f23346a;
    }

    /* renamed from: b */
    public int m29169b() {
        return this.f23347b;
    }
}
