package com.google.android.gms.internal.ads;

public final class anz extends afi<anz> {
    /* renamed from: a */
    public Integer f28211a;
    /* renamed from: b */
    public Integer f28212b;
    /* renamed from: c */
    public Integer f28213c;

    public anz() {
        this.f28211a = null;
        this.f28212b = null;
        this.f28213c = null;
        this.Y = null;
        this.Z = -1;
    }

    /* renamed from: a */
    protected final int mo3803a() {
        int a = super.mo3803a();
        if (this.f28211a != null) {
            a += afg.m18350b(1, this.f28211a.intValue());
        }
        if (this.f28212b != null) {
            a += afg.m18350b(2, this.f28212b.intValue());
        }
        return this.f28213c != null ? a + afg.m18350b(3, this.f28213c.intValue()) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ afo mo6026a(afe afe) {
        while (true) {
            int a = afe.m18324a();
            if (a == 0) {
                return this;
            }
            if (a == 8) {
                this.f28211a = Integer.valueOf(afe.m18338g());
            } else if (a == 16) {
                this.f28212b = Integer.valueOf(afe.m18338g());
            } else if (a == 24) {
                this.f28213c = Integer.valueOf(afe.m18338g());
            } else if (!super.m29903a(afe, a)) {
                return this;
            }
        }
    }

    /* renamed from: a */
    public final void mo3804a(afg afg) {
        if (this.f28211a != null) {
            afg.m18361a(1, this.f28211a.intValue());
        }
        if (this.f28212b != null) {
            afg.m18361a(2, this.f28212b.intValue());
        }
        if (this.f28213c != null) {
            afg.m18361a(3, this.f28213c.intValue());
        }
        super.mo3804a(afg);
    }
}
