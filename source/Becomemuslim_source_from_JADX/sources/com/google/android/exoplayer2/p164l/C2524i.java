package com.google.android.exoplayer2.p164l;

import android.text.TextUtils;

/* compiled from: MimeTypes */
/* renamed from: com.google.android.exoplayer2.l.i */
public final class C2524i {
    /* renamed from: a */
    public static boolean m7050a(String str) {
        return "audio".equals(C2524i.m7059j(str));
    }

    /* renamed from: b */
    public static boolean m7051b(String str) {
        return "video".equals(C2524i.m7059j(str));
    }

    /* renamed from: c */
    public static boolean m7052c(String str) {
        return "text".equals(C2524i.m7059j(str));
    }

    /* renamed from: d */
    public static String m7053d(String str) {
        if (str == null) {
            return null;
        }
        for (String f : str.split(",")) {
            String f2 = C2524i.m7055f(f2);
            if (f2 != null && C2524i.m7051b(f2)) {
                return f2;
            }
        }
        return null;
    }

    /* renamed from: e */
    public static String m7054e(String str) {
        if (str == null) {
            return null;
        }
        for (String f : str.split(",")) {
            String f2 = C2524i.m7055f(f2);
            if (f2 != null && C2524i.m7050a(f2)) {
                return f2;
            }
        }
        return null;
    }

    /* renamed from: f */
    public static String m7055f(String str) {
        if (str == null) {
            return null;
        }
        str = str.trim();
        if (!str.startsWith("avc1")) {
            if (!str.startsWith("avc3")) {
                if (!str.startsWith("hev1")) {
                    if (!str.startsWith("hvc1")) {
                        if (!str.startsWith("vp9")) {
                            if (!str.startsWith("vp09")) {
                                if (!str.startsWith("vp8")) {
                                    if (!str.startsWith("vp08")) {
                                        if (str.startsWith("mp4a")) {
                                            return "audio/mp4a-latm";
                                        }
                                        if (!str.startsWith("ac-3")) {
                                            if (!str.startsWith("dac3")) {
                                                if (!str.startsWith("ec-3")) {
                                                    if (!str.startsWith("dec3")) {
                                                        if (str.startsWith("ec+3")) {
                                                            return "audio/eac3-joc";
                                                        }
                                                        if (!str.startsWith("dtsc")) {
                                                            if (!str.startsWith("dtse")) {
                                                                if (!str.startsWith("dtsh")) {
                                                                    if (!str.startsWith("dtsl")) {
                                                                        if (str.startsWith("opus")) {
                                                                            return "audio/opus";
                                                                        }
                                                                        if (str.startsWith("vorbis") != null) {
                                                                            return "audio/vorbis";
                                                                        }
                                                                        return null;
                                                                    }
                                                                }
                                                                return "audio/vnd.dts.hd";
                                                            }
                                                        }
                                                        return "audio/vnd.dts";
                                                    }
                                                }
                                                return "audio/eac3";
                                            }
                                        }
                                        return "audio/ac3";
                                    }
                                }
                                return "video/x-vnd.on2.vp8";
                            }
                        }
                        return "video/x-vnd.on2.vp9";
                    }
                }
                return "video/hevc";
            }
        }
        return "video/avc";
    }

    /* renamed from: g */
    public static int m7056g(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (C2524i.m7050a(str)) {
            return 1;
        }
        if (C2524i.m7051b(str)) {
            return 2;
        }
        if (!(C2524i.m7052c(str) || "application/cea-608".equals(str) || "application/cea-708".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/x-subrip".equals(str) || "application/ttml+xml".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-rawcc".equals(str) || "application/vobsub".equals(str) || "application/pgs".equals(str))) {
            if (!"application/dvbsubs".equals(str)) {
                if (!("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str))) {
                    if ("application/x-camera-motion".equals(str) == null) {
                        return -1;
                    }
                }
                return 4;
            }
        }
        return 3;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: h */
    public static int m7057h(java.lang.String r2) {
        /*
        r0 = r2.hashCode();
        r1 = 0;
        switch(r0) {
            case -2123537834: goto L_0x0031;
            case -1095064472: goto L_0x0027;
            case 187078296: goto L_0x001d;
            case 1504578661: goto L_0x0013;
            case 1505942594: goto L_0x0009;
            default: goto L_0x0008;
        };
    L_0x0008:
        goto L_0x003b;
    L_0x0009:
        r0 = "audio/vnd.dts.hd";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x003b;
    L_0x0011:
        r2 = 4;
        goto L_0x003c;
    L_0x0013:
        r0 = "audio/eac3";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x003b;
    L_0x001b:
        r2 = 1;
        goto L_0x003c;
    L_0x001d:
        r0 = "audio/ac3";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x003b;
    L_0x0025:
        r2 = 0;
        goto L_0x003c;
    L_0x0027:
        r0 = "audio/vnd.dts";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x003b;
    L_0x002f:
        r2 = 3;
        goto L_0x003c;
    L_0x0031:
        r0 = "audio/eac3-joc";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x003b;
    L_0x0039:
        r2 = 2;
        goto L_0x003c;
    L_0x003b:
        r2 = -1;
    L_0x003c:
        switch(r2) {
            case 0: goto L_0x0047;
            case 1: goto L_0x0045;
            case 2: goto L_0x0045;
            case 3: goto L_0x0043;
            case 4: goto L_0x0040;
            default: goto L_0x003f;
        };
    L_0x003f:
        return r1;
    L_0x0040:
        r2 = 8;
        return r2;
    L_0x0043:
        r2 = 7;
        return r2;
    L_0x0045:
        r2 = 6;
        return r2;
    L_0x0047:
        r2 = 5;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.l.i.h(java.lang.String):int");
    }

    /* renamed from: i */
    public static int m7058i(String str) {
        return C2524i.m7056g(C2524i.m7055f(str));
    }

    /* renamed from: j */
    private static String m7059j(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(47);
        if (indexOf != -1) {
            return str.substring(0, indexOf);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid mime type: ");
        stringBuilder.append(str);
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
