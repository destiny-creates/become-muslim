package org.spongycastle.jcajce.provider.asymmetric;

import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;

public class IES {

    public static class Mappings extends AsymmetricAlgorithmProvider {
        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            configurableProvider.mo5883a("AlgorithmParameters.IES", "org.spongycastle.jcajce.provider.asymmetric.ies.AlgorithmParametersSpi");
            configurableProvider.mo5883a("Cipher.IES", "org.spongycastle.jcajce.provider.asymmetric.ies.CipherSpi$IES");
        }
    }
}
