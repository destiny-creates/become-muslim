package com.google.android.gms.internal.ads;

public final class ame implements ac {
    /* renamed from: a */
    private int f23721a;
    /* renamed from: b */
    private int f23722b;
    /* renamed from: c */
    private final int f23723c;
    /* renamed from: d */
    private final float f23724d;

    public ame() {
        this(2500, 1, 1.0f);
    }

    private ame(int i, int i2, float f) {
        this.f23721a = 2500;
        this.f23723c = 1;
        this.f23724d = 1.0f;
    }

    /* renamed from: a */
    public final int mo3843a() {
        return this.f23721a;
    }

    /* renamed from: a */
    public final void mo3844a(df dfVar) {
        int i = 1;
        this.f23722b++;
        this.f23721a = (int) (((float) this.f23721a) + (((float) this.f23721a) * this.f23724d));
        if (this.f23722b > this.f23723c) {
            i = 0;
        }
        if (i == 0) {
            throw dfVar;
        }
    }

    /* renamed from: b */
    public final int mo3845b() {
        return this.f23722b;
    }
}
