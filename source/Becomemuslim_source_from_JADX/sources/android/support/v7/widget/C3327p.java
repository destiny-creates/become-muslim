package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.view.C0514r;
import android.support.v4.widget.C0575t;
import android.support.v7.p035a.C0591a.C0581a;
import android.util.AttributeSet;
import android.widget.ImageButton;

/* compiled from: AppCompatImageButton */
/* renamed from: android.support.v7.widget.p */
public class C3327p extends ImageButton implements C0514r, C0575t {
    /* renamed from: a */
    private final C0795h f8842a;
    /* renamed from: b */
    private final C0801q f8843b;

    public C3327p(Context context) {
        this(context, null);
    }

    public C3327p(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0581a.imageButtonStyle);
    }

    public C3327p(Context context, AttributeSet attributeSet, int i) {
        super(bn.m2764a(context), attributeSet, i);
        this.f8842a = new C0795h(this);
        this.f8842a.m2877a(attributeSet, i);
        this.f8843b = new C0801q(this);
        this.f8843b.m2926a(attributeSet, i);
    }

    public void setImageResource(int i) {
        this.f8843b.m2923a(i);
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.f8843b != null) {
            this.f8843b.m2930d();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.f8843b != null) {
            this.f8843b.m2930d();
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        if (this.f8843b != null) {
            this.f8843b.m2930d();
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f8842a != null) {
            this.f8842a.m2873a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f8842a != null) {
            this.f8842a.m2876a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f8842a != null) {
            this.f8842a.m2874a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f8842a != null ? this.f8842a.m2872a() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f8842a != null) {
            this.f8842a.m2875a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f8842a != null ? this.f8842a.m2878b() : null;
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.f8843b != null) {
            this.f8843b.m2924a(colorStateList);
        }
    }

    public ColorStateList getSupportImageTintList() {
        return this.f8843b != null ? this.f8843b.m2928b() : null;
    }

    public void setSupportImageTintMode(Mode mode) {
        if (this.f8843b != null) {
            this.f8843b.m2925a(mode);
        }
    }

    public Mode getSupportImageTintMode() {
        return this.f8843b != null ? this.f8843b.m2929c() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f8842a != null) {
            this.f8842a.m2880c();
        }
        if (this.f8843b != null) {
            this.f8843b.m2930d();
        }
    }

    public boolean hasOverlappingRendering() {
        return this.f8843b.m2927a() && super.hasOverlappingRendering();
    }
}
