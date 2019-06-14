package com.google.android.gms.internal.p210i;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.i.gg */
final class gg extends du<Long> implements fr<Long>, he, RandomAccess {
    /* renamed from: a */
    private static final gg f28913a;
    /* renamed from: b */
    private long[] f28914b;
    /* renamed from: c */
    private int f28915c;

    gg() {
        this(new long[10], 0);
    }

    private gg(long[] jArr, int i) {
        this.f28914b = jArr;
        this.f28915c = i;
    }

    protected final void removeRange(int i, int i2) {
        m31336c();
        if (i2 >= i) {
            System.arraycopy(this.f28914b, i2, this.f28914b, i, this.f28915c - i2);
            this.f28915c -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof gg)) {
            return super.equals(obj);
        }
        gg ggVar = (gg) obj;
        if (this.f28915c != ggVar.f28915c) {
            return false;
        }
        obj = ggVar.f28914b;
        for (int i = 0; i < this.f28915c; i++) {
            if (this.f28914b[i] != obj[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f28915c; i2++) {
            i = (i * 31) + fm.m20554a(this.f28914b[i2]);
        }
        return i;
    }

    /* renamed from: b */
    public final long m37972b(int i) {
        m37968c(i);
        return this.f28914b[i];
    }

    public final int size() {
        return this.f28915c;
    }

    /* renamed from: a */
    public final void m37971a(long j) {
        m37967a(this.f28915c, j);
    }

    /* renamed from: a */
    private final void m37967a(int i, long j) {
        m31336c();
        if (i < 0 || i > this.f28915c) {
            throw new IndexOutOfBoundsException(m37969d(i));
        }
        if (this.f28915c < this.f28914b.length) {
            System.arraycopy(this.f28914b, i, this.f28914b, i + 1, this.f28915c - i);
        } else {
            Object obj = new long[(((this.f28915c * 3) / 2) + 1)];
            System.arraycopy(this.f28914b, 0, obj, 0, i);
            System.arraycopy(this.f28914b, i, obj, i + 1, this.f28915c - i);
            this.f28914b = obj;
        }
        this.f28914b[i] = j;
        this.f28915c++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Long> collection) {
        m31336c();
        fm.m20556a((Object) collection);
        if (!(collection instanceof gg)) {
            return super.addAll(collection);
        }
        gg ggVar = (gg) collection;
        if (ggVar.f28915c == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.f28915c >= ggVar.f28915c) {
            int i = this.f28915c + ggVar.f28915c;
            if (i > this.f28914b.length) {
                this.f28914b = Arrays.copyOf(this.f28914b, i);
            }
            System.arraycopy(ggVar.f28914b, 0, this.f28914b, this.f28915c, ggVar.f28915c);
            this.f28915c = i;
            this.modCount += 1;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        m31336c();
        for (int i = 0; i < this.f28915c; i++) {
            if (obj.equals(Long.valueOf(this.f28914b[i]))) {
                System.arraycopy(this.f28914b, i + 1, this.f28914b, i, (this.f28915c - i) - 1);
                this.f28915c -= 1;
                this.modCount += 1;
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    private final void m37968c(int i) {
        if (i < 0 || i >= this.f28915c) {
            throw new IndexOutOfBoundsException(m37969d(i));
        }
    }

    /* renamed from: d */
    private final String m37969d(int i) {
        int i2 = this.f28915c;
        StringBuilder stringBuilder = new StringBuilder(35);
        stringBuilder.append("Index:");
        stringBuilder.append(i);
        stringBuilder.append(", Size:");
        stringBuilder.append(i2);
        return stringBuilder.toString();
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        m31336c();
        m37968c(i);
        long j = this.f28914b[i];
        this.f28914b[i] = longValue;
        return Long.valueOf(j);
    }

    public final /* synthetic */ Object remove(int i) {
        m31336c();
        m37968c(i);
        long j = this.f28914b[i];
        if (i < this.f28915c - 1) {
            System.arraycopy(this.f28914b, i + 1, this.f28914b, i, (this.f28915c - i) - 1);
        }
        this.f28915c--;
        this.modCount++;
        return Long.valueOf(j);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        m37967a(i, ((Long) obj).longValue());
    }

    /* renamed from: a */
    public final /* synthetic */ fr mo6150a(int i) {
        if (i >= this.f28915c) {
            return new gg(Arrays.copyOf(this.f28914b, i), this.f28915c);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(m37972b(i));
    }

    static {
        du ggVar = new gg(new long[0], 0);
        f28913a = ggVar;
        ggVar.mo4430b();
    }
}
