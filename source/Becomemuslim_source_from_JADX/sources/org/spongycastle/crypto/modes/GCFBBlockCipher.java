package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.StreamBlockCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.params.ParametersWithSBox;

public class GCFBBlockCipher extends StreamBlockCipher {
    /* renamed from: a */
    private static final byte[] f31719a = new byte[]{(byte) 105, (byte) 0, (byte) 114, (byte) 34, (byte) 100, (byte) -55, (byte) 4, (byte) 35, (byte) -115, (byte) 58, (byte) -37, (byte) -106, (byte) 70, (byte) -23, (byte) 42, (byte) -60, (byte) 24, (byte) -2, (byte) -84, (byte) -108, (byte) 0, (byte) -19, (byte) 7, (byte) 18, (byte) -64, (byte) -122, (byte) -36, (byte) -62, (byte) -17, (byte) 76, (byte) -87, (byte) 43};
    /* renamed from: b */
    private final CFBBlockCipher f31720b;
    /* renamed from: c */
    private KeyParameter f31721c;
    /* renamed from: d */
    private long f31722d = 0;
    /* renamed from: e */
    private boolean f31723e;

    public GCFBBlockCipher(BlockCipher blockCipher) {
        super(blockCipher);
        this.f31720b = new CFBBlockCipher(blockCipher, blockCipher.mo5743b() * 8);
    }

    /* renamed from: a */
    public void mo5742a(boolean z, CipherParameters cipherParameters) {
        this.f31722d = 0;
        this.f31720b.mo5742a(z, cipherParameters);
        this.f31723e = z;
        if (cipherParameters instanceof ParametersWithIV) {
            cipherParameters = ((ParametersWithIV) cipherParameters).m35696b();
        }
        if (cipherParameters instanceof ParametersWithRandom) {
            cipherParameters = ((ParametersWithRandom) cipherParameters).m35698b();
        }
        if (cipherParameters instanceof ParametersWithSBox) {
            cipherParameters = ((ParametersWithSBox) cipherParameters).m35700b();
        }
        this.f31721c = (KeyParameter) cipherParameters;
    }

    /* renamed from: a */
    public String mo5749a() {
        String a = this.f31720b.mo5749a();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a.substring(0, a.indexOf(47)));
        stringBuilder.append("/G");
        stringBuilder.append(a.substring(a.indexOf(47) + 1));
        return stringBuilder.toString();
    }

    /* renamed from: b */
    public int mo5743b() {
        return this.f31720b.mo5743b();
    }

    /* renamed from: a */
    public int mo5740a(byte[] bArr, int i, byte[] bArr2, int i2) {
        mo5722a(bArr, i, this.f31720b.mo5743b(), bArr2, i2);
        return this.f31720b.mo5743b();
    }

    /* renamed from: b */
    protected byte mo6454b(byte b) {
        if (this.f31722d > 0 && this.f31722d % 1024 == 0) {
            BlockCipher e = this.f31720b.m34701e();
            e.mo5742a(false, this.f31721c);
            byte[] bArr = new byte[32];
            e.mo5740a(f31719a, 0, bArr, 0);
            e.mo5740a(f31719a, 8, bArr, 8);
            e.mo5740a(f31719a, 16, bArr, 16);
            e.mo5740a(f31719a, 24, bArr, 24);
            this.f31721c = new KeyParameter(bArr);
            e.mo5742a(true, this.f31721c);
            bArr = this.f31720b.m40751d();
            e.mo5740a(bArr, 0, bArr, 0);
            this.f31720b.mo5742a(this.f31723e, new ParametersWithIV(this.f31721c, bArr));
        }
        this.f31722d++;
        return this.f31720b.mo6454b(b);
    }

    /* renamed from: c */
    public void mo5744c() {
        this.f31722d = 0;
        this.f31720b.mo5744c();
    }
}
