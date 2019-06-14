package org.spongycastle.crypto.digests;

import com.facebook.imageutils.JfifUtil;
import java.lang.reflect.Array;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.crypto.engines.GOST28147Engine;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithSBox;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Memoable;
import org.spongycastle.util.Pack;

public class GOST3411Digest implements ExtendedDigest, Memoable {
    /* renamed from: s */
    private static final byte[] f31562s = new byte[]{(byte) 0, (byte) -1, (byte) 0, (byte) -1, (byte) 0, (byte) -1, (byte) 0, (byte) -1, (byte) -1, (byte) 0, (byte) -1, (byte) 0, (byte) -1, (byte) 0, (byte) -1, (byte) 0, (byte) 0, (byte) -1, (byte) -1, (byte) 0, (byte) -1, (byte) 0, (byte) 0, (byte) -1, (byte) -1, (byte) 0, (byte) 0, (byte) 0, (byte) -1, (byte) -1, (byte) 0, (byte) -1};
    /* renamed from: a */
    byte[] f31563a;
    /* renamed from: b */
    short[] f31564b;
    /* renamed from: c */
    short[] f31565c;
    /* renamed from: d */
    byte[] f31566d;
    /* renamed from: e */
    byte[] f31567e;
    /* renamed from: f */
    byte[] f31568f;
    /* renamed from: g */
    byte[] f31569g;
    /* renamed from: h */
    private byte[] f31570h;
    /* renamed from: i */
    private byte[] f31571i;
    /* renamed from: j */
    private byte[] f31572j;
    /* renamed from: k */
    private byte[] f31573k;
    /* renamed from: l */
    private byte[][] f31574l;
    /* renamed from: m */
    private byte[] f31575m;
    /* renamed from: n */
    private int f31576n;
    /* renamed from: o */
    private long f31577o;
    /* renamed from: p */
    private BlockCipher f31578p;
    /* renamed from: q */
    private byte[] f31579q;
    /* renamed from: r */
    private byte[] f31580r;

    /* renamed from: a */
    public String mo5729a() {
        return "GOST3411";
    }

    /* renamed from: b */
    public int mo5732b() {
        return 32;
    }

    /* renamed from: d */
    public int mo6445d() {
        return 32;
    }

    public GOST3411Digest() {
        this.f31570h = new byte[32];
        this.f31571i = new byte[32];
        this.f31572j = new byte[32];
        this.f31573k = new byte[32];
        this.f31574l = (byte[][]) Array.newInstance(byte.class, new int[]{4, 32});
        this.f31575m = new byte[32];
        this.f31578p = new GOST28147Engine();
        this.f31580r = new byte[32];
        this.f31563a = new byte[8];
        this.f31564b = new short[16];
        this.f31565c = new short[16];
        this.f31566d = new byte[32];
        this.f31567e = new byte[32];
        this.f31568f = new byte[32];
        this.f31569g = new byte[32];
        this.f31579q = GOST28147Engine.m34944a("D-A");
        this.f31578p.mo5742a(true, new ParametersWithSBox(null, this.f31579q));
        mo5733c();
    }

    public GOST3411Digest(byte[] bArr) {
        this.f31570h = new byte[32];
        this.f31571i = new byte[32];
        this.f31572j = new byte[32];
        this.f31573k = new byte[32];
        this.f31574l = (byte[][]) Array.newInstance(byte.class, new int[]{4, 32});
        this.f31575m = new byte[32];
        this.f31578p = new GOST28147Engine();
        this.f31580r = new byte[32];
        this.f31563a = new byte[8];
        this.f31564b = new short[16];
        this.f31565c = new short[16];
        this.f31566d = new byte[32];
        this.f31567e = new byte[32];
        this.f31568f = new byte[32];
        this.f31569g = new byte[32];
        this.f31579q = Arrays.m29373b(bArr);
        this.f31578p.mo5742a(true, new ParametersWithSBox(null, this.f31579q));
        mo5733c();
    }

    public GOST3411Digest(GOST3411Digest gOST3411Digest) {
        this.f31570h = new byte[32];
        this.f31571i = new byte[32];
        this.f31572j = new byte[32];
        this.f31573k = new byte[32];
        this.f31574l = (byte[][]) Array.newInstance(byte.class, new int[]{4, 32});
        this.f31575m = new byte[32];
        this.f31578p = new GOST28147Engine();
        this.f31580r = new byte[32];
        this.f31563a = new byte[8];
        this.f31564b = new short[16];
        this.f31565c = new short[16];
        this.f31566d = new byte[32];
        this.f31567e = new byte[32];
        this.f31568f = new byte[32];
        this.f31569g = new byte[32];
        mo5734a((Memoable) gOST3411Digest);
    }

