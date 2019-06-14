package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2868t;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

public final class Status extends C4363a implements C2814k, ReflectedParcelable {
    public static final Creator<Status> CREATOR = new C2822t();
    /* renamed from: a */
    public static final Status f13151a = new Status(0);
    /* renamed from: b */
    public static final Status f13152b = new Status(14);
    /* renamed from: c */
    public static final Status f13153c = new Status(8);
    /* renamed from: d */
    public static final Status f13154d = new Status(15);
    /* renamed from: e */
    public static final Status f13155e = new Status(16);
    /* renamed from: f */
    public static final Status f13156f = new Status(18);
    /* renamed from: g */
    private static final Status f13157g = new Status(17);
    /* renamed from: h */
    private final int f13158h;
    /* renamed from: i */
    private final int f13159i;
    /* renamed from: j */
    private final String f13160j;
    /* renamed from: k */
    private final PendingIntent f13161k;

    Status(int i, int i2, String str, PendingIntent pendingIntent) {
        this.f13158h = i;
        this.f13159i = i2;
        this.f13160j = str;
        this.f13161k = pendingIntent;
    }

    /* renamed from: b */
    public final Status mo2360b() {
        return this;
    }

    public Status(int i) {
        this(i, null);
    }

    public Status(int i, String str) {
        this(1, i, str, null);
    }

    public Status(int i, String str, PendingIntent pendingIntent) {
        this(1, i, str, pendingIntent);
    }

    /* renamed from: a */
    public final void m16702a(Activity activity, int i) {
        if (m16704c()) {
            activity.startIntentSenderForResult(this.f13161k.getIntentSender(), i, null, 0, 0, 0);
        }
    }

    /* renamed from: a */
    public final String m16701a() {
        return this.f13160j;
    }

    /* renamed from: c */
    public final boolean m16704c() {
        return this.f13161k != null;
    }

    /* renamed from: d */
    public final boolean m16705d() {
        return this.f13159i <= 0;
    }

    /* renamed from: e */
    public final int m16706e() {
        return this.f13159i;
    }

    public final int hashCode() {
        return C2868t.m8372a(Integer.valueOf(this.f13158h), Integer.valueOf(this.f13159i), this.f13160j, this.f13161k);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        if (this.f13158h == status.f13158h && this.f13159i == status.f13159i && C2868t.m8374a(this.f13160j, status.f13160j) && C2868t.m8374a(this.f13161k, status.f13161k) != null) {
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public final String m16707f() {
        if (this.f13160j != null) {
            return this.f13160j;
        }
        return C2784d.m7938b(this.f13159i);
    }

    public final String toString() {
        return C2868t.m8373a((Object) this).m8371a("statusCode", m16707f()).m8371a("resolution", this.f13161k).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.m8179a(parcel);
        C2835c.m8184a(parcel, 1, m16706e());
        C2835c.m8193a(parcel, 2, m16701a(), false);
        C2835c.m8188a(parcel, 3, this.f13161k, i, false);
        C2835c.m8184a(parcel, 1000, this.f13158h);
        C2835c.m8180a(parcel, a);
    }
}
