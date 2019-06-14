package com.google.android.gms.maps;

import com.google.android.gms.internal.p212k.ab;
import com.google.android.gms.maps.C5125c.C5109b;
import com.google.android.gms.maps.model.C5143l;
import com.google.android.gms.maps.p216a.ar;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C4757d;

/* renamed from: com.google.android.gms.maps.p */
final class C7860p extends ar {
    /* renamed from: a */
    private final /* synthetic */ C5109b f29321a;

    C7860p(C5125c c5125c, C5109b c5109b) {
        this.f29321a = c5109b;
    }

    /* renamed from: a */
    public final C2758b mo6242a(ab abVar) {
        return C4757d.a(this.f29321a.getInfoWindow(new C5143l(abVar)));
    }

    /* renamed from: b */
    public final C2758b mo6243b(ab abVar) {
        return C4757d.a(this.f29321a.getInfoContents(new C5143l(abVar)));
    }
}
