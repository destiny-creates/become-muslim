package expo.modules.appauth;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import de.p287a.p288a.C5884c;
import expo.modules.appauth.AppAuthBrowserActivity.OAuthResultEvent;
import expo.p304a.C6006c;
import expo.p304a.C6007d;
import expo.p304a.C6009f;
import expo.p304a.p305a.C5995b;
import expo.p304a.p305a.C5996c;
import expo.p304a.p305a.C6001h;
import expo.p304a.p305a.p306a.C5993b;
import expo.p307b.p310c.C6023a;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import net.openid.appauth.C6576b;
import net.openid.appauth.C6576b.C6574a;
import net.openid.appauth.C6584d;
import net.openid.appauth.C6587e;
import net.openid.appauth.C6587e.C6586a;
import net.openid.appauth.C6593g;
import net.openid.appauth.C6593g.C6592b;
import net.openid.appauth.C6596h;
import net.openid.appauth.C6596h.C6595b;
import net.openid.appauth.C6608r;
import net.openid.appauth.C6608r.C6607a;
import net.openid.appauth.C6610s;
import net.openid.appauth.C7641k;
import net.openid.appauth.p369b.C6575a;
import net.openid.appauth.p369b.C7639b;

public class AppAuthModule extends C6006c implements C6001h {
    private static final String ERROR_TAG = "ERR_APP_AUTH";
    private static final String MANIFEST_URL_KEY = "experienceUrl";
    private static final String TAG = "ExpoAppAuth";
    private AuthTask authTask = new AuthTask();
    private Map<String, String> mAdditionalParametersMap;
    private Boolean mCanMakeInsecureRequests;
    private String mClientSecret;
    private C6007d mModuleRegistry;

    /* renamed from: expo.modules.appauth.AppAuthModule$4 */
    class C73964 implements C6592b {
        C73964() {
        }

        public void onTokenRequestCompleted(C6610s c6610s, C6584d c6584d) {
            if (c6610s != null) {
                AppAuthModule.this.authTask.resolve(AppAuthModule.this.tokenResponseToBundle(c6610s));
            } else {
                AppAuthModule.this.authTask.reject(c6584d);
            }
        }
    }

    public String getName() {
        return TAG;
    }

    public AppAuthModule(Context context) {
        super(context);
    }

    public void setModuleRegistry(C6007d c6007d) {
        this.mModuleRegistry = c6007d;
    }

    private Activity getCurrentActivity() {
        return this.mModuleRegistry != null ? ((C5995b) this.mModuleRegistry.m25133a(C5995b.class)).getCurrentActivity() : null;
    }

    private Map<String, String> castObjectsToStrings(Map<String, Object> map) {
        Map<String, String> hashMap = new HashMap();
        for (String str : map.keySet()) {
            hashMap.put(str, String.valueOf(map.get(str)));
        }
        return hashMap;
    }

    private void refreshAsync(String str, String str2, String str3, ArrayList arrayList, String str4, String str5, Map<String, String> map) {
        Map<String, String> map2 = map;
        C6575a createConnectionBuilder = createConnectionBuilder();
        final C6576b createAppAuthConfiguration = createAppAuthConfiguration(createConnectionBuilder);
        final Map map3 = this.mAdditionalParametersMap;
        if (map2 != null) {
            try {
                refreshWithConfiguration(createAuthorizationServiceConfiguration(map2), createAppAuthConfiguration, str5, str4, arrayList, str3, map3, str2);
                return;
            } catch (Exception e) {
                r10.authTask.reject(e);
                return;
            }
        }
        final String str6 = str5;
        final String str7 = str4;
        final ArrayList arrayList2 = arrayList;
        final String str8 = str3;
        final String str9 = str2;
        C6596h.m26897a(Uri.parse(str).buildUpon().appendPath(".well-known").appendPath("openid-configuration").build(), new C6595b() {
            public void onFetchConfigurationCompleted(C6596h c6596h, C6584d c6584d) {
                if (c6584d != null) {
                    AppAuthModule.this.authTask.reject(c6584d);
                    return;
                }
                AppAuthModule.this.refreshWithConfiguration(c6596h, createAppAuthConfiguration, str6, str7, arrayList2, str8, map3, str9);
            }
        }, createConnectionBuilder);
    }

