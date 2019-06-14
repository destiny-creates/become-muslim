package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;

public class CBCBlockCipher implements BlockCipher {
    /* renamed from: a */
    private byte[] f26965a;
    /* renamed from: b */
    private byte[] f26966b;
    /* renamed from: c */
    private byte[] f26967c;
    /* renamed from: d */
    private int f26968d;
    /* renamed from: e */
    private BlockCipher f26969e = null;
    /* renamed from: f */
    private boolean f26970f;

    public CBCBlockCipher(BlockCipher blockCipher) {
        this.f26969e = blockCipher;
        this.f26968d = blockCipher.mo5743b();
        this.f26965a = new byte[this.f26968d];
        this.f26966b = new byte[this.f26968d];
        this.f26967c = new byte[this.f26968d];
    }

    /* renamed from: d */
    public BlockCipher m35495d() {
        return this.f26969e;
    }

    /* renamed from: a */
    public void mo5742a(boolean z, CipherParameters cipherParameters) {
        boolean z2 = this.f26970f;
        this.f26970f = z;
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            Object a = parametersWithIV.m35695a();
            if (a.length == this.f26968d) {
                System.arraycopy(a, 0, this.f26965a, 0, a.length);
                mo5744c();
                if (parametersWithIV.m35696b() != null) {
                    this.f26969e.mo5742a(z, parametersWithIV.m35696b());
                    return;
                } else if (z2 != z) {
                    throw new IllegalArgumentException("cannot change encrypting state without providing key.");
                } else {
                    return;
                }
            }
            throw new IllegalArgumentException("initialisation vector must be the same length as block size");
        }
        mo5744c();
        if (cipherParameters != null) {
            this.f26969e.mo5742a(z, cipherParameters);
        } else if (z2 != z) {
            throw new IllegalArgumentException("cannot change encrypting state without providing key.");
        }
    }

    /* renamed from: a */
    public String mo5741a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f26969e.mo5741a());
        stringBuilder.append("/CBC");
        return stringBuilder.toString();
    }

    /* renamed from: b */
    public int mo5743b() {
        return this.f26969e.mo5743b();
    }

    /* renamed from: a */
    public int mo5740a(byte[] bArr, int i, byte[] bArr2, int i2) {
        return this.f26970f ? m35488b(bArr, i, bArr2, i2) : m35489c(bArr, i, bArr2, i2);
    }

    /* renamed from: c */
    public void mo5744c() {
        System.arraycopy(this.f26965a, 0, this.f26966b, 0, this.f26965a.length);
        Arrays.m29351a(this.f26967c, (byte) 0);
        this.f26969e.mo5744c();
    }

    /* renamed from: b */
    private int m35488b(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.f26968d + i <= bArr.length) {
            for (int i3 = 0; i3 < this.f26968d; i3++) {
                byte[] bArr3 = this.f26966b;
                bArr3[i3] = (byte) (bArr3[i3] ^ bArr[i + i3]);
            }
            bArr = this.f26969e.mo5740a(this.f26966b, 0, bArr2, i2);
            System.arraycopy(bArr2, i2, this.f26966b, 0, this.f26966b.length);
            return bArr;
        }
        throw new DataLengthException("input buffer too short");
    }

    /* renamed from: c */
    private int m35489c(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.f26968d + i <= bArr.length) {
            int i3 = 0;
            System.arraycopy(bArr, i, this.f26967c, 0, this.f26968d);
            bArr = this.f26969e.mo5740a(bArr, i, bArr2, i2);
            while (i3 < this.f26968d) {
                i = i2 + i3;
                bArr2[i] = (byte) (bArr2[i] ^ this.f26966b[i3]);
                i3++;
            }
            i = this.f26966b;
            this.f26966b = this.f26967c;
            this.f26967c = i;
            return bArr;
        }
        throw new DataLengthException("input buffer too short");
    }
}
