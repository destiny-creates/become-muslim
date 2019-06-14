package com.stripe.android;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.stripe.android.p285b.C5729q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: EphemeralKey */
/* renamed from: com.stripe.android.c */
class C7170c extends C5729q implements Parcelable {
    public static final Creator<C7170c> CREATOR = new C57321();
    /* renamed from: a */
    private long f25423a;
    /* renamed from: b */
    private String f25424b;
    /* renamed from: c */
    private long f25425c;
    /* renamed from: d */
    private String f25426d;
    /* renamed from: e */
    private boolean f25427e;
    /* renamed from: f */
    private String f25428f;
    /* renamed from: g */
    private String f25429g;
    /* renamed from: h */
    private String f25430h;

    /* compiled from: EphemeralKey */
    /* renamed from: com.stripe.android.c$1 */
    static class C57321 implements Creator<C7170c> {
        C57321() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m24292a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m24293a(i);
        }

        /* renamed from: a */
        public C7170c m24292a(Parcel parcel) {
            return new C7170c(parcel);
        }

        /* renamed from: a */
        public C7170c[] m24293a(int i) {
            return new C7170c[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    private C7170c(Parcel parcel) {
        this.f25423a = parcel.readLong();
        this.f25424b = parcel.readString();
        this.f25425c = parcel.readLong();
        this.f25426d = parcel.readString();
        boolean z = true;
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.f25427e = z;
        this.f25428f = parcel.readString();
        this.f25429g = parcel.readString();
        this.f25430h = parcel.readString();
    }

    /* renamed from: a */
    public org.json.JSONObject mo5065a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = new org.json.JSONObject;
        r0.<init>();
        r1 = new org.json.JSONArray;
        r1.<init>();
        r2 = new org.json.JSONObject;
        r2.<init>();
        r3 = "created";	 Catch:{ JSONException -> 0x0050 }
        r4 = r6.f25423a;	 Catch:{ JSONException -> 0x0050 }
        r0.put(r3, r4);	 Catch:{ JSONException -> 0x0050 }
        r3 = "expires";	 Catch:{ JSONException -> 0x0050 }
        r4 = r6.f25425c;	 Catch:{ JSONException -> 0x0050 }
        r0.put(r3, r4);	 Catch:{ JSONException -> 0x0050 }
        r3 = "object";	 Catch:{ JSONException -> 0x0050 }
        r4 = r6.f25428f;	 Catch:{ JSONException -> 0x0050 }
        r0.put(r3, r4);	 Catch:{ JSONException -> 0x0050 }
        r3 = "id";	 Catch:{ JSONException -> 0x0050 }
        r4 = r6.f25426d;	 Catch:{ JSONException -> 0x0050 }
        r0.put(r3, r4);	 Catch:{ JSONException -> 0x0050 }
        r3 = "secret";	 Catch:{ JSONException -> 0x0050 }
        r4 = r6.f25429g;	 Catch:{ JSONException -> 0x0050 }
        r0.put(r3, r4);	 Catch:{ JSONException -> 0x0050 }
        r3 = "livemode";	 Catch:{ JSONException -> 0x0050 }
        r4 = r6.f25427e;	 Catch:{ JSONException -> 0x0050 }
        r0.put(r3, r4);	 Catch:{ JSONException -> 0x0050 }
        r3 = "type";	 Catch:{ JSONException -> 0x0050 }
        r4 = r6.f25430h;	 Catch:{ JSONException -> 0x0050 }
        r2.put(r3, r4);	 Catch:{ JSONException -> 0x0050 }
        r3 = "id";	 Catch:{ JSONException -> 0x0050 }
        r4 = r6.f25424b;	 Catch:{ JSONException -> 0x0050 }
        r2.put(r3, r4);	 Catch:{ JSONException -> 0x0050 }
        r1.put(r2);	 Catch:{ JSONException -> 0x0050 }
        r2 = "associated_objects";	 Catch:{ JSONException -> 0x0050 }
        r0.put(r2, r1);	 Catch:{ JSONException -> 0x0050 }
        return r0;
    L_0x0050:
        r0 = new java.lang.IllegalArgumentException;
        r1 = "JSONObject creation exception thrown.";
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.c.a():org.json.JSONObject");
    }

    /* renamed from: b */
    public Map<String, Object> mo5066b() {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("created", Long.valueOf(this.f25423a));
        hashMap.put("expires", Long.valueOf(this.f25425c));
        hashMap.put("object", this.f25428f);
        hashMap.put("id", this.f25426d);
        hashMap.put("secret", this.f25429g);
        hashMap.put("livemode", Boolean.valueOf(this.f25427e));
        List arrayList = new ArrayList();
        Map hashMap2 = new HashMap();
        hashMap2.put("id", this.f25424b);
        hashMap2.put("type", this.f25430h);
        arrayList.add(hashMap2);
        hashMap.put("associated_objects", arrayList);
        return hashMap;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f25423a);
        parcel.writeString(this.f25424b);
        parcel.writeLong(this.f25425c);
        parcel.writeString(this.f25426d);
        parcel.writeInt(this.f25427e);
        parcel.writeString(this.f25428f);
        parcel.writeString(this.f25429g);
        parcel.writeString(this.f25430h);
    }

    /* renamed from: c */
    String m33373c() {
        return this.f25424b;
    }

    /* renamed from: d */
    long m33374d() {
        return this.f25425c;
    }

    /* renamed from: e */
    String m33375e() {
        return this.f25429g;
    }
}
