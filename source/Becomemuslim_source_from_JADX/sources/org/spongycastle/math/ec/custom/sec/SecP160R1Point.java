package org.spongycastle.math.ec.custom.sec;

import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.ec.ECPoint.AbstractFp;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat160;

public class SecP160R1Point extends AbstractFp {
    public SecP160R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        this(eCCurve, eCFieldElement, eCFieldElement2, false);
    }

    public SecP160R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
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

    SecP160R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        this.f = z;
    }

    /* renamed from: e */
    protected ECPoint mo6570e() {
        return new SecP160R1Point(null, m28409g(), m28410h());
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
        SecP160R1FieldElement secP160R1FieldElement = (SecP160R1FieldElement) this.c;
        SecP160R1FieldElement secP160R1FieldElement2 = (SecP160R1FieldElement) this.d;
        SecP160R1FieldElement secP160R1FieldElement3 = (SecP160R1FieldElement) eCPoint.m28411i();
        SecP160R1FieldElement secP160R1FieldElement4 = (SecP160R1FieldElement) eCPoint.mo6571j();
        SecP160R1FieldElement secP160R1FieldElement5 = (SecP160R1FieldElement) this.e[0];
        SecP160R1FieldElement secP160R1FieldElement6 = (SecP160R1FieldElement) eCPoint.mo6574a(0);
        int[] b = Nat160.m28874b();
        int[] a = Nat160.m28868a();
        int[] a2 = Nat160.m28868a();
        int[] a3 = Nat160.m28868a();
        boolean i = secP160R1FieldElement5.mo6565i();
        if (i) {
            iArr = secP160R1FieldElement3.f32051b;
            iArr2 = secP160R1FieldElement4.f32051b;
        } else {
            SecP160R1Field.m28543d(secP160R1FieldElement5.f32051b, a2);
            SecP160R1Field.m28540b(a2, secP160R1FieldElement3.f32051b, a);
            SecP160R1Field.m28540b(a2, secP160R1FieldElement5.f32051b, a2);
            SecP160R1Field.m28540b(a2, secP160R1FieldElement4.f32051b, a2);
            iArr = a;
            iArr2 = a2;
        }
        boolean i2 = secP160R1FieldElement6.mo6565i();
        if (i2) {
            iArr3 = secP160R1FieldElement.f32051b;
            iArr4 = secP160R1FieldElement2.f32051b;
        } else {
            SecP160R1Field.m28543d(secP160R1FieldElement6.f32051b, a3);
            SecP160R1Field.m28540b(a3, secP160R1FieldElement.f32051b, b);
            SecP160R1Field.m28540b(a3, secP160R1FieldElement6.f32051b, a3);
            SecP160R1Field.m28540b(a3, secP160R1FieldElement2.f32051b, a3);
            iArr3 = b;
            iArr4 = a3;
        }
        int[] a4 = Nat160.m28868a();
        SecP160R1Field.m28544d(iArr3, iArr, a4);
        SecP160R1Field.m28544d(iArr4, iArr2, a);
        if (!Nat160.m28872b(a4)) {
            SecP160R1Field.m28543d(a4, a2);
            iArr = Nat160.m28868a();
            SecP160R1Field.m28540b(a2, a4, iArr);
            SecP160R1Field.m28540b(a2, iArr3, a2);
            SecP160R1Field.m28539b(iArr, iArr);
            Nat160.m28877c(iArr4, iArr, b);
            SecP160R1Field.m28534a(Nat160.m28871b(a2, a2, iArr), iArr);
            ECFieldElement secP160R1FieldElement7 = new SecP160R1FieldElement(a3);
            SecP160R1Field.m28543d(a, secP160R1FieldElement7.f32051b);
            SecP160R1Field.m28544d(secP160R1FieldElement7.f32051b, iArr, secP160R1FieldElement7.f32051b);
            ECFieldElement secP160R1FieldElement8 = new SecP160R1FieldElement(iArr);
            SecP160R1Field.m28544d(a2, secP160R1FieldElement7.f32051b, secP160R1FieldElement8.f32051b);
            SecP160R1Field.m28542c(secP160R1FieldElement8.f32051b, a, b);
            SecP160R1Field.m28541c(b, secP160R1FieldElement8.f32051b);
            secP160R1FieldElement = new SecP160R1FieldElement(a4);
            if (!i) {
                SecP160R1Field.m28540b(secP160R1FieldElement.f32051b, secP160R1FieldElement5.f32051b, secP160R1FieldElement.f32051b);
            }
            if (!i2) {
                SecP160R1Field.m28540b(secP160R1FieldElement.f32051b, secP160R1FieldElement6.f32051b, secP160R1FieldElement.f32051b);
            }
            return new SecP160R1Point(d, secP160R1FieldElement7, secP160R1FieldElement8, new ECFieldElement[]{secP160R1FieldElement}, this.f);
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
        SecP160R1FieldElement secP160R1FieldElement = (SecP160R1FieldElement) this.d;
        if (secP160R1FieldElement.mo6566j()) {
            return d.mo6547e();
        }
        SecP160R1FieldElement secP160R1FieldElement2 = (SecP160R1FieldElement) this.c;
        SecP160R1FieldElement secP160R1FieldElement3 = (SecP160R1FieldElement) this.e[0];
        int[] a = Nat160.m28868a();
        int[] a2 = Nat160.m28868a();
        int[] a3 = Nat160.m28868a();
        SecP160R1Field.m28543d(secP160R1FieldElement.f32051b, a3);
        int[] a4 = Nat160.m28868a();
        SecP160R1Field.m28543d(a3, a4);
        boolean i = secP160R1FieldElement3.mo6565i();
        int[] iArr = secP160R1FieldElement3.f32051b;
        if (!i) {
            SecP160R1Field.m28543d(secP160R1FieldElement3.f32051b, a2);
            iArr = a2;
        }
        SecP160R1Field.m28544d(secP160R1FieldElement2.f32051b, iArr, a);
        SecP160R1Field.m28537a(secP160R1FieldElement2.f32051b, iArr, a2);
        SecP160R1Field.m28540b(a2, a, a2);
        SecP160R1Field.m28534a(Nat160.m28871b(a2, a2, a2), a2);
        SecP160R1Field.m28540b(a3, secP160R1FieldElement2.f32051b, a3);
        SecP160R1Field.m28534a(Nat.m29029c(5, a3, 2, 0), a3);
        SecP160R1Field.m28534a(Nat.m29005a(5, a4, 3, 0, a), a);
        ECFieldElement secP160R1FieldElement4 = new SecP160R1FieldElement(a4);
        SecP160R1Field.m28543d(a2, secP160R1FieldElement4.f32051b);
        SecP160R1Field.m28544d(secP160R1FieldElement4.f32051b, a3, secP160R1FieldElement4.f32051b);
        SecP160R1Field.m28544d(secP160R1FieldElement4.f32051b, a3, secP160R1FieldElement4.f32051b);
        ECFieldElement secP160R1FieldElement5 = new SecP160R1FieldElement(a3);
        SecP160R1Field.m28544d(a3, secP160R1FieldElement4.f32051b, secP160R1FieldElement5.f32051b);
        SecP160R1Field.m28540b(secP160R1FieldElement5.f32051b, a2, secP160R1FieldElement5.f32051b);
        SecP160R1Field.m28544d(secP160R1FieldElement5.f32051b, a, secP160R1FieldElement5.f32051b);
        secP160R1FieldElement2 = new SecP160R1FieldElement(a2);
        SecP160R1Field.m28545e(secP160R1FieldElement.f32051b, secP160R1FieldElement2.f32051b);
        if (!i) {
            SecP160R1Field.m28540b(secP160R1FieldElement2.f32051b, secP160R1FieldElement3.f32051b, secP160R1FieldElement2.f32051b);
        }
        return new SecP160R1Point(d, secP160R1FieldElement4, secP160R1FieldElement5, new ECFieldElement[]{secP160R1FieldElement2}, this.f);
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
        return new SecP160R1Point(this.b, this.c, this.d.mo6559d(), this.e, this.f);
    }
}
