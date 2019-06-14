package org.spongycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECPoint;

public class ECParameterSpec implements AlgorithmParameterSpec {
    /* renamed from: a */
    private ECCurve f23047a;
    /* renamed from: b */
    private byte[] f23048b;
    /* renamed from: c */
    private ECPoint f23049c;
    /* renamed from: d */
    private BigInteger f23050d;
    /* renamed from: e */
    private BigInteger f23051e;

    public ECParameterSpec(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger) {
        this.f23047a = eCCurve;
        this.f23049c = eCPoint.m28418p();
        this.f23050d = bigInteger;
        this.f23051e = BigInteger.valueOf(1);
        this.f23048b = null;
    }

    public ECParameterSpec(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.f23047a = eCCurve;
        this.f23049c = eCPoint.m28418p();
        this.f23050d = bigInteger;
        this.f23051e = bigInteger2;
        this.f23048b = bArr;
    }

    /* renamed from: b */
    public ECCurve m28315b() {
        return this.f23047a;
    }

    /* renamed from: c */
    public ECPoint m28316c() {
        return this.f23049c;
    }

    /* renamed from: d */
    public BigInteger m28317d() {
        return this.f23050d;
    }

    /* renamed from: e */
    public BigInteger m28318e() {
        return this.f23051e;
    }

    /* renamed from: f */
    public byte[] m28319f() {
        return this.f23048b;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof ECParameterSpec)) {
            return false;
        }
        ECParameterSpec eCParameterSpec = (ECParameterSpec) obj;
        if (m28315b().m28374a(eCParameterSpec.m28315b()) && m28316c().m28397a(eCParameterSpec.m28316c()) != null) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return m28315b().hashCode() ^ m28316c().hashCode();
    }
}
