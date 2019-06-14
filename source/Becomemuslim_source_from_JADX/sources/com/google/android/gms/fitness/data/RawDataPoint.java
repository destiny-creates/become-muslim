package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.C2868t;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import com.google.android.gms.internal.p208g.br;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

@KeepName
public final class RawDataPoint extends C4363a {
    public static final Creator<RawDataPoint> CREATOR = new ad();
    /* renamed from: a */
    private final long f13453a;
    /* renamed from: b */
    private final long f13454b;
    /* renamed from: c */
    private final C4806h[] f13455c;
    /* renamed from: d */
    private final int f13456d;
    /* renamed from: e */
    private final int f13457e;
    /* renamed from: f */
    private final long f13458f;
    /* renamed from: g */
    private final long f13459g;

    public RawDataPoint(long j, long j2, C4806h[] c4806hArr, int i, int i2, long j3, long j4) {
        this.f13453a = j;
        this.f13454b = j2;
        this.f13456d = i;
        this.f13457e = i2;
        this.f13458f = j3;
        this.f13459g = j4;
        this.f13455c = c4806hArr;
    }

    RawDataPoint(DataPoint dataPoint, List<C4801a> list) {
        this.f13453a = dataPoint.m16970a(TimeUnit.NANOSECONDS);
        this.f13454b = dataPoint.m16973b(TimeUnit.NANOSECONDS);
        this.f13455c = dataPoint.m16972a();
        this.f13456d = br.a(dataPoint.m16975c(), list);
        this.f13457e = br.a(dataPoint.m16977e(), list);
        this.f13458f = dataPoint.m16978f();
        this.f13459g = dataPoint.m16979g();
    }

    /* renamed from: a */
    public final long m16995a() {
        return this.f13453a;
    }

    /* renamed from: b */
    public final long m16996b() {
        return this.f13454b;
    }

    /* renamed from: c */
    public final C4806h[] m16997c() {
        return this.f13455c;
    }

    /* renamed from: d */
    public final int m16998d() {
        return this.f13456d;
    }

    /* renamed from: e */
    public final int m16999e() {
        return this.f13457e;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RawDataPoint)) {
            return false;
        }
        RawDataPoint rawDataPoint = (RawDataPoint) obj;
        return this.f13453a == rawDataPoint.f13453a && this.f13454b == rawDataPoint.f13454b && Arrays.equals(this.f13455c, rawDataPoint.f13455c) && this.f13456d == rawDataPoint.f13456d && this.f13457e == rawDataPoint.f13457e && this.f13458f == rawDataPoint.f13458f;
    }

    /* renamed from: f */
    public final long m17000f() {
        return this.f13458f;
    }

    /* renamed from: g */
    public final long m17001g() {
        return this.f13459g;
    }

    public final int hashCode() {
        return C2868t.m8372a(Long.valueOf(this.f13453a), Long.valueOf(this.f13454b));
    }

    public final String toString() {
        return String.format(Locale.US, "RawDataPoint{%s@[%s, %s](%d,%d)}", new Object[]{Arrays.toString(this.f13455c), Long.valueOf(this.f13454b), Long.valueOf(this.f13453a), Integer.valueOf(this.f13456d), Integer.valueOf(this.f13457e)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.m8179a(parcel);
        C2835c.m8185a(parcel, 1, this.f13453a);
        C2835c.m8185a(parcel, 2, this.f13454b);
        C2835c.m8200a(parcel, 3, this.f13455c, i, false);
        C2835c.m8184a(parcel, 4, this.f13456d);
        C2835c.m8184a(parcel, 5, this.f13457e);
        C2835c.m8185a(parcel, 6, this.f13458f);
        C2835c.m8185a(parcel, 7, this.f13459g);
        C2835c.m8180a(parcel, a);
    }
}
