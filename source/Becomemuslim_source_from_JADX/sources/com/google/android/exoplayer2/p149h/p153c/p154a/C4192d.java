package com.google.android.exoplayer2.p149h.p153c.p154a;

import android.net.Uri;
import android.util.Base64;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.stetho.common.Utf8Charset;
import com.google.android.exoplayer2.C2251b;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.C2571p;
import com.google.android.exoplayer2.p136c.C2255a;
import com.google.android.exoplayer2.p136c.C2255a.C2254a;
import com.google.android.exoplayer2.p149h.C4222r;
import com.google.android.exoplayer2.p149h.p153c.p154a.C4190a.C2394a;
import com.google.android.exoplayer2.p149h.p153c.p154a.C4191b.C2395a;
import com.google.android.exoplayer2.p163k.C4253u.C2513a;
import com.google.android.exoplayer2.p164l.C2541v;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: HlsPlaylistParser */
/* renamed from: com.google.android.exoplayer2.h.c.a.d */
public final class C4192d implements C2513a<C2396c> {
    /* renamed from: a */
    private static final Pattern f10926a = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
    /* renamed from: b */
    private static final Pattern f10927b = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
    /* renamed from: c */
    private static final Pattern f10928c = Pattern.compile("CODECS=\"(.+?)\"");
    /* renamed from: d */
    private static final Pattern f10929d = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
    /* renamed from: e */
    private static final Pattern f10930e = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");
    /* renamed from: f */
    private static final Pattern f10931f = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
    /* renamed from: g */
    private static final Pattern f10932g = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
    /* renamed from: h */
    private static final Pattern f10933h = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
    /* renamed from: i */
    private static final Pattern f10934i = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    /* renamed from: j */
    private static final Pattern f10935j = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    /* renamed from: k */
    private static final Pattern f10936k = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    /* renamed from: l */
    private static final Pattern f10937l = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    /* renamed from: m */
    private static final Pattern f10938m = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    /* renamed from: n */
    private static final Pattern f10939n = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC)");
    /* renamed from: o */
    private static final Pattern f10940o = Pattern.compile("KEYFORMAT=\"(.+?)\"");
    /* renamed from: p */
    private static final Pattern f10941p = Pattern.compile("URI=\"(.+?)\"");
    /* renamed from: q */
    private static final Pattern f10942q = Pattern.compile("IV=([^,.*]+)");
    /* renamed from: r */
    private static final Pattern f10943r = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    /* renamed from: s */
    private static final Pattern f10944s = Pattern.compile("LANGUAGE=\"(.+?)\"");
    /* renamed from: t */
    private static final Pattern f10945t = Pattern.compile("NAME=\"(.+?)\"");
    /* renamed from: u */
    private static final Pattern f10946u = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    /* renamed from: v */
    private static final Pattern f10947v = C4192d.m13451b("AUTOSELECT");
    /* renamed from: w */
    private static final Pattern f10948w = C4192d.m13451b(MessengerShareContentUtility.PREVIEW_DEFAULT);
    /* renamed from: x */
    private static final Pattern f10949x = C4192d.m13451b("FORCED");

    /* compiled from: HlsPlaylistParser */
    /* renamed from: com.google.android.exoplayer2.h.c.a.d$a */
    private static class C2397a {
        /* renamed from: a */
        private final BufferedReader f5909a;
        /* renamed from: b */
        private final Queue<String> f5910b;
        /* renamed from: c */
        private String f5911c;

        public C2397a(Queue<String> queue, BufferedReader bufferedReader) {
            this.f5910b = queue;
            this.f5909a = bufferedReader;
        }

        /* renamed from: a */
        public boolean m6606a() {
            if (this.f5911c != null) {
                return true;
            }
            if (this.f5910b.isEmpty()) {
                do {
                    String readLine = this.f5909a.readLine();
                    this.f5911c = readLine;
                    if (readLine == null) {
                        return false;
                    }
                    this.f5911c = this.f5911c.trim();
                } while (this.f5911c.isEmpty());
                return true;
            }
            this.f5911c = (String) this.f5910b.poll();
            return true;
        }

        /* renamed from: b */
        public String m6607b() {
            if (!m6606a()) {
                return null;
            }
            String str = this.f5911c;
            this.f5911c = null;
            return str;
        }
    }

    /* renamed from: b */
    public /* synthetic */ Object mo2245b(Uri uri, InputStream inputStream) {
        return m13454a(uri, inputStream);
    }

    /* renamed from: a */
    public C2396c m13454a(Uri uri, InputStream inputStream) {
        Closeable bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        inputStream = new ArrayDeque();
        try {
            if (C4192d.m13447a((BufferedReader) bufferedReader)) {
                String readLine;
                while (true) {
                    readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        readLine = readLine.trim();
                        if (!readLine.isEmpty()) {
                            if (!readLine.startsWith("#EXT-X-STREAM-INF")) {
                                if (readLine.startsWith("#EXT-X-TARGETDURATION") || readLine.startsWith("#EXT-X-MEDIA-SEQUENCE") || readLine.startsWith("#EXTINF") || readLine.startsWith("#EXT-X-KEY") || readLine.startsWith("#EXT-X-BYTERANGE") || readLine.equals("#EXT-X-DISCONTINUITY") || readLine.equals("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                                    break;
                                } else if (readLine.equals("#EXT-X-ENDLIST")) {
                                    break;
                                } else {
                                    inputStream.add(readLine);
                                }
                            } else {
                                inputStream.add(readLine);
                                uri = C4192d.m13446a(new C2397a(inputStream, bufferedReader), uri.toString());
                                C2541v.m7175a(bufferedReader);
                                return uri;
                            }
                        }
                    } else {
                        C2541v.m7175a(bufferedReader);
                        throw new C2571p("Failed to parse the playlist, could not identify any tags.");
                    }
                }
                inputStream.add(readLine);
                uri = C4192d.m13450b(new C2397a(inputStream, bufferedReader), uri.toString());
                return uri;
            }
            throw new C4222r("Input does not start with the #EXTM3U header.", uri);
        } finally {
            C2541v.m7175a(bufferedReader);
        }
    }

    /* renamed from: a */
    private static boolean m13447a(BufferedReader bufferedReader) {
        int read = bufferedReader.read();
        if (read == 239) {
            if (bufferedReader.read() == 187) {
                if (bufferedReader.read() == 191) {
                    read = bufferedReader.read();
                }
            }
            return false;
        }
        read = C4192d.m13442a(bufferedReader, true, read);
        int length = "#EXTM3U".length();
        int i = read;
        for (read = 0; read < length; read++) {
            if (i != "#EXTM3U".charAt(read)) {
                return false;
            }
            i = bufferedReader.read();
        }
        return C2541v.m7177a(C4192d.m13442a(bufferedReader, false, i));
    }

    /* renamed from: a */
    private static int m13442a(BufferedReader bufferedReader, boolean z, int i) {
        while (i != -1 && Character.isWhitespace(i) && (z || !C2541v.m7177a(i))) {
            i = bufferedReader.read();
        }
        return i;
    }

    /* renamed from: a */
    private static C4190a m13446a(C2397a c2397a, String str) {
        HashSet hashSet = new HashSet();
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        List arrayList3 = new ArrayList();
        List arrayList4 = new ArrayList();
        C2515k c2515k = null;
        List list = c2515k;
        int i = 0;
        while (c2397a.m6606a()) {
            String b = c2397a.m6607b();
            if (b.startsWith("#EXT")) {
                arrayList4.add(b);
            }
            String c;
            String d;
            int hashCode;
            if (b.startsWith("#EXT-X-MEDIA")) {
                Object obj;
                C2515k a;
                int parseInt;
                int i2;
                String str2;
                int a2 = C4192d.m13443a(b);
                c = C4192d.m13452c(b, f10941p);
                String d2 = C4192d.m13453d(b, f10945t);
                String c2 = C4192d.m13452c(b, f10944s);
                d = C4192d.m13453d(b, f10943r);
                hashCode = d.hashCode();
                if (hashCode == -959297733) {
                    if (d.equals("SUBTITLES")) {
                        obj = 1;
                        switch (obj) {
                            case null:
                                a = C2515k.m6995a(d2, "application/x-mpegURL", null, null, -1, -1, -1, null, a2, c2);
                                if (c != null) {
                                    arrayList2.add(new C2394a(c, a));
                                    break;
                                }
                                c2515k = a;
                                break;
                            case 1:
                                arrayList3.add(new C2394a(c, C2515k.m6996a(d2, "application/x-mpegURL", "text/vtt", null, -1, a2, c2)));
                                break;
                            case 2:
                                b = C4192d.m13453d(b, f10946u);
                                if (b.startsWith("CC")) {
                                    c = "application/cea-708";
                                    parseInt = Integer.parseInt(b.substring(7));
                                } else {
                                    c = "application/cea-608";
                                    parseInt = Integer.parseInt(b.substring(2));
                                }
                                i2 = parseInt;
                                str2 = c;
                                if (list == null) {
                                    list = new ArrayList();
                                }
                                list.add(C2515k.m6997a(d2, null, str2, null, -1, a2, c2, i2));
                                break;
                            default:
                                break;
                        }
                    }
                } else if (hashCode == -333210994) {
                    if (d.equals("CLOSED-CAPTIONS")) {
                        obj = 2;
                        switch (obj) {
                            case null:
                                a = C2515k.m6995a(d2, "application/x-mpegURL", null, null, -1, -1, -1, null, a2, c2);
                                if (c != null) {
                                    c2515k = a;
                                    break;
                                }
                                arrayList2.add(new C2394a(c, a));
                                break;
                            case 1:
                                arrayList3.add(new C2394a(c, C2515k.m6996a(d2, "application/x-mpegURL", "text/vtt", null, -1, a2, c2)));
                                break;
                            case 2:
                                b = C4192d.m13453d(b, f10946u);
                                if (b.startsWith("CC")) {
                                    c = "application/cea-708";
                                    parseInt = Integer.parseInt(b.substring(7));
                                } else {
                                    c = "application/cea-608";
                                    parseInt = Integer.parseInt(b.substring(2));
                                }
                                i2 = parseInt;
                                str2 = c;
                                if (list == null) {
                                    list = new ArrayList();
                                }
                                list.add(C2515k.m6997a(d2, null, str2, null, -1, a2, c2, i2));
                                break;
                            default:
                                break;
                        }
                    }
                } else if (hashCode == 62628790) {
                    if (d.equals("AUDIO")) {
                        obj = null;
                        switch (obj) {
                            case null:
                                a = C2515k.m6995a(d2, "application/x-mpegURL", null, null, -1, -1, -1, null, a2, c2);
                                if (c != null) {
                                    arrayList2.add(new C2394a(c, a));
                                    break;
                                }
                                c2515k = a;
                                break;
                            case 1:
                                arrayList3.add(new C2394a(c, C2515k.m6996a(d2, "application/x-mpegURL", "text/vtt", null, -1, a2, c2)));
                                break;
                            case 2:
                                b = C4192d.m13453d(b, f10946u);
                                if (b.startsWith("CC")) {
                                    c = "application/cea-608";
                                    parseInt = Integer.parseInt(b.substring(2));
                                } else {
                                    c = "application/cea-708";
                                    parseInt = Integer.parseInt(b.substring(7));
                                }
                                i2 = parseInt;
                                str2 = c;
                                if (list == null) {
                                    list = new ArrayList();
                                }
                                list.add(C2515k.m6997a(d2, null, str2, null, -1, a2, c2, i2));
                                break;
                            default:
                                break;
                        }
                    }
                }
                obj = -1;
                switch (obj) {
                    case null:
                        a = C2515k.m6995a(d2, "application/x-mpegURL", null, null, -1, -1, -1, null, a2, c2);
                        if (c != null) {
                            c2515k = a;
                            break;
                        }
                        arrayList2.add(new C2394a(c, a));
                        break;
                    case 1:
                        arrayList3.add(new C2394a(c, C2515k.m6996a(d2, "application/x-mpegURL", "text/vtt", null, -1, a2, c2)));
                        break;
                    case 2:
                        b = C4192d.m13453d(b, f10946u);
                        if (b.startsWith("CC")) {
                            c = "application/cea-708";
                            parseInt = Integer.parseInt(b.substring(7));
                        } else {
                            c = "application/cea-608";
                            parseInt = Integer.parseInt(b.substring(2));
                        }
                        i2 = parseInt;
                        str2 = c;
                        if (list == null) {
                            list = new ArrayList();
                        }
                        list.add(C2515k.m6997a(d2, null, str2, null, -1, a2, c2, i2));
                        break;
                    default:
                        break;
                }
            } else if (b.startsWith("#EXT-X-STREAM-INF")) {
                int i3;
                int i4;
                i |= b.contains("CLOSED-CAPTIONS=NONE");
                int a3 = C4192d.m13444a(b, f10927b);
                String c3 = C4192d.m13452c(b, f10926a);
                if (c3 != null) {
                    a3 = Integer.parseInt(c3);
                }
                hashCode = a3;
                d = C4192d.m13452c(b, f10928c);
                c = C4192d.m13452c(b, f10929d);
                if (c != null) {
                    int i5;
                    int i6;
                    String[] split = c.split("x");
                    int parseInt2 = Integer.parseInt(split[0]);
                    a3 = Integer.parseInt(split[1]);
                    if (parseInt2 > 0) {
                        if (a3 > 0) {
                            i5 = a3;
                            i6 = parseInt2;
                            i3 = i6;
                            i4 = i5;
                        }
                    }
                    i6 = -1;
                    i5 = -1;
                    i3 = i6;
                    i4 = i5;
                } else {
                    i3 = -1;
                    i4 = -1;
                }
                b = C4192d.m13452c(b, f10930e);
                float parseFloat = b != null ? Float.parseFloat(b) : -1.0f;
                b = c2397a.m6607b();
                if (hashSet.add(b)) {
                    arrayList.add(new C2394a(b, C2515k.m6994a(Integer.toString(arrayList.size()), "application/x-mpegURL", null, d, hashCode, i3, i4, parseFloat, null, 0)));
                }
            }
        }
        if (i != 0) {
            list = Collections.emptyList();
        }
        return new C4190a(str, arrayList4, arrayList, arrayList2, arrayList3, c2515k, list);
    }

    /* renamed from: a */
    private static int m13443a(String str) {
        int i = 0;
        int a = C4192d.m13448a(str, f10948w, false) | (C4192d.m13448a(str, f10949x, false) ? 2 : 0);
        if (C4192d.m13448a(str, f10947v, false) != null) {
            i = 4;
        }
        return a | i;
    }

    /* renamed from: b */
    private static C4191b m13450b(C2397a c2397a, String str) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        long j = -9223372036854775807L;
        long j2 = j;
        int i = 0;
        int i2 = 0;
        long j3 = 0;
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1;
        boolean z2 = false;
        boolean z3 = false;
        C2255a c2255a = null;
        C2395a c2395a = null;
        long j4 = 0;
        int i6 = 0;
        long j5 = -1;
        long j6 = 0;
        String str2 = null;
        String str3 = null;
        loop0:
        while (true) {
            long j7 = 0;
            while (c2397a.m6606a()) {
                String b = c2397a.m6607b();
                if (b.startsWith("#EXT")) {
                    arrayList2.add(b);
                }
                if (b.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                    b = C4192d.m13453d(b, f10933h);
                    if ("VOD".equals(b)) {
                        i2 = 1;
                    } else if ("EVENT".equals(b)) {
                        i2 = 2;
                    }
                } else if (b.startsWith("#EXT-X-START")) {
                    j = (long) (C4192d.m13449b(b, f10936k) * 1000000.0d);
                } else if (b.startsWith("#EXT-X-MAP")) {
                    String d = C4192d.m13453d(b, f10941p);
                    b = C4192d.m13452c(b, f10938m);
                    if (b != null) {
                        r2 = b.split("@");
                        j5 = Long.parseLong(r2[0]);
                        if (r2.length > 1) {
                            j4 = Long.parseLong(r2[1]);
                        }
                    }
                    c2395a = new C2395a(d, j4, j5);
                    j4 = 0;
                    j5 = -1;
                } else if (b.startsWith("#EXT-X-TARGETDURATION")) {
                    j2 = 1000000 * ((long) C4192d.m13444a(b, f10931f));
                } else if (b.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                    i6 = C4192d.m13444a(b, f10934i);
                    i4 = i6;
                } else if (b.startsWith("#EXT-X-VERSION")) {
                    i5 = C4192d.m13444a(b, f10932g);
                } else if (b.startsWith("#EXTINF")) {
                    j7 = (long) (C4192d.m13449b(b, f10935j) * 1000000.0d);
                } else if (b.startsWith("#EXT-X-KEY")) {
                    String c = C4192d.m13452c(b, f10939n);
                    String c2 = C4192d.m13452c(b, f10940o);
                    if ("NONE".equals(c)) {
                        str2 = null;
                        str3 = null;
                    } else {
                        String c3 = C4192d.m13452c(b, f10942q);
                        if (!InterpolationAnimatedNode.EXTRAPOLATE_TYPE_IDENTITY.equals(c2)) {
                            if (c2 != null) {
                                if (!(c == null || C4192d.m13445a(b, c2) == null)) {
                                    c2255a = new C2255a("SAMPLE-AES-CENC".equals(c) ? "cenc" : "cbcs", C4192d.m13445a(b, c2));
                                }
                                str3 = c3;
                                str2 = null;
                            }
                        }
                        if ("AES-128".equals(c)) {
                            str2 = C4192d.m13453d(b, f10941p);
                            str3 = c3;
                        }
                        str3 = c3;
                        str2 = null;
                    }
                } else if (b.startsWith("#EXT-X-BYTERANGE")) {
                    r2 = C4192d.m13453d(b, f10937l).split("@");
                    j5 = Long.parseLong(r2[0]);
                    if (r2.length > 1) {
                        j4 = Long.parseLong(r2[1]);
                    }
                } else if (b.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                    i3 = Integer.parseInt(b.substring(b.indexOf(58) + 1));
                    z = true;
                } else if (b.equals("#EXT-X-DISCONTINUITY")) {
                    i++;
                } else if (b.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
                    if (j3 == 0) {
                        j3 = C2251b.m6222b(C2541v.m7192f(b.substring(b.indexOf(58) + 1))) - j6;
                    }
                } else if (!b.startsWith("#")) {
                    String toHexString = str2 == null ? null : str3 != null ? str3 : Integer.toHexString(i6);
                    int i7 = i6 + 1;
                    int i8 = (j5 > -1 ? 1 : (j5 == -1 ? 0 : -1));
                    if (i8 == 0) {
                        j4 = 0;
                    }
                    arrayList.add(new C2395a(b, j7, i, j6, str2, toHexString, j4, j5));
                    j6 += j7;
                    if (i8 != 0) {
                        j4 += j5;
                    }
                    i6 = i7;
                    j5 = -1;
                } else if (b.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                    z2 = true;
                } else if (b.equals("#EXT-X-ENDLIST")) {
                    z3 = true;
                }
            }
            break loop0;
        }
        return new C4191b(i2, str, arrayList2, j, j3, z, i3, i4, i5, j2, z2, z3, j3 != 0, c2255a, c2395a, arrayList);
    }

    /* renamed from: a */
    private static C2254a m13445a(String str, String str2) {
        if ("urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed".equals(str2)) {
            str = C4192d.m13453d(str, f10941p);
            return new C2254a(C2251b.f5379e, "video/mp4", Base64.decode(str.substring(str.indexOf(44)), 0));
        } else if ("com.widevine".equals(str2) == null) {
            return null;
        } else {
            try {
                return new C2254a(C2251b.f5379e, "hls", str.getBytes(Utf8Charset.NAME));
            } catch (Throwable e) {
                throw new C2571p(e);
            }
        }
    }

    /* renamed from: a */
    private static int m13444a(String str, Pattern pattern) {
        return Integer.parseInt(C4192d.m13453d(str, pattern));
    }

    /* renamed from: b */
    private static double m13449b(String str, Pattern pattern) {
        return Double.parseDouble(C4192d.m13453d(str, pattern));
    }

    /* renamed from: c */
    private static String m13452c(String str, Pattern pattern) {
        str = pattern.matcher(str);
        return str.find() != null ? str.group(1) : null;
    }

    /* renamed from: d */
    private static String m13453d(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find() && matcher.groupCount() == 1) {
            return matcher.group(1);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Couldn't match ");
        stringBuilder.append(pattern.pattern());
        stringBuilder.append(" in ");
        stringBuilder.append(str);
        throw new C2571p(stringBuilder.toString());
    }

    /* renamed from: a */
    private static boolean m13448a(String str, Pattern pattern, boolean z) {
        str = pattern.matcher(str);
        return str.find() != null ? str.group(1).equals("YES") : z;
    }

    /* renamed from: b */
    private static Pattern m13451b(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("=(");
        stringBuilder.append("NO");
        stringBuilder.append("|");
        stringBuilder.append("YES");
        stringBuilder.append(")");
        return Pattern.compile(stringBuilder.toString());
    }
}
