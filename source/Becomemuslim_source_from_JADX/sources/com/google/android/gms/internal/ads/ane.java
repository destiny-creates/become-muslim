package com.google.android.gms.internal.ads;

public final class ane {
    /* renamed from: a */
    private final byte[] f14773a;
    /* renamed from: b */
    private int f14774b;
    /* renamed from: c */
    private int f14775c;
    /* renamed from: d */
    private final /* synthetic */ anc f14776d;

    private ane(anc anc, byte[] bArr) {
        this.f14776d = anc;
        this.f14773a = bArr;
    }

    /* renamed from: a */
    public final ane m18653a(int i) {
        this.f14774b = i;
        return this;
    }

    /* renamed from: a */
    public final synchronized void m18654a() {
        try {
            if (this.f14776d.f14772b) {
                this.f14776d.f14771a.mo3827a(this.f14773a);
                this.f14776d.f14771a.mo3824a(this.f14774b);
                this.f14776d.f14771a.mo3829b(this.f14775c);
                this.f14776d.f14771a.mo3828a(null);
                this.f14776d.f14771a.mo3823a();
            }
        } catch (Throwable e) {
            mt.m19916a("Clearcut log failed", e);
        }
    }

    /* renamed from: b */
    public final ane m18655b(int i) {
        this.f14775c = i;
        return this;
    }
}
