package org.spongycastle.math.ec.custom.sec;

import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.ec.ECPoint.AbstractFp;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat256;

public class SecP256K1Point extends AbstractFp {
    public SecP256K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        this(eCCurve, eCFieldElement, eCFieldElement2, false);
    }

    public SecP256K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
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

    SecP256K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        this.f = z;
    }

    /* renamed from: e */
    protected ECPoint mo6570e() {
        return new SecP256K1Point(null, m28409g(), m28410h());
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
        SecP256K1FieldElement secP256K1FieldElement = (SecP256K1FieldElement) this.c;
        SecP256K1FieldElement secP256K1FieldElement2 = (SecP256K1FieldElement) this.d;
        SecP256K1FieldElement secP256K1FieldElement3 = (SecP256K1FieldElement) eCPoint.m28411i();
        SecP256K1FieldElement secP256K1FieldElement4 = (SecP256K1FieldElement) eCPoint.mo6571j();
        SecP256K1FieldElement secP256K1FieldElement5 = (SecP256K1FieldElement) this.e[0];
        SecP256K1FieldElement secP256K1FieldElement6 = (SecP256K1FieldElement) eCPoint.mo6574a(0);
        int[] c = Nat256.m28966c();
        int[] a = Nat256.m28950a();
        int[] a2 = Nat256.m28950a();
        int[] a3 = Nat256.m28950a();
        boolean i = secP256K1FieldElement5.mo6565i();
        if (i) {
            iArr = secP256K1FieldElement3.f32076b;
            iArr2 = secP256K1FieldElement4.f32076b;
        } else {
            SecP256K1Field.m28619d(secP256K1FieldElement5.f32076b, a2);
            SecP256K1Field.m28616b(a2, secP256K1FieldElement3.f32076b, a);
            SecP256K1Field.m28616b(a2, secP256K1FieldElement5.f32076b, a2);
            SecP256K1Field.m28616b(a2, secP256K1FieldElement4.f32076b, a2);
            iArr = a;
            iArr2 = a2;
        }
        boolean i2 = secP256K1FieldElement6.mo6565i();
        if (i2) {
            iArr3 = secP256K1FieldElement.f32076b;
            iArr4 = secP256K1FieldElement2.f32076b;
        } else {
            SecP256K1Field.m28619d(secP256K1FieldElement6.f32076b, a3);
            SecP256K1Field.m28616b(a3, secP256K1FieldElement.f32076b, c);
            SecP256K1Field.m28616b(a3, secP256K1FieldElement6.f32076b, a3);
            SecP256K1Field.m28616b(a3, secP256K1FieldElement2.f32076b, a3);
            iArr3 = c;
            iArr4 = a3;
        }
        int[] a4 = Nat256.m28950a();
        SecP256K1Field.m28620d(iArr3, iArr, a4);
        SecP256K1Field.m28620d(iArr4, iArr2, a);
        if (!Nat256.m28954b(a4)) {
            SecP256K1Field.m28619d(a4, a2);
            iArr = Nat256.m28950a();
            SecP256K1Field.m28616b(a2, a4, iArr);
            SecP256K1Field.m28616b(a2, iArr3, a2);
            SecP256K1Field.m28615b(iArr, iArr);
            Nat256.m28964c(iArr4, iArr, c);
            SecP256K1Field.m28610a(Nat256.m28952b(a2, a2, iArr), iArr);
            ECFieldElement secP256K1FieldElement7 = new SecP256K1FieldElement(a3);
            SecP256K1Field.m28619d(a, secP256K1FieldElement7.f32076b);
            SecP256K1Field.m28620d(secP256K1FieldElement7.f32076b, iArr, secP256K1FieldElement7.f32076b);
            ECFieldElement secP256K1FieldElement8 = new SecP256K1FieldElement(iArr);
            SecP256K1Field.m28620d(a2, secP256K1FieldElement7.f32076b, secP256K1FieldElement8.f32076b);
            SecP256K1Field.m28618c(secP256K1FieldElement8.f32076b, a, c);
            SecP256K1Field.m28617c(c, secP256K1FieldElement8.f32076b);
            secP256K1FieldElement = new SecP256K1FieldElement(a4);
            if (!i) {
                SecP256K1Field.m28616b(secP256K1FieldElement.f32076b, secP256K1FieldElement5.f32076b, secP256K1FieldElement.f32076b);
            }
            if (!i2) {
                SecP256K1Field.m28616b(secP256K1FieldElement.f32076b, secP256K1FieldElement6.f32076b, secP256K1FieldElement.f32076b);
            }
            return new SecP256K1Point(d, secP256K1FieldElement7, secP256K1FieldElement8, new ECFieldElement[]{secP256K1FieldElement}, this.f);
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
        SecP256K1FieldElement secP256K1FieldElement = (SecP256K1FieldElement) this.d;
        if (secP256K1FieldElement.mo6566j()) {
            return d.mo6547e();
        }
        SecP256K1FieldElement secP256K1FieldElement2 = (SecP256K1FieldElement) this.c;
        SecP256K1FieldElement secP256K1FieldElement3 = (SecP256K1FieldElement) this.e[0];
        int[] a = Nat256.m28950a();
        SecP256K1Field.m28619d(secP256K1FieldElement.f32076b, a);
        int[] a2 = Nat256.m28950a();
        SecP256K1Field.m28619d(a, a2);
        int[] a3 = Nat256.m28950a();
        SecP256K1Field.m28619d(secP256K1FieldElement2.f32076b, a3);
        SecP256K1Field.m28610a(Nat256.m28952b(a3, a3, a3), a3);
        SecP256K1Field.m28616b(a, secP256K1FieldElement2.f32076b, a);
        SecP256K1Field.m28610a(Nat.m29029c(8, a, 2, 0), a);
        int[] a4 = Nat256.m28950a();
        SecP256K1Field.m28610a(Nat.m29005a(8, a2, 3, 0, a4), a4);
        ECFieldElement secP256K1FieldElement4 = new SecP256K1FieldElement(a2);
        SecP256K1Field.m28619d(a3, secP256K1FieldElement4.f32076b);
        SecP256K1Field.m28620d(secP256K1FieldElement4.f32076b, a, secP256K1FieldElement4.f32076b);
        SecP256K1Field.m28620d(secP256K1FieldElement4.f32076b, a, secP256K1FieldElement4.f32076b);
        ECFieldElement secP256K1FieldElement5 = new SecP256K1FieldElement(a);
        SecP256K1Field.m28620d(a, secP256K1FieldElement4.f32076b, secP256K1FieldElement5.f32076b);
        SecP256K1Field.m28616b(secP256K1FieldElement5.f32076b, a3, secP256K1FieldElement5.f32076b);
        SecP256K1Field.m28620d(secP256K1FieldElement5.f32076b, a4, secP256K1FieldElement5.f32076b);
        secP256K1FieldElement2 = new SecP256K1FieldElement(a3);
        SecP256K1Field.m28621e(secP256K1FieldElement.f32076b, secP256K1FieldElement2.f32076b);
        if (!secP256K1FieldElement3.mo6565i()) {
            SecP256K1Field.m28616b(secP256K1FieldElement2.f32076b, secP256K1FieldElement3.f32076b, secP256K1FieldElement2.f32076b);
        }
        return new SecP256K1Point(d, secP256K1FieldElement4, secP256K1FieldElement5, new ECFieldElement[]{secP256K1FieldElement2}, this.f);
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
        return new SecP256K1Point(this.b, this.c, this.d.mo6559d(), this.e, this.f);
    }
}
