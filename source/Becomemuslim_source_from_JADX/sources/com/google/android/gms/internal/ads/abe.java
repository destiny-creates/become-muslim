package com.google.android.gms.internal.ads;

import com.facebook.soloader.MinElf;

final class abe {
    /* renamed from: a */
    private final Object f14152a;
    /* renamed from: b */
    private final int f14153b;

    abe(Object obj, int i) {
        this.f14152a = obj;
        this.f14153b = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof abe)) {
            return false;
        }
        abe abe = (abe) obj;
        return this.f14152a == abe.f14152a && this.f14153b == abe.f14153b;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.f14152a) * MinElf.PN_XNUM) + this.f14153b;
    }
}
