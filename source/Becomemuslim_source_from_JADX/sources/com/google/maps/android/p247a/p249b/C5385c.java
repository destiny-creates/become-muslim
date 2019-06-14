package com.google.maps.android.p247a.p249b;

import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: KmlContainerParser */
/* renamed from: com.google.maps.android.a.b.c */
class C5385c {
    /* renamed from: a */
    static C5384b m22847a(XmlPullParser xmlPullParser) {
        return C5385c.m22849b(xmlPullParser);
    }

    /* renamed from: b */
    private static C5384b m22849b(XmlPullParser xmlPullParser) {
        String name = xmlPullParser.getName();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        ArrayList arrayList = new ArrayList();
        HashMap hashMap4 = new HashMap();
        HashMap hashMap5 = new HashMap();
        String attributeValue = xmlPullParser.getAttributeValue(null, "id") != null ? xmlPullParser.getAttributeValue(null, "id") : null;
        xmlPullParser.next();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 3) {
                if (xmlPullParser.getName().equals(name)) {
                    return new C5384b(hashMap, hashMap2, hashMap3, hashMap4, arrayList, hashMap5, attributeValue);
                }
            }
            if (eventType == 2) {
                if (xmlPullParser.getName().matches("altitude|altitudeModeGroup|altitudeMode|begin|bottomFov|cookie|displayName|displayMode|displayMode|end|expires|extrude|flyToView|gridOrigin|httpQuery|leftFov|linkDescription|linkName|linkSnippet|listItemType|maxSnippetLines|maxSessionLength|message|minAltitude|minFadeExtent|minLodPixels|minRefreshPeriod|maxAltitude|maxFadeExtent|maxLodPixels|maxHeight|maxWidth|near|overlayXY|range|refreshMode|refreshInterval|refreshVisibility|rightFov|roll|rotationXY|screenXY|shape|sourceHref|state|targetHref|tessellate|tileSize|topFov|viewBoundScale|viewFormat|viewRefreshMode|viewRefreshTime|when")) {
                    C5388i.m22869a(xmlPullParser);
                } else if (xmlPullParser.getName().matches("Folder|Document")) {
                    arrayList.add(C5385c.m22849b(xmlPullParser));
                } else if (xmlPullParser.getName().matches("name|description|visibility|open|address|phoneNumber")) {
                    hashMap.put(xmlPullParser.getName(), xmlPullParser.nextText());
                } else if (xmlPullParser.getName().equals("StyleMap")) {
                    C5385c.m22848a(xmlPullParser, hashMap4);
                } else if (xmlPullParser.getName().equals("Style")) {
                    C5385c.m22851c(xmlPullParser, hashMap2);
                } else if (xmlPullParser.getName().equals("Placemark")) {
                    C5385c.m22852d(xmlPullParser, hashMap3);
                } else if (xmlPullParser.getName().equals("ExtendedData")) {
                    C5385c.m22850b(xmlPullParser, hashMap);
                } else if (xmlPullParser.getName().equals("GroundOverlay")) {
                    hashMap5.put(C5386d.m22858b(xmlPullParser), null);
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    /* renamed from: a */
    private static void m22848a(XmlPullParser xmlPullParser, HashMap<String, String> hashMap) {
        hashMap.putAll(C5391o.m22883b(xmlPullParser));
    }

    /* renamed from: b */
    private static void m22850b(XmlPullParser xmlPullParser, HashMap<String, String> hashMap) {
        int eventType = xmlPullParser.getEventType();
        Object obj = null;
        while (true) {
            if (eventType == 3) {
                if (xmlPullParser.getName().equals("ExtendedData")) {
                    return;
                }
            }
            if (eventType == 2) {
                if (xmlPullParser.getName().equals("Data")) {
                    obj = xmlPullParser.getAttributeValue(null, "name");
                } else if (xmlPullParser.getName().equals("value") && obj != null) {
                    hashMap.put(obj, xmlPullParser.nextText());
                    obj = null;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    /* renamed from: c */
    private static void m22851c(XmlPullParser xmlPullParser, HashMap<String, C6925n> hashMap) {
        if (xmlPullParser.getAttributeValue(null, "id") != null) {
            xmlPullParser = C5391o.m22880a(xmlPullParser);
            hashMap.put(xmlPullParser.m32500b(), xmlPullParser);
        }
    }

    /* renamed from: d */
    private static void m22852d(XmlPullParser xmlPullParser, HashMap<C6923j, Object> hashMap) {
        hashMap.put(C5386d.m22854a(xmlPullParser), null);
    }
}
