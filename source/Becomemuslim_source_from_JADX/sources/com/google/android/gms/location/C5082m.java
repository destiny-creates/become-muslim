package com.google.android.gms.location;

import android.content.Context;
import com.google.android.gms.common.api.C2781a;
import com.google.android.gms.common.api.C2781a.C4337a;
import com.google.android.gms.common.api.C2781a.C4341g;
import com.google.android.gms.common.api.C2814k;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.C2796c.C4770a;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.internal.p211j.C6799g;
import com.google.android.gms.internal.p211j.aa;
import com.google.android.gms.internal.p211j.am;
import com.google.android.gms.internal.p211j.ba;

/* renamed from: com.google.android.gms.location.m */
public class C5082m {
    /* renamed from: a */
    public static final C2781a<Object> f17381a = new C2781a("LocationServices.API", f17386f, f17385e);
    @Deprecated
    /* renamed from: b */
    public static final C5074d f17382b = new ba();
    @Deprecated
    /* renamed from: c */
    public static final C5077g f17383c = new C6799g();
    @Deprecated
    /* renamed from: d */
    public static final C5085r f17384d = new am();
    /* renamed from: e */
    private static final C4341g<aa> f17385e = new C4341g();
    /* renamed from: f */
    private static final C4337a<aa, Object> f17386f = new C7840w();

    /* renamed from: com.google.android.gms.location.m$a */
    public static abstract class C8225a<R extends C2814k> extends C4770a<R, aa> {
        public C8225a(GoogleApiClient googleApiClient) {
            super(C5082m.f17381a, googleApiClient);
        }
    }

    /* renamed from: a */
    public static aa m21573a(GoogleApiClient googleApiClient) {
        boolean z = false;
        C2872v.b(googleApiClient != null, "GoogleApiClient parameter is required.");
        aa aaVar = (aa) googleApiClient.a(f17385e);
        if (aaVar != null) {
            z = true;
        }
        C2872v.a(z, "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
        return aaVar;
    }

    /* renamed from: a */
    public static C6833h m21574a(Context context) {
        return new C6833h(context);
    }

    /* renamed from: b */
    public static C6832e m21575b(Context context) {
        return new C6832e(context);
    }
}
