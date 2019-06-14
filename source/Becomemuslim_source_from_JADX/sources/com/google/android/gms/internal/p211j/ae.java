package com.google.android.gms.internal.p211j;

import com.google.android.gms.common.api.internal.C2796c.C2795b;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.location.C7837o;

/* renamed from: com.google.android.gms.internal.j.ae */
final class ae extends C6804s {
    /* renamed from: a */
    private C2795b<C7837o> f28927a;

    public ae(C2795b<C7837o> c2795b) {
        C2872v.b(c2795b != null, "listener can't be null.");
        this.f28927a = c2795b;
    }

    /* renamed from: a */
    public final void mo6205a(C7837o c7837o) {
        this.f28927a.a(c7837o);
        this.f28927a = null;
    }
}
