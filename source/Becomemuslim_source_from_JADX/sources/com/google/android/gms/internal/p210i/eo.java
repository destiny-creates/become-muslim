package com.google.android.gms.internal.p210i;

import java.util.List;

/* renamed from: com.google.android.gms.internal.i.eo */
final class eo implements hh {
    /* renamed from: a */
    private final el f24481a;
    /* renamed from: b */
    private int f24482b;
    /* renamed from: c */
    private int f24483c;
    /* renamed from: d */
    private int f24484d = 0;

    /* renamed from: a */
    public static eo m31383a(el elVar) {
        if (elVar.f16521c != null) {
            return elVar.f16521c;
        }
        return new eo(elVar);
    }

    private eo(el elVar) {
        this.f24481a = (el) fm.m20558a((Object) elVar, "input");
        this.f24481a.f16521c = this;
    }

    /* renamed from: a */
    public final int mo4459a() {
        if (this.f24484d != 0) {
            this.f24482b = this.f24484d;
            this.f24484d = 0;
        } else {
            this.f24482b = this.f24481a.mo4432a();
        }
        if (this.f24482b != 0) {
            if (this.f24482b != this.f24483c) {
                return this.f24482b >>> 3;
            }
        }
        return Integer.MAX_VALUE;
    }

    /* renamed from: b */
    public final int mo4464b() {
        return this.f24482b;
    }

    /* renamed from: c */
    public final boolean mo4469c() {
        if (!this.f24481a.mo4457t()) {
            if (this.f24482b != this.f24483c) {
                return this.f24481a.mo4436b(this.f24482b);
            }
        }
        return false;
    }

    /* renamed from: a */
    private final void m31385a(int i) {
        if ((this.f24482b & 7) != i) {
            throw fs.m20572e();
        }
    }

    /* renamed from: d */
    public final double mo4470d() {
        m31385a(1);
        return this.f24481a.mo4435b();
    }

    /* renamed from: e */
    public final float mo4472e() {
        m31385a(5);
        return this.f24481a.mo4437c();
    }

    /* renamed from: f */
    public final long mo4474f() {
        m31385a(0);
        return this.f24481a.mo4439d();
    }

    /* renamed from: g */
    public final long mo4476g() {
        m31385a(0);
        return this.f24481a.mo4440e();
    }

    /* renamed from: h */
    public final int mo4478h() {
        m31385a(0);
        return this.f24481a.mo4442f();
    }

    /* renamed from: i */
    public final long mo4480i() {
        m31385a(1);
        return this.f24481a.mo4444g();
    }

    /* renamed from: j */
    public final int mo4482j() {
        m31385a(5);
        return this.f24481a.mo4445h();
    }

    /* renamed from: k */
    public final boolean mo4485k() {
        m31385a(0);
        return this.f24481a.mo4446i();
    }

    /* renamed from: l */
    public final String mo4486l() {
        m31385a(2);
        return this.f24481a.mo4447j();
    }

    /* renamed from: m */
    public final String mo4488m() {
        m31385a(2);
        return this.f24481a.mo4448k();
    }

    /* renamed from: a */
    public final <T> T mo4460a(hi<T> hiVar, ew ewVar) {
        m31385a(2);
        return m31388c(hiVar, ewVar);
    }

    /* renamed from: b */
    public final <T> T mo4465b(hi<T> hiVar, ew ewVar) {
        m31385a(3);
        return m31390d(hiVar, ewVar);
    }

    /* renamed from: c */
    private final <T> T m31388c(hi<T> hiVar, ew ewVar) {
        int m = this.f24481a.mo4450m();
        if (this.f24481a.f16519a < this.f24481a.f16520b) {
            m = this.f24481a.mo4438d(m);
            T a = hiVar.mo4569a();
            el elVar = this.f24481a;
            elVar.f16519a++;
            hiVar.mo4570a(a, this, ewVar);
            hiVar.mo4575c(a);
            this.f24481a.mo4434a(null);
            hiVar = this.f24481a;
            hiVar.f16519a--;
            this.f24481a.mo4441e(m);
            return a;
        }
        throw fs.m20573f();
    }

