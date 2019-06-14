package com.google.android.gms.internal.ads;

import java.security.Provider;
import javax.crypto.KeyAgreement;

public final class za implements yx<KeyAgreement> {
    /* renamed from: a */
    public final /* synthetic */ Object mo4392a(String str, Provider provider) {
        return provider == null ? KeyAgreement.getInstance(str) : KeyAgreement.getInstance(str, provider);
    }
}
