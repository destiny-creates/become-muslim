package org.spongycastle.pqc.crypto.mceliece;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.pqc.math.linearalgebra.PolynomialRingGF2;

public class McElieceParameters implements CipherParameters {
    /* renamed from: a */
    private int f27716a;
    /* renamed from: b */
    private int f27717b;
    /* renamed from: c */
    private int f27718c;
    /* renamed from: d */
    private int f27719d;

    public McElieceParameters() {
        this(11, 50);
    }

    public McElieceParameters(int i, int i2) {
        if (i < 1) {
            throw new IllegalArgumentException("m must be positive");
        } else if (i <= 32) {
            this.f27716a = i;
            this.f27718c = 1 << i;
            if (i2 < 0) {
                throw new IllegalArgumentException("t must be positive");
            } else if (i2 <= this.f27718c) {
                this.f27717b = i2;
                this.f27719d = PolynomialRingGF2.m29287c(i);
            } else {
                throw new IllegalArgumentException("t must be less than n = 2^m");
            }
        } else {
            throw new IllegalArgumentException("m is too large");
        }
    }

    /* renamed from: b */
    public int m36368b() {
        return this.f27716a;
    }

    /* renamed from: c */
    public int m36369c() {
        return this.f27718c;
    }

    /* renamed from: d */
    public int m36370d() {
        return this.f27717b;
    }

    /* renamed from: e */
    public int m36371e() {
        return this.f27719d;
    }
}
