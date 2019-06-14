package org.spongycastle.jcajce.provider.asymmetric.util;

import java.security.AlgorithmParameterGeneratorSpi;
import java.security.AlgorithmParameters;
import org.spongycastle.jcajce.util.BCJcaJceHelper;
import org.spongycastle.jcajce.util.JcaJceHelper;

public abstract class BaseAlgorithmParameterGeneratorSpi extends AlgorithmParameterGeneratorSpi {
    /* renamed from: a */
    private final JcaJceHelper f22815a = new BCJcaJceHelper();

    /* renamed from: a */
    protected final AlgorithmParameters m27989a(String str) {
        return this.f22815a.mo5878c(str);
    }
}
