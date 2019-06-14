package com.google.android.exoplayer2.p149h.p155d.p156a;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.C2571p;
import com.google.android.exoplayer2.p136c.C2255a;
import com.google.android.exoplayer2.p136c.C2255a.C2254a;
import com.google.android.exoplayer2.p137e.p140d.C2283h;
import com.google.android.exoplayer2.p149h.p155d.p156a.C2412a.C2410a;
import com.google.android.exoplayer2.p149h.p155d.p156a.C2412a.C2411b;
import com.google.android.exoplayer2.p163k.C4253u.C2513a;
import com.google.android.exoplayer2.p164l.C2516a;
import com.google.android.exoplayer2.p164l.C2518c;
import com.google.android.exoplayer2.p164l.C2541v;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: SsManifestParser */
/* renamed from: com.google.android.exoplayer2.h.d.a.b */
public class C4209b implements C2513a<C2412a> {
    /* renamed from: a */
    private final XmlPullParserFactory f11056a;

    /* compiled from: SsManifestParser */
    /* renamed from: com.google.android.exoplayer2.h.d.a.b$a */
    private static abstract class C2413a {
        /* renamed from: a */
        private final String f5967a;
        /* renamed from: b */
        private final String f5968b;
        /* renamed from: c */
        private final C2413a f5969c;
        /* renamed from: d */
        private final List<Pair<String, Object>> f5970d = new LinkedList();

        /* renamed from: a */
        protected abstract Object mo2276a();

        /* renamed from: a */
        protected void mo2281a(Object obj) {
        }

        /* renamed from: b */
        protected void mo2277b(XmlPullParser xmlPullParser) {
        }

        /* renamed from: b */
        protected boolean mo2278b(String str) {
            return false;
        }

        /* renamed from: c */
        protected void mo2279c(XmlPullParser xmlPullParser) {
        }

        /* renamed from: d */
        protected void mo2280d(XmlPullParser xmlPullParser) {
        }

        public C2413a(C2413a c2413a, String str, String str2) {
            this.f5969c = c2413a;
            this.f5967a = str;
            this.f5968b = str2;
        }

        /* renamed from: a */
        public final Object m6640a(XmlPullParser xmlPullParser) {
            Object obj = null;
            int i = 0;
            while (true) {
                String name;
                switch (xmlPullParser.getEventType()) {
                    case 1:
                        return null;
                    case 2:
                        name = xmlPullParser.getName();
                        if (!this.f5968b.equals(name)) {
                            if (obj != null) {
                                if (i <= 0) {
                                    if (!mo2278b(name)) {
                                        C2413a a = m6635a(this, name, this.f5967a);
                                        if (a != null) {
                                            mo2281a(a.m6640a(xmlPullParser));
                                            break;
                                        }
                                        i = 1;
                                        break;
                                    }
                                    mo2277b(xmlPullParser);
                                    break;
                                }
                                i++;
                                break;
                            }
                            break;
                        }
                        mo2277b(xmlPullParser);
                        obj = 1;
                        break;
                    case 3:
                        if (obj != null) {
                            if (i <= 0) {
                                name = xmlPullParser.getName();
                                mo2280d(xmlPullParser);
                                if (mo2278b(name)) {
                                    break;
                                }
                                return mo2276a();
                            }
                            i--;
                            break;
                        }
                        continue;
                    case 4:
                        if (obj != null && i == 0) {
                            mo2279c(xmlPullParser);
                            break;
                        }
                    default:
                        break;
                }
                xmlPullParser.next();
            }
        }

        /* renamed from: a */
        private C2413a m6635a(C2413a c2413a, String str, String str2) {
            if ("QualityLevel".equals(str)) {
                return new C4206d(c2413a, str2);
            }
            if ("Protection".equals(str)) {
                return new C4205c(c2413a, str2);
            }
            return "StreamIndex".equals(str) != null ? new C4208f(c2413a, str2) : null;
        }

        /* renamed from: a */
        protected final void m6643a(String str, Object obj) {
            this.f5970d.add(Pair.create(str, obj));
        }

        /* renamed from: a */
        protected final Object m6639a(String str) {
            for (int i = 0; i < this.f5970d.size(); i++) {
                Pair pair = (Pair) this.f5970d.get(i);
                if (((String) pair.first).equals(str)) {
                    return pair.second;
                }
            }
            return this.f5969c == null ? null : this.f5969c.m6639a(str);
        }

