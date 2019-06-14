package org.spongycastle.pqc.crypto.gmss;

import org.spongycastle.crypto.params.AsymmetricKeyParameter;

public class GMSSKeyParameters extends AsymmetricKeyParameter {
    /* renamed from: b */
    private GMSSParameters f32169b;

    public GMSSKeyParameters(boolean z, GMSSParameters gMSSParameters) {
        super(z);
        this.f32169b = gMSSParameters;
    }

    /* renamed from: b */
    public GMSSParameters m42093b() {
        return this.f32169b;
    }
}
