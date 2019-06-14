package org.spongycastle.math.ec.custom.sec;

import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.ec.ECPoint.AbstractFp;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat224;

public class SecP224K1Point extends AbstractFp {
    public SecP224K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        this(eCCurve, eCFieldElement, eCFieldElement2, false);
    }

    public SecP224K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
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

    SecP224K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        this.f = z;
    }

    /* renamed from: e */
    protected ECPoint mo6570e() {
        return new SecP224K1Point(null, m28409g(), m28410h());
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
        SecP224K1FieldElement secP224K1FieldElement = (SecP224K1FieldElement) this.c;
        SecP224K1FieldElement secP224K1FieldElement2 = (SecP224K1FieldElement) this.d;
        SecP224K1FieldElement secP224K1FieldElement3 = (SecP224K1FieldElement) eCPoint.m28411i();
        SecP224K1FieldElement secP224K1FieldElement4 = (SecP224K1FieldElement) eCPoint.mo6571j();
        SecP224K1FieldElement secP224K1FieldElement5 = (SecP224K1FieldElement) this.e[0];
        SecP224K1FieldElement secP224K1FieldElement6 = (SecP224K1FieldElement) eCPoint.mo6574a(0);
        int[] b = Nat224.m28928b();
        int[] a = Nat224.m28923a();
        int[] a2 = Nat224.m28923a();
        int[] a3 = Nat224.m28923a();
        boolean i = secP224K1FieldElement5.mo6565i();
        if (i) {
            iArr = secP224K1FieldElement3.f32068b;
            iArr2 = secP224K1FieldElement4.f32068b;
        } else {
            SecP224K1Field.m28593d(secP224K1FieldElement5.f32068b, a2);
            SecP224K1Field.m28590b(a2, secP224K1FieldElement3.f32068b, a);
            SecP224K1Field.m28590b(a2, secP224K1FieldElement5.f32068b, a2);
            SecP224K1Field.m28590b(a2, secP224K1FieldElement4.f32068b, a2);
            iArr = a;
            iArr2 = a2;
        }
        boolean i2 = secP224K1FieldElement6.mo6565i();
        if (i2) {
            iArr3 = secP224K1FieldElement.f32068b;
            iArr4 = secP224K1FieldElement2.f32068b;
        } else {
            SecP224K1Field.m28593d(secP224K1FieldElement6.f32068b, a3);
            SecP224K1Field.m28590b(a3, secP224K1FieldElement.f32068b, b);
            SecP224K1Field.m28590b(a3, secP224K1FieldElement6.f32068b, a3);
            SecP224K1Field.m28590b(a3, secP224K1FieldElement2.f32068b, a3);
            iArr3 = b;
            iArr4 = a3;
        }
        int[] a4 = Nat224.m28923a();
        SecP224K1Field.m28594d(iArr3, iArr, a4);
        SecP224K1Field.m28594d(iArr4, iArr2, a);
        if (!Nat224.m28926b(a4)) {
            SecP224K1Field.m28593d(a4, a2);
            iArr = Nat224.m28923a();
            SecP224K1Field.m28590b(a2, a4, iArr);
            SecP224K1Field.m28590b(a2, iArr3, a2);
            SecP224K1Field.m28589b(iArr, iArr);
            Nat224.m28930c(iArr4, iArr, b);
            SecP224K1Field.m28584a(Nat224.m28925b(a2, a2, iArr), iArr);
            ECFieldElement secP224K1FieldElement7 = new SecP224K1FieldElement(a3);
            SecP224K1Field.m28593d(a, secP224K1FieldElement7.f32068b);
            SecP224K1Field.m28594d(secP224K1FieldElement7.f32068b, iArr, secP224K1FieldElement7.f32068b);
            ECFieldElement secP224K1FieldElement8 = new SecP224K1FieldElement(iArr);
            SecP224K1Field.m28594d(a2, secP224K1FieldElement7.f32068b, secP224K1FieldElement8.f32068b);
            SecP224K1Field.m28592c(secP224K1FieldElement8.f32068b, a, b);
            SecP224K1Field.m28591c(b, secP224K1FieldElement8.f32068b);
            secP224K1FieldElement = new SecP224K1FieldElement(a4);
            if (!i) {
                SecP224K1Field.m28590b(secP224K1FieldElement.f32068b, secP224K1FieldElement5.f32068b, secP224K1FieldElement.f32068b);
            }
            if (!i2) {
                SecP224K1Field.m28590b(secP224K1FieldElement.f32068b, secP224K1FieldElement6.f32068b, secP224K1FieldElement.f32068b);
            }
            return new SecP224K1Point(d, secP224K1FieldElement7, secP224K1FieldElement8, new ECFieldElement[]{secP224K1FieldElement}, this.f);
        } else if (Nat224.m28926b(a) != null) {
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
        SecP224K1FieldElement secP224K1FieldElement = (SecP224K1FieldElement) this.d;
        if (secP224K1FieldElement.mo6566j()) {
            return d.mo6547e();
        }
        SecP224K1FieldElement secP224K1FieldElement2 = (SecP224K1FieldElement) this.c;
        SecP224K1FieldElement secP224K1FieldElement3 = (SecP224K1FieldElement) this.e[0];
        int[] a = Nat224.m28923a();
        SecP224K1Field.m28593d(secP224K1FieldElement.f32068b, a);
        int[] a2 = Nat224.m28923a();
        SecP224K1Field.m28593d(a, a2);
        int[] a3 = Nat224.m28923a();
        SecP224K1Field.m28593d(secP224K1FieldElement2.f32068b, a3);
        SecP224K1Field.m28584a(Nat224.m28925b(a3, a3, a3), a3);
        SecP224K1Field.m28590b(a, secP224K1FieldElement2.f32068b, a);
        SecP224K1Field.m28584a(Nat.m29029c(7, a, 2, 0), a);
        int[] a4 = Nat224.m28923a();
        SecP224K1Field.m28584a(Nat.m29005a(7, a2, 3, 0, a4), a4);
        ECFieldElement secP224K1FieldElement4 = new SecP224K1FieldElement(a2);
        SecP224K1Field.m28593d(a3, secP224K1FieldElement4.f32068b);
        SecP224K1Field.m28594d(secP224K1FieldElement4.f32068b, a, secP224K1FieldElement4.f32068b);
        SecP224K1Field.m28594d(secP224K1FieldElement4.f32068b, a, secP224K1FieldElement4.f32068b);
        ECFieldElement secP224K1FieldElement5 = new SecP224K1FieldElement(a);
        SecP224K1Field.m28594d(a, secP224K1FieldElement4.f32068b, secP224K1FieldElement5.f32068b);
        SecP224K1Field.m28590b(secP224K1FieldElement5.f32068b, a3, secP224K1FieldElement5.f32068b);
        SecP224K1Field.m28594d(secP224K1FieldElement5.f32068b, a4, secP224K1FieldElement5.f32068b);
        secP224K1FieldElement2 = new SecP224K1FieldElement(a3);
        SecP224K1Field.m28595e(secP224K1FieldElement.f32068b, secP224K1FieldElement2.f32068b);
        if (!secP224K1FieldElement3.mo6565i()) {
            SecP224K1Field.m28590b(secP224K1FieldElement2.f32068b, secP224K1FieldElement3.f32068b, secP224K1FieldElement2.f32068b);
        }
        return new SecP224K1Point(d, secP224K1FieldElement4, secP224K1FieldElement5, new ECFieldElement[]{secP224K1FieldElement2}, this.f);
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
        return mo6573u().mo6568b(eCPoint);
    }

    /* renamed from: v */
    public ECPoint mo6576v() {
        if (!m28419q()) {
            if (!this.d.mo6566j()) {
                return mo6573u().mo6568b((ECPoint) this);
            }
        }
        return this;
    }

    /* renamed from: t */
    public ECPoint mo6572t() {
        if (m28419q()) {
            return this;
        }
        return new SecP224K1Point(this.b, this.c, this.d.mo6559d(), this.e, this.f);
    }
}
