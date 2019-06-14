package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;

@cm
public final class ko {
    /* renamed from: a */
    private boolean f15704a = false;
    /* renamed from: b */
    private float f15705b = 1.0f;

    /* renamed from: a */
    public static float m19776a(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            return 0.0f;
        }
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        return streamMaxVolume == 0 ? 0.0f : ((float) audioManager.getStreamVolume(3)) / ((float) streamMaxVolume);
    }

    /* renamed from: c */
    private final synchronized boolean m19777c() {
        return this.f15705b >= 0.0f;
    }

    /* renamed from: a */
    public final synchronized float m19778a() {
        if (!m19777c()) {
            return 1.0f;
        }
        return this.f15705b;
    }

    /* renamed from: a */
    public final synchronized void m19779a(float f) {
        this.f15705b = f;
    }

    /* renamed from: a */
    public final synchronized void m19780a(boolean z) {
        this.f15704a = z;
    }

    /* renamed from: b */
    public final synchronized boolean m19781b() {
        return this.f15704a;
    }
}
