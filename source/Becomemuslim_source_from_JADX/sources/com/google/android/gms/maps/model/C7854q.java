package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.maps.model.q */
public final class C7854q extends C4363a {
    public static final Creator<C7854q> CREATOR = new am();
    /* renamed from: a */
    private final List<LatLng> f29288a;
    /* renamed from: b */
    private final List<List<LatLng>> f29289b;
    /* renamed from: c */
    private float f29290c;
    /* renamed from: d */
    private int f29291d;
    /* renamed from: e */
    private int f29292e;
    /* renamed from: f */
    private float f29293f;
    /* renamed from: g */
    private boolean f29294g;
    /* renamed from: h */
    private boolean f29295h;
    /* renamed from: i */
    private boolean f29296i;
    /* renamed from: j */
    private int f29297j;
    /* renamed from: k */
    private List<C7852n> f29298k;

    public C7854q() {
        this.f29290c = 10.0f;
        this.f29291d = -16777216;
        this.f29292e = 0;
        this.f29293f = 0.0f;
        this.f29294g = true;
        this.f29295h = false;
        this.f29296i = false;
        this.f29297j = 0;
        this.f29298k = null;
        this.f29288a = new ArrayList();
        this.f29289b = new ArrayList();
    }

    C7854q(List<LatLng> list, List list2, float f, int i, int i2, float f2, boolean z, boolean z2, boolean z3, int i3, List<C7852n> list3) {
        this.f29290c = 10.0f;
        this.f29291d = -16777216;
        this.f29292e = 0;
        this.f29293f = 0.0f;
        this.f29294g = true;
        this.f29295h = false;
        this.f29296i = false;
        this.f29297j = 0;
        this.f29298k = null;
        this.f29288a = list;
        this.f29289b = list2;
        this.f29290c = f;
        this.f29291d = i;
        this.f29292e = i2;
        this.f29293f = f2;
        this.f29294g = z;
        this.f29295h = z2;
        this.f29296i = z3;
        this.f29297j = i3;
        this.f29298k = list3;
    }

    /* renamed from: a */
    public final C7854q m38340a(float f) {
        this.f29290c = f;
        return this;
    }

    /* renamed from: a */
    public final C7854q m38341a(int i) {
        this.f29291d = i;
        return this;
    }

    /* renamed from: a */
    public final C7854q m38342a(Iterable<LatLng> iterable) {
        for (LatLng add : iterable) {
            this.f29288a.add(add);
        }
        return this;
    }

    /* renamed from: a */
    public final C7854q m38343a(boolean z) {
        this.f29294g = z;
        return this;
    }

    /* renamed from: a */
    public final List<LatLng> m38344a() {
        return this.f29288a;
    }

    /* renamed from: b */
    public final float m38345b() {
        return this.f29290c;
    }

    /* renamed from: b */
    public final C7854q m38346b(float f) {
        this.f29293f = f;
        return this;
    }

    /* renamed from: b */
    public final C7854q m38347b(int i) {
        this.f29292e = i;
        return this;
    }

    /* renamed from: b */
    public final C7854q m38348b(Iterable<LatLng> iterable) {
        ArrayList arrayList = new ArrayList();
        for (LatLng add : iterable) {
            arrayList.add(add);
        }
        this.f29289b.add(arrayList);
        return this;
    }

    /* renamed from: b */
    public final C7854q m38349b(boolean z) {
        this.f29295h = z;
        return this;
    }

    /* renamed from: c */
    public final int m38350c() {
        return this.f29291d;
    }

    /* renamed from: d */
    public final int m38351d() {
        return this.f29297j;
    }

    /* renamed from: e */
    public final List<C7852n> m38352e() {
        return this.f29298k;
    }

    /* renamed from: f */
    public final int m38353f() {
        return this.f29292e;
    }

    /* renamed from: g */
    public final float m38354g() {
        return this.f29293f;
    }

    /* renamed from: h */
    public final boolean m38355h() {
        return this.f29294g;
    }

    /* renamed from: i */
    public final boolean m38356i() {
        return this.f29295h;
    }

    /* renamed from: j */
    public final boolean m38357j() {
        return this.f29296i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.c(parcel, 2, m38344a(), false);
        C2835c.d(parcel, 3, this.f29289b, false);
        C2835c.a(parcel, 4, m38345b());
        C2835c.a(parcel, 5, m38350c());
        C2835c.a(parcel, 6, m38353f());
        C2835c.a(parcel, 7, m38354g());
        C2835c.a(parcel, 8, m38355h());
        C2835c.a(parcel, 9, m38356i());
        C2835c.a(parcel, 10, m38357j());
        C2835c.a(parcel, 11, m38351d());
        C2835c.c(parcel, 12, m38352e(), false);
        C2835c.a(parcel, i);
    }
}
