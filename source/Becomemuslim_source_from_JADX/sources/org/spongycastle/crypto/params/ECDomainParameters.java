package org.spongycastle.crypto.params;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.Arrays;

public class ECDomainParameters implements ECConstants {
    /* renamed from: a */
    private ECCurve f27086a;
    /* renamed from: b */
    private byte[] f27087b;
    /* renamed from: h */
    private ECPoint f27088h;
    /* renamed from: i */
    private BigInteger f27089i;
    /* renamed from: j */
    private BigInteger f27090j;

    public ECDomainParameters(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger) {
        this(eCCurve, eCPoint, bigInteger, d, null);
    }

    public ECDomainParameters(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        this(eCCurve, eCPoint, bigInteger, bigInteger2, null);
    }

    public ECDomainParameters(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.f27086a = eCCurve;
        this.f27088h = eCPoint.m28418p();
        this.f27089i = bigInteger;
        this.f27090j = bigInteger2;
        this.f27087b = bArr;
    }

    /* renamed from: a */
    public ECCurve m35647a() {
        return this.f27086a;
    }

    /* renamed from: b */
    public ECPoint m35648b() {
        return this.f27088h;
    }

    /* renamed from: c */
    public BigInteger m35649c() {
        return this.f27089i;
    }

    /* renamed from: d */
    public BigInteger m35650d() {
        return this.f27090j;
    }

    /* renamed from: e */
    public byte[] m35651e() {
        return Arrays.m29373b(this.f27087b);
    }
}
