package com.facebook.ads.internal.adapters;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.p085a.C1299d;
import com.facebook.ads.internal.p085a.C1301e;
import com.facebook.ads.internal.p085a.C1301e.C1300a;
import com.facebook.ads.internal.p095j.C1399c;
import com.facebook.ads.internal.p105q.p106a.C1508k;
import com.facebook.appevents.UserDataStore;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.adapters.p */
public class C3568p implements C1300a {
    /* renamed from: a */
    private final String f9521a;
    /* renamed from: b */
    private final String f9522b;
    /* renamed from: c */
    private final C1299d f9523c;
    /* renamed from: d */
    private final Collection<String> f9524d;
    /* renamed from: e */
    private final Map<String, String> f9525e;
    /* renamed from: f */
    private final String f9526f;
    /* renamed from: g */
    private final int f9527g;
    /* renamed from: h */
    private final int f9528h;
    /* renamed from: i */
    private final int f9529i;
    /* renamed from: j */
    private final String f9530j;

    private C3568p(String str, String str2, C1299d c1299d, Collection<String> collection, Map<String, String> map, String str3, int i, int i2, int i3, String str4) {
        this.f9521a = str;
        this.f9522b = str2;
        this.f9523c = c1299d;
        this.f9524d = collection;
        this.f9525e = map;
        this.f9526f = str3;
        this.f9527g = i;
        this.f9528h = i2;
        this.f9529i = i3;
        this.f9530j = str4;
    }

    /* renamed from: a */
    public static C3568p m11558a(Bundle bundle) {
        return new C3568p(C1399c.m4799a(bundle.getByteArray("markup")), null, C1299d.NONE, null, null, bundle.getString("request_id"), bundle.getInt("viewability_check_initial_delay"), bundle.getInt("viewability_check_interval"), bundle.getInt("skip_after_seconds", 0), bundle.getString(UserDataStore.CITY));
    }

    /* renamed from: a */
    public static C3568p m11559a(JSONObject jSONObject) {
        JSONArray jSONArray = null;
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("markup");
        String optString2 = jSONObject.optString("activation_command");
        String optString3 = jSONObject.optString("request_id");
        String a = C1508k.m5307a(jSONObject, UserDataStore.CITY);
        C1299d a2 = C1299d.m4446a(jSONObject.optString("invalidation_behavior"));
        try {
            jSONArray = new JSONArray(jSONObject.optString("detection_strings"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Collection a3 = C1301e.m4450a(jSONArray);
        jSONObject = jSONObject.optJSONObject("metadata");
        Map hashMap = new HashMap();
        if (jSONObject != null) {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                hashMap.put(str, jSONObject.optString(str));
            }
        }
        return new C3568p(optString, optString2, a2, a3, hashMap, optString3, hashMap.containsKey("viewability_check_initial_delay") ? Integer.parseInt((String) hashMap.get("viewability_check_initial_delay")) : 0, hashMap.containsKey("viewability_check_interval") ? Integer.parseInt((String) hashMap.get("viewability_check_interval")) : 1000, hashMap.containsKey("skip_after_seconds") ? Integer.parseInt((String) hashMap.get("skip_after_seconds")) : 0, a);
    }

    /* renamed from: b */
    public static C3568p m11560b(Intent intent) {
        return new C3568p(C1399c.m4799a(intent.getByteArrayExtra("markup")), intent.getStringExtra("activation_command"), C1299d.NONE, null, null, intent.getStringExtra("request_id"), intent.getIntExtra("viewability_check_initial_delay", 0), intent.getIntExtra("viewability_check_interval", 1000), intent.getIntExtra(AudienceNetworkActivity.SKIP_DELAY_SECONDS_KEY, 0), intent.getStringExtra(UserDataStore.CITY));
    }

    /* renamed from: a */
    public C1299d mo934a() {
        return this.f9523c;
    }

    /* renamed from: a */
    public void m11562a(Intent intent) {
        intent.putExtra("markup", C1399c.m4800a(this.f9521a));
        intent.putExtra("activation_command", this.f9522b);
        intent.putExtra("request_id", this.f9526f);
        intent.putExtra("viewability_check_initial_delay", this.f9527g);
        intent.putExtra("viewability_check_interval", this.f9528h);
        intent.putExtra(AudienceNetworkActivity.SKIP_DELAY_SECONDS_KEY, this.f9529i);
        intent.putExtra(UserDataStore.CITY, this.f9530j);
    }

    /* renamed from: b */
    public Collection<String> mo935b() {
        return this.f9524d;
    }

    /* renamed from: c */
    public String mo936c() {
        return this.f9530j;
    }

    /* renamed from: d */
    public String m11565d() {
        return this.f9521a;
    }

    /* renamed from: e */
    public String m11566e() {
        return this.f9522b;
    }

    /* renamed from: f */
    public Map<String, String> m11567f() {
        return this.f9525e;
    }

    /* renamed from: g */
    public String m11568g() {
        return this.f9526f;
    }

    /* renamed from: h */
    public int m11569h() {
        return this.f9527g;
    }

    /* renamed from: i */
    public int m11570i() {
        return this.f9528h;
    }

    /* renamed from: j */
    public Bundle m11571j() {
        Bundle bundle = new Bundle();
        bundle.putByteArray("markup", C1399c.m4800a(this.f9521a));
        bundle.putString("request_id", this.f9526f);
        bundle.putInt("viewability_check_initial_delay", this.f9527g);
        bundle.putInt("viewability_check_interval", this.f9528h);
        bundle.putInt("skip_after_seconds", this.f9529i);
        bundle.putString(UserDataStore.CITY, this.f9530j);
        return bundle;
    }
}
