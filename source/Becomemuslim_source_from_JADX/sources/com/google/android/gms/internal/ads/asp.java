package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.amplitude.api.Constants;
import com.facebook.ads.AdError;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.common.util.ByteConstants;
import com.facebook.react.uimanager.ViewProps;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

@cm
public final class asp {
    /* renamed from: A */
    public static final asf<Long> f14910A = asf.m18872a(1, "gads:video:spinner:jank_threshold_ms", 50);
    /* renamed from: B */
    public static final asf<Boolean> f14911B = asf.m18873a(1, "gads:video:aggressive_media_codec_release", Boolean.valueOf(false));
    /* renamed from: C */
    public static final asf<Boolean> f14912C = asf.m18873a(1, "gads:memory_bundle:debug_info", Boolean.valueOf(false));
    /* renamed from: D */
    public static final asf<Boolean> f14913D = asf.m18873a(1, "gads:memory_bundle:runtime_info", Boolean.valueOf(true));
    /* renamed from: E */
    public static final asf<String> f14914E = asf.m18874a(1, "gads:video:codec_query_mime_types", "");
    /* renamed from: F */
    public static final asf<Integer> f14915F = asf.m18871a(1, "gads:video:codec_query_minimum_version", 16);
    /* renamed from: G */
    public static final asf<Boolean> f14916G = asf.m18873a(0, "gads:looper_for_gms_client:enabled", Boolean.valueOf(true));
    /* renamed from: H */
    public static final asf<Boolean> f14917H = asf.m18873a(0, "gads:sw_ad_request_service:enabled", Boolean.valueOf(true));
    /* renamed from: I */
    public static final asf<String> f14918I = asf.m18874a(1, "gad:mraid:url_banner", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_banner.js");
    /* renamed from: J */
    public static final asf<String> f14919J = asf.m18874a(1, "gad:mraid:url_expanded_banner", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_expanded_banner.js");
    /* renamed from: K */
    public static final asf<String> f14920K = asf.m18874a(1, "gad:mraid:url_interstitial", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_interstitial.js");
    /* renamed from: L */
    public static final asf<String> f14921L = asf.m18874a(1, "gad:mraid:version", "2.0");
    /* renamed from: M */
    public static final asf<Boolean> f14922M = asf.m18873a(1, "gads:mraid:unload", Boolean.valueOf(false));
    /* renamed from: N */
    public static final asf<Boolean> f14923N = asf.m18873a(0, "gads:enabled_sdk_csi", Boolean.valueOf(false));
    /* renamed from: O */
    public static final asf<String> f14924O = asf.m18874a(0, "gads:sdk_csi_server", "https://csi.gstatic.com/csi");
    /* renamed from: P */
    public static final asf<Boolean> f14925P = asf.m18873a(0, "gads:sdk_csi_write_to_file", Boolean.valueOf(false));
    /* renamed from: Q */
    public static final asf<Boolean> f14926Q = asf.m18873a(0, "gads:enable_content_fetching", Boolean.valueOf(true));
    /* renamed from: R */
    public static final asf<Integer> f14927R = asf.m18871a(0, "gads:content_length_weight", 1);
    /* renamed from: S */
    public static final asf<Integer> f14928S = asf.m18871a(0, "gads:content_age_weight", 1);
    /* renamed from: T */
    public static final asf<Integer> f14929T = asf.m18871a(0, "gads:min_content_len", 11);
    /* renamed from: U */
    public static final asf<Integer> f14930U = asf.m18871a(0, "gads:fingerprint_number", 10);
    /* renamed from: V */
    public static final asf<Integer> f14931V = asf.m18871a(0, "gads:sleep_sec", 10);
    /* renamed from: W */
    public static final asf<Boolean> f14932W = asf.m18873a(1, "gads:enable_content_url_hash", Boolean.valueOf(true));
    /* renamed from: X */
    public static final asf<Integer> f14933X = asf.m18871a(1, "gads:content_vertical_fingerprint_number", 100);
    /* renamed from: Y */
    public static final asf<Boolean> f14934Y = asf.m18873a(1, "gads:enable_content_vertical_hash", Boolean.valueOf(true));
    /* renamed from: Z */
    public static final asf<Integer> f14935Z = asf.m18871a(1, "gads:content_vertical_fingerprint_bits", 23);
    /* renamed from: a */
    public static final asf<String> f14936a = asf.m18874a(0, "gads:sdk_core_location", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/sdk-core-v40.html");
    public static final asf<Boolean> aA = asf.m18873a(0, "gads:corewebview:javascript_engine", Boolean.valueOf(false));
    public static final asf<Boolean> aB = asf.m18873a(1, "gad:webview:inject_scripts", Boolean.valueOf(false));
    public static final asf<Boolean> aC = asf.m18873a(0, "gads:webview:permission:disabled", Boolean.valueOf(false));
    public static final asf<Boolean> aD = asf.m18873a(1, "gads:rewarded:adapter_initialization_enabled", Boolean.valueOf(false));
    public static final asf<Long> aE = asf.m18872a(1, "gads:rewarded:adapter_timeout_ms", 20000);
    public static final asf<Boolean> aF = asf.m18873a(1, "gads:rewarded:ad_metadata_enabled", Boolean.valueOf(false));
    public static final asf<Boolean> aG = asf.m18873a(1, "gads:app_activity_tracker:enabled", Boolean.valueOf(true));
    public static final asf<Long> aH = asf.m18872a(1, "gads:app_activity_tracker:notify_background_listeners_delay_ms", 500);
    public static final asf<Long> aI = asf.m18872a(1, "gads:app_activity_tracker:app_session_timeout_ms", TimeUnit.MINUTES.toMillis(5));
    public static final asf<Boolean> aJ = asf.m18873a(1, "gads:adid_values_in_adrequest:enabled", Boolean.valueOf(false));
    public static final asf<Long> aK = asf.m18872a(1, "gads:adid_values_in_adrequest:timeout", 2000);
    public static final asf<Boolean> aL = asf.m18873a(1, "gads:disable_adid_values_in_ms", Boolean.valueOf(false));
    public static final asf<Boolean> aM = asf.m18873a(1, "gads:enable_ad_loader_manager", Boolean.valueOf(true));
    public static final asf<Boolean> aN = asf.m18873a(1, "gads:ad_manager_enforce_arp_invariant:enabled", Boolean.valueOf(true));
    public static final asf<Boolean> aO = asf.m18873a(1, "gads:ad_manager:admob_extra:new_bundle", Boolean.valueOf(true));
    public static final asf<Long> aP = asf.m18872a(1, "gads:ad_overlay:delay_page_close_timeout_ms", 5000);
    public static final asf<Boolean> aQ = asf.m18873a(1, "gads:interstitial_ad_immersive_mode", Boolean.valueOf(true));
    public static final asf<Boolean> aR = asf.m18873a(1, "gads:custom_close_blocking:enabled", Boolean.valueOf(false));
    public static final asf<Boolean> aS = asf.m18873a(1, "gads:disabling_closable_area:enabled", Boolean.valueOf(false));
    public static final asf<Boolean> aT = asf.m18873a(1, "gads:interstitial_ad_pool:enabled", Boolean.valueOf(false));
    public static final asf<Boolean> aU = asf.m18873a(1, "gads:interstitial_ad_pool:enabled_for_rewarded", Boolean.valueOf(false));
    public static final asf<String> aV = asf.m18874a(1, "gads:interstitial_ad_pool:schema", "customTargeting");
    public static final asf<String> aW = asf.m18874a(1, "gads:interstitial_ad_pool:request_exclusions", "com.google.ads.mediation.admob.AdMobAdapter/_ad");
    public static final asf<Integer> aX = asf.m18871a(1, "gads:interstitial_ad_pool:max_pools", 3);
    public static final asf<Integer> aY = asf.m18871a(1, "gads:interstitial_ad_pool:max_pool_depth", 2);
    public static final asf<Integer> aZ = asf.m18871a(1, "gads:interstitial_ad_pool:time_limit_sec", 1200);
    public static final asf<Integer> aa = asf.m18871a(1, "gads:content_vertical_fingerprint_ngram", 3);
    public static final asf<String> ab = asf.m18874a(1, "gads:content_fetch_view_tag_id", "googlebot");
    public static final asf<String> ac = asf.m18874a(1, "gads:content_fetch_exclude_view_tag", ViewProps.NONE);
    public static final asf<Boolean> ad = asf.m18873a(0, "gad:app_index_enabled", Boolean.valueOf(true));
    public static final asf<Boolean> ae = asf.m18873a(1, "gads:content_fetch_disable_get_title_from_webview", Boolean.valueOf(false));
    public static final asf<Boolean> af = asf.m18873a(0, "gads:app_index:without_content_info_present:enabled", Boolean.valueOf(true));
    public static final asf<Long> ag = asf.m18872a(0, "gads:app_index:timeout_ms", 1000);
    public static final asf<Boolean> ah = asf.m18873a(0, "gads:kitkat_interstitial_workaround:enabled", Boolean.valueOf(true));
    public static final asf<Boolean> ai = asf.m18873a(0, "gads:interstitial_follow_url", Boolean.valueOf(true));
    public static final asf<Boolean> aj = asf.m18873a(0, "gads:interstitial_follow_url:register_click", Boolean.valueOf(true));
    public static final asf<Boolean> ak = asf.m18873a(0, "gads:ad_key_enabled", Boolean.valueOf(false));
    public static final asf<Boolean> al = asf.m18873a(1, "gads:sai:enabled", Boolean.valueOf(true));
    public static final asf<Boolean> am = asf.m18873a(1, "gads:sai:banner_ad_enabled", Boolean.valueOf(true));
    public static final asf<Boolean> an = asf.m18873a(1, "gads:sai:native_ad_enabled", Boolean.valueOf(true));
    public static final asf<Boolean> ao = asf.m18873a(1, "gads:sai:interstitial_ad_enabled", Boolean.valueOf(true));
    public static final asf<Boolean> ap = asf.m18873a(1, "gads:sai:rewardedvideo_ad_enabled", Boolean.valueOf(true));
    public static final asf<String> aq = asf.m18874a(1, "gads:sai:click_ping_schema_v2", "^[^?]*(/aclk\\?|/pcs/click\\?).*");
    public static final asf<String> ar = asf.m18874a(1, "gads:sai:impression_ping_schema_v2", "^[^?]*/adview.*");
    public static final asf<Boolean> as = asf.m18873a(1, "gads:sai:click_gmsg_enabled", Boolean.valueOf(true));
    public static final asf<Boolean> at = asf.m18873a(1, "gads:sai:using_macro:enabled", Boolean.valueOf(false));
    public static final asf<String> au = asf.m18874a(1, "gads:sai:ad_event_id_macro_name", "[gw_fbsaeid]");
    public static final asf<Long> av = asf.m18872a(1, "gads:sai:timeout_ms", -1);
    public static final asf<Integer> aw = asf.m18871a(1, "gads:sai:scion_thread_pool_size", 5);
    public static final asf<Boolean> ax = asf.m18873a(1, "gads:x_seconds_rewarded:enable", Boolean.valueOf(false));
    public static final asf<Boolean> ay = asf.m18873a(1, "gads:webview:ignore_over_scroll", Boolean.valueOf(true));
    public static final asf<Boolean> az = asf.m18873a(0, "gads:corewebview:adwebview_factory:enable", Boolean.valueOf(false));
    /* renamed from: b */
    public static final asf<Boolean> f14937b = asf.m18873a(0, "gads:sdk_crash_report_enabled", Boolean.valueOf(false));
    public static final asf<Long> bA = asf.m18872a(0, "gads:ad_loader:timeout_ms", 60000);
    public static final asf<Long> bB = asf.m18872a(0, "gads:rendering:timeout_ms", 60000);
    public static final asf<Boolean> bC = asf.m18873a(0, "gads:adshield:enable_adshield_instrumentation", Boolean.valueOf(false));
    public static final asf<Long> bD = asf.m18872a(1, "gads:gestures:task_timeout", 2000);
    public static final asf<Boolean> bE = asf.m18873a(1, "gads:gestures:asig:enabled", Boolean.valueOf(false));
    public static final asf<Boolean> bF = asf.m18873a(1, "gads:gestures:ans:enabled", Boolean.valueOf(false));
    public static final asf<Boolean> bG = asf.m18873a(1, "gads:gestures:tos:enabled", Boolean.valueOf(false));
    public static final asf<Boolean> bH = asf.m18873a(1, "gads:signal:app_permissions:disabled", Boolean.valueOf(false));
    public static final asf<Boolean> bI = asf.m18873a(1, "gads:gestures:inthex:enabled", Boolean.valueOf(false));
    public static final asf<Boolean> bJ = asf.m18873a(1, "gads:gestures:hpk:enabled", Boolean.valueOf(true));
    public static final asf<String> bK = asf.m18874a(1, "gads:gestures:pk", "");
    public static final asf<Boolean> bL = asf.m18873a(1, "gads:gestures:bs:enabled", Boolean.valueOf(true));
    public static final asf<Boolean> bM = asf.m18873a(1, "gads:gestures:check_initialization_thread:enabled", Boolean.valueOf(false));
    public static final asf<Boolean> bN = asf.m18873a(1, "gads:gestures:get_query_in_non_ui_thread:enabled", Boolean.valueOf(true));
    public static final asf<Boolean> bO = asf.m18873a(0, "gass:enabled", Boolean.valueOf(true));
    public static final asf<Boolean> bP = asf.m18873a(0, "gass:enable_int_signal", Boolean.valueOf(true));
    public static final asf<Boolean> bQ = asf.m18873a(0, "gass:enable_ad_attestation_signal", Boolean.valueOf(true));
    public static final asf<Boolean> bR = asf.m18873a(0, "gads:support_screen_shot", Boolean.valueOf(true));
    public static final asf<Boolean> bS = asf.m18873a(0, "gads:use_get_drawing_cache_for_screenshot:enabled", Boolean.valueOf(true));
    public static final asf<String> bT = asf.m18874a(1, "gads:sdk_core_constants:caps", "");
    public static final asf<Long> bU = asf.m18872a(0, "gads:js_flags:update_interval", TimeUnit.HOURS.toMillis(12));
    public static final asf<Boolean> bV = asf.m18873a(0, "gads:js_flags:mf", Boolean.valueOf(false));
    public static final asf<Boolean> bW = asf.m18873a(0, "gads:custom_render:ping_on_ad_rendered", Boolean.valueOf(false));
    public static final asf<String> bX = asf.m18874a(1, "gads:native:engine_url_with_protocol", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/native_ads.html");
    public static final asf<String> bY = asf.m18874a(1, "gads:native:video_url_with_protocol", "https://imasdk.googleapis.com/admob/sdkloader/native_video.html");
    public static final asf<Boolean> bZ = asf.m18873a(1, "gads:enable_untrack_view_native", Boolean.valueOf(true));
    public static final asf<String> ba = asf.m18874a(1, "gads:interstitial_ad_pool:ad_unit_exclusions", "(?!)");
    public static final asf<Integer> bb = asf.m18871a(1, "gads:interstitial_ad_pool:top_off_latency_min_millis", 0);
    public static final asf<Integer> bc = asf.m18871a(1, "gads:interstitial_ad_pool:top_off_latency_range_millis", 0);
    public static final asf<Long> bd = asf.m18872a(1, "gads:interstitial_ad_pool:discard_thresholds", 0);
    public static final asf<Long> be = asf.m18872a(1, "gads:interstitial_ad_pool:miss_thresholds", 0);
    public static final asf<Float> bf = asf.m18870a(1, "gads:interstitial_ad_pool:discard_asymptote", 0.0f);
    public static final asf<Float> bg = asf.m18870a(1, "gads:interstitial_ad_pool:miss_asymptote", 0.0f);
    public static final asf<Boolean> bh = asf.m18873a(0, "gads:debug_logging_feature:enable", Boolean.valueOf(false));
    public static final asf<Boolean> bi = asf.m18873a(0, "gads:debug_logging_feature:intercept_web_view", Boolean.valueOf(false));
    public static final asf<String> bj = asf.m18874a(1, "gads:spherical_video:vertex_shader", "");
    public static final asf<String> bk = asf.m18874a(1, "gads:spherical_video:fragment_shader", "");
    public static final asf<Boolean> bl = asf.m18873a(0, "gads:log:verbose_enabled", Boolean.valueOf(false));
    public static final asf<Boolean> bm = asf.m18873a(1, "gads:include_local_global_rectangles", Boolean.valueOf(false));
    public static final asf<Long> bn = asf.m18872a(1, "gads:position_watcher:throttle_ms", 200);
    public static final asf<Boolean> bo = asf.m18873a(1, "gads:include_lock_screen_apps_for_visibility", Boolean.valueOf(true));
    public static final asf<Boolean> bp = asf.m18873a(0, "gads:device_info_caching:enabled", Boolean.valueOf(true));
    public static final asf<Long> bq = asf.m18872a(0, "gads:device_info_caching_expiry_ms:expiry", (long) Constants.MIN_TIME_BETWEEN_SESSIONS_MILLIS);
    public static final asf<Boolean> br = asf.m18873a(1, "gads:gen204_signals:enabled", Boolean.valueOf(false));
    public static final asf<Boolean> bs = asf.m18873a(0, "gads:webview:error_reporting_enabled", Boolean.valueOf(false));
    public static final asf<Boolean> bt = asf.m18873a(1, "gads:gmsg:disable_back_button:enabled", Boolean.valueOf(true));
    public static final asf<Boolean> bu = asf.m18873a(0, "gads:gmsg:video_meta:enabled", Boolean.valueOf(true));
    public static final asf<Long> bv = asf.m18872a(1, "gads:network:network_prediction_timeout_ms", 2000);
    public static final asf<Boolean> bw = asf.m18873a(0, "gads:mediation:dynamite_first:admobadapter", Boolean.valueOf(true));
    public static final asf<Boolean> bx = asf.m18873a(0, "gads:mediation:dynamite_first:adurladapter", Boolean.valueOf(true));
    public static final asf<Boolean> by = asf.m18873a(1, "gads:bypass_adrequest_service_for_inlined_mediation", Boolean.valueOf(true));
    public static final asf<Long> bz = asf.m18872a(0, "gads:resolve_future:default_timeout_ms", (long) Constants.EVENT_UPLOAD_PERIOD_MILLIS);
    /* renamed from: c */
    public static final asf<Boolean> f14938c = asf.m18873a(0, "gads:report_dynamite_crash_in_background_thread", Boolean.valueOf(false));
    public static final asf<Long> cA = asf.m18872a(1, "gads:parental_controls:timeout", 2000);
    public static final asf<Boolean> cB = asf.m18873a(0, "gads:safe_browsing:debug", Boolean.valueOf(false));
    public static final asf<Boolean> cC = asf.m18873a(0, "gads:webview_cookie:enabled", Boolean.valueOf(true));
    public static final asf<Boolean> cD = asf.m18873a(1, "gads:cache:bind_on_foreground", Boolean.valueOf(false));
    public static final asf<Boolean> cE = asf.m18873a(1, "gads:cache:bind_on_init", Boolean.valueOf(false));
    public static final asf<Boolean> cF = asf.m18873a(1, "gads:cache:bind_on_request", Boolean.valueOf(false));
    public static final asf<Long> cG = asf.m18872a(1, "gads:cache:bind_on_request_keep_alive", TimeUnit.SECONDS.toMillis(30));
    public static final asf<Boolean> cH = asf.m18873a(1, "gads:cache:use_cache_data_source", Boolean.valueOf(false));
    public static final asf<Boolean> cI = asf.m18873a(1, "gads:http_assets_cache:enabled", Boolean.valueOf(false));
    public static final asf<String> cJ = asf.m18874a(1, "gads:http_assets_cache:regex", "(?i)https:\\/\\/(tpc\\.googlesyndication\\.com\\/(.*)|lh\\d+\\.googleusercontent\\.com\\/(.*))");
    public static final asf<Integer> cK = asf.m18871a(1, "gads:http_assets_cache:time_out", 100);
    public static final asf<Boolean> cL = asf.m18873a(1, "gads:chrome_custom_tabs:enabled", Boolean.valueOf(true));
    public static final asf<Boolean> cM = asf.m18873a(1, "gads:chrome_custom_tabs_browser:enabled", Boolean.valueOf(false));
    public static final asf<Boolean> cN = asf.m18873a(1, "gads:chrome_custom_tabs:disabled", Boolean.valueOf(false));
    public static final asf<Boolean> cO = asf.m18873a(1, "gads:drx_in_app_preview:enabled", Boolean.valueOf(true));
    public static final asf<Boolean> cP = asf.m18873a(1, "gads:drx_debug_signals:enabled", Boolean.valueOf(true));
    public static final asf<Boolean> cQ = asf.m18873a(1, "gads:debug_hold_gesture:enabled", Boolean.valueOf(false));
    public static final asf<Long> cR = asf.m18872a(1, "gads:debug_hold_gesture:time_millis", 2000);
    public static final asf<String> cS = asf.m18874a(1, "gads:drx_debug:debug_device_linking_url", "https://www.google.com/dfp/linkDevice");
    public static final asf<String> cT = asf.m18874a(1, "gads:drx_debug:in_app_preview_status_url", "https://www.google.com/dfp/inAppPreview");
    public static final asf<String> cU = asf.m18874a(1, "gads:drx_debug:debug_signal_status_url", "https://www.google.com/dfp/debugSignals");
    public static final asf<String> cV = asf.m18874a(1, "gads:drx_debug:send_debug_data_url", "https://www.google.com/dfp/sendDebugData");
    public static final asf<Integer> cW = asf.m18871a(1, "gads:drx_debug:timeout_ms", 5000);
    public static final asf<Integer> cX = asf.m18871a(1, "gad:pixel_dp_comparision_multiplier", 1);
    public static final asf<Boolean> cY = asf.m18873a(1, "gad:interstitial_for_multi_window", Boolean.valueOf(false));
    public static final asf<Boolean> cZ = asf.m18873a(1, "gad:interstitial_ad_stay_active_in_multi_window", Boolean.valueOf(false));
    public static final asf<Boolean> ca = asf.m18873a(1, "gads:ignore_untrack_view_google_native", Boolean.valueOf(true));
    public static final asf<Boolean> cb = asf.m18873a(1, "gads:reset_listeners_preparead_native", Boolean.valueOf(true));
    public static final asf<Integer> cc = asf.m18871a(1, "gads:native_video_load_timeout", 10);
    public static final asf<Integer> cd = asf.m18871a(1, "gads:omid:native_webview_load_timeout", (int) AdError.SERVER_ERROR_CODE);
    public static final asf<String> ce = asf.m18874a(1, "gads:ad_choices_content_description", "Ad Choices Icon");
    public static final asf<Boolean> cf = asf.m18873a(1, "gads:clamp_native_video_player_dimensions", Boolean.valueOf(true));
    public static final asf<Boolean> cg = asf.m18873a(1, "gads:enable_store_active_view_state", Boolean.valueOf(false));
    public static final asf<Boolean> ch = asf.m18873a(1, "gads:enable_singleton_broadcast_receiver", Boolean.valueOf(false));
    public static final asf<Boolean> ci = asf.m18873a(1, "gads:native:overlay_new_fix:enabled", Boolean.valueOf(true));
    public static final asf<Boolean> cj = asf.m18873a(1, "gads:native:count_impression_for_assets", Boolean.valueOf(false));
    public static final asf<Boolean> ck = asf.m18873a(1, "gads:native:custom_one_point_five_click:enable", Boolean.valueOf(true));
    public static final asf<Boolean> cl = asf.m18873a(1, "gads:unified_native_ad:enable", Boolean.valueOf(true));
    public static final asf<Boolean> cm = asf.m18873a(1, "gads:fluid_ad:use_wrap_content_height", Boolean.valueOf(false));
    public static final asf<Boolean> cn = asf.m18873a(0, "gads:method_tracing:enabled", Boolean.valueOf(false));
    public static final asf<Long> co = asf.m18872a(0, "gads:method_tracing:duration_ms", (long) Constants.EVENT_UPLOAD_PERIOD_MILLIS);
    public static final asf<Integer> cp = asf.m18871a(0, "gads:method_tracing:count", 5);
    public static final asf<Integer> cq = asf.m18871a(0, "gads:method_tracing:filesize", 134217728);
    public static final asf<Long> cr = asf.m18872a(1, "gads:auto_location_timeout", 2000);
    public static final asf<Boolean> cs = asf.m18873a(1, "gads:fetch_app_settings_using_cld:enabled", Boolean.valueOf(false));
    public static final asf<Long> ct = asf.m18872a(1, "gads:fetch_app_settings_using_cld:refresh_interval_ms", 7200000);
    public static final asf<String> cu = asf.m18874a(0, "gads:afs:csa_webview_gmsg_ad_failed", "gmsg://noAdLoaded");
    public static final asf<String> cv = asf.m18874a(0, "gads:afs:csa_webview_gmsg_script_load_failed", "gmsg://scriptLoadFailed");
    public static final asf<String> cw = asf.m18874a(0, "gads:afs:csa_webview_gmsg_ad_loaded", "gmsg://adResized");
    public static final asf<String> cx = asf.m18874a(0, "gads:afs:csa_webview_static_file_path", "/afs/ads/i/webview.html");
    public static final asf<String> cy = asf.m18874a(0, "gads:afs:csa_webview_custom_domain_param_key", "csa_customDomain");
    public static final asf<Long> cz = asf.m18872a(0, "gads:afs:csa_webview_adshield_timeout_ms", 1000);
    /* renamed from: d */
    public static final asf<Boolean> f14939d = asf.m18873a(0, "gads:sdk_crash_report_full_stacktrace", Boolean.valueOf(false));
    private static final asf<String> dA = asf.m18869a(0, "gads:video_stream_cache:experiment_id");
    private static final asf<Boolean> dB = asf.m18873a(0, "gads:ad_id_app_context:enabled", Boolean.valueOf(false));
    private static final asf<Float> dC = asf.m18870a(0, "gads:ad_id_app_context:ping_ratio", 0.0f);
    private static final asf<String> dD = asf.m18869a(0, "gads:ad_id_app_context:experiment_id");
    private static final asf<String> dE = asf.m18869a(0, "gads:ad_id_use_shared_preference:experiment_id");
    private static final asf<Boolean> dF = asf.m18873a(0, "gads:ad_id_use_shared_preference:enabled", Boolean.valueOf(false));
    private static final asf<Float> dG = asf.m18870a(0, "gads:ad_id_use_shared_preference:ping_ratio", 0.0f);
    private static final asf<Boolean> dH = asf.m18873a(0, "gads:ad_id_use_persistent_service:enabled", Boolean.valueOf(false));
    private static final asf<Boolean> dI = asf.m18873a(0, "gads:ad_id:use_ipc:enabled", Boolean.valueOf(false));
    private static final asf<String> dJ = asf.m18875b(0, "gads:looper_for_gms_client:experiment_id");
    private static final asf<Boolean> dK = asf.m18873a(0, "gads:sw_dynamite:enabled", Boolean.valueOf(true));
    private static final asf<String> dL = asf.m18869a(0, "gads:app_index:experiment_id");
    private static final asf<String> dM = asf.m18869a(0, "gads:kitkat_interstitial_workaround:experiment_id");
    private static final asf<String> dN = asf.m18869a(0, "gads:interstitial_follow_url:experiment_id");
    private static final asf<Boolean> dO = asf.m18873a(0, "gads:analytics_enabled", Boolean.valueOf(true));
    private static final asf<Integer> dP = asf.m18871a(0, "gads:webview_cache_version", 0);
    private static final asf<String> dQ = asf.m18875b(0, "gads:pan:experiment_id");
    private static final asf<Boolean> dR = asf.m18873a(0, "gads:ad_serving:enabled", Boolean.valueOf(true));
    private static final asf<Boolean> dS = asf.m18873a(1, "gads:impression_optimization_enabled", Boolean.valueOf(false));
    private static final asf<String> dT = asf.m18874a(1, "gads:banner_ad_pool:schema", "customTargeting");
    private static final asf<Integer> dU = asf.m18871a(1, "gads:banner_ad_pool:max_queues", 3);
    private static final asf<Integer> dV = asf.m18871a(1, "gads:banner_ad_pool:max_pools", 3);
    private static final asf<Integer> dW = asf.m18871a(1, "gads:heap_wastage:bytes", 0);
    private static final asf<Boolean> dX = asf.m18873a(0, "gads:adid_reporting:enabled", Boolean.valueOf(false));
    private static final asf<Boolean> dY = asf.m18873a(0, "gads:ad_settings_page_reporting:enabled", Boolean.valueOf(false));
    private static final asf<Boolean> dZ = asf.m18873a(0, "gads:adid_info_gmscore_upgrade_reporting:enabled", Boolean.valueOf(false));
    public static final asf<Integer> da = asf.m18871a(1, "gad:interstitial:close_button_padding_dip", 0);
    public static final asf<Boolean> db = asf.m18873a(1, "gads:clearcut_logging:enabled", Boolean.valueOf(false));
    public static final asf<Boolean> dc = asf.m18873a(1, "gads:clearcut_logging:write_to_file", Boolean.valueOf(false));
    public static final asf<Boolean> dd = asf.m18873a(0, "gad:force_local_ad_request_service:enabled", Boolean.valueOf(false));
    public static final asf<Boolean> de = asf.m18873a(0, "gad:force_dynamite_loading_enabled", Boolean.valueOf(false));
    public static final asf<Integer> df = asf.m18871a(1, "gad:http_redirect_max_count:times", 8);
    public static final asf<Boolean> dg = asf.m18873a(1, "gads:omid:enabled", Boolean.valueOf(false));
    public static final asf<Boolean> dh = asf.m18873a(1, "gads:nonagon:banner:check_dp_size", Boolean.valueOf(false));
    public static final asf<Long> di = asf.m18872a(1, "gads:mobius_linking:sdk_side_cooldown_time_threshold:ms", 3600000);
    public static final asf<String> dj = asf.m18874a(0, "gads:public_beta:traffic_multiplier", "1.0");
    public static final asf<Boolean> dk = asf.m18873a(1, "gads:real_test_request:enabled", Boolean.valueOf(true));
    public static final asf<Boolean> dl = asf.m18873a(1, "gads:real_test_request:render_webview_label", Boolean.valueOf(true));
    public static final asf<Boolean> dm = asf.m18873a(1, "gads:real_test_request:render_native_label", Boolean.valueOf(true));
    public static final asf<Integer> dn = asf.m18871a(1, "gads:adoverlay:b68684796:targeting_sdk:lower_bound", 27);
    /* renamed from: do */
    public static final asf<Integer> f14940do = asf.m18871a(1, "gads:adoverlay:b68684796:targeting_sdk:upper_bound", 27);
    public static final asf<Integer> dp = asf.m18871a(1, "gads:adoverlay:b68684796:sdk_int:lower_bound", 26);
    public static final asf<Integer> dq = asf.m18871a(1, "gads:adoverlay:b68684796:sdk_int:upper_bound", 27);
    private static final asf<String> dr = asf.m18869a(0, "gads:sdk_core_experiment_id");
    private static final asf<String> ds = asf.m18874a(0, "gads:sdk_core_js_location", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/production/sdk-core-v40-impl.js");
    private static final asf<Boolean> dt = asf.m18873a(0, "gads:request_builder:singleton_webview", Boolean.valueOf(false));
    private static final asf<String> du = asf.m18869a(0, "gads:request_builder:singleton_webview_experiment_id");
    private static final asf<Boolean> dv = asf.m18873a(0, "gads:sdk_use_dynamic_module", Boolean.valueOf(true));
    private static final asf<String> dw = asf.m18869a(0, "gads:sdk_use_dynamic_module_experiment_id");
    private static final asf<String> dx = asf.m18869a(0, "gads:block_autoclicks_experiment_id");
    private static final asf<String> dy = asf.m18869a(0, "gads:spam_app_context:experiment_id");
    private static final asf<Integer> dz = asf.m18871a(1, "gads:http_url_connection_factory:timeout_millis", 10000);
    /* renamed from: e */
    public static final asf<String> f14941e = asf.m18874a(0, "gads:sdk_crash_report_class_prefix", "com.google.");
    private static final asf<Long> eA = asf.m18872a(1, "gads:cache:javascript_timeout_millis", 5000);
    private static final asf<Boolean> eB = asf.m18873a(1, "gads:cache:connection_per_read", Boolean.valueOf(false));
    private static final asf<Long> eC = asf.m18872a(1, "gads:cache:connection_timeout", 5000);
    private static final asf<Long> eD = asf.m18872a(1, "gads:cache:read_only_connection_timeout", 5000);
    private static final asf<Boolean> eE = asf.m18873a(0, "gads:nonagon:red_button", Boolean.valueOf(false));
    private static final asf<Boolean> eF = asf.m18873a(1, "gads:nonagon:banner:enabled", Boolean.valueOf(false));
    private static final asf<String> eG = asf.m18874a(1, "gads:nonagon:banner:ad_unit_exclusions", "(?!)");
    private static final asf<Boolean> eH = asf.m18873a(1, "gads:nonagon:interstitial:enabled", Boolean.valueOf(false));
    private static final asf<String> eI = asf.m18874a(1, "gads:nonagon:interstitial:ad_unit_exclusions", "(?!)");
    private static final asf<Boolean> eJ = asf.m18873a(1, "gads:nonagon:rewardedvideo:enabled", Boolean.valueOf(false));
    private static final asf<Boolean> eK = asf.m18873a(1, "gads:nonagon:mobile_ads_setting_manager:enabled", Boolean.valueOf(false));
    private static final asf<String> eL = asf.m18874a(1, "gads:nonagon:rewardedvideo:ad_unit_exclusions", "(?!)");
    private static final asf<Boolean> eM = asf.m18873a(1, "gads:nonagon:nativead:enabled", Boolean.valueOf(false));
    private static final asf<String> eN = asf.m18874a(1, "gads:nonagon:nativead:app_name", "(?!)");
    private static final asf<Boolean> eO = asf.m18873a(1, "gads:nonagon:service:enabled", Boolean.valueOf(false));
    private static final asf<Boolean> eP = asf.m18873a(1, "gads:signals:ad_id_info:enabled", Boolean.valueOf(false));
    private static final asf<Boolean> eQ = asf.m18873a(1, "gads:signals:app_index:enabled", Boolean.valueOf(false));
    private static final asf<Boolean> eR = asf.m18873a(1, "gads:signals:cache:enabled", Boolean.valueOf(false));
    private static final asf<Boolean> eS = asf.m18873a(1, "gads:signals:doritos:enabled", Boolean.valueOf(false));
    private static final asf<Boolean> eT = asf.m18873a(1, "gads:signals:location:enabled", Boolean.valueOf(false));
    private static final asf<Boolean> eU = asf.m18873a(1, "gads:signals:network_prediction:enabled", Boolean.valueOf(false));
    private static final asf<Boolean> eV = asf.m18873a(1, "gads:signals:parental_control:enabled", Boolean.valueOf(false));
    private static byte[] eW;
    private static final asf<Boolean> ea = asf.m18873a(0, "gads:request_pkg:enabled", Boolean.valueOf(true));
    private static final asf<String> eb = asf.m18869a(0, "gads:gmsg:video_meta:experiment_id");
    private static final asf<Long> ec = asf.m18872a(1, "gads:network:cache_prediction_duration_s", 300);
    private static final asf<Long> ed = asf.m18872a(1, "gads:rtb_signal_timeout_ms", 1000);
    private static final asf<Boolean> ee = asf.m18873a(0, "gads:adid_notification:first_party_check:enabled", Boolean.valueOf(true));
    private static final asf<Boolean> ef = asf.m18873a(0, "gads:edu_device_helper:enabled", Boolean.valueOf(true));
    private static final asf<String> eg = asf.m18869a(0, "gads:use_get_drawing_cache_for_screenshot:experiment_id");
    private static final asf<String> eh = asf.m18869a(1, "gads:sdk_core_constants:experiment_id");
    private static final asf<Boolean> ei = asf.m18873a(1, "gads:js_flags:disable_phenotype", Boolean.valueOf(false));
    private static final asf<String> ej = asf.m18874a(0, "gads:native:engine_js_url_with_protocol", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/production/native_ads.js");
    private static final asf<String> ek = asf.m18874a(1, "gads:native:video_url", "//imasdk.googleapis.com/admob/sdkloader/native_video.html");
    private static final asf<String> el = asf.m18869a(1, "gads:singleton_webview_native:experiment_id");
    private static final asf<Boolean> em = asf.m18873a(1, "gads:auto_location_for_coarse_permission", Boolean.valueOf(false));
    private static final asf<String> en = asf.m18875b(1, "gads:auto_location_for_coarse_permission:experiment_id");
    private static final asf<String> eo = asf.m18875b(1, "gads:auto_location_timeout:experiment_id");
    private static final asf<Long> ep = asf.m18872a(1, "gads:auto_location_interval", -1);
    private static final asf<String> eq = asf.m18875b(1, "gads:auto_location_interval:experiment_id");
    private static final asf<String> er = asf.m18869a(1, "gads:fetch_app_settings_using_cld:enabled:experiment_id");
    private static final asf<String> es = asf.m18869a(0, "gads:afs:csa:experiment_id");
    private static final asf<Boolean> et = asf.m18873a(0, "gads:afs:csa_ad_manager_enabled", Boolean.valueOf(true));
    private static final asf<Boolean> eu = asf.m18873a(1, "gads:parental_controls:send_from_client", Boolean.valueOf(true));
    private static final asf<Boolean> ev = asf.m18873a(1, "gads:parental_controls:cache_results", Boolean.valueOf(true));
    private static final asf<String> ew = asf.m18874a(0, "gads:safe_browsing:api_key", "AIzaSyDRKQ9d6kfsoZT2lUnZcZnBYvH69HExNPE");
    private static final asf<Long> ex = asf.m18872a(0, "gads:safe_browsing:safety_net:delay_ms", 2000);
    private static final asf<Integer> ey = asf.m18871a(1, "gads:cache:ad_request_timeout_millis", 250);
    private static final asf<Integer> ez = asf.m18871a(1, "gads:cache:max_concurrent_downloads", 10);
    /* renamed from: f */
    public static final asf<Float> f14942f = asf.m18870a(1, "gads:trapped_exception_sample_rate", 0.01f);
    /* renamed from: g */
    public static final asf<Boolean> f14943g = asf.m18873a(0, "gads:block_autoclicks", Boolean.valueOf(false));
    /* renamed from: h */
    public static final asf<String> f14944h = asf.m18874a(1, "gads:video_exo_player:version", AppEventsConstants.EVENT_PARAM_VALUE_YES);
    /* renamed from: i */
    public static final asf<Integer> f14945i = asf.m18871a(1, "gads:video_exo_player:connect_timeout", 8000);
    /* renamed from: j */
    public static final asf<Integer> f14946j = asf.m18871a(1, "gads:video_exo_player:read_timeout", 8000);
    /* renamed from: k */
    public static final asf<Integer> f14947k = asf.m18871a(1, "gads:video_exo_player:loading_check_interval", (int) ByteConstants.MB);
    /* renamed from: l */
    public static final asf<Integer> f14948l = asf.m18871a(1, "gads:video_exo_player:exo_player_precache_limit", Integer.MAX_VALUE);
    /* renamed from: m */
    public static final asf<Integer> f14949m = asf.m18871a(1, "gads:video_exo_player:byte_buffer_precache_limit", Integer.MAX_VALUE);
    /* renamed from: n */
    public static final asf<Integer> f14950n = asf.m18871a(1, "gads:video_stream_cache:limit_count", 5);
    /* renamed from: o */
    public static final asf<Integer> f14951o = asf.m18871a(1, "gads:video_stream_cache:limit_space", 8388608);
    /* renamed from: p */
    public static final asf<Integer> f14952p = asf.m18871a(1, "gads:video_stream_exo_cache:buffer_size", 8388608);
    /* renamed from: q */
    public static final asf<Long> f14953q = asf.m18872a(1, "gads:video_stream_cache:limit_time_sec", 300);
    /* renamed from: r */
    public static final asf<Long> f14954r = asf.m18872a(1, "gads:video_stream_cache:notify_interval_millis", 125);
    /* renamed from: s */
    public static final asf<Integer> f14955s = asf.m18871a(1, "gads:video_stream_cache:connect_timeout_millis", 10000);
    /* renamed from: t */
    public static final asf<Boolean> f14956t = asf.m18873a(0, "gads:video:metric_reporting_enabled", Boolean.valueOf(false));
    /* renamed from: u */
    public static final asf<String> f14957u = asf.m18874a(1, "gads:video:metric_frame_hash_times", "");
    /* renamed from: v */
    public static final asf<Long> f14958v = asf.m18872a(1, "gads:video:metric_frame_hash_time_leniency", 500);
    /* renamed from: w */
    public static final asf<Boolean> f14959w = asf.m18873a(1, "gads:video:force_watermark", Boolean.valueOf(false));
    /* renamed from: x */
    public static final asf<Long> f14960x = asf.m18872a(1, "gads:video:surface_update_min_spacing_ms", 1000);
    /* renamed from: y */
    public static final asf<Boolean> f14961y = asf.m18873a(1, "gads:video:spinner:enabled", Boolean.valueOf(false));
    /* renamed from: z */
    public static final asf<Integer> f14962z = asf.m18871a(1, "gads:video:spinner:scale", 4);

    /* renamed from: a */
    public static List<String> m18891a() {
        return aph.m18687e().m18882a();
    }

    /* renamed from: a */
    public static void m18892a(Context context) {
        lz.m19845a(context, new asq(context));
        int intValue = ((Integer) aph.m18688f().m18889a(dW)).intValue();
        if (intValue > 0 && eW == null) {
            eW = new byte[intValue];
        }
    }

    /* renamed from: a */
    public static void m18893a(Context context, int i, JSONObject jSONObject) {
        aph.m18686d();
        Editor edit = context.getSharedPreferences("google_ads_flags", 0).edit();
        aph.m18687e().m18883a(edit, 1, jSONObject);
        aph.m18686d();
        edit.commit();
    }

    /* renamed from: b */
    public static List<String> m18894b() {
        return aph.m18687e().m18885b();
    }
}
