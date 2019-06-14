package com.theartofdev.edmodo.cropper;

import android.graphics.RectF;
import com.theartofdev.edmodo.cropper.C5849h.C5848a;
import com.theartofdev.edmodo.cropper.CropImageView.C5820b;

/* compiled from: CropWindowHandler */
/* renamed from: com.theartofdev.edmodo.cropper.g */
final class C5846g {
    /* renamed from: a */
    private final RectF f19460a = new RectF();
    /* renamed from: b */
    private final RectF f19461b = new RectF();
    /* renamed from: c */
    private float f19462c;
    /* renamed from: d */
    private float f19463d;
    /* renamed from: e */
    private float f19464e;
    /* renamed from: f */
    private float f19465f;
    /* renamed from: g */
    private float f19466g;
    /* renamed from: h */
    private float f19467h;
    /* renamed from: i */
    private float f19468i;
    /* renamed from: j */
    private float f19469j;
    /* renamed from: k */
    private float f19470k = 1.0f;
    /* renamed from: l */
    private float f19471l = 1.0f;

    /* renamed from: c */
    private static boolean m24658c(float f, float f2, float f3, float f4, float f5, float f6) {
        return f > f3 && f < f5 && f2 > f4 && f2 < f6;
    }

    C5846g() {
    }

    /* renamed from: a */
    public RectF m24660a() {
        this.f19461b.set(this.f19460a);
        return this.f19461b;
    }

    /* renamed from: b */
    public float m24665b() {
        return Math.max(this.f19462c, this.f19466g / this.f19470k);
    }

    /* renamed from: c */
    public float m24666c() {
        return Math.max(this.f19463d, this.f19467h / this.f19471l);
    }

    /* renamed from: d */
    public float m24667d() {
        return Math.min(this.f19464e, this.f19468i / this.f19470k);
    }

    /* renamed from: e */
    public float m24668e() {
        return Math.min(this.f19465f, this.f19469j / this.f19471l);
    }

    /* renamed from: f */
    public float m24669f() {
        return this.f19470k;
    }

    /* renamed from: g */
    public float m24670g() {
        return this.f19471l;
    }

    /* renamed from: a */
    public void m24662a(float f, float f2, float f3, float f4) {
        this.f19464e = f;
        this.f19465f = f2;
        this.f19470k = f3;
        this.f19471l = f4;
    }

    /* renamed from: a */
    public void m24664a(C5845f c5845f) {
        this.f19462c = (float) c5845f.f19457x;
        this.f19463d = (float) c5845f.f19458y;
        this.f19466g = (float) c5845f.f19459z;
        this.f19467h = (float) c5845f.f19412A;
        this.f19468i = (float) c5845f.f19413B;
        this.f19469j = (float) c5845f.f19414C;
    }

    /* renamed from: a */
    public void m24663a(RectF rectF) {
        this.f19460a.set(rectF);
    }

    /* renamed from: h */
    public boolean m24671h() {
        return this.f19460a.width() >= 100.0f && this.f19460a.height() >= 100.0f;
    }

    /* renamed from: a */
    public C5849h m24661a(float f, float f2, float f3, C5820b c5820b) {
        if (c5820b == C5820b.OVAL) {
            f3 = m24653a(f, f2);
        } else {
            f3 = m24654a(f, f2, f3);
        }
        return f3 != null ? new C5849h(f3, this, f, f2) : null;
    }

    /* renamed from: a */
    private C5848a m24654a(float f, float f2, float f3) {
        if (C5846g.m24655a(f, f2, this.f19460a.left, this.f19460a.top, f3)) {
            return C5848a.TOP_LEFT;
        }
        if (C5846g.m24655a(f, f2, this.f19460a.right, this.f19460a.top, f3)) {
            return C5848a.TOP_RIGHT;
        }
        if (C5846g.m24655a(f, f2, this.f19460a.left, this.f19460a.bottom, f3)) {
            return C5848a.BOTTOM_LEFT;
        }
        if (C5846g.m24655a(f, f2, this.f19460a.right, this.f19460a.bottom, f3)) {
            return C5848a.BOTTOM_RIGHT;
        }
        if (C5846g.m24658c(f, f2, this.f19460a.left, this.f19460a.top, this.f19460a.right, this.f19460a.bottom) && m24659i()) {
            return C5848a.CENTER;
        }
        if (C5846g.m24656a(f, f2, this.f19460a.left, this.f19460a.right, this.f19460a.top, f3)) {
            return C5848a.TOP;
        }
        if (C5846g.m24656a(f, f2, this.f19460a.left, this.f19460a.right, this.f19460a.bottom, f3)) {
            return C5848a.BOTTOM;
        }
        if (C5846g.m24657b(f, f2, this.f19460a.left, this.f19460a.top, this.f19460a.bottom, f3)) {
            return C5848a.LEFT;
        }
        if (C5846g.m24657b(f, f2, this.f19460a.right, this.f19460a.top, this.f19460a.bottom, f3) != null) {
            return C5848a.RIGHT;
        }
        return (C5846g.m24658c(f, f2, this.f19460a.left, this.f19460a.top, this.f19460a.right, this.f19460a.bottom) == null || m24659i() != null) ? 0.0f : C5848a.CENTER;
    }

    /* renamed from: a */
    private C5848a m24653a(float f, float f2) {
        float width = this.f19460a.width() / 6.0f;
        float f3 = this.f19460a.left + width;
        float f4 = this.f19460a.left + (width * 5.0f);
        width = this.f19460a.height() / 6.0f;
        float f5 = this.f19460a.top + width;
        float f6 = this.f19460a.top + (width * 5.0f);
        if (f < f3) {
            if (f2 < f5) {
                return C5848a.TOP_LEFT;
            }
            if (f2 < f6) {
                return C5848a.LEFT;
            }
            return C5848a.BOTTOM_LEFT;
        } else if (f < f4) {
            if (f2 < f5) {
                return C5848a.TOP;
            }
            if (f2 < f6) {
                return C5848a.CENTER;
            }
            return C5848a.BOTTOM;
        } else if (f2 < f5) {
            return C5848a.TOP_RIGHT;
        } else {
            if (f2 < f6) {
                return C5848a.RIGHT;
            }
            return C5848a.BOTTOM_RIGHT;
        }
    }

    /* renamed from: a */
    private static boolean m24655a(float f, float f2, float f3, float f4, float f5) {
        return Math.abs(f - f3) <= f5 && Math.abs(f2 - f4) <= f5;
    }

    /* renamed from: a */
    private static boolean m24656a(float f, float f2, float f3, float f4, float f5, float f6) {
        return f > f3 && f < f4 && Math.abs(f2 - f5) <= f6;
    }

    /* renamed from: b */
    private static boolean m24657b(float f, float f2, float f3, float f4, float f5, float f6) {
        return Math.abs(f - f3) <= f6 && f2 > f4 && f2 < f5;
    }

    /* renamed from: i */
    private boolean m24659i() {
        return m24671h() ^ 1;
    }
}
