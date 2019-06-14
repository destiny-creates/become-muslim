package com.google.android.gms.internal.p211j;

import com.google.android.gms.common.api.internal.C2804h;
import com.google.android.gms.location.C5080k;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.aq;

/* renamed from: com.google.android.gms.internal.j.u */
final class C7822u extends aq {
    /* renamed from: a */
    private final C2804h<C5080k> f28964a;

    /* renamed from: a */
    public final void mo4776a(LocationAvailability locationAvailability) {
        this.f28964a.a(new C6806w(this, locationAvailability));
    }

    /* renamed from: a */
    public final void mo4777a(LocationResult locationResult) {
        this.f28964a.a(new C6805v(this, locationResult));
    }
}
