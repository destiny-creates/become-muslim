package com.google.android.gms.ads;

import android.content.Context;
import com.facebook.login.widget.ProfilePictureView;
import com.google.android.gms.internal.ads.aou;
import com.google.android.gms.internal.ads.aph;
import com.google.android.gms.internal.ads.mi;

/* renamed from: com.google.android.gms.ads.d */
public final class C2631d {
    /* renamed from: a */
    public static final C2631d f6669a = new C2631d(320, 50, "320x50_mb");
    /* renamed from: b */
    public static final C2631d f6670b = new C2631d(468, 60, "468x60_as");
    /* renamed from: c */
    public static final C2631d f6671c = new C2631d(320, 100, "320x100_as");
    /* renamed from: d */
    public static final C2631d f6672d = new C2631d(728, 90, "728x90_as");
    /* renamed from: e */
    public static final C2631d f6673e = new C2631d(300, 250, "300x250_as");
    /* renamed from: f */
    public static final C2631d f6674f = new C2631d(160, 600, "160x600_as");
    /* renamed from: g */
    public static final C2631d f6675g = new C2631d(-1, -2, "smart_banner");
    /* renamed from: h */
    public static final C2631d f6676h = new C2631d(-3, -4, "fluid");
    /* renamed from: i */
    public static final C2631d f6677i = new C2631d(50, 50, "50x50_mb");
    /* renamed from: j */
    public static final C2631d f6678j = new C2631d(-3, 0, "search_v2");
    /* renamed from: k */
    private final int f6679k;
    /* renamed from: l */
    private final int f6680l;
    /* renamed from: m */
    private final String f6681m;

    public C2631d(int i, int i2) {
        String valueOf = i == -1 ? "FULL" : String.valueOf(i);
        String valueOf2 = i2 == -2 ? "AUTO" : String.valueOf(i2);
        StringBuilder stringBuilder = new StringBuilder((String.valueOf(valueOf).length() + 4) + String.valueOf(valueOf2).length());
        stringBuilder.append(valueOf);
        stringBuilder.append("x");
        stringBuilder.append(valueOf2);
        stringBuilder.append("_as");
        this(i, i2, stringBuilder.toString());
    }

    C2631d(int i, int i2, String str) {
        if (i < 0 && i != -1) {
            if (i != -3) {
                StringBuilder stringBuilder = new StringBuilder(37);
                stringBuilder.append("Invalid width for AdSize: ");
                stringBuilder.append(i);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        if (i2 < 0 && i2 != -2) {
            if (i2 != -4) {
                stringBuilder = new StringBuilder(38);
                stringBuilder.append("Invalid height for AdSize: ");
                stringBuilder.append(i2);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        this.f6679k = i;
        this.f6680l = i2;
        this.f6681m = str;
    }

    /* renamed from: a */
    public final int m7410a() {
        return this.f6680l;
    }

    /* renamed from: a */
    public final int m7411a(Context context) {
        switch (this.f6680l) {
            case ProfilePictureView.LARGE /*-4*/:
            case ProfilePictureView.NORMAL /*-3*/:
                return -1;
            case -2:
                return aou.b(context.getResources().getDisplayMetrics());
            default:
                aph.a();
                return mi.a(context, this.f6680l);
        }
    }

    /* renamed from: b */
    public final int m7412b() {
        return this.f6679k;
    }

    /* renamed from: b */
    public final int m7413b(Context context) {
        int i = this.f6679k;
        if (i == -1) {
            return aou.a(context.getResources().getDisplayMetrics());
        }
        switch (i) {
            case ProfilePictureView.LARGE /*-4*/:
            case ProfilePictureView.NORMAL /*-3*/:
                return -1;
            default:
                aph.a();
                return mi.a(context, this.f6679k);
        }
    }

    /* renamed from: c */
    public final boolean m7414c() {
        return this.f6679k == -3 && this.f6680l == -4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2631d)) {
            return false;
        }
        C2631d c2631d = (C2631d) obj;
        return this.f6679k == c2631d.f6679k && this.f6680l == c2631d.f6680l && this.f6681m.equals(c2631d.f6681m);
    }

    public final int hashCode() {
        return this.f6681m.hashCode();
    }

    public final String toString() {
        return this.f6681m;
    }
}
