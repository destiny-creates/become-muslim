package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.aty;
import com.google.android.gms.internal.ads.awo;
import com.google.android.gms.internal.ads.is;
import com.google.android.gms.internal.ads.jn;

final class al implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ String f6715a;
    /* renamed from: b */
    private final /* synthetic */ is f6716b;
    /* renamed from: c */
    private final /* synthetic */ ae f6717c;

    al(ae aeVar, String str, is isVar) {
        this.f6717c = aeVar;
        this.f6715a = str;
        this.f6716b = isVar;
    }

    public final void run() {
        try {
            ((awo) this.f6717c.e.f6811v.get(this.f6715a)).a((aty) this.f6716b.f15557C);
        } catch (Throwable e) {
            jn.d("#007 Could not call remote method.", e);
        }
    }
}