    /* renamed from: a */
    public void mo5730a(byte b) {
        byte[] bArr = this.f31575m;
        int i = this.f31576n;
        this.f31576n = i + 1;
        bArr[i] = b;
        if (this.f31576n == this.f31575m.length) {
            m40552d(this.f31575m);
            m40560b(this.f31575m, 0);
            this.f31576n = 0;
        }
        this.f31577o++;
    }

    /* renamed from: a */
    public void mo5731a(byte[] bArr, int i, int i2) {
        while (this.f31576n != 0 && i2 > 0) {
            mo5730a(bArr[i]);
            i++;
            i2--;
        }
        while (i2 > this.f31575m.length) {
            System.arraycopy(bArr, i, this.f31575m, 0, this.f31575m.length);
            m40552d(this.f31575m);
            m40560b(this.f31575m, 0);
            i += this.f31575m.length;
            i2 -= this.f31575m.length;
            this.f31577o += (long) this.f31575m.length;
        }
        while (i2 > 0) {
            mo5730a(bArr[i]);
            i++;
            i2--;
        }
    }

    /* renamed from: a */
    private byte[] m40549a(byte[] bArr) {
        for (int i = 0; i < 8; i++) {
            int i2 = i * 4;
            this.f31580r[i2] = bArr[i];
            this.f31580r[i2 + 1] = bArr[i + 8];
            this.f31580r[i2 + 2] = bArr[i + 16];
            this.f31580r[i2 + 3] = bArr[i + 24];
        }
        return this.f31580r;
    }

    /* renamed from: b */
    private byte[] m40550b(byte[] bArr) {
        for (int i = 0; i < 8; i++) {
            this.f31563a[i] = (byte) (bArr[i] ^ bArr[i + 8]);
        }
        System.arraycopy(bArr, 8, bArr, 0, 24);
        System.arraycopy(this.f31563a, 0, bArr, 24, 8);
        return bArr;
    }

    /* renamed from: a */
    private void m40546a(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, int i2) {
        this.f31578p.mo5742a(1, new KeyParameter(bArr));
        this.f31578p.mo5740a(bArr3, i2, bArr2, i);
    }

    /* renamed from: c */
    private void m40551c(byte[] bArr) {
        m40547a(bArr, this.f31564b);
        this.f31565c[15] = (short) (((((this.f31564b[0] ^ this.f31564b[1]) ^ this.f31564b[2]) ^ this.f31564b[3]) ^ this.f31564b[12]) ^ this.f31564b[15]);
        System.arraycopy(this.f31564b, 1, this.f31565c, 0, 15);
        m40548a(this.f31565c, bArr);
    }

    /* renamed from: b */
    protected void m40560b(byte[] bArr, int i) {
        System.arraycopy(bArr, i, this.f31572j, 0, 32);
        System.arraycopy(this.f31570h, 0, this.f31567e, 0, 32);
        System.arraycopy(this.f31572j, 0, this.f31568f, 0, 32);
        for (bArr = null; bArr < 32; bArr++) {
            this.f31569g[bArr] = (byte) (this.f31567e[bArr] ^ this.f31568f[bArr]);
        }
        m40546a(m40549a(this.f31569g), this.f31566d, 0, this.f31570h, 0);
        for (bArr = 1; bArr < 4; bArr++) {
            i = m40550b(this.f31567e);
            for (int i2 = 0; i2 < 32; i2++) {
                this.f31567e[i2] = (byte) (i[i2] ^ this.f31574l[bArr][i2]);
            }
            this.f31568f = m40550b(m40550b(this.f31568f));
            for (i = 0; i < 32; i++) {
                this.f31569g[i] = (byte) (this.f31567e[i] ^ this.f31568f[i]);
            }
            int i3 = bArr * 8;
            m40546a(m40549a(this.f31569g), this.f31566d, i3, this.f31570h, i3);
        }
        for (bArr = null; bArr < 12; bArr++) {
            m40551c(this.f31566d);
        }
        for (bArr = null; bArr < 32; bArr++) {
            this.f31566d[bArr] = (byte) (this.f31566d[bArr] ^ this.f31572j[bArr]);
        }
        m40551c(this.f31566d);
        for (bArr = null; bArr < 32; bArr++) {
            this.f31566d[bArr] = (byte) (this.f31570h[bArr] ^ this.f31566d[bArr]);
        }
        for (bArr = null; bArr < 61; bArr++) {
            m40551c(this.f31566d);
        }
        System.arraycopy(this.f31566d, 0, this.f31570h, 0, this.f31570h.length);
    }

