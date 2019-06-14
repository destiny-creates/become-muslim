package com.google.maps.android.p247a.p249b;

import com.facebook.react.uimanager.ViewProps;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.maps.android.p247a.C5393c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: KmlFeatureParser */
/* renamed from: com.google.maps.android.a.b.d */
class C5386d {
    /* renamed from: a */
    static C6923j m22854a(XmlPullParser xmlPullParser) {
        HashMap hashMap = new HashMap();
        int eventType = xmlPullParser.getEventType();
        C5393c c5393c = null;
        String str = null;
        C6925n c6925n = str;
        while (true) {
            if (eventType == 3) {
                if (xmlPullParser.getName().equals("Placemark")) {
                    return new C6923j(c5393c, str, c6925n, hashMap);
                }
            }
            if (eventType == 2) {
                if (xmlPullParser.getName().equals("styleUrl")) {
                    str = xmlPullParser.nextText();
                } else if (xmlPullParser.getName().matches("Point|LineString|Polygon|MultiGeometry")) {
                    c5393c = C5386d.m22855a(xmlPullParser, xmlPullParser.getName());
                } else if (xmlPullParser.getName().matches("name|description|drawOrder|visibility|open|address|phoneNumber")) {
                    hashMap.put(xmlPullParser.getName(), xmlPullParser.nextText());
                } else if (xmlPullParser.getName().equals("ExtendedData")) {
                    hashMap.putAll(C5386d.m22861e(xmlPullParser));
                } else if (xmlPullParser.getName().equals("Style")) {
                    c6925n = C5391o.m22880a(xmlPullParser);
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    /* renamed from: b */
    static C5387e m22858b(XmlPullParser xmlPullParser) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        int eventType = xmlPullParser.getEventType();
        String str = null;
        float f = 0.0f;
        int i = 1;
        float f2 = 0.0f;
        while (true) {
            if (eventType == 3) {
                if (xmlPullParser.getName().equals("GroundOverlay")) {
                    return new C5387e(str, C5386d.m22853a((Double) hashMap2.get("north"), (Double) hashMap2.get("south"), (Double) hashMap2.get("east"), (Double) hashMap2.get("west")), f, i, hashMap, f2);
                }
            }
            if (eventType == 2) {
                if (xmlPullParser.getName().equals("Icon")) {
                    str = C5386d.m22860d(xmlPullParser);
                } else if (xmlPullParser.getName().equals("drawOrder")) {
                    f = Float.parseFloat(xmlPullParser.nextText());
                } else if (xmlPullParser.getName().equals("visibility")) {
                    i = Integer.parseInt(xmlPullParser.nextText());
                } else if (xmlPullParser.getName().equals("ExtendedData")) {
                    hashMap.putAll(C5386d.m22861e(xmlPullParser));
                } else if (xmlPullParser.getName().equals("rotation")) {
                    f2 = C5386d.m22859c(xmlPullParser);
                } else {
                    if (!xmlPullParser.getName().matches("name|description|drawOrder|visibility|open|address|phoneNumber")) {
                        if (!xmlPullParser.getName().equals(ViewProps.COLOR)) {
                            if (xmlPullParser.getName().matches("north|south|east|west")) {
                                hashMap2.put(xmlPullParser.getName(), Double.valueOf(Double.parseDouble(xmlPullParser.nextText())));
                            }
                        }
                    }
                    hashMap.put(xmlPullParser.getName(), xmlPullParser.nextText());
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    /* renamed from: c */
    private static float m22859c(XmlPullParser xmlPullParser) {
        return -Float.parseFloat(xmlPullParser.nextText());
    }

    /* renamed from: d */
    private static String m22860d(XmlPullParser xmlPullParser) {
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 3) {
                if (xmlPullParser.getName().equals("Icon")) {
                    return null;
                }
            }
            if (eventType == 2 && xmlPullParser.getName().equals(ShareConstants.WEB_DIALOG_PARAM_HREF)) {
                return xmlPullParser.nextText();
            }
            eventType = xmlPullParser.next();
        }
    }

    /* renamed from: a */
    private static C5393c m22855a(XmlPullParser xmlPullParser, String str) {
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 3) {
                if (xmlPullParser.getName().equals(str)) {
                    return null;
                }
            }
            if (eventType == 2) {
                if (xmlPullParser.getName().equals("Point")) {
                    return C5386d.m22862f(xmlPullParser);
                }
                if (xmlPullParser.getName().equals("LineString")) {
                    return C5386d.m22863g(xmlPullParser);
                }
                if (xmlPullParser.getName().equals("Polygon")) {
                    return C5386d.m22864h(xmlPullParser);
                }
                if (xmlPullParser.getName().equals("MultiGeometry")) {
                    return C5386d.m22865i(xmlPullParser);
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    /* renamed from: e */
    private static HashMap<String, String> m22861e(XmlPullParser xmlPullParser) {
        HashMap<String, String> hashMap = new HashMap();
        int eventType = xmlPullParser.getEventType();
        Object obj = null;
        while (true) {
            if (eventType == 3) {
                if (xmlPullParser.getName().equals("ExtendedData")) {
                    return hashMap;
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

    /* renamed from: f */
    private static C7927k m22862f(XmlPullParser xmlPullParser) {
        int eventType = xmlPullParser.getEventType();
        LatLng latLng = null;
        while (true) {
            if (eventType == 3) {
                if (xmlPullParser.getName().equals("Point")) {
                    return new C7927k(latLng);
                }
            }
            if (eventType == 2 && xmlPullParser.getName().equals("coordinates")) {
                latLng = C5386d.m22857b(xmlPullParser.nextText());
            }
            eventType = xmlPullParser.next();
        }
    }

    /* renamed from: g */
    private static C7925g m22863g(XmlPullParser xmlPullParser) {
        ArrayList arrayList = new ArrayList();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 3) {
                if (xmlPullParser.getName().equals("LineString")) {
                    return new C7925g(arrayList);
                }
            }
            if (eventType == 2 && xmlPullParser.getName().equals("coordinates")) {
                arrayList = C5386d.m22856a(xmlPullParser.nextText());
            }
            eventType = xmlPullParser.next();
        }
    }

    /* renamed from: h */
    private static C7928l m22864h(XmlPullParser xmlPullParser) {
        Boolean valueOf = Boolean.valueOf(false);
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 3) {
                if (xmlPullParser.getName().equals("Polygon")) {
                    return new C7928l(arrayList, arrayList2);
                }
            }
            if (eventType == 2) {
                if (xmlPullParser.getName().matches("outerBoundaryIs|innerBoundaryIs")) {
                    valueOf = Boolean.valueOf(xmlPullParser.getName().equals("outerBoundaryIs"));
                } else if (xmlPullParser.getName().equals("coordinates")) {
                    if (valueOf.booleanValue()) {
                        arrayList = C5386d.m22856a(xmlPullParser.nextText());
                    } else {
                        arrayList2.add(C5386d.m22856a(xmlPullParser.nextText()));
                    }
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    /* renamed from: i */
    private static C7926h m22865i(XmlPullParser xmlPullParser) {
        ArrayList arrayList = new ArrayList();
        int next = xmlPullParser.next();
        while (true) {
            if (next == 3) {
                if (xmlPullParser.getName().equals("MultiGeometry")) {
                    return new C7926h(arrayList);
                }
            }
            if (next == 2 && xmlPullParser.getName().matches("Point|LineString|Polygon|MultiGeometry")) {
                arrayList.add(C5386d.m22855a(xmlPullParser, xmlPullParser.getName()));
            }
            next = xmlPullParser.next();
        }
    }

    /* renamed from: a */
    private static ArrayList<LatLng> m22856a(String str) {
        ArrayList<LatLng> arrayList = new ArrayList();
        for (String b : str.trim().split("(\\s+)")) {
            arrayList.add(C5386d.m22857b(b));
        }
        return arrayList;
    }

    /* renamed from: b */
    private static LatLng m22857b(String str) {
        str = str.split(",");
        return new LatLng(Double.valueOf(Double.parseDouble(str[1])).doubleValue(), Double.valueOf(Double.parseDouble(str[0])).doubleValue());
    }

    /* renamed from: a */
    private static LatLngBounds m22853a(Double d, Double d2, Double d3, Double d4) {
        return new LatLngBounds(new LatLng(d2.doubleValue(), d4.doubleValue()), new LatLng(d.doubleValue(), d3.doubleValue()));
    }
}
