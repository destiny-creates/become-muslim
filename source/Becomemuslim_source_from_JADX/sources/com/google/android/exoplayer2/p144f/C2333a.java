package com.google.android.exoplayer2.p144f;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.media.MediaCodecInfo.AudioCapabilities;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.p164l.C2516a;
import com.google.android.exoplayer2.p164l.C2524i;
import com.google.android.exoplayer2.p164l.C2541v;

@TargetApi(16)
/* compiled from: MediaCodecInfo */
/* renamed from: com.google.android.exoplayer2.f.a */
public final class C2333a {
    /* renamed from: a */
    public final String f5786a;
    /* renamed from: b */
    public final boolean f5787b;
    /* renamed from: c */
    public final boolean f5788c;
    /* renamed from: d */
    public final boolean f5789d;
    /* renamed from: e */
    private final String f5790e;
    /* renamed from: f */
    private final CodecCapabilities f5791f;

    /* renamed from: a */
    public static C2333a m6463a(String str) {
        return new C2333a(str, null, null, false, false);
    }

    /* renamed from: a */
    public static C2333a m6464a(String str, String str2, CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        return new C2333a(str, str2, codecCapabilities, z, z2);
    }

    private C2333a(String str, String str2, CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        this.f5786a = (String) C2516a.m7015a((Object) str);
        this.f5790e = str2;
        this.f5791f = codecCapabilities;
        str = true;
        z = (z || codecCapabilities == null || !C2333a.m6465a(codecCapabilities)) ? false : true;
        this.f5787b = z;
        z = codecCapabilities != null && C2333a.m6469c(codecCapabilities);
        this.f5788c = z;
        if (!z2) {
            if (codecCapabilities == null || C2333a.m6472e(codecCapabilities) == null) {
                str = null;
            }
        }
        this.f5789d = str;
    }

    /* renamed from: a */
    public CodecProfileLevel[] m6477a() {
        if (this.f5791f != null) {
            if (this.f5791f.profileLevels != null) {
                return this.f5791f.profileLevels;
            }
        }
        return new CodecProfileLevel[0];
    }

