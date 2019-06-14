package org.spongycastle.math.ec.custom.djb;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Mod;
import org.spongycastle.math.raw.Nat256;
import org.spongycastle.util.Arrays;

public class Curve25519FieldElement extends ECFieldElement {
    /* renamed from: a */
    public static final BigInteger f32039a = Curve25519.f32037i;
    /* renamed from: h */
    private static final int[] f32040h = new int[]{1242472624, -991028441, -1389370248, 792926214, 1039914919, 726466713, 1338105611, 730014848};
    /* renamed from: b */
    protected int[] f32041b;

    public Curve25519FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f32039a) >= 0) {
            throw new IllegalArgumentException("x value invalid for Curve25519FieldElement");
        }
        this.f32041b = Curve25519Field.m28510a(bigInteger);
    }

    public Curve25519FieldElement() {
        this.f32041b = Nat256.m28950a();
    }

    protected Curve25519FieldElement(int[] iArr) {
        this.f32041b = iArr;
    }

    /* renamed from: j */
    public boolean mo6566j() {
        return Nat256.m28954b(this.f32041b);
    }

    /* renamed from: i */
    public boolean mo6565i() {
        return Nat256.m28946a(this.f32041b);
    }

    /* renamed from: k */
    public boolean mo6567k() {
        return Nat256.m28940a(this.f32041b, 0) == 1;
    }

    /* renamed from: a */
    public BigInteger mo6549a() {
        return Nat256.m28961c(this.f32041b);
    }

    /* renamed from: b */
    public int mo6554b() {
        return f32039a.bitLength();
    }

    /* renamed from: a */
    public ECFieldElement mo6551a(ECFieldElement eCFieldElement) {
        int[] a = Nat256.m28950a();
        Curve25519Field.m28509a(this.f32041b, ((Curve25519FieldElement) eCFieldElement).f32041b, a);
        return new Curve25519FieldElement(a);
    }

    /* renamed from: c */
    public ECFieldElement mo6557c() {
        int[] a = Nat256.m28950a();
        Curve25519Field.m28508a(this.f32041b, a);
        return new Curve25519FieldElement(a);
    }

    /* renamed from: b */
    public ECFieldElement mo6555b(ECFieldElement eCFieldElement) {
        int[] a = Nat256.m28950a();
        Curve25519Field.m28518d(this.f32041b, ((Curve25519FieldElement) eCFieldElement).f32041b, a);
        return new Curve25519FieldElement(a);
    }

    /* renamed from: c */
    public ECFieldElement mo6558c(ECFieldElement eCFieldElement) {
        int[] a = Nat256.m28950a();
        Curve25519Field.m28513b(this.f32041b, ((Curve25519FieldElement) eCFieldElement).f32041b, a);
        return new Curve25519FieldElement(a);
    }

    /* renamed from: d */
    public ECFieldElement mo6560d(ECFieldElement eCFieldElement) {
        int[] a = Nat256.m28950a();
        Mod.m28835a(Curve25519Field.f23121a, ((Curve25519FieldElement) eCFieldElement).f32041b, a);
        Curve25519Field.m28513b(a, this.f32041b, a);
        return new Curve25519FieldElement(a);
    }

    /* renamed from: d */
    public ECFieldElement mo6559d() {
        int[] a = Nat256.m28950a();
        Curve25519Field.m28512b(this.f32041b, a);
        return new Curve25519FieldElement(a);
    }

    /* renamed from: e */
    public ECFieldElement mo6561e() {
        int[] a = Nat256.m28950a();
        Curve25519Field.m28517d(this.f32041b, a);
        return new Curve25519FieldElement(a);
    }

    /* renamed from: f */
    public ECFieldElement mo6562f() {
        int[] a = Nat256.m28950a();
        Mod.m28835a(Curve25519Field.f23121a, this.f32041b, a);
        return new Curve25519FieldElement(a);
    }

    /* renamed from: g */
    public ECFieldElement mo6563g() {
        int[] iArr = this.f32041b;
        if (!Nat256.m28954b(iArr)) {
            if (!Nat256.m28946a(iArr)) {
                int[] a = Nat256.m28950a();
                Curve25519Field.m28517d(iArr, a);
                Curve25519Field.m28513b(a, iArr, a);
                Curve25519Field.m28517d(a, a);
                Curve25519Field.m28513b(a, iArr, a);
                int[] a2 = Nat256.m28950a();
                Curve25519Field.m28517d(a, a2);
                Curve25519Field.m28513b(a2, iArr, a2);
                int[] a3 = Nat256.m28950a();
                Curve25519Field.m28507a(a2, 3, a3);
                Curve25519Field.m28513b(a3, a, a3);
                Curve25519Field.m28507a(a3, 4, a);
                Curve25519Field.m28513b(a, a2, a);
                Curve25519Field.m28507a(a, 4, a3);
                Curve25519Field.m28513b(a3, a2, a3);
                Curve25519Field.m28507a(a3, 15, a2);
                Curve25519Field.m28513b(a2, a3, a2);
                Curve25519Field.m28507a(a2, 30, a3);
                Curve25519Field.m28513b(a3, a2, a3);
                Curve25519Field.m28507a(a3, 60, a2);
                Curve25519Field.m28513b(a2, a3, a2);
                Curve25519Field.m28507a(a2, 11, a3);
                Curve25519Field.m28513b(a3, a, a3);
                Curve25519Field.m28507a(a3, 120, a);
                Curve25519Field.m28513b(a, a2, a);
                Curve25519Field.m28517d(a, a);
                Curve25519Field.m28517d(a, a2);
                if (Nat256.m28956b(iArr, a2)) {
                    return new Curve25519FieldElement(a);
                }
                Curve25519Field.m28513b(a, f32040h, a);
                Curve25519Field.m28517d(a, a2);
                return Nat256.m28956b(iArr, a2) ? new Curve25519FieldElement(a) : null;
            }
        }
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Curve25519FieldElement)) {
            return null;
        }
        return Nat256.m28956b(this.f32041b, ((Curve25519FieldElement) obj).f32041b);
    }

    public int hashCode() {
        return f32039a.hashCode() ^ Arrays.m29345a(this.f32041b, 0, 8);
    }
}
