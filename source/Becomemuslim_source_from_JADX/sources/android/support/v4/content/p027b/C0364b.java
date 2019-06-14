package android.support.v4.content.p027b;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.p027b.C0360a.C0358a;
import android.support.v4.p020a.C0269c;
import android.util.Log;
import android.util.TypedValue;

/* compiled from: ResourcesCompat */
/* renamed from: android.support.v4.content.b.b */
public final class C0364b {

    /* compiled from: ResourcesCompat */
    /* renamed from: android.support.v4.content.b.b$a */
    public static abstract class C0363a {
        /* renamed from: a */
        public abstract void mo711a(int i);

        /* renamed from: a */
        public abstract void mo712a(Typeface typeface);

        /* renamed from: a */
        public final void m1089a(final Typeface typeface, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable(this) {
                /* renamed from: b */
                final /* synthetic */ C0363a f960b;

                public void run() {
                    this.f960b.mo712a(typeface);
                }
            });
        }

        /* renamed from: a */
        public final void m1087a(final int i, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable(this) {
                /* renamed from: b */
                final /* synthetic */ C0363a f962b;

                public void run() {
                    this.f962b.mo711a(i);
                }
            });
        }
    }

    /* renamed from: a */
    public static Drawable m1093a(Resources resources, int i, Theme theme) {
        if (VERSION.SDK_INT >= 21) {
            return resources.getDrawable(i, theme);
        }
        return resources.getDrawable(i);
    }

    /* renamed from: a */
    public static Typeface m1090a(Context context, int i, TypedValue typedValue, int i2, C0363a c0363a) {
        if (context.isRestricted()) {
            return null;
        }
        return C0364b.m1091a(context, i, typedValue, i2, c0363a, null, true);
    }

    /* renamed from: a */
    private static Typeface m1091a(Context context, int i, TypedValue typedValue, int i2, C0363a c0363a, Handler handler, boolean z) {
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        context = C0364b.m1092a(context, resources, typedValue, i, i2, c0363a, handler, z);
        if (context == null) {
            if (c0363a == null) {
                typedValue = new StringBuilder();
                typedValue.append("Font resource ID #0x");
                typedValue.append(Integer.toHexString(i));
                typedValue.append(" could not be retrieved.");
                throw new NotFoundException(typedValue.toString());
            }
        }
        return context;
    }

    /* renamed from: a */
    private static Typeface m1092a(Context context, Resources resources, TypedValue typedValue, int i, int i2, C0363a c0363a, Handler handler, boolean z) {
        StringBuilder stringBuilder;
        Resources resources2 = resources;
        TypedValue typedValue2 = typedValue;
        int i3 = i;
        int i4 = i2;
        C0363a c0363a2 = c0363a;
        Handler handler2 = handler;
        if (typedValue2.string != null) {
            String charSequence = typedValue2.string.toString();
            if (charSequence.startsWith("res/")) {
                Typeface a = C0269c.m740a(resources, i3, i4);
                if (a != null) {
                    if (c0363a2 != null) {
                        c0363a2.m1089a(a, handler2);
                    }
                    return a;
                }
                try {
                    if (charSequence.toLowerCase().endsWith(".xml")) {
                        C0358a a2 = C0360a.m1079a(resources.getXml(i3), resources);
                        if (a2 != null) {
                            return C0269c.m739a(context, a2, resources, i, i2, c0363a, handler, z);
                        }
                        Log.e("ResourcesCompat", "Failed to find font-family tag");
                        if (c0363a2 != null) {
                            c0363a2.m1087a(-3, handler2);
                        }
                        return null;
                    }
                    Context context2 = context;
                    Typeface a3 = C0269c.m737a(context, resources, i3, charSequence, i4);
                    if (c0363a2 != null) {
                        if (a3 != null) {
                            c0363a2.m1089a(a3, handler2);
                        } else {
                            c0363a2.m1087a(-3, handler2);
                        }
                    }
                    return a3;
                } catch (Throwable e) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Failed to parse xml resource ");
                    stringBuilder.append(charSequence);
                    Log.e("ResourcesCompat", stringBuilder.toString(), e);
                    if (c0363a2 != null) {
                        c0363a2.m1087a(-3, handler2);
                    }
                    return null;
                } catch (Throwable e2) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Failed to read xml resource ");
                    stringBuilder.append(charSequence);
                    Log.e("ResourcesCompat", stringBuilder.toString(), e2);
                    if (c0363a2 != null) {
                        c0363a2.m1087a(-3, handler2);
                    }
                    return null;
                }
            }
            if (c0363a2 != null) {
                c0363a2.m1087a(-3, handler2);
            }
            return null;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Resource \"");
        stringBuilder2.append(resources.getResourceName(i3));
        stringBuilder2.append("\" (");
        stringBuilder2.append(Integer.toHexString(i));
        stringBuilder2.append(") is not a Font: ");
        stringBuilder2.append(typedValue2);
        throw new NotFoundException(stringBuilder2.toString());
    }
}
