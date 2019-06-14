package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import com.facebook.common.time.Clock;
import com.google.android.gms.common.internal.C2868t;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

public final class aj extends C4363a {
    public static final Creator<aj> CREATOR = new ak();
    /* renamed from: a */
    private boolean f29174a;
    /* renamed from: b */
    private long f29175b;
    /* renamed from: c */
    private float f29176c;
    /* renamed from: d */
    private long f29177d;
    /* renamed from: e */
    private int f29178e;

    public aj() {
        this(true, 50, 0.0f, Clock.MAX_TIME, Integer.MAX_VALUE);
    }

    aj(boolean z, long j, float f, long j2, int i) {
        this.f29174a = z;
        this.f29175b = j;
        this.f29176c = f;
        this.f29177d = j2;
        this.f29178e = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof aj)) {
            return false;
        }
        aj ajVar = (aj) obj;
        return this.f29174a == ajVar.f29174a && this.f29175b == ajVar.f29175b && Float.compare(this.f29176c, ajVar.f29176c) == 0 && this.f29177d == ajVar.f29177d && this.f29178e == ajVar.f29178e;
    }

    public final int hashCode() {
        return C2868t.a(new Object[]{Boolean.valueOf(this.f29174a), Long.valueOf(this.f29175b), Float.valueOf(this.f29176c), Long.valueOf(this.f29177d), Integer.valueOf(this.f29178e)});
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DeviceOrientationRequest[mShouldUseMag=");
        stringBuilder.append(this.f29174a);
        stringBuilder.append(" mMinimumSamplingPeriodMs=");
        stringBuilder.append(this.f29175b);
        stringBuilder.append(" mSmallestAngleChangeRadians=");
        stringBuilder.append(this.f29176c);
        if (this.f29177d != Clock.MAX_TIME) {
            long elapsedRealtime = this.f29177d - SystemClock.elapsedRealtime();
            stringBuilder.append(" expireIn=");
            stringBuilder.append(elapsedRealtime);
            stringBuilder.append("ms");
        }
        if (this.f29178e != Integer.MAX_VALUE) {
            stringBuilder.append(" num=");
            stringBuilder.append(this.f29178e);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 1, this.f29174a);
        C2835c.a(parcel, 2, this.f29175b);
        C2835c.a(parcel, 3, this.f29176c);
        C2835c.a(parcel, 4, this.f29177d);
        C2835c.a(parcel, 5, this.f29178e);
        C2835c.a(parcel, i);
    }
}
