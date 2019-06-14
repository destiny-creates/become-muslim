package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Nat576;
import org.spongycastle.util.Arrays;

public class SecT571FieldElement extends ECFieldElement {
    /* renamed from: a */
    protected long[] f32113a;

    /* renamed from: b */
    public int mo6554b() {
        return 571;
    }

    /* renamed from: d */
    public ECFieldElement mo6559d() {
        return this;
    }

    /* renamed from: m */
    public int m42031m() {
        return 571;
    }

    public SecT571FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 571) {
            throw new IllegalArgumentException("x value invalid for SecT571FieldElement");
        }
        this.f32113a = SecT571Field.m28800a(bigInteger);
    }

    public SecT571FieldElement() {
        this.f32113a = Nat576.m28993a();
    }

    protected SecT571FieldElement(long[] jArr) {
        this.f32113a = jArr;
    }

    /* renamed from: i */
    public boolean mo6565i() {
        return Nat576.m28991a(this.f32113a);
    }

    /* renamed from: j */
    public boolean mo6566j() {
        return Nat576.m28995b(this.f32113a);
    }

    /* renamed from: k */
    public boolean mo6567k() {
        return (this.f32113a[0] & 1) != 0;
    }

    /* renamed from: a */
    public BigInteger mo6549a() {
        return Nat576.m28997c(this.f32113a);
    }

    /* renamed from: a */
    public ECFieldElement mo6551a(ECFieldElement eCFieldElement) {
        long[] a = Nat576.m28993a();
        SecT571Field.m28799a(this.f32113a, ((SecT571FieldElement) eCFieldElement).f32113a, a);
        return new SecT571FieldElement(a);
    }

    /* renamed from: c */
    public ECFieldElement mo6557c() {
        long[] a = Nat576.m28993a();
        SecT571Field.m28798a(this.f32113a, a);
        return new SecT571FieldElement(a);
    }

    /* renamed from: b */
    public ECFieldElement mo6555b(ECFieldElement eCFieldElement) {
        return mo6551a(eCFieldElement);
    }

    /* renamed from: c */
    public ECFieldElement mo6558c(ECFieldElement eCFieldElement) {
        long[] a = Nat576.m28993a();
        SecT571Field.m28805c(this.f32113a, ((SecT571FieldElement) eCFieldElement).f32113a, a);
        return new SecT571FieldElement(a);
    }

    /* renamed from: a */
    public ECFieldElement mo6553a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return mo6556b(eCFieldElement, eCFieldElement2, eCFieldElement3);
    }

    /* renamed from: b */
    public ECFieldElement mo6556b(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        long[] jArr = this.f32113a;
        eCFieldElement = ((SecT571FieldElement) eCFieldElement).f32113a;
        eCFieldElement2 = ((SecT571FieldElement) eCFieldElement2).f32113a;
        eCFieldElement3 = ((SecT571FieldElement) eCFieldElement3).f32113a;
        long[] b = Nat576.m28996b();
        SecT571Field.m28807d(jArr, eCFieldElement, b);
        SecT571Field.m28807d(eCFieldElement2, eCFieldElement3, b);
        long[] a = Nat576.m28993a();
        SecT571Field.m28804c(b, a);
        return new SecT571FieldElement(a);
    }

    /* renamed from: d */
    public ECFieldElement mo6560d(ECFieldElement eCFieldElement) {
        return mo6558c(eCFieldElement.mo6562f());
    }

    /* renamed from: e */
    public ECFieldElement mo6561e() {
        long[] a = Nat576.m28993a();
        SecT571Field.m28806d(this.f32113a, a);
        return new SecT571FieldElement(a);
    }

    /* renamed from: a */
    public ECFieldElement mo6552a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        long[] jArr = this.f32113a;
        eCFieldElement = ((SecT571FieldElement) eCFieldElement).f32113a;
        eCFieldElement2 = ((SecT571FieldElement) eCFieldElement2).f32113a;
        long[] b = Nat576.m28996b();
        SecT571Field.m28808e(jArr, b);
        SecT571Field.m28807d(eCFieldElement, eCFieldElement2, b);
        long[] a = Nat576.m28993a();
        SecT571Field.m28804c(b, a);
        return new SecT571FieldElement(a);
    }

    /* renamed from: a */
    public ECFieldElement mo6550a(int i) {
        if (i < 1) {
            return this;
        }
        long[] a = Nat576.m28993a();
        SecT571Field.m28796a(this.f32113a, i, a);
        return new SecT571FieldElement(a);
    }

    /* renamed from: f */
    public ECFieldElement mo6562f() {
        long[] a = Nat576.m28993a();
        SecT571Field.m28802b(this.f32113a, a);
        return new SecT571FieldElement(a);
    }

    /* renamed from: g */
    public ECFieldElement mo6563g() {
        return mo6550a(m42031m() - 1);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecT571FieldElement)) {
            return null;
        }
        return Nat576.m28992a(this.f32113a, ((SecT571FieldElement) obj).f32113a);
    }

    public int hashCode() {
        return Arrays.m29346a(this.f32113a, 0, 9) ^ 5711052;
    }
}
