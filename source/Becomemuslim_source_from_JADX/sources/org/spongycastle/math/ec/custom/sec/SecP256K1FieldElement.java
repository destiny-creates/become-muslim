package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Mod;
import org.spongycastle.math.raw.Nat256;
import org.spongycastle.util.Arrays;

public class SecP256K1FieldElement extends ECFieldElement {
    /* renamed from: a */
    public static final BigInteger f32075a = SecP256K1Curve.f32073i;
    /* renamed from: b */
    protected int[] f32076b;

    public SecP256K1FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f32075a) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP256K1FieldElement");
        }
        this.f32076b = SecP256K1Field.m28614a(bigInteger);
    }

    public SecP256K1FieldElement() {
        this.f32076b = Nat256.m28950a();
    }

    protected SecP256K1FieldElement(int[] iArr) {
        this.f32076b = iArr;
    }

    /* renamed from: j */
    public boolean mo6566j() {
        return Nat256.m28954b(this.f32076b);
    }

    /* renamed from: i */
    public boolean mo6565i() {
        return Nat256.m28946a(this.f32076b);
    }

    /* renamed from: k */
    public boolean mo6567k() {
        return Nat256.m28940a(this.f32076b, 0) == 1;
    }

    /* renamed from: a */
    public BigInteger mo6549a() {
        return Nat256.m28961c(this.f32076b);
    }

    /* renamed from: b */
    public int mo6554b() {
        return f32075a.bitLength();
    }

    /* renamed from: a */
    public ECFieldElement mo6551a(ECFieldElement eCFieldElement) {
        int[] a = Nat256.m28950a();
        SecP256K1Field.m28613a(this.f32076b, ((SecP256K1FieldElement) eCFieldElement).f32076b, a);
        return new SecP256K1FieldElement(a);
    }

    /* renamed from: c */
    public ECFieldElement mo6557c() {
        int[] a = Nat256.m28950a();
        SecP256K1Field.m28612a(this.f32076b, a);
        return new SecP256K1FieldElement(a);
    }

    /* renamed from: b */
    public ECFieldElement mo6555b(ECFieldElement eCFieldElement) {
        int[] a = Nat256.m28950a();
        SecP256K1Field.m28620d(this.f32076b, ((SecP256K1FieldElement) eCFieldElement).f32076b, a);
        return new SecP256K1FieldElement(a);
    }

    /* renamed from: c */
    public ECFieldElement mo6558c(ECFieldElement eCFieldElement) {
        int[] a = Nat256.m28950a();
        SecP256K1Field.m28616b(this.f32076b, ((SecP256K1FieldElement) eCFieldElement).f32076b, a);
        return new SecP256K1FieldElement(a);
    }

    /* renamed from: d */
    public ECFieldElement mo6560d(ECFieldElement eCFieldElement) {
        int[] a = Nat256.m28950a();
        Mod.m28835a(SecP256K1Field.f23144a, ((SecP256K1FieldElement) eCFieldElement).f32076b, a);
        SecP256K1Field.m28616b(a, this.f32076b, a);
        return new SecP256K1FieldElement(a);
    }

    /* renamed from: d */
    public ECFieldElement mo6559d() {
        int[] a = Nat256.m28950a();
        SecP256K1Field.m28615b(this.f32076b, a);
        return new SecP256K1FieldElement(a);
    }

    /* renamed from: e */
    public ECFieldElement mo6561e() {
        int[] a = Nat256.m28950a();
        SecP256K1Field.m28619d(this.f32076b, a);
        return new SecP256K1FieldElement(a);
    }

    /* renamed from: f */
    public ECFieldElement mo6562f() {
        int[] a = Nat256.m28950a();
        Mod.m28835a(SecP256K1Field.f23144a, this.f32076b, a);
        return new SecP256K1FieldElement(a);
    }

    /* renamed from: g */
    public ECFieldElement mo6563g() {
        int[] iArr = this.f32076b;
        if (!Nat256.m28954b(iArr)) {
            if (!Nat256.m28946a(iArr)) {
                int[] a = Nat256.m28950a();
                SecP256K1Field.m28619d(iArr, a);
                SecP256K1Field.m28616b(a, iArr, a);
                int[] a2 = Nat256.m28950a();
                SecP256K1Field.m28619d(a, a2);
                SecP256K1Field.m28616b(a2, iArr, a2);
                int[] a3 = Nat256.m28950a();
                SecP256K1Field.m28611a(a2, 3, a3);
                SecP256K1Field.m28616b(a3, a2, a3);
                SecP256K1Field.m28611a(a3, 3, a3);
                SecP256K1Field.m28616b(a3, a2, a3);
                SecP256K1Field.m28611a(a3, 2, a3);
                SecP256K1Field.m28616b(a3, a, a3);
                int[] a4 = Nat256.m28950a();
                SecP256K1Field.m28611a(a3, 11, a4);
                SecP256K1Field.m28616b(a4, a3, a4);
                SecP256K1Field.m28611a(a4, 22, a3);
                SecP256K1Field.m28616b(a3, a4, a3);
                int[] a5 = Nat256.m28950a();
                SecP256K1Field.m28611a(a3, 44, a5);
                SecP256K1Field.m28616b(a5, a3, a5);
                int[] a6 = Nat256.m28950a();
                SecP256K1Field.m28611a(a5, 88, a6);
                SecP256K1Field.m28616b(a6, a5, a6);
                SecP256K1Field.m28611a(a6, 44, a5);
                SecP256K1Field.m28616b(a5, a3, a5);
                SecP256K1Field.m28611a(a5, 3, a3);
                SecP256K1Field.m28616b(a3, a2, a3);
                SecP256K1Field.m28611a(a3, 23, a3);
                SecP256K1Field.m28616b(a3, a4, a3);
                SecP256K1Field.m28611a(a3, 6, a3);
                SecP256K1Field.m28616b(a3, a, a3);
                SecP256K1Field.m28611a(a3, 2, a3);
                SecP256K1Field.m28619d(a3, a);
                return Nat256.m28956b(iArr, a) ? new SecP256K1FieldElement(a3) : null;
            }
        }
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecP256K1FieldElement)) {
            return null;
        }
        return Nat256.m28956b(this.f32076b, ((SecP256K1FieldElement) obj).f32076b);
    }

    public int hashCode() {
        return f32075a.hashCode() ^ Arrays.m29345a(this.f32076b, 0, 8);
    }
}
