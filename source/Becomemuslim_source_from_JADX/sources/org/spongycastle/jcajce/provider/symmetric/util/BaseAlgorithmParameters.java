package org.spongycastle.jcajce.provider.symmetric.util;

import java.security.AlgorithmParametersSpi;
import java.security.spec.AlgorithmParameterSpec;

public abstract class BaseAlgorithmParameters extends AlgorithmParametersSpi {
    /* renamed from: a */
    protected abstract AlgorithmParameterSpec mo5855a(Class cls);

    /* renamed from: a */
    protected boolean m28078a(String str) {
        if (str != null) {
            if (str.equals("ASN.1") == null) {
                return null;
            }
        }
        return true;
    }

    protected AlgorithmParameterSpec engineGetParameterSpec(Class cls) {
        if (cls != null) {
            return mo5855a(cls);
        }
        throw new NullPointerException("argument to getParameterSpec must not be null");
    }
}
