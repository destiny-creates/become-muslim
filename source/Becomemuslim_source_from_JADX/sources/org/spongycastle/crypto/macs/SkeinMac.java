package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.digests.SkeinEngine;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.SkeinParameters;
import org.spongycastle.crypto.params.SkeinParameters.Builder;

public class SkeinMac implements Mac {
    /* renamed from: a */
    private SkeinEngine f26953a;

    public SkeinMac(int i, int i2) {
        this.f26953a = new SkeinEngine(i, i2);
    }

    /* renamed from: a */
    public String mo5762a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Skein-MAC-");
        stringBuilder.append(this.f26953a.m34748b() * 8);
        stringBuilder.append("-");
        stringBuilder.append(this.f26953a.m34742a() * 8);
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public void mo5764a(CipherParameters cipherParameters) {
        SkeinParameters skeinParameters;
        if (cipherParameters instanceof SkeinParameters) {
            skeinParameters = (SkeinParameters) cipherParameters;
        } else if (cipherParameters instanceof KeyParameter) {
            skeinParameters = new Builder().m27503a(((KeyParameter) cipherParameters).m35685a()).m27504a();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid parameter passed to Skein MAC init - ");
            stringBuilder.append(cipherParameters.getClass().getName());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (skeinParameters.m35710b() != null) {
            this.f26953a.m34745a(skeinParameters);
            return;
        }
        throw new IllegalArgumentException("Skein MAC requires a key parameter.");
    }

    /* renamed from: b */
    public int mo5766b() {
        return this.f26953a.m34742a();
    }

    /* renamed from: c */
    public void mo5767c() {
        this.f26953a.m34749c();
    }

    /* renamed from: a */
    public void mo5763a(byte b) {
        this.f26953a.m34744a(b);
    }

    /* renamed from: a */
    public void mo5765a(byte[] bArr, int i, int i2) {
        this.f26953a.m34747a(bArr, i, i2);
    }

    /* renamed from: a */
    public int mo5761a(byte[] bArr, int i) {
        return this.f26953a.m34743a(bArr, i);
    }
}
