package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.p035a.C0591a.C0590j;
import android.util.AttributeSet;
import android.widget.TextView;

/* compiled from: AppCompatTextHelperV17 */
class aa extends C0810z {
    /* renamed from: b */
    private bo f8712b;
    /* renamed from: c */
    private bo f8713c;

    aa(TextView textView) {
        super(textView);
    }

    /* renamed from: a */
    void mo604a(AttributeSet attributeSet, int i) {
        super.mo604a(attributeSet, i);
        Context context = this.a.getContext();
        C0799m a = C0799m.m2896a();
        attributeSet = context.obtainStyledAttributes(attributeSet, C0590j.AppCompatTextHelper, i, 0);
        if (attributeSet.hasValue(C0590j.AppCompatTextHelper_android_drawableStart) != 0) {
            this.f8712b = C0810z.m2938a(context, a, attributeSet.getResourceId(C0590j.AppCompatTextHelper_android_drawableStart, 0));
        }
        if (attributeSet.hasValue(C0590j.AppCompatTextHelper_android_drawableEnd) != 0) {
            this.f8713c = C0810z.m2938a(context, a, attributeSet.getResourceId(C0590j.AppCompatTextHelper_android_drawableEnd, 0));
        }
        attributeSet.recycle();
    }

    /* renamed from: a */
    void mo603a() {
        super.mo603a();
        if (this.f8712b != null || this.f8713c != null) {
            Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
            m2949a(compoundDrawablesRelative[0], this.f8712b);
            m2949a(compoundDrawablesRelative[2], this.f8713c);
        }
    }
}
