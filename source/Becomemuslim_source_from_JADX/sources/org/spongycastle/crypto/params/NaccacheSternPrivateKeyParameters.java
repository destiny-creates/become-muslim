package org.spongycastle.crypto.params;

import java.math.BigInteger;
import java.util.Vector;

public class NaccacheSternPrivateKeyParameters extends NaccacheSternKeyParameters {
    /* renamed from: c */
    private BigInteger f32640c;
    /* renamed from: d */
    private Vector f32641d;

    public NaccacheSternPrivateKeyParameters(BigInteger bigInteger, BigInteger bigInteger2, int i, Vector vector, BigInteger bigInteger3) {
        super(true, bigInteger, bigInteger2, i);
        this.f32641d = vector;
        this.f32640c = bigInteger3;
    }

    /* renamed from: e */
    public BigInteger m43375e() {
        return this.f32640c;
    }

    /* renamed from: f */
    public Vector m43376f() {
        return this.f32641d;
    }
}
