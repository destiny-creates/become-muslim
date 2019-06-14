package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.bn;
import java.util.Arrays;

@cm
final class aze {
    /* renamed from: a */
    private final Object[] f15077a;

    aze(aoq aoq, String str, int i) {
        this.f15077a = bn.a((String) aph.m18688f().m18889a(asp.aV), aoq, str, i, null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof aze)) {
            return false;
        }
        return Arrays.equals(this.f15077a, ((aze) obj).f15077a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f15077a);
    }

    public final String toString() {
        String arrays = Arrays.toString(this.f15077a);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(arrays).length() + 24);
        stringBuilder.append("[InterstitialAdPoolKey ");
        stringBuilder.append(arrays);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
