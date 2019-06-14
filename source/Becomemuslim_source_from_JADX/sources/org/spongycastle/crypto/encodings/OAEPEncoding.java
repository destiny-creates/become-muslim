package org.spongycastle.crypto.encodings;

import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.params.ParametersWithRandom;

public class OAEPEncoding implements AsymmetricBlockCipher {
    /* renamed from: a */
    private byte[] f26509a;
    /* renamed from: b */
    private Digest f26510b;
    /* renamed from: c */
    private AsymmetricBlockCipher f26511c;
    /* renamed from: d */
    private SecureRandom f26512d;
    /* renamed from: e */
    private boolean f26513e;

    public OAEPEncoding(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, byte[] bArr) {
        this(asymmetricBlockCipher, digest, digest, bArr);
    }

    public OAEPEncoding(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, Digest digest2, byte[] bArr) {
        this.f26511c = asymmetricBlockCipher;
        this.f26510b = digest2;
        this.f26509a = new byte[digest.mo5732b()];
        digest.mo5733c();
        if (bArr != null) {
            digest.mo5731a(bArr, 0, bArr.length);
        }
        digest.mo5728a(this.f26509a, 0);
    }

    /* renamed from: a */
    public void mo5737a(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithRandom) {
            this.f26512d = ((ParametersWithRandom) cipherParameters).m35697a();
        } else {
            this.f26512d = new SecureRandom();
        }
        this.f26511c.mo5737a(z, cipherParameters);
        this.f26513e = z;
    }

    /* renamed from: a */
    public int mo5736a() {
        int a = this.f26511c.mo5736a();
        return this.f26513e ? (a - 1) - (this.f26509a.length * 2) : a;
    }

    /* renamed from: b */
    public int mo5739b() {
        int b = this.f26511c.mo5739b();
        if (this.f26513e) {
            return b;
        }
        return (b - 1) - (this.f26509a.length * 2);
    }

    /* renamed from: a */
    public byte[] mo5738a(byte[] bArr, int i, int i2) {
        if (this.f26513e) {
            return m34795b(bArr, i, i2);
        }
        return m34796c(bArr, i, i2);
    }

    /* renamed from: b */
    public byte[] m34795b(byte[] bArr, int i, int i2) {
        Object obj = new byte[((mo5736a() + 1) + (this.f26509a.length * 2))];
        System.arraycopy(bArr, i, obj, obj.length - i2, i2);
        obj[(obj.length - i2) - 1] = 1;
        System.arraycopy(this.f26509a, 0, obj, this.f26509a.length, this.f26509a.length);
        bArr = new byte[this.f26509a.length];
        this.f26512d.nextBytes(bArr);
        i = m34790a(bArr, 0, bArr.length, obj.length - this.f26509a.length);
        for (i2 = this.f26509a.length; i2 != obj.length; i2++) {
            obj[i2] = (byte) (obj[i2] ^ i[i2 - this.f26509a.length]);
        }
        System.arraycopy(bArr, 0, obj, 0, this.f26509a.length);
        bArr = m34790a(obj, this.f26509a.length, obj.length - this.f26509a.length, this.f26509a.length);
        for (i = 0; i != this.f26509a.length; i++) {
            obj[i] = (byte) (obj[i] ^ bArr[i]);
        }
        return this.f26511c.mo5738a(obj, 0, obj.length);
    }

    /* renamed from: c */
    public byte[] m34796c(byte[] bArr, int i, int i2) {
        bArr = this.f26511c.mo5738a(bArr, i, i2);
        if (bArr.length < this.f26511c.mo5739b()) {
            i = new byte[this.f26511c.mo5739b()];
            System.arraycopy(bArr, 0, i, i.length - bArr.length, bArr.length);
            bArr = i;
        }
        if (bArr.length >= (this.f26509a.length * 2) + 1) {
            i = m34790a(bArr, this.f26509a.length, bArr.length - this.f26509a.length, this.f26509a.length);
            for (i2 = 0; i2 != this.f26509a.length; i2++) {
                bArr[i2] = (byte) (bArr[i2] ^ i[i2]);
            }
            i = m34790a(bArr, 0, this.f26509a.length, bArr.length - this.f26509a.length);
            for (i2 = this.f26509a.length; i2 != bArr.length; i2++) {
                bArr[i2] = (byte) (bArr[i2] ^ i[i2 - this.f26509a.length]);
            }
            i2 = 0;
            for (i = 0; i != this.f26509a.length; i++) {
                if (this.f26509a[i] != bArr[this.f26509a.length + i]) {
                    i2 = 1;
                }
            }
            if (i2 == 0) {
                i = this.f26509a.length * 2;
                while (i != bArr.length) {
                    if (bArr[i] != 0) {
                        break;
                    }
                    i++;
                }
                if (i >= bArr.length - 1 || bArr[i] != 1) {
                    i2 = new StringBuilder();
                    i2.append("data start wrong ");
                    i2.append(i);
                    throw new InvalidCipherTextException(i2.toString());
                }
                i++;
                i2 = new byte[(bArr.length - i)];
                System.arraycopy(bArr, i, i2, 0, i2.length);
                return i2;
            }
            throw new InvalidCipherTextException("data hash wrong");
        }
        throw new InvalidCipherTextException("data too short");
    }

    /* renamed from: a */
    private void m34789a(int i, byte[] bArr) {
        bArr[0] = (byte) (i >>> 24);
        bArr[1] = (byte) (i >>> 16);
        bArr[2] = (byte) (i >>> 8);
        bArr[3] = (byte) (i >>> 0);
    }

    /* renamed from: a */
    private byte[] m34790a(byte[] bArr, int i, int i2, int i3) {
        Object obj = new byte[i3];
        Object obj2 = new byte[this.f26510b.mo5732b()];
        byte[] bArr2 = new byte[4];
        this.f26510b.mo5733c();
        int i4 = 0;
        while (i4 < i3 / obj2.length) {
            m34789a(i4, bArr2);
            this.f26510b.mo5731a(bArr, i, i2);
            this.f26510b.mo5731a(bArr2, 0, bArr2.length);
            this.f26510b.mo5728a(obj2, 0);
            System.arraycopy(obj2, 0, obj, obj2.length * i4, obj2.length);
            i4++;
        }
        if (obj2.length * i4 < i3) {
            m34789a(i4, bArr2);
            this.f26510b.mo5731a(bArr, i, i2);
            this.f26510b.mo5731a(bArr2, 0, bArr2.length);
            this.f26510b.mo5728a(obj2, 0);
            System.arraycopy(obj2, 0, obj, obj2.length * i4, obj.length - (i4 * obj2.length));
        }
        return obj;
    }
}
