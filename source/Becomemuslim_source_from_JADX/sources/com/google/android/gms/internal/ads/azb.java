package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.ax;
import java.util.Random;

final class azb extends apo {
    /* renamed from: a */
    private final apn f28455a;

    azb(apn apn) {
        this.f28455a = apn;
    }

    /* renamed from: a */
    public final void mo3858a() {
        if (azl.m19174a()) {
            int intValue = ((Integer) aph.m18688f().m18889a(asp.bb)).intValue();
            int intValue2 = ((Integer) aph.m18688f().m18889a(asp.bc)).intValue();
            if (intValue > 0) {
                if (intValue2 >= 0) {
                    jw.f15691a.postDelayed(azc.f15073a, (long) (intValue + new Random().nextInt(intValue2 + 1)));
                }
            }
            ax.r().m19143a();
        }
        this.f28455a.mo3858a();
    }

    /* renamed from: a */
    public final void mo3859a(int i) {
        this.f28455a.mo3859a(i);
    }

    /* renamed from: b */
    public final void mo3860b() {
        this.f28455a.mo3860b();
    }

    /* renamed from: c */
    public final void mo3861c() {
        this.f28455a.mo3861c();
    }

    /* renamed from: d */
    public final void mo3862d() {
        this.f28455a.mo3862d();
    }

    /* renamed from: e */
    public final void mo3863e() {
        this.f28455a.mo3863e();
    }

    /* renamed from: f */
    public final void mo3864f() {
        this.f28455a.mo3864f();
    }
}
