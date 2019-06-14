package org.spongycastle.crypto.modes;

import com.facebook.imageutils.JfifUtil;
import java.util.Vector;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;

public class OCBBlockCipher implements AEADBlockCipher {
    /* renamed from: a */
    private BlockCipher f27016a;
    /* renamed from: b */
    private BlockCipher f27017b;
    /* renamed from: c */
    private boolean f27018c;
    /* renamed from: d */
    private int f27019d;
    /* renamed from: e */
    private byte[] f27020e;
    /* renamed from: f */
    private Vector f27021f;
    /* renamed from: g */
    private byte[] f27022g;
    /* renamed from: h */
    private byte[] f27023h;
    /* renamed from: i */
    private byte[] f27024i = null;
    /* renamed from: j */
    private byte[] f27025j = new byte[24];
    /* renamed from: k */
    private byte[] f27026k = new byte[16];
    /* renamed from: l */
    private byte[] f27027l;
    /* renamed from: m */
    private byte[] f27028m;
    /* renamed from: n */
    private int f27029n;
    /* renamed from: o */
    private int f27030o;
    /* renamed from: p */
    private long f27031p;
    /* renamed from: q */
    private long f27032q;
    /* renamed from: r */
    private byte[] f27033r;
    /* renamed from: s */
    private byte[] f27034s;
    /* renamed from: t */
    private byte[] f27035t = new byte[16];
    /* renamed from: u */
    private byte[] f27036u;
    /* renamed from: v */
    private byte[] f27037v;

    /* renamed from: a */
    protected static int m35547a(long j) {
        if (j == 0) {
            return 64;
        }
        int i = 0;
        while ((1 & j) == 0) {
            i++;
            j >>>= 1;
        }
        return i;
    }

    public OCBBlockCipher(BlockCipher blockCipher, BlockCipher blockCipher2) {
        if (blockCipher == null) {
            throw new IllegalArgumentException("'hashCipher' cannot be null");
        } else if (blockCipher.mo5743b() != 16) {
            throw new IllegalArgumentException("'hashCipher' must have a block size of 16");
        } else if (blockCipher2 == null) {
            throw new IllegalArgumentException("'mainCipher' cannot be null");
        } else if (blockCipher2.mo5743b() != 16) {
            throw new IllegalArgumentException("'mainCipher' must have a block size of 16");
        } else if (blockCipher.mo5741a().equals(blockCipher2.mo5741a())) {
            this.f27016a = blockCipher;
            this.f27017b = blockCipher2;
        } else {
            throw new IllegalArgumentException("'hashCipher' and 'mainCipher' must be the same algorithm");
        }
    }

    /* renamed from: a */
    public BlockCipher mo5771a() {
        return this.f27017b;
    }

