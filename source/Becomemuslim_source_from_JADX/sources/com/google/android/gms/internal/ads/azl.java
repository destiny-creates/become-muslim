package com.google.android.gms.internal.ads;

@cm
final class azl {
    /* renamed from: a */
    private static final azi f15104a = azi.m19160a();
    /* renamed from: b */
    private static final float f15105b = ((Float) aph.m18688f().m18889a(asp.bf)).floatValue();
    /* renamed from: c */
    private static final long f15106c = ((Long) aph.m18688f().m18889a(asp.bd)).longValue();
    /* renamed from: d */
    private static final float f15107d = ((Float) aph.m18688f().m18889a(asp.bg)).floatValue();
    /* renamed from: e */
    private static final long f15108e = ((Long) aph.m18688f().m18889a(asp.be)).longValue();

    /* renamed from: a */
    private static int m19173a(long j, int i) {
        return (int) ((j >>> ((i % 16) * 4)) & 15);
    }

    /* renamed from: a */
    static boolean m19174a() {
        int h = f15104a.m19168h();
        int i = f15104a.m19169i();
        int g = f15104a.m19167g() + f15104a.m19166f();
        int i2 = Integer.MAX_VALUE;
        int a = (h >= 16 || f15108e == 0) ? f15107d != 0.0f ? ((int) (f15107d * ((float) h))) + 1 : Integer.MAX_VALUE : m19173a(f15108e, h);
        if (i <= a) {
            if (h < 16 && f15106c != 0) {
                i2 = m19173a(f15106c, h);
            } else if (f15105b != 0.0f) {
                i2 = (int) (f15105b * ((float) h));
            }
            if (g <= i2) {
                return true;
            }
        }
        return false;
    }
}