    /* renamed from: d */
    private final <T> T m31390d(hi<T> hiVar, ew ewVar) {
        int i = this.f24483c;
        T t = ((this.f24482b >>> 3) << 3) | 4;
        this.f24483c = t;
        try {
            t = hiVar.mo4569a();
            hiVar.mo4570a(t, this, ewVar);
            hiVar.mo4575c(t);
            if (this.f24482b == this.f24483c) {
                return t;
            }
            throw fs.m20574g();
        } finally {
            this.f24483c = i;
        }
    }

    /* renamed from: n */
    public final dy mo4490n() {
        m31385a(2);
        return this.f24481a.mo4449l();
    }

    /* renamed from: o */
    public final int mo4492o() {
        m31385a(0);
        return this.f24481a.mo4450m();
    }

    /* renamed from: p */
    public final int mo4494p() {
        m31385a(0);
        return this.f24481a.mo4451n();
    }

    /* renamed from: q */
    public final int mo4496q() {
        m31385a(5);
        return this.f24481a.mo4452o();
    }

    /* renamed from: r */
    public final long mo4498r() {
        m31385a(1);
        return this.f24481a.mo4453p();
    }

    /* renamed from: s */
    public final int mo4499s() {
        m31385a(0);
        return this.f24481a.mo4454q();
    }

    /* renamed from: t */
    public final long mo4500t() {
        m31385a(0);
        return this.f24481a.mo4455r();
    }

    /* renamed from: a */
    public final void mo4461a(List<Double> list) {
        int m;
        int u;
        if (list instanceof et) {
            et etVar = (et) list;
            switch (this.f24482b & 7) {
                case 1:
                    break;
                case 2:
                    m = this.f24481a.mo4450m();
                    eo.m31387b(m);
                    u = this.f24481a.mo4458u() + m;
                    do {
                        etVar.m37932a(this.f24481a.mo4435b());
                    } while (this.f24481a.mo4458u() < u);
                    return;
                default:
                    throw fs.m20572e();
            }
            do {
                etVar.m37932a(this.f24481a.mo4435b());
                if (!this.f24481a.mo4457t()) {
                    m = this.f24481a.mo4432a();
                } else {
                    return;
                }
            } while (m == this.f24482b);
            this.f24484d = m;
            return;
        }
        switch (this.f24482b & 7) {
            case 1:
                break;
            case 2:
                m = this.f24481a.mo4450m();
                eo.m31387b(m);
                u = this.f24481a.mo4458u() + m;
                do {
                    list.add(Double.valueOf(this.f24481a.mo4435b()));
                } while (this.f24481a.mo4458u() < u);
                return;
            default:
                throw fs.m20572e();
        }
        do {
            list.add(Double.valueOf(this.f24481a.mo4435b()));
            if (!this.f24481a.mo4457t()) {
                m = this.f24481a.mo4432a();
            } else {
                return;
            }
        } while (m == this.f24482b);
        this.f24484d = m;
    }

    /* renamed from: b */
    public final void mo4466b(List<Float> list) {
        if (list instanceof fg) {
            fg fgVar = (fg) list;
            list = this.f24482b & 7;
            if (list == 2) {
                int m = this.f24481a.mo4450m();
                eo.m31389c(m);
                int u = this.f24481a.mo4458u() + m;
                do {
                    fgVar.m37951a(this.f24481a.mo4437c());
                } while (this.f24481a.mo4458u() < u);
                return;
            } else if (list == 5) {
                do {
                    fgVar.m37951a(this.f24481a.mo4437c());
                    if (this.f24481a.mo4457t() == null) {
                        list = this.f24481a.mo4432a();
                    } else {
                        return;
                    }
                } while (list == this.f24482b);
                this.f24484d = list;
                return;
            } else {
                throw fs.m20572e();
            }
        }
        int i = this.f24482b & 7;
        if (i == 2) {
            i = this.f24481a.mo4450m();
            eo.m31389c(i);
            int u2 = this.f24481a.mo4458u() + i;
            do {
                list.add(Float.valueOf(this.f24481a.mo4437c()));
            } while (this.f24481a.mo4458u() < u2);
        } else if (i == 5) {
            do {
                list.add(Float.valueOf(this.f24481a.mo4437c()));
                if (!this.f24481a.mo4457t()) {
                    i = this.f24481a.mo4432a();
                } else {
                    return;
                }
            } while (i == this.f24482b);
            this.f24484d = i;
        } else {
            throw fs.m20572e();
        }
    }

