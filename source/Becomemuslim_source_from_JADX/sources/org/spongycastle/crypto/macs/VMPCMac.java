package org.spongycastle.crypto.macs;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

public class VMPCMac implements Mac {
    /* renamed from: a */
    private byte f26954a;
    /* renamed from: b */
    private byte f26955b = (byte) 0;
    /* renamed from: c */
    private byte[] f26956c = null;
    /* renamed from: d */
    private byte f26957d = (byte) 0;
    /* renamed from: e */
    private byte[] f26958e;
    /* renamed from: f */
    private byte[] f26959f;
    /* renamed from: g */
    private byte[] f26960g;
    /* renamed from: h */
    private byte f26961h;
    /* renamed from: i */
    private byte f26962i;
    /* renamed from: j */
    private byte f26963j;
    /* renamed from: k */
    private byte f26964k;

    /* renamed from: a */
    public String mo5762a() {
        return "VMPC-MAC";
    }

    /* renamed from: b */
    public int mo5766b() {
        return 20;
    }

    /* renamed from: a */
    public int mo5761a(byte[] bArr, int i) {
        for (int i2 = 1; i2 < 25; i2++) {
            this.f26957d = this.f26956c[(this.f26957d + this.f26956c[this.f26955b & JfifUtil.MARKER_FIRST_BYTE]) & JfifUtil.MARKER_FIRST_BYTE];
            this.f26964k = this.f26956c[((this.f26964k + this.f26963j) + i2) & JfifUtil.MARKER_FIRST_BYTE];
            this.f26963j = this.f26956c[((this.f26963j + this.f26962i) + i2) & JfifUtil.MARKER_FIRST_BYTE];
            this.f26962i = this.f26956c[((this.f26962i + this.f26961h) + i2) & JfifUtil.MARKER_FIRST_BYTE];
            this.f26961h = this.f26956c[((this.f26961h + this.f26957d) + i2) & JfifUtil.MARKER_FIRST_BYTE];
            this.f26958e[this.f26954a & 31] = (byte) (this.f26958e[this.f26954a & 31] ^ this.f26961h);
            this.f26958e[(this.f26954a + 1) & 31] = (byte) (this.f26958e[(this.f26954a + 1) & 31] ^ this.f26962i);
            this.f26958e[(this.f26954a + 2) & 31] = (byte) (this.f26958e[(this.f26954a + 2) & 31] ^ this.f26963j);
            this.f26958e[(this.f26954a + 3) & 31] = (byte) (this.f26958e[(this.f26954a + 3) & 31] ^ this.f26964k);
            this.f26954a = (byte) ((this.f26954a + 4) & 31);
            byte b = this.f26956c[this.f26955b & JfifUtil.MARKER_FIRST_BYTE];
            this.f26956c[this.f26955b & JfifUtil.MARKER_FIRST_BYTE] = this.f26956c[this.f26957d & JfifUtil.MARKER_FIRST_BYTE];
            this.f26956c[this.f26957d & JfifUtil.MARKER_FIRST_BYTE] = b;
            this.f26955b = (byte) ((this.f26955b + 1) & JfifUtil.MARKER_FIRST_BYTE);
        }
        for (int i3 = 0; i3 < 768; i3++) {
            int i4 = i3 & JfifUtil.MARKER_FIRST_BYTE;
            this.f26957d = this.f26956c[((this.f26957d + this.f26956c[i4]) + this.f26958e[i3 & 31]) & JfifUtil.MARKER_FIRST_BYTE];
            byte b2 = this.f26956c[i4];
            this.f26956c[i4] = this.f26956c[this.f26957d & JfifUtil.MARKER_FIRST_BYTE];
            this.f26956c[this.f26957d & JfifUtil.MARKER_FIRST_BYTE] = b2;
        }
        Object obj = new byte[20];
        for (int i5 = 0; i5 < 20; i5++) {
            int i6 = i5 & JfifUtil.MARKER_FIRST_BYTE;
            this.f26957d = this.f26956c[(this.f26957d + this.f26956c[i6]) & JfifUtil.MARKER_FIRST_BYTE];
            obj[i5] = this.f26956c[(this.f26956c[this.f26956c[this.f26957d & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE] + 1) & JfifUtil.MARKER_FIRST_BYTE];
            byte b3 = this.f26956c[i6];
            this.f26956c[i6] = this.f26956c[this.f26957d & JfifUtil.MARKER_FIRST_BYTE];
            this.f26956c[this.f26957d & JfifUtil.MARKER_FIRST_BYTE] = b3;
        }
        System.arraycopy(obj, 0, bArr, i, obj.length);
        mo5767c();
        return obj.length;
    }

    /* renamed from: a */
    public void mo5764a(CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            KeyParameter keyParameter = (KeyParameter) parametersWithIV.m35696b();
            if (parametersWithIV.m35696b() instanceof KeyParameter) {
                this.f26959f = parametersWithIV.m35695a();
                if (this.f26959f == null || this.f26959f.length < 1 || this.f26959f.length > 768) {
                    throw new IllegalArgumentException("VMPC-MAC requires 1 to 768 bytes of IV");
                }
                this.f26960g = keyParameter.m35685a();
                mo5767c();
                return;
            }
            throw new IllegalArgumentException("VMPC-MAC Init parameters must include a key");
        }
        throw new IllegalArgumentException("VMPC-MAC Init parameters must include an IV");
    }

