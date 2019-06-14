package org.spongycastle.crypto.params;

public class ElGamalKeyParameters extends AsymmetricKeyParameter {
    /* renamed from: b */
    private ElGamalParameters f31751b;

    protected ElGamalKeyParameters(boolean z, ElGamalParameters elGamalParameters) {
        super(z);
        this.f31751b = elGamalParameters;
    }

    /* renamed from: b */
    public ElGamalParameters m40793b() {
        return this.f31751b;
    }

    public int hashCode() {
        return this.f31751b != null ? this.f31751b.hashCode() : 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof ElGamalKeyParameters)) {
            return false;
        }
        ElGamalKeyParameters elGamalKeyParameters = (ElGamalKeyParameters) obj;
        if (this.f31751b != null) {
            return this.f31751b.equals(elGamalKeyParameters.m40793b());
        }
        if (elGamalKeyParameters.m40793b() == null) {
            z = true;
        }
        return z;
    }
}
