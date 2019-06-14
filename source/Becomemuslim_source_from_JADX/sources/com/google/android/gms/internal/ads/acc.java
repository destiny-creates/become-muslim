package com.google.android.gms.internal.ads;

public final class acc extends afi<acc> {
    /* renamed from: a */
    public Long f28017a;
    /* renamed from: b */
    public Long f28018b;
    /* renamed from: c */
    public Long f28019c;
    /* renamed from: d */
    private Long f28020d;
    /* renamed from: e */
    private Long f28021e;

    public acc() {
        this.f28020d = null;
        this.f28021e = null;
        this.f28017a = null;
        this.f28018b = null;
        this.f28019c = null;
        this.Z = -1;
    }

    /* renamed from: a */
    protected final int mo3803a() {
        int a = super.mo3803a();
        if (this.f28020d != null) {
            a += afg.m18358d(1, this.f28020d.longValue());
        }
        if (this.f28021e != null) {
            a += afg.m18358d(2, this.f28021e.longValue());
        }
        if (this.f28017a != null) {
            a += afg.m18358d(3, this.f28017a.longValue());
        }
        if (this.f28018b != null) {
            a += afg.m18358d(4, this.f28018b.longValue());
        }
        return this.f28019c != null ? a + afg.m18358d(5, this.f28019c.longValue()) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ afo mo6026a(afe afe) {
        while (true) {
            int a = afe.m18324a();
            if (a == 0) {
                return this;
            }
            if (a == 8) {
                this.f28020d = Long.valueOf(afe.m18339h());
            } else if (a == 16) {
                this.f28021e = Long.valueOf(afe.m18339h());
            } else if (a == 24) {
                this.f28017a = Long.valueOf(afe.m18339h());
            } else if (a == 32) {
                this.f28018b = Long.valueOf(afe.m18339h());
            } else if (a == 40) {
                this.f28019c = Long.valueOf(afe.m18339h());
            } else if (!super.m29903a(afe, a)) {
                return this;
            }
        }
    }

    /* renamed from: a */
    public final void mo3804a(afg afg) {
        if (this.f28020d != null) {
            afg.m18367b(1, this.f28020d.longValue());
        }
        if (this.f28021e != null) {
            afg.m18367b(2, this.f28021e.longValue());
        }
        if (this.f28017a != null) {
            afg.m18367b(3, this.f28017a.longValue());
        }
        if (this.f28018b != null) {
            afg.m18367b(4, this.f28018b.longValue());
        }
        if (this.f28019c != null) {
            afg.m18367b(5, this.f28019c.longValue());
        }
        super.mo3804a(afg);
    }
}
