package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@cm
public final class dr extends C4363a {
    public static final Creator<dr> CREATOR = new ds();
    /* renamed from: a */
    public final boolean f28622a;
    /* renamed from: b */
    public final List<String> f28623b;

    public dr() {
        this(false, Collections.emptyList());
    }

    public dr(boolean z, List<String> list) {
        this.f28622a = z;
        this.f28623b = list;
    }

    /* renamed from: a */
    public static dr m37459a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new dr();
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("reporting_urls");
        List arrayList = new ArrayList();
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    arrayList.add(optJSONArray.getString(i));
                } catch (Throwable e) {
                    mt.m19921c("Error grabbing url from json.", e);
                }
            }
        }
        return new dr(jSONObject.optBoolean("enable_protection"), arrayList);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f28622a);
        C2835c.b(parcel, 3, this.f28623b, false);
        C2835c.a(parcel, i);
    }
}
