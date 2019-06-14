package com.google.android.exoplayer2.p134a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.Arrays;

@TargetApi(21)
/* compiled from: AudioCapabilities */
/* renamed from: com.google.android.exoplayer2.a.c */
public final class C2220c {
    /* renamed from: a */
    public static final C2220c f5283a = new C2220c(new int[]{2}, 2);
    /* renamed from: b */
    private final int[] f5284b;
    /* renamed from: c */
    private final int f5285c;

    /* renamed from: a */
    public static C2220c m6116a(Context context) {
        return C2220c.m6117a(context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    @SuppressLint({"InlinedApi"})
    /* renamed from: a */
    static C2220c m6117a(Intent intent) {
        if (intent != null) {
            if (intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) != 0) {
                return new C2220c(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 0));
            }
        }
        return f5283a;
    }

    C2220c(int[] iArr, int i) {
        if (iArr != null) {
            this.f5284b = Arrays.copyOf(iArr, iArr.length);
            Arrays.sort(this.f5284b);
        } else {
            this.f5284b = new int[null];
        }
        this.f5285c = i;
    }

    /* renamed from: a */
    public boolean m6118a(int i) {
        return Arrays.binarySearch(this.f5284b, i) >= 0;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2220c)) {
            return false;
        }
        C2220c c2220c = (C2220c) obj;
        if (!Arrays.equals(this.f5284b, c2220c.f5284b) || this.f5285c != c2220c.f5285c) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return this.f5285c + (Arrays.hashCode(this.f5284b) * 31);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AudioCapabilities[maxChannelCount=");
        stringBuilder.append(this.f5285c);
        stringBuilder.append(", supportedEncodings=");
        stringBuilder.append(Arrays.toString(this.f5284b));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
