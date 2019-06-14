package com.google.android.gms.internal.ads;

public final class bbb extends of<bbl> {
    /* renamed from: a */
    private final Object f28461a = new Object();
    /* renamed from: b */
    private final bbf f28462b;
    /* renamed from: c */
    private boolean f28463c;

    public bbb(bbf bbf) {
        this.f28462b = bbf;
    }

    /* renamed from: c */
    public final void m37254c() {
        synchronized (this.f28461a) {
            if (this.f28463c) {
                return;
            }
            this.f28463c = true;
            mo4320a(new bbc(this), new od());
            mo4320a(new bbd(this), new bbe(this));
        }
    }
}