    /* renamed from: c */
    public final void mo4468c(List<Long> list) {
        if (list instanceof gg) {
            gg ggVar = (gg) list;
            list = this.f24482b & 7;
            if (list == null) {
                do {
                    ggVar.m37971a(this.f24481a.mo4439d());
                    if (this.f24481a.mo4457t() == null) {
                        list = this.f24481a.mo4432a();
                    } else {
                        return;
                    }
                } while (list == this.f24482b);
                this.f24484d = list;
                return;
            } else if (list == 2) {
                int u;
                u = this.f24481a.mo4458u() + this.f24481a.mo4450m();
                do {
                    ggVar.m37971a(this.f24481a.mo4439d());
                } while (this.f24481a.mo4458u() < u);
                m31391d(u);
                return;
            } else {
                throw fs.m20572e();
            }
        }
        int i = this.f24482b & 7;
        if (i == 0) {
            do {
                list.add(Long.valueOf(this.f24481a.mo4439d()));
                if (!this.f24481a.mo4457t()) {
                    i = this.f24481a.mo4432a();
                } else {
                    return;
                }
            } while (i == this.f24482b);
            this.f24484d = i;
        } else if (i == 2) {
            u = this.f24481a.mo4458u() + this.f24481a.mo4450m();
            do {
                list.add(Long.valueOf(this.f24481a.mo4439d()));
            } while (this.f24481a.mo4458u() < u);
            m31391d(u);
        } else {
            throw fs.m20572e();
        }
    }

    /* renamed from: d */
    public final void mo4471d(List<Long> list) {
        if (list instanceof gg) {
            gg ggVar = (gg) list;
            list = this.f24482b & 7;
            if (list == null) {
                do {
                    ggVar.m37971a(this.f24481a.mo4440e());
                    if (this.f24481a.mo4457t() == null) {
                        list = this.f24481a.mo4432a();
                    } else {
                        return;
                    }
                } while (list == this.f24482b);
                this.f24484d = list;
                return;
            } else if (list == 2) {
                int u;
                u = this.f24481a.mo4458u() + this.f24481a.mo4450m();
                do {
                    ggVar.m37971a(this.f24481a.mo4440e());
                } while (this.f24481a.mo4458u() < u);
                m31391d(u);
                return;
            } else {
                throw fs.m20572e();
            }
        }
        int i = this.f24482b & 7;
        if (i == 0) {
            do {
                list.add(Long.valueOf(this.f24481a.mo4440e()));
                if (!this.f24481a.mo4457t()) {
                    i = this.f24481a.mo4432a();
                } else {
                    return;
                }
            } while (i == this.f24482b);
            this.f24484d = i;
        } else if (i == 2) {
            u = this.f24481a.mo4458u() + this.f24481a.mo4450m();
            do {
                list.add(Long.valueOf(this.f24481a.mo4440e()));
            } while (this.f24481a.mo4458u() < u);
            m31391d(u);
        } else {
            throw fs.m20572e();
        }
    }

    /* renamed from: e */
    public final void mo4473e(List<Integer> list) {
        int u;
        if (list instanceof fl) {
            fl flVar = (fl) list;
            list = this.f24482b & 7;
            if (list == null) {
                do {
                    flVar.m37959c(this.f24481a.mo4442f());
                    if (this.f24481a.mo4457t() == null) {
                        list = this.f24481a.mo4432a();
                    } else {
                        return;
                    }
                } while (list == this.f24482b);
                this.f24484d = list;
                return;
            } else if (list == 2) {
                u = this.f24481a.mo4458u() + this.f24481a.mo4450m();
                do {
                    flVar.m37959c(this.f24481a.mo4442f());
                } while (this.f24481a.mo4458u() < u);
                m31391d(u);
                return;
            } else {
                throw fs.m20572e();
            }
        }
        int i = this.f24482b & 7;
        if (i == 0) {
            do {
                list.add(Integer.valueOf(this.f24481a.mo4442f()));
                if (!this.f24481a.mo4457t()) {
                    i = this.f24481a.mo4432a();
                } else {
                    return;
                }
            } while (i == this.f24482b);
            this.f24484d = i;
        } else if (i == 2) {
            u = this.f24481a.mo4458u() + this.f24481a.mo4450m();
            do {
                list.add(Integer.valueOf(this.f24481a.mo4442f()));
            } while (this.f24481a.mo4458u() < u);
            m31391d(u);
        } else {
            throw fs.m20572e();
        }
    }

