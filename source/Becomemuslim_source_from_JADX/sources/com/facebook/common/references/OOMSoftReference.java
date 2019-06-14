package com.facebook.common.references;

import java.lang.ref.SoftReference;

public class OOMSoftReference<T> {
    SoftReference<T> softRef1 = null;
    SoftReference<T> softRef2 = null;
    SoftReference<T> softRef3 = null;

    public void set(T t) {
        this.softRef1 = new SoftReference(t);
        this.softRef2 = new SoftReference(t);
        this.softRef3 = new SoftReference(t);
    }

    public T get() {
        return this.softRef1 == null ? null : this.softRef1.get();
    }

    public void clear() {
        if (this.softRef1 != null) {
            this.softRef1.clear();
            this.softRef1 = null;
        }
        if (this.softRef2 != null) {
            this.softRef2.clear();
            this.softRef2 = null;
        }
        if (this.softRef3 != null) {
            this.softRef3.clear();
            this.softRef3 = null;
        }
    }
}