    /* renamed from: b */
    public boolean m6479b(String str) {
        if (str != null) {
            if (this.f5790e != null) {
                String f = C2524i.m7055f(str);
                if (f == null) {
                    return true;
                }
                StringBuilder stringBuilder;
                if (this.f5790e.equals(f)) {
                    Pair a = C2340d.m6489a(str);
                    if (a == null) {
                        return true;
                    }
                    for (CodecProfileLevel codecProfileLevel : m6477a()) {
                        if (codecProfileLevel.profile == ((Integer) a.first).intValue() && codecProfileLevel.level >= ((Integer) a.second).intValue()) {
                            return true;
                        }
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("codec.profileLevel, ");
                    stringBuilder.append(str);
                    stringBuilder.append(", ");
                    stringBuilder.append(f);
                    m6468c(stringBuilder.toString());
                    return false;
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("codec.mime ");
                stringBuilder.append(str);
                stringBuilder.append(", ");
                stringBuilder.append(f);
                m6468c(stringBuilder.toString());
                return false;
            }
        }
        return true;
    }

    @TargetApi(21)
    /* renamed from: a */
    public boolean m6476a(int i, int i2, double d) {
        if (this.f5791f == null) {
            m6468c("sizeAndRate.caps");
            return false;
        }
        VideoCapabilities videoCapabilities = this.f5791f.getVideoCapabilities();
        if (videoCapabilities == null) {
            m6468c("sizeAndRate.vCaps");
            return false;
        }
        if (!C2333a.m6466a(videoCapabilities, i, i2, d)) {
            StringBuilder stringBuilder;
            if (i < i2) {
                if (C2333a.m6466a(videoCapabilities, i2, i, d)) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("sizeAndRate.rotated, ");
                    stringBuilder.append(i);
                    stringBuilder.append("x");
                    stringBuilder.append(i2);
                    stringBuilder.append("x");
                    stringBuilder.append(d);
                    m6470d(stringBuilder.toString());
                }
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("sizeAndRate.support, ");
            stringBuilder.append(i);
            stringBuilder.append("x");
            stringBuilder.append(i2);
            stringBuilder.append("x");
            stringBuilder.append(d);
            m6468c(stringBuilder.toString());
            return false;
        }
        return true;
    }

    @TargetApi(21)
    /* renamed from: a */
    public Point m6474a(int i, int i2) {
        if (this.f5791f == null) {
            m6468c("align.caps");
            return null;
        }
        VideoCapabilities videoCapabilities = this.f5791f.getVideoCapabilities();
        if (videoCapabilities == null) {
            m6468c("align.vCaps");
            return null;
        }
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(C2541v.m7163a(i, widthAlignment) * widthAlignment, C2541v.m7163a(i2, heightAlignment) * heightAlignment);
    }

    @TargetApi(21)
    /* renamed from: a */
    public boolean m6475a(int i) {
        if (this.f5791f == null) {
            m6468c("sampleRate.caps");
            return false;
        }
        AudioCapabilities audioCapabilities = this.f5791f.getAudioCapabilities();
        if (audioCapabilities == null) {
            m6468c("sampleRate.aCaps");
            return false;
        } else if (audioCapabilities.isSampleRateSupported(i)) {
            return true;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("sampleRate.support, ");
            stringBuilder.append(i);
            m6468c(stringBuilder.toString());
            return false;
        }
    }

    @TargetApi(21)
    /* renamed from: b */
    public boolean m6478b(int i) {
        if (this.f5791f == null) {
            m6468c("channelCount.caps");
            return false;
        }
        AudioCapabilities audioCapabilities = this.f5791f.getAudioCapabilities();
        if (audioCapabilities == null) {
            m6468c("channelCount.aCaps");
            return false;
        } else if (C2333a.m6462a(this.f5786a, this.f5790e, audioCapabilities.getMaxInputChannelCount()) >= i) {
            return true;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("channelCount.support, ");
            stringBuilder.append(i);
            m6468c(stringBuilder.toString());
            return false;
        }
    }

    /* renamed from: c */
    private void m6468c(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NoSupport [");
        stringBuilder.append(str);
        stringBuilder.append("] [");
        stringBuilder.append(this.f5786a);
        stringBuilder.append(", ");
        stringBuilder.append(this.f5790e);
        stringBuilder.append("] [");
        stringBuilder.append(C2541v.f6471e);
        stringBuilder.append("]");
        Log.d("MediaCodecInfo", stringBuilder.toString());
    }

    /* renamed from: d */
    private void m6470d(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AssumedSupport [");
        stringBuilder.append(str);
        stringBuilder.append("] [");
        stringBuilder.append(this.f5786a);
        stringBuilder.append(", ");
        stringBuilder.append(this.f5790e);
        stringBuilder.append("] [");
        stringBuilder.append(C2541v.f6471e);
        stringBuilder.append("]");
        Log.d("MediaCodecInfo", stringBuilder.toString());
    }

    /* renamed from: a */
    private static int m6462a(String str, String str2, int i) {
        if (i <= 1) {
            if (C2541v.f6467a < 26 || i <= 0) {
                if (!("audio/mpeg".equals(str2) || "audio/3gpp".equals(str2) || "audio/amr-wb".equals(str2) || "audio/mp4a-latm".equals(str2) || "audio/vorbis".equals(str2) || "audio/opus".equals(str2) || "audio/raw".equals(str2) || "audio/flac".equals(str2) || "audio/g711-alaw".equals(str2) || "audio/g711-mlaw".equals(str2))) {
                    if (!"audio/gsm".equals(str2)) {
                        str2 = "audio/ac3".equals(str2) ? 6 : "audio/eac3".equals(str2) != null ? 16 : 30;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("AssumedMaxChannelAdjustment: ");
                        stringBuilder.append(str);
                        stringBuilder.append(", [");
                        stringBuilder.append(i);
                        stringBuilder.append(" to ");
                        stringBuilder.append(str2);
                        stringBuilder.append("]");
                        Log.w("MediaCodecInfo", stringBuilder.toString());
                        return str2;
                    }
                }
                return i;
            }
        }
        return i;
    }

    /* renamed from: a */
    private static boolean m6465a(CodecCapabilities codecCapabilities) {
        return (C2541v.f6467a < 19 || C2333a.m6467b(codecCapabilities) == null) ? null : true;
    }

    @TargetApi(19)
    /* renamed from: b */
    private static boolean m6467b(CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    /* renamed from: c */
    private static boolean m6469c(CodecCapabilities codecCapabilities) {
        return (C2541v.f6467a < 21 || C2333a.m6471d(codecCapabilities) == null) ? null : true;
    }

    @TargetApi(21)
    /* renamed from: d */
    private static boolean m6471d(CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    /* renamed from: e */
    private static boolean m6472e(CodecCapabilities codecCapabilities) {
        return (C2541v.f6467a < 21 || C2333a.m6473f(codecCapabilities) == null) ? null : true;
    }

    @TargetApi(21)
    /* renamed from: f */
    private static boolean m6473f(CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    @TargetApi(21)
    /* renamed from: a */
    private static boolean m6466a(VideoCapabilities videoCapabilities, int i, int i2, double d) {
        if (d != -1.0d) {
            if (d > 0.0d) {
                return videoCapabilities.areSizeAndRateSupported(i, i2, d);
            }
        }
        return videoCapabilities.isSizeSupported(i, i2);
    }
}
