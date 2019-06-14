package com.p082f.p083a;

import android.graphics.Matrix;

/* compiled from: ScaleManager */
/* renamed from: com.f.a.c */
public class C1254c {
    /* renamed from: a */
    private C1255d f3625a;
    /* renamed from: b */
    private C1255d f3626b;

    public C1254c(C1255d c1255d, C1255d c1255d2) {
        this.f3625a = c1255d;
        this.f3626b = c1255d2;
    }

    /* renamed from: a */
    public Matrix m4375a(C1252b c1252b) {
        switch (c1252b) {
            case NONE:
                return m4362a();
            case FIT_XY:
                return m4366b();
            case FIT_CENTER:
                return m4370d();
            case FIT_START:
                return m4368c();
            case FIT_END:
                return m4371e();
            case LEFT_TOP:
                return m4367b(C1251a.LEFT_TOP);
            case LEFT_CENTER:
                return m4367b(C1251a.LEFT_CENTER);
            case LEFT_BOTTOM:
                return m4367b(C1251a.LEFT_BOTTOM);
            case CENTER_TOP:
                return m4367b(C1251a.CENTER_TOP);
            case CENTER:
                return m4367b(C1251a.CENTER);
            case CENTER_BOTTOM:
                return m4367b(C1251a.CENTER_BOTTOM);
            case RIGHT_TOP:
                return m4367b(C1251a.RIGHT_TOP);
            case RIGHT_CENTER:
                return m4367b(C1251a.RIGHT_CENTER);
            case RIGHT_BOTTOM:
                return m4367b(C1251a.RIGHT_BOTTOM);
            case LEFT_TOP_CROP:
                return m4369c(C1251a.LEFT_TOP);
            case LEFT_CENTER_CROP:
                return m4369c(C1251a.LEFT_CENTER);
            case LEFT_BOTTOM_CROP:
                return m4369c(C1251a.LEFT_BOTTOM);
            case CENTER_TOP_CROP:
                return m4369c(C1251a.CENTER_TOP);
            case CENTER_CROP:
                return m4369c(C1251a.CENTER);
            case CENTER_BOTTOM_CROP:
                return m4369c(C1251a.CENTER_BOTTOM);
            case RIGHT_TOP_CROP:
                return m4369c(C1251a.RIGHT_TOP);
            case RIGHT_CENTER_CROP:
                return m4369c(C1251a.RIGHT_CENTER);
            case RIGHT_BOTTOM_CROP:
                return m4369c(C1251a.RIGHT_BOTTOM);
            case START_INSIDE:
                return m4372f();
            case CENTER_INSIDE:
                return m4373g();
            case END_INSIDE:
                return m4374h();
            default:
                return null;
        }
    }

    /* renamed from: a */
    private Matrix m4363a(float f, float f2, float f3, float f4) {
        Matrix matrix = new Matrix();
        matrix.setScale(f, f2, f3, f4);
        return matrix;
    }

    /* renamed from: a */
    private Matrix m4364a(float f, float f2, C1251a c1251a) {
        switch (c1251a) {
            case LEFT_TOP:
                return m4363a(f, f2, 0.0f, 0.0f);
            case LEFT_CENTER:
                return m4363a(f, f2, 0.0f, ((float) this.f3625a.m4377b()) / 1073741824);
            case LEFT_BOTTOM:
                return m4363a(f, f2, 0.0f, (float) this.f3625a.m4377b());
            case CENTER_TOP:
                return m4363a(f, f2, ((float) this.f3625a.m4376a()) / 1073741824, 0.0f);
            case CENTER:
                return m4363a(f, f2, ((float) this.f3625a.m4376a()) / 1073741824, ((float) this.f3625a.m4377b()) / 2.0f);
            case CENTER_BOTTOM:
                return m4363a(f, f2, ((float) this.f3625a.m4376a()) / 1073741824, (float) this.f3625a.m4377b());
            case RIGHT_TOP:
                return m4363a(f, f2, (float) this.f3625a.m4376a(), 0.0f);
            case RIGHT_CENTER:
                return m4363a(f, f2, (float) this.f3625a.m4376a(), ((float) this.f3625a.m4377b()) / 2.0f);
            case RIGHT_BOTTOM:
                return m4363a(f, f2, (float) this.f3625a.m4376a(), (float) this.f3625a.m4377b());
            default:
                throw new IllegalArgumentException("Illegal PivotPoint");
        }
    }

    /* renamed from: a */
    private Matrix m4362a() {
        return m4364a(((float) this.f3626b.m4376a()) / ((float) this.f3625a.m4376a()), ((float) this.f3626b.m4377b()) / ((float) this.f3625a.m4377b()), C1251a.LEFT_TOP);
    }

    /* renamed from: a */
    private Matrix m4365a(C1251a c1251a) {
        float a = ((float) this.f3625a.m4376a()) / ((float) this.f3626b.m4376a());
        float b = ((float) this.f3625a.m4377b()) / ((float) this.f3626b.m4377b());
        float min = Math.min(a, b);
        return m4364a(min / a, min / b, c1251a);
    }

    /* renamed from: b */
    private Matrix m4366b() {
        return m4364a(1.0f, 1.0f, C1251a.LEFT_TOP);
    }

    /* renamed from: c */
    private Matrix m4368c() {
        return m4365a(C1251a.LEFT_TOP);
    }

    /* renamed from: d */
    private Matrix m4370d() {
        return m4365a(C1251a.CENTER);
    }

    /* renamed from: e */
    private Matrix m4371e() {
        return m4365a(C1251a.RIGHT_BOTTOM);
    }

    /* renamed from: b */
    private Matrix m4367b(C1251a c1251a) {
        return m4364a(((float) this.f3626b.m4376a()) / ((float) this.f3625a.m4376a()), ((float) this.f3626b.m4377b()) / ((float) this.f3625a.m4377b()), c1251a);
    }

    /* renamed from: c */
    private Matrix m4369c(C1251a c1251a) {
        float a = ((float) this.f3625a.m4376a()) / ((float) this.f3626b.m4376a());
        float b = ((float) this.f3625a.m4377b()) / ((float) this.f3626b.m4377b());
        float max = Math.max(a, b);
        return m4364a(max / a, max / b, c1251a);
    }

    /* renamed from: f */
    private Matrix m4372f() {
        if (this.f3626b.m4377b() > this.f3625a.m4376a() || this.f3626b.m4377b() > this.f3625a.m4377b()) {
            return m4368c();
        }
        return m4367b(C1251a.LEFT_TOP);
    }

    /* renamed from: g */
    private Matrix m4373g() {
        if (this.f3626b.m4377b() > this.f3625a.m4376a() || this.f3626b.m4377b() > this.f3625a.m4377b()) {
            return m4370d();
        }
        return m4367b(C1251a.CENTER);
    }

    /* renamed from: h */
    private Matrix m4374h() {
        if (this.f3626b.m4377b() > this.f3625a.m4376a() || this.f3626b.m4377b() > this.f3625a.m4377b()) {
            return m4371e();
        }
        return m4367b(C1251a.RIGHT_BOTTOM);
    }
}
