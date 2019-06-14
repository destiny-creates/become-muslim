package com.stripe.android.p285b;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.appevents.UserDataStore;
import com.facebook.internal.ServerProtocol;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: Address */
/* renamed from: com.stripe.android.b.a */
public class C7156a extends C5729q implements Parcelable {
    public static final Creator<C7156a> CREATOR = new C57201();
    /* renamed from: a */
    private String f25309a;
    /* renamed from: b */
    private String f25310b;
    /* renamed from: c */
    private String f25311c;
    /* renamed from: d */
    private String f25312d;
    /* renamed from: e */
    private String f25313e;
    /* renamed from: f */
    private String f25314f;

    /* compiled from: Address */
    /* renamed from: com.stripe.android.b.a$1 */
    static class C57201 implements Creator<C7156a> {
        C57201() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m24169a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m24170a(i);
        }

        /* renamed from: a */
        public C7156a m24169a(Parcel parcel) {
            return new C7156a(parcel);
        }

        /* renamed from: a */
        public C7156a[] m24170a(int i) {
            return new C7156a[i];
        }
    }

    /* compiled from: Address */
    /* renamed from: com.stripe.android.b.a$a */
    public static class C5721a {
        /* renamed from: a */
        private String f19042a;
        /* renamed from: b */
        private String f19043b;
        /* renamed from: c */
        private String f19044c;
        /* renamed from: d */
        private String f19045d;
        /* renamed from: e */
        private String f19046e;
        /* renamed from: f */
        private String f19047f;

        /* renamed from: a */
        public C5721a m24177a(String str) {
            this.f19042a = str;
            return this;
        }

        /* renamed from: b */
        public C5721a m24179b(String str) {
            this.f19043b = str.toUpperCase();
            return this;
        }

        /* renamed from: c */
        public C5721a m24180c(String str) {
            this.f19044c = str;
            return this;
        }

        /* renamed from: d */
        public C5721a m24181d(String str) {
            this.f19045d = str;
            return this;
        }

        /* renamed from: e */
        public C5721a m24182e(String str) {
            this.f19046e = str;
            return this;
        }

        /* renamed from: f */
        public C5721a m24183f(String str) {
            this.f19047f = str;
            return this;
        }

        /* renamed from: a */
        public C7156a m24178a() {
            return new C7156a(this);
        }
    }

    public int describeContents() {
        return 0;
    }

    C7156a(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f25309a = str;
        this.f25310b = str2;
        this.f25311c = str3;
        this.f25312d = str4;
        this.f25313e = str5;
        this.f25314f = str6;
    }

    C7156a(C5721a c5721a) {
        this.f25309a = c5721a.f19042a;
        this.f25310b = c5721a.f19043b;
        this.f25311c = c5721a.f19044c;
        this.f25312d = c5721a.f19045d;
        this.f25313e = c5721a.f19046e;
        this.f25314f = c5721a.f19047f;
    }

    /* renamed from: c */
    public String m33207c() {
        return this.f25309a;
    }

    /* renamed from: d */
    public String m33208d() {
        return this.f25310b;
    }

    /* renamed from: e */
    public String m33209e() {
        return this.f25311c;
    }

    /* renamed from: f */
    public String m33210f() {
        return this.f25312d;
    }

    /* renamed from: g */
    public String m33211g() {
        return this.f25313e;
    }

    /* renamed from: h */
    public String m33212h() {
        return this.f25314f;
    }

    /* renamed from: b */
    public Map<String, Object> mo5066b() {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("city", this.f25309a);
        hashMap.put(UserDataStore.COUNTRY, this.f25310b);
        hashMap.put("line1", this.f25311c);
        hashMap.put("line2", this.f25312d);
        hashMap.put("postal_code", this.f25313e);
        hashMap.put(ServerProtocol.DIALOG_PARAM_STATE, this.f25314f);
        return hashMap;
    }

    /* renamed from: a */
    public JSONObject mo5065a() {
        JSONObject jSONObject = new JSONObject();
        C5730r.m24283a(jSONObject, "city", this.f25309a);
        C5730r.m24283a(jSONObject, UserDataStore.COUNTRY, this.f25310b);
        C5730r.m24283a(jSONObject, "line1", this.f25311c);
        C5730r.m24283a(jSONObject, "line2", this.f25312d);
        C5730r.m24283a(jSONObject, "postal_code", this.f25313e);
        C5730r.m24283a(jSONObject, ServerProtocol.DIALOG_PARAM_STATE, this.f25314f);
        return jSONObject;
    }

    /* renamed from: a */
    public static C7156a m33204a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new C7156a(C5730r.m24288d(jSONObject, "city"), C5730r.m24288d(jSONObject, UserDataStore.COUNTRY), C5730r.m24288d(jSONObject, "line1"), C5730r.m24288d(jSONObject, "line2"), C5730r.m24288d(jSONObject, "postal_code"), C5730r.m24288d(jSONObject, ServerProtocol.DIALOG_PARAM_STATE));
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f25309a);
        parcel.writeString(this.f25310b);
        parcel.writeString(this.f25311c);
        parcel.writeString(this.f25312d);
        parcel.writeString(this.f25313e);
        parcel.writeString(this.f25314f);
    }

    protected C7156a(Parcel parcel) {
        this.f25309a = parcel.readString();
        this.f25310b = parcel.readString();
        this.f25311c = parcel.readString();
        this.f25312d = parcel.readString();
        this.f25313e = parcel.readString();
        this.f25314f = parcel.readString();
    }
}
