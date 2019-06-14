package com.google.android.gms.p185e;

import java.util.Arrays;

/* renamed from: com.google.android.gms.e.ac */
final class ac {
    /* renamed from: a */
    final String f7454a;
    /* renamed from: b */
    final byte[] f7455b;

    ac(String str, byte[] bArr) {
        this.f7454a = str;
        this.f7455b = bArr;
    }

    public final String toString() {
        String str = this.f7454a;
        int hashCode = Arrays.hashCode(this.f7455b);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 54);
        stringBuilder.append("KeyAndSerialized: key = ");
        stringBuilder.append(str);
        stringBuilder.append(" serialized hash = ");
        stringBuilder.append(hashCode);
        return stringBuilder.toString();
    }
}
