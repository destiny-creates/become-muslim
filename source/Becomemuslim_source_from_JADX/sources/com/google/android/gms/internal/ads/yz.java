package com.google.android.gms.internal.ads;

import java.security.Provider;
import javax.crypto.Cipher;

public final class yz implements yx<Cipher> {
    /* renamed from: a */
    public final /* synthetic */ Object mo4392a(String str, Provider provider) {
        return provider == null ? Cipher.getInstance(str) : Cipher.getInstance(str, provider);
    }
}
