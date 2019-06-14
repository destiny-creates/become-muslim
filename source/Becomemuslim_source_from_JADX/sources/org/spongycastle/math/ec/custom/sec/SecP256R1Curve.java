package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECCurve.AbstractFp;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.encoders.Hex;

public class SecP256R1Curve extends AbstractFp {
    /* renamed from: i */
    public static final BigInteger f32077i = new BigInteger(1, Hex.m29436a("FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFF"));
    /* renamed from: j */
    protected SecP256R1Point f32078j;

    /* renamed from: a */
    public boolean mo6544a(int i) {
        return i == 2;
    }

    public SecP256R1Curve() {
        super(f32077i);
        this.f32078j = new SecP256R1Point(this, null, null);
        this.b = mo6541a(new BigInteger(1, Hex.m29436a("FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFC")));
        this.c = mo6541a(new BigInteger(1, Hex.m29436a("5AC635D8AA3A93E7B3EBBD55769886BC651D06B0CC53B0F63BCE3C3E27D2604B")));
        this.d = new BigInteger(1, Hex.m29436a("FFFFFFFF00000000FFFFFFFFFFFFFFFFBCE6FAADA7179E84F3B9CAC2FC632551"));
        this.e = BigInteger.valueOf(1);
        this.f = 2;
    }

    /* renamed from: c */
    protected ECCurve mo6545c() {
        return new SecP256R1Curve();
    }

    /* renamed from: a */
    public int mo6540a() {
        return f32077i.bitLength();
    }

    /* renamed from: a */
    public ECFieldElement mo6541a(BigInteger bigInteger) {
        return new SecP256R1FieldElement(bigInteger);
    }

    /* renamed from: a */
    protected ECPoint mo6542a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
        return new SecP256R1Point(this, eCFieldElement, eCFieldElement2, z);
    }

    /* renamed from: a */
    protected ECPoint mo6543a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        return new SecP256R1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr, z);
    }

    /* renamed from: e */
    public ECPoint mo6547e() {
        return this.f32078j;
    }
}