    /* renamed from: f */
    public final void mo4475f(List<Long> list) {
        int m;
        int u;
        if (list instanceof gg) {
            gg ggVar = (gg) list;
            switch (this.f24482b & 7) {
                case 1:
                    break;
                case 2:
                    m = this.f24481a.mo4450m();
                    eo.m31387b(m);
                    u = this.f24481a.mo4458u() + m;
                    do {
                        ggVar.m37971a(this.f24481a.mo4444g());
                    } while (this.f24481a.mo4458u() < u);
                    return;
                default:
                    throw fs.m20572e();
            }
            do {
                ggVar.m37971a(this.f24481a.mo4444g());
                if (!this.f24481a.mo4457t()) {
                    m = this.f24481a.mo4432a();
                } else {
                    return;
                }
            } while (m == this.f24482b);
            this.f24484d = m;
            return;
        }
        switch (this.f24482b & 7) {
            case 1:
                break;
            case 2:
                m = this.f24481a.mo4450m();
                eo.m31387b(m);
                u = this.f24481a.mo4458u() + m;
                do {
                    list.add(Long.valueOf(this.f24481a.mo4444g()));
                } while (this.f24481a.mo4458u() < u);
                return;
            default:
                throw fs.m20572e();
        }
        do {
            list.add(Long.valueOf(this.f24481a.mo4444g()));
            if (!this.f24481a.mo4457t()) {
                m = this.f24481a.mo4432a();
            } else {
                return;
            }
        } while (m == this.f24482b);
        this.f24484d = m;
    }

    /* renamed from: g */
    public final void mo4477g(List<Integer> list) {
        if (list instanceof fl) {
            fl flVar = (fl) list;
            list = this.f24482b & 7;
            if (list == 2) {
                int m = this.f24481a.mo4450m();
                eo.m31389c(m);
                int u = this.f24481a.mo4458u() + m;
                do {
                    flVar.m37959c(this.f24481a.mo4445h());
                } while (this.f24481a.mo4458u() < u);
                return;
            } else if (list == 5) {
                do {
                    flVar.m37959c(this.f24481a.mo4445h());
                    if (this.f24481a.mo4457t() == null) {
                        list = this.f24481a.mo4432a();
                    } else {
                        return;
                    }
                } while (list == this.f24482b);
                this.f24484d = list;
                return;
            } else {
                throw fs.m20572e();
            }
        }
        int i = this.f24482b & 7;
        if (i == 2) {
            i = this.f24481a.mo4450m();
            eo.m31389c(i);
            int u2 = this.f24481a.mo4458u() + i;
            do {
                list.add(Integer.valueOf(this.f24481a.mo4445h()));
            } while (this.f24481a.mo4458u() < u2);
        } else if (i == 5) {
            do {
                list.add(Integer.valueOf(this.f24481a.mo4445h()));
                if (!this.f24481a.mo4457t()) {
                    i = this.f24481a.mo4432a();
                } else {
                    return;
                }
            } while (i == this.f24482b);
            this.f24484d = i;
        } else {
            throw fs.m20572e();
        }
    }

    /* renamed from: h */
    public final void mo4479h(List<Boolean> list) {
        int u;
        if (list instanceof dw) {
            dw dwVar = (dw) list;
            list = this.f24482b & 7;
            if (list == null) {
                do {
                    dwVar.m37820a(this.f24481a.mo4446i());
                    if (this.f24481a.mo4457t() == null) {
                        list = this.f24481a.mo4432a();
                    } else {
                        return;
                    }
                } while (list == this.f24482b);
                this.f24484d = list;
                return;
            } else if (list == 2) {
                u = this.f24481a.mo4458u() + this.f24481a.mo4450m();
                do {
                    dwVar.m37820a(this.f24481a.mo4446i());
                } while (this.f24481a.mo4458u() < u);
                m31391d(u);
                return;
            } else {
                throw fs.m20572e();
            }
        }
        int i = this.f24482b & 7;
        if (i == 0) {
            do {
                list.add(Boolean.valueOf(this.f24481a.mo4446i()));
                if (!this.f24481a.mo4457t()) {
                    i = this.f24481a.mo4432a();
                } else {
                    return;
                }
            } while (i == this.f24482b);
            this.f24484d = i;
        } else if (i == 2) {
            u = this.f24481a.mo4458u() + this.f24481a.mo4450m();
            do {
                list.add(Boolean.valueOf(this.f24481a.mo4446i()));
            } while (this.f24481a.mo4458u() < u);
            m31391d(u);
        } else {
            throw fs.m20572e();
        }
    }

