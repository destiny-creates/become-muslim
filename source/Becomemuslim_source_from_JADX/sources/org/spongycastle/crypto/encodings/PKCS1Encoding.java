package org.spongycastle.crypto.encodings;

import com.facebook.internal.ServerProtocol;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ParametersWithRandom;

public class PKCS1Encoding implements AsymmetricBlockCipher {
    /* renamed from: a */
    private SecureRandom f26514a;
    /* renamed from: b */
    private AsymmetricBlockCipher f26515b;
    /* renamed from: c */
    private boolean f26516c;
    /* renamed from: d */
    private boolean f26517d;
    /* renamed from: e */
    private boolean f26518e;
    /* renamed from: f */
    private int f26519f = -1;
    /* renamed from: g */
    private byte[] f26520g = null;

    /* renamed from: org.spongycastle.crypto.encodings.PKCS1Encoding$1 */
    class C66771 implements PrivilegedAction {
        /* renamed from: a */
        final /* synthetic */ PKCS1Encoding f22310a;

        C66771(PKCS1Encoding pKCS1Encoding) {
            this.f22310a = pKCS1Encoding;
        }

        public Object run() {
            return System.getProperty("org.spongycastle.pkcs1.strict");
        }
    }

    /* renamed from: org.spongycastle.crypto.encodings.PKCS1Encoding$2 */
    class C66782 implements PrivilegedAction {
        /* renamed from: a */
        final /* synthetic */ PKCS1Encoding f22311a;

        C66782(PKCS1Encoding pKCS1Encoding) {
            this.f22311a = pKCS1Encoding;
        }

        public Object run() {
            return System.getProperty("org.spongycastle.pkcs1.not_strict");
        }
    }

    public PKCS1Encoding(AsymmetricBlockCipher asymmetricBlockCipher) {
        this.f26515b = asymmetricBlockCipher;
        this.f26518e = m34799c();
    }

    public PKCS1Encoding(AsymmetricBlockCipher asymmetricBlockCipher, byte[] bArr) {
        this.f26515b = asymmetricBlockCipher;
        this.f26518e = m34799c();
        this.f26520g = bArr;
        this.f26519f = bArr.length;
    }

