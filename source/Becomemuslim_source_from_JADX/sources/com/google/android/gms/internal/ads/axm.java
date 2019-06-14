package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import java.util.Map;
import java.util.Map.Entry;

@cm
public final class axm extends C4363a {
    public static final Creator<axm> CREATOR = new axn();
    /* renamed from: a */
    private final String f28438a;
    /* renamed from: b */
    private final String[] f28439b;
    /* renamed from: c */
    private final String[] f28440c;

    axm(String str, String[] strArr, String[] strArr2) {
        this.f28438a = str;
        this.f28439b = strArr;
        this.f28440c = strArr2;
    }

    /* renamed from: a */
    public static axm m37188a(awi awi) {
        Map b = awi.mo6109b();
        int size = b.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i = 0;
        for (Entry entry : b.entrySet()) {
            strArr[i] = (String) entry.getKey();
            strArr2[i] = (String) entry.getValue();
            i++;
        }
        return new axm(awi.m19065e(), strArr, strArr2);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 1, this.f28438a, false);
        C2835c.a(parcel, 2, this.f28439b, false);
        C2835c.a(parcel, 3, this.f28440c, false);
        C2835c.a(parcel, i);
    }
}
