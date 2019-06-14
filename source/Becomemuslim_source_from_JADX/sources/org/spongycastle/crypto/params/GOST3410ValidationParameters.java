package org.spongycastle.crypto.params;

public class GOST3410ValidationParameters {
    /* renamed from: a */
    private int f22422a;
    /* renamed from: b */
    private int f22423b;
    /* renamed from: c */
    private long f22424c;
    /* renamed from: d */
    private long f22425d;

    public boolean equals(Object obj) {
        if (!(obj instanceof GOST3410ValidationParameters)) {
            return false;
        }
        GOST3410ValidationParameters gOST3410ValidationParameters = (GOST3410ValidationParameters) obj;
        if (gOST3410ValidationParameters.f22423b == this.f22423b && gOST3410ValidationParameters.f22422a == this.f22422a && gOST3410ValidationParameters.f22425d == this.f22425d && gOST3410ValidationParameters.f22424c == this.f22424c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f22422a ^ this.f22423b) ^ ((int) this.f22424c)) ^ ((int) (this.f22424c >> 32))) ^ ((int) this.f22425d)) ^ ((int) (this.f22425d >> 32));
    }
}
