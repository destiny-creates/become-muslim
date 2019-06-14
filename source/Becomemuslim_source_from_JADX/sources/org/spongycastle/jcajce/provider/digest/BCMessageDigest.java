package org.spongycastle.jcajce.provider.digest;

import java.security.MessageDigest;
import org.spongycastle.crypto.Digest;

public class BCMessageDigest extends MessageDigest {
    /* renamed from: a */
    protected Digest f22856a;

    protected BCMessageDigest(Digest digest) {
        super(digest.mo5729a());
        this.f22856a = digest;
    }

    public void engineReset() {
        this.f22856a.mo5733c();
    }

    public void engineUpdate(byte b) {
        this.f22856a.mo5730a(b);
    }

    public void engineUpdate(byte[] bArr, int i, int i2) {
        this.f22856a.mo5731a(bArr, i, i2);
    }

    public byte[] engineDigest() {
        byte[] bArr = new byte[this.f22856a.mo5732b()];
        this.f22856a.mo5728a(bArr, 0);
        return bArr;
    }
}
