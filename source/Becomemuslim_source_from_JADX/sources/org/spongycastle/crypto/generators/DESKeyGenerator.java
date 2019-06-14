package org.spongycastle.crypto.generators;

import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.DESParameters;

public class DESKeyGenerator extends CipherKeyGenerator {
    /* renamed from: a */
    public void mo5756a(KeyGenerationParameters keyGenerationParameters) {
        super.mo5756a(keyGenerationParameters);
        if (this.b != null) {
            if (this.b != 7) {
                if (this.b != 8) {
                    throw new IllegalArgumentException("DES key must be 64 bits long.");
                }
                return;
            }
        }
        this.b = 8;
    }

    /* renamed from: a */
    public byte[] mo5757a() {
        byte[] bArr = new byte[8];
        do {
            this.a.nextBytes(bArr);
            DESParameters.m40788a(bArr);
        } while (DESParameters.m40789a(bArr, 0));
        return bArr;
    }
}
