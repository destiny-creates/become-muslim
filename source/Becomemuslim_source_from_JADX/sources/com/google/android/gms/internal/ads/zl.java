package com.google.android.gms.internal.ads;

import java.security.SecureRandom;

final class zl extends ThreadLocal<SecureRandom> {
    zl() {
    }

    protected final /* synthetic */ Object initialValue() {
        return zk.m20198b();
    }
}
