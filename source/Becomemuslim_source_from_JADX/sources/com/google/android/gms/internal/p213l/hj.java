package com.google.android.gms.internal.p213l;

import android.util.Log;

/* renamed from: com.google.android.gms.internal.l.hj */
final class hj extends hd<Boolean> {
    hj(hn hnVar, String str, Boolean bool) {
        super(hnVar, str, bool);
    }

    /* renamed from: a */
    protected final /* synthetic */ Object mo4766a(String str) {
        if (gy.f17251a.matcher(str).matches()) {
            return Boolean.valueOf(true);
        }
        if (gy.f17252b.matcher(str).matches()) {
            return Boolean.valueOf(false);
        }
        String str2 = this.a;
        StringBuilder stringBuilder = new StringBuilder((String.valueOf(str2).length() + 28) + String.valueOf(str).length());
        stringBuilder.append("Invalid boolean value for ");
        stringBuilder.append(str2);
        stringBuilder.append(": ");
        stringBuilder.append(str);
        Log.e("PhenotypeFlag", stringBuilder.toString());
        return null;
    }
}
