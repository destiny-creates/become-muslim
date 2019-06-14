package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Mod;
import org.spongycastle.math.raw.Nat224;
import org.spongycastle.util.Arrays;

public class SecP224K1FieldElement extends ECFieldElement {
    /* renamed from: a */
    public static final BigInteger f32066a = SecP224K1Curve.f32064i;
    /* renamed from: h */
    private static final int[] f32067h = new int[]{868209154, -587542221, 579297866, -1014948952, -1470801668, 514782679, -1897982644};
    /* renamed from: b */
    protected int[] f32068b;

    public SecP224K1FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f32066a) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP224K1FieldElement");
        }
        this.f32068b = SecP224K1Field.m28588a(bigInteger);
    }

    public SecP224K1FieldElement() {
        this.f32068b = Nat224.m28923a();
    }

    protected SecP224K1FieldElement(int[] iArr) {
        this.f32068b = iArr;
    }

    /* renamed from: j */
    public boolean mo6566j() {
        return Nat224.m28926b(this.f32068b);
    }

    /* renamed from: i */
    public boolean mo6565i() {
        return Nat224.m28922a(this.f32068b);
    }

    /* renamed from: k */
    public boolean mo6567k() {
        return Nat224.m28918a(this.f32068b, 0) == 1;
    }

    /* renamed from: a */
    public BigInteger mo6549a() {
        return Nat224.m28929c(this.f32068b);
    }

    /* renamed from: b */
    public int mo6554b() {
        return f32066a.bitLength();
    }

    /* renamed from: a */
    public ECFieldElement mo6551a(ECFieldElement eCFieldElement) {
        int[] a = Nat224.m28923a();
        SecP224K1Field.m28587a(this.f32068b, ((SecP224K1FieldElement) eCFieldElement).f32068b, a);
        return new SecP224K1FieldElement(a);
    }

    /* renamed from: c */
    public ECFieldElement mo6557c() {
        int[] a = Nat224.m28923a();
        SecP224K1Field.m28586a(this.f32068b, a);
        return new SecP224K1FieldElement(a);
    }

    /* renamed from: b */
    public ECFieldElement mo6555b(ECFieldElement eCFieldElement) {
        int[] a = Nat224.m28923a();
        SecP224K1Field.m28594d(this.f32068b, ((SecP224K1FieldElement) eCFieldElement).f32068b, a);
        return new SecP224K1FieldElement(a);
    }

    /* renamed from: c */
    public ECFieldElement mo6558c(ECFieldElement eCFieldElement) {
        int[] a = Nat224.m28923a();
        SecP224K1Field.m28590b(this.f32068b, ((SecP224K1FieldElement) eCFieldElement).f32068b, a);
        return new SecP224K1FieldElement(a);
    }

    /* renamed from: d */
    public ECFieldElement mo6560d(ECFieldElement eCFieldElement) {
        int[] a = Nat224.m28923a();
        Mod.m28835a(SecP224K1Field.f23138a, ((SecP224K1FieldElement) eCFieldElement).f32068b, a);
        SecP224K1Field.m28590b(a, this.f32068b, a);
        return new SecP224K1FieldElement(a);
    }

    /* renamed from: d */
    public ECFieldElement mo6559d() {
        int[] a = Nat224.m28923a();
        SecP224K1Field.m28589b(this.f32068b, a);
        return new SecP224K1FieldElement(a);
    }

    /* renamed from: e */
    public ECFieldElement mo6561e() {
        int[] a = Nat224.m28923a();
        SecP224K1Field.m28593d(this.f32068b, a);
        return new SecP224K1FieldElement(a);
    }

    /* renamed from: f */
    public ECFieldElement mo6562f() {
        int[] a = Nat224.m28923a();
        Mod.m28835a(SecP224K1Field.f23138a, this.f32068b, a);
        return new SecP224K1FieldElement(a);
    }

    /* renamed from: g */
    public ECFieldElement mo6563g() {
        int[] iArr = this.f32068b;
        if (!Nat224.m28926b(iArr)) {
            if (!Nat224.m28922a(iArr)) {
                int[] a = Nat224.m28923a();
                SecP224K1Field.m28593d(iArr, a);
                SecP224K1Field.m28590b(a, iArr, a);
                SecP224K1Field.m28593d(a, a);
                SecP224K1Field.m28590b(a, iArr, a);
                int[] a2 = Nat224.m28923a();
                SecP224K1Field.m28593d(a, a2);
                SecP224K1Field.m28590b(a2, iArr, a2);
                int[] a3 = Nat224.m28923a();
                SecP224K1Field.m28585a(a2, 4, a3);
                SecP224K1Field.m28590b(a3, a2, a3);
                int[] a4 = Nat224.m28923a();
                SecP224K1Field.m28585a(a3, 3, a4);
                SecP224K1Field.m28590b(a4, a, a4);
                SecP224K1Field.m28585a(a4, 8, a4);
                SecP224K1Field.m28590b(a4, a3, a4);
                SecP224K1Field.m28585a(a4, 4, a3);
                SecP224K1Field.m28590b(a3, a2, a3);
                SecP224K1Field.m28585a(a3, 19, a2);
                SecP224K1Field.m28590b(a2, a4, a2);
                int[] a5 = Nat224.m28923a();
                SecP224K1Field.m28585a(a2, 42, a5);
                SecP224K1Field.m28590b(a5, a2, a5);
                SecP224K1Field.m28585a(a5, 23, a2);
                SecP224K1Field.m28590b(a2, a3, a2);
                SecP224K1Field.m28585a(a2, 84, a3);
                SecP224K1Field.m28590b(a3, a5, a3);
                SecP224K1Field.m28585a(a3, 20, a3);
                SecP224K1Field.m28590b(a3, a4, a3);
                SecP224K1Field.m28585a(a3, 3, a3);
                SecP224K1Field.m28590b(a3, iArr, a3);
                SecP224K1Field.m28585a(a3, 2, a3);
                SecP224K1Field.m28590b(a3, iArr, a3);
                SecP224K1Field.m28585a(a3, 4, a3);
                SecP224K1Field.m28590b(a3, a, a3);
                SecP224K1Field.m28593d(a3, a3);
                SecP224K1Field.m28593d(a3, a5);
                if (Nat224.m28927b(iArr, a5)) {
                    return new SecP224K1FieldElement(a3);
                }
                SecP224K1Field.m28590b(a3, f32067h, a3);
                SecP224K1Field.m28593d(a3, a5);
                return Nat224.m28927b(iArr, a5) ? new SecP224K1FieldElement(a3) : null;
            }
        }
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecP224K1FieldElement)) {
            return null;
        }
        return Nat224.m28927b(this.f32068b, ((SecP224K1FieldElement) obj).f32068b);
    }

    public int hashCode() {
        return f32066a.hashCode() ^ Arrays.m29345a(this.f32068b, 0, 7);
    }
}
