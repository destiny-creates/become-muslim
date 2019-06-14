package io.p347a.p348a.p349a.p350a.p358g;

import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareConstants;
import io.p347a.p348a.p349a.p350a.p352b.C6430k;
import org.json.JSONObject;

/* compiled from: DefaultSettingsJsonTransform */
/* renamed from: io.a.a.a.a.g.k */
class C7623k implements C6509v {
    C7623k() {
    }

    /* renamed from: a */
    public C6507t mo5469a(C6430k c6430k, JSONObject jSONObject) {
        int optInt = jSONObject.optInt("settings_version", 0);
        int optInt2 = jSONObject.optInt("cache_duration", 3600);
        return new C6507t(m34416a(c6430k, (long) optInt2, jSONObject), m34417a(jSONObject.getJSONObject("app")), m34421e(jSONObject.getJSONObject("session")), m34422f(jSONObject.getJSONObject("prompt")), m34419c(jSONObject.getJSONObject("features")), m34420d(jSONObject.getJSONObject("analytics")), m34423g(jSONObject.getJSONObject("beta")), optInt, optInt2);
    }

    /* renamed from: a */
    private C6494e m34417a(JSONObject jSONObject) {
        String string = jSONObject.getString("identifier");
        String string2 = jSONObject.getString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
        String string3 = jSONObject.getString("url");
        String string4 = jSONObject.getString("reports_url");
        boolean optBoolean = jSONObject.optBoolean("update_required", false);
        jSONObject = (jSONObject.has("icon") && jSONObject.getJSONObject("icon").has("hash")) ? m34418b(jSONObject.getJSONObject("icon")) : null;
        return new C6494e(string, string2, string3, string4, optBoolean, jSONObject);
    }

    /* renamed from: b */
    private C6492c m34418b(JSONObject jSONObject) {
        return new C6492c(jSONObject.getString("hash"), jSONObject.getInt("width"), jSONObject.getInt("height"));
    }

    /* renamed from: c */
    private C6497m m34419c(JSONObject jSONObject) {
        return new C6497m(jSONObject.optBoolean("prompt_enabled", false), jSONObject.optBoolean("collect_logged_exceptions", true), jSONObject.optBoolean("collect_reports", true), jSONObject.optBoolean("collect_analytics", false));
    }

    /* renamed from: d */
    private C6491b m34420d(JSONObject jSONObject) {
        return new C6491b(jSONObject.optString("url", "https://e.crashlytics.com/spi/v2/events"), jSONObject.optInt("flush_interval_secs", 600), jSONObject.optInt("max_byte_size_per_file", 8000), jSONObject.optInt("max_file_count_per_send", 1), jSONObject.optInt("max_pending_send_file_count", 100), jSONObject.optBoolean("track_custom_events", true), jSONObject.optBoolean("track_predefined_events", true), jSONObject.optInt("sampling_rate", 1), jSONObject.optBoolean("flush_on_background", true));
    }

    /* renamed from: e */
    private C6500p m34421e(JSONObject jSONObject) {
        return new C6500p(jSONObject.optInt("log_buffer_size", 64000), jSONObject.optInt("max_chained_exception_depth", 8), jSONObject.optInt("max_custom_exception_events", 64), jSONObject.optInt("max_custom_key_value_pairs", 64), jSONObject.optInt("identifier_mask", JfifUtil.MARKER_FIRST_BYTE), jSONObject.optBoolean("send_session_without_crash", false));
    }

    /* renamed from: f */
    private C6499o m34422f(JSONObject jSONObject) {
        return new C6499o(jSONObject.optString("title", "Send Crash Report?"), jSONObject.optString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "Looks like we crashed! Please help us fix the problem by sending a crash report."), jSONObject.optString("send_button_title", "Send"), jSONObject.optBoolean("show_cancel_button", true), jSONObject.optString("cancel_button_title", "Don't Send"), jSONObject.optBoolean("show_always_send_button", true), jSONObject.optString("always_send_button_title", "Always Send"));
    }

    /* renamed from: g */
    private C6495f m34423g(JSONObject jSONObject) {
        return new C6495f(jSONObject.optString("update_endpoint", C6508u.f20975a), jSONObject.optInt("update_suspend_duration", 3600));
    }

    /* renamed from: a */
    private long m34416a(C6430k c6430k, long j, JSONObject jSONObject) {
        if (jSONObject.has("expires_at")) {
            return jSONObject.getLong("expires_at");
        }
        return c6430k.mo5438a() + (j * 1000);
    }
}
