package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import java.util.List;

@cm
public final class amq extends C4363a {
    public static final Creator<amq> CREATOR = new amr();
    /* renamed from: a */
    public final String f28117a;
    /* renamed from: b */
    private final long f28118b;
    /* renamed from: c */
    private final String f28119c;
    /* renamed from: d */
    private final String f28120d;
    /* renamed from: e */
    private final String f28121e;
    /* renamed from: f */
    private final Bundle f28122f;
    /* renamed from: g */
    private final boolean f28123g;
    /* renamed from: h */
    private long f28124h;

    amq(String str, long j, String str2, String str3, String str4, Bundle bundle, boolean z, long j2) {
        this.f28117a = str;
        this.f28118b = j;
        if (str2 == null) {
            str2 = "";
        }
        this.f28119c = str2;
        if (str3 == null) {
            str3 = "";
        }
        this.f28120d = str3;
        if (str4 == null) {
            str4 = "";
        }
        this.f28121e = str4;
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.f28122f = bundle;
        this.f28123g = z;
        this.f28124h = j2;
    }

    /* renamed from: a */
    public static amq m36801a(Uri uri) {
        try {
            if (!"gcache".equals(uri.getScheme())) {
                return null;
            }
            List pathSegments = uri.getPathSegments();
            if (pathSegments.size() != 2) {
                int size = pathSegments.size();
                StringBuilder stringBuilder = new StringBuilder(62);
                stringBuilder.append("Expected 2 path parts for namespace and id, found :");
                stringBuilder.append(size);
                mt.m19924e(stringBuilder.toString());
                return null;
            }
            String str = (String) pathSegments.get(0);
            String str2 = (String) pathSegments.get(1);
            String host = uri.getHost();
            String queryParameter = uri.getQueryParameter("url");
            boolean equals = AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(uri.getQueryParameter("read_only"));
            String queryParameter2 = uri.getQueryParameter("expiration");
            long parseLong = queryParameter2 == null ? 0 : Long.parseLong(queryParameter2);
            Bundle bundle = new Bundle();
            for (String str3 : ax.g().mo6102a(uri)) {
                if (str3.startsWith("tag.")) {
                    bundle.putString(str3.substring(4), uri.getQueryParameter(str3));
                }
            }
            return new amq(queryParameter, parseLong, host, str, str2, bundle, equals, 0);
        } catch (Throwable e) {
            mt.m19921c("Unable to parse Uri into cache offering.", e);
            return null;
        }
    }

    /* renamed from: a */
    public static amq m36802a(String str) {
        return m36801a(Uri.parse(str));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f28117a, false);
        C2835c.a(parcel, 3, this.f28118b);
        C2835c.a(parcel, 4, this.f28119c, false);
        C2835c.a(parcel, 5, this.f28120d, false);
        C2835c.a(parcel, 6, this.f28121e, false);
        C2835c.a(parcel, 7, this.f28122f, false);
        C2835c.a(parcel, 8, this.f28123g);
        C2835c.a(parcel, 9, this.f28124h);
        C2835c.a(parcel, i);
    }
}
