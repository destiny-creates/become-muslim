package com.google.android.gms.internal.ads;

import java.security.KeyFactory;
import java.security.Provider;

public final class zb implements yx<KeyFactory> {
    /* renamed from: a */
    public final /* synthetic */ Object mo4392a(String str, Provider provider) {
        return provider == null ? KeyFactory.getInstance(str) : KeyFactory.getInstance(str, provider);
    }
}
