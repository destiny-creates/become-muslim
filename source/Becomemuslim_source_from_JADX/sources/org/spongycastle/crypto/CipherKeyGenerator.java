package org.spongycastle.crypto;

import java.security.SecureRandom;

public class CipherKeyGenerator {
    /* renamed from: a */
    protected SecureRandom f22197a;
    /* renamed from: b */
    protected int f22198b;

    /* renamed from: a */
    public void mo5756a(KeyGenerationParameters keyGenerationParameters) {
        this.f22197a = keyGenerationParameters.m27324a();
        this.f22198b = (keyGenerationParameters.m27325b() + 7) / 8;
    }

    /* renamed from: a */
    public byte[] mo5757a() {
        byte[] bArr = new byte[this.f22198b];
        this.f22197a.nextBytes(bArr);
        return bArr;
    }
}
