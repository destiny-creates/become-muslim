package com.google.android.gms.internal.p213l;

import com.facebook.imageutils.JfifUtil;
import com.facebook.imageutils.TiffUtil;

/* renamed from: com.google.android.gms.internal.l.gn */
public final class gn extends C6823d<gn> {
    /* renamed from: K */
    private static volatile gn[] f29054K;
    /* renamed from: A */
    public String f29055A;
    /* renamed from: B */
    public Boolean f29056B;
    /* renamed from: C */
    public gi[] f29057C;
    /* renamed from: D */
    public String f29058D;
    /* renamed from: E */
    public Integer f29059E;
    /* renamed from: F */
    public String f29060F;
    /* renamed from: G */
    public Long f29061G;
    /* renamed from: H */
    public Long f29062H;
    /* renamed from: I */
    public String f29063I;
    /* renamed from: J */
    public Integer f29064J;
    /* renamed from: L */
    private Integer f29065L;
    /* renamed from: M */
    private Integer f29066M;
    /* renamed from: N */
    private String f29067N;
    /* renamed from: O */
    private String f29068O;
    /* renamed from: c */
    public Integer f29069c;
    /* renamed from: d */
    public gk[] f29070d;
    /* renamed from: e */
    public gq[] f29071e;
    /* renamed from: f */
    public Long f29072f;
    /* renamed from: g */
    public Long f29073g;
    /* renamed from: h */
    public Long f29074h;
    /* renamed from: i */
    public Long f29075i;
    /* renamed from: j */
    public Long f29076j;
    /* renamed from: k */
    public String f29077k;
    /* renamed from: l */
    public String f29078l;
    /* renamed from: m */
    public String f29079m;
    /* renamed from: n */
    public String f29080n;
    /* renamed from: o */
    public Integer f29081o;
    /* renamed from: p */
    public String f29082p;
    /* renamed from: q */
    public String f29083q;
    /* renamed from: r */
    public String f29084r;
    /* renamed from: s */
    public Long f29085s;
    /* renamed from: t */
    public Long f29086t;
    /* renamed from: u */
    public String f29087u;
    /* renamed from: v */
    public Boolean f29088v;
    /* renamed from: w */
    public String f29089w;
    /* renamed from: x */
    public Long f29090x;
    /* renamed from: y */
    public Integer f29091y;
    /* renamed from: z */
    public String f29092z;

    public gn() {
        this.f29069c = null;
        this.f29070d = gk.m38149e();
        this.f29071e = gq.m38171e();
        this.f29072f = null;
        this.f29073g = null;
        this.f29074h = null;
        this.f29075i = null;
        this.f29076j = null;
        this.f29077k = null;
        this.f29078l = null;
        this.f29079m = null;
        this.f29080n = null;
        this.f29081o = null;
        this.f29082p = null;
        this.f29083q = null;
        this.f29084r = null;
        this.f29085s = null;
        this.f29086t = null;
        this.f29087u = null;
        this.f29088v = null;
        this.f29089w = null;
        this.f29090x = null;
        this.f29091y = null;
        this.f29092z = null;
        this.f29055A = null;
        this.f29056B = null;
        this.f29057C = gi.m38141e();
        this.f29058D = null;
        this.f29059E = null;
        this.f29065L = null;
        this.f29066M = null;
        this.f29060F = null;
        this.f29061G = null;
        this.f29062H = null;
        this.f29063I = null;
        this.f29067N = null;
        this.f29064J = null;
        this.f29068O = null;
        this.a = null;
        this.b = -1;
    }

    /* renamed from: e */
    public static gn[] m38160e() {
        if (f29054K == null) {
            synchronized (C5041h.f17265b) {
                if (f29054K == null) {
                    f29054K = new gn[0];
                }
            }
        }
        return f29054K;
    }

