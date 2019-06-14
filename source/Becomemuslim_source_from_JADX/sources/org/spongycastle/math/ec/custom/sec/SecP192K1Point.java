package org.spongycastle.math.ec.custom.sec;

import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.ec.ECPoint.AbstractFp;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat192;

public class SecP192K1Point extends AbstractFp {
    public SecP192K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        this(eCCurve, eCFieldElement, eCFieldElement2, false);
    }

    public SecP192K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
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

    SecP192K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        this.f = z;
    }

    /* renamed from: e */
    protected ECPoint mo6570e() {
        return new SecP192K1Point(null, m28409g(), m28410h());
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
        SecP192K1FieldElement secP192K1FieldElement = (SecP192K1FieldElement) this.c;
        SecP192K1FieldElement secP192K1FieldElement2 = (SecP192K1FieldElement) this.d;
        SecP192K1FieldElement secP192K1FieldElement3 = (SecP192K1FieldElement) eCPoint.m28411i();
        SecP192K1FieldElement secP192K1FieldElement4 = (SecP192K1FieldElement) eCPoint.mo6571j();
        SecP192K1FieldElement secP192K1FieldElement5 = (SecP192K1FieldElement) this.e[0];
        SecP192K1FieldElement secP192K1FieldElement6 = (SecP192K1FieldElement) eCPoint.mo6574a(0);
        int[] c = Nat192.m28910c();
        int[] a = Nat192.m28894a();
        int[] a2 = Nat192.m28894a();
        int[] a3 = Nat192.m28894a();
        boolean i = secP192K1FieldElement5.mo6565i();
        if (i) {
            iArr = secP192K1FieldElement3.f32059b;
            iArr2 = secP192K1FieldElement4.f32059b;
        } else {
            SecP192K1Field.m28567d(secP192K1FieldElement5.f32059b, a2);
            SecP192K1Field.m28564b(a2, secP192K1FieldElement3.f32059b, a);
            SecP192K1Field.m28564b(a2, secP192K1FieldElement5.f32059b, a2);
            SecP192K1Field.m28564b(a2, secP192K1FieldElement4.f32059b, a2);
            iArr = a;
            iArr2 = a2;
        }
        boolean i2 = secP192K1FieldElement6.mo6565i();
        if (i2) {
            iArr3 = secP192K1FieldElement.f32059b;
            iArr4 = secP192K1FieldElement2.f32059b;
        } else {
            SecP192K1Field.m28567d(secP192K1FieldElement6.f32059b, a3);
            SecP192K1Field.m28564b(a3, secP192K1FieldElement.f32059b, c);
            SecP192K1Field.m28564b(a3, secP192K1FieldElement6.f32059b, a3);
            SecP192K1Field.m28564b(a3, secP192K1FieldElement2.f32059b, a3);
            iArr3 = c;
            iArr4 = a3;
        }
        int[] a4 = Nat192.m28894a();
        SecP192K1Field.m28568d(iArr3, iArr, a4);
        SecP192K1Field.m28568d(iArr4, iArr2, a);
        if (!Nat192.m28898b(a4)) {
            SecP192K1Field.m28567d(a4, a2);
            iArr = Nat192.m28894a();
            SecP192K1Field.m28564b(a2, a4, iArr);
            SecP192K1Field.m28564b(a2, iArr3, a2);
            SecP192K1Field.m28563b(iArr, iArr);
            Nat192.m28909c(iArr4, iArr, c);
            SecP192K1Field.m28558a(Nat192.m28896b(a2, a2, iArr), iArr);
            ECFieldElement secP192K1FieldElement7 = new SecP192K1FieldElement(a3);
            SecP192K1Field.m28567d(a, secP192K1FieldElement7.f32059b);
            SecP192K1Field.m28568d(secP192K1FieldElement7.f32059b, iArr, secP192K1FieldElement7.f32059b);
            ECFieldElement secP192K1FieldElement8 = new SecP192K1FieldElement(iArr);
            SecP192K1Field.m28568d(a2, secP192K1FieldElement7.f32059b, secP192K1FieldElement8.f32059b);
            SecP192K1Field.m28566c(secP192K1FieldElement8.f32059b, a, c);
            SecP192K1Field.m28565c(c, secP192K1FieldElement8.f32059b);
            secP192K1FieldElement = new SecP192K1FieldElement(a4);
            if (!i) {
                SecP192K1Field.m28564b(secP192K1FieldElement.f32059b, secP192K1FieldElement5.f32059b, secP192K1FieldElement.f32059b);
            }
            if (!i2) {
                SecP192K1Field.m28564b(secP192K1FieldElement.f32059b, secP192K1FieldElement6.f32059b, secP192K1FieldElement.f32059b);
            }
            return new SecP192K1Point(d, secP192K1FieldElement7, secP192K1FieldElement8, new ECFieldElement[]{secP192K1FieldElement}, this.f);
        } else if (Nat192.m28898b(a) != null) {
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
        SecP192K1FieldElement secP192K1FieldElement = (SecP192K1FieldElement) this.d;
        if (secP192K1FieldElement.mo6566j()) {
            return d.mo6547e();
        }
        SecP192K1FieldElement secP192K1FieldElement2 = (SecP192K1FieldElement) this.c;
        SecP192K1FieldElement secP192K1FieldElement3 = (SecP192K1FieldElement) this.e[0];
        int[] a = Nat192.m28894a();
        SecP192K1Field.m28567d(secP192K1FieldElement.f32059b, a);
        int[] a2 = Nat192.m28894a();
        SecP192K1Field.m28567d(a, a2);
        int[] a3 = Nat192.m28894a();
        SecP192K1Field.m28567d(secP192K1FieldElement2.f32059b, a3);
        SecP192K1Field.m28558a(Nat192.m28896b(a3, a3, a3), a3);
        SecP192K1Field.m28564b(a, secP192K1FieldElement2.f32059b, a);
        SecP192K1Field.m28558a(Nat.m29029c(6, a, 2, 0), a);
        int[] a4 = Nat192.m28894a();
        SecP192K1Field.m28558a(Nat.m29005a(6, a2, 3, 0, a4), a4);
        ECFieldElement secP192K1FieldElement4 = new SecP192K1FieldElement(a2);
        SecP192K1Field.m28567d(a3, secP192K1FieldElement4.f32059b);
        SecP192K1Field.m28568d(secP192K1FieldElement4.f32059b, a, secP192K1FieldElement4.f32059b);
        SecP192K1Field.m28568d(secP192K1FieldElement4.f32059b, a, secP192K1FieldElement4.f32059b);
        ECFieldElement secP192K1FieldElement5 = new SecP192K1FieldElement(a);
        SecP192K1Field.m28568d(a, secP192K1FieldElement4.f32059b, secP192K1FieldElement5.f32059b);
        SecP192K1Field.m28564b(secP192K1FieldElement5.f32059b, a3, secP192K1FieldElement5.f32059b);
        SecP192K1Field.m28568d(secP192K1FieldElement5.f32059b, a4, secP192K1FieldElement5.f32059b);
        secP192K1FieldElement2 = new SecP192K1FieldElement(a3);
        SecP192K1Field.m28569e(secP192K1FieldElement.f32059b, secP192K1FieldElement2.f32059b);
        if (!secP192K1FieldElement3.mo6565i()) {
            SecP192K1Field.m28564b(secP192K1FieldElement2.f32059b, secP192K1FieldElement3.f32059b, secP192K1FieldElement2.f32059b);
        }
        return new SecP192K1Point(d, secP192K1FieldElement4, secP192K1FieldElement5, new ECFieldElement[]{secP192K1FieldElement2}, this.f);
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
        return new SecP192K1Point(this.b, this.c, this.d.mo6559d(), this.e, this.f);
    }
}
