package org.spongycastle.math.ec.custom.sec;

import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.ec.ECPoint.AbstractFp;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat160;

public class SecP160K1Point extends AbstractFp {
    public SecP160K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        this(eCCurve, eCFieldElement, eCFieldElement2, false);
    }

    public SecP160K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
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

    SecP160K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        this.f = z;
    }

    /* renamed from: e */
    protected ECPoint mo6570e() {
        return new SecP160K1Point(null, m28409g(), m28410h());
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
        SecP160R2FieldElement secP160R2FieldElement = (SecP160R2FieldElement) this.c;
        SecP160R2FieldElement secP160R2FieldElement2 = (SecP160R2FieldElement) this.d;
        SecP160R2FieldElement secP160R2FieldElement3 = (SecP160R2FieldElement) eCPoint.m28411i();
        SecP160R2FieldElement secP160R2FieldElement4 = (SecP160R2FieldElement) eCPoint.mo6571j();
        SecP160R2FieldElement secP160R2FieldElement5 = (SecP160R2FieldElement) this.e[0];
        SecP160R2FieldElement secP160R2FieldElement6 = (SecP160R2FieldElement) eCPoint.mo6574a(0);
        int[] b = Nat160.m28874b();
        int[] a = Nat160.m28868a();
        int[] a2 = Nat160.m28868a();
        int[] a3 = Nat160.m28868a();
        boolean i = secP160R2FieldElement5.mo6565i();
        if (i) {
            iArr = secP160R2FieldElement3.f32055b;
            iArr2 = secP160R2FieldElement4.f32055b;
        } else {
            SecP160R2Field.m28555d(secP160R2FieldElement5.f32055b, a2);
            SecP160R2Field.m28552b(a2, secP160R2FieldElement3.f32055b, a);
            SecP160R2Field.m28552b(a2, secP160R2FieldElement5.f32055b, a2);
            SecP160R2Field.m28552b(a2, secP160R2FieldElement4.f32055b, a2);
            iArr = a;
            iArr2 = a2;
        }
        boolean i2 = secP160R2FieldElement6.mo6565i();
        if (i2) {
            iArr3 = secP160R2FieldElement.f32055b;
            iArr4 = secP160R2FieldElement2.f32055b;
        } else {
            SecP160R2Field.m28555d(secP160R2FieldElement6.f32055b, a3);
            SecP160R2Field.m28552b(a3, secP160R2FieldElement.f32055b, b);
            SecP160R2Field.m28552b(a3, secP160R2FieldElement6.f32055b, a3);
            SecP160R2Field.m28552b(a3, secP160R2FieldElement2.f32055b, a3);
            iArr3 = b;
            iArr4 = a3;
        }
        int[] a4 = Nat160.m28868a();
        SecP160R2Field.m28556d(iArr3, iArr, a4);
        SecP160R2Field.m28556d(iArr4, iArr2, a);
        if (!Nat160.m28872b(a4)) {
            SecP160R2Field.m28555d(a4, a2);
            iArr = Nat160.m28868a();
            SecP160R2Field.m28552b(a2, a4, iArr);
            SecP160R2Field.m28552b(a2, iArr3, a2);
            SecP160R2Field.m28551b(iArr, iArr);
            Nat160.m28877c(iArr4, iArr, b);
            SecP160R2Field.m28546a(Nat160.m28871b(a2, a2, iArr), iArr);
            ECFieldElement secP160R2FieldElement7 = new SecP160R2FieldElement(a3);
            SecP160R2Field.m28555d(a, secP160R2FieldElement7.f32055b);
            SecP160R2Field.m28556d(secP160R2FieldElement7.f32055b, iArr, secP160R2FieldElement7.f32055b);
            ECFieldElement secP160R2FieldElement8 = new SecP160R2FieldElement(iArr);
            SecP160R2Field.m28556d(a2, secP160R2FieldElement7.f32055b, secP160R2FieldElement8.f32055b);
            SecP160R2Field.m28554c(secP160R2FieldElement8.f32055b, a, b);
            SecP160R2Field.m28553c(b, secP160R2FieldElement8.f32055b);
            secP160R2FieldElement = new SecP160R2FieldElement(a4);
            if (!i) {
                SecP160R2Field.m28552b(secP160R2FieldElement.f32055b, secP160R2FieldElement5.f32055b, secP160R2FieldElement.f32055b);
            }
            if (!i2) {
                SecP160R2Field.m28552b(secP160R2FieldElement.f32055b, secP160R2FieldElement6.f32055b, secP160R2FieldElement.f32055b);
            }
            return new SecP160K1Point(d, secP160R2FieldElement7, secP160R2FieldElement8, new ECFieldElement[]{secP160R2FieldElement}, this.f);
        } else if (Nat160.m28872b(a) != null) {
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
        SecP160R2FieldElement secP160R2FieldElement = (SecP160R2FieldElement) this.d;
        if (secP160R2FieldElement.mo6566j()) {
            return d.mo6547e();
        }
        SecP160R2FieldElement secP160R2FieldElement2 = (SecP160R2FieldElement) this.c;
        SecP160R2FieldElement secP160R2FieldElement3 = (SecP160R2FieldElement) this.e[0];
        int[] a = Nat160.m28868a();
        SecP160R2Field.m28555d(secP160R2FieldElement.f32055b, a);
        int[] a2 = Nat160.m28868a();
        SecP160R2Field.m28555d(a, a2);
        int[] a3 = Nat160.m28868a();
        SecP160R2Field.m28555d(secP160R2FieldElement2.f32055b, a3);
        SecP160R2Field.m28546a(Nat160.m28871b(a3, a3, a3), a3);
        SecP160R2Field.m28552b(a, secP160R2FieldElement2.f32055b, a);
        SecP160R2Field.m28546a(Nat.m29029c(5, a, 2, 0), a);
        int[] a4 = Nat160.m28868a();
        SecP160R2Field.m28546a(Nat.m29005a(5, a2, 3, 0, a4), a4);
        ECFieldElement secP160R2FieldElement4 = new SecP160R2FieldElement(a2);
        SecP160R2Field.m28555d(a3, secP160R2FieldElement4.f32055b);
        SecP160R2Field.m28556d(secP160R2FieldElement4.f32055b, a, secP160R2FieldElement4.f32055b);
        SecP160R2Field.m28556d(secP160R2FieldElement4.f32055b, a, secP160R2FieldElement4.f32055b);
        ECFieldElement secP160R2FieldElement5 = new SecP160R2FieldElement(a);
        SecP160R2Field.m28556d(a, secP160R2FieldElement4.f32055b, secP160R2FieldElement5.f32055b);
        SecP160R2Field.m28552b(secP160R2FieldElement5.f32055b, a3, secP160R2FieldElement5.f32055b);
        SecP160R2Field.m28556d(secP160R2FieldElement5.f32055b, a4, secP160R2FieldElement5.f32055b);
        secP160R2FieldElement2 = new SecP160R2FieldElement(a3);
        SecP160R2Field.m28557e(secP160R2FieldElement.f32055b, secP160R2FieldElement2.f32055b);
        if (!secP160R2FieldElement3.mo6565i()) {
            SecP160R2Field.m28552b(secP160R2FieldElement2.f32055b, secP160R2FieldElement3.f32055b, secP160R2FieldElement2.f32055b);
        }
        return new SecP160K1Point(d, secP160R2FieldElement4, secP160R2FieldElement5, new ECFieldElement[]{secP160R2FieldElement2}, this.f);
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
        return new SecP160K1Point(this.b, this.c, this.d.mo6559d(), this.e, this.f);
    }
}
