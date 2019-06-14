package org.spongycastle.math.ec.custom.sec;

import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.ec.ECPoint.AbstractFp;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat192;

public class SecP192R1Point extends AbstractFp {
    public SecP192R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        this(eCCurve, eCFieldElement, eCFieldElement2, false);
    }

    public SecP192R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
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

    SecP192R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        this.f = z;
    }

    /* renamed from: e */
    protected ECPoint mo6570e() {
        return new SecP192R1Point(null, m28409g(), m28410h());
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
        SecP192R1FieldElement secP192R1FieldElement = (SecP192R1FieldElement) this.c;
        SecP192R1FieldElement secP192R1FieldElement2 = (SecP192R1FieldElement) this.d;
        SecP192R1FieldElement secP192R1FieldElement3 = (SecP192R1FieldElement) eCPoint.m28411i();
        SecP192R1FieldElement secP192R1FieldElement4 = (SecP192R1FieldElement) eCPoint.mo6571j();
        SecP192R1FieldElement secP192R1FieldElement5 = (SecP192R1FieldElement) this.e[0];
        SecP192R1FieldElement secP192R1FieldElement6 = (SecP192R1FieldElement) eCPoint.mo6574a(0);
        int[] c = Nat192.m28910c();
        int[] a = Nat192.m28894a();
        int[] a2 = Nat192.m28894a();
        int[] a3 = Nat192.m28894a();
        boolean i = secP192R1FieldElement5.mo6565i();
        if (i) {
            iArr = secP192R1FieldElement3.f32063b;
            iArr2 = secP192R1FieldElement4.f32063b;
        } else {
            SecP192R1Field.m28581d(secP192R1FieldElement5.f32063b, a2);
            SecP192R1Field.m28578b(a2, secP192R1FieldElement3.f32063b, a);
            SecP192R1Field.m28578b(a2, secP192R1FieldElement5.f32063b, a2);
            SecP192R1Field.m28578b(a2, secP192R1FieldElement4.f32063b, a2);
            iArr = a;
            iArr2 = a2;
        }
        boolean i2 = secP192R1FieldElement6.mo6565i();
        if (i2) {
            iArr3 = secP192R1FieldElement.f32063b;
            iArr4 = secP192R1FieldElement2.f32063b;
        } else {
            SecP192R1Field.m28581d(secP192R1FieldElement6.f32063b, a3);
            SecP192R1Field.m28578b(a3, secP192R1FieldElement.f32063b, c);
            SecP192R1Field.m28578b(a3, secP192R1FieldElement6.f32063b, a3);
            SecP192R1Field.m28578b(a3, secP192R1FieldElement2.f32063b, a3);
            iArr3 = c;
            iArr4 = a3;
        }
        int[] a4 = Nat192.m28894a();
        SecP192R1Field.m28582d(iArr3, iArr, a4);
        SecP192R1Field.m28582d(iArr4, iArr2, a);
        if (!Nat192.m28898b(a4)) {
            SecP192R1Field.m28581d(a4, a2);
            iArr = Nat192.m28894a();
            SecP192R1Field.m28578b(a2, a4, iArr);
            SecP192R1Field.m28578b(a2, iArr3, a2);
            SecP192R1Field.m28577b(iArr, iArr);
            Nat192.m28909c(iArr4, iArr, c);
            SecP192R1Field.m28570a(Nat192.m28896b(a2, a2, iArr), iArr);
            ECFieldElement secP192R1FieldElement7 = new SecP192R1FieldElement(a3);
            SecP192R1Field.m28581d(a, secP192R1FieldElement7.f32063b);
            SecP192R1Field.m28582d(secP192R1FieldElement7.f32063b, iArr, secP192R1FieldElement7.f32063b);
            ECFieldElement secP192R1FieldElement8 = new SecP192R1FieldElement(iArr);
            SecP192R1Field.m28582d(a2, secP192R1FieldElement7.f32063b, secP192R1FieldElement8.f32063b);
            SecP192R1Field.m28580c(secP192R1FieldElement8.f32063b, a, c);
            SecP192R1Field.m28579c(c, secP192R1FieldElement8.f32063b);
            secP192R1FieldElement = new SecP192R1FieldElement(a4);
            if (!i) {
                SecP192R1Field.m28578b(secP192R1FieldElement.f32063b, secP192R1FieldElement5.f32063b, secP192R1FieldElement.f32063b);
            }
            if (!i2) {
                SecP192R1Field.m28578b(secP192R1FieldElement.f32063b, secP192R1FieldElement6.f32063b, secP192R1FieldElement.f32063b);
            }
            return new SecP192R1Point(d, secP192R1FieldElement7, secP192R1FieldElement8, new ECFieldElement[]{secP192R1FieldElement}, this.f);
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
        SecP192R1FieldElement secP192R1FieldElement = (SecP192R1FieldElement) this.d;
        if (secP192R1FieldElement.mo6566j()) {
            return d.mo6547e();
        }
        SecP192R1FieldElement secP192R1FieldElement2 = (SecP192R1FieldElement) this.c;
        SecP192R1FieldElement secP192R1FieldElement3 = (SecP192R1FieldElement) this.e[0];
        int[] a = Nat192.m28894a();
        int[] a2 = Nat192.m28894a();
        int[] a3 = Nat192.m28894a();
        SecP192R1Field.m28581d(secP192R1FieldElement.f32063b, a3);
        int[] a4 = Nat192.m28894a();
        SecP192R1Field.m28581d(a3, a4);
        boolean i = secP192R1FieldElement3.mo6565i();
        int[] iArr = secP192R1FieldElement3.f32063b;
        if (!i) {
            SecP192R1Field.m28581d(secP192R1FieldElement3.f32063b, a2);
            iArr = a2;
        }
        SecP192R1Field.m28582d(secP192R1FieldElement2.f32063b, iArr, a);
        SecP192R1Field.m28574a(secP192R1FieldElement2.f32063b, iArr, a2);
        SecP192R1Field.m28578b(a2, a, a2);
        SecP192R1Field.m28570a(Nat192.m28896b(a2, a2, a2), a2);
        SecP192R1Field.m28578b(a3, secP192R1FieldElement2.f32063b, a3);
        SecP192R1Field.m28570a(Nat.m29029c(6, a3, 2, 0), a3);
        SecP192R1Field.m28570a(Nat.m29005a(6, a4, 3, 0, a), a);
        ECFieldElement secP192R1FieldElement4 = new SecP192R1FieldElement(a4);
        SecP192R1Field.m28581d(a2, secP192R1FieldElement4.f32063b);
        SecP192R1Field.m28582d(secP192R1FieldElement4.f32063b, a3, secP192R1FieldElement4.f32063b);
        SecP192R1Field.m28582d(secP192R1FieldElement4.f32063b, a3, secP192R1FieldElement4.f32063b);
        ECFieldElement secP192R1FieldElement5 = new SecP192R1FieldElement(a3);
        SecP192R1Field.m28582d(a3, secP192R1FieldElement4.f32063b, secP192R1FieldElement5.f32063b);
        SecP192R1Field.m28578b(secP192R1FieldElement5.f32063b, a2, secP192R1FieldElement5.f32063b);
        SecP192R1Field.m28582d(secP192R1FieldElement5.f32063b, a, secP192R1FieldElement5.f32063b);
        secP192R1FieldElement2 = new SecP192R1FieldElement(a2);
        SecP192R1Field.m28583e(secP192R1FieldElement.f32063b, secP192R1FieldElement2.f32063b);
        if (!i) {
            SecP192R1Field.m28578b(secP192R1FieldElement2.f32063b, secP192R1FieldElement3.f32063b, secP192R1FieldElement2.f32063b);
        }
        return new SecP192R1Point(d, secP192R1FieldElement4, secP192R1FieldElement5, new ECFieldElement[]{secP192R1FieldElement2}, this.f);
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
        return new SecP192R1Point(this.b, this.c, this.d.mo6559d(), this.e, this.f);
    }
}
