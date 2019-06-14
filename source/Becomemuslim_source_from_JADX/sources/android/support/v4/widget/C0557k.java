package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.widget.ImageView;

/* compiled from: ImageViewCompat */
/* renamed from: android.support.v4.widget.k */
public class C0557k {
    /* renamed from: a */
    static final C0556b f1396a;

    /* compiled from: ImageViewCompat */
    /* renamed from: android.support.v4.widget.k$b */
    interface C0556b {
        /* renamed from: a */
        ColorStateList mo341a(ImageView imageView);

        /* renamed from: a */
        void mo342a(ImageView imageView, ColorStateList colorStateList);

        /* renamed from: a */
        void mo343a(ImageView imageView, Mode mode);

        /* renamed from: b */
        Mode mo344b(ImageView imageView);
    }

    /* compiled from: ImageViewCompat */
    /* renamed from: android.support.v4.widget.k$a */
    static class C3241a implements C0556b {
        C3241a() {
        }

        /* renamed from: a */
        public ColorStateList mo341a(ImageView imageView) {
            return imageView instanceof C0575t ? ((C0575t) imageView).getSupportImageTintList() : null;
        }

        /* renamed from: a */
        public void mo342a(ImageView imageView, ColorStateList colorStateList) {
            if (imageView instanceof C0575t) {
                ((C0575t) imageView).setSupportImageTintList(colorStateList);
            }
        }

        /* renamed from: a */
        public void mo343a(ImageView imageView, Mode mode) {
            if (imageView instanceof C0575t) {
                ((C0575t) imageView).setSupportImageTintMode(mode);
            }
        }

        /* renamed from: b */
        public Mode mo344b(ImageView imageView) {
            return imageView instanceof C0575t ? ((C0575t) imageView).getSupportImageTintMode() : null;
        }
    }

    /* compiled from: ImageViewCompat */
    /* renamed from: android.support.v4.widget.k$c */
    static class C4469c extends C3241a {
        C4469c() {
        }

        /* renamed from: a */
        public ColorStateList mo341a(ImageView imageView) {
            return imageView.getImageTintList();
        }

        /* renamed from: a */
        public void mo342a(ImageView imageView, ColorStateList colorStateList) {
            imageView.setImageTintList(colorStateList);
            if (VERSION.SDK_INT == 21) {
                colorStateList = imageView.getDrawable();
                Object obj = (imageView.getImageTintList() == null || imageView.getImageTintMode() == null) ? null : 1;
                if (colorStateList != null && obj != null) {
                    if (colorStateList.isStateful()) {
                        colorStateList.setState(imageView.getDrawableState());
                    }
                    imageView.setImageDrawable(colorStateList);
                }
            }
        }

        /* renamed from: a */
        public void mo343a(ImageView imageView, Mode mode) {
            imageView.setImageTintMode(mode);
            if (VERSION.SDK_INT == 21) {
                mode = imageView.getDrawable();
                Object obj = (imageView.getImageTintList() == null || imageView.getImageTintMode() == null) ? null : 1;
                if (mode != null && obj != null) {
                    if (mode.isStateful()) {
                        mode.setState(imageView.getDrawableState());
                    }
                    imageView.setImageDrawable(mode);
                }
            }
        }

        /* renamed from: b */
        public Mode mo344b(ImageView imageView) {
            return imageView.getImageTintMode();
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f1396a = new C4469c();
        } else {
            f1396a = new C3241a();
        }
    }

    /* renamed from: a */
    public static ColorStateList m1885a(ImageView imageView) {
        return f1396a.mo341a(imageView);
    }

    /* renamed from: a */
    public static void m1886a(ImageView imageView, ColorStateList colorStateList) {
        f1396a.mo342a(imageView, colorStateList);
    }

    /* renamed from: b */
    public static Mode m1888b(ImageView imageView) {
        return f1396a.mo344b(imageView);
    }

    /* renamed from: a */
    public static void m1887a(ImageView imageView, Mode mode) {
        f1396a.mo343a(imageView, mode);
    }
}
