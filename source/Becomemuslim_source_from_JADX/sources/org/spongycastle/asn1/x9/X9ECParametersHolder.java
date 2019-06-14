package org.spongycastle.asn1.x9;

public abstract class X9ECParametersHolder {
    /* renamed from: a */
    private X9ECParameters f22133a;

    /* renamed from: a */
    protected abstract X9ECParameters mo5716a();

    /* renamed from: b */
    public synchronized X9ECParameters m27273b() {
        if (this.f22133a == null) {
            this.f22133a = mo5716a();
        }
        return this.f22133a;
    }
}
