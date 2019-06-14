package com.google.android.gms.internal.ads;

public final class agb extends afi<agb> {
    /* renamed from: a */
    public String f28094a;
    /* renamed from: b */
    public Long f28095b;
    /* renamed from: c */
    public Boolean f28096c;

    public agb() {
        this.f28094a = null;
        this.f28095b = null;
        this.f28096c = null;
        this.Y = null;
        this.Z = -1;
    }

    /* renamed from: a */
    protected final int mo3803a() {
        int a = super.mo3803a();
        if (this.f28094a != null) {
            a += afg.m18352b(1, this.f28094a);
        }
        if (this.f28095b != null) {
            a += afg.m18358d(2, this.f28095b.longValue());
        }
        if (this.f28096c == null) {
            return a;
        }
        this.f28096c.booleanValue();
        return a + (afg.m18349b(3) + 1);
    }

    /* renamed from: a */
    public final /* synthetic */ afo mo6026a(afe afe) {
        while (true) {
            int a = afe.m18324a();
            if (a == 0) {
                return this;
            }
            if (a == 10) {
                this.f28094a = afe.m18335e();
            } else if (a == 16) {
                this.f28095b = Long.valueOf(afe.m18328b());
            } else if (a == 24) {
                this.f28096c = Boolean.valueOf(afe.m18334d());
            } else if (!super.m29903a(afe, a)) {
                return this;
            }
        }
    }

    /* renamed from: a */
    public final void mo3804a(afg afg) {
        if (this.f28094a != null) {
            afg.m18364a(1, this.f28094a);
        }
        if (this.f28095b != null) {
            afg.m18367b(2, this.f28095b.longValue());
        }
        if (this.f28096c != null) {
            afg.m18365a(3, this.f28096c.booleanValue());
        }
        super.mo3804a(afg);
    }
}
