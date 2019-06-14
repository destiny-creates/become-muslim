package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

final class aum {
    /* renamed from: a */
    private final WeakReference<qo> f15010a;
    /* renamed from: b */
    private String f15011b;

    public aum(qo qoVar) {
        this.f15010a = new WeakReference(qoVar);
    }

    /* renamed from: a */
    public final void m18987a(bq bqVar) {
        bqVar.mo4222a("/loadHtml", new aun(this, bqVar));
        bqVar.mo4222a("/showOverlay", new aup(this, bqVar));
        bqVar.mo4222a("/hideOverlay", new auq(this, bqVar));
        qo qoVar = (qo) this.f15010a.get();
        if (qoVar != null) {
            qoVar.mo6678a("/sendMessageToSdk", new aur(this, bqVar));
        }
    }
}
