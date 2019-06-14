package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Mod;
import org.spongycastle.math.raw.Nat128;
import org.spongycastle.util.Arrays;

public class SecP128R1FieldElement extends ECFieldElement {
    /* renamed from: a */
    public static final BigInteger f32044a = SecP128R1Curve.f32042i;
    /* renamed from: b */
    protected int[] f32045b;

    public SecP128R1FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f32044a) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP128R1FieldElement");
        }
        this.f32045b = SecP128R1Field.m28525a(bigInteger);
    }

    public SecP128R1FieldElement() {
        this.f32045b = Nat128.m28843a();
    }

    protected SecP128R1FieldElement(int[] iArr) {
        this.f32045b = iArr;
    }

    /* renamed from: j */
    public boolean mo6566j() {
        return Nat128.m28846b(this.f32045b);
    }

    /* renamed from: i */
    public boolean mo6565i() {
        return Nat128.m28839a(this.f32045b);
    }

    /* renamed from: k */
    public boolean mo6567k() {
        return Nat128.m28837a(this.f32045b, 0) == 1;
    }

    /* renamed from: a */
    public BigInteger mo6549a() {
        return Nat128.m28851c(this.f32045b);
    }

    /* renamed from: b */
    public int mo6554b() {
        return f32044a.bitLength();
    }

    /* renamed from: a */
    public ECFieldElement mo6551a(ECFieldElement eCFieldElement) {
        int[] a = Nat128.m28843a();
        SecP128R1Field.m28524a(this.f32045b, ((SecP128R1FieldElement) eCFieldElement).f32045b, a);
        return new SecP128R1FieldElement(a);
    }

    /* renamed from: c */
    public ECFieldElement mo6557c() {
        int[] a = Nat128.m28843a();
        SecP128R1Field.m28523a(this.f32045b, a);
        return new SecP128R1FieldElement(a);
    }

    /* renamed from: b */
    public ECFieldElement mo6555b(ECFieldElement eCFieldElement) {
        int[] a = Nat128.m28843a();
        SecP128R1Field.m28532d(this.f32045b, ((SecP128R1FieldElement) eCFieldElement).f32045b, a);
        return new SecP128R1FieldElement(a);
    }

    /* renamed from: c */
    public ECFieldElement mo6558c(ECFieldElement eCFieldElement) {
        int[] a = Nat128.m28843a();
        SecP128R1Field.m28528b(this.f32045b, ((SecP128R1FieldElement) eCFieldElement).f32045b, a);
        return new SecP128R1FieldElement(a);
    }

    /* renamed from: d */
    public ECFieldElement mo6560d(ECFieldElement eCFieldElement) {
        int[] a = Nat128.m28843a();
        Mod.m28835a(SecP128R1Field.f23123a, ((SecP128R1FieldElement) eCFieldElement).f32045b, a);
        SecP128R1Field.m28528b(a, this.f32045b, a);
        return new SecP128R1FieldElement(a);
    }

    /* renamed from: d */
    public ECFieldElement mo6559d() {
        int[] a = Nat128.m28843a();
        SecP128R1Field.m28527b(this.f32045b, a);
        return new SecP128R1FieldElement(a);
    }

    /* renamed from: e */
    public ECFieldElement mo6561e() {
        int[] a = Nat128.m28843a();
        SecP128R1Field.m28531d(this.f32045b, a);
        return new SecP128R1FieldElement(a);
    }

    /* renamed from: f */
    public ECFieldElement mo6562f() {
        int[] a = Nat128.m28843a();
        Mod.m28835a(SecP128R1Field.f23123a, this.f32045b, a);
        return new SecP128R1FieldElement(a);
    }

    /* renamed from: g */
    public ECFieldElement mo6563g() {
        int[] iArr = this.f32045b;
        if (!Nat128.m28846b(iArr)) {
            if (!Nat128.m28839a(iArr)) {
                int[] a = Nat128.m28843a();
                SecP128R1Field.m28531d(iArr, a);
                SecP128R1Field.m28528b(a, iArr, a);
                int[] a2 = Nat128.m28843a();
                SecP128R1Field.m28522a(a, 2, a2);
                SecP128R1Field.m28528b(a2, a, a2);
                int[] a3 = Nat128.m28843a();
                SecP128R1Field.m28522a(a2, 4, a3);
                SecP128R1Field.m28528b(a3, a2, a3);
                SecP128R1Field.m28522a(a3, 2, a2);
                SecP128R1Field.m28528b(a2, a, a2);
                SecP128R1Field.m28522a(a2, 10, a);
                SecP128R1Field.m28528b(a, a2, a);
                SecP128R1Field.m28522a(a, 10, a3);
                SecP128R1Field.m28528b(a3, a2, a3);
                SecP128R1Field.m28531d(a3, a2);
                SecP128R1Field.m28528b(a2, iArr, a2);
                SecP128R1Field.m28522a(a2, 95, a2);
                SecP128R1Field.m28531d(a2, a3);
                return Nat128.m28840a(iArr, a3) ? new SecP128R1FieldElement(a2) : null;
            }
        }
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecP128R1FieldElement)) {
            return null;
        }
        return Nat128.m28840a(this.f32045b, ((SecP128R1FieldElement) obj).f32045b);
    }

    public int hashCode() {
        return f32044a.hashCode() ^ Arrays.m29345a(this.f32045b, 0, 4);
    }
}
