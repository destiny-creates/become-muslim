package com.google.p217b.p222b.p223a;

import com.google.p217b.C5316s;
import com.google.p217b.C6894l;
import com.google.p217b.p222b.C5202b;

/* compiled from: WhiteRectangleDetector */
/* renamed from: com.google.b.b.a.b */
public final class C5195b {
    /* renamed from: a */
    private final C5202b f17507a;
    /* renamed from: b */
    private final int f17508b;
    /* renamed from: c */
    private final int f17509c;
    /* renamed from: d */
    private final int f17510d;
    /* renamed from: e */
    private final int f17511e;
    /* renamed from: f */
    private final int f17512f;
    /* renamed from: g */
    private final int f17513g;

    public C5195b(C5202b c5202b) {
        this(c5202b, 10, c5202b.m22010f() / 2, c5202b.m22011g() / 2);
    }

    public C5195b(C5202b c5202b, int i, int i2, int i3) {
        this.f17507a = c5202b;
        this.f17508b = c5202b.m22011g();
        this.f17509c = c5202b.m22010f();
        i /= 2;
        this.f17510d = i2 - i;
        this.f17511e = i2 + i;
        this.f17513g = i3 - i;
        this.f17512f = i3 + i;
        if (this.f17513g < null || this.f17510d < null || this.f17512f >= this.f17508b || this.f17511e >= this.f17509c) {
            throw C6894l.m32349a();
        }
    }

    /* renamed from: a */
    public C5316s[] m21951a() {
        int i = this.f17510d;
        int i2 = this.f17511e;
        int i3 = this.f17513g;
        int i4 = this.f17512f;
        boolean z = false;
        int i5 = 1;
        int i6 = i;
        Object obj = 1;
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        Object obj5 = null;
        Object obj6 = null;
        while (obj != null) {
            boolean z2 = true;
            Object obj7 = null;
            while (true) {
                if ((z2 || obj2 == null) && i2 < this.f17509c) {
                    z2 = m21949a(i3, i4, i2, false);
                    if (z2) {
                        i2++;
                        obj2 = 1;
                        obj7 = 1;
                    } else if (obj2 == null) {
                        i2++;
                    }
                }
            }
            if (i2 < this.f17509c) {
                z2 = true;
                while (true) {
                    if ((z2 || obj3 == null) && i4 < this.f17508b) {
                        z2 = m21949a(i6, i2, i4, true);
                        if (z2) {
                            i4++;
                            obj3 = 1;
                            obj7 = 1;
                        } else if (obj3 == null) {
                            i4++;
                        }
                    }
                }
                if (i4 < this.f17508b) {
                    z2 = true;
                    while (true) {
                        if ((z2 || obj4 == null) && i6 >= 0) {
                            z2 = m21949a(i3, i4, i6, false);
                            if (z2) {
                                i6--;
                                obj4 = 1;
                                obj7 = 1;
                            } else if (obj4 == null) {
                                i6--;
                            }
                        }
                    }
                    if (i6 >= 0) {
                        z2 = true;
                        while (true) {
                            if ((z2 || obj6 == null) && i3 >= 0) {
                                z2 = m21949a(i6, i2, i3, true);
                                if (z2) {
                                    i3--;
                                    obj6 = 1;
                                    obj7 = 1;
                                } else if (obj6 == null) {
                                    i3--;
                                }
                            }
                        }
                        if (i3 >= 0) {
                            if (obj7 != null) {
                                obj5 = 1;
                            }
                            obj = obj7;
                        }
                    }
                }
            }
            z = true;
            break;
        }
        if (z || r10 == null) {
            throw C6894l.m32349a();
        }
        i = i2 - i6;
        C5316s c5316s = null;
        C5316s c5316s2 = null;
        int i7 = 1;
        while (c5316s2 == null && i7 < i) {
            c5316s2 = m21948a((float) i6, (float) (i4 - i7), (float) (i6 + i7), (float) i4);
            i7++;
        }
        if (c5316s2 != null) {
            C5316s c5316s3 = null;
            int i8 = 1;
            while (c5316s3 == null && i8 < i) {
                c5316s3 = m21948a((float) i6, (float) (i3 + i8), (float) (i6 + i8), (float) i3);
                i8++;
            }
            if (c5316s3 != null) {
                C5316s c5316s4 = null;
                i8 = 1;
                while (c5316s4 == null && i8 < i) {
                    c5316s4 = m21948a((float) i2, (float) (i3 + i8), (float) (i2 - i8), (float) i3);
                    i8++;
                }
                if (c5316s4 != null) {
                    while (c5316s == null && i5 < i) {
                        c5316s = m21948a((float) i2, (float) (i4 - i5), (float) (i2 - i5), (float) i4);
                        i5++;
                    }
                    if (c5316s != null) {
                        return m21950a(c5316s, c5316s2, c5316s4, c5316s3);
                    }
                    throw C6894l.m32349a();
                }
                throw C6894l.m32349a();
            }
            throw C6894l.m32349a();
        }
        throw C6894l.m32349a();
    }

    /* renamed from: a */
    private C5316s m21948a(float f, float f2, float f3, float f4) {
        int a = C5194a.m21946a(C5194a.m21944a(f, f2, f3, f4));
        float f5 = (float) a;
        f3 = (f3 - f) / f5;
        f4 = (f4 - f2) / f5;
        for (int i = 0; i < a; i++) {
            float f6 = (float) i;
            int a2 = C5194a.m21946a((f6 * f3) + f);
            int a3 = C5194a.m21946a((f6 * f4) + f2);
            if (this.f17507a.m22002a(a2, a3)) {
                return new C5316s((float) a2, (float) a3);
            }
        }
        return 0.0f;
    }

    /* renamed from: a */
    private C5316s[] m21950a(C5316s c5316s, C5316s c5316s2, C5316s c5316s3, C5316s c5316s4) {
        float a = c5316s.m22582a();
        c5316s = c5316s.m22583b();
        float a2 = c5316s2.m22582a();
        c5316s2 = c5316s2.m22583b();
        float a3 = c5316s3.m22582a();
        c5316s3 = c5316s3.m22583b();
        float a4 = c5316s4.m22582a();
        c5316s4 = c5316s4.m22583b();
        if (a < ((float) this.f17509c) / 2.0f) {
            return new C5316s[]{new C5316s(a4 - 1.0f, c5316s4 + 1065353216), new C5316s(a2 + 1.0f, c5316s2 + 1065353216), new C5316s(a3 - 1.0f, c5316s3 - 1065353216), new C5316s(a + 1.0f, c5316s - 1065353216)};
        }
        return new C5316s[]{new C5316s(a4 + 1.0f, c5316s4 + 1065353216), new C5316s(a2 + 1.0f, c5316s2 - 1065353216), new C5316s(a3 - 1.0f, c5316s3 + 1065353216), new C5316s(a - 1.0f, c5316s - 1065353216)};
    }

    /* renamed from: a */
    private boolean m21949a(int i, int i2, int i3, boolean z) {
        if (z) {
            while (i <= i2) {
                if (this.f17507a.m22002a(i, i3)) {
                    return true;
                }
                i++;
            }
        } else {
            while (i <= i2) {
                if (this.f17507a.m22002a(i3, i)) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }
}
