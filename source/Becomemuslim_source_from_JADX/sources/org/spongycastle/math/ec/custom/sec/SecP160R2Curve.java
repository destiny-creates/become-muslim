package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECCurve.AbstractFp;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.encoders.Hex;

public class SecP160R2Curve extends AbstractFp {
    /* renamed from: i */
    public static final BigInteger f32052i = new BigInteger(1, Hex.m29436a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFAC73"));
    /* renamed from: j */
    protected SecP160R2Point f32053j;

    /* renamed from: a */
    public boolean mo6544a(int i) {
        return i == 2;
    }

    public SecP160R2Curve() {
        super(f32052i);
        this.f32053j = new SecP160R2Point(this, null, null);
        this.b = mo6541a(new BigInteger(1, Hex.m29436a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFAC70")));
        this.c = mo6541a(new BigInteger(1, Hex.m29436a("B4E134D3FB59EB8BAB57274904664D5AF50388BA")));
        this.d = new BigInteger(1, Hex.m29436a("0100000000000000000000351EE786A818F3A1A16B"));
        this.e = BigInteger.valueOf(1);
        this.f = 2;
    }

    /* renamed from: c */
    protected ECCurve mo6545c() {
        return new SecP160R2Curve();
    }

    /* renamed from: a */
    public int mo6540a() {
        return f32052i.bitLength();
    }

    /* renamed from: a */
    public ECFieldElement mo6541a(BigInteger bigInteger) {
        return new SecP160R2FieldElement(bigInteger);
    }

    /* renamed from: a */
    protected ECPoint mo6542a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
        return new SecP160R2Point(this, eCFieldElement, eCFieldElement2, z);
    }

    /* renamed from: a */
    protected ECPoint mo6543a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        return new SecP160R2Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr, z);
    }

    /* renamed from: e */
    public ECPoint mo6547e() {
        return this.f32053j;
    }
}
