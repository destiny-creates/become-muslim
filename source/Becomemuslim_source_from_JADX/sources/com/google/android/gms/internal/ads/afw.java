package com.google.android.gms.internal.ads;

public final class afw extends afi<afw> {
    /* renamed from: a */
    private byte[] f28069a;
    /* renamed from: b */
    private byte[] f28070b;
    /* renamed from: c */
    private byte[] f28071c;

    public afw() {
        this.f28069a = null;
        this.f28070b = null;
        this.f28071c = null;
        this.Y = null;
        this.Z = -1;
    }

    /* renamed from: a */
    protected final int mo3803a() {
        int a = super.mo3803a();
        if (this.f28069a != null) {
            a += afg.m18353b(1, this.f28069a);
        }
        if (this.f28070b != null) {
            a += afg.m18353b(2, this.f28070b);
        }
        return this.f28071c != null ? a + afg.m18353b(3, this.f28071c) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ afo mo6026a(afe afe) {
        while (true) {
            int a = afe.m18324a();
            if (a == 0) {
                return this;
            }
            if (a == 10) {
                this.f28069a = afe.m18337f();
            } else if (a == 18) {
                this.f28070b = afe.m18337f();
            } else if (a == 26) {
                this.f28071c = afe.m18337f();
            } else if (!super.m29903a(afe, a)) {
                return this;
            }
        }
    }

    /* renamed from: a */
    public final void mo3804a(afg afg) {
        if (this.f28069a != null) {
            afg.m18366a(1, this.f28069a);
        }
        if (this.f28070b != null) {
            afg.m18366a(2, this.f28070b);
        }
        if (this.f28071c != null) {
            afg.m18366a(3, this.f28071c);
        }
        super.mo3804a(afg);
    }
}
