package com.google.android.gms.internal.p210i;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.internal.i.jc */
public final class jc<M extends jb<M>, T> {
    /* renamed from: a */
    protected final Class<T> f16777a;
    /* renamed from: b */
    public final int f16778b;
    /* renamed from: c */
    protected final boolean f16779c;
    /* renamed from: d */
    private final int f16780d;
    /* renamed from: e */
    private final fk<?, ?> f16781e;

    /* renamed from: a */
    public static <M extends jb<M>, T extends jh> jc<M, T> m20982a(int i, Class<T> cls, long j) {
        return new jc(11, cls, 810, false);
    }

    private jc(int i, Class<T> cls, int i2, boolean z) {
        this(11, cls, null, 810, false);
    }

    private jc(int i, Class<T> cls, fk<?, ?> fkVar, int i2, boolean z) {
        this.f16780d = i;
        this.f16777a = cls;
        this.f16778b = i2;
        this.f16779c = false;
        this.f16781e = 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof jc)) {
            return false;
        }
        jc jcVar = (jc) obj;
        return this.f16780d == jcVar.f16780d && this.f16777a == jcVar.f16777a && this.f16778b == jcVar.f16778b && this.f16779c == jcVar.f16779c;
    }

    public final int hashCode() {
        return ((((((this.f16780d + 1147) * 31) + this.f16777a.hashCode()) * 31) + this.f16778b) * 31) + this.f16779c;
    }

    /* renamed from: a */
    final T m20985a(List<jj> list) {
        if (list == null) {
            return null;
        }
        if (this.f16779c) {
            List arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                jj jjVar = (jj) list.get(i);
                if (jjVar.f16795b.length != 0) {
                    arrayList.add(m20983a(iy.m20931a(jjVar.f16795b)));
                }
            }
            list = arrayList.size();
            if (list == null) {
                return null;
            }
            T cast = this.f16777a.cast(Array.newInstance(this.f16777a.getComponentType(), list));
            for (int i2 = 0; i2 < list; i2++) {
                Array.set(cast, i2, arrayList.get(i2));
            }
            return cast;
        } else if (list.isEmpty()) {
            return null;
        } else {
            return this.f16777a.cast(m20983a(iy.m20931a(((jj) list.get(list.size() - 1)).f16795b)));
        }
    }

    /* renamed from: a */
    private final Object m20983a(iy iyVar) {
        String valueOf;
        Class componentType = this.f16779c ? this.f16777a.getComponentType() : this.f16777a;
        StringBuilder stringBuilder;
        try {
            jh jhVar;
            switch (this.f16780d) {
                case 10:
                    jhVar = (jh) componentType.newInstance();
                    iyVar.m20941a(jhVar, this.f16778b >>> 3);
                    return jhVar;
                case 11:
                    jhVar = (jh) componentType.newInstance();
                    iyVar.m20940a(jhVar);
                    return jhVar;
                default:
                    int i = this.f16780d;
                    stringBuilder = new StringBuilder(24);
                    stringBuilder.append("Unknown type ");
                    stringBuilder.append(i);
                    throw new IllegalArgumentException(stringBuilder.toString());
            }
        } catch (iy iyVar2) {
            valueOf = String.valueOf(componentType);
            stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 33);
            stringBuilder.append("Error creating instance of class ");
            stringBuilder.append(valueOf);
            throw new IllegalArgumentException(stringBuilder.toString(), iyVar2);
        } catch (iy iyVar22) {
            valueOf = String.valueOf(componentType);
            stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 33);
            stringBuilder.append("Error creating instance of class ");
            stringBuilder.append(valueOf);
            throw new IllegalArgumentException(stringBuilder.toString(), iyVar22);
        } catch (iy iyVar222) {
            throw new IllegalArgumentException("Error reading extension field", iyVar222);
        }
    }

    /* renamed from: a */
    protected final void m20986a(Object obj, iz izVar) {
        try {
            izVar.m20979c(this.f16778b);
            switch (this.f16780d) {
                case 10:
                    int i = this.f16778b >>> 3;
                    ((jh) obj).mo4622a(izVar);
                    izVar.m20980c(i, 4);
                    return;
                case 11:
                    izVar.m20977a((jh) obj);
                    return;
                default:
                    izVar = this.f16780d;
                    StringBuilder stringBuilder = new StringBuilder(24);
                    stringBuilder.append("Unknown type ");
                    stringBuilder.append(izVar);
                    throw new IllegalArgumentException(stringBuilder.toString());
            }
        } catch (Object obj2) {
            throw new IllegalStateException(obj2);
        }
    }

    /* renamed from: a */
    protected final int m20984a(Object obj) {
        int i = this.f16778b >>> 3;
        switch (this.f16780d) {
            case 10:
                return (iz.m20962b(i) << 1) + ((jh) obj).m21017e();
            case 11:
                return iz.m20965b(i, (jh) obj);
            default:
                i = this.f16780d;
                StringBuilder stringBuilder = new StringBuilder(24);
                stringBuilder.append("Unknown type ");
                stringBuilder.append(i);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }
}
