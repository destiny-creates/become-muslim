package com.google.android.exoplayer2.p149h.p151b.p152a;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.C2571p;
import com.google.android.exoplayer2.p136c.C2255a;
import com.google.android.exoplayer2.p136c.C2255a.C2254a;
import com.google.android.exoplayer2.p149h.p151b.p152a.C2384h.C2383d;
import com.google.android.exoplayer2.p149h.p151b.p152a.C2384h.C4178e;
import com.google.android.exoplayer2.p149h.p151b.p152a.C2384h.C4713b;
import com.google.android.exoplayer2.p149h.p151b.p152a.C2384h.C4714c;
import com.google.android.exoplayer2.p163k.C4253u.C2513a;
import com.google.android.exoplayer2.p164l.C2516a;
import com.google.android.exoplayer2.p164l.C2524i;
import com.google.android.exoplayer2.p164l.C2539u;
import com.google.android.exoplayer2.p164l.C2541v;
import com.google.android.exoplayer2.p164l.C2542w;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: DashManifestParser */
/* renamed from: com.google.android.exoplayer2.h.b.a.c */
public class C4174c extends DefaultHandler implements C2513a<C2376b> {
    /* renamed from: a */
    private static final Pattern f10847a = Pattern.compile("(\\d+)(?:/(\\d+))?");
    /* renamed from: b */
    private static final Pattern f10848b = Pattern.compile("CC([1-4])=.*");
    /* renamed from: c */
    private static final Pattern f10849c = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");
    /* renamed from: d */
    private final String f10850d;
    /* renamed from: e */
    private final XmlPullParserFactory f10851e;

    /* compiled from: DashManifestParser */
    /* renamed from: com.google.android.exoplayer2.h.b.a.c$a */
    protected static final class C2377a {
        /* renamed from: a */
        public final C2515k f5846a;
        /* renamed from: b */
        public final String f5847b;
        /* renamed from: c */
        public final C2384h f5848c;
        /* renamed from: d */
        public final String f5849d;
        /* renamed from: e */
        public final ArrayList<C2254a> f5850e;
        /* renamed from: f */
        public final ArrayList<C2378d> f5851f;
        /* renamed from: g */
        public final long f5852g;

        public C2377a(C2515k c2515k, String str, C2384h c2384h, String str2, ArrayList<C2254a> arrayList, ArrayList<C2378d> arrayList2, long j) {
            this.f5846a = c2515k;
            this.f5847b = str;
            this.f5848c = c2384h;
            this.f5849d = str2;
            this.f5850e = arrayList;
            this.f5851f = arrayList2;
            this.f5852g = j;
        }
    }

    /* renamed from: e */
    protected void m13345e(XmlPullParser xmlPullParser) {
    }

    /* renamed from: b */
    public /* synthetic */ Object mo2245b(Uri uri, InputStream inputStream) {
        return m13323a(uri, inputStream);
    }

    public C4174c() {
        this(null);
    }

    public C4174c(String str) {
        this.f10850d = str;
        try {
            this.f10851e = XmlPullParserFactory.newInstance();
        } catch (String str2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", str2);
        }
    }

    /* renamed from: a */
    public C2376b m13323a(Uri uri, InputStream inputStream) {
        try {
            XmlPullParser newPullParser = this.f10851e.newPullParser();
            newPullParser.setInput(inputStream, null);
            if (newPullParser.next() == 2 && "MPD".equals(newPullParser.getName()) != null) {
                return m13324a(newPullParser, uri.toString());
            }
            throw new C2571p("inputStream does not contain a valid media presentation description");
        } catch (Throwable e) {
            throw new C2571p(e);
        }
    }

    /* renamed from: a */
    protected C2376b m13324a(XmlPullParser xmlPullParser, String str) {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        long c = C4174c.m13312c(xmlPullParser2, "availabilityStartTime", -9223372036854775807L);
        long b = C4174c.m13308b(xmlPullParser2, "mediaPresentationDuration", -9223372036854775807L);
        long b2 = C4174c.m13308b(xmlPullParser2, "minBufferTime", -9223372036854775807L);
        String attributeValue = xmlPullParser2.getAttributeValue(null, "type");
        Object obj = null;
        boolean z = attributeValue != null && attributeValue.equals("dynamic");
        long b3 = z ? C4174c.m13308b(xmlPullParser2, "minimumUpdatePeriod", -9223372036854775807L) : -9223372036854775807L;
        long b4 = z ? C4174c.m13308b(xmlPullParser2, "timeShiftBufferDepth", -9223372036854775807L) : -9223372036854775807L;
        long b5 = z ? C4174c.m13308b(xmlPullParser2, "suggestedPresentationDelay", -9223372036854775807L) : -9223372036854775807L;
        long c2 = C4174c.m13312c(xmlPullParser2, "publishTime", -9223372036854775807L);
        List arrayList = new ArrayList();
        String str2 = str;
        long j = z ? -9223372036854775807L : 0;
        Object obj2 = null;
        Uri uri = null;
        C2386k c2386k = null;
        while (true) {
            long j2;
            xmlPullParser.next();
            long j3 = b4;
            if (!C2542w.m7199b(xmlPullParser2, "BaseURL")) {
                if (C2542w.m7199b(xmlPullParser2, "UTCTiming")) {
                    j2 = b3;
                    c2386k = m13339a(xmlPullParser);
                } else if (C2542w.m7199b(xmlPullParser2, "Location")) {
                    j2 = b3;
                    uri = Uri.parse(xmlPullParser.nextText());
                } else if (C2542w.m7199b(xmlPullParser2, "Period") && r21 == null) {
                    Object obj3 = obj;
                    Pair a = m13319a(xmlPullParser2, str2, j);
                    long j4 = j;
                    C2379e c2379e = (C2379e) a.first;
                    j2 = b3;
                    if (c2379e.f5857b != -9223372036854775807L) {
                        long longValue = ((Long) a.second).longValue();
                        if (longValue == -9223372036854775807L) {
                            longValue = -9223372036854775807L;
                        } else {
                            longValue += c2379e.f5857b;
                        }
                        arrayList.add(c2379e);
                        j = longValue;
                        obj = obj3;
                    } else if (z) {
                        obj = obj3;
                        j = j4;
                        obj2 = 1;
                    } else {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unable to determine start of period ");
                        stringBuilder.append(arrayList.size());
                        throw new C2571p(stringBuilder.toString());
                    }
                }
                if (!C2542w.m7197a(xmlPullParser2, "MPD")) {
                    break;
                }
                b4 = j3;
                b3 = j2;
            } else if (obj == null) {
                str2 = C4174c.m13315c(xmlPullParser2, str2);
                j2 = b3;
                obj = 1;
                if (!C2542w.m7197a(xmlPullParser2, "MPD")) {
                    break;
                }
                b4 = j3;
                b3 = j2;
            }
            j2 = b3;
            obj = obj;
            j = j;
            if (!C2542w.m7197a(xmlPullParser2, "MPD")) {
                break;
            }
            b4 = j3;
            b3 = j2;
        }
        if (b == -9223372036854775807L) {
            if (j != -9223372036854775807L) {
                b = j;
            } else if (!z) {
                throw new C2571p("Unable to determine duration of static manifest.");
            }
        }
        if (arrayList.isEmpty()) {
            throw new C2571p("No periods found.");
        }
        return m13322a(c, b, b2, z, j2, j3, b5, c2, c2386k, uri, arrayList);
    }

