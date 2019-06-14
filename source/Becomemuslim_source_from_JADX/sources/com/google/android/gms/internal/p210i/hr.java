package com.google.android.gms.internal.p210i;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.i.hr */
final class hr implements Iterator<Object> {
    hr() {
    }

    public final boolean hasNext() {
        return false;
    }

    public final Object next() {
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
