package org.spongycastle.crypto.params;

import java.math.BigInteger;
import org.spongycastle.crypto.CipherParameters;

public class RSABlindingParameters implements CipherParameters {
    /* renamed from: a */
    private RSAKeyParameters f27143a;
    /* renamed from: b */
    private BigInteger f27144b;

    /* renamed from: a */
    public RSAKeyParameters m35705a() {
        return this.f27143a;
    }

    /* renamed from: b */
    public BigInteger m35706b() {
        return this.f27144b;
    }
}
