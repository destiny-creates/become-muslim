package com.google.android.gms.maps;

import com.google.android.gms.internal.p212k.ab;
import com.google.android.gms.maps.C5125c.C5119l;
import com.google.android.gms.maps.model.C5143l;
import com.google.android.gms.maps.p216a.C6842v;

/* renamed from: com.google.android.gms.maps.n */
final class C7858n extends C6842v {
    /* renamed from: a */
    private final /* synthetic */ C5119l f29319a;

    C7858n(C5125c c5125c, C5119l c5119l) {
        this.f29319a = c5119l;
    }

    /* renamed from: a */
    public final void mo6238a(ab abVar) {
        this.f29319a.onMarkerDragStart(new C5143l(abVar));
    }

    /* renamed from: b */
    public final void mo6239b(ab abVar) {
        this.f29319a.onMarkerDrag(new C5143l(abVar));
    }

    /* renamed from: c */
    public final void mo6240c(ab abVar) {
        this.f29319a.onMarkerDragEnd(new C5143l(abVar));
    }
}
