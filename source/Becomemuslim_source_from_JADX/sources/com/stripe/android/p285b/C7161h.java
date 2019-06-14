package com.stripe.android.p285b;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Currency;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: ShippingMethod */
/* renamed from: com.stripe.android.b.h */
public class C7161h extends C5729q implements Parcelable {
    public static final Creator<C7161h> CREATOR = new C57271();
    /* renamed from: a */
    private long f25357a;
    /* renamed from: b */
    private String f25358b;
    /* renamed from: c */
    private String f25359c;
    /* renamed from: d */
    private String f25360d;
    /* renamed from: e */
    private String f25361e;

    /* compiled from: ShippingMethod */
    /* renamed from: com.stripe.android.b.h$1 */
    static class C57271 implements Creator<C7161h> {
        C57271() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m24246a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m24247a(i);
        }

        /* renamed from: a */
        public C7161h m24246a(Parcel parcel) {
            return new C7161h(parcel);
        }

        /* renamed from: a */
        public C7161h[] m24247a(int i) {
            return new C7161h[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: c */
    public Currency m33270c() {
        return Currency.getInstance(this.f25358b);
    }

    /* renamed from: d */
    public long m33271d() {
        return this.f25357a;
    }

    /* renamed from: e */
    public String m33272e() {
        return this.f25361e;
    }

    /* renamed from: f */
    public String m33273f() {
        return this.f25359c;
    }

    /* renamed from: a */
    public JSONObject mo5065a() {
        JSONObject jSONObject = new JSONObject();
        C5730r.m24282a(jSONObject, "amount", Long.valueOf(this.f25357a));
        C5730r.m24283a(jSONObject, "currency_code", this.f25358b);
        C5730r.m24283a(jSONObject, "detail", this.f25359c);
        C5730r.m24283a(jSONObject, "identifier", this.f25360d);
        C5730r.m24283a(jSONObject, "label", this.f25361e);
        return jSONObject;
    }

    /* renamed from: b */
    public Map<String, Object> mo5066b() {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("amount", Long.valueOf(this.f25357a));
        hashMap.put("currency_code", this.f25358b);
        hashMap.put("detail", this.f25359c);
        hashMap.put("identifier", this.f25360d);
        hashMap.put("label", this.f25361e);
        return hashMap;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f25357a);
        parcel.writeString(this.f25358b);
        parcel.writeString(this.f25359c);
        parcel.writeString(this.f25360d);
        parcel.writeString(this.f25361e);
    }

    private C7161h(Parcel parcel) {
        this.f25357a = parcel.readLong();
        this.f25358b = parcel.readString();
        this.f25359c = parcel.readString();
        this.f25360d = parcel.readString();
        this.f25361e = parcel.readString();
    }
}
