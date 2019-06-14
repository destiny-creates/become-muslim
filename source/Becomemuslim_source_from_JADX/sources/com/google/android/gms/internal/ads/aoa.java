package com.google.android.gms.internal.ads;

public final class aoa extends afi<aoa> {
    /* renamed from: a */
    private static volatile aoa[] f28214a;
    /* renamed from: b */
    private aoe f28215b;
    /* renamed from: c */
    private aoh f28216c;
    /* renamed from: d */
    private aoi f28217d;
    /* renamed from: e */
    private aoj f28218e;
    /* renamed from: f */
    private aob f28219f;
    /* renamed from: g */
    private aof f28220g;
    /* renamed from: h */
    private aod f28221h;
    /* renamed from: i */
    private Integer f28222i;
    /* renamed from: j */
    private Integer f28223j;
    /* renamed from: k */
    private any f28224k;
    /* renamed from: l */
    private Integer f28225l;
    /* renamed from: m */
    private Integer f28226m;
    /* renamed from: n */
    private Integer f28227n;
    /* renamed from: o */
    private Integer f28228o;
    /* renamed from: p */
    private Integer f28229p;
    /* renamed from: q */
    private Long f28230q;

    public aoa() {
        this.f28215b = null;
        this.f28216c = null;
        this.f28217d = null;
        this.f28218e = null;
        this.f28219f = null;
        this.f28220g = null;
        this.f28221h = null;
        this.f28222i = null;
        this.f28223j = null;
        this.f28224k = null;
        this.f28225l = null;
        this.f28226m = null;
        this.f28227n = null;
        this.f28228o = null;
        this.f28229p = null;
        this.f28230q = null;
        this.Y = null;
        this.Z = -1;
    }

    /* renamed from: b */
    public static aoa[] m36877b() {
        if (f28214a == null) {
            synchronized (afm.f14429b) {
                if (f28214a == null) {
                    f28214a = new aoa[0];
                }
            }
        }
        return f28214a;
    }

    /* renamed from: a */
    protected final int mo3803a() {
        int a = super.mo3803a();
        if (this.f28215b != null) {
            a += afg.m18351b(5, this.f28215b);
        }
        if (this.f28216c != null) {
            a += afg.m18351b(6, this.f28216c);
        }
        if (this.f28217d != null) {
            a += afg.m18351b(7, this.f28217d);
        }
        if (this.f28218e != null) {
            a += afg.m18351b(8, this.f28218e);
        }
        if (this.f28219f != null) {
            a += afg.m18351b(9, this.f28219f);
        }
        if (this.f28220g != null) {
            a += afg.m18351b(10, this.f28220g);
        }
        if (this.f28221h != null) {
            a += afg.m18351b(11, this.f28221h);
        }
        if (this.f28222i != null) {
            a += afg.m18350b(12, this.f28222i.intValue());
        }
        if (this.f28223j != null) {
            a += afg.m18350b(13, this.f28223j.intValue());
        }
        if (this.f28224k != null) {
            a += afg.m18351b(14, this.f28224k);
        }
        if (this.f28225l != null) {
            a += afg.m18350b(15, this.f28225l.intValue());
        }
        if (this.f28226m != null) {
            a += afg.m18350b(16, this.f28226m.intValue());
        }
        if (this.f28227n != null) {
            a += afg.m18350b(17, this.f28227n.intValue());
        }
        if (this.f28228o != null) {
            a += afg.m18350b(18, this.f28228o.intValue());
        }
        if (this.f28229p != null) {
            a += afg.m18350b(19, this.f28229p.intValue());
        }
        return this.f28230q != null ? a + afg.m18356c(20, this.f28230q.longValue()) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ afo mo6026a(afe afe) {
        while (true) {
            afo afo;
            int a = afe.m18324a();
            switch (a) {
                case 0:
                    return this;
                case 42:
                    if (this.f28215b == null) {
                        this.f28215b = new aoe();
                    }
                    afo = this.f28215b;
                    break;
                case 50:
                    if (this.f28216c == null) {
                        this.f28216c = new aoh();
                    }
                    afo = this.f28216c;
                    break;
                case 58:
                    if (this.f28217d == null) {
                        this.f28217d = new aoi();
                    }
                    afo = this.f28217d;
                    break;
                case 66:
                    if (this.f28218e == null) {
                        this.f28218e = new aoj();
                    }
                    afo = this.f28218e;
                    break;
                case 74:
                    if (this.f28219f == null) {
                        this.f28219f = new aob();
                    }
                    afo = this.f28219f;
                    break;
                case 82:
                    if (this.f28220g == null) {
                        this.f28220g = new aof();
                    }
                    afo = this.f28220g;
                    break;
                case 90:
                    if (this.f28221h == null) {
                        this.f28221h = new aod();
                    }
                    afo = this.f28221h;
                    break;
                case 96:
                    this.f28222i = Integer.valueOf(afe.m18338g());
                    continue;
                case 104:
                    this.f28223j = Integer.valueOf(afe.m18338g());
                    continue;
                case 114:
                    if (this.f28224k == null) {
                        this.f28224k = new any();
                    }
                    afo = this.f28224k;
                    break;
                case 120:
                    this.f28225l = Integer.valueOf(afe.m18338g());
                    continue;
                case 128:
                    this.f28226m = Integer.valueOf(afe.m18338g());
                    continue;
                case 136:
                    this.f28227n = Integer.valueOf(afe.m18338g());
                    continue;
                case 144:
                    this.f28228o = Integer.valueOf(afe.m18338g());
                    continue;
                case 152:
                    this.f28229p = Integer.valueOf(afe.m18338g());
                    continue;
                case 160:
                    this.f28230q = Long.valueOf(afe.m18339h());
                    continue;
                default:
                    if (!super.m29903a(afe, a)) {
                        return this;
                    }
                    continue;
            }
            afe.m18326a(afo);
        }
    }

    /* renamed from: a */
    public final void mo3804a(afg afg) {
        if (this.f28215b != null) {
            afg.m18363a(5, this.f28215b);
        }
        if (this.f28216c != null) {
            afg.m18363a(6, this.f28216c);
        }
        if (this.f28217d != null) {
            afg.m18363a(7, this.f28217d);
        }
        if (this.f28218e != null) {
            afg.m18363a(8, this.f28218e);
        }
        if (this.f28219f != null) {
            afg.m18363a(9, this.f28219f);
        }
        if (this.f28220g != null) {
            afg.m18363a(10, this.f28220g);
        }
        if (this.f28221h != null) {
            afg.m18363a(11, this.f28221h);
        }
        if (this.f28222i != null) {
            afg.m18361a(12, this.f28222i.intValue());
        }
        if (this.f28223j != null) {
            afg.m18361a(13, this.f28223j.intValue());
        }
        if (this.f28224k != null) {
            afg.m18363a(14, this.f28224k);
        }
        if (this.f28225l != null) {
            afg.m18361a(15, this.f28225l.intValue());
        }
        if (this.f28226m != null) {
            afg.m18361a(16, this.f28226m.intValue());
        }
        if (this.f28227n != null) {
            afg.m18361a(17, this.f28227n.intValue());
        }
        if (this.f28228o != null) {
            afg.m18361a(18, this.f28228o.intValue());
        }
        if (this.f28229p != null) {
            afg.m18361a(19, this.f28229p.intValue());
        }
        if (this.f28230q != null) {
            afg.m18362a(20, this.f28230q.longValue());
        }
        super.mo3804a(afg);
    }
}
