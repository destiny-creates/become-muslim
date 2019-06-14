package com.google.android.gms.internal.p213l;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* renamed from: com.google.android.gms.internal.l.av */
public final class av extends gr implements at {
    av(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    /* renamed from: a */
    public final List<ft> mo4735a(C7826u c7826u, boolean z) {
        Parcel a = m21376a();
        gt.m21381a(a, (Parcelable) c7826u);
        gt.m21382a(a, z);
        Parcel a2 = m21377a(7, a);
        List createTypedArrayList = a2.createTypedArrayList(ft.CREATOR);
        a2.recycle();
        return createTypedArrayList;
    }

    /* renamed from: a */
    public final List<C7827y> mo4736a(String str, String str2, C7826u c7826u) {
        Parcel a = m21376a();
        a.writeString(str);
        a.writeString(str2);
        gt.m21381a(a, (Parcelable) c7826u);
        Parcel a2 = m21377a(16, a);
        List createTypedArrayList = a2.createTypedArrayList(C7827y.CREATOR);
        a2.recycle();
        return createTypedArrayList;
    }

    /* renamed from: a */
    public final List<C7827y> mo4737a(String str, String str2, String str3) {
        Parcel a = m21376a();
        a.writeString(str);
        a.writeString(str2);
        a.writeString(str3);
        Parcel a2 = m21377a(17, a);
        List createTypedArrayList = a2.createTypedArrayList(C7827y.CREATOR);
        a2.recycle();
        return createTypedArrayList;
    }

    /* renamed from: a */
    public final List<ft> mo4738a(String str, String str2, String str3, boolean z) {
        Parcel a = m21376a();
        a.writeString(str);
        a.writeString(str2);
        a.writeString(str3);
        gt.m21382a(a, z);
        Parcel a2 = m21377a(15, a);
        List createTypedArrayList = a2.createTypedArrayList(ft.CREATOR);
        a2.recycle();
        return createTypedArrayList;
    }

    /* renamed from: a */
    public final List<ft> mo4739a(String str, String str2, boolean z, C7826u c7826u) {
        Parcel a = m21376a();
        a.writeString(str);
        a.writeString(str2);
        gt.m21382a(a, z);
        gt.m21381a(a, (Parcelable) c7826u);
        Parcel a2 = m21377a(14, a);
        List createTypedArrayList = a2.createTypedArrayList(ft.CREATOR);
        a2.recycle();
        return createTypedArrayList;
    }

    /* renamed from: a */
    public final void mo4740a(long j, String str, String str2, String str3) {
        Parcel a = m21376a();
        a.writeLong(j);
        a.writeString(str);
        a.writeString(str2);
        a.writeString(str3);
        m21378b(10, a);
    }

    /* renamed from: a */
    public final void mo4741a(aq aqVar, C7826u c7826u) {
        Parcel a = m21376a();
        gt.m21381a(a, (Parcelable) aqVar);
        gt.m21381a(a, (Parcelable) c7826u);
        m21378b(1, a);
    }

    /* renamed from: a */
    public final void mo4742a(aq aqVar, String str, String str2) {
        Parcel a = m21376a();
        gt.m21381a(a, (Parcelable) aqVar);
        a.writeString(str);
        a.writeString(str2);
        m21378b(5, a);
    }

    /* renamed from: a */
    public final void mo4743a(ft ftVar, C7826u c7826u) {
        Parcel a = m21376a();
        gt.m21381a(a, (Parcelable) ftVar);
        gt.m21381a(a, (Parcelable) c7826u);
        m21378b(2, a);
    }

    /* renamed from: a */
    public final void mo4744a(C7826u c7826u) {
        Parcel a = m21376a();
        gt.m21381a(a, (Parcelable) c7826u);
        m21378b(4, a);
    }

    /* renamed from: a */
    public final void mo4745a(C7827y c7827y) {
        Parcel a = m21376a();
        gt.m21381a(a, (Parcelable) c7827y);
        m21378b(13, a);
    }

    /* renamed from: a */
    public final void mo4746a(C7827y c7827y, C7826u c7826u) {
        Parcel a = m21376a();
        gt.m21381a(a, (Parcelable) c7827y);
        gt.m21381a(a, (Parcelable) c7826u);
        m21378b(12, a);
    }

    /* renamed from: a */
    public final byte[] mo4747a(aq aqVar, String str) {
        Parcel a = m21376a();
        gt.m21381a(a, (Parcelable) aqVar);
        a.writeString(str);
        Parcel a2 = m21377a(9, a);
        byte[] createByteArray = a2.createByteArray();
        a2.recycle();
        return createByteArray;
    }

    /* renamed from: b */
    public final void mo4748b(C7826u c7826u) {
        Parcel a = m21376a();
        gt.m21381a(a, (Parcelable) c7826u);
        m21378b(6, a);
    }

    /* renamed from: c */
    public final String mo4749c(C7826u c7826u) {
        Parcel a = m21376a();
        gt.m21381a(a, (Parcelable) c7826u);
        Parcel a2 = m21377a(11, a);
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    /* renamed from: d */
    public final void mo4750d(C7826u c7826u) {
        Parcel a = m21376a();
        gt.m21381a(a, (Parcelable) c7826u);
        m21378b(18, a);
    }
}
