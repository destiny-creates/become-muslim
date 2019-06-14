package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.C2868t;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import com.google.android.gms.internal.p208g.br;
import java.util.List;

@KeepName
public final class RawDataSet extends C4363a {
    public static final Creator<RawDataSet> CREATOR = new C2995j();
    /* renamed from: a */
    public final int f13460a;
    /* renamed from: b */
    public final List<RawDataPoint> f13461b;
    /* renamed from: c */
    public final boolean f13462c;

    public RawDataSet(int i, List<RawDataPoint> list, boolean z) {
        this.f13460a = i;
        this.f13461b = list;
        this.f13462c = z;
    }

    public RawDataSet(DataSet dataSet, List<C4801a> list) {
        this.f13461b = dataSet.m16984a((List) list);
        this.f13462c = dataSet.m16988d();
        this.f13460a = br.a(dataSet.m16983a(), list);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RawDataSet)) {
            return false;
        }
        RawDataSet rawDataSet = (RawDataSet) obj;
        return this.f13460a == rawDataSet.f13460a && this.f13462c == rawDataSet.f13462c && C2868t.m8374a(this.f13461b, rawDataSet.f13461b);
    }

    public final int hashCode() {
        return C2868t.m8372a(Integer.valueOf(this.f13460a));
    }

    public final String toString() {
        return String.format("RawDataSet{%s@[%s]}", new Object[]{Integer.valueOf(this.f13460a), this.f13461b});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.m8179a(parcel);
        C2835c.m8184a(parcel, 1, this.f13460a);
        C2835c.m8207c(parcel, 3, this.f13461b, false);
        C2835c.m8196a(parcel, 4, this.f13462c);
        C2835c.m8180a(parcel, i);
    }
}
