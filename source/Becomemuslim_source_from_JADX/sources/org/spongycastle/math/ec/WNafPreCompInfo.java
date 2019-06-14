package org.spongycastle.math.ec;

public class WNafPreCompInfo implements PreCompInfo {
    /* renamed from: a */
    protected ECPoint[] f27642a = null;
    /* renamed from: b */
    protected ECPoint[] f27643b = null;
    /* renamed from: c */
    protected ECPoint f27644c = null;

    /* renamed from: a */
    public ECPoint[] m36308a() {
        return this.f27642a;
    }

    /* renamed from: a */
    public void m36307a(ECPoint[] eCPointArr) {
        this.f27642a = eCPointArr;
    }

    /* renamed from: b */
    public ECPoint[] m36310b() {
        return this.f27643b;
    }

    /* renamed from: b */
    public void m36309b(ECPoint[] eCPointArr) {
        this.f27643b = eCPointArr;
    }

    /* renamed from: c */
    public ECPoint m36311c() {
        return this.f27644c;
    }

    /* renamed from: a */
    public void m36306a(ECPoint eCPoint) {
        this.f27644c = eCPoint;
    }
}
