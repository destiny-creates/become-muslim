package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.Provider;

public final class ze implements yx<MessageDigest> {
    /* renamed from: a */
    public final /* synthetic */ Object mo4392a(String str, Provider provider) {
        return provider == null ? MessageDigest.getInstance(str) : MessageDigest.getInstance(str, provider);
    }
}
