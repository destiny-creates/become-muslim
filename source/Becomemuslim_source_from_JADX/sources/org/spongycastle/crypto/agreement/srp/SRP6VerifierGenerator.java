package org.spongycastle.crypto.agreement.srp;

import java.math.BigInteger;
import org.spongycastle.crypto.Digest;

public class SRP6VerifierGenerator {
    /* renamed from: a */
    protected BigInteger f22259a;
    /* renamed from: b */
    protected BigInteger f22260b;
    /* renamed from: c */
    protected Digest f22261c;

    /* renamed from: a */
    public BigInteger m27383a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return this.f22260b.modPow(SRP6Util.m27380a(this.f22261c, this.f22259a, bArr, bArr2, bArr3), this.f22259a);
    }
}
