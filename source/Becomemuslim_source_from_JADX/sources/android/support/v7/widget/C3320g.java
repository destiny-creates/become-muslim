package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.C0514r;
import android.support.v7.p035a.C0591a.C0581a;
import android.support.v7.p037c.p038a.C0631b;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

/* compiled from: AppCompatAutoCompleteTextView */
/* renamed from: android.support.v7.widget.g */
public class C3320g extends AutoCompleteTextView implements C0514r {
    /* renamed from: a */
    private static final int[] f8835a = new int[]{16843126};
    /* renamed from: b */
    private final C0795h f8836b;
    /* renamed from: c */
    private final C0810z f8837c;

    public C3320g(Context context) {
        this(context, null);
    }

    public C3320g(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0581a.autoCompleteTextViewStyle);
    }

    public C3320g(Context context, AttributeSet attributeSet, int i) {
        super(bn.m2764a(context), attributeSet, i);
        context = bq.m2769a(getContext(), attributeSet, f8835a, i, 0);
        if (context.m2787g(0)) {
            setDropDownBackgroundDrawable(context.m2773a(0));
        }
        context.m2774a();
        this.f8836b = new C0795h(this);
        this.f8836b.m2877a(attributeSet, i);
        this.f8837c = C0810z.m2939a((TextView) this);
        this.f8837c.mo604a(attributeSet, i);
        this.f8837c.mo603a();
    }

    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(C0631b.m2112b(getContext(), i));
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f8836b != null) {
            this.f8836b.m2873a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f8836b != null) {
            this.f8836b.m2876a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f8836b != null) {
            this.f8836b.m2874a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f8836b != null ? this.f8836b.m2872a() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f8836b != null) {
            this.f8836b.m2875a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f8836b != null ? this.f8836b.m2878b() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f8836b != null) {
            this.f8836b.m2880c();
        }
        if (this.f8837c != null) {
            this.f8837c.mo603a();
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f8837c != null) {
            this.f8837c.m2948a(context, i);
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return C0800o.m2920a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }
}
