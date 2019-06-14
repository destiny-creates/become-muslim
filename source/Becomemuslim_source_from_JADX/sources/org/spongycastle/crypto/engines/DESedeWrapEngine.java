package org.spongycastle.crypto.engines;

import com.facebook.stetho.dumpapp.Framer;
import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Wrapper;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.util.Arrays;

public class DESedeWrapEngine implements Wrapper {
    /* renamed from: h */
    private static final byte[] f26613h = new byte[]{(byte) 74, (byte) -35, (byte) -94, (byte) 44, (byte) 121, (byte) -24, Framer.ENTER_FRAME_PREFIX, (byte) 5};
    /* renamed from: a */
    Digest f26614a = new SHA1Digest();
    /* renamed from: b */
    byte[] f26615b = new byte[20];
    /* renamed from: c */
    private CBCBlockCipher f26616c;
    /* renamed from: d */
    private KeyParameter f26617d;
    /* renamed from: e */
    private ParametersWithIV f26618e;
    /* renamed from: f */
    private byte[] f26619f;
    /* renamed from: g */
    private boolean f26620g;

    /* renamed from: a */
    public String mo5745a() {
        return "DESede";
    }

    /* renamed from: a */
    public void mo5746a(boolean z, CipherParameters cipherParameters) {
        this.f26620g = z;
        this.f26616c = new CBCBlockCipher(new DESedeEngine());
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            z = parametersWithRandom.m35698b();
            cipherParameters = parametersWithRandom.m35697a();
        } else {
            CipherParameters cipherParameters2 = cipherParameters;
            cipherParameters = new SecureRandom();
            z = cipherParameters2;
        }
        if (z instanceof KeyParameter) {
            this.f26617d = (KeyParameter) z;
            if (this.f26620g) {
                this.f26619f = new byte[8];
                cipherParameters.nextBytes(this.f26619f);
                this.f26618e = new ParametersWithIV(this.f26617d, this.f26619f);
            }
        } else if ((z instanceof ParametersWithIV) != null) {
            this.f26618e = (ParametersWithIV) z;
            this.f26619f = this.f26618e.m35695a();
            this.f26617d = (KeyParameter) this.f26618e.m35696b();
            if (!this.f26620g) {
                throw new IllegalArgumentException("You should not supply an IV for unwrapping");
            } else if (!this.f26619f || !this.f26619f.length) {
                throw new IllegalArgumentException("IV is not 8 octets");
            }
        }
    }

    /* renamed from: a */
    public byte[] mo5747a(byte[] bArr, int i, int i2) {
        if (this.f26620g) {
            Object obj = new byte[i2];
            int i3 = 0;
            System.arraycopy(bArr, i, obj, 0, i2);
            bArr = m34929a(obj);
            i = new byte[(obj.length + bArr.length)];
            System.arraycopy(obj, 0, i, 0, obj.length);
            System.arraycopy(bArr, 0, i, obj.length, bArr.length);
            bArr = this.f26616c.mo5743b();
            if (i.length % bArr == 0) {
                this.f26616c.mo5742a(true, this.f26618e);
                i2 = new byte[i.length];
                for (int i4 = 0; i4 != i.length; i4 += bArr) {
                    this.f26616c.mo5740a(i, i4, i2, i4);
                }
                i = new byte[(this.f26619f.length + i2.length)];
                System.arraycopy(this.f26619f, 0, i, 0, this.f26619f.length);
                System.arraycopy(i2, 0, i, this.f26619f.length, i2.length);
                i = m34930b(i);
                this.f26616c.mo5742a(true, new ParametersWithIV(this.f26617d, f26613h));
                while (i3 != i.length) {
                    this.f26616c.mo5740a(i, i3, i, i3);
                    i3 += bArr;
                }
                return i;
            }
            throw new IllegalStateException("Not multiple of block length");
        }
        throw new IllegalStateException("Not initialized for wrapping");
    }

    /* renamed from: b */
    public byte[] mo5748b(byte[] bArr, int i, int i2) {
        if (this.f26620g) {
            throw new IllegalStateException("Not set for unwrapping");
        } else if (bArr != null) {
            int b = this.f26616c.mo5743b();
            if (i2 % b == 0) {
                this.f26616c.mo5742a(false, new ParametersWithIV(this.f26617d, f26613h));
                byte[] bArr2 = new byte[i2];
                for (int i3 = 0; i3 != i2; i3 += b) {
                    this.f26616c.mo5740a(bArr, i + i3, bArr2, i3);
                }
                bArr = m34930b(bArr2);
                this.f26619f = new byte[8];
                i2 = new byte[(bArr.length - 8)];
                System.arraycopy(bArr, 0, this.f26619f, 0, 8);
                System.arraycopy(bArr, 8, i2, 0, bArr.length - 8);
                this.f26618e = new ParametersWithIV(this.f26617d, this.f26619f);
                this.f26616c.mo5742a(false, this.f26618e);
                bArr = new byte[i2.length];
                for (int i4 = 0; i4 != bArr.length; i4 += b) {
                    this.f26616c.mo5740a(i2, i4, bArr, i4);
                }
                byte[] bArr3 = new byte[(bArr.length - 8)];
                byte[] bArr4 = new byte[8];
                System.arraycopy(bArr, 0, bArr3, 0, bArr.length - 8);
                System.arraycopy(bArr, bArr.length - 8, bArr4, 0, 8);
                if (m34928a(bArr3, bArr4) != null) {
                    return bArr3;
                }
                throw new InvalidCipherTextException("Checksum inside ciphertext is corrupted");
            }
            i = new StringBuilder();
            i.append("Ciphertext not multiple of ");
            i.append(b);
            throw new InvalidCipherTextException(i.toString());
        } else {
            throw new InvalidCipherTextException("Null pointer as ciphertext");
        }
    }

    /* renamed from: a */
    private byte[] m34929a(byte[] bArr) {
        Object obj = new byte[8];
        this.f26614a.mo5731a(bArr, 0, bArr.length);
        this.f26614a.mo5728a(this.f26615b, 0);
        System.arraycopy(this.f26615b, 0, obj, 0, 8);
        return obj;
    }

    /* renamed from: a */
    private boolean m34928a(byte[] bArr, byte[] bArr2) {
        return Arrays.m29372b(m34929a(bArr), bArr2);
    }

    /* renamed from: b */
    private static byte[] m34930b(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int i = 0;
        while (i < bArr.length) {
            int i2 = i + 1;
            bArr2[i] = bArr[bArr.length - i2];
            i = i2;
        }
        return bArr2;
    }
}
