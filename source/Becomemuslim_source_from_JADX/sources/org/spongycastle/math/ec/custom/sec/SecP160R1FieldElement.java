package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Mod;
import org.spongycastle.math.raw.Nat160;
import org.spongycastle.util.Arrays;

public class SecP160R1FieldElement extends ECFieldElement {
    /* renamed from: a */
    public static final BigInteger f32050a = SecP160R1Curve.f32048i;
    /* renamed from: b */
    protected int[] f32051b;

    public SecP160R1FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f32050a) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP160R1FieldElement");
        }
        this.f32051b = SecP160R1Field.m28538a(bigInteger);
    }

    public SecP160R1FieldElement() {
        this.f32051b = Nat160.m28868a();
    }

    protected SecP160R1FieldElement(int[] iArr) {
        this.f32051b = iArr;
    }

    /* renamed from: j */
    public boolean mo6566j() {
        return Nat160.m28872b(this.f32051b);
    }

    /* renamed from: i */
    public boolean mo6565i() {
        return Nat160.m28866a(this.f32051b);
    }

    /* renamed from: k */
    public boolean mo6567k() {
        return Nat160.m28863a(this.f32051b, 0) == 1;
    }

    /* renamed from: a */
    public BigInteger mo6549a() {
        return Nat160.m28875c(this.f32051b);
    }

    /* renamed from: b */
    public int mo6554b() {
        return f32050a.bitLength();
    }

    /* renamed from: a */
    public ECFieldElement mo6551a(ECFieldElement eCFieldElement) {
        int[] a = Nat160.m28868a();
        SecP160R1Field.m28537a(this.f32051b, ((SecP160R1FieldElement) eCFieldElement).f32051b, a);
        return new SecP160R1FieldElement(a);
    }

    /* renamed from: c */
    public ECFieldElement mo6557c() {
        int[] a = Nat160.m28868a();
        SecP160R1Field.m28536a(this.f32051b, a);
        return new SecP160R1FieldElement(a);
    }

    /* renamed from: b */
    public ECFieldElement mo6555b(ECFieldElement eCFieldElement) {
        int[] a = Nat160.m28868a();
        SecP160R1Field.m28544d(this.f32051b, ((SecP160R1FieldElement) eCFieldElement).f32051b, a);
        return new SecP160R1FieldElement(a);
    }

    /* renamed from: c */
    public ECFieldElement mo6558c(ECFieldElement eCFieldElement) {
        int[] a = Nat160.m28868a();
        SecP160R1Field.m28540b(this.f32051b, ((SecP160R1FieldElement) eCFieldElement).f32051b, a);
        return new SecP160R1FieldElement(a);
    }

    /* renamed from: d */
    public ECFieldElement mo6560d(ECFieldElement eCFieldElement) {
        int[] a = Nat160.m28868a();
        Mod.m28835a(SecP160R1Field.f23126a, ((SecP160R1FieldElement) eCFieldElement).f32051b, a);
        SecP160R1Field.m28540b(a, this.f32051b, a);
        return new SecP160R1FieldElement(a);
    }

    /* renamed from: d */
    public ECFieldElement mo6559d() {
        int[] a = Nat160.m28868a();
        SecP160R1Field.m28539b(this.f32051b, a);
        return new SecP160R1FieldElement(a);
    }

    /* renamed from: e */
    public ECFieldElement mo6561e() {
        int[] a = Nat160.m28868a();
        SecP160R1Field.m28543d(this.f32051b, a);
        return new SecP160R1FieldElement(a);
    }

    /* renamed from: f */
    public ECFieldElement mo6562f() {
        int[] a = Nat160.m28868a();
        Mod.m28835a(SecP160R1Field.f23126a, this.f32051b, a);
        return new SecP160R1FieldElement(a);
    }

    /* renamed from: g */
    public ECFieldElement mo6563g() {
        int[] iArr = this.f32051b;
        if (!Nat160.m28872b(iArr)) {
            if (!Nat160.m28866a(iArr)) {
                int[] a = Nat160.m28868a();
                SecP160R1Field.m28543d(iArr, a);
                SecP160R1Field.m28540b(a, iArr, a);
                int[] a2 = Nat160.m28868a();
                SecP160R1Field.m28535a(a, 2, a2);
                SecP160R1Field.m28540b(a2, a, a2);
                SecP160R1Field.m28535a(a2, 4, a);
                SecP160R1Field.m28540b(a, a2, a);
                SecP160R1Field.m28535a(a, 8, a2);
                SecP160R1Field.m28540b(a2, a, a2);
                SecP160R1Field.m28535a(a2, 16, a);
                SecP160R1Field.m28540b(a, a2, a);
                SecP160R1Field.m28535a(a, 32, a2);
                SecP160R1Field.m28540b(a2, a, a2);
                SecP160R1Field.m28535a(a2, 64, a);
                SecP160R1Field.m28540b(a, a2, a);
                SecP160R1Field.m28543d(a, a2);
                SecP160R1Field.m28540b(a2, iArr, a2);
                SecP160R1Field.m28535a(a2, 29, a2);
                SecP160R1Field.m28543d(a2, a);
                return Nat160.m28867a(iArr, a) ? new SecP160R1FieldElement(a2) : null;
            }
        }
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecP160R1FieldElement)) {
            return null;
        }
        return Nat160.m28867a(this.f32051b, ((SecP160R1FieldElement) obj).f32051b);
    }

    public int hashCode() {
        return f32050a.hashCode() ^ Arrays.m29345a(this.f32051b, 0, 5);
    }
}