    /* renamed from: a */
    public void mo5772a(boolean z, CipherParameters cipherParameters) {
        byte[] d;
        int b;
        boolean z2 = this.f27018c;
        this.f27018c = z;
        this.f27037v = null;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            d = aEADParameters.m35629d();
            this.f27020e = aEADParameters.m35628c();
            b = aEADParameters.m35627b();
            if (b < 64 || b > 128 || b % 8 != 0) {
                cipherParameters = new StringBuilder();
                cipherParameters.append("Invalid value for MAC size: ");
                cipherParameters.append(b);
                throw new IllegalArgumentException(cipherParameters.toString());
            }
            this.f27019d = b / 8;
            cipherParameters = aEADParameters.m35626a();
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            d = parametersWithIV.m35695a();
            this.f27020e = null;
            this.f27019d = 16;
            cipherParameters = (KeyParameter) parametersWithIV.m35696b();
        } else {
            throw new IllegalArgumentException("invalid parameters passed to OCB");
        }
        this.f27027l = new byte[16];
        if (z) {
            b = 16;
        } else {
            b = this.f27019d + 16;
        }
        this.f27028m = new byte[b];
        if (d == null) {
            d = new byte[0];
        }
        if (d.length <= 15) {
            if (cipherParameters != null) {
                this.f27016a.mo5742a(true, cipherParameters);
                this.f27017b.mo5742a(z, cipherParameters);
                this.f27024i = null;
            } else if (z2 != z) {
                throw new IllegalArgumentException("cannot change encrypting state without providing key.");
            }
            this.f27022g = new byte[16];
            this.f27016a.mo5740a(this.f27022g, 0, this.f27022g, 0);
            this.f27023h = m35551d(this.f27022g);
            this.f27021f = new Vector();
            this.f27021f.addElement(m35551d(this.f27023h));
            z = m35553a(d);
            cipherParameters = z % 8;
            z /= 8;
            if (cipherParameters == null) {
                System.arraycopy(this.f27025j, z, this.f27026k, 0, 16);
            } else {
                int i = z;
                for (z = false; z < true; z++) {
                    int i2 = this.f27025j[i] & JfifUtil.MARKER_FIRST_BYTE;
                    i++;
                    this.f27026k[z] = (byte) ((i2 << cipherParameters) | ((this.f27025j[i] & JfifUtil.MARKER_FIRST_BYTE) >>> (8 - cipherParameters)));
                }
            }
            this.f27029n = 0;
            this.f27030o = 0;
            this.f27031p = 0;
            this.f27032q = 0;
            this.f27033r = new byte[16];
            this.f27034s = new byte[16];
            System.arraycopy(this.f27026k, 0, this.f27035t, 0, 16);
            this.f27036u = new byte[16];
            if (this.f27020e) {
                mo5773a(this.f27020e, 0, this.f27020e.length);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("IV must be no more than 15 bytes");
    }

    /* renamed from: a */
    protected int m35553a(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i = 0;
        System.arraycopy(bArr, 0, bArr2, bArr2.length - bArr.length, bArr.length);
        bArr2[0] = (byte) (this.f27019d << 4);
        bArr = 15 - bArr.length;
        bArr2[bArr] = (byte) (bArr2[bArr] | 1);
        bArr = bArr2[15] & 63;
        bArr2[15] = (byte) (bArr2[15] & JfifUtil.MARKER_SOFn);
        if (this.f27024i == null || !Arrays.m29353a(bArr2, this.f27024i)) {
            Object obj = new byte[16];
            this.f27024i = bArr2;
            this.f27016a.mo5740a(this.f27024i, 0, obj, 0);
            System.arraycopy(obj, 0, this.f27025j, 0, 16);
            while (i < 8) {
                byte[] bArr3 = this.f27025j;
                int i2 = i + 16;
                byte b = obj[i];
                i++;
                bArr3[i2] = (byte) (b ^ obj[i]);
            }
        }
        return bArr;
    }

    /* renamed from: b */
    public int mo5774b(int i) {
        i += this.f27030o;
        if (this.f27018c) {
            return i + this.f27019d;
        }
        return i < this.f27019d ? 0 : i - this.f27019d;
    }

    /* renamed from: a */
    public int mo5768a(int i) {
        i += this.f27030o;
        if (!this.f27018c) {
            if (i < this.f27019d) {
                return 0;
            }
            i -= this.f27019d;
        }
        return i - (i % 16);
    }

    /* renamed from: a */
    public void mo5773a(byte[] bArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            this.f27027l[this.f27029n] = bArr[i + i3];
            int i4 = this.f27029n + 1;
            this.f27029n = i4;
            if (i4 == this.f27027l.length) {
                m35561b();
            }
        }
    }

