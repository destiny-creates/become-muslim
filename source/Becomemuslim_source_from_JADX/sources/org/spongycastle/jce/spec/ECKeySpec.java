package org.spongycastle.jce.spec;

import java.security.spec.KeySpec;

public class ECKeySpec implements KeySpec {
    /* renamed from: a */
    private ECParameterSpec f23044a;

    protected ECKeySpec(ECParameterSpec eCParameterSpec) {
        this.f23044a = eCParameterSpec;
    }

    /* renamed from: a */
    public ECParameterSpec m28309a() {
        return this.f23044a;
    }
}
