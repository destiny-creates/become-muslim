package com.google.android.gms.internal.ads;

import java.security.Provider;
import javax.crypto.Mac;

public final class zd implements yx<Mac> {
    /* renamed from: a */
    public final /* synthetic */ Object mo4392a(String str, Provider provider) {
        return provider == null ? Mac.getInstance(str) : Mac.getInstance(str, provider);
    }
}
