package org.spongycastle.jcajce.provider.asymmetric.util;

import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.jce.spec.IESParameterSpec;

public class IESUtil {
    /* renamed from: a */
    public static IESParameterSpec m28016a(BufferedBlockCipher bufferedBlockCipher) {
        if (bufferedBlockCipher == null) {
            return new IESParameterSpec(null, null, 128);
        }
        bufferedBlockCipher = bufferedBlockCipher.m27301a();
        if (!(bufferedBlockCipher.mo5741a().equals("DES") || bufferedBlockCipher.mo5741a().equals("RC2") || bufferedBlockCipher.mo5741a().equals("RC5-32"))) {
            if (!bufferedBlockCipher.mo5741a().equals("RC5-64")) {
                if (bufferedBlockCipher.mo5741a().equals("SKIPJACK")) {
                    return new IESParameterSpec(null, null, 80, 80);
                }
                if (bufferedBlockCipher.mo5741a().equals("GOST28147") != null) {
                    return new IESParameterSpec(null, null, 256, 256);
                }
                return new IESParameterSpec(null, null, 128, 128);
            }
        }
        return new IESParameterSpec(null, null, 64, 64);
    }
}
