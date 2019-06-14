package org.spongycastle.crypto.engines;

import com.facebook.imageutils.JfifUtil;
import com.facebook.soloader.MinElf;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

public class Grainv1Engine implements StreamCipher {
    /* renamed from: a */
    private byte[] f26648a;
    /* renamed from: b */
    private byte[] f26649b;
    /* renamed from: c */
    private byte[] f26650c;
    /* renamed from: d */
    private int[] f26651d;
    /* renamed from: e */
    private int[] f26652e;
    /* renamed from: f */
    private int f26653f;
    /* renamed from: g */
    private int f26654g = 2;
    /* renamed from: h */
    private boolean f26655h = false;

    /* renamed from: a */
    public String mo5749a() {
        return "Grain v1";
    }

    /* renamed from: a */
    public void mo5750a(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            z = parametersWithIV.m35695a();
            if (!z || z.length != 8) {
                throw new IllegalArgumentException("Grain v1 requires exactly 8 bytes of IV");
            } else if (parametersWithIV.m35696b() instanceof KeyParameter) {
                KeyParameter keyParameter = (KeyParameter) parametersWithIV.m35696b();
                this.f26649b = new byte[keyParameter.m35685a().length];
                this.f26648a = new byte[keyParameter.m35685a().length];
                this.f26651d = new int[5];
                this.f26652e = new int[5];
                this.f26650c = new byte[2];
                System.arraycopy(z, 0, this.f26649b, 0, z.length);
                System.arraycopy(keyParameter.m35685a(), 0, this.f26648a, 0, keyParameter.m35685a().length);
                mo5751c();
                return;
            } else {
                throw new IllegalArgumentException("Grain v1 Init parameters must include a key");
            }
        }
        throw new IllegalArgumentException("Grain v1 Init parameters must include an IV");
    }

    /* renamed from: b */
    private void m34966b() {
        for (int i = 0; i < 10; i++) {
            this.f26653f = m34969f();
            this.f26652e = m34965a(this.f26652e, (m34967d() ^ this.f26651d[0]) ^ this.f26653f);
            this.f26651d = m34965a(this.f26651d, m34968e() ^ this.f26653f);
        }
        this.f26655h = true;
    }

    /* renamed from: d */
    private int m34967d() {
        int i = (this.f26652e[0] >>> 9) | (this.f26652e[1] << 7);
        int i2 = (this.f26652e[0] >>> 15) | (this.f26652e[1] << 1);
        int i3 = (this.f26652e[1] >>> 5) | (this.f26652e[2] << 11);
        int i4 = (this.f26652e[1] >>> 12) | (this.f26652e[2] << 4);
        int i5 = (this.f26652e[2] >>> 1) | (this.f26652e[3] << 15);
        int i6 = (this.f26652e[2] >>> 5) | (this.f26652e[3] << 11);
        int i7 = (this.f26652e[2] >>> 13) | (this.f26652e[3] << 3);
        int i8 = (this.f26652e[3] >>> 4) | (this.f26652e[4] << 12);
        int i9 = (this.f26652e[4] << 4) | (this.f26652e[3] >>> 12);
        int i10 = (this.f26652e[4] << 1) | (this.f26652e[3] >>> 15);
        int i11 = this.f26652e[0] ^ ((((this.f26652e[0] >>> 14) | (this.f26652e[1] << 2)) ^ (((((((((this.f26652e[4] << 2) | (this.f26652e[3] >>> 14)) ^ i9) ^ i8) ^ i7) ^ i6) ^ i5) ^ i4) ^ i3)) ^ i);
        int i12 = i10 & i9;
        i9 &= i8;
        int i13 = (i5 & i4) & i3;
        return (((((((((((i11 ^ i12) ^ (i6 & i5)) ^ (i2 & i)) ^ (i9 & i7)) ^ i13) ^ (((i10 & i7) & i4) & i)) ^ ((i9 & i6) & i5)) ^ ((i12 & i3) & i2)) ^ (((i12 & i8) & i7) & i6)) ^ ((i2 & i13) & i)) ^ (((((i8 & i7) & i6) & i5) & i4) & i3)) & MinElf.PN_XNUM;
    }

    /* renamed from: e */
    private int m34968e() {
        int i = (this.f26651d[1] >>> 7) | (this.f26651d[2] << 9);
        int i2 = (this.f26651d[2] >>> 6) | (this.f26651d[3] << 10);
        int i3 = (this.f26651d[3] >>> 3) | (this.f26651d[4] << 13);
        return (((((this.f26651d[0] ^ ((this.f26651d[0] >>> 13) | (this.f26651d[1] << 3))) ^ i) ^ i2) ^ i3) ^ ((this.f26651d[3] >>> 14) | (this.f26651d[4] << 2))) & MinElf.PN_XNUM;
    }

    /* renamed from: f */
    private int m34969f() {
        int i = (this.f26652e[0] >>> 1) | (this.f26652e[1] << 15);
        int i2 = (this.f26652e[0] >>> 2) | (this.f26652e[1] << 14);
        int i3 = (this.f26652e[0] >>> 4) | (this.f26652e[1] << 12);
        int i4 = (this.f26652e[0] >>> 10) | (this.f26652e[1] << 6);
        int i5 = (this.f26652e[1] >>> 15) | (this.f26652e[2] << 1);
        int i6 = (this.f26652e[2] >>> 11) | (this.f26652e[3] << 5);
        int i7 = (this.f26652e[3] >>> 8) | (this.f26652e[4] << 8);
        int i8 = (this.f26652e[3] >>> 15) | (this.f26652e[4] << 1);
        int i9 = (this.f26651d[0] >>> 3) | (this.f26651d[1] << 13);
        int i10 = (this.f26651d[1] >>> 9) | (this.f26651d[2] << 7);
        int i11 = (this.f26651d[3] << 2) | (this.f26651d[2] >>> 14);
        int i12 = this.f26651d[4];
        int i13 = (i10 ^ i8) ^ (i9 & i12);
        int i14 = i11 & i12;
        i9 &= i11;
        i12 &= i9;
        return (((((((i ^ ((((i9 & i8) ^ (i12 ^ (((i13 ^ i14) ^ (i12 & i8)) ^ ((i9 & i10) & i11)))) ^ ((i10 & i11) & i8)) ^ (i14 & i8))) ^ i2) ^ i3) ^ i4) ^ i5) ^ i6) ^ i7) & MinElf.PN_XNUM;
    }

    /* renamed from: a */
    private int[] m34965a(int[] iArr, int i) {
        iArr[0] = iArr[1];
        iArr[1] = iArr[2];
        iArr[2] = iArr[3];
        iArr[3] = iArr[4];
        iArr[4] = i;
        return iArr;
    }

    /* renamed from: a */
    private void m34964a(byte[] bArr, byte[] bArr2) {
        bArr2[8] = (byte) -1;
        bArr2[9] = (byte) -1;
        this.f26648a = bArr;
        this.f26649b = bArr2;
        bArr2 = null;
        for (bArr = null; bArr < this.f26652e.length; bArr++) {
            int i = bArr2 + 1;
            this.f26652e[bArr] = ((this.f26648a[i] << 8) | (this.f26648a[bArr2] & JfifUtil.MARKER_FIRST_BYTE)) & MinElf.PN_XNUM;
            this.f26651d[bArr] = ((this.f26649b[i] << 8) | (this.f26649b[bArr2] & JfifUtil.MARKER_FIRST_BYTE)) & MinElf.PN_XNUM;
            bArr2 += 2;
        }
    }

    /* renamed from: a */
    public int mo5722a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (!this.f26655h) {
            i = new StringBuilder();
            i.append(mo5749a());
            i.append(" not initialised");
            throw new IllegalStateException(i.toString());
        } else if (i + i2 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i3 + i2 <= bArr2.length) {
            for (int i4 = 0; i4 < i2; i4++) {
                bArr2[i3 + i4] = (byte) (bArr[i + i4] ^ m34971h());
            }
            return i2;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    /* renamed from: c */
    public void mo5751c() {
        this.f26654g = 2;
        m34964a(this.f26648a, this.f26649b);
        m34966b();
    }

    /* renamed from: g */
    private void m34970g() {
        this.f26653f = m34969f();
        this.f26650c[0] = (byte) this.f26653f;
        this.f26650c[1] = (byte) (this.f26653f >> 8);
        this.f26652e = m34965a(this.f26652e, m34967d() ^ this.f26651d[0]);
        this.f26651d = m34965a(this.f26651d, m34968e());
    }

    /* renamed from: a */
    public byte mo5721a(byte b) {
        if (this.f26655h) {
            return (byte) (b ^ m34971h());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(mo5749a());
        stringBuilder.append(" not initialised");
        throw new IllegalStateException(stringBuilder.toString());
    }

    /* renamed from: h */
    private byte m34971h() {
        if (this.f26654g > 1) {
            m34970g();
            this.f26654g = 0;
        }
        byte[] bArr = this.f26650c;
        int i = this.f26654g;
        this.f26654g = i + 1;
        return bArr[i];
    }
}
