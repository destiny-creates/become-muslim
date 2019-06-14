package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECCurve.AbstractFp;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.encoders.Hex;

public class SecP384R1Curve extends AbstractFp {
    /* renamed from: i */
    public static final BigInteger f32081i = new BigInteger(1, Hex.m29436a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFF0000000000000000FFFFFFFF"));
    /* renamed from: j */
    protected SecP384R1Point f32082j;

    /* renamed from: a */
    public boolean mo6544a(int i) {
        return i == 2;
    }

    public SecP384R1Curve() {
        super(f32081i);
        this.f32082j = new SecP384R1Point(this, null, null);
        this.b = mo6541a(new BigInteger(1, Hex.m29436a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFF0000000000000000FFFFFFFC")));
        this.c = mo6541a(new BigInteger(1, Hex.m29436a("B3312FA7E23EE7E4988E056BE3F82D19181D9C6EFE8141120314088F5013875AC656398D8A2ED19D2A85C8EDD3EC2AEF")));
        this.d = new BigInteger(1, Hex.m29436a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFC7634D81F4372DDF581A0DB248B0A77AECEC196ACCC52973"));
        this.e = BigInteger.valueOf(1);
        this.f = 2;
    }

    /* renamed from: c */
    protected ECCurve mo6545c() {
        return new SecP384R1Curve();
    }

    /* renamed from: a */
    public int mo6540a() {
        return f32081i.bitLength();
    }

    /* renamed from: a */
    public ECFieldElement mo6541a(BigInteger bigInteger) {
        return new SecP384R1FieldElement(bigInteger);
    }

    /* renamed from: a */
    protected ECPoint mo6542a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
        return new SecP384R1Point(this, eCFieldElement, eCFieldElement2, z);
    }

    /* renamed from: a */
    protected ECPoint mo6543a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        return new SecP384R1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr, z);
    }

    /* renamed from: e */
    public ECPoint mo6547e() {
        return this.f32082j;
    }
}
