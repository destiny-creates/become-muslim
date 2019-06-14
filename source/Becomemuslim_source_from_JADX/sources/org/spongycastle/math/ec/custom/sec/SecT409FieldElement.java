package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat448;
import org.spongycastle.util.Arrays;

public class SecT409FieldElement extends ECFieldElement {
    /* renamed from: a */
    protected long[] f32110a;

    /* renamed from: b */
    public int mo6554b() {
        return 409;
    }

    /* renamed from: d */
    public ECFieldElement mo6559d() {
        return this;
    }

    /* renamed from: m */
    public int m41977m() {
        return 409;
    }

    public SecT409FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 409) {
            throw new IllegalArgumentException("x value invalid for SecT409FieldElement");
        }
        this.f32110a = SecT409Field.m28784a(bigInteger);
    }

    public SecT409FieldElement() {
        this.f32110a = Nat448.m28984a();
    }

    protected SecT409FieldElement(long[] jArr) {
        this.f32110a = jArr;
    }

    /* renamed from: i */
    public boolean mo6565i() {
        return Nat448.m28982a(this.f32110a);
    }

    /* renamed from: j */
    public boolean mo6566j() {
        return Nat448.m28986b(this.f32110a);
    }

    /* renamed from: k */
    public boolean mo6567k() {
        return (this.f32110a[0] & 1) != 0;
    }

    /* renamed from: a */
    public BigInteger mo6549a() {
        return Nat448.m28988c(this.f32110a);
    }

    /* renamed from: a */
    public ECFieldElement mo6551a(ECFieldElement eCFieldElement) {
        long[] a = Nat448.m28984a();
        SecT409Field.m28783a(this.f32110a, ((SecT409FieldElement) eCFieldElement).f32110a, a);
        return new SecT409FieldElement(a);
    }

    /* renamed from: c */
    public ECFieldElement mo6557c() {
        long[] a = Nat448.m28984a();
        SecT409Field.m28782a(this.f32110a, a);
        return new SecT409FieldElement(a);
    }

    /* renamed from: b */
    public ECFieldElement mo6555b(ECFieldElement eCFieldElement) {
        return mo6551a(eCFieldElement);
    }

    /* renamed from: c */
    public ECFieldElement mo6558c(ECFieldElement eCFieldElement) {
        long[] a = Nat448.m28984a();
        SecT409Field.m28788c(this.f32110a, ((SecT409FieldElement) eCFieldElement).f32110a, a);
        return new SecT409FieldElement(a);
    }

    /* renamed from: a */
    public ECFieldElement mo6553a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return mo6556b(eCFieldElement, eCFieldElement2, eCFieldElement3);
    }

    /* renamed from: b */
    public ECFieldElement mo6556b(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        long[] jArr = this.f32110a;
        eCFieldElement = ((SecT409FieldElement) eCFieldElement).f32110a;
        eCFieldElement2 = ((SecT409FieldElement) eCFieldElement2).f32110a;
        eCFieldElement3 = ((SecT409FieldElement) eCFieldElement3).f32110a;
        long[] b = Nat.m29025b(13);
        SecT409Field.m28790d(jArr, eCFieldElement, b);
        SecT409Field.m28790d(eCFieldElement2, eCFieldElement3, b);
        long[] a = Nat448.m28984a();
        SecT409Field.m28787c(b, a);
        return new SecT409FieldElement(a);
    }

    /* renamed from: d */
    public ECFieldElement mo6560d(ECFieldElement eCFieldElement) {
        return mo6558c(eCFieldElement.mo6562f());
    }

    /* renamed from: e */
    public ECFieldElement mo6561e() {
        long[] a = Nat448.m28984a();
        SecT409Field.m28789d(this.f32110a, a);
        return new SecT409FieldElement(a);
    }

    /* renamed from: a */
    public ECFieldElement mo6552a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        long[] jArr = this.f32110a;
        eCFieldElement = ((SecT409FieldElement) eCFieldElement).f32110a;
        eCFieldElement2 = ((SecT409FieldElement) eCFieldElement2).f32110a;
        long[] b = Nat.m29025b(13);
        SecT409Field.m28791e(jArr, b);
        SecT409Field.m28790d(eCFieldElement, eCFieldElement2, b);
        long[] a = Nat448.m28984a();
        SecT409Field.m28787c(b, a);
        return new SecT409FieldElement(a);
    }

    /* renamed from: a */
    public ECFieldElement mo6550a(int i) {
        if (i < 1) {
            return this;
        }
        long[] a = Nat448.m28984a();
        SecT409Field.m28780a(this.f32110a, i, a);
        return new SecT409FieldElement(a);
    }

    /* renamed from: f */
    public ECFieldElement mo6562f() {
        long[] a = Nat448.m28984a();
        SecT409Field.m28785b(this.f32110a, a);
        return new SecT409FieldElement(a);
    }

    /* renamed from: g */
    public ECFieldElement mo6563g() {
        return mo6550a(m41977m() - 1);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecT409FieldElement)) {
            return null;
        }
        return Nat448.m28983a(this.f32110a, ((SecT409FieldElement) obj).f32110a);
    }

    public int hashCode() {
        return Arrays.m29346a(this.f32110a, 0, 7) ^ 4090087;
    }
}
