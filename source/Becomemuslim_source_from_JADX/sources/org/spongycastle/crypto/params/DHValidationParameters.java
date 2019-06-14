package org.spongycastle.crypto.params;

import org.spongycastle.util.Arrays;

public class DHValidationParameters {
    /* renamed from: a */
    private byte[] f22412a;
    /* renamed from: b */
    private int f22413b;

    public DHValidationParameters(byte[] bArr, int i) {
        this.f22412a = bArr;
        this.f22413b = i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DHValidationParameters)) {
            return false;
        }
        DHValidationParameters dHValidationParameters = (DHValidationParameters) obj;
        if (dHValidationParameters.f22413b != this.f22413b) {
            return false;
        }
        return Arrays.m29353a(this.f22412a, dHValidationParameters.f22412a);
    }

    public int hashCode() {
        return this.f22413b ^ Arrays.m29342a(this.f22412a);
    }
}
