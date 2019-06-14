package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@cm
public final class ia extends C4363a {
    public static final Creator<ia> CREATOR = new ib();
    /* renamed from: a */
    public final String f28693a;
    /* renamed from: b */
    public final String f28694b;
    /* renamed from: c */
    public final boolean f28695c;
    /* renamed from: d */
    public final boolean f28696d;
    /* renamed from: e */
    public final List<String> f28697e;
    /* renamed from: f */
    public final boolean f28698f;
    /* renamed from: g */
    public final boolean f28699g;
    /* renamed from: h */
    public final List<String> f28700h;

    public ia(String str, String str2, boolean z, boolean z2, List<String> list, boolean z3, boolean z4, List<String> list2) {
        List arrayList;
        this.f28693a = str;
        this.f28694b = str2;
        this.f28695c = z;
        this.f28696d = z2;
        this.f28697e = list;
        this.f28698f = z3;
        this.f28699g = z4;
        if (list2 == null) {
            arrayList = new ArrayList();
        }
        this.f28700h = arrayList;
    }

    /* renamed from: a */
    public static ia m37548a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new ia(jSONObject.optString("click_string", ""), jSONObject.optString("report_url", ""), jSONObject.optBoolean("rendered_ad_enabled", false), jSONObject.optBoolean("non_malicious_reporting_enabled", false), lr.m19836a(jSONObject.optJSONArray("allowed_headers"), null), jSONObject.optBoolean("protection_enabled", false), jSONObject.optBoolean("malicious_reporting_enabled", false), lr.m19836a(jSONObject.optJSONArray("webview_permissions"), null));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f28693a, false);
        C2835c.a(parcel, 3, this.f28694b, false);
        C2835c.a(parcel, 4, this.f28695c);
        C2835c.a(parcel, 5, this.f28696d);
        C2835c.b(parcel, 6, this.f28697e, false);
        C2835c.a(parcel, 7, this.f28698f);
        C2835c.a(parcel, 8, this.f28699g);
        C2835c.b(parcel, 9, this.f28700h, false);
        C2835c.a(parcel, i);
    }
}
