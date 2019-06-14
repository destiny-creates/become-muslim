package org.spongycastle.crypto.modes;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.modes.gcm.GCMExponentiator;
import org.spongycastle.crypto.modes.gcm.GCMMultiplier;
import org.spongycastle.crypto.modes.gcm.GCMUtil;
import org.spongycastle.crypto.modes.gcm.Tables1kGCMExponentiator;
import org.spongycastle.crypto.modes.gcm.Tables8kGCMMultiplier;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Pack;

public class GCMBlockCipher implements AEADBlockCipher {
    /* renamed from: a */
    private BlockCipher f26994a;
    /* renamed from: b */
    private GCMMultiplier f26995b;
    /* renamed from: c */
    private GCMExponentiator f26996c;
    /* renamed from: d */
    private boolean f26997d;
    /* renamed from: e */
    private int f26998e;
    /* renamed from: f */
    private byte[] f26999f;
    /* renamed from: g */
    private byte[] f27000g;
    /* renamed from: h */
    private byte[] f27001h;
    /* renamed from: i */
    private byte[] f27002i;
    /* renamed from: j */
    private byte[] f27003j;
    /* renamed from: k */
    private byte[] f27004k;
    /* renamed from: l */
    private byte[] f27005l;
    /* renamed from: m */
    private byte[] f27006m;
    /* renamed from: n */
    private byte[] f27007n;
    /* renamed from: o */
    private byte[] f27008o;
    /* renamed from: p */
    private int f27009p;
    /* renamed from: q */
    private long f27010q;
    /* renamed from: r */
    private byte[] f27011r;
    /* renamed from: s */
    private int f27012s;
    /* renamed from: t */
    private long f27013t;
    /* renamed from: u */
    private long f27014u;

    public GCMBlockCipher(BlockCipher blockCipher) {
        this(blockCipher, null);
    }

    public GCMBlockCipher(BlockCipher blockCipher, GCMMultiplier gCMMultiplier) {
        if (blockCipher.mo5743b() == 16) {
            if (gCMMultiplier == null) {
                gCMMultiplier = new Tables8kGCMMultiplier();
            }
            this.f26994a = blockCipher;
            this.f26995b = gCMMultiplier;
            return;
        }
        throw new IllegalArgumentException("cipher required with a block size of 16.");
    }

    /* renamed from: a */
    public BlockCipher mo5771a() {
        return this.f26994a;
    }

