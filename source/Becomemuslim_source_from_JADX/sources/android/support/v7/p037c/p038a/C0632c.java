package android.support.v7.p037c.p038a;

import java.lang.reflect.Array;

/* compiled from: GrowingArrayUtils */
/* renamed from: android.support.v7.c.a.c */
final class C0632c {
    /* renamed from: a */
    static final /* synthetic */ boolean f1619a = (C0632c.class.desiredAssertionStatus() ^ 1);

    /* renamed from: a */
    public static int m2116a(int i) {
        return i <= 4 ? 8 : i * 2;
    }

    /* renamed from: a */
    public static <T> T[] m2118a(T[] tArr, int i, T t) {
        if (!f1619a) {
            if (i > tArr.length) {
                throw new AssertionError();
            }
        }
        if (i + 1 > tArr.length) {
            T[] tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), C0632c.m2116a(i));
            System.arraycopy(tArr, 0, tArr2, 0, i);
            tArr = tArr2;
        }
        tArr[i] = t;
        return tArr;
    }

    /* renamed from: a */
    public static int[] m2117a(int[] iArr, int i, int i2) {
        if (!f1619a) {
            if (i > iArr.length) {
                throw new AssertionError();
            }
        }
        if (i + 1 > iArr.length) {
            Object obj = new int[C0632c.m2116a(i)];
            System.arraycopy(iArr, 0, obj, 0, i);
            iArr = obj;
        }
        iArr[i] = i2;
        return iArr;
    }

    private C0632c() {
    }
}
