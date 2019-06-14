package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.MaxBytesExceededException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.SkippingStreamCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Pack;
import org.spongycastle.util.Strings;

public class Salsa20Engine implements SkippingStreamCipher {
    /* renamed from: a */
    protected static final byte[] f31664a = Strings.m29429d("expand 32-byte k");
    /* renamed from: b */
    protected static final byte[] f31665b = Strings.m29429d("expand 16-byte k");
    /* renamed from: c */
    protected int f31666c;
    /* renamed from: d */
    protected int[] f31667d;
    /* renamed from: e */
    protected int[] f31668e;
    /* renamed from: f */
    private int f31669f;
    /* renamed from: g */
    private byte[] f31670g;
    /* renamed from: h */
    private boolean f31671h;
    /* renamed from: i */
    private int f31672i;
    /* renamed from: j */
    private int f31673j;
    /* renamed from: k */
    private int f31674k;

    /* renamed from: a */
    protected static int m40704a(int i, int i2) {
        return (i >>> (-i2)) | (i << i2);
    }

    /* renamed from: h */
    protected int mo6804h() {
        return 8;
    }

    public Salsa20Engine() {
        this(20);
    }

    public Salsa20Engine(int i) {
        this.f31669f = 0;
        this.f31667d = new int[16];
        this.f31668e = new int[16];
        this.f31670g = new byte[64];
        this.f31671h = false;
        if (i <= 0 || (i & 1) != 0) {
            throw new IllegalArgumentException("'rounds' must be a positive, even number");
        }
        this.f31666c = i;
    }

