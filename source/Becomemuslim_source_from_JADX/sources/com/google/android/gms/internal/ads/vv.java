package com.google.android.gms.internal.ads;

public final class vv extends afi<vv> {
    /* renamed from: a */
    public String f28763a;
    /* renamed from: b */
    public Long f28764b;
    /* renamed from: c */
    private String f28765c;
    /* renamed from: d */
    private String f28766d;
    /* renamed from: e */
    private String f28767e;
    /* renamed from: f */
    private Long f28768f;
    /* renamed from: g */
    private Long f28769g;
    /* renamed from: h */
    private String f28770h;
    /* renamed from: i */
    private Long f28771i;
    /* renamed from: j */
    private String f28772j;

    public vv() {
        this.f28763a = null;
        this.f28764b = null;
        this.f28765c = null;
        this.f28766d = null;
        this.f28767e = null;
        this.f28768f = null;
        this.f28769g = null;
        this.f28770h = null;
        this.f28771i = null;
        this.f28772j = null;
        this.Z = -1;
    }

    /* renamed from: a */
    protected final int mo3803a() {
        int a = super.mo3803a();
        if (this.f28763a != null) {
            a += afg.m18352b(1, this.f28763a);
        }
        if (this.f28764b != null) {
            a += afg.m18358d(2, this.f28764b.longValue());
        }
        if (this.f28765c != null) {
            a += afg.m18352b(3, this.f28765c);
        }
        if (this.f28766d != null) {
            a += afg.m18352b(4, this.f28766d);
        }
        if (this.f28767e != null) {
            a += afg.m18352b(5, this.f28767e);
        }
        if (this.f28768f != null) {
            a += afg.m18358d(6, this.f28768f.longValue());
        }
        if (this.f28769g != null) {
            a += afg.m18358d(7, this.f28769g.longValue());
        }
        if (this.f28770h != null) {
            a += afg.m18352b(8, this.f28770h);
        }
        if (this.f28771i != null) {
            a += afg.m18358d(9, this.f28771i.longValue());
        }
        return this.f28772j != null ? a + afg.m18352b(10, this.f28772j) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ afo mo6026a(afe afe) {
        while (true) {
            int a = afe.m18324a();
            switch (a) {
                case 0:
                    return this;
                case 10:
                    this.f28763a = afe.m18335e();
                    break;
                case 16:
                    this.f28764b = Long.valueOf(afe.m18339h());
                    break;
                case 26:
                    this.f28765c = afe.m18335e();
                    break;
                case 34:
                    this.f28766d = afe.m18335e();
                    break;
                case 42:
                    this.f28767e = afe.m18335e();
                    break;
                case 48:
                    this.f28768f = Long.valueOf(afe.m18339h());
                    break;
                case 56:
                    this.f28769g = Long.valueOf(afe.m18339h());
                    break;
                case 66:
                    this.f28770h = afe.m18335e();
                    break;
                case 72:
                    this.f28771i = Long.valueOf(afe.m18339h());
                    break;
                case 82:
                    this.f28772j = afe.m18335e();
                    break;
                default:
                    if (super.m29903a(afe, a)) {
                        break;
                    }
                    return this;
            }
        }
    }

    /* renamed from: a */
    public final void mo3804a(afg afg) {
        if (this.f28763a != null) {
            afg.m18364a(1, this.f28763a);
        }
        if (this.f28764b != null) {
            afg.m18367b(2, this.f28764b.longValue());
        }
        if (this.f28765c != null) {
            afg.m18364a(3, this.f28765c);
        }
        if (this.f28766d != null) {
            afg.m18364a(4, this.f28766d);
        }
        if (this.f28767e != null) {
            afg.m18364a(5, this.f28767e);
        }
        if (this.f28768f != null) {
            afg.m18367b(6, this.f28768f.longValue());
        }
        if (this.f28769g != null) {
            afg.m18367b(7, this.f28769g.longValue());
        }
        if (this.f28770h != null) {
            afg.m18364a(8, this.f28770h);
        }
        if (this.f28771i != null) {
            afg.m18367b(9, this.f28771i.longValue());
        }
        if (this.f28772j != null) {
            afg.m18364a(10, this.f28772j);
        }
        super.mo3804a(afg);
    }
}
