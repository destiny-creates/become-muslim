package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Mod;
import org.spongycastle.math.raw.Nat160;
import org.spongycastle.util.Arrays;

public class SecP160R2FieldElement extends ECFieldElement {
    /* renamed from: a */
    public static final BigInteger f32054a = SecP160R2Curve.f32052i;
    /* renamed from: b */
    protected int[] f32055b;

    public SecP160R2FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f32054a) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP160R2FieldElement");
        }
        this.f32055b = SecP160R2Field.m28550a(bigInteger);
    }

    public SecP160R2FieldElement() {
        this.f32055b = Nat160.m28868a();
    }

    protected SecP160R2FieldElement(int[] iArr) {
        this.f32055b = iArr;
    }

    /* renamed from: j */
    public boolean mo6566j() {
        return Nat160.m28872b(this.f32055b);
    }

    /* renamed from: i */
    public boolean mo6565i() {
        return Nat160.m28866a(this.f32055b);
    }

    /* renamed from: k */
    public boolean mo6567k() {
        return Nat160.m28863a(this.f32055b, 0) == 1;
    }

    /* renamed from: a */
    public BigInteger mo6549a() {
        return Nat160.m28875c(this.f32055b);
    }

    /* renamed from: b */
    public int mo6554b() {
        return f32054a.bitLength();
    }

    /* renamed from: a */
    public ECFieldElement mo6551a(ECFieldElement eCFieldElement) {
        int[] a = Nat160.m28868a();
        SecP160R2Field.m28549a(this.f32055b, ((SecP160R2FieldElement) eCFieldElement).f32055b, a);
        return new SecP160R2FieldElement(a);
    }

    /* renamed from: c */
    public ECFieldElement mo6557c() {
        int[] a = Nat160.m28868a();
        SecP160R2Field.m28548a(this.f32055b, a);
        return new SecP160R2FieldElement(a);
    }

    /* renamed from: b */
    public ECFieldElement mo6555b(ECFieldElement eCFieldElement) {
        int[] a = Nat160.m28868a();
        SecP160R2Field.m28556d(this.f32055b, ((SecP160R2FieldElement) eCFieldElement).f32055b, a);
        return new SecP160R2FieldElement(a);
    }

    /* renamed from: c */
    public ECFieldElement mo6558c(ECFieldElement eCFieldElement) {
        int[] a = Nat160.m28868a();
        SecP160R2Field.m28552b(this.f32055b, ((SecP160R2FieldElement) eCFieldElement).f32055b, a);
        return new SecP160R2FieldElement(a);
    }

    /* renamed from: d */
    public ECFieldElement mo6560d(ECFieldElement eCFieldElement) {
        int[] a = Nat160.m28868a();
        Mod.m28835a(SecP160R2Field.f23129a, ((SecP160R2FieldElement) eCFieldElement).f32055b, a);
        SecP160R2Field.m28552b(a, this.f32055b, a);
        return new SecP160R2FieldElement(a);
    }

    /* renamed from: d */
    public ECFieldElement mo6559d() {
        int[] a = Nat160.m28868a();
        SecP160R2Field.m28551b(this.f32055b, a);
        return new SecP160R2FieldElement(a);
    }

    /* renamed from: e */
    public ECFieldElement mo6561e() {
        int[] a = Nat160.m28868a();
        SecP160R2Field.m28555d(this.f32055b, a);
        return new SecP160R2FieldElement(a);
    }

    /* renamed from: f */
    public ECFieldElement mo6562f() {
        int[] a = Nat160.m28868a();
        Mod.m28835a(SecP160R2Field.f23129a, this.f32055b, a);
        return new SecP160R2FieldElement(a);
    }

    /* renamed from: g */
    public ECFieldElement mo6563g() {
        int[] iArr = this.f32055b;
        if (!Nat160.m28872b(iArr)) {
            if (!Nat160.m28866a(iArr)) {
                int[] a = Nat160.m28868a();
                SecP160R2Field.m28555d(iArr, a);
                SecP160R2Field.m28552b(a, iArr, a);
                int[] a2 = Nat160.m28868a();
                SecP160R2Field.m28555d(a, a2);
                SecP160R2Field.m28552b(a2, iArr, a2);
                int[] a3 = Nat160.m28868a();
                SecP160R2Field.m28555d(a2, a3);
                SecP160R2Field.m28552b(a3, iArr, a3);
                int[] a4 = Nat160.m28868a();
                SecP160R2Field.m28547a(a3, 3, a4);
                SecP160R2Field.m28552b(a4, a2, a4);
                SecP160R2Field.m28547a(a4, 7, a3);
                SecP160R2Field.m28552b(a3, a4, a3);
                SecP160R2Field.m28547a(a3, 3, a4);
                SecP160R2Field.m28552b(a4, a2, a4);
                int[] a5 = Nat160.m28868a();
                SecP160R2Field.m28547a(a4, 14, a5);
                SecP160R2Field.m28552b(a5, a3, a5);
                SecP160R2Field.m28547a(a5, 31, a3);
                SecP160R2Field.m28552b(a3, a5, a3);
                SecP160R2Field.m28547a(a3, 62, a5);
                SecP160R2Field.m28552b(a5, a3, a5);
                SecP160R2Field.m28547a(a5, 3, a3);
                SecP160R2Field.m28552b(a3, a2, a3);
                SecP160R2Field.m28547a(a3, 18, a3);
                SecP160R2Field.m28552b(a3, a4, a3);
                SecP160R2Field.m28547a(a3, 2, a3);
                SecP160R2Field.m28552b(a3, iArr, a3);
                SecP160R2Field.m28547a(a3, 3, a3);
                SecP160R2Field.m28552b(a3, a, a3);
                SecP160R2Field.m28547a(a3, 6, a3);
                SecP160R2Field.m28552b(a3, a2, a3);
                SecP160R2Field.m28547a(a3, 2, a3);
                SecP160R2Field.m28552b(a3, iArr, a3);
                SecP160R2Field.m28555d(a3, a);
                return Nat160.m28867a(iArr, a) ? new SecP160R2FieldElement(a3) : null;
            }
        }
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecP160R2FieldElement)) {
            return null;
        }
        return Nat160.m28867a(this.f32055b, ((SecP160R2FieldElement) obj).f32055b);
    }

    public int hashCode() {
        return f32054a.hashCode() ^ Arrays.m29345a(this.f32055b, 0, 5);
    }
}
