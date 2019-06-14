package com.google.android.gms.internal.p210i;

import com.facebook.ads.AdError;
import com.google.android.gms.common.util.C2895e;

/* renamed from: com.google.android.gms.internal.i.bj */
public final class bj {
    /* renamed from: a */
    private final long f16417a;
    /* renamed from: b */
    private final int f16418b;
    /* renamed from: c */
    private double f16419c;
    /* renamed from: d */
    private long f16420d;
    /* renamed from: e */
    private final Object f16421e;
    /* renamed from: f */
    private final String f16422f;
    /* renamed from: g */
    private final C2895e f16423g;

    private bj(int i, long j, String str, C2895e c2895e) {
        this.f16421e = new Object();
        this.f16418b = 60;
        this.f16419c = (double) this.f16418b;
        this.f16417a = AdError.SERVER_ERROR_CODE;
        this.f16422f = str;
        this.f16423g = c2895e;
    }

    public bj(String str, C2895e c2895e) {
        this(60, 2000, str, c2895e);
    }

    /* renamed from: a */
    public final boolean m20330a() {
        synchronized (this.f16421e) {
            long a = this.f16423g.a();
            if (this.f16419c < ((double) this.f16418b)) {
                double d = ((double) (a - this.f16420d)) / ((double) this.f16417a);
                if (d > 0.0d) {
                    this.f16419c = Math.min((double) this.f16418b, this.f16419c + d);
                }
            }
            this.f16420d = a;
            if (this.f16419c >= 1.0d) {
                this.f16419c -= 1.0d;
                return true;
            }
            String str = this.f16422f;
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 34);
            stringBuilder.append("Excessive ");
            stringBuilder.append(str);
            stringBuilder.append(" detected; call ignored.");
            bk.m20335b(stringBuilder.toString());
            return false;
        }
    }
}