    private void authAsync(Map<String, String> map, String str, String str2, String str3, ArrayList arrayList, String str4, Map<String, String> map2) {
        C6575a createConnectionBuilder = createConnectionBuilder();
        final C6576b createAppAuthConfiguration = createAppAuthConfiguration(createConnectionBuilder);
        this.mClientSecret = str2;
        if (map2 != null) {
            try {
                authorizeWithConfiguration(createAuthorizationServiceConfiguration(map2), createAppAuthConfiguration, str4, arrayList, str3, map);
                return;
            } catch (Map<String, String> map3) {
                this.authTask.reject(map3);
                return;
            }
        }
        final String str5 = str4;
        final ArrayList arrayList2 = arrayList;
        final String str6 = str3;
        final Map<String, String> map4 = map3;
        C6596h.m26897a(Uri.parse(str).buildUpon().appendPath(".well-known").appendPath("openid-configuration").build(), new C6595b() {
            public void onFetchConfigurationCompleted(C6596h c6596h, C6584d c6584d) {
                if (c6584d != null) {
                    AppAuthModule.this.authTask.reject(c6584d);
                    return;
                }
                AppAuthModule.this.authorizeWithConfiguration(c6596h, createAppAuthConfiguration, str5, arrayList2, str6, map4);
            }
        }, createConnectionBuilder);
    }

    @C5996c
    public void executeAsync(final Map<String, Object> map, final C6009f c6009f) {
        ((C5993b) this.mModuleRegistry.m25133a(C5993b.class)).runOnUiQueueThread(new Runnable() {
            public void run() {
                String str = (String) map.get("issuer");
                String str2 = (String) map.get("redirectUrl");
                String str3 = (String) map.get("clientId");
                String str4 = (String) map.get("clientSecret");
                String str5 = (String) map.get("refreshToken");
                boolean z = false;
                Boolean valueOf = Boolean.valueOf(map.containsKey("canMakeInsecureRequests") ? ((Boolean) map.get("canMakeInsecureRequests")).booleanValue() : false);
                if (map.containsKey("isRefresh")) {
                    z = ((Boolean) map.get("isRefresh")).booleanValue();
                }
                Boolean valueOf2 = Boolean.valueOf(z);
                ArrayList arrayList = (ArrayList) map.get("scopes");
                Map hashMap = new HashMap();
                if (map.containsKey("additionalParameters") && (map.get("additionalParameters") instanceof Map)) {
                    hashMap = AppAuthModule.this.castObjectsToStrings((Map) map.get("additionalParameters"));
                }
                Map map = null;
                if (map.containsKey("serviceConfiguration") && (map.get("serviceConfiguration") instanceof Map)) {
                    map = AppAuthModule.this.castObjectsToStrings((Map) map.get("serviceConfiguration"));
                }
                if (str4 != null) {
                    hashMap.put("client_secret", str4);
                }
                AppAuthModule.this.mAdditionalParametersMap = hashMap;
                AppAuthModule.this.mCanMakeInsecureRequests = valueOf;
                AppAuthModule.this.authTask.update(c6009f, "Get Auth");
                if (valueOf2.equals(Boolean.valueOf(true))) {
                    AppAuthModule.this.refreshAsync(str, str4, str2, arrayList, str3, str5, map);
                } else {
                    AppAuthModule.this.authAsync(hashMap, str, str4, str2, arrayList, str3, map);
                }
            }
        });
    }

    public Map<String, Object> getConstants() {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("OAuthRedirect", getContext().getApplicationContext().getPackageName());
        return hashMap;
    }

    private C6592b getTokenCallback() {
        return new C73964();
    }

    private void authorizeWithConfiguration(C6596h c6596h, C6576b c6576b, String str, ArrayList arrayList, String str2, Map<String, String> map) {
        C6586a c6586a = new C6586a(c6596h, str, "code", Uri.parse(str2));
        if (arrayList != null) {
            c6596h = tokenizeScopes(arrayList);
            if (c6596h != null) {
                c6586a.m26849f(c6596h);
            }
        }
        if (map != null) {
            if (map.containsKey("login_hint") != null) {
                c6586a.m26846c((String) map.get("login_hint"));
                map.remove("login_hint");
            }
            if (map.containsKey("display") != null) {
                c6586a.m26845b((String) map.get("display"));
                map.remove("display");
            }
            if (map.containsKey("prompt") != null) {
                c6586a.m26847d((String) map.get("prompt"));
                map.remove("prompt");
            }
            c6586a.m26841a((Map) map);
        }
        C5884c.m24753a().m24765a((Object) this);
        c6596h = getCurrentActivity();
        str = new Intent(c6596h, AppAuthBrowserActivity.class).addFlags(603979776);
        C6023a c6023a = (C6023a) this.mModuleRegistry.m25133a(C6023a.class);
        if ("standalone".equals(c6023a.getAppOwnership()) == null) {
            if (c6023a.getConstants().containsKey(MANIFEST_URL_KEY) == null) {
                this.authTask.reject(ERROR_TAG, "Missing experienceUrl in the experience Constants");
                return;
            } else {
                str.putExtra(AppAuthBrowserActivity.EXTRA_REDIRECT_EXPERIENCE_URL, (String) c6023a.getConstants().get(MANIFEST_URL_KEY));
            }
        }
        C6587e a = c6586a.m26844a();
        PendingIntent activity = PendingIntent.getActivity(c6596h, a.hashCode(), str, null);
        new C6593g(c6596h, c6576b).m26890a(a, activity, activity);
    }

