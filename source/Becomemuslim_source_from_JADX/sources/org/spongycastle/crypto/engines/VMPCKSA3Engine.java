package org.spongycastle.crypto.engines;

import com.facebook.imageutils.JfifUtil;

public class VMPCKSA3Engine extends VMPCEngine {
    /* renamed from: a */
    public String mo5749a() {
        return "VMPC-KSA3";
    }

    /* renamed from: a */
    protected void mo6452a(byte[] bArr, byte[] bArr2) {
        int i;
        this.c = (byte) 0;
        this.b = new byte[256];
        for (int i2 = 0; i2 < 256; i2++) {
            this.b[i2] = (byte) i2;
        }
        for (i = 0; i < 768; i++) {
            int i3 = i & JfifUtil.MARKER_FIRST_BYTE;
            this.c = this.b[((this.c + this.b[i3]) + bArr[i % bArr.length]) & JfifUtil.MARKER_FIRST_BYTE];
            byte b = this.b[i3];
            this.b[i3] = this.b[this.c & JfifUtil.MARKER_FIRST_BYTE];
            this.b[this.c & JfifUtil.MARKER_FIRST_BYTE] = b;
        }
        for (i = 0; i < 768; i++) {
            int i4 = i & JfifUtil.MARKER_FIRST_BYTE;
            this.c = this.b[((this.c + this.b[i4]) + bArr2[i % bArr2.length]) & JfifUtil.MARKER_FIRST_BYTE];
            byte b2 = this.b[i4];
            this.b[i4] = this.b[this.c & JfifUtil.MARKER_FIRST_BYTE];
            this.b[this.c & JfifUtil.MARKER_FIRST_BYTE] = b2;
        }
        for (bArr2 = null; bArr2 < 768; bArr2++) {
            i3 = bArr2 & JfifUtil.MARKER_FIRST_BYTE;
            this.c = this.b[((this.c + this.b[i3]) + bArr[bArr2 % bArr.length]) & JfifUtil.MARKER_FIRST_BYTE];
            byte b3 = this.b[i3];
            this.b[i3] = this.b[this.c & JfifUtil.MARKER_FIRST_BYTE];
            this.b[this.c & JfifUtil.MARKER_FIRST_BYTE] = b3;
        }
        this.a = (byte) 0;
    }
}
