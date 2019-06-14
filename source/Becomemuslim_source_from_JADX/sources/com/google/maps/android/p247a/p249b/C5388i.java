package com.google.maps.android.p247a.p249b;

import com.google.android.gms.maps.model.C5139g;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: KmlParser */
/* renamed from: com.google.maps.android.a.b.i */
class C5388i {
    /* renamed from: a */
    private final XmlPullParser f18158a;
    /* renamed from: b */
    private final HashMap<C6923j, Object> f18159b = new HashMap();
    /* renamed from: c */
    private final ArrayList<C5384b> f18160c = new ArrayList();
    /* renamed from: d */
    private final HashMap<String, C6925n> f18161d = new HashMap();
    /* renamed from: e */
    private final HashMap<String, String> f18162e = new HashMap();
    /* renamed from: f */
    private final HashMap<C5387e, C5139g> f18163f = new HashMap();

    C5388i(XmlPullParser xmlPullParser) {
        this.f18158a = xmlPullParser;
    }

    /* renamed from: a */
    void m22870a() {
        int eventType = this.f18158a.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                if (this.f18158a.getName().matches("altitude|altitudeModeGroup|altitudeMode|begin|bottomFov|cookie|displayName|displayMode|displayMode|end|expires|extrude|flyToView|gridOrigin|httpQuery|leftFov|linkDescription|linkName|linkSnippet|listItemType|maxSnippetLines|maxSessionLength|message|minAltitude|minFadeExtent|minLodPixels|minRefreshPeriod|maxAltitude|maxFadeExtent|maxLodPixels|maxHeight|maxWidth|near|NetworkLink|NetworkLinkControl|overlayXY|range|refreshMode|refreshInterval|refreshVisibility|rightFov|roll|rotationXY|screenXY|shape|sourceHref|state|targetHref|tessellate|tileSize|topFov|viewBoundScale|viewFormat|viewRefreshMode|viewRefreshTime|when")) {
                    C5388i.m22869a(this.f18158a);
                }
                if (this.f18158a.getName().matches("Folder|Document")) {
                    this.f18160c.add(C5385c.m22847a(this.f18158a));
                }
                if (this.f18158a.getName().equals("Style")) {
                    C6925n a = C5391o.m22880a(this.f18158a);
                    this.f18161d.put(a.m32500b(), a);
                }
                if (this.f18158a.getName().equals("StyleMap")) {
                    this.f18162e.putAll(C5391o.m22883b(this.f18158a));
                }
                if (this.f18158a.getName().equals("Placemark")) {
                    this.f18159b.put(C5386d.m22854a(this.f18158a), null);
                }
                if (this.f18158a.getName().equals("GroundOverlay")) {
                    this.f18163f.put(C5386d.m22858b(this.f18158a), null);
                }
            }
            eventType = this.f18158a.next();
        }
        this.f18161d.put(null, new C6925n());
    }

    /* renamed from: b */
    HashMap<String, C6925n> m22871b() {
        return this.f18161d;
    }

    /* renamed from: c */
    HashMap<C6923j, Object> m22872c() {
        return this.f18159b;
    }

    /* renamed from: d */
    HashMap<String, String> m22873d() {
        return this.f18162e;
    }

    /* renamed from: e */
    ArrayList<C5384b> m22874e() {
        return this.f18160c;
    }

    /* renamed from: f */
    HashMap<C5387e, C5139g> m22875f() {
        return this.f18163f;
    }

    /* renamed from: a */
    static void m22869a(XmlPullParser xmlPullParser) {
        if (xmlPullParser.getEventType() == 2) {
            int i = 1;
            while (i != 0) {
                switch (xmlPullParser.next()) {
                    case 2:
                        i++;
                        break;
                    case 3:
                        i--;
                        break;
                    default:
                        break;
                }
            }
            return;
        }
        throw new IllegalStateException();
    }
}
