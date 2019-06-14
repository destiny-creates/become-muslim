package org.spongycastle.crypto.digests;

import org.spongycastle.crypto.Xof;

public class SHAKEDigest extends KeccakDigest implements Xof {
    /* renamed from: a */
    private static int m43319a(int i) {
        if (i != 128) {
            if (i != 256) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("'bitLength' ");
                stringBuilder.append(i);
                stringBuilder.append(" not supported for SHAKE");
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        return i;
    }

    public SHAKEDigest() {
        this(128);
    }

    public SHAKEDigest(int i) {
        super(m43319a(i));
    }

    /* renamed from: a */
    public String mo5729a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SHAKE");
        stringBuilder.append(this.e);
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public int mo5728a(byte[] bArr, int i) {
        return m43322b(bArr, i, mo5732b());
    }

    /* renamed from: b */
    public int m43322b(byte[] bArr, int i, int i2) {
        m40598a(new byte[]{(byte) 15}, 0, 4);
        m40600b(bArr, i, ((long) i2) * 8);
        mo5733c();
        return i2;
    }
}