    /* renamed from: f */
    private void m40553f() {
        Pack.m29409b(this.f31577o * 8, this.f31571i, 0);
        while (this.f31576n != 0) {
            mo5730a((byte) 0);
        }
        m40560b(this.f31571i, 0);
        m40560b(this.f31573k, 0);
    }

    /* renamed from: a */
    public int mo5728a(byte[] bArr, int i) {
        m40553f();
        System.arraycopy(this.f31570h, 0, bArr, i, this.f31570h.length);
        mo5733c();
        return 32;
    }

    /* renamed from: c */
    public void mo5733c() {
        int i;
        this.f31577o = 0;
        this.f31576n = 0;
        for (i = 0; i < this.f31570h.length; i++) {
            this.f31570h[i] = (byte) 0;
        }
        for (i = 0; i < this.f31571i.length; i++) {
            this.f31571i[i] = (byte) 0;
        }
        for (i = 0; i < this.f31572j.length; i++) {
            this.f31572j[i] = (byte) 0;
        }
        for (i = 0; i < this.f31574l[1].length; i++) {
            this.f31574l[1][i] = (byte) 0;
        }
        for (i = 0; i < this.f31574l[3].length; i++) {
            this.f31574l[3][i] = (byte) 0;
        }
        for (i = 0; i < this.f31573k.length; i++) {
            this.f31573k[i] = (byte) 0;
        }
        for (i = 0; i < this.f31575m.length; i++) {
            this.f31575m[i] = (byte) 0;
        }
        System.arraycopy(f31562s, 0, this.f31574l[2], 0, f31562s.length);
    }

    /* renamed from: d */
    private void m40552d(byte[] bArr) {
        int i = 0;
        for (int i2 = 0; i2 != this.f31573k.length; i2++) {
            int i3 = ((this.f31573k[i2] & JfifUtil.MARKER_FIRST_BYTE) + (bArr[i2] & JfifUtil.MARKER_FIRST_BYTE)) + i;
            this.f31573k[i2] = (byte) i3;
            i = i3 >>> 8;
        }
    }

    /* renamed from: a */
    private void m40547a(byte[] bArr, short[] sArr) {
        for (int i = 0; i < bArr.length / 2; i++) {
            int i2 = i * 2;
            sArr[i] = (short) ((bArr[i2] & JfifUtil.MARKER_FIRST_BYTE) | ((bArr[i2 + 1] << 8) & 65280));
        }
    }

    /* renamed from: a */
    private void m40548a(short[] sArr, byte[] bArr) {
        for (int i = 0; i < bArr.length / 2; i++) {
            int i2 = i * 2;
            bArr[i2 + 1] = (byte) (sArr[i] >> 8);
            bArr[i2] = (byte) sArr[i];
        }
    }

    /* renamed from: e */
    public Memoable mo5735e() {
        return new GOST3411Digest(this);
    }

    /* renamed from: a */
    public void mo5734a(Memoable memoable) {
        GOST3411Digest gOST3411Digest = (GOST3411Digest) memoable;
        this.f31579q = gOST3411Digest.f31579q;
        this.f31578p.mo5742a(true, new ParametersWithSBox(null, this.f31579q));
        mo5733c();
        System.arraycopy(gOST3411Digest.f31570h, 0, this.f31570h, 0, gOST3411Digest.f31570h.length);
        System.arraycopy(gOST3411Digest.f31571i, 0, this.f31571i, 0, gOST3411Digest.f31571i.length);
        System.arraycopy(gOST3411Digest.f31572j, 0, this.f31572j, 0, gOST3411Digest.f31572j.length);
        System.arraycopy(gOST3411Digest.f31573k, 0, this.f31573k, 0, gOST3411Digest.f31573k.length);
        System.arraycopy(gOST3411Digest.f31574l[1], 0, this.f31574l[1], 0, gOST3411Digest.f31574l[1].length);
        System.arraycopy(gOST3411Digest.f31574l[2], 0, this.f31574l[2], 0, gOST3411Digest.f31574l[2].length);
        System.arraycopy(gOST3411Digest.f31574l[3], 0, this.f31574l[3], 0, gOST3411Digest.f31574l[3].length);
        System.arraycopy(gOST3411Digest.f31575m, 0, this.f31575m, 0, gOST3411Digest.f31575m.length);
        this.f31576n = gOST3411Digest.f31576n;
        this.f31577o = gOST3411Digest.f31577o;
    }
}
