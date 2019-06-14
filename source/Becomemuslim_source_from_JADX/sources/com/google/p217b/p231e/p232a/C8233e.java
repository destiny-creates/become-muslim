package com.google.p217b.p231e.p232a;

import com.facebook.device.yearclass.YearClass;
import com.google.p217b.C5193a;
import com.google.p217b.C5254e;
import com.google.p217b.C5314q;
import com.google.p217b.C5316s;
import com.google.p217b.C6894l;
import com.google.p217b.p222b.C5196a;
import com.google.p217b.p222b.p223a.C5194a;
import com.google.p217b.p231e.C6873r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: RSS14Reader */
/* renamed from: com.google.b.e.a.e */
public final class C8233e extends C7900a {
    /* renamed from: a */
    private static final int[] f32391a = new int[]{1, 10, 34, 70, 126};
    /* renamed from: b */
    private static final int[] f32392b = new int[]{4, 20, 48, 81};
    /* renamed from: c */
    private static final int[] f32393c = new int[]{0, 161, 961, YearClass.CLASS_2015, 2715};
    /* renamed from: d */
    private static final int[] f32394d = new int[]{0, 336, 1036, 1516};
    /* renamed from: e */
    private static final int[] f32395e = new int[]{8, 6, 4, 3, 1};
    /* renamed from: f */
    private static final int[] f32396f = new int[]{2, 4, 6, 8};
    /* renamed from: g */
    private static final int[][] f32397g = new int[][]{new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};
    /* renamed from: h */
    private final List<C6872d> f32398h = new ArrayList();
    /* renamed from: i */
    private final List<C6872d> f32399i = new ArrayList();

    /* renamed from: a */
    public C5314q mo6260a(int i, C5196a c5196a, Map<C5254e, ?> map) {
        C8233e.m42770a(this.f32398h, m42768a(c5196a, false, i, (Map) map));
        c5196a.m21969e();
        C8233e.m42770a(this.f32399i, m42768a(c5196a, true, i, (Map) map));
        c5196a.m21969e();
        for (C6872d c6872d : this.f32398h) {
            if (c6872d.m32292d() > 1) {
                map = this.f32399i.iterator();
                while (map.hasNext()) {
                    C6872d c6872d2 = (C6872d) map.next();
                    if (c6872d2.m32292d() > 1 && C8233e.m42773b(c6872d, c6872d2)) {
                        return C8233e.m42769a(c6872d, c6872d2);
                    }
                }
                continue;
            }
        }
        throw C6894l.m32349a();
    }

    /* renamed from: a */
    private static void m42770a(Collection<C6872d> collection, C6872d c6872d) {
        if (c6872d != null) {
            Object obj = null;
            for (C6872d c6872d2 : collection) {
                if (c6872d2.m22224a() == c6872d.m22224a()) {
                    c6872d2.m32293e();
                    obj = 1;
                    break;
                }
            }
            if (obj == null) {
                collection.add(c6872d);
            }
        }
    }

    /* renamed from: a */
    private static C5314q m42769a(C6872d c6872d, C6872d c6872d2) {
        int length;
        String valueOf = String.valueOf((((long) c6872d.m22224a()) * 4537077) + ((long) c6872d2.m22224a()));
        StringBuilder stringBuilder = new StringBuilder(14);
        for (length = 13 - valueOf.length(); length > 0; length--) {
            stringBuilder.append('0');
        }
        stringBuilder.append(valueOf);
        int i = 0;
        for (length = 0; length < 13; length++) {
            int charAt = stringBuilder.charAt(length) - 48;
            if ((length & 1) == 0) {
                charAt *= 3;
            }
            i += charAt;
        }
        int i2 = 10 - (i % 10);
        if (i2 == 10) {
            i2 = 0;
        }
        stringBuilder.append(i2);
        c6872d = c6872d.m32291c().m22228c();
        c6872d2 = c6872d2.m32291c().m22228c();
        return new C5314q(stringBuilder.toString(), null, new C5316s[]{c6872d[0], c6872d[1], c6872d2[0], c6872d2[1]}, C5193a.RSS_14);
    }

