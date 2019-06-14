package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* compiled from: TintResources */
class bp extends bb {
    /* renamed from: a */
    private final WeakReference<Context> f8803a;

    public bp(Context context, Resources resources) {
        super(resources);
        this.f8803a = new WeakReference(context);
    }

    public Drawable getDrawable(int i) {
        Drawable drawable = super.getDrawable(i);
        Context context = (Context) this.f8803a.get();
        if (!(drawable == null || context == null)) {
            C0799m.m2896a();
            C0799m.m2902a(context, i, drawable);
        }
        return drawable;
    }
}
