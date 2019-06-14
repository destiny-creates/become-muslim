package org.spongycastle.crypto.paddings;

import java.security.SecureRandom;
import org.spongycastle.crypto.InvalidCipherTextException;

public class ISO7816d4Padding implements BlockCipherPadding {
    /* renamed from: a */
    public void mo5785a(SecureRandom secureRandom) {
    }

    /* renamed from: a */
    public int mo5784a(byte[] bArr, int i) {
        int length = bArr.length - i;
        bArr[i] = Byte.MIN_VALUE;
        for (i++; i < bArr.length; i++) {
            bArr[i] = (byte) 0;
        }
        return length;
    }

    /* renamed from: a */
    public int mo5783a(byte[] bArr) {
        int length = bArr.length - 1;
        while (length > 0 && bArr[length] == (byte) 0) {
            length--;
        }
        if (bArr[length] == Byte.MIN_VALUE) {
            return bArr.length - length;
        }
        throw new InvalidCipherTextException("pad block corrupted");
    }
}
