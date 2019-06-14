package com.google.android.gms.internal.p210i;

import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.i.dz */
final class dz extends eb {
    /* renamed from: a */
    private int f28875a = null;
    /* renamed from: b */
    private final int f28876b = this.f28877c.mo6160a();
    /* renamed from: c */
    private final /* synthetic */ dy f28877c;

    dz(dy dyVar) {
        this.f28877c = dyVar;
    }

    public final boolean hasNext() {
        return this.f28875a < this.f28876b;
    }

    /* renamed from: a */
    public final byte mo6158a() {
        int i = this.f28875a;
        if (i < this.f28876b) {
            this.f28875a = i + 1;
            return this.f28877c.mo6166b(i);
        }
        throw new NoSuchElementException();
    }
}
