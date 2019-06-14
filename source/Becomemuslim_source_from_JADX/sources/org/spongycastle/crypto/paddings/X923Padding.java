package org.spongycastle.crypto.paddings;

import com.facebook.imageutils.JfifUtil;
import java.security.SecureRandom;
import org.spongycastle.crypto.InvalidCipherTextException;

public class X923Padding implements BlockCipherPadding {
    /* renamed from: a */
    SecureRandom f27063a = null;

    /* renamed from: a */
    public void mo5785a(SecureRandom secureRandom) {
        this.f27063a = secureRandom;
    }

    /* renamed from: a */
    public int mo5784a(byte[] bArr, int i) {
        byte length = (byte) (bArr.length - i);
        while (i < bArr.length - 1) {
            if (this.f27063a == null) {
                bArr[i] = (byte) 0;
            } else {
                bArr[i] = (byte) this.f27063a.nextInt();
            }
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
