package com.google.android.gms.maps;

import com.google.android.gms.internal.p212k.C5031v;
import com.google.android.gms.maps.C5125c.C5113f;
import com.google.android.gms.maps.model.C5141i;
import com.google.android.gms.maps.p216a.C6835h;

/* renamed from: com.google.android.gms.maps.j */
final class C7844j extends C6835h {
    /* renamed from: a */
    private final /* synthetic */ C5113f f29224a;

    C7844j(C5125c c5125c, C5113f c5113f) {
        this.f29224a = c5113f;
    }

    /* renamed from: a */
    public final void mo6234a() {
        this.f29224a.onIndoorBuildingFocused();
    }

    /* renamed from: a */
    public final void mo6235a(C5031v c5031v) {
        this.f29224a.onIndoorLevelActivated(new C5141i(c5031v));
    }
}
