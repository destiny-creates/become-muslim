package org.spongycastle.math.ec.custom.sec;

import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.ec.ECPoint.AbstractFp;
import org.spongycastle.math.raw.Nat;

public class SecP521R1Point extends AbstractFp {
    public SecP521R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        this(eCCurve, eCFieldElement, eCFieldElement2, false);
    }

    public SecP521R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
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

    SecP521R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        this.f = z;
    }

    /* renamed from: e */
    protected ECPoint mo6570e() {
        return new SecP521R1Point(null, m28409g(), m28410h());
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
        SecP521R1FieldElement secP521R1FieldElement = (SecP521R1FieldElement) eCPoint2.c;
        SecP521R1FieldElement secP521R1FieldElement2 = (SecP521R1FieldElement) eCPoint2.d;
        SecP521R1FieldElement secP521R1FieldElement3 = (SecP521R1FieldElement) eCPoint.m28411i();
        SecP521R1FieldElement secP521R1FieldElement4 = (SecP521R1FieldElement) eCPoint.mo6571j();
        SecP521R1FieldElement secP521R1FieldElement5 = (SecP521R1FieldElement) eCPoint2.e[0];
        SecP521R1FieldElement secP521R1FieldElement6 = (SecP521R1FieldElement) eCPoint3.mo6574a(0);
        int[] a = Nat.m29015a(17);
        int[] a2 = Nat.m29015a(17);
        int[] a3 = Nat.m29015a(17);
        int[] a4 = Nat.m29015a(17);
        boolean i = secP521R1FieldElement5.mo6565i();
        if (i) {
            iArr = secP521R1FieldElement3.f32088b;
            iArr2 = secP521R1FieldElement4.f32088b;
        } else {
            SecP521R1Field.m28659d(secP521R1FieldElement5.f32088b, a3);
            SecP521R1Field.m28656b(a3, secP521R1FieldElement3.f32088b, a2);
            SecP521R1Field.m28656b(a3, secP521R1FieldElement5.f32088b, a3);
            SecP521R1Field.m28656b(a3, secP521R1FieldElement4.f32088b, a3);
            iArr = a2;
            iArr2 = a3;
        }
        boolean i2 = secP521R1FieldElement6.mo6565i();
        if (i2) {
            iArr3 = secP521R1FieldElement.f32088b;
            iArr4 = secP521R1FieldElement2.f32088b;
        } else {
            SecP521R1Field.m28659d(secP521R1FieldElement6.f32088b, a4);
            SecP521R1Field.m28656b(a4, secP521R1FieldElement.f32088b, a);
            SecP521R1Field.m28656b(a4, secP521R1FieldElement6.f32088b, a4);
            SecP521R1Field.m28656b(a4, secP521R1FieldElement2.f32088b, a4);
            iArr3 = a;
            iArr4 = a4;
        }
        int[] a5 = Nat.m29015a(17);
        SecP521R1Field.m28658c(iArr3, iArr, a5);
        SecP521R1Field.m28658c(iArr4, iArr2, a2);
        if (!Nat.m29037e(17, a5)) {
            SecP521R1Field.m28659d(a5, a3);
            iArr = Nat.m29015a(17);
            SecP521R1Field.m28656b(a3, a5, iArr);
            SecP521R1Field.m28656b(a3, iArr3, a3);
            SecP521R1Field.m28656b(iArr4, iArr, a);
            ECFieldElement secP521R1FieldElement7 = new SecP521R1FieldElement(a4);
            SecP521R1Field.m28659d(a2, secP521R1FieldElement7.f32088b);
            SecP521R1Field.m28653a(secP521R1FieldElement7.f32088b, iArr, secP521R1FieldElement7.f32088b);
            SecP521R1Field.m28658c(secP521R1FieldElement7.f32088b, a3, secP521R1FieldElement7.f32088b);
            SecP521R1Field.m28658c(secP521R1FieldElement7.f32088b, a3, secP521R1FieldElement7.f32088b);
            ECFieldElement secP521R1FieldElement8 = new SecP521R1FieldElement(iArr);
            SecP521R1Field.m28658c(a3, secP521R1FieldElement7.f32088b, secP521R1FieldElement8.f32088b);
            SecP521R1Field.m28656b(secP521R1FieldElement8.f32088b, a2, a2);
            SecP521R1Field.m28658c(a2, a, secP521R1FieldElement8.f32088b);
            secP521R1FieldElement = new SecP521R1FieldElement(a5);
            if (!i) {
                SecP521R1Field.m28656b(secP521R1FieldElement.f32088b, secP521R1FieldElement5.f32088b, secP521R1FieldElement.f32088b);
            }
            if (!i2) {
                SecP521R1Field.m28656b(secP521R1FieldElement.f32088b, secP521R1FieldElement6.f32088b, secP521R1FieldElement.f32088b);
            }
            return new SecP521R1Point(d, secP521R1FieldElement7, secP521R1FieldElement8, new ECFieldElement[]{secP521R1FieldElement}, eCPoint2.f);
        } else if (Nat.m29037e(17, a2)) {
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
        SecP521R1FieldElement secP521R1FieldElement = (SecP521R1FieldElement) this.d;
        if (secP521R1FieldElement.mo6566j()) {
            return d.mo6547e();
        }
        SecP521R1FieldElement secP521R1FieldElement2 = (SecP521R1FieldElement) this.c;
        SecP521R1FieldElement secP521R1FieldElement3 = (SecP521R1FieldElement) this.e[0];
        int[] a = Nat.m29015a(17);
        int[] a2 = Nat.m29015a(17);
        int[] a3 = Nat.m29015a(17);
        SecP521R1Field.m28659d(secP521R1FieldElement.f32088b, a3);
        int[] a4 = Nat.m29015a(17);
        SecP521R1Field.m28659d(a3, a4);
        boolean i = secP521R1FieldElement3.mo6565i();
        int[] iArr = secP521R1FieldElement3.f32088b;
        if (!i) {
            SecP521R1Field.m28659d(secP521R1FieldElement3.f32088b, a2);
            iArr = a2;
        }
        SecP521R1Field.m28658c(secP521R1FieldElement2.f32088b, iArr, a);
        SecP521R1Field.m28653a(secP521R1FieldElement2.f32088b, iArr, a2);
        SecP521R1Field.m28656b(a2, a, a2);
        Nat.m29023b(17, a2, a2, a2);
        SecP521R1Field.m28650a(a2);
        SecP521R1Field.m28656b(a3, secP521R1FieldElement2.f32088b, a3);
        Nat.m29029c(17, a3, 2, 0);
        SecP521R1Field.m28650a(a3);
        Nat.m29005a(17, a4, 3, 0, a);
        SecP521R1Field.m28650a(a);
        ECFieldElement secP521R1FieldElement4 = new SecP521R1FieldElement(a4);
        SecP521R1Field.m28659d(a2, secP521R1FieldElement4.f32088b);
        SecP521R1Field.m28658c(secP521R1FieldElement4.f32088b, a3, secP521R1FieldElement4.f32088b);
        SecP521R1Field.m28658c(secP521R1FieldElement4.f32088b, a3, secP521R1FieldElement4.f32088b);
        ECFieldElement secP521R1FieldElement5 = new SecP521R1FieldElement(a3);
        SecP521R1Field.m28658c(a3, secP521R1FieldElement4.f32088b, secP521R1FieldElement5.f32088b);
        SecP521R1Field.m28656b(secP521R1FieldElement5.f32088b, a2, secP521R1FieldElement5.f32088b);
        SecP521R1Field.m28658c(secP521R1FieldElement5.f32088b, a, secP521R1FieldElement5.f32088b);
        secP521R1FieldElement2 = new SecP521R1FieldElement(a2);
        SecP521R1Field.m28661e(secP521R1FieldElement.f32088b, secP521R1FieldElement2.f32088b);
        if (!i) {
            SecP521R1Field.m28656b(secP521R1FieldElement2.f32088b, secP521R1FieldElement3.f32088b, secP521R1FieldElement2.f32088b);
        }
        return new SecP521R1Point(d, secP521R1FieldElement4, secP521R1FieldElement5, new ECFieldElement[]{secP521R1FieldElement2}, this.f);
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
        return new SecP521R1Point(this.b, this.c, this.d.mo6559d(), this.e, this.f);
    }
}
