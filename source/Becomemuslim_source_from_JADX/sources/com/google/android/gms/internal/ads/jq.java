package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import org.json.JSONObject;

final class jq extends js {
    /* renamed from: a */
    private final /* synthetic */ Context f32211a;
    /* renamed from: b */
    private final /* synthetic */ jp f32212b;

    jq(jp jpVar, Context context) {
        this.f32212b = jpVar;
        this.f32211a = context;
        super();
    }

    /* renamed from: a */
    public final void mo6079a() {
        SharedPreferences sharedPreferences = this.f32211a.getSharedPreferences("admob", 0);
        Editor edit = sharedPreferences.edit();
        synchronized (this.f32212b.f15668b) {
            this.f32212b.f15671e = sharedPreferences;
            this.f32212b.f15667a = edit;
            this.f32212b.f15672f = jp.m19640n();
            this.f32212b.f15673g = this.f32212b.f15671e.getBoolean("use_https", this.f32212b.f15673g);
            this.f32212b.f15685s = this.f32212b.f15671e.getBoolean("content_url_opted_out", this.f32212b.f15685s);
            this.f32212b.f15674h = this.f32212b.f15671e.getString("content_url_hashes", this.f32212b.f15674h);
            this.f32212b.f15676j = this.f32212b.f15671e.getBoolean("auto_collect_location", this.f32212b.f15676j);
            this.f32212b.f15686t = this.f32212b.f15671e.getBoolean("content_vertical_opted_out", this.f32212b.f15686t);
            this.f32212b.f15675i = this.f32212b.f15671e.getString("content_vertical_hashes", this.f32212b.f15675i);
            this.f32212b.f15682p = this.f32212b.f15671e.getInt("version_code", this.f32212b.f15682p);
            this.f32212b.f15677k = this.f32212b.f15671e.getString("app_settings_json", this.f32212b.f15677k);
            this.f32212b.f15678l = this.f32212b.f15671e.getLong("app_settings_last_update_ms", this.f32212b.f15678l);
            this.f32212b.f15679m = this.f32212b.f15671e.getLong("app_last_background_time_ms", this.f32212b.f15679m);
            this.f32212b.f15681o = this.f32212b.f15671e.getInt("request_in_session_count", this.f32212b.f15681o);
            this.f32212b.f15680n = this.f32212b.f15671e.getLong("first_ad_req_time_ms", this.f32212b.f15680n);
            this.f32212b.f15683q = this.f32212b.f15671e.getStringSet("never_pool_slots", this.f32212b.f15683q);
            try {
                this.f32212b.f15684r = new JSONObject(this.f32212b.f15671e.getString("native_advanced_settings", "{}"));
            } catch (Throwable e) {
                mt.m19921c("Could not convert native advanced settings to json object", e);
            }
            this.f32212b.m19615a(this.f32212b.m19643p());
        }
    }
}
