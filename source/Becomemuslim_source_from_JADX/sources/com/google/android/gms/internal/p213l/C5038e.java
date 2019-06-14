package com.google.android.gms.internal.p213l;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.internal.l.e */
public final class C5038e<M extends C6823d<M>, T> {
    /* renamed from: a */
    protected final Class<T> f17149a;
    /* renamed from: b */
    public final int f17150b;
    /* renamed from: c */
    protected final boolean f17151c;
    /* renamed from: d */
    private final int f17152d;

    /* renamed from: a */
    private final Object m21342a(C5033a c5033a) {
        StringBuilder stringBuilder;
        String valueOf;
        Class componentType = this.f17151c ? this.f17149a.getComponentType() : this.f17149a;
        try {
            C5043j c5043j;
            switch (this.f17152d) {
                case 10:
                    c5043j = (C5043j) componentType.newInstance();
                    c5033a.m21217a(c5043j, this.f17150b >>> 3);
                    return c5043j;
                case 11:
                    c5043j = (C5043j) componentType.newInstance();
                    c5033a.m21216a(c5043j);
                    return c5043j;
                default:
                    int i = this.f17152d;
                    stringBuilder = new StringBuilder(24);
                    stringBuilder.append("Unknown type ");
                    stringBuilder.append(i);
                    throw new IllegalArgumentException(stringBuilder.toString());
            }
        } catch (Throwable e) {
            valueOf = String.valueOf(componentType);
            stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 33);
            stringBuilder.append("Error creating instance of class ");
            stringBuilder.append(valueOf);
            throw new IllegalArgumentException(stringBuilder.toString(), e);
        } catch (Throwable e2) {
            valueOf = String.valueOf(componentType);
            stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 33);
            stringBuilder.append("Error creating instance of class ");
            stringBuilder.append(valueOf);
            throw new IllegalArgumentException(stringBuilder.toString(), e2);
        } catch (Throwable e22) {
            throw new IllegalArgumentException("Error reading extension field", e22);
        }
    }

    /* renamed from: a */
    protected final int m21343a(Object obj) {
        int i = this.f17150b >>> 3;
        switch (this.f17152d) {
            case 10:
                return (C5035b.m21286b(i) << 1) + ((C5043j) obj).m21444d();
            case 11:
                return C5035b.m21288b(i, (C5043j) obj);
            default:
                i = this.f17152d;
                StringBuilder stringBuilder = new StringBuilder(24);
                stringBuilder.append("Unknown type ");
                stringBuilder.append(i);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    final T m21344a(List<C5045l> list) {
        if (list == null) {
            return null;
        }
        if (this.f17151c) {
            List arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                C5045l c5045l = (C5045l) list.get(i);
                if (c5045l.f17296b.length != 0) {
                    arrayList.add(m21342a(C5033a.m21209a(c5045l.f17296b)));
                }
            }
            int size = arrayList.size();
            if (size == 0) {
                return null;
            }
            T cast = this.f17149a.cast(Array.newInstance(this.f17149a.getComponentType(), size));
            for (int i2 = 0; i2 < size; i2++) {
                Array.set(cast, i2, arrayList.get(i2));
            }
            return cast;
        } else if (list.isEmpty()) {
            return null;
        } else {
            return this.f17149a.cast(m21342a(C5033a.m21209a(((C5045l) list.get(list.size() - 1)).f17296b)));
        }
    }

    /* renamed from: a */
    protected final void m21345a(Object obj, C5035b c5035b) {
        try {
            c5035b.m21305c(this.f17150b);
            switch (this.f17152d) {
                case 10:
                    int i = this.f17150b >>> 3;
                    ((C5043j) obj).mo4757a(c5035b);
                    c5035b.m21306c(i, 4);
                    return;
                case 11:
                    c5035b.m21302a((C5043j) obj);
                    return;
                default:
                    int i2 = this.f17152d;
                    StringBuilder stringBuilder = new StringBuilder(24);
                    stringBuilder.append("Unknown type ");
                    stringBuilder.append(i2);
                    throw new IllegalArgumentException(stringBuilder.toString());
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5038e)) {
            return false;
        }
        C5038e c5038e = (C5038e) obj;
        return this.f17152d == c5038e.f17152d && this.f17149a == c5038e.f17149a && this.f17150b == c5038e.f17150b && this.f17151c == c5038e.f17151c;
    }

    public final int hashCode() {
        return ((((((this.f17152d + 1147) * 31) + this.f17149a.hashCode()) * 31) + this.f17150b) * 31) + this.f17151c;
    }
}
