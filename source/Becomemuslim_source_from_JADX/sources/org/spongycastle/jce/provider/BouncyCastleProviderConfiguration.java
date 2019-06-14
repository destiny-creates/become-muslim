package org.spongycastle.jce.provider;

import java.security.Permission;
import javax.crypto.spec.DHParameterSpec;
import org.spongycastle.jcajce.provider.config.ProviderConfiguration;
import org.spongycastle.jcajce.provider.config.ProviderConfigurationPermission;
import org.spongycastle.jce.spec.ECParameterSpec;

class BouncyCastleProviderConfiguration implements ProviderConfiguration {
    /* renamed from: a */
    private static Permission f27561a = new ProviderConfigurationPermission("SC", "threadLocalEcImplicitlyCa");
    /* renamed from: b */
    private static Permission f27562b = new ProviderConfigurationPermission("SC", "ecImplicitlyCa");
    /* renamed from: c */
    private static Permission f27563c = new ProviderConfigurationPermission("SC", "threadLocalDhDefaultParams");
    /* renamed from: d */
    private static Permission f27564d = new ProviderConfigurationPermission("SC", "DhDefaultParams");
    /* renamed from: e */
    private ThreadLocal f27565e = new ThreadLocal();
    /* renamed from: f */
    private ThreadLocal f27566f = new ThreadLocal();
    /* renamed from: g */
    private volatile ECParameterSpec f27567g;
    /* renamed from: h */
    private volatile Object f27568h;

    BouncyCastleProviderConfiguration() {
    }

    /* renamed from: a */
    public ECParameterSpec mo5888a() {
        ECParameterSpec eCParameterSpec = (ECParameterSpec) this.f27565e.get();
        if (eCParameterSpec != null) {
            return eCParameterSpec;
        }
        return this.f27567g;
    }

    /* renamed from: a */
    public DHParameterSpec mo5887a(int i) {
        Object obj = this.f27566f.get();
        if (obj == null) {
            obj = this.f27568h;
        }
        if (obj instanceof DHParameterSpec) {
            DHParameterSpec dHParameterSpec = (DHParameterSpec) obj;
            if (dHParameterSpec.getP().bitLength() == i) {
                return dHParameterSpec;
            }
        } else if (obj instanceof DHParameterSpec[]) {
            DHParameterSpec[] dHParameterSpecArr = (DHParameterSpec[]) obj;
            for (int i2 = 0; i2 != dHParameterSpecArr.length; i2++) {
                if (dHParameterSpecArr[i2].getP().bitLength() == i) {
                    return dHParameterSpecArr[i2];
                }
            }
        }
        return 0;
    }
}
