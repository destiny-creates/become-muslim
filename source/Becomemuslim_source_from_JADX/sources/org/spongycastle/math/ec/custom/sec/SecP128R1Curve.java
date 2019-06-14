package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECCurve.AbstractFp;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.encoders.Hex;

public class SecP128R1Curve extends AbstractFp {
    /* renamed from: i */
    public static final BigInteger f32042i = new BigInteger(1, Hex.m29436a("FFFFFFFDFFFFFFFFFFFFFFFFFFFFFFFF"));
    /* renamed from: j */
    protected SecP128R1Point f32043j;

    /* renamed from: a */
    public boolean mo6544a(int i) {
        return i == 2;
    }

    public SecP128R1Curve() {
        super(f32042i);
        this.f32043j = new SecP128R1Point(this, null, null);
        this.b = mo6541a(new BigInteger(1, Hex.m29436a("FFFFFFFDFFFFFFFFFFFFFFFFFFFFFFFC")));
        this.c = mo6541a(new BigInteger(1, Hex.m29436a("E87579C11079F43DD824993C2CEE5ED3")));
        this.d = new BigInteger(1, Hex.m29436a("FFFFFFFE0000000075A30D1B9038A115"));
        this.e = BigInteger.valueOf(1);
        this.f = 2;
    }

    /* renamed from: c */
    protected ECCurve mo6545c() {
        return new SecP128R1Curve();
    }

    /* renamed from: a */
    public int mo6540a() {
        return f32042i.bitLength();
    }

    /* renamed from: a */
    public ECFieldElement mo6541a(BigInteger bigInteger) {
        return new SecP128R1FieldElement(bigInteger);
    }

    /* renamed from: a */
    protected ECPoint mo6542a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
        return new SecP128R1Point(this, eCFieldElement, eCFieldElement2, z);
    }

    /* renamed from: a */
    protected ECPoint mo6543a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        return new SecP128R1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr, z);
    }

    /* renamed from: e */
    public ECPoint mo6547e() {
        return this.f32043j;
    }
}
