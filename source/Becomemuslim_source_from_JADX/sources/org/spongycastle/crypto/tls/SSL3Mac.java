package org.spongycastle.crypto.tls;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Arrays;

public class SSL3Mac implements Mac {
    /* renamed from: a */
    static final byte[] f27309a = m35882a((byte) 54, 48);
    /* renamed from: b */
    static final byte[] f27310b = m35882a((byte) 92, 48);
    /* renamed from: c */
    private Digest f27311c;
    /* renamed from: d */
    private int f27312d;
    /* renamed from: e */
    private byte[] f27313e;

    public SSL3Mac(Digest digest) {
        this.f27311c = digest;
        if (digest.mo5732b() == 20) {
            this.f27312d = 40;
        } else {
            this.f27312d = 48;
        }
    }

    /* renamed from: a */
    public String mo5762a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f27311c.mo5729a());
        stringBuilder.append("/SSL3MAC");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public void mo5764a(CipherParameters cipherParameters) {
        this.f27313e = Arrays.m29373b(((KeyParameter) cipherParameters).m35685a());
        mo5767c();
    }

    /* renamed from: b */
    public int mo5766b() {
        return this.f27311c.mo5732b();
    }

    /* renamed from: a */
    public void mo5763a(byte b) {
        this.f27311c.mo5730a(b);
    }

    /* renamed from: a */
    public void mo5765a(byte[] bArr, int i, int i2) {
        this.f27311c.mo5731a(bArr, i, i2);
    }

    /* renamed from: a */
    public int mo5761a(byte[] bArr, int i) {
        byte[] bArr2 = new byte[this.f27311c.mo5732b()];
        this.f27311c.mo5728a(bArr2, 0);
        this.f27311c.mo5731a(this.f27313e, 0, this.f27313e.length);
        this.f27311c.mo5731a(f27310b, 0, this.f27312d);
        this.f27311c.mo5731a(bArr2, 0, bArr2.length);
        bArr = this.f27311c.mo5728a(bArr, i);
        mo5767c();
        return bArr;
    }

    /* renamed from: c */
    public void mo5767c() {
        this.f27311c.mo5733c();
        this.f27311c.mo5731a(this.f27313e, 0, this.f27313e.length);
        this.f27311c.mo5731a(f27309a, 0, this.f27312d);
    }

    /* renamed from: a */
    private static byte[] m35882a(byte b, int i) {
        byte[] bArr = new byte[i];
        Arrays.m29351a(bArr, b);
        return bArr;
    }
}