    /* renamed from: i */
    public final void mo4481i(List<String> list) {
        m31386a((List) list, false);
    }

    /* renamed from: j */
    public final void mo4483j(List<String> list) {
        m31386a((List) list, true);
    }

    /* renamed from: a */
    private final void m31386a(List<String> list, boolean z) {
        if ((this.f24482b & 7) != 2) {
            throw fs.m20572e();
        } else if (!(list instanceof gb) || z) {
            int a;
            do {
                list.add(z ? mo4488m() : mo4486l());
                if (!this.f24481a.mo4457t()) {
                    a = this.f24481a.mo4432a();
                } else {
                    return;
                }
            } while (a == this.f24482b);
            this.f24484d = a;
        } else {
            gb gbVar = (gb) list;
            do {
                gbVar.mo4603a(mo4490n());
                if (this.f24481a.mo4457t() == null) {
                    list = this.f24481a.mo4432a();
                } else {
                    return;
                }
            } while (list == this.f24482b);
            this.f24484d = list;
        }
    }

    /* renamed from: a */
    public final <T> void mo4462a(List<T> list, hi<T> hiVar, ew ewVar) {
        if ((this.f24482b & 7) == 2) {
            int a;
            int i = this.f24482b;
            do {
                list.add(m31388c(hiVar, ewVar));
                if (!this.f24481a.mo4457t()) {
                    if (this.f24484d == 0) {
                        a = this.f24481a.mo4432a();
                    }
                }
                return;
            } while (a == i);
            this.f24484d = a;
            return;
        }
        throw fs.m20572e();
    }

    /* renamed from: b */
    public final <T> void mo4467b(List<T> list, hi<T> hiVar, ew ewVar) {
        if ((this.f24482b & 7) == 3) {
            int a;
            int i = this.f24482b;
            do {
                list.add(m31390d(hiVar, ewVar));
                if (!this.f24481a.mo4457t()) {
                    if (this.f24484d == 0) {
                        a = this.f24481a.mo4432a();
                    }
                }
                return;
            } while (a == i);
            this.f24484d = a;
            return;
        }
        throw fs.m20572e();
    }

    /* renamed from: k */
    public final void mo4484k(List<dy> list) {
        if ((this.f24482b & 7) == 2) {
            int a;
            do {
                list.add(mo4490n());
                if (!this.f24481a.mo4457t()) {
                    a = this.f24481a.mo4432a();
                } else {
                    return;
                }
            } while (a == this.f24482b);
            this.f24484d = a;
            return;
        }
        throw fs.m20572e();
    }

    /* renamed from: l */
    public final void mo4487l(List<Integer> list) {
        if (list instanceof fl) {
            fl flVar = (fl) list;
            list = this.f24482b & 7;
            if (list == null) {
                do {
                    flVar.m37959c(this.f24481a.mo4450m());
                    if (this.f24481a.mo4457t() == null) {
                        list = this.f24481a.mo4432a();
                    } else {
                        return;
                    }
                } while (list == this.f24482b);
                this.f24484d = list;
                return;
            } else if (list == 2) {
                int u;
                u = this.f24481a.mo4458u() + this.f24481a.mo4450m();
                do {
                    flVar.m37959c(this.f24481a.mo4450m());
                } while (this.f24481a.mo4458u() < u);
                m31391d(u);
                return;
            } else {
                throw fs.m20572e();
            }
        }
        int i = this.f24482b & 7;
        if (i == 0) {
            do {
                list.add(Integer.valueOf(this.f24481a.mo4450m()));
                if (!this.f24481a.mo4457t()) {
                    i = this.f24481a.mo4432a();
                } else {
                    return;
                }
            } while (i == this.f24482b);
            this.f24484d = i;
        } else if (i == 2) {
            u = this.f24481a.mo4458u() + this.f24481a.mo4450m();
            do {
                list.add(Integer.valueOf(this.f24481a.mo4450m()));
            } while (this.f24481a.mo4458u() < u);
            m31391d(u);
        } else {
            throw fs.m20572e();
        }
    }

