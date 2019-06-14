package org.spongycastle.pqc.crypto.mceliece;

import org.spongycastle.crypto.params.AsymmetricKeyParameter;

public class McElieceCCA2KeyParameters extends AsymmetricKeyParameter {
    /* renamed from: b */
    private McElieceCCA2Parameters f32170b;

    public McElieceCCA2KeyParameters(boolean z, McElieceCCA2Parameters mcElieceCCA2Parameters) {
        super(z);
        this.f32170b = mcElieceCCA2Parameters;
    }

    /* renamed from: b */
    public McElieceCCA2Parameters m42094b() {
        return this.f32170b;
    }
}
