package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import com.facebook.common.time.Clock;
import com.google.android.gms.common.internal.C2868t;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

public final class LocationRequest extends C4363a implements ReflectedParcelable {
    public static final Creator<LocationRequest> CREATOR = new C5087u();
    /* renamed from: a */
    private int f29157a;
    /* renamed from: b */
    private long f29158b;
    /* renamed from: c */
    private long f29159c;
    /* renamed from: d */
    private boolean f29160d;
    /* renamed from: e */
    private long f29161e;
    /* renamed from: f */
    private int f29162f;
    /* renamed from: g */
    private float f29163g;
    /* renamed from: h */
    private long f29164h;

    public LocationRequest() {
        this.f29157a = 102;
        this.f29158b = 3600000;
        this.f29159c = 600000;
        this.f29160d = false;
        this.f29161e = Clock.MAX_TIME;
        this.f29162f = Integer.MAX_VALUE;
        this.f29163g = 0.0f;
        this.f29164h = 0;
    }

    LocationRequest(int i, long j, long j2, boolean z, long j3, int i2, float f, long j4) {
        this.f29157a = i;
        this.f29158b = j;
        this.f29159c = j2;
        this.f29160d = z;
        this.f29161e = j3;
        this.f29162f = i2;
        this.f29163g = f;
        this.f29164h = j4;
    }

    /* renamed from: a */
    public static LocationRequest m38207a() {
        return new LocationRequest();
    }

    /* renamed from: d */
    private static void m38208d(long j) {
        if (j < 0) {
            StringBuilder stringBuilder = new StringBuilder(38);
            stringBuilder.append("invalid interval: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    public final LocationRequest m38209a(float f) {
        if (f >= 0.0f) {
            this.f29163g = f;
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder(37);
        stringBuilder.append("invalid displacement: ");
        stringBuilder.append(f);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public final LocationRequest m38210a(int i) {
        switch (i) {
            case 100:
            case 102:
            case 104:
            case 105:
                this.f29157a = i;
                return this;
            default:
                StringBuilder stringBuilder = new StringBuilder(28);
                stringBuilder.append("invalid quality: ");
                stringBuilder.append(i);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    public final LocationRequest m38211a(long j) {
        m38208d(j);
        this.f29158b = j;
        if (!this.f29160d) {
            this.f29159c = (long) (((double) this.f29158b) / 6.0d);
        }
        return this;
    }

    /* renamed from: b */
    public final long m38212b() {
        long j = this.f29164h;
        return j < this.f29158b ? this.f29158b : j;
    }

    /* renamed from: b */
    public final LocationRequest m38213b(int i) {
        if (i > 0) {
            this.f29162f = i;
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder(31);
        stringBuilder.append("invalid numUpdates: ");
        stringBuilder.append(i);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: b */
    public final LocationRequest m38214b(long j) {
        m38208d(j);
        this.f29164h = j;
        return this;
    }

    /* renamed from: c */
    public final LocationRequest m38215c(long j) {
        m38208d(j);
        this.f29160d = true;
        this.f29159c = j;
        return this;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationRequest)) {
            return false;
        }
        LocationRequest locationRequest = (LocationRequest) obj;
        return this.f29157a == locationRequest.f29157a && this.f29158b == locationRequest.f29158b && this.f29159c == locationRequest.f29159c && this.f29160d == locationRequest.f29160d && this.f29161e == locationRequest.f29161e && this.f29162f == locationRequest.f29162f && this.f29163g == locationRequest.f29163g && m38212b() == locationRequest.m38212b();
    }

    public final int hashCode() {
        return C2868t.a(new Object[]{Integer.valueOf(this.f29157a), Long.valueOf(this.f29158b), Float.valueOf(this.f29163g), Long.valueOf(this.f29164h)});
    }

    public final String toString() {
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Request[");
        switch (this.f29157a) {
            case 100:
                str = "PRIORITY_HIGH_ACCURACY";
                break;
            case 102:
                str = "PRIORITY_BALANCED_POWER_ACCURACY";
                break;
            case 104:
                str = "PRIORITY_LOW_POWER";
                break;
            case 105:
                str = "PRIORITY_NO_POWER";
                break;
            default:
                str = "???";
                break;
        }
        stringBuilder.append(str);
        if (this.f29157a != 105) {
            stringBuilder.append(" requested=");
            stringBuilder.append(this.f29158b);
            stringBuilder.append("ms");
        }
        stringBuilder.append(" fastest=");
        stringBuilder.append(this.f29159c);
        stringBuilder.append("ms");
        if (this.f29164h > this.f29158b) {
            stringBuilder.append(" maxWait=");
            stringBuilder.append(this.f29164h);
            stringBuilder.append("ms");
        }
        if (this.f29163g > 0.0f) {
            stringBuilder.append(" smallestDisplacement=");
            stringBuilder.append(this.f29163g);
            stringBuilder.append("m");
        }
        if (this.f29161e != Clock.MAX_TIME) {
            long elapsedRealtime = this.f29161e - SystemClock.elapsedRealtime();
            stringBuilder.append(" expireIn=");
            stringBuilder.append(elapsedRealtime);
            stringBuilder.append("ms");
        }
        if (this.f29162f != Integer.MAX_VALUE) {
            stringBuilder.append(" num=");
            stringBuilder.append(this.f29162f);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 1, this.f29157a);
        C2835c.a(parcel, 2, this.f29158b);
        C2835c.a(parcel, 3, this.f29159c);
        C2835c.a(parcel, 4, this.f29160d);
        C2835c.a(parcel, 5, this.f29161e);
        C2835c.a(parcel, 6, this.f29162f);
        C2835c.a(parcel, 7, this.f29163g);
        C2835c.a(parcel, 8, this.f29164h);
        C2835c.a(parcel, i);
    }
}