    /* renamed from: m */
    public final void mo4489m(List<Integer> list) {
        int u;
        if (list instanceof fl) {
            fl flVar = (fl) list;
            list = this.f24482b & 7;
            if (list == null) {
                do {
                    flVar.m37959c(this.f24481a.mo4451n());
                    if (this.f24481a.mo4457t() == null) {
                        list = this.f24481a.mo4432a();
                    } else {
                        return;
                    }
                } while (list == this.f24482b);
                this.f24484d = list;
                return;
            } else if (list == 2) {
                u = this.f24481a.mo4458u() + this.f24481a.mo4450m();
                do {
                    flVar.m37959c(this.f24481a.mo4451n());
                } while (this.f24481a.mo4458u() < u);
                m31391d(u);
                return;
            } else {
                throw fs.m20572e();
            }
        }
        int i = this.f24482b & 7;
        if (i == 0) {
            do {
                list.add(Integer.valueOf(this.f24481a.mo4451n()));
                if (!this.f24481a.mo4457t()) {
                    i = this.f24481a.mo4432a();
                } else {
                    return;
                }
            } while (i == this.f24482b);
            this.f24484d = i;
        } else if (i == 2) {
            u = this.f24481a.mo4458u() + this.f24481a.mo4450m();
            do {
                list.add(Integer.valueOf(this.f24481a.mo4451n()));
            } while (this.f24481a.mo4458u() < u);
            m31391d(u);
        } else {
            throw fs.m20572e();
        }
    }

    /* renamed from: n */
    public final void mo4491n(List<Integer> list) {
        if (list instanceof fl) {
            fl flVar = (fl) list;
            list = this.f24482b & 7;
            if (list == 2) {
                int m = this.f24481a.mo4450m();
                eo.m31389c(m);
                int u = this.f24481a.mo4458u() + m;
                do {
                    flVar.m37959c(this.f24481a.mo4452o());
                } while (this.f24481a.mo4458u() < u);
                return;
            } else if (list == 5) {
                do {
                    flVar.m37959c(this.f24481a.mo4452o());
                    if (this.f24481a.mo4457t() == null) {
                        list = this.f24481a.mo4432a();
                    } else {
                        return;
                    }
                } while (list == this.f24482b);
                this.f24484d = list;
                return;
            } else {
                throw fs.m20572e();
            }
        }
        int i = this.f24482b & 7;
        if (i == 2) {
            i = this.f24481a.mo4450m();
            eo.m31389c(i);
            int u2 = this.f24481a.mo4458u() + i;
            do {
                list.add(Integer.valueOf(this.f24481a.mo4452o()));
            } while (this.f24481a.mo4458u() < u2);
        } else if (i == 5) {
            do {
                list.add(Integer.valueOf(this.f24481a.mo4452o()));
                if (!this.f24481a.mo4457t()) {
                    i = this.f24481a.mo4432a();
                } else {
                    return;
                }
            } while (i == this.f24482b);
            this.f24484d = i;
        } else {
            throw fs.m20572e();
        }
    }

    /* renamed from: o */
    public final void mo4493o(List<Long> list) {
        int m;
        int u;
        if (list instanceof gg) {
            gg ggVar = (gg) list;
            switch (this.f24482b & 7) {
                case 1:
                    break;
                case 2:
                    m = this.f24481a.mo4450m();
                    eo.m31387b(m);
                    u = this.f24481a.mo4458u() + m;
                    do {
                        ggVar.m37971a(this.f24481a.mo4453p());
                    } while (this.f24481a.mo4458u() < u);
                    return;
                default:
                    throw fs.m20572e();
            }
            do {
                ggVar.m37971a(this.f24481a.mo4453p());
                if (!this.f24481a.mo4457t()) {
                    m = this.f24481a.mo4432a();
                } else {
                    return;
                }
            } while (m == this.f24482b);
            this.f24484d = m;
            return;
        }
        switch (this.f24482b & 7) {
            case 1:
                break;
            case 2:
                m = this.f24481a.mo4450m();
                eo.m31387b(m);
                u = this.f24481a.mo4458u() + m;
                do {
                    list.add(Long.valueOf(this.f24481a.mo4453p()));
                } while (this.f24481a.mo4458u() < u);
                return;
            default:
                throw fs.m20572e();
        }
        do {
            list.add(Long.valueOf(this.f24481a.mo4453p()));
            if (!this.f24481a.mo4457t()) {
                m = this.f24481a.mo4432a();
            } else {
                return;
            }
        } while (m == this.f24482b);
        this.f24484d = m;
    }

