package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2868t;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class DataPoint extends C4363a implements ReflectedParcelable {
    public static final Creator<DataPoint> CREATOR = new C3002r();
    /* renamed from: a */
    private final C4801a f13380a;
    /* renamed from: b */
    private long f13381b;
    /* renamed from: c */
    private long f13382c;
    /* renamed from: d */
    private final C4806h[] f13383d;
    /* renamed from: e */
    private C4801a f13384e;
    /* renamed from: f */
    private long f13385f;
    /* renamed from: g */
    private long f13386g;

    public DataPoint(C4801a c4801a, long j, long j2, C4806h[] c4806hArr, C4801a c4801a2, long j3, long j4) {
        this.f13380a = c4801a;
        this.f13384e = c4801a2;
        this.f13381b = j;
        this.f13382c = j2;
        this.f13383d = c4806hArr;
        this.f13385f = j3;
        this.f13386g = j4;
    }

    private DataPoint(C4801a c4801a, C4801a c4801a2, RawDataPoint rawDataPoint) {
        this(c4801a, m16968a(Long.valueOf(rawDataPoint.m16995a()), 0), m16968a(Long.valueOf(rawDataPoint.m16996b()), 0), rawDataPoint.m16997c(), c4801a2, m16968a(Long.valueOf(rawDataPoint.m17000f()), 0), m16968a(Long.valueOf(rawDataPoint.m17001g()), 0));
    }

    DataPoint(List<C4801a> list, RawDataPoint rawDataPoint) {
        this(m16969a((List) list, rawDataPoint.m16998d()), m16969a((List) list, rawDataPoint.m16999e()), rawDataPoint);
    }

    /* renamed from: a */
    private static long m16968a(Long l, long j) {
        return l != null ? l.longValue() : 0;
    }

    /* renamed from: a */
    private static C4801a m16969a(List<C4801a> list, int i) {
        return (i < 0 || i >= list.size()) ? null : (C4801a) list.get(i);
    }

    /* renamed from: a */
    public final long m16970a(TimeUnit timeUnit) {
        return timeUnit.convert(this.f13381b, TimeUnit.NANOSECONDS);
    }

    /* renamed from: a */
    public final C4806h m16971a(C4803c c4803c) {
        return this.f13383d[m16974b().m16990a(c4803c)];
    }

    /* renamed from: a */
    public final C4806h[] m16972a() {
        return this.f13383d;
    }

    /* renamed from: b */
    public final long m16973b(TimeUnit timeUnit) {
        return timeUnit.convert(this.f13382c, TimeUnit.NANOSECONDS);
    }

    /* renamed from: b */
    public final DataType m16974b() {
        return this.f13380a.m17005a();
    }

    /* renamed from: c */
    public final C4801a m16975c() {
        return this.f13380a;
    }

    /* renamed from: d */
    public final C4801a m16976d() {
        return this.f13384e != null ? this.f13384e : this.f13380a;
    }

    /* renamed from: e */
    public final C4801a m16977e() {
        return this.f13384e;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DataPoint)) {
            return false;
        }
        DataPoint dataPoint = (DataPoint) obj;
        return C2868t.m8374a(this.f13380a, dataPoint.f13380a) && this.f13381b == dataPoint.f13381b && this.f13382c == dataPoint.f13382c && Arrays.equals(this.f13383d, dataPoint.f13383d) && C2868t.m8374a(m16976d(), dataPoint.m16976d());
    }

    /* renamed from: f */
    public final long m16978f() {
        return this.f13385f;
    }

    /* renamed from: g */
    public final long m16979g() {
        return this.f13386g;
    }

    public final int hashCode() {
        return C2868t.m8372a(this.f13380a, Long.valueOf(this.f13381b), Long.valueOf(this.f13382c));
    }

    public final String toString() {
        String str = "DataPoint{%s@[%s, %s,raw=%s,insert=%s](%s %s)}";
        Object[] objArr = new Object[7];
        objArr[0] = Arrays.toString(this.f13383d);
        objArr[1] = Long.valueOf(this.f13382c);
        objArr[2] = Long.valueOf(this.f13381b);
        objArr[3] = Long.valueOf(this.f13385f);
        objArr[4] = Long.valueOf(this.f13386g);
        objArr[5] = this.f13380a.m17011g();
        objArr[6] = this.f13384e != null ? this.f13384e.m17011g() : "N/A";
        return String.format(str, objArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.m8179a(parcel);
        C2835c.m8188a(parcel, 1, m16975c(), i, false);
        C2835c.m8185a(parcel, 3, this.f13381b);
        C2835c.m8185a(parcel, 4, this.f13382c);
        C2835c.m8200a(parcel, 5, this.f13383d, i, false);
        C2835c.m8188a(parcel, 6, this.f13384e, i, false);
        C2835c.m8185a(parcel, 7, this.f13385f);
        C2835c.m8185a(parcel, 8, this.f13386g);
        C2835c.m8180a(parcel, a);
    }
}
