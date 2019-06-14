package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;

@TargetApi(14)
@cm
public final class pq implements OnAudioFocusChangeListener {
    /* renamed from: a */
    private final AudioManager f15921a;
    /* renamed from: b */
    private final ps f15922b;
    /* renamed from: c */
    private boolean f15923c;
    /* renamed from: d */
    private boolean f15924d;
    /* renamed from: e */
    private boolean f15925e;
    /* renamed from: f */
    private float f15926f = 1.0f;

    public pq(Context context, ps psVar) {
        this.f15921a = (AudioManager) context.getSystemService("audio");
        this.f15922b = psVar;
    }

    /* renamed from: d */
    private final void m20018d() {
        boolean z = false;
        Object obj = (!this.f15924d || this.f15925e || this.f15926f <= 0.0f) ? null : 1;
        if (obj == null || this.f15923c) {
            if (obj == null && this.f15923c) {
                if (this.f15921a != null) {
                    if (this.f15923c) {
                        if (this.f15921a.abandonAudioFocus(this) == 0) {
                            z = true;
                        }
                        this.f15923c = z;
                    }
                }
                this.f15922b.mo4324e();
            }
            return;
        }
        if (this.f15921a != null) {
            if (!this.f15923c) {
                if (this.f15921a.requestAudioFocus(this, 3, 2) == 1) {
                    z = true;
                }
                this.f15923c = z;
            }
        }
        this.f15922b.mo4324e();
    }

    /* renamed from: a */
    public final float m20019a() {
        return this.f15923c ? this.f15925e ? 0.0f : this.f15926f : 0.0f;
    }

    /* renamed from: a */
    public final void m20020a(float f) {
        this.f15926f = f;
        m20018d();
    }

    /* renamed from: a */
    public final void m20021a(boolean z) {
        this.f15925e = z;
        m20018d();
    }

    /* renamed from: b */
    public final void m20022b() {
        this.f15924d = true;
        m20018d();
    }

    /* renamed from: c */
    public final void m20023c() {
        this.f15924d = false;
        m20018d();
    }

    public final void onAudioFocusChange(int i) {
        this.f15923c = i > 0;
        this.f15922b.mo4324e();
    }
}
