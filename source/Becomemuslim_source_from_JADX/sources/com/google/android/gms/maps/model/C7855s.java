package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.maps.model.s */
public final class C7855s extends C4363a {
    public static final Creator<C7855s> CREATOR = new an();
    /* renamed from: a */
    private final List<LatLng> f29299a;
    /* renamed from: b */
    private float f29300b;
    /* renamed from: c */
    private int f29301c;
    /* renamed from: d */
    private float f29302d;
    /* renamed from: e */
    private boolean f29303e;
    /* renamed from: f */
    private boolean f29304f;
    /* renamed from: g */
    private boolean f29305g;
    /* renamed from: h */
    private C7847d f29306h;
    /* renamed from: i */
    private C7847d f29307i;
    /* renamed from: j */
    private int f29308j;
    /* renamed from: k */
    private List<C7852n> f29309k;

    public C7855s() {
        this.f29300b = 10.0f;
        this.f29301c = -16777216;
        this.f29302d = 0.0f;
        this.f29303e = true;
        this.f29304f = false;
        this.f29305g = false;
        this.f29306h = new C8226c();
        this.f29307i = new C8226c();
        this.f29308j = 0;
        this.f29309k = null;
        this.f29299a = new ArrayList();
    }

    C7855s(List list, float f, int i, float f2, boolean z, boolean z2, boolean z3, C7847d c7847d, C7847d c7847d2, int i2, List<C7852n> list2) {
        this.f29300b = 10.0f;
        this.f29301c = -16777216;
        this.f29302d = 0.0f;
        this.f29303e = true;
        this.f29304f = false;
        this.f29305g = false;
        this.f29306h = new C8226c();
        this.f29307i = new C8226c();
        this.f29308j = 0;
        this.f29309k = null;
        this.f29299a = list;
        this.f29300b = f;
        this.f29301c = i;
        this.f29302d = f2;
        this.f29303e = z;
        this.f29304f = z2;
        this.f29305g = z3;
        if (c7847d != null) {
            this.f29306h = c7847d;
        }
        if (c7847d2 != null) {
            this.f29307i = c7847d2;
        }
        this.f29308j = i2;
        this.f29309k = list2;
    }

    /* renamed from: a */
    public final C7855s m38358a(float f) {
        this.f29300b = f;
        return this;
    }

    /* renamed from: a */
    public final C7855s m38359a(int i) {
        this.f29301c = i;
        return this;
    }

    /* renamed from: a */
    public final C7855s m38360a(C7847d c7847d) {
        this.f29306h = (C7847d) C2872v.a(c7847d, "startCap must not be null");
        return this;
    }

    /* renamed from: a */
    public final C7855s m38361a(Iterable<LatLng> iterable) {
        for (LatLng add : iterable) {
            this.f29299a.add(add);
        }
        return this;
    }

    /* renamed from: a */
    public final C7855s m38362a(boolean z) {
        this.f29303e = z;
        return this;
    }

    /* renamed from: a */
    public final List<LatLng> m38363a() {
        return this.f29299a;
    }

    /* renamed from: b */
    public final float m38364b() {
        return this.f29300b;
    }

    /* renamed from: b */
    public final C7855s m38365b(float f) {
        this.f29302d = f;
        return this;
    }

    /* renamed from: b */
    public final C7855s m38366b(C7847d c7847d) {
        this.f29307i = (C7847d) C2872v.a(c7847d, "endCap must not be null");
        return this;
    }

    /* renamed from: b */
    public final C7855s m38367b(boolean z) {
        this.f29304f = z;
        return this;
    }

    /* renamed from: c */
    public final int m38368c() {
        return this.f29301c;
    }

    /* renamed from: c */
    public final C7855s m38369c(boolean z) {
        this.f29305g = z;
        return this;
    }

    /* renamed from: d */
    public final C7847d m38370d() {
        return this.f29306h;
    }

    /* renamed from: e */
    public final C7847d m38371e() {
        return this.f29307i;
    }

    /* renamed from: f */
    public final int m38372f() {
        return this.f29308j;
    }

    /* renamed from: g */
    public final List<C7852n> m38373g() {
        return this.f29309k;
    }

    /* renamed from: h */
    public final float m38374h() {
        return this.f29302d;
    }

    /* renamed from: i */
    public final boolean m38375i() {
        return this.f29303e;
    }

    /* renamed from: j */
    public final boolean m38376j() {
        return this.f29304f;
    }

    /* renamed from: k */
    public final boolean m38377k() {
        return this.f29305g;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.a(parcel);
        C2835c.c(parcel, 2, m38363a(), false);
        C2835c.a(parcel, 3, m38364b());
        C2835c.a(parcel, 4, m38368c());
        C2835c.a(parcel, 5, m38374h());
        C2835c.a(parcel, 6, m38375i());
        C2835c.a(parcel, 7, m38376j());
        C2835c.a(parcel, 8, m38377k());
        C2835c.a(parcel, 9, m38370d(), i, false);
        C2835c.a(parcel, 10, m38371e(), i, false);
        C2835c.a(parcel, 11, m38372f());
        C2835c.c(parcel, 12, m38373g(), false);
        C2835c.a(parcel, a);
    }
}
