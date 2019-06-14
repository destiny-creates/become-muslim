package org.spongycastle.crypto.paddings;

import com.facebook.imageutils.JfifUtil;
import java.security.SecureRandom;
import org.spongycastle.crypto.InvalidCipherTextException;

public class ISO10126d2Padding implements BlockCipherPadding {
    /* renamed from: a */
    SecureRandom f27061a;

    /* renamed from: a */
    public void mo5785a(SecureRandom secureRandom) {
        if (secureRandom != null) {
            this.f27061a = secureRandom;
        } else {
            this.f27061a = new SecureRandom();
        }
    }

    /* renamed from: a */
    public int mo5784a(byte[] bArr, int i) {
        byte length = (byte) (bArr.length - i);
        while (i < bArr.length - 1) {
            bArr[i] = (byte) this.f27061a.nextInt();
            i++;
        }
        bArr[i] = length;
        return length;
    }

    /* renamed from: a */
    public int mo5783a(byte[] bArr) {
        int i = bArr[bArr.length - 1] & JfifUtil.MARKER_FIRST_BYTE;
        if (i <= bArr.length) {
            return i;
        }
        throw new InvalidCipherTextException("pad block corrupted");
    }
}
