package com.google.android.gms.internal.p210i;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.i.et */
final class et extends du<Double> implements fr<Double>, he, RandomAccess {
    /* renamed from: a */
    private static final et f28899a;
    /* renamed from: b */
    private double[] f28900b;
    /* renamed from: c */
    private int f28901c;

    et() {
        this(new double[10], 0);
    }

    private et(double[] dArr, int i) {
        this.f28900b = dArr;
        this.f28901c = i;
    }

    protected final void removeRange(int i, int i2) {
        m31336c();
        if (i2 >= i) {
            System.arraycopy(this.f28900b, i2, this.f28900b, i, this.f28901c - i2);
            this.f28901c -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof et)) {
            return super.equals(obj);
        }
        et etVar = (et) obj;
        if (this.f28901c != etVar.f28901c) {
            return false;
        }
        obj = etVar.f28900b;
        for (int i = 0; i < this.f28901c; i++) {
            if (Double.doubleToLongBits(this.f28900b[i]) != Double.doubleToLongBits(obj[i])) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f28901c; i2++) {
            i = (i * 31) + fm.m20554a(Double.doubleToLongBits(this.f28900b[i2]));
        }
        return i;
    }

    public final int size() {
        return this.f28901c;
    }

    /* renamed from: a */
    public final void m37932a(double d) {
        m37928a(this.f28901c, d);
    }

    /* renamed from: a */
    private final void m37928a(int i, double d) {
        m31336c();
        if (i < 0 || i > this.f28901c) {
            throw new IndexOutOfBoundsException(m37930c(i));
        }
        if (this.f28901c < this.f28900b.length) {
            System.arraycopy(this.f28900b, i, this.f28900b, i + 1, this.f28901c - i);
        } else {
            Object obj = new double[(((this.f28901c * 3) / 2) + 1)];
            System.arraycopy(this.f28900b, 0, obj, 0, i);
            System.arraycopy(this.f28900b, i, obj, i + 1, this.f28901c - i);
            this.f28900b = obj;
        }
        this.f28900b[i] = d;
        this.f28901c++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Double> collection) {
        m31336c();
        fm.m20556a((Object) collection);
        if (!(collection instanceof et)) {
            return super.addAll(collection);
        }
        et etVar = (et) collection;
        if (etVar.f28901c == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.f28901c >= etVar.f28901c) {
            int i = this.f28901c + etVar.f28901c;
            if (i > this.f28900b.length) {
                this.f28900b = Arrays.copyOf(this.f28900b, i);
            }
            System.arraycopy(etVar.f28900b, 0, this.f28900b, this.f28901c, etVar.f28901c);
            this.f28901c = i;
            this.modCount += 1;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        m31336c();
        for (int i = 0; i < this.f28901c; i++) {
            if (obj.equals(Double.valueOf(this.f28900b[i]))) {
                System.arraycopy(this.f28900b, i + 1, this.f28900b, i, (this.f28901c - i) - 1);
                this.f28901c -= 1;
                this.modCount += 1;
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private final void m37929b(int i) {
        if (i < 0 || i >= this.f28901c) {
            throw new IndexOutOfBoundsException(m37930c(i));
        }
    }

    /* renamed from: c */
    private final String m37930c(int i) {
        int i2 = this.f28901c;
        StringBuilder stringBuilder = new StringBuilder(35);
        stringBuilder.append("Index:");
        stringBuilder.append(i);
        stringBuilder.append(", Size:");
        stringBuilder.append(i2);
        return stringBuilder.toString();
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        m31336c();
        m37929b(i);
        double d = this.f28900b[i];
        this.f28900b[i] = doubleValue;
        return Double.valueOf(d);
    }

    public final /* synthetic */ Object remove(int i) {
        m31336c();
        m37929b(i);
        double d = this.f28900b[i];
        if (i < this.f28901c - 1) {
            System.arraycopy(this.f28900b, i + 1, this.f28900b, i, (this.f28901c - i) - 1);
        }
        this.f28901c--;
        this.modCount++;
        return Double.valueOf(d);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        m37928a(i, ((Double) obj).doubleValue());
    }

    /* renamed from: a */
    public final /* synthetic */ fr mo6150a(int i) {
        if (i >= this.f28901c) {
            return new et(Arrays.copyOf(this.f28900b, i), this.f28901c);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        m37929b(i);
        return Double.valueOf(this.f28900b[i]);
    }

    static {
        du etVar = new et(new double[0], 0);
        f28899a = etVar;
        etVar.mo4430b();
    }
}
