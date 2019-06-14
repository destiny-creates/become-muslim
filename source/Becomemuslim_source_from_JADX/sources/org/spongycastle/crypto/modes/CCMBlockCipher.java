package org.spongycastle.crypto.modes;

import com.facebook.imageutils.JfifUtil;
import java.io.ByteArrayOutputStream;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.macs.CBCBlockCipherMac;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;

public class CCMBlockCipher implements AEADBlockCipher {
    /* renamed from: a */
    private BlockCipher f26971a;
    /* renamed from: b */
    private int f26972b;
    /* renamed from: c */
    private boolean f26973c;
    /* renamed from: d */
    private byte[] f26974d;
    /* renamed from: e */
    private byte[] f26975e;
    /* renamed from: f */
    private int f26976f;
    /* renamed from: g */
    private CipherParameters f26977g;
    /* renamed from: h */
    private byte[] f26978h;
    /* renamed from: i */
    private ExposedByteArrayOutputStream f26979i = new ExposedByteArrayOutputStream(this);
    /* renamed from: j */
    private ExposedByteArrayOutputStream f26980j = new ExposedByteArrayOutputStream(this);

    private class ExposedByteArrayOutputStream extends ByteArrayOutputStream {
        /* renamed from: a */
        final /* synthetic */ CCMBlockCipher f22410a;

        public ExposedByteArrayOutputStream(CCMBlockCipher cCMBlockCipher) {
            this.f22410a = cCMBlockCipher;
        }

        /* renamed from: a */
        public byte[] m27473a() {
            return this.buf;
        }
    }

    /* renamed from: a */
    public int mo5768a(int i) {
        return 0;
    }

    public CCMBlockCipher(BlockCipher blockCipher) {
        this.f26971a = blockCipher;
        this.f26972b = blockCipher.mo5743b();
        this.f26978h = new byte[this.f26972b];
        if (this.f26972b != 16) {
            throw new IllegalArgumentException("cipher required with a block size of 16.");
        }
    }

    /* renamed from: a */
    public BlockCipher mo5771a() {
        return this.f26971a;
    }

    /* renamed from: a */
    public void mo5772a(boolean z, CipherParameters cipherParameters) {
        this.f26973c = z;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            this.f26974d = aEADParameters.m35629d();
            this.f26975e = aEADParameters.m35628c();
            this.f26976f = aEADParameters.m35627b() / 8;
            z = aEADParameters.m35626a();
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.f26974d = parametersWithIV.m35695a();
            this.f26975e = false;
            this.f26976f = this.f26978h.length / 2;
            z = parametersWithIV.m35696b();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("invalid parameters passed to CCM: ");
            stringBuilder.append(cipherParameters.getClass().getName());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (z) {
            this.f26977g = z;
        }
        if (!this.f26974d || this.f26974d.length < true || this.f26974d.length > true) {
            throw new IllegalArgumentException("nonce must have length from 7 to 13 octets");
        }
        m35507b();
    }

    /* renamed from: a */
    public void mo5773a(byte[] bArr, int i, int i2) {
        this.f26979i.write(bArr, i, i2);
    }

