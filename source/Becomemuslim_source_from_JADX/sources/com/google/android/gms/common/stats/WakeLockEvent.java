package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.p181a.C2835c;
import java.util.List;

public final class WakeLockEvent extends StatsEvent {
    public static final Creator<WakeLockEvent> CREATOR = new C2886e();
    /* renamed from: a */
    private final int f13989a;
    /* renamed from: b */
    private final long f13990b;
    /* renamed from: c */
    private int f13991c;
    /* renamed from: d */
    private final String f13992d;
    /* renamed from: e */
    private final String f13993e;
    /* renamed from: f */
    private final String f13994f;
    /* renamed from: g */
    private final int f13995g;
    /* renamed from: h */
    private final List<String> f13996h;
    /* renamed from: i */
    private final String f13997i;
    /* renamed from: j */
    private final long f13998j;
    /* renamed from: k */
    private int f13999k;
    /* renamed from: l */
    private final String f14000l;
    /* renamed from: m */
    private final float f14001m;
    /* renamed from: n */
    private final long f14002n;
    /* renamed from: o */
    private long f14003o;

    WakeLockEvent(int i, long j, int i2, String str, int i3, List<String> list, String str2, long j2, int i4, String str3, String str4, float f, long j3, String str5) {
        this.f13989a = i;
        this.f13990b = j;
        this.f13991c = i2;
        this.f13992d = str;
        this.f13993e = str3;
        this.f13994f = str5;
        this.f13995g = i3;
        this.f14003o = -1;
        this.f13996h = list;
        this.f13997i = str2;
        this.f13998j = j2;
        this.f13999k = i4;
        this.f14000l = str4;
        this.f14001m = f;
        this.f14002n = j3;
    }

    public WakeLockEvent(long j, int i, String str, int i2, List<String> list, String str2, long j2, int i3, String str3, String str4, float f, long j3, String str5) {
        this(2, j, i, str, i2, list, str2, j2, i3, str3, str4, f, j3, str5);
    }

    /* renamed from: a */
    public final long mo3463a() {
        return this.f13990b;
    }

    /* renamed from: b */
    public final int mo3464b() {
        return this.f13991c;
    }

    /* renamed from: c */
    public final long mo3465c() {
        return this.f14003o;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.m8179a(parcel);
        C2835c.m8184a(parcel, 1, this.f13989a);
        C2835c.m8185a(parcel, 2, mo3463a());
        C2835c.m8193a(parcel, 4, this.f13992d, false);
        C2835c.m8184a(parcel, 5, this.f13995g);
        C2835c.m8205b(parcel, 6, this.f13996h, false);
        C2835c.m8185a(parcel, 8, this.f13998j);
        C2835c.m8193a(parcel, 10, this.f13993e, false);
        C2835c.m8184a(parcel, 11, mo3464b());
        C2835c.m8193a(parcel, 12, this.f13997i, false);
        C2835c.m8193a(parcel, 13, this.f14000l, false);
        C2835c.m8184a(parcel, 14, this.f13999k);
        C2835c.m8183a(parcel, 15, this.f14001m);
        C2835c.m8185a(parcel, 16, this.f14002n);
        C2835c.m8193a(parcel, 17, this.f13994f, false);
        C2835c.m8180a(parcel, i);
    }

    /* renamed from: d */
    public final String mo3466d() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = this.f13992d;
        int i = this.f13995g;
        if (this.f13996h == null) {
            str = "";
        } else {
            str = TextUtils.join(",", this.f13996h);
        }
        int i2 = this.f13999k;
        if (this.f13993e == null) {
            str2 = "";
        } else {
            str2 = this.f13993e;
        }
        if (this.f14000l == null) {
            str3 = "";
        } else {
            str3 = this.f14000l;
        }
        float f = this.f14001m;
        if (this.f13994f == null) {
            str4 = "";
        } else {
            str4 = this.f13994f;
        }
        StringBuilder stringBuilder = new StringBuilder(((((String.valueOf(str5).length() + 45) + String.valueOf(str).length()) + String.valueOf(str2).length()) + String.valueOf(str3).length()) + String.valueOf(str4).length());
        stringBuilder.append("\t");
        stringBuilder.append(str5);
        stringBuilder.append("\t");
        stringBuilder.append(i);
        stringBuilder.append("\t");
        stringBuilder.append(str);
        stringBuilder.append("\t");
        stringBuilder.append(i2);
        stringBuilder.append("\t");
        stringBuilder.append(str2);
        stringBuilder.append("\t");
        stringBuilder.append(str3);
        stringBuilder.append("\t");
        stringBuilder.append(f);
        stringBuilder.append("\t");
        stringBuilder.append(str4);
        return stringBuilder.toString();
    }
}
