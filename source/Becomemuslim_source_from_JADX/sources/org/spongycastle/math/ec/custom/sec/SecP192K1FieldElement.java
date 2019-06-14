package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Mod;
import org.spongycastle.math.raw.Nat192;
import org.spongycastle.util.Arrays;

public class SecP192K1FieldElement extends ECFieldElement {
    /* renamed from: a */
    public static final BigInteger f32058a = SecP192K1Curve.f32056i;
    /* renamed from: b */
    protected int[] f32059b;

    public SecP192K1FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f32058a) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP192K1FieldElement");
        }
        this.f32059b = SecP192K1Field.m28562a(bigInteger);
    }

    public SecP192K1FieldElement() {
        this.f32059b = Nat192.m28894a();
    }

    protected SecP192K1FieldElement(int[] iArr) {
        this.f32059b = iArr;
    }

    /* renamed from: j */
    public boolean mo6566j() {
        return Nat192.m28898b(this.f32059b);
    }

    /* renamed from: i */
    public boolean mo6565i() {
        return Nat192.m28889a(this.f32059b);
    }

    /* renamed from: k */
    public boolean mo6567k() {
        return Nat192.m28884a(this.f32059b, 0) == 1;
    }

    /* renamed from: a */
    public BigInteger mo6549a() {
        return Nat192.m28905c(this.f32059b);
    }

    /* renamed from: b */
    public int mo6554b() {
        return f32058a.bitLength();
    }

    /* renamed from: a */
    public ECFieldElement mo6551a(ECFieldElement eCFieldElement) {
        int[] a = Nat192.m28894a();
        SecP192K1Field.m28561a(this.f32059b, ((SecP192K1FieldElement) eCFieldElement).f32059b, a);
        return new SecP192K1FieldElement(a);
    }

    /* renamed from: c */
    public ECFieldElement mo6557c() {
        int[] a = Nat192.m28894a();
        SecP192K1Field.m28560a(this.f32059b, a);
        return new SecP192K1FieldElement(a);
    }

    /* renamed from: b */
    public ECFieldElement mo6555b(ECFieldElement eCFieldElement) {
        int[] a = Nat192.m28894a();
        SecP192K1Field.m28568d(this.f32059b, ((SecP192K1FieldElement) eCFieldElement).f32059b, a);
        return new SecP192K1FieldElement(a);
    }

    /* renamed from: c */
    public ECFieldElement mo6558c(ECFieldElement eCFieldElement) {
        int[] a = Nat192.m28894a();
        SecP192K1Field.m28564b(this.f32059b, ((SecP192K1FieldElement) eCFieldElement).f32059b, a);
        return new SecP192K1FieldElement(a);
    }

    /* renamed from: d */
    public ECFieldElement mo6560d(ECFieldElement eCFieldElement) {
        int[] a = Nat192.m28894a();
        Mod.m28835a(SecP192K1Field.f23132a, ((SecP192K1FieldElement) eCFieldElement).f32059b, a);
        SecP192K1Field.m28564b(a, this.f32059b, a);
        return new SecP192K1FieldElement(a);
    }

    /* renamed from: d */
    public ECFieldElement mo6559d() {
        int[] a = Nat192.m28894a();
        SecP192K1Field.m28563b(this.f32059b, a);
        return new SecP192K1FieldElement(a);
    }

    /* renamed from: e */
    public ECFieldElement mo6561e() {
        int[] a = Nat192.m28894a();
        SecP192K1Field.m28567d(this.f32059b, a);
        return new SecP192K1FieldElement(a);
    }

    /* renamed from: f */
    public ECFieldElement mo6562f() {
        int[] a = Nat192.m28894a();
        Mod.m28835a(SecP192K1Field.f23132a, this.f32059b, a);
        return new SecP192K1FieldElement(a);
    }

    /* renamed from: g */
    public ECFieldElement mo6563g() {
        int[] iArr = this.f32059b;
        if (!Nat192.m28898b(iArr)) {
            if (!Nat192.m28889a(iArr)) {
                int[] a = Nat192.m28894a();
                SecP192K1Field.m28567d(iArr, a);
                SecP192K1Field.m28564b(a, iArr, a);
                int[] a2 = Nat192.m28894a();
                SecP192K1Field.m28567d(a, a2);
                SecP192K1Field.m28564b(a2, iArr, a2);
                int[] a3 = Nat192.m28894a();
                SecP192K1Field.m28559a(a2, 3, a3);
                SecP192K1Field.m28564b(a3, a2, a3);
                SecP192K1Field.m28559a(a3, 2, a3);
                SecP192K1Field.m28564b(a3, a, a3);
                SecP192K1Field.m28559a(a3, 8, a);
                SecP192K1Field.m28564b(a, a3, a);
                SecP192K1Field.m28559a(a, 3, a3);
                SecP192K1Field.m28564b(a3, a2, a3);
                int[] a4 = Nat192.m28894a();
                SecP192K1Field.m28559a(a3, 16, a4);
                SecP192K1Field.m28564b(a4, a, a4);
                SecP192K1Field.m28559a(a4, 35, a);
                SecP192K1Field.m28564b(a, a4, a);
                SecP192K1Field.m28559a(a, 70, a4);
                SecP192K1Field.m28564b(a4, a, a4);
                SecP192K1Field.m28559a(a4, 19, a);
                SecP192K1Field.m28564b(a, a3, a);
                SecP192K1Field.m28559a(a, 20, a);
                SecP192K1Field.m28564b(a, a3, a);
                SecP192K1Field.m28559a(a, 4, a);
                SecP192K1Field.m28564b(a, a2, a);
                SecP192K1Field.m28559a(a, 6, a);
                SecP192K1Field.m28564b(a, a2, a);
                SecP192K1Field.m28567d(a, a);
                SecP192K1Field.m28567d(a, a2);
                return Nat192.m28891a(iArr, a2) ? new SecP192K1FieldElement(a) : null;
            }
        }
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecP192K1FieldElement)) {
            return null;
        }
        return Nat192.m28891a(this.f32059b, ((SecP192K1FieldElement) obj).f32059b);
    }

    public int hashCode() {
        return f32058a.hashCode() ^ Arrays.m29345a(this.f32059b, 0, 6);
    }
}
