package org.spongycastle.crypto.params;

import org.spongycastle.crypto.CipherParameters;

public class TweakableBlockCipherParameters implements CipherParameters {
    /* renamed from: a */
    private final byte[] f27148a;
    /* renamed from: b */
    private final KeyParameter f27149b;

    /* renamed from: a */
    public KeyParameter m35711a() {
        return this.f27149b;
    }

    /* renamed from: b */
    public byte[] m35712b() {
        return this.f27148a;
    }
}