        /* renamed from: a */
        protected final String m6641a(XmlPullParser xmlPullParser, String str) {
            xmlPullParser = xmlPullParser.getAttributeValue(null, str);
            if (xmlPullParser != null) {
                return xmlPullParser;
            }
            throw new C4204b(str);
        }

        /* renamed from: a */
        protected final int m6636a(XmlPullParser xmlPullParser, String str, int i) {
            xmlPullParser = xmlPullParser.getAttributeValue(null, str);
            if (xmlPullParser == null) {
                return i;
            }
            try {
                return Integer.parseInt(xmlPullParser);
            } catch (Throwable e) {
                throw new C2571p(e);
            }
        }

        /* renamed from: b */
        protected final int m6645b(XmlPullParser xmlPullParser, String str) {
            xmlPullParser = xmlPullParser.getAttributeValue(null, str);
            if (xmlPullParser != null) {
                try {
                    return Integer.parseInt(xmlPullParser);
                } catch (Throwable e) {
                    throw new C2571p(e);
                }
            }
            throw new C4204b(str);
        }

        /* renamed from: a */
        protected final long m6637a(XmlPullParser xmlPullParser, String str, long j) {
            xmlPullParser = xmlPullParser.getAttributeValue(null, str);
            if (xmlPullParser == null) {
                return j;
            }
            try {
                return Long.parseLong(xmlPullParser);
            } catch (Throwable e) {
                throw new C2571p(e);
            }
        }

        /* renamed from: c */
        protected final long m6648c(XmlPullParser xmlPullParser, String str) {
            xmlPullParser = xmlPullParser.getAttributeValue(null, str);
            if (xmlPullParser != null) {
                try {
                    return Long.parseLong(xmlPullParser);
                } catch (Throwable e) {
                    throw new C2571p(e);
                }
            }
            throw new C4204b(str);
        }

        /* renamed from: a */
        protected final boolean m6644a(XmlPullParser xmlPullParser, String str, boolean z) {
            xmlPullParser = xmlPullParser.getAttributeValue(null, str);
            return xmlPullParser != null ? Boolean.parseBoolean(xmlPullParser) : z;
        }
    }

