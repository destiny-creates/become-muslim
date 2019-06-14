package com.google.android.gms.internal.p213l;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Pair;
import com.amplitude.api.Constants;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import java.math.BigInteger;
import java.util.Locale;

/* renamed from: com.google.android.gms.internal.l.bm */
final class bm extends dc {
    /* renamed from: a */
    static final Pair<String, Long> f32324a = new Pair("", Long.valueOf(0));
    /* renamed from: b */
    public bq f32325b;
    /* renamed from: c */
    public final bp f32326c = new bp(this, "last_upload", 0);
    /* renamed from: d */
    public final bp f32327d = new bp(this, "last_upload_attempt", 0);
    /* renamed from: e */
    public final bp f32328e = new bp(this, "backoff", 0);
    /* renamed from: f */
    public final bp f32329f = new bp(this, "last_delete_stale", 0);
    /* renamed from: g */
    public final bp f32330g = new bp(this, "midnight_offset", 0);
    /* renamed from: h */
    public final bp f32331h = new bp(this, "first_open_time", 0);
    /* renamed from: i */
    public final bp f32332i = new bp(this, "app_install_time", 0);
    /* renamed from: j */
    public final br f32333j = new br(this, "app_instance_id", null);
    /* renamed from: k */
    public final bp f32334k = new bp(this, "time_before_start", 10000);
    /* renamed from: l */
    public final bp f32335l = new bp(this, "session_timeout", Constants.SESSION_TIMEOUT_MILLIS);
    /* renamed from: m */
    public final bo f32336m = new bo(this, "start_new_session", true);
    /* renamed from: n */
    public final bp f32337n = new bp(this, "last_pause_time", 0);
    /* renamed from: o */
    public final bp f32338o = new bp(this, "time_active", 0);
    /* renamed from: p */
    public boolean f32339p;
    /* renamed from: r */
    private SharedPreferences f32340r;
    /* renamed from: s */
    private String f32341s;
    /* renamed from: t */
    private boolean f32342t;
    /* renamed from: u */
    private long f32343u;
    /* renamed from: v */
    private String f32344v;
    /* renamed from: w */
    private long f32345w;
    /* renamed from: x */
    private final Object f32346x = new Object();

    bm(cg cgVar) {
        super(cgVar);
    }

    /* renamed from: x */
    private final SharedPreferences m42582x() {
        mo6210d();
        m38104z();
        return this.f32340r;
    }

    /* renamed from: a */
    final Pair<String, Boolean> m42583a(String str) {
        mo6210d();
        long b = mo4751m().b();
        if (this.f32341s != null && b < this.f32343u) {
            return new Pair(this.f32341s, Boolean.valueOf(this.f32342t));
        }
        this.f32343u = b + mo6215t().m38036a(str, as.f16942j);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(mo4752n());
            if (advertisingIdInfo != null) {
                this.f32341s = advertisingIdInfo.getId();
                this.f32342t = advertisingIdInfo.isLimitAdTrackingEnabled();
            }
            if (this.f32341s == null) {
                this.f32341s = "";
            }
        } catch (Exception e) {
            mo4754r().m42578v().m21308a("Unable to get advertising id", e);
            this.f32341s = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair(this.f32341s, Boolean.valueOf(this.f32342t));
    }

    /* renamed from: a */
    final void m42584a(boolean z) {
        mo6210d();
        mo4754r().m42579w().m21308a("Setting useService", Boolean.valueOf(z));
        Editor edit = m42582x().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
    }

    /* renamed from: b */
    final String m42585b(String str) {
        mo6210d();
        str = (String) m42583a(str).first;
        if (fw.m42654i() == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, fw.m42654i().digest(str.getBytes()))});
    }

    /* renamed from: b */
    final void m42586b(boolean z) {
        mo6210d();
        mo4754r().m42579w().m21308a("Setting measurementEnabled", Boolean.valueOf(z));
        Editor edit = m42582x().edit();
        edit.putBoolean("measurement_enabled", z);
        edit.apply();
    }

    /* renamed from: c */
    final void m42587c(String str) {
        mo6210d();
        Editor edit = m42582x().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
    }

    /* renamed from: c */
    final boolean m42588c(boolean z) {
        mo6210d();
        return m42582x().getBoolean("measurement_enabled", z);
    }

    /* renamed from: d */
    final void m42589d(String str) {
        synchronized (this.f32346x) {
            this.f32344v = str;
            this.f32345w = mo4751m().b();
        }
    }

    /* renamed from: d */
    final void m42590d(boolean z) {
        mo6210d();
        mo4754r().m42579w().m21308a("Updating deferred analytics collection", Boolean.valueOf(z));
        Editor edit = m42582x().edit();
        edit.putBoolean("deferred_analytics_collection", z);
        edit.apply();
    }

    /* renamed from: e */
    protected final boolean mo6739e() {
        return true;
    }

    /* renamed from: f */
    protected final void mo6740f() {
        this.f32340r = mo4752n().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.f32339p = this.f32340r.getBoolean("has_been_opened", false);
        if (!this.f32339p) {
            Editor edit = this.f32340r.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        this.f32325b = new bq(this, "health_monitor", Math.max(0, ((Long) as.f16943k.m21260b()).longValue()));
    }

    /* renamed from: g */
    final String m42593g() {
        mo6210d();
        return m42582x().getString("gmp_app_id", null);
    }

    /* renamed from: h */
    final String m42594h() {
        synchronized (this.f32346x) {
            if (Math.abs(mo4751m().b() - this.f32345w) < 1000) {
                String str = this.f32344v;
                return str;
            }
            return null;
        }
    }

    /* renamed from: i */
    final Boolean m42595i() {
        mo6210d();
        return !m42582x().contains("use_service") ? null : Boolean.valueOf(m42582x().getBoolean("use_service", false));
    }

    /* renamed from: j */
    final void m42596j() {
        mo6210d();
        mo4754r().m42579w().m21307a("Clearing collection preferences.");
        boolean contains = m42582x().contains("measurement_enabled");
        boolean z = true;
        if (contains) {
            z = m42588c(true);
        }
        Editor edit = m42582x().edit();
        edit.clear();
        edit.apply();
        if (contains) {
            m42586b(z);
        }
    }

    /* renamed from: k */
    protected final String m42597k() {
        mo6210d();
        String string = m42582x().getString("previous_os_version", null);
        mo6211l().m38104z();
        String str = VERSION.RELEASE;
        if (!(TextUtils.isEmpty(str) || str.equals(string))) {
            Editor edit = m42582x().edit();
            edit.putString("previous_os_version", str);
            edit.apply();
        }
        return string;
    }

    /* renamed from: v */
    final boolean m42598v() {
        mo6210d();
        return m42582x().getBoolean("deferred_analytics_collection", false);
    }

    /* renamed from: w */
    final boolean m42599w() {
        return this.f32340r.contains("deferred_analytics_collection");
    }
}
