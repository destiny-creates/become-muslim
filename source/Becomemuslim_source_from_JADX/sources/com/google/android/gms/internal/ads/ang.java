package com.google.android.gms.internal.ads;

public final class ang {
    /* renamed from: a */
    public static int m18656a(int i) {
        if (i >= 0 && i <= 1) {
            return i;
        }
        if (i >= 1000 && i <= 1000) {
            return i;
        }
        StringBuilder stringBuilder = new StringBuilder(43);
        stringBuilder.append(i);
        stringBuilder.append(" is not a valid enum EnumBoolean");
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
