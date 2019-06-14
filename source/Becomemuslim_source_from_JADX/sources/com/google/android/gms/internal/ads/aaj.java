package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class aaj implements Iterator {
    /* renamed from: a */
    private int f14135a = 0;
    /* renamed from: b */
    private final int f14136b = this.f14137c.mo6036a();
    /* renamed from: c */
    private final /* synthetic */ aai f14137c;

    aaj(aai aai) {
        this.f14137c = aai;
    }

    /* renamed from: a */
    private final byte m17848a() {
        try {
            aai aai = this.f14137c;
            int i = this.f14135a;
            this.f14135a = i + 1;
            return aai.mo6035a(i);
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public final boolean hasNext() {
        return this.f14135a < this.f14136b;
    }

    public final /* synthetic */ Object next() {
        return Byte.valueOf(m17848a());
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
