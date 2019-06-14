package com.google.android.gms.internal.p210i;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.i.fl */
final class fl extends du<Integer> implements fr<Integer>, he, RandomAccess {
    /* renamed from: a */
    private static final fl f28907a;
    /* renamed from: b */
    private int[] f28908b;
    /* renamed from: c */
    private int f28909c;

    /* renamed from: d */
    public static fl m37954d() {
        return f28907a;
    }

    fl() {
        this(new int[10], 0);
    }

    private fl(int[] iArr, int i) {
        this.f28908b = iArr;
        this.f28909c = i;
    }

    protected final void removeRange(int i, int i2) {
        m31336c();
        if (i2 >= i) {
            System.arraycopy(this.f28908b, i2, this.f28908b, i, this.f28909c - i2);
            this.f28909c -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fl)) {
            return super.equals(obj);
        }
        fl flVar = (fl) obj;
        if (this.f28909c != flVar.f28909c) {
            return false;
        }
        obj = flVar.f28908b;
        for (int i = 0; i < this.f28909c; i++) {
            if (this.f28908b[i] != obj[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f28909c; i2++) {
            i = (i * 31) + this.f28908b[i2];
        }
        return i;
    }

    /* renamed from: b */
    public final int m37958b(int i) {
        m37955d(i);
        return this.f28908b[i];
    }

    public final int size() {
        return this.f28909c;
    }

    /* renamed from: c */
    public final void m37959c(int i) {
        m37953a(this.f28909c, i);
    }

    /* renamed from: a */
    private final void m37953a(int i, int i2) {
        m31336c();
        if (i < 0 || i > this.f28909c) {
            throw new IndexOutOfBoundsException(m37956e(i));
        }
        if (this.f28909c < this.f28908b.length) {
            System.arraycopy(this.f28908b, i, this.f28908b, i + 1, this.f28909c - i);
        } else {
            Object obj = new int[(((this.f28909c * 3) / 2) + 1)];
            System.arraycopy(this.f28908b, 0, obj, 0, i);
            System.arraycopy(this.f28908b, i, obj, i + 1, this.f28909c - i);
            this.f28908b = obj;
        }
        this.f28908b[i] = i2;
        this.f28909c++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        m31336c();
        fm.m20556a((Object) collection);
        if (!(collection instanceof fl)) {
            return super.addAll(collection);
        }
        fl flVar = (fl) collection;
        if (flVar.f28909c == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.f28909c >= flVar.f28909c) {
            int i = this.f28909c + flVar.f28909c;
            if (i > this.f28908b.length) {
                this.f28908b = Arrays.copyOf(this.f28908b, i);
            }
            System.arraycopy(flVar.f28908b, 0, this.f28908b, this.f28909c, flVar.f28909c);
            this.f28909c = i;
            this.modCount += 1;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        m31336c();
        for (int i = 0; i < this.f28909c; i++) {
            if (obj.equals(Integer.valueOf(this.f28908b[i]))) {
                System.arraycopy(this.f28908b, i + 1, this.f28908b, i, (this.f28909c - i) - 1);
                this.f28909c -= 1;
                this.modCount += 1;
                return true;
            }
        }
        return false;
    }

    /* renamed from: d */
    private final void m37955d(int i) {
        if (i < 0 || i >= this.f28909c) {
            throw new IndexOutOfBoundsException(m37956e(i));
        }
    }

    /* renamed from: e */
    private final String m37956e(int i) {
        int i2 = this.f28909c;
        StringBuilder stringBuilder = new StringBuilder(35);
        stringBuilder.append("Index:");
        stringBuilder.append(i);
        stringBuilder.append(", Size:");
        stringBuilder.append(i2);
        return stringBuilder.toString();
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        obj = ((Integer) obj).intValue();
        m31336c();
        m37955d(i);
        int i2 = this.f28908b[i];
        this.f28908b[i] = obj;
        return Integer.valueOf(i2);
    }

    public final /* synthetic */ Object remove(int i) {
        m31336c();
        m37955d(i);
        int i2 = this.f28908b[i];
        if (i < this.f28909c - 1) {
            System.arraycopy(this.f28908b, i + 1, this.f28908b, i, (this.f28909c - i) - 1);
        }
        this.f28909c--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        m37953a(i, ((Integer) obj).intValue());
    }

    /* renamed from: a */
    public final /* synthetic */ fr mo6150a(int i) {
        if (i >= this.f28909c) {
            return new fl(Arrays.copyOf(this.f28908b, i), this.f28909c);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(m37958b(i));
    }

    static {
        du flVar = new fl(new int[0], 0);
        f28907a = flVar;
        flVar.mo4430b();
    }
}
