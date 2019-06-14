package com.google.android.gms.internal.ads;

final class ek implements oe<bbl> {
    /* renamed from: a */
    private final /* synthetic */ ej f24068a;

    ek(ej ejVar) {
        this.f24068a = ejVar;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo3839a(Object obj) {
        try {
            ((bbl) obj).mo6652b("AFMA_getAdapterLessMediationAd", this.f24068a.f15338a);
        } catch (Throwable e) {
            mt.m19919b("Error requesting an ad url", e);
            eh.f28641f.b(this.f24068a.f15339b);
        }
    }
}
