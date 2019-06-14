package android.support.v4.p032h;

import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.Locale;

/* compiled from: TextUtilsCompat */
/* renamed from: android.support.v4.h.d */
public final class C0415d {
    /* renamed from: a */
    private static final Locale f1074a = new Locale("", "");

    /* renamed from: a */
    public static int m1221a(Locale locale) {
        if (VERSION.SDK_INT >= 17) {
            return TextUtils.getLayoutDirectionFromLocale(locale);
        }
        if (!(locale == null || locale.equals(f1074a))) {
            String a = C0411a.m1215a(locale);
            if (a == null) {
                return C0415d.m1222b(locale);
            }
            if (!(a.equalsIgnoreCase("Arab") == null && a.equalsIgnoreCase("Hebr") == null)) {
                return 1;
            }
        }
        return null;
    }

    /* renamed from: b */
    private static int m1222b(Locale locale) {
        switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
            case 1:
            case 2:
                return 1;
            default:
                return 0;
        }
    }
}
