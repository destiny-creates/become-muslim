package org.spongycastle.crypto.params;

import org.spongycastle.crypto.CipherParameters;

public class MQVPublicParameters implements CipherParameters {
    /* renamed from: a */
    private ECPublicKeyParameters f27128a;
    /* renamed from: b */
    private ECPublicKeyParameters f27129b;

    public MQVPublicParameters(ECPublicKeyParameters eCPublicKeyParameters, ECPublicKeyParameters eCPublicKeyParameters2) {
        this.f27128a = eCPublicKeyParameters;
        this.f27129b = eCPublicKeyParameters2;
    }

    /* renamed from: a */
    public ECPublicKeyParameters m35690a() {
        return this.f27128a;
    }

    /* renamed from: b */
    public ECPublicKeyParameters m35691b() {
        return this.f27129b;
    }
}
