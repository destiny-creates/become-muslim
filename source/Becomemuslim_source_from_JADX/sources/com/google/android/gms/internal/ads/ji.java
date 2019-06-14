package com.google.android.gms.internal.ads;

@cm
public abstract class ji implements kp<no> {
    /* renamed from: a */
    private final Runnable f24137a = new jj(this);
    /* renamed from: b */
    private volatile Thread f24138b;
    /* renamed from: c */
    private boolean f24139c = false;

    public ji(boolean z) {
    }

    /* renamed from: a */
    public abstract void mo6079a();

    /* renamed from: b */
    public final void mo3818b() {
        h_();
        if (this.f24138b != null) {
            this.f24138b.interrupt();
        }
    }

    /* renamed from: c */
    public final /* synthetic */ Object mo3819c() {
        return this.f24139c ? ju.m19681b(this.f24137a) : ju.m19678a(this.f24137a);
    }

    /* renamed from: h */
    public final no m30863h() {
        return this.f24139c ? ju.m19681b(this.f24137a) : ju.m19678a(this.f24137a);
    }

    public abstract void h_();
}
