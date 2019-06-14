package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.modes.GCMBlockCipher;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

public class GMac implements Mac {
    /* renamed from: a */
    private final GCMBlockCipher f26890a;
    /* renamed from: b */
    private final int f26891b = 128;

    public GMac(GCMBlockCipher gCMBlockCipher) {
        this.f26890a = gCMBlockCipher;
    }

    /* renamed from: a */
    public void mo5764a(CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] a = parametersWithIV.m35695a();
            this.f26890a.mo5772a(true, new AEADParameters((KeyParameter) parametersWithIV.m35696b(), this.f26891b, a));
            return;
        }
        throw new IllegalArgumentException("GMAC requires ParametersWithIV");
    }

    /* renamed from: a */
    public String mo5762a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f26890a.mo5771a().mo5741a());
        stringBuilder.append("-GMAC");
        return stringBuilder.toString();
    }

    /* renamed from: b */
    public int mo5766b() {
        return this.f26891b / 8;
    }

    /* renamed from: a */
    public void mo5763a(byte b) {
        this.f26890a.m35538a(b);
    }

    /* renamed from: a */
    public void mo5765a(byte[] bArr, int i, int i2) {
        this.f26890a.mo5773a(bArr, i, i2);
    }

    /* renamed from: a */
    public int mo5761a(byte[] bArr, int i) {
        try {
            return this.f26890a.mo5769a(bArr, i);
        } catch (byte[] bArr2) {
            throw new IllegalStateException(bArr2.toString());
        }
    }

    /* renamed from: c */
    public void mo5767c() {
        this.f26890a.m35542b();
    }
}
