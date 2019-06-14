package android.support.v7.p042f;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

/* compiled from: AllCapsTransformationMethod */
/* renamed from: android.support.v7.f.a */
public class C0637a implements TransformationMethod {
    /* renamed from: a */
    private Locale f1621a;

    public void onFocusChanged(View view, CharSequence charSequence, boolean z, int i, Rect rect) {
    }

    public C0637a(Context context) {
        this.f1621a = context.getResources().getConfiguration().locale;
    }

    public CharSequence getTransformation(CharSequence charSequence, View view) {
        return charSequence != null ? charSequence.toString().toUpperCase(this.f1621a) : null;
    }
}
