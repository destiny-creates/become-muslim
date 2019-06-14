package com.p079e.p080a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.p079e.p080a.C1236t.C1233d;

/* compiled from: ImageViewAction */
/* renamed from: com.e.a.l */
class C3504l extends C1194a<ImageView> {
    /* renamed from: m */
    C1212e f9336m;

    C3504l(C1236t c1236t, ImageView imageView, C1242w c1242w, int i, int i2, int i3, Drawable drawable, String str, Object obj, C1212e c1212e, boolean z) {
        super(c1236t, imageView, c1242w, i, i2, i3, drawable, str, obj, z);
        this.f9336m = c1212e;
    }

    /* renamed from: a */
    public void mo827a(Bitmap bitmap, C1233d c1233d) {
        if (bitmap != null) {
            ImageView imageView = (ImageView) this.c.get();
            if (imageView != null) {
                Bitmap bitmap2 = bitmap;
                C1233d c1233d2 = c1233d;
                C1237u.m4320a(imageView, this.a.f3497c, bitmap2, c1233d2, this.d, this.a.f3505k);
                if (this.f9336m != null) {
                    this.f9336m.m4259a();
                }
                return;
            }
            return;
        }
        throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[]{this}));
    }

    /* renamed from: a */
    public void mo826a() {
        ImageView imageView = (ImageView) this.c.get();
        if (imageView != null) {
            if (this.g != 0) {
                imageView.setImageResource(this.g);
            } else if (this.h != null) {
                imageView.setImageDrawable(this.h);
            }
            if (this.f9336m != null) {
                this.f9336m.m4260b();
            }
        }
    }

    /* renamed from: b */
    void mo828b() {
        super.mo828b();
        if (this.f9336m != null) {
            this.f9336m = null;
        }
    }
}