    /* renamed from: b */
    private static boolean m42773b(C6872d c6872d, C6872d c6872d2) {
        int b = (c6872d.m22225b() + (c6872d2.m22225b() * 16)) % 79;
        c6872d = (c6872d.m32291c().m22226a() * 9) + c6872d2.m32291c().m22226a();
        if (c6872d > 72) {
            c6872d--;
        }
        if (c6872d > 8) {
            c6872d--;
        }
        return b == c6872d ? true : null;
    }

    /* renamed from: a */
    private com.google.p217b.p231e.p232a.C6872d m42768a(com.google.p217b.p222b.C5196a r7, boolean r8, int r9, java.util.Map<com.google.p217b.C5254e, ?> r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = 0;
        r1 = r6.m42772a(r7, r8);	 Catch:{ l -> 0x0059 }
        r2 = r6.m42767a(r7, r9, r8, r1);	 Catch:{ l -> 0x0059 }
        if (r10 != 0) goto L_0x000d;	 Catch:{ l -> 0x0059 }
    L_0x000b:
        r10 = r0;	 Catch:{ l -> 0x0059 }
        goto L_0x0015;	 Catch:{ l -> 0x0059 }
    L_0x000d:
        r3 = com.google.p217b.C5254e.NEED_RESULT_POINT_CALLBACK;	 Catch:{ l -> 0x0059 }
        r10 = r10.get(r3);	 Catch:{ l -> 0x0059 }
        r10 = (com.google.p217b.C5317t) r10;	 Catch:{ l -> 0x0059 }
    L_0x0015:
        r3 = 0;	 Catch:{ l -> 0x0059 }
        r4 = 1;	 Catch:{ l -> 0x0059 }
        if (r10 == 0) goto L_0x0035;	 Catch:{ l -> 0x0059 }
    L_0x0019:
        r5 = r1[r3];	 Catch:{ l -> 0x0059 }
        r1 = r1[r4];	 Catch:{ l -> 0x0059 }
        r5 = r5 + r1;	 Catch:{ l -> 0x0059 }
        r1 = (float) r5;	 Catch:{ l -> 0x0059 }
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;	 Catch:{ l -> 0x0059 }
        r1 = r1 / r5;	 Catch:{ l -> 0x0059 }
        if (r8 == 0) goto L_0x002c;	 Catch:{ l -> 0x0059 }
    L_0x0024:
        r8 = r7.m21954a();	 Catch:{ l -> 0x0059 }
        r8 = r8 - r4;	 Catch:{ l -> 0x0059 }
        r8 = (float) r8;	 Catch:{ l -> 0x0059 }
        r1 = r8 - r1;	 Catch:{ l -> 0x0059 }
    L_0x002c:
        r8 = new com.google.b.s;	 Catch:{ l -> 0x0059 }
        r9 = (float) r9;	 Catch:{ l -> 0x0059 }
        r8.<init>(r1, r9);	 Catch:{ l -> 0x0059 }
        r10.m22584a(r8);	 Catch:{ l -> 0x0059 }
    L_0x0035:
        r8 = r6.m42766a(r7, r2, r4);	 Catch:{ l -> 0x0059 }
        r7 = r6.m42766a(r7, r2, r3);	 Catch:{ l -> 0x0059 }
        r9 = new com.google.b.e.a.d;	 Catch:{ l -> 0x0059 }
        r10 = r8.m22224a();	 Catch:{ l -> 0x0059 }
        r10 = r10 * 1597;	 Catch:{ l -> 0x0059 }
        r1 = r7.m22224a();	 Catch:{ l -> 0x0059 }
        r10 = r10 + r1;	 Catch:{ l -> 0x0059 }
        r8 = r8.m22225b();	 Catch:{ l -> 0x0059 }
        r7 = r7.m22225b();	 Catch:{ l -> 0x0059 }
        r7 = r7 * 4;	 Catch:{ l -> 0x0059 }
        r8 = r8 + r7;	 Catch:{ l -> 0x0059 }
        r9.<init>(r10, r8, r2);	 Catch:{ l -> 0x0059 }
        return r9;
    L_0x0059:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.b.e.a.e.a(com.google.b.b.a, boolean, int, java.util.Map):com.google.b.e.a.d");
    }

