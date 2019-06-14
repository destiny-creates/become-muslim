package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2868t;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public final class DataSet extends C4363a implements ReflectedParcelable {
    public static final Creator<DataSet> CREATOR = new C3003s();
    /* renamed from: a */
    private final int f13387a;
    /* renamed from: b */
    private final C4801a f13388b;
    /* renamed from: c */
    private final List<DataPoint> f13389c;
    /* renamed from: d */
    private final List<C4801a> f13390d;
    /* renamed from: e */
    private boolean f13391e;

    DataSet(int i, C4801a c4801a, List<RawDataPoint> list, List<C4801a> list2, boolean z) {
        List singletonList;
        this.f13391e = false;
        this.f13387a = i;
        this.f13388b = c4801a;
        this.f13391e = z;
        this.f13389c = new ArrayList(list.size());
        if (i < 2) {
            singletonList = Collections.singletonList(c4801a);
        }
        this.f13390d = singletonList;
        for (RawDataPoint dataPoint : list) {
            this.f13389c.add(new DataPoint(this.f13390d, dataPoint));
        }
    }

    public DataSet(RawDataSet rawDataSet, List<C4801a> list) {
        this.f13391e = false;
        this.f13387a = 3;
        this.f13388b = (C4801a) list.get(rawDataSet.f13460a);
        this.f13390d = list;
        this.f13391e = rawDataSet.f13462c;
        List<RawDataPoint> list2 = rawDataSet.f13461b;
        this.f13389c = new ArrayList(list2.size());
        for (RawDataPoint dataPoint : list2) {
            this.f13389c.add(new DataPoint(this.f13390d, dataPoint));
        }
    }

    private DataSet(C4801a c4801a) {
        this.f13391e = false;
        this.f13387a = 3;
        this.f13388b = (C4801a) C2872v.m8380a((Object) c4801a);
        this.f13389c = new ArrayList();
        this.f13390d = new ArrayList();
        this.f13390d.add(this.f13388b);
    }

    /* renamed from: a */
    public static DataSet m16980a(C4801a c4801a) {
        C2872v.m8381a((Object) c4801a, (Object) "DataSource should be specified");
        return new DataSet(c4801a);
    }

    /* renamed from: a */
    private final void m16981a(DataPoint dataPoint) {
        this.f13389c.add(dataPoint);
        C4801a d = dataPoint.m16976d();
        if (d != null && !this.f13390d.contains(d)) {
            this.f13390d.add(d);
        }
    }

    /* renamed from: e */
    private final List<RawDataPoint> m16982e() {
        return m16984a(this.f13390d);
    }

    /* renamed from: a */
    public final C4801a m16983a() {
        return this.f13388b;
    }

    /* renamed from: a */
    final List<RawDataPoint> m16984a(List<C4801a> list) {
        List<RawDataPoint> arrayList = new ArrayList(this.f13389c.size());
        for (DataPoint rawDataPoint : this.f13389c) {
            arrayList.add(new RawDataPoint(rawDataPoint, list));
        }
        return arrayList;
    }

    /* renamed from: a */
    public final void m16985a(Iterable<DataPoint> iterable) {
        for (DataPoint a : iterable) {
            m16981a(a);
        }
    }

    /* renamed from: b */
    public final DataType m16986b() {
        return this.f13388b.m17005a();
    }

    /* renamed from: c */
    public final List<DataPoint> m16987c() {
        return Collections.unmodifiableList(this.f13389c);
    }

    /* renamed from: d */
    public final boolean m16988d() {
        return this.f13391e;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DataSet)) {
            return false;
        }
        DataSet dataSet = (DataSet) obj;
        return C2868t.m8374a(this.f13388b, dataSet.f13388b) && C2868t.m8374a(this.f13389c, dataSet.f13389c) && this.f13391e == dataSet.f13391e;
    }

    public final int hashCode() {
        return C2868t.m8372a(this.f13388b);
    }

    public final String toString() {
        List e = m16982e();
        Locale locale = Locale.US;
        String str = "DataSet{%s %s}";
        Object[] objArr = new Object[2];
        objArr[0] = this.f13388b.m17011g();
        if (this.f13389c.size() >= 10) {
            e = String.format(Locale.US, "%d data points, first 5: %s", new Object[]{Integer.valueOf(this.f13389c.size()), e.subList(0, 5)});
        }
        objArr[1] = e;
        return String.format(locale, str, objArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.m8179a(parcel);
        C2835c.m8188a(parcel, 1, m16983a(), i, false);
        C2835c.m8208d(parcel, 3, m16982e(), false);
        C2835c.m8207c(parcel, 4, this.f13390d, false);
        C2835c.m8196a(parcel, 5, this.f13391e);
        C2835c.m8184a(parcel, 1000, this.f13387a);
        C2835c.m8180a(parcel, a);
    }
}
