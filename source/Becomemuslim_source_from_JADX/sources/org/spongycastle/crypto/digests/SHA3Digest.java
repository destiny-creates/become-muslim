package org.spongycastle.crypto.digests;

import com.facebook.imagepipeline.memory.BitmapCounterConfig;

public class SHA3Digest extends KeccakDigest {
    /* renamed from: a */
    private static int m43301a(int i) {
        if (!(i == 224 || i == 256 || i == BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT)) {
            if (i != 512) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("'bitLength' ");
                stringBuilder.append(i);
                stringBuilder.append(" not supported for SHA-3");
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        return i;
    }

    public SHA3Digest() {
        this(256);
    }

    public SHA3Digest(int i) {
        super(m43301a(i));
    }

    public SHA3Digest(SHA3Digest sHA3Digest) {
        super((KeccakDigest) sHA3Digest);
    }

    /* renamed from: a */
    public String mo5729a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SHA3-");
        stringBuilder.append(this.e);
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public int mo5728a(byte[] bArr, int i) {
        m40598a(new byte[]{(byte) 2}, 0, 2);
        return super.mo5728a(bArr, i);
    }
}
