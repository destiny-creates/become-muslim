package com.google.android.gms.internal.ads;

public final class anv extends afi<anv> {
    /* renamed from: a */
    private Integer f28200a;
    /* renamed from: b */
    private Integer f28201b;

    public anv() {
        this.f28200a = null;
        this.f28201b = null;
        this.Y = null;
        this.Z = -1;
    }

    /* renamed from: a */
    protected final int mo3803a() {
        int a = super.mo3803a();
        if (this.f28200a != null) {
            a += afg.m18350b(1, this.f28200a.intValue());
        }
        return this.f28201b != null ? a + afg.m18350b(2, this.f28201b.intValue()) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ afo mo6026a(afe afe) {
        while (true) {
            int a = afe.m18324a();
            if (a == 0) {
                return this;
            }
            if (a == 8) {
                this.f28200a = Integer.valueOf(afe.m18338g());
            } else if (a == 16) {
                this.f28201b = Integer.valueOf(afe.m18338g());
            } else if (!super.m29903a(afe, a)) {
                return this;
            }
        }
    }

    /* renamed from: a */
    public final void mo3804a(afg afg) {
        if (this.f28200a != null) {
            afg.m18361a(1, this.f28200a.intValue());
        }
        if (this.f28201b != null) {
            afg.m18361a(2, this.f28201b.intValue());
        }
        super.mo3804a(afg);
    }
}
