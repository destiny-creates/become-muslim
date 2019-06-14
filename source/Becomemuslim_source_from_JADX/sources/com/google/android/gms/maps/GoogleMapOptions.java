package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import com.google.android.gms.common.internal.C2868t;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import com.google.android.gms.maps.C5131h.C5130a;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CameraPosition.C5134a;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.p216a.C5096g;

public final class GoogleMapOptions extends C4363a implements ReflectedParcelable {
    public static final Creator<GoogleMapOptions> CREATOR = new C5133k();
    /* renamed from: a */
    private Boolean f29203a;
    /* renamed from: b */
    private Boolean f29204b;
    /* renamed from: c */
    private int f29205c = -1;
    /* renamed from: d */
    private CameraPosition f29206d;
    /* renamed from: e */
    private Boolean f29207e;
    /* renamed from: f */
    private Boolean f29208f;
    /* renamed from: g */
    private Boolean f29209g;
    /* renamed from: h */
    private Boolean f29210h;
    /* renamed from: i */
    private Boolean f29211i;
    /* renamed from: j */
    private Boolean f29212j;
    /* renamed from: k */
    private Boolean f29213k;
    /* renamed from: l */
    private Boolean f29214l;
    /* renamed from: m */
    private Boolean f29215m;
    /* renamed from: n */
    private Float f29216n = null;
    /* renamed from: o */
    private Float f29217o = null;
    /* renamed from: p */
    private LatLngBounds f29218p = null;

    GoogleMapOptions(byte b, byte b2, int i, CameraPosition cameraPosition, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8, byte b9, byte b10, byte b11, Float f, Float f2, LatLngBounds latLngBounds) {
        this.f29203a = C5096g.m21677a(b);
        this.f29204b = C5096g.m21677a(b2);
        this.f29205c = i;
        this.f29206d = cameraPosition;
        this.f29207e = C5096g.m21677a(b3);
        this.f29208f = C5096g.m21677a(b4);
        this.f29209g = C5096g.m21677a(b5);
        this.f29210h = C5096g.m21677a(b6);
        this.f29211i = C5096g.m21677a(b7);
        this.f29212j = C5096g.m21677a(b8);
        this.f29213k = C5096g.m21677a(b9);
        this.f29214l = C5096g.m21677a(b10);
        this.f29215m = C5096g.m21677a(b11);
        this.f29216n = f;
        this.f29217o = f2;
        this.f29218p = latLngBounds;
    }

