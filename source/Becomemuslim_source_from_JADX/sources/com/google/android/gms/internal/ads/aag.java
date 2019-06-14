package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class aag extends aac<Boolean> implements abv<Boolean>, RandomAccess {
    /* renamed from: a */
    private static final aag f27978a;
    /* renamed from: b */
    private boolean[] f27979b;
    /* renamed from: c */
    private int f27980c;

    static {
        aac aag = new aag();
        f27978a = aag;
        aag.mo3615b();
    }

    aag() {
        this(new boolean[10], 0);
    }

    private aag(boolean[] zArr, int i) {
        this.f27979b = zArr;
        this.f27980c = i;
    }

    /* renamed from: a */
    private final void m36656a(int i, boolean z) {
        m29505c();
        if (i < 0 || i > this.f27980c) {
            throw new IndexOutOfBoundsException(m36658c(i));
        }
        if (this.f27980c < this.f27979b.length) {
            System.arraycopy(this.f27979b, i, this.f27979b, i + 1, this.f27980c - i);
        } else {
            Object obj = new boolean[(((this.f27980c * 3) / 2) + 1)];
            System.arraycopy(this.f27979b, 0, obj, 0, i);
            System.arraycopy(this.f27979b, i, obj, i + 1, this.f27980c - i);
            this.f27979b = obj;
        }
        this.f27979b[i] = z;
        this.f27980c++;
        this.modCount++;
    }

    /* renamed from: b */
    private final void m36657b(int i) {
        if (i < 0 || i >= this.f27980c) {
            throw new IndexOutOfBoundsException(m36658c(i));
        }
    }

    /* renamed from: c */
    private final String m36658c(int i) {
        int i2 = this.f27980c;
        StringBuilder stringBuilder = new StringBuilder(35);
        stringBuilder.append("Index:");
        stringBuilder.append(i);
        stringBuilder.append(", Size:");
        stringBuilder.append(i2);
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public final /* synthetic */ abv mo6027a(int i) {
        if (i >= this.f27980c) {
            return new aag(Arrays.copyOf(this.f27979b, i), this.f27980c);
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: a */
    public final void m36660a(boolean z) {
        m36656a(this.f27980c, z);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        m36656a(i, ((Boolean) obj).booleanValue());
    }

    public final boolean addAll(Collection<? extends Boolean> collection) {
        m29505c();
        abs.m17933a((Object) collection);
        if (!(collection instanceof aag)) {
            return super.addAll(collection);
        }
        aag aag = (aag) collection;
        if (aag.f27980c == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.f27980c >= aag.f27980c) {
            int i = this.f27980c + aag.f27980c;
            if (i > this.f27979b.length) {
                this.f27979b = Arrays.copyOf(this.f27979b, i);
            }
            System.arraycopy(aag.f27979b, 0, this.f27979b, this.f27980c, aag.f27980c);
            this.f27980c = i;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof aag)) {
            return super.equals(obj);
        }
        aag aag = (aag) obj;
        if (this.f27980c != aag.f27980c) {
            return false;
        }
        boolean[] zArr = aag.f27979b;
        for (int i = 0; i < this.f27980c; i++) {
            if (this.f27979b[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        m36657b(i);
        return Boolean.valueOf(this.f27979b[i]);
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f27980c; i2++) {
            i = (i * 31) + abs.m17932a(this.f27979b[i2]);
        }
        return i;
    }

    public final /* synthetic */ Object remove(int i) {
        m29505c();
        m36657b(i);
        boolean z = this.f27979b[i];
        if (i < this.f27980c - 1) {
            System.arraycopy(this.f27979b, i + 1, this.f27979b, i, this.f27980c - i);
        }
        this.f27980c--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    public final boolean remove(Object obj) {
        m29505c();
        for (int i = 0; i < this.f27980c; i++) {
            if (obj.equals(Boolean.valueOf(this.f27979b[i]))) {
                System.arraycopy(this.f27979b, i + 1, this.f27979b, i, this.f27980c - i);
                this.f27980c--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    protected final void removeRange(int i, int i2) {
        m29505c();
        if (i2 >= i) {
            System.arraycopy(this.f27979b, i2, this.f27979b, i, this.f27980c - i2);
            this.f27980c -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        m29505c();
        m36657b(i);
        boolean z = this.f27979b[i];
        this.f27979b[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    public final int size() {
        return this.f27980c;
    }
}
