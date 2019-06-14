package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import java.util.Random;
import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECCurve.AbstractF2m;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.encoders.Hex;

public class SecT193R2Curve extends AbstractF2m {
    /* renamed from: i */
    protected SecT193R2Point f32101i;

    /* renamed from: a */
    public int mo6540a() {
        return 193;
    }

    /* renamed from: a */
    public boolean mo6544a(int i) {
        return i == 6;
    }

    /* renamed from: o */
    public boolean mo6577o() {
        return false;
    }

    public SecT193R2Curve() {
        super(193, 15, 0, 0);
        this.f32101i = new SecT193R2Point(this, null, null);
        this.b = mo6541a(new BigInteger(1, Hex.m29436a("0163F35A5137C2CE3EA6ED8667190B0BC43ECD69977702709B")));
        this.c = mo6541a(new BigInteger(1, Hex.m29436a("00C9BB9E8927D4D64C377E2AB2856A5B16E3EFB7F61D4316AE")));
        this.d = new BigInteger(1, Hex.m29436a("010000000000000000000000015AAB561B005413CCD4EE99D5"));
        this.e = BigInteger.valueOf(2);
        this.f = 6;
    }

    /* renamed from: c */
    protected ECCurve mo6545c() {
        return new SecT193R2Curve();
    }

    /* renamed from: a */
    public ECFieldElement mo6541a(BigInteger bigInteger) {
        return new SecT193FieldElement(bigInteger);
    }

    /* renamed from: a */
    protected ECPoint mo6542a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
        return new SecT193R2Point(this, eCFieldElement, eCFieldElement2, z);
    }

    /* renamed from: a */
    protected ECPoint mo6543a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        return new SecT193R2Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr, z);
    }

    /* renamed from: e */
    public ECPoint mo6547e() {
        return this.f32101i;
    }

    /* renamed from: a */
    protected ECPoint mo5903a(int i, BigInteger bigInteger) {
        ECFieldElement a = mo6541a(bigInteger);
        if (a.mo6566j()) {
            i = this.c.mo6563g();
        } else {
            ECFieldElement a2 = m41797a(a.mo6561e().mo6562f().mo6558c(this.c).mo6551a(this.b).mo6551a(a));
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
    private ECFieldElement m41797a(ECFieldElement eCFieldElement) {
        if (eCFieldElement.mo6566j()) {
            return eCFieldElement;
        }
        ECFieldElement eCFieldElement2;
        ECFieldElement a = mo6541a(ECConstants.f23075c);
        Random random = new Random();
        do {
            ECFieldElement a2 = mo6541a(new BigInteger(193, random));
            ECFieldElement eCFieldElement3 = eCFieldElement;
            eCFieldElement2 = a;
            for (int i = 1; i < 193; i++) {
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
