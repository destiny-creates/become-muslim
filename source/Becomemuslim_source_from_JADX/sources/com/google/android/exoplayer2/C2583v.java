package com.google.android.exoplayer2;

/* compiled from: RendererConfiguration */
/* renamed from: com.google.android.exoplayer2.v */
public final class C2583v {
    /* renamed from: a */
    public static final C2583v f6615a = new C2583v(0);
    /* renamed from: b */
    public final int f6616b;

    public C2583v(int i) {
        this.f6616b = i;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                if (this.f6616b != ((C2583v) obj).f6616b) {
                    z = false;
                }
                return z;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f6616b;
    }
}
