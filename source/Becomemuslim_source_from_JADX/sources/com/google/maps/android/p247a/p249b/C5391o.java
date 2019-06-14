package com.google.maps.android.p247a.p249b;

import com.facebook.react.uimanager.ViewProps;
import com.facebook.share.internal.ShareConstants;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: KmlStyleParser */
/* renamed from: com.google.maps.android.a.b.o */
class C5391o {
    /* renamed from: a */
    static C6925n m22880a(XmlPullParser xmlPullParser) {
        C6925n c6925n = new C6925n();
        C5391o.m22881a(xmlPullParser.getAttributeValue(null, "id"), c6925n);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 3) {
                if (xmlPullParser.getName().equals("Style")) {
                    return c6925n;
                }
            }
            if (eventType == 2) {
                if (xmlPullParser.getName().equals("IconStyle")) {
                    C5391o.m22882a(xmlPullParser, c6925n);
                } else if (xmlPullParser.getName().equals("LineStyle")) {
                    C5391o.m22887e(xmlPullParser, c6925n);
                } else if (xmlPullParser.getName().equals("PolyStyle")) {
                    C5391o.m22888f(xmlPullParser, c6925n);
                } else if (xmlPullParser.getName().equals("BalloonStyle")) {
                    C5391o.m22884b(xmlPullParser, c6925n);
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    /* renamed from: a */
    private static void m22881a(String str, C6925n c6925n) {
        if (str != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("#");
            stringBuilder.append(str);
            c6925n.m32502b(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    private static void m22882a(XmlPullParser xmlPullParser, C6925n c6925n) {
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 3) {
                if (xmlPullParser.getName().equals("IconStyle")) {
                    return;
                }
            }
            if (eventType == 2) {
                if (xmlPullParser.getName().equals("heading")) {
                    c6925n.m32507d(Float.parseFloat(xmlPullParser.nextText()));
                } else if (xmlPullParser.getName().equals("Icon")) {
                    C5391o.m22885c(xmlPullParser, c6925n);
                } else if (xmlPullParser.getName().equals("hotSpot")) {
                    C5391o.m22886d(xmlPullParser, c6925n);
                } else if (xmlPullParser.getName().equals("scale")) {
                    c6925n.m32496a(Double.parseDouble(xmlPullParser.nextText()));
                } else if (xmlPullParser.getName().equals(ViewProps.COLOR)) {
                    c6925n.m32511f(xmlPullParser.nextText());
                } else if (xmlPullParser.getName().equals("colorMode")) {
                    c6925n.m32514g(xmlPullParser.nextText());
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    /* renamed from: b */
    static HashMap<String, String> m22883b(XmlPullParser xmlPullParser) {
        HashMap<String, String> hashMap = new HashMap();
        Boolean valueOf = Boolean.valueOf(false);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("#");
        stringBuilder.append(xmlPullParser.getAttributeValue(null, "id"));
        String stringBuilder2 = stringBuilder.toString();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 3) {
                if (xmlPullParser.getName().equals("StyleMap")) {
                    return hashMap;
                }
            }
            if (eventType == 2) {
                if (xmlPullParser.getName().equals("key") && xmlPullParser.nextText().equals("normal")) {
                    valueOf = Boolean.valueOf(true);
                } else if (xmlPullParser.getName().equals("styleUrl") && r2.booleanValue()) {
                    hashMap.put(stringBuilder2, xmlPullParser.nextText());
                    valueOf = Boolean.valueOf(false);
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    /* renamed from: b */
    private static void m22884b(XmlPullParser xmlPullParser, C6925n c6925n) {
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 3) {
                if (xmlPullParser.getName().equals("BalloonStyle")) {
                    return;
                }
            }
            if (eventType == 2 && xmlPullParser.getName().equals("text")) {
                c6925n.m32498a(xmlPullParser.nextText());
            }
            eventType = xmlPullParser.next();
        }
    }

    /* renamed from: c */
    private static void m22885c(XmlPullParser xmlPullParser, C6925n c6925n) {
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 3) {
                if (xmlPullParser.getName().equals("Icon")) {
                    return;
                }
            }
            if (eventType == 2 && xmlPullParser.getName().equals(ShareConstants.WEB_DIALOG_PARAM_HREF)) {
                c6925n.m32508d(xmlPullParser.nextText());
            }
            eventType = xmlPullParser.next();
        }
    }

    /* renamed from: d */
    private static void m22886d(XmlPullParser xmlPullParser, C6925n c6925n) {
        Float valueOf = Float.valueOf(Float.parseFloat(xmlPullParser.getAttributeValue(null, "x")));
        Float valueOf2 = Float.valueOf(Float.parseFloat(xmlPullParser.getAttributeValue(null, "y")));
        c6925n.m32501b(valueOf.floatValue(), valueOf2.floatValue(), xmlPullParser.getAttributeValue(null, "xunits"), xmlPullParser.getAttributeValue(null, "yunits"));
    }

    /* renamed from: e */
    private static void m22887e(XmlPullParser xmlPullParser, C6925n c6925n) {
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 3) {
                if (xmlPullParser.getName().equals("LineStyle")) {
                    return;
                }
            }
            if (eventType == 2) {
                if (xmlPullParser.getName().equals(ViewProps.COLOR)) {
                    c6925n.m32519j(xmlPullParser.nextText());
                } else if (xmlPullParser.getName().equals("width")) {
                    c6925n.m32497a(Float.valueOf(xmlPullParser.nextText()));
                } else if (xmlPullParser.getName().equals("colorMode")) {
                    c6925n.m32515h(xmlPullParser.nextText());
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    /* renamed from: f */
    private static void m22888f(XmlPullParser xmlPullParser, C6925n c6925n) {
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 3) {
                if (xmlPullParser.getName().equals("PolyStyle")) {
                    return;
                }
            }
            if (eventType == 2) {
                if (xmlPullParser.getName().equals(ViewProps.COLOR)) {
                    c6925n.m32509e(xmlPullParser.nextText());
                } else if (xmlPullParser.getName().equals("outline")) {
                    c6925n.m32503b(C5383a.m22835a(xmlPullParser.nextText()));
                } else if (xmlPullParser.getName().equals("fill")) {
                    c6925n.m32499a(C5383a.m22835a(xmlPullParser.nextText()));
                } else if (xmlPullParser.getName().equals("colorMode")) {
                    c6925n.m32517i(xmlPullParser.nextText());
                }
            }
            eventType = xmlPullParser.next();
        }
    }
}
