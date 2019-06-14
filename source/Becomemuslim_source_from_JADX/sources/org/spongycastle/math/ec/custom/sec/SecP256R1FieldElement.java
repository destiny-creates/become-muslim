package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Mod;
import org.spongycastle.math.raw.Nat256;
import org.spongycastle.util.Arrays;

public class SecP256R1FieldElement extends ECFieldElement {
    /* renamed from: a */
    public static final BigInteger f32079a = SecP256R1Curve.f32077i;
    /* renamed from: b */
    protected int[] f32080b;

    public SecP256R1FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f32079a) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP256R1FieldElement");
        }
        this.f32080b = SecP256R1Field.m28627a(bigInteger);
    }

    public SecP256R1FieldElement() {
        this.f32080b = Nat256.m28950a();
    }

    protected SecP256R1FieldElement(int[] iArr) {
        this.f32080b = iArr;
    }

    /* renamed from: j */
    public boolean mo6566j() {
        return Nat256.m28954b(this.f32080b);
    }

    /* renamed from: i */
    public boolean mo6565i() {
        return Nat256.m28946a(this.f32080b);
    }

    /* renamed from: k */
    public boolean mo6567k() {
        return Nat256.m28940a(this.f32080b, 0) == 1;
    }

    /* renamed from: a */
    public BigInteger mo6549a() {
        return Nat256.m28961c(this.f32080b);
    }

    /* renamed from: b */
    public int mo6554b() {
        return f32079a.bitLength();
    }

    /* renamed from: a */
    public ECFieldElement mo6551a(ECFieldElement eCFieldElement) {
        int[] a = Nat256.m28950a();
        SecP256R1Field.m28626a(this.f32080b, ((SecP256R1FieldElement) eCFieldElement).f32080b, a);
        return new SecP256R1FieldElement(a);
    }

    /* renamed from: c */
    public ECFieldElement mo6557c() {
        int[] a = Nat256.m28950a();
        SecP256R1Field.m28625a(this.f32080b, a);
        return new SecP256R1FieldElement(a);
    }

    /* renamed from: b */
    public ECFieldElement mo6555b(ECFieldElement eCFieldElement) {
        int[] a = Nat256.m28950a();
        SecP256R1Field.m28634d(this.f32080b, ((SecP256R1FieldElement) eCFieldElement).f32080b, a);
        return new SecP256R1FieldElement(a);
    }

    /* renamed from: c */
    public ECFieldElement mo6558c(ECFieldElement eCFieldElement) {
        int[] a = Nat256.m28950a();
        SecP256R1Field.m28630b(this.f32080b, ((SecP256R1FieldElement) eCFieldElement).f32080b, a);
        return new SecP256R1FieldElement(a);
    }

    /* renamed from: d */
    public ECFieldElement mo6560d(ECFieldElement eCFieldElement) {
        int[] a = Nat256.m28950a();
        Mod.m28835a(SecP256R1Field.f23147a, ((SecP256R1FieldElement) eCFieldElement).f32080b, a);
        SecP256R1Field.m28630b(a, this.f32080b, a);
        return new SecP256R1FieldElement(a);
    }

    /* renamed from: d */
    public ECFieldElement mo6559d() {
        int[] a = Nat256.m28950a();
        SecP256R1Field.m28629b(this.f32080b, a);
        return new SecP256R1FieldElement(a);
    }

    /* renamed from: e */
    public ECFieldElement mo6561e() {
        int[] a = Nat256.m28950a();
        SecP256R1Field.m28633d(this.f32080b, a);
        return new SecP256R1FieldElement(a);
    }

    /* renamed from: f */
    public ECFieldElement mo6562f() {
        int[] a = Nat256.m28950a();
        Mod.m28835a(SecP256R1Field.f23147a, this.f32080b, a);
        return new SecP256R1FieldElement(a);
    }

    /* renamed from: g */
    public ECFieldElement mo6563g() {
        int[] iArr = this.f32080b;
        if (!Nat256.m28954b(iArr)) {
            if (!Nat256.m28946a(iArr)) {
                int[] a = Nat256.m28950a();
                int[] a2 = Nat256.m28950a();
                SecP256R1Field.m28633d(iArr, a);
                SecP256R1Field.m28630b(a, iArr, a);
                SecP256R1Field.m28624a(a, 2, a2);
                SecP256R1Field.m28630b(a2, a, a2);
                SecP256R1Field.m28624a(a2, 4, a);
                SecP256R1Field.m28630b(a, a2, a);
                SecP256R1Field.m28624a(a, 8, a2);
                SecP256R1Field.m28630b(a2, a, a2);
                SecP256R1Field.m28624a(a2, 16, a);
                SecP256R1Field.m28630b(a, a2, a);
                SecP256R1Field.m28624a(a, 32, a);
                SecP256R1Field.m28630b(a, iArr, a);
                SecP256R1Field.m28624a(a, 96, a);
                SecP256R1Field.m28630b(a, iArr, a);
                SecP256R1Field.m28624a(a, 94, a);
                SecP256R1Field.m28633d(a, a2);
                return Nat256.m28956b(iArr, a2) ? new SecP256R1FieldElement(a) : null;
            }
        }
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecP256R1FieldElement)) {
            return null;
        }
        return Nat256.m28956b(this.f32080b, ((SecP256R1FieldElement) obj).f32080b);
    }

    public int hashCode() {
        return f32079a.hashCode() ^ Arrays.m29345a(this.f32080b, 0, 8);
    }
}
