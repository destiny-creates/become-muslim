package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import java.util.List;

/* renamed from: com.google.android.gms.maps.model.f */
public final class C7848f extends C4363a {
    public static final Creator<C7848f> CREATOR = new ae();
    /* renamed from: a */
    private LatLng f29245a = null;
    /* renamed from: b */
    private double f29246b = 0.0d;
    /* renamed from: c */
    private float f29247c = 10.0f;
    /* renamed from: d */
    private int f29248d = -16777216;
    /* renamed from: e */
    private int f29249e = 0;
    /* renamed from: f */
    private float f29250f = 0.0f;
    /* renamed from: g */
    private boolean f29251g = true;
    /* renamed from: h */
    private boolean f29252h = false;
    /* renamed from: i */
    private List<C7852n> f29253i = null;

    C7848f(LatLng latLng, double d, float f, int i, int i2, float f2, boolean z, boolean z2, List<C7852n> list) {
        this.f29245a = latLng;
        this.f29246b = d;
        this.f29247c = f;
        this.f29248d = i;
        this.f29249e = i2;
        this.f29250f = f2;
        this.f29251g = z;
        this.f29252h = z2;
        this.f29253i = list;
    }

    /* renamed from: a */
    public final LatLng m38283a() {
        return this.f29245a;
    }

    /* renamed from: a */
    public final C7848f m38284a(double d) {
        this.f29246b = d;
        return this;
    }

    /* renamed from: a */
    public final C7848f m38285a(float f) {
        this.f29247c = f;
        return this;
    }

    /* renamed from: a */
    public final C7848f m38286a(int i) {
        this.f29248d = i;
        return this;
    }

    /* renamed from: a */
    public final C7848f m38287a(LatLng latLng) {
        this.f29245a = latLng;
        return this;
    }

    /* renamed from: b */
    public final double m38288b() {
        return this.f29246b;
    }

    /* renamed from: b */
    public final C7848f m38289b(float f) {
        this.f29250f = f;
        return this;
    }

    /* renamed from: b */
    public final C7848f m38290b(int i) {
        this.f29249e = i;
        return this;
    }

    /* renamed from: c */
    public final float m38291c() {
        return this.f29247c;
    }

    /* renamed from: d */
    public final int m38292d() {
        return this.f29248d;
    }

    /* renamed from: e */
    public final List<C7852n> m38293e() {
        return this.f29253i;
    }

    /* renamed from: f */
    public final int m38294f() {
        return this.f29249e;
    }

    /* renamed from: g */
    public final float m38295g() {
        return this.f29250f;
    }

    /* renamed from: h */
    public final boolean m38296h() {
        return this.f29251g;
    }

    /* renamed from: i */
    public final boolean m38297i() {
        return this.f29252h;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.a(parcel);
        C2835c.a(parcel, 2, m38283a(), i, false);
        C2835c.a(parcel, 3, m38288b());
        C2835c.a(parcel, 4, m38291c());
        C2835c.a(parcel, 5, m38292d());
        C2835c.a(parcel, 6, m38294f());
        C2835c.a(parcel, 7, m38295g());
        C2835c.a(parcel, 8, m38296h());
        C2835c.a(parcel, 9, m38297i());
        C2835c.c(parcel, 10, m38293e(), false);
        C2835c.a(parcel, a);
    }
}
