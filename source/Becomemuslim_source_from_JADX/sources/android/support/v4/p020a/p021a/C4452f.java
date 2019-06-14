package android.support.v4.p020a.p021a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.p020a.p021a.C3159e.C0263a;

/* compiled from: WrappedDrawableApi19 */
/* renamed from: android.support.v4.a.a.f */
class C4452f extends C3159e {

    /* compiled from: WrappedDrawableApi19 */
    /* renamed from: android.support.v4.a.a.f$a */
    private static class C3160a extends C0263a {
        C3160a(C0263a c0263a, Resources resources) {
            super(c0263a, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new C4452f(this, resources);
        }
    }

    C4452f(Drawable drawable) {
        super(drawable);
    }

    C4452f(C0263a c0263a, Resources resources) {
        super(c0263a, resources);
    }

    public void setAutoMirrored(boolean z) {
        this.c.setAutoMirrored(z);
    }

    public boolean isAutoMirrored() {
        return this.c.isAutoMirrored();
    }

    /* renamed from: b */
    C0263a mo2655b() {
        return new C3160a(this.b, null);
    }
}