    /* renamed from: a */
    protected final int mo4756a() {
        int i;
        int a = super.mo4756a();
        if (this.f29069c != null) {
            a += C5035b.m21287b(1, this.f29069c.intValue());
        }
        if (this.f29070d != null && this.f29070d.length > 0) {
            i = a;
            for (C5043j c5043j : this.f29070d) {
                if (c5043j != null) {
                    i += C5035b.m21288b(2, c5043j);
                }
            }
            a = i;
        }
        if (this.f29071e != null && this.f29071e.length > 0) {
            i = a;
            for (C5043j c5043j2 : this.f29071e) {
                if (c5043j2 != null) {
                    i += C5035b.m21288b(3, c5043j2);
                }
            }
            a = i;
        }
        if (this.f29072f != null) {
            a += C5035b.m21291c(4, this.f29072f.longValue());
        }
        if (this.f29073g != null) {
            a += C5035b.m21291c(5, this.f29073g.longValue());
        }
        if (this.f29074h != null) {
            a += C5035b.m21291c(6, this.f29074h.longValue());
        }
        if (this.f29076j != null) {
            a += C5035b.m21291c(7, this.f29076j.longValue());
        }
        if (this.f29077k != null) {
            a += C5035b.m21289b(8, this.f29077k);
        }
        if (this.f29078l != null) {
            a += C5035b.m21289b(9, this.f29078l);
        }
        if (this.f29079m != null) {
            a += C5035b.m21289b(10, this.f29079m);
        }
        if (this.f29080n != null) {
            a += C5035b.m21289b(11, this.f29080n);
        }
        if (this.f29081o != null) {
            a += C5035b.m21287b(12, this.f29081o.intValue());
        }
        if (this.f29082p != null) {
            a += C5035b.m21289b(13, this.f29082p);
        }
        if (this.f29083q != null) {
            a += C5035b.m21289b(14, this.f29083q);
        }
        if (this.f29084r != null) {
            a += C5035b.m21289b(16, this.f29084r);
        }
        if (this.f29085s != null) {
            a += C5035b.m21291c(17, this.f29085s.longValue());
        }
        if (this.f29086t != null) {
            a += C5035b.m21291c(18, this.f29086t.longValue());
        }
        if (this.f29087u != null) {
            a += C5035b.m21289b(19, this.f29087u);
        }
        if (this.f29088v != null) {
            this.f29088v.booleanValue();
            a += C5035b.m21286b(20) + 1;
        }
        if (this.f29089w != null) {
            a += C5035b.m21289b(21, this.f29089w);
        }
        if (this.f29090x != null) {
            a += C5035b.m21291c(22, this.f29090x.longValue());
        }
        if (this.f29091y != null) {
            a += C5035b.m21287b(23, this.f29091y.intValue());
        }
        if (this.f29092z != null) {
            a += C5035b.m21289b(24, this.f29092z);
        }
        if (this.f29055A != null) {
            a += C5035b.m21289b(25, this.f29055A);
        }
        if (this.f29075i != null) {
            a += C5035b.m21291c(26, this.f29075i.longValue());
        }
        if (this.f29056B != null) {
            this.f29056B.booleanValue();
            a += C5035b.m21286b(28) + 1;
        }
        if (this.f29057C != null && this.f29057C.length > 0) {
            for (C5043j c5043j3 : this.f29057C) {
                if (c5043j3 != null) {
                    a += C5035b.m21288b(29, c5043j3);
                }
            }
        }
        if (this.f29058D != null) {
            a += C5035b.m21289b(30, this.f29058D);
        }
        if (this.f29059E != null) {
            a += C5035b.m21287b(31, this.f29059E.intValue());
        }
        if (this.f29065L != null) {
            a += C5035b.m21287b(32, this.f29065L.intValue());
        }
        if (this.f29066M != null) {
            a += C5035b.m21287b(33, this.f29066M.intValue());
        }
        if (this.f29060F != null) {
            a += C5035b.m21289b(34, this.f29060F);
        }
        if (this.f29061G != null) {
            a += C5035b.m21291c(35, this.f29061G.longValue());
        }
        if (this.f29062H != null) {
            a += C5035b.m21291c(36, this.f29062H.longValue());
        }
        if (this.f29063I != null) {
            a += C5035b.m21289b(37, this.f29063I);
        }
        if (this.f29067N != null) {
            a += C5035b.m21289b(38, this.f29067N);
        }
        if (this.f29064J != null) {
            a += C5035b.m21287b(39, this.f29064J.intValue());
        }
        return this.f29068O != null ? a + C5035b.m21289b(41, this.f29068O) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ C5043j mo6216a(C5033a c5033a) {
        while (true) {
            int a = c5033a.m21214a();
            int length;
            Object obj;
            switch (a) {
                case 0:
                    return this;
                case 8:
                    this.f29069c = Integer.valueOf(c5033a.m21224d());
                    break;
                case 18:
                    a = C5046m.m21448a(c5033a, 18);
                    length = this.f29070d == null ? 0 : this.f29070d.length;
                    obj = new gk[(a + length)];
                    if (length != 0) {
                        System.arraycopy(this.f29070d, 0, obj, 0, length);
                    }
                    while (length < obj.length - 1) {
                        obj[length] = new gk();
                        c5033a.m21216a(obj[length]);
                        c5033a.m21214a();
                        length++;
                    }
                    obj[length] = new gk();
                    c5033a.m21216a(obj[length]);
                    this.f29070d = obj;
                    break;
                case 26:
                    a = C5046m.m21448a(c5033a, 26);
                    length = this.f29071e == null ? 0 : this.f29071e.length;
                    obj = new gq[(a + length)];
                    if (length != 0) {
                        System.arraycopy(this.f29071e, 0, obj, 0, length);
                    }
                    while (length < obj.length - 1) {
                        obj[length] = new gq();
                        c5033a.m21216a(obj[length]);
                        c5033a.m21214a();
                        length++;
                    }
                    obj[length] = new gq();
                    c5033a.m21216a(obj[length]);
                    this.f29071e = obj;
                    break;
                case 32:
                    this.f29072f = Long.valueOf(c5033a.m21226e());
                    break;
                case 40:
                    this.f29073g = Long.valueOf(c5033a.m21226e());
                    break;
                case 48:
                    this.f29074h = Long.valueOf(c5033a.m21226e());
                    break;
                case 56:
                    this.f29076j = Long.valueOf(c5033a.m21226e());
                    break;
                case 66:
                    this.f29077k = c5033a.m21223c();
                    break;
                case 74:
                    this.f29078l = c5033a.m21223c();
                    break;
                case 82:
                    this.f29079m = c5033a.m21223c();
                    break;
                case 90:
                    this.f29080n = c5033a.m21223c();
                    break;
                case 96:
                    this.f29081o = Integer.valueOf(c5033a.m21224d());
                    break;
                case 106:
                    this.f29082p = c5033a.m21223c();
                    break;
                case 114:
                    this.f29083q = c5033a.m21223c();
                    break;
                case 130:
                    this.f29084r = c5033a.m21223c();
                    break;
                case 136:
                    this.f29085s = Long.valueOf(c5033a.m21226e());
                    break;
                case 144:
                    this.f29086t = Long.valueOf(c5033a.m21226e());
                    break;
                case 154:
                    this.f29087u = c5033a.m21223c();
                    break;
                case 160:
                    this.f29088v = Boolean.valueOf(c5033a.m21220b());
                    break;
                case 170:
                    this.f29089w = c5033a.m21223c();
                    break;
                case 176:
                    this.f29090x = Long.valueOf(c5033a.m21226e());
                    break;
                case 184:
                    this.f29091y = Integer.valueOf(c5033a.m21224d());
                    break;
                case 194:
                    this.f29092z = c5033a.m21223c();
                    break;
                case 202:
                    this.f29055A = c5033a.m21223c();
                    break;
                case JfifUtil.MARKER_RST0 /*208*/:
                    this.f29075i = Long.valueOf(c5033a.m21226e());
                    break;
                case 224:
                    this.f29056B = Boolean.valueOf(c5033a.m21220b());
                    break;
                case 234:
                    a = C5046m.m21448a(c5033a, 234);
                    length = this.f29057C == null ? 0 : this.f29057C.length;
                    obj = new gi[(a + length)];
                    if (length != 0) {
                        System.arraycopy(this.f29057C, 0, obj, 0, length);
                    }
                    while (length < obj.length - 1) {
                        obj[length] = new gi();
                        c5033a.m21216a(obj[length]);
                        c5033a.m21214a();
                        length++;
                    }
                    obj[length] = new gi();
                    c5033a.m21216a(obj[length]);
                    this.f29057C = obj;
                    break;
                case 242:
                    this.f29058D = c5033a.m21223c();
                    break;
                case 248:
                    this.f29059E = Integer.valueOf(c5033a.m21224d());
                    break;
                case 256:
                    this.f29065L = Integer.valueOf(c5033a.m21224d());
                    break;
                case 264:
                    this.f29066M = Integer.valueOf(c5033a.m21224d());
                    break;
                case TiffUtil.TIFF_TAG_ORIENTATION /*274*/:
                    this.f29060F = c5033a.m21223c();
                    break;
                case 280:
                    this.f29061G = Long.valueOf(c5033a.m21226e());
                    break;
                case 288:
                    this.f29062H = Long.valueOf(c5033a.m21226e());
                    break;
                case 298:
                    this.f29063I = c5033a.m21223c();
                    break;
                case 306:
                    this.f29067N = c5033a.m21223c();
                    break;
                case 312:
                    this.f29064J = Integer.valueOf(c5033a.m21224d());
                    break;
                case 330:
                    this.f29068O = c5033a.m21223c();
                    break;
                default:
                    if (super.m31987a(c5033a, a)) {
                        break;
                    }
                    return this;
            }
        }
    }

    /* renamed from: a */
    public final void mo4757a(C5035b c5035b) {
        if (this.f29069c != null) {
            c5035b.m21297a(1, this.f29069c.intValue());
        }
        if (this.f29070d != null && this.f29070d.length > 0) {
            for (C5043j c5043j : this.f29070d) {
                if (c5043j != null) {
                    c5035b.m21299a(2, c5043j);
                }
            }
        }
        if (this.f29071e != null && this.f29071e.length > 0) {
            for (C5043j c5043j2 : this.f29071e) {
                if (c5043j2 != null) {
                    c5035b.m21299a(3, c5043j2);
                }
            }
        }
        if (this.f29072f != null) {
            c5035b.m21303b(4, this.f29072f.longValue());
        }
        if (this.f29073g != null) {
            c5035b.m21303b(5, this.f29073g.longValue());
        }
        if (this.f29074h != null) {
            c5035b.m21303b(6, this.f29074h.longValue());
        }
        if (this.f29076j != null) {
            c5035b.m21303b(7, this.f29076j.longValue());
        }
        if (this.f29077k != null) {
            c5035b.m21300a(8, this.f29077k);
        }
        if (this.f29078l != null) {
            c5035b.m21300a(9, this.f29078l);
        }
        if (this.f29079m != null) {
            c5035b.m21300a(10, this.f29079m);
        }
        if (this.f29080n != null) {
            c5035b.m21300a(11, this.f29080n);
        }
        if (this.f29081o != null) {
            c5035b.m21297a(12, this.f29081o.intValue());
        }
        if (this.f29082p != null) {
            c5035b.m21300a(13, this.f29082p);
        }
        if (this.f29083q != null) {
            c5035b.m21300a(14, this.f29083q);
        }
        if (this.f29084r != null) {
            c5035b.m21300a(16, this.f29084r);
        }
        if (this.f29085s != null) {
            c5035b.m21303b(17, this.f29085s.longValue());
        }
        if (this.f29086t != null) {
            c5035b.m21303b(18, this.f29086t.longValue());
        }
        if (this.f29087u != null) {
            c5035b.m21300a(19, this.f29087u);
        }
        if (this.f29088v != null) {
            c5035b.m21301a(20, this.f29088v.booleanValue());
        }
        if (this.f29089w != null) {
            c5035b.m21300a(21, this.f29089w);
        }
        if (this.f29090x != null) {
            c5035b.m21303b(22, this.f29090x.longValue());
        }
        if (this.f29091y != null) {
            c5035b.m21297a(23, this.f29091y.intValue());
        }
        if (this.f29092z != null) {
            c5035b.m21300a(24, this.f29092z);
        }
        if (this.f29055A != null) {
            c5035b.m21300a(25, this.f29055A);
        }
        if (this.f29075i != null) {
            c5035b.m21303b(26, this.f29075i.longValue());
        }
        if (this.f29056B != null) {
            c5035b.m21301a(28, this.f29056B.booleanValue());
        }
        if (this.f29057C != null && this.f29057C.length > 0) {
            for (C5043j c5043j3 : this.f29057C) {
                if (c5043j3 != null) {
                    c5035b.m21299a(29, c5043j3);
                }
            }
        }
        if (this.f29058D != null) {
            c5035b.m21300a(30, this.f29058D);
        }
        if (this.f29059E != null) {
            c5035b.m21297a(31, this.f29059E.intValue());
        }
        if (this.f29065L != null) {
            c5035b.m21297a(32, this.f29065L.intValue());
        }
        if (this.f29066M != null) {
            c5035b.m21297a(33, this.f29066M.intValue());
        }
        if (this.f29060F != null) {
            c5035b.m21300a(34, this.f29060F);
        }
        if (this.f29061G != null) {
            c5035b.m21303b(35, this.f29061G.longValue());
        }
        if (this.f29062H != null) {
            c5035b.m21303b(36, this.f29062H.longValue());
        }
        if (this.f29063I != null) {
            c5035b.m21300a(37, this.f29063I);
        }
        if (this.f29067N != null) {
            c5035b.m21300a(38, this.f29067N);
        }
        if (this.f29064J != null) {
            c5035b.m21297a(39, this.f29064J.intValue());
        }
        if (this.f29068O != null) {
            c5035b.m21300a(41, this.f29068O);
        }
        super.mo4757a(c5035b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof gn)) {
            return false;
        }
        gn gnVar = (gn) obj;
        if (this.f29069c == null) {
            if (gnVar.f29069c != null) {
                return false;
            }
        } else if (!this.f29069c.equals(gnVar.f29069c)) {
            return false;
        }
        if (!C5041h.m21398a(this.f29070d, gnVar.f29070d) || !C5041h.m21398a(this.f29071e, gnVar.f29071e)) {
            return false;
        }
        if (this.f29072f == null) {
            if (gnVar.f29072f != null) {
                return false;
            }
        } else if (!this.f29072f.equals(gnVar.f29072f)) {
            return false;
        }
        if (this.f29073g == null) {
            if (gnVar.f29073g != null) {
                return false;
            }
        } else if (!this.f29073g.equals(gnVar.f29073g)) {
            return false;
        }
        if (this.f29074h == null) {
            if (gnVar.f29074h != null) {
                return false;
            }
        } else if (!this.f29074h.equals(gnVar.f29074h)) {
            return false;
        }
        if (this.f29075i == null) {
            if (gnVar.f29075i != null) {
                return false;
            }
        } else if (!this.f29075i.equals(gnVar.f29075i)) {
            return false;
        }
        if (this.f29076j == null) {
            if (gnVar.f29076j != null) {
                return false;
            }
        } else if (!this.f29076j.equals(gnVar.f29076j)) {
            return false;
        }
        if (this.f29077k == null) {
            if (gnVar.f29077k != null) {
                return false;
            }
        } else if (!this.f29077k.equals(gnVar.f29077k)) {
            return false;
        }
        if (this.f29078l == null) {
            if (gnVar.f29078l != null) {
                return false;
            }
        } else if (!this.f29078l.equals(gnVar.f29078l)) {
            return false;
        }
        if (this.f29079m == null) {
            if (gnVar.f29079m != null) {
                return false;
            }
        } else if (!this.f29079m.equals(gnVar.f29079m)) {
            return false;
        }
        if (this.f29080n == null) {
            if (gnVar.f29080n != null) {
                return false;
            }
        } else if (!this.f29080n.equals(gnVar.f29080n)) {
            return false;
        }
        if (this.f29081o == null) {
            if (gnVar.f29081o != null) {
                return false;
            }
        } else if (!this.f29081o.equals(gnVar.f29081o)) {
            return false;
        }
        if (this.f29082p == null) {
            if (gnVar.f29082p != null) {
                return false;
            }
        } else if (!this.f29082p.equals(gnVar.f29082p)) {
            return false;
        }
        if (this.f29083q == null) {
            if (gnVar.f29083q != null) {
                return false;
            }
        } else if (!this.f29083q.equals(gnVar.f29083q)) {
            return false;
        }
        if (this.f29084r == null) {
            if (gnVar.f29084r != null) {
                return false;
            }
        } else if (!this.f29084r.equals(gnVar.f29084r)) {
            return false;
        }
        if (this.f29085s == null) {
            if (gnVar.f29085s != null) {
                return false;
            }
        } else if (!this.f29085s.equals(gnVar.f29085s)) {
            return false;
        }
        if (this.f29086t == null) {
            if (gnVar.f29086t != null) {
                return false;
            }
        } else if (!this.f29086t.equals(gnVar.f29086t)) {
            return false;
        }
        if (this.f29087u == null) {
            if (gnVar.f29087u != null) {
                return false;
            }
        } else if (!this.f29087u.equals(gnVar.f29087u)) {
            return false;
        }
        if (this.f29088v == null) {
            if (gnVar.f29088v != null) {
                return false;
            }
        } else if (!this.f29088v.equals(gnVar.f29088v)) {
            return false;
        }
        if (this.f29089w == null) {
            if (gnVar.f29089w != null) {
                return false;
            }
        } else if (!this.f29089w.equals(gnVar.f29089w)) {
            return false;
        }
        if (this.f29090x == null) {
            if (gnVar.f29090x != null) {
                return false;
            }
        } else if (!this.f29090x.equals(gnVar.f29090x)) {
            return false;
        }
        if (this.f29091y == null) {
            if (gnVar.f29091y != null) {
                return false;
            }
        } else if (!this.f29091y.equals(gnVar.f29091y)) {
            return false;
        }
        if (this.f29092z == null) {
            if (gnVar.f29092z != null) {
                return false;
            }
        } else if (!this.f29092z.equals(gnVar.f29092z)) {
            return false;
        }
        if (this.f29055A == null) {
            if (gnVar.f29055A != null) {
                return false;
            }
        } else if (!this.f29055A.equals(gnVar.f29055A)) {
            return false;
        }
        if (this.f29056B == null) {
            if (gnVar.f29056B != null) {
                return false;
            }
        } else if (!this.f29056B.equals(gnVar.f29056B)) {
            return false;
        }
        if (!C5041h.m21398a(this.f29057C, gnVar.f29057C)) {
            return false;
        }
        if (this.f29058D == null) {
            if (gnVar.f29058D != null) {
                return false;
            }
        } else if (!this.f29058D.equals(gnVar.f29058D)) {
            return false;
        }
        if (this.f29059E == null) {
            if (gnVar.f29059E != null) {
                return false;
            }
        } else if (!this.f29059E.equals(gnVar.f29059E)) {
            return false;
        }
        if (this.f29065L == null) {
            if (gnVar.f29065L != null) {
                return false;
            }
        } else if (!this.f29065L.equals(gnVar.f29065L)) {
            return false;
        }
        if (this.f29066M == null) {
            if (gnVar.f29066M != null) {
                return false;
            }
        } else if (!this.f29066M.equals(gnVar.f29066M)) {
            return false;
        }
        if (this.f29060F == null) {
            if (gnVar.f29060F != null) {
                return false;
            }
        } else if (!this.f29060F.equals(gnVar.f29060F)) {
            return false;
        }
        if (this.f29061G == null) {
            if (gnVar.f29061G != null) {
                return false;
            }
        } else if (!this.f29061G.equals(gnVar.f29061G)) {
            return false;
        }
        if (this.f29062H == null) {
            if (gnVar.f29062H != null) {
                return false;
            }
        } else if (!this.f29062H.equals(gnVar.f29062H)) {
            return false;
        }
        if (this.f29063I == null) {
            if (gnVar.f29063I != null) {
                return false;
            }
        } else if (!this.f29063I.equals(gnVar.f29063I)) {
            return false;
        }
        if (this.f29067N == null) {
            if (gnVar.f29067N != null) {
                return false;
            }
        } else if (!this.f29067N.equals(gnVar.f29067N)) {
            return false;
        }
        if (this.f29064J == null) {
            if (gnVar.f29064J != null) {
                return false;
            }
        } else if (!this.f29064J.equals(gnVar.f29064J)) {
            return false;
        }
        if (this.f29068O == null) {
            if (gnVar.f29068O != null) {
                return false;
            }
        } else if (!this.f29068O.equals(gnVar.f29068O)) {
            return false;
        }
        if (this.a != null) {
            if (!this.a.m21363b()) {
                return this.a.equals(gnVar.a);
            }
        }
        if (gnVar.a != null) {
            if (!gnVar.a.m21363b()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((getClass().getName().hashCode() + 527) * 31) + (this.f29069c == null ? 0 : this.f29069c.hashCode())) * 31) + C5041h.m21395a(this.f29070d)) * 31) + C5041h.m21395a(this.f29071e)) * 31) + (this.f29072f == null ? 0 : this.f29072f.hashCode())) * 31) + (this.f29073g == null ? 0 : this.f29073g.hashCode())) * 31) + (this.f29074h == null ? 0 : this.f29074h.hashCode())) * 31) + (this.f29075i == null ? 0 : this.f29075i.hashCode())) * 31) + (this.f29076j == null ? 0 : this.f29076j.hashCode())) * 31) + (this.f29077k == null ? 0 : this.f29077k.hashCode())) * 31) + (this.f29078l == null ? 0 : this.f29078l.hashCode())) * 31) + (this.f29079m == null ? 0 : this.f29079m.hashCode())) * 31) + (this.f29080n == null ? 0 : this.f29080n.hashCode())) * 31) + (this.f29081o == null ? 0 : this.f29081o.hashCode())) * 31) + (this.f29082p == null ? 0 : this.f29082p.hashCode())) * 31) + (this.f29083q == null ? 0 : this.f29083q.hashCode())) * 31) + (this.f29084r == null ? 0 : this.f29084r.hashCode())) * 31) + (this.f29085s == null ? 0 : this.f29085s.hashCode())) * 31) + (this.f29086t == null ? 0 : this.f29086t.hashCode())) * 31) + (this.f29087u == null ? 0 : this.f29087u.hashCode())) * 31) + (this.f29088v == null ? 0 : this.f29088v.hashCode())) * 31) + (this.f29089w == null ? 0 : this.f29089w.hashCode())) * 31) + (this.f29090x == null ? 0 : this.f29090x.hashCode())) * 31) + (this.f29091y == null ? 0 : this.f29091y.hashCode())) * 31) + (this.f29092z == null ? 0 : this.f29092z.hashCode())) * 31) + (this.f29055A == null ? 0 : this.f29055A.hashCode())) * 31) + (this.f29056B == null ? 0 : this.f29056B.hashCode())) * 31) + C5041h.m21395a(this.f29057C)) * 31) + (this.f29058D == null ? 0 : this.f29058D.hashCode())) * 31) + (this.f29059E == null ? 0 : this.f29059E.hashCode())) * 31) + (this.f29065L == null ? 0 : this.f29065L.hashCode())) * 31) + (this.f29066M == null ? 0 : this.f29066M.hashCode())) * 31) + (this.f29060F == null ? 0 : this.f29060F.hashCode())) * 31) + (this.f29061G == null ? 0 : this.f29061G.hashCode())) * 31) + (this.f29062H == null ? 0 : this.f29062H.hashCode())) * 31) + (this.f29063I == null ? 0 : this.f29063I.hashCode())) * 31) + (this.f29067N == null ? 0 : this.f29067N.hashCode())) * 31) + (this.f29064J == null ? 0 : this.f29064J.hashCode())) * 31) + (this.f29068O == null ? 0 : this.f29068O.hashCode())) * 31;
        if (this.a != null) {
            if (!this.a.m21363b()) {
                i = this.a.hashCode();
            }
        }
        return hashCode + i;
    }
}