    /* renamed from: p */
    public final void mo4495p(List<Integer> list) {
        if (list instanceof fl) {
            fl flVar = (fl) list;
            list = this.f24482b & 7;
            if (list == null) {
                do {
                    flVar.m37959c(this.f24481a.mo4454q());
                    if (this.f24481a.mo4457t() == null) {
                        list = this.f24481a.mo4432a();
                    } else {
                        return;
                    }
                } while (list == this.f24482b);
                this.f24484d = list;
                return;
            } else if (list == 2) {
                int u;
                u = this.f24481a.mo4458u() + this.f24481a.mo4450m();
                do {
                    flVar.m37959c(this.f24481a.mo4454q());
                } while (this.f24481a.mo4458u() < u);
                m31391d(u);
                return;
            } else {
                throw fs.m20572e();
            }
        }
        int i = this.f24482b & 7;
        if (i == 0) {
            do {
                list.add(Integer.valueOf(this.f24481a.mo4454q()));
                if (!this.f24481a.mo4457t()) {
                    i = this.f24481a.mo4432a();
                } else {
                    return;
                }
            } while (i == this.f24482b);
            this.f24484d = i;
        } else if (i == 2) {
            u = this.f24481a.mo4458u() + this.f24481a.mo4450m();
            do {
                list.add(Integer.valueOf(this.f24481a.mo4454q()));
            } while (this.f24481a.mo4458u() < u);
            m31391d(u);
        } else {
            throw fs.m20572e();
        }
    }

    /* renamed from: q */
    public final void mo4497q(List<Long> list) {
        int u;
        if (list instanceof gg) {
            gg ggVar = (gg) list;
            list = this.f24482b & 7;
            if (list == null) {
                do {
                    ggVar.m37971a(this.f24481a.mo4455r());
                    if (this.f24481a.mo4457t() == null) {
                        list = this.f24481a.mo4432a();
                    } else {
                        return;
                    }
                } while (list == this.f24482b);
                this.f24484d = list;
                return;
            } else if (list == 2) {
                u = this.f24481a.mo4458u() + this.f24481a.mo4450m();
                do {
                    ggVar.m37971a(this.f24481a.mo4455r());
                } while (this.f24481a.mo4458u() < u);
                m31391d(u);
                return;
            } else {
                throw fs.m20572e();
            }
        }
        int i = this.f24482b & 7;
        if (i == 0) {
            do {
                list.add(Long.valueOf(this.f24481a.mo4455r()));
                if (!this.f24481a.mo4457t()) {
                    i = this.f24481a.mo4432a();
                } else {
                    return;
                }
            } while (i == this.f24482b);
            this.f24484d = i;
        } else if (i == 2) {
            u = this.f24481a.mo4458u() + this.f24481a.mo4450m();
            do {
                list.add(Long.valueOf(this.f24481a.mo4455r()));
            } while (this.f24481a.mo4458u() < u);
            m31391d(u);
        } else {
            throw fs.m20572e();
        }
    }

    /* renamed from: b */
    private static void m31387b(int i) {
        if ((i & 7) != 0) {
            throw fs.m20574g();
        }
    }

