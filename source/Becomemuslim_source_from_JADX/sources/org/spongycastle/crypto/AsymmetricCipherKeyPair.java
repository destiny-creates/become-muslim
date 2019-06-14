package org.spongycastle.crypto;

import org.spongycastle.crypto.params.AsymmetricKeyParameter;

public class AsymmetricCipherKeyPair {
    /* renamed from: a */
    private AsymmetricKeyParameter f22186a;
    /* renamed from: b */
    private AsymmetricKeyParameter f22187b;

    public AsymmetricCipherKeyPair(AsymmetricKeyParameter asymmetricKeyParameter, AsymmetricKeyParameter asymmetricKeyParameter2) {
        this.f22186a = asymmetricKeyParameter;
        this.f22187b = asymmetricKeyParameter2;
    }

    /* renamed from: a */
    public AsymmetricKeyParameter m27281a() {
        return this.f22186a;
    }

    /* renamed from: b */
    public AsymmetricKeyParameter m27282b() {
        return this.f22187b;
    }
}
