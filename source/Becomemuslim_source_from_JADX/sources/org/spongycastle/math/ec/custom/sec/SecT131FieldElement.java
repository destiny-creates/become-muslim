package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat192;
import org.spongycastle.util.Arrays;

public class SecT131FieldElement extends ECFieldElement {
    /* renamed from: a */
    protected long[] f32092a;

    /* renamed from: b */
    public int mo6554b() {
        return 131;
    }

    /* renamed from: d */
    public ECFieldElement mo6559d() {
        return this;
    }

    /* renamed from: m */
    public int m41655m() {
        return 131;
    }

    public SecT131FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 131) {
            throw new IllegalArgumentException("x value invalid for SecT131FieldElement");
        }
        this.f32092a = SecT131Field.m28684a(bigInteger);
    }

    public SecT131FieldElement() {
        this.f32092a = Nat192.m28902b();
    }

    protected SecT131FieldElement(long[] jArr) {
        this.f32092a = jArr;
    }

    /* renamed from: i */
    public boolean mo6565i() {
        return Nat192.m28892a(this.f32092a);
    }

    /* renamed from: j */
    public boolean mo6566j() {
        return Nat192.m28901b(this.f32092a);
    }

    /* renamed from: k */
    public boolean mo6567k() {
        return (this.f32092a[0] & 1) != 0;
    }

    /* renamed from: a */
    public BigInteger mo6549a() {
        return Nat192.m28906c(this.f32092a);
    }

    /* renamed from: a */
    public ECFieldElement mo6551a(ECFieldElement eCFieldElement) {
        long[] b = Nat192.m28902b();
        SecT131Field.m28683a(this.f32092a, ((SecT131FieldElement) eCFieldElement).f32092a, b);
        return new SecT131FieldElement(b);
    }

    /* renamed from: c */
    public ECFieldElement mo6557c() {
        long[] b = Nat192.m28902b();
        SecT131Field.m28682a(this.f32092a, b);
        return new SecT131FieldElement(b);
    }

    /* renamed from: b */
    public ECFieldElement mo6555b(ECFieldElement eCFieldElement) {
        return mo6551a(eCFieldElement);
    }

    /* renamed from: c */
    public ECFieldElement mo6558c(ECFieldElement eCFieldElement) {
        long[] b = Nat192.m28902b();
        SecT131Field.m28688c(this.f32092a, ((SecT131FieldElement) eCFieldElement).f32092a, b);
        return new SecT131FieldElement(b);
    }

    /* renamed from: a */
    public ECFieldElement mo6553a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return mo6556b(eCFieldElement, eCFieldElement2, eCFieldElement3);
    }

    /* renamed from: b */
    public ECFieldElement mo6556b(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        long[] jArr = this.f32092a;
        eCFieldElement = ((SecT131FieldElement) eCFieldElement).f32092a;
        eCFieldElement2 = ((SecT131FieldElement) eCFieldElement2).f32092a;
        eCFieldElement3 = ((SecT131FieldElement) eCFieldElement3).f32092a;
        long[] b = Nat.m29025b(5);
        SecT131Field.m28690d(jArr, eCFieldElement, b);
        SecT131Field.m28690d(eCFieldElement2, eCFieldElement3, b);
        long[] b2 = Nat192.m28902b();
        SecT131Field.m28687c(b, b2);
        return new SecT131FieldElement(b2);
    }

    /* renamed from: d */
    public ECFieldElement mo6560d(ECFieldElement eCFieldElement) {
        return mo6558c(eCFieldElement.mo6562f());
    }

    /* renamed from: e */
    public ECFieldElement mo6561e() {
        long[] b = Nat192.m28902b();
        SecT131Field.m28689d(this.f32092a, b);
        return new SecT131FieldElement(b);
    }

    /* renamed from: a */
    public ECFieldElement mo6552a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        long[] jArr = this.f32092a;
        eCFieldElement = ((SecT131FieldElement) eCFieldElement).f32092a;
        eCFieldElement2 = ((SecT131FieldElement) eCFieldElement2).f32092a;
        long[] b = Nat.m29025b(5);
        SecT131Field.m28691e(jArr, b);
        SecT131Field.m28690d(eCFieldElement, eCFieldElement2, b);
        long[] b2 = Nat192.m28902b();
        SecT131Field.m28687c(b, b2);
        return new SecT131FieldElement(b2);
    }

    /* renamed from: a */
    public ECFieldElement mo6550a(int i) {
        if (i < 1) {
            return this;
        }
        long[] b = Nat192.m28902b();
        SecT131Field.m28681a(this.f32092a, i, b);
        return new SecT131FieldElement(b);
    }

    /* renamed from: f */
    public ECFieldElement mo6562f() {
        long[] b = Nat192.m28902b();
        SecT131Field.m28685b(this.f32092a, b);
        return new SecT131FieldElement(b);
    }

    /* renamed from: g */
    public ECFieldElement mo6563g() {
        return mo6550a(m41655m() - 1);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecT131FieldElement)) {
            return null;
        }
        return Nat192.m28893a(this.f32092a, ((SecT131FieldElement) obj).f32092a);
    }

    public int hashCode() {
        return Arrays.m29346a(this.f32092a, 0, 3) ^ 131832;
    }
}
