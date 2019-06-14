package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Wrapper;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.util.Arrays;

public class RFC3394WrapEngine implements Wrapper {
    /* renamed from: a */
    private BlockCipher f26727a;
    /* renamed from: b */
    private boolean f26728b;
    /* renamed from: c */
    private KeyParameter f26729c;
    /* renamed from: d */
    private boolean f26730d;
    /* renamed from: e */
    private byte[] f26731e;

    public RFC3394WrapEngine(BlockCipher blockCipher) {
        this(blockCipher, false);
    }

    public RFC3394WrapEngine(BlockCipher blockCipher, boolean z) {
        this.f26731e = new byte[]{(byte) -90, (byte) -90, (byte) -90, (byte) -90, (byte) -90, (byte) -90, (byte) -90, (byte) -90};
        this.f26727a = blockCipher;
        this.f26728b = z ^ 1;
    }

    /* renamed from: a */
    public void mo5746a(boolean z, CipherParameters cipherParameters) {
        this.f26730d = z;
        if (cipherParameters instanceof ParametersWithRandom) {
            cipherParameters = ((ParametersWithRandom) cipherParameters).m35698b();
        }
        if (cipherParameters instanceof KeyParameter) {
            this.f26729c = (KeyParameter) cipherParameters;
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.f26731e = parametersWithIV.m35695a();
            this.f26729c = (KeyParameter) parametersWithIV.m35696b();
            if (!this.f26731e.length) {
                throw new IllegalArgumentException("IV not equal to 8");
            }
        }
    }

    /* renamed from: a */
    public String mo5745a() {
        return this.f26727a.mo5741a();
    }

    /* renamed from: a */
    public byte[] mo5747a(byte[] bArr, int i, int i2) {
        if (this.f26730d) {
            int i3 = i2 / 8;
            if (i3 * 8 == i2) {
                Object obj = new byte[(this.f26731e.length + i2)];
                Object obj2 = new byte[(this.f26731e.length + 8)];
                System.arraycopy(this.f26731e, 0, obj, 0, this.f26731e.length);
                System.arraycopy(bArr, i, obj, this.f26731e.length, i2);
                this.f26727a.mo5742a(this.f26728b, this.f26729c);
                for (bArr = null; bArr != 6; bArr++) {
                    for (i2 = 1; i2 <= i3; i2++) {
                        System.arraycopy(obj, 0, obj2, 0, this.f26731e.length);
                        int i4 = i2 * 8;
                        System.arraycopy(obj, i4, obj2, this.f26731e.length, 8);
                        this.f26727a.mo5740a(obj2, 0, obj2, 0);
                        int i5 = (i3 * bArr) + i2;
                        int i6 = 1;
                        while (i5 != 0) {
                            int length = this.f26731e.length - i6;
                            obj2[length] = (byte) (((byte) i5) ^ obj2[length]);
                            i5 >>>= 8;
                            i6++;
                        }
                        System.arraycopy(obj2, 0, obj, 0, 8);
                        System.arraycopy(obj2, 8, obj, i4, 8);
                    }
                }
                return obj;
            }
            throw new DataLengthException("wrap data must be a multiple of 8 bytes");
        }
        throw new IllegalStateException("not set for wrapping");
    }

    /* renamed from: b */
    public byte[] mo5748b(byte[] bArr, int i, int i2) {
        if (this.f26730d) {
            throw new IllegalStateException("not set for unwrapping");
        }
        int i3 = i2 / 8;
        if (i3 * 8 == i2) {
            Object obj = new byte[(i2 - this.f26731e.length)];
            byte[] bArr2 = new byte[this.f26731e.length];
            Object obj2 = new byte[(this.f26731e.length + 8)];
            System.arraycopy(bArr, i, bArr2, 0, this.f26731e.length);
            System.arraycopy(bArr, i + this.f26731e.length, obj, 0, i2 - this.f26731e.length);
            this.f26727a.mo5742a(this.f26728b ^ 1, this.f26729c);
            i3--;
            for (bArr = 5; bArr >= null; bArr--) {
                for (i = i3; i >= 1; i--) {
                    System.arraycopy(bArr2, 0, obj2, 0, this.f26731e.length);
                    int i4 = (i - 1) * 8;
                    System.arraycopy(obj, i4, obj2, this.f26731e.length, 8);
                    int i5 = (i3 * bArr) + i;
                    int i6 = 1;
                    while (i5 != 0) {
                        int length = this.f26731e.length - i6;
                        obj2[length] = (byte) (((byte) i5) ^ obj2[length]);
                        i5 >>>= 8;
                        i6++;
                    }
                    this.f26727a.mo5740a(obj2, 0, obj2, 0);
                    System.arraycopy(obj2, 0, bArr2, 0, 8);
                    System.arraycopy(obj2, 8, obj, i4, 8);
                }
            }
            if (Arrays.m29372b(bArr2, this.f26731e) != null) {
                return obj;
            }
            throw new InvalidCipherTextException("checksum failed");
        }
        throw new InvalidCipherTextException("unwrap data must be a multiple of 8 bytes");
    }
}
