package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.view.C0514r;
import android.support.v4.widget.C0575t;
import android.util.AttributeSet;
import android.widget.ImageView;

public class AppCompatImageView extends ImageView implements C0514r, C0575t {
    /* renamed from: a */
    private final C0795h f8615a;
    /* renamed from: b */
    private final C0801q f8616b;

    public AppCompatImageView(Context context) {
        this(context, null);
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet, int i) {
        super(bn.m2764a(context), attributeSet, i);
        this.f8615a = new C0795h(this);
        this.f8615a.m2877a(attributeSet, i);
        this.f8616b = new C0801q(this);
        this.f8616b.m2926a(attributeSet, i);
    }

    public void setImageResource(int i) {
        if (this.f8616b != null) {
            this.f8616b.m2923a(i);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.f8616b != null) {
            this.f8616b.m2930d();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.f8616b != null) {
            this.f8616b.m2930d();
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        if (this.f8616b != null) {
            this.f8616b.m2930d();
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f8615a != null) {
            this.f8615a.m2873a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f8615a != null) {
            this.f8615a.m2876a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f8615a != null) {
            this.f8615a.m2874a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f8615a != null ? this.f8615a.m2872a() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f8615a != null) {
            this.f8615a.m2875a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f8615a != null ? this.f8615a.m2878b() : null;
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.f8616b != null) {
            this.f8616b.m2924a(colorStateList);
        }
    }

    public ColorStateList getSupportImageTintList() {
        return this.f8616b != null ? this.f8616b.m2928b() : null;
    }

    public void setSupportImageTintMode(Mode mode) {
        if (this.f8616b != null) {
            this.f8616b.m2925a(mode);
        }
    }

    public Mode getSupportImageTintMode() {
        return this.f8616b != null ? this.f8616b.m2929c() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f8615a != null) {
            this.f8615a.m2880c();
        }
        if (this.f8616b != null) {
            this.f8616b.m2930d();
        }
    }

    public boolean hasOverlappingRendering() {
        return this.f8616b.m2927a() && super.hasOverlappingRendering();
    }
}
