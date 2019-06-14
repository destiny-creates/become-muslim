package org.spongycastle.crypto.paddings;

import com.facebook.imageutils.JfifUtil;
import java.security.SecureRandom;

public class TBCPadding implements BlockCipherPadding {
    /* renamed from: a */
    public void mo5785a(SecureRandom secureRandom) {
    }

    /* renamed from: a */
    public int mo5784a(byte[] bArr, int i) {
        byte b;
        int length = bArr.length - i;
        int i2 = 0;
        if (i > 0) {
            if ((bArr[i - 1] & 1) == 0) {
                i2 = JfifUtil.MARKER_FIRST_BYTE;
            }
            b = (byte) i2;
        } else {
            if ((bArr[bArr.length - 1] & 1) == 0) {
                i2 = JfifUtil.MARKER_FIRST_BYTE;
            }
            b = (byte) i2;
        }
        while (i < bArr.length) {
            bArr[i] = b;
            i++;
        }
        return length;
    }

    /* renamed from: a */
    public int mo5783a(byte[] bArr) {
        byte b = bArr[bArr.length - 1];
        int length = bArr.length - 1;
        while (length > 0 && bArr[length - 1] == b) {
            length--;
        }
        return bArr.length - length;
    }
}
