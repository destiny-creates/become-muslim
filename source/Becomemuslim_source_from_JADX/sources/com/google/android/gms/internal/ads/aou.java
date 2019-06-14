package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.C2631d;
import com.google.android.gms.ads.C2696n;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

@cm
public class aou extends C4363a {
    public static final Creator<aou> CREATOR = new aov();
    /* renamed from: a */
    public final String f28279a;
    /* renamed from: b */
    public final int f28280b;
    /* renamed from: c */
    public final int f28281c;
    /* renamed from: d */
    public final boolean f28282d;
    /* renamed from: e */
    public final int f28283e;
    /* renamed from: f */
    public final int f28284f;
    /* renamed from: g */
    public final aou[] f28285g;
    /* renamed from: h */
    public final boolean f28286h;
    /* renamed from: i */
    public final boolean f28287i;
    /* renamed from: j */
    public boolean f28288j;

    public aou() {
        this("interstitial_mb", 0, 0, true, 0, 0, null, false, false, false);
    }

    public aou(Context context, C2631d c2631d) {
        this(context, new C2631d[]{c2631d});
    }

    public aou(Context context, C2631d[] c2631dArr) {
        int a;
        int i;
        int i2;
        String c2631d;
        int i3;
        C2631d c2631d2 = c2631dArr[0];
        this.f28282d = false;
        this.f28287i = c2631d2.c();
        if (this.f28287i) {
            this.f28283e = C2631d.f6669a.b();
            a = C2631d.f6669a.a();
        } else {
            this.f28283e = c2631d2.b();
            a = c2631d2.a();
        }
        this.f28280b = a;
        Object obj = this.f28283e == -1 ? 1 : null;
        Object obj2 = this.f28280b == -2 ? 1 : null;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (obj != null) {
            double d;
            aph.m18683a();
            if (mi.m19884g(context)) {
                aph.m18683a();
                if (mi.m19885h(context)) {
                    i = displayMetrics.widthPixels;
                    aph.m18683a();
                    i -= mi.m19886i(context);
                    this.f28284f = i;
                    d = (double) (((float) this.f28284f) / displayMetrics.density);
                    i2 = (int) d;
                    if (d - ((double) i2) >= 0.01d) {
                        i2++;
                    }
                }
            }
            i = displayMetrics.widthPixels;
            this.f28284f = i;
            d = (double) (((float) this.f28284f) / displayMetrics.density);
            i2 = (int) d;
            if (d - ((double) i2) >= 0.01d) {
                i2++;
            }
        } else {
            i2 = this.f28283e;
            aph.m18683a();
            this.f28284f = mi.m19865a(displayMetrics, this.f28283e);
        }
        i = obj2 != null ? m36927c(displayMetrics) : this.f28280b;
        aph.m18683a();
        this.f28281c = mi.m19865a(displayMetrics, i);
        if (obj == null) {
            if (obj2 == null) {
                c2631d = this.f28287i ? "320x50_mb" : c2631d2.toString();
                this.f28279a = c2631d;
                if (c2631dArr.length <= 1) {
                    this.f28285g = new aou[c2631dArr.length];
                    for (i3 = 0; i3 < c2631dArr.length; i3++) {
                        this.f28285g[i3] = new aou(context, c2631dArr[i3]);
                    }
                } else {
                    this.f28285g = null;
                }
                this.f28286h = false;
                this.f28288j = false;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(26);
        stringBuilder.append(i2);
        stringBuilder.append("x");
        stringBuilder.append(i);
        stringBuilder.append("_as");
        c2631d = stringBuilder.toString();
        this.f28279a = c2631d;
        if (c2631dArr.length <= 1) {
            this.f28285g = null;
        } else {
            this.f28285g = new aou[c2631dArr.length];
            for (i3 = 0; i3 < c2631dArr.length; i3++) {
                this.f28285g[i3] = new aou(context, c2631dArr[i3]);
            }
        }
        this.f28286h = false;
        this.f28288j = false;
    }

    public aou(aou aou, aou[] aouArr) {
        this(aou.f28279a, aou.f28280b, aou.f28281c, aou.f28282d, aou.f28283e, aou.f28284f, aouArr, aou.f28286h, aou.f28287i, aou.f28288j);
    }

    aou(String str, int i, int i2, boolean z, int i3, int i4, aou[] aouArr, boolean z2, boolean z3, boolean z4) {
        this.f28279a = str;
        this.f28280b = i;
        this.f28281c = i2;
        this.f28282d = z;
        this.f28283e = i3;
        this.f28284f = i4;
        this.f28285g = aouArr;
        this.f28286h = z2;
        this.f28287i = z3;
        this.f28288j = z4;
    }

    /* renamed from: a */
    public static int m36923a(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    /* renamed from: a */
    public static aou m36924a() {
        return new aou("reward_mb", 0, 0, true, 0, 0, null, false, false, false);
    }

    /* renamed from: a */
    public static aou m36925a(Context context) {
        return new aou("320x50_mb", 0, 0, false, 0, 0, null, true, false, false);
    }

    /* renamed from: b */
    public static int m36926b(DisplayMetrics displayMetrics) {
        return (int) (((float) m36927c(displayMetrics)) * displayMetrics.density);
    }

    /* renamed from: c */
    private static int m36927c(DisplayMetrics displayMetrics) {
        int i = (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
        return i <= 400 ? 32 : i <= 720 ? 50 : 90;
    }

    /* renamed from: b */
    public final C2631d m36928b() {
        return C2696n.a(this.f28283e, this.f28280b, this.f28279a);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f28279a, false);
        C2835c.a(parcel, 3, this.f28280b);
        C2835c.a(parcel, 4, this.f28281c);
        C2835c.a(parcel, 5, this.f28282d);
        C2835c.a(parcel, 6, this.f28283e);
        C2835c.a(parcel, 7, this.f28284f);
        C2835c.a(parcel, 8, this.f28285g, i, false);
        C2835c.a(parcel, 9, this.f28286h);
        C2835c.a(parcel, 10, this.f28287i);
        C2835c.a(parcel, 11, this.f28288j);
        C2835c.a(parcel, a);
    }
}
