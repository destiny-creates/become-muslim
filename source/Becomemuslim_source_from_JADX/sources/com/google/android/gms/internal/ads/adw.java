package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map.Entry;

final class adw extends aec {
    /* renamed from: a */
    private final /* synthetic */ adt f23566a;

    private adw(adt adt) {
        this.f23566a = adt;
        super(adt);
    }

    public final Iterator<Entry<K, V>> iterator() {
        return new adv(this.f23566a);
    }
}
