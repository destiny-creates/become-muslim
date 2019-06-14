package com.google.android.gms.internal.p210i;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.i.fg */
final class fg extends du<Float> implements fr<Float>, he, RandomAccess {
    /* renamed from: a */
    private static final fg f28903a;
    /* renamed from: b */
    private float[] f28904b;
    /* renamed from: c */
    private int f28905c;

    fg() {
        this(new float[10], 0);
    }

    private fg(float[] fArr, int i) {
        this.f28904b = fArr;
        this.f28905c = i;
    }

    protected final void removeRange(int i, int i2) {
        m31336c();
        if (i2 >= i) {
            System.arraycopy(this.f28904b, i2, this.f28904b, i, this.f28905c - i2);
            this.f28905c -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fg)) {
            return super.equals(obj);
        }
        fg fgVar = (fg) obj;
        if (this.f28905c != fgVar.f28905c) {
            return false;
        }
        obj = fgVar.f28904b;
        for (int i = 0; i < this.f28905c; i++) {
            if (Float.floatToIntBits(this.f28904b[i]) != Float.floatToIntBits(obj[i])) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f28905c; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.f28904b[i2]);
        }
        return i;
    }

    public final int size() {
        return this.f28905c;
    }

    /* renamed from: a */
    public final void m37951a(float f) {
        m37947a(this.f28905c, f);
    }

    /* renamed from: a */
    private final void m37947a(int i, float f) {
        m31336c();
        if (i < 0 || i > this.f28905c) {
            throw new IndexOutOfBoundsException(m37949c(i));
        }
        if (this.f28905c < this.f28904b.length) {
            System.arraycopy(this.f28904b, i, this.f28904b, i + 1, this.f28905c - i);
        } else {
            Object obj = new float[(((this.f28905c * 3) / 2) + 1)];
            System.arraycopy(this.f28904b, 0, obj, 0, i);
            System.arraycopy(this.f28904b, i, obj, i + 1, this.f28905c - i);
            this.f28904b = obj;
        }
        this.f28904b[i] = f;
        this.f28905c++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Float> collection) {
        m31336c();
        fm.m20556a((Object) collection);
        if (!(collection instanceof fg)) {
            return super.addAll(collection);
        }
        fg fgVar = (fg) collection;
        if (fgVar.f28905c == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.f28905c >= fgVar.f28905c) {
            int i = this.f28905c + fgVar.f28905c;
            if (i > this.f28904b.length) {
                this.f28904b = Arrays.copyOf(this.f28904b, i);
            }
            System.arraycopy(fgVar.f28904b, 0, this.f28904b, this.f28905c, fgVar.f28905c);
            this.f28905c = i;
            this.modCount += 1;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        m31336c();
        for (int i = 0; i < this.f28905c; i++) {
            if (obj.equals(Float.valueOf(this.f28904b[i]))) {
                System.arraycopy(this.f28904b, i + 1, this.f28904b, i, (this.f28905c - i) - 1);
                this.f28905c -= 1;
                this.modCount += 1;
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private final void m37948b(int i) {
        if (i < 0 || i >= this.f28905c) {
            throw new IndexOutOfBoundsException(m37949c(i));
        }
    }

    /* renamed from: c */
    private final String m37949c(int i) {
        int i2 = this.f28905c;
        StringBuilder stringBuilder = new StringBuilder(35);
        stringBuilder.append("Index:");
        stringBuilder.append(i);
        stringBuilder.append(", Size:");
        stringBuilder.append(i2);
        return stringBuilder.toString();
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        obj = ((Float) obj).floatValue();
        m31336c();
        m37948b(i);
        float f = this.f28904b[i];
        this.f28904b[i] = obj;
        return Float.valueOf(f);
    }

    public final /* synthetic */ Object remove(int i) {
        m31336c();
        m37948b(i);
        float f = this.f28904b[i];
        if (i < this.f28905c - 1) {
            System.arraycopy(this.f28904b, i + 1, this.f28904b, i, (this.f28905c - i) - 1);
        }
        this.f28905c--;
        this.modCount++;
        return Float.valueOf(f);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        m37947a(i, ((Float) obj).floatValue());
    }

    /* renamed from: a */
    public final /* synthetic */ fr mo6150a(int i) {
        if (i >= this.f28905c) {
            return new fg(Arrays.copyOf(this.f28904b, i), this.f28905c);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        m37948b(i);
        return Float.valueOf(this.f28904b[i]);
    }

    static {
        du fgVar = new fg(new float[0], 0);
        f28903a = fgVar;
        fgVar.mo4430b();
    }
}
