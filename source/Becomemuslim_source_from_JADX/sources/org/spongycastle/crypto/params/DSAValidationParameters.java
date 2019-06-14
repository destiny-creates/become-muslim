package org.spongycastle.crypto.params;

import org.spongycastle.util.Arrays;

public class DSAValidationParameters {
    /* renamed from: a */
    private int f22419a;
    /* renamed from: b */
    private byte[] f22420b;
    /* renamed from: c */
    private int f22421c;

    public DSAValidationParameters(byte[] bArr, int i) {
        this(bArr, i, -1);
    }

    public DSAValidationParameters(byte[] bArr, int i, int i2) {
        this.f22420b = bArr;
        this.f22421c = i;
        this.f22419a = i2;
    }

    public int hashCode() {
        return this.f22421c ^ Arrays.m29342a(this.f22420b);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DSAValidationParameters)) {
            return false;
        }
        DSAValidationParameters dSAValidationParameters = (DSAValidationParameters) obj;
        if (dSAValidationParameters.f22421c != this.f22421c) {
            return false;
        }
        return Arrays.m29353a(this.f22420b, dSAValidationParameters.f22420b);
    }
}
