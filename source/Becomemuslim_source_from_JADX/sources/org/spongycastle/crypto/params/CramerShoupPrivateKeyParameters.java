package org.spongycastle.crypto.params;

import java.math.BigInteger;

public class CramerShoupPrivateKeyParameters extends CramerShoupKeyParameters {
    /* renamed from: b */
    private BigInteger f32621b;
    /* renamed from: c */
    private BigInteger f32622c;
    /* renamed from: d */
    private BigInteger f32623d;
    /* renamed from: e */
    private BigInteger f32624e;
    /* renamed from: f */
    private BigInteger f32625f;
    /* renamed from: g */
    private CramerShoupPublicKeyParameters f32626g;

    public CramerShoupPrivateKeyParameters(CramerShoupParameters cramerShoupParameters, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5) {
        super(true, cramerShoupParameters);
        this.f32621b = bigInteger;
        this.f32622c = bigInteger2;
        this.f32623d = bigInteger3;
        this.f32624e = bigInteger4;
        this.f32625f = bigInteger5;
    }

    /* renamed from: c */
    public BigInteger m43353c() {
        return this.f32621b;
    }

    /* renamed from: d */
    public BigInteger m43354d() {
        return this.f32622c;
    }

    /* renamed from: e */
    public BigInteger m43355e() {
        return this.f32623d;
    }

    /* renamed from: f */
    public BigInteger m43356f() {
        return this.f32624e;
    }

    /* renamed from: g */
    public BigInteger m43357g() {
        return this.f32625f;
    }

    /* renamed from: a */
    public void m43352a(CramerShoupPublicKeyParameters cramerShoupPublicKeyParameters) {
        this.f32626g = cramerShoupPublicKeyParameters;
    }

    public int hashCode() {
        return ((((this.f32621b.hashCode() ^ this.f32622c.hashCode()) ^ this.f32623d.hashCode()) ^ this.f32624e.hashCode()) ^ this.f32625f.hashCode()) ^ super.hashCode();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof CramerShoupPrivateKeyParameters)) {
            return false;
        }
        CramerShoupPrivateKeyParameters cramerShoupPrivateKeyParameters = (CramerShoupPrivateKeyParameters) obj;
        if (cramerShoupPrivateKeyParameters.m43353c().equals(this.f32621b) && cramerShoupPrivateKeyParameters.m43354d().equals(this.f32622c) && cramerShoupPrivateKeyParameters.m43355e().equals(this.f32623d) && cramerShoupPrivateKeyParameters.m43356f().equals(this.f32624e) && cramerShoupPrivateKeyParameters.m43357g().equals(this.f32625f) && super.equals(obj) != null) {
            z = true;
        }
        return z;
    }
}