    /* renamed from: a */
    private void m35480a(byte[] bArr, byte[] bArr2) {
        this.f26957d = (byte) 0;
        this.f26956c = new byte[256];
        for (int i = 0; i < 256; i++) {
            this.f26956c[i] = (byte) i;
        }
        for (int i2 = 0; i2 < 768; i2++) {
            int i3 = i2 & JfifUtil.MARKER_FIRST_BYTE;
            this.f26957d = this.f26956c[((this.f26957d + this.f26956c[i3]) + bArr[i2 % bArr.length]) & JfifUtil.MARKER_FIRST_BYTE];
            byte b = this.f26956c[i3];
            this.f26956c[i3] = this.f26956c[this.f26957d & JfifUtil.MARKER_FIRST_BYTE];
            this.f26956c[this.f26957d & JfifUtil.MARKER_FIRST_BYTE] = b;
        }
        for (bArr = null; bArr < 768; bArr++) {
            i3 = bArr & JfifUtil.MARKER_FIRST_BYTE;
            this.f26957d = this.f26956c[((this.f26957d + this.f26956c[i3]) + bArr2[bArr % bArr2.length]) & JfifUtil.MARKER_FIRST_BYTE];
            byte b2 = this.f26956c[i3];
            this.f26956c[i3] = this.f26956c[this.f26957d & JfifUtil.MARKER_FIRST_BYTE];
            this.f26956c[this.f26957d & JfifUtil.MARKER_FIRST_BYTE] = b2;
        }
        this.f26955b = (byte) 0;
    }

    /* renamed from: c */
    public void mo5767c() {
        m35480a(this.f26960g, this.f26959f);
        this.f26955b = (byte) 0;
        this.f26964k = (byte) 0;
        this.f26963j = (byte) 0;
        this.f26962i = (byte) 0;
        this.f26961h = (byte) 0;
        this.f26954a = (byte) 0;
        this.f26958e = new byte[32];
        for (int i = 0; i < 32; i++) {
            this.f26958e[i] = (byte) 0;
        }
    }

    /* renamed from: a */
    public void mo5763a(byte b) {
        this.f26957d = this.f26956c[(this.f26957d + this.f26956c[this.f26955b & JfifUtil.MARKER_FIRST_BYTE]) & JfifUtil.MARKER_FIRST_BYTE];
        b = (byte) (b ^ this.f26956c[(this.f26956c[this.f26956c[this.f26957d & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE] + 1) & JfifUtil.MARKER_FIRST_BYTE]);
        this.f26964k = this.f26956c[(this.f26964k + this.f26963j) & JfifUtil.MARKER_FIRST_BYTE];
        this.f26963j = this.f26956c[(this.f26963j + this.f26962i) & JfifUtil.MARKER_FIRST_BYTE];
        this.f26962i = this.f26956c[(this.f26962i + this.f26961h) & JfifUtil.MARKER_FIRST_BYTE];
        this.f26961h = this.f26956c[((this.f26961h + this.f26957d) + b) & JfifUtil.MARKER_FIRST_BYTE];
        this.f26958e[this.f26954a & 31] = (byte) (this.f26958e[this.f26954a & 31] ^ this.f26961h);
        this.f26958e[(this.f26954a + 1) & 31] = (byte) (this.f26958e[(this.f26954a + 1) & 31] ^ this.f26962i);
        this.f26958e[(this.f26954a + 2) & 31] = (byte) (this.f26958e[(this.f26954a + 2) & 31] ^ this.f26963j);
        this.f26958e[(this.f26954a + 3) & 31] = (byte) (this.f26958e[(this.f26954a + 3) & 31] ^ this.f26964k);
        this.f26954a = (byte) ((this.f26954a + 4) & 31);
        b = this.f26956c[this.f26955b & JfifUtil.MARKER_FIRST_BYTE];
        this.f26956c[this.f26955b & JfifUtil.MARKER_FIRST_BYTE] = this.f26956c[this.f26957d & JfifUtil.MARKER_FIRST_BYTE];
        this.f26956c[this.f26957d & JfifUtil.MARKER_FIRST_BYTE] = b;
        this.f26955b = (byte) ((this.f26955b + 1) & JfifUtil.MARKER_FIRST_BYTE);
    }

    /* renamed from: a */
    public void mo5765a(byte[] bArr, int i, int i2) {
        if (i + i2 <= bArr.length) {
            for (i = 0; i < i2; i++) {
                mo5763a(bArr[i]);
            }
            return;
        }
        throw new DataLengthException("input buffer too short");
    }
}
