package org.spongycastle.crypto.macs;

import java.util.Hashtable;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Integers;
import org.spongycastle.util.Memoable;

public class HMac implements Mac {
    /* renamed from: h */
    private static Hashtable f26900h = new Hashtable();
    /* renamed from: a */
    private Digest f26901a;
    /* renamed from: b */
    private int f26902b;
    /* renamed from: c */
    private int f26903c;
    /* renamed from: d */
    private Memoable f26904d;
    /* renamed from: e */
    private Memoable f26905e;
    /* renamed from: f */
    private byte[] f26906f;
    /* renamed from: g */
    private byte[] f26907g;

    static {
        f26900h.put("GOST3411", Integers.m29396a(32));
        f26900h.put("MD2", Integers.m29396a(16));
        f26900h.put("MD4", Integers.m29396a(64));
        f26900h.put("MD5", Integers.m29396a(64));
        f26900h.put("RIPEMD128", Integers.m29396a(64));
        f26900h.put("RIPEMD160", Integers.m29396a(64));
        f26900h.put("SHA-1", Integers.m29396a(64));
        f26900h.put("SHA-224", Integers.m29396a(64));
        f26900h.put("SHA-256", Integers.m29396a(64));
        f26900h.put("SHA-384", Integers.m29396a(128));
        f26900h.put("SHA-512", Integers.m29396a(128));
        f26900h.put("Tiger", Integers.m29396a(64));
        f26900h.put("Whirlpool", Integers.m29396a(64));
    }

    /* renamed from: a */
    private static int m35429a(Digest digest) {
        if (digest instanceof ExtendedDigest) {
            return ((ExtendedDigest) digest).mo6445d();
        }
        Integer num = (Integer) f26900h.get(digest.mo5729a());
        if (num != null) {
            return num.intValue();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unknown digest passed: ");
        stringBuilder.append(digest.mo5729a());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public HMac(Digest digest) {
        this(digest, m35429a(digest));
    }

    private HMac(Digest digest, int i) {
        this.f26901a = digest;
        this.f26902b = digest.mo5732b();
        this.f26903c = i;
        this.f26906f = new byte[this.f26903c];
        this.f26907g = new byte[(this.f26903c + this.f26902b)];
    }

    /* renamed from: a */
    public String mo5762a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f26901a.mo5729a());
        stringBuilder.append("/HMAC");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public void mo5764a(CipherParameters cipherParameters) {
        this.f26901a.mo5733c();
        cipherParameters = ((KeyParameter) cipherParameters).m35685a();
        int length = cipherParameters.length;
        if (length > this.f26903c) {
            this.f26901a.mo5731a(cipherParameters, 0, length);
            this.f26901a.mo5728a(this.f26906f, 0);
            length = this.f26902b;
        } else {
            System.arraycopy(cipherParameters, 0, this.f26906f, 0, length);
        }
        while (length < this.f26906f.length) {
            this.f26906f[length] = null;
            length++;
        }
        System.arraycopy(this.f26906f, 0, this.f26907g, 0, this.f26903c);
        m35430a(this.f26906f, this.f26903c, (byte) 54);
        m35430a(this.f26907g, this.f26903c, (byte) 92);
        if ((this.f26901a instanceof Memoable) != null) {
            this.f26905e = ((Memoable) this.f26901a).mo5735e();
            ((Digest) this.f26905e).mo5731a(this.f26907g, 0, this.f26903c);
        }
        this.f26901a.mo5731a(this.f26906f, 0, this.f26906f.length);
        if ((this.f26901a instanceof Memoable) != null) {
            this.f26904d = ((Memoable) this.f26901a).mo5735e();
        }
    }

    /* renamed from: b */
    public int mo5766b() {
        return this.f26902b;
    }

    /* renamed from: a */
    public void mo5763a(byte b) {
        this.f26901a.mo5730a(b);
    }

    /* renamed from: a */
    public void mo5765a(byte[] bArr, int i, int i2) {
        this.f26901a.mo5731a(bArr, i, i2);
    }

    /* renamed from: a */
    public int mo5761a(byte[] bArr, int i) {
        this.f26901a.mo5728a(this.f26907g, this.f26903c);
        if (this.f26905e != null) {
            ((Memoable) this.f26901a).mo5734a(this.f26905e);
            this.f26901a.mo5731a(this.f26907g, this.f26903c, this.f26901a.mo5732b());
        } else {
            this.f26901a.mo5731a(this.f26907g, 0, this.f26907g.length);
        }
        bArr = this.f26901a.mo5728a(bArr, i);
        for (i = this.f26903c; i < this.f26907g.length; i++) {
            this.f26907g[i] = (byte) 0;
        }
        if (this.f26904d != 0) {
            ((Memoable) this.f26901a).mo5734a(this.f26904d);
        } else {
            this.f26901a.mo5731a(this.f26906f, 0, this.f26906f.length);
        }
        return bArr;
    }

    /* renamed from: c */
    public void mo5767c() {
        this.f26901a.mo5733c();
        this.f26901a.mo5731a(this.f26906f, 0, this.f26906f.length);
    }

    /* renamed from: a */
    private static void m35430a(byte[] bArr, int i, byte b) {
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) (bArr[i2] ^ b);
        }
    }
}
