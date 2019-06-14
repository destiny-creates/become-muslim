package com.google.android.gms.p185e;

import com.facebook.ads.AdError;
import com.google.android.gms.common.util.C2895e;
import com.google.android.gms.common.util.C4376h;

/* renamed from: com.google.android.gms.e.dw */
final class dw implements ct {
    /* renamed from: a */
    private final long f11687a;
    /* renamed from: b */
    private final int f11688b;
    /* renamed from: c */
    private double f11689c;
    /* renamed from: d */
    private long f11690d;
    /* renamed from: e */
    private final Object f11691e;
    /* renamed from: f */
    private final C2895e f11692f;

    private dw(int i, long j) {
        this.f11691e = new Object();
        this.f11688b = 60;
        this.f11689c = (double) this.f11688b;
        this.f11687a = AdError.SERVER_ERROR_CODE;
        this.f11692f = C4376h.m14397d();
    }

    public dw() {
        this(60, 2000);
    }

    /* renamed from: a */
    public final boolean mo2514a() {
        synchronized (this.f11691e) {
            long a = this.f11692f.mo2482a();
            if (this.f11689c < ((double) this.f11688b)) {
                double d = ((double) (a - this.f11690d)) / ((double) this.f11687a);
                if (d > 0.0d) {
                    this.f11689c = Math.min((double) this.f11688b, this.f11689c + d);
                }
            }
            this.f11690d = a;
            if (this.f11689c >= 1.0d) {
                this.f11689c -= 1.0d;
                return true;
            }
            bs.m8584b("No more tokens available.");
            return false;
        }
    }
}
