package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat320;
import org.spongycastle.util.Arrays;

public class SecT283FieldElement extends ECFieldElement {
    /* renamed from: a */
    protected long[] f32107a;

    /* renamed from: b */
    public int mo6554b() {
        return 283;
    }

    /* renamed from: d */
    public ECFieldElement mo6559d() {
        return this;
    }

    /* renamed from: m */
    public int m41923m() {
        return 283;
    }

    public SecT283FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 283) {
            throw new IllegalArgumentException("x value invalid for SecT283FieldElement");
        }
        this.f32107a = SecT283Field.m28767a(bigInteger);
    }

    public SecT283FieldElement() {
        this.f32107a = Nat320.m28975a();
    }

    protected SecT283FieldElement(long[] jArr) {
        this.f32107a = jArr;
    }

    /* renamed from: i */
    public boolean mo6565i() {
        return Nat320.m28973a(this.f32107a);
    }

    /* renamed from: j */
    public boolean mo6566j() {
        return Nat320.m28977b(this.f32107a);
    }

    /* renamed from: k */
    public boolean mo6567k() {
        return (this.f32107a[0] & 1) != 0;
    }

    /* renamed from: a */
    public BigInteger mo6549a() {
        return Nat320.m28979c(this.f32107a);
    }

    /* renamed from: a */
    public ECFieldElement mo6551a(ECFieldElement eCFieldElement) {
        long[] a = Nat320.m28975a();
        SecT283Field.m28766a(this.f32107a, ((SecT283FieldElement) eCFieldElement).f32107a, a);
        return new SecT283FieldElement(a);
    }

    /* renamed from: c */
    public ECFieldElement mo6557c() {
        long[] a = Nat320.m28975a();
        SecT283Field.m28765a(this.f32107a, a);
        return new SecT283FieldElement(a);
    }

    /* renamed from: b */
    public ECFieldElement mo6555b(ECFieldElement eCFieldElement) {
        return mo6551a(eCFieldElement);
    }

    /* renamed from: c */
    public ECFieldElement mo6558c(ECFieldElement eCFieldElement) {
        long[] a = Nat320.m28975a();
        SecT283Field.m28771c(this.f32107a, ((SecT283FieldElement) eCFieldElement).f32107a, a);
        return new SecT283FieldElement(a);
    }

    /* renamed from: a */
    public ECFieldElement mo6553a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return mo6556b(eCFieldElement, eCFieldElement2, eCFieldElement3);
    }

    /* renamed from: b */
    public ECFieldElement mo6556b(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        long[] jArr = this.f32107a;
        eCFieldElement = ((SecT283FieldElement) eCFieldElement).f32107a;
        eCFieldElement2 = ((SecT283FieldElement) eCFieldElement2).f32107a;
        eCFieldElement3 = ((SecT283FieldElement) eCFieldElement3).f32107a;
        long[] b = Nat.m29025b(9);
        SecT283Field.m28773d(jArr, eCFieldElement, b);
        SecT283Field.m28773d(eCFieldElement2, eCFieldElement3, b);
        long[] a = Nat320.m28975a();
        SecT283Field.m28770c(b, a);
        return new SecT283FieldElement(a);
    }

    /* renamed from: d */
    public ECFieldElement mo6560d(ECFieldElement eCFieldElement) {
        return mo6558c(eCFieldElement.mo6562f());
    }

    /* renamed from: e */
    public ECFieldElement mo6561e() {
        long[] a = Nat320.m28975a();
        SecT283Field.m28772d(this.f32107a, a);
        return new SecT283FieldElement(a);
    }

    /* renamed from: a */
    public ECFieldElement mo6552a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        long[] jArr = this.f32107a;
        eCFieldElement = ((SecT283FieldElement) eCFieldElement).f32107a;
        eCFieldElement2 = ((SecT283FieldElement) eCFieldElement2).f32107a;
        long[] b = Nat.m29025b(9);
        SecT283Field.m28774e(jArr, b);
        SecT283Field.m28773d(eCFieldElement, eCFieldElement2, b);
        long[] a = Nat320.m28975a();
        SecT283Field.m28770c(b, a);
        return new SecT283FieldElement(a);
    }

    /* renamed from: a */
    public ECFieldElement mo6550a(int i) {
        if (i < 1) {
            return this;
        }
        long[] a = Nat320.m28975a();
        SecT283Field.m28764a(this.f32107a, i, a);
        return new SecT283FieldElement(a);
    }

    /* renamed from: f */
    public ECFieldElement mo6562f() {
        long[] a = Nat320.m28975a();
        SecT283Field.m28768b(this.f32107a, a);
        return new SecT283FieldElement(a);
    }

    /* renamed from: g */
    public ECFieldElement mo6563g() {
        return mo6550a(m41923m() - 1);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecT283FieldElement)) {
            return null;
        }
        return Nat320.m28974a(this.f32107a, ((SecT283FieldElement) obj).f32107a);
    }

    public int hashCode() {
        return Arrays.m29346a(this.f32107a, 0, 5) ^ 2831275;
    }
}