    /* renamed from: a */
    public static GoogleMapOptions m38234a(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, C5130a.MapAttrs);
                GoogleMapOptions googleMapOptions = new GoogleMapOptions();
                if (obtainAttributes.hasValue(C5130a.MapAttrs_mapType)) {
                    googleMapOptions.m38239a(obtainAttributes.getInt(C5130a.MapAttrs_mapType, -1));
                }
                if (obtainAttributes.hasValue(C5130a.MapAttrs_zOrderOnTop)) {
                    googleMapOptions.m38242a(obtainAttributes.getBoolean(C5130a.MapAttrs_zOrderOnTop, false));
                }
                if (obtainAttributes.hasValue(C5130a.MapAttrs_useViewLifecycle)) {
                    googleMapOptions.m38244b(obtainAttributes.getBoolean(C5130a.MapAttrs_useViewLifecycle, false));
                }
                if (obtainAttributes.hasValue(C5130a.MapAttrs_uiCompass)) {
                    googleMapOptions.m38248d(obtainAttributes.getBoolean(C5130a.MapAttrs_uiCompass, true));
                }
                if (obtainAttributes.hasValue(C5130a.MapAttrs_uiRotateGestures)) {
                    googleMapOptions.m38254h(obtainAttributes.getBoolean(C5130a.MapAttrs_uiRotateGestures, true));
                }
                if (obtainAttributes.hasValue(C5130a.MapAttrs_uiScrollGestures)) {
                    googleMapOptions.m38250e(obtainAttributes.getBoolean(C5130a.MapAttrs_uiScrollGestures, true));
                }
                if (obtainAttributes.hasValue(C5130a.MapAttrs_uiTiltGestures)) {
                    googleMapOptions.m38253g(obtainAttributes.getBoolean(C5130a.MapAttrs_uiTiltGestures, true));
                }
                if (obtainAttributes.hasValue(C5130a.MapAttrs_uiZoomGestures)) {
                    googleMapOptions.m38252f(obtainAttributes.getBoolean(C5130a.MapAttrs_uiZoomGestures, true));
                }
                if (obtainAttributes.hasValue(C5130a.MapAttrs_uiZoomControls)) {
                    googleMapOptions.m38246c(obtainAttributes.getBoolean(C5130a.MapAttrs_uiZoomControls, true));
                }
                if (obtainAttributes.hasValue(C5130a.MapAttrs_liteMode)) {
                    googleMapOptions.m38255i(obtainAttributes.getBoolean(C5130a.MapAttrs_liteMode, false));
                }
                if (obtainAttributes.hasValue(C5130a.MapAttrs_uiMapToolbar)) {
                    googleMapOptions.m38256j(obtainAttributes.getBoolean(C5130a.MapAttrs_uiMapToolbar, true));
                }
                if (obtainAttributes.hasValue(C5130a.MapAttrs_ambientEnabled)) {
                    googleMapOptions.m38257k(obtainAttributes.getBoolean(C5130a.MapAttrs_ambientEnabled, false));
                }
                if (obtainAttributes.hasValue(C5130a.MapAttrs_cameraMinZoomPreference)) {
                    googleMapOptions.m38238a(obtainAttributes.getFloat(C5130a.MapAttrs_cameraMinZoomPreference, Float.NEGATIVE_INFINITY));
                }
                if (obtainAttributes.hasValue(C5130a.MapAttrs_cameraMinZoomPreference)) {
                    googleMapOptions.m38243b(obtainAttributes.getFloat(C5130a.MapAttrs_cameraMaxZoomPreference, Float.POSITIVE_INFINITY));
                }
                googleMapOptions.m38241a(m38235b(context, attributeSet));
                googleMapOptions.m38240a(m38236c(context, attributeSet));
                obtainAttributes.recycle();
                return googleMapOptions;
            }
        }
        return null;
    }

    /* renamed from: b */
    public static LatLngBounds m38235b(Context context, AttributeSet attributeSet) {
        if (context == null) {
            return null;
        }
        if (attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, C5130a.MapAttrs);
        Float valueOf = obtainAttributes.hasValue(C5130a.MapAttrs_latLngBoundsSouthWestLatitude) ? Float.valueOf(obtainAttributes.getFloat(C5130a.MapAttrs_latLngBoundsSouthWestLatitude, 0.0f)) : null;
        Float valueOf2 = obtainAttributes.hasValue(C5130a.MapAttrs_latLngBoundsSouthWestLongitude) ? Float.valueOf(obtainAttributes.getFloat(C5130a.MapAttrs_latLngBoundsSouthWestLongitude, 0.0f)) : null;
        Float valueOf3 = obtainAttributes.hasValue(C5130a.MapAttrs_latLngBoundsNorthEastLatitude) ? Float.valueOf(obtainAttributes.getFloat(C5130a.MapAttrs_latLngBoundsNorthEastLatitude, 0.0f)) : null;
        Float valueOf4 = obtainAttributes.hasValue(C5130a.MapAttrs_latLngBoundsNorthEastLongitude) ? Float.valueOf(obtainAttributes.getFloat(C5130a.MapAttrs_latLngBoundsNorthEastLongitude, 0.0f)) : null;
        obtainAttributes.recycle();
        return (valueOf == null || valueOf2 == null || valueOf3 == null) ? null : valueOf4 == null ? null : new LatLngBounds(new LatLng((double) valueOf.floatValue(), (double) valueOf2.floatValue()), new LatLng((double) valueOf3.floatValue(), (double) valueOf4.floatValue()));
    }

    /* renamed from: c */
    public static CameraPosition m38236c(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, C5130a.MapAttrs);
                LatLng latLng = new LatLng((double) (obtainAttributes.hasValue(C5130a.MapAttrs_cameraTargetLat) ? obtainAttributes.getFloat(C5130a.MapAttrs_cameraTargetLat, 0.0f) : 0.0f), (double) (obtainAttributes.hasValue(C5130a.MapAttrs_cameraTargetLng) ? obtainAttributes.getFloat(C5130a.MapAttrs_cameraTargetLng, 0.0f) : 0.0f));
                C5134a a = CameraPosition.m38276a();
                a.m21754a(latLng);
                if (obtainAttributes.hasValue(C5130a.MapAttrs_cameraZoom)) {
                    a.m21753a(obtainAttributes.getFloat(C5130a.MapAttrs_cameraZoom, 0.0f));
                }
                if (obtainAttributes.hasValue(C5130a.MapAttrs_cameraBearing)) {
                    a.m21757c(obtainAttributes.getFloat(C5130a.MapAttrs_cameraBearing, 0.0f));
                }
                if (obtainAttributes.hasValue(C5130a.MapAttrs_cameraTilt)) {
                    a.m21756b(obtainAttributes.getFloat(C5130a.MapAttrs_cameraTilt, 0.0f));
                }
                obtainAttributes.recycle();
                return a.m21755a();
            }
        }
        return null;
    }

    /* renamed from: a */
    public final int m38237a() {
        return this.f29205c;
    }

    /* renamed from: a */
    public final GoogleMapOptions m38238a(float f) {
        this.f29216n = Float.valueOf(f);
        return this;
    }

    /* renamed from: a */
    public final GoogleMapOptions m38239a(int i) {
        this.f29205c = i;
        return this;
    }

    /* renamed from: a */
    public final GoogleMapOptions m38240a(CameraPosition cameraPosition) {
        this.f29206d = cameraPosition;
        return this;
    }

    /* renamed from: a */
    public final GoogleMapOptions m38241a(LatLngBounds latLngBounds) {
        this.f29218p = latLngBounds;
        return this;
    }

    /* renamed from: a */
    public final GoogleMapOptions m38242a(boolean z) {
        this.f29203a = Boolean.valueOf(z);
        return this;
    }

    /* renamed from: b */
    public final GoogleMapOptions m38243b(float f) {
        this.f29217o = Float.valueOf(f);
        return this;
    }

    /* renamed from: b */
    public final GoogleMapOptions m38244b(boolean z) {
        this.f29204b = Boolean.valueOf(z);
        return this;
    }

    /* renamed from: b */
    public final CameraPosition m38245b() {
        return this.f29206d;
    }

    /* renamed from: c */
    public final GoogleMapOptions m38246c(boolean z) {
        this.f29207e = Boolean.valueOf(z);
        return this;
    }

    /* renamed from: c */
    public final Float m38247c() {
        return this.f29216n;
    }

    /* renamed from: d */
    public final GoogleMapOptions m38248d(boolean z) {
        this.f29208f = Boolean.valueOf(z);
        return this;
    }

    /* renamed from: d */
    public final Float m38249d() {
        return this.f29217o;
    }

    /* renamed from: e */
    public final GoogleMapOptions m38250e(boolean z) {
        this.f29209g = Boolean.valueOf(z);
        return this;
    }

    /* renamed from: e */
    public final LatLngBounds m38251e() {
        return this.f29218p;
    }

    /* renamed from: f */
    public final GoogleMapOptions m38252f(boolean z) {
        this.f29210h = Boolean.valueOf(z);
        return this;
    }

    /* renamed from: g */
    public final GoogleMapOptions m38253g(boolean z) {
        this.f29211i = Boolean.valueOf(z);
        return this;
    }

    /* renamed from: h */
    public final GoogleMapOptions m38254h(boolean z) {
        this.f29212j = Boolean.valueOf(z);
        return this;
    }

    /* renamed from: i */
    public final GoogleMapOptions m38255i(boolean z) {
        this.f29213k = Boolean.valueOf(z);
        return this;
    }

    /* renamed from: j */
    public final GoogleMapOptions m38256j(boolean z) {
        this.f29214l = Boolean.valueOf(z);
        return this;
    }

    /* renamed from: k */
    public final GoogleMapOptions m38257k(boolean z) {
        this.f29215m = Boolean.valueOf(z);
        return this;
    }

    public final String toString() {
        return C2868t.a(this).a("MapType", Integer.valueOf(this.f29205c)).a("LiteMode", this.f29213k).a("Camera", this.f29206d).a("CompassEnabled", this.f29208f).a("ZoomControlsEnabled", this.f29207e).a("ScrollGesturesEnabled", this.f29209g).a("ZoomGesturesEnabled", this.f29210h).a("TiltGesturesEnabled", this.f29211i).a("RotateGesturesEnabled", this.f29212j).a("MapToolbarEnabled", this.f29214l).a("AmbientEnabled", this.f29215m).a("MinZoomPreference", this.f29216n).a("MaxZoomPreference", this.f29217o).a("LatLngBoundsForCameraTarget", this.f29218p).a("ZOrderOnTop", this.f29203a).a("UseViewLifecycleInFragment", this.f29204b).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.a(parcel);
        C2835c.a(parcel, 2, C5096g.m21676a(this.f29203a));
        C2835c.a(parcel, 3, C5096g.m21676a(this.f29204b));
        C2835c.a(parcel, 4, m38237a());
        C2835c.a(parcel, 5, m38245b(), i, false);
        C2835c.a(parcel, 6, C5096g.m21676a(this.f29207e));
        C2835c.a(parcel, 7, C5096g.m21676a(this.f29208f));
        C2835c.a(parcel, 8, C5096g.m21676a(this.f29209g));
        C2835c.a(parcel, 9, C5096g.m21676a(this.f29210h));
        C2835c.a(parcel, 10, C5096g.m21676a(this.f29211i));
        C2835c.a(parcel, 11, C5096g.m21676a(this.f29212j));
        C2835c.a(parcel, 12, C5096g.m21676a(this.f29213k));
        C2835c.a(parcel, 14, C5096g.m21676a(this.f29214l));
        C2835c.a(parcel, 15, C5096g.m21676a(this.f29215m));
        C2835c.a(parcel, 16, m38247c(), false);
        C2835c.a(parcel, 17, m38249d(), false);
        C2835c.a(parcel, 18, m38251e(), i, false);
        C2835c.a(parcel, a);
    }
}
