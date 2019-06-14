package com.google.android.gms.internal.ads;

public final class add extends afi<add> {
    /* renamed from: a */
    private Long f28028a;
    /* renamed from: b */
    private Integer f28029b;
    /* renamed from: c */
    private Boolean f28030c;
    /* renamed from: d */
    private int[] f28031d;
    /* renamed from: e */
    private Long f28032e;

    public add() {
        this.f28028a = null;
        this.f28029b = null;
        this.f28030c = null;
        this.f28031d = afr.f14434a;
        this.f28032e = null;
        this.Z = -1;
    }

    /* renamed from: a */
    protected final int mo3803a() {
        int a = super.mo3803a();
        if (this.f28028a != null) {
            a += afg.m18358d(1, this.f28028a.longValue());
        }
        if (this.f28029b != null) {
            a += afg.m18350b(2, this.f28029b.intValue());
        }
        if (this.f28030c != null) {
            this.f28030c.booleanValue();
            a += afg.m18349b(3) + 1;
        }
        if (this.f28031d != null && this.f28031d.length > 0) {
            int i = 0;
            for (int a2 : this.f28031d) {
                i += afg.m18342a(a2);
            }
            a = (a + i) + (this.f28031d.length * 1);
        }
        return this.f28032e != null ? a + afg.m18356c(5, this.f28032e.longValue()) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ afo mo6026a(afe afe) {
        while (true) {
            int a = afe.m18324a();
            if (a == 0) {
                return this;
            }
            if (a == 8) {
                this.f28028a = Long.valueOf(afe.m18339h());
            } else if (a == 16) {
                this.f28029b = Integer.valueOf(afe.m18338g());
            } else if (a == 24) {
                this.f28030c = Boolean.valueOf(afe.m18334d());
            } else if (a == 32) {
                a = afr.m18397a(afe, 32);
                r1 = this.f28031d == null ? 0 : this.f28031d.length;
                Object obj = new int[(a + r1)];
                if (r1 != 0) {
                    System.arraycopy(this.f28031d, 0, obj, 0, r1);
                }
                while (r1 < obj.length - 1) {
                    obj[r1] = afe.m18338g();
                    afe.m18324a();
                    r1++;
                }
                obj[r1] = afe.m18338g();
                this.f28031d = obj;
            } else if (a == 34) {
                a = afe.m18332c(afe.m18338g());
                r1 = afe.m18341j();
                int i = 0;
                while (afe.m18340i() > 0) {
                    afe.m18338g();
                    i++;
                }
                afe.m18336e(r1);
                r1 = this.f28031d == null ? 0 : this.f28031d.length;
                Object obj2 = new int[(i + r1)];
                if (r1 != 0) {
                    System.arraycopy(this.f28031d, 0, obj2, 0, r1);
                }
                while (r1 < obj2.length) {
                    obj2[r1] = afe.m18338g();
                    r1++;
                }
                this.f28031d = obj2;
                afe.m18333d(a);
            } else if (a == 40) {
                this.f28032e = Long.valueOf(afe.m18339h());
            } else if (!super.m29903a(afe, a)) {
                return this;
            }
        }
    }

    /* renamed from: a */
    public final void mo3804a(afg afg) {
        if (this.f28028a != null) {
            afg.m18367b(1, this.f28028a.longValue());
        }
        if (this.f28029b != null) {
            afg.m18361a(2, this.f28029b.intValue());
        }
        if (this.f28030c != null) {
            afg.m18365a(3, this.f28030c.booleanValue());
        }
        if (this.f28031d != null && this.f28031d.length > 0) {
            for (int a : this.f28031d) {
                afg.m18361a(4, a);
            }
        }
        if (this.f28032e != null) {
            afg.m18362a(5, this.f28032e.longValue());
        }
        super.mo3804a(afg);
    }
}