    /* renamed from: a */
    private C5246b m42766a(C5196a c5196a, C5247c c5247c, boolean z) {
        int[] b = m38444b();
        for (int i = 0; i < b.length; i++) {
            b[i] = 0;
        }
        if (z) {
            C6873r.m32297b(c5196a, c5247c.m22227b()[0], b);
        } else {
            C6873r.m32295a(c5196a, (int) c5247c.m22227b()[1] + 1, b);
            c5196a = null;
            for (C5196a length = b.length - 1; c5196a < length; length--) {
                int i2 = b[c5196a];
                b[c5196a] = b[length];
                b[length] = i2;
                c5196a++;
            }
        }
        int i3 = z ? 16 : 15;
        c5247c = ((float) C5194a.m21947a(b)) / ((float) i3);
        int[] e = m38447e();
        int[] f = m38448f();
        float[] c = m38445c();
        float[] d = m38446d();
        for (int i4 = 0; i4 < b.length; i4++) {
            float f2 = ((float) b[i4]) / c5247c;
            int i5 = (int) (0.5f + f2);
            if (i5 <= 0) {
                i5 = 1;
            } else if (i5 > 8) {
                i5 = 8;
            }
            int i6 = i4 / 2;
            if ((i4 & 1) == 0) {
                e[i6] = i5;
                c[i6] = f2 - ((float) i5);
            } else {
                f[i6] = i5;
                d[i6] = f2 - ((float) i5);
            }
        }
        m42771a(z, i3);
        c5247c = null;
        int i7 = 0;
        for (c5196a = e.length - 1; c5196a >= null; c5196a--) {
            c5247c = (c5247c * 9) + e[c5196a];
            i7 += e[c5196a];
        }
        int i8 = 0;
        int i9 = 0;
        for (c5196a = f.length - 1; c5196a >= null; c5196a--) {
            i8 = (i8 * 9) + f[c5196a];
            i9 += f[c5196a];
        }
        c5247c += i8 * 3;
        if (z) {
            if ((i7 & 1) || i7 > 12 || i7 < 4) {
                throw C6894l.m32349a();
            }
            z = (true - i7) / 2;
            c5196a = f32395e[z];
            i7 = 9 - c5196a;
            return new C5246b(((C5248f.m22230a(e, c5196a, false) * f32391a[z]) + C5248f.m22230a(f, i7, true)) + f32393c[z], c5247c);
        } else if ((i9 & 1) || i9 > 10 || i9 < 4) {
            throw C6894l.m32349a();
        } else {
            z = (true - i9) / 2;
            c5196a = f32396f[z];
            return new C5246b(((C5248f.m22230a(f, 9 - c5196a, false) * f32392b[z]) + C5248f.m22230a(e, c5196a, true)) + f32394d[z], c5247c);
        }
    }

    /* renamed from: a */
    private int[] m42772a(C5196a c5196a, boolean z) {
        int[] a = m38443a();
        a[0] = 0;
        a[1] = 0;
        a[2] = 0;
        a[3] = 0;
        int a2 = c5196a.m21954a();
        int i = 0;
        int i2 = 0;
        while (i < a2) {
            i2 = c5196a.m21959a(i) ^ 1;
            if (z == i2) {
                break;
            }
            i++;
        }
        int i3 = i;
        z = false;
        while (i < a2) {
            if (c5196a.m21959a(i) != i2) {
                a[z] = a[z] + 1;
            } else {
                if (!z) {
                    z++;
                } else if (C7900a.m38441a(a)) {
                    return new int[]{i3, i};
                } else {
                    i3 += a[0] + a[1];
                    a[0] = a[2];
                    a[1] = a[3];
                    a[2] = 0;
                    a[3] = 0;
                    z--;
                }
                a[z] = 1;
                i2 = i2 == false ? 1 : 0;
            }
            i++;
        }
        throw C6894l.m32349a();
    }

