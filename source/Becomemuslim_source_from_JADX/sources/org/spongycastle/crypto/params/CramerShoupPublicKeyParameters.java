package org.spongycastle.crypto.params;

import java.math.BigInteger;

public class CramerShoupPublicKeyParameters extends CramerShoupKeyParameters {
    /* renamed from: b */
    private BigInteger f32627b;
    /* renamed from: c */
    private BigInteger f32628c;
    /* renamed from: d */
    private BigInteger f32629d;

    public CramerShoupPublicKeyParameters(CramerShoupParameters cramerShoupParameters, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        super(false, cramerShoupParameters);
        this.f32627b = bigInteger;
        this.f32628c = bigInteger2;
        this.f32629d = bigInteger3;
    }

    /* renamed from: c */
    public BigInteger m43358c() {
        return this.f32627b;
    }

    /* renamed from: d */
    public BigInteger m43359d() {
        return this.f32628c;
    }

    /* renamed from: e */
    public BigInteger m43360e() {
        return this.f32629d;
    }

    public int hashCode() {
        return ((this.f32627b.hashCode() ^ this.f32628c.hashCode()) ^ this.f32629d.hashCode()) ^ super.hashCode();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof CramerShoupPublicKeyParameters)) {
            return false;
        }
        CramerShoupPublicKeyParameters cramerShoupPublicKeyParameters = (CramerShoupPublicKeyParameters) obj;
        if (cramerShoupPublicKeyParameters.m43358c().equals(this.f32627b) && cramerShoupPublicKeyParameters.m43359d().equals(this.f32628c) && cramerShoupPublicKeyParameters.m43360e().equals(this.f32629d) && super.equals(obj) != null) {
            z = true;
        }
        return z;
    }
}
