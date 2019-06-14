package org.spongycastle.crypto.paddings;

import java.security.SecureRandom;

public class ZeroBytePadding implements BlockCipherPadding {
    /* renamed from: a */
    public void mo5785a(SecureRandom secureRandom) {
    }

    /* renamed from: a */
    public int mo5784a(byte[] bArr, int i) {
        int length = bArr.length - i;
        while (i < bArr.length) {
            bArr[i] = (byte) 0;
            i++;
        }
        return length;
    }

    /* renamed from: a */
    public int mo5783a(byte[] bArr) {
        int length = bArr.length;
        while (length > 0) {
            if (bArr[length - 1] != (byte) 0) {
                break;
            }
            length--;
        }
        return bArr.length - length;
    }
}
