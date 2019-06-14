package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.react.uimanager.events.TouchesHelper;
import com.google.android.gms.common.internal.C2868t;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

public final class CameraPosition extends C4363a implements ReflectedParcelable {
    public static final Creator<CameraPosition> CREATOR = new ac();
    /* renamed from: a */
    public final LatLng f29227a;
    /* renamed from: b */
    public final float f29228b;
    /* renamed from: c */
    public final float f29229c;
    /* renamed from: d */
    public final float f29230d;

    /* renamed from: com.google.android.gms.maps.model.CameraPosition$a */
    public static final class C5134a {
        /* renamed from: a */
        private LatLng f17401a;
        /* renamed from: b */
        private float f17402b;
        /* renamed from: c */
        private float f17403c;
        /* renamed from: d */
        private float f17404d;

        public C5134a(CameraPosition cameraPosition) {
            this.f17401a = cameraPosition.f29227a;
            this.f17402b = cameraPosition.f29228b;
            this.f17403c = cameraPosition.f29229c;
            this.f17404d = cameraPosition.f29230d;
        }

        /* renamed from: a */
        public final C5134a m21753a(float f) {
            this.f17402b = f;
            return this;
        }

        /* renamed from: a */
        public final C5134a m21754a(LatLng latLng) {
            this.f17401a = latLng;
            return this;
        }

        /* renamed from: a */
        public final CameraPosition m21755a() {
            return new CameraPosition(this.f17401a, this.f17402b, this.f17403c, this.f17404d);
        }

        /* renamed from: b */
        public final C5134a m21756b(float f) {
            this.f17403c = f;
            return this;
        }

        /* renamed from: c */
        public final C5134a m21757c(float f) {
            this.f17404d = f;
            return this;
        }
    }

    public CameraPosition(LatLng latLng, float f, float f2, float f3) {
        C2872v.a(latLng, "null camera target");
        boolean z = 0.0f <= f2 && f2 <= 90.0f;
        C2872v.b(z, "Tilt needs to be between 0 and 90 inclusive: %s", new Object[]{Float.valueOf(f2)});
        this.f29227a = latLng;
        this.f29228b = f;
        this.f29229c = f2 + 0.0f;
        if (((double) f3) <= 0.0d) {
            f3 = (f3 % 360.0f) + 360.0f;
        }
        this.f29230d = f3 % 360.0f;
    }

    /* renamed from: a */
    public static C5134a m38276a() {
        return new C5134a();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) obj;
        return this.f29227a.equals(cameraPosition.f29227a) && Float.floatToIntBits(this.f29228b) == Float.floatToIntBits(cameraPosition.f29228b) && Float.floatToIntBits(this.f29229c) == Float.floatToIntBits(cameraPosition.f29229c) && Float.floatToIntBits(this.f29230d) == Float.floatToIntBits(cameraPosition.f29230d);
    }

    public final int hashCode() {
        return C2868t.a(new Object[]{this.f29227a, Float.valueOf(this.f29228b), Float.valueOf(this.f29229c), Float.valueOf(this.f29230d)});
    }

    public final String toString() {
        return C2868t.a(this).a(TouchesHelper.TARGET_KEY, this.f29227a).a("zoom", Float.valueOf(this.f29228b)).a("tilt", Float.valueOf(this.f29229c)).a("bearing", Float.valueOf(this.f29230d)).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f29227a, i, false);
        C2835c.a(parcel, 3, this.f29228b);
        C2835c.a(parcel, 4, this.f29229c);
        C2835c.a(parcel, 5, this.f29230d);
        C2835c.a(parcel, a);
    }
}