    public void onEvent(OAuthResultEvent oAuthResultEvent) {
        C5884c.m24753a().m24768c(this);
        if (oAuthResultEvent.exception != null) {
            this.authTask.reject(oAuthResultEvent.exception);
            return;
        }
        performTokenRequest(oAuthResultEvent.response.m26880a(this.mAdditionalParametersMap), createAppAuthConfiguration(createConnectionBuilder()), this.mClientSecret);
    }

    private void refreshWithConfiguration(C6596h c6596h, C6576b c6576b, String str, String str2, ArrayList arrayList, String str3, Map<String, String> map, String str4) {
        arrayList = arrayList != null ? tokenizeScopes(arrayList) : null;
        c6596h = new C6607a(c6596h, str2).m26949e(str).m26939a(Uri.parse(str3));
        if (arrayList != null) {
            c6596h.m26947c(arrayList);
        }
        if (map.isEmpty() == null) {
            c6596h.m26942a((Map) map);
        }
        performTokenRequest(c6596h.m26945a(), c6576b, str4);
    }

    private void performTokenRequest(C6608r c6608r, C6576b c6576b, String str) {
        C6593g c6593g = new C6593g(getContext(), c6576b);
        if (str != null) {
            c6593g.m26893a(c6608r, new C7641k(str), getTokenCallback());
        } else {
            c6593g.m26892a(c6608r, getTokenCallback());
        }
    }

    private String tokenizeScopes(ArrayList arrayList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            if (i != 0) {
                stringBuilder.append(' ');
            }
            stringBuilder.append(arrayList.get(i));
        }
        return stringBuilder.toString();
    }

    private Bundle tokenResponseToBundle(C6610s c6610s) {
        Bundle bundle = new Bundle();
        bundle.putString("accessToken", c6610s.f21292c);
        if (c6610s.f21293d != null) {
            Date date = new Date(c6610s.f21293d.longValue());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            bundle.putString("accessTokenExpirationDate", simpleDateFormat.format(date));
        }
        Bundle bundle2 = new Bundle();
        if (!c6610s.f21297h.isEmpty()) {
            for (String str : c6610s.f21297h.keySet()) {
                bundle2.putString(str, (String) c6610s.f21297h.get(str));
            }
        }
        bundle.putBundle("additionalParameters", bundle2);
        bundle.putString("idToken", c6610s.f21294e);
        bundle.putString("refreshToken", c6610s.f21295f);
        bundle.putString("tokenType", c6610s.f21291b);
        return bundle;
    }

    private C6576b createAppAuthConfiguration(C6575a c6575a) {
        return new C6574a().m26795a(c6575a).m26796a();
    }

    private C6575a createConnectionBuilder() {
        return this.mCanMakeInsecureRequests.equals(Boolean.valueOf(true)) ? UnsafeConnectionBuilder.INSTANCE : C7639b.f26409a;
    }

    private C6596h createAuthorizationServiceConfiguration(Map<String, String> map) {
        if (!map.containsKey("authorizationEndpoint")) {
            throw new Exception("serviceConfiguration passed without an authorizationEndpoint");
        } else if (map.containsKey("tokenEndpoint")) {
            Uri parse = Uri.parse((String) map.get("authorizationEndpoint"));
            Uri parse2 = Uri.parse((String) map.get("tokenEndpoint"));
            Uri uri = null;
            if (map.containsKey("registrationEndpoint")) {
                uri = Uri.parse((String) map.get("registrationEndpoint"));
            }
            return new C6596h(parse, parse2, uri);
        } else {
            throw new Exception("serviceConfiguration passed without a tokenEndpoint");
        }
    }
}
