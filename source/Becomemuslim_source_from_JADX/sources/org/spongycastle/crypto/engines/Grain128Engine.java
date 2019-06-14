package org.spongycastle.crypto.engines;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

public class Grain128Engine implements StreamCipher {
    /* renamed from: a */
    private byte[] f26640a;
    /* renamed from: b */
    private byte[] f26641b;
    /* renamed from: c */
    private byte[] f26642c;
    /* renamed from: d */
    private int[] f26643d;
    /* renamed from: e */
    private int[] f26644e;
    /* renamed from: f */
    private int f26645f;
    /* renamed from: g */
    private int f26646g = 4;
    /* renamed from: h */
    private boolean f26647h = false;

    /* renamed from: a */
    public String mo5749a() {
        return "Grain-128";
    }

    /* renamed from: a */
    public void mo5750a(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            z = parametersWithIV.m35695a();
            if (!z || z.length != 12) {
                throw new IllegalArgumentException("Grain-128  requires exactly 12 bytes of IV");
            } else if (parametersWithIV.m35696b() instanceof KeyParameter) {
                KeyParameter keyParameter = (KeyParameter) parametersWithIV.m35696b();
                this.f26641b = new byte[keyParameter.m35685a().length];
                this.f26640a = new byte[keyParameter.m35685a().length];
                this.f26643d = new int[4];
                this.f26644e = new int[4];
                this.f26642c = new byte[4];
                System.arraycopy(z, 0, this.f26641b, 0, z.length);
                System.arraycopy(keyParameter.m35685a(), 0, this.f26640a, 0, keyParameter.m35685a().length);
                mo5751c();
                return;
            } else {
                throw new IllegalArgumentException("Grain-128 Init parameters must include a key");
            }
        }
        throw new IllegalArgumentException("Grain-128 Init parameters must include an IV");
    }

    /* renamed from: b */
    private void m34953b() {
        for (int i = 0; i < 8; i++) {
            this.f26645f = m34956f();
            this.f26644e = m34952a(this.f26644e, (m34954d() ^ this.f26643d[0]) ^ this.f26645f);
            this.f26643d = m34952a(this.f26643d, m34955e() ^ this.f26645f);
        }
        this.f26647h = true;
    }

    /* renamed from: d */
    private int m34954d() {
        int i = (this.f26644e[1] >>> 24) | (this.f26644e[2] << 8);
        int i2 = (this.f26644e[2] << 3) | (this.f26644e[1] >>> 29);
        int i3 = (this.f26644e[3] << 31) | (this.f26644e[2] >>> 1);
        int i4 = i2;
        int i5 = i3;
        i3 = (this.f26644e[3] << 28) | (this.f26644e[2] >>> 4);
        int i6 = i3;
        i3 = (this.f26644e[3] << 12) | (this.f26644e[2] >>> 20);
        int i7 = i3;
        i3 = (this.f26644e[3] << 5) | (this.f26644e[2] >>> 27);
        return ((((((((((this.f26644e[0] ^ ((this.f26644e[0] >>> 26) | (this.f26644e[1] << 6))) ^ i) ^ i3) ^ this.f26644e[3]) ^ (((this.f26644e[0] >>> 3) | (this.f26644e[1] << 29)) & ((this.f26644e[3] << 29) | (this.f26644e[2] >>> 3)))) ^ (((this.f26644e[0] >>> 11) | (this.f26644e[1] << 21)) & ((this.f26644e[0] >>> 13) | (this.f26644e[1] << 19)))) ^ (((this.f26644e[0] >>> 17) | (this.f26644e[1] << 15)) & ((this.f26644e[0] >>> 18) | (this.f26644e[1] << 14)))) ^ (((this.f26644e[0] >>> 27) | (this.f26644e[1] << 5)) & ((this.f26644e[2] << 5) | (this.f26644e[1] >>> 27)))) ^ (((this.f26644e[1] >>> 8) | (this.f26644e[2] << 24)) & ((this.f26644e[1] >>> 16) | (this.f26644e[2] << 16)))) ^ (i4 & i5)) ^ (i6 & i7);
    }

    /* renamed from: e */
    private int m34955e() {
        int i = (this.f26643d[1] >>> 6) | (this.f26643d[2] << 26);
        int i2 = (this.f26643d[2] >>> 6) | (this.f26643d[3] << 26);
        int i3 = (this.f26643d[2] >>> 17) | (this.f26643d[3] << 15);
        return ((((this.f26643d[0] ^ ((this.f26643d[0] >>> 7) | (this.f26643d[1] << 25))) ^ i) ^ i2) ^ i3) ^ this.f26643d[3];
    }

    /* renamed from: f */
    private int m34956f() {
        int i = (this.f26644e[0] >>> 2) | (this.f26644e[1] << 30);
        int i2 = (this.f26644e[0] >>> 12) | (this.f26644e[1] << 20);
        int i3 = (this.f26644e[0] >>> 15) | (this.f26644e[1] << 17);
        int i4 = (this.f26644e[1] >>> 4) | (this.f26644e[2] << 28);
        int i5 = (this.f26644e[1] >>> 13) | (this.f26644e[2] << 19);
        int i6 = (this.f26644e[2] >>> 31) | (this.f26644e[3] << 1);
        int i7 = (this.f26643d[1] << 19) | (this.f26643d[0] >>> 13);
        int i8 = (this.f26643d[2] << 22) | (this.f26643d[1] >>> 10);
        int i9 = (this.f26643d[2] << 4) | (this.f26643d[1] >>> 28);
        int i10 = (this.f26643d[3] << 17) | (this.f26643d[2] >>> 15);
        int i11 = (this.f26643d[3] << 3) | (this.f26643d[2] >>> 29);
        int i12 = this.f26643d[2] >>> 31;
        int i13 = ((this.f26643d[0] >>> 20) | (this.f26643d[1] << 12)) & i7;
        return ((((((i ^ (((((i13 ^ (((this.f26643d[0] >>> 8) | (this.f26643d[1] << 24)) & i2)) ^ (i8 & i6)) ^ (i10 & i9)) ^ ((i2 & i6) & ((this.f26643d[3] << 1) | i12))) ^ i11)) ^ i3) ^ i4) ^ i5) ^ this.f26644e[2]) ^ ((this.f26644e[2] >>> 9) | (this.f26644e[3] << 23))) ^ ((this.f26644e[2] >>> 25) | (this.f26644e[3] << 7));
    }

    /* renamed from: a */
    private int[] m34952a(int[] iArr, int i) {
        iArr[0] = iArr[1];
        iArr[1] = iArr[2];
        iArr[2] = iArr[3];
        iArr[3] = i;
        return iArr;
    }

    /* renamed from: a */
    private void m34951a(byte[] bArr, byte[] bArr2) {
        bArr2[12] = (byte) -1;
        bArr2[13] = (byte) -1;
        bArr2[14] = (byte) -1;
        bArr2[15] = (byte) -1;
        this.f26640a = bArr;
        this.f26641b = bArr2;
        bArr2 = null;
        for (bArr = null; bArr < this.f26644e.length; bArr++) {
            int i = bArr2 + 3;
            int i2 = bArr2 + 2;
            int i3 = bArr2 + 1;
            this.f26644e[bArr] = (((this.f26640a[i] << 24) | ((this.f26640a[i2] << 16) & 16711680)) | ((this.f26640a[i3] << 8) & 65280)) | (this.f26640a[bArr2] & JfifUtil.MARKER_FIRST_BYTE);
            this.f26643d[bArr] = (((this.f26641b[i] << 24) | ((this.f26641b[i2] << 16) & 16711680)) | ((this.f26641b[i3] << 8) & 65280)) | (this.f26641b[bArr2] & JfifUtil.MARKER_FIRST_BYTE);
            bArr2 += 4;
        }
    }

    /* renamed from: a */
    public int mo5722a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (!this.f26647h) {
            i = new StringBuilder();
            i.append(mo5749a());
            i.append(" not initialised");
            throw new IllegalStateException(i.toString());
        } else if (i + i2 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i3 + i2 <= bArr2.length) {
            for (int i4 = 0; i4 < i2; i4++) {
                bArr2[i3 + i4] = (byte) (bArr[i + i4] ^ m34958h());
            }
            return i2;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    /* renamed from: c */
    public void mo5751c() {
        this.f26646g = 4;
        m34951a(this.f26640a, this.f26641b);
        m34953b();
    }

    /* renamed from: g */
    private void m34957g() {
        this.f26645f = m34956f();
        this.f26642c[0] = (byte) this.f26645f;
        this.f26642c[1] = (byte) (this.f26645f >> 8);
        this.f26642c[2] = (byte) (this.f26645f >> 16);
        this.f26642c[3] = (byte) (this.f26645f >> 24);
        this.f26644e = m34952a(this.f26644e, m34954d() ^ this.f26643d[0]);
        this.f26643d = m34952a(this.f26643d, m34955e());
    }

    /* renamed from: a */
    public byte mo5721a(byte b) {
        if (this.f26647h) {
            return (byte) (b ^ m34958h());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(mo5749a());
        stringBuilder.append(" not initialised");
        throw new IllegalStateException(stringBuilder.toString());
    }

    /* renamed from: h */
    private byte m34958h() {
        if (this.f26646g > 3) {
            m34957g();
            this.f26646g = 0;
        }
        byte[] bArr = this.f26642c;
        int i = this.f26646g;
        this.f26646g = i + 1;
        return bArr[i];
    }
}
