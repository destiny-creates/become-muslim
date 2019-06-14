package org.spongycastle.crypto.params;

public class DHKeyParameters extends AsymmetricKeyParameter {
    /* renamed from: b */
    private DHParameters f31747b;

    protected DHKeyParameters(boolean z, DHParameters dHParameters) {
        super(z);
        this.f31747b = dHParameters;
    }

    /* renamed from: b */
    public DHParameters m40790b() {
        return this.f31747b;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof DHKeyParameters)) {
            return false;
        }
        DHKeyParameters dHKeyParameters = (DHKeyParameters) obj;
        if (this.f31747b != null) {
            return this.f31747b.equals(dHKeyParameters.m40790b());
        }
        if (dHKeyParameters.m40790b() == null) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        int a = m35630a() ^ 1;
        return this.f31747b != null ? a ^ this.f31747b.hashCode() : a;
    }
}
