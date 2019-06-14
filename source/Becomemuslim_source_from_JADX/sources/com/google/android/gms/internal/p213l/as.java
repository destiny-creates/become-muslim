package com.google.android.gms.internal.p213l;

import android.net.Uri;
import com.amplitude.api.Constants;
import com.facebook.common.util.UriUtil;
import com.facebook.internal.NativeProtocol;
import com.facebook.stetho.server.http.HttpStatus;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.internal.l.as */
public final class as {
    /* renamed from: A */
    public static C5034a<Long> f16907A = C5034a.m21252a("measurement.upload.window_interval", 3600000, 3600000);
    /* renamed from: B */
    public static C5034a<Long> f16908B = C5034a.m21252a("measurement.upload.interval", 3600000, 3600000);
    /* renamed from: C */
    public static C5034a<Long> f16909C = C5034a.m21252a("measurement.upload.realtime_upload_interval", 10000, 10000);
    /* renamed from: D */
    public static C5034a<Long> f16910D = C5034a.m21252a("measurement.upload.debug_upload_interval", 1000, 1000);
    /* renamed from: E */
    public static C5034a<Long> f16911E = C5034a.m21252a("measurement.upload.minimum_delay", 500, 500);
    /* renamed from: F */
    public static C5034a<Long> f16912F = C5034a.m21252a("measurement.alarm_manager.minimum_interval", 60000, 60000);
    /* renamed from: G */
    public static C5034a<Long> f16913G = C5034a.m21252a("measurement.upload.stale_data_deletion_interval", 86400000, 86400000);
    /* renamed from: H */
    public static C5034a<Long> f16914H = C5034a.m21252a("measurement.upload.refresh_blacklisted_config_interval", 604800000, 604800000);
    /* renamed from: I */
    public static C5034a<Long> f16915I = C5034a.m21252a("measurement.upload.initial_upload_delay_time", 15000, 15000);
    /* renamed from: J */
    public static C5034a<Long> f16916J = C5034a.m21252a("measurement.upload.retry_time", (long) Constants.SESSION_TIMEOUT_MILLIS, (long) Constants.SESSION_TIMEOUT_MILLIS);
    /* renamed from: K */
    public static C5034a<Integer> f16917K = C5034a.m21251a("measurement.upload.retry_count", 6, 6);
    /* renamed from: L */
    public static C5034a<Long> f16918L = C5034a.m21252a("measurement.upload.max_queue_time", 2419200000L, 2419200000L);
    /* renamed from: M */
    public static C5034a<Integer> f16919M = C5034a.m21251a("measurement.lifetimevalue.max_currency_tracked", 4, 4);
    /* renamed from: N */
    public static C5034a<Integer> f16920N = C5034a.m21251a("measurement.audience.filter_result_max_count", (int) HttpStatus.HTTP_OK, (int) HttpStatus.HTTP_OK);
    /* renamed from: O */
    public static C5034a<Long> f16921O = C5034a.m21252a("measurement.service_client.idle_disconnect_millis", 5000, 5000);
    /* renamed from: P */
    public static C5034a<Boolean> f16922P = C5034a.m21254a("measurement.test.boolean_flag", false, false);
    /* renamed from: Q */
    public static C5034a<String> f16923Q;
    /* renamed from: R */
    public static C5034a<Long> f16924R = C5034a.m21252a("measurement.test.long_flag", -1, -1);
    /* renamed from: S */
    public static C5034a<Integer> f16925S = C5034a.m21251a("measurement.test.int_flag", -2, -2);
    /* renamed from: T */
    public static C5034a<Double> f16926T = C5034a.m21250a("measurement.test.double_flag", -3.0d, -3.0d);
    /* renamed from: U */
    public static C5034a<Boolean> f16927U = C5034a.m21254a("measurement.lifetimevalue.user_engagement_tracking_enabled", false, false);
    /* renamed from: V */
    public static C5034a<Boolean> f16928V = C5034a.m21254a("measurement.audience.complex_param_evaluation", false, false);
    /* renamed from: W */
    public static C5034a<Boolean> f16929W = C5034a.m21254a("measurement.validation.internal_limits_internal_event_params", false, false);
    /* renamed from: X */
    public static C5034a<Boolean> f16930X = C5034a.m21254a("measurement.quality.unsuccessful_update_retry_counter", false, false);
    /* renamed from: Y */
    public static C5034a<Boolean> f16931Y = C5034a.m21254a("measurement.iid.disable_on_collection_disabled", true, true);
    /* renamed from: Z */
    public static C5034a<Boolean> f16932Z = C5034a.m21254a("measurement.app_launch.call_only_when_enabled", true, true);
    /* renamed from: a */
    static C5052x f16933a;
    public static C5034a<Boolean> aa = C5034a.m21254a("measurement.run_on_worker_inline", true, false);
    public static C5034a<Boolean> ab = C5034a.m21254a("measurement.audience.dynamic_filters", false, false);
    public static C5034a<Boolean> ac = C5034a.m21254a("measurement.reset_analytics.persist_time", false, false);
    private static final hn ad;
    private static C5034a<Boolean> ae = C5034a.m21254a("measurement.log_third_party_store_events_enabled", false, false);
    private static C5034a<Boolean> af = C5034a.m21254a("measurement.log_installs_enabled", false, false);
    private static C5034a<Boolean> ag = C5034a.m21254a("measurement.log_upgrades_enabled", false, false);
    private static C5034a<Boolean> ah = C5034a.m21254a("measurement.validation.value_and_currency_params", false, false);
    /* renamed from: b */
    static List<C5034a<Integer>> f16934b = new ArrayList();
    /* renamed from: c */
    static List<C5034a<Long>> f16935c = new ArrayList();
    /* renamed from: d */
    static List<C5034a<Boolean>> f16936d = new ArrayList();
    /* renamed from: e */
    static List<C5034a<String>> f16937e = new ArrayList();
    /* renamed from: f */
    static List<C5034a<Double>> f16938f = new ArrayList();
    /* renamed from: g */
    public static C5034a<Boolean> f16939g = C5034a.m21254a("measurement.log_androidId_enabled", false, false);
    /* renamed from: h */
    public static C5034a<Boolean> f16940h = C5034a.m21254a("measurement.upload_dsid_enabled", false, false);
    /* renamed from: i */
    public static C5034a<String> f16941i = C5034a.m21253a("measurement.log_tag", "FA", "FA-SVC");
    /* renamed from: j */
    public static C5034a<Long> f16942j = C5034a.m21252a("measurement.ad_id_cache_time", 10000, 10000);
    /* renamed from: k */
    public static C5034a<Long> f16943k = C5034a.m21252a("measurement.monitoring.sample_period_millis", 86400000, 86400000);
    /* renamed from: l */
    public static C5034a<Long> f16944l = C5034a.m21252a("measurement.config.cache_time", 86400000, 3600000);
    /* renamed from: m */
    public static C5034a<String> f16945m;
    /* renamed from: n */
    public static C5034a<String> f16946n;
    /* renamed from: o */
    public static C5034a<Integer> f16947o = C5034a.m21251a("measurement.upload.max_bundles", 100, 100);
    /* renamed from: p */
    public static C5034a<Integer> f16948p = C5034a.m21251a("measurement.upload.max_batch_size", (int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, (int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
    /* renamed from: q */
    public static C5034a<Integer> f16949q = C5034a.m21251a("measurement.upload.max_bundle_size", (int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, (int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
    /* renamed from: r */
    public static C5034a<Integer> f16950r = C5034a.m21251a("measurement.upload.max_events_per_bundle", 1000, 1000);
    /* renamed from: s */
    public static C5034a<Integer> f16951s = C5034a.m21251a("measurement.upload.max_events_per_day", 100000, 100000);
    /* renamed from: t */
    public static C5034a<Integer> f16952t = C5034a.m21251a("measurement.upload.max_error_events_per_day", 1000, 1000);
    /* renamed from: u */
    public static C5034a<Integer> f16953u = C5034a.m21251a("measurement.upload.max_public_events_per_day", 50000, 50000);
    /* renamed from: v */
    public static C5034a<Integer> f16954v = C5034a.m21251a("measurement.upload.max_conversions_per_day", (int) HttpStatus.HTTP_INTERNAL_SERVER_ERROR, (int) HttpStatus.HTTP_INTERNAL_SERVER_ERROR);
    /* renamed from: w */
    public static C5034a<Integer> f16955w = C5034a.m21251a("measurement.upload.max_realtime_events_per_day", 10, 10);
    /* renamed from: x */
    public static C5034a<Integer> f16956x = C5034a.m21251a("measurement.store.max_stored_events_per_app", 100000, 100000);
    /* renamed from: y */
    public static C5034a<String> f16957y;
    /* renamed from: z */
    public static C5034a<Long> f16958z = C5034a.m21252a("measurement.upload.backoff_period", 43200000, 43200000);

    /* renamed from: com.google.android.gms.internal.l.as$a */
    public static final class C5034a<V> {
        /* renamed from: a */
        private hd<V> f16902a;
        /* renamed from: b */
        private final V f16903b;
        /* renamed from: c */
        private final V f16904c;
        /* renamed from: d */
        private volatile V f16905d;
        /* renamed from: e */
        private final String f16906e;

        private C5034a(String str, V v, V v2) {
            this.f16906e = str;
            this.f16904c = v;
            this.f16903b = v2;
        }

        /* renamed from: a */
        static C5034a<Double> m21250a(String str, double d, double d2) {
            C5034a<Double> c5034a = new C5034a(str, Double.valueOf(-3.0d), Double.valueOf(-3.0d));
            as.f16938f.add(c5034a);
            return c5034a;
        }

        /* renamed from: a */
        static C5034a<Integer> m21251a(String str, int i, int i2) {
            C5034a<Integer> c5034a = new C5034a(str, Integer.valueOf(i), Integer.valueOf(i2));
            as.f16934b.add(c5034a);
            return c5034a;
        }

        /* renamed from: a */
        static C5034a<Long> m21252a(String str, long j, long j2) {
            C5034a<Long> c5034a = new C5034a(str, Long.valueOf(j), Long.valueOf(j2));
            as.f16935c.add(c5034a);
            return c5034a;
        }

        /* renamed from: a */
        static C5034a<String> m21253a(String str, String str2, String str3) {
            C5034a<String> c5034a = new C5034a(str, str2, str3);
            as.f16937e.add(c5034a);
            return c5034a;
        }

        /* renamed from: a */
        static C5034a<Boolean> m21254a(String str, boolean z, boolean z2) {
            C5034a<Boolean> c5034a = new C5034a(str, Boolean.valueOf(z), Boolean.valueOf(z2));
            as.f16936d.add(c5034a);
            return c5034a;
        }

        /* renamed from: d */
        private static void m21256d() {
            synchronized (C5034a.class) {
                for (C5034a c5034a : as.f16936d) {
                    hn a = as.ad;
                    String str = c5034a.f16906e;
                    C5052x c5052x = as.f16933a;
                    c5034a.f16902a = a.m21434a(str, ((Boolean) c5034a.f16904c).booleanValue());
                }
                for (C5034a c5034a2 : as.f16937e) {
                    a = as.ad;
                    str = c5034a2.f16906e;
                    c5052x = as.f16933a;
                    c5034a2.f16902a = a.m21433a(str, (String) c5034a2.f16904c);
                }
                for (C5034a c5034a22 : as.f16935c) {
                    a = as.ad;
                    str = c5034a22.f16906e;
                    c5052x = as.f16933a;
                    c5034a22.f16902a = a.m21432a(str, ((Long) c5034a22.f16904c).longValue());
                }
                for (C5034a c5034a222 : as.f16934b) {
                    a = as.ad;
                    str = c5034a222.f16906e;
                    c5052x = as.f16933a;
                    c5034a222.f16902a = a.m21431a(str, ((Integer) c5034a222.f16904c).intValue());
                }
                for (C5034a c5034a2222 : as.f16938f) {
                    a = as.ad;
                    str = c5034a2222.f16906e;
                    c5052x = as.f16933a;
                    c5034a2222.f16902a = a.m21430a(str, ((Double) c5034a2222.f16904c).doubleValue());
                }
            }
        }

        /* renamed from: e */
        private static void m21257e() {
            synchronized (C5034a.class) {
                if (C5052x.m21503a()) {
                    throw new IllegalStateException("Tried to refresh flag cache on main thread or on package side.");
                }
                C5052x c5052x = as.f16933a;
                for (C5034a c5034a : as.f16936d) {
                    c5034a.f16905d = c5034a.f16902a.m21423a();
                }
                for (C5034a c5034a2 : as.f16937e) {
                    c5034a2.f16905d = c5034a2.f16902a.m21423a();
                }
                for (C5034a c5034a22 : as.f16935c) {
                    c5034a22.f16905d = c5034a22.f16902a.m21423a();
                }
                for (C5034a c5034a222 : as.f16934b) {
                    c5034a222.f16905d = c5034a222.f16902a.m21423a();
                }
                for (C5034a c5034a2222 : as.f16938f) {
                    c5034a2222.f16905d = c5034a2222.f16902a.m21423a();
                }
            }
        }

        /* renamed from: a */
        public final V m21258a(V v) {
            if (v != null) {
                return v;
            }
            if (as.f16933a == null) {
                return this.f16904c;
            }
            C5052x c5052x = as.f16933a;
            if (C5052x.m21503a()) {
                return this.f16905d == null ? this.f16904c : this.f16905d;
            } else {
                C5034a.m21257e();
                return this.f16902a.m21423a();
            }
        }

        /* renamed from: a */
        public final String m21259a() {
            return this.f16906e;
        }

        /* renamed from: b */
        public final V m21260b() {
            if (as.f16933a == null) {
                return this.f16904c;
            }
            C5052x c5052x = as.f16933a;
            if (C5052x.m21503a()) {
                return this.f16905d == null ? this.f16904c : this.f16905d;
            } else {
                C5034a.m21257e();
                return this.f16902a.m21423a();
            }
        }
    }

    static {
        String str = "content://com.google.android.gms.phenotype/";
        String valueOf = String.valueOf(Uri.encode("com.google.android.gms.measurement"));
        ad = new hn(Uri.parse(valueOf.length() != 0 ? str.concat(valueOf) : new String(str)));
        String str2 = UriUtil.HTTPS_SCHEME;
        f16945m = C5034a.m21253a("measurement.config.url_scheme", str2, str2);
        str2 = "app-measurement.com";
        f16946n = C5034a.m21253a("measurement.config.url_authority", str2, str2);
        str2 = "https://app-measurement.com/a";
        f16957y = C5034a.m21253a("measurement.upload.url", str2, str2);
        str = "---";
        f16923Q = C5034a.m21253a("measurement.test.string_flag", str, str);
    }

    /* renamed from: a */
    static void m21262a(C5052x c5052x) {
        f16933a = c5052x;
        C5034a.m21256d();
    }
}
