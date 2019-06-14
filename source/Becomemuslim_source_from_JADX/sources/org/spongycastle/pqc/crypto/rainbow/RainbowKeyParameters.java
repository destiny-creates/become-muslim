package org.spongycastle.pqc.crypto.rainbow;

import org.spongycastle.crypto.params.AsymmetricKeyParameter;

public class RainbowKeyParameters extends AsymmetricKeyParameter {
    /* renamed from: b */
    private int f32178b;

    public RainbowKeyParameters(boolean z, int i) {
        super(z);
        this.f32178b = i;
    }

    /* renamed from: b */
    public int m42098b() {
        return this.f32178b;
    }
}
