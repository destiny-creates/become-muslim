package com.google.android.gms.internal.ads;

public final class afu extends afi<afu> {
    /* renamed from: c */
    private static volatile afu[] f28061c;
    /* renamed from: a */
    public byte[] f28062a;
    /* renamed from: b */
    public byte[] f28063b;

    public afu() {
        this.f28062a = null;
        this.f28063b = null;
        this.Y = null;
        this.Z = -1;
    }

    /* renamed from: b */
    public static afu[] m36753b() {
        if (f28061c == null) {
            synchronized (afm.f14429b) {
                if (f28061c == null) {
                    f28061c = new afu[0];
                }
            }
        }
        return f28061c;
    }

    /* renamed from: a */
    protected final int mo3803a() {
        int a = super.mo3803a() + afg.m18353b(1, this.f28062a);
        return this.f28063b != null ? a + afg.m18353b(2, this.f28063b) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ afo mo6026a(afe afe) {
        while (true) {
            int a = afe.m18324a();
            if (a == 0) {
                return this;
            }
            if (a == 10) {
                this.f28062a = afe.m18337f();
            } else if (a == 18) {
                this.f28063b = afe.m18337f();
            } else if (!super.m29903a(afe, a)) {
                return this;
            }
        }
    }

    /* renamed from: a */
    public final void mo3804a(afg afg) {
        afg.m18366a(1, this.f28062a);
        if (this.f28063b != null) {
            afg.m18366a(2, this.f28063b);
        }
        super.mo3804a(afg);
    }
}
