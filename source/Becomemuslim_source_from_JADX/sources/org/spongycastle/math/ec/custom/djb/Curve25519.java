package org.spongycastle.math.ec.custom.djb;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECCurve.AbstractFp;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.raw.Nat256;
import org.spongycastle.util.encoders.Hex;

public class Curve25519 extends AbstractFp {
    /* renamed from: i */
    public static final BigInteger f32037i = Nat256.m28961c(Curve25519Field.f23121a);
    /* renamed from: j */
    protected Curve25519Point f32038j;

    /* renamed from: a */
    public boolean mo6544a(int i) {
        return i == 4;
    }

    public Curve25519() {
        super(f32037i);
        this.f32038j = new Curve25519Point(this, null, null);
        this.b = mo6541a(new BigInteger(1, Hex.m29436a("2AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA984914A144")));
        this.c = mo6541a(new BigInteger(1, Hex.m29436a("7B425ED097B425ED097B425ED097B425ED097B425ED097B4260B5E9C7710C864")));
        this.d = new BigInteger(1, Hex.m29436a("1000000000000000000000000000000014DEF9DEA2F79CD65812631A5CF5D3ED"));
        this.e = BigInteger.valueOf(8);
        this.f = 4;
    }

    /* renamed from: c */
    protected ECCurve mo6545c() {
        return new Curve25519();
    }

    /* renamed from: a */
    public int mo6540a() {
        return f32037i.bitLength();
    }

    /* renamed from: a */
    public ECFieldElement mo6541a(BigInteger bigInteger) {
        return new Curve25519FieldElement(bigInteger);
    }

    /* renamed from: a */
    protected ECPoint mo6542a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
        return new Curve25519Point(this, eCFieldElement, eCFieldElement2, z);
    }

    /* renamed from: a */
    protected ECPoint mo6543a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        return new Curve25519Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr, z);
    }

    /* renamed from: e */
    public ECPoint mo6547e() {
        return this.f32038j;
    }
}