    /* compiled from: SsManifestParser */
    /* renamed from: com.google.android.exoplayer2.h.d.a.b$b */
    public static class C4204b extends C2571p {
        public C4204b(String str) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Missing required field: ");
            stringBuilder.append(str);
            super(stringBuilder.toString());
        }
    }

    /* compiled from: SsManifestParser */
    /* renamed from: com.google.android.exoplayer2.h.d.a.b$c */
    private static class C4205c extends C2413a {
        /* renamed from: a */
        private boolean f11029a;
        /* renamed from: b */
        private UUID f11030b;
        /* renamed from: c */
        private byte[] f11031c;

        public C4205c(C2413a c2413a, String str) {
            super(c2413a, str, "Protection");
        }

        /* renamed from: b */
        public boolean mo2278b(String str) {
            return "ProtectionHeader".equals(str);
        }

        /* renamed from: b */
        public void mo2277b(XmlPullParser xmlPullParser) {
            if ("ProtectionHeader".equals(xmlPullParser.getName())) {
                this.f11029a = true;
                this.f11030b = UUID.fromString(C4205c.m13580c(xmlPullParser.getAttributeValue(null, "SystemID")));
            }
        }

        /* renamed from: c */
        public void mo2279c(XmlPullParser xmlPullParser) {
            if (this.f11029a) {
                this.f11031c = Base64.decode(xmlPullParser.getText(), 0);
            }
        }

        /* renamed from: d */
        public void mo2280d(XmlPullParser xmlPullParser) {
            if ("ProtectionHeader".equals(xmlPullParser.getName()) != null) {
                this.f11029a = null;
            }
        }

        /* renamed from: a */
        public Object mo2276a() {
            return new C2410a(this.f11030b, C2283h.m6316a(this.f11030b, this.f11031c));
        }

        /* renamed from: c */
        private static String m13580c(String str) {
            return (str.charAt(0) == '{' && str.charAt(str.length() - 1) == '}') ? str.substring(1, str.length() - 1) : str;
        }
    }

    /* compiled from: SsManifestParser */
    /* renamed from: com.google.android.exoplayer2.h.d.a.b$d */
    private static class C4206d extends C2413a {
        /* renamed from: a */
        private C2515k f11032a;

        public C4206d(C2413a c2413a, String str) {
            super(c2413a, str, "QualityLevel");
        }

        /* renamed from: b */
        public void mo2277b(XmlPullParser xmlPullParser) {
            int intValue = ((Integer) m6639a("Type")).intValue();
            String attributeValue = xmlPullParser.getAttributeValue(null, "Index");
            int b = m6645b(xmlPullParser, "Bitrate");
            String d = C4206d.m13587d(m6641a(xmlPullParser, "FourCC"));
            if (intValue == 2) {
                this.f11032a = C2515k.m6994a(attributeValue, "video/mp4", d, null, b, m6645b(xmlPullParser, "MaxWidth"), m6645b(xmlPullParser, "MaxHeight"), -1.0f, C4206d.m13586c(xmlPullParser.getAttributeValue(null, "CodecPrivateData")), 0);
            } else if (intValue == 1) {
                if (d == null) {
                    d = "audio/mp4a-latm";
                }
                int b2 = m6645b(xmlPullParser, "Channels");
                int b3 = m6645b(xmlPullParser, "SamplingRate");
                xmlPullParser = C4206d.m13586c(xmlPullParser.getAttributeValue(null, "CodecPrivateData"));
                if (xmlPullParser.isEmpty() && "audio/mp4a-latm".equals(d)) {
                    xmlPullParser = Collections.singletonList(C2518c.m7027a(b3, b2));
                }
                this.f11032a = C2515k.m6995a(attributeValue, "audio/mp4", d, null, b, b2, b3, (List) xmlPullParser, 0, (String) m6639a("Language"));
            } else if (intValue == 3) {
                this.f11032a = C2515k.m6996a(attributeValue, "application/mp4", d, null, b, 0, (String) m6639a("Language"));
            } else {
                this.f11032a = C2515k.m7004b(attributeValue, "application/mp4", d, null, b, 0, null);
            }
        }

        /* renamed from: a */
        public Object mo2276a() {
            return this.f11032a;
        }

        /* renamed from: c */
        private static List<byte[]> m13586c(String str) {
            Object arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                byte[] h = C2541v.m7194h(str);
                Object[] b = C2518c.m7032b(h);
                if (b == null) {
                    arrayList.add(h);
                } else {
                    Collections.addAll(arrayList, b);
                }
            }
            return arrayList;
        }

        /* renamed from: d */
        private static String m13587d(String str) {
            if (!(str.equalsIgnoreCase("H264") || str.equalsIgnoreCase("X264") || str.equalsIgnoreCase("AVC1"))) {
                if (!str.equalsIgnoreCase("DAVC")) {
                    if (!(str.equalsIgnoreCase("AAC") || str.equalsIgnoreCase("AACL") || str.equalsIgnoreCase("AACH"))) {
                        if (!str.equalsIgnoreCase("AACP")) {
                            if (str.equalsIgnoreCase("TTML")) {
                                return "application/ttml+xml";
                            }
                            if (!str.equalsIgnoreCase("ac-3")) {
                                if (!str.equalsIgnoreCase("dac3")) {
                                    if (!str.equalsIgnoreCase("ec-3")) {
                                        if (!str.equalsIgnoreCase("dec3")) {
                                            if (str.equalsIgnoreCase("dtsc")) {
                                                return "audio/vnd.dts";
                                            }
                                            if (!str.equalsIgnoreCase("dtsh")) {
                                                if (!str.equalsIgnoreCase("dtsl")) {
                                                    if (str.equalsIgnoreCase("dtse")) {
                                                        return "audio/vnd.dts.hd;profile=lbr";
                                                    }
                                                    return str.equalsIgnoreCase("opus") != null ? "audio/opus" : null;
                                                }
                                            }
                                            return "audio/vnd.dts.hd";
                                        }
                                    }
                                    return "audio/eac3";
                                }
                            }
                            return "audio/ac3";
                        }
                    }
                    return "audio/mp4a-latm";
                }
            }
            return "video/avc";
        }
    }

    /* compiled from: SsManifestParser */
    /* renamed from: com.google.android.exoplayer2.h.d.a.b$e */
    private static class C4207e extends C2413a {
        /* renamed from: a */
        private final List<C2411b> f11033a = new LinkedList();
        /* renamed from: b */
        private int f11034b;
        /* renamed from: c */
        private int f11035c;
        /* renamed from: d */
        private long f11036d;
        /* renamed from: e */
        private long f11037e;
        /* renamed from: f */
        private long f11038f;
        /* renamed from: g */
        private int f11039g = -1;
        /* renamed from: h */
        private boolean f11040h;
        /* renamed from: i */
        private C2410a f11041i = null;

        public C4207e(C2413a c2413a, String str) {
            super(c2413a, str, "SmoothStreamingMedia");
        }

        /* renamed from: b */
        public void mo2277b(XmlPullParser xmlPullParser) {
            this.f11034b = m6645b(xmlPullParser, "MajorVersion");
            this.f11035c = m6645b(xmlPullParser, "MinorVersion");
            this.f11036d = m6637a(xmlPullParser, "TimeScale", 10000000);
            this.f11037e = m6648c(xmlPullParser, "Duration");
            this.f11038f = m6637a(xmlPullParser, "DVRWindowLength", 0);
            this.f11039g = m6636a(xmlPullParser, "LookaheadCount", -1);
            this.f11040h = m6644a(xmlPullParser, "IsLive", false);
            m6643a("TimeScale", (Object) Long.valueOf(this.f11036d));
        }

        /* renamed from: a */
        public void mo2281a(Object obj) {
            if (obj instanceof C2411b) {
                this.f11033a.add((C2411b) obj);
            } else if (obj instanceof C2410a) {
                C2516a.m7019b(this.f11041i == null);
                this.f11041i = (C2410a) obj;
            }
        }

        /* renamed from: a */
        public Object mo2276a() {
            C2411b[] c2411bArr = new C2411b[this.f11033a.size()];
            this.f11033a.toArray(c2411bArr);
            if (this.f11041i != null) {
                C2255a c2255a = new C2255a(new C2254a(this.f11041i.f5941a, "video/mp4", this.f11041i.f5942b));
                for (C2411b c2411b : c2411bArr) {
                    for (int i = 0; i < c2411b.f5952j.length; i++) {
                        c2411b.f5952j[i] = c2411b.f5952j[i].m7009a(c2255a);
                    }
                }
            }
            return new C2412a(this.f11034b, this.f11035c, this.f11036d, this.f11037e, this.f11038f, this.f11039g, this.f11040h, this.f11041i, c2411bArr);
        }
    }

    /* compiled from: SsManifestParser */
    /* renamed from: com.google.android.exoplayer2.h.d.a.b$f */
    private static class C4208f extends C2413a {
        /* renamed from: a */
        private final String f11042a;
        /* renamed from: b */
        private final List<C2515k> f11043b = new LinkedList();
        /* renamed from: c */
        private int f11044c;
        /* renamed from: d */
        private String f11045d;
        /* renamed from: e */
        private long f11046e;
        /* renamed from: f */
        private String f11047f;
        /* renamed from: g */
        private String f11048g;
        /* renamed from: h */
        private int f11049h;
        /* renamed from: i */
        private int f11050i;
        /* renamed from: j */
        private int f11051j;
        /* renamed from: k */
        private int f11052k;
        /* renamed from: l */
        private String f11053l;
        /* renamed from: m */
        private ArrayList<Long> f11054m;
        /* renamed from: n */
        private long f11055n;

        public C4208f(C2413a c2413a, String str) {
            super(c2413a, str, "StreamIndex");
            this.f11042a = str;
        }

        /* renamed from: b */
        public boolean mo2278b(String str) {
            return "c".equals(str);
        }

        /* renamed from: b */
        public void mo2277b(XmlPullParser xmlPullParser) {
            if ("c".equals(xmlPullParser.getName())) {
                m13593e(xmlPullParser);
            } else {
                m13594f(xmlPullParser);
            }
        }

        /* renamed from: e */
        private void m13593e(XmlPullParser xmlPullParser) {
            int size = this.f11054m.size();
            long a = m6637a(xmlPullParser, "t", -9223372036854775807L);
            int i = 1;
            if (a == -9223372036854775807L) {
                if (size == 0) {
                    a = 0;
                } else if (this.f11055n != -1) {
                    a = ((Long) this.f11054m.get(size - 1)).longValue() + this.f11055n;
                } else {
                    throw new C2571p("Unable to infer start time");
                }
            }
            this.f11054m.add(Long.valueOf(a));
            this.f11055n = m6637a(xmlPullParser, "d", -9223372036854775807L);
            long a2 = m6637a(xmlPullParser, "r", 1);
            if (a2 > 1) {
                if (this.f11055n == -9223372036854775807L) {
                    throw new C2571p("Repeated chunk with unspecified duration");
                }
            }
            while (true) {
                long j = (long) i;
                if (j < a2) {
                    this.f11054m.add(Long.valueOf((this.f11055n * j) + a));
                    i++;
                } else {
                    return;
                }
            }
        }

        /* renamed from: f */
        private void m13594f(XmlPullParser xmlPullParser) {
            this.f11044c = m13595g(xmlPullParser);
            m6643a("Type", (Object) Integer.valueOf(this.f11044c));
            if (this.f11044c == 3) {
                this.f11045d = m6641a(xmlPullParser, "Subtype");
            } else {
                this.f11045d = xmlPullParser.getAttributeValue(null, "Subtype");
            }
            this.f11047f = xmlPullParser.getAttributeValue(null, "Name");
            this.f11048g = m6641a(xmlPullParser, "Url");
            this.f11049h = m6636a(xmlPullParser, "MaxWidth", -1);
            this.f11050i = m6636a(xmlPullParser, "MaxHeight", -1);
            this.f11051j = m6636a(xmlPullParser, "DisplayWidth", -1);
            this.f11052k = m6636a(xmlPullParser, "DisplayHeight", -1);
            this.f11053l = xmlPullParser.getAttributeValue(null, "Language");
            m6643a("Language", (Object) this.f11053l);
            this.f11046e = (long) m6636a(xmlPullParser, "TimeScale", -1);
            if (this.f11046e == -1) {
                this.f11046e = ((Long) m6639a("TimeScale")).longValue();
            }
            this.f11054m = new ArrayList();
        }

        /* renamed from: g */
        private int m13595g(XmlPullParser xmlPullParser) {
            xmlPullParser = xmlPullParser.getAttributeValue(null, "Type");
            if (xmlPullParser == null) {
                throw new C4204b("Type");
            } else if ("audio".equalsIgnoreCase(xmlPullParser)) {
                return 1;
            } else {
                if ("video".equalsIgnoreCase(xmlPullParser)) {
                    return 2;
                }
                if ("text".equalsIgnoreCase(xmlPullParser)) {
                    return 3;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid key value[");
                stringBuilder.append(xmlPullParser);
                stringBuilder.append("]");
                throw new C2571p(stringBuilder.toString());
            }
        }

        /* renamed from: a */
        public void mo2281a(Object obj) {
            if (obj instanceof C2515k) {
                this.f11043b.add((C2515k) obj);
            }
        }

        /* renamed from: a */
        public Object mo2276a() {
            C2515k[] c2515kArr = new C2515k[this.f11043b.size()];
            C2515k[] c2515kArr2 = c2515kArr;
            this.f11043b.toArray(c2515kArr);
            C2411b c2411b = r2;
            C2411b c2411b2 = new C2411b(this.f11042a, this.f11048g, this.f11044c, this.f11045d, this.f11046e, this.f11047f, this.f11049h, this.f11050i, this.f11051j, this.f11052k, this.f11053l, c2515kArr2, this.f11054m, this.f11055n);
            return c2411b;
        }
    }

    /* renamed from: b */
    public /* synthetic */ Object mo2245b(Uri uri, InputStream inputStream) {
        return m13600a(uri, inputStream);
    }

    public C4209b() {
        try {
            this.f11056a = XmlPullParserFactory.newInstance();
        } catch (Throwable e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    /* renamed from: a */
    public C2412a m13600a(Uri uri, InputStream inputStream) {
        try {
            XmlPullParser newPullParser = this.f11056a.newPullParser();
            newPullParser.setInput(inputStream, null);
            return (C2412a) new C4207e(null, uri.toString()).m6640a(newPullParser);
        } catch (Throwable e) {
            throw new C2571p(e);
        }
    }
}
