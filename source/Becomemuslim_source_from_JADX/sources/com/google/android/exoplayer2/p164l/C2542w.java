package com.google.android.exoplayer2.p164l;

import org.xmlpull.v1.XmlPullParser;

/* compiled from: XmlPullParserUtil */
/* renamed from: com.google.android.exoplayer2.l.w */
public final class C2542w {
    /* renamed from: a */
    public static boolean m7197a(XmlPullParser xmlPullParser, String str) {
        return (!C2542w.m7196a(xmlPullParser) || xmlPullParser.getName().equals(str) == null) ? null : true;
    }

    /* renamed from: a */
    public static boolean m7196a(XmlPullParser xmlPullParser) {
        return xmlPullParser.getEventType() == 3 ? true : null;
    }

    /* renamed from: b */
    public static boolean m7199b(XmlPullParser xmlPullParser, String str) {
        return (!C2542w.m7198b(xmlPullParser) || xmlPullParser.getName().equals(str) == null) ? null : true;
    }

    /* renamed from: b */
    public static boolean m7198b(XmlPullParser xmlPullParser) {
        return xmlPullParser.getEventType() == 2 ? true : null;
    }

    /* renamed from: c */
    public static String m7200c(XmlPullParser xmlPullParser, String str) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            if (str.equals(xmlPullParser.getAttributeName(i))) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }
}
