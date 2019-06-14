package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import com.google.android.gms.common.util.C2895e;
import com.google.android.gms.common.util.C4376h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class GoogleSignInAccount extends C4363a implements ReflectedParcelable {
    public static final Creator<GoogleSignInAccount> CREATOR = new C2738g();
    /* renamed from: a */
    private static C2895e f13114a = C4376h.m14397d();
    /* renamed from: b */
    private final int f13115b;
    /* renamed from: c */
    private String f13116c;
    /* renamed from: d */
    private String f13117d;
    /* renamed from: e */
    private String f13118e;
    /* renamed from: f */
    private String f13119f;
    /* renamed from: g */
    private Uri f13120g;
    /* renamed from: h */
    private String f13121h;
    /* renamed from: i */
    private long f13122i;
    /* renamed from: j */
    private String f13123j;
    /* renamed from: k */
    private List<Scope> f13124k;
    /* renamed from: l */
    private String f13125l;
    /* renamed from: m */
    private String f13126m;
    /* renamed from: n */
    private Set<Scope> f13127n = new HashSet();

    /* renamed from: a */
    public static GoogleSignInAccount m16654a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        str = jSONObject.optString("photoUrl", null);
        Uri parse = !TextUtils.isEmpty(str) ? Uri.parse(str) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        Set hashSet = new HashSet();
        str = jSONObject.getJSONArray("grantedScopes");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(str.getString(i)));
        }
        str = m16655a(jSONObject.optString("id"), jSONObject.optString("tokenId", null), jSONObject.optString("email", null), jSONObject.optString("displayName", null), jSONObject.optString("givenName", null), jSONObject.optString("familyName", null), parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        str.f13121h = jSONObject.optString("serverAuthCode", null);
        return str;
    }

    /* renamed from: a */
    private static GoogleSignInAccount m16655a(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l, String str7, Set<Scope> set) {
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, (l == null ? Long.valueOf(f13114a.mo2482a() / 1000) : l).longValue(), C2872v.m8382a(str7), new ArrayList((Collection) C2872v.m8380a((Object) set)), str5, str6);
    }

    GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, List<Scope> list, String str7, String str8) {
        this.f13115b = i;
        this.f13116c = str;
        this.f13117d = str2;
        this.f13118e = str3;
        this.f13119f = str4;
        this.f13120g = uri;
        this.f13121h = str5;
        this.f13122i = j;
        this.f13123j = str6;
        this.f13124k = list;
        this.f13125l = str7;
        this.f13126m = str8;
    }

    /* renamed from: a */
    public String m16657a() {
        return this.f13116c;
    }

    /* renamed from: b */
    public String m16658b() {
        return this.f13117d;
    }

    /* renamed from: c */
    public String m16659c() {
        return this.f13118e;
    }

    /* renamed from: d */
    public Account m16660d() {
        return this.f13118e == null ? null : new Account(this.f13118e, "com.google");
    }

    /* renamed from: e */
    public String m16661e() {
        return this.f13119f;
    }

    /* renamed from: f */
    public String m16662f() {
        return this.f13125l;
    }

    /* renamed from: g */
    public String m16663g() {
        return this.f13126m;
    }

    /* renamed from: h */
    public Uri m16664h() {
        return this.f13120g;
    }

    /* renamed from: i */
    public String m16665i() {
        return this.f13121h;
    }

    /* renamed from: j */
    public boolean m16666j() {
        return f13114a.mo2482a() / 1000 >= this.f13122i - 300;
    }

    /* renamed from: k */
    public final String m16667k() {
        return this.f13123j;
    }

    /* renamed from: l */
    public Set<Scope> m16668l() {
        return new HashSet(this.f13124k);
    }

    /* renamed from: m */
    public Set<Scope> m16669m() {
        Set<Scope> hashSet = new HashSet(this.f13124k);
        hashSet.addAll(this.f13127n);
        return hashSet;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.m8179a(parcel);
        C2835c.m8184a(parcel, 1, this.f13115b);
        C2835c.m8193a(parcel, 2, m16657a(), false);
        C2835c.m8193a(parcel, 3, m16658b(), false);
        C2835c.m8193a(parcel, 4, m16659c(), false);
        C2835c.m8193a(parcel, 5, m16661e(), false);
        C2835c.m8188a(parcel, 6, m16664h(), i, false);
        C2835c.m8193a(parcel, 7, m16665i(), false);
        C2835c.m8185a(parcel, 8, this.f13122i);
        C2835c.m8193a(parcel, 9, this.f13123j, false);
        C2835c.m8207c(parcel, 10, this.f13124k, false);
        C2835c.m8193a(parcel, 11, m16662f(), false);
        C2835c.m8193a(parcel, 12, m16663g(), false);
        C2835c.m8180a(parcel, a);
    }

    public int hashCode() {
        return ((this.f13123j.hashCode() + 527) * 31) + m16669m().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        return googleSignInAccount.f13123j.equals(this.f13123j) && googleSignInAccount.m16669m().equals(m16669m()) != null;
    }

    /* renamed from: n */
    public final String m16670n() {
        JSONObject o = m16656o();
        o.remove("serverAuthCode");
        return o.toString();
    }

    /* renamed from: o */
    private final JSONObject m16656o() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (m16657a() != null) {
                jSONObject.put("id", m16657a());
            }
            if (m16658b() != null) {
                jSONObject.put("tokenId", m16658b());
            }
            if (m16659c() != null) {
                jSONObject.put("email", m16659c());
            }
            if (m16661e() != null) {
                jSONObject.put("displayName", m16661e());
            }
            if (m16662f() != null) {
                jSONObject.put("givenName", m16662f());
            }
            if (m16663g() != null) {
                jSONObject.put("familyName", m16663g());
            }
            if (m16664h() != null) {
                jSONObject.put("photoUrl", m16664h().toString());
            }
            if (m16665i() != null) {
                jSONObject.put("serverAuthCode", m16665i());
            }
            jSONObject.put("expirationTime", this.f13122i);
            jSONObject.put("obfuscatedIdentifier", this.f13123j);
            JSONArray jSONArray = new JSONArray();
            Scope[] scopeArr = (Scope[]) this.f13124k.toArray(new Scope[this.f13124k.size()]);
            Arrays.sort(scopeArr, C2737f.f7028a);
            for (Scope a : scopeArr) {
                jSONArray.put(a.m16700a());
            }
            jSONObject.put("grantedScopes", jSONArray);
            return jSONObject;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
