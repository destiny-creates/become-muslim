package com.theartofdev.edmodo.cropper;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;

/* compiled from: CropWindowMoveHandler */
/* renamed from: com.theartofdev.edmodo.cropper.h */
final class C5849h {
    /* renamed from: a */
    private static final Matrix f19483a = new Matrix();
    /* renamed from: b */
    private final float f19484b;
    /* renamed from: c */
    private final float f19485c;
    /* renamed from: d */
    private final float f19486d;
    /* renamed from: e */
    private final float f19487e;
    /* renamed from: f */
    private final C5848a f19488f;
    /* renamed from: g */
    private final PointF f19489g = new PointF();

    /* compiled from: CropWindowMoveHandler */
    /* renamed from: com.theartofdev.edmodo.cropper.h$a */
    public enum C5848a {
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        CENTER
    }

    /* renamed from: a */
    private static float m24672a(float f, float f2, float f3, float f4) {
        return (f3 - f) / (f4 - f2);
    }

    public C5849h(C5848a c5848a, C5846g c5846g, float f, float f2) {
        this.f19488f = c5848a;
        this.f19484b = c5846g.m24665b();
        this.f19485c = c5846g.m24666c();
        this.f19486d = c5846g.m24667d();
        this.f19487e = c5846g.m24668e();
        m24674a(c5846g.m24660a(), f, f2);
    }

