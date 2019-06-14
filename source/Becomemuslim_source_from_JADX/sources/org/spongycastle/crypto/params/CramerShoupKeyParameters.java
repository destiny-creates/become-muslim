package org.spongycastle.crypto.params;

public class CramerShoupKeyParameters extends AsymmetricKeyParameter {
    /* renamed from: b */
    private CramerShoupParameters f31745b;

    protected CramerShoupKeyParameters(boolean z, CramerShoupParameters cramerShoupParameters) {
        super(z);
        this.f31745b = cramerShoupParameters;
    }

    /* renamed from: b */
    public CramerShoupParameters m40787b() {
        return this.f31745b;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof CramerShoupKeyParameters)) {
            return false;
        }
        CramerShoupKeyParameters cramerShoupKeyParameters = (CramerShoupKeyParameters) obj;
        if (this.f31745b != null) {
            return this.f31745b.equals(cramerShoupKeyParameters.m40787b());
        }
        if (cramerShoupKeyParameters.m40787b() == null) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        int a = m35630a() ^ 1;
        return this.f31745b != null ? a ^ this.f31745b.hashCode() : a;
    }
}
