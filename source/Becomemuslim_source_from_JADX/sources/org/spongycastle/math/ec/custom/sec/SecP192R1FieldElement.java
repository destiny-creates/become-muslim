package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Mod;
import org.spongycastle.math.raw.Nat192;
import org.spongycastle.util.Arrays;

public class SecP192R1FieldElement extends ECFieldElement {
    /* renamed from: a */
    public static final BigInteger f32062a = SecP192R1Curve.f32060i;
    /* renamed from: b */
    protected int[] f32063b;

    public SecP192R1FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f32062a) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP192R1FieldElement");
        }
        this.f32063b = SecP192R1Field.m28575a(bigInteger);
    }

    public SecP192R1FieldElement() {
        this.f32063b = Nat192.m28894a();
    }

    protected SecP192R1FieldElement(int[] iArr) {
        this.f32063b = iArr;
    }

    /* renamed from: j */
    public boolean mo6566j() {
        return Nat192.m28898b(this.f32063b);
    }

    /* renamed from: i */
    public boolean mo6565i() {
        return Nat192.m28889a(this.f32063b);
    }

    /* renamed from: k */
    public boolean mo6567k() {
        return Nat192.m28884a(this.f32063b, 0) == 1;
    }

    /* renamed from: a */
    public BigInteger mo6549a() {
        return Nat192.m28905c(this.f32063b);
    }

    /* renamed from: b */
    public int mo6554b() {
        return f32062a.bitLength();
    }

    /* renamed from: a */
    public ECFieldElement mo6551a(ECFieldElement eCFieldElement) {
        int[] a = Nat192.m28894a();
        SecP192R1Field.m28574a(this.f32063b, ((SecP192R1FieldElement) eCFieldElement).f32063b, a);
        return new SecP192R1FieldElement(a);
    }

    /* renamed from: c */
    public ECFieldElement mo6557c() {
        int[] a = Nat192.m28894a();
        SecP192R1Field.m28573a(this.f32063b, a);
        return new SecP192R1FieldElement(a);
    }

    /* renamed from: b */
    public ECFieldElement mo6555b(ECFieldElement eCFieldElement) {
        int[] a = Nat192.m28894a();
        SecP192R1Field.m28582d(this.f32063b, ((SecP192R1FieldElement) eCFieldElement).f32063b, a);
        return new SecP192R1FieldElement(a);
    }

    /* renamed from: c */
    public ECFieldElement mo6558c(ECFieldElement eCFieldElement) {
        int[] a = Nat192.m28894a();
        SecP192R1Field.m28578b(this.f32063b, ((SecP192R1FieldElement) eCFieldElement).f32063b, a);
        return new SecP192R1FieldElement(a);
    }

    /* renamed from: d */
    public ECFieldElement mo6560d(ECFieldElement eCFieldElement) {
        int[] a = Nat192.m28894a();
        Mod.m28835a(SecP192R1Field.f23135a, ((SecP192R1FieldElement) eCFieldElement).f32063b, a);
        SecP192R1Field.m28578b(a, this.f32063b, a);
        return new SecP192R1FieldElement(a);
    }

    /* renamed from: d */
    public ECFieldElement mo6559d() {
        int[] a = Nat192.m28894a();
        SecP192R1Field.m28577b(this.f32063b, a);
        return new SecP192R1FieldElement(a);
    }

    /* renamed from: e */
    public ECFieldElement mo6561e() {
        int[] a = Nat192.m28894a();
        SecP192R1Field.m28581d(this.f32063b, a);
        return new SecP192R1FieldElement(a);
    }

    /* renamed from: f */
    public ECFieldElement mo6562f() {
        int[] a = Nat192.m28894a();
        Mod.m28835a(SecP192R1Field.f23135a, this.f32063b, a);
        return new SecP192R1FieldElement(a);
    }

    /* renamed from: g */
    public ECFieldElement mo6563g() {
        int[] iArr = this.f32063b;
        if (!Nat192.m28898b(iArr)) {
            if (!Nat192.m28889a(iArr)) {
                int[] a = Nat192.m28894a();
                int[] a2 = Nat192.m28894a();
                SecP192R1Field.m28581d(iArr, a);
                SecP192R1Field.m28578b(a, iArr, a);
                SecP192R1Field.m28572a(a, 2, a2);
                SecP192R1Field.m28578b(a2, a, a2);
                SecP192R1Field.m28572a(a2, 4, a);
                SecP192R1Field.m28578b(a, a2, a);
                SecP192R1Field.m28572a(a, 8, a2);
                SecP192R1Field.m28578b(a2, a, a2);
                SecP192R1Field.m28572a(a2, 16, a);
                SecP192R1Field.m28578b(a, a2, a);
                SecP192R1Field.m28572a(a, 32, a2);
                SecP192R1Field.m28578b(a2, a, a2);
                SecP192R1Field.m28572a(a2, 64, a);
                SecP192R1Field.m28578b(a, a2, a);
                SecP192R1Field.m28572a(a, 62, a);
                SecP192R1Field.m28581d(a, a2);
                return Nat192.m28891a(iArr, a2) ? new SecP192R1FieldElement(a) : null;
            }
        }
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecP192R1FieldElement)) {
            return null;
        }
        return Nat192.m28891a(this.f32063b, ((SecP192R1FieldElement) obj).f32063b);
    }

    public int hashCode() {
        return f32062a.hashCode() ^ Arrays.m29345a(this.f32063b, 0, 6);
    }
}
