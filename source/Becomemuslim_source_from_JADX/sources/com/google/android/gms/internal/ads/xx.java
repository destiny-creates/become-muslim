package com.google.android.gms.internal.ads;

public final class xx extends afi<xx> {
    /* renamed from: a */
    public String f28773a;
    /* renamed from: b */
    private String f28774b;
    /* renamed from: c */
    private String f28775c;
    /* renamed from: d */
    private String f28776d;
    /* renamed from: e */
    private String f28777e;

    /* renamed from: a */
    protected final int mo3803a() {
        int a = super.mo3803a();
        if (this.f28773a != null) {
            a += afg.m18352b(1, this.f28773a);
        }
        if (this.f28774b != null) {
            a += afg.m18352b(2, this.f28774b);
        }
        if (this.f28775c != null) {
            a += afg.m18352b(3, this.f28775c);
        }
        if (this.f28776d != null) {
            a += afg.m18352b(4, this.f28776d);
        }
        return this.f28777e != null ? a + afg.m18352b(5, this.f28777e) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ afo mo6026a(afe afe) {
        while (true) {
            int a = afe.m18324a();
            if (a == 0) {
                return this;
            }
            if (a == 10) {
                this.f28773a = afe.m18335e();
            } else if (a == 18) {
                this.f28774b = afe.m18335e();
            } else if (a == 26) {
                this.f28775c = afe.m18335e();
            } else if (a == 34) {
                this.f28776d = afe.m18335e();
            } else if (a == 42) {
                this.f28777e = afe.m18335e();
            } else if (!super.m29903a(afe, a)) {
                return this;
            }
        }
    }

    /* renamed from: a */
    public final void mo3804a(afg afg) {
        if (this.f28773a != null) {
            afg.m18364a(1, this.f28773a);
        }
        if (this.f28774b != null) {
            afg.m18364a(2, this.f28774b);
        }
        if (this.f28775c != null) {
            afg.m18364a(3, this.f28775c);
        }
        if (this.f28776d != null) {
            afg.m18364a(4, this.f28776d);
        }
        if (this.f28777e != null) {
            afg.m18364a(5, this.f28777e);
        }
        super.mo3804a(afg);
    }
}
