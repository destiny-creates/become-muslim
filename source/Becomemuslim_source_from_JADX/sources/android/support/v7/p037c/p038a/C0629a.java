package android.support.v7.p037c.p038a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.p020a.C0264a;
import android.support.v7.p035a.C0591a.C0581a;
import android.support.v7.p035a.C0591a.C0590j;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: AppCompatColorStateListInflater */
/* renamed from: android.support.v7.c.a.a */
final class C0629a {
    /* renamed from: a */
    public static ColorStateList m2105a(Resources resources, XmlPullParser xmlPullParser, Theme theme) {
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        while (true) {
            int next = xmlPullParser.next();
            if (next == 2 || next == 1) {
                if (next == 2) {
                    return C0629a.m2106a(resources, xmlPullParser, asAttributeSet, theme);
                }
                throw new XmlPullParserException("No start tag found");
            }
        }
        if (next == 2) {
            return C0629a.m2106a(resources, xmlPullParser, asAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    /* renamed from: a */
    private static ColorStateList m2106a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return C0629a.m2108b(resources, xmlPullParser, attributeSet, theme);
        }
        attributeSet = new StringBuilder();
        attributeSet.append(xmlPullParser.getPositionDescription());
        attributeSet.append(": invalid color state list tag ");
        attributeSet.append(name);
        throw new XmlPullParserException(attributeSet.toString());
    }

    /* renamed from: b */
    private static ColorStateList m2108b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        AttributeSet attributeSet2 = attributeSet;
        int i = 1;
        int depth = xmlPullParser.getDepth() + 1;
        Object obj = new int[20][];
        Object obj2 = new int[obj.length];
        int i2 = 0;
        while (true) {
            int next = xmlPullParser.next();
            if (next == i) {
                break;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                break;
            }
            if (next == 2 && depth2 <= depth) {
                if (xmlPullParser.getName().equals("item")) {
                    TypedArray a = C0629a.m2107a(resources, theme, attributeSet2, C0590j.ColorStateListItem);
                    int color = a.getColor(C0590j.ColorStateListItem_android_color, -65281);
                    float f = 1.0f;
                    if (a.hasValue(C0590j.ColorStateListItem_android_alpha)) {
                        f = a.getFloat(C0590j.ColorStateListItem_android_alpha, 1.0f);
                    } else if (a.hasValue(C0590j.ColorStateListItem_alpha)) {
                        f = a.getFloat(C0590j.ColorStateListItem_alpha, 1.0f);
                    }
                    a.recycle();
                    next = attributeSet.getAttributeCount();
                    int[] iArr = new int[next];
                    int i3 = 0;
                    for (int i4 = 0; i4 < next; i4++) {
                        int attributeNameResource = attributeSet2.getAttributeNameResource(i4);
                        if (!(attributeNameResource == 16843173 || attributeNameResource == 16843551 || attributeNameResource == C0581a.alpha)) {
                            i = i3 + 1;
                            if (!attributeSet2.getAttributeBooleanValue(i4, false)) {
                                attributeNameResource = -attributeNameResource;
                            }
                            iArr[i3] = attributeNameResource;
                            i3 = i;
                        }
                    }
                    Object trimStateSet = StateSet.trimStateSet(iArr, i3);
                    next = C0629a.m2104a(color, f);
                    if (i2 != 0) {
                        color = trimStateSet.length;
                    }
                    obj2 = C0632c.m2117a((int[]) obj2, i2, next);
                    obj = (int[][]) C0632c.m2118a((Object[]) obj, i2, trimStateSet);
                    i2++;
                    i = 1;
                }
            }
            Resources resources2 = resources;
            Theme theme2 = theme;
            i = 1;
        }
        Object obj3 = new int[i2];
        Object obj4 = new int[i2][];
        System.arraycopy(obj2, 0, obj3, 0, i2);
        System.arraycopy(obj, 0, obj4, 0, i2);
        return new ColorStateList(obj4, obj3);
    }

    /* renamed from: a */
    private static TypedArray m2107a(Resources resources, Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    /* renamed from: a */
    private static int m2104a(int i, float f) {
        return C0264a.m717b(i, Math.round(((float) Color.alpha(i)) * f));
    }
}
