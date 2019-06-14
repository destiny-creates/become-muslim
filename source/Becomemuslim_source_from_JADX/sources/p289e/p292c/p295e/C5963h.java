package p289e.p292c.p295e;

import p289e.p292c.p295e.p297b.C5958h;

/* compiled from: OpenHashSet */
/* renamed from: e.c.e.h */
public final class C5963h<T> {
    /* renamed from: a */
    final float f19725a;
    /* renamed from: b */
    int f19726b;
    /* renamed from: c */
    int f19727c;
    /* renamed from: d */
    int f19728d;
    /* renamed from: e */
    T[] f19729e;

    /* renamed from: a */
    static int m24935a(int i) {
        i *= -1640531527;
        return i ^ (i >>> 16);
    }

    public C5963h() {
        this(16, 0.75f);
    }

    public C5963h(int i, float f) {
        this.f19725a = f;
        i = C5958h.m24924a(i);
        this.f19726b = i - 1;
        this.f19728d = (int) (f * ((float) i));
        this.f19729e = (Object[]) new Object[i];
    }

    /* renamed from: a */
    public boolean m24938a(T t) {
        Object[] objArr = this.f19729e;
        int i = this.f19726b;
        int a = C5963h.m24935a(t.hashCode()) & i;
        Object obj = objArr[a];
        if (obj != null) {
            if (obj.equals(t)) {
                return false;
            }
            do {
                a = (a + 1) & i;
                obj = objArr[a];
                if (obj == null) {
                }
            } while (!obj.equals(t));
            return false;
        }
        objArr[a] = t;
        t = this.f19727c + 1;
        this.f19727c = t;
        if (t >= this.f19728d) {
            m24939b();
        }
        return true;
    }

    /* renamed from: b */
    public boolean m24940b(T t) {
        Object[] objArr = this.f19729e;
        int i = this.f19726b;
        int a = C5963h.m24935a(t.hashCode()) & i;
        Object obj = objArr[a];
        if (obj == null) {
            return false;
        }
        if (obj.equals(t)) {
            return m24937a(a, objArr, i);
        }
        do {
            a = (a + 1) & i;
            obj = objArr[a];
            if (obj == null) {
                return false;
            }
        } while (!obj.equals(t));
        return m24937a(a, objArr, i);
    }

    /* renamed from: a */
    boolean m24937a(int i, T[] tArr, int i2) {
        this.f19727c--;
        while (true) {
            Object obj;
            int i3 = (i + 1) & i2;
            while (true) {
                obj = tArr[i3];
                if (obj == null) {
                    tArr[i] = 0;
                    return true;
                }
                int a = C5963h.m24935a(obj.hashCode()) & i2;
                if (i > i3) {
                    if (i >= a && a > i3) {
                        break;
                    }
                    i3 = (i3 + 1) & i2;
                } else if (i >= a) {
                    break;
                } else if (a > i3) {
                    break;
                } else {
                    i3 = (i3 + 1) & i2;
                }
            }
            tArr[i] = obj;
            i = i3;
        }
    }

    /* renamed from: a */
    public void m24936a() {
        this.f19727c = 0;
        this.f19729e = new Object[0];
    }

    /* renamed from: b */
    void m24939b() {
        Object[] objArr = this.f19729e;
        int length = objArr.length;
        int i = length << 1;
        int i2 = i - 1;
        Object[] objArr2 = new Object[i];
        int i3 = this.f19727c;
        while (true) {
            int i4 = i3 - 1;
            if (i3 != 0) {
                while (true) {
                    length--;
                    if (objArr[length] != null) {
                        break;
                    }
                }
                i3 = C5963h.m24935a(objArr[length].hashCode()) & i2;
                if (objArr2[i3] != null) {
                    do {
                        i3 = (i3 + 1) & i2;
                    } while (objArr2[i3] != null);
                }
                objArr2[i3] = objArr[length];
                i3 = i4;
            } else {
                this.f19726b = i2;
                this.f19728d = (int) (((float) i) * this.f19725a);
                this.f19729e = objArr2;
                return;
            }
        }
    }

    /* renamed from: c */
    public boolean m24941c() {
        return this.f19727c == 0;
    }

    /* renamed from: d */
    public T[] m24942d() {
        return this.f19729e;
    }
}
