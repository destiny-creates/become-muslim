package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;

public class DESedeEngine extends DESEngine {
    /* renamed from: a */
    private int[] f31660a = null;
    /* renamed from: b */
    private int[] f31661b = null;
    /* renamed from: c */
    private int[] f31662c = null;
    /* renamed from: d */
    private boolean f31663d;

    /* renamed from: a */
    public String mo5741a() {
        return "DESede";
    }

    /* renamed from: b */
    public int mo5743b() {
        return 8;
    }

    /* renamed from: c */
    public void mo5744c() {
    }

    /* renamed from: a */
    public void mo5742a(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            cipherParameters = ((KeyParameter) cipherParameters).m35685a();
            if (cipherParameters.length != 24) {
                if (cipherParameters.length != 16) {
                    throw new IllegalArgumentException("key size must be 16 or 24 bytes.");
                }
            }
            this.f31663d = z;
            Object obj = new byte[8];
            System.arraycopy(cipherParameters, 0, obj, 0, obj.length);
            this.f31660a = m34925a(z, (byte[]) obj);
            obj = new byte[8];
            System.arraycopy(cipherParameters, 8, obj, 0, obj.length);
            this.f31661b = m34925a(z ^ 1, (byte[]) obj);
            if (cipherParameters.length == 24) {
                Object obj2 = new byte[8];
                System.arraycopy(cipherParameters, 16, obj2, 0, obj2.length);
                this.f31662c = m34925a(z, (byte[]) obj2);
                return;
            }
            this.f31662c = this.f31660a;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("invalid parameter passed to DESede init - ");
        stringBuilder.append(cipherParameters.getClass().getName());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public int mo5740a(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.f31660a == null) {
            throw new IllegalStateException("DESede engine not initialised");
        } else if (i + 8 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 8 <= bArr2.length) {
            byte[] bArr3 = new byte[8];
            byte[] bArr4;
            byte[] bArr5;
            if (this.f31663d) {
                bArr4 = bArr3;
                m34924a(this.f31660a, bArr, i, bArr4, 0);
                bArr5 = bArr3;
                m34924a(this.f31661b, bArr5, 0, bArr4, 0);
                m34924a(this.f31662c, bArr5, 0, bArr2, i2);
            } else {
                bArr4 = bArr3;
                m34924a(this.f31662c, bArr, i, bArr4, 0);
                bArr5 = bArr3;
                m34924a(this.f31661b, bArr5, 0, bArr4, 0);
                m34924a(this.f31660a, bArr5, 0, bArr2, i2);
            }
            return 8;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }
}
