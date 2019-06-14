package org.spongycastle.crypto;

public abstract class StreamBlockCipher implements BlockCipher, StreamCipher {
    /* renamed from: a */
    private final BlockCipher f26470a;

    /* renamed from: b */
    protected abstract byte mo6454b(byte b);

    protected StreamBlockCipher(BlockCipher blockCipher) {
        this.f26470a = blockCipher;
    }

    /* renamed from: e */
    public BlockCipher m34701e() {
        return this.f26470a;
    }

    /* renamed from: a */
    public final byte mo5721a(byte b) {
        return mo6454b(b);
    }

    /* renamed from: a */
    public int mo5722a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (i3 + i2 <= bArr2.length) {
            int i4 = i + i2;
            if (i4 <= bArr.length) {
                while (i < i4) {
                    int i5 = i3 + 1;
                    int i6 = i + 1;
                    bArr2[i3] = mo6454b(bArr[i]);
                    i3 = i5;
                    i = i6;
                }
                return i2;
            }
            throw new DataLengthException("input buffer too small");
        }
        throw new DataLengthException("output buffer too short");
    }
}
