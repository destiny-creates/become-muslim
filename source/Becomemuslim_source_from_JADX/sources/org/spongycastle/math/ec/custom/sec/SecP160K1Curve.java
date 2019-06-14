package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECCurve.AbstractFp;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.encoders.Hex;

public class SecP160K1Curve extends AbstractFp {
    /* renamed from: i */
    public static final BigInteger f32046i = SecP160R2Curve.f32052i;
    /* renamed from: j */
    protected SecP160K1Point f32047j;

    /* renamed from: a */
    public boolean mo6544a(int i) {
        return i == 2;
    }

    public SecP160K1Curve() {
        super(f32046i);
        this.f32047j = new SecP160K1Point(this, null, null);
        this.b = mo6541a(ECConstants.f23075c);
        this.c = mo6541a(BigInteger.valueOf(7));
        this.d = new BigInteger(1, Hex.m29436a("0100000000000000000001B8FA16DFAB9ACA16B6B3"));
        this.e = BigInteger.valueOf(1);
        this.f = 2;
    }

    /* renamed from: c */
    protected ECCurve mo6545c() {
        return new SecP160K1Curve();
    }

    /* renamed from: a */
    public int mo6540a() {
        return f32046i.bitLength();
    }

    /* renamed from: a */
    public ECFieldElement mo6541a(BigInteger bigInteger) {
        return new SecP160R2FieldElement(bigInteger);
    }

    /* renamed from: a */
    protected ECPoint mo6542a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
        return new SecP160K1Point(this, eCFieldElement, eCFieldElement2, z);
    }

    /* renamed from: a */
    protected ECPoint mo6543a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        return new SecP160K1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr, z);
    }

    /* renamed from: e */
    public ECPoint mo6547e() {
        return this.f32047j;
    }
}