    /* renamed from: c */
    private boolean m34799c() {
        String str = (String) AccessController.doPrivileged(new C66771(this));
        String str2 = (String) AccessController.doPrivileged(new C66782(this));
        boolean z = true;
        if (str2 != null) {
            return str2.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE) ^ true;
        }
        if (str != null) {
            if (!str.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                z = false;
            }
        }
        return z;
    }

    /* renamed from: a */
    public void mo5737a(boolean z, CipherParameters cipherParameters) {
        AsymmetricKeyParameter asymmetricKeyParameter;
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.f26514a = parametersWithRandom.m35697a();
            asymmetricKeyParameter = (AsymmetricKeyParameter) parametersWithRandom.m35698b();
        } else {
            asymmetricKeyParameter = (AsymmetricKeyParameter) cipherParameters;
            if (!asymmetricKeyParameter.m35630a() && z) {
                this.f26514a = new SecureRandom();
            }
        }
        this.f26515b.mo5737a(z, cipherParameters);
        this.f26517d = asymmetricKeyParameter.m35630a();
        this.f26516c = z;
    }

    /* renamed from: a */
    public int mo5736a() {
        int a = this.f26515b.mo5736a();
        return this.f26516c ? a - 10 : a;
    }

    /* renamed from: b */
    public int mo5739b() {
        int b = this.f26515b.mo5739b();
        return this.f26516c ? b : b - 10;
    }

    /* renamed from: a */
    public byte[] mo5738a(byte[] bArr, int i, int i2) {
        if (this.f26516c) {
            return m34798b(bArr, i, i2);
        }
        return m34801d(bArr, i, i2);
    }

    /* renamed from: b */
    private byte[] m34798b(byte[] bArr, int i, int i2) {
        if (i2 <= mo5736a()) {
            Object obj = new byte[this.f26515b.mo5736a()];
            int i3;
            if (this.f26517d) {
                obj[0] = 1;
                for (i3 = 1; i3 != (obj.length - i2) - 1; i3++) {
                    obj[i3] = (byte) -1;
                }
            } else {
                this.f26514a.nextBytes(obj);
                obj[0] = (byte) 2;
                for (i3 = 1; i3 != (obj.length - i2) - 1; i3++) {
                    while (obj[i3] == (byte) 0) {
                        obj[i3] = (byte) this.f26514a.nextInt();
                    }
                }
            }
            obj[(obj.length - i2) - 1] = null;
            System.arraycopy(bArr, i, obj, obj.length - i2, i2);
            return this.f26515b.mo5738a(obj, 0, obj.length);
        }
        throw new IllegalArgumentException("input data too large");
    }

    /* renamed from: a */
    private static int m34797a(byte[] bArr, int i) {
        i++;
        int length = bArr.length - i;
        int i2 = 0 | (bArr[0] ^ 2);
        for (int i3 = 1; i3 < length; i3++) {
            byte b = bArr[i3];
            int i4 = b | (b >> 1);
            i4 |= i4 >> 2;
            i2 |= ((i4 | (i4 >> 4)) & 1) - 1;
        }
        bArr = bArr[bArr.length - i] | i2;
        bArr |= bArr >> 1;
        bArr |= bArr >> 2;
        return ~(((bArr | (bArr >> 4)) & 1) - 1);
    }

    /* renamed from: c */
    private byte[] m34800c(byte[] bArr, int i, int i2) {
        if (this.f26517d) {
            bArr = this.f26515b.mo5738a(bArr, i, i2);
            if (this.f26520g == 0) {
                i = new byte[this.f26519f];
                this.f26514a.nextBytes(i);
            } else {
                i = this.f26520g;
            }
            if (bArr.length >= mo5739b()) {
                if (this.f26518e != 0) {
                    if (bArr.length != this.f26515b.mo5739b()) {
                        throw new InvalidCipherTextException("block incorrect size");
                    }
                }
                i2 = m34797a(bArr, this.f26519f);
                byte[] bArr2 = new byte[this.f26519f];
                for (int i3 = 0; i3 < this.f26519f; i3++) {
                    bArr2[i3] = (byte) ((bArr[(bArr.length - this.f26519f) + i3] & (~i2)) | (i[i3] & i2));
                }
                return bArr2;
            }
            throw new InvalidCipherTextException("block truncated");
        }
        throw new InvalidCipherTextException("sorry, this method is only for decryption, not for signing");
    }

    /* renamed from: d */
    private byte[] m34801d(byte[] bArr, int i, int i2) {
        if (this.f26519f != -1) {
            return m34800c(bArr, i, i2);
        }
        bArr = this.f26515b.mo5738a(bArr, i, i2);
        if (bArr.length >= mo5739b()) {
            i2 = bArr[0];
            if (this.f26517d) {
                if (i2 != 2) {
                    throw new InvalidCipherTextException("unknown block type");
                }
            } else if (i2 != 1) {
                throw new InvalidCipherTextException("unknown block type");
            }
            if (this.f26518e) {
                if (bArr.length != this.f26515b.mo5739b()) {
                    throw new InvalidCipherTextException("block incorrect size");
                }
            }
            int i3 = 1;
            while (i3 != bArr.length) {
                byte b = bArr[i3];
                if (b == (byte) 0) {
                    break;
                }
                if (i2 == 1) {
                    if (b != (byte) -1) {
                        throw new InvalidCipherTextException("block padding incorrect");
                    }
                }
                i3++;
            }
            i3++;
            if (i3 > bArr.length || i3 < 10) {
                throw new InvalidCipherTextException("no data in block");
            }
            i2 = new byte[(bArr.length - i3)];
            System.arraycopy(bArr, i3, i2, 0, i2.length);
            return i2;
        }
        throw new InvalidCipherTextException("block truncated");
    }
}
