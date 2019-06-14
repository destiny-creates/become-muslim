package org.spongycastle.math.ec.custom.sec;

import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.ec.ECPoint.AbstractFp;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat128;

public class SecP128R1Point extends AbstractFp {
    public SecP128R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        this(eCCurve, eCFieldElement, eCFieldElement2, false);
    }

    public SecP128R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
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

    SecP128R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        this.f = z;
    }

    /* renamed from: e */
    protected ECPoint mo6570e() {
        return new SecP128R1Point(null, m28409g(), m28410h());
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
        SecP128R1FieldElement secP128R1FieldElement = (SecP128R1FieldElement) this.c;
        SecP128R1FieldElement secP128R1FieldElement2 = (SecP128R1FieldElement) this.d;
        SecP128R1FieldElement secP128R1FieldElement3 = (SecP128R1FieldElement) eCPoint.m28411i();
        SecP128R1FieldElement secP128R1FieldElement4 = (SecP128R1FieldElement) eCPoint.mo6571j();
        SecP128R1FieldElement secP128R1FieldElement5 = (SecP128R1FieldElement) this.e[0];
        SecP128R1FieldElement secP128R1FieldElement6 = (SecP128R1FieldElement) eCPoint.mo6574a(0);
        int[] c = Nat128.m28855c();
        int[] a = Nat128.m28843a();
        int[] a2 = Nat128.m28843a();
        int[] a3 = Nat128.m28843a();
        boolean i = secP128R1FieldElement5.mo6565i();
        if (i) {
            iArr = secP128R1FieldElement3.f32045b;
            iArr2 = secP128R1FieldElement4.f32045b;
        } else {
            SecP128R1Field.m28531d(secP128R1FieldElement5.f32045b, a2);
            SecP128R1Field.m28528b(a2, secP128R1FieldElement3.f32045b, a);
            SecP128R1Field.m28528b(a2, secP128R1FieldElement5.f32045b, a2);
            SecP128R1Field.m28528b(a2, secP128R1FieldElement4.f32045b, a2);
            iArr = a;
            iArr2 = a2;
        }
        boolean i2 = secP128R1FieldElement6.mo6565i();
        if (i2) {
            iArr3 = secP128R1FieldElement.f32045b;
            iArr4 = secP128R1FieldElement2.f32045b;
        } else {
            SecP128R1Field.m28531d(secP128R1FieldElement6.f32045b, a3);
            SecP128R1Field.m28528b(a3, secP128R1FieldElement.f32045b, c);
            SecP128R1Field.m28528b(a3, secP128R1FieldElement6.f32045b, a3);
            SecP128R1Field.m28528b(a3, secP128R1FieldElement2.f32045b, a3);
            iArr3 = c;
            iArr4 = a3;
        }
        int[] a4 = Nat128.m28843a();
        SecP128R1Field.m28532d(iArr3, iArr, a4);
        SecP128R1Field.m28532d(iArr4, iArr2, a);
        if (!Nat128.m28846b(a4)) {
            SecP128R1Field.m28531d(a4, a2);
            iArr = Nat128.m28843a();
            SecP128R1Field.m28528b(a2, a4, iArr);
            SecP128R1Field.m28528b(a2, iArr3, a2);
            SecP128R1Field.m28527b(iArr, iArr);
            Nat128.m28854c(iArr4, iArr, c);
            SecP128R1Field.m28520a(Nat128.m28845b(a2, a2, iArr), iArr);
            ECFieldElement secP128R1FieldElement7 = new SecP128R1FieldElement(a3);
            SecP128R1Field.m28531d(a, secP128R1FieldElement7.f32045b);
            SecP128R1Field.m28532d(secP128R1FieldElement7.f32045b, iArr, secP128R1FieldElement7.f32045b);
            ECFieldElement secP128R1FieldElement8 = new SecP128R1FieldElement(iArr);
            SecP128R1Field.m28532d(a2, secP128R1FieldElement7.f32045b, secP128R1FieldElement8.f32045b);
            SecP128R1Field.m28530c(secP128R1FieldElement8.f32045b, a, c);
            SecP128R1Field.m28529c(c, secP128R1FieldElement8.f32045b);
            secP128R1FieldElement = new SecP128R1FieldElement(a4);
            if (!i) {
                SecP128R1Field.m28528b(secP128R1FieldElement.f32045b, secP128R1FieldElement5.f32045b, secP128R1FieldElement.f32045b);
            }
            if (!i2) {
                SecP128R1Field.m28528b(secP128R1FieldElement.f32045b, secP128R1FieldElement6.f32045b, secP128R1FieldElement.f32045b);
            }
            return new SecP128R1Point(d, secP128R1FieldElement7, secP128R1FieldElement8, new ECFieldElement[]{secP128R1FieldElement}, this.f);
        } else if (Nat128.m28846b(a) != null) {
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
        SecP128R1FieldElement secP128R1FieldElement = (SecP128R1FieldElement) this.d;
        if (secP128R1FieldElement.mo6566j()) {
            return d.mo6547e();
        }
        SecP128R1FieldElement secP128R1FieldElement2 = (SecP128R1FieldElement) this.c;
        SecP128R1FieldElement secP128R1FieldElement3 = (SecP128R1FieldElement) this.e[0];
        int[] a = Nat128.m28843a();
        int[] a2 = Nat128.m28843a();
        int[] a3 = Nat128.m28843a();
        SecP128R1Field.m28531d(secP128R1FieldElement.f32045b, a3);
        int[] a4 = Nat128.m28843a();
        SecP128R1Field.m28531d(a3, a4);
        boolean i = secP128R1FieldElement3.mo6565i();
        int[] iArr = secP128R1FieldElement3.f32045b;
        if (!i) {
            SecP128R1Field.m28531d(secP128R1FieldElement3.f32045b, a2);
            iArr = a2;
        }
        SecP128R1Field.m28532d(secP128R1FieldElement2.f32045b, iArr, a);
        SecP128R1Field.m28524a(secP128R1FieldElement2.f32045b, iArr, a2);
        SecP128R1Field.m28528b(a2, a, a2);
        SecP128R1Field.m28520a(Nat128.m28845b(a2, a2, a2), a2);
        SecP128R1Field.m28528b(a3, secP128R1FieldElement2.f32045b, a3);
        SecP128R1Field.m28520a(Nat.m29029c(4, a3, 2, 0), a3);
        SecP128R1Field.m28520a(Nat.m29005a(4, a4, 3, 0, a), a);
        ECFieldElement secP128R1FieldElement4 = new SecP128R1FieldElement(a4);
        SecP128R1Field.m28531d(a2, secP128R1FieldElement4.f32045b);
        SecP128R1Field.m28532d(secP128R1FieldElement4.f32045b, a3, secP128R1FieldElement4.f32045b);
        SecP128R1Field.m28532d(secP128R1FieldElement4.f32045b, a3, secP128R1FieldElement4.f32045b);
        ECFieldElement secP128R1FieldElement5 = new SecP128R1FieldElement(a3);
        SecP128R1Field.m28532d(a3, secP128R1FieldElement4.f32045b, secP128R1FieldElement5.f32045b);
        SecP128R1Field.m28528b(secP128R1FieldElement5.f32045b, a2, secP128R1FieldElement5.f32045b);
        SecP128R1Field.m28532d(secP128R1FieldElement5.f32045b, a, secP128R1FieldElement5.f32045b);
        secP128R1FieldElement2 = new SecP128R1FieldElement(a2);
        SecP128R1Field.m28533e(secP128R1FieldElement.f32045b, secP128R1FieldElement2.f32045b);
        if (!i) {
            SecP128R1Field.m28528b(secP128R1FieldElement2.f32045b, secP128R1FieldElement3.f32045b, secP128R1FieldElement2.f32045b);
        }
        return new SecP128R1Point(d, secP128R1FieldElement4, secP128R1FieldElement5, new ECFieldElement[]{secP128R1FieldElement2}, this.f);
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
        return new SecP128R1Point(this.b, this.c, this.d.mo6559d(), this.e, this.f);
    }
}
