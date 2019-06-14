package ai.api.ui;

import ai.api.C0043i.C0042c;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ImageView;

/* compiled from: MaskedColorView */
/* renamed from: ai.api.ui.a */
public class C0054a extends ImageView {
    /* renamed from: a */
    private ColorStateList f148a = null;

    public C0054a(Context context) {
        super(context, null);
    }

    public C0054a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16842866);
        m126a(attributeSet);
    }

    public C0054a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m126a(attributeSet);
    }

    @TargetApi(11)
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        setColorFilter(m125a(getDrawableState()), Mode.SRC_ATOP);
        if (VERSION.SDK_INT >= 11) {
            jumpDrawablesToCurrentState();
        }
    }

    public void setColorStateList(ColorStateList colorStateList) {
        this.f148a = colorStateList;
    }

    /* renamed from: a */
    private int m125a(int[] iArr) {
        if (this.f148a == null) {
            return -65281;
        }
        return this.f148a.getColorForState(iArr, this.f148a.getDefaultColor());
    }

    /* renamed from: a */
    private void m126a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            attributeSet = getContext().obtainStyledAttributes(attributeSet, C0042c.MaskedColorView);
            try {
                ColorStateList colorStateList = attributeSet.getColorStateList(C0042c.MaskedColorView_mainColor);
                if (colorStateList != null) {
                    this.f148a = colorStateList;
                }
                attributeSet.recycle();
            } catch (Throwable th) {
                attributeSet.recycle();
            }
        }
    }

    protected String getDebugState() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("====\ncsl is ");
        stringBuilder.append(this.f148a != null ? "NOT" : "");
        stringBuilder.append(" null");
        return stringBuilder.toString();
    }
}
