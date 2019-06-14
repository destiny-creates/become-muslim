package com.google.android.gms.internal.ads;

import java.security.KeyPairGenerator;
import java.security.Provider;

public final class zc implements yx<KeyPairGenerator> {
    /* renamed from: a */
    public final /* synthetic */ Object mo4392a(String str, Provider provider) {
        return provider == null ? KeyPairGenerator.getInstance(str) : KeyPairGenerator.getInstance(str, provider);
    }
}
