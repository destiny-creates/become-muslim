package com.google.android.exoplayer2.p134a;

import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p136c.C2255a;
import com.google.android.exoplayer2.p164l.C2528k;
import java.nio.ByteBuffer;

/* compiled from: DtsUtil */
/* renamed from: com.google.android.exoplayer2.a.i */
public final class C2241i {
    /* renamed from: a */
    private static final int[] f5324a = new int[]{1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    /* renamed from: b */
    private static final int[] f5325b = new int[]{-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
    /* renamed from: c */
    private static final int[] f5326c = new int[]{64, 112, 128, JfifUtil.MARKER_SOFn, 224, 256, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    /* renamed from: a */
    public static C2515k m6179a(byte[] bArr, String str, String str2, C2255a c2255a) {
        byte[] bArr2 = bArr;
        C2528k c2528k = new C2528k(bArr);
        c2528k.m7078b(60);
        int i = f5324a[c2528k.m7081c(6)];
        int i2 = f5325b[c2528k.m7081c(4)];
        int c = c2528k.m7081c(5);
        int i3 = c >= f5326c.length ? -1 : (f5326c[c] * 1000) / 2;
        c2528k.m7078b(10);
        return C2515k.m6988a(str, "audio/vnd.dts", null, i3, -1, i + (c2528k.m7081c(2) > 0 ? 1 : 0), i2, null, c2255a, 0, str2);
    }

    /* renamed from: a */
    public static int m6178a(byte[] bArr) {
        return ((((bArr[5] & 252) >> 2) | ((bArr[4] & 1) << 6)) + 1) * 32;
    }

    /* renamed from: a */
    public static int m6177a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        return ((((byteBuffer.get(position + 5) & 252) >> 2) | ((byteBuffer.get(position + 4) & 1) << 6)) + 1) * 32;
    }

    /* renamed from: b */
    public static int m6180b(byte[] bArr) {
        return (((bArr[7] & 240) >> 4) | (((bArr[5] & 2) << 12) | ((bArr[6] & JfifUtil.MARKER_FIRST_BYTE) << 4))) + 1;
    }
}
