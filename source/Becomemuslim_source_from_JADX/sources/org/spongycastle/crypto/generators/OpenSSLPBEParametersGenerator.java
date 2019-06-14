package org.spongycastle.crypto.generators;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.PBEParametersGenerator;
import org.spongycastle.crypto.digests.MD5Digest;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

public class OpenSSLPBEParametersGenerator extends PBEParametersGenerator {
    /* renamed from: d */
    private Digest f26852d = new MD5Digest();

    /* renamed from: a */
    public void m35353a(byte[] bArr, byte[] bArr2) {
        super.m27339a(bArr, bArr2, 1);
    }

    /* renamed from: c */
    private byte[] m35350c(int i) {
        Object obj = new byte[this.f26852d.mo5732b()];
        Object obj2 = new byte[i];
        int i2 = 0;
        while (true) {
            this.f26852d.mo5731a(this.a, 0, this.a.length);
            this.f26852d.mo5731a(this.b, 0, this.b.length);
            this.f26852d.mo5728a(obj, 0);
            int length = i > obj.length ? obj.length : i;
            System.arraycopy(obj, 0, obj2, i2, length);
            i2 += length;
            i -= length;
            if (i == 0) {
                return obj2;
            }
            this.f26852d.mo5733c();
            this.f26852d.mo5731a(obj, 0, obj.length);
        }
    }

    /* renamed from: a */
    public CipherParameters mo5758a(int i) {
        i /= 8;
        return new KeyParameter(m35350c(i), 0, i);
    }

    /* renamed from: a */
    public CipherParameters mo5759a(int i, int i2) {
        i /= 8;
        i2 /= 8;
        byte[] c = m35350c(i + i2);
        return new ParametersWithIV(new KeyParameter(c, 0, i), c, i, i2);
    }

    /* renamed from: b */
    public CipherParameters mo5760b(int i) {
        return mo5758a(i);
    }
}
