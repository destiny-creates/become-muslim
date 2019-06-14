package com.google.android.gms.internal.p215n;

import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.C2810p;
import com.google.android.gms.p186f.C2955h;

/* renamed from: com.google.android.gms.internal.n.d */
final class C8222d extends C7830c {
    /* renamed from: a */
    private final C2955h<Boolean> f32373a;

    C8222d(C2955h<Boolean> c2955h) {
        this.f32373a = c2955h;
    }

    /* renamed from: a */
    public final void mo6220a(int i, boolean z, Bundle bundle) {
        C2810p.a(new Status(i), Boolean.valueOf(z), this.f32373a);
    }

    /* renamed from: a */
    public final void mo6227a(Status status, boolean z, Bundle bundle) {
        C2810p.a(status, Boolean.valueOf(z), this.f32373a);
    }
}
