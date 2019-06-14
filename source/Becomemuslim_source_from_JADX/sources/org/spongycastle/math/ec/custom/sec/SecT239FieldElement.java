package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Nat256;
import org.spongycastle.util.Arrays;

public class SecT239FieldElement extends ECFieldElement {
    /* renamed from: a */
    protected long[] f32105a;

    /* renamed from: b */
    public int mo6554b() {
        return 239;
    }

    /* renamed from: d */
    public ECFieldElement mo6559d() {
        return this;
    }

    /* renamed from: m */
    public int m41886m() {
        return 239;
    }

    public SecT239FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 239) {
            throw new IllegalArgumentException("x value invalid for SecT239FieldElement");
        }
        this.f32105a = SecT239Field.m28750a(bigInteger);
    }

    public SecT239FieldElement() {
        this.f32105a = Nat256.m28958b();
    }

    protected SecT239FieldElement(long[] jArr) {
        this.f32105a = jArr;
    }

    /* renamed from: i */
    public boolean mo6565i() {
        return Nat256.m28948a(this.f32105a);
    }

    /* renamed from: j */
    public boolean mo6566j() {
        return Nat256.m28957b(this.f32105a);
    }

    /* renamed from: k */
    public boolean mo6567k() {
        return (this.f32105a[0] & 1) != 0;
    }

    /* renamed from: a */
    public BigInteger mo6549a() {
        return Nat256.m28962c(this.f32105a);
    }

    /* renamed from: a */
    public ECFieldElement mo6551a(ECFieldElement eCFieldElement) {
        long[] b = Nat256.m28958b();
        SecT239Field.m28749a(this.f32105a, ((SecT239FieldElement) eCFieldElement).f32105a, b);
        return new SecT239FieldElement(b);
    }

    /* renamed from: c */
    public ECFieldElement mo6557c() {
        long[] b = Nat256.m28958b();
        SecT239Field.m28748a(this.f32105a, b);
        return new SecT239FieldElement(b);
    }

    /* renamed from: b */
    public ECFieldElement mo6555b(ECFieldElement eCFieldElement) {
        return mo6551a(eCFieldElement);
    }

    /* renamed from: c */
    public ECFieldElement mo6558c(ECFieldElement eCFieldElement) {
        long[] b = Nat256.m28958b();
        SecT239Field.m28754c(this.f32105a, ((SecT239FieldElement) eCFieldElement).f32105a, b);
        return new SecT239FieldElement(b);
    }

    /* renamed from: a */
    public ECFieldElement mo6553a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return mo6556b(eCFieldElement, eCFieldElement2, eCFieldElement3);
    }

    /* renamed from: b */
    public ECFieldElement mo6556b(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        long[] jArr = this.f32105a;
        eCFieldElement = ((SecT239FieldElement) eCFieldElement).f32105a;
        eCFieldElement2 = ((SecT239FieldElement) eCFieldElement2).f32105a;
        eCFieldElement3 = ((SecT239FieldElement) eCFieldElement3).f32105a;
        long[] d = Nat256.m28970d();
        SecT239Field.m28756d(jArr, eCFieldElement, d);
        SecT239Field.m28756d(eCFieldElement2, eCFieldElement3, d);
        long[] b = Nat256.m28958b();
        SecT239Field.m28753c(d, b);
        return new SecT239FieldElement(b);
    }

    /* renamed from: d */
    public ECFieldElement mo6560d(ECFieldElement eCFieldElement) {
        return mo6558c(eCFieldElement.mo6562f());
    }

    /* renamed from: e */
    public ECFieldElement mo6561e() {
        long[] b = Nat256.m28958b();
        SecT239Field.m28755d(this.f32105a, b);
        return new SecT239FieldElement(b);
    }

    /* renamed from: a */
    public ECFieldElement mo6552a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        long[] jArr = this.f32105a;
        eCFieldElement = ((SecT239FieldElement) eCFieldElement).f32105a;
        eCFieldElement2 = ((SecT239FieldElement) eCFieldElement2).f32105a;
        long[] d = Nat256.m28970d();
        SecT239Field.m28757e(jArr, d);
        SecT239Field.m28756d(eCFieldElement, eCFieldElement2, d);
        long[] b = Nat256.m28958b();
        SecT239Field.m28753c(d, b);
        return new SecT239FieldElement(b);
    }

    /* renamed from: a */
    public ECFieldElement mo6550a(int i) {
        if (i < 1) {
            return this;
        }
        long[] b = Nat256.m28958b();
        SecT239Field.m28747a(this.f32105a, i, b);
        return new SecT239FieldElement(b);
    }

    /* renamed from: f */
    public ECFieldElement mo6562f() {
        long[] b = Nat256.m28958b();
        SecT239Field.m28751b(this.f32105a, b);
        return new SecT239FieldElement(b);
    }

    /* renamed from: g */
    public ECFieldElement mo6563g() {
        return mo6550a(m41886m() - 1);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecT239FieldElement)) {
            return null;
        }
        return Nat256.m28949a(this.f32105a, ((SecT239FieldElement) obj).f32105a);
    }

    public int hashCode() {
        return Arrays.m29346a(this.f32105a, 0, 4) ^ 23900158;
    }
}
