package org.spongycastle.jcajce.spec;

import javax.crypto.spec.PBEKeySpec;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class PBKDF2KeySpec extends PBEKeySpec {
    /* renamed from: a */
    private AlgorithmIdentifier f22906a;

    public PBKDF2KeySpec(char[] cArr, byte[] bArr, int i, int i2, AlgorithmIdentifier algorithmIdentifier) {
        super(cArr, bArr, i, i2);
        this.f22906a = algorithmIdentifier;
    }

    /* renamed from: a */
    public AlgorithmIdentifier m28110a() {
        return this.f22906a;
    }
}
