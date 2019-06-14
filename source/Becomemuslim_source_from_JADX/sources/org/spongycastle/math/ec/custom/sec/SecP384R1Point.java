package org.spongycastle.math.ec.custom.sec;

import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.ec.ECPoint.AbstractFp;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat384;

public class SecP384R1Point extends AbstractFp {
    public SecP384R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        this(eCCurve, eCFieldElement, eCFieldElement2, false);
    }

    public SecP384R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
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

    SecP384R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        this.f = z;
    }

    /* renamed from: e */
    protected ECPoint mo6570e() {
        return new SecP384R1Point(null, m28409g(), m28410h());
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
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        ECCurve d = m28406d();
        SecP384R1FieldElement secP384R1FieldElement = (SecP384R1FieldElement) eCPoint2.c;
        SecP384R1FieldElement secP384R1FieldElement2 = (SecP384R1FieldElement) eCPoint2.d;
        SecP384R1FieldElement secP384R1FieldElement3 = (SecP384R1FieldElement) eCPoint.m28411i();
        SecP384R1FieldElement secP384R1FieldElement4 = (SecP384R1FieldElement) eCPoint.mo6571j();
        SecP384R1FieldElement secP384R1FieldElement5 = (SecP384R1FieldElement) eCPoint2.e[0];
        SecP384R1FieldElement secP384R1FieldElement6 = (SecP384R1FieldElement) eCPoint3.mo6574a(0);
        int[] a = Nat.m29015a(24);
        int[] a2 = Nat.m29015a(24);
        int[] a3 = Nat.m29015a(12);
        int[] a4 = Nat.m29015a(12);
        boolean i = secP384R1FieldElement5.mo6565i();
        if (i) {
            iArr = secP384R1FieldElement3.f32084b;
            iArr2 = secP384R1FieldElement4.f32084b;
        } else {
            SecP384R1Field.m28647d(secP384R1FieldElement5.f32084b, a3);
            SecP384R1Field.m28646c(a3, secP384R1FieldElement3.f32084b, a2);
            SecP384R1Field.m28646c(a3, secP384R1FieldElement5.f32084b, a3);
            SecP384R1Field.m28646c(a3, secP384R1FieldElement4.f32084b, a3);
            iArr = a2;
            iArr2 = a3;
        }
        boolean i2 = secP384R1FieldElement6.mo6565i();
        if (i2) {
            iArr3 = secP384R1FieldElement.f32084b;
            iArr4 = secP384R1FieldElement2.f32084b;
        } else {
            SecP384R1Field.m28647d(secP384R1FieldElement6.f32084b, a4);
            SecP384R1Field.m28646c(a4, secP384R1FieldElement.f32084b, a);
            SecP384R1Field.m28646c(a4, secP384R1FieldElement6.f32084b, a4);
            SecP384R1Field.m28646c(a4, secP384R1FieldElement2.f32084b, a4);
            iArr3 = a;
            iArr4 = a4;
        }
        int[] a5 = Nat.m29015a(12);
        SecP384R1Field.m28648d(iArr3, iArr, a5);
        iArr = Nat.m29015a(12);
        SecP384R1Field.m28648d(iArr4, iArr2, iArr);
        if (!Nat.m29037e(12, a5)) {
            SecP384R1Field.m28647d(a5, a3);
            iArr2 = Nat.m29015a(12);
            SecP384R1Field.m28646c(a3, a5, iArr2);
            SecP384R1Field.m28646c(a3, iArr3, a3);
            SecP384R1Field.m28643b(iArr2, iArr2);
            Nat384.m28981a(iArr4, iArr2, a);
            SecP384R1Field.m28636a(Nat.m29023b(12, a3, a3, iArr2), iArr2);
            ECFieldElement secP384R1FieldElement7 = new SecP384R1FieldElement(a4);
            SecP384R1Field.m28647d(iArr, secP384R1FieldElement7.f32084b);
            SecP384R1Field.m28648d(secP384R1FieldElement7.f32084b, iArr2, secP384R1FieldElement7.f32084b);
            ECFieldElement secP384R1FieldElement8 = new SecP384R1FieldElement(iArr2);
            SecP384R1Field.m28648d(a3, secP384R1FieldElement7.f32084b, secP384R1FieldElement8.f32084b);
            Nat384.m28981a(secP384R1FieldElement8.f32084b, iArr, a2);
            SecP384R1Field.m28644b(a, a2, a);
            SecP384R1Field.m28645c(a, secP384R1FieldElement8.f32084b);
            secP384R1FieldElement = new SecP384R1FieldElement(a5);
            if (!i) {
                SecP384R1Field.m28646c(secP384R1FieldElement.f32084b, secP384R1FieldElement5.f32084b, secP384R1FieldElement.f32084b);
            }
            if (!i2) {
                SecP384R1Field.m28646c(secP384R1FieldElement.f32084b, secP384R1FieldElement6.f32084b, secP384R1FieldElement.f32084b);
            }
            return new SecP384R1Point(d, secP384R1FieldElement7, secP384R1FieldElement8, new ECFieldElement[]{secP384R1FieldElement}, eCPoint2.f);
        } else if (Nat.m29037e(12, iArr)) {
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
        SecP384R1FieldElement secP384R1FieldElement = (SecP384R1FieldElement) this.d;
        if (secP384R1FieldElement.mo6566j()) {
            return d.mo6547e();
        }
        SecP384R1FieldElement secP384R1FieldElement2 = (SecP384R1FieldElement) this.c;
        SecP384R1FieldElement secP384R1FieldElement3 = (SecP384R1FieldElement) this.e[0];
        int[] a = Nat.m29015a(12);
        int[] a2 = Nat.m29015a(12);
        int[] a3 = Nat.m29015a(12);
        SecP384R1Field.m28647d(secP384R1FieldElement.f32084b, a3);
        int[] a4 = Nat.m29015a(12);
        SecP384R1Field.m28647d(a3, a4);
        boolean i = secP384R1FieldElement3.mo6565i();
        int[] iArr = secP384R1FieldElement3.f32084b;
        if (!i) {
            SecP384R1Field.m28647d(secP384R1FieldElement3.f32084b, a2);
            iArr = a2;
        }
        SecP384R1Field.m28648d(secP384R1FieldElement2.f32084b, iArr, a);
        SecP384R1Field.m28640a(secP384R1FieldElement2.f32084b, iArr, a2);
        SecP384R1Field.m28646c(a2, a, a2);
        SecP384R1Field.m28636a(Nat.m29023b(12, a2, a2, a2), a2);
        SecP384R1Field.m28646c(a3, secP384R1FieldElement2.f32084b, a3);
        SecP384R1Field.m28636a(Nat.m29029c(12, a3, 2, 0), a3);
        SecP384R1Field.m28636a(Nat.m29005a(12, a4, 3, 0, a), a);
        ECFieldElement secP384R1FieldElement4 = new SecP384R1FieldElement(a4);
        SecP384R1Field.m28647d(a2, secP384R1FieldElement4.f32084b);
        SecP384R1Field.m28648d(secP384R1FieldElement4.f32084b, a3, secP384R1FieldElement4.f32084b);
        SecP384R1Field.m28648d(secP384R1FieldElement4.f32084b, a3, secP384R1FieldElement4.f32084b);
        ECFieldElement secP384R1FieldElement5 = new SecP384R1FieldElement(a3);
        SecP384R1Field.m28648d(a3, secP384R1FieldElement4.f32084b, secP384R1FieldElement5.f32084b);
        SecP384R1Field.m28646c(secP384R1FieldElement5.f32084b, a2, secP384R1FieldElement5.f32084b);
        SecP384R1Field.m28648d(secP384R1FieldElement5.f32084b, a, secP384R1FieldElement5.f32084b);
        secP384R1FieldElement2 = new SecP384R1FieldElement(a2);
        SecP384R1Field.m28649e(secP384R1FieldElement.f32084b, secP384R1FieldElement2.f32084b);
        if (!i) {
            SecP384R1Field.m28646c(secP384R1FieldElement2.f32084b, secP384R1FieldElement3.f32084b, secP384R1FieldElement2.f32084b);
        }
        return new SecP384R1Point(d, secP384R1FieldElement4, secP384R1FieldElement5, new ECFieldElement[]{secP384R1FieldElement2}, this.f);
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
        return new SecP384R1Point(this.b, this.c, this.d.mo6559d(), this.e, this.f);
    }
}
