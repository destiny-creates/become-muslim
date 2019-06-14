package org.spongycastle.math.ec.custom.djb;

import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.ec.ECPoint.AbstractFp;
import org.spongycastle.math.raw.Nat256;

public class Curve25519Point extends AbstractFp {
    public Curve25519Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        this(eCCurve, eCFieldElement, eCFieldElement2, false);
    }

    public Curve25519Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
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

    Curve25519Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        this.f = z;
    }

    /* renamed from: e */
    protected ECPoint mo6570e() {
        return new Curve25519Point(null, m28409g(), m28410h());
    }

    /* renamed from: a */
    public ECFieldElement mo6574a(int i) {
        if (i == 1) {
            return m41268w();
        }
        return super.mo6574a(i);
    }

    /* renamed from: b */
    public ECPoint mo6568b(ECPoint eCPoint) {
        if (m28419q()) {
            return eCPoint;
        }
        if (eCPoint.m28419q()) {
            return this;
        }
        if (this == eCPoint) {
            return mo6573u();
        }
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        ECCurve d = m28406d();
        Curve25519FieldElement curve25519FieldElement = (Curve25519FieldElement) this.c;
        Curve25519FieldElement curve25519FieldElement2 = (Curve25519FieldElement) this.d;
        Curve25519FieldElement curve25519FieldElement3 = (Curve25519FieldElement) this.e[0];
        Curve25519FieldElement curve25519FieldElement4 = (Curve25519FieldElement) eCPoint.m28411i();
        Curve25519FieldElement curve25519FieldElement5 = (Curve25519FieldElement) eCPoint.mo6571j();
        Curve25519FieldElement curve25519FieldElement6 = (Curve25519FieldElement) eCPoint.mo6574a(0);
        int[] c = Nat256.m28966c();
        int[] a = Nat256.m28950a();
        int[] a2 = Nat256.m28950a();
        int[] a3 = Nat256.m28950a();
        boolean i = curve25519FieldElement3.mo6565i();
        if (i) {
            iArr = curve25519FieldElement4.f32041b;
            iArr2 = curve25519FieldElement5.f32041b;
        } else {
            Curve25519Field.m28517d(curve25519FieldElement3.f32041b, a2);
            Curve25519Field.m28513b(a2, curve25519FieldElement4.f32041b, a);
            Curve25519Field.m28513b(a2, curve25519FieldElement3.f32041b, a2);
            Curve25519Field.m28513b(a2, curve25519FieldElement5.f32041b, a2);
            iArr = a;
            iArr2 = a2;
        }
        boolean i2 = curve25519FieldElement6.mo6565i();
        if (i2) {
            iArr3 = curve25519FieldElement.f32041b;
            iArr4 = curve25519FieldElement2.f32041b;
        } else {
            Curve25519Field.m28517d(curve25519FieldElement6.f32041b, a3);
            Curve25519Field.m28513b(a3, curve25519FieldElement.f32041b, c);
            Curve25519Field.m28513b(a3, curve25519FieldElement6.f32041b, a3);
            Curve25519Field.m28513b(a3, curve25519FieldElement2.f32041b, a3);
            iArr3 = c;
            iArr4 = a3;
        }
        int[] a4 = Nat256.m28950a();
        Curve25519Field.m28518d(iArr3, iArr, a4);
        Curve25519Field.m28518d(iArr4, iArr2, a);
        if (!Nat256.m28954b(a4)) {
            iArr = Nat256.m28950a();
            Curve25519Field.m28517d(a4, iArr);
            iArr2 = Nat256.m28950a();
            Curve25519Field.m28513b(iArr, a4, iArr2);
            Curve25519Field.m28513b(iArr, iArr3, a2);
            Curve25519Field.m28512b(iArr2, iArr2);
            Nat256.m28964c(iArr4, iArr2, c);
            Curve25519Field.m28506a(Nat256.m28952b(a2, a2, iArr2), iArr2);
            ECFieldElement curve25519FieldElement7 = new Curve25519FieldElement(a3);
            Curve25519Field.m28517d(a, curve25519FieldElement7.f32041b);
            Curve25519Field.m28518d(curve25519FieldElement7.f32041b, iArr2, curve25519FieldElement7.f32041b);
            ECFieldElement curve25519FieldElement8 = new Curve25519FieldElement(iArr2);
            Curve25519Field.m28518d(a2, curve25519FieldElement7.f32041b, curve25519FieldElement8.f32041b);
            Curve25519Field.m28516c(curve25519FieldElement8.f32041b, a, c);
            Curve25519Field.m28515c(c, curve25519FieldElement8.f32041b);
            curve25519FieldElement = new Curve25519FieldElement(a4);
            if (!i) {
                Curve25519Field.m28513b(curve25519FieldElement.f32041b, curve25519FieldElement3.f32041b, curve25519FieldElement.f32041b);
            }
            if (!i2) {
                Curve25519Field.m28513b(curve25519FieldElement.f32041b, curve25519FieldElement6.f32041b, curve25519FieldElement.f32041b);
            }
            if (!i || !i2) {
                iArr = null;
            }
            eCPoint = m41260a(curve25519FieldElement, iArr);
            return new Curve25519Point(d, curve25519FieldElement7, curve25519FieldElement8, new ECFieldElement[]{curve25519FieldElement, eCPoint}, this.f);
        } else if (Nat256.m28954b(a) != null) {
            return mo6573u();
        } else {
            return d.mo6547e();
        }
    }

    /* renamed from: u */
    public ECPoint mo6573u() {
        if (m28419q()) {
            return this;
        }
        ECCurve d = m28406d();
        if (this.d.mo6566j()) {
            return d.mo6547e();
        }
        return m41262b(true);
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
        if (this.d.mo6566j()) {
            return eCPoint;
        }
        return m41262b(false).mo6568b(eCPoint);
    }

    /* renamed from: v */
    public ECPoint mo6576v() {
        if (m28419q() || this.d.mo6566j()) {
            return this;
        }
        return m41262b(false).mo6568b((ECPoint) this);
    }

    /* renamed from: t */
    public ECPoint mo6572t() {
        if (m28419q()) {
            return this;
        }
        return new Curve25519Point(m28406d(), this.c, this.d.mo6559d(), this.e, this.f);
    }

    /* renamed from: a */
    protected Curve25519FieldElement m41260a(Curve25519FieldElement curve25519FieldElement, int[] iArr) {
        Curve25519FieldElement curve25519FieldElement2 = (Curve25519FieldElement) m28406d().m28383g();
        if (curve25519FieldElement.mo6565i()) {
            return curve25519FieldElement2;
        }
        Curve25519FieldElement curve25519FieldElement3 = new Curve25519FieldElement();
        if (iArr == null) {
            iArr = curve25519FieldElement3.f32041b;
            Curve25519Field.m28517d(curve25519FieldElement.f32041b, iArr);
        }
        Curve25519Field.m28517d(iArr, curve25519FieldElement3.f32041b);
        Curve25519Field.m28513b(curve25519FieldElement3.f32041b, curve25519FieldElement2.f32041b, curve25519FieldElement3.f32041b);
        return curve25519FieldElement3;
    }

    /* renamed from: w */
    protected Curve25519FieldElement m41268w() {
        Curve25519FieldElement curve25519FieldElement = (Curve25519FieldElement) this.e[1];
        if (curve25519FieldElement != null) {
            return curve25519FieldElement;
        }
        ECFieldElement[] eCFieldElementArr = this.e;
        Curve25519FieldElement a = m41260a((Curve25519FieldElement) this.e[0], null);
        eCFieldElementArr[1] = a;
        return a;
    }

    /* renamed from: b */
    protected Curve25519Point m41262b(boolean z) {
        Curve25519FieldElement curve25519FieldElement = (Curve25519FieldElement) this.c;
        Curve25519FieldElement curve25519FieldElement2 = (Curve25519FieldElement) this.d;
        Curve25519FieldElement curve25519FieldElement3 = (Curve25519FieldElement) this.e[0];
        Curve25519FieldElement w = m41268w();
        int[] a = Nat256.m28950a();
        Curve25519Field.m28517d(curve25519FieldElement.f32041b, a);
        Curve25519Field.m28506a(Nat256.m28952b(a, a, a) + Nat256.m28943a(w.f32041b, a), a);
        int[] a2 = Nat256.m28950a();
        Curve25519Field.m28519e(curve25519FieldElement2.f32041b, a2);
        int[] a3 = Nat256.m28950a();
        Curve25519Field.m28513b(a2, curve25519FieldElement2.f32041b, a3);
        int[] a4 = Nat256.m28950a();
        Curve25519Field.m28513b(a3, curve25519FieldElement.f32041b, a4);
        Curve25519Field.m28519e(a4, a4);
        int[] a5 = Nat256.m28950a();
        Curve25519Field.m28517d(a3, a5);
        Curve25519Field.m28519e(a5, a5);
        ECFieldElement curve25519FieldElement4 = new Curve25519FieldElement(a3);
        Curve25519Field.m28517d(a, curve25519FieldElement4.f32041b);
        Curve25519Field.m28518d(curve25519FieldElement4.f32041b, a4, curve25519FieldElement4.f32041b);
        Curve25519Field.m28518d(curve25519FieldElement4.f32041b, a4, curve25519FieldElement4.f32041b);
        ECFieldElement curve25519FieldElement5 = new Curve25519FieldElement(a4);
        Curve25519Field.m28518d(a4, curve25519FieldElement4.f32041b, curve25519FieldElement5.f32041b);
        Curve25519Field.m28513b(curve25519FieldElement5.f32041b, a, curve25519FieldElement5.f32041b);
        Curve25519Field.m28518d(curve25519FieldElement5.f32041b, a5, curve25519FieldElement5.f32041b);
        curve25519FieldElement2 = new Curve25519FieldElement(a2);
        if (!Nat256.m28946a(curve25519FieldElement3.f32041b)) {
            Curve25519Field.m28513b(curve25519FieldElement2.f32041b, curve25519FieldElement3.f32041b, curve25519FieldElement2.f32041b);
        }
        curve25519FieldElement3 = null;
        if (z) {
            curve25519FieldElement3 = new Curve25519FieldElement(a5);
            Curve25519Field.m28513b(curve25519FieldElement3.f32041b, w.f32041b, curve25519FieldElement3.f32041b);
            Curve25519Field.m28519e(curve25519FieldElement3.f32041b, curve25519FieldElement3.f32041b);
        }
        return new Curve25519Point(m28406d(), curve25519FieldElement4, curve25519FieldElement5, new ECFieldElement[]{curve25519FieldElement2, curve25519FieldElement3}, this.f);
    }
}
