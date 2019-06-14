package android.support.v4.content.p027b;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: TypedArrayUtils */
/* renamed from: android.support.v4.content.b.c */
public class C0365c {
    /* renamed from: a */
    public static boolean m1099a(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null ? true : null;
    }

    /* renamed from: a */
    public static float m1094a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, float f) {
        if (C0365c.m1099a(xmlPullParser, str) == null) {
            return f;
        }
        return typedArray.getFloat(i, f);
    }

    /* renamed from: a */
    public static boolean m1098a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, boolean z) {
        if (C0365c.m1099a(xmlPullParser, str) == null) {
            return z;
        }
        return typedArray.getBoolean(i, z);
    }

    /* renamed from: a */
    public static int m1095a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        if (C0365c.m1099a(xmlPullParser, str) == null) {
            return i2;
        }
        return typedArray.getInt(i, i2);
    }

    /* renamed from: b */
    public static int m1100b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        if (C0365c.m1099a(xmlPullParser, str) == null) {
            return i2;
        }
        return typedArray.getColor(i, i2);
    }

    /* renamed from: c */
    public static int m1102c(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        if (C0365c.m1099a(xmlPullParser, str) == null) {
            return i2;
        }
        return typedArray.getResourceId(i, i2);
    }

    /* renamed from: a */
    public static String m1097a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        if (C0365c.m1099a(xmlPullParser, str) == null) {
            return null;
        }
        return typedArray.getString(i);
    }

    /* renamed from: b */
    public static TypedValue m1101b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        if (C0365c.m1099a(xmlPullParser, str) == null) {
            return null;
        }
        return typedArray.peekValue(i);
    }

    /* renamed from: a */
    public static TypedArray m1096a(Resources resources, Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