    /* renamed from: a */
    public void mo5772a(boolean z, CipherParameters cipherParameters) {
        this.f26997d = z;
        this.f27004k = null;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            this.f26999f = aEADParameters.m35629d();
            this.f27000g = aEADParameters.m35628c();
            int b = aEADParameters.m35627b();
            if (b < 32 || b > 128 || b % 8 != 0) {
                cipherParameters = new StringBuilder();
                cipherParameters.append("Invalid value for MAC size: ");
                cipherParameters.append(b);
                throw new IllegalArgumentException(cipherParameters.toString());
            }
            this.f26998e = b / 8;
            cipherParameters = aEADParameters.m35626a();
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.f26999f = parametersWithIV.m35695a();
            this.f27000g = null;
            this.f26998e = 16;
            cipherParameters = (KeyParameter) parametersWithIV.m35696b();
        } else {
            throw new IllegalArgumentException("invalid parameters passed to GCM");
        }
        if (z) {
            z = true;
        } else {
            z = this.f26998e + true;
        }
        this.f27003j = new byte[z];
        if (!this.f26999f || this.f26999f.length < true) {
            throw new IllegalArgumentException("IV must be at least 1 byte");
        }
        if (cipherParameters != null) {
            this.f26994a.mo5742a(true, cipherParameters);
            this.f27001h = new byte[16];
            this.f26994a.mo5740a(this.f27001h, 0, this.f27001h, 0);
            this.f26995b.mo5781a(this.f27001h);
            this.f26996c = null;
        } else if (this.f27001h == null) {
            throw new IllegalArgumentException("Key must be specified in initial init");
        }
        this.f27002i = new byte[16];
        if (this.f26999f.length == 12) {
            System.arraycopy(this.f26999f, 0, this.f27002i, 0, this.f26999f.length);
            this.f27002i[15] = 1;
        } else {
            m35531b(this.f27002i, this.f26999f, this.f26999f.length);
            byte[] bArr = new byte[16];
            Pack.m29401a(((long) this.f26999f.length) * 8, bArr, 8);
            m35526a(this.f27002i, bArr);
        }
        this.f27005l = new byte[16];
        this.f27006m = new byte[16];
        this.f27007n = new byte[16];
        this.f27011r = new byte[16];
        this.f27012s = 0;
        this.f27013t = 0;
        this.f27014u = 0;
        this.f27008o = Arrays.m29373b(this.f27002i);
        this.f27009p = 0;
        this.f27010q = 0;
        if (this.f27000g != null) {
            mo5773a(this.f27000g, 0, this.f27000g.length);
        }
    }

    /* renamed from: b */
    public int mo5774b(int i) {
        i += this.f27009p;
        if (this.f26997d) {
            return i + this.f26998e;
        }
        return i < this.f26998e ? 0 : i - this.f26998e;
    }

    /* renamed from: a */
    public int mo5768a(int i) {
        i += this.f27009p;
        if (!this.f26997d) {
            if (i < this.f26998e) {
                return 0;
            }
            i -= this.f26998e;
        }
        return i - (i % 16);
    }

    /* renamed from: a */
    public void m35538a(byte b) {
        this.f27011r[this.f27012s] = b;
        b = this.f27012s + 1;
        this.f27012s = b;
        if (b == (byte) 16) {
            m35526a(this.f27006m, this.f27011r);
            this.f27012s = (byte) 0;
            this.f27013t += 16;
        }
    }

    /* renamed from: a */
    public void mo5773a(byte[] bArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            this.f27011r[this.f27012s] = bArr[i + i3];
            int i4 = this.f27012s + 1;
            this.f27012s = i4;
            if (i4 == 16) {
                m35526a(this.f27006m, this.f27011r);
                this.f27012s = 0;
                this.f27013t += 16;
            }
        }
    }

    /* renamed from: c */
    private void m35532c() {
        if (this.f27013t > 0) {
            System.arraycopy(this.f27006m, 0, this.f27007n, 0, 16);
            this.f27014u = this.f27013t;
        }
        if (this.f27012s > 0) {
            m35528a(this.f27007n, this.f27011r, 0, this.f27012s);
            this.f27014u += (long) this.f27012s;
        }
        if (this.f27014u > 0) {
            System.arraycopy(this.f27007n, 0, this.f27005l, 0, 16);
        }
    }

    /* renamed from: a */
    public int mo5770a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (bArr.length >= i + i2) {
            int i4 = 0;
            for (int i5 = 0; i5 < i2; i5++) {
                this.f27003j[this.f27009p] = bArr[i + i5];
                int i6 = this.f27009p + 1;
                this.f27009p = i6;
                if (i6 == this.f27003j.length) {
                    m35529b(bArr2, i3 + i4);
                    i4 += 16;
                }
            }
            return i4;
        }
        throw new DataLengthException("Input buffer too short");
    }

    /* renamed from: b */
    private void m35529b(byte[] bArr, int i) {
        if (bArr.length >= i + 16) {
            if (this.f27010q == 0) {
                m35532c();
            }
            m35527a(this.f27003j, bArr, i);
            if (this.f26997d != null) {
                this.f27009p = 0;
                return;
            }
            System.arraycopy(this.f27003j, 16, this.f27003j, 0, this.f26998e);
            this.f27009p = this.f26998e;
            return;
        }
        throw new OutputLengthException("Output buffer too short");
    }

    /* renamed from: a */
    public int mo5769a(byte[] bArr, int i) {
        if (this.f27010q == 0) {
            m35532c();
        }
        int i2 = this.f27009p;
        if (this.f26997d) {
            if (bArr.length < (i + i2) + this.f26998e) {
                throw new OutputLengthException("Output buffer too short");
            }
        } else if (i2 >= this.f26998e) {
            i2 -= this.f26998e;
            if (bArr.length < i + i2) {
                throw new OutputLengthException("Output buffer too short");
            }
        } else {
            throw new InvalidCipherTextException("data too short");
        }
        if (i2 > 0) {
            m35530b(this.f27003j, 0, i2, bArr, i);
        }
        this.f27013t += (long) this.f27012s;
        if (this.f27013t > this.f27014u) {
            if (this.f27012s > 0) {
                m35528a(this.f27006m, this.f27011r, 0, this.f27012s);
            }
            if (this.f27014u > 0) {
                GCMUtil.m27487b(this.f27006m, this.f27007n);
            }
            long j = ((this.f27010q * 8) + 127) >>> 7;
            byte[] bArr2 = new byte[16];
            if (this.f26996c == null) {
                this.f26996c = new Tables1kGCMExponentiator();
                this.f26996c.mo5780a(this.f27001h);
            }
            this.f26996c.mo5779a(j, bArr2);
            GCMUtil.m27479a(this.f27006m, bArr2);
            GCMUtil.m27487b(this.f27005l, this.f27006m);
        }
        byte[] bArr3 = new byte[16];
        Pack.m29401a(this.f27013t * 8, bArr3, 0);
        Pack.m29401a(this.f27010q * 8, bArr3, 8);
        m35526a(this.f27005l, bArr3);
        byte[] bArr4 = new byte[16];
        this.f26994a.mo5740a(this.f27002i, 0, bArr4, 0);
        GCMUtil.m27487b(bArr4, this.f27005l);
        this.f27004k = new byte[this.f26998e];
        System.arraycopy(bArr4, 0, this.f27004k, 0, this.f26998e);
        if (this.f26997d) {
            System.arraycopy(this.f27004k, 0, bArr, i + this.f27009p, this.f26998e);
            i2 += this.f26998e;
        } else {
            bArr = new byte[this.f26998e];
            System.arraycopy(this.f27003j, i2, bArr, 0, this.f26998e);
            if (Arrays.m29372b(this.f27004k, bArr) == null) {
                throw new InvalidCipherTextException("mac check in GCM failed");
            }
        }
        m35525a(false);
        return i2;
    }

    /* renamed from: b */
    public void m35542b() {
        m35525a(true);
    }

    /* renamed from: a */
    private void m35525a(boolean z) {
        this.f26994a.mo5744c();
        this.f27005l = new byte[16];
        this.f27006m = new byte[16];
        this.f27007n = new byte[16];
        this.f27011r = new byte[16];
        this.f27012s = 0;
        this.f27013t = 0;
        this.f27014u = 0;
        this.f27008o = Arrays.m29373b(this.f27002i);
        this.f27009p = 0;
        this.f27010q = 0;
        if (this.f27003j != null) {
            Arrays.m29351a(this.f27003j, (byte) 0);
        }
        if (z) {
            this.f27004k = false;
        }
        if (this.f27000g) {
            mo5773a(this.f27000g, 0, this.f27000g.length);
        }
    }

    /* renamed from: a */
    private void m35527a(byte[] bArr, byte[] bArr2, int i) {
        byte[] d = m35533d();
        GCMUtil.m27487b(d, bArr);
        System.arraycopy(d, 0, bArr2, i, 16);
        bArr2 = this.f27005l;
        if (this.f26997d != 0) {
            bArr = d;
        }
        m35526a(bArr2, bArr);
        this.f27010q += 16;
    }

    /* renamed from: b */
    private void m35530b(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        Object d = m35533d();
        GCMUtil.m27480a(d, bArr, i, i2);
        System.arraycopy(d, 0, bArr2, i3, i2);
        bArr2 = this.f27005l;
        if (this.f26997d != 0) {
            bArr = d;
        }
        m35528a(bArr2, bArr, 0, i2);
        this.f27010q += (long) i2;
    }

    /* renamed from: b */
    private void m35531b(byte[] bArr, byte[] bArr2, int i) {
        for (int i2 = 0; i2 < i; i2 += 16) {
            m35528a(bArr, bArr2, i2, Math.min(i - i2, 16));
        }
    }

    /* renamed from: a */
    private void m35526a(byte[] bArr, byte[] bArr2) {
        GCMUtil.m27487b(bArr, bArr2);
        this.f26995b.mo5782b(bArr);
    }

    /* renamed from: a */
    private void m35528a(byte[] bArr, byte[] bArr2, int i, int i2) {
        GCMUtil.m27480a(bArr, bArr2, i, i2);
        this.f26995b.mo5782b(bArr);
    }

    /* renamed from: d */
    private byte[] m35533d() {
        for (int i = 15; i >= 12; i--) {
            byte b = (byte) ((this.f27008o[i] + 1) & JfifUtil.MARKER_FIRST_BYTE);
            this.f27008o[i] = b;
            if (b != (byte) 0) {
                break;
            }
        }
        byte[] bArr = new byte[16];
        this.f26994a.mo5740a(this.f27008o, 0, bArr, 0);
        return bArr;
    }
}
