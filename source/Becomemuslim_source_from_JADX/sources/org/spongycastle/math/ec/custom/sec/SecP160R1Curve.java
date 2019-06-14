package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECCurve.AbstractFp;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.encoders.Hex;

public class SecP160R1Curve extends AbstractFp {
    /* renamed from: i */
    public static final BigInteger f32048i = new BigInteger(1, Hex.m29436a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF7FFFFFFF"));
    /* renamed from: j */
    protected SecP160R1Point f32049j;

    /* renamed from: a */
    public boolean mo6544a(int i) {
        return i == 2;
    }

    public SecP160R1Curve() {
        super(f32048i);
        this.f32049j = new SecP160R1Point(this, null, null);
        this.b = mo6541a(new BigInteger(1, Hex.m29436a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF7FFFFFFC")));
        this.c = mo6541a(new BigInteger(1, Hex.m29436a("1C97BEFC54BD7A8B65ACF89F81D4D4ADC565FA45")));
        this.d = new BigInteger(1, Hex.m29436a("0100000000000000000001F4C8F927AED3CA752257"));
        this.e = BigInteger.valueOf(1);
        this.f = 2;
    }

    /* renamed from: c */
    protected ECCurve mo6545c() {
        return new SecP160R1Curve();
    }

    /* renamed from: a */
    public int mo6540a() {
        return f32048i.bitLength();
    }

    /* renamed from: a */
    public ECFieldElement mo6541a(BigInteger bigInteger) {
        return new SecP160R1FieldElement(bigInteger);
    }

    /* renamed from: a */
    protected ECPoint mo6542a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
        return new SecP160R1Point(this, eCFieldElement, eCFieldElement2, z);
    }

    /* renamed from: a */
    protected ECPoint mo6543a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        return new SecP160R1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr, z);
    }

    /* renamed from: e */
    public ECPoint mo6547e() {
        return this.f32049j;
    }
}
