package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.Iterator;

final class jr extends js {
    /* renamed from: a */
    private final /* synthetic */ Bundle f32213a;
    /* renamed from: b */
    private final /* synthetic */ jp f32214b;

    jr(jp jpVar, Bundle bundle) {
        this.f32214b = jpVar;
        this.f32213a = bundle;
        super();
    }

    /* renamed from: a */
    public final void mo6079a() {
        Iterator it = this.f32214b.f15670d.iterator();
        while (it.hasNext()) {
            ((jt) it.next()).mo4303a(this.f32213a);
        }
    }
}
