package com.polidea.p254a.p256b.p260d;

import com.amplitude.api.Constants;
import com.facebook.common.time.Clock;
import com.polidea.p254a.p255a.C6975n;
import java.util.Date;
import p289e.C5986h;

/* compiled from: ScanPreconditionsVerifierApi24 */
/* renamed from: com.polidea.a.b.d.l */
public class C7043l implements C5589i {
    /* renamed from: a */
    private final long[] f24998a = new long[5];
    /* renamed from: b */
    private final C7042j f24999b;
    /* renamed from: c */
    private final C5986h f25000c;

    public C7043l(C7042j c7042j, C5986h c5986h) {
        this.f24999b = c7042j;
        this.f25000c = c5986h;
    }

    /* renamed from: a */
    public void mo5009a() {
        this.f24999b.mo5009a();
        int b = m32909b();
        long j = this.f24998a[b];
        long b2 = this.f25000c.m25116b();
        if (b2 - j >= Constants.EVENT_UPLOAD_PERIOD_MILLIS) {
            this.f24998a[b] = b2;
            return;
        }
        throw new C6975n(2147483646, new Date(j + Constants.EVENT_UPLOAD_PERIOD_MILLIS));
    }

    /* renamed from: b */
    private int m32909b() {
        long j = Clock.MAX_TIME;
        int i = -1;
        for (int i2 = 0; i2 < 5; i2++) {
            long j2 = this.f24998a[i2];
            if (j2 < j) {
                i = i2;
                j = j2;
            }
        }
        return i;
    }
}
