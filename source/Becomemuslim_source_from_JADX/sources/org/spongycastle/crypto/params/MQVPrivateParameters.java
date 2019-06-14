package org.spongycastle.crypto.params;

import org.spongycastle.crypto.CipherParameters;

public class MQVPrivateParameters implements CipherParameters {
    /* renamed from: a */
    private ECPrivateKeyParameters f27125a;
    /* renamed from: b */
    private ECPrivateKeyParameters f27126b;
    /* renamed from: c */
    private ECPublicKeyParameters f27127c;

    public MQVPrivateParameters(ECPrivateKeyParameters eCPrivateKeyParameters, ECPrivateKeyParameters eCPrivateKeyParameters2, ECPublicKeyParameters eCPublicKeyParameters) {
        this.f27125a = eCPrivateKeyParameters;
        this.f27126b = eCPrivateKeyParameters2;
        this.f27127c = eCPublicKeyParameters;
    }

    /* renamed from: a */
    public ECPrivateKeyParameters m35687a() {
        return this.f27125a;
    }

    /* renamed from: b */
    public ECPrivateKeyParameters m35688b() {
        return this.f27126b;
    }

    /* renamed from: c */
    public ECPublicKeyParameters m35689c() {
        return this.f27127c;
    }
}