    /* renamed from: a */
    public final <K, V> void mo4463a(java.util.Map<K, V> r6, com.google.android.gms.internal.p210i.gm<K, V> r7, com.google.android.gms.internal.p210i.ew r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r5 = this;
        r0 = 2;
        r5.m31385a(r0);
        r0 = r5.f24481a;
        r0 = r0.mo4450m();
        r1 = r5.f24481a;
        r0 = r1.mo4438d(r0);
        r1 = r7.f16648b;
        r2 = r7.f16650d;
    L_0x0014:
        r3 = r5.mo4459a();	 Catch:{ all -> 0x0067 }
        r4 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;	 Catch:{ all -> 0x0067 }
        if (r3 == r4) goto L_0x005e;	 Catch:{ all -> 0x0067 }
    L_0x001d:
        r4 = r5.f24481a;	 Catch:{ all -> 0x0067 }
        r4 = r4.mo4457t();	 Catch:{ all -> 0x0067 }
        if (r4 != 0) goto L_0x005e;
    L_0x0025:
        switch(r3) {
            case 1: goto L_0x003b;
            case 2: goto L_0x002d;
            default: goto L_0x0028;
        };
    L_0x0028:
        r3 = r5.mo4469c();	 Catch:{ ft -> 0x004f }
        goto L_0x0044;	 Catch:{ ft -> 0x004f }
    L_0x002d:
        r3 = r7.f16649c;	 Catch:{ ft -> 0x004f }
        r4 = r7.f16650d;	 Catch:{ ft -> 0x004f }
        r4 = r4.getClass();	 Catch:{ ft -> 0x004f }
        r3 = r5.m31384a(r3, r4, r8);	 Catch:{ ft -> 0x004f }
        r2 = r3;	 Catch:{ ft -> 0x004f }
        goto L_0x0014;	 Catch:{ ft -> 0x004f }
    L_0x003b:
        r3 = r7.f16647a;	 Catch:{ ft -> 0x004f }
        r4 = 0;	 Catch:{ ft -> 0x004f }
        r3 = r5.m31384a(r3, r4, r4);	 Catch:{ ft -> 0x004f }
        r1 = r3;	 Catch:{ ft -> 0x004f }
        goto L_0x0014;	 Catch:{ ft -> 0x004f }
    L_0x0044:
        if (r3 == 0) goto L_0x0047;	 Catch:{ ft -> 0x004f }
    L_0x0046:
        goto L_0x0014;	 Catch:{ ft -> 0x004f }
    L_0x0047:
        r3 = new com.google.android.gms.internal.i.fs;	 Catch:{ ft -> 0x004f }
        r4 = "Unable to parse map entry.";	 Catch:{ ft -> 0x004f }
        r3.<init>(r4);	 Catch:{ ft -> 0x004f }
        throw r3;	 Catch:{ ft -> 0x004f }
    L_0x004f:
        r3 = r5.mo4469c();	 Catch:{ all -> 0x0067 }
        if (r3 == 0) goto L_0x0056;	 Catch:{ all -> 0x0067 }
    L_0x0055:
        goto L_0x0014;	 Catch:{ all -> 0x0067 }
    L_0x0056:
        r6 = new com.google.android.gms.internal.i.fs;	 Catch:{ all -> 0x0067 }
        r7 = "Unable to parse map entry.";	 Catch:{ all -> 0x0067 }
        r6.<init>(r7);	 Catch:{ all -> 0x0067 }
        throw r6;	 Catch:{ all -> 0x0067 }
    L_0x005e:
        r6.put(r1, r2);	 Catch:{ all -> 0x0067 }
        r6 = r5.f24481a;
        r6.mo4441e(r0);
        return;
    L_0x0067:
        r6 = move-exception;
        r7 = r5.f24481a;
        r7.mo4441e(r0);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.eo.a(java.util.Map, com.google.android.gms.internal.i.gm, com.google.android.gms.internal.i.ew):void");
    }

    /* renamed from: a */
    private final Object m31384a(ir irVar, Class<?> cls, ew ewVar) {
        switch (ep.f16524a[irVar.ordinal()]) {
            case 1:
                return Boolean.valueOf(mo4485k());
            case 2:
                return mo4490n();
            case 3:
                return Double.valueOf(mo4470d());
            case 4:
                return Integer.valueOf(mo4494p());
            case 5:
                return Integer.valueOf(mo4482j());
            case 6:
                return Long.valueOf(mo4480i());
            case 7:
                return Float.valueOf(mo4472e());
            case 8:
                return Integer.valueOf(mo4478h());
            case 9:
                return Long.valueOf(mo4476g());
            case 10:
                m31385a(2);
                return m31388c(hf.m20628a().m20629a((Class) cls), ewVar);
            case 11:
                return Integer.valueOf(mo4496q());
            case 12:
                return Long.valueOf(mo4498r());
            case 13:
                return Integer.valueOf(mo4499s());
            case 14:
                return Long.valueOf(mo4500t());
            case 15:
                return mo4488m();
            case 16:
                return Integer.valueOf(mo4492o());
            case 17:
                return Long.valueOf(mo4474f());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /* renamed from: c */
    private static void m31389c(int i) {
        if ((i & 3) != 0) {
            throw fs.m20574g();
        }
    }

    /* renamed from: d */
    private final void m31391d(int i) {
        if (this.f24481a.mo4458u() != i) {
            throw fs.m20568a();
        }
    }
}
