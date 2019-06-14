package com.google.android.exoplayer2.p144f;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseIntArray;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.common.util.ByteConstants;
import com.facebook.imagepipeline.memory.DefaultFlexByteArrayPoolParams;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.google.android.exoplayer2.p164l.C2541v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressLint({"InlinedApi"})
@TargetApi(16)
/* compiled from: MediaCodecUtil */
/* renamed from: com.google.android.exoplayer2.f.d */
public final class C2340d {
    /* renamed from: a */
    private static final C2333a f5799a = C2333a.m6463a("OMX.google.raw.decoder");
    /* renamed from: b */
    private static final Pattern f5800b = Pattern.compile("^\\D?(\\d+)$");
    /* renamed from: c */
    private static final HashMap<C2337a, List<C2333a>> f5801c = new HashMap();
    /* renamed from: d */
    private static final SparseIntArray f5802d = new SparseIntArray();
    /* renamed from: e */
    private static final SparseIntArray f5803e = new SparseIntArray();
    /* renamed from: f */
    private static final Map<String, Integer> f5804f = new HashMap();
    /* renamed from: g */
    private static int f5805g = -1;

    /* compiled from: MediaCodecUtil */
    /* renamed from: com.google.android.exoplayer2.f.d$a */
    private static final class C2337a {
        /* renamed from: a */
        public final String f5797a;
        /* renamed from: b */
        public final boolean f5798b;

        public C2337a(String str, boolean z) {
            this.f5797a = str;
            this.f5798b = z;
        }

