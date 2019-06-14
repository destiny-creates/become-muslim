package com.google.android.gms.internal.ads;

public final class anw extends afi<anw> {
    /* renamed from: a */
    private Integer f28202a;
    /* renamed from: b */
    private Integer f28203b;

    public anw() {
        this.f28202a = null;
        this.f28203b = null;
        this.Y = null;
        this.Z = -1;
    }

    /* renamed from: a */
    protected final int mo3803a() {
        int a = super.mo3803a();
        if (this.f28202a != null) {
            a += afg.m18350b(1, this.f28202a.intValue());
        }
        return this.f28203b != null ? a + afg.m18350b(2, this.f28203b.intValue()) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ afo mo6026a(afe afe) {
        while (true) {
            int a = afe.m18324a();
            if (a == 0) {
                return this;
            }
            if (a == 8) {
                this.f28202a = Integer.valueOf(afe.m18338g());
            } else if (a == 16) {
                this.f28203b = Integer.valueOf(afe.m18338g());
            } else if (!super.m29903a(afe, a)) {
                return this;
            }
        }
    }

    /* renamed from: a */
    public final void mo3804a(afg afg) {
        if (this.f28202a != null) {
            afg.m18361a(1, this.f28202a.intValue());
        }
        if (this.f28203b != null) {
            afg.m18361a(2, this.f28203b.intValue());
        }
        super.mo3804a(afg);
    }
}
