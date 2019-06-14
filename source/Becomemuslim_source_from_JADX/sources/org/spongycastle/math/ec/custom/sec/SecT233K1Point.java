package org.spongycastle.math.ec.custom.sec;

import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.ec.ECPoint.AbstractF2m;

public class SecT233K1Point extends AbstractF2m {
    public SecT233K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        this(eCCurve, eCFieldElement, eCFieldElement2, false);
    }

    public SecT233K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
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

    SecT233K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        this.f = z;
    }

    /* renamed from: e */
    protected ECPoint mo6570e() {
        return new SecT233K1Point(null, m28409g(), m28410h());
    }

    /* renamed from: j */
    public ECFieldElement mo6571j() {
        ECFieldElement eCFieldElement = this.c;
        ECFieldElement eCFieldElement2 = this.d;
        if (!m28419q()) {
            if (!eCFieldElement.mo6566j()) {
                eCFieldElement = eCFieldElement2.mo6551a(eCFieldElement).mo6558c(eCFieldElement);
                eCFieldElement2 = this.e[0];
                if (!eCFieldElement2.mo6565i()) {
                    eCFieldElement = eCFieldElement.mo6560d(eCFieldElement2);
                }
                return eCFieldElement;
            }
        }
        return eCFieldElement2;
    }

    /* renamed from: s */
    protected boolean mo5907s() {
        ECFieldElement k = m28413k();
        boolean z = false;
        if (k.mo6566j()) {
            return false;
        }
        if (m28414l().mo6567k() != k.mo6567k()) {
            z = true;
        }
        return z;
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
        ECFieldElement eCFieldElement = this.c;
        ECFieldElement k = eCPoint.m28413k();
        if (!eCFieldElement.mo6566j()) {
            ECFieldElement eCFieldElement2;
            ECFieldElement eCFieldElement3;
            ECFieldElement eCFieldElement4;
            ECFieldElement eCFieldElement5 = this.d;
            ECFieldElement eCFieldElement6 = this.e[0];
            ECFieldElement l = eCPoint.m28414l();
            eCPoint = eCPoint.mo6574a(0);
            boolean i = eCFieldElement6.mo6565i();
            if (i) {
                eCFieldElement2 = k;
                eCFieldElement3 = l;
            } else {
                eCFieldElement2 = k.mo6558c(eCFieldElement6);
                eCFieldElement3 = l.mo6558c(eCFieldElement6);
            }
            boolean i2 = eCPoint.mo6565i();
            if (i2) {
                eCFieldElement4 = eCFieldElement5;
            } else {
                eCFieldElement = eCFieldElement.mo6558c(eCPoint);
                eCFieldElement4 = eCFieldElement5.mo6558c(eCPoint);
            }
            eCFieldElement3 = eCFieldElement4.mo6551a(eCFieldElement3);
            eCFieldElement4 = eCFieldElement.mo6551a(eCFieldElement2);
            if (!eCFieldElement4.mo6566j()) {
                if (k.mo6566j()) {
                    eCPoint = m28418p();
                    eCFieldElement = eCPoint.m28411i();
                    ECFieldElement j = eCPoint.mo6571j();
                    k = j.mo6551a(l).mo6560d(eCFieldElement);
                    eCFieldElement5 = k.mo6561e().mo6551a(k).mo6551a(eCFieldElement);
                    if (eCFieldElement5.mo6566j()) {
                        return new SecT233K1Point(d, eCFieldElement5, d.m28384h(), this.f);
                    }
                    eCFieldElement6 = k.mo6558c(eCFieldElement.mo6551a(eCFieldElement5)).mo6551a(eCFieldElement5).mo6551a(j).mo6560d(eCFieldElement5).mo6551a(eCFieldElement5);
                    eCPoint = d.mo6541a(ECConstants.f23076d);
                } else {
                    k = eCFieldElement4.mo6561e();
                    eCFieldElement = eCFieldElement3.mo6558c(eCFieldElement);
                    l = eCFieldElement3.mo6558c(eCFieldElement2);
                    eCFieldElement = eCFieldElement.mo6558c(l);
                    if (eCFieldElement.mo6566j()) {
                        return new SecT233K1Point(d, eCFieldElement, d.m28384h(), this.f);
                    }
                    eCFieldElement2 = eCFieldElement3.mo6558c(k);
                    eCPoint = !i2 ? eCFieldElement2.mo6558c(eCPoint) : eCFieldElement2;
                    k = l.mo6551a(k).mo6552a(eCPoint, eCFieldElement5.mo6551a(eCFieldElement6));
                    if (!i) {
                        eCPoint = eCPoint.mo6558c(eCFieldElement6);
                    }
                    eCFieldElement5 = eCFieldElement;
                    eCFieldElement6 = k;
                }
                return new SecT233K1Point(d, eCFieldElement5, eCFieldElement6, new ECFieldElement[]{eCPoint}, this.f);
            } else if (eCFieldElement3.mo6566j() != null) {
                return mo6573u();
            } else {
                return d.mo6547e();
            }
        } else if (k.mo6566j()) {
            return d.mo6547e();
        } else {
            return eCPoint.mo6568b((ECPoint) this);
        }
    }

    /* renamed from: u */
    public ECPoint mo6573u() {
        if (m28419q()) {
            return this;
        }
        ECCurve d = m28406d();
        ECFieldElement eCFieldElement = this.c;
        if (eCFieldElement.mo6566j()) {
            return d.mo6547e();
        }
        ECFieldElement eCFieldElement2;
        ECFieldElement a;
        ECFieldElement eCFieldElement3 = this.d;
        ECFieldElement eCFieldElement4 = this.e[0];
        boolean i = eCFieldElement4.mo6565i();
        if (i) {
            eCFieldElement2 = eCFieldElement4;
        } else {
            eCFieldElement2 = eCFieldElement4.mo6561e();
        }
        if (i) {
            a = eCFieldElement3.mo6561e().mo6551a(eCFieldElement3);
        } else {
            a = eCFieldElement3.mo6551a(eCFieldElement4).mo6558c(eCFieldElement3);
        }
        if (a.mo6566j()) {
            return new SecT233K1Point(d, a, d.m28384h(), this.f);
        }
        ECFieldElement eCFieldElement5;
        ECFieldElement e = a.mo6561e();
        if (i) {
            eCFieldElement5 = a;
        } else {
            eCFieldElement5 = a.mo6558c(eCFieldElement2);
        }
        eCFieldElement = eCFieldElement3.mo6551a(eCFieldElement).mo6561e();
        if (!i) {
            eCFieldElement4 = eCFieldElement2.mo6561e();
        }
        eCFieldElement = eCFieldElement.mo6551a(a).mo6551a(eCFieldElement2).mo6558c(eCFieldElement).mo6551a(eCFieldElement4).mo6551a(e).mo6551a(eCFieldElement5);
        return new SecT233K1Point(d, e, eCFieldElement, new ECFieldElement[]{eCFieldElement5}, this.f);
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
        ECFieldElement k = eCPoint.m28413k();
        ECFieldElement a = eCPoint.mo6574a(0);
        if (!k.mo6566j()) {
            if (a.mo6565i()) {
                a = this.d;
                ECFieldElement eCFieldElement2 = this.e[0];
                ECFieldElement l = eCPoint.m28414l();
                eCFieldElement = eCFieldElement.mo6561e();
                ECFieldElement e = a.mo6561e();
                ECFieldElement e2 = eCFieldElement2.mo6561e();
                a = e.mo6551a(a.mo6558c(eCFieldElement2));
                eCFieldElement2 = l.mo6557c();
                eCFieldElement = eCFieldElement2.mo6558c(e2).mo6551a(e).mo6556b(a, eCFieldElement, e2);
                k = k.mo6558c(e2);
                l = k.mo6551a(a).mo6561e();
                if (l.mo6566j()) {
                    if (eCFieldElement.mo6566j()) {
                        return eCPoint.mo6573u();
                    }
                    return d.mo6547e();
                } else if (eCFieldElement.mo6566j() != null) {
                    return new SecT233K1Point(d, eCFieldElement, d.m28384h(), this.f);
                } else {
                    return new SecT233K1Point(d, eCFieldElement.mo6561e().mo6558c(k), eCFieldElement.mo6551a(l).mo6561e().mo6556b(a, eCFieldElement2, eCFieldElement.mo6558c(l).mo6558c(e2)), new ECFieldElement[]{eCPoint}, this.f);
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
        ECFieldElement eCFieldElement2 = this.d;
        ECFieldElement eCFieldElement3 = this.e[0];
        ECCurve eCCurve = this.b;
        ECFieldElement[] eCFieldElementArr = new ECFieldElement[]{eCFieldElement3};
        return new SecT233K1Point(eCCurve, eCFieldElement, eCFieldElement2.mo6551a(eCFieldElement3), eCFieldElementArr, this.f);
    }
}
