package com.google.android.gms.internal.p213l;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.l.c */
public final class C5036c extends IOException {
    C5036c(int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder(108);
        stringBuilder.append("CodedOutputStream was writing to a flat byte array and ran out of space (pos ");
        stringBuilder.append(i);
        stringBuilder.append(" limit ");
        stringBuilder.append(i2);
        stringBuilder.append(").");
        super(stringBuilder.toString());
    }
}
