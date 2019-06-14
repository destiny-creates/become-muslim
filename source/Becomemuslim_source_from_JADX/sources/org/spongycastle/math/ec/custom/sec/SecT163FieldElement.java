package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Nat192;
import org.spongycastle.util.Arrays;

public class SecT163FieldElement extends ECFieldElement {
    /* renamed from: a */
    protected long[] f32095a;

    /* renamed from: b */
    public int mo6554b() {
        return 163;
    }

    /* renamed from: d */
    public ECFieldElement mo6559d() {
        return this;
    }

    /* renamed from: m */
    public int m41708m() {
        return 163;
    }

    public SecT163FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 163) {
            throw new IllegalArgumentException("x value invalid for SecT163FieldElement");
        }
        this.f32095a = SecT163Field.m28700a(bigInteger);
    }

    public SecT163FieldElement() {
        this.f32095a = Nat192.m28902b();
    }

    protected SecT163FieldElement(long[] jArr) {
        this.f32095a = jArr;
    }

    /* renamed from: i */
    public boolean mo6565i() {
        return Nat192.m28892a(this.f32095a);
    }

    /* renamed from: j */
    public boolean mo6566j() {
        return Nat192.m28901b(this.f32095a);
    }

    /* renamed from: k */
    public boolean mo6567k() {
        return (this.f32095a[0] & 1) != 0;
    }

    /* renamed from: a */
    public BigInteger mo6549a() {
        return Nat192.m28906c(this.f32095a);
    }

    /* renamed from: a */
    public ECFieldElement mo6551a(ECFieldElement eCFieldElement) {
        long[] b = Nat192.m28902b();
        SecT163Field.m28699a(this.f32095a, ((SecT163FieldElement) eCFieldElement).f32095a, b);
        return new SecT163FieldElement(b);
    }

    /* renamed from: c */
    public ECFieldElement mo6557c() {
        long[] b = Nat192.m28902b();
        SecT163Field.m28698a(this.f32095a, b);
        return new SecT163FieldElement(b);
    }

    /* renamed from: b */
    public ECFieldElement mo6555b(ECFieldElement eCFieldElement) {
        return mo6551a(eCFieldElement);
    }

    /* renamed from: c */
    public ECFieldElement mo6558c(ECFieldElement eCFieldElement) {
        long[] b = Nat192.m28902b();
        SecT163Field.m28704c(this.f32095a, ((SecT163FieldElement) eCFieldElement).f32095a, b);
        return new SecT163FieldElement(b);
    }

    /* renamed from: a */
    public ECFieldElement mo6553a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return mo6556b(eCFieldElement, eCFieldElement2, eCFieldElement3);
    }

    /* renamed from: b */
    public ECFieldElement mo6556b(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        long[] jArr = this.f32095a;
        eCFieldElement = ((SecT163FieldElement) eCFieldElement).f32095a;
        eCFieldElement2 = ((SecT163FieldElement) eCFieldElement2).f32095a;
        eCFieldElement3 = ((SecT163FieldElement) eCFieldElement3).f32095a;
        long[] d = Nat192.m28914d();
        SecT163Field.m28706d(jArr, eCFieldElement, d);
        SecT163Field.m28706d(eCFieldElement2, eCFieldElement3, d);
        long[] b = Nat192.m28902b();
        SecT163Field.m28703c(d, b);
        return new SecT163FieldElement(b);
    }

    /* renamed from: d */
    public ECFieldElement mo6560d(ECFieldElement eCFieldElement) {
        return mo6558c(eCFieldElement.mo6562f());
    }

    /* renamed from: e */
    public ECFieldElement mo6561e() {
        long[] b = Nat192.m28902b();
        SecT163Field.m28705d(this.f32095a, b);
        return new SecT163FieldElement(b);
    }

    /* renamed from: a */
    public ECFieldElement mo6552a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        long[] jArr = this.f32095a;
        eCFieldElement = ((SecT163FieldElement) eCFieldElement).f32095a;
        eCFieldElement2 = ((SecT163FieldElement) eCFieldElement2).f32095a;
        long[] d = Nat192.m28914d();
        SecT163Field.m28707e(jArr, d);
        SecT163Field.m28706d(eCFieldElement, eCFieldElement2, d);
        long[] b = Nat192.m28902b();
        SecT163Field.m28703c(d, b);
        return new SecT163FieldElement(b);
    }

    /* renamed from: a */
    public ECFieldElement mo6550a(int i) {
        if (i < 1) {
            return this;
        }
        long[] b = Nat192.m28902b();
        SecT163Field.m28697a(this.f32095a, i, b);
        return new SecT163FieldElement(b);
    }

    /* renamed from: f */
    public ECFieldElement mo6562f() {
        long[] b = Nat192.m28902b();
        SecT163Field.m28701b(this.f32095a, b);
        return new SecT163FieldElement(b);
    }

    /* renamed from: g */
    public ECFieldElement mo6563g() {
        return mo6550a(m41708m() - 1);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecT163FieldElement)) {
            return null;
        }
        return Nat192.m28893a(this.f32095a, ((SecT163FieldElement) obj).f32095a);
    }

    public int hashCode() {
        return Arrays.m29346a(this.f32095a, 0, 3) ^ 163763;
    }
}
