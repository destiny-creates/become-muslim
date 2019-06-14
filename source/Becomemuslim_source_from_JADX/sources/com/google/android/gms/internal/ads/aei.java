package com.google.android.gms.internal.ads;

import java.util.List;

public final class aei extends RuntimeException {
    /* renamed from: a */
    private final List<String> f14336a = null;

    public aei(acx acx) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    /* renamed from: a */
    public final abw m18175a() {
        return new abw(getMessage());
    }
}
