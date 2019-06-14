package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: TintContextWrapper */
public class bn extends ContextWrapper {
    /* renamed from: a */
    private static final Object f2129a = new Object();
    /* renamed from: b */
    private static ArrayList<WeakReference<bn>> f2130b;
    /* renamed from: c */
    private final Resources f2131c;
    /* renamed from: d */
    private final Theme f2132d;

    /* renamed from: a */
    public static Context m2764a(Context context) {
        if (!m2765b(context)) {
            return context;
        }
        synchronized (f2129a) {
            if (f2130b == null) {
                f2130b = new ArrayList();
            } else {
                int size;
                WeakReference weakReference;
                for (size = f2130b.size() - 1; size >= 0; size--) {
                    weakReference = (WeakReference) f2130b.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        f2130b.remove(size);
                    }
                }
                size = f2130b.size() - 1;
                while (size >= 0) {
                    weakReference = (WeakReference) f2130b.get(size);
                    Context context2 = weakReference != null ? (bn) weakReference.get() : null;
                    if (context2 == null || context2.getBaseContext() != context) {
                        size--;
                    } else {
                        return context2;
                    }
                }
            }
            Context bnVar = new bn(context);
            f2130b.add(new WeakReference(bnVar));
            return bnVar;
        }
    }

    /* renamed from: b */
    private static boolean m2765b(Context context) {
        boolean z = false;
        if (!((context instanceof bn) || (context.getResources() instanceof bp))) {
            if ((context.getResources() instanceof bv) == null) {
                if (VERSION.SDK_INT < 21 || bv.m2802a() != null) {
                    z = true;
                }
                return z;
            }
        }
        return false;
    }

    private bn(Context context) {
        super(context);
        if (bv.m2802a()) {
            this.f2131c = new bv(this, context.getResources());
            this.f2132d = this.f2131c.newTheme();
            this.f2132d.setTo(context.getTheme());
            return;
        }
        this.f2131c = new bp(this, context.getResources());
        this.f2132d = null;
    }

    public Theme getTheme() {
        return this.f2132d == null ? super.getTheme() : this.f2132d;
    }

    public void setTheme(int i) {
        if (this.f2132d == null) {
            super.setTheme(i);
        } else {
            this.f2132d.applyStyle(i, true);
        }
    }

    public Resources getResources() {
        return this.f2131c;
    }

    public AssetManager getAssets() {
        return this.f2131c.getAssets();
    }
}
