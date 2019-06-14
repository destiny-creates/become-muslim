package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2868t;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Bucket extends C4363a implements ReflectedParcelable {
    public static final Creator<Bucket> CREATOR = new C3001q();
    /* renamed from: a */
    private final long f13373a;
    /* renamed from: b */
    private final long f13374b;
    /* renamed from: c */
    private final C4804f f13375c;
    /* renamed from: d */
    private final int f13376d;
    /* renamed from: e */
    private final List<DataSet> f13377e;
    /* renamed from: f */
    private final int f13378f;
    /* renamed from: g */
    private boolean f13379g;

    Bucket(long j, long j2, C4804f c4804f, int i, List<DataSet> list, int i2, boolean z) {
        this.f13379g = false;
        this.f13373a = j;
        this.f13374b = j2;
        this.f13375c = c4804f;
        this.f13376d = i;
        this.f13377e = list;
        this.f13378f = i2;
        this.f13379g = z;
    }

    public Bucket(RawBucket rawBucket, List<C4801a> list) {
        long j = rawBucket.f13446a;
        long j2 = rawBucket.f13447b;
        C4804f c4804f = rawBucket.f13448c;
        int i = rawBucket.f13449d;
        Collection<RawDataSet> collection = rawBucket.f13450e;
        List arrayList = new ArrayList(collection.size());
        for (RawDataSet dataSet : collection) {
            arrayList.add(new DataSet(dataSet, list));
        }
        this(j, j2, c4804f, i, arrayList, rawBucket.f13451f, rawBucket.f13452g);
    }

    /* renamed from: a */
    public static String m16958a(int i) {
        switch (i) {
            case 0:
                return "unknown";
            case 1:
                return "time";
            case 2:
                return "session";
            case 3:
                return "type";
            case 4:
                return "segment";
            default:
                return "bug";
        }
    }

    /* renamed from: a */
    public long m16959a(TimeUnit timeUnit) {
        return timeUnit.convert(this.f13373a, TimeUnit.MILLISECONDS);
    }

    /* renamed from: a */
    public DataSet m16960a(DataType dataType) {
        for (DataSet dataSet : this.f13377e) {
            if (dataSet.m16986b().equals(dataType)) {
                return dataSet;
            }
        }
        return null;
    }

    /* renamed from: a */
    public C4804f m16961a() {
        return this.f13375c;
    }

    /* renamed from: a */
    public final boolean m16962a(Bucket bucket) {
        return this.f13373a == bucket.f13373a && this.f13374b == bucket.f13374b && this.f13376d == bucket.f13376d && this.f13378f == bucket.f13378f;
    }

    /* renamed from: b */
    public final int m16963b() {
        return this.f13376d;
    }

    /* renamed from: b */
    public long m16964b(TimeUnit timeUnit) {
        return timeUnit.convert(this.f13374b, TimeUnit.MILLISECONDS);
    }

    /* renamed from: c */
    public List<DataSet> m16965c() {
        return this.f13377e;
    }

    /* renamed from: d */
    public int m16966d() {
        return this.f13378f;
    }

    /* renamed from: e */
    public final boolean m16967e() {
        if (this.f13379g) {
            return true;
        }
        for (DataSet d : this.f13377e) {
            if (d.m16988d()) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Bucket)) {
            return false;
        }
        Bucket bucket = (Bucket) obj;
        return this.f13373a == bucket.f13373a && this.f13374b == bucket.f13374b && this.f13376d == bucket.f13376d && C2868t.m8374a(this.f13377e, bucket.f13377e) && this.f13378f == bucket.f13378f && this.f13379g == bucket.f13379g;
    }

    public int hashCode() {
        return C2868t.m8372a(Long.valueOf(this.f13373a), Long.valueOf(this.f13374b), Integer.valueOf(this.f13376d), Integer.valueOf(this.f13378f));
    }

    public String toString() {
        return C2868t.m8373a((Object) this).m8371a("startTime", Long.valueOf(this.f13373a)).m8371a("endTime", Long.valueOf(this.f13374b)).m8371a("activity", Integer.valueOf(this.f13376d)).m8371a("dataSets", this.f13377e).m8371a("bucketType", m16958a(this.f13378f)).m8371a("serverHasMoreData", Boolean.valueOf(this.f13379g)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.m8179a(parcel);
        C2835c.m8185a(parcel, 1, this.f13373a);
        C2835c.m8185a(parcel, 2, this.f13374b);
        C2835c.m8188a(parcel, 3, m16961a(), i, false);
        C2835c.m8184a(parcel, 4, this.f13376d);
        C2835c.m8207c(parcel, 5, m16965c(), false);
        C2835c.m8184a(parcel, 6, m16966d());
        C2835c.m8196a(parcel, 7, m16967e());
        C2835c.m8180a(parcel, a);
    }
}
