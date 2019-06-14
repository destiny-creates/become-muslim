package org.spongycastle.pqc.crypto.mceliece;

import org.spongycastle.crypto.params.AsymmetricKeyParameter;

public class McElieceKeyParameters extends AsymmetricKeyParameter {
    /* renamed from: b */
    private McElieceParameters f32172b;

    public McElieceKeyParameters(boolean z, McElieceParameters mcElieceParameters) {
        super(z);
        this.f32172b = mcElieceParameters;
    }

    /* renamed from: b */
    public McElieceParameters m42096b() {
        return this.f32172b;
    }
}
