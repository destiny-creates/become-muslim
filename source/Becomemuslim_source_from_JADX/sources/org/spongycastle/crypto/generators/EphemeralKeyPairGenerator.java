package org.spongycastle.crypto.generators;

import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.EphemeralKeyPair;
import org.spongycastle.crypto.KeyEncoder;

public class EphemeralKeyPairGenerator {
    /* renamed from: a */
    private AsymmetricCipherKeyPairGenerator f22373a;
    /* renamed from: b */
    private KeyEncoder f22374b;

    public EphemeralKeyPairGenerator(AsymmetricCipherKeyPairGenerator asymmetricCipherKeyPairGenerator, KeyEncoder keyEncoder) {
        this.f22373a = asymmetricCipherKeyPairGenerator;
        this.f22374b = keyEncoder;
    }

    /* renamed from: a */
    public EphemeralKeyPair m27454a() {
        return new EphemeralKeyPair(this.f22373a.mo5755a(), this.f22374b);
    }
}
