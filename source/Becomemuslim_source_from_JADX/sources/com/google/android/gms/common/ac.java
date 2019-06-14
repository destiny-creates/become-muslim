package com.google.android.gms.common;

import java.util.concurrent.Callable;

final class ac extends aa {
    /* renamed from: b */
    private final Callable<String> f11380b;

    private ac(Callable<String> callable) {
        super(false, null, null);
        this.f11380b = callable;
    }

    /* renamed from: b */
    final String mo2375b() {
        try {
            return (String) this.f11380b.call();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
