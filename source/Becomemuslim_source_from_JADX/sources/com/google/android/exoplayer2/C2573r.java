package com.google.android.exoplayer2;

/* compiled from: PlaybackParameters */
/* renamed from: com.google.android.exoplayer2.r */
public final class C2573r {
    /* renamed from: a */
    public static final C2573r f6571a = new C2573r(1.0f, 1.0f);
    /* renamed from: b */
    public final float f6572b;
    /* renamed from: c */
    public final float f6573c;
    /* renamed from: d */
    private final int f6574d;

    public C2573r(float f, float f2) {
        this.f6572b = f;
        this.f6573c = f2;
        this.f6574d = Math.round(f * 1000.0f);
    }

    /* renamed from: a */
    public long m7273a(long j) {
        return j * ((long) this.f6574d);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                C2573r c2573r = (C2573r) obj;
                if (this.f6572b != c2573r.f6572b || this.f6573c != c2573r.f6573c) {
                    z = false;
                }
                return z;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((527 + Float.floatToRawIntBits(this.f6572b)) * 31) + Float.floatToRawIntBits(this.f6573c);
    }
}
