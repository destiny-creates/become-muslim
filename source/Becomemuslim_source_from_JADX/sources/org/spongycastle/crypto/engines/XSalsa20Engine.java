package org.spongycastle.crypto.engines;

import org.spongycastle.util.Pack;

public class XSalsa20Engine extends Salsa20Engine {
    /* renamed from: a */
    public String mo5749a() {
        return "XSalsa20";
    }

    /* renamed from: h */
    protected int mo6804h() {
        return 24;
    }

    /* renamed from: a */
    protected void mo6797a(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            bArr2 = new StringBuilder();
            bArr2.append(mo5749a());
            bArr2.append(" doesn't support re-init with null key");
            throw new IllegalArgumentException(bArr2.toString());
        } else if (bArr.length == 32) {
            super.mo6797a(bArr, bArr2);
            this.d[8] = Pack.m29411c(bArr2, 8);
            this.d[9] = Pack.m29411c(bArr2, 12);
            bArr = new int[this.d.length];
            Salsa20Engine.m40706b(20, this.d, bArr);
            this.d[1] = bArr[0] - this.d[0];
            this.d[2] = bArr[5] - this.d[5];
            this.d[3] = bArr[10] - this.d[10];
            this.d[4] = bArr[15] - this.d[15];
            this.d[11] = bArr[6] - this.d[6];
            this.d[12] = bArr[7] - this.d[7];
            this.d[13] = bArr[8] - this.d[8];
            this.d[14] = bArr[9] - this.d[9];
            this.d[6] = Pack.m29411c(bArr2, 16);
            this.d[7] = Pack.m29411c(bArr2, 20);
        } else {
            bArr2 = new StringBuilder();
            bArr2.append(mo5749a());
            bArr2.append(" requires a 256 bit key");
            throw new IllegalArgumentException(bArr2.toString());
        }
    }
}
