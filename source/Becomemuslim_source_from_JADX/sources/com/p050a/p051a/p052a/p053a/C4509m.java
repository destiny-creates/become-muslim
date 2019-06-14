package com.p050a.p051a.p052a.p053a;

import android.graphics.Path;
import android.graphics.PointF;
import com.p050a.p051a.C0957g;
import com.p050a.p051a.C0959i;
import com.p050a.p051a.p052a.p054b.C0885a;
import com.p050a.p051a.p052a.p054b.C0885a.C0884a;
import com.p050a.p051a.p056c.C0917e;
import com.p050a.p051a.p056c.p058b.C3375i;
import com.p050a.p051a.p056c.p058b.C3375i.C0901a;
import com.p050a.p051a.p056c.p058b.C3382q.C0906a;
import com.p050a.p051a.p056c.p059c.C4529a;
import com.p050a.p051a.p061e.C0947e;
import com.p050a.p051a.p061e.C0948f;
import com.p050a.p051a.p062f.C0952c;
import java.util.List;

/* compiled from: PolystarContent */
/* renamed from: com.a.a.a.a.m */
public class C4509m implements C3359j, C3360l, C0884a {
    /* renamed from: a */
    private final Path f12168a = new Path();
    /* renamed from: b */
    private final String f12169b;
    /* renamed from: c */
    private final C0957g f12170c;
    /* renamed from: d */
    private final C0901a f12171d;
    /* renamed from: e */
    private final C0885a<?, Float> f12172e;
    /* renamed from: f */
    private final C0885a<?, PointF> f12173f;
    /* renamed from: g */
    private final C0885a<?, Float> f12174g;
    /* renamed from: h */
    private final C0885a<?, Float> f12175h;
    /* renamed from: i */
    private final C0885a<?, Float> f12176i;
    /* renamed from: j */
    private final C0885a<?, Float> f12177j;
    /* renamed from: k */
    private final C0885a<?, Float> f12178k;
    /* renamed from: l */
    private C3361r f12179l;
    /* renamed from: m */
    private boolean f12180m;

    public C4509m(C0957g c0957g, C4529a c4529a, C3375i c3375i) {
        this.f12170c = c0957g;
        this.f12169b = c3375i.m10725a();
        this.f12171d = c3375i.m10726b();
        this.f12172e = c3375i.m10727c().mo737a();
        this.f12173f = c3375i.m10728d().mo737a();
        this.f12174g = c3375i.m10729e().mo737a();
        this.f12176i = c3375i.m10731g().mo737a();
        this.f12178k = c3375i.m10733i().mo737a();
        if (this.f12171d == C0901a.Star) {
            this.f12175h = c3375i.m10730f().mo737a();
            this.f12177j = c3375i.m10732h().mo737a();
        } else {
            this.f12175h = null;
            this.f12177j = null;
        }
        c4529a.m15378a(this.f12172e);
        c4529a.m15378a(this.f12173f);
        c4529a.m15378a(this.f12174g);
        c4529a.m15378a(this.f12176i);
        c4529a.m15378a(this.f12178k);
        if (this.f12171d == C0901a.Star) {
            c4529a.m15378a(this.f12175h);
            c4529a.m15378a(this.f12177j);
        }
        this.f12172e.m3133a((C0884a) this);
        this.f12173f.m3133a((C0884a) this);
        this.f12174g.m3133a((C0884a) this);
        this.f12176i.m3133a((C0884a) this);
        this.f12178k.m3133a((C0884a) this);
        if (this.f12171d == C0901a.Star) {
            this.f12176i.m3133a((C0884a) this);
            this.f12178k.m3133a((C0884a) this);
        }
    }

    /* renamed from: a */
    public void mo728a() {
        m15307c();
    }

    /* renamed from: c */
    private void m15307c() {
        this.f12180m = false;
        this.f12170c.invalidateSelf();
    }

    /* renamed from: a */
    public void mo729a(List<C0880b> list, List<C0880b> list2) {
        for (list2 = null; list2 < list.size(); list2++) {
            C0880b c0880b = (C0880b) list.get(list2);
            if (c0880b instanceof C3361r) {
                C3361r c3361r = (C3361r) c0880b;
                if (c3361r.m10669c() == C0906a.Simultaneously) {
                    this.f12179l = c3361r;
                    this.f12179l.m10666a(this);
                }
            }
        }
    }

    /* renamed from: e */
    public Path mo2793e() {
        if (this.f12180m) {
            return this.f12168a;
        }
        this.f12168a.reset();
        switch (this.f12171d) {
            case Star:
                m15308d();
                break;
            case Polygon:
                m15309f();
                break;
            default:
                break;
        }
        this.f12168a.close();
        C0948f.m3318a(this.f12168a, this.f12179l);
        this.f12180m = true;
        return this.f12168a;
    }

