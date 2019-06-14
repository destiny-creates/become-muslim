package org.spongycastle.crypto.prng.drbg;

import org.spongycastle.math.ec.ECPoint;

public class DualECPoints {
    /* renamed from: a */
    private final ECPoint f22455a;
    /* renamed from: b */
    private final ECPoint f22456b;
    /* renamed from: c */
    private final int f22457c;
    /* renamed from: d */
    private final int f22458d;

    /* renamed from: a */
    private static int m27516a(int i) {
        int i2 = 0;
        while (true) {
            i >>= 1;
            if (i == 0) {
                return i2;
            }
            i2++;
        }
    }

    public DualECPoints(int i, ECPoint eCPoint, ECPoint eCPoint2, int i2) {
        if (eCPoint.m28406d().m28374a(eCPoint2.m28406d())) {
            this.f22457c = i;
            this.f22455a = eCPoint;
            this.f22456b = eCPoint2;
            this.f22458d = i2;
            return;
        }
        throw new IllegalArgumentException("points need to be on the same curve");
    }

    /* renamed from: a */
    public int m27517a() {
        return this.f22455a.m28406d().mo6540a();
    }

    /* renamed from: b */
    public int m27518b() {
        return ((this.f22455a.m28406d().mo6540a() - (m27516a(this.f22458d) + 13)) / 8) * 8;
    }

    /* renamed from: c */
    public ECPoint m27519c() {
        return this.f22455a;
    }

    /* renamed from: d */
    public ECPoint m27520d() {
        return this.f22456b;
    }

    /* renamed from: e */
    public int m27521e() {
        return this.f22457c;
    }
}