    /* renamed from: a */
    protected C2376b m13322a(long j, long j2, long j3, boolean z, long j4, long j5, long j6, long j7, C2386k c2386k, Uri uri, List<C2379e> list) {
        return new C2376b(j, j2, j3, z, j4, j5, j6, j7, c2386k, uri, list);
    }

    /* renamed from: a */
    protected C2386k m13339a(XmlPullParser xmlPullParser) {
        return m13338a(xmlPullParser.getAttributeValue(null, "schemeIdUri"), xmlPullParser.getAttributeValue(null, "value"));
    }

    /* renamed from: a */
    protected C2386k m13338a(String str, String str2) {
        return new C2386k(str, str2);
    }

    /* renamed from: a */
    protected Pair<C2379e, Long> m13319a(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "id");
        j = C4174c.m13308b(xmlPullParser, ViewProps.START, j);
        long b = C4174c.m13308b(xmlPullParser, "duration", -9223372036854775807L);
        List arrayList = new ArrayList();
        Object obj = null;
        C2384h c2384h = null;
        do {
            xmlPullParser.next();
            if (C2542w.m7199b(xmlPullParser, "BaseURL")) {
                if (obj == null) {
                    str = C4174c.m13315c(xmlPullParser, str);
                    obj = 1;
                }
            } else if (C2542w.m7199b(xmlPullParser, "AdaptationSet")) {
                arrayList.add(m13321a(xmlPullParser, str, c2384h));
            } else if (C2542w.m7199b(xmlPullParser, "SegmentBase")) {
                c2384h = m13336a(xmlPullParser, null);
            } else if (C2542w.m7199b(xmlPullParser, "SegmentList")) {
                c2384h = m13331a(xmlPullParser, null);
            } else if (C2542w.m7199b(xmlPullParser, "SegmentTemplate")) {
                c2384h = m13333a(xmlPullParser, null);
            }
        } while (!C2542w.m7197a(xmlPullParser, "Period"));
        return Pair.create(m13326a(attributeValue, j, arrayList), Long.valueOf(b));
    }

    /* renamed from: a */
    protected C2379e m13326a(String str, long j, List<C2375a> list) {
        return new C2379e(str, j, list);
    }

    /* renamed from: a */
    protected C2375a m13321a(XmlPullParser xmlPullParser, String str, C2384h c2384h) {
        List list;
        ArrayList arrayList;
        ArrayList arrayList2;
        int i;
        C4174c c4174c = this;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        int a = C4174c.m13304a(xmlPullParser2, "id", -1);
        int b = m13341b(xmlPullParser);
        String str2 = null;
        String attributeValue = xmlPullParser2.getAttributeValue(null, "mimeType");
        String attributeValue2 = xmlPullParser2.getAttributeValue(null, "codecs");
        int a2 = C4174c.m13304a(xmlPullParser2, "width", -1);
        int a3 = C4174c.m13304a(xmlPullParser2, "height", -1);
        float a4 = C4174c.m13301a(xmlPullParser2, -1.0f);
        int a5 = C4174c.m13304a(xmlPullParser2, "audioSamplingRate", -1);
        String attributeValue3 = xmlPullParser2.getAttributeValue(null, "lang");
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        String str3 = str;
        C2384h c2384h2 = c2384h;
        int i2 = b;
        String str4 = attributeValue3;
        String str5 = null;
        Object obj = null;
        int i3 = 0;
        int i4 = -1;
        while (true) {
            String c;
            String str6;
            ArrayList arrayList8;
            ArrayList arrayList9;
            String str7;
            XmlPullParser xmlPullParser3;
            List list2;
            xmlPullParser.next();
            int i5;
            if (C2542w.m7199b(xmlPullParser2, "BaseURL")) {
                if (obj == null) {
                    c = C4174c.m13315c(xmlPullParser2, str3);
                    str6 = str4;
                    list = arrayList7;
                    arrayList = arrayList6;
                    arrayList2 = arrayList5;
                    arrayList8 = arrayList4;
                    arrayList9 = arrayList3;
                    str7 = str2;
                    xmlPullParser3 = xmlPullParser2;
                    obj = 1;
                }
                i5 = i2;
                str6 = str4;
                c = str3;
                list = arrayList7;
                arrayList = arrayList6;
                arrayList2 = arrayList5;
                arrayList8 = arrayList4;
                arrayList9 = arrayList3;
                str7 = str2;
                xmlPullParser3 = xmlPullParser2;
                i = i5;
                if (!C2542w.m7197a(xmlPullParser3, "AdaptationSet")) {
                    break;
                }
                xmlPullParser2 = xmlPullParser3;
                arrayList4 = arrayList8;
                i2 = i;
                str3 = c;
                arrayList6 = arrayList;
                arrayList5 = arrayList2;
                arrayList3 = arrayList9;
                str2 = str7;
                list2 = list;
                str4 = str6;
            } else {
                if (!C2542w.m7199b(xmlPullParser2, "ContentProtection")) {
                    if (C2542w.m7199b(xmlPullParser2, "ContentComponent")) {
                        str6 = C4174c.m13313c(str4, xmlPullParser2.getAttributeValue(str2, "lang"));
                        c = str3;
                        list = arrayList7;
                        arrayList = arrayList6;
                        arrayList2 = arrayList5;
                        arrayList8 = arrayList4;
                        arrayList9 = arrayList3;
                        str7 = str2;
                        xmlPullParser3 = xmlPullParser2;
                        i = C4174c.m13302a(i2, m13341b(xmlPullParser));
                    } else if (C2542w.m7199b(xmlPullParser2, "Role")) {
                        i3 |= m13344d(xmlPullParser);
                    } else if (C2542w.m7199b(xmlPullParser2, "AudioChannelConfiguration")) {
                        i4 = m13349i(xmlPullParser);
                    } else {
                        if (C2542w.m7199b(xmlPullParser2, "Accessibility")) {
                            arrayList5.add(C4174c.m13309b(xmlPullParser2, "Accessibility"));
                        } else if (C2542w.m7199b(xmlPullParser2, "SupplementalProperty")) {
                            arrayList6.add(C4174c.m13309b(xmlPullParser2, "SupplementalProperty"));
                        } else if (C2542w.m7199b(xmlPullParser2, "Representation")) {
                            int i6 = i2;
                            str6 = str4;
                            c = str3;
                            ArrayList arrayList10 = arrayList7;
                            arrayList = arrayList6;
                            arrayList2 = arrayList5;
                            r34 = arrayList4;
                            arrayList9 = arrayList3;
                            str7 = str2;
                            C2377a a6 = m13325a(xmlPullParser, str3, attributeValue, attributeValue2, a2, a3, a4, i4, a5, str6, i3, (List) arrayList2, c2384h2);
                            int a7 = C4174c.m13302a(i6, m13318a(a6.f5846a));
                            list = arrayList10;
                            list.add(a6);
                            i = a7;
                            arrayList8 = r34;
                            xmlPullParser3 = xmlPullParser;
                        } else {
                            C2384h a8;
                            str6 = str4;
                            c = str3;
                            list = arrayList7;
                            arrayList = arrayList6;
                            arrayList2 = arrayList5;
                            r34 = arrayList4;
                            arrayList9 = arrayList3;
                            str7 = str2;
                            i5 = i2;
                            xmlPullParser3 = xmlPullParser;
                            if (C2542w.m7199b(xmlPullParser3, "SegmentBase")) {
                                a8 = m13336a(xmlPullParser3, (C4178e) c2384h2);
                            } else if (C2542w.m7199b(xmlPullParser3, "SegmentList")) {
                                a8 = m13331a(xmlPullParser3, (C4713b) c2384h2);
                            } else if (C2542w.m7199b(xmlPullParser3, "SegmentTemplate")) {
                                a8 = m13333a(xmlPullParser3, (C4714c) c2384h2);
                            } else {
                                if (C2542w.m7199b(xmlPullParser3, "InbandEventStream")) {
                                    arrayList8 = r34;
                                    arrayList8.add(C4174c.m13309b(xmlPullParser3, "InbandEventStream"));
                                } else {
                                    arrayList8 = r34;
                                    if (C2542w.m7198b(xmlPullParser)) {
                                        m13345e(xmlPullParser);
                                    }
                                }
                                i = i5;
                            }
                            c2384h2 = a8;
                            i = i5;
                            arrayList8 = r34;
                        }
                        i5 = i2;
                        str6 = str4;
                        c = str3;
                        list = arrayList7;
                        arrayList = arrayList6;
                        arrayList2 = arrayList5;
                        arrayList8 = arrayList4;
                        arrayList9 = arrayList3;
                        str7 = str2;
                        xmlPullParser3 = xmlPullParser2;
                        i = i5;
                    }
                    if (!C2542w.m7197a(xmlPullParser3, "AdaptationSet")) {
                        break;
                    }
                    xmlPullParser2 = xmlPullParser3;
                    arrayList4 = arrayList8;
                    i2 = i;
                    str3 = c;
                    arrayList6 = arrayList;
                    arrayList5 = arrayList2;
                    arrayList3 = arrayList9;
                    str2 = str7;
                    list2 = list;
                    str4 = str6;
                } else {
                    Pair c2 = m13343c(xmlPullParser);
                    if (c2.first != null) {
                        str5 = (String) c2.first;
                    }
                    if (c2.second != null) {
                        arrayList3.add(c2.second);
                    }
                }
                str6 = str4;
                c = str3;
                Object obj2 = arrayList7;
                arrayList = arrayList6;
                arrayList2 = arrayList5;
                arrayList8 = arrayList4;
                arrayList9 = arrayList3;
                str7 = str2;
                xmlPullParser3 = xmlPullParser2;
            }
            i = i2;
            if (!C2542w.m7197a(xmlPullParser3, "AdaptationSet")) {
                break;
            }
            xmlPullParser2 = xmlPullParser3;
            arrayList4 = arrayList8;
            i2 = i;
            str3 = c;
            arrayList6 = arrayList;
            arrayList5 = arrayList2;
            arrayList3 = arrayList9;
            str2 = str7;
            list2 = list;
            str4 = str6;
        }
        List arrayList11 = new ArrayList(list.size());
        for (int i7 = 0; i7 < list.size(); i7++) {
            arrayList11.add(m13329a((C2377a) list.get(i7), c4174c.f10850d, str5, arrayList9, arrayList8));
        }
        return m13320a(a, i, arrayList11, (List) arrayList2, (List) arrayList);
    }

    /* renamed from: a */
    protected C2375a m13320a(int i, int i2, List<C2382g> list, List<C2378d> list2, List<C2378d> list3) {
        return new C2375a(i, i2, list, list2, list3);
    }

    /* renamed from: b */
    protected int m13341b(XmlPullParser xmlPullParser) {
        xmlPullParser = xmlPullParser.getAttributeValue(null, "contentType");
        if (TextUtils.isEmpty(xmlPullParser)) {
            return -1;
        }
        if ("audio".equals(xmlPullParser)) {
            return 1;
        }
        if ("video".equals(xmlPullParser)) {
            return 2;
        }
        if ("text".equals(xmlPullParser) != null) {
            return 3;
        }
        return -1;
    }

    /* renamed from: a */
    protected int m13318a(C2515k c2515k) {
        String str = c2515k.f6380f;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (C2524i.m7051b(str)) {
            return 2;
        }
        if (C2524i.m7050a(str)) {
            return 1;
        }
        if (C4174c.m13306a(str) != null) {
            return 3;
        }
        return -1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    protected android.util.Pair<java.lang.String, com.google.android.exoplayer2.p136c.C2255a.C2254a> m13343c(org.xmlpull.v1.XmlPullParser r11) {
        /*
        r10 = this;
        r0 = "schemeIdUri";
        r1 = 0;
        r0 = r11.getAttributeValue(r1, r0);
        r2 = 1;
        r3 = 0;
        if (r0 == 0) goto L_0x007b;
    L_0x000b:
        r0 = com.google.android.exoplayer2.p164l.C2541v.m7190d(r0);
        r4 = -1;
        r5 = r0.hashCode();
        r6 = 489446379; // 0x1d2c5beb float:2.281153E-21 double:2.418186413E-315;
        if (r5 == r6) goto L_0x0038;
    L_0x0019:
        r6 = 755418770; // 0x2d06c692 float:7.66111E-12 double:3.732264625E-315;
        if (r5 == r6) goto L_0x002e;
    L_0x001e:
        r6 = 1812765994; // 0x6c0c9d2a float:6.799672E26 double:8.956254016E-315;
        if (r5 == r6) goto L_0x0024;
    L_0x0023:
        goto L_0x0042;
    L_0x0024:
        r5 = "urn:mpeg:dash:mp4protection:2011";
        r0 = r0.equals(r5);
        if (r0 == 0) goto L_0x0042;
    L_0x002c:
        r0 = 0;
        goto L_0x0043;
    L_0x002e:
        r5 = "urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed";
        r0 = r0.equals(r5);
        if (r0 == 0) goto L_0x0042;
    L_0x0036:
        r0 = 2;
        goto L_0x0043;
    L_0x0038:
        r5 = "urn:uuid:9a04f079-9840-4286-ab92-e65be0885f95";
        r0 = r0.equals(r5);
        if (r0 == 0) goto L_0x0042;
    L_0x0040:
        r0 = 1;
        goto L_0x0043;
    L_0x0042:
        r0 = -1;
    L_0x0043:
        switch(r0) {
            case 0: goto L_0x004e;
            case 1: goto L_0x004a;
            case 2: goto L_0x0047;
            default: goto L_0x0046;
        };
    L_0x0046:
        goto L_0x007b;
    L_0x0047:
        r0 = com.google.android.exoplayer2.C2251b.f5379e;
        goto L_0x004c;
    L_0x004a:
        r0 = com.google.android.exoplayer2.C2251b.f5380f;
    L_0x004c:
        r4 = r1;
        goto L_0x007d;
    L_0x004e:
        r0 = "value";
        r0 = r11.getAttributeValue(r1, r0);
        r4 = "cenc:default_KID";
        r4 = r11.getAttributeValue(r1, r4);
        if (r4 == 0) goto L_0x0077;
    L_0x005c:
        r5 = "00000000-0000-0000-0000-000000000000";
        r5 = r5.equals(r4);
        if (r5 != 0) goto L_0x0077;
    L_0x0064:
        r4 = java.util.UUID.fromString(r4);
        r5 = com.google.android.exoplayer2.C2251b.f5377c;
        r6 = new java.util.UUID[r2];
        r6[r3] = r4;
        r4 = com.google.android.exoplayer2.p137e.p140d.C2283h.m6317a(r5, r6, r1);
        r5 = com.google.android.exoplayer2.C2251b.f5377c;
        r6 = r0;
        r0 = r5;
        goto L_0x007e;
    L_0x0077:
        r6 = r0;
        r0 = r1;
        r4 = r0;
        goto L_0x007e;
    L_0x007b:
        r0 = r1;
        r4 = r0;
    L_0x007d:
        r6 = r4;
    L_0x007e:
        r5 = 0;
    L_0x007f:
        r11.next();
        r7 = "widevine:license";
        r7 = com.google.android.exoplayer2.p164l.C2542w.m7199b(r11, r7);
        if (r7 == 0) goto L_0x009e;
    L_0x008a:
        r5 = "robustness_level";
        r5 = r11.getAttributeValue(r1, r5);
        if (r5 == 0) goto L_0x009c;
    L_0x0092:
        r7 = "HW";
        r5 = r5.startsWith(r7);
        if (r5 == 0) goto L_0x009c;
    L_0x009a:
        r5 = 1;
        goto L_0x00eb;
    L_0x009c:
        r5 = 0;
        goto L_0x00eb;
    L_0x009e:
        if (r4 != 0) goto L_0x00eb;
    L_0x00a0:
        r7 = "cenc:pssh";
        r7 = com.google.android.exoplayer2.p164l.C2542w.m7199b(r11, r7);
        r8 = 4;
        if (r7 == 0) goto L_0x00cb;
    L_0x00a9:
        r7 = r11.next();
        if (r7 != r8) goto L_0x00cb;
    L_0x00af:
        r0 = r11.getText();
        r0 = android.util.Base64.decode(r0, r3);
        r4 = com.google.android.exoplayer2.p137e.p140d.C2283h.m6315a(r0);
        if (r4 != 0) goto L_0x00c7;
    L_0x00bd:
        r0 = "MpdParser";
        r7 = "Skipping malformed cenc:pssh data";
        android.util.Log.w(r0, r7);
        r0 = r4;
        r4 = r1;
        goto L_0x00eb;
    L_0x00c7:
        r9 = r4;
        r4 = r0;
        r0 = r9;
        goto L_0x00eb;
    L_0x00cb:
        r7 = com.google.android.exoplayer2.C2251b.f5380f;
        if (r0 != r7) goto L_0x00eb;
    L_0x00cf:
        r7 = "mspr:pro";
        r7 = com.google.android.exoplayer2.p164l.C2542w.m7199b(r11, r7);
        if (r7 == 0) goto L_0x00eb;
    L_0x00d7:
        r7 = r11.next();
        if (r7 != r8) goto L_0x00eb;
    L_0x00dd:
        r4 = com.google.android.exoplayer2.C2251b.f5380f;
        r7 = r11.getText();
        r7 = android.util.Base64.decode(r7, r3);
        r4 = com.google.android.exoplayer2.p137e.p140d.C2283h.m6316a(r4, r7);
    L_0x00eb:
        r7 = "ContentProtection";
        r7 = com.google.android.exoplayer2.p164l.C2542w.m7197a(r11, r7);
        if (r7 == 0) goto L_0x007f;
    L_0x00f3:
        if (r0 == 0) goto L_0x00fc;
    L_0x00f5:
        r1 = new com.google.android.exoplayer2.c.a$a;
        r11 = "video/mp4";
        r1.<init>(r0, r11, r4, r5);
    L_0x00fc:
        r11 = android.util.Pair.create(r6, r1);
        return r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.h.b.a.c.c(org.xmlpull.v1.XmlPullParser):android.util.Pair<java.lang.String, com.google.android.exoplayer2.c.a$a>");
    }

    /* renamed from: d */
    protected int m13344d(XmlPullParser xmlPullParser) {
        String b = C4174c.m13311b(xmlPullParser, "schemeIdUri", null);
        String b2 = C4174c.m13311b(xmlPullParser, "value", null);
        do {
            xmlPullParser.next();
        } while (!C2542w.m7197a(xmlPullParser, "Role"));
        return ("urn:mpeg:dash:role:2011".equals(b) == null || "main".equals(b2) == null) ? null : 1;
    }

    /* renamed from: a */
    protected C2377a m13325a(XmlPullParser xmlPullParser, String str, String str2, String str3, int i, int i2, float f, int i3, int i4, String str4, int i5, List<C2378d> list, C2384h c2384h) {
        String str5;
        String str6;
        String str7;
        C4178e c4178e;
        C4174c c4174c = this;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        String attributeValue = xmlPullParser2.getAttributeValue(null, "id");
        int a = C4174c.m13304a(xmlPullParser2, "bandwidth", -1);
        String b = C4174c.m13311b(xmlPullParser2, "mimeType", str2);
        String b2 = C4174c.m13311b(xmlPullParser2, "codecs", str3);
        int a2 = C4174c.m13304a(xmlPullParser2, "width", i);
        int a3 = C4174c.m13304a(xmlPullParser2, "height", i2);
        float a4 = C4174c.m13301a(xmlPullParser2, f);
        int a5 = C4174c.m13304a(xmlPullParser2, "audioSamplingRate", i4);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Object obj = null;
        int i6 = i3;
        C4178e c4178e2 = c2384h;
        String str8 = null;
        String str9 = str;
        while (true) {
            xmlPullParser.next();
            str5 = b2;
            if (!C2542w.m7199b(xmlPullParser2, "BaseURL")) {
                if (C2542w.m7199b(xmlPullParser2, "AudioChannelConfiguration")) {
                    str6 = str9;
                    i6 = m13349i(xmlPullParser);
                } else if (C2542w.m7199b(xmlPullParser2, "SegmentBase")) {
                    c4178e2 = m13336a(xmlPullParser2, c4178e2);
                } else if (C2542w.m7199b(xmlPullParser2, "SegmentList")) {
                    c4178e2 = m13331a(xmlPullParser2, (C4713b) c4178e2);
                } else if (C2542w.m7199b(xmlPullParser2, "SegmentTemplate")) {
                    c4178e2 = m13333a(xmlPullParser2, (C4714c) c4178e2);
                } else if (C2542w.m7199b(xmlPullParser2, "ContentProtection")) {
                    Pair c = m13343c(xmlPullParser);
                    str6 = str9;
                    if (c.first != null) {
                        str8 = (String) c.first;
                    }
                    if (c.second != null) {
                        arrayList.add(c.second);
                    }
                } else {
                    str6 = str9;
                    if (C2542w.m7199b(xmlPullParser2, "InbandEventStream")) {
                        arrayList2.add(C4174c.m13309b(xmlPullParser2, "InbandEventStream"));
                    } else if (C2542w.m7199b(xmlPullParser2, "SupplementalProperty")) {
                        arrayList3.add(C4174c.m13309b(xmlPullParser2, "SupplementalProperty"));
                    }
                }
                str7 = str8;
                c4178e = c4178e2;
                if (C2542w.m7197a(xmlPullParser2, "Representation")) {
                    break;
                }
                c4178e2 = c4178e;
                b2 = str5;
                str9 = str6;
                str8 = str7;
            } else if (obj == null) {
                str9 = C4174c.m13315c(xmlPullParser2, str9);
                obj = 1;
            }
            str6 = str9;
            str7 = str8;
            c4178e = c4178e2;
            if (C2542w.m7197a(xmlPullParser2, "Representation")) {
                break;
            }
            c4178e2 = c4178e;
            b2 = str5;
            str9 = str6;
            str8 = str7;
        }
        ArrayList arrayList4 = arrayList2;
        C2515k a6 = m13340a(attributeValue, b, a2, a3, a4, i6, a5, a, str4, i5, (List) list, str5, (List) arrayList3);
        if (c4178e == null) {
            c4178e = new C4178e();
        }
        return new C2377a(a6, str6, c4178e, str7, arrayList, arrayList4, -1);
    }

    /* renamed from: a */
    protected C2515k m13340a(String str, String str2, int i, int i2, float f, int i3, int i4, int i5, String str3, int i6, List<C2378d> list, String str4, List<C2378d> list2) {
        String str5;
        String str6 = str2;
        String b = C4174c.m13310b(str2, str4);
        if (b != null) {
            if ("audio/eac3".equals(b)) {
                b = C4174c.m13314c((List) list2);
            }
            str5 = b;
            if (C2524i.m7051b(str5)) {
                return C2515k.m6994a(str, str2, str5, str4, i5, i, i2, f, null, i6);
            }
            if (C2524i.m7050a(str5)) {
                return C2515k.m6995a(str, str2, str5, str4, i5, i3, i4, null, i6, str3);
            }
            if (C4174c.m13306a(str5)) {
                int a;
                int i7;
                if ("application/cea-608".equals(str5)) {
                    a = C4174c.m13303a((List) list);
                } else if ("application/cea-708".equals(str5)) {
                    a = C4174c.m13307b((List) list);
                } else {
                    i7 = -1;
                    return C2515k.m6997a(str, str2, str5, str4, i5, i6, str3, i7);
                }
                i7 = a;
                return C2515k.m6997a(str, str2, str5, str4, i5, i6, str3, i7);
            }
        }
        str5 = b;
        return C2515k.m7004b(str, str2, str5, str4, i5, i6, str3);
    }

    /* renamed from: a */
    protected C2382g m13329a(C2377a c2377a, String str, String str2, ArrayList<C2254a> arrayList, ArrayList<C2378d> arrayList2) {
        C2515k c2515k = c2377a.f5846a;
        if (c2377a.f5849d != null) {
            str2 = c2377a.f5849d;
        }
        List list = c2377a.f5850e;
        list.addAll(arrayList);
        if (list.isEmpty() == null) {
            C4174c.m13305a((ArrayList) list);
            c2515k = c2515k.m7009a(new C2255a(str2, list));
        }
        C2515k c2515k2 = c2515k;
        List list2 = c2377a.f5851f;
        list2.addAll(arrayList2);
        return C2382g.m6576a(str, c2377a.f5852g, c2515k2, c2377a.f5847b, c2377a.f5848c, list2);
    }

    /* renamed from: a */
    protected C4178e m13336a(XmlPullParser xmlPullParser, C4178e c4178e) {
        long parseLong;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        C4178e c4178e2 = c4178e;
        long d = C4174c.m13316d(xmlPullParser2, "timescale", c4178e2 != null ? c4178e2.b : 1);
        long j = 0;
        long d2 = C4174c.m13316d(xmlPullParser2, "presentationTimeOffset", c4178e2 != null ? c4178e2.c : 0);
        long j2 = c4178e2 != null ? c4178e2.f10861d : 0;
        if (c4178e2 != null) {
            j = c4178e2.f10862e;
        }
        String str = null;
        String attributeValue = xmlPullParser2.getAttributeValue(null, "indexRange");
        if (attributeValue != null) {
            String[] split = attributeValue.split("-");
            j = Long.parseLong(split[0]);
            parseLong = (Long.parseLong(split[1]) - j) + 1;
        } else {
            parseLong = j;
            j = j2;
        }
        if (c4178e2 != null) {
            str = c4178e2.a;
        }
        do {
            xmlPullParser.next();
            if (C2542w.m7199b(xmlPullParser2, "Initialization")) {
                str = m13347g(xmlPullParser);
            }
        } while (!C2542w.m7197a(xmlPullParser2, "SegmentBase"));
        return m13335a((C2380f) str, d, d2, j, parseLong);
    }

    /* renamed from: a */
    protected C4178e m13335a(C2380f c2380f, long j, long j2, long j3, long j4) {
        return new C4178e(c2380f, j, j2, j3, j4);
    }

    /* renamed from: a */
    protected C4713b m13331a(XmlPullParser xmlPullParser, C4713b c4713b) {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        C4713b c4713b2 = c4713b;
        long d = C4174c.m13316d(xmlPullParser2, "timescale", c4713b2 != null ? c4713b2.b : 1);
        long d2 = C4174c.m13316d(xmlPullParser2, "presentationTimeOffset", c4713b2 != null ? c4713b2.c : 0);
        long d3 = C4174c.m13316d(xmlPullParser2, "duration", c4713b2 != null ? c4713b2.e : -9223372036854775807L);
        int a = C4174c.m13304a(xmlPullParser2, "startNumber", c4713b2 != null ? c4713b2.d : 1);
        List list = null;
        C2380f c2380f = null;
        List list2 = c2380f;
        do {
            xmlPullParser.next();
            if (C2542w.m7199b(xmlPullParser2, "Initialization")) {
                c2380f = m13347g(xmlPullParser);
            } else if (C2542w.m7199b(xmlPullParser2, "SegmentTimeline")) {
                list2 = m13346f(xmlPullParser);
            } else if (C2542w.m7199b(xmlPullParser2, "SegmentURL")) {
                if (list == null) {
                    list = new ArrayList();
                }
                list.add(m13348h(xmlPullParser));
            }
        } while (!C2542w.m7197a(xmlPullParser2, "SegmentList"));
        if (c4713b2 != null) {
            if (c2380f == null) {
                c2380f = c4713b2.a;
            }
            if (list2 == null) {
                list2 = c4713b2.f;
            }
            if (list == null) {
                list = c4713b2.f12736g;
            }
        }
        return m13330a(c2380f, d, d2, a, d3, list2, list);
    }

    /* renamed from: a */
    protected C4713b m13330a(C2380f c2380f, long j, long j2, int i, long j3, List<C2383d> list, List<C2380f> list2) {
        return new C4713b(c2380f, j, j2, i, j3, list, list2);
    }

    /* renamed from: a */
    protected C4714c m13333a(XmlPullParser xmlPullParser, C4714c c4714c) {
        C4174c c4174c = this;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        C4714c c4714c2 = c4714c;
        long d = C4174c.m13316d(xmlPullParser2, "timescale", c4714c2 != null ? c4714c2.b : 1);
        long d2 = C4174c.m13316d(xmlPullParser2, "presentationTimeOffset", c4714c2 != null ? c4714c2.c : 0);
        long d3 = C4174c.m13316d(xmlPullParser2, "duration", c4714c2 != null ? c4714c2.e : -9223372036854775807L);
        int a = C4174c.m13304a(xmlPullParser2, "startNumber", c4714c2 != null ? c4714c2.d : 1);
        C2380f c2380f = null;
        C2385j a2 = m13337a(xmlPullParser2, "media", c4714c2 != null ? c4714c2.f12738h : null);
        C2385j a3 = m13337a(xmlPullParser2, "initialization", c4714c2 != null ? c4714c2.f12737g : null);
        List list = null;
        do {
            xmlPullParser.next();
            if (C2542w.m7199b(xmlPullParser2, "Initialization")) {
                c2380f = m13347g(xmlPullParser);
            } else if (C2542w.m7199b(xmlPullParser2, "SegmentTimeline")) {
                list = m13346f(xmlPullParser);
            }
        } while (!C2542w.m7197a(xmlPullParser2, "SegmentTemplate"));
        if (c4714c2 != null) {
            if (c2380f == null) {
                c2380f = c4714c2.a;
            }
            if (list == null) {
                list = c4714c2.f;
            }
        }
        return m13332a(c2380f, d, d2, a, d3, list, a3, a2);
    }

    /* renamed from: a */
    protected C4714c m13332a(C2380f c2380f, long j, long j2, int i, long j3, List<C2383d> list, C2385j c2385j, C2385j c2385j2) {
        return new C4714c(c2380f, j, j2, i, j3, list, c2385j, c2385j2);
    }

    /* renamed from: f */
    protected List<C2383d> m13346f(XmlPullParser xmlPullParser) {
        List<C2383d> arrayList = new ArrayList();
        long j = 0;
        do {
            xmlPullParser.next();
            if (C2542w.m7199b(xmlPullParser, "S")) {
                j = C4174c.m13316d(xmlPullParser, "t", j);
                long d = C4174c.m13316d(xmlPullParser, "d", -9223372036854775807L);
                int i = 0;
                int a = C4174c.m13304a(xmlPullParser, "r", 0) + 1;
                while (i < a) {
                    arrayList.add(m13334a(j, d));
                    j += d;
                    i++;
                }
            }
        } while (!C2542w.m7197a(xmlPullParser, "SegmentTimeline"));
        return arrayList;
    }

    /* renamed from: a */
    protected C2383d m13334a(long j, long j2) {
        return new C2383d(j, j2);
    }

    /* renamed from: a */
    protected C2385j m13337a(XmlPullParser xmlPullParser, String str, C2385j c2385j) {
        xmlPullParser = xmlPullParser.getAttributeValue(null, str);
        return xmlPullParser != null ? C2385j.m6585a(xmlPullParser) : c2385j;
    }

    /* renamed from: g */
    protected C2380f m13347g(XmlPullParser xmlPullParser) {
        return m13328a(xmlPullParser, "sourceURL", "range");
    }

    /* renamed from: h */
    protected C2380f m13348h(XmlPullParser xmlPullParser) {
        return m13328a(xmlPullParser, "media", "mediaRange");
    }

    /* renamed from: a */
    protected C2380f m13328a(XmlPullParser xmlPullParser, String str, String str2) {
        long parseLong;
        long parseLong2;
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        xmlPullParser = xmlPullParser.getAttributeValue(null, str2);
        if (xmlPullParser != null) {
            xmlPullParser = xmlPullParser.split("-");
            parseLong = Long.parseLong(xmlPullParser[0]);
            if (xmlPullParser.length == 2) {
                parseLong2 = (Long.parseLong(xmlPullParser[1]) - parseLong) + 1;
                return m13327a(attributeValue, parseLong, parseLong2);
            }
        }
        parseLong = 0;
        parseLong2 = -1;
        return m13327a(attributeValue, parseLong, parseLong2);
    }

    /* renamed from: a */
    protected C2380f m13327a(String str, long j, long j2) {
        return new C2380f(str, j, j2);
    }

    /* renamed from: i */
    protected int m13349i(XmlPullParser xmlPullParser) {
        String b = C4174c.m13311b(xmlPullParser, "schemeIdUri", null);
        int i = -1;
        if ("urn:mpeg:dash:23003:3:audio_channel_configuration:2011".equals(b)) {
            i = C4174c.m13304a(xmlPullParser, "value", -1);
        } else if ("tag:dolby.com,2014:dash:audio_channel_configuration:2011".equals(b)) {
            i = C4174c.m13317j(xmlPullParser);
        }
        do {
            xmlPullParser.next();
        } while (!C2542w.m7197a(xmlPullParser, "AudioChannelConfiguration"));
        return i;
    }

    /* renamed from: a */
    private static void m13305a(ArrayList<C2254a> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            C2254a c2254a = (C2254a) arrayList.get(size);
            if (!c2254a.m6228a()) {
                for (int i = 0; i < arrayList.size(); i++) {
                    if (((C2254a) arrayList.get(i)).m6229a(c2254a)) {
                        arrayList.remove(size);
                        break;
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private static String m13310b(String str, String str2) {
        if (C2524i.m7050a(str)) {
            return C2524i.m7054e(str2);
        }
        if (C2524i.m7051b(str)) {
            return C2524i.m7053d(str2);
        }
        if (C4174c.m13306a(str)) {
            return str;
        }
        if (!"application/mp4".equals(str)) {
            if (!("application/x-rawcc".equals(str) == null || str2 == null)) {
                if (str2.contains("cea708") != null) {
                    return "application/cea-708";
                }
                if (!(str2.contains("eia608") == null && str2.contains("cea608") == null)) {
                    return "application/cea-608";
                }
            }
            return null;
        } else if ("stpp".equals(str2) != null) {
            return "application/ttml+xml";
        } else {
            if ("wvtt".equals(str2) != null) {
                return "application/x-mp4-vtt";
            }
        }
        return null;
    }

    /* renamed from: a */
    private static boolean m13306a(String str) {
        if (!(C2524i.m7052c(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/cea-708".equals(str))) {
            if ("application/cea-608".equals(str) == null) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: c */
    private static String m13313c(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        C2516a.m7019b(str.equals(str2));
        return str;
    }

    /* renamed from: a */
    private static int m13302a(int i, int i2) {
        if (i == -1) {
            return i2;
        }
        if (i2 == -1) {
            return i;
        }
        C2516a.m7019b(i == i2 ? 1 : 0);
        return i;
    }

    /* renamed from: b */
    protected static C2378d m13309b(XmlPullParser xmlPullParser, String str) {
        String b = C4174c.m13311b(xmlPullParser, "schemeIdUri", "");
        String b2 = C4174c.m13311b(xmlPullParser, "value", null);
        String b3 = C4174c.m13311b(xmlPullParser, "id", null);
        do {
            xmlPullParser.next();
        } while (!C2542w.m7197a(xmlPullParser, str));
        return new C2378d(b, b2, b3);
    }

    /* renamed from: a */
    protected static int m13303a(List<C2378d> list) {
        for (int i = 0; i < list.size(); i++) {
            C2378d c2378d = (C2378d) list.get(i);
            if ("urn:scte:dash:cc:cea-608:2015".equals(c2378d.f5853a) && c2378d.f5854b != null) {
                Matcher matcher = f10848b.matcher(c2378d.f5854b);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unable to parse CEA-608 channel number from: ");
                stringBuilder.append(c2378d.f5854b);
                Log.w("MpdParser", stringBuilder.toString());
            }
        }
        return -1;
    }

    /* renamed from: b */
    protected static int m13307b(List<C2378d> list) {
        for (int i = 0; i < list.size(); i++) {
            C2378d c2378d = (C2378d) list.get(i);
            if ("urn:scte:dash:cc:cea-708:2015".equals(c2378d.f5853a) && c2378d.f5854b != null) {
                Matcher matcher = f10849c.matcher(c2378d.f5854b);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unable to parse CEA-708 service block number from: ");
                stringBuilder.append(c2378d.f5854b);
                Log.w("MpdParser", stringBuilder.toString());
            }
        }
        return -1;
    }

    /* renamed from: c */
    protected static String m13314c(List<C2378d> list) {
        for (int i = 0; i < list.size(); i++) {
            C2378d c2378d = (C2378d) list.get(i);
            if ("tag:dolby.com,2014:dash:DolbyDigitalPlusExtensionType:2014".equals(c2378d.f5853a) && "ec+3".equals(c2378d.f5854b)) {
                return "audio/eac3-joc";
            }
        }
        return "audio/eac3";
    }

    /* renamed from: a */
    protected static float m13301a(XmlPullParser xmlPullParser, float f) {
        xmlPullParser = xmlPullParser.getAttributeValue(null, "frameRate");
        if (xmlPullParser == null) {
            return f;
        }
        xmlPullParser = f10847a.matcher(xmlPullParser);
        if (!xmlPullParser.matches()) {
            return f;
        }
        f = Integer.parseInt(xmlPullParser.group(Float.MIN_VALUE));
        xmlPullParser = xmlPullParser.group(2);
        return !TextUtils.isEmpty(xmlPullParser) ? ((float) f) / ((float) Integer.parseInt(xmlPullParser)) : (float) f;
    }

    /* renamed from: b */
    protected static long m13308b(XmlPullParser xmlPullParser, String str, long j) {
        xmlPullParser = xmlPullParser.getAttributeValue(null, str);
        if (xmlPullParser == null) {
            return j;
        }
        return C2541v.m7191e(xmlPullParser);
    }

    /* renamed from: c */
    protected static long m13312c(XmlPullParser xmlPullParser, String str, long j) {
        xmlPullParser = xmlPullParser.getAttributeValue(null, str);
        if (xmlPullParser == null) {
            return j;
        }
        return C2541v.m7192f(xmlPullParser);
    }

    /* renamed from: c */
    protected static String m13315c(XmlPullParser xmlPullParser, String str) {
        xmlPullParser.next();
        return C2539u.m7161b(str, xmlPullParser.getText());
    }

    /* renamed from: a */
    protected static int m13304a(XmlPullParser xmlPullParser, String str, int i) {
        xmlPullParser = xmlPullParser.getAttributeValue(null, str);
        return xmlPullParser == null ? i : Integer.parseInt(xmlPullParser);
    }

    /* renamed from: d */
    protected static long m13316d(XmlPullParser xmlPullParser, String str, long j) {
        xmlPullParser = xmlPullParser.getAttributeValue(null, str);
        return xmlPullParser == null ? j : Long.parseLong(xmlPullParser);
    }

    /* renamed from: b */
    protected static String m13311b(XmlPullParser xmlPullParser, String str, String str2) {
        xmlPullParser = xmlPullParser.getAttributeValue(null, str);
        return xmlPullParser == null ? str2 : xmlPullParser;
    }

    /* renamed from: j */
    protected static int m13317j(XmlPullParser xmlPullParser) {
        xmlPullParser = C2541v.m7190d(xmlPullParser.getAttributeValue(null, "value"));
        if (xmlPullParser == null) {
            return -1;
        }
        int hashCode = xmlPullParser.hashCode();
        if (hashCode != 1596796) {
            if (hashCode != 2937391) {
                if (hashCode != 3094035) {
                    if (hashCode == 3133436) {
                        if (xmlPullParser.equals("fa01") != null) {
                            xmlPullParser = 3;
                            switch (xmlPullParser) {
                                case null:
                                    return 1;
                                case 1:
                                    return 2;
                                case 2:
                                    return 6;
                                case 3:
                                    return 8;
                                default:
                                    return -1;
                            }
                        }
                    }
                } else if (xmlPullParser.equals("f801") != null) {
                    xmlPullParser = 2;
                    switch (xmlPullParser) {
                        case null:
                            return 1;
                        case 1:
                            return 2;
                        case 2:
                            return 6;
                        case 3:
                            return 8;
                        default:
                            return -1;
                    }
                }
            } else if (xmlPullParser.equals("a000") != null) {
                xmlPullParser = true;
                switch (xmlPullParser) {
                    case null:
                        return 1;
                    case 1:
                        return 2;
                    case 2:
                        return 6;
                    case 3:
                        return 8;
                    default:
                        return -1;
                }
            }
        } else if (xmlPullParser.equals("4000") != null) {
            xmlPullParser = null;
            switch (xmlPullParser) {
                case null:
                    return 1;
                case 1:
                    return 2;
                case 2:
                    return 6;
                case 3:
                    return 8;
                default:
                    return -1;
            }
        }
        xmlPullParser = -1;
        switch (xmlPullParser) {
            case null:
                return 1;
            case 1:
                return 2;
            case 2:
                return 6;
            case 3:
                return 8;
            default:
                return -1;
        }
    }
}