    /* renamed from: b */
    public String mo730b() {
        return this.f12169b;
    }

    /* renamed from: d */
    private void m15308d() {
        float f;
        int i;
        double d;
        double d2;
        float cos;
        float sin;
        float floatValue = ((Float) this.f12172e.mo733e()).floatValue();
        double toRadians = Math.toRadians((this.f12174g == null ? 0.0d : (double) ((Float) r0.f12174g.mo733e()).floatValue()) - 90.0d);
        double d3 = (double) floatValue;
        float f2 = (float) (6.283185307179586d / d3);
        float f3 = f2 / 2.0f;
        floatValue -= (float) ((int) floatValue);
        int i2 = (floatValue > 0.0f ? 1 : (floatValue == 0.0f ? 0 : -1));
        if (i2 != 0) {
            toRadians += (double) ((1.0f - floatValue) * f3);
        }
        float floatValue2 = ((Float) r0.f12176i.mo733e()).floatValue();
        float floatValue3 = ((Float) r0.f12175h.mo733e()).floatValue();
        float floatValue4 = r0.f12177j != null ? ((Float) r0.f12177j.mo733e()).floatValue() / 100.0f : 0.0f;
        float floatValue5 = r0.f12178k != null ? ((Float) r0.f12178k.mo733e()).floatValue() / 100.0f : 0.0f;
        if (i2 != 0) {
            f = ((floatValue2 - floatValue3) * floatValue) + floatValue3;
            i = i2;
            d = (double) f;
            d2 = d3;
            cos = (float) (d * Math.cos(toRadians));
            sin = (float) (d * Math.sin(toRadians));
            r0.f12168a.moveTo(cos, sin);
            toRadians += (double) ((f2 * floatValue) / 2.0f);
        } else {
            d2 = d3;
            i = i2;
            double d4 = (double) floatValue2;
            float cos2 = (float) (Math.cos(toRadians) * d4);
            sin = (float) (d4 * Math.sin(toRadians));
            r0.f12168a.moveTo(cos2, sin);
            toRadians += (double) f3;
            cos = cos2;
            f = 0.0f;
        }
        d = Math.ceil(d2) * 2.0d;
        int i3 = 0;
        d2 = toRadians;
        float f4 = floatValue2;
        float f5 = floatValue3;
        int i4 = 0;
        while (true) {
            double d5 = (double) i3;
            if (d5 < d) {
                float f6;
                float f7;
                float f8;
                float f9;
                double d6;
                float f10;
                float f11;
                float f12;
                float f13 = i4 != 0 ? f4 : f5;
                int i5 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
                if (i5 == 0 || d5 != d - 2.0d) {
                    f6 = f13;
                    f13 = f3;
                } else {
                    f6 = f13;
                    f13 = (f2 * floatValue) / 2.0f;
                }
                if (i5 == 0 || d5 != d - 1.0d) {
                    f7 = f13;
                    f8 = f2;
                    f2 = f6;
                } else {
                    f7 = f13;
                    f8 = f2;
                    f2 = f;
                }
                double d7 = (double) f2;
                double d8 = d5;
                floatValue2 = (float) (d7 * Math.cos(d2));
                f13 = (float) (d7 * Math.sin(d2));
                if (floatValue4 == 0.0f && floatValue5 == 0.0f) {
                    r0.f12168a.lineTo(floatValue2, f13);
                    f9 = f3;
                    d6 = d;
                    f10 = floatValue4;
                    f11 = floatValue5;
                    f12 = f;
                } else {
                    f10 = floatValue4;
                    f11 = floatValue5;
                    f12 = f;
                    double atan2 = (double) ((float) (Math.atan2((double) sin, (double) cos) - 1.5707963267948966d));
                    float f14 = cos;
                    f2 = (float) Math.cos(atan2);
                    cos = (float) Math.sin(atan2);
                    f9 = f3;
                    d6 = d;
                    double atan22 = (double) ((float) (Math.atan2((double) f13, (double) floatValue2) - 1.5707963267948966d));
                    float cos3 = (float) Math.cos(atan22);
                    f3 = (float) Math.sin(atan22);
                    float f15 = i4 != 0 ? f10 : f11;
                    floatValue4 = ((i4 != 0 ? f5 : f4) * f15) * 0.47829f;
                    f2 *= floatValue4;
                    floatValue4 *= cos;
                    floatValue5 = ((i4 != 0 ? f4 : f5) * (i4 != 0 ? f11 : f10)) * 0.47829f;
                    cos3 *= floatValue5;
                    floatValue5 *= f3;
                    if (i != 0) {
                        if (i3 == 0) {
                            f2 *= floatValue;
                            floatValue4 *= floatValue;
                        } else if (d8 == d6 - 1.0d) {
                            cos3 *= floatValue;
                            floatValue5 *= floatValue;
                        }
                    }
                    r0.f12168a.cubicTo(f14 - f2, sin - floatValue4, floatValue2 + cos3, f13 + floatValue5, floatValue2, f13);
                }
                d2 += (double) f7;
                i4 ^= 1;
                i3++;
                sin = f13;
                cos = floatValue2;
                f2 = f8;
                floatValue4 = f10;
                floatValue5 = f11;
                f = f12;
                f3 = f9;
                d = d6;
            } else {
                PointF pointF = (PointF) r0.f12173f.mo733e();
                r0.f12168a.offset(pointF.x, pointF.y);
                r0.f12168a.close();
                return;
            }
        }
    }

