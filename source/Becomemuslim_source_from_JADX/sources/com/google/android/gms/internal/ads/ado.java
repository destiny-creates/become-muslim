package com.google.android.gms.internal.ads;

final class ado {
    /* renamed from: a */
    private final String f14310a;
    /* renamed from: b */
    private int f14311b = 0;

    ado(String str) {
        this.f14310a = str;
    }

    /* renamed from: a */
    final boolean m18038a() {
        return this.f14311b < this.f14310a.length();
    }

    /* renamed from: b */
    final int m18039b() {
        String str = this.f14310a;
        int i = this.f14311b;
        this.f14311b = i + 1;
        char charAt = str.charAt(i);
        if (charAt < '?') {
            return charAt;
        }
        int i2 = charAt & 8191;
        int i3 = 13;
        while (true) {
            String str2 = this.f14310a;
            int i4 = this.f14311b;
            this.f14311b = i4 + 1;
            char charAt2 = str2.charAt(i4);
            if (charAt2 < '?') {
                return i2 | (charAt2 << i3);
            }
            i2 |= (charAt2 & 8191) << i3;
            i3 += 13;
        }
    }
}
