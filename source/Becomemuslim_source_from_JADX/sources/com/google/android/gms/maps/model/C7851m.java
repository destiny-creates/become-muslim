package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import com.google.android.gms.p174b.C2758b.C4325a;

/* renamed from: com.google.android.gms.maps.model.m */
public final class C7851m extends C4363a {
    public static final Creator<C7851m> CREATOR = new aj();
    /* renamed from: a */
    private LatLng f29268a;
    /* renamed from: b */
    private String f29269b;
    /* renamed from: c */
    private String f29270c;
    /* renamed from: d */
    private C5136a f29271d;
    /* renamed from: e */
    private float f29272e = 0.5f;
    /* renamed from: f */
    private float f29273f = 1.0f;
    /* renamed from: g */
    private boolean f29274g;
    /* renamed from: h */
    private boolean f29275h = true;
    /* renamed from: i */
    private boolean f29276i = false;
    /* renamed from: j */
    private float f29277j = 0.0f;
    /* renamed from: k */
    private float f29278k = 0.5f;
    /* renamed from: l */
    private float f29279l = 0.0f;
    /* renamed from: m */
    private float f29280m = 1.0f;
    /* renamed from: n */
    private float f29281n;

    C7851m(LatLng latLng, String str, String str2, IBinder iBinder, float f, float f2, boolean z, boolean z2, boolean z3, float f3, float f4, float f5, float f6, float f7) {
        this.f29268a = latLng;
        this.f29269b = str;
        this.f29270c = str2;
        if (iBinder == null) {
            r0.f29271d = null;
        } else {
            r0.f29271d = new C5136a(C4325a.a(iBinder));
        }
        r0.f29272e = f;
        r0.f29273f = f2;
        r0.f29274g = z;
        r0.f29275h = z2;
        r0.f29276i = z3;
        r0.f29277j = f3;
        r0.f29278k = f4;
        r0.f29279l = f5;
        r0.f29280m = f6;
        r0.f29281n = f7;
    }

    /* renamed from: a */
    public final LatLng m38314a() {
        return this.f29268a;
    }

    /* renamed from: a */
    public final C7851m m38315a(float f) {
        this.f29281n = f;
        return this;
    }

    /* renamed from: a */
    public final C7851m m38316a(float f, float f2) {
        this.f29272e = f;
        this.f29273f = f2;
        return this;
    }

    /* renamed from: a */
    public final C7851m m38317a(LatLng latLng) {
        if (latLng != null) {
            this.f29268a = latLng;
            return this;
        }
        throw new IllegalArgumentException("latlng cannot be null - a position is required.");
    }

    /* renamed from: a */
    public final C7851m m38318a(C5136a c5136a) {
        this.f29271d = c5136a;
        return this;
    }

    /* renamed from: a */
    public final C7851m m38319a(String str) {
        this.f29269b = str;
        return this;
    }

    /* renamed from: a */
    public final C7851m m38320a(boolean z) {
        this.f29274g = z;
        return this;
    }

    /* renamed from: b */
    public final C7851m m38321b(float f) {
        this.f29277j = f;
        return this;
    }

    /* renamed from: b */
    public final C7851m m38322b(float f, float f2) {
        this.f29278k = f;
        this.f29279l = f2;
        return this;
    }

    /* renamed from: b */
    public final C7851m m38323b(String str) {
        this.f29270c = str;
        return this;
    }

    /* renamed from: b */
    public final C7851m m38324b(boolean z) {
        this.f29275h = z;
        return this;
    }

    /* renamed from: b */
    public final String m38325b() {
        return this.f29269b;
    }

    /* renamed from: c */
    public final C7851m m38326c(float f) {
        this.f29280m = f;
        return this;
    }

    /* renamed from: c */
    public final C7851m m38327c(boolean z) {
        this.f29276i = z;
        return this;
    }

    /* renamed from: c */
    public final String m38328c() {
        return this.f29270c;
    }

    /* renamed from: d */
    public final C5136a m38329d() {
        return this.f29271d;
    }

    /* renamed from: e */
    public final float m38330e() {
        return this.f29272e;
    }

    /* renamed from: f */
    public final float m38331f() {
        return this.f29273f;
    }

    /* renamed from: g */
    public final boolean m38332g() {
        return this.f29274g;
    }

    /* renamed from: h */
    public final boolean m38333h() {
        return this.f29275h;
    }

    /* renamed from: i */
    public final boolean m38334i() {
        return this.f29276i;
    }

    /* renamed from: j */
    public final float m38335j() {
        return this.f29277j;
    }

    /* renamed from: k */
    public final float m38336k() {
        return this.f29278k;
    }

    /* renamed from: l */
    public final float m38337l() {
        return this.f29279l;
    }

    /* renamed from: m */
    public final float m38338m() {
        return this.f29280m;
    }

    /* renamed from: n */
    public final float m38339n() {
        return this.f29281n;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.a(parcel);
        C2835c.a(parcel, 2, m38314a(), i, false);
        C2835c.a(parcel, 3, m38325b(), false);
        C2835c.a(parcel, 4, m38328c(), false);
        C2835c.a(parcel, 5, this.f29271d == null ? null : this.f29271d.m21760a().asBinder(), false);
        C2835c.a(parcel, 6, m38330e());
        C2835c.a(parcel, 7, m38331f());
        C2835c.a(parcel, 8, m38332g());
        C2835c.a(parcel, 9, m38333h());
        C2835c.a(parcel, 10, m38334i());
        C2835c.a(parcel, 11, m38335j());
        C2835c.a(parcel, 12, m38336k());
        C2835c.a(parcel, 13, m38337l());
        C2835c.a(parcel, 14, m38338m());
        C2835c.a(parcel, 15, m38339n());
        C2835c.a(parcel, a);
    }
}
