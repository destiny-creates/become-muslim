package org.spongycastle.jcajce.provider.symmetric.util;

import java.security.AlgorithmParameterGeneratorSpi;
import java.security.AlgorithmParameters;
import java.security.SecureRandom;
import org.spongycastle.jcajce.util.BCJcaJceHelper;
import org.spongycastle.jcajce.util.JcaJceHelper;

public abstract class BaseAlgorithmParameterGenerator extends AlgorithmParameterGeneratorSpi {
    /* renamed from: a */
    private final JcaJceHelper f22879a = new BCJcaJceHelper();
    /* renamed from: b */
    protected SecureRandom f22880b;
    /* renamed from: c */
    protected int f22881c = 1024;

    /* renamed from: a */
    protected final AlgorithmParameters m28076a(String str) {
        return this.f22879a.mo5878c(str);
    }

    protected void engineInit(int i, SecureRandom secureRandom) {
        this.f22881c = i;
        this.f22880b = secureRandom;
    }
}
