package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import java.util.Random;
import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECCurve.AbstractF2m;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECMultiplier;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.ec.WTauNafMultiplier;
import org.spongycastle.util.encoders.Hex;

public class SecT163K1Curve extends AbstractF2m {
    /* renamed from: i */
    protected SecT163K1Point f32096i;

    /* renamed from: a */
    public int mo6540a() {
        return 163;
    }

    /* renamed from: a */
    public boolean mo6544a(int i) {
        return i == 6;
    }

    /* renamed from: o */
    public boolean mo6577o() {
        return true;
    }

    public SecT163K1Curve() {
        super(163, 3, 6, 7);
        this.f32096i = new SecT163K1Point(this, null, null);
        this.b = mo6541a(BigInteger.valueOf(1));
        this.c = this.b;
        this.d = new BigInteger(1, Hex.m29436a("04000000000000000000020108A2E0CC0D99F8A5EF"));
        this.e = BigInteger.valueOf(2);
        this.f = 6;
    }

    /* renamed from: c */
    protected ECCurve mo6545c() {
        return new SecT163K1Curve();
    }

    /* renamed from: d */
    protected ECMultiplier mo6546d() {
        return new WTauNafMultiplier();
    }

    /* renamed from: a */
    public ECFieldElement mo6541a(BigInteger bigInteger) {
        return new SecT163FieldElement(bigInteger);
    }

    /* renamed from: a */
    protected ECPoint mo6542a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
        return new SecT163K1Point(this, eCFieldElement, eCFieldElement2, z);
    }

    /* renamed from: a */
    protected ECPoint mo6543a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        return new SecT163K1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr, z);
    }

    /* renamed from: e */
    public ECPoint mo6547e() {
        return this.f32096i;
    }

    /* renamed from: a */
    protected ECPoint mo5903a(int i, BigInteger bigInteger) {
        ECFieldElement a = mo6541a(bigInteger);
        if (a.mo6566j()) {
            i = this.c.mo6563g();
        } else {
            ECFieldElement a2 = m41709a(a.mo6561e().mo6562f().mo6558c(this.c).mo6551a(this.b).mo6551a(a));
            if (a2 != null) {
                if (a2.mo6567k() != (i == 1)) {
                    a2 = a2.mo6557c();
                }
                switch (m28387k()) {
                    case 5:
                    case 6:
                        i = a2.mo6551a(a);
                        break;
                    default:
                        i = a2.mo6558c(a);
                        break;
                }
            }
            i = 0;
        }
        if (i != 0) {
            return mo6542a(a, i, true);
        }
        throw new IllegalArgumentException("Invalid point compression");
    }

    /* renamed from: a */
    private ECFieldElement m41709a(ECFieldElement eCFieldElement) {
        if (eCFieldElement.mo6566j()) {
            return eCFieldElement;
        }
        ECFieldElement eCFieldElement2;
        ECFieldElement a = mo6541a(ECConstants.f23075c);
        Random random = new Random();
        do {
            ECFieldElement a2 = mo6541a(new BigInteger(163, random));
            ECFieldElement eCFieldElement3 = eCFieldElement;
            eCFieldElement2 = a;
            for (int i = 1; i < 163; i++) {
                eCFieldElement3 = eCFieldElement3.mo6561e();
                eCFieldElement2 = eCFieldElement2.mo6561e().mo6551a(eCFieldElement3.mo6558c(a2));
                eCFieldElement3 = eCFieldElement3.mo6551a(eCFieldElement);
            }
            if (!eCFieldElement3.mo6566j()) {
                return null;
            }
        } while (eCFieldElement2.mo6561e().mo6551a(eCFieldElement2).mo6566j());
        return eCFieldElement2;
    }
}
