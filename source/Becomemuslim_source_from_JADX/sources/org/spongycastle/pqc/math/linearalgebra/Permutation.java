package org.spongycastle.pqc.math.linearalgebra;

import java.security.SecureRandom;

public class Permutation {
    /* renamed from: a */
    private int[] f23390a;

    public Permutation(int i) {
        if (i > 0) {
            this.f23390a = new int[i];
            for (i--; i >= 0; i--) {
                this.f23390a[i] = i;
            }
            return;
        }
        throw new IllegalArgumentException("invalid length");
    }

    public Permutation(int i, SecureRandom secureRandom) {
        if (i > 0) {
            int i2;
            this.f23390a = new int[i];
            int[] iArr = new int[i];
            for (i2 = 0; i2 < i; i2++) {
                iArr[i2] = i2;
            }
            i2 = i;
            for (int i3 = 0; i3 < i; i3++) {
                int a = RandUtils.m29292a(secureRandom, i2);
                i2--;
                this.f23390a[i3] = iArr[a];
                iArr[a] = iArr[i2];
            }
            return;
        }
        throw new IllegalArgumentException("invalid length");
    }

    /* renamed from: a */
    public byte[] m29247a() {
        int length = this.f23390a.length;
        int a = IntegerFunctions.m29235a(length - 1);
        byte[] bArr = new byte[((length * a) + 4)];
        int i = 0;
        LittleEndianConversions.m29239a(length, bArr, 0);
        while (i < length) {
            LittleEndianConversions.m29240a(this.f23390a[i], bArr, (i * a) + 4, a);
            i++;
        }
        return bArr;
    }

    /* renamed from: b */
    public int[] m29248b() {
        return IntUtils.m29234a(this.f23390a);
    }

    /* renamed from: c */
    public Permutation m29249c() {
        Permutation permutation = new Permutation(this.f23390a.length);
        for (int length = this.f23390a.length - 1; length >= 0; length--) {
            permutation.f23390a[this.f23390a[length]] = length;
        }
        return permutation;
    }

    /* renamed from: a */
    public Permutation m29246a(Permutation permutation) {
        if (permutation.f23390a.length == this.f23390a.length) {
            Permutation permutation2 = new Permutation(this.f23390a.length);
            for (int length = this.f23390a.length - 1; length >= 0; length--) {
                permutation2.f23390a[length] = this.f23390a[permutation.f23390a[length]];
            }
            return permutation2;
        }
        throw new IllegalArgumentException("length mismatch");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Permutation)) {
            return null;
        }
        return IntUtils.m29233a(this.f23390a, ((Permutation) obj).f23390a);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append(this.f23390a[0]);
        String stringBuilder2 = stringBuilder.toString();
        for (int i = 1; i < this.f23390a.length; i++) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(stringBuilder2);
            stringBuilder3.append(", ");
            stringBuilder3.append(this.f23390a[i]);
            stringBuilder2 = stringBuilder3.toString();
        }
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append(stringBuilder2);
        stringBuilder4.append("]");
        return stringBuilder4.toString();
    }

    public int hashCode() {
        return this.f23390a.hashCode();
    }
}
