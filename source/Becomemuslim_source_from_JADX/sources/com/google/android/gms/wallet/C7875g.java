package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import com.google.android.gms.common.util.C2892b;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.C7886b;
import com.google.android.gms.wallet.wobs.C7887c;
import com.google.android.gms.wallet.wobs.C7889e;
import com.google.android.gms.wallet.wobs.C7890f;
import com.google.android.gms.wallet.wobs.C7891g;
import com.google.android.gms.wallet.wobs.C7892h;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.g */
public final class C7875g extends C4363a {
    public static final Creator<C7875g> CREATOR = new as();
    /* renamed from: a */
    String f29373a;
    /* renamed from: b */
    String f29374b;
    /* renamed from: c */
    String f29375c;
    /* renamed from: d */
    String f29376d;
    /* renamed from: e */
    String f29377e;
    /* renamed from: f */
    String f29378f;
    /* renamed from: g */
    String f29379g;
    /* renamed from: h */
    String f29380h;
    /* renamed from: i */
    String f29381i;
    /* renamed from: j */
    String f29382j;
    /* renamed from: k */
    int f29383k;
    /* renamed from: l */
    ArrayList<C7892h> f29384l;
    /* renamed from: m */
    C7890f f29385m;
    /* renamed from: n */
    ArrayList<LatLng> f29386n;
    /* renamed from: o */
    String f29387o;
    /* renamed from: p */
    String f29388p;
    /* renamed from: q */
    ArrayList<C7886b> f29389q;
    /* renamed from: r */
    boolean f29390r;
    /* renamed from: s */
    ArrayList<C7891g> f29391s;
    /* renamed from: t */
    ArrayList<C7889e> f29392t;
    /* renamed from: u */
    ArrayList<C7891g> f29393u;
    /* renamed from: v */
    C7887c f29394v;

    C7875g() {
        this.f29384l = C2892b.a();
        this.f29386n = C2892b.a();
        this.f29389q = C2892b.a();
        this.f29391s = C2892b.a();
        this.f29392t = C2892b.a();
        this.f29393u = C2892b.a();
    }

    C7875g(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i, ArrayList<C7892h> arrayList, C7890f c7890f, ArrayList<LatLng> arrayList2, String str11, String str12, ArrayList<C7886b> arrayList3, boolean z, ArrayList<C7891g> arrayList4, ArrayList<C7889e> arrayList5, ArrayList<C7891g> arrayList6, C7887c c7887c) {
        this.f29373a = str;
        this.f29374b = str2;
        this.f29375c = str3;
        this.f29376d = str4;
        this.f29377e = str5;
        this.f29378f = str6;
        this.f29379g = str7;
        this.f29380h = str8;
        this.f29381i = str9;
        this.f29382j = str10;
        this.f29383k = i;
        this.f29384l = arrayList;
        this.f29385m = c7890f;
        this.f29386n = arrayList2;
        this.f29387o = str11;
        this.f29388p = str12;
        this.f29389q = arrayList3;
        this.f29390r = z;
        this.f29391s = arrayList4;
        this.f29392t = arrayList5;
        this.f29393u = arrayList6;
        this.f29394v = c7887c;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f29373a, false);
        C2835c.a(parcel, 3, this.f29374b, false);
        C2835c.a(parcel, 4, this.f29375c, false);
        C2835c.a(parcel, 5, this.f29376d, false);
        C2835c.a(parcel, 6, this.f29377e, false);
        C2835c.a(parcel, 7, this.f29378f, false);
        C2835c.a(parcel, 8, this.f29379g, false);
        C2835c.a(parcel, 9, this.f29380h, false);
        C2835c.a(parcel, 10, this.f29381i, false);
        C2835c.a(parcel, 11, this.f29382j, false);
        C2835c.a(parcel, 12, this.f29383k);
        C2835c.c(parcel, 13, this.f29384l, false);
        C2835c.a(parcel, 14, this.f29385m, i, false);
        C2835c.c(parcel, 15, this.f29386n, false);
        C2835c.a(parcel, 16, this.f29387o, false);
        C2835c.a(parcel, 17, this.f29388p, false);
        C2835c.c(parcel, 18, this.f29389q, false);
        C2835c.a(parcel, 19, this.f29390r);
        C2835c.c(parcel, 20, this.f29391s, false);
        C2835c.c(parcel, 21, this.f29392t, false);
        C2835c.c(parcel, 22, this.f29393u, false);
        C2835c.a(parcel, 23, this.f29394v, i, false);
        C2835c.a(parcel, a);
    }
}
