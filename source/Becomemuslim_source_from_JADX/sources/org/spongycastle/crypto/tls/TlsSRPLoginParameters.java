package org.spongycastle.crypto.tls;

import java.math.BigInteger;
import org.spongycastle.crypto.params.SRP6GroupParameters;

public class TlsSRPLoginParameters {
    /* renamed from: a */
    protected SRP6GroupParameters f22629a;
    /* renamed from: b */
    protected BigInteger f22630b;
    /* renamed from: c */
    protected byte[] f22631c;

    public TlsSRPLoginParameters(SRP6GroupParameters sRP6GroupParameters, BigInteger bigInteger, byte[] bArr) {
        this.f22629a = sRP6GroupParameters;
        this.f22630b = bigInteger;
        this.f22631c = bArr;
    }

    /* renamed from: a */
    public SRP6GroupParameters m27779a() {
        return this.f22629a;
    }

    /* renamed from: b */
    public byte[] m27780b() {
        return this.f22631c;
    }

    /* renamed from: c */
    public BigInteger m27781c() {
        return this.f22630b;
    }
}
