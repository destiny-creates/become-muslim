package org.spongycastle.math.ec.custom.sec;

import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.ec.ECPoint.AbstractFp;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat256;

public class SecP256R1Point extends AbstractFp {
    public SecP256R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        this(eCCurve, eCFieldElement, eCFieldElement2, false);
    }

    public SecP256R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
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

    SecP256R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        this.f = z;
    }

    /* renamed from: e */
    protected ECPoint mo6570e() {
        return new SecP256R1Point(null, m28409g(), m28410h());
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
        SecP256R1FieldElement secP256R1FieldElement = (SecP256R1FieldElement) this.c;
        SecP256R1FieldElement secP256R1FieldElement2 = (SecP256R1FieldElement) this.d;
        SecP256R1FieldElement secP256R1FieldElement3 = (SecP256R1FieldElement) eCPoint.m28411i();
        SecP256R1FieldElement secP256R1FieldElement4 = (SecP256R1FieldElement) eCPoint.mo6571j();
        SecP256R1FieldElement secP256R1FieldElement5 = (SecP256R1FieldElement) this.e[0];
        SecP256R1FieldElement secP256R1FieldElement6 = (SecP256R1FieldElement) eCPoint.mo6574a(0);
        int[] c = Nat256.m28966c();
        int[] a = Nat256.m28950a();
        int[] a2 = Nat256.m28950a();
        int[] a3 = Nat256.m28950a();
        boolean i = secP256R1FieldElement5.mo6565i();
        if (i) {
            iArr = secP256R1FieldElement3.f32080b;
            iArr2 = secP256R1FieldElement4.f32080b;
        } else {
            SecP256R1Field.m28633d(secP256R1FieldElement5.f32080b, a2);
            SecP256R1Field.m28630b(a2, secP256R1FieldElement3.f32080b, a);
            SecP256R1Field.m28630b(a2, secP256R1FieldElement5.f32080b, a2);
            SecP256R1Field.m28630b(a2, secP256R1FieldElement4.f32080b, a2);
            iArr = a;
            iArr2 = a2;
        }
        boolean i2 = secP256R1FieldElement6.mo6565i();
        if (i2) {
            iArr3 = secP256R1FieldElement.f32080b;
            iArr4 = secP256R1FieldElement2.f32080b;
        } else {
            SecP256R1Field.m28633d(secP256R1FieldElement6.f32080b, a3);
            SecP256R1Field.m28630b(a3, secP256R1FieldElement.f32080b, c);
            SecP256R1Field.m28630b(a3, secP256R1FieldElement6.f32080b, a3);
            SecP256R1Field.m28630b(a3, secP256R1FieldElement2.f32080b, a3);
            iArr3 = c;
            iArr4 = a3;
        }
        int[] a4 = Nat256.m28950a();
        SecP256R1Field.m28634d(iArr3, iArr, a4);
        SecP256R1Field.m28634d(iArr4, iArr2, a);
        if (!Nat256.m28954b(a4)) {
            SecP256R1Field.m28633d(a4, a2);
            iArr = Nat256.m28950a();
            SecP256R1Field.m28630b(a2, a4, iArr);
            SecP256R1Field.m28630b(a2, iArr3, a2);
            SecP256R1Field.m28629b(iArr, iArr);
            Nat256.m28964c(iArr4, iArr, c);
            SecP256R1Field.m28622a(Nat256.m28952b(a2, a2, iArr), iArr);
            ECFieldElement secP256R1FieldElement7 = new SecP256R1FieldElement(a3);
            SecP256R1Field.m28633d(a, secP256R1FieldElement7.f32080b);
            SecP256R1Field.m28634d(secP256R1FieldElement7.f32080b, iArr, secP256R1FieldElement7.f32080b);
            ECFieldElement secP256R1FieldElement8 = new SecP256R1FieldElement(iArr);
            SecP256R1Field.m28634d(a2, secP256R1FieldElement7.f32080b, secP256R1FieldElement8.f32080b);
            SecP256R1Field.m28632c(secP256R1FieldElement8.f32080b, a, c);
            SecP256R1Field.m28631c(c, secP256R1FieldElement8.f32080b);
            secP256R1FieldElement = new SecP256R1FieldElement(a4);
            if (!i) {
                SecP256R1Field.m28630b(secP256R1FieldElement.f32080b, secP256R1FieldElement5.f32080b, secP256R1FieldElement.f32080b);
            }
            if (!i2) {
                SecP256R1Field.m28630b(secP256R1FieldElement.f32080b, secP256R1FieldElement6.f32080b, secP256R1FieldElement.f32080b);
            }
            return new SecP256R1Point(d, secP256R1FieldElement7, secP256R1FieldElement8, new ECFieldElement[]{secP256R1FieldElement}, this.f);
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
        SecP256R1FieldElement secP256R1FieldElement = (SecP256R1FieldElement) this.d;
        if (secP256R1FieldElement.mo6566j()) {
            return d.mo6547e();
        }
        SecP256R1FieldElement secP256R1FieldElement2 = (SecP256R1FieldElement) this.c;
        SecP256R1FieldElement secP256R1FieldElement3 = (SecP256R1FieldElement) this.e[0];
        int[] a = Nat256.m28950a();
        int[] a2 = Nat256.m28950a();
        int[] a3 = Nat256.m28950a();
        SecP256R1Field.m28633d(secP256R1FieldElement.f32080b, a3);
        int[] a4 = Nat256.m28950a();
        SecP256R1Field.m28633d(a3, a4);
        boolean i = secP256R1FieldElement3.mo6565i();
        int[] iArr = secP256R1FieldElement3.f32080b;
        if (!i) {
            SecP256R1Field.m28633d(secP256R1FieldElement3.f32080b, a2);
            iArr = a2;
        }
        SecP256R1Field.m28634d(secP256R1FieldElement2.f32080b, iArr, a);
        SecP256R1Field.m28626a(secP256R1FieldElement2.f32080b, iArr, a2);
        SecP256R1Field.m28630b(a2, a, a2);
        SecP256R1Field.m28622a(Nat256.m28952b(a2, a2, a2), a2);
        SecP256R1Field.m28630b(a3, secP256R1FieldElement2.f32080b, a3);
        SecP256R1Field.m28622a(Nat.m29029c(8, a3, 2, 0), a3);
        SecP256R1Field.m28622a(Nat.m29005a(8, a4, 3, 0, a), a);
        ECFieldElement secP256R1FieldElement4 = new SecP256R1FieldElement(a4);
        SecP256R1Field.m28633d(a2, secP256R1FieldElement4.f32080b);
        SecP256R1Field.m28634d(secP256R1FieldElement4.f32080b, a3, secP256R1FieldElement4.f32080b);
        SecP256R1Field.m28634d(secP256R1FieldElement4.f32080b, a3, secP256R1FieldElement4.f32080b);
        ECFieldElement secP256R1FieldElement5 = new SecP256R1FieldElement(a3);
        SecP256R1Field.m28634d(a3, secP256R1FieldElement4.f32080b, secP256R1FieldElement5.f32080b);
        SecP256R1Field.m28630b(secP256R1FieldElement5.f32080b, a2, secP256R1FieldElement5.f32080b);
        SecP256R1Field.m28634d(secP256R1FieldElement5.f32080b, a, secP256R1FieldElement5.f32080b);
        secP256R1FieldElement2 = new SecP256R1FieldElement(a2);
        SecP256R1Field.m28635e(secP256R1FieldElement.f32080b, secP256R1FieldElement2.f32080b);
        if (!i) {
            SecP256R1Field.m28630b(secP256R1FieldElement2.f32080b, secP256R1FieldElement3.f32080b, secP256R1FieldElement2.f32080b);
        }
        return new SecP256R1Point(d, secP256R1FieldElement4, secP256R1FieldElement5, new ECFieldElement[]{secP256R1FieldElement2}, this.f);
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
        return new SecP256R1Point(this.b, this.c, this.d.mo6559d(), this.e, this.f);
    }
}
