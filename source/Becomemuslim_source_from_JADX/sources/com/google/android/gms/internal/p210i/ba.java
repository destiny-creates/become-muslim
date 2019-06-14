package com.google.android.gms.internal.p210i;

import com.amplitude.api.Constants;
import com.facebook.ads.AdError;
import com.facebook.internal.Utility;

/* renamed from: com.google.android.gms.internal.i.ba */
public final class ba {
    /* renamed from: A */
    public static bb<Long> f16364A = bb.m20312a("analytics.service_client.idle_disconnect_millis", 10000, 10000);
    /* renamed from: B */
    public static bb<Long> f16365B = bb.m20312a("analytics.service_client.connect_timeout_millis", 5000, 5000);
    /* renamed from: C */
    public static bb<Long> f16366C = bb.m20312a("analytics.service_client.reconnect_throttle_millis", (long) Constants.SESSION_TIMEOUT_MILLIS, (long) Constants.SESSION_TIMEOUT_MILLIS);
    /* renamed from: D */
    public static bb<Long> f16367D = bb.m20312a("analytics.monitoring.sample_period_millis", 86400000, 86400000);
    /* renamed from: E */
    public static bb<Long> f16368E = bb.m20312a("analytics.initialization_warning_threshold", 5000, 5000);
    /* renamed from: F */
    public static bb<Boolean> f16369F = bb.m20314a("analytics.gcm_task_service", false, false);
    /* renamed from: G */
    private static bb<Boolean> f16370G = bb.m20314a("analytics.service_enabled", false, false);
    /* renamed from: H */
    private static bb<Long> f16371H = bb.m20312a("analytics.max_tokens", 60, 60);
    /* renamed from: I */
    private static bb<Float> f16372I = bb.m20310a("analytics.tokens_per_sec", 0.5f, 0.5f);
    /* renamed from: J */
    private static bb<Integer> f16373J = bb.m20311a("analytics.max_stored_hits_per_app", (int) AdError.SERVER_ERROR_CODE, (int) AdError.SERVER_ERROR_CODE);
    /* renamed from: K */
    private static bb<Long> f16374K = bb.m20312a("analytics.min_local_dispatch_millis", 120000, 120000);
    /* renamed from: L */
    private static bb<Long> f16375L = bb.m20312a("analytics.max_local_dispatch_millis", 7200000, 7200000);
    /* renamed from: M */
    private static bb<Integer> f16376M = bb.m20311a("analytics.max_hits_per_request.k", 20, 20);
    /* renamed from: N */
    private static bb<Long> f16377N = bb.m20312a("analytics.service_monitor_interval", 86400000, 86400000);
    /* renamed from: O */
    private static bb<String> f16378O;
    /* renamed from: P */
    private static bb<Integer> f16379P = bb.m20311a("analytics.first_party_experiment_variant", 0, 0);
    /* renamed from: Q */
    private static bb<Long> f16380Q = bb.m20312a("analytics.service_client.second_connect_delay_millis", 5000, 5000);
    /* renamed from: R */
    private static bb<Long> f16381R = bb.m20312a("analytics.service_client.unexpected_reconnect_millis", 60000, 60000);
    /* renamed from: a */
    public static bb<Boolean> f16382a = bb.m20314a("analytics.service_client_enabled", true, true);
    /* renamed from: b */
    public static bb<String> f16383b = bb.m20313a("analytics.log_tag", "GAv4", "GAv4-SVC");
    /* renamed from: c */
    public static bb<Integer> f16384c = bb.m20311a("analytics.max_stored_hits", (int) AdError.SERVER_ERROR_CODE, 20000);
    /* renamed from: d */
    public static bb<Integer> f16385d = bb.m20311a("analytics.max_stored_properties_per_app", 100, 100);
    /* renamed from: e */
    public static bb<Long> f16386e = bb.m20312a("analytics.local_dispatch_millis", (long) Constants.SESSION_TIMEOUT_MILLIS, 120000);
    /* renamed from: f */
    public static bb<Long> f16387f = bb.m20312a("analytics.initial_local_dispatch_millis", 5000, 5000);
    /* renamed from: g */
    public static bb<Long> f16388g = bb.m20312a("analytics.dispatch_alarm_millis", 7200000, 7200000);
    /* renamed from: h */
    public static bb<Long> f16389h = bb.m20312a("analytics.max_dispatch_alarm_millis", 32400000, 32400000);
    /* renamed from: i */
    public static bb<Integer> f16390i = bb.m20311a("analytics.max_hits_per_dispatch", 20, 20);
    /* renamed from: j */
    public static bb<Integer> f16391j = bb.m20311a("analytics.max_hits_per_batch", 20, 20);
    /* renamed from: k */
    public static bb<String> f16392k;
    /* renamed from: l */
    public static bb<String> f16393l;
    /* renamed from: m */
    public static bb<String> f16394m;
    /* renamed from: n */
    public static bb<String> f16395n;
    /* renamed from: o */
    public static bb<Integer> f16396o = bb.m20311a("analytics.max_get_length", 2036, 2036);
    /* renamed from: p */
    public static bb<String> f16397p = bb.m20313a("analytics.batching_strategy.k", ai.BATCH_BY_COUNT.name(), ai.BATCH_BY_COUNT.name());
    /* renamed from: q */
    public static bb<String> f16398q;
    /* renamed from: r */
    public static bb<Integer> f16399r = bb.m20311a("analytics.max_hit_length.k", (int) Utility.DEFAULT_STREAM_BUFFER_SIZE, (int) Utility.DEFAULT_STREAM_BUFFER_SIZE);
    /* renamed from: s */
    public static bb<Integer> f16400s = bb.m20311a("analytics.max_post_length.k", (int) Utility.DEFAULT_STREAM_BUFFER_SIZE, (int) Utility.DEFAULT_STREAM_BUFFER_SIZE);
    /* renamed from: t */
    public static bb<Integer> f16401t = bb.m20311a("analytics.max_batch_post_length", (int) Utility.DEFAULT_STREAM_BUFFER_SIZE, (int) Utility.DEFAULT_STREAM_BUFFER_SIZE);
    /* renamed from: u */
    public static bb<String> f16402u;
    /* renamed from: v */
    public static bb<Integer> f16403v = bb.m20311a("analytics.batch_retry_interval.seconds.k", 3600, 3600);
    /* renamed from: w */
    public static bb<Integer> f16404w = bb.m20311a("analytics.http_connection.connect_timeout_millis", 60000, 60000);
    /* renamed from: x */
    public static bb<Integer> f16405x = bb.m20311a("analytics.http_connection.read_timeout_millis", 61000, 61000);
    /* renamed from: y */
    public static bb<Long> f16406y = bb.m20312a("analytics.campaigns.time_limit", 86400000, 86400000);
    /* renamed from: z */
    public static bb<Boolean> f16407z = bb.m20314a("analytics.test.disable_receiver", false, false);

    static {
        String str = "http://www.google-analytics.com";
        f16392k = bb.m20313a("analytics.insecure_host", str, str);
        str = "https://ssl.google-analytics.com";
        f16393l = bb.m20313a("analytics.secure_host", str, str);
        str = "/collect";
        f16394m = bb.m20313a("analytics.simple_endpoint", str, str);
        str = "/batch";
        f16395n = bb.m20313a("analytics.batching_endpoint", str, str);
        str = ao.GZIP.name();
        f16398q = bb.m20313a("analytics.compression_strategy.k", str, str);
        String str2 = "404,502";
        f16402u = bb.m20313a("analytics.fallback_responses.k", str2, str2);
        String str3 = "";
        f16378O = bb.m20313a("analytics.first_party_experiment_id", str3, str3);
    }
}
