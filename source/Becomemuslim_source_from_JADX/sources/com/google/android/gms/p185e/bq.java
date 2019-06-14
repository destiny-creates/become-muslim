package com.google.android.gms.p185e;

import com.google.android.gms.common.util.C2895e;

/* renamed from: com.google.android.gms.e.bq */
final class bq implements ct {
    /* renamed from: a */
    private final long f11639a = 900000;
    /* renamed from: b */
    private final long f11640b = 5000;
    /* renamed from: c */
    private final int f11641c = 5;
    /* renamed from: d */
    private double f11642d = ((double) Math.min(1, 5));
    /* renamed from: e */
    private long f11643e;
    /* renamed from: f */
    private final Object f11644f = new Object();
    /* renamed from: g */
    private final String f11645g;
    /* renamed from: h */
    private final C2895e f11646h;

    public bq(int i, int i2, long j, long j2, String str, C2895e c2895e) {
        this.f11645g = str;
        this.f11646h = c2895e;
    }

    /* renamed from: a */
    public final boolean mo2514a() {
        synchronized (this.f11644f) {
            long a = this.f11646h.mo2482a();
            if (a - this.f11643e < this.f11640b) {
                String str = this.f11645g;
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 34);
                stringBuilder.append("Excessive ");
                stringBuilder.append(str);
                stringBuilder.append(" detected; call ignored.");
                bs.m8584b(stringBuilder.toString());
                return false;
            }
            if (this.f11642d < ((double) this.f11641c)) {
                double d = ((double) (a - this.f11643e)) / ((double) this.f11639a);
                if (d > 0.0d) {
                    this.f11642d = Math.min((double) this.f11641c, this.f11642d + d);
                }
            }
            this.f11643e = a;
            if (this.f11642d >= 1.0d) {
                this.f11642d -= 1.0d;
                return true;
            }
            str = this.f11645g;
            stringBuilder = new StringBuilder(String.valueOf(str).length() + 34);
            stringBuilder.append("Excessive ");
            stringBuilder.append(str);
            stringBuilder.append(" detected; call ignored.");
            bs.m8584b(stringBuilder.toString());
            return false;
        }
    }
}
