package butterknife.internal;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p020a.p021a.C0259a;
import android.util.TypedValue;
import android.view.View;
import java.lang.reflect.Array;
import java.util.List;

public final class Utils {
    private static final boolean HAS_SUPPORT_V4 = hasSupportV4();
    private static final TypedValue VALUE = new TypedValue();

    static class SupportV4 {
        private static final TypedValue OUT_VALUE = new TypedValue();

        SupportV4() {
        }

        static Drawable getTintedDrawable(Resources resources, Theme theme, int i, int i2) {
            if (theme.resolveAttribute(i2, OUT_VALUE, true)) {
                Drawable g = C0259a.m703g(Utils.getDrawable(resources, theme, i).mutate());
                C0259a.m690a(g, Utils.getColor(resources, theme, OUT_VALUE.resourceId));
                return g;
            }
            i = new StringBuilder();
            i.append("Required tint color attribute with name ");
            i.append(resources.getResourceEntryName(i2));
            i.append(" and attribute ID ");
            i.append(i2);
            i.append(" was not found.");
            throw new NotFoundException(i.toString());
        }
    }

    public static <T> T castParam(Object obj, String str, int i, String str2, int i2) {
        return obj;
    }

    private static boolean hasSupportV4() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = 0;
        r1 = "android.support.v4.a.a.a";	 Catch:{ ClassNotFoundException -> 0x0009, VerifyError -> 0x0008 }
        java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x0009, VerifyError -> 0x0008 }
        r0 = 1;
        return r0;
    L_0x0008:
        return r0;
    L_0x0009:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: butterknife.internal.Utils.hasSupportV4():boolean");
    }

    public static Drawable getTintedDrawable(Resources resources, Theme theme, int i, int i2) {
        if (HAS_SUPPORT_V4) {
            return SupportV4.getTintedDrawable(resources, theme, i, i2);
        }
        throw new RuntimeException("Android support-v4 library is required for @BindDrawable with tint.");
    }

    public static int getColor(Resources resources, Theme theme, int i) {
        if (VERSION.SDK_INT < 23) {
            return resources.getColor(i);
        }
        return resources.getColor(i, theme);
    }

    public static float getFloat(Resources resources, int i) {
        TypedValue typedValue = VALUE;
        resources.getValue(i, typedValue, true);
        if (typedValue.type == 4) {
            return typedValue.getFloat();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Resource ID #0x");
        stringBuilder.append(Integer.toHexString(i));
        stringBuilder.append(" type #0x");
        stringBuilder.append(Integer.toHexString(typedValue.type));
        stringBuilder.append(" is not valid");
        throw new NotFoundException(stringBuilder.toString());
    }

    public static ColorStateList getColorStateList(Resources resources, Theme theme, int i) {
        if (VERSION.SDK_INT < 23) {
            return resources.getColorStateList(i);
        }
        return resources.getColorStateList(i, theme);
    }

    public static Drawable getDrawable(Resources resources, Theme theme, int i) {
        if (VERSION.SDK_INT < 21) {
            return resources.getDrawable(i);
        }
        return resources.getDrawable(i, theme);
    }

    @SafeVarargs
    public static <T> T[] arrayOf(T... tArr) {
        return filterNull(tArr);
    }

    @SafeVarargs
    public static <T> List<T> listOf(T... tArr) {
        return new ImmutableList(filterNull(tArr));
    }

    private static <T> T[] filterNull(T[] tArr) {
        int i = 0;
        for (T t : tArr) {
            if (t != null) {
                int i2 = i + 1;
                tArr[i] = t;
                i = i2;
            }
        }
        if (i == r0) {
            return tArr;
        }
        Object[] objArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i);
        System.arraycopy(tArr, 0, objArr, 0, i);
        return objArr;
    }

    public static <T> T findOptionalViewAsType(View view, int i, String str, Class<T> cls) {
        return castView(view.findViewById(i), i, str, cls);
    }

    public static View findRequiredView(View view, int i, String str) {
        View findViewById = view.findViewById(i);
        if (findViewById != null) {
            return findViewById;
        }
        view = getResourceEntryName(view, i);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Required view '");
        stringBuilder.append(view);
        stringBuilder.append("' with ID ");
        stringBuilder.append(i);
        stringBuilder.append(" for ");
        stringBuilder.append(str);
        stringBuilder.append(" was not found. If this view is optional add '@Nullable' (fields) or '@Optional' (methods) annotation.");
        throw new IllegalStateException(stringBuilder.toString());
    }

    public static <T> T findRequiredViewAsType(View view, int i, String str, Class<T> cls) {
        return castView(findRequiredView(view, i, str), i, str, cls);
    }

    public static <T> T castView(View view, int i, String str, Class<T> cls) {
        try {
            return cls.cast(view);
        } catch (Class<T> cls2) {
            view = getResourceEntryName(view, i);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("View '");
            stringBuilder.append(view);
            stringBuilder.append("' with ID ");
            stringBuilder.append(i);
            stringBuilder.append(" for ");
            stringBuilder.append(str);
            stringBuilder.append(" was of the wrong type. See cause for more info.");
            throw new IllegalStateException(stringBuilder.toString(), cls2);
        }
    }

    private static String getResourceEntryName(View view, int i) {
        if (view.isInEditMode()) {
            return "<unavailable while editing>";
        }
        return view.getContext().getResources().getResourceEntryName(i);
    }

    private Utils() {
        throw new AssertionError("No instances.");
    }
}