    /* renamed from: a */
    public int mo5770a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (bArr.length >= i + i2) {
            int i4 = 0;
            for (int i5 = 0; i5 < i2; i5++) {
                this.f27028m[this.f27030o] = bArr[i + i5];
                int i6 = this.f27030o + 1;
                this.f27030o = i6;
                if (i6 == this.f27028m.length) {
                    m35563b(bArr2, i3 + i4);
                    i4 += 16;
                }
            }
            return i4;
        }
        throw new DataLengthException("Input buffer too short");
    }

    /* renamed from: a */
    public int mo5769a(byte[] bArr, int i) {
        byte[] bArr2;
        if (this.f27018c) {
            bArr2 = null;
        } else if (this.f27030o >= this.f27019d) {
            this.f27030o -= this.f27019d;
            bArr2 = new byte[this.f27019d];
            System.arraycopy(this.f27028m, this.f27030o, bArr2, 0, this.f27019d);
        } else {
            throw new InvalidCipherTextException("data too short");
        }
        if (this.f27029n > 0) {
            m35550c(this.f27027l, this.f27029n);
            m35564c(this.f27022g);
        }
        if (this.f27030o > 0) {
            if (this.f27018c) {
                m35550c(this.f27028m, this.f27030o);
                m35549b(this.f27036u, this.f27028m);
            }
            m35549b(this.f27035t, this.f27022g);
            byte[] bArr3 = new byte[16];
            this.f27016a.mo5740a(this.f27035t, 0, bArr3, 0);
            m35549b(this.f27028m, bArr3);
            if (bArr.length >= this.f27030o + i) {
                System.arraycopy(this.f27028m, 0, bArr, i, this.f27030o);
                if (!this.f27018c) {
                    m35550c(this.f27028m, this.f27030o);
                    m35549b(this.f27036u, this.f27028m);
                }
            } else {
                throw new OutputLengthException("Output buffer too short");
            }
        }
        m35549b(this.f27036u, this.f27035t);
        m35549b(this.f27036u, this.f27023h);
        this.f27016a.mo5740a(this.f27036u, 0, this.f27036u, 0);
        m35549b(this.f27036u, this.f27034s);
        this.f27037v = new byte[this.f27019d];
        System.arraycopy(this.f27036u, 0, this.f27037v, 0, this.f27019d);
        int i2 = this.f27030o;
        if (this.f27018c) {
            i += i2;
            if (bArr.length >= this.f27019d + i) {
                System.arraycopy(this.f27037v, 0, bArr, i, this.f27019d);
                i2 += this.f27019d;
            } else {
                throw new OutputLengthException("Output buffer too short");
            }
        } else if (Arrays.m29372b(this.f27037v, bArr2) == null) {
            throw new InvalidCipherTextException("mac check in OCB failed");
        }
        m35557a(false);
        return i2;
    }

    /* renamed from: b */
    protected void m35562b(byte[] bArr) {
        if (bArr != null) {
            Arrays.m29351a(bArr, (byte) 0);
        }
    }

    /* renamed from: c */
    protected byte[] m35565c(int i) {
        while (i >= this.f27021f.size()) {
            this.f27021f.addElement(m35551d((byte[]) this.f27021f.lastElement()));
        }
        return (byte[]) this.f27021f.elementAt(i);
    }

    /* renamed from: b */
    protected void m35561b() {
        long j = this.f27031p + 1;
        this.f27031p = j;
        m35564c(m35565c(m35547a(j)));
        this.f27029n = 0;
    }

    /* renamed from: b */
    protected void m35563b(byte[] bArr, int i) {
        if (bArr.length >= i + 16) {
            if (this.f27018c) {
                m35549b(this.f27036u, this.f27028m);
                this.f27030o = 0;
            }
            byte[] bArr2 = this.f27035t;
            long j = this.f27032q + 1;
            this.f27032q = j;
            m35549b(bArr2, m35565c(m35547a(j)));
            m35549b(this.f27028m, this.f27035t);
            this.f27017b.mo5740a(this.f27028m, 0, this.f27028m, 0);
            m35549b(this.f27028m, this.f27035t);
            System.arraycopy(this.f27028m, 0, bArr, i, 16);
            if (this.f27018c == null) {
                m35549b(this.f27036u, this.f27028m);
                System.arraycopy(this.f27028m, 16, this.f27028m, 0, this.f27019d);
                this.f27030o = this.f27019d;
                return;
            }
            return;
        }
        throw new OutputLengthException("Output buffer too short");
    }

    /* renamed from: a */
    protected void m35557a(boolean z) {
        this.f27016a.mo5744c();
        this.f27017b.mo5744c();
        m35562b(this.f27027l);
        m35562b(this.f27028m);
        this.f27029n = 0;
        this.f27030o = 0;
        this.f27031p = 0;
        this.f27032q = 0;
        m35562b(this.f27033r);
        m35562b(this.f27034s);
        System.arraycopy(this.f27026k, 0, this.f27035t, 0, 16);
        m35562b(this.f27036u);
        if (z) {
            this.f27037v = false;
        }
        if (this.f27020e) {
            mo5773a(this.f27020e, 0, this.f27020e.length);
        }
    }

    /* renamed from: c */
    protected void m35564c(byte[] bArr) {
        m35549b(this.f27033r, bArr);
        m35549b(this.f27027l, this.f27033r);
        this.f27016a.mo5740a(this.f27027l, 0, this.f27027l, 0);
        m35549b(this.f27034s, this.f27027l);
    }

    /* renamed from: d */
    protected static byte[] m35551d(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        bArr2[15] = (byte) ((135 >>> ((1 - m35548a(bArr, bArr2)) << 3)) ^ bArr2[15]);
        return bArr2;
    }

    /* renamed from: c */
    protected static void m35550c(byte[] bArr, int i) {
        bArr[i] = Byte.MIN_VALUE;
        while (true) {
            i++;
            if (i < 16) {
                bArr[i] = (byte) 0;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    protected static int m35548a(byte[] bArr, byte[] bArr2) {
        int i = 16;
        int i2 = 0;
        while (true) {
            i--;
            if (i < 0) {
                return i2;
            }
            int i3 = bArr[i] & JfifUtil.MARKER_FIRST_BYTE;
            bArr2[i] = (byte) (i2 | (i3 << 1));
            i2 = (i3 >>> 7) & 1;
        }
    }

    /* renamed from: b */
    protected static void m35549b(byte[] bArr, byte[] bArr2) {
        for (int i = 15; i >= 0; i--) {
            bArr[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
    }
}
