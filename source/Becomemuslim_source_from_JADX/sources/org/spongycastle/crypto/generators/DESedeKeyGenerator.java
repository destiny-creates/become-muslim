package org.spongycastle.crypto.generators;

import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.DESParameters;
import org.spongycastle.crypto.params.DESedeParameters;

public class DESedeKeyGenerator extends DESKeyGenerator {
    /* renamed from: a */
    public void mo5756a(KeyGenerationParameters keyGenerationParameters) {
        this.a = keyGenerationParameters.m27324a();
        this.b = (keyGenerationParameters.m27325b() + 7) / 8;
        if (this.b != null) {
            if (this.b != 21) {
                if (this.b == 14) {
                    this.b = 16;
                    return;
                } else if (this.b == 24) {
                    return;
                } else {
                    if (this.b != 16) {
                        throw new IllegalArgumentException("DESede key must be 192 or 128 bits long.");
                    }
                    return;
                }
            }
        }
        this.b = 24;
    }

    /* renamed from: a */
    public byte[] mo5757a() {
        byte[] bArr = new byte[this.b];
        int i = 0;
        while (true) {
            this.a.nextBytes(bArr);
            DESParameters.m40788a(bArr);
            i++;
            if (i >= 20 || (!DESedeParameters.m43361a(bArr, 0, bArr.length) && DESedeParameters.m43362b(bArr, 0))) {
            }
        }
        if (!DESedeParameters.m43361a(bArr, 0, bArr.length) && DESedeParameters.m43362b(bArr, 0)) {
            return bArr;
        }
        throw new IllegalStateException("Unable to generate DES-EDE key");
    }
}
