package com.google.android.gms.internal.p211j;

import android.location.Location;
import com.google.android.gms.common.api.internal.C2804h;
import com.google.android.gms.location.C5081l;
import com.google.android.gms.location.at;

/* renamed from: com.google.android.gms.internal.j.y */
final class C7824y extends at {
    /* renamed from: a */
    private final C2804h<C5081l> f28965a;

    C7824y(C2804h<C5081l> c2804h) {
        this.f28965a = c2804h;
    }

    /* renamed from: a */
    public final synchronized void m38029a() {
        this.f28965a.a();
    }

    /* renamed from: a */
    public final synchronized void mo4778a(Location location) {
        this.f28965a.a(new C6807z(this, location));
    }
}
