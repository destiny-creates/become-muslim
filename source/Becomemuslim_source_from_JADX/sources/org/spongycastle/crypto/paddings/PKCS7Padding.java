package org.spongycastle.crypto.paddings;

import com.facebook.imageutils.JfifUtil;
import java.security.SecureRandom;
import org.spongycastle.crypto.InvalidCipherTextException;

public class PKCS7Padding implements BlockCipherPadding {
    /* renamed from: a */
    public void mo5785a(SecureRandom secureRandom) {
    }

    /* renamed from: a */
    public int mo5784a(byte[] bArr, int i) {
        byte length = (byte) (bArr.length - i);
        while (i < bArr.length) {
            bArr[i] = length;
            i++;
        }
        return length;
    }

    /* renamed from: a */
    public int mo5783a(byte[] bArr) {
        int i = bArr[bArr.length - 1] & JfifUtil.MARKER_FIRST_BYTE;
        byte b = (byte) i;
        int i2 = (i > bArr.length ? 1 : 0) | (i == 0 ? 1 : 0);
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i2 |= (bArr.length - i3 <= i ? 1 : 0) & (bArr[i3] != b ? 1 : 0);
        }
        if (i2 == 0) {
            return i;
        }
        throw new InvalidCipherTextException("pad block corrupted");
    }
}
