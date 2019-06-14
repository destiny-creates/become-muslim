package com.google.android.gms.internal.p210i;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.i.dw */
final class dw extends du<Boolean> implements fr<Boolean>, he, RandomAccess {
    /* renamed from: a */
    private static final dw f28872a;
    /* renamed from: b */
    private boolean[] f28873b;
    /* renamed from: c */
    private int f28874c;

    dw() {
        this(new boolean[10], 0);
    }

    private dw(boolean[] zArr, int i) {
        this.f28873b = zArr;
        this.f28874c = i;
    }

    protected final void removeRange(int i, int i2) {
        m31336c();
        if (i2 >= i) {
            System.arraycopy(this.f28873b, i2, this.f28873b, i, this.f28874c - i2);
            this.f28874c -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dw)) {
            return super.equals(obj);
        }
        dw dwVar = (dw) obj;
        if (this.f28874c != dwVar.f28874c) {
            return false;
        }
        obj = dwVar.f28873b;
        for (int i = 0; i < this.f28874c; i++) {
            if (this.f28873b[i] != obj[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f28874c; i2++) {
            i = (i * 31) + fm.m20555a(this.f28873b[i2]);
        }
        return i;
    }

    public final int size() {
        return this.f28874c;
    }

    /* renamed from: a */
    public final void m37820a(boolean z) {
        m37816a(this.f28874c, z);
    }

    /* renamed from: a */
    private final void m37816a(int i, boolean z) {
        m31336c();
        if (i < 0 || i > this.f28874c) {
            throw new IndexOutOfBoundsException(m37818c(i));
        }
        if (this.f28874c < this.f28873b.length) {
            System.arraycopy(this.f28873b, i, this.f28873b, i + 1, this.f28874c - i);
        } else {
            Object obj = new boolean[(((this.f28874c * 3) / 2) + 1)];
            System.arraycopy(this.f28873b, 0, obj, 0, i);
            System.arraycopy(this.f28873b, i, obj, i + 1, this.f28874c - i);
            this.f28873b = obj;
        }
        this.f28873b[i] = z;
        this.f28874c++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Boolean> collection) {
        m31336c();
        fm.m20556a((Object) collection);
        if (!(collection instanceof dw)) {
            return super.addAll(collection);
        }
        dw dwVar = (dw) collection;
        if (dwVar.f28874c == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.f28874c >= dwVar.f28874c) {
            int i = this.f28874c + dwVar.f28874c;
            if (i > this.f28873b.length) {
                this.f28873b = Arrays.copyOf(this.f28873b, i);
            }
            System.arraycopy(dwVar.f28873b, 0, this.f28873b, this.f28874c, dwVar.f28874c);
            this.f28874c = i;
            this.modCount += 1;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        m31336c();
        for (int i = 0; i < this.f28874c; i++) {
            if (obj.equals(Boolean.valueOf(this.f28873b[i]))) {
                System.arraycopy(this.f28873b, i + 1, this.f28873b, i, (this.f28874c - i) - 1);
                this.f28874c -= 1;
                this.modCount += 1;
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private final void m37817b(int i) {
        if (i < 0 || i >= this.f28874c) {
            throw new IndexOutOfBoundsException(m37818c(i));
        }
    }

    /* renamed from: c */
    private final String m37818c(int i) {
        int i2 = this.f28874c;
        StringBuilder stringBuilder = new StringBuilder(35);
        stringBuilder.append("Index:");
        stringBuilder.append(i);
        stringBuilder.append(", Size:");
        stringBuilder.append(i2);
        return stringBuilder.toString();
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        obj = ((Boolean) obj).booleanValue();
        m31336c();
        m37817b(i);
        boolean z = this.f28873b[i];
        this.f28873b[i] = obj;
        return Boolean.valueOf(z);
    }

    public final /* synthetic */ Object remove(int i) {
        m31336c();
        m37817b(i);
        boolean z = this.f28873b[i];
        if (i < this.f28874c - 1) {
            System.arraycopy(this.f28873b, i + 1, this.f28873b, i, (this.f28874c - i) - 1);
        }
        this.f28874c--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        m37816a(i, ((Boolean) obj).booleanValue());
    }

    /* renamed from: a */
    public final /* synthetic */ fr mo6150a(int i) {
        if (i >= this.f28874c) {
            return new dw(Arrays.copyOf(this.f28873b, i), this.f28874c);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        m37817b(i);
        return Boolean.valueOf(this.f28873b[i]);
    }

    static {
        du dwVar = new dw(new boolean[0], 0);
        f28872a = dwVar;
        dwVar.mo4430b();
    }
}
