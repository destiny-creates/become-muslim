package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.app.C0611e;
import java.lang.ref.WeakReference;

/* compiled from: VectorEnabledTintResources */
public class bv extends Resources {
    /* renamed from: a */
    private final WeakReference<Context> f2161a;

    /* renamed from: a */
    public static boolean m2802a() {
        return C0611e.m2060k() && VERSION.SDK_INT <= 20;
    }

    public bv(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f2161a = new WeakReference(context);
    }

    public Drawable getDrawable(int i) {
        Context context = (Context) this.f2161a.get();
        if (context != null) {
            return C0799m.m2896a().m2917a(context, this, i);
        }
        return super.getDrawable(i);
    }

    /* renamed from: a */
    final Drawable m2803a(int i) {
        return super.getDrawable(i);
    }
}
