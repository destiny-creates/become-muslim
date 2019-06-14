package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.gmsg.ae;
import java.util.Map;

final class auq implements ae<Object> {
    /* renamed from: a */
    private final /* synthetic */ bq f23820a;
    /* renamed from: b */
    private final /* synthetic */ aum f23821b;

    auq(aum aum, bq bqVar) {
        this.f23821b = aum;
        this.f23820a = bqVar;
    }

    public final void zza(Object obj, Map<String, String> map) {
        qo qoVar = (qo) this.f23821b.f15010a.get();
        if (qoVar == null) {
            this.f23820a.mo4225b("/hideOverlay", this);
        } else {
            qoVar.getView().setVisibility(8);
        }
    }
}
