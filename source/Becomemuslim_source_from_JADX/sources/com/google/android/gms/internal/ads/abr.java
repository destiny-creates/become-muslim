package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class abr extends aac<Integer> implements abv<Integer>, RandomAccess {
    /* renamed from: a */
    private static final abr f28014a;
    /* renamed from: b */
    private int[] f28015b;
    /* renamed from: c */
    private int f28016c;

    static {
        aac abr = new abr();
        f28014a = abr;
        abr.mo3615b();
    }

    abr() {
        this(new int[10], 0);
    }

    private abr(int[] iArr, int i) {
        this.f28015b = iArr;
        this.f28016c = i;
    }

    /* renamed from: a */
    private final void m36712a(int i, int i2) {
        m29505c();
        if (i < 0 || i > this.f28016c) {
            throw new IndexOutOfBoundsException(m36714e(i));
        }
        if (this.f28016c < this.f28015b.length) {
            System.arraycopy(this.f28015b, i, this.f28015b, i + 1, this.f28016c - i);
        } else {
            Object obj = new int[(((this.f28016c * 3) / 2) + 1)];
            System.arraycopy(this.f28015b, 0, obj, 0, i);
            System.arraycopy(this.f28015b, i, obj, i + 1, this.f28016c - i);
            this.f28015b = obj;
        }
        this.f28015b[i] = i2;
        this.f28016c++;
        this.modCount++;
    }

    /* renamed from: d */
    private final void m36713d(int i) {
        if (i < 0 || i >= this.f28016c) {
            throw new IndexOutOfBoundsException(m36714e(i));
        }
    }

    /* renamed from: e */
    private final String m36714e(int i) {
        int i2 = this.f28016c;
        StringBuilder stringBuilder = new StringBuilder(35);
        stringBuilder.append("Index:");
        stringBuilder.append(i);
        stringBuilder.append(", Size:");
        stringBuilder.append(i2);
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public final /* synthetic */ abv mo6027a(int i) {
        if (i >= this.f28016c) {
            return new abr(Arrays.copyOf(this.f28015b, i), this.f28016c);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ void add(int i, Object obj) {
        m36712a(i, ((Integer) obj).intValue());
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        m29505c();
        abs.m17933a((Object) collection);
        if (!(collection instanceof abr)) {
            return super.addAll(collection);
        }
        abr abr = (abr) collection;
        if (abr.f28016c == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.f28016c >= abr.f28016c) {
            int i = this.f28016c + abr.f28016c;
            if (i > this.f28015b.length) {
                this.f28015b = Arrays.copyOf(this.f28015b, i);
            }
            System.arraycopy(abr.f28015b, 0, this.f28015b, this.f28016c, abr.f28016c);
            this.f28016c = i;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    /* renamed from: b */
    public final int m36716b(int i) {
        m36713d(i);
        return this.f28015b[i];
    }

    /* renamed from: c */
    public final void m36717c(int i) {
        m36712a(this.f28016c, i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof abr)) {
            return super.equals(obj);
        }
        abr abr = (abr) obj;
        if (this.f28016c != abr.f28016c) {
            return false;
        }
        int[] iArr = abr.f28015b;
        for (int i = 0; i < this.f28016c; i++) {
            if (this.f28015b[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(m36716b(i));
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f28016c; i2++) {
            i = (i * 31) + this.f28015b[i2];
        }
        return i;
    }

    public final /* synthetic */ Object remove(int i) {
        m29505c();
        m36713d(i);
        int i2 = this.f28015b[i];
        if (i < this.f28016c - 1) {
            System.arraycopy(this.f28015b, i + 1, this.f28015b, i, this.f28016c - i);
        }
        this.f28016c--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    public final boolean remove(Object obj) {
        m29505c();
        for (int i = 0; i < this.f28016c; i++) {
            if (obj.equals(Integer.valueOf(this.f28015b[i]))) {
                System.arraycopy(this.f28015b, i + 1, this.f28015b, i, this.f28016c - i);
                this.f28016c--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    protected final void removeRange(int i, int i2) {
        m29505c();
        if (i2 >= i) {
            System.arraycopy(this.f28015b, i2, this.f28015b, i, this.f28016c - i2);
            this.f28016c -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        m29505c();
        m36713d(i);
        int i2 = this.f28015b[i];
        this.f28015b[i] = intValue;
        return Integer.valueOf(i2);
    }

    public final int size() {
        return this.f28016c;
    }
}
