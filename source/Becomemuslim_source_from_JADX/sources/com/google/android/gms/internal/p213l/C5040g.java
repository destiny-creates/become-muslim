package com.google.android.gms.internal.p213l;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.internal.l.g */
final class C5040g implements Cloneable {
    /* renamed from: a */
    private C5038e<?, ?> f17244a;
    /* renamed from: b */
    private Object f17245b;
    /* renamed from: c */
    private List<C5045l> f17246c = new ArrayList();

    C5040g() {
    }

    /* renamed from: b */
    private final byte[] m21371b() {
        byte[] bArr = new byte[m21373a()];
        m21374a(C5035b.m21283a(bArr));
        return bArr;
    }

    /* renamed from: c */
    private final C5040g m21372c() {
        C5040g c5040g = new C5040g();
        try {
            c5040g.f17244a = this.f17244a;
            if (this.f17246c == null) {
                c5040g.f17246c = null;
            } else {
                c5040g.f17246c.addAll(this.f17246c);
            }
            if (this.f17245b != null) {
                Object obj;
                if (this.f17245b instanceof C5043j) {
                    obj = (C5043j) ((C5043j) this.f17245b).clone();
                } else if (this.f17245b instanceof byte[]) {
                    obj = ((byte[]) this.f17245b).clone();
                } else {
                    int i = 0;
                    Object obj2;
                    if (this.f17245b instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.f17245b;
                        obj2 = new byte[bArr.length][];
                        c5040g.f17245b = obj2;
                        while (i < bArr.length) {
                            obj2[i] = (byte[]) bArr[i].clone();
                            i++;
                        }
                    } else if (this.f17245b instanceof boolean[]) {
                        obj = ((boolean[]) this.f17245b).clone();
                    } else if (this.f17245b instanceof int[]) {
                        obj = ((int[]) this.f17245b).clone();
                    } else if (this.f17245b instanceof long[]) {
                        obj = ((long[]) this.f17245b).clone();
                    } else if (this.f17245b instanceof float[]) {
                        obj = ((float[]) this.f17245b).clone();
                    } else if (this.f17245b instanceof double[]) {
                        obj = ((double[]) this.f17245b).clone();
                    } else if (this.f17245b instanceof C5043j[]) {
                        C5043j[] c5043jArr = (C5043j[]) this.f17245b;
                        obj2 = new C5043j[c5043jArr.length];
                        c5040g.f17245b = obj2;
                        while (i < c5043jArr.length) {
                            obj2[i] = (C5043j) c5043jArr[i].clone();
                            i++;
                        }
                    }
                }
                c5040g.f17245b = obj;
            }
            return c5040g;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: a */
    final int m21373a() {
        int i = 0;
        int i2;
        if (this.f17245b != null) {
            C5038e c5038e = this.f17244a;
            Object obj = this.f17245b;
            if (!c5038e.f17151c) {
                return c5038e.m21343a(obj);
            }
            int length = Array.getLength(obj);
            i2 = 0;
            while (i < length) {
                if (Array.get(obj, i) != null) {
                    i2 += c5038e.m21343a(Array.get(obj, i));
                }
                i++;
            }
            return i2;
        }
        i2 = 0;
        for (C5045l c5045l : this.f17246c) {
            i2 += (C5035b.m21292d(c5045l.f17295a) + 0) + c5045l.f17296b.length;
        }
        return i2;
    }

    /* renamed from: a */
    final void m21374a(C5035b c5035b) {
        if (this.f17245b != null) {
            C5038e c5038e = this.f17244a;
            Object obj = this.f17245b;
            if (c5038e.f17151c) {
                int length = Array.getLength(obj);
                for (int i = 0; i < length; i++) {
                    Object obj2 = Array.get(obj, i);
                    if (obj2 != null) {
                        c5038e.m21345a(obj2, c5035b);
                    }
                }
                return;
            }
            c5038e.m21345a(obj, c5035b);
            return;
        }
        for (C5045l c5045l : this.f17246c) {
            c5035b.m21305c(c5045l.f17295a);
            c5035b.m21304b(c5045l.f17296b);
        }
    }

    /* renamed from: a */
    final void m21375a(C5045l c5045l) {
        if (this.f17246c != null) {
            this.f17246c.add(c5045l);
            return;
        }
        Object a;
        if (this.f17245b instanceof C5043j) {
            byte[] bArr = c5045l.f17296b;
            C5033a a2 = C5033a.m21210a(bArr, 0, bArr.length);
            int d = a2.m21224d();
            if (d == bArr.length - C5035b.m21279a(d)) {
                a = ((C5043j) this.f17245b).mo6216a(a2);
            } else {
                throw C5042i.m21435a();
            }
        } else if (this.f17245b instanceof C5043j[]) {
            C5043j[] c5043jArr = (C5043j[]) this.f17244a.m21344a(Collections.singletonList(c5045l));
            C5043j[] c5043jArr2 = (C5043j[]) this.f17245b;
            Object obj = (C5043j[]) Arrays.copyOf(c5043jArr2, c5043jArr2.length + c5043jArr.length);
            System.arraycopy(c5043jArr, 0, obj, c5043jArr2.length, c5043jArr.length);
            a = obj;
        } else {
            a = this.f17244a.m21344a(Collections.singletonList(c5045l));
        }
        this.f17244a = this.f17244a;
        this.f17245b = a;
        this.f17246c = null;
    }

    public final /* synthetic */ Object clone() {
        return m21372c();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C5040g)) {
            return false;
        }
        C5040g c5040g = (C5040g) obj;
        if (this.f17245b != null && c5040g.f17245b != null) {
            return this.f17244a != c5040g.f17244a ? false : !this.f17244a.f17149a.isArray() ? this.f17245b.equals(c5040g.f17245b) : this.f17245b instanceof byte[] ? Arrays.equals((byte[]) this.f17245b, (byte[]) c5040g.f17245b) : this.f17245b instanceof int[] ? Arrays.equals((int[]) this.f17245b, (int[]) c5040g.f17245b) : this.f17245b instanceof long[] ? Arrays.equals((long[]) this.f17245b, (long[]) c5040g.f17245b) : this.f17245b instanceof float[] ? Arrays.equals((float[]) this.f17245b, (float[]) c5040g.f17245b) : this.f17245b instanceof double[] ? Arrays.equals((double[]) this.f17245b, (double[]) c5040g.f17245b) : this.f17245b instanceof boolean[] ? Arrays.equals((boolean[]) this.f17245b, (boolean[]) c5040g.f17245b) : Arrays.deepEquals((Object[]) this.f17245b, (Object[]) c5040g.f17245b);
        } else {
            if (this.f17246c != null && c5040g.f17246c != null) {
                return this.f17246c.equals(c5040g.f17246c);
            }
            try {
                return Arrays.equals(m21371b(), c5040g.m21371b());
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(m21371b()) + 527;
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }
}
