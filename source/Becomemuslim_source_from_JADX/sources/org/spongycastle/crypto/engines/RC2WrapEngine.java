package org.spongycastle.crypto.engines;

import com.facebook.imageutils.JfifUtil;
import com.facebook.stetho.dumpapp.Framer;
import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Wrapper;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.util.Arrays;

public class RC2WrapEngine implements Wrapper {
    /* renamed from: i */
    private static final byte[] f26702i = new byte[]{(byte) 74, (byte) -35, (byte) -94, (byte) 44, (byte) 121, (byte) -24, Framer.ENTER_FRAME_PREFIX, (byte) 5};
    /* renamed from: a */
    Digest f26703a = new SHA1Digest();
    /* renamed from: b */
    byte[] f26704b = new byte[20];
    /* renamed from: c */
    private CBCBlockCipher f26705c;
    /* renamed from: d */
    private CipherParameters f26706d;
    /* renamed from: e */
    private ParametersWithIV f26707e;
    /* renamed from: f */
    private byte[] f26708f;
    /* renamed from: g */
    private boolean f26709g;
    /* renamed from: h */
    private SecureRandom f26710h;

    /* renamed from: a */
    public String mo5745a() {
        return "RC2";
    }

    /* renamed from: a */
    public void mo5746a(boolean z, CipherParameters cipherParameters) {
        this.f26709g = z;
        this.f26705c = new CBCBlockCipher(new RC2Engine());
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.f26710h = parametersWithRandom.m35697a();
            cipherParameters = parametersWithRandom.m35698b();
        } else {
            this.f26710h = new SecureRandom();
        }
        if (cipherParameters instanceof ParametersWithIV) {
            this.f26707e = (ParametersWithIV) cipherParameters;
            this.f26708f = this.f26707e.m35695a();
            this.f26706d = this.f26707e.m35696b();
            if (!this.f26709g) {
                throw new IllegalArgumentException("You should not supply an IV for unwrapping");
            } else if (!this.f26708f || !this.f26708f.length) {
                throw new IllegalArgumentException("IV is not 8 octets");
            } else {
                return;
            }
        }
        this.f26706d = cipherParameters;
        if (this.f26709g) {
            this.f26708f = new byte[8];
            this.f26710h.nextBytes(this.f26708f);
            this.f26707e = new ParametersWithIV(this.f26706d, this.f26708f);
        }
    }

    /* renamed from: a */
    public byte[] mo5747a(byte[] bArr, int i, int i2) {
        if (this.f26709g) {
            int i3 = i2 + 1;
            int i4 = i3 % 8;
            Object obj = new byte[(i4 != 0 ? (8 - i4) + i3 : i3)];
            int i5 = 0;
            obj[0] = (byte) i2;
            System.arraycopy(bArr, i, obj, 1, i2);
            bArr = new byte[((obj.length - i2) - 1)];
            if (bArr.length > 0) {
                this.f26710h.nextBytes(bArr);
                System.arraycopy(bArr, 0, obj, i3, bArr.length);
            }
            bArr = m35064a(obj);
            i = new byte[(obj.length + bArr.length)];
            System.arraycopy(obj, 0, i, 0, obj.length);
            System.arraycopy(bArr, 0, i, obj.length, bArr.length);
            bArr = new byte[i.length];
            System.arraycopy(i, 0, bArr, 0, i.length);
            i2 = i.length / this.f26705c.mo5743b();
            if (i.length % this.f26705c.mo5743b() == 0) {
                this.f26705c.mo5742a(true, this.f26707e);
                for (i = 0; i < i2; i++) {
                    i3 = this.f26705c.mo5743b() * i;
                    this.f26705c.mo5740a(bArr, i3, bArr, i3);
                }
                i = new byte[(this.f26708f.length + bArr.length)];
                System.arraycopy(this.f26708f, 0, i, 0, this.f26708f.length);
                System.arraycopy(bArr, 0, i, this.f26708f.length, bArr.length);
                bArr = new byte[i.length];
                i3 = 0;
                while (i3 < i.length) {
                    int i6 = i3 + 1;
                    bArr[i3] = i[i.length - i6];
                    i3 = i6;
                }
                this.f26705c.mo5742a(true, new ParametersWithIV(this.f26706d, f26702i));
                while (i5 < i2 + 1) {
                    i = this.f26705c.mo5743b() * i5;
                    this.f26705c.mo5740a(bArr, i, bArr, i);
                    i5++;
                }
                return bArr;
            }
            throw new IllegalStateException("Not multiple of block length");
        }
        throw new IllegalStateException("Not initialized for wrapping");
    }

    /* renamed from: b */
    public byte[] mo5748b(byte[] bArr, int i, int i2) {
        if (this.f26709g) {
            throw new IllegalStateException("Not set for unwrapping");
        } else if (bArr == null) {
            throw new InvalidCipherTextException("Null pointer as ciphertext");
        } else if (i2 % this.f26705c.mo5743b() == 0) {
            this.f26705c.mo5742a(false, new ParametersWithIV(this.f26706d, f26702i));
            Object obj = new byte[i2];
            System.arraycopy(bArr, i, obj, 0, i2);
            for (bArr = null; bArr < obj.length / this.f26705c.mo5743b(); bArr++) {
                i = this.f26705c.mo5743b() * bArr;
                this.f26705c.mo5740a(obj, i, obj, i);
            }
            bArr = new byte[obj.length];
            i = 0;
            while (i < obj.length) {
                int i3 = i + 1;
                bArr[i] = obj[obj.length - i3];
                i = i3;
            }
            this.f26708f = new byte[8];
            i2 = new byte[(bArr.length - 8)];
            System.arraycopy(bArr, 0, this.f26708f, 0, 8);
            System.arraycopy(bArr, 8, i2, 0, bArr.length - 8);
            this.f26707e = new ParametersWithIV(this.f26706d, this.f26708f);
            this.f26705c.mo5742a(false, this.f26707e);
            bArr = new byte[i2.length];
            System.arraycopy(i2, 0, bArr, 0, i2.length);
            for (i2 = 0; i2 < bArr.length / this.f26705c.mo5743b(); i2++) {
                int b = this.f26705c.mo5743b() * i2;
                this.f26705c.mo5740a(bArr, b, bArr, b);
            }
            byte[] bArr2 = new byte[(bArr.length - 8)];
            byte[] bArr3 = new byte[8];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length - 8);
            System.arraycopy(bArr, bArr.length - 8, bArr3, 0, 8);
            if (m35063a(bArr2, bArr3) == null) {
                throw new InvalidCipherTextException("Checksum inside ciphertext is corrupted");
            } else if (bArr2.length - ((bArr2[0] & JfifUtil.MARKER_FIRST_BYTE) + 1) <= 7) {
                bArr = new byte[bArr2[0]];
                System.arraycopy(bArr2, 1, bArr, 0, bArr.length);
                return bArr;
            } else {
                i = new StringBuilder();
                i.append("too many pad bytes (");
                i.append(bArr2.length - ((bArr2[0] & JfifUtil.MARKER_FIRST_BYTE) + 1));
                i.append(")");
                throw new InvalidCipherTextException(i.toString());
            }
        } else {
            i = new StringBuilder();
            i.append("Ciphertext not multiple of ");
            i.append(this.f26705c.mo5743b());
            throw new InvalidCipherTextException(i.toString());
        }
    }

    /* renamed from: a */
    private byte[] m35064a(byte[] bArr) {
        Object obj = new byte[8];
        this.f26703a.mo5731a(bArr, 0, bArr.length);
        this.f26703a.mo5728a(this.f26704b, 0);
        System.arraycopy(this.f26704b, 0, obj, 0, 8);
        return obj;
    }

    /* renamed from: a */
    private boolean m35063a(byte[] bArr, byte[] bArr2) {
        return Arrays.m29372b(m35064a(bArr), bArr2);
    }
}