    /* renamed from: a */
    public void mo5750a(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] a = parametersWithIV.m35695a();
            if (a == null || a.length != mo6804h()) {
                cipherParameters = new StringBuilder();
                cipherParameters.append(mo5749a());
                cipherParameters.append(" requires exactly ");
                cipherParameters.append(mo6804h());
                cipherParameters.append(" bytes of IV");
                throw new IllegalArgumentException(cipherParameters.toString());
            }
            cipherParameters = parametersWithIV.m35696b();
            if (cipherParameters == null) {
                if (this.f31671h != null) {
                    mo6797a((byte[]) null, a);
                } else {
                    cipherParameters = new StringBuilder();
                    cipherParameters.append(mo5749a());
                    cipherParameters.append(" KeyParameter can not be null for first initialisation");
                    throw new IllegalStateException(cipherParameters.toString());
                }
            } else if (cipherParameters instanceof KeyParameter) {
                mo6797a(((KeyParameter) cipherParameters).m35685a(), a);
            } else {
                cipherParameters = new StringBuilder();
                cipherParameters.append(mo5749a());
                cipherParameters.append(" Init parameters must contain a KeyParameter (or null for re-init)");
                throw new IllegalArgumentException(cipherParameters.toString());
            }
            mo5751c();
            this.f31671h = true;
            return;
        }
        cipherParameters = new StringBuilder();
        cipherParameters.append(mo5749a());
        cipherParameters.append(" Init parameters must include an IV");
        throw new IllegalArgumentException(cipherParameters.toString());
    }

    /* renamed from: a */
    public String mo5749a() {
        String str = "Salsa20";
        if (this.f31666c == 20) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("/");
        stringBuilder.append(this.f31666c);
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public byte mo5721a(byte b) {
        if (m40708j()) {
            throw new MaxBytesExceededException("2^70 byte limit per IV; Change IV");
        }
        b = (byte) (b ^ this.f31670g[this.f31669f]);
        this.f31669f = (this.f31669f + 1) & 63;
        if (this.f31669f == 0) {
            mo6798b();
            mo6796a(this.f31670g);
        }
        return b;
    }

    /* renamed from: c */
    protected void mo6799c(long j) {
        int i = (int) (j >>> 32);
        j = (int) j;
        if (i > 0) {
            int[] iArr = this.f31667d;
            iArr[9] = iArr[9] + i;
        }
        i = this.f31667d[8];
        int[] iArr2 = this.f31667d;
        iArr2[8] = iArr2[8] + j;
        if (i != 0 && this.f31667d[8] < i) {
            j = this.f31667d;
            j[9] = j[9] + 1;
        }
    }

    /* renamed from: b */
    protected void mo6798b() {
        int[] iArr = this.f31667d;
        int i = iArr[8] + 1;
        iArr[8] = i;
        if (i == 0) {
            iArr = this.f31667d;
            iArr[9] = iArr[9] + 1;
        }
    }

    /* renamed from: d */
    protected void mo6800d(long j) {
        int i = (int) (j >>> 32);
        j = (int) j;
        if (i != 0) {
            if ((((long) this.f31667d[9]) & 4294967295L) >= (((long) i) & 4294967295L)) {
                int[] iArr = this.f31667d;
                iArr[9] = iArr[9] - i;
            } else {
                throw new IllegalStateException("attempt to reduce counter past zero.");
            }
        }
        int[] iArr2;
        if ((((long) this.f31667d[8]) & 4294967295L) >= (((long) j) & 4294967295L)) {
            iArr2 = this.f31667d;
            iArr2[8] = iArr2[8] - j;
        } else if (this.f31667d[9] != 0) {
            int[] iArr3 = this.f31667d;
            iArr3[9] = iArr3[9] - 1;
            iArr2 = this.f31667d;
            iArr2[8] = iArr2[8] - j;
        } else {
            throw new IllegalStateException("attempt to reduce counter past zero.");
        }
    }

    /* renamed from: e */
    protected void mo6801e() {
        if (this.f31667d[8] == 0) {
            if (this.f31667d[9] == 0) {
                throw new IllegalStateException("attempt to reduce counter past zero.");
            }
        }
        int[] iArr = this.f31667d;
        int i = iArr[8] - 1;
        iArr[8] = i;
        if (i == -1) {
            iArr = this.f31667d;
            iArr[9] = iArr[9] - 1;
        }
    }

    /* renamed from: a */
    public int mo5722a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (!this.f31671h) {
            i = new StringBuilder();
            i.append(mo5749a());
            i.append(" not initialised");
            throw new IllegalStateException(i.toString());
        } else if (i + i2 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i3 + i2 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        } else if (m40705a(i2)) {
            throw new MaxBytesExceededException("2^70 byte limit per IV would be exceeded; Change IV");
        } else {
            for (int i4 = 0; i4 < i2; i4++) {
                bArr2[i4 + i3] = (byte) (this.f31670g[this.f31669f] ^ bArr[i4 + i]);
                this.f31669f = (this.f31669f + 1) & 63;
                if (this.f31669f == 0) {
                    mo6798b();
                    mo6796a(this.f31670g);
                }
            }
            return i2;
        }
    }

    /* renamed from: a */
    public long mo6449a(long j) {
        long j2 = 0;
        if (j >= 0) {
            if (j >= 64) {
                j2 = j / 64;
                mo6799c(j2);
                j2 = j - (j2 * 64);
            } else {
                j2 = j;
            }
            int i = this.f31669f;
            this.f31669f = (this.f31669f + ((int) j2)) & 63;
            if (this.f31669f < i) {
                mo6798b();
            }
        } else {
            long j3 = -j;
            if (j3 >= 64) {
                long j4 = j3 / 64;
                mo6800d(j4);
                j3 -= j4 * 64;
            }
            while (j2 < j3) {
                if (this.f31669f == 0) {
                    mo6801e();
                }
                this.f31669f = (this.f31669f - 1) & 63;
                j2++;
            }
        }
        mo6796a(this.f31670g);
        return j;
    }

    /* renamed from: b */
    public long mo6450b(long j) {
        mo5751c();
        return mo6449a(j);
    }

    /* renamed from: d */
    public long mo6451d() {
        return (mo6802f() * 64) + ((long) this.f31669f);
    }

    /* renamed from: c */
    public void mo5751c() {
        this.f31669f = 0;
        m40707i();
        mo6803g();
        mo6796a(this.f31670g);
    }

    /* renamed from: f */
    protected long mo6802f() {
        return (((long) this.f31667d[9]) << 32) | (((long) this.f31667d[8]) & 4294967295L);
    }

    /* renamed from: g */
    protected void mo6803g() {
        int[] iArr = this.f31667d;
        this.f31667d[9] = 0;
        iArr[8] = 0;
    }

    /* renamed from: a */
    protected void mo6797a(byte[] bArr, byte[] bArr2) {
        if (bArr != null) {
            byte[] bArr3;
            int i = 16;
            if (bArr.length != 16) {
                if (bArr.length != 32) {
                    bArr2 = new StringBuilder();
                    bArr2.append(mo5749a());
                    bArr2.append(" requires 128 bit or 256 bit key");
                    throw new IllegalArgumentException(bArr2.toString());
                }
            }
            this.f31667d[1] = Pack.m29411c(bArr, 0);
            this.f31667d[2] = Pack.m29411c(bArr, 4);
            this.f31667d[3] = Pack.m29411c(bArr, 8);
            this.f31667d[4] = Pack.m29411c(bArr, 12);
            if (bArr.length == 32) {
                bArr3 = f31664a;
            } else {
                bArr3 = f31665b;
                i = 0;
            }
            this.f31667d[11] = Pack.m29411c(bArr, i);
            this.f31667d[12] = Pack.m29411c(bArr, i + 4);
            this.f31667d[13] = Pack.m29411c(bArr, i + 8);
            this.f31667d[14] = Pack.m29411c(bArr, i + 12);
            this.f31667d[0] = Pack.m29411c(bArr3, 0);
            this.f31667d[5] = Pack.m29411c(bArr3, 4);
            this.f31667d[10] = Pack.m29411c(bArr3, 8);
            this.f31667d[15] = Pack.m29411c(bArr3, 12);
        }
        this.f31667d[6] = Pack.m29411c(bArr2, 0);
        this.f31667d[7] = Pack.m29411c(bArr2, 4);
    }

    /* renamed from: a */
    protected void mo6796a(byte[] bArr) {
        m40706b(this.f31666c, this.f31667d, this.f31668e);
        Pack.m29410b(this.f31668e, bArr, 0);
    }

    /* renamed from: b */
    public static void m40706b(int i, int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        if (iArr3.length != 16) {
            throw new IllegalArgumentException();
        } else if (iArr4.length != 16) {
            throw new IllegalArgumentException();
        } else if (i % 2 == 0) {
            int i2 = iArr3[0];
            int i3 = iArr3[1];
            int i4 = iArr3[2];
            int i5 = iArr3[3];
            int i6 = iArr3[4];
            int i7 = iArr3[5];
            int i8 = iArr3[6];
            int i9 = 7;
            int i10 = iArr3[7];
            int i11 = iArr3[8];
            int i12 = 9;
            int i13 = iArr3[9];
            int i14 = iArr3[10];
            int i15 = iArr3[11];
            int i16 = iArr3[12];
            int i17 = 13;
            int i18 = iArr3[13];
            int i19 = iArr3[14];
            int i20 = iArr3[15];
            int i21 = i;
            while (i21 > 0) {
                int a = m40704a(i2 + i16, i9) ^ i6;
                i6 = i11 ^ m40704a(a + i2, i12);
                int a2 = i16 ^ m40704a(i6 + a, i17);
                i2 ^= m40704a(a2 + i6, 18);
                int a3 = i13 ^ m40704a(i7 + i3, i9);
                i9 = i18 ^ m40704a(a3 + i7, i12);
                i3 ^= m40704a(i9 + a3, i17);
                i12 = m40704a(i3 + i9, 18) ^ i7;
                int a4 = i19 ^ m40704a(i14 + i8, 7);
                i4 ^= m40704a(a4 + i14, 9);
                i17 = i8 ^ m40704a(i4 + a4, 13);
                int a5 = i14 ^ m40704a(i17 + i4, 18);
                int a6 = i5 ^ m40704a(i20 + i15, 7);
                i5 = i10 ^ m40704a(a6 + i20, 9);
                int i22 = i21;
                i21 = i15 ^ m40704a(i5 + a6, 13);
                i7 = i20 ^ m40704a(i21 + i5, 18);
                int i23 = a2;
                i3 ^= m40704a(i2 + a6, 7);
                i4 ^= m40704a(i3 + i2, 9);
                a6 ^= m40704a(i4 + i3, 13);
                i2 ^= m40704a(a6 + i4, 18);
                i8 = i17 ^ m40704a(i12 + a, 7);
                i10 = i5 ^ m40704a(i8 + i12, 9);
                a2 = m40704a(i10 + i8, 13) ^ a;
                i15 = i21 ^ m40704a(a5 + a3, 7);
                i11 = i6 ^ m40704a(i15 + a5, 9);
                i13 = a3 ^ m40704a(i11 + i15, 13);
                i14 = a5 ^ m40704a(i13 + i11, 18);
                i16 = i23 ^ m40704a(i7 + a4, 7);
                i18 = i9 ^ m40704a(i16 + i7, 9);
                i19 = a4 ^ m40704a(i18 + i16, 13);
                i20 = i7 ^ m40704a(i19 + i18, 18);
                i21 = i22 - 2;
                i5 = a6;
                i6 = a2;
                i7 = m40704a(a2 + i10, 18) ^ i12;
                iArr3 = iArr;
                iArr4 = iArr2;
                i17 = 13;
                i12 = 9;
                i9 = 7;
            }
            int[] iArr5 = iArr2;
            iArr5[0] = i2 + iArr3[0];
            iArr5[1] = i3 + iArr3[1];
            iArr5[2] = i4 + iArr3[2];
            iArr5[3] = i5 + iArr3[3];
            iArr5[4] = i6 + iArr3[4];
            iArr5[5] = i7 + iArr3[5];
            iArr5[6] = i8 + iArr3[6];
            iArr5[7] = i10 + iArr3[7];
            iArr5[8] = i11 + iArr3[8];
            iArr5[9] = i13 + iArr3[9];
            iArr5[10] = i14 + iArr3[10];
            iArr5[11] = i15 + iArr3[11];
            iArr5[12] = i16 + iArr3[12];
            iArr5[13] = i18 + iArr3[13];
            iArr5[14] = i19 + iArr3[14];
            iArr5[15] = i20 + iArr3[15];
        } else {
            throw new IllegalArgumentException("Number of rounds must be even");
        }
    }

    /* renamed from: i */
    private void m40707i() {
        this.f31672i = 0;
        this.f31673j = 0;
        this.f31674k = 0;
    }

    /* renamed from: j */
    private boolean m40708j() {
        boolean z = true;
        int i = this.f31672i + 1;
        this.f31672i = i;
        if (i == 0) {
            i = this.f31673j + 1;
            this.f31673j = i;
            if (i == 0) {
                i = this.f31674k + 1;
                this.f31674k = i;
                if ((i & 32) == 0) {
                    z = false;
                }
                return z;
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m40705a(int i) {
        this.f31672i += i;
        if (this.f31672i < i && this.f31672i >= 0) {
            boolean z = true;
            i = this.f31673j + 1;
            this.f31673j = i;
            if (i == 0) {
                i = this.f31674k + 1;
                this.f31674k = i;
                if ((i & 32) == 0) {
                    z = false;
                }
                return z;
            }
        }
        return false;
    }
}
