package com.google.android.gms.internal.ads;

final class bay implements oc {
    /* renamed from: a */
    private final /* synthetic */ bbf f23880a;
    /* renamed from: b */
    private final /* synthetic */ bao f23881b;

    bay(bao bao, bbf bbf) {
        this.f23881b = bao;
        this.f23880a = bbf;
    }

    /* renamed from: a */
    public final void mo3840a() {
        synchronized (this.f23881b.f15139a) {
            this.f23881b.f15146h = 1;
            jn.m30864a("Failed loading new engine. Marking new engine destroyable.");
            this.f23880a.m37259e();
        }
    }
}
