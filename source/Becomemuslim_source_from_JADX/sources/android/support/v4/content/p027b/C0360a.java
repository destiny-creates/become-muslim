package android.support.v4.content.p027b;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.p013a.C0093a.C0092b;
import android.support.v4.p031g.C0398a;
import android.util.Base64;
import android.util.Xml;
import com.facebook.stetho.server.http.HttpStatus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: FontResourcesParserCompat */
/* renamed from: android.support.v4.content.b.a */
public class C0360a {

    /* compiled from: FontResourcesParserCompat */
    /* renamed from: android.support.v4.content.b.a$a */
    public interface C0358a {
    }

    /* compiled from: FontResourcesParserCompat */
    /* renamed from: android.support.v4.content.b.a$c */
    public static final class C0359c {
        /* renamed from: a */
        private final String f955a;
        /* renamed from: b */
        private int f956b;
        /* renamed from: c */
        private boolean f957c;
        /* renamed from: d */
        private int f958d;

        public C0359c(String str, int i, boolean z, int i2) {
            this.f955a = str;
            this.f956b = i;
            this.f957c = z;
            this.f958d = i2;
        }

        /* renamed from: a */
        public String m1075a() {
            return this.f955a;
        }

        /* renamed from: b */
        public int m1076b() {
            return this.f956b;
        }

        /* renamed from: c */
        public boolean m1077c() {
            return this.f957c;
        }

        /* renamed from: d */
        public int m1078d() {
            return this.f958d;
        }
    }

    /* compiled from: FontResourcesParserCompat */
    /* renamed from: android.support.v4.content.b.a$b */
    public static final class C3193b implements C0358a {
        /* renamed from: a */
        private final C0359c[] f8238a;

        public C3193b(C0359c[] c0359cArr) {
            this.f8238a = c0359cArr;
        }

        /* renamed from: a */
        public C0359c[] m9665a() {
            return this.f8238a;
        }
    }

    /* compiled from: FontResourcesParserCompat */
    /* renamed from: android.support.v4.content.b.a$d */
    public static final class C3194d implements C0358a {
        /* renamed from: a */
        private final C0398a f8239a;
        /* renamed from: b */
        private final int f8240b;
        /* renamed from: c */
        private final int f8241c;

        public C3194d(C0398a c0398a, int i, int i2) {
            this.f8239a = c0398a;
            this.f8241c = i;
            this.f8240b = i2;
        }

        /* renamed from: a */
        public C0398a m9666a() {
            return this.f8239a;
        }

        /* renamed from: b */
        public int m9667b() {
            return this.f8241c;
        }

        /* renamed from: c */
        public int m9668c() {
            return this.f8240b;
        }
    }

    /* renamed from: a */
    public static C0358a m1079a(XmlPullParser xmlPullParser, Resources resources) {
        while (true) {
            int next = xmlPullParser.next();
            if (next == 2 || next == 1) {
                if (next == 2) {
                    return C0360a.m1083b(xmlPullParser, resources);
                }
                throw new XmlPullParserException("No start tag found");
            }
        }
        if (next == 2) {
            return C0360a.m1083b(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    /* renamed from: b */
    private static C0358a m1083b(XmlPullParser xmlPullParser, Resources resources) {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return C0360a.m1084c(xmlPullParser, resources);
        }
        C0360a.m1082a(xmlPullParser);
        return null;
    }

    /* renamed from: c */
    private static C0358a m1084c(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), C0092b.FontFamily);
        String string = obtainAttributes.getString(C0092b.FontFamily_fontProviderAuthority);
        String string2 = obtainAttributes.getString(C0092b.FontFamily_fontProviderPackage);
        String string3 = obtainAttributes.getString(C0092b.FontFamily_fontProviderQuery);
        int resourceId = obtainAttributes.getResourceId(C0092b.FontFamily_fontProviderCerts, 0);
        int integer = obtainAttributes.getInteger(C0092b.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = obtainAttributes.getInteger(C0092b.FontFamily_fontProviderFetchTimeout, HttpStatus.HTTP_INTERNAL_SERVER_ERROR);
        obtainAttributes.recycle();
        if (string == null || string2 == null || string3 == null) {
            List arrayList = new ArrayList();
            while (xmlPullParser.next() != 3) {
                if (xmlPullParser.getEventType() == 2) {
                    if (xmlPullParser.getName().equals("font")) {
                        arrayList.add(C0360a.m1085d(xmlPullParser, resources));
                    } else {
                        C0360a.m1082a(xmlPullParser);
                    }
                }
            }
            if (arrayList.isEmpty() != null) {
                return null;
            }
            return new C3193b((C0359c[]) arrayList.toArray(new C0359c[arrayList.size()]));
        }
        while (xmlPullParser.next() != 3) {
            C0360a.m1082a(xmlPullParser);
        }
        return new C3194d(new C0398a(string, string2, string3, C0360a.m1080a(resources, resourceId)), integer, integer2);
    }

    /* renamed from: a */
    public static List<List<byte[]>> m1080a(Resources resources, int i) {
        List<List<byte[]>> list = null;
        if (i != 0) {
            TypedArray obtainTypedArray = resources.obtainTypedArray(i);
            if (obtainTypedArray.length() > 0) {
                list = new ArrayList();
                if ((obtainTypedArray.getResourceId(0, 0) != 0 ? 1 : null) != null) {
                    for (i = 0; i < obtainTypedArray.length(); i++) {
                        list.add(C0360a.m1081a(resources.getStringArray(obtainTypedArray.getResourceId(i, 0))));
                    }
                } else {
                    list.add(C0360a.m1081a(resources.getStringArray(i)));
                }
            }
            obtainTypedArray.recycle();
        }
        return list != null ? list : Collections.emptyList();
    }

    /* renamed from: a */
    private static List<byte[]> m1081a(String[] strArr) {
        List<byte[]> arrayList = new ArrayList();
        for (String decode : strArr) {
            arrayList.add(Base64.decode(decode, 0));
        }
        return arrayList;
    }

    /* renamed from: d */
    private static C0359c m1085d(XmlPullParser xmlPullParser, Resources resources) {
        resources = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), C0092b.FontFamilyFont);
        int i = resources.getInt(resources.hasValue(C0092b.FontFamilyFont_fontWeight) ? C0092b.FontFamilyFont_fontWeight : C0092b.FontFamilyFont_android_fontWeight, 400);
        boolean z = true;
        if (1 != resources.getInt(resources.hasValue(C0092b.FontFamilyFont_fontStyle) ? C0092b.FontFamilyFont_fontStyle : C0092b.FontFamilyFont_android_fontStyle, 0)) {
            z = false;
        }
        int i2 = resources.hasValue(C0092b.FontFamilyFont_font) ? C0092b.FontFamilyFont_font : C0092b.FontFamilyFont_android_font;
        int resourceId = resources.getResourceId(i2, 0);
        String string = resources.getString(i2);
        resources.recycle();
        while (xmlPullParser.next() != 3) {
            C0360a.m1082a(xmlPullParser);
        }
        return new C0359c(string, i, z, resourceId);
    }

    /* renamed from: a */
    private static void m1082a(XmlPullParser xmlPullParser) {
        int i = 1;
        while (i > 0) {
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
    }
}
