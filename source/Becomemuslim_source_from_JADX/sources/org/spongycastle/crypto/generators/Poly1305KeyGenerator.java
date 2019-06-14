package org.spongycastle.crypto.generators;

import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;

public class Poly1305KeyGenerator extends CipherKeyGenerator {
    /* renamed from: a */
    public void mo5756a(KeyGenerationParameters keyGenerationParameters) {
        super.mo5756a(new KeyGenerationParameters(keyGenerationParameters.m27324a(), 256));
    }

    /* renamed from: a */
    public byte[] mo5757a() {
        byte[] a = super.mo5757a();
        m35370a(a);
        return a;
    }

    /* renamed from: a */
    public static void m35370a(byte[] bArr) {
        if (bArr.length == 32) {
            bArr[19] = (byte) (bArr[19] & 15);
            bArr[23] = (byte) (bArr[23] & 15);
            bArr[27] = (byte) (bArr[27] & 15);
            bArr[31] = (byte) (bArr[31] & 15);
            bArr[20] = (byte) (bArr[20] & -4);
            bArr[24] = (byte) (bArr[24] & -4);
            bArr[28] = (byte) (bArr[28] & -4);
            return;
        }
        throw new IllegalArgumentException("Poly1305 key must be 256 bits.");
    }

    /* renamed from: b */
    public static void m35371b(byte[] bArr) {
        if (bArr.length == 32) {
            m35369a(bArr[19], (byte) 15);
            m35369a(bArr[23], (byte) 15);
            m35369a(bArr[27], (byte) 15);
            m35369a(bArr[31], (byte) 15);
            m35369a(bArr[20], (byte) -4);
            m35369a(bArr[24], (byte) -4);
            m35369a(bArr[28], (byte) -4);
            return;
        }
        throw new IllegalArgumentException("Poly1305 key must be 256 bits.");
    }

    /* renamed from: a */
    private static void m35369a(byte b, byte b2) {
        if ((b & (~b2)) != (byte) 0) {
            throw new IllegalArgumentException("Invalid format for r portion of Poly1305 key.");
        }
    }
}
