package com.google.android.exoplayer2.p134a;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.media.AudioAttributes.Builder;

/* compiled from: AudioAttributes */
/* renamed from: com.google.android.exoplayer2.a.b */
public final class C2219b {
    /* renamed from: a */
    public static final C2219b f5278a = new C2218a().m6114a();
    /* renamed from: b */
    public final int f5279b;
    /* renamed from: c */
    public final int f5280c;
    /* renamed from: d */
    public final int f5281d;
    /* renamed from: e */
    private AudioAttributes f5282e;

    /* compiled from: AudioAttributes */
    /* renamed from: com.google.android.exoplayer2.a.b$a */
    public static final class C2218a {
        /* renamed from: a */
        private int f5275a = 0;
        /* renamed from: b */
        private int f5276b = 0;
        /* renamed from: c */
        private int f5277c = 1;

        /* renamed from: a */
        public C2219b m6114a() {
            return new C2219b(this.f5275a, this.f5276b, this.f5277c);
        }
    }

    private C2219b(int i, int i2, int i3) {
        this.f5279b = i;
        this.f5280c = i2;
        this.f5281d = i3;
    }

    @TargetApi(21)
    /* renamed from: a */
    AudioAttributes m6115a() {
        if (this.f5282e == null) {
            this.f5282e = new Builder().setContentType(this.f5279b).setFlags(this.f5280c).setUsage(this.f5281d).build();
        }
        return this.f5282e;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                C2219b c2219b = (C2219b) obj;
                if (this.f5279b != c2219b.f5279b || this.f5280c != c2219b.f5280c || this.f5281d != c2219b.f5281d) {
                    z = false;
                }
                return z;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f5279b) * 31) + this.f5280c) * 31) + this.f5281d;
    }
}
