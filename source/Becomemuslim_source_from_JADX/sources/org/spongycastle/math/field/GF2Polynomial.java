package org.spongycastle.math.field;

import org.spongycastle.util.Arrays;

class GF2Polynomial implements Polynomial {
    /* renamed from: a */
    protected final int[] f27646a;

    GF2Polynomial(int[] iArr) {
        this.f27646a = Arrays.m29375b(iArr);
    }

    /* renamed from: a */
    public int mo5909a() {
        return this.f27646a[this.f27646a.length - 1];
    }

    /* renamed from: b */
    public int[] mo5910b() {
        return Arrays.m29375b(this.f27646a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GF2Polynomial)) {
            return null;
        }
        return Arrays.m29356a(this.f27646a, ((GF2Polynomial) obj).f27646a);
    }

    public int hashCode() {
        return Arrays.m29344a(this.f27646a);
    }
}
