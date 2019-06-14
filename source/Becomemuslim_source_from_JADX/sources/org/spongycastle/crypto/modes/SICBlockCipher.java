package org.spongycastle.crypto.modes;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.SkippingStreamCipher;
import org.spongycastle.crypto.StreamBlockCipher;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Pack;

public class SICBlockCipher extends StreamBlockCipher implements SkippingStreamCipher {
    /* renamed from: a */
    private final BlockCipher f31739a;
    /* renamed from: b */
    private final int f31740b = this.f31739a.mo5743b();
    /* renamed from: c */
    private byte[] f31741c = new byte[this.f31740b];
    /* renamed from: d */
    private byte[] f31742d = new byte[this.f31740b];
    /* renamed from: e */
    private byte[] f31743e = new byte[this.f31740b];
    /* renamed from: f */
    private int f31744f = null;

    public SICBlockCipher(BlockCipher blockCipher) {
        super(blockCipher);
        this.f31739a = blockCipher;
    }

    /* renamed from: a */
    public void mo5742a(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            System.arraycopy(parametersWithIV.m35695a(), 0, this.f31741c, 0, this.f31741c.length);
            if (parametersWithIV.m35696b()) {
                this.f31739a.mo5742a(true, parametersWithIV.m35696b());
            }
            mo5744c();
            return;
        }
        throw new IllegalArgumentException("SIC mode requires ParametersWithIV");
    }

    /* renamed from: a */
    public String mo5749a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f31739a.mo5741a());
        stringBuilder.append("/SIC");
        return stringBuilder.toString();
    }

    /* renamed from: b */
    public int mo5743b() {
        return this.f31739a.mo5743b();
    }

    /* renamed from: a */
    public int mo5740a(byte[] bArr, int i, byte[] bArr2, int i2) {
        mo5722a(bArr, i, this.f31740b, bArr2, i2);
        return this.f31740b;
    }

    /* renamed from: b */
    protected byte mo6454b(byte b) {
        if (this.f31744f == 0) {
            this.f31739a.mo5740a(this.f31742d, 0, this.f31743e, 0);
            byte[] bArr = this.f31743e;
            int i = this.f31744f;
            this.f31744f = i + 1;
            return (byte) (b ^ bArr[i]);
        }
        bArr = this.f31743e;
        int i2 = this.f31744f;
        this.f31744f = i2 + 1;
        b = (byte) (b ^ bArr[i2]);
        if (this.f31744f == this.f31742d.length) {
            this.f31744f = 0;
            m40776f();
        }
        return b;
    }

    /* renamed from: a */
    private void m40772a(int i) {
        int length = this.f31742d.length - (i + 1);
        while (length >= 0) {
            i = this.f31742d;
            byte b = (byte) (i[length] + 1);
            i[length] = b;
            if (b == (byte) 0) {
                length--;
            } else {
                return;
            }
        }
    }

    /* renamed from: b */
    private void m40773b(int i) {
        byte b = this.f31742d[this.f31742d.length - 1];
        byte[] bArr = this.f31742d;
        int length = this.f31742d.length - 1;
        bArr[length] = (byte) (bArr[length] + i);
        if (b != (byte) 0 && this.f31742d[this.f31742d.length - 1] < b) {
            m40772a(1);
        }
    }

    /* renamed from: f */
    private void m40776f() {
        int length = this.f31742d.length - 1;
        while (length >= 0) {
            byte[] bArr = this.f31742d;
            byte b = (byte) (bArr[length] + 1);
            bArr[length] = b;
            if (b == (byte) 0) {
                length--;
            } else {
                return;
            }
        }
    }

    /* renamed from: c */
    private void m40774c(int i) {
        if (this.f31742d[i] == (byte) 0) {
            Object obj = null;
            for (int length = this.f31742d.length - (i + 1); length > 0; length--) {
                if (this.f31742d[length] != (byte) 0) {
                    obj = 1;
                }
            }
            if (obj == null) {
                throw new IllegalStateException("attempt to reduce counter past zero.");
            }
        }
        int length2 = this.f31742d.length - (i + 1);
        while (length2 >= 0) {
            i = this.f31742d;
            byte b = (byte) (i[length2] - 1);
            i[length2] = b;
            if (b == (byte) -1) {
                length2--;
            } else {
                return;
            }
        }
    }

    /* renamed from: g */
    private void m40777g() {
        int length;
        int i = 0;
        if (this.f31742d[0] == (byte) 0) {
            for (length = this.f31742d.length - 1; length > 0; length--) {
                if (this.f31742d[length] != (byte) 0) {
                    i = 1;
                }
            }
            if (i == 0) {
                throw new IllegalStateException("attempt to reduce counter past zero.");
            }
        }
        length = this.f31742d.length - 1;
        while (length >= 0) {
            byte[] bArr = this.f31742d;
            byte b = (byte) (bArr[length] - 1);
            bArr[length] = b;
            if (b == (byte) -1) {
                length--;
            } else {
                return;
            }
        }
    }

    /* renamed from: c */
    private void m40775c(long j) {
        int i = 5;
        long j2 = 0;
        long j3;
        long j4;
        if (j >= 0) {
            j2 = (((long) this.f31744f) + j) / ((long) this.f31740b);
            if (j2 > 255) {
                j3 = j2;
                while (i >= 1) {
                    j4 = 1 << (i * 8);
                    while (j3 >= j4) {
                        m40772a(i);
                        j3 -= j4;
                    }
                    i--;
                }
                m40773b((int) j3);
            } else {
                m40773b((int) j2);
            }
            this.f31744f = (int) ((j + ((long) this.f31744f)) - (((long) this.f31740b) * j2));
            return;
        }
        j4 = ((-j) - ((long) this.f31744f)) / ((long) this.f31740b);
        if (j4 > 255) {
            j3 = j4;
            while (i >= 1) {
                long j5 = 1 << (i * 8);
                while (j3 > j5) {
                    m40774c(i);
                    j3 -= j5;
                }
                i--;
            }
            while (j2 != j3) {
                m40777g();
                j2++;
            }
        } else {
            while (j2 != j4) {
                m40777g();
                j2++;
            }
        }
        j = (int) ((((long) this.f31744f) + j) + (((long) this.f31740b) * j4));
        if (j >= null) {
            this.f31744f = 0;
            return;
        }
        m40777g();
        this.f31744f = this.f31740b + j;
    }

    /* renamed from: c */
    public void mo5744c() {
        System.arraycopy(this.f31741c, 0, this.f31742d, 0, this.f31742d.length);
        this.f31739a.mo5744c();
        this.f31744f = 0;
    }

    /* renamed from: a */
    public long mo6449a(long j) {
        m40775c(j);
        this.f31739a.mo5740a(this.f31742d, 0, this.f31743e, 0);
        return j;
    }

    /* renamed from: b */
    public long mo6450b(long j) {
        mo5744c();
        return mo6449a(j);
    }

    /* renamed from: d */
    public long mo6451d() {
        Object obj = new byte[this.f31741c.length];
        System.arraycopy(this.f31742d, 0, obj, 0, obj.length);
        for (int length = obj.length - 1; length >= 1; length--) {
            int i = (obj[length] & JfifUtil.MARKER_FIRST_BYTE) - (this.f31741c[length] & JfifUtil.MARKER_FIRST_BYTE);
            if (i < 0) {
                int i2 = length - 1;
                obj[i2] = (byte) (obj[i2] - 1);
                i += 256;
            }
            obj[length] = (byte) i;
        }
        return (Pack.m29407b(obj, obj.length - 8) * ((long) this.f31740b)) + ((long) this.f31744f);
    }
}
