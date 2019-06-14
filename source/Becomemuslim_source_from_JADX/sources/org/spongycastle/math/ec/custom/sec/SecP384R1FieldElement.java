package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Mod;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.util.Arrays;

public class SecP384R1FieldElement extends ECFieldElement {
    /* renamed from: a */
    public static final BigInteger f32083a = SecP384R1Curve.f32081i;
    /* renamed from: b */
    protected int[] f32084b;

    public SecP384R1FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f32083a) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP384R1FieldElement");
        }
        this.f32084b = SecP384R1Field.m28641a(bigInteger);
    }

    public SecP384R1FieldElement() {
        this.f32084b = Nat.m29015a(12);
    }

    protected SecP384R1FieldElement(int[] iArr) {
        this.f32084b = iArr;
    }

    /* renamed from: j */
    public boolean mo6566j() {
        return Nat.m29037e(12, this.f32084b);
    }

    /* renamed from: i */
    public boolean mo6565i() {
        return Nat.m29035d(12, this.f32084b);
    }

    /* renamed from: k */
    public boolean mo6567k() {
        return Nat.m29011a(this.f32084b, 0) == 1;
    }

    /* renamed from: a */
    public BigInteger mo6549a() {
        return Nat.m29038f(12, this.f32084b);
    }

    /* renamed from: b */
    public int mo6554b() {
        return f32083a.bitLength();
    }

    /* renamed from: a */
    public ECFieldElement mo6551a(ECFieldElement eCFieldElement) {
        int[] a = Nat.m29015a(12);
        SecP384R1Field.m28640a(this.f32084b, ((SecP384R1FieldElement) eCFieldElement).f32084b, a);
        return new SecP384R1FieldElement(a);
    }

    /* renamed from: c */
    public ECFieldElement mo6557c() {
        int[] a = Nat.m29015a(12);
        SecP384R1Field.m28639a(this.f32084b, a);
        return new SecP384R1FieldElement(a);
    }

    /* renamed from: b */
    public ECFieldElement mo6555b(ECFieldElement eCFieldElement) {
        int[] a = Nat.m29015a(12);
        SecP384R1Field.m28648d(this.f32084b, ((SecP384R1FieldElement) eCFieldElement).f32084b, a);
        return new SecP384R1FieldElement(a);
    }

    /* renamed from: c */
    public ECFieldElement mo6558c(ECFieldElement eCFieldElement) {
        int[] a = Nat.m29015a(12);
        SecP384R1Field.m28646c(this.f32084b, ((SecP384R1FieldElement) eCFieldElement).f32084b, a);
        return new SecP384R1FieldElement(a);
    }

    /* renamed from: d */
    public ECFieldElement mo6560d(ECFieldElement eCFieldElement) {
        int[] a = Nat.m29015a(12);
        Mod.m28835a(SecP384R1Field.f23149a, ((SecP384R1FieldElement) eCFieldElement).f32084b, a);
        SecP384R1Field.m28646c(a, this.f32084b, a);
        return new SecP384R1FieldElement(a);
    }

    /* renamed from: d */
    public ECFieldElement mo6559d() {
        int[] a = Nat.m29015a(12);
        SecP384R1Field.m28643b(this.f32084b, a);
        return new SecP384R1FieldElement(a);
    }

    /* renamed from: e */
    public ECFieldElement mo6561e() {
        int[] a = Nat.m29015a(12);
        SecP384R1Field.m28647d(this.f32084b, a);
        return new SecP384R1FieldElement(a);
    }

    /* renamed from: f */
    public ECFieldElement mo6562f() {
        int[] a = Nat.m29015a(12);
        Mod.m28835a(SecP384R1Field.f23149a, this.f32084b, a);
        return new SecP384R1FieldElement(a);
    }

    /* renamed from: g */
    public ECFieldElement mo6563g() {
        int[] iArr = this.f32084b;
        if (!Nat.m29037e(12, iArr)) {
            if (!Nat.m29035d(12, iArr)) {
                int[] a = Nat.m29015a(12);
                int[] a2 = Nat.m29015a(12);
                int[] a3 = Nat.m29015a(12);
                int[] a4 = Nat.m29015a(12);
                SecP384R1Field.m28647d(iArr, a);
                SecP384R1Field.m28646c(a, iArr, a);
                SecP384R1Field.m28638a(a, 2, a2);
                SecP384R1Field.m28646c(a2, a, a2);
                SecP384R1Field.m28647d(a2, a2);
                SecP384R1Field.m28646c(a2, iArr, a2);
                SecP384R1Field.m28638a(a2, 5, a3);
                SecP384R1Field.m28646c(a3, a2, a3);
                SecP384R1Field.m28638a(a3, 5, a4);
                SecP384R1Field.m28646c(a4, a2, a4);
                SecP384R1Field.m28638a(a4, 15, a2);
                SecP384R1Field.m28646c(a2, a4, a2);
                SecP384R1Field.m28638a(a2, 2, a3);
                SecP384R1Field.m28646c(a, a3, a);
                SecP384R1Field.m28638a(a3, 28, a3);
                SecP384R1Field.m28646c(a2, a3, a2);
                SecP384R1Field.m28638a(a2, 60, a3);
                SecP384R1Field.m28646c(a3, a2, a3);
                SecP384R1Field.m28638a(a3, 120, a2);
                SecP384R1Field.m28646c(a2, a3, a2);
                SecP384R1Field.m28638a(a2, 15, a2);
                SecP384R1Field.m28646c(a2, a4, a2);
                SecP384R1Field.m28638a(a2, 33, a2);
                SecP384R1Field.m28646c(a2, a, a2);
                SecP384R1Field.m28638a(a2, 64, a2);
                SecP384R1Field.m28646c(a2, iArr, a2);
                SecP384R1Field.m28638a(a2, 30, a);
                SecP384R1Field.m28647d(a, a2);
                return Nat.m29024b(12, iArr, a2) ? new SecP384R1FieldElement(a) : null;
            }
        }
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecP384R1FieldElement)) {
            return null;
        }
        return Nat.m29024b(12, this.f32084b, ((SecP384R1FieldElement) obj).f32084b);
    }

    public int hashCode() {
        return f32083a.hashCode() ^ Arrays.m29345a(this.f32084b, 0, 12);
    }
}
