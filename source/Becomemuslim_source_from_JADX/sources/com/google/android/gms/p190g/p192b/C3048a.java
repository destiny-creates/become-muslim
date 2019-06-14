package com.google.android.gms.p190g.p192b;

import android.graphics.PointF;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.google.android.gms.g.b.a */
public class C3048a {
    /* renamed from: a */
    private int f7757a;
    /* renamed from: b */
    private PointF f7758b;
    /* renamed from: c */
    private float f7759c;
    /* renamed from: d */
    private float f7760d;
    /* renamed from: e */
    private float f7761e;
    /* renamed from: f */
    private float f7762f;
    /* renamed from: g */
    private List<C3050c> f7763g;
    /* renamed from: h */
    private float f7764h;
    /* renamed from: i */
    private float f7765i;
    /* renamed from: j */
    private float f7766j;

    public C3048a(int i, PointF pointF, float f, float f2, float f3, float f4, C3050c[] c3050cArr, float f5, float f6, float f7) {
        this.f7757a = i;
        this.f7758b = pointF;
        this.f7759c = f;
        this.f7760d = f2;
        this.f7761e = f3;
        this.f7762f = f4;
        this.f7763g = Arrays.asList(c3050cArr);
        if (f5 < 0.0f || f5 > 1.0f) {
            this.f7764h = -1.0f;
        } else {
            this.f7764h = f5;
        }
        if (f6 < 0.0f || f6 > 1.0f) {
            this.f7765i = -1.0f;
        } else {
            this.f7765i = f6;
        }
        if (f7 < 0.0f || f7 > 1.0f) {
            this.f7766j = -1.0f;
        } else {
            this.f7766j = f7;
        }
    }

    /* renamed from: a */
    public PointF m8888a() {
        return new PointF(this.f7758b.x - (this.f7759c / 2.0f), this.f7758b.y - (this.f7760d / 2.0f));
    }

    /* renamed from: b */
    public float m8889b() {
        return this.f7759c;
    }

    /* renamed from: c */
    public float m8890c() {
        return this.f7760d;
    }

    /* renamed from: d */
    public float m8891d() {
        return this.f7761e;
    }

    /* renamed from: e */
    public float m8892e() {
        return this.f7762f;
    }

    /* renamed from: f */
    public List<C3050c> m8893f() {
        return this.f7763g;
    }

    /* renamed from: g */
    public float m8894g() {
        return this.f7764h;
    }

    /* renamed from: h */
    public float m8895h() {
        return this.f7765i;
    }

    /* renamed from: i */
    public float m8896i() {
        return this.f7766j;
    }

    /* renamed from: j */
    public int m8897j() {
        return this.f7757a;
    }
}
