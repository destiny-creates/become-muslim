package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Nat256;
import org.spongycastle.util.Arrays;

public class SecT193FieldElement extends ECFieldElement {
    /* renamed from: a */
    protected long[] f32099a;

    /* renamed from: b */
    public int mo6554b() {
        return 193;
    }

    /* renamed from: d */
    public ECFieldElement mo6559d() {
        return this;
    }

    /* renamed from: m */
    public int m41779m() {
        return 193;
    }

    public SecT193FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 193) {
            throw new IllegalArgumentException("x value invalid for SecT193FieldElement");
        }
        this.f32099a = SecT193Field.m28716a(bigInteger);
    }

    public SecT193FieldElement() {
        this.f32099a = Nat256.m28958b();
    }

    protected SecT193FieldElement(long[] jArr) {
        this.f32099a = jArr;
    }

    /* renamed from: i */
    public boolean mo6565i() {
        return Nat256.m28948a(this.f32099a);
    }

    /* renamed from: j */
    public boolean mo6566j() {
        return Nat256.m28957b(this.f32099a);
    }

    /* renamed from: k */
    public boolean mo6567k() {
        return (this.f32099a[0] & 1) != 0;
    }

    /* renamed from: a */
    public BigInteger mo6549a() {
        return Nat256.m28962c(this.f32099a);
    }

    /* renamed from: a */
    public ECFieldElement mo6551a(ECFieldElement eCFieldElement) {
        long[] b = Nat256.m28958b();
        SecT193Field.m28715a(this.f32099a, ((SecT193FieldElement) eCFieldElement).f32099a, b);
        return new SecT193FieldElement(b);
    }

    /* renamed from: c */
    public ECFieldElement mo6557c() {
        long[] b = Nat256.m28958b();
        SecT193Field.m28714a(this.f32099a, b);
        return new SecT193FieldElement(b);
    }

    /* renamed from: b */
    public ECFieldElement mo6555b(ECFieldElement eCFieldElement) {
        return mo6551a(eCFieldElement);
    }

    /* renamed from: c */
    public ECFieldElement mo6558c(ECFieldElement eCFieldElement) {
        long[] b = Nat256.m28958b();
        SecT193Field.m28720c(this.f32099a, ((SecT193FieldElement) eCFieldElement).f32099a, b);
        return new SecT193FieldElement(b);
    }

    /* renamed from: a */
    public ECFieldElement mo6553a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return mo6556b(eCFieldElement, eCFieldElement2, eCFieldElement3);
    }

    /* renamed from: b */
    public ECFieldElement mo6556b(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        long[] jArr = this.f32099a;
        eCFieldElement = ((SecT193FieldElement) eCFieldElement).f32099a;
        eCFieldElement2 = ((SecT193FieldElement) eCFieldElement2).f32099a;
        eCFieldElement3 = ((SecT193FieldElement) eCFieldElement3).f32099a;
        long[] d = Nat256.m28970d();
        SecT193Field.m28722d(jArr, eCFieldElement, d);
        SecT193Field.m28722d(eCFieldElement2, eCFieldElement3, d);
        long[] b = Nat256.m28958b();
        SecT193Field.m28719c(d, b);
        return new SecT193FieldElement(b);
    }

    /* renamed from: d */
    public ECFieldElement mo6560d(ECFieldElement eCFieldElement) {
        return mo6558c(eCFieldElement.mo6562f());
    }

    /* renamed from: e */
    public ECFieldElement mo6561e() {
        long[] b = Nat256.m28958b();
        SecT193Field.m28721d(this.f32099a, b);
        return new SecT193FieldElement(b);
    }

    /* renamed from: a */
    public ECFieldElement mo6552a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        long[] jArr = this.f32099a;
        eCFieldElement = ((SecT193FieldElement) eCFieldElement).f32099a;
        eCFieldElement2 = ((SecT193FieldElement) eCFieldElement2).f32099a;
        long[] d = Nat256.m28970d();
        SecT193Field.m28723e(jArr, d);
        SecT193Field.m28722d(eCFieldElement, eCFieldElement2, d);
        long[] b = Nat256.m28958b();
        SecT193Field.m28719c(d, b);
        return new SecT193FieldElement(b);
    }

    /* renamed from: a */
    public ECFieldElement mo6550a(int i) {
        if (i < 1) {
            return this;
        }
        long[] b = Nat256.m28958b();
        SecT193Field.m28713a(this.f32099a, i, b);
        return new SecT193FieldElement(b);
    }

    /* renamed from: f */
    public ECFieldElement mo6562f() {
        long[] b = Nat256.m28958b();
        SecT193Field.m28717b(this.f32099a, b);
        return new SecT193FieldElement(b);
    }

    /* renamed from: g */
    public ECFieldElement mo6563g() {
        return mo6550a(m41779m() - 1);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecT193FieldElement)) {
            return null;
        }
        return Nat256.m28949a(this.f32099a, ((SecT193FieldElement) obj).f32099a);
    }

    public int hashCode() {
        return Arrays.m29346a(this.f32099a, 0, 4) ^ 1930015;
    }
}
