package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import com.google.android.gms.common.util.C2892b;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

@KeepName
public class CommonWalletObject extends C4363a {
    public static final Creator<CommonWalletObject> CREATOR = new C5170k();
    /* renamed from: a */
    String f29439a;
    /* renamed from: b */
    String f29440b;
    /* renamed from: c */
    String f29441c;
    /* renamed from: d */
    String f29442d;
    /* renamed from: e */
    String f29443e;
    /* renamed from: f */
    String f29444f;
    /* renamed from: g */
    String f29445g;
    /* renamed from: h */
    String f29446h;
    /* renamed from: i */
    int f29447i;
    /* renamed from: j */
    ArrayList<C7892h> f29448j;
    /* renamed from: k */
    C7890f f29449k;
    /* renamed from: l */
    ArrayList<LatLng> f29450l;
    /* renamed from: m */
    String f29451m;
    /* renamed from: n */
    String f29452n;
    /* renamed from: o */
    ArrayList<C7886b> f29453o;
    /* renamed from: p */
    boolean f29454p;
    /* renamed from: q */
    ArrayList<C7891g> f29455q;
    /* renamed from: r */
    ArrayList<C7889e> f29456r;
    /* renamed from: s */
    ArrayList<C7891g> f29457s;

    /* renamed from: com.google.android.gms.wallet.wobs.CommonWalletObject$a */
    public final class C5167a {
        /* renamed from: a */
        private final /* synthetic */ CommonWalletObject f17446a;

        private C5167a(CommonWalletObject commonWalletObject) {
            this.f17446a = commonWalletObject;
        }

        /* renamed from: a */
        public final C5167a m21876a(String str) {
            this.f17446a.f29439a = str;
            return this;
        }

        /* renamed from: a */
        public final CommonWalletObject m21877a() {
            return this.f17446a;
        }
    }

    CommonWalletObject() {
        this.f29448j = C2892b.a();
        this.f29450l = C2892b.a();
        this.f29453o = C2892b.a();
        this.f29455q = C2892b.a();
        this.f29456r = C2892b.a();
        this.f29457s = C2892b.a();
    }

    CommonWalletObject(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, ArrayList<C7892h> arrayList, C7890f c7890f, ArrayList<LatLng> arrayList2, String str9, String str10, ArrayList<C7886b> arrayList3, boolean z, ArrayList<C7891g> arrayList4, ArrayList<C7889e> arrayList5, ArrayList<C7891g> arrayList6) {
        this.f29439a = str;
        this.f29440b = str2;
        this.f29441c = str3;
        this.f29442d = str4;
        this.f29443e = str5;
        this.f29444f = str6;
        this.f29445g = str7;
        this.f29446h = str8;
        this.f29447i = i;
        this.f29448j = arrayList;
        this.f29449k = c7890f;
        this.f29450l = arrayList2;
        this.f29451m = str9;
        this.f29452n = str10;
        this.f29453o = arrayList3;
        this.f29454p = z;
        this.f29455q = arrayList4;
        this.f29456r = arrayList5;
        this.f29457s = arrayList6;
    }

    /* renamed from: a */
    public static C5167a m38420a() {
        return new C5167a();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f29439a, false);
        C2835c.a(parcel, 3, this.f29440b, false);
        C2835c.a(parcel, 4, this.f29441c, false);
        C2835c.a(parcel, 5, this.f29442d, false);
        C2835c.a(parcel, 6, this.f29443e, false);
        C2835c.a(parcel, 7, this.f29444f, false);
        C2835c.a(parcel, 8, this.f29445g, false);
        C2835c.a(parcel, 9, this.f29446h, false);
        C2835c.a(parcel, 10, this.f29447i);
        C2835c.c(parcel, 11, this.f29448j, false);
        C2835c.a(parcel, 12, this.f29449k, i, false);
        C2835c.c(parcel, 13, this.f29450l, false);
        C2835c.a(parcel, 14, this.f29451m, false);
        C2835c.a(parcel, 15, this.f29452n, false);
        C2835c.c(parcel, 16, this.f29453o, false);
        C2835c.a(parcel, 17, this.f29454p);
        C2835c.c(parcel, 18, this.f29455q, false);
        C2835c.c(parcel, 19, this.f29456r, false);
        C2835c.c(parcel, 20, this.f29457s, false);
        C2835c.a(parcel, a);
    }
}
