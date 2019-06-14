package android.support.v7.widget;

import android.content.Context;
import android.support.v7.p037c.p038a.C0631b;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import android.widget.TextView;

/* compiled from: AppCompatCheckedTextView */
/* renamed from: android.support.v7.widget.k */
public class C0796k extends CheckedTextView {
    /* renamed from: a */
    private static final int[] f2210a = new int[]{16843016};
    /* renamed from: b */
    private final C0810z f2211b;

    public C0796k(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public C0796k(Context context, AttributeSet attributeSet, int i) {
        super(bn.m2764a(context), attributeSet, i);
        this.f2211b = C0810z.m2939a((TextView) this);
        this.f2211b.mo604a(attributeSet, i);
        this.f2211b.mo603a();
        context = bq.m2769a(getContext(), attributeSet, f2210a, i, 0);
        setCheckMarkDrawable(context.m2773a(0));
        context.m2774a();
    }

    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(C0631b.m2112b(getContext(), i));
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f2211b != null) {
            this.f2211b.m2948a(context, i);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2211b != null) {
            this.f2211b.mo603a();
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return C0800o.m2920a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }
}