    /* renamed from: a */
    public int mo5770a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (bArr.length >= i + i2) {
            this.f26980j.write(bArr, i, i2);
            return null;
        }
        throw new DataLengthException("Input buffer too short");
    }

    /* renamed from: a */
    public int mo5769a(byte[] bArr, int i) {
        bArr = m35506b(this.f26980j.m27473a(), 0, this.f26980j.size(), bArr, i);
        m35507b();
        return bArr;
    }

    /* renamed from: b */
    public void m35507b() {
        this.f26971a.mo5744c();
        this.f26979i.reset();
        this.f26980j.reset();
    }

    /* renamed from: b */
    public int mo5774b(int i) {
        i += this.f26980j.size();
        if (this.f26973c) {
            return i + this.f26976f;
        }
        return i < this.f26976f ? 0 : i - this.f26976f;
    }

    /* renamed from: b */
    public int m35506b(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (this.f26977g != null) {
            int i4;
            int length = 15 - this.f26974d.length;
            if (length < 4) {
                if (i2 >= (1 << (length * 8))) {
                    throw new IllegalStateException("CCM packet too large for choice of q.");
                }
            }
            Object obj = new byte[this.f26972b];
            obj[0] = (byte) ((length - 1) & 7);
            System.arraycopy(this.f26974d, 0, obj, 1, this.f26974d.length);
            BlockCipher sICBlockCipher = new SICBlockCipher(this.f26971a);
            sICBlockCipher.mo5742a(this.f26973c, new ParametersWithIV(this.f26977g, obj));
            int i5;
            if (this.f26973c) {
                i4 = this.f26976f + i2;
                if (bArr2.length >= i4 + i3) {
                    int i6;
                    m35496a(bArr, i, i2, this.f26978h);
                    Object obj2 = new byte[this.f26972b];
                    sICBlockCipher.mo5740a(this.f26978h, 0, obj2, 0);
                    i5 = i;
                    int i7 = i3;
                    while (true) {
                        i6 = i + i2;
                        if (i5 >= i6 - this.f26972b) {
                            break;
                        }
                        sICBlockCipher.mo5740a(bArr, i5, bArr2, i7);
                        i7 += this.f26972b;
                        i5 += this.f26972b;
                    }
                    i = new byte[this.f26972b];
                    i6 -= i5;
                    System.arraycopy(bArr, i5, i, 0, i6);
                    sICBlockCipher.mo5740a(i, 0, i, 0);
                    System.arraycopy(i, 0, bArr2, i7, i6);
                    System.arraycopy(obj2, 0, bArr2, i3 + i2, this.f26976f);
                } else {
                    throw new OutputLengthException("Output buffer too short.");
                }
            } else if (i2 >= this.f26976f) {
                i4 = i2 - this.f26976f;
                if (bArr2.length >= i4 + i3) {
                    int i8;
                    i2 = i + i4;
                    System.arraycopy(bArr, i2, this.f26978h, 0, this.f26976f);
                    sICBlockCipher.mo5740a(this.f26978h, 0, this.f26978h, 0);
                    for (i8 = this.f26976f; i8 != this.f26978h.length; i8++) {
                        this.f26978h[i8] = (byte) 0;
                    }
                    i8 = i;
                    i5 = i3;
                    while (i8 < i2 - this.f26972b) {
                        sICBlockCipher.mo5740a(bArr, i8, bArr2, i5);
                        i5 += this.f26972b;
                        i8 += this.f26972b;
                    }
                    i2 = new byte[this.f26972b];
                    i = i4 - (i8 - i);
                    System.arraycopy(bArr, i8, i2, 0, i);
                    sICBlockCipher.mo5740a(i2, 0, i2, 0);
                    System.arraycopy(i2, 0, bArr2, i5, i);
                    bArr = new byte[this.f26972b];
                    m35496a(bArr2, i3, i4, bArr);
                    if (Arrays.m29372b(this.f26978h, bArr) == null) {
                        throw new InvalidCipherTextException("mac check in CCM failed");
                    }
                }
                throw new OutputLengthException("Output buffer too short.");
            } else {
                throw new InvalidCipherTextException("data too short");
            }
            return i4;
        }
        throw new IllegalStateException("CCM cipher unitialized.");
    }

    /* renamed from: a */
    private int m35496a(byte[] bArr, int i, int i2, byte[] bArr2) {
        Mac cBCBlockCipherMac = new CBCBlockCipherMac(this.f26971a, this.f26976f * 8);
        cBCBlockCipherMac.mo5764a(this.f26977g);
        Object obj = new byte[16];
        if (m35498d()) {
            obj[0] = (byte) (obj[0] | 64);
        }
        int i3 = 2;
        obj[0] = (byte) (obj[0] | ((((cBCBlockCipherMac.mo5766b() - 2) / 2) & 7) << 3));
        obj[0] = (byte) (obj[0] | (((15 - this.f26974d.length) - 1) & 7));
        System.arraycopy(this.f26974d, 0, obj, 1, this.f26974d.length);
        int i4 = i2;
        int i5 = 1;
        while (i4 > 0) {
            obj[obj.length - i5] = (byte) (i4 & JfifUtil.MARKER_FIRST_BYTE);
            i4 >>>= 8;
            i5++;
        }
        cBCBlockCipherMac.mo5765a(obj, 0, obj.length);
        if (m35498d()) {
            int c = m35497c();
            if (c < 65280) {
                cBCBlockCipherMac.mo5763a((byte) (c >> 8));
                cBCBlockCipherMac.mo5763a((byte) c);
            } else {
                cBCBlockCipherMac.mo5763a((byte) -1);
                cBCBlockCipherMac.mo5763a((byte) -2);
                cBCBlockCipherMac.mo5763a((byte) (c >> 24));
                cBCBlockCipherMac.mo5763a((byte) (c >> 16));
                cBCBlockCipherMac.mo5763a((byte) (c >> 8));
                cBCBlockCipherMac.mo5763a((byte) c);
                i3 = 6;
            }
            if (this.f26975e != null) {
                cBCBlockCipherMac.mo5765a(this.f26975e, 0, this.f26975e.length);
            }
            if (this.f26979i.size() > 0) {
                cBCBlockCipherMac.mo5765a(this.f26979i.m27473a(), 0, this.f26979i.size());
            }
            i3 = (i3 + c) % 16;
            if (i3 != 0) {
                while (i3 != 16) {
                    cBCBlockCipherMac.mo5763a((byte) 0);
                    i3++;
                }
            }
        }
        cBCBlockCipherMac.mo5765a(bArr, i, i2);
        return cBCBlockCipherMac.mo5761a(bArr2, 0);
    }

    /* renamed from: c */
    private int m35497c() {
        return this.f26979i.size() + (this.f26975e == null ? 0 : this.f26975e.length);
    }

    /* renamed from: d */
    private boolean m35498d() {
        return m35497c() > 0;
    }
}
