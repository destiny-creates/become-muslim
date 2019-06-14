package com.google.android.gms.maps;

import android.location.Location;
import com.google.android.gms.maps.C5125c.C5120m;
import com.google.android.gms.maps.p216a.C6843x;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C4757d;

/* renamed from: com.google.android.gms.maps.q */
final class C7861q extends C6843x {
    /* renamed from: a */
    private final /* synthetic */ C5120m f29322a;

    C7861q(C5125c c5125c, C5120m c5120m) {
        this.f29322a = c5120m;
    }

    /* renamed from: a */
    public final void mo6244a(C2758b c2758b) {
        this.f29322a.onMyLocationChange((Location) C4757d.a(c2758b));
    }
}
