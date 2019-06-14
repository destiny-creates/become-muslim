package org.spongycastle.crypto.params;

import java.security.SecureRandom;
import org.spongycastle.crypto.KeyGenerationParameters;

public class ECKeyGenerationParameters extends KeyGenerationParameters {
    /* renamed from: a */
    private ECDomainParameters f27091a;

    public ECKeyGenerationParameters(ECDomainParameters eCDomainParameters, SecureRandom secureRandom) {
        super(secureRandom, eCDomainParameters.m35649c().bitLength());
        this.f27091a = eCDomainParameters;
    }

    /* renamed from: c */
    public ECDomainParameters m35652c() {
        return this.f27091a;
    }
}
