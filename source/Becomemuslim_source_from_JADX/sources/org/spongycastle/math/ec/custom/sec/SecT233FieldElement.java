package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Nat256;
import org.spongycastle.util.Arrays;

public class SecT233FieldElement extends ECFieldElement {
    /* renamed from: a */
    protected long[] f32102a;

    /* renamed from: b */
    public int mo6554b() {
        return 233;
    }

    /* renamed from: d */
    public ECFieldElement mo6559d() {
        return this;
    }

    /* renamed from: m */
    public int m41832m() {
        return 233;
    }

    public SecT233FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 233) {
            throw new IllegalArgumentException("x value invalid for SecT233FieldElement");
        }
        this.f32102a = SecT233Field.m28733a(bigInteger);
    }

    public SecT233FieldElement() {
        this.f32102a = Nat256.m28958b();
    }

    protected SecT233FieldElement(long[] jArr) {
        this.f32102a = jArr;
    }

    /* renamed from: i */
    public boolean mo6565i() {
        return Nat256.m28948a(this.f32102a);
    }

    /* renamed from: j */
    public boolean mo6566j() {
        return Nat256.m28957b(this.f32102a);
    }

    /* renamed from: k */
    public boolean mo6567k() {
        return (this.f32102a[0] & 1) != 0;
    }

    /* renamed from: a */
    public BigInteger mo6549a() {
        return Nat256.m28962c(this.f32102a);
    }

    /* renamed from: a */
    public ECFieldElement mo6551a(ECFieldElement eCFieldElement) {
        long[] b = Nat256.m28958b();
        SecT233Field.m28732a(this.f32102a, ((SecT233FieldElement) eCFieldElement).f32102a, b);
        return new SecT233FieldElement(b);
    }

    /* renamed from: c */
    public ECFieldElement mo6557c() {
        long[] b = Nat256.m28958b();
        SecT233Field.m28731a(this.f32102a, b);
        return new SecT233FieldElement(b);
    }

    /* renamed from: b */
    public ECFieldElement mo6555b(ECFieldElement eCFieldElement) {
        return mo6551a(eCFieldElement);
    }

    /* renamed from: c */
    public ECFieldElement mo6558c(ECFieldElement eCFieldElement) {
        long[] b = Nat256.m28958b();
        SecT233Field.m28737c(this.f32102a, ((SecT233FieldElement) eCFieldElement).f32102a, b);
        return new SecT233FieldElement(b);
    }

    /* renamed from: a */
    public ECFieldElement mo6553a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return mo6556b(eCFieldElement, eCFieldElement2, eCFieldElement3);
    }

    /* renamed from: b */
    public ECFieldElement mo6556b(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        long[] jArr = this.f32102a;
        eCFieldElement = ((SecT233FieldElement) eCFieldElement).f32102a;
        eCFieldElement2 = ((SecT233FieldElement) eCFieldElement2).f32102a;
        eCFieldElement3 = ((SecT233FieldElement) eCFieldElement3).f32102a;
        long[] d = Nat256.m28970d();
        SecT233Field.m28739d(jArr, eCFieldElement, d);
        SecT233Field.m28739d(eCFieldElement2, eCFieldElement3, d);
        long[] b = Nat256.m28958b();
        SecT233Field.m28736c(d, b);
        return new SecT233FieldElement(b);
    }

    /* renamed from: d */
    public ECFieldElement mo6560d(ECFieldElement eCFieldElement) {
        return mo6558c(eCFieldElement.mo6562f());
    }

    /* renamed from: e */
    public ECFieldElement mo6561e() {
        long[] b = Nat256.m28958b();
        SecT233Field.m28738d(this.f32102a, b);
        return new SecT233FieldElement(b);
    }

    /* renamed from: a */
    public ECFieldElement mo6552a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        long[] jArr = this.f32102a;
        eCFieldElement = ((SecT233FieldElement) eCFieldElement).f32102a;
        eCFieldElement2 = ((SecT233FieldElement) eCFieldElement2).f32102a;
        long[] d = Nat256.m28970d();
        SecT233Field.m28740e(jArr, d);
        SecT233Field.m28739d(eCFieldElement, eCFieldElement2, d);
        long[] b = Nat256.m28958b();
        SecT233Field.m28736c(d, b);
        return new SecT233FieldElement(b);
    }

    /* renamed from: a */
    public ECFieldElement mo6550a(int i) {
        if (i < 1) {
            return this;
        }
        long[] b = Nat256.m28958b();
        SecT233Field.m28730a(this.f32102a, i, b);
        return new SecT233FieldElement(b);
    }

    /* renamed from: f */
    public ECFieldElement mo6562f() {
        long[] b = Nat256.m28958b();
        SecT233Field.m28734b(this.f32102a, b);
        return new SecT233FieldElement(b);
    }

    /* renamed from: g */
    public ECFieldElement mo6563g() {
        return mo6550a(m41832m() - 1);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecT233FieldElement)) {
            return null;
        }
        return Nat256.m28949a(this.f32102a, ((SecT233FieldElement) obj).f32102a);
    }

    public int hashCode() {
        return Arrays.m29346a(this.f32102a, 0, 4) ^ 2330074;
    }
}
