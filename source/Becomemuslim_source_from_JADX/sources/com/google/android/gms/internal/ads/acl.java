package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class acl extends aac<Long> implements abv<Long>, RandomAccess {
    /* renamed from: a */
    private static final acl f28025a;
    /* renamed from: b */
    private long[] f28026b;
    /* renamed from: c */
    private int f28027c;

    static {
        aac acl = new acl();
        f28025a = acl;
        acl.mo3615b();
    }

    acl() {
        this(new long[10], 0);
    }

    private acl(long[] jArr, int i) {
        this.f28026b = jArr;
        this.f28027c = i;
    }

    /* renamed from: a */
    private final void m36728a(int i, long j) {
        m29505c();
        if (i < 0 || i > this.f28027c) {
            throw new IndexOutOfBoundsException(m36730d(i));
        }
        if (this.f28027c < this.f28026b.length) {
            System.arraycopy(this.f28026b, i, this.f28026b, i + 1, this.f28027c - i);
        } else {
            Object obj = new long[(((this.f28027c * 3) / 2) + 1)];
            System.arraycopy(this.f28026b, 0, obj, 0, i);
            System.arraycopy(this.f28026b, i, obj, i + 1, this.f28027c - i);
            this.f28026b = obj;
        }
        this.f28026b[i] = j;
        this.f28027c++;
        this.modCount++;
    }

    /* renamed from: c */
    private final void m36729c(int i) {
        if (i < 0 || i >= this.f28027c) {
            throw new IndexOutOfBoundsException(m36730d(i));
        }
    }

    /* renamed from: d */
    private final String m36730d(int i) {
        int i2 = this.f28027c;
        StringBuilder stringBuilder = new StringBuilder(35);
        stringBuilder.append("Index:");
        stringBuilder.append(i);
        stringBuilder.append(", Size:");
        stringBuilder.append(i2);
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public final /* synthetic */ abv mo6027a(int i) {
        if (i >= this.f28027c) {
            return new acl(Arrays.copyOf(this.f28026b, i), this.f28027c);
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: a */
    public final void m36732a(long j) {
        m36728a(this.f28027c, j);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        m36728a(i, ((Long) obj).longValue());
    }

    public final boolean addAll(Collection<? extends Long> collection) {
        m29505c();
        abs.m17933a((Object) collection);
        if (!(collection instanceof acl)) {
            return super.addAll(collection);
        }
        acl acl = (acl) collection;
        if (acl.f28027c == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.f28027c >= acl.f28027c) {
            int i = this.f28027c + acl.f28027c;
            if (i > this.f28026b.length) {
                this.f28026b = Arrays.copyOf(this.f28026b, i);
            }
            System.arraycopy(acl.f28026b, 0, this.f28026b, this.f28027c, acl.f28027c);
            this.f28027c = i;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    /* renamed from: b */
    public final long m36733b(int i) {
        m36729c(i);
        return this.f28026b[i];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof acl)) {
            return super.equals(obj);
        }
        acl acl = (acl) obj;
        if (this.f28027c != acl.f28027c) {
            return false;
        }
        long[] jArr = acl.f28026b;
        for (int i = 0; i < this.f28027c; i++) {
            if (this.f28026b[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(m36733b(i));
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f28027c; i2++) {
            i = (i * 31) + abs.m17931a(this.f28026b[i2]);
        }
        return i;
    }

    public final /* synthetic */ Object remove(int i) {
        m29505c();
        m36729c(i);
        long j = this.f28026b[i];
        if (i < this.f28027c - 1) {
            System.arraycopy(this.f28026b, i + 1, this.f28026b, i, this.f28027c - i);
        }
        this.f28027c--;
        this.modCount++;
        return Long.valueOf(j);
    }

    public final boolean remove(Object obj) {
        m29505c();
        for (int i = 0; i < this.f28027c; i++) {
            if (obj.equals(Long.valueOf(this.f28026b[i]))) {
                System.arraycopy(this.f28026b, i + 1, this.f28026b, i, this.f28027c - i);
                this.f28027c--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    protected final void removeRange(int i, int i2) {
        m29505c();
        if (i2 >= i) {
            System.arraycopy(this.f28026b, i2, this.f28026b, i, this.f28027c - i2);
            this.f28027c -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        m29505c();
        m36729c(i);
        long j = this.f28026b[i];
        this.f28026b[i] = longValue;
        return Long.valueOf(j);
    }

    public final int size() {
        return this.f28027c;
    }
}
