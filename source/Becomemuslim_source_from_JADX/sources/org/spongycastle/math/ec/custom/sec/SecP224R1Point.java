package org.spongycastle.math.ec.custom.sec;

import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.ec.ECPoint.AbstractFp;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat224;

public class SecP224R1Point extends AbstractFp {
    public SecP224R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        this(eCCurve, eCFieldElement, eCFieldElement2, false);
    }

    public SecP224R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
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

    SecP224R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        this.f = z;
    }

    /* renamed from: e */
    protected ECPoint mo6570e() {
        return new SecP224R1Point(null, m28409g(), m28410h());
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
        SecP224R1FieldElement secP224R1FieldElement = (SecP224R1FieldElement) this.c;
        SecP224R1FieldElement secP224R1FieldElement2 = (SecP224R1FieldElement) this.d;
        SecP224R1FieldElement secP224R1FieldElement3 = (SecP224R1FieldElement) eCPoint.m28411i();
        SecP224R1FieldElement secP224R1FieldElement4 = (SecP224R1FieldElement) eCPoint.mo6571j();
        SecP224R1FieldElement secP224R1FieldElement5 = (SecP224R1FieldElement) this.e[0];
        SecP224R1FieldElement secP224R1FieldElement6 = (SecP224R1FieldElement) eCPoint.mo6574a(0);
        int[] b = Nat224.m28928b();
        int[] a = Nat224.m28923a();
        int[] a2 = Nat224.m28923a();
        int[] a3 = Nat224.m28923a();
        boolean i = secP224R1FieldElement5.mo6565i();
        if (i) {
            iArr = secP224R1FieldElement3.f32072b;
            iArr2 = secP224R1FieldElement4.f32072b;
        } else {
            SecP224R1Field.m28607d(secP224R1FieldElement5.f32072b, a2);
            SecP224R1Field.m28604b(a2, secP224R1FieldElement3.f32072b, a);
            SecP224R1Field.m28604b(a2, secP224R1FieldElement5.f32072b, a2);
            SecP224R1Field.m28604b(a2, secP224R1FieldElement4.f32072b, a2);
            iArr = a;
            iArr2 = a2;
        }
        boolean i2 = secP224R1FieldElement6.mo6565i();
        if (i2) {
            iArr3 = secP224R1FieldElement.f32072b;
            iArr4 = secP224R1FieldElement2.f32072b;
        } else {
            SecP224R1Field.m28607d(secP224R1FieldElement6.f32072b, a3);
            SecP224R1Field.m28604b(a3, secP224R1FieldElement.f32072b, b);
            SecP224R1Field.m28604b(a3, secP224R1FieldElement6.f32072b, a3);
            SecP224R1Field.m28604b(a3, secP224R1FieldElement2.f32072b, a3);
            iArr3 = b;
            iArr4 = a3;
        }
        int[] a4 = Nat224.m28923a();
        SecP224R1Field.m28608d(iArr3, iArr, a4);
        SecP224R1Field.m28608d(iArr4, iArr2, a);
        if (!Nat224.m28926b(a4)) {
            SecP224R1Field.m28607d(a4, a2);
            iArr = Nat224.m28923a();
            SecP224R1Field.m28604b(a2, a4, iArr);
            SecP224R1Field.m28604b(a2, iArr3, a2);
            SecP224R1Field.m28603b(iArr, iArr);
            Nat224.m28930c(iArr4, iArr, b);
            SecP224R1Field.m28596a(Nat224.m28925b(a2, a2, iArr), iArr);
            ECFieldElement secP224R1FieldElement7 = new SecP224R1FieldElement(a3);
            SecP224R1Field.m28607d(a, secP224R1FieldElement7.f32072b);
            SecP224R1Field.m28608d(secP224R1FieldElement7.f32072b, iArr, secP224R1FieldElement7.f32072b);
            ECFieldElement secP224R1FieldElement8 = new SecP224R1FieldElement(iArr);
            SecP224R1Field.m28608d(a2, secP224R1FieldElement7.f32072b, secP224R1FieldElement8.f32072b);
            SecP224R1Field.m28606c(secP224R1FieldElement8.f32072b, a, b);
            SecP224R1Field.m28605c(b, secP224R1FieldElement8.f32072b);
            secP224R1FieldElement = new SecP224R1FieldElement(a4);
            if (!i) {
                SecP224R1Field.m28604b(secP224R1FieldElement.f32072b, secP224R1FieldElement5.f32072b, secP224R1FieldElement.f32072b);
            }
            if (!i2) {
                SecP224R1Field.m28604b(secP224R1FieldElement.f32072b, secP224R1FieldElement6.f32072b, secP224R1FieldElement.f32072b);
            }
            return new SecP224R1Point(d, secP224R1FieldElement7, secP224R1FieldElement8, new ECFieldElement[]{secP224R1FieldElement}, this.f);
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
        SecP224R1FieldElement secP224R1FieldElement = (SecP224R1FieldElement) this.d;
        if (secP224R1FieldElement.mo6566j()) {
            return d.mo6547e();
        }
        SecP224R1FieldElement secP224R1FieldElement2 = (SecP224R1FieldElement) this.c;
        SecP224R1FieldElement secP224R1FieldElement3 = (SecP224R1FieldElement) this.e[0];
        int[] a = Nat224.m28923a();
        int[] a2 = Nat224.m28923a();
        int[] a3 = Nat224.m28923a();
        SecP224R1Field.m28607d(secP224R1FieldElement.f32072b, a3);
        int[] a4 = Nat224.m28923a();
        SecP224R1Field.m28607d(a3, a4);
        boolean i = secP224R1FieldElement3.mo6565i();
        int[] iArr = secP224R1FieldElement3.f32072b;
        if (!i) {
            SecP224R1Field.m28607d(secP224R1FieldElement3.f32072b, a2);
            iArr = a2;
        }
        SecP224R1Field.m28608d(secP224R1FieldElement2.f32072b, iArr, a);
        SecP224R1Field.m28600a(secP224R1FieldElement2.f32072b, iArr, a2);
        SecP224R1Field.m28604b(a2, a, a2);
        SecP224R1Field.m28596a(Nat224.m28925b(a2, a2, a2), a2);
        SecP224R1Field.m28604b(a3, secP224R1FieldElement2.f32072b, a3);
        SecP224R1Field.m28596a(Nat.m29029c(7, a3, 2, 0), a3);
        SecP224R1Field.m28596a(Nat.m29005a(7, a4, 3, 0, a), a);
        ECFieldElement secP224R1FieldElement4 = new SecP224R1FieldElement(a4);
        SecP224R1Field.m28607d(a2, secP224R1FieldElement4.f32072b);
        SecP224R1Field.m28608d(secP224R1FieldElement4.f32072b, a3, secP224R1FieldElement4.f32072b);
        SecP224R1Field.m28608d(secP224R1FieldElement4.f32072b, a3, secP224R1FieldElement4.f32072b);
        ECFieldElement secP224R1FieldElement5 = new SecP224R1FieldElement(a3);
        SecP224R1Field.m28608d(a3, secP224R1FieldElement4.f32072b, secP224R1FieldElement5.f32072b);
        SecP224R1Field.m28604b(secP224R1FieldElement5.f32072b, a2, secP224R1FieldElement5.f32072b);
        SecP224R1Field.m28608d(secP224R1FieldElement5.f32072b, a, secP224R1FieldElement5.f32072b);
        secP224R1FieldElement2 = new SecP224R1FieldElement(a2);
        SecP224R1Field.m28609e(secP224R1FieldElement.f32072b, secP224R1FieldElement2.f32072b);
        if (!i) {
            SecP224R1Field.m28604b(secP224R1FieldElement2.f32072b, secP224R1FieldElement3.f32072b, secP224R1FieldElement2.f32072b);
        }
        return new SecP224R1Point(d, secP224R1FieldElement4, secP224R1FieldElement5, new ECFieldElement[]{secP224R1FieldElement2}, this.f);
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
        return new SecP224R1Point(this.b, this.c, this.d.mo6559d(), this.e, this.f);
    }
}
