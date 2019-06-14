package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.params.KeyParameter;

public class OldHMac implements Mac {
    /* renamed from: a */
    private Digest f26916a;
    /* renamed from: b */
    private int f26917b;
    /* renamed from: c */
    private byte[] f26918c = new byte[64];
    /* renamed from: d */
    private byte[] f26919d = new byte[64];

    public OldHMac(Digest digest) {
        this.f26916a = digest;
        this.f26917b = digest.mo5732b();
    }

    /* renamed from: a */
    public String mo5762a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f26916a.mo5729a());
        stringBuilder.append("/HMAC");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public void mo5764a(CipherParameters cipherParameters) {
        this.f26916a.mo5733c();
        cipherParameters = ((KeyParameter) cipherParameters).m35685a();
        if (cipherParameters.length > 64) {
            this.f26916a.mo5731a(cipherParameters, 0, cipherParameters.length);
            this.f26916a.mo5728a(this.f26918c, 0);
            for (cipherParameters = this.f26917b; cipherParameters < this.f26918c.length; cipherParameters++) {
                this.f26918c[cipherParameters] = (byte) 0;
            }
        } else {
            System.arraycopy(cipherParameters, 0, this.f26918c, 0, cipherParameters.length);
            for (cipherParameters = cipherParameters.length; cipherParameters < this.f26918c.length; cipherParameters++) {
                this.f26918c[cipherParameters] = (byte) 0;
            }
        }
        this.f26919d = new byte[this.f26918c.length];
        System.arraycopy(this.f26918c, 0, this.f26919d, 0, this.f26918c.length);
        for (cipherParameters = null; cipherParameters < this.f26918c.length; cipherParameters++) {
            byte[] bArr = this.f26918c;
            bArr[cipherParameters] = (byte) (bArr[cipherParameters] ^ 54);
        }
        for (cipherParameters = null; cipherParameters < this.f26919d.length; cipherParameters++) {
            bArr = this.f26919d;
            bArr[cipherParameters] = (byte) (bArr[cipherParameters] ^ 92);
        }
        this.f26916a.mo5731a(this.f26918c, 0, this.f26918c.length);
    }

    /* renamed from: b */
    public int mo5766b() {
        return this.f26917b;
    }

    /* renamed from: a */
    public void mo5763a(byte b) {
        this.f26916a.mo5730a(b);
    }

    /* renamed from: a */
    public void mo5765a(byte[] bArr, int i, int i2) {
        this.f26916a.mo5731a(bArr, i, i2);
    }

    /* renamed from: a */
    public int mo5761a(byte[] bArr, int i) {
        byte[] bArr2 = new byte[this.f26917b];
        this.f26916a.mo5728a(bArr2, 0);
        this.f26916a.mo5731a(this.f26919d, 0, this.f26919d.length);
        this.f26916a.mo5731a(bArr2, 0, bArr2.length);
        bArr = this.f26916a.mo5728a(bArr, i);
        mo5767c();
        return bArr;
    }

    /* renamed from: c */
    public void mo5767c() {
        this.f26916a.mo5733c();
        this.f26916a.mo5731a(this.f26918c, 0, this.f26918c.length);
    }
}
