package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Mod;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.util.Arrays;

public class SecP521R1FieldElement extends ECFieldElement {
    /* renamed from: a */
    public static final BigInteger f32087a = SecP521R1Curve.f32085i;
    /* renamed from: b */
    protected int[] f32088b;

    public SecP521R1FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f32087a) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP521R1FieldElement");
        }
        this.f32088b = SecP521R1Field.m28654a(bigInteger);
    }

    public SecP521R1FieldElement() {
        this.f32088b = Nat.m29015a(17);
    }

    protected SecP521R1FieldElement(int[] iArr) {
        this.f32088b = iArr;
    }

    /* renamed from: j */
    public boolean mo6566j() {
        return Nat.m29037e(17, this.f32088b);
    }

    /* renamed from: i */
    public boolean mo6565i() {
        return Nat.m29035d(17, this.f32088b);
    }

    /* renamed from: k */
    public boolean mo6567k() {
        return Nat.m29011a(this.f32088b, 0) == 1;
    }

    /* renamed from: a */
    public BigInteger mo6549a() {
        return Nat.m29038f(17, this.f32088b);
    }

    /* renamed from: b */
    public int mo6554b() {
        return f32087a.bitLength();
    }

    /* renamed from: a */
    public ECFieldElement mo6551a(ECFieldElement eCFieldElement) {
        int[] a = Nat.m29015a(17);
        SecP521R1Field.m28653a(this.f32088b, ((SecP521R1FieldElement) eCFieldElement).f32088b, a);
        return new SecP521R1FieldElement(a);
    }

    /* renamed from: c */
    public ECFieldElement mo6557c() {
        int[] a = Nat.m29015a(17);
        SecP521R1Field.m28652a(this.f32088b, a);
        return new SecP521R1FieldElement(a);
    }

    /* renamed from: b */
    public ECFieldElement mo6555b(ECFieldElement eCFieldElement) {
        int[] a = Nat.m29015a(17);
        SecP521R1Field.m28658c(this.f32088b, ((SecP521R1FieldElement) eCFieldElement).f32088b, a);
        return new SecP521R1FieldElement(a);
    }

    /* renamed from: c */
    public ECFieldElement mo6558c(ECFieldElement eCFieldElement) {
        int[] a = Nat.m29015a(17);
        SecP521R1Field.m28656b(this.f32088b, ((SecP521R1FieldElement) eCFieldElement).f32088b, a);
        return new SecP521R1FieldElement(a);
    }

    /* renamed from: d */
    public ECFieldElement mo6560d(ECFieldElement eCFieldElement) {
        int[] a = Nat.m29015a(17);
        Mod.m28835a(SecP521R1Field.f23152a, ((SecP521R1FieldElement) eCFieldElement).f32088b, a);
        SecP521R1Field.m28656b(a, this.f32088b, a);
        return new SecP521R1FieldElement(a);
    }

    /* renamed from: d */
    public ECFieldElement mo6559d() {
        int[] a = Nat.m29015a(17);
        SecP521R1Field.m28655b(this.f32088b, a);
        return new SecP521R1FieldElement(a);
    }

    /* renamed from: e */
    public ECFieldElement mo6561e() {
        int[] a = Nat.m29015a(17);
        SecP521R1Field.m28659d(this.f32088b, a);
        return new SecP521R1FieldElement(a);
    }

    /* renamed from: f */
    public ECFieldElement mo6562f() {
        int[] a = Nat.m29015a(17);
        Mod.m28835a(SecP521R1Field.f23152a, this.f32088b, a);
        return new SecP521R1FieldElement(a);
    }

    /* renamed from: g */
    public ECFieldElement mo6563g() {
        int[] iArr = this.f32088b;
        if (!Nat.m29037e(17, iArr)) {
            if (!Nat.m29035d(17, iArr)) {
                int[] a = Nat.m29015a(17);
                int[] a2 = Nat.m29015a(17);
                SecP521R1Field.m28651a(iArr, 519, a);
                SecP521R1Field.m28659d(a, a2);
                return Nat.m29024b(17, iArr, a2) ? new SecP521R1FieldElement(a) : null;
            }
        }
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecP521R1FieldElement)) {
            return null;
        }
        return Nat.m29024b(17, this.f32088b, ((SecP521R1FieldElement) obj).f32088b);
    }

    public int hashCode() {
        return f32087a.hashCode() ^ Arrays.m29345a(this.f32088b, 0, 17);
    }
}
