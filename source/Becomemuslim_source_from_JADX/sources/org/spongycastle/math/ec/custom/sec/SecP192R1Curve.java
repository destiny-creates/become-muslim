package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECCurve.AbstractFp;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.encoders.Hex;

public class SecP192R1Curve extends AbstractFp {
    /* renamed from: i */
    public static final BigInteger f32060i = new BigInteger(1, Hex.m29436a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFF"));
    /* renamed from: j */
    protected SecP192R1Point f32061j;

    /* renamed from: a */
    public boolean mo6544a(int i) {
        return i == 2;
    }

    public SecP192R1Curve() {
        super(f32060i);
        this.f32061j = new SecP192R1Point(this, null, null);
        this.b = mo6541a(new BigInteger(1, Hex.m29436a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFC")));
        this.c = mo6541a(new BigInteger(1, Hex.m29436a("64210519E59C80E70FA7E9AB72243049FEB8DEECC146B9B1")));
        this.d = new BigInteger(1, Hex.m29436a("FFFFFFFFFFFFFFFFFFFFFFFF99DEF836146BC9B1B4D22831"));
        this.e = BigInteger.valueOf(1);
        this.f = 2;
    }

    /* renamed from: c */
    protected ECCurve mo6545c() {
        return new SecP192R1Curve();
    }

    /* renamed from: a */
    public int mo6540a() {
        return f32060i.bitLength();
    }

    /* renamed from: a */
    public ECFieldElement mo6541a(BigInteger bigInteger) {
        return new SecP192R1FieldElement(bigInteger);
    }

    /* renamed from: a */
    protected ECPoint mo6542a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
        return new SecP192R1Point(this, eCFieldElement, eCFieldElement2, z);
    }

    /* renamed from: a */
    protected ECPoint mo6543a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        return new SecP192R1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr, z);
    }

    /* renamed from: e */
    public ECPoint mo6547e() {
        return this.f32061j;
    }
}
