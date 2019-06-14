package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.gmsg.ae;
import java.util.Map;

final class aup implements ae<Object> {
    /* renamed from: a */
    private final /* synthetic */ bq f23818a;
    /* renamed from: b */
    private final /* synthetic */ aum f23819b;

    aup(aum aum, bq bqVar) {
        this.f23819b = aum;
        this.f23818a = bqVar;
    }

    public final void zza(Object obj, Map<String, String> map) {
        qo qoVar = (qo) this.f23819b.f15010a.get();
        if (qoVar == null) {
            this.f23818a.mo4225b("/showOverlay", this);
        } else {
            qoVar.getView().setVisibility(0);
        }
    }
}
