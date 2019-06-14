package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;

public class NullEngine implements BlockCipher {
    /* renamed from: a */
    private boolean f26697a;
    /* renamed from: b */
    private final int f26698b;

    /* renamed from: a */
    public String mo5741a() {
        return "Null";
    }

    /* renamed from: c */
    public void mo5744c() {
    }

    public NullEngine() {
        this(1);
    }

    public NullEngine(int i) {
        this.f26698b = i;
    }

    /* renamed from: a */
    public void mo5742a(boolean z, CipherParameters cipherParameters) {
        this.f26697a = true;
    }

    /* renamed from: b */
    public int mo5743b() {
        return this.f26698b;
    }

    /* renamed from: a */
    public int mo5740a(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (!this.f26697a) {
            throw new IllegalStateException("Null engine not initialised");
        } else if (this.f26698b + i > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (this.f26698b + i2 <= bArr2.length) {
            for (int i3 = 0; i3 < this.f26698b; i3++) {
                bArr2[i2 + i3] = bArr[i + i3];
            }
            return this.f26698b;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }
}
