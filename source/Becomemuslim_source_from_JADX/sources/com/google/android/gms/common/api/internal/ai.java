package com.google.android.gms.common.api.internal;

import com.google.android.gms.p175c.p176a.C4759d;
import com.google.android.gms.p175c.p176a.C4761k;
import java.lang.ref.WeakReference;

final class ai extends C4759d {
    /* renamed from: a */
    private final WeakReference<ab> f13975a;

    ai(ab abVar) {
        this.f13975a = new WeakReference(abVar);
    }

    /* renamed from: a */
    public final void mo3273a(C4761k c4761k) {
        ab abVar = (ab) this.f13975a.get();
        if (abVar != null) {
            abVar.f11398a.m16716a(new aj(this, abVar, abVar, c4761k));
        }
    }
}
