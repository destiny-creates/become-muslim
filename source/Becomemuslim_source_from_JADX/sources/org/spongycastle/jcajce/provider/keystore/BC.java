package org.spongycastle.jcajce.provider.keystore;

import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;

public class BC {

    public static class Mappings extends AsymmetricAlgorithmProvider {
        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            configurableProvider.mo5883a("KeyStore.BKS", "org.spongycastle.jcajce.provider.keystore.bc.BcKeyStoreSpi$Std");
            configurableProvider.mo5883a("KeyStore.BKS-V1", "org.spongycastle.jcajce.provider.keystore.bc.BcKeyStoreSpi$Version1");
            configurableProvider.mo5883a("KeyStore.BouncyCastle", "org.spongycastle.jcajce.provider.keystore.bc.BcKeyStoreSpi$BouncyCastleStore");
            configurableProvider.mo5883a("Alg.Alias.KeyStore.UBER", "BouncyCastle");
            configurableProvider.mo5883a("Alg.Alias.KeyStore.BOUNCYCASTLE", "BouncyCastle");
            configurableProvider.mo5883a("Alg.Alias.KeyStore.spongycastle", "BouncyCastle");
        }
    }
}
