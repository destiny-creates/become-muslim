package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Mod;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat224;
import org.spongycastle.util.Arrays;

public class SecP224R1FieldElement extends ECFieldElement {
    /* renamed from: a */
    public static final BigInteger f32071a = SecP224R1Curve.f32069i;
    /* renamed from: b */
    protected int[] f32072b;

    public SecP224R1FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f32071a) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP224R1FieldElement");
        }
        this.f32072b = SecP224R1Field.m28601a(bigInteger);
    }

    public SecP224R1FieldElement() {
        this.f32072b = Nat224.m28923a();
    }

    protected SecP224R1FieldElement(int[] iArr) {
        this.f32072b = iArr;
    }

    /* renamed from: j */
    public boolean mo6566j() {
        return Nat224.m28926b(this.f32072b);
    }

    /* renamed from: i */
    public boolean mo6565i() {
        return Nat224.m28922a(this.f32072b);
    }

    /* renamed from: k */
    public boolean mo6567k() {
        return Nat224.m28918a(this.f32072b, 0) == 1;
    }

    /* renamed from: a */
    public BigInteger mo6549a() {
        return Nat224.m28929c(this.f32072b);
    }

    /* renamed from: b */
    public int mo6554b() {
        return f32071a.bitLength();
    }

    /* renamed from: a */
    public ECFieldElement mo6551a(ECFieldElement eCFieldElement) {
        int[] a = Nat224.m28923a();
        SecP224R1Field.m28600a(this.f32072b, ((SecP224R1FieldElement) eCFieldElement).f32072b, a);
        return new SecP224R1FieldElement(a);
    }

    /* renamed from: c */
    public ECFieldElement mo6557c() {
        int[] a = Nat224.m28923a();
        SecP224R1Field.m28599a(this.f32072b, a);
        return new SecP224R1FieldElement(a);
    }

    /* renamed from: b */
    public ECFieldElement mo6555b(ECFieldElement eCFieldElement) {
        int[] a = Nat224.m28923a();
        SecP224R1Field.m28608d(this.f32072b, ((SecP224R1FieldElement) eCFieldElement).f32072b, a);
        return new SecP224R1FieldElement(a);
    }

    /* renamed from: c */
    public ECFieldElement mo6558c(ECFieldElement eCFieldElement) {
        int[] a = Nat224.m28923a();
        SecP224R1Field.m28604b(this.f32072b, ((SecP224R1FieldElement) eCFieldElement).f32072b, a);
        return new SecP224R1FieldElement(a);
    }

    /* renamed from: d */
    public ECFieldElement mo6560d(ECFieldElement eCFieldElement) {
        int[] a = Nat224.m28923a();
        Mod.m28835a(SecP224R1Field.f23141a, ((SecP224R1FieldElement) eCFieldElement).f32072b, a);
        SecP224R1Field.m28604b(a, this.f32072b, a);
        return new SecP224R1FieldElement(a);
    }

    /* renamed from: d */
    public ECFieldElement mo6559d() {
        int[] a = Nat224.m28923a();
        SecP224R1Field.m28603b(this.f32072b, a);
        return new SecP224R1FieldElement(a);
    }

    /* renamed from: e */
    public ECFieldElement mo6561e() {
        int[] a = Nat224.m28923a();
        SecP224R1Field.m28607d(this.f32072b, a);
        return new SecP224R1FieldElement(a);
    }

    /* renamed from: f */
    public ECFieldElement mo6562f() {
        int[] a = Nat224.m28923a();
        Mod.m28835a(SecP224R1Field.f23141a, this.f32072b, a);
        return new SecP224R1FieldElement(a);
    }

    /* renamed from: g */
    public ECFieldElement mo6563g() {
        int[] iArr = this.f32072b;
        if (!Nat224.m28926b(iArr)) {
            if (!Nat224.m28922a(iArr)) {
                int[] a = Nat224.m28923a();
                SecP224R1Field.m28603b(iArr, a);
                int[] a2 = Mod.m28836a(SecP224R1Field.f23141a);
                int[] a3 = Nat224.m28923a();
                ECFieldElement eCFieldElement = null;
                if (!m41454a(iArr)) {
                    return null;
                }
                while (!m41455a(a, a2, a3)) {
                    SecP224R1Field.m28599a(a2, a2);
                }
                SecP224R1Field.m28607d(a3, a2);
                if (Nat224.m28927b(iArr, a2)) {
                    eCFieldElement = new SecP224R1FieldElement(a3);
                }
                return eCFieldElement;
            }
        }
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecP224R1FieldElement)) {
            return null;
        }
        return Nat224.m28927b(this.f32072b, ((SecP224R1FieldElement) obj).f32072b);
    }

    public int hashCode() {
        return f32071a.hashCode() ^ Arrays.m29345a(this.f32072b, 0, 7);
    }

    /* renamed from: a */
    private static boolean m41454a(int[] iArr) {
        int[] a = Nat224.m28923a();
        int[] a2 = Nat224.m28923a();
        Nat224.m28921a(iArr, a);
        for (iArr = null; iArr < 7; iArr++) {
            Nat224.m28921a(a, a2);
            SecP224R1Field.m28598a(a, 1 << iArr, a);
            SecP224R1Field.m28604b(a, a2, a);
        }
        SecP224R1Field.m28598a(a, (int) 95, a);
        return Nat224.m28922a(a);
    }

    /* renamed from: a */
    private static void m41453a(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5, int[] iArr6, int[] iArr7) {
        SecP224R1Field.m28604b(iArr5, iArr3, iArr7);
        SecP224R1Field.m28604b(iArr7, iArr, iArr7);
        SecP224R1Field.m28604b(iArr4, iArr2, iArr6);
        SecP224R1Field.m28600a(iArr6, iArr7, iArr6);
        SecP224R1Field.m28604b(iArr4, iArr3, iArr7);
        Nat224.m28921a(iArr6, iArr4);
        SecP224R1Field.m28604b(iArr5, iArr2, iArr5);
        SecP224R1Field.m28600a(iArr5, iArr7, iArr5);
        SecP224R1Field.m28607d(iArr5, iArr6);
        SecP224R1Field.m28604b(iArr6, iArr, iArr6);
    }

    /* renamed from: a */
    private static void m41452a(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5) {
        Nat224.m28921a(iArr, iArr4);
        int[] a = Nat224.m28923a();
        int[] a2 = Nat224.m28923a();
        for (int i = 0; i < 7; i++) {
            Nat224.m28921a(iArr2, a);
            Nat224.m28921a(iArr3, a2);
            int i2 = 1 << i;
            while (true) {
                i2--;
                if (i2 < 0) {
                    break;
                }
                m41451a(iArr2, iArr3, iArr4, iArr5);
            }
            m41453a(iArr, a, a2, iArr2, iArr3, iArr4, iArr5);
        }
    }

    /* renamed from: a */
    private static void m41451a(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        SecP224R1Field.m28604b(iArr2, iArr, iArr2);
        SecP224R1Field.m28609e(iArr2, iArr2);
        SecP224R1Field.m28607d(iArr, iArr4);
        SecP224R1Field.m28600a(iArr3, iArr4, iArr);
        SecP224R1Field.m28604b(iArr3, iArr4, iArr3);
        SecP224R1Field.m28596a(Nat.m29029c((int) 7, iArr3, 2, 0), iArr3);
    }

    /* renamed from: a */
    private static boolean m41455a(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] a = Nat224.m28923a();
        Nat224.m28921a(iArr2, a);
        iArr2 = Nat224.m28923a();
        iArr2[0] = 1;
        int[] a2 = Nat224.m28923a();
        m41452a(iArr, a, iArr2, a2, iArr3);
        iArr = Nat224.m28923a();
        int[] a3 = Nat224.m28923a();
        for (int i = 1; i < 96; i++) {
            Nat224.m28921a(a, iArr);
            Nat224.m28921a(iArr2, a3);
            m41451a(a, iArr2, a2, iArr3);
            if (Nat224.m28926b(a)) {
                Mod.m28835a(SecP224R1Field.f23141a, a3, iArr3);
                SecP224R1Field.m28604b(iArr3, iArr, iArr3);
                return true;
            }
        }
        return false;
    }
}
