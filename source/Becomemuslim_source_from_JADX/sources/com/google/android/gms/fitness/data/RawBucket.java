package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.C2868t;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@KeepName
public final class RawBucket extends C4363a {
    public static final Creator<RawBucket> CREATOR = new ac();
    /* renamed from: a */
    public final long f13446a;
    /* renamed from: b */
    public final long f13447b;
    /* renamed from: c */
    public final C4804f f13448c;
    /* renamed from: d */
    public final int f13449d;
    /* renamed from: e */
    public final List<RawDataSet> f13450e;
    /* renamed from: f */
    public final int f13451f;
    /* renamed from: g */
    public final boolean f13452g;

    public RawBucket(long j, long j2, C4804f c4804f, int i, List<RawDataSet> list, int i2, boolean z) {
        this.f13446a = j;
        this.f13447b = j2;
        this.f13448c = c4804f;
        this.f13449d = i;
        this.f13450e = list;
        this.f13451f = i2;
        this.f13452g = z;
    }

    public RawBucket(Bucket bucket, List<C4801a> list) {
        this.f13446a = bucket.m16959a(TimeUnit.MILLISECONDS);
        this.f13447b = bucket.m16964b(TimeUnit.MILLISECONDS);
        this.f13448c = bucket.m16961a();
        this.f13449d = bucket.m16963b();
        this.f13451f = bucket.m16966d();
        this.f13452g = bucket.m16967e();
        List<DataSet> c = bucket.m16965c();
        this.f13450e = new ArrayList(c.size());
        for (DataSet rawDataSet : c) {
            this.f13450e.add(new RawDataSet(rawDataSet, list));
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RawBucket)) {
            return false;
        }
        RawBucket rawBucket = (RawBucket) obj;
        return this.f13446a == rawBucket.f13446a && this.f13447b == rawBucket.f13447b && this.f13449d == rawBucket.f13449d && C2868t.m8374a(this.f13450e, rawBucket.f13450e) && this.f13451f == rawBucket.f13451f && this.f13452g == rawBucket.f13452g;
    }

    public final int hashCode() {
        return C2868t.m8372a(Long.valueOf(this.f13446a), Long.valueOf(this.f13447b), Integer.valueOf(this.f13451f));
    }

    public final String toString() {
        return C2868t.m8373a((Object) this).m8371a("startTime", Long.valueOf(this.f13446a)).m8371a("endTime", Long.valueOf(this.f13447b)).m8371a("activity", Integer.valueOf(this.f13449d)).m8371a("dataSets", this.f13450e).m8371a("bucketType", Integer.valueOf(this.f13451f)).m8371a("serverHasMoreData", Boolean.valueOf(this.f13452g)).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.m8179a(parcel);
        C2835c.m8185a(parcel, 1, this.f13446a);
        C2835c.m8185a(parcel, 2, this.f13447b);
        C2835c.m8188a(parcel, 3, this.f13448c, i, false);
        C2835c.m8184a(parcel, 4, this.f13449d);
        C2835c.m8207c(parcel, 5, this.f13450e, false);
        C2835c.m8184a(parcel, 6, this.f13451f);
        C2835c.m8196a(parcel, 7, this.f13452g);
        C2835c.m8180a(parcel, a);
    }
}
