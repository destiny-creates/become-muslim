package com.google.android.gms.internal.ads;

public final class yy {
    /* renamed from: a */
    public static int m20186a(int i) {
        if (i >= 0 && i <= 2) {
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

    /* renamed from: b */
    public static int m20187b(int i) {
        if (i >= 0 && i <= 2) {
            return i;
        }
        StringBuilder stringBuilder = new StringBuilder(41);
        stringBuilder.append(i);
        stringBuilder.append(" is not a valid enum ProtoName");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: c */
    public static int m20188c(int i) {
        if (i >= 0 && i <= 3) {
            return i;
        }
        StringBuilder stringBuilder = new StringBuilder(48);
        stringBuilder.append(i);
        stringBuilder.append(" is not a valid enum EncryptionMethod");
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
