package org.spongycastle.crypto.engines;

import com.facebook.imageutils.JfifUtil;
import java.security.SecureRandom;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Wrapper;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.params.ParametersWithRandom;

public class RFC3211WrapEngine implements Wrapper {
    /* renamed from: a */
    private CBCBlockCipher f26723a;
    /* renamed from: b */
    private ParametersWithIV f26724b;
    /* renamed from: c */
    private boolean f26725c;
    /* renamed from: d */
    private SecureRandom f26726d;

    public RFC3211WrapEngine(BlockCipher blockCipher) {
        this.f26723a = new CBCBlockCipher(blockCipher);
    }

    /* renamed from: a */
    public void mo5746a(boolean z, CipherParameters cipherParameters) {
        this.f26725c = z;
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.f26726d = parametersWithRandom.m35697a();
            this.f26724b = (ParametersWithIV) parametersWithRandom.m35698b();
            return;
        }
        if (z) {
            this.f26726d = new SecureRandom();
        }
        this.f26724b = (ParametersWithIV) cipherParameters;
    }

    /* renamed from: a */
    public String mo5745a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f26723a.m35495d().mo5741a());
        stringBuilder.append("/RFC3211Wrap");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public byte[] mo5747a(byte[] bArr, int i, int i2) {
        if (this.f26725c) {
            Object obj;
            this.f26723a.mo5742a(true, this.f26724b);
            int b = this.f26723a.mo5743b();
            int i3 = i2 + 4;
            int i4 = b * 2;
            if (i3 < i4) {
                obj = new byte[i4];
            } else {
                obj = new byte[(i3 % b == 0 ? i3 : ((i3 / b) + 1) * b)];
            }
            int i5 = 0;
            obj[0] = (byte) i2;
            obj[1] = (byte) (~bArr[i]);
            obj[2] = (byte) (~bArr[i + 1]);
            obj[3] = (byte) (~bArr[i + 2]);
            System.arraycopy(bArr, i, obj, 4, i2);
            bArr = new byte[(obj.length - i3)];
            this.f26726d.nextBytes(bArr);
            System.arraycopy(bArr, 0, obj, i3, bArr.length);
            for (bArr = null; bArr < obj.length; bArr += b) {
                this.f26723a.mo5740a(obj, bArr, obj, bArr);
            }
            while (i5 < obj.length) {
                this.f26723a.mo5740a(obj, i5, obj, i5);
                i5 += b;
            }
            return obj;
        }
        throw new IllegalStateException("not set for wrapping");
    }

    /* renamed from: b */
    public byte[] mo5748b(byte[] bArr, int i, int i2) {
        if (this.f26725c) {
            throw new IllegalStateException("not set for unwrapping");
        }
        int b = this.f26723a.mo5743b();
        if (i2 >= b * 2) {
            Object obj = new byte[i2];
            Object obj2 = new byte[b];
            int i3 = 0;
            System.arraycopy(bArr, i, obj, 0, i2);
            System.arraycopy(bArr, i, obj2, 0, obj2.length);
            this.f26723a.mo5742a(false, new ParametersWithIV(this.f26724b.m35696b(), obj2));
            for (bArr = b; bArr < obj.length; bArr += b) {
                this.f26723a.mo5740a(obj, bArr, obj, bArr);
            }
            System.arraycopy(obj, obj.length - obj2.length, obj2, 0, obj2.length);
            this.f26723a.mo5742a(false, new ParametersWithIV(this.f26724b.m35696b(), obj2));
            this.f26723a.mo5740a(obj, 0, obj, 0);
            this.f26723a.mo5742a(false, this.f26724b);
            for (bArr = null; bArr < obj.length; bArr += b) {
                this.f26723a.mo5740a(obj, bArr, obj, bArr);
            }
            if ((obj[0] & JfifUtil.MARKER_FIRST_BYTE) <= obj.length - 4) {
                bArr = new byte[(obj[0] & JfifUtil.MARKER_FIRST_BYTE)];
                System.arraycopy(obj, 4, bArr, 0, obj[0]);
                i = 0;
                while (i3 != 3) {
                    i2 = i3 + 1;
                    i |= ((byte) (~obj[i2])) ^ bArr[i3];
                    i3 = i2;
                }
                if (i == 0) {
                    return bArr;
                }
                throw new InvalidCipherTextException("wrapped key fails checksum");
            }
            throw new InvalidCipherTextException("wrapped key corrupted");
        }
        throw new InvalidCipherTextException("input too short");
    }
}