    /* renamed from: a */
    public void m24688a(RectF rectF, float f, float f2, RectF rectF2, int i, int i2, float f3, boolean z, float f4) {
        float f5 = f + this.f19489g.x;
        float f6 = f2 + this.f19489g.y;
        if (this.f19488f == C5848a.CENTER) {
            m24675a(rectF, f5, f6, rectF2, i, i2, f3);
        } else if (z) {
            m24676a(rectF, f5, f6, rectF2, i, i2, f3, f4);
        } else {
            m24681b(rectF, f5, f6, rectF2, i, i2, f3);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private void m24674a(android.graphics.RectF r3, float r4, float r5) {
        /*
        r2 = this;
        r0 = com.theartofdev.edmodo.cropper.C5849h.C58471.f19472a;
        r1 = r2.f19488f;
        r1 = r1.ordinal();
        r0 = r0[r1];
        r1 = 0;
        switch(r0) {
            case 1: goto L_0x0045;
            case 2: goto L_0x003d;
            case 3: goto L_0x0035;
            case 4: goto L_0x002d;
            case 5: goto L_0x0028;
            case 6: goto L_0x0024;
            case 7: goto L_0x0020;
            case 8: goto L_0x001c;
            case 9: goto L_0x0010;
            default: goto L_0x000e;
        };
    L_0x000e:
        r3 = 0;
        goto L_0x004c;
    L_0x0010:
        r0 = r3.centerX();
        r1 = r0 - r4;
        r3 = r3.centerY();
        r3 = r3 - r5;
        goto L_0x004c;
    L_0x001c:
        r3 = r3.bottom;
        r3 = r3 - r5;
        goto L_0x004c;
    L_0x0020:
        r3 = r3.right;
        r3 = r3 - r4;
        goto L_0x002b;
    L_0x0024:
        r3 = r3.top;
        r3 = r3 - r5;
        goto L_0x004c;
    L_0x0028:
        r3 = r3.left;
        r3 = r3 - r4;
    L_0x002b:
        r1 = r3;
        goto L_0x000e;
    L_0x002d:
        r0 = r3.right;
        r1 = r0 - r4;
        r3 = r3.bottom;
        r3 = r3 - r5;
        goto L_0x004c;
    L_0x0035:
        r0 = r3.left;
        r1 = r0 - r4;
        r3 = r3.bottom;
        r3 = r3 - r5;
        goto L_0x004c;
    L_0x003d:
        r0 = r3.right;
        r1 = r0 - r4;
        r3 = r3.top;
        r3 = r3 - r5;
        goto L_0x004c;
    L_0x0045:
        r0 = r3.left;
        r1 = r0 - r4;
        r3 = r3.top;
        r3 = r3 - r5;
    L_0x004c:
        r4 = r2.f19489g;
        r4.x = r1;
        r4 = r2.f19489g;
        r4.y = r3;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.theartofdev.edmodo.cropper.h.a(android.graphics.RectF, float, float):void");
    }

    /* renamed from: a */
    private void m24675a(RectF rectF, float f, float f2, RectF rectF2, int i, int i2, float f3) {
        f -= rectF.centerX();
        f2 -= rectF.centerY();
        if (rectF.left + f < 0.0f || rectF.right + f > ((float) i) || rectF.left + f < rectF2.left || rectF.right + f > rectF2.right) {
            f /= 1.05f;
            i = this.f19489g;
            i.x -= f / 2.0f;
        }
        if (rectF.top + f2 < 0 || rectF.bottom + f2 > ((float) i2) || rectF.top + f2 < rectF2.top || rectF.bottom + f2 > rectF2.bottom) {
            f2 /= 1.05f;
            i = this.f19489g;
            i.y -= f2 / 2.0f;
        }
        rectF.offset(f, f2);
        m24679a(rectF, rectF2, f3);
    }

    /* renamed from: b */
    private void m24681b(RectF rectF, float f, float f2, RectF rectF2, int i, int i2, float f3) {
        RectF rectF3;
        RectF rectF4;
        switch (this.f19488f) {
            case TOP_LEFT:
                rectF3 = rectF;
                rectF4 = rectF2;
                float f4 = f3;
                m24682b(rectF3, f2, rectF4, f4, 0.0f, false, false);
                m24677a(rectF3, f, rectF4, f4, 0.0f, false, false);
                return;
            case TOP_RIGHT:
                rectF3 = rectF;
                rectF4 = rectF2;
                m24682b(rectF3, f2, rectF4, f3, 0.0f, false, false);
                m24678a(rectF3, f, rectF4, i, f3, 0.0f, false, false);
                return;
            case BOTTOM_LEFT:
                rectF3 = rectF;
                rectF4 = rectF2;
                m24683b(rectF3, f2, rectF4, i2, f3, 0.0f, false, false);
                m24677a(rectF3, f, rectF4, f3, 0.0f, false, false);
                return;
            case BOTTOM_RIGHT:
                rectF3 = rectF;
                rectF4 = rectF2;
                float f5 = f3;
                m24683b(rectF3, f2, rectF4, i2, f5, 0.0f, false, false);
                m24678a(rectF3, f, rectF4, i, f5, 0.0f, false, false);
                return;
            case LEFT:
                m24677a(rectF, f, rectF2, f3, 0.0f, false, false);
                return;
            case TOP:
                m24682b(rectF, f2, rectF2, f3, 0.0f, false, false);
                return;
            case RIGHT:
                m24678a(rectF, f, rectF2, i, f3, 0.0f, false, false);
                return;
            case BOTTOM:
                m24683b(rectF, f2, rectF2, i2, f3, 0.0f, false, false);
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    private void m24676a(RectF rectF, float f, float f2, RectF rectF2, int i, int i2, float f3, float f4) {
        RectF rectF3 = rectF;
        float f5 = f;
        float f6 = f2;
        RectF rectF4 = rectF2;
        float f7 = f4;
        switch (this.f19488f) {
            case TOP_LEFT:
                if (C5849h.m24672a(f, f6, rectF3.right, rectF3.bottom) < f7) {
                    m24682b(rectF, f2, rectF2, f3, f4, true, false);
                    m24673a(rectF, f7);
                    return;
                }
                m24677a(rectF, f, rectF2, f3, f4, true, false);
                m24680b(rectF, f7);
                return;
            case TOP_RIGHT:
                if (C5849h.m24672a(rectF3.left, f6, f, rectF3.bottom) < f7) {
                    m24682b(rectF, f2, rectF2, f3, f4, false, true);
                    m24685c(rectF, f7);
                    return;
                }
                m24678a(rectF, f, rectF2, i, f3, f4, true, false);
                m24680b(rectF, f7);
                return;
            case BOTTOM_LEFT:
                if (C5849h.m24672a(f, rectF3.top, rectF3.right, f6) < f7) {
                    m24683b(rectF, f2, rectF2, i2, f3, f4, true, false);
                    m24673a(rectF, f7);
                    return;
                }
                m24677a(rectF, f, rectF2, f3, f4, false, true);
                m24687d(rectF, f7);
                return;
            case BOTTOM_RIGHT:
                if (C5849h.m24672a(rectF3.left, rectF3.top, f, f6) < f7) {
                    m24683b(rectF, f2, rectF2, i2, f3, f4, false, true);
                    m24685c(rectF, f7);
                    return;
                }
                m24678a(rectF, f, rectF2, i, f3, f4, false, true);
                m24687d(rectF, f7);
                return;
            case LEFT:
                m24677a(rectF, f, rectF2, f3, f4, true, true);
                m24686c(rectF, rectF4, f7);
                return;
            case TOP:
                m24682b(rectF, f2, rectF2, f3, f4, true, true);
                m24684b(rectF, rectF4, f7);
                return;
            case RIGHT:
                m24678a(rectF, f, rectF2, i, f3, f4, true, true);
                m24686c(rectF, rectF4, f7);
                return;
            case BOTTOM:
                m24683b(rectF, f2, rectF2, i2, f3, f4, true, true);
                m24684b(rectF, rectF4, f7);
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    private void m24679a(RectF rectF, RectF rectF2, float f) {
        if (rectF.left < rectF2.left + f) {
            rectF.offset(rectF2.left - rectF.left, 0.0f);
        }
        if (rectF.top < rectF2.top + f) {
            rectF.offset(0.0f, rectF2.top - rectF.top);
        }
        if (rectF.right > rectF2.right - f) {
            rectF.offset(rectF2.right - rectF.right, 0.0f);
        }
        if (rectF.bottom > rectF2.bottom - f) {
            rectF.offset(0.0f, rectF2.bottom - rectF.bottom);
        }
    }

    /* renamed from: a */
    private void m24677a(RectF rectF, float f, RectF rectF2, float f2, float f3, boolean z, boolean z2) {
        if (f < 0.0f) {
            f /= 1.05f;
            PointF pointF = this.f19489g;
            pointF.x -= f / 1.1f;
        }
        if (f < rectF2.left) {
            pointF = this.f19489g;
            pointF.x -= (f - rectF2.left) / 2.0f;
        }
        if (f - rectF2.left < f2) {
            f = rectF2.left;
        }
        if (rectF.right - f < this.f19484b) {
            f = rectF.right - this.f19484b;
        }
        if (rectF.right - f > this.f19486d) {
            f = rectF.right - this.f19486d;
        }
        if (f - rectF2.left < f2) {
            f = rectF2.left;
        }
        if (f3 > 0.0f) {
            f2 = (rectF.right - f) / f3;
            if (f2 < this.f19485c) {
                f = Math.max(rectF2.left, rectF.right - (this.f19485c * f3));
                f2 = (rectF.right - f) / f3;
            }
            if (f2 > this.f19487e) {
                f = Math.max(rectF2.left, rectF.right - (this.f19487e * f3));
                f2 = (rectF.right - f) / f3;
            }
            if (z && z2) {
                f = Math.max(f, Math.max(rectF2.left, rectF.right - (rectF2.height() * f3)));
            } else {
                if (z && rectF.bottom - r9 < rectF2.top) {
                    f = Math.max(rectF2.left, rectF.right - ((rectF.bottom - rectF2.top) * f3));
                    f2 = (rectF.right - f) / f3;
                }
                if (z2 && rectF.top + r9 > rectF2.bottom) {
                    f = Math.max(f, Math.max(rectF2.left, rectF.right - ((rectF2.bottom - rectF.top) * f3)));
                }
            }
        }
        rectF.left = f;
    }

    /* renamed from: a */
    private void m24678a(RectF rectF, float f, RectF rectF2, int i, float f2, float f3, boolean z, boolean z2) {
        i = (float) i;
        if (f > i) {
            f = ((f - i) / 1.05f) + i;
            PointF pointF = this.f19489g;
            pointF.x -= (f - i) / 1066192077;
        }
        if (f > rectF2.right) {
            i = this.f19489g;
            i.x -= (f - rectF2.right) / 2.0f;
        }
        if (rectF2.right - f < f2) {
            f = rectF2.right;
        }
        if (f - rectF.left < this.f19484b) {
            f = rectF.left + this.f19484b;
        }
        if (f - rectF.left > this.f19486d) {
            f = rectF.left + this.f19486d;
        }
        if (rectF2.right - f < f2) {
            f = rectF2.right;
        }
        if (f3 > 0) {
            i = (f - rectF.left) / f3;
            if (i < this.f19485c) {
                f = Math.min(rectF2.right, rectF.left + (this.f19485c * f3));
                i = (f - rectF.left) / f3;
            }
            if (i > this.f19487e) {
                f = Math.min(rectF2.right, rectF.left + (this.f19487e * f3));
                i = (f - rectF.left) / f3;
            }
            if (z && z2) {
                f = Math.min(f, Math.min(rectF2.right, rectF.left + (rectF2.height() * f3)));
            } else {
                if (z && rectF.bottom - r7 < rectF2.top) {
                    f = Math.min(rectF2.right, rectF.left + ((rectF.bottom - rectF2.top) * f3));
                    i = (f - rectF.left) / f3;
                }
                if (z2 && rectF.top + r7 > rectF2.bottom) {
                    f = Math.min(f, Math.min(rectF2.right, rectF.left + ((rectF2.bottom - rectF.top) * f3)));
                }
            }
        }
        rectF.right = f;
    }

    /* renamed from: b */
    private void m24682b(RectF rectF, float f, RectF rectF2, float f2, float f3, boolean z, boolean z2) {
        if (f < 0.0f) {
            f /= 1.05f;
            PointF pointF = this.f19489g;
            pointF.y -= f / 1.1f;
        }
        if (f < rectF2.top) {
            pointF = this.f19489g;
            pointF.y -= (f - rectF2.top) / 2.0f;
        }
        if (f - rectF2.top < f2) {
            f = rectF2.top;
        }
        if (rectF.bottom - f < this.f19485c) {
            f = rectF.bottom - this.f19485c;
        }
        if (rectF.bottom - f > this.f19487e) {
            f = rectF.bottom - this.f19487e;
        }
        if (f - rectF2.top < f2) {
            f = rectF2.top;
        }
        if (f3 > 0.0f) {
            f2 = (rectF.bottom - f) * f3;
            if (f2 < this.f19484b) {
                f = Math.max(rectF2.top, rectF.bottom - (this.f19484b / f3));
                f2 = (rectF.bottom - f) * f3;
            }
            if (f2 > this.f19486d) {
                f = Math.max(rectF2.top, rectF.bottom - (this.f19486d / f3));
                f2 = (rectF.bottom - f) * f3;
            }
            if (z && z2) {
                f = Math.max(f, Math.max(rectF2.top, rectF.bottom - (rectF2.width() / f3)));
            } else {
                if (z && rectF.right - r9 < rectF2.left) {
                    f = Math.max(rectF2.top, rectF.bottom - ((rectF.right - rectF2.left) / f3));
                    f2 = (rectF.bottom - f) * f3;
                }
                if (z2 && rectF.left + r9 > rectF2.right) {
                    f = Math.max(f, Math.max(rectF2.top, rectF.bottom - ((rectF2.right - rectF.left) / f3)));
                }
            }
        }
        rectF.top = f;
    }

    /* renamed from: b */
    private void m24683b(RectF rectF, float f, RectF rectF2, int i, float f2, float f3, boolean z, boolean z2) {
        i = (float) i;
        if (f > i) {
            f = ((f - i) / 1.05f) + i;
            PointF pointF = this.f19489g;
            pointF.y -= (f - i) / 1066192077;
        }
        if (f > rectF2.bottom) {
            i = this.f19489g;
            i.y -= (f - rectF2.bottom) / 2.0f;
        }
        if (rectF2.bottom - f < f2) {
            f = rectF2.bottom;
        }
        if (f - rectF.top < this.f19485c) {
            f = rectF.top + this.f19485c;
        }
        if (f - rectF.top > this.f19487e) {
            f = rectF.top + this.f19487e;
        }
        if (rectF2.bottom - f < f2) {
            f = rectF2.bottom;
        }
        if (f3 > 0) {
            i = (f - rectF.top) * f3;
            if (i < this.f19484b) {
                f = Math.min(rectF2.bottom, rectF.top + (this.f19484b / f3));
                i = (f - rectF.top) * f3;
            }
            if (i > this.f19486d) {
                f = Math.min(rectF2.bottom, rectF.top + (this.f19486d / f3));
                i = (f - rectF.top) * f3;
            }
            if (z && z2) {
                f = Math.min(f, Math.min(rectF2.bottom, rectF.top + (rectF2.width() / f3)));
            } else {
                if (z && rectF.right - r7 < rectF2.left) {
                    f = Math.min(rectF2.bottom, rectF.top + ((rectF.right - rectF2.left) / f3));
                    i = (f - rectF.top) * f3;
                }
                if (z2 && rectF.left + r7 > rectF2.right) {
                    f = Math.min(f, Math.min(rectF2.bottom, rectF.top + ((rectF2.right - rectF.left) / f3)));
                }
            }
        }
        rectF.bottom = f;
    }

    /* renamed from: a */
    private void m24673a(RectF rectF, float f) {
        rectF.left = rectF.right - (rectF.height() * f);
    }

    /* renamed from: b */
    private void m24680b(RectF rectF, float f) {
        rectF.top = rectF.bottom - (rectF.width() / f);
    }

    /* renamed from: c */
    private void m24685c(RectF rectF, float f) {
        rectF.right = rectF.left + (rectF.height() * f);
    }

    /* renamed from: d */
    private void m24687d(RectF rectF, float f) {
        rectF.bottom = rectF.top + (rectF.width() / f);
    }

    /* renamed from: b */
    private void m24684b(RectF rectF, RectF rectF2, float f) {
        rectF.inset((rectF.width() - (rectF.height() * f)) / 2.0f, 0.0f);
        if (rectF.left < rectF2.left) {
            rectF.offset(rectF2.left - rectF.left, 0.0f);
        }
        if (rectF.right > rectF2.right) {
            rectF.offset(rectF2.right - rectF.right, 0.0f);
        }
    }

    /* renamed from: c */
    private void m24686c(RectF rectF, RectF rectF2, float f) {
        rectF.inset(0.0f, (rectF.height() - (rectF.width() / f)) / 2.0f);
        if (rectF.top < rectF2.top) {
            rectF.offset(0.0f, rectF2.top - rectF.top);
        }
        if (rectF.bottom > rectF2.bottom) {
            rectF.offset(0.0f, rectF2.bottom - rectF.bottom);
        }
    }
}
