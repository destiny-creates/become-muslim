package com.google.android.gms.internal.ads;

import java.security.Provider;
import java.security.Signature;

public final class zf implements yx<Signature> {
    /* renamed from: a */
    public final /* synthetic */ Object mo4392a(String str, Provider provider) {
        return provider == null ? Signature.getInstance(str) : Signature.getInstance(str, provider);
    }
}