        public int hashCode() {
            return (((this.f5797a == null ? 0 : this.f5797a.hashCode()) + 31) * 31) + (this.f5798b ? 1231 : 1237);
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                if (obj.getClass() == C2337a.class) {
                    C2337a c2337a = (C2337a) obj;
                    if (!TextUtils.equals(this.f5797a, c2337a.f5797a) || this.f5798b != c2337a.f5798b) {
                        z = false;
                    }
                    return z;
                }
            }
            return false;
        }
    }

    /* compiled from: MediaCodecUtil */
    /* renamed from: com.google.android.exoplayer2.f.d$b */
    public static class C2338b extends Exception {
        private C2338b(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }
    }

    /* compiled from: MediaCodecUtil */
    /* renamed from: com.google.android.exoplayer2.f.d$c */
    private interface C2339c {
        /* renamed from: a */
        int mo2223a();

        /* renamed from: a */
        MediaCodecInfo mo2224a(int i);

        /* renamed from: a */
        boolean mo2225a(String str, CodecCapabilities codecCapabilities);

        /* renamed from: b */
        boolean mo2226b();
    }

    /* compiled from: MediaCodecUtil */
    /* renamed from: com.google.android.exoplayer2.f.d$d */
    private static final class C4157d implements C2339c {
        /* renamed from: b */
        public boolean mo2226b() {
            return false;
        }

        private C4157d() {
        }

        /* renamed from: a */
        public int mo2223a() {
            return MediaCodecList.getCodecCount();
        }

        /* renamed from: a */
        public MediaCodecInfo mo2224a(int i) {
            return MediaCodecList.getCodecInfoAt(i);
        }

        /* renamed from: a */
        public boolean mo2225a(String str, CodecCapabilities codecCapabilities) {
            return "video/avc".equals(str);
        }
    }

    @TargetApi(21)
    /* compiled from: MediaCodecUtil */
    /* renamed from: com.google.android.exoplayer2.f.d$e */
    private static final class C4158e implements C2339c {
        /* renamed from: a */
        private final int f10788a;
        /* renamed from: b */
        private MediaCodecInfo[] f10789b;

        /* renamed from: b */
        public boolean mo2226b() {
            return true;
        }

        public C4158e(boolean z) {
            this.f10788a = z;
        }

        /* renamed from: a */
        public int mo2223a() {
            m13223c();
            return this.f10789b.length;
        }

        /* renamed from: a */
        public MediaCodecInfo mo2224a(int i) {
            m13223c();
            return this.f10789b[i];
        }

        /* renamed from: a */
        public boolean mo2225a(String str, CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported("secure-playback");
        }

        /* renamed from: c */
        private void m13223c() {
            if (this.f10789b == null) {
                this.f10789b = new MediaCodecList(this.f10788a).getCodecInfos();
            }
        }
    }

    /* renamed from: a */
    private static int m6488a(int i) {
        switch (i) {
            case 1:
                return 25344;
            case 2:
                return 25344;
            case 8:
                return 101376;
            case 16:
                return 101376;
            case 32:
                return 101376;
            case 64:
                return 202752;
            case 128:
                return 414720;
            case 256:
                return 414720;
            case 512:
                return 921600;
            case 1024:
                return 1310720;
            case 2048:
                return 2097152;
            case 4096:
                return 2097152;
            case Utility.DEFAULT_STREAM_BUFFER_SIZE /*8192*/:
                return 2228224;
            case 16384:
                return 5652480;
            case 32768:
                return 9437184;
            case NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST /*65536*/:
                return 9437184;
            default:
                return -1;
        }
    }

    static {
        f5802d.put(66, 1);
        f5802d.put(77, 2);
        f5802d.put(88, 4);
        f5802d.put(100, 8);
        f5803e.put(10, 1);
        f5803e.put(11, 4);
        f5803e.put(12, 8);
        f5803e.put(13, 16);
        f5803e.put(20, 32);
        f5803e.put(21, 64);
        f5803e.put(22, 128);
        f5803e.put(30, 256);
        f5803e.put(31, 512);
        f5803e.put(32, 1024);
        f5803e.put(40, 2048);
        f5803e.put(41, 4096);
        f5803e.put(42, Utility.DEFAULT_STREAM_BUFFER_SIZE);
        f5803e.put(50, 16384);
        f5803e.put(51, 32768);
        f5803e.put(52, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        f5804f.put("L30", Integer.valueOf(1));
        f5804f.put("L60", Integer.valueOf(4));
        f5804f.put("L63", Integer.valueOf(16));
        f5804f.put("L90", Integer.valueOf(64));
        f5804f.put("L93", Integer.valueOf(256));
        f5804f.put("L120", Integer.valueOf(1024));
        f5804f.put("L123", Integer.valueOf(4096));
        f5804f.put("L150", Integer.valueOf(16384));
        f5804f.put("L153", Integer.valueOf(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST));
        f5804f.put("L156", Integer.valueOf(262144));
        f5804f.put("L180", Integer.valueOf(ByteConstants.MB));
        f5804f.put("L183", Integer.valueOf(DefaultFlexByteArrayPoolParams.DEFAULT_MAX_BYTE_ARRAY_SIZE));
        f5804f.put("L186", Integer.valueOf(16777216));
        f5804f.put("H30", Integer.valueOf(2));
        f5804f.put("H60", Integer.valueOf(8));
        f5804f.put("H63", Integer.valueOf(32));
        f5804f.put("H90", Integer.valueOf(128));
        f5804f.put("H93", Integer.valueOf(512));
        f5804f.put("H120", Integer.valueOf(2048));
        f5804f.put("H123", Integer.valueOf(Utility.DEFAULT_STREAM_BUFFER_SIZE));
        f5804f.put("H150", Integer.valueOf(32768));
        f5804f.put("H153", Integer.valueOf(131072));
        f5804f.put("H156", Integer.valueOf(524288));
        f5804f.put("H180", Integer.valueOf(2097152));
        f5804f.put("H183", Integer.valueOf(8388608));
        f5804f.put("H186", Integer.valueOf(33554432));
    }

    /* renamed from: a */
    public static C2333a m6491a() {
        return f5799a;
    }

    /* renamed from: a */
    public static C2333a m6492a(String str, boolean z) {
        str = C2340d.m6498b(str, z);
        return str.isEmpty() ? null : (C2333a) str.get(false);
    }

    /* renamed from: b */
    public static synchronized List<C2333a> m6498b(String str, boolean z) {
        synchronized (C2340d.class) {
            C2337a c2337a = new C2337a(str, z);
            List<C2333a> list = (List) f5801c.get(c2337a);
            if (list != null) {
                return list;
            }
            C2339c c4158e = C2541v.f6467a >= 21 ? new C4158e(z) : new C4157d();
            List a = C2340d.m6493a(c2337a, c4158e, str);
            if (z && a.isEmpty() && true <= C2541v.f6467a && C2541v.f6467a <= true) {
                c4158e = new C4157d();
                a = C2340d.m6493a(c2337a, c4158e, str);
                if (!a.isEmpty()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("MediaCodecList API didn't list secure decoder for: ");
                    stringBuilder.append(str);
                    stringBuilder.append(". Assuming: ");
                    stringBuilder.append(((C2333a) a.get(0)).f5786a);
                    Log.w("MediaCodecUtil", stringBuilder.toString());
                }
            }
            if ("audio/eac3-joc".equals(str)) {
                a.addAll(C2340d.m6493a(new C2337a("audio/eac3", c2337a.f5798b), c4158e, str));
            }
            C2340d.m6494a(a);
            str = Collections.unmodifiableList(a);
            f5801c.put(c2337a, str);
            return str;
        }
    }

    /* renamed from: b */
    public static int m6496b() {
        if (f5805g == -1) {
            int i = 0;
            C2333a a = C2340d.m6492a("video/avc", false);
            if (a != null) {
                CodecProfileLevel[] a2 = a.m6477a();
                int length = a2.length;
                int i2 = 0;
                while (i < length) {
                    i2 = Math.max(C2340d.m6488a(a2[i].level), i2);
                    i++;
                }
                i = Math.max(i2, C2541v.f6467a >= 21 ? 345600 : 172800);
            }
            f5805g = i;
        }
        return f5805g;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> m6489a(java.lang.String r6) {
        /*
        r0 = 0;
        if (r6 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = "\\.";
        r1 = r6.split(r1);
        r2 = 0;
        r3 = r1[r2];
        r4 = -1;
        r5 = r3.hashCode();
        switch(r5) {
            case 3006243: goto L_0x0033;
            case 3006244: goto L_0x0029;
            case 3199032: goto L_0x0020;
            case 3214780: goto L_0x0016;
            default: goto L_0x0015;
        };
    L_0x0015:
        goto L_0x003d;
    L_0x0016:
        r2 = "hvc1";
        r2 = r3.equals(r2);
        if (r2 == 0) goto L_0x003d;
    L_0x001e:
        r2 = 1;
        goto L_0x003e;
    L_0x0020:
        r5 = "hev1";
        r3 = r3.equals(r5);
        if (r3 == 0) goto L_0x003d;
    L_0x0028:
        goto L_0x003e;
    L_0x0029:
        r2 = "avc2";
        r2 = r3.equals(r2);
        if (r2 == 0) goto L_0x003d;
    L_0x0031:
        r2 = 3;
        goto L_0x003e;
    L_0x0033:
        r2 = "avc1";
        r2 = r3.equals(r2);
        if (r2 == 0) goto L_0x003d;
    L_0x003b:
        r2 = 2;
        goto L_0x003e;
    L_0x003d:
        r2 = -1;
    L_0x003e:
        switch(r2) {
            case 0: goto L_0x0047;
            case 1: goto L_0x0047;
            case 2: goto L_0x0042;
            case 3: goto L_0x0042;
            default: goto L_0x0041;
        };
    L_0x0041:
        return r0;
    L_0x0042:
        r6 = com.google.android.exoplayer2.p144f.C2340d.m6497b(r6, r1);
        return r6;
    L_0x0047:
        r6 = com.google.android.exoplayer2.p144f.C2340d.m6490a(r6, r1);
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.f.d.a(java.lang.String):android.util.Pair<java.lang.Integer, java.lang.Integer>");
    }

    /* renamed from: a */
    private static ArrayList<C2333a> m6493a(C2337a c2337a, C2339c c2339c, String str) {
        int i;
        Exception e;
        StringBuilder stringBuilder;
        C2337a c2337a2 = c2337a;
        C2339c c2339c2 = c2339c;
        try {
            ArrayList<C2333a> arrayList = new ArrayList();
            String str2 = c2337a2.f5797a;
            int a = c2339c.mo2223a();
            boolean b = c2339c.mo2226b();
            int i2 = 0;
            while (i2 < a) {
                MediaCodecInfo a2 = c2339c2.mo2224a(i2);
                String name = a2.getName();
                if (C2340d.m6495a(a2, name, b, str)) {
                    String[] supportedTypes = a2.getSupportedTypes();
                    int length = supportedTypes.length;
                    int i3 = 0;
                    while (i3 < length) {
                        String str3 = supportedTypes[i3];
                        if (str3.equalsIgnoreCase(str2)) {
                            try {
                                CodecCapabilities capabilitiesForType = a2.getCapabilitiesForType(str3);
                                boolean a3 = c2339c2.mo2225a(str2, capabilitiesForType);
                                boolean b2 = C2340d.m6499b(name);
                                StringBuilder stringBuilder2;
                                if (b) {
                                    i = a;
                                    try {
                                        if (c2337a2.f5798b != a3) {
                                            if (!b || c2337a2.f5798b) {
                                                if (!b && a3) {
                                                    stringBuilder2 = new StringBuilder();
                                                    stringBuilder2.append(name);
                                                    stringBuilder2.append(".secure");
                                                    arrayList.add(C2333a.m6464a(stringBuilder2.toString(), str2, capabilitiesForType, b2, true));
                                                    return arrayList;
                                                }
                                            }
                                        }
                                    } catch (Exception e2) {
                                        e = e2;
                                        if (C2541v.f6467a <= 23) {
                                        }
                                        stringBuilder = new StringBuilder();
                                        stringBuilder.append("Failed to query codec ");
                                        stringBuilder.append(name);
                                        stringBuilder.append(" (");
                                        stringBuilder.append(str3);
                                        stringBuilder.append(")");
                                        Log.e("MediaCodecUtil", stringBuilder.toString());
                                        throw e;
                                    }
                                }
                                i = a;
                                if (b) {
                                }
                                stringBuilder2 = new StringBuilder();
                                stringBuilder2.append(name);
                                stringBuilder2.append(".secure");
                                arrayList.add(C2333a.m6464a(stringBuilder2.toString(), str2, capabilitiesForType, b2, true));
                                return arrayList;
                                arrayList.add(C2333a.m6464a(name, str2, capabilitiesForType, b2, false));
                            } catch (Exception e3) {
                                e = e3;
                                i = a;
                                if (C2541v.f6467a <= 23 || arrayList.isEmpty()) {
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append("Failed to query codec ");
                                    stringBuilder.append(name);
                                    stringBuilder.append(" (");
                                    stringBuilder.append(str3);
                                    stringBuilder.append(")");
                                    Log.e("MediaCodecUtil", stringBuilder.toString());
                                    throw e;
                                }
                                stringBuilder = new StringBuilder();
                                stringBuilder.append("Skipping codec ");
                                stringBuilder.append(name);
                                stringBuilder.append(" (failed to query capabilities)");
                                Log.e("MediaCodecUtil", stringBuilder.toString());
                                i3++;
                                a = i;
                                c2339c2 = c2339c;
                            }
                        } else {
                            i = a;
                        }
                        i3++;
                        a = i;
                        c2339c2 = c2339c;
                    }
                    continue;
                }
                i2++;
                a = a;
                c2339c2 = c2339c;
            }
            return arrayList;
        } catch (Throwable e4) {
            throw new C2338b(e4);
        }
    }

    /* renamed from: a */
    private static boolean m6495a(MediaCodecInfo mediaCodecInfo, String str, boolean z, String str2) {
        if (mediaCodecInfo.isEncoder() == null) {
            if (z || str.endsWith(".secure") == null) {
                if (C2541v.f6467a < true && ("CIPAACDecoder".equals(str) != null || "CIPMP3Decoder".equals(str) != null || "CIPVorbisDecoder".equals(str) != null || "CIPAMRNBDecoder".equals(str) != null || "AACDecoder".equals(str) != null || "MP3Decoder".equals(str) != null)) {
                    return false;
                }
                if (C2541v.f6467a < 18 && "OMX.SEC.MP3.Decoder".equals(str) != null) {
                    return false;
                }
                if (C2541v.f6467a < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str) != null && ("a70".equals(C2541v.f6468b) != null || ("Xiaomi".equals(C2541v.f6469c) != null && C2541v.f6468b.startsWith("HM") != null))) {
                    return false;
                }
                if (C2541v.f6467a == 16 && "OMX.qcom.audio.decoder.mp3".equals(str) != null && ("dlxu".equals(C2541v.f6468b) != null || "protou".equals(C2541v.f6468b) != null || "ville".equals(C2541v.f6468b) != null || "villeplus".equals(C2541v.f6468b) != null || "villec2".equals(C2541v.f6468b) != null || C2541v.f6468b.startsWith("gee") != null || "C6602".equals(C2541v.f6468b) != null || "C6603".equals(C2541v.f6468b) != null || "C6606".equals(C2541v.f6468b) != null || "C6616".equals(C2541v.f6468b) != null || "L36h".equals(C2541v.f6468b) != null || "SO-02E".equals(C2541v.f6468b) != null)) {
                    return false;
                }
                if (C2541v.f6467a == 16 && "OMX.qcom.audio.decoder.aac".equals(str) != null && ("C1504".equals(C2541v.f6468b) != null || "C1505".equals(C2541v.f6468b) != null || "C1604".equals(C2541v.f6468b) != null || "C1605".equals(C2541v.f6468b) != null)) {
                    return false;
                }
                if (C2541v.f6467a < true && (("OMX.SEC.aac.dec".equals(str) != null || "OMX.Exynos.AAC.Decoder".equals(str) != null) && C2541v.f6469c.equals("samsung") != null && (C2541v.f6468b.startsWith("zeroflte") != null || C2541v.f6468b.startsWith("zerolte") != null || C2541v.f6468b.startsWith("zenlte") != null || C2541v.f6468b.equals("SC-05G") != null || C2541v.f6468b.equals("marinelteatt") != null || C2541v.f6468b.equals("404SC") != null || C2541v.f6468b.equals("SC-04G") != null || C2541v.f6468b.equals("SCV31") != null))) {
                    return false;
                }
                if (C2541v.f6467a <= 19 && "OMX.SEC.vp8.dec".equals(str) != null && "samsung".equals(C2541v.f6469c) != null && (C2541v.f6468b.startsWith("d2") != null || C2541v.f6468b.startsWith("serrano") != null || C2541v.f6468b.startsWith("jflte") != null || C2541v.f6468b.startsWith("santos") != null || C2541v.f6468b.startsWith("t0") != null)) {
                    return false;
                }
                if (C2541v.f6467a <= 19 && C2541v.f6468b.startsWith("jflte") != null && "OMX.qcom.video.decoder.vp8".equals(str) != null) {
                    return false;
                }
                if ("audio/eac3-joc".equals(str2) == null || "OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str) == null) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static void m6494a(List<C2333a> list) {
        if (C2541v.f6467a < 26) {
            int i = 1;
            if (list.size() > 1 && "OMX.MTK.AUDIO.DECODER.RAW".equals(((C2333a) list.get(0)).f5786a)) {
                while (i < list.size()) {
                    C2333a c2333a = (C2333a) list.get(i);
                    if ("OMX.google.raw.decoder".equals(c2333a.f5786a)) {
                        list.remove(i);
                        list.add(0, c2333a);
                        return;
                    }
                    i++;
                }
            }
        }
    }

    /* renamed from: b */
    private static boolean m6499b(String str) {
        return (C2541v.f6467a > 22 || (!(C2541v.f6470d.equals("ODROID-XU3") || C2541v.f6470d.equals("Nexus 10")) || (!"OMX.Exynos.AVC.Decoder".equals(str) && "OMX.Exynos.AVC.Decoder.secure".equals(str) == null))) ? null : true;
    }

    /* renamed from: a */
    private static Pair<Integer, Integer> m6490a(String str, String[] strArr) {
        if (strArr.length < 4) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Ignoring malformed HEVC codec string: ");
            stringBuilder.append(str);
            Log.w("MediaCodecUtil", stringBuilder.toString());
            return null;
        }
        Matcher matcher = f5800b.matcher(strArr[1]);
        if (matcher.matches()) {
            str = matcher.group(1);
            if (AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(str)) {
                str = true;
            } else if ("2".equals(str)) {
                str = 2;
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown HEVC profile string: ");
                stringBuilder.append(str);
                Log.w("MediaCodecUtil", stringBuilder.toString());
                return null;
            }
            Integer num = (Integer) f5804f.get(strArr[3]);
            if (num != null) {
                return new Pair(Integer.valueOf(str), num);
            }
            strArr = new StringBuilder();
            strArr.append("Unknown HEVC level string: ");
            strArr.append(matcher.group(1));
            Log.w("MediaCodecUtil", strArr.toString());
            return null;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Ignoring malformed HEVC codec string: ");
        stringBuilder.append(str);
        Log.w("MediaCodecUtil", stringBuilder.toString());
        return null;
    }

    /* renamed from: b */
    private static android.util.Pair<java.lang.Integer, java.lang.Integer> m6497b(java.lang.String r5, java.lang.String[] r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = r6.length;
        r1 = 2;
        r2 = 0;
        if (r0 >= r1) goto L_0x001c;
    L_0x0005:
        r6 = "MediaCodecUtil";
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "Ignoring malformed AVC codec string: ";
        r0.append(r1);
        r0.append(r5);
        r5 = r0.toString();
        android.util.Log.w(r6, r5);
        return r2;
    L_0x001c:
        r0 = 1;
        r3 = r6[r0];	 Catch:{ NumberFormatException -> 0x00cb }
        r3 = r3.length();	 Catch:{ NumberFormatException -> 0x00cb }
        r4 = 6;	 Catch:{ NumberFormatException -> 0x00cb }
        if (r3 != r4) goto L_0x0048;	 Catch:{ NumberFormatException -> 0x00cb }
    L_0x0026:
        r3 = r6[r0];	 Catch:{ NumberFormatException -> 0x00cb }
        r4 = 0;	 Catch:{ NumberFormatException -> 0x00cb }
        r1 = r3.substring(r4, r1);	 Catch:{ NumberFormatException -> 0x00cb }
        r3 = 16;	 Catch:{ NumberFormatException -> 0x00cb }
        r1 = java.lang.Integer.parseInt(r1, r3);	 Catch:{ NumberFormatException -> 0x00cb }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ NumberFormatException -> 0x00cb }
        r6 = r6[r0];	 Catch:{ NumberFormatException -> 0x00cb }
        r0 = 4;	 Catch:{ NumberFormatException -> 0x00cb }
        r6 = r6.substring(r0);	 Catch:{ NumberFormatException -> 0x00cb }
        r6 = java.lang.Integer.parseInt(r6, r3);	 Catch:{ NumberFormatException -> 0x00cb }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ NumberFormatException -> 0x00cb }
        r0 = r1;	 Catch:{ NumberFormatException -> 0x00cb }
        goto L_0x0060;	 Catch:{ NumberFormatException -> 0x00cb }
    L_0x0048:
        r3 = r6.length;	 Catch:{ NumberFormatException -> 0x00cb }
        r4 = 3;	 Catch:{ NumberFormatException -> 0x00cb }
        if (r3 < r4) goto L_0x00b4;	 Catch:{ NumberFormatException -> 0x00cb }
    L_0x004c:
        r0 = r6[r0];	 Catch:{ NumberFormatException -> 0x00cb }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ NumberFormatException -> 0x00cb }
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ NumberFormatException -> 0x00cb }
        r6 = r6[r1];	 Catch:{ NumberFormatException -> 0x00cb }
        r6 = java.lang.Integer.parseInt(r6);	 Catch:{ NumberFormatException -> 0x00cb }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ NumberFormatException -> 0x00cb }
    L_0x0060:
        r5 = f5802d;
        r1 = r0.intValue();
        r5 = r5.get(r1);
        r5 = java.lang.Integer.valueOf(r5);
        if (r5 != 0) goto L_0x0087;
    L_0x0070:
        r5 = "MediaCodecUtil";
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r1 = "Unknown AVC profile: ";
        r6.append(r1);
        r6.append(r0);
        r6 = r6.toString();
        android.util.Log.w(r5, r6);
        return r2;
    L_0x0087:
        r0 = f5803e;
        r1 = r6.intValue();
        r0 = r0.get(r1);
        r0 = java.lang.Integer.valueOf(r0);
        if (r0 != 0) goto L_0x00ae;
    L_0x0097:
        r5 = "MediaCodecUtil";
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "Unknown AVC level: ";
        r0.append(r1);
        r0.append(r6);
        r6 = r0.toString();
        android.util.Log.w(r5, r6);
        return r2;
    L_0x00ae:
        r6 = new android.util.Pair;
        r6.<init>(r5, r0);
        return r6;
    L_0x00b4:
        r6 = "MediaCodecUtil";	 Catch:{ NumberFormatException -> 0x00cb }
        r0 = new java.lang.StringBuilder;	 Catch:{ NumberFormatException -> 0x00cb }
        r0.<init>();	 Catch:{ NumberFormatException -> 0x00cb }
        r1 = "Ignoring malformed AVC codec string: ";	 Catch:{ NumberFormatException -> 0x00cb }
        r0.append(r1);	 Catch:{ NumberFormatException -> 0x00cb }
        r0.append(r5);	 Catch:{ NumberFormatException -> 0x00cb }
        r0 = r0.toString();	 Catch:{ NumberFormatException -> 0x00cb }
        android.util.Log.w(r6, r0);	 Catch:{ NumberFormatException -> 0x00cb }
        return r2;
    L_0x00cb:
        r6 = "MediaCodecUtil";
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "Ignoring malformed AVC codec string: ";
        r0.append(r1);
        r0.append(r5);
        r5 = r0.toString();
        android.util.Log.w(r6, r5);
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.f.d.b(java.lang.String, java.lang.String[]):android.util.Pair<java.lang.Integer, java.lang.Integer>");
    }
}
