package org.spongycastle.pqc.crypto.ntru;

import org.spongycastle.crypto.params.AsymmetricKeyParameter;

public class NTRUEncryptionKeyParameters extends AsymmetricKeyParameter {
    /* renamed from: b */
    protected final NTRUEncryptionParameters f32173b;

    public NTRUEncryptionKeyParameters(boolean z, NTRUEncryptionParameters nTRUEncryptionParameters) {
        super(z);
        this.f32173b = nTRUEncryptionParameters;
    }

    /* renamed from: b */
    public NTRUEncryptionParameters m42097b() {
        return this.f32173b;
    }
}
