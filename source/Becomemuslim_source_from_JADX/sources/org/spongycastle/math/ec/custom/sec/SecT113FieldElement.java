package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Nat128;
import org.spongycastle.util.Arrays;

public class SecT113FieldElement extends ECFieldElement {
    /* renamed from: a */
    protected long[] f32089a;

    /* renamed from: b */
    public int mo6554b() {
        return 113;
    }

    /* renamed from: d */
    public ECFieldElement mo6559d() {
        return this;
    }

    /* renamed from: m */
    public int m41602m() {
        return 113;
    }

    public SecT113FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 113) {
            throw new IllegalArgumentException("x value invalid for SecT113FieldElement");
        }
        this.f32089a = SecT113Field.m28668a(bigInteger);
    }

    public SecT113FieldElement() {
        this.f32089a = Nat128.m28849b();
    }

    protected SecT113FieldElement(long[] jArr) {
        this.f32089a = jArr;
    }

    /* renamed from: i */
    public boolean mo6565i() {
        return Nat128.m28841a(this.f32089a);
    }

    /* renamed from: j */
    public boolean mo6566j() {
        return Nat128.m28848b(this.f32089a);
    }

    /* renamed from: k */
    public boolean mo6567k() {
        return (this.f32089a[0] & 1) != 0;
    }

    /* renamed from: a */
    public BigInteger mo6549a() {
        return Nat128.m28852c(this.f32089a);
    }

    /* renamed from: a */
    public ECFieldElement mo6551a(ECFieldElement eCFieldElement) {
        long[] b = Nat128.m28849b();
        SecT113Field.m28667a(this.f32089a, ((SecT113FieldElement) eCFieldElement).f32089a, b);
        return new SecT113FieldElement(b);
    }

    /* renamed from: c */
    public ECFieldElement mo6557c() {
        long[] b = Nat128.m28849b();
        SecT113Field.m28666a(this.f32089a, b);
        return new SecT113FieldElement(b);
    }

    /* renamed from: b */
    public ECFieldElement mo6555b(ECFieldElement eCFieldElement) {
        return mo6551a(eCFieldElement);
    }

    /* renamed from: c */
    public ECFieldElement mo6558c(ECFieldElement eCFieldElement) {
        long[] b = Nat128.m28849b();
        SecT113Field.m28672c(this.f32089a, ((SecT113FieldElement) eCFieldElement).f32089a, b);
        return new SecT113FieldElement(b);
    }

    /* renamed from: a */
    public ECFieldElement mo6553a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return mo6556b(eCFieldElement, eCFieldElement2, eCFieldElement3);
    }

    /* renamed from: b */
    public ECFieldElement mo6556b(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        long[] jArr = this.f32089a;
        eCFieldElement = ((SecT113FieldElement) eCFieldElement).f32089a;
        eCFieldElement2 = ((SecT113FieldElement) eCFieldElement2).f32089a;
        eCFieldElement3 = ((SecT113FieldElement) eCFieldElement3).f32089a;
        long[] d = Nat128.m28859d();
        SecT113Field.m28674d(jArr, eCFieldElement, d);
        SecT113Field.m28674d(eCFieldElement2, eCFieldElement3, d);
        long[] b = Nat128.m28849b();
        SecT113Field.m28671c(d, b);
        return new SecT113FieldElement(b);
    }

    /* renamed from: d */
    public ECFieldElement mo6560d(ECFieldElement eCFieldElement) {
        return mo6558c(eCFieldElement.mo6562f());
    }

    /* renamed from: e */
    public ECFieldElement mo6561e() {
        long[] b = Nat128.m28849b();
        SecT113Field.m28673d(this.f32089a, b);
        return new SecT113FieldElement(b);
    }

    /* renamed from: a */
    public ECFieldElement mo6552a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        long[] jArr = this.f32089a;
        eCFieldElement = ((SecT113FieldElement) eCFieldElement).f32089a;
        eCFieldElement2 = ((SecT113FieldElement) eCFieldElement2).f32089a;
        long[] d = Nat128.m28859d();
        SecT113Field.m28675e(jArr, d);
        SecT113Field.m28674d(eCFieldElement, eCFieldElement2, d);
        long[] b = Nat128.m28849b();
        SecT113Field.m28671c(d, b);
        return new SecT113FieldElement(b);
    }

    /* renamed from: a */
    public ECFieldElement mo6550a(int i) {
        if (i < 1) {
            return this;
        }
        long[] b = Nat128.m28849b();
        SecT113Field.m28665a(this.f32089a, i, b);
        return new SecT113FieldElement(b);
    }

    /* renamed from: f */
    public ECFieldElement mo6562f() {
        long[] b = Nat128.m28849b();
        SecT113Field.m28669b(this.f32089a, b);
        return new SecT113FieldElement(b);
    }

    /* renamed from: g */
    public ECFieldElement mo6563g() {
        return mo6550a(m41602m() - 1);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecT113FieldElement)) {
            return null;
        }
        return Nat128.m28842a(this.f32089a, ((SecT113FieldElement) obj).f32089a);
    }

    public int hashCode() {
        return Arrays.m29346a(this.f32089a, 0, 2) ^ 113009;
    }
}
