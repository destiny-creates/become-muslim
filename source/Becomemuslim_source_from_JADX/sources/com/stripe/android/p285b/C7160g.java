package com.stripe.android.p285b;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.places.model.PlaceFields;
import com.stripe.android.C5772r;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: ShippingInformation */
/* renamed from: com.stripe.android.b.g */
public class C7160g extends C5729q implements Parcelable {
    public static final Creator<C7160g> CREATOR = new C57261();
    /* renamed from: a */
    private C7156a f25354a;
    /* renamed from: b */
    private String f25355b;
    /* renamed from: c */
    private String f25356c;

    /* compiled from: ShippingInformation */
    /* renamed from: com.stripe.android.b.g$1 */
    static class C57261 implements Creator<C7160g> {
        C57261() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m24244a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m24245a(i);
        }

        /* renamed from: a */
        public C7160g m24244a(Parcel parcel) {
            return new C7160g(parcel);
        }

        /* renamed from: a */
        public C7160g[] m24245a(int i) {
            return new C7160g[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public C7160g(C7156a c7156a, String str, String str2) {
        this.f25354a = c7156a;
        this.f25355b = str;
        this.f25356c = str2;
    }

    /* renamed from: c */
    public C7156a m33265c() {
        return this.f25354a;
    }

    /* renamed from: d */
    public String m33266d() {
        return this.f25355b;
    }

    /* renamed from: e */
    public String m33267e() {
        return this.f25356c;
    }

    /* renamed from: a */
    public static C7160g m33262a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        C7160g c7160g = new C7160g();
        c7160g.f25355b = C5730r.m24288d(jSONObject, "name");
        c7160g.f25356c = C5730r.m24288d(jSONObject, PlaceFields.PHONE);
        c7160g.f25354a = C7156a.m33204a(jSONObject.optJSONObject("address"));
        return c7160g;
    }

    /* renamed from: a */
    public JSONObject mo5065a() {
        JSONObject jSONObject = new JSONObject();
        C5730r.m24283a(jSONObject, "name", this.f25355b);
        C5730r.m24283a(jSONObject, PlaceFields.PHONE, this.f25356c);
        C5729q.m24270a(jSONObject, "address", this.f25354a);
        return jSONObject;
    }

    /* renamed from: b */
    public Map<String, Object> mo5066b() {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("name", this.f25355b);
        hashMap.put(PlaceFields.PHONE, this.f25356c);
        C5729q.m24268a((Map) hashMap, "address", this.f25354a);
        C5772r.m24411a(hashMap);
        return hashMap;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f25354a, i);
        parcel.writeString(this.f25355b);
        parcel.writeString(this.f25356c);
    }

    protected C7160g(Parcel parcel) {
        this.f25354a = (C7156a) parcel.readParcelable(C7156a.class.getClassLoader());
        this.f25355b = parcel.readString();
        this.f25356c = parcel.readString();
    }
}
