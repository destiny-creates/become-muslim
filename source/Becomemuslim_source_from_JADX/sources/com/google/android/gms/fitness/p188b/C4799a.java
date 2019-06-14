package com.google.android.gms.fitness.p188b;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.api.C2814k;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C2868t;
import com.google.android.gms.common.internal.C2868t.C2867a;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.C4801a;
import com.google.android.gms.fitness.data.C4801a.C2989a;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.RawBucket;
import com.google.android.gms.fitness.data.RawDataSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.b.a */
public class C4799a extends C4363a implements C2814k {
    public static final Creator<C4799a> CREATOR = new C2984c();
    /* renamed from: a */
    private final List<DataSet> f13366a;
    /* renamed from: b */
    private final Status f13367b;
    /* renamed from: c */
    private final List<Bucket> f13368c;
    /* renamed from: d */
    private int f13369d;
    /* renamed from: e */
    private final List<C4801a> f13370e;

    C4799a(List<RawDataSet> list, Status status, List<RawBucket> list2, int i, List<C4801a> list3) {
        this.f13367b = status;
        this.f13369d = i;
        this.f13370e = list3;
        this.f13366a = new ArrayList(list.size());
        for (RawDataSet dataSet : list) {
            this.f13366a.add(new DataSet(dataSet, list3));
        }
        this.f13368c = new ArrayList(list2.size());
        for (RawBucket bucket : list2) {
            this.f13368c.add(new Bucket(bucket, list3));
        }
    }

    private C4799a(List<DataSet> list, List<Bucket> list2, Status status) {
        this.f13366a = list;
        this.f13367b = status;
        this.f13368c = list2;
        this.f13369d = 1;
        this.f13370e = new ArrayList();
    }

    /* renamed from: a */
    public static C4799a m16949a(Status status, List<DataType> list, List<C4801a> list2) {
        List arrayList = new ArrayList();
        for (C4801a a : list2) {
            arrayList.add(DataSet.m16980a(a));
        }
        for (DataType a2 : list) {
            arrayList.add(DataSet.m16980a(new C2989a().m8850a(a2).m8849a(1).m8851a("Default").m8852a()));
        }
        return new C4799a(arrayList, Collections.emptyList(), status);
    }

    /* renamed from: a */
    private static void m16950a(DataSet dataSet, List<DataSet> list) {
        for (DataSet dataSet2 : list) {
            if (dataSet2.m16983a().equals(dataSet.m16983a())) {
                dataSet2.m16985a(dataSet.m16987c());
                return;
            }
        }
        list.add(dataSet);
    }

    /* renamed from: a */
    public List<DataSet> m16951a() {
        return this.f13366a;
    }

    /* renamed from: a */
    public final void m16952a(C4799a c4799a) {
        for (DataSet a : c4799a.m16951a()) {
            C4799a.m16950a(a, this.f13366a);
        }
        for (Bucket bucket : c4799a.m16954c()) {
            for (Bucket bucket2 : this.f13368c) {
                if (bucket2.m16962a(bucket)) {
                    for (DataSet a2 : bucket.m16965c()) {
                        C4799a.m16950a(a2, bucket2.m16965c());
                    }
                }
            }
            this.f13368c.add(bucket);
        }
    }

    /* renamed from: b */
    public Status mo2360b() {
        return this.f13367b;
    }

    /* renamed from: c */
    public List<Bucket> m16954c() {
        return this.f13368c;
    }

    /* renamed from: d */
    public final int m16955d() {
        return this.f13369d;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof C4799a) {
                C4799a c4799a = (C4799a) obj;
                obj = (this.f13367b.equals(c4799a.f13367b) && C2868t.m8374a(this.f13366a, c4799a.f13366a) && C2868t.m8374a(this.f13368c, c4799a.f13368c)) ? 1 : null;
                if (obj != null) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return C2868t.m8372a(this.f13367b, this.f13366a, this.f13368c);
    }

    public String toString() {
        Object stringBuilder;
        C2867a a = C2868t.m8373a((Object) this).m8371a(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, this.f13367b);
        String str = "dataSets";
        if (this.f13366a.size() > 5) {
            int size = this.f13366a.size();
            StringBuilder stringBuilder2 = new StringBuilder(21);
            stringBuilder2.append(size);
            stringBuilder2.append(" data sets");
            stringBuilder = stringBuilder2.toString();
        } else {
            stringBuilder = this.f13366a;
        }
        a = a.m8371a(str, stringBuilder);
        str = "buckets";
        if (this.f13368c.size() > 5) {
            size = this.f13368c.size();
            StringBuilder stringBuilder3 = new StringBuilder(19);
            stringBuilder3.append(size);
            stringBuilder3.append(" buckets");
            stringBuilder = stringBuilder3.toString();
        } else {
            stringBuilder = this.f13368c;
        }
        return a.m8371a(str, stringBuilder).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.m8179a(parcel);
        List arrayList = new ArrayList(this.f13366a.size());
        for (DataSet rawDataSet : this.f13366a) {
            arrayList.add(new RawDataSet(rawDataSet, this.f13370e));
        }
        C2835c.m8208d(parcel, 1, arrayList, false);
        C2835c.m8188a(parcel, 2, mo2360b(), i, false);
        arrayList = new ArrayList(this.f13368c.size());
        for (Bucket rawBucket : this.f13368c) {
            arrayList.add(new RawBucket(rawBucket, this.f13370e));
        }
        C2835c.m8208d(parcel, 3, arrayList, false);
        C2835c.m8184a(parcel, 5, this.f13369d);
        C2835c.m8207c(parcel, 6, this.f13370e, false);
        C2835c.m8180a(parcel, a);
    }
}
