package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class ady implements Iterator<Object> {
    ady() {
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
