package com.google.android.gms.internal.p210i;

/* renamed from: com.google.android.gms.internal.i.io */
final class io extends IllegalArgumentException {
    io(int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder(54);
        stringBuilder.append("Unpaired surrogate at index ");
        stringBuilder.append(i);
        stringBuilder.append(" of ");
        stringBuilder.append(i2);
        super(stringBuilder.toString());
    }
}
