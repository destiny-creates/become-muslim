package org.spongycastle.math.ec;

import java.math.BigInteger;
import java.util.Hashtable;

public abstract class ECPoint {
    /* renamed from: a */
    protected static ECFieldElement[] f23092a = new ECFieldElement[0];
    /* renamed from: b */
    protected ECCurve f23093b;
    /* renamed from: c */
    protected ECFieldElement f23094c;
    /* renamed from: d */
    protected ECFieldElement f23095d;
    /* renamed from: e */
    protected ECFieldElement[] f23096e;
    /* renamed from: f */
    protected boolean f23097f;
    /* renamed from: g */
    protected Hashtable f23098g;

    public static abstract class AbstractF2m extends ECPoint {
        protected AbstractF2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            super(eCCurve, eCFieldElement, eCFieldElement2);
        }

        protected AbstractF2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
            super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        }

        /* renamed from: b */
        protected boolean mo5905b() {
            ECCurve d = m28406d();
            ECFieldElement eCFieldElement = this.c;
            ECFieldElement g = d.m28383g();
            ECFieldElement h = d.m28384h();
            int k = d.m28387k();
            ECFieldElement eCFieldElement2;
            ECFieldElement eCFieldElement3;
            if (k == 6) {
                eCFieldElement2 = this.e[0];
                boolean i = eCFieldElement2.mo6565i();
                if (eCFieldElement.mo6566j()) {
                    Object c;
                    eCFieldElement = this.d.mo6561e();
                    if (!i) {
                        c = h.mo6558c(eCFieldElement2.mo6561e());
                    }
                    return eCFieldElement.equals(c);
                }
                Object a;
                eCFieldElement3 = this.d;
                eCFieldElement = eCFieldElement.mo6561e();
                if (i) {
                    eCFieldElement2 = eCFieldElement3.mo6561e().mo6551a(eCFieldElement3).mo6551a(g);
                    a = eCFieldElement.mo6561e().mo6551a(h);
                } else {
                    ECFieldElement e = eCFieldElement2.mo6561e();
                    ECFieldElement e2 = e.mo6561e();
                    eCFieldElement2 = eCFieldElement3.mo6551a(eCFieldElement2).mo6556b(eCFieldElement3, g, e);
                    a = eCFieldElement.mo6552a(h, e2);
                }
                return eCFieldElement2.mo6558c(eCFieldElement).equals(a);
            }
            eCFieldElement3 = this.d;
            Object c2 = eCFieldElement3.mo6551a(eCFieldElement).mo6558c(eCFieldElement3);
            switch (k) {
                case 0:
                    break;
                case 1:
                    eCFieldElement2 = this.e[0];
                    if (!eCFieldElement2.mo6565i()) {
                        e = eCFieldElement2.mo6558c(eCFieldElement2.mo6561e());
                        c2 = c2.mo6558c(eCFieldElement2);
                        g = g.mo6558c(eCFieldElement2);
                        h = h.mo6558c(e);
                        break;
                    }
                    break;
                default:
                    throw new IllegalStateException("unsupported coordinate system");
            }
            return c2.equals(eCFieldElement.mo6551a(g).mo6558c(eCFieldElement.mo6561e()).mo6551a(h));
        }

        /* renamed from: b */
        public ECPoint mo5904b(ECFieldElement eCFieldElement) {
            if (m28419q()) {
                return this;
            }
            ECFieldElement k;
            ECFieldElement l;
            switch (m28408f()) {
                case 5:
                    k = m28413k();
                    l = m28414l();
                    return m28406d().mo6543a(k, l.mo6551a(k).mo6560d(eCFieldElement).mo6551a(k.mo6558c(eCFieldElement)), m28415m(), this.f);
                case 6:
                    k = m28413k();
                    l = m28414l();
                    ECFieldElement eCFieldElement2 = m28415m()[0];
                    ECFieldElement c = k.mo6558c(eCFieldElement.mo6561e());
                    k = l.mo6551a(k).mo6551a(c);
                    eCFieldElement = eCFieldElement2.mo6558c(eCFieldElement);
                    return m28406d().mo6543a(c, k, new ECFieldElement[]{eCFieldElement}, this.f);
                default:
                    return super.mo5904b(eCFieldElement);
            }
        }

        /* renamed from: c */
        public ECPoint mo5906c(ECFieldElement eCFieldElement) {
            if (m28419q()) {
                return this;
            }
            switch (m28408f()) {
                case 5:
                case 6:
                    ECFieldElement k = m28413k();
                    return m28406d().mo6543a(k, m28414l().mo6551a(k).mo6558c(eCFieldElement).mo6551a(k), m28415m(), this.f);
                default:
                    return super.mo5906c(eCFieldElement);
            }
        }

        /* renamed from: c */
        public AbstractF2m m36296c(int i) {
            if (m28419q()) {
                return this;
            }
            ECCurve d = m28406d();
            int k = d.m28387k();
            ECFieldElement eCFieldElement = this.c;
            switch (k) {
                case 0:
                case 5:
                    return (AbstractF2m) d.mo6542a(eCFieldElement.mo6550a(i), this.d.mo6550a(i), this.f);
                case 1:
                case 6:
                    ECFieldElement eCFieldElement2 = this.d;
                    ECFieldElement eCFieldElement3 = this.e[0];
                    return (AbstractF2m) d.mo6543a(eCFieldElement.mo6550a(i), eCFieldElement2.mo6550a(i), new ECFieldElement[]{eCFieldElement3.mo6550a(i)}, this.f);
                default:
                    throw new IllegalStateException("unsupported coordinate system");
            }
        }
    }

    public static abstract class AbstractFp extends ECPoint {
        protected AbstractFp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            super(eCCurve, eCFieldElement, eCFieldElement2);
        }

        protected AbstractFp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
            super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        }

        /* renamed from: s */
        protected boolean mo5907s() {
            return m28410h().mo6567k();
        }

        /* renamed from: b */
        protected boolean mo5905b() {
            ECFieldElement eCFieldElement = this.c;
            ECFieldElement eCFieldElement2 = this.d;
            ECFieldElement g = this.b.m28383g();
            ECFieldElement h = this.b.m28384h();
            Object e = eCFieldElement2.mo6561e();
            ECFieldElement eCFieldElement3;
            ECFieldElement e2;
            switch (m28408f()) {
                case 0:
                    break;
                case 1:
                    eCFieldElement3 = this.e[0];
                    if (!eCFieldElement3.mo6565i()) {
                        e2 = eCFieldElement3.mo6561e();
                        ECFieldElement c = eCFieldElement3.mo6558c(e2);
                        e = e.mo6558c(eCFieldElement3);
                        g = g.mo6558c(e2);
                        h = h.mo6558c(c);
                        break;
                    }
                    break;
                case 2:
                case 3:
                case 4:
                    eCFieldElement3 = this.e[0];
                    if (!eCFieldElement3.mo6565i()) {
                        eCFieldElement3 = eCFieldElement3.mo6561e();
                        e2 = eCFieldElement3.mo6561e();
                        eCFieldElement3 = eCFieldElement3.mo6558c(e2);
                        g = g.mo6558c(e2);
                        h = h.mo6558c(eCFieldElement3);
                        break;
                    }
                    break;
                default:
                    throw new IllegalStateException("unsupported coordinate system");
            }
            return e.equals(eCFieldElement.mo6561e().mo6551a(g).mo6558c(eCFieldElement).mo6551a(h));
        }
    }

    public static class F2m extends AbstractF2m {
        public F2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            this(eCCurve, eCFieldElement, eCFieldElement2, false);
        }

        public F2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
            super(eCCurve, eCFieldElement, eCFieldElement2);
            Object obj = null;
            Object obj2 = eCFieldElement == null ? 1 : null;
            if (eCFieldElement2 == null) {
                obj = 1;
            }
            if (obj2 == obj) {
                if (eCFieldElement != null) {
                    org.spongycastle.math.ec.ECFieldElement.F2m.m41156b(this.c, this.d);
                    if (eCCurve != null) {
                        org.spongycastle.math.ec.ECFieldElement.F2m.m41156b(this.c, this.b.m28383g());
                    }
                }
                this.f = z;
                return;
            }
            throw new IllegalArgumentException("Exactly one of the field elements is null");
        }

        F2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
            super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
            this.f = z;
        }

        /* renamed from: e */
        protected ECPoint mo6570e() {
            return new F2m(null, m28409g(), m28410h());
        }

        /* renamed from: j */
        public ECFieldElement mo6571j() {
            int f = m28408f();
            switch (f) {
                case 5:
                case 6:
                    ECFieldElement eCFieldElement = this.c;
                    ECFieldElement eCFieldElement2 = this.d;
                    if (!m28419q()) {
                        if (!eCFieldElement.mo6566j()) {
                            eCFieldElement = eCFieldElement2.mo6551a(eCFieldElement).mo6558c(eCFieldElement);
                            if (6 == f) {
                                ECFieldElement eCFieldElement3 = this.e[0];
                                if (!eCFieldElement3.mo6565i()) {
                                    eCFieldElement = eCFieldElement.mo6560d(eCFieldElement3);
                                }
                            }
                            return eCFieldElement;
                        }
                    }
                    return eCFieldElement2;
                default:
                    return this.d;
            }
        }

        /* renamed from: s */
        protected boolean mo5907s() {
            ECFieldElement k = m28413k();
            boolean z = false;
            if (k.mo6566j()) {
                return false;
            }
            ECFieldElement l = m28414l();
            switch (m28408f()) {
                case 5:
                case 6:
                    if (l.mo6567k() != k.mo6567k()) {
                        z = true;
                    }
                    return z;
                default:
                    return l.mo6560d(k).mo6567k();
            }
        }

        /* renamed from: b */
        public ECPoint mo6568b(ECPoint eCPoint) {
            if (m28419q()) {
                return eCPoint;
            }
            if (eCPoint.m28419q()) {
                return this;
            }
            ECCurve d = m28406d();
            int k = d.m28387k();
            ECFieldElement eCFieldElement = this.c;
            ECFieldElement eCFieldElement2 = eCPoint.f23094c;
            ECFieldElement eCFieldElement3;
            ECFieldElement eCFieldElement4;
            ECFieldElement eCFieldElement5;
            ECFieldElement eCFieldElement6;
            boolean i;
            ECFieldElement eCFieldElement7;
            ECFieldElement c;
            ECFieldElement a;
            if (k != 6) {
                switch (k) {
                    case 0:
                        eCFieldElement3 = this.d;
                        eCFieldElement4 = eCPoint.f23095d;
                        eCFieldElement2 = eCFieldElement.mo6551a(eCFieldElement2);
                        eCPoint = eCFieldElement3.mo6551a(eCFieldElement4);
                        if (!eCFieldElement2.mo6566j()) {
                            eCFieldElement4 = eCPoint.mo6560d(eCFieldElement2);
                            eCFieldElement2 = eCFieldElement4.mo6561e().mo6551a(eCFieldElement4).mo6551a(eCFieldElement2).mo6551a(d.m28383g());
                            return new F2m(d, eCFieldElement2, eCFieldElement4.mo6558c(eCFieldElement.mo6551a(eCFieldElement2)).mo6551a(eCFieldElement2).mo6551a(eCFieldElement3), this.f);
                        } else if (eCPoint.mo6566j() != null) {
                            return mo6573u();
                        } else {
                            return d.mo6547e();
                        }
                    case 1:
                        eCFieldElement3 = this.d;
                        eCFieldElement5 = this.e[0];
                        eCFieldElement6 = eCPoint.f23095d;
                        eCPoint = eCPoint.f23096e[0];
                        i = eCPoint.mo6565i();
                        eCFieldElement6 = eCFieldElement5.mo6558c(eCFieldElement6);
                        if (i) {
                            eCFieldElement7 = eCFieldElement3;
                        } else {
                            eCFieldElement7 = eCFieldElement3.mo6558c(eCPoint);
                        }
                        eCFieldElement6 = eCFieldElement6.mo6551a(eCFieldElement7);
                        eCFieldElement2 = eCFieldElement5.mo6558c(eCFieldElement2);
                        if (i) {
                            eCFieldElement7 = eCFieldElement;
                        } else {
                            eCFieldElement7 = eCFieldElement.mo6558c(eCPoint);
                        }
                        eCFieldElement2 = eCFieldElement2.mo6551a(eCFieldElement7);
                        if (!eCFieldElement2.mo6566j()) {
                            eCFieldElement7 = eCFieldElement2.mo6561e();
                            c = eCFieldElement7.mo6558c(eCFieldElement2);
                            if (!i) {
                                eCFieldElement5 = eCFieldElement5.mo6558c(eCPoint);
                            }
                            ECFieldElement a2 = eCFieldElement6.mo6551a(eCFieldElement2);
                            a = a2.mo6556b(eCFieldElement6, eCFieldElement7, d.m28383g()).mo6558c(eCFieldElement5).mo6551a(c);
                            ECFieldElement c2 = eCFieldElement2.mo6558c(a);
                            if (!i) {
                                eCFieldElement7 = eCFieldElement7.mo6558c(eCPoint);
                            }
                            return new F2m(d, c2, eCFieldElement6.mo6556b(eCFieldElement, eCFieldElement2, eCFieldElement3).mo6556b(eCFieldElement7, a2, a), new ECFieldElement[]{c.mo6558c(eCFieldElement5)}, this.f);
                        } else if (eCFieldElement6.mo6566j() != null) {
                            return mo6573u();
                        } else {
                            return d.mo6547e();
                        }
                    default:
                        throw new IllegalStateException("unsupported coordinate system");
                }
            } else if (!eCFieldElement.mo6566j()) {
                eCFieldElement3 = this.d;
                eCFieldElement5 = this.e[0];
                eCFieldElement6 = eCPoint.f23095d;
                eCPoint = eCPoint.f23096e[0];
                i = eCFieldElement5.mo6565i();
                if (i) {
                    eCFieldElement7 = eCFieldElement2;
                    c = eCFieldElement6;
                } else {
                    eCFieldElement7 = eCFieldElement2.mo6558c(eCFieldElement5);
                    c = eCFieldElement6.mo6558c(eCFieldElement5);
                }
                boolean i2 = eCPoint.mo6565i();
                if (i2) {
                    a = eCFieldElement3;
                } else {
                    eCFieldElement = eCFieldElement.mo6558c(eCPoint);
                    a = eCFieldElement3.mo6558c(eCPoint);
                }
                c = a.mo6551a(c);
                a = eCFieldElement.mo6551a(eCFieldElement7);
                if (!a.mo6566j()) {
                    if (eCFieldElement2.mo6566j()) {
                        eCPoint = m28418p();
                        eCFieldElement3 = eCPoint.m28411i();
                        eCFieldElement4 = eCPoint.mo6571j();
                        eCFieldElement = eCFieldElement4.mo6551a(eCFieldElement6).mo6560d(eCFieldElement3);
                        eCFieldElement2 = eCFieldElement.mo6561e().mo6551a(eCFieldElement).mo6551a(eCFieldElement3).mo6551a(d.m28383g());
                        if (eCFieldElement2.mo6566j()) {
                            return new F2m(d, eCFieldElement2, d.m28384h().mo6563g(), this.f);
                        }
                        eCFieldElement5 = eCFieldElement.mo6558c(eCFieldElement3.mo6551a(eCFieldElement2)).mo6551a(eCFieldElement2).mo6551a(eCFieldElement4).mo6560d(eCFieldElement2).mo6551a(eCFieldElement2);
                        eCPoint = d.mo6541a(ECConstants.f23076d);
                    } else {
                        eCFieldElement2 = a.mo6561e();
                        eCFieldElement = c.mo6558c(eCFieldElement);
                        eCFieldElement6 = c.mo6558c(eCFieldElement7);
                        eCFieldElement = eCFieldElement.mo6558c(eCFieldElement6);
                        if (eCFieldElement.mo6566j()) {
                            return new F2m(d, eCFieldElement, d.m28384h().mo6563g(), this.f);
                        }
                        eCFieldElement7 = c.mo6558c(eCFieldElement2);
                        eCPoint = !i2 ? eCFieldElement7.mo6558c(eCPoint) : eCFieldElement7;
                        eCFieldElement3 = eCFieldElement6.mo6551a(eCFieldElement2).mo6552a(eCPoint, eCFieldElement3.mo6551a(eCFieldElement5));
                        if (!i) {
                            eCPoint = eCPoint.mo6558c(eCFieldElement5);
                        }
                        eCFieldElement5 = eCFieldElement3;
                        eCFieldElement2 = eCFieldElement;
                    }
                    return new F2m(d, eCFieldElement2, eCFieldElement5, new ECFieldElement[]{eCPoint}, this.f);
                } else if (c.mo6566j() != null) {
                    return mo6573u();
                } else {
                    return d.mo6547e();
                }
            } else if (eCFieldElement2.mo6566j()) {
                return d.mo6547e();
            } else {
                return eCPoint.mo6568b((ECPoint) this);
            }
        }

        /* renamed from: u */
        public ECPoint mo6573u() {
            ECPoint eCPoint = this;
            if (m28419q()) {
                return eCPoint;
            }
            ECCurve d = m28406d();
            ECFieldElement eCFieldElement = eCPoint.c;
            if (eCFieldElement.mo6566j()) {
                return d.mo6547e();
            }
            int k = d.m28387k();
            ECFieldElement a;
            ECFieldElement a2;
            boolean i;
            ECFieldElement eCFieldElement2;
            if (k != 6) {
                switch (k) {
                    case 0:
                        a = eCPoint.d.mo6560d(eCFieldElement).mo6551a(eCFieldElement);
                        a2 = a.mo6561e().mo6551a(a).mo6551a(d.m28383g());
                        return new F2m(d, a2, eCFieldElement.mo6552a(a2, a.mo6557c()), eCPoint.f);
                    case 1:
                        a = eCPoint.d;
                        a2 = eCPoint.e[0];
                        i = a2.mo6565i();
                        if (i) {
                            eCFieldElement2 = eCFieldElement;
                        } else {
                            eCFieldElement2 = eCFieldElement.mo6558c(a2);
                        }
                        if (!i) {
                            a = a.mo6558c(a2);
                        }
                        eCFieldElement = eCFieldElement.mo6561e();
                        a = eCFieldElement.mo6551a(a);
                        a2 = eCFieldElement2.mo6561e();
                        ECFieldElement a3 = a.mo6551a(eCFieldElement2);
                        a = a3.mo6556b(a, a2, d.m28383g());
                        return new F2m(d, eCFieldElement2.mo6558c(a), eCFieldElement.mo6561e().mo6556b(eCFieldElement2, a, a3), new ECFieldElement[]{eCFieldElement2.mo6558c(a2)}, eCPoint.f);
                    default:
                        throw new IllegalStateException("unsupported coordinate system");
                }
            }
            ECFieldElement eCFieldElement3;
            ECFieldElement eCFieldElement4;
            a = eCPoint.d;
            a2 = eCPoint.e[0];
            i = a2.mo6565i();
            if (i) {
                eCFieldElement2 = a;
            } else {
                eCFieldElement2 = a.mo6558c(a2);
            }
            if (i) {
                eCFieldElement3 = a2;
            } else {
                eCFieldElement3 = a2.mo6561e();
            }
            ECFieldElement g = d.m28383g();
            if (i) {
                eCFieldElement4 = g;
            } else {
                eCFieldElement4 = g.mo6558c(eCFieldElement3);
            }
            ECFieldElement a4 = a.mo6561e().mo6551a(eCFieldElement2).mo6551a(eCFieldElement4);
            if (a4.mo6566j()) {
                return new F2m(d, a4, d.m28384h().mo6563g(), eCPoint.f);
            }
            ECFieldElement eCFieldElement5;
            ECFieldElement e = a4.mo6561e();
            if (i) {
                eCFieldElement5 = a4;
            } else {
                eCFieldElement5 = a4.mo6558c(eCFieldElement3);
            }
            ECFieldElement h = d.m28384h();
            ECCurve eCCurve = d;
            if (h.mo6564h() < (d.mo6540a() >> 1)) {
                eCFieldElement = a.mo6551a(eCFieldElement).mo6561e();
                if (h.mo6565i()) {
                    a = eCFieldElement4.mo6551a(eCFieldElement3).mo6561e();
                } else {
                    a = eCFieldElement4.mo6552a(h, eCFieldElement3.mo6561e());
                }
                eCFieldElement = eCFieldElement.mo6551a(a4).mo6551a(eCFieldElement3).mo6558c(eCFieldElement).mo6551a(a).mo6551a(e);
                if (g.mo6566j()) {
                    eCFieldElement = eCFieldElement.mo6551a(eCFieldElement5);
                } else if (!g.mo6565i()) {
                    eCFieldElement = eCFieldElement.mo6551a(g.mo6557c().mo6558c(eCFieldElement5));
                }
            } else {
                if (!i) {
                    eCFieldElement = eCFieldElement.mo6558c(a2);
                }
                eCFieldElement = eCFieldElement.mo6552a(a4, eCFieldElement2).mo6551a(e).mo6551a(eCFieldElement5);
            }
            return new F2m(eCCurve, e, eCFieldElement, new ECFieldElement[]{eCFieldElement5}, eCPoint.f);
        }

        /* renamed from: c */
        public ECPoint mo6569c(ECPoint eCPoint) {
            if (m28419q()) {
                return eCPoint;
            }
            if (eCPoint.m28419q()) {
                return mo6573u();
            }
            ECCurve d = m28406d();
            ECFieldElement eCFieldElement = this.c;
            if (eCFieldElement.mo6566j()) {
                return eCPoint;
            }
            if (d.m28387k() != 6) {
                return mo6573u().mo6568b(eCPoint);
            }
            ECFieldElement eCFieldElement2 = eCPoint.f23094c;
            ECFieldElement eCFieldElement3 = eCPoint.f23096e[0];
            if (!eCFieldElement2.mo6566j()) {
                if (eCFieldElement3.mo6565i()) {
                    eCFieldElement3 = this.d;
                    ECFieldElement eCFieldElement4 = this.e[0];
                    ECFieldElement eCFieldElement5 = eCPoint.f23095d;
                    eCFieldElement = eCFieldElement.mo6561e();
                    ECFieldElement e = eCFieldElement3.mo6561e();
                    ECFieldElement e2 = eCFieldElement4.mo6561e();
                    eCFieldElement3 = d.m28383g().mo6558c(e2).mo6551a(e).mo6551a(eCFieldElement3.mo6558c(eCFieldElement4));
                    eCFieldElement4 = eCFieldElement5.mo6557c();
                    eCFieldElement = d.m28383g().mo6551a(eCFieldElement4).mo6558c(e2).mo6551a(e).mo6556b(eCFieldElement3, eCFieldElement, e2);
                    eCFieldElement2 = eCFieldElement2.mo6558c(e2);
                    eCFieldElement5 = eCFieldElement2.mo6551a(eCFieldElement3).mo6561e();
                    if (eCFieldElement5.mo6566j()) {
                        if (eCFieldElement.mo6566j()) {
                            return eCPoint.mo6573u();
                        }
                        return d.mo6547e();
                    } else if (eCFieldElement.mo6566j() != null) {
                        return new F2m(d, eCFieldElement, d.m28384h().mo6563g(), this.f);
                    } else {
                        return new F2m(d, eCFieldElement.mo6561e().mo6558c(eCFieldElement2), eCFieldElement.mo6551a(eCFieldElement5).mo6561e().mo6556b(eCFieldElement3, eCFieldElement4, eCFieldElement.mo6558c(eCFieldElement5).mo6558c(e2)), new ECFieldElement[]{eCPoint}, this.f);
                    }
                }
            }
            return mo6573u().mo6568b(eCPoint);
        }

        /* renamed from: t */
        public ECPoint mo6572t() {
            if (m28419q()) {
                return this;
            }
            ECFieldElement eCFieldElement = this.c;
            if (eCFieldElement.mo6566j()) {
                return this;
            }
            ECFieldElement eCFieldElement2;
            ECFieldElement eCFieldElement3;
            switch (m28408f()) {
                case 0:
                    return new F2m(this.b, eCFieldElement, this.d.mo6551a(eCFieldElement), this.f);
                case 1:
                    eCFieldElement2 = this.d;
                    eCFieldElement3 = this.e[0];
                    return new F2m(this.b, eCFieldElement, eCFieldElement2.mo6551a(eCFieldElement), new ECFieldElement[]{eCFieldElement3}, this.f);
                case 5:
                    return new F2m(this.b, eCFieldElement, this.d.mo6557c(), this.f);
                case 6:
                    eCFieldElement2 = this.d;
                    eCFieldElement3 = this.e[0];
                    return new F2m(this.b, eCFieldElement, eCFieldElement2.mo6551a(eCFieldElement3), new ECFieldElement[]{eCFieldElement3}, this.f);
                default:
                    throw new IllegalStateException("unsupported coordinate system");
            }
        }
    }

    public static class Fp extends AbstractFp {
        public Fp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            this(eCCurve, eCFieldElement, eCFieldElement2, false);
        }

        public Fp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
            super(eCCurve, eCFieldElement, eCFieldElement2);
            ECFieldElement eCFieldElement3 = null;
            eCFieldElement = eCFieldElement == null ? true : null;
            if (eCFieldElement2 == null) {
                eCFieldElement3 = true;
            }
            if (eCFieldElement == eCFieldElement3) {
                this.f = z;
                return;
            }
            throw new IllegalArgumentException("Exactly one of the field elements is null");
        }

        Fp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
            super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
            this.f = z;
        }

        /* renamed from: e */
        protected ECPoint mo6570e() {
            return new Fp(null, m28409g(), m28410h());
        }

        /* renamed from: a */
        public ECFieldElement mo6574a(int i) {
            if (i == 1 && 4 == m28408f()) {
                return m41221w();
            }
            return super.mo6574a(i);
        }

        /* renamed from: b */
        public ECPoint mo6568b(ECPoint eCPoint) {
            ECPoint eCPoint2 = this;
            ECPoint eCPoint3 = eCPoint;
            if (m28419q()) {
                return eCPoint3;
            }
            if (eCPoint.m28419q()) {
                return eCPoint2;
            }
            if (eCPoint2 == eCPoint3) {
                return mo6573u();
            }
            ECFieldElement b;
            ECFieldElement b2;
            ECFieldElement e;
            ECFieldElement[] eCFieldElementArr;
            ECCurve d = m28406d();
            int k = d.m28387k();
            ECFieldElement eCFieldElement = eCPoint2.c;
            ECFieldElement eCFieldElement2 = eCPoint2.d;
            ECFieldElement eCFieldElement3 = eCPoint3.f23094c;
            ECFieldElement eCFieldElement4 = eCPoint3.f23095d;
            if (k != 4) {
                switch (k) {
                    case 0:
                        b = eCFieldElement3.mo6555b(eCFieldElement);
                        b2 = eCFieldElement4.mo6555b(eCFieldElement2);
                        if (!b.mo6566j()) {
                            b = b2.mo6560d(b);
                            b2 = b.mo6561e().mo6555b(eCFieldElement).mo6555b(eCFieldElement3);
                            return new Fp(d, b2, b.mo6558c(eCFieldElement.mo6555b(b2)).mo6555b(eCFieldElement2), eCPoint2.f);
                        } else if (b2.mo6566j()) {
                            return mo6573u();
                        } else {
                            return d.mo6547e();
                        }
                    case 1:
                        b2 = eCPoint2.e[0];
                        b = eCPoint3.f23096e[0];
                        boolean i = b2.mo6565i();
                        boolean i2 = b.mo6565i();
                        if (!i) {
                            eCFieldElement4 = eCFieldElement4.mo6558c(b2);
                        }
                        if (!i2) {
                            eCFieldElement2 = eCFieldElement2.mo6558c(b);
                        }
                        eCFieldElement4 = eCFieldElement4.mo6555b(eCFieldElement2);
                        if (!i) {
                            eCFieldElement3 = eCFieldElement3.mo6558c(b2);
                        }
                        if (!i2) {
                            eCFieldElement = eCFieldElement.mo6558c(b);
                        }
                        eCFieldElement3 = eCFieldElement3.mo6555b(eCFieldElement);
                        if (!eCFieldElement3.mo6566j()) {
                            if (i) {
                                b2 = b;
                            } else if (!i2) {
                                b2 = b2.mo6558c(b);
                            }
                            b = eCFieldElement3.mo6561e();
                            ECFieldElement c = b.mo6558c(eCFieldElement3);
                            b = b.mo6558c(eCFieldElement);
                            eCFieldElement = eCFieldElement4.mo6561e().mo6558c(b2).mo6555b(c).mo6555b(m41213d(b));
                            return new Fp(d, eCFieldElement3.mo6558c(eCFieldElement), b.mo6555b(eCFieldElement).mo6553a(eCFieldElement4, eCFieldElement2, c), new ECFieldElement[]{c.mo6558c(b2)}, eCPoint2.f);
                        } else if (eCFieldElement4.mo6566j()) {
                            return mo6573u();
                        } else {
                            return d.mo6547e();
                        }
                    case 2:
                        break;
                    default:
                        throw new IllegalStateException("unsupported coordinate system");
                }
            }
            ECFieldElement eCFieldElement5 = eCPoint2.e[0];
            b = eCPoint3.f23096e[0];
            boolean i3 = eCFieldElement5.mo6565i();
            if (i3 || !eCFieldElement5.equals(b)) {
                if (!i3) {
                    ECFieldElement e2 = eCFieldElement5.mo6561e();
                    eCFieldElement3 = e2.mo6558c(eCFieldElement3);
                    eCFieldElement4 = e2.mo6558c(eCFieldElement5).mo6558c(eCFieldElement4);
                }
                boolean i4 = b.mo6565i();
                if (!i4) {
                    e = b.mo6561e();
                    eCFieldElement = e.mo6558c(eCFieldElement);
                    eCFieldElement2 = e.mo6558c(b).mo6558c(eCFieldElement2);
                }
                eCFieldElement3 = eCFieldElement.mo6555b(eCFieldElement3);
                eCFieldElement4 = eCFieldElement2.mo6555b(eCFieldElement4);
                if (!eCFieldElement3.mo6566j()) {
                    e = eCFieldElement3.mo6561e();
                    ECFieldElement c2 = e.mo6558c(eCFieldElement3);
                    eCFieldElement = e.mo6558c(eCFieldElement);
                    ECFieldElement b3 = eCFieldElement4.mo6561e().mo6551a(c2).mo6555b(m41213d(eCFieldElement));
                    eCFieldElement = eCFieldElement.mo6555b(b3).mo6553a(eCFieldElement4, c2, eCFieldElement2);
                    eCFieldElement2 = !i3 ? eCFieldElement3.mo6558c(eCFieldElement5) : eCFieldElement3;
                    if (i4) {
                        b = eCFieldElement2;
                    } else {
                        b = eCFieldElement2.mo6558c(b);
                    }
                    if (b == eCFieldElement3) {
                        eCFieldElement2 = eCFieldElement;
                        eCFieldElement = b3;
                        if (k != 4) {
                            b2 = m41208b(b, e);
                            eCFieldElementArr = new ECFieldElement[]{b, b2};
                        } else {
                            eCFieldElementArr = new ECFieldElement[]{b};
                        }
                        return new Fp(d, eCFieldElement, eCFieldElement2, eCFieldElementArr, eCPoint2.f);
                    }
                    eCFieldElement2 = eCFieldElement;
                    eCFieldElement = b3;
                } else if (eCFieldElement4.mo6566j()) {
                    return mo6573u();
                } else {
                    return d.mo6547e();
                }
            }
            b = eCFieldElement.mo6555b(eCFieldElement3);
            eCFieldElement4 = eCFieldElement2.mo6555b(eCFieldElement4);
            if (!b.mo6566j()) {
                ECFieldElement e3 = b.mo6561e();
                eCFieldElement = eCFieldElement.mo6558c(e3);
                eCFieldElement3 = eCFieldElement3.mo6558c(e3);
                eCFieldElement2 = eCFieldElement.mo6555b(eCFieldElement3).mo6558c(eCFieldElement2);
                eCFieldElement3 = eCFieldElement4.mo6561e().mo6555b(eCFieldElement).mo6555b(eCFieldElement3);
                eCFieldElement = eCFieldElement.mo6555b(eCFieldElement3).mo6558c(eCFieldElement4).mo6555b(eCFieldElement2);
                b = b.mo6558c(eCFieldElement5);
                eCFieldElement2 = eCFieldElement;
                eCFieldElement = eCFieldElement3;
            } else if (eCFieldElement4.mo6566j()) {
                return mo6573u();
            } else {
                return d.mo6547e();
            }
            e = null;
            if (k != 4) {
                eCFieldElementArr = new ECFieldElement[]{b};
            } else {
                b2 = m41208b(b, e);
                eCFieldElementArr = new ECFieldElement[]{b, b2};
            }
            return new Fp(d, eCFieldElement, eCFieldElement2, eCFieldElementArr, eCPoint2.f);
        }

        /* renamed from: u */
        public ECPoint mo6573u() {
            if (m28419q()) {
                return this;
            }
            ECCurve d = m28406d();
            ECFieldElement eCFieldElement = this.d;
            if (eCFieldElement.mo6566j()) {
                return d.mo6547e();
            }
            int k = d.m28387k();
            ECFieldElement eCFieldElement2 = this.c;
            if (k == 4) {
                return m41209b(true);
            }
            ECFieldElement d2;
            boolean i;
            ECFieldElement g;
            ECFieldElement b;
            ECFieldElement d3;
            ECFieldElement c;
            switch (k) {
                case 0:
                    d2 = m41214e(eCFieldElement2.mo6561e()).mo6551a(m28406d().m28383g()).mo6560d(m41213d(eCFieldElement));
                    ECFieldElement b2 = d2.mo6561e().mo6555b(m41213d(eCFieldElement2));
                    return new Fp(d, b2, d2.mo6558c(eCFieldElement2.mo6555b(b2)).mo6555b(eCFieldElement), this.f);
                case 1:
                    d2 = this.e[0];
                    i = d2.mo6565i();
                    g = d.m28383g();
                    if (!(g.mo6566j() || i)) {
                        g = g.mo6558c(d2.mo6561e());
                    }
                    g = g.mo6551a(m41214e(eCFieldElement2.mo6561e()));
                    if (i) {
                        d2 = eCFieldElement;
                    } else {
                        d2 = eCFieldElement.mo6558c(d2);
                    }
                    eCFieldElement = i ? eCFieldElement.mo6561e() : d2.mo6558c(eCFieldElement);
                    eCFieldElement2 = m41216f(eCFieldElement2.mo6558c(eCFieldElement));
                    b = g.mo6561e().mo6555b(m41213d(eCFieldElement2));
                    d3 = m41213d(d2);
                    c = b.mo6558c(d3);
                    eCFieldElement = m41213d(eCFieldElement);
                    g = eCFieldElement2.mo6555b(b).mo6558c(g).mo6555b(m41213d(eCFieldElement.mo6561e()));
                    eCFieldElement = i ? m41213d(eCFieldElement) : d3.mo6561e();
                    return new Fp(d, c, g, new ECFieldElement[]{m41213d(eCFieldElement).mo6558c(d2)}, this.f);
                case 2:
                    d2 = this.e[0];
                    i = d2.mo6565i();
                    g = eCFieldElement.mo6561e();
                    b = g.mo6561e();
                    d3 = d.m28383g();
                    c = d3.mo6559d();
                    if (c.mo6549a().equals(BigInteger.valueOf(3))) {
                        if (i) {
                            d3 = d2;
                        } else {
                            d3 = d2.mo6561e();
                        }
                        d3 = m41214e(eCFieldElement2.mo6551a(d3).mo6558c(eCFieldElement2.mo6555b(d3)));
                        eCFieldElement2 = m41216f(g.mo6558c(eCFieldElement2));
                    } else {
                        ECFieldElement e = m41214e(eCFieldElement2.mo6561e());
                        if (i) {
                            d3 = e.mo6551a(d3);
                        } else if (d3.mo6566j()) {
                            d3 = e;
                        } else {
                            ECFieldElement e2 = d2.mo6561e().mo6561e();
                            d3 = c.mo6564h() < d3.mo6564h() ? e.mo6555b(e2.mo6558c(c)) : e.mo6551a(e2.mo6558c(d3));
                        }
                        eCFieldElement2 = m41216f(eCFieldElement2.mo6558c(g));
                    }
                    g = d3.mo6561e().mo6555b(m41213d(eCFieldElement2));
                    b = eCFieldElement2.mo6555b(g).mo6558c(d3).mo6555b(m41217g(b));
                    eCFieldElement = m41213d(eCFieldElement);
                    if (!i) {
                        eCFieldElement = eCFieldElement.mo6558c(d2);
                    }
                    return new Fp(d, g, b, new ECFieldElement[]{eCFieldElement}, this.f);
                default:
                    throw new IllegalStateException("unsupported coordinate system");
            }
        }

        /* renamed from: c */
        public ECPoint mo6569c(ECPoint eCPoint) {
            if (this == eCPoint) {
                return mo6576v();
            }
            if (m28419q()) {
                return eCPoint;
            }
            if (eCPoint.m28419q()) {
                return mo6573u();
            }
            ECFieldElement eCFieldElement = this.d;
            if (eCFieldElement.mo6566j()) {
                return eCPoint;
            }
            ECCurve d = m28406d();
            int k = d.m28387k();
            if (k == 0) {
                ECFieldElement eCFieldElement2 = this.c;
                ECFieldElement eCFieldElement3 = eCPoint.f23094c;
                eCPoint = eCPoint.f23095d;
                ECFieldElement b = eCFieldElement3.mo6555b(eCFieldElement2);
                eCPoint = eCPoint.mo6555b(eCFieldElement);
                if (!b.mo6566j()) {
                    ECFieldElement e = b.mo6561e();
                    ECFieldElement b2 = e.mo6558c(m41213d(eCFieldElement2).mo6551a(eCFieldElement3)).mo6555b(eCPoint.mo6561e());
                    if (b2.mo6566j()) {
                        return d.mo6547e();
                    }
                    ECFieldElement f = b2.mo6558c(b).mo6562f();
                    eCPoint = b2.mo6558c(f).mo6558c(eCPoint);
                    b = m41213d(eCFieldElement).mo6558c(e).mo6558c(b).mo6558c(f).mo6555b(eCPoint);
                    eCPoint = b.mo6555b(eCPoint).mo6558c(eCPoint.mo6551a(b)).mo6551a(eCFieldElement3);
                    return new Fp(d, eCPoint, eCFieldElement2.mo6555b(eCPoint).mo6558c(b).mo6555b(eCFieldElement), this.f);
                } else if (eCPoint.mo6566j() != null) {
                    return mo6576v();
                } else {
                    return this;
                }
            } else if (k != 4) {
                return mo6573u().mo6568b(eCPoint);
            } else {
                return m41209b(false).mo6568b(eCPoint);
            }
        }

        /* renamed from: v */
        public ECPoint mo6576v() {
            if (m28419q()) {
                return this;
            }
            ECFieldElement eCFieldElement = this.d;
            if (eCFieldElement.mo6566j()) {
                return this;
            }
            ECCurve d = m28406d();
            int k = d.m28387k();
            if (k == 0) {
                ECFieldElement eCFieldElement2 = this.c;
                ECFieldElement d2 = m41213d(eCFieldElement);
                ECFieldElement e = d2.mo6561e();
                ECFieldElement a = m41214e(eCFieldElement2.mo6561e()).mo6551a(m28406d().m28383g());
                ECFieldElement b = m41214e(eCFieldElement2).mo6558c(e).mo6555b(a.mo6561e());
                if (b.mo6566j()) {
                    return m28406d().mo6547e();
                }
                d2 = b.mo6558c(d2).mo6562f();
                a = b.mo6558c(d2).mo6558c(a);
                d2 = e.mo6561e().mo6558c(d2).mo6555b(a);
                e = d2.mo6555b(a).mo6558c(a.mo6551a(d2)).mo6551a(eCFieldElement2);
                return new Fp(d, e, eCFieldElement2.mo6555b(e).mo6558c(d2).mo6555b(eCFieldElement), this.f);
            } else if (k != 4) {
                return mo6573u().mo6568b((ECPoint) this);
            } else {
                return m41209b(false).mo6568b((ECPoint) this);
            }
        }

        /* renamed from: b */
        public ECPoint mo6575b(int i) {
            if (i >= 0) {
                if (i != 0) {
                    if (!m28419q()) {
                        if (i == 1) {
                            return mo6573u();
                        }
                        ECCurve d = m28406d();
                        ECFieldElement eCFieldElement = this.d;
                        if (eCFieldElement.mo6566j()) {
                            return d.mo6547e();
                        }
                        int k = d.m28387k();
                        ECFieldElement g = d.m28383g();
                        ECFieldElement eCFieldElement2 = this.c;
                        ECFieldElement a = this.e.length < 1 ? d.mo6541a(ECConstants.f23076d) : this.e[0];
                        if (!a.mo6565i()) {
                            if (k != 4) {
                                switch (k) {
                                    case 0:
                                        break;
                                    case 1:
                                        g = a.mo6561e();
                                        eCFieldElement2 = eCFieldElement2.mo6558c(a);
                                        eCFieldElement = eCFieldElement.mo6558c(g);
                                        g = m41208b(a, g);
                                        break;
                                    case 2:
                                        g = m41208b(a, null);
                                        break;
                                    default:
                                        throw new IllegalStateException("unsupported coordinate system");
                                }
                            }
                            g = m41221w();
                        }
                        ECFieldElement eCFieldElement3 = a;
                        a = g;
                        g = eCFieldElement;
                        int i2 = 0;
                        while (i2 < i) {
                            if (g.mo6566j()) {
                                return d.mo6547e();
                            }
                            ECFieldElement e = m41214e(eCFieldElement2.mo6561e());
                            ECFieldElement d2 = m41213d(g);
                            g = d2.mo6558c(g);
                            eCFieldElement2 = m41213d(eCFieldElement2.mo6558c(g));
                            g = m41213d(g.mo6561e());
                            if (!a.mo6566j()) {
                                e = e.mo6551a(a);
                                a = m41213d(g.mo6558c(a));
                            }
                            ECFieldElement b = e.mo6561e().mo6555b(m41213d(eCFieldElement2));
                            g = e.mo6558c(eCFieldElement2.mo6555b(b)).mo6555b(g);
                            eCFieldElement3 = eCFieldElement3.mo6565i() ? d2 : d2.mo6558c(eCFieldElement3);
                            i2++;
                            eCFieldElement2 = b;
                        }
                        if (k != 4) {
                            switch (k) {
                                case 0:
                                    i = eCFieldElement3.mo6562f();
                                    ECFieldElement e2 = i.mo6561e();
                                    return new Fp(d, eCFieldElement2.mo6558c(e2), g.mo6558c(e2.mo6558c(i)), this.f);
                                case 1:
                                    return new Fp(d, eCFieldElement2.mo6558c(eCFieldElement3), g, new ECFieldElement[]{eCFieldElement3.mo6558c(eCFieldElement3.mo6561e())}, this.f);
                                case 2:
                                    return new Fp(d, eCFieldElement2, g, new ECFieldElement[]{eCFieldElement3}, this.f);
                                default:
                                    throw new IllegalStateException("unsupported coordinate system");
                            }
                        }
                        return new Fp(d, eCFieldElement2, g, new ECFieldElement[]{eCFieldElement3, a}, this.f);
                    }
                }
                return this;
            }
            throw new IllegalArgumentException("'e' cannot be negative");
        }

        /* renamed from: d */
        protected ECFieldElement m41213d(ECFieldElement eCFieldElement) {
            return eCFieldElement.mo6551a(eCFieldElement);
        }

        /* renamed from: e */
        protected ECFieldElement m41214e(ECFieldElement eCFieldElement) {
            return m41213d(eCFieldElement).mo6551a(eCFieldElement);
        }

        /* renamed from: f */
        protected ECFieldElement m41216f(ECFieldElement eCFieldElement) {
            return m41213d(m41213d(eCFieldElement));
        }

        /* renamed from: g */
        protected ECFieldElement m41217g(ECFieldElement eCFieldElement) {
            return m41216f(m41213d(eCFieldElement));
        }

        /* renamed from: t */
        public ECPoint mo6572t() {
            if (m28419q()) {
                return this;
            }
            ECCurve d = m28406d();
            if (d.m28387k() != 0) {
                return new Fp(d, this.c, this.d.mo6559d(), this.e, this.f);
            }
            return new Fp(d, this.c, this.d.mo6559d(), this.f);
        }

        /* renamed from: b */
        protected ECFieldElement m41208b(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            ECFieldElement g = m28406d().m28383g();
            if (!g.mo6566j()) {
                if (!eCFieldElement.mo6565i()) {
                    if (eCFieldElement2 == null) {
                        eCFieldElement2 = eCFieldElement.mo6561e();
                    }
                    eCFieldElement = eCFieldElement2.mo6561e();
                    eCFieldElement2 = g.mo6559d();
                    if (eCFieldElement2.mo6564h() < g.mo6564h()) {
                        eCFieldElement = eCFieldElement.mo6558c(eCFieldElement2).mo6559d();
                    } else {
                        eCFieldElement = eCFieldElement.mo6558c(g);
                    }
                    return eCFieldElement;
                }
            }
            return g;
        }

        /* renamed from: w */
        protected ECFieldElement m41221w() {
            ECFieldElement eCFieldElement = this.e[1];
            if (eCFieldElement != null) {
                return eCFieldElement;
            }
            ECFieldElement[] eCFieldElementArr = this.e;
            ECFieldElement b = m41208b(this.e[0], null);
            eCFieldElementArr[1] = b;
            return b;
        }

        /* renamed from: b */
        protected Fp m41209b(boolean z) {
            ECFieldElement eCFieldElement = this.c;
            ECFieldElement eCFieldElement2 = this.d;
            ECFieldElement eCFieldElement3 = this.e[0];
            ECFieldElement w = m41221w();
            ECFieldElement a = m41214e(eCFieldElement.mo6561e()).mo6551a(w);
            ECFieldElement d = m41213d(eCFieldElement2);
            eCFieldElement2 = d.mo6558c(eCFieldElement2);
            eCFieldElement = m41213d(eCFieldElement.mo6558c(eCFieldElement2));
            ECFieldElement b = a.mo6561e().mo6555b(m41213d(eCFieldElement));
            eCFieldElement2 = m41213d(eCFieldElement2.mo6561e());
            ECFieldElement b2 = a.mo6558c(eCFieldElement.mo6555b(b)).mo6555b(eCFieldElement2);
            eCFieldElement = z ? m41213d(eCFieldElement2.mo6558c(w)) : null;
            if (!eCFieldElement3.mo6565i()) {
                d = d.mo6558c(eCFieldElement3);
            }
            return new Fp(m28406d(), b, b2, new ECFieldElement[]{d, eCFieldElement}, r0.f);
        }
    }

    /* renamed from: b */
    public abstract ECPoint mo6568b(ECPoint eCPoint);

    /* renamed from: b */
    protected abstract boolean mo5905b();

    /* renamed from: e */
    protected abstract ECPoint mo6570e();

    /* renamed from: s */
    protected abstract boolean mo5907s();

    /* renamed from: t */
    public abstract ECPoint mo6572t();

    /* renamed from: u */
    public abstract ECPoint mo6573u();

    /* renamed from: a */
    protected static ECFieldElement[] m28391a(ECCurve eCCurve) {
        int k = eCCurve == null ? 0 : eCCurve.m28387k();
        if (k == 0 || k == 5) {
            return f23092a;
        }
        ECFieldElement a = eCCurve.mo6541a(ECConstants.f23076d);
        if (k != 6) {
            switch (k) {
                case 1:
                case 2:
                    break;
                case 3:
                    return new ECFieldElement[]{a, a, a};
                case 4:
                    return new ECFieldElement[]{a, eCCurve.m28383g()};
                default:
                    throw new IllegalArgumentException("unknown coordinate system");
            }
        }
        return new ECFieldElement[]{a};
    }

    protected ECPoint(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        this(eCCurve, eCFieldElement, eCFieldElement2, m28391a(eCCurve));
    }

    protected ECPoint(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        this.f23098g = null;
        this.f23093b = eCCurve;
        this.f23094c = eCFieldElement;
        this.f23095d = eCFieldElement2;
        this.f23096e = eCFieldElementArr;
    }

    /* renamed from: a */
    protected boolean m28396a() {
        BigInteger j = this.f23093b.m28386j();
        if (!(j == null || j.equals(ECConstants.f23076d))) {
            if (ECAlgorithms.m28342a(this, j).m28419q()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    public final ECPoint m28403c() {
        return m28418p().mo6570e();
    }

    /* renamed from: d */
    public ECCurve m28406d() {
        return this.f23093b;
    }

    /* renamed from: f */
    protected int m28408f() {
        return this.f23093b == null ? 0 : this.f23093b.m28387k();
    }

    /* renamed from: g */
    public ECFieldElement m28409g() {
        m28416n();
        return m28411i();
    }

    /* renamed from: h */
    public ECFieldElement m28410h() {
        m28416n();
        return mo6571j();
    }

    /* renamed from: i */
    public ECFieldElement m28411i() {
        return this.f23094c;
    }

    /* renamed from: j */
    public ECFieldElement mo6571j() {
        return this.f23095d;
    }

    /* renamed from: a */
    public ECFieldElement mo6574a(int i) {
        if (i >= 0) {
            if (i < this.f23096e.length) {
                return this.f23096e[i];
            }
        }
        return 0;
    }

    /* renamed from: k */
    public final ECFieldElement m28413k() {
        return this.f23094c;
    }

    /* renamed from: l */
    public final ECFieldElement m28414l() {
        return this.f23095d;
    }

    /* renamed from: m */
    protected final ECFieldElement[] m28415m() {
        return this.f23096e;
    }

    /* renamed from: n */
    protected void m28416n() {
        if (!m28417o()) {
            throw new IllegalStateException("point not in normal form");
        }
    }

    /* renamed from: o */
    public boolean m28417o() {
        int f = m28408f();
        if (f == 0 || f == 5 || m28419q() || this.f23096e[0].mo6565i()) {
            return true;
        }
        return false;
    }

    /* renamed from: p */
    public ECPoint m28418p() {
        if (m28419q()) {
            return this;
        }
        int f = m28408f();
        if (f == 0 || f == 5) {
            return this;
        }
        ECFieldElement a = mo6574a(0);
        if (a.mo6565i()) {
            return this;
        }
        return m28394a(a.mo6562f());
    }

    /* renamed from: a */
    ECPoint m28394a(ECFieldElement eCFieldElement) {
        int f = m28408f();
        if (f != 6) {
            switch (f) {
                case 1:
                    break;
                case 2:
                case 3:
                case 4:
                    ECFieldElement e = eCFieldElement.mo6561e();
                    return m28395a(e, e.mo6558c(eCFieldElement));
                default:
                    throw new IllegalStateException("not a projective coordinate system");
            }
        }
        return m28395a(eCFieldElement, eCFieldElement);
    }

    /* renamed from: a */
    protected ECPoint m28395a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return m28406d().mo6542a(m28413k().mo6558c(eCFieldElement), m28414l().mo6558c(eCFieldElement2), this.f23097f);
    }

    /* renamed from: q */
    public boolean m28419q() {
        return this.f23094c == null || this.f23095d == null || (this.f23096e.length > 0 && this.f23096e[0].mo6566j());
    }

    /* renamed from: r */
    public boolean m28420r() {
        if (m28419q() || m28406d() == null || (mo5905b() && m28396a())) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public ECPoint mo5904b(ECFieldElement eCFieldElement) {
        if (m28419q()) {
            return this;
        }
        return m28406d().mo6543a(m28413k().mo6558c(eCFieldElement), m28414l(), m28415m(), this.f23097f);
    }

    /* renamed from: c */
    public ECPoint mo5906c(ECFieldElement eCFieldElement) {
        if (m28419q()) {
            return this;
        }
        return m28406d().mo6543a(m28413k(), m28414l().mo6558c(eCFieldElement), m28415m(), this.f23097f);
    }

    /* renamed from: a */
    public boolean m28397a(ECPoint eCPoint) {
        boolean z = false;
        if (eCPoint == null) {
            return false;
        }
        ECCurve d = m28406d();
        ECCurve d2 = eCPoint.m28406d();
        Object obj = d == null ? 1 : null;
        Object obj2 = d2 == null ? 1 : null;
        boolean q = m28419q();
        boolean q2 = eCPoint.m28419q();
        if (!q) {
            if (!q2) {
                ECPoint eCPoint2;
                if (obj == null || obj2 == null) {
                    if (obj != null) {
                        eCPoint = eCPoint.m28418p();
                    } else {
                        if (obj2 != null) {
                            eCPoint2 = eCPoint;
                            eCPoint = m28418p();
                        } else if (!d.m28374a(d2)) {
                            return false;
                        } else {
                            ECPoint[] eCPointArr = new ECPoint[]{this, d.mo6548a(eCPoint)};
                            d.m28370a(eCPointArr);
                            eCPoint = eCPointArr[0];
                            eCPoint2 = eCPointArr[1];
                        }
                        if (eCPoint.m28411i().equals(eCPoint2.m28411i()) && eCPoint.mo6571j().equals(eCPoint2.mo6571j()) != null) {
                            z = true;
                        }
                        return z;
                    }
                }
                eCPoint2 = eCPoint;
                eCPoint = this;
                z = true;
                return z;
            }
        }
        if (q && q2 && !(obj == null && obj2 == null && d.m28374a(d2) == null)) {
            z = true;
        }
        return z;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ECPoint) {
            return m28397a((ECPoint) obj);
        }
        return null;
    }

    public int hashCode() {
        int i;
        ECCurve d = m28406d();
        if (d == null) {
            i = 0;
        } else {
            i = ~d.hashCode();
        }
        if (m28419q()) {
            return i;
        }
        ECPoint p = m28418p();
        return (i ^ (p.m28411i().hashCode() * 17)) ^ (p.mo6571j().hashCode() * 257);
    }

    public String toString() {
        if (m28419q()) {
            return "INF";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('(');
        stringBuffer.append(m28413k());
        stringBuffer.append(',');
        stringBuffer.append(m28414l());
        for (Object append : this.f23096e) {
            stringBuffer.append(',');
            stringBuffer.append(append);
        }
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public byte[] m28398a(boolean z) {
        if (m28419q()) {
            return new byte[1];
        }
        ECPoint p = m28418p();
        Object l = p.m28411i().m36293l();
        if (z) {
            z = new byte[(l.length + true)];
            z[0] = (byte) (p.mo5907s() ? 3 : 2);
            System.arraycopy(l, 0, z, 1, l.length);
            return z;
        }
        z = p.mo6571j().m36293l();
        Object obj = new byte[((l.length + z.length) + 1)];
        obj[0] = (byte) 4;
        System.arraycopy(l, 0, obj, 1, l.length);
        System.arraycopy(z, 0, obj, l.length + 1, z.length);
        return obj;
    }

    /* renamed from: b */
    public ECPoint mo6575b(int i) {
        if (i >= 0) {
            ECPoint eCPoint = this;
            while (true) {
                i--;
                if (i < 0) {
                    return eCPoint;
                }
                eCPoint = eCPoint.mo6573u();
            }
        } else {
            throw new IllegalArgumentException("'e' cannot be negative");
        }
    }

    /* renamed from: c */
    public ECPoint mo6569c(ECPoint eCPoint) {
        return mo6573u().mo6568b(eCPoint);
    }

    /* renamed from: v */
    public ECPoint mo6576v() {
        return mo6569c(this);
    }

    /* renamed from: a */
    public ECPoint m28393a(BigInteger bigInteger) {
        return m28406d().m28389m().mo5901a(this, bigInteger);
    }
}
