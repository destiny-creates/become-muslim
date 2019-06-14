package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class aaz extends aac<Double> implements abv<Double>, RandomAccess {
    /* renamed from: a */
    private static final aaz f27986a;
    /* renamed from: b */
    private double[] f27987b;
    /* renamed from: c */
    private int f27988c;

    static {
        aac aaz = new aaz();
        f27986a = aaz;
        aaz.mo3615b();
    }

    aaz() {
        this(new double[10], 0);
    }

    private aaz(double[] dArr, int i) {
        this.f27987b = dArr;
        this.f27988c = i;
    }

    /* renamed from: a */
    private final void m36697a(int i, double d) {
        m29505c();
        if (i < 0 || i > this.f27988c) {
            throw new IndexOutOfBoundsException(m36699c(i));
        }
        if (this.f27988c < this.f27987b.length) {
            System.arraycopy(this.f27987b, i, this.f27987b, i + 1, this.f27988c - i);
        } else {
            Object obj = new double[(((this.f27988c * 3) / 2) + 1)];
            System.arraycopy(this.f27987b, 0, obj, 0, i);
            System.arraycopy(this.f27987b, i, obj, i + 1, this.f27988c - i);
            this.f27987b = obj;
        }
        this.f27987b[i] = d;
        this.f27988c++;
        this.modCount++;
    }

    /* renamed from: b */
    private final void m36698b(int i) {
        if (i < 0 || i >= this.f27988c) {
            throw new IndexOutOfBoundsException(m36699c(i));
        }
    }

    /* renamed from: c */
    private final String m36699c(int i) {
        int i2 = this.f27988c;
        StringBuilder stringBuilder = new StringBuilder(35);
        stringBuilder.append("Index:");
        stringBuilder.append(i);
        stringBuilder.append(", Size:");
        stringBuilder.append(i2);
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public final /* synthetic */ abv mo6027a(int i) {
        if (i >= this.f27988c) {
            return new aaz(Arrays.copyOf(this.f27987b, i), this.f27988c);
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: a */
    public final void m36701a(double d) {
        m36697a(this.f27988c, d);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        m36697a(i, ((Double) obj).doubleValue());
    }

    public final boolean addAll(Collection<? extends Double> collection) {
        m29505c();
        abs.m17933a((Object) collection);
        if (!(collection instanceof aaz)) {
            return super.addAll(collection);
        }
        aaz aaz = (aaz) collection;
        if (aaz.f27988c == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.f27988c >= aaz.f27988c) {
            int i = this.f27988c + aaz.f27988c;
            if (i > this.f27987b.length) {
                this.f27987b = Arrays.copyOf(this.f27987b, i);
            }
            System.arraycopy(aaz.f27987b, 0, this.f27987b, this.f27988c, aaz.f27988c);
            this.f27988c = i;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof aaz)) {
            return super.equals(obj);
        }
        aaz aaz = (aaz) obj;
        if (this.f27988c != aaz.f27988c) {
            return false;
        }
        double[] dArr = aaz.f27987b;
        for (int i = 0; i < this.f27988c; i++) {
            if (this.f27987b[i] != dArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        m36698b(i);
        return Double.valueOf(this.f27987b[i]);
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f27988c; i2++) {
            i = (i * 31) + abs.m17931a(Double.doubleToLongBits(this.f27987b[i2]));
        }
        return i;
    }

    public final /* synthetic */ Object remove(int i) {
        m29505c();
        m36698b(i);
        double d = this.f27987b[i];
        if (i < this.f27988c - 1) {
            System.arraycopy(this.f27987b, i + 1, this.f27987b, i, this.f27988c - i);
        }
        this.f27988c--;
        this.modCount++;
        return Double.valueOf(d);
    }

    public final boolean remove(Object obj) {
        m29505c();
        for (int i = 0; i < this.f27988c; i++) {
            if (obj.equals(Double.valueOf(this.f27987b[i]))) {
                System.arraycopy(this.f27987b, i + 1, this.f27987b, i, this.f27988c - i);
                this.f27988c--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    protected final void removeRange(int i, int i2) {
        m29505c();
        if (i2 >= i) {
            System.arraycopy(this.f27987b, i2, this.f27987b, i, this.f27988c - i2);
            this.f27988c -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        m29505c();
        m36698b(i);
        double d = this.f27987b[i];
        this.f27987b[i] = doubleValue;
        return Double.valueOf(d);
    }

    public final int size() {
        return this.f27988c;
    }
}
