package com.google.p217b.p218a.p221c;

import com.facebook.imageutils.JfifUtil;
import com.google.p217b.p222b.C5196a;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: HighLevelEncoder */
/* renamed from: com.google.b.a.c.d */
public final class C5190d {
    /* renamed from: a */
    static final String[] f17477a = new String[]{"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};
    /* renamed from: b */
    static final int[][] f17478b = new int[][]{new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};
    /* renamed from: c */
    static final int[][] f17479c;
    /* renamed from: d */
    private static final int[][] f17480d;
    /* renamed from: e */
    private final byte[] f17481e;

    /* compiled from: HighLevelEncoder */
    /* renamed from: com.google.b.a.c.d$1 */
    class C51891 implements Comparator<C5191f> {
        /* renamed from: a */
        final /* synthetic */ C5190d f17476a;

        C51891(C5190d c5190d) {
            this.f17476a = c5190d;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m21924a((C5191f) obj, (C5191f) obj2);
        }

        /* renamed from: a */
        public int m21924a(C5191f c5191f, C5191f c5191f2) {
            return c5191f.m21939c() - c5191f2.m21939c();
        }
    }

    static {
        int i;
        int[][] iArr = (int[][]) Array.newInstance(int.class, new int[]{5, 256});
        f17480d = iArr;
        iArr[0][32] = 1;
        for (i = 65; i <= 90; i++) {
            f17480d[0][i] = (i - 65) + 2;
        }
        f17480d[1][32] = 1;
        for (i = 97; i <= 122; i++) {
            f17480d[1][i] = (i - 97) + 2;
        }
        f17480d[2][32] = 1;
        for (i = 48; i <= 57; i++) {
            f17480d[2][i] = (i - 48) + 2;
        }
        f17480d[2][44] = 12;
        f17480d[2][46] = 13;
        int[] iArr2 = new int[]{0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, 127};
        for (int i2 = 0; i2 < 28; i2++) {
            f17480d[3][iArr2[i2]] = i2;
        }
        int[] iArr3 = new int[]{0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, 125};
        for (int i3 = 0; i3 < 31; i3++) {
            if (iArr3[i3] > 0) {
                f17480d[4][iArr3[i3]] = i3;
            }
        }
        int[][] iArr4 = (int[][]) Array.newInstance(int.class, new int[]{6, 6});
        f17479c = iArr4;
        for (int[] fill : iArr4) {
            Arrays.fill(fill, -1);
        }
        f17479c[0][4] = 0;
        f17479c[1][4] = 0;
        f17479c[1][0] = 28;
        f17479c[3][4] = 0;
        f17479c[2][4] = 0;
        f17479c[2][0] = 15;
    }

    public C5190d(byte[] bArr) {
        this.f17481e = bArr;
    }

    /* renamed from: a */
    public C5196a m21930a() {
        Iterable singletonList = Collections.singletonList(C5191f.f17482a);
        int i = 0;
        while (i < this.f17481e.length) {
            int i2;
            int i3 = i + 1;
            byte b = i3 < this.f17481e.length ? this.f17481e[i3] : (byte) 0;
            byte b2 = this.f17481e[i];
            if (b2 != (byte) 13) {
                if (b2 != (byte) 44) {
                    if (b2 != (byte) 46) {
                        if (b2 == (byte) 58 && b == (byte) 32) {
                            i2 = 5;
                            if (i2 > 0) {
                                singletonList = C5190d.m21927a(singletonList, i, i2);
                                i = i3;
                            } else {
                                singletonList = m21926a(singletonList, i);
                            }
                            i++;
                        }
                    } else if (b == (byte) 32) {
                        i2 = 3;
                        if (i2 > 0) {
                            singletonList = m21926a(singletonList, i);
                        } else {
                            singletonList = C5190d.m21927a(singletonList, i, i2);
                            i = i3;
                        }
                        i++;
                    }
                } else if (b == (byte) 32) {
                    i2 = 4;
                    if (i2 > 0) {
                        singletonList = C5190d.m21927a(singletonList, i, i2);
                        i = i3;
                    } else {
                        singletonList = m21926a(singletonList, i);
                    }
                    i++;
                }
            } else if (b == (byte) 10) {
                i2 = 2;
                if (i2 > 0) {
                    singletonList = m21926a(singletonList, i);
                } else {
                    singletonList = C5190d.m21927a(singletonList, i, i2);
                    i = i3;
                }
                i++;
            }
            i2 = 0;
            if (i2 > 0) {
                singletonList = C5190d.m21927a(singletonList, i, i2);
                i = i3;
            } else {
                singletonList = m21926a(singletonList, i);
            }
            i++;
        }
        return ((C5191f) Collections.min(singletonList, new C51891(this))).m21934a(this.f17481e);
    }

    /* renamed from: a */
    private Collection<C5191f> m21926a(Iterable<C5191f> iterable, int i) {
        Collection linkedList = new LinkedList();
        for (C5191f a : iterable) {
            m21929a(a, i, linkedList);
        }
        return C5190d.m21925a(linkedList);
    }

    /* renamed from: a */
    private void m21929a(C5191f c5191f, int i, Collection<C5191f> collection) {
        char c = (char) (this.f17481e[i] & JfifUtil.MARKER_FIRST_BYTE);
        int i2 = 0;
        Object obj = f17480d[c5191f.m21931a()][c] > 0 ? 1 : null;
        C5191f c5191f2 = null;
        while (i2 <= 4) {
            int i3 = f17480d[i2][c];
            if (i3 > 0) {
                if (c5191f2 == null) {
                    c5191f2 = c5191f.m21937b(i);
                }
                if (obj == null || i2 == c5191f.m21931a() || i2 == 2) {
                    collection.add(c5191f2.m21933a(i2, i3));
                }
                if (obj == null && f17479c[c5191f.m21931a()][i2] >= 0) {
                    collection.add(c5191f2.m21938b(i2, i3));
                }
            }
            i2++;
        }
        if (c5191f.m21936b() > 0 || f17480d[c5191f.m21931a()][c] == 0) {
            collection.add(c5191f.m21932a(i));
        }
    }

    /* renamed from: a */
    private static Collection<C5191f> m21927a(Iterable<C5191f> iterable, int i, int i2) {
        Iterable linkedList = new LinkedList();
        for (C5191f a : iterable) {
            C5190d.m21928a(a, i, i2, linkedList);
        }
        return C5190d.m21925a(linkedList);
    }

    /* renamed from: a */
    private static void m21928a(C5191f c5191f, int i, int i2, Collection<C5191f> collection) {
        C5191f b = c5191f.m21937b(i);
        collection.add(b.m21933a(4, i2));
        if (c5191f.m21931a() != 4) {
            collection.add(b.m21938b(4, i2));
        }
        if (i2 == 3 || i2 == 4) {
            collection.add(b.m21933a(2, 16 - i2).m21933a(2, 1));
        }
        if (c5191f.m21936b() > 0) {
            collection.add(c5191f.m21932a(i).m21932a(i + 1));
        }
    }

    /* renamed from: a */
    private static Collection<C5191f> m21925a(Iterable<C5191f> iterable) {
        Collection linkedList = new LinkedList();
        for (C5191f c5191f : iterable) {
            Object obj = 1;
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                C5191f c5191f2 = (C5191f) it.next();
                if (c5191f2.m21935a(c5191f)) {
                    obj = null;
                    break;
                } else if (c5191f.m21935a(c5191f2)) {
                    it.remove();
                }
            }
            if (obj != null) {
                linkedList.add(c5191f);
            }
        }
        return linkedList;
    }
}
