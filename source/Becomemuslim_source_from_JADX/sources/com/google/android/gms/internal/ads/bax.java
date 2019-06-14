package com.google.android.gms.internal.ads;

final class bax implements oe<bac> {
    /* renamed from: a */
    private final /* synthetic */ bbf f23878a;
    /* renamed from: b */
    private final /* synthetic */ bao f23879b;

    bax(bao bao, bbf bbf) {
        this.f23879b = bao;
        this.f23878a = bbf;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo3839a(Object obj) {
        synchronized (this.f23879b.f15139a) {
            this.f23879b.f15146h = 0;
            if (!(this.f23879b.f15145g == null || this.f23878a == this.f23879b.f15145g)) {
                jn.m30864a("New JS engine is loaded, marking previous one as destroyable.");
                this.f23879b.f15145g.m37259e();
            }
            this.f23879b.f15145g = this.f23878a;
        }
    }
}
