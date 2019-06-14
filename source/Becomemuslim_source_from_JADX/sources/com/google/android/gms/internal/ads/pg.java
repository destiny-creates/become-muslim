package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import java.util.concurrent.TimeUnit;

@TargetApi(14)
@cm
public final class pg {
    /* renamed from: a */
    private final long f15881a = TimeUnit.MILLISECONDS.toNanos(((Long) aph.m18688f().m18889a(asp.f14960x)).longValue());
    /* renamed from: b */
    private long f15882b;
    /* renamed from: c */
    private boolean f15883c = true;

    pg() {
    }

    /* renamed from: a */
    public final void m19998a() {
        this.f15883c = true;
    }

    /* renamed from: a */
    public final void m19999a(SurfaceTexture surfaceTexture, ow owVar) {
        if (owVar != null) {
            long timestamp = surfaceTexture.getTimestamp();
            if (this.f15883c || Math.abs(timestamp - this.f15882b) >= this.f15881a) {
                this.f15883c = false;
                this.f15882b = timestamp;
                jw.f15691a.post(new ph(this, owVar));
            }
        }
    }
}
