package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.ArrayList;
import java.util.List;

@cm
final class axz {
    /* renamed from: a */
    private final List<ayz> f15046a = new ArrayList();

    axz() {
    }

    /* renamed from: a */
    final void m19107a(aza aza) {
        Handler handler = jw.f15691a;
        for (ayz ayy : this.f15046a) {
            handler.post(new ayy(this, ayy, aza));
        }
        this.f15046a.clear();
    }
}
