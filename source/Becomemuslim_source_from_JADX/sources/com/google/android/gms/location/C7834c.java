package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2868t;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import java.util.Comparator;

/* renamed from: com.google.android.gms.location.c */
public class C7834c extends C4363a {
    public static final Creator<C7834c> CREATOR = new ai();
    /* renamed from: a */
    private static final Comparator<C7834c> f29179a = new ah();
    /* renamed from: b */
    private static final int[] f29180b = new int[]{9, 10};
    /* renamed from: c */
    private static final int[] f29181c = new int[]{0, 1, 2, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14, 16, 17, 18, 19};
    /* renamed from: d */
    private static final int[] f29182d = new int[]{0, 1, 2, 3, 7, 8, 16, 17};
    /* renamed from: e */
    private int f29183e;
    /* renamed from: f */
    private int f29184f;

    public C7834c(int i, int i2) {
        this.f29183e = i;
        this.f29184f = i2;
    }

    /* renamed from: a */
    public int m38221a() {
        int i = this.f29183e;
        if (i <= 19) {
            if (i >= 0) {
                return i;
            }
        }
        return 4;
    }

    /* renamed from: b */
    public int m38222b() {
        return this.f29184f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                C7834c c7834c = (C7834c) obj;
                return this.f29183e == c7834c.f29183e && this.f29184f == c7834c.f29184f;
            }
        }
    }

    public int hashCode() {
        return C2868t.a(new Object[]{Integer.valueOf(this.f29183e), Integer.valueOf(this.f29184f)});
    }

    public String toString() {
        String str;
        int a = m38221a();
        switch (a) {
            case 0:
                str = "IN_VEHICLE";
                break;
            case 1:
                str = "ON_BICYCLE";
                break;
            case 2:
                str = "ON_FOOT";
                break;
            case 3:
                str = "STILL";
                break;
            case 4:
                str = "UNKNOWN";
                break;
            case 5:
                str = "TILTING";
                break;
            default:
                switch (a) {
                    case 7:
                        str = "WALKING";
                        break;
                    case 8:
                        str = "RUNNING";
                        break;
                    default:
                        switch (a) {
                            case 16:
                                str = "IN_ROAD_VEHICLE";
                                break;
                            case 17:
                                str = "IN_RAIL_VEHICLE";
                                break;
                            case 18:
                                str = "IN_TWO_WHEELER_VEHICLE";
                                break;
                            case 19:
                                str = "IN_FOUR_WHEELER_VEHICLE";
                                break;
                            default:
                                str = Integer.toString(a);
                                break;
                        }
                }
        }
        int i = this.f29184f;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 48);
        stringBuilder.append("DetectedActivity [type=");
        stringBuilder.append(str);
        stringBuilder.append(", confidence=");
        stringBuilder.append(i);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 1, this.f29183e);
        C2835c.a(parcel, 2, this.f29184f);
        C2835c.a(parcel, i);
    }
}