    /* renamed from: a */
    private C5247c m42767a(C5196a c5196a, int i, boolean z, int[] iArr) {
        int a;
        int a2;
        boolean a3 = c5196a.m21959a(iArr[0]);
        int i2 = iArr[0] - 1;
        while (i2 >= 0 && a3 != c5196a.m21959a(i2)) {
            i2--;
        }
        i2++;
        int i3 = iArr[0] - i2;
        Object a4 = m38443a();
        System.arraycopy(a4, 0, a4, 1, a4.length - 1);
        a4[0] = i3;
        int a5 = C7900a.m38439a((int[]) a4, f32397g);
        i3 = iArr[1];
        if (z) {
            a = (c5196a.m21954a() - 1) - i3;
            a2 = (c5196a.m21954a() - true) - i2;
        } else {
            a = i3;
            a2 = i2;
        }
        return new C5247c(a5, new int[]{i2, iArr[1]}, a2, a, i);
    }

    /* renamed from: a */
    private void m42771a(boolean z, int i) {
        Object obj;
        Object obj2;
        Object obj3;
        int i2;
        int a = C5194a.m21947a(m38447e());
        int a2 = C5194a.m21947a(m38448f());
        Object obj4 = null;
        Object obj5;
        if (z) {
            if (a > 12) {
                obj = null;
                obj2 = 1;
            } else {
                obj = a < 4 ? 1 : null;
                obj2 = null;
            }
            if (a2 > 12) {
                obj5 = obj;
                obj = obj2;
            } else if (a2 < 4) {
                obj5 = obj;
                obj = obj2;
                obj3 = 1;
                obj2 = null;
                i2 = (a + a2) - i;
                z = (a & 1) == z;
                if ((a2 & 1) == 1) {
                    obj4 = 1;
                }
                if (i2 != 1) {
                    if (i2 == -1) {
                        if (z) {
                            if (obj4 == null) {
                                obj5 = 1;
                            } else {
                                throw C6894l.m32349a();
                            }
                        } else if (obj4 != null) {
                            obj3 = 1;
                        } else {
                            throw C6894l.m32349a();
                        }
                    } else if (i2 != 0) {
                        throw C6894l.m32349a();
                    } else if (z) {
                        if (obj4 == null) {
                            throw C6894l.m32349a();
                        } else if (a < a2) {
                            obj5 = 1;
                            obj2 = 1;
                        } else {
                            obj3 = 1;
                        }
                    } else if (obj4 != null) {
                        throw C6894l.m32349a();
                    }
                    if (obj5 != null) {
                        if (obj == null) {
                            throw C6894l.m32349a();
                        }
                        C7900a.m38440a((int[]) m38447e(), (float[]) m38445c());
                    }
                    if (obj != null) {
                        C7900a.m38442b(m38447e(), m38445c());
                    }
                    if (obj3 != null) {
                        if (obj2 == null) {
                            throw C6894l.m32349a();
                        }
                        C7900a.m38440a((int[]) m38448f(), (float[]) m38445c());
                    }
                    if (obj2 == null) {
                        C7900a.m38442b(m38448f(), m38446d());
                    }
                } else if (!z) {
                    if (obj4 == null) {
                        throw C6894l.m32349a();
                    }
                    obj2 = 1;
                    if (obj5 != null) {
                        if (obj == null) {
                            C7900a.m38440a((int[]) m38447e(), (float[]) m38445c());
                        } else {
                            throw C6894l.m32349a();
                        }
                    }
                    if (obj != null) {
                        C7900a.m38442b(m38447e(), m38445c());
                    }
                    if (obj3 != null) {
                        if (obj2 == null) {
                            C7900a.m38440a((int[]) m38448f(), (float[]) m38445c());
                        } else {
                            throw C6894l.m32349a();
                        }
                    }
                    if (obj2 == null) {
                        C7900a.m38442b(m38448f(), m38446d());
                    }
                } else if (obj4 != null) {
                    throw C6894l.m32349a();
                }
                obj = 1;
                if (obj5 != null) {
                    if (obj == null) {
                        C7900a.m38440a((int[]) m38447e(), (float[]) m38445c());
                    } else {
                        throw C6894l.m32349a();
                    }
                }
                if (obj != null) {
                    C7900a.m38442b(m38447e(), m38445c());
                }
                if (obj3 != null) {
                    if (obj2 == null) {
                        C7900a.m38440a((int[]) m38448f(), (float[]) m38445c());
                    } else {
                        throw C6894l.m32349a();
                    }
                }
                if (obj2 == null) {
                    C7900a.m38442b(m38448f(), m38446d());
                }
            } else {
                obj5 = obj;
                obj = obj2;
                obj3 = null;
                obj2 = null;
                i2 = (a + a2) - i;
                if ((a & 1) == z) {
                }
                if ((a2 & 1) == 1) {
                    obj4 = 1;
                }
                if (i2 != 1) {
                    if (i2 == -1) {
                        if (i2 != 0) {
                            throw C6894l.m32349a();
                        } else if (z) {
                            if (obj4 != null) {
                                throw C6894l.m32349a();
                            }
                        } else if (obj4 == null) {
                            throw C6894l.m32349a();
                        } else if (a < a2) {
                            obj3 = 1;
                        } else {
                            obj5 = 1;
                            obj2 = 1;
                        }
                    } else if (z) {
                        if (obj4 != null) {
                            throw C6894l.m32349a();
                        }
                        obj3 = 1;
                    } else if (obj4 == null) {
                        throw C6894l.m32349a();
                    } else {
                        obj5 = 1;
                    }
                    if (obj5 != null) {
                        if (obj == null) {
                            throw C6894l.m32349a();
                        }
                        C7900a.m38440a((int[]) m38447e(), (float[]) m38445c());
                    }
                    if (obj != null) {
                        C7900a.m38442b(m38447e(), m38445c());
                    }
                    if (obj3 != null) {
                        if (obj2 == null) {
                            throw C6894l.m32349a();
                        }
                        C7900a.m38440a((int[]) m38448f(), (float[]) m38445c());
                    }
                    if (obj2 == null) {
                        C7900a.m38442b(m38448f(), m38446d());
                    }
                } else if (!z) {
                    if (obj4 == null) {
                        throw C6894l.m32349a();
                    }
                    obj2 = 1;
                    if (obj5 != null) {
                        if (obj == null) {
                            C7900a.m38440a((int[]) m38447e(), (float[]) m38445c());
                        } else {
                            throw C6894l.m32349a();
                        }
                    }
                    if (obj != null) {
                        C7900a.m38442b(m38447e(), m38445c());
                    }
                    if (obj3 != null) {
                        if (obj2 == null) {
                            C7900a.m38440a((int[]) m38448f(), (float[]) m38445c());
                        } else {
                            throw C6894l.m32349a();
                        }
                    }
                    if (obj2 == null) {
                        C7900a.m38442b(m38448f(), m38446d());
                    }
                } else if (obj4 != null) {
                    throw C6894l.m32349a();
                }
                obj = 1;
                if (obj5 != null) {
                    if (obj == null) {
                        throw C6894l.m32349a();
                    }
                    C7900a.m38440a((int[]) m38447e(), (float[]) m38445c());
                }
                if (obj != null) {
                    C7900a.m38442b(m38447e(), m38445c());
                }
                if (obj3 != null) {
                    if (obj2 == null) {
                        throw C6894l.m32349a();
                    }
                    C7900a.m38440a((int[]) m38448f(), (float[]) m38445c());
                }
                if (obj2 == null) {
                    C7900a.m38442b(m38448f(), m38446d());
                }
            }
        }
        if (a > 11) {
            obj5 = null;
            obj = 1;
        } else {
            obj5 = a < 5 ? 1 : null;
            obj = null;
        }
        if (a2 <= 10) {
            if (a2 < 4) {
                obj3 = 1;
                obj2 = null;
                i2 = (a + a2) - i;
                if ((a & 1) == z) {
                }
                if ((a2 & 1) == 1) {
                    obj4 = 1;
                }
                if (i2 != 1) {
                    if (i2 == -1) {
                        if (z) {
                            if (obj4 == null) {
                                obj5 = 1;
                            } else {
                                throw C6894l.m32349a();
                            }
                        } else if (obj4 != null) {
                            obj3 = 1;
                        } else {
                            throw C6894l.m32349a();
                        }
                    } else if (i2 != 0) {
                        throw C6894l.m32349a();
                    } else if (z) {
                        if (obj4 == null) {
                            throw C6894l.m32349a();
                        } else if (a < a2) {
                            obj5 = 1;
                            obj2 = 1;
                        } else {
                            obj3 = 1;
                        }
                    } else if (obj4 != null) {
                        throw C6894l.m32349a();
                    }
                    if (obj5 != null) {
                        if (obj == null) {
                            throw C6894l.m32349a();
                        }
                        C7900a.m38440a((int[]) m38447e(), (float[]) m38445c());
                    }
                    if (obj != null) {
                        C7900a.m38442b(m38447e(), m38445c());
                    }
                    if (obj3 != null) {
                        if (obj2 == null) {
                            throw C6894l.m32349a();
                        }
                        C7900a.m38440a((int[]) m38448f(), (float[]) m38445c());
                    }
                    if (obj2 == null) {
                        C7900a.m38442b(m38448f(), m38446d());
                    }
                } else if (!z) {
                    if (obj4 == null) {
                        throw C6894l.m32349a();
                    }
                    obj2 = 1;
                    if (obj5 != null) {
                        if (obj == null) {
                            C7900a.m38440a((int[]) m38447e(), (float[]) m38445c());
                        } else {
                            throw C6894l.m32349a();
                        }
                    }
                    if (obj != null) {
                        C7900a.m38442b(m38447e(), m38445c());
                    }
                    if (obj3 != null) {
                        if (obj2 == null) {
                            C7900a.m38440a((int[]) m38448f(), (float[]) m38445c());
                        } else {
                            throw C6894l.m32349a();
                        }
                    }
                    if (obj2 == null) {
                        C7900a.m38442b(m38448f(), m38446d());
                    }
                } else if (obj4 != null) {
                    throw C6894l.m32349a();
                }
                obj = 1;
                if (obj5 != null) {
                    if (obj == null) {
                        C7900a.m38440a((int[]) m38447e(), (float[]) m38445c());
                    } else {
                        throw C6894l.m32349a();
                    }
                }
                if (obj != null) {
                    C7900a.m38442b(m38447e(), m38445c());
                }
                if (obj3 != null) {
                    if (obj2 == null) {
                        C7900a.m38440a((int[]) m38448f(), (float[]) m38445c());
                    } else {
                        throw C6894l.m32349a();
                    }
                }
                if (obj2 == null) {
                    C7900a.m38442b(m38448f(), m38446d());
                }
            }
            obj3 = null;
            obj2 = null;
            i2 = (a + a2) - i;
            if ((a & 1) == z) {
            }
            if ((a2 & 1) == 1) {
                obj4 = 1;
            }
            if (i2 != 1) {
                if (i2 == -1) {
                    if (i2 != 0) {
                        throw C6894l.m32349a();
                    } else if (z) {
                        if (obj4 != null) {
                            throw C6894l.m32349a();
                        }
                    } else if (obj4 == null) {
                        throw C6894l.m32349a();
                    } else if (a < a2) {
                        obj3 = 1;
                    } else {
                        obj5 = 1;
                        obj2 = 1;
                    }
                } else if (z) {
                    if (obj4 != null) {
                        throw C6894l.m32349a();
                    }
                    obj3 = 1;
                } else if (obj4 == null) {
                    throw C6894l.m32349a();
                } else {
                    obj5 = 1;
                }
                if (obj5 != null) {
                    if (obj == null) {
                        throw C6894l.m32349a();
                    }
                    C7900a.m38440a((int[]) m38447e(), (float[]) m38445c());
                }
                if (obj != null) {
                    C7900a.m38442b(m38447e(), m38445c());
                }
                if (obj3 != null) {
                    if (obj2 == null) {
                        throw C6894l.m32349a();
                    }
                    C7900a.m38440a((int[]) m38448f(), (float[]) m38445c());
                }
                if (obj2 == null) {
                    C7900a.m38442b(m38448f(), m38446d());
                }
            } else if (!z) {
                if (obj4 == null) {
                    throw C6894l.m32349a();
                }
                obj2 = 1;
                if (obj5 != null) {
                    if (obj == null) {
                        C7900a.m38440a((int[]) m38447e(), (float[]) m38445c());
                    } else {
                        throw C6894l.m32349a();
                    }
                }
                if (obj != null) {
                    C7900a.m38442b(m38447e(), m38445c());
                }
                if (obj3 != null) {
                    if (obj2 == null) {
                        C7900a.m38440a((int[]) m38448f(), (float[]) m38445c());
                    } else {
                        throw C6894l.m32349a();
                    }
                }
                if (obj2 == null) {
                    C7900a.m38442b(m38448f(), m38446d());
                }
            } else if (obj4 != null) {
                throw C6894l.m32349a();
            }
            obj = 1;
            if (obj5 != null) {
                if (obj == null) {
                    throw C6894l.m32349a();
                }
                C7900a.m38440a((int[]) m38447e(), (float[]) m38445c());
            }
            if (obj != null) {
                C7900a.m38442b(m38447e(), m38445c());
            }
            if (obj3 != null) {
                if (obj2 == null) {
                    throw C6894l.m32349a();
                }
                C7900a.m38440a((int[]) m38448f(), (float[]) m38445c());
            }
            if (obj2 == null) {
                C7900a.m38442b(m38448f(), m38446d());
            }
        }
        obj3 = null;
        obj2 = 1;
        i2 = (a + a2) - i;
        if ((a & 1) == z) {
        }
        if ((a2 & 1) == 1) {
            obj4 = 1;
        }
        if (i2 != 1) {
            if (i2 == -1) {
                if (z) {
                    if (obj4 == null) {
                        obj5 = 1;
                    } else {
                        throw C6894l.m32349a();
                    }
                } else if (obj4 != null) {
                    obj3 = 1;
                } else {
                    throw C6894l.m32349a();
                }
            } else if (i2 != 0) {
                throw C6894l.m32349a();
            } else if (z) {
                if (obj4 == null) {
                    throw C6894l.m32349a();
                } else if (a < a2) {
                    obj5 = 1;
                    obj2 = 1;
                } else {
                    obj3 = 1;
                }
            } else if (obj4 != null) {
                throw C6894l.m32349a();
            }
            if (obj5 != null) {
                if (obj == null) {
                    throw C6894l.m32349a();
                }
                C7900a.m38440a((int[]) m38447e(), (float[]) m38445c());
            }
            if (obj != null) {
                C7900a.m38442b(m38447e(), m38445c());
            }
            if (obj3 != null) {
                if (obj2 == null) {
                    throw C6894l.m32349a();
                }
                C7900a.m38440a((int[]) m38448f(), (float[]) m38445c());
            }
            if (obj2 == null) {
                C7900a.m38442b(m38448f(), m38446d());
            }
        } else if (!z) {
            if (obj4 == null) {
                throw C6894l.m32349a();
            }
            obj2 = 1;
            if (obj5 != null) {
                if (obj == null) {
                    C7900a.m38440a((int[]) m38447e(), (float[]) m38445c());
                } else {
                    throw C6894l.m32349a();
                }
            }
            if (obj != null) {
                C7900a.m38442b(m38447e(), m38445c());
            }
            if (obj3 != null) {
                if (obj2 == null) {
                    C7900a.m38440a((int[]) m38448f(), (float[]) m38445c());
                } else {
                    throw C6894l.m32349a();
                }
            }
            if (obj2 == null) {
                C7900a.m38442b(m38448f(), m38446d());
            }
        } else if (obj4 != null) {
            throw C6894l.m32349a();
        }
        obj = 1;
        if (obj5 != null) {
            if (obj == null) {
                C7900a.m38440a((int[]) m38447e(), (float[]) m38445c());
            } else {
                throw C6894l.m32349a();
            }
        }
        if (obj != null) {
            C7900a.m38442b(m38447e(), m38445c());
        }
        if (obj3 != null) {
            if (obj2 == null) {
                C7900a.m38440a((int[]) m38448f(), (float[]) m38445c());
            } else {
                throw C6894l.m32349a();
            }
        }
        if (obj2 == null) {
            C7900a.m38442b(m38448f(), m38446d());
        }
    }
}
