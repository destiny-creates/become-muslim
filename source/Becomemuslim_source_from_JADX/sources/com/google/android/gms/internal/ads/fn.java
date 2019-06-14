package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import org.json.JSONObject;

@cm
public final class fn extends fp {
    /* renamed from: a */
    private final Object f24074a = new Object();
    /* renamed from: b */
    private final Context f24075b;
    /* renamed from: c */
    private SharedPreferences f24076c;
    /* renamed from: d */
    private final bbp<JSONObject, JSONObject> f24077d;

    public fn(Context context, bbp<JSONObject, JSONObject> bbp) {
        this.f24075b = context.getApplicationContext();
        this.f24077d = bbp;
    }

    /* renamed from: a */
    public final no<Void> mo4241a() {
        synchronized (this.f24074a) {
            if (this.f24076c == null) {
                this.f24076c = this.f24075b.getSharedPreferences("google_ads_flags_meta", 0);
            }
        }
        if (ax.l().a() - this.f24076c.getLong("js_last_update", 0) < ((Long) aph.m18688f().m18889a(asp.bU)).longValue()) {
            return nd.m19938a(null);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("js", mv.m37566a().f28709a);
            jSONObject.put("mf", aph.m18688f().m18889a(asp.bV));
            jSONObject.put("cl", "193400285");
            jSONObject.put("rapid_rc", "dev");
            jSONObject.put("rapid_rollup", "HEAD");
            jSONObject.put("dynamite_version", ModuleDescriptor.MODULE_VERSION);
            return nd.m19941a(this.f24077d.mo6092b(jSONObject), new fo(this), nu.f15847b);
        } catch (Throwable e) {
            mt.m19919b("Unable to populate SDK Core Constants parameters.", e);
            return nd.m19938a(null);
        }
    }

    /* renamed from: a */
    final /* synthetic */ Void m30717a(JSONObject jSONObject) {
        asp.m18893a(this.f24075b, 1, jSONObject);
        this.f24076c.edit().putLong("js_last_update", ax.l().a()).apply();
        return null;
    }
}
