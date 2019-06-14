package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class abo extends aac<Float> implements abv<Float>, RandomAccess {
    /* renamed from: a */
    private static final abo f28011a;
    /* renamed from: b */
    private float[] f28012b;
    /* renamed from: c */
    private int f28013c;

    static {
        aac abo = new abo();
        f28011a = abo;
        abo.mo3615b();
    }

    abo() {
        this(new float[10], 0);
    }

    private abo(float[] fArr, int i) {
        this.f28012b = fArr;
        this.f28013c = i;
    }

    /* renamed from: a */
    private final void m36707a(int i, float f) {
        m29505c();
        if (i < 0 || i > this.f28013c) {
            throw new IndexOutOfBoundsException(m36709c(i));
        }
        if (this.f28013c < this.f28012b.length) {
            System.arraycopy(this.f28012b, i, this.f28012b, i + 1, this.f28013c - i);
        } else {
            Object obj = new float[(((this.f28013c * 3) / 2) + 1)];
            System.arraycopy(this.f28012b, 0, obj, 0, i);
            System.arraycopy(this.f28012b, i, obj, i + 1, this.f28013c - i);
            this.f28012b = obj;
        }
        this.f28012b[i] = f;
        this.f28013c++;
        this.modCount++;
    }

    /* renamed from: b */
    private final void m36708b(int i) {
        if (i < 0 || i >= this.f28013c) {
            throw new IndexOutOfBoundsException(m36709c(i));
        }
    }

    /* renamed from: c */
    private final String m36709c(int i) {
        int i2 = this.f28013c;
        StringBuilder stringBuilder = new StringBuilder(35);
        stringBuilder.append("Index:");
        stringBuilder.append(i);
        stringBuilder.append(", Size:");
        stringBuilder.append(i2);
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public final /* synthetic */ abv mo6027a(int i) {
        if (i >= this.f28013c) {
            return new abo(Arrays.copyOf(this.f28012b, i), this.f28013c);
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: a */
    public final void m36711a(float f) {
        m36707a(this.f28013c, f);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        m36707a(i, ((Float) obj).floatValue());
    }

    public final boolean addAll(Collection<? extends Float> collection) {
        m29505c();
        abs.m17933a((Object) collection);
        if (!(collection instanceof abo)) {
            return super.addAll(collection);
        }
        abo abo = (abo) collection;
        if (abo.f28013c == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.f28013c >= abo.f28013c) {
            int i = this.f28013c + abo.f28013c;
            if (i > this.f28012b.length) {
                this.f28012b = Arrays.copyOf(this.f28012b, i);
            }
            System.arraycopy(abo.f28012b, 0, this.f28012b, this.f28013c, abo.f28013c);
            this.f28013c = i;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof abo)) {
            return super.equals(obj);
        }
        abo abo = (abo) obj;
        if (this.f28013c != abo.f28013c) {
            return false;
        }
        float[] fArr = abo.f28012b;
        for (int i = 0; i < this.f28013c; i++) {
            if (this.f28012b[i] != fArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        m36708b(i);
        return Float.valueOf(this.f28012b[i]);
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f28013c; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.f28012b[i2]);
        }
        return i;
    }

    public final /* synthetic */ Object remove(int i) {
        m29505c();
        m36708b(i);
        float f = this.f28012b[i];
        if (i < this.f28013c - 1) {
            System.arraycopy(this.f28012b, i + 1, this.f28012b, i, this.f28013c - i);
        }
        this.f28013c--;
        this.modCount++;
        return Float.valueOf(f);
    }

    public final boolean remove(Object obj) {
        m29505c();
        for (int i = 0; i < this.f28013c; i++) {
            if (obj.equals(Float.valueOf(this.f28012b[i]))) {
                System.arraycopy(this.f28012b, i + 1, this.f28012b, i, this.f28013c - i);
                this.f28013c--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    protected final void removeRange(int i, int i2) {
        m29505c();
        if (i2 >= i) {
            System.arraycopy(this.f28012b, i2, this.f28012b, i, this.f28013c - i2);
            this.f28013c -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        m29505c();
        m36708b(i);
        float f = this.f28012b[i];
        this.f28012b[i] = floatValue;
        return Float.valueOf(f);
    }

    public final int size() {
        return this.f28013c;
    }
}
