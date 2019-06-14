package com.p050a.p051a.p062f;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.p050a.p051a.C0954f;

/* compiled from: Keyframe */
/* renamed from: com.a.a.f.a */
public class C0950a<T> {
    /* renamed from: a */
    public final T f2644a;
    /* renamed from: b */
    public final T f2645b;
    /* renamed from: c */
    public final Interpolator f2646c;
    /* renamed from: d */
    public final float f2647d;
    /* renamed from: e */
    public Float f2648e;
    /* renamed from: f */
    public PointF f2649f;
    /* renamed from: g */
    public PointF f2650g;
    /* renamed from: h */
    private final C0954f f2651h;
    /* renamed from: i */
    private float f2652i;
    /* renamed from: j */
    private float f2653j;

    public C0950a(C0954f c0954f, T t, T t2, Interpolator interpolator, float f, Float f2) {
        this.f2652i = Float.MIN_VALUE;
        this.f2653j = Float.MIN_VALUE;
        this.f2649f = null;
        this.f2650g = null;
        this.f2651h = c0954f;
        this.f2644a = t;
        this.f2645b = t2;
        this.f2646c = interpolator;
        this.f2647d = f;
        this.f2648e = f2;
    }

    public C0950a(T t) {
        this.f2652i = Float.MIN_VALUE;
        this.f2653j = Float.MIN_VALUE;
        this.f2649f = null;
        this.f2650g = null;
        this.f2651h = null;
        this.f2644a = t;
        this.f2645b = t;
        this.f2646c = null;
        this.f2647d = Float.MIN_VALUE;
        this.f2648e = Float.valueOf(Float.MAX_VALUE);
    }

    /* renamed from: b */
    public float m3326b() {
        if (this.f2651h == null) {
            return 0.0f;
        }
        if (this.f2652i == Float.MIN_VALUE) {
            this.f2652i = (this.f2647d - this.f2651h.m3343d()) / this.f2651h.m3350k();
        }
        return this.f2652i;
    }

    /* renamed from: c */
    public float m3327c() {
        if (this.f2651h == null) {
            return 1.0f;
        }
        if (this.f2653j == Float.MIN_VALUE) {
            if (this.f2648e == null) {
                this.f2653j = 1.0f;
            } else {
                this.f2653j = m3326b() + ((this.f2648e.floatValue() - this.f2647d) / this.f2651h.m3350k());
            }
        }
        return this.f2653j;
    }

    /* renamed from: d */
    public boolean m3328d() {
        return this.f2646c == null;
    }

    /* renamed from: a */
    public boolean m3325a(float f) {
        return f >= m3326b() && f < m3327c();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Keyframe{startValue=");
        stringBuilder.append(this.f2644a);
        stringBuilder.append(", endValue=");
        stringBuilder.append(this.f2645b);
        stringBuilder.append(", startFrame=");
        stringBuilder.append(this.f2647d);
        stringBuilder.append(", endFrame=");
        stringBuilder.append(this.f2648e);
        stringBuilder.append(", interpolator=");
        stringBuilder.append(this.f2646c);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
