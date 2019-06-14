package org.spongycastle.pqc.crypto.mceliece;

import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.SHA256Digest;

public class McElieceCCA2Parameters extends McElieceParameters {
    /* renamed from: a */
    public Digest f32171a = new SHA256Digest();

    public McElieceCCA2Parameters(int i, int i2) {
        super(i, i2);
    }

    /* renamed from: a */
    public Digest m42095a() {
        return this.f32171a;
    }
}