    /* renamed from: f */
    private void m15309f() {
        int floor = (int) Math.floor((double) ((Float) this.f12172e.mo733e()).floatValue());
        double toRadians = Math.toRadians((this.f12174g == null ? 0.0d : (double) ((Float) r0.f12174g.mo733e()).floatValue()) - 90.0d);
        double d = (double) floor;
        float f = (float) (6.283185307179586d / d);
        float floatValue = ((Float) r0.f12178k.mo733e()).floatValue() / 100.0f;
        float floatValue2 = ((Float) r0.f12176i.mo733e()).floatValue();
        double d2 = (double) floatValue2;
        float cos = (float) (Math.cos(toRadians) * d2);
        float sin = (float) (Math.sin(toRadians) * d2);
        r0.f12168a.moveTo(cos, sin);
        double d3 = (double) f;
        toRadians += d3;
        d = Math.ceil(d);
        floor = 0;
        while (((double) floor) < d) {
            double d4;
            int i;
            double d5;
            double d6;
            float cos2 = (float) (Math.cos(toRadians) * d2);
            double d7 = d;
            float sin2 = (float) (d2 * Math.sin(toRadians));
            if (floatValue != 0.0f) {
                d4 = d2;
                i = floor;
                d5 = toRadians;
                double atan2 = (double) ((float) (Math.atan2((double) sin, (double) cos) - 1.5707963267948966d));
                d6 = d3;
                double atan22 = (double) ((float) (Math.atan2((double) sin2, (double) cos2) - 1.5707963267948966d));
                float f2 = (floatValue2 * floatValue) * 0.25f;
                r0.f12168a.cubicTo(cos - (((float) Math.cos(atan2)) * f2), sin - (((float) Math.sin(atan2)) * f2), cos2 + (((float) Math.cos(atan22)) * f2), sin2 + (f2 * ((float) Math.sin(atan22))), cos2, sin2);
            } else {
                i = floor;
                d5 = toRadians;
                d4 = d2;
                d6 = d3;
                r0.f12168a.lineTo(cos2, sin2);
            }
            toRadians = d5 + d6;
            floor = i + 1;
            sin = sin2;
            cos = cos2;
            d = d7;
            d2 = d4;
            d3 = d6;
        }
        PointF pointF = (PointF) r0.f12173f.mo733e();
        r0.f12168a.offset(pointF.x, pointF.y);
        r0.f12168a.close();
    }

    /* renamed from: a */
    public void mo2791a(C0917e c0917e, int i, List<C0917e> list, C0917e c0917e2) {
        C0947e.m3309a(c0917e, i, list, c0917e2, this);
    }

    /* renamed from: a */
    public <T> void mo2792a(T t, C0952c<T> c0952c) {
        if (t == C0959i.f2715o) {
            this.f12172e.m3134a((C0952c) c0952c);
        } else if (t == C0959i.f2716p) {
            this.f12174g.m3134a((C0952c) c0952c);
        } else if (t == C0959i.f2708h) {
            this.f12173f.m3134a((C0952c) c0952c);
        } else if (t == C0959i.f2717q && this.f12175h != null) {
            this.f12175h.m3134a((C0952c) c0952c);
        } else if (t == C0959i.f2718r) {
            this.f12176i.m3134a((C0952c) c0952c);
        } else if (t == C0959i.f2719s && this.f12177j != null) {
            this.f12177j.m3134a((C0952c) c0952c);
        } else if (t == C0959i.f2720t) {
            this.f12178k.m3134a((C0952c) c0952c);
        }
    }
}
