package org.spongycastle.crypto;

public class EphemeralKeyPair {
    /* renamed from: a */
    private AsymmetricCipherKeyPair f22200a;
    /* renamed from: b */
    private KeyEncoder f22201b;

    public EphemeralKeyPair(AsymmetricCipherKeyPair asymmetricCipherKeyPair, KeyEncoder keyEncoder) {
        this.f22200a = asymmetricCipherKeyPair;
        this.f22201b = keyEncoder;
    }

    /* renamed from: a */
    public AsymmetricCipherKeyPair m27321a() {
        return this.f22200a;
    }

    /* renamed from: b */
    public byte[] m27322b() {
        return this.f22201b.mo5852a(this.f22200a.m27281a());
    }
}
